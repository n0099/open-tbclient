package android.support.v4.media;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.annotation.RestrictTo;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserServiceCompatApi21;
import android.support.v4.media.MediaBrowserServiceCompatApi23;
import android.support.v4.media.MediaBrowserServiceCompatApi24;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.BuildCompat;
import android.support.v4.os.ResultReceiver;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class MediaBrowserServiceCompat extends Service {
    @RestrictTo
    public static final String KEY_MEDIA_ITEM = "media_item";
    static final int RESULT_FLAG_ON_LOAD_ITEM_NOT_IMPLEMENTED = 2;
    static final int RESULT_FLAG_OPTION_NOT_HANDLED = 1;
    public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
    a mCurConnection;
    private b mImpl;
    MediaSessionCompat.Token mSession;
    static final String TAG = "MBServiceCompat";
    static final boolean DEBUG = Log.isLoggable(TAG, 3);
    final ArrayMap<IBinder, a> mConnections = new ArrayMap<>();
    final j mHandler = new j();

    /* loaded from: classes2.dex */
    interface b {
        Bundle getBrowserRootHints();

        void notifyChildrenChanged(String str, Bundle bundle);

        IBinder onBind(Intent intent);

        void onCreate();

        void setSessionToken(MediaSessionCompat.Token token);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface h {
        void a(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException;

        void a(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle) throws RemoteException;

        IBinder asBinder();

        /* renamed from: do  reason: not valid java name */
        void mo2do() throws RemoteException;
    }

    public abstract BrowserRoot onGetRoot(String str, int i2, Bundle bundle);

    public abstract void onLoadChildren(String str, Result<List<MediaBrowserCompat.MediaItem>> result);

    /* loaded from: classes2.dex */
    class f implements b {
        private Messenger mMessenger;

        f() {
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.b
        public void onCreate() {
            this.mMessenger = new Messenger(MediaBrowserServiceCompat.this.mHandler);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.b
        public IBinder onBind(Intent intent) {
            if (MediaBrowserServiceCompat.SERVICE_INTERFACE.equals(intent.getAction())) {
                return this.mMessenger.getBinder();
            }
            return null;
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.b
        public void setSessionToken(final MediaSessionCompat.Token token) {
            MediaBrowserServiceCompat.this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.f.1
                @Override // java.lang.Runnable
                public void run() {
                    Iterator<a> it = MediaBrowserServiceCompat.this.mConnections.values().iterator();
                    while (it.hasNext()) {
                        a next = it.next();
                        try {
                            next.xN.a(next.xO.getRootId(), token, next.xO.getExtras());
                        } catch (RemoteException e) {
                            Log.w(MediaBrowserServiceCompat.TAG, "Connection for " + next.xL + " is no longer valid.");
                            it.remove();
                        }
                    }
                }
            });
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.b
        public void notifyChildrenChanged(final String str, final Bundle bundle) {
            MediaBrowserServiceCompat.this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.f.2
                @Override // java.lang.Runnable
                public void run() {
                    for (IBinder iBinder : MediaBrowserServiceCompat.this.mConnections.keySet()) {
                        a aVar = MediaBrowserServiceCompat.this.mConnections.get(iBinder);
                        List<Pair<IBinder, Bundle>> list = aVar.xP.get(str);
                        if (list != null) {
                            for (Pair<IBinder, Bundle> pair : list) {
                                if (MediaBrowserCompatUtils.hasDuplicatedItems(bundle, pair.second)) {
                                    MediaBrowserServiceCompat.this.performLoadChildren(str, aVar, pair.second);
                                }
                            }
                        }
                    }
                }
            });
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.b
        public Bundle getBrowserRootHints() {
            if (MediaBrowserServiceCompat.this.mCurConnection == null) {
                throw new IllegalStateException("This should be called inside of onLoadChildren or onLoadItem methods");
            }
            if (MediaBrowserServiceCompat.this.mCurConnection.xM == null) {
                return null;
            }
            return new Bundle(MediaBrowserServiceCompat.this.mCurConnection.xM);
        }
    }

    /* loaded from: classes2.dex */
    class c implements b, MediaBrowserServiceCompatApi21.ServiceCompatProxy {
        Messenger mMessenger;
        Object xQ;

        c() {
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.b
        public void onCreate() {
            this.xQ = MediaBrowserServiceCompatApi21.a(MediaBrowserServiceCompat.this, this);
            MediaBrowserServiceCompatApi21.s(this.xQ);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.b
        public IBinder onBind(Intent intent) {
            return MediaBrowserServiceCompatApi21.a(this.xQ, intent);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.b
        public void setSessionToken(MediaSessionCompat.Token token) {
            MediaBrowserServiceCompatApi21.e(this.xQ, token.getToken());
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.b
        public void notifyChildrenChanged(final String str, final Bundle bundle) {
            if (this.mMessenger == null) {
                MediaBrowserServiceCompatApi21.e(this.xQ, str);
            } else {
                MediaBrowserServiceCompat.this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        for (IBinder iBinder : MediaBrowserServiceCompat.this.mConnections.keySet()) {
                            a aVar = MediaBrowserServiceCompat.this.mConnections.get(iBinder);
                            List<Pair<IBinder, Bundle>> list = aVar.xP.get(str);
                            if (list != null) {
                                for (Pair<IBinder, Bundle> pair : list) {
                                    if (MediaBrowserCompatUtils.hasDuplicatedItems(bundle, pair.second)) {
                                        MediaBrowserServiceCompat.this.performLoadChildren(str, aVar, pair.second);
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.b
        public Bundle getBrowserRootHints() {
            if (this.mMessenger == null) {
                return null;
            }
            if (MediaBrowserServiceCompat.this.mCurConnection == null) {
                throw new IllegalStateException("This should be called inside of onLoadChildren or onLoadItem methods");
            }
            if (MediaBrowserServiceCompat.this.mCurConnection.xM != null) {
                return new Bundle(MediaBrowserServiceCompat.this.mCurConnection.xM);
            }
            return null;
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
        public MediaBrowserServiceCompatApi21.a onGetRoot(String str, int i, Bundle bundle) {
            Bundle bundle2;
            if (bundle == null || bundle.getInt("extra_client_version", 0) == 0) {
                bundle2 = null;
            } else {
                bundle.remove("extra_client_version");
                this.mMessenger = new Messenger(MediaBrowserServiceCompat.this.mHandler);
                bundle2 = new Bundle();
                bundle2.putInt("extra_service_version", 1);
                BundleCompat.putBinder(bundle2, "extra_messenger", this.mMessenger.getBinder());
            }
            BrowserRoot onGetRoot = MediaBrowserServiceCompat.this.onGetRoot(str, i, bundle);
            if (onGetRoot == null) {
                return null;
            }
            if (bundle2 == null) {
                bundle2 = onGetRoot.getExtras();
            } else if (onGetRoot.getExtras() != null) {
                bundle2.putAll(onGetRoot.getExtras());
            }
            return new MediaBrowserServiceCompatApi21.a(onGetRoot.getRootId(), bundle2);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
        public void onLoadChildren(String str, final MediaBrowserServiceCompatApi21.c<List<Parcel>> cVar) {
            MediaBrowserServiceCompat.this.onLoadChildren(str, new Result<List<MediaBrowserCompat.MediaItem>>(str) { // from class: android.support.v4.media.MediaBrowserServiceCompat.c.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
                public void b(List<MediaBrowserCompat.MediaItem> list, int i) {
                    ArrayList arrayList = null;
                    if (list != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (MediaBrowserCompat.MediaItem mediaItem : list) {
                            Parcel obtain = Parcel.obtain();
                            mediaItem.writeToParcel(obtain, 0);
                            arrayList2.add(obtain);
                        }
                        arrayList = arrayList2;
                    }
                    cVar.sendResult(arrayList);
                }

                @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
                public void detach() {
                    cVar.detach();
                }
            });
        }
    }

    /* loaded from: classes2.dex */
    class d extends c implements MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        d() {
            super();
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.c, android.support.v4.media.MediaBrowserServiceCompat.b
        public void onCreate() {
            this.xQ = MediaBrowserServiceCompatApi23.a(MediaBrowserServiceCompat.this, this);
            MediaBrowserServiceCompatApi21.s(this.xQ);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompatApi23.ServiceCompatProxy
        public void onLoadItem(String str, final MediaBrowserServiceCompatApi21.c<Parcel> cVar) {
            MediaBrowserServiceCompat.this.onLoadItem(str, new Result<MediaBrowserCompat.MediaItem>(str) { // from class: android.support.v4.media.MediaBrowserServiceCompat.d.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
                /* renamed from: a */
                public void b(MediaBrowserCompat.MediaItem mediaItem, int i) {
                    if (mediaItem == null) {
                        cVar.sendResult(null);
                        return;
                    }
                    Parcel obtain = Parcel.obtain();
                    mediaItem.writeToParcel(obtain, 0);
                    cVar.sendResult(obtain);
                }

                @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
                public void detach() {
                    cVar.detach();
                }
            });
        }
    }

    /* loaded from: classes2.dex */
    class e extends d implements MediaBrowserServiceCompatApi24.ServiceCompatProxy {
        e() {
            super();
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.d, android.support.v4.media.MediaBrowserServiceCompat.c, android.support.v4.media.MediaBrowserServiceCompat.b
        public void onCreate() {
            this.xQ = MediaBrowserServiceCompatApi24.a(MediaBrowserServiceCompat.this, this);
            MediaBrowserServiceCompatApi21.s(this.xQ);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.c, android.support.v4.media.MediaBrowserServiceCompat.b
        public void notifyChildrenChanged(String str, Bundle bundle) {
            if (bundle == null) {
                MediaBrowserServiceCompatApi21.e(this.xQ, str);
            } else {
                MediaBrowserServiceCompatApi24.a(this.xQ, str, bundle);
            }
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompatApi24.ServiceCompatProxy
        public void onLoadChildren(String str, final MediaBrowserServiceCompatApi24.b bVar, Bundle bundle) {
            MediaBrowserServiceCompat.this.onLoadChildren(str, new Result<List<MediaBrowserCompat.MediaItem>>(str) { // from class: android.support.v4.media.MediaBrowserServiceCompat.e.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
                public void b(List<MediaBrowserCompat.MediaItem> list, int i) {
                    ArrayList arrayList = null;
                    if (list != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (MediaBrowserCompat.MediaItem mediaItem : list) {
                            Parcel obtain = Parcel.obtain();
                            mediaItem.writeToParcel(obtain, 0);
                            arrayList2.add(obtain);
                        }
                        arrayList = arrayList2;
                    }
                    bVar.c(arrayList, i);
                }

                @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
                public void detach() {
                    bVar.detach();
                }
            }, bundle);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.c, android.support.v4.media.MediaBrowserServiceCompat.b
        public Bundle getBrowserRootHints() {
            return MediaBrowserServiceCompatApi24.t(this.xQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class j extends Handler {
        private final g yi;

        j() {
            this.yi = new g();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    this.yi.a(data.getString("data_package_name"), data.getInt("data_calling_uid"), data.getBundle("data_root_hints"), new i(message.replyTo));
                    return;
                case 2:
                    this.yi.a(new i(message.replyTo));
                    return;
                case 3:
                    this.yi.a(data.getString("data_media_item_id"), BundleCompat.getBinder(data, "data_callback_token"), data.getBundle("data_options"), new i(message.replyTo));
                    return;
                case 4:
                    this.yi.a(data.getString("data_media_item_id"), BundleCompat.getBinder(data, "data_callback_token"), new i(message.replyTo));
                    return;
                case 5:
                    this.yi.a(data.getString("data_media_item_id"), (ResultReceiver) data.getParcelable("data_result_receiver"), new i(message.replyTo));
                    return;
                case 6:
                    this.yi.a(new i(message.replyTo), data.getBundle("data_root_hints"));
                    return;
                case 7:
                    this.yi.b(new i(message.replyTo));
                    return;
                default:
                    Log.w(MediaBrowserServiceCompat.TAG, "Unhandled message: " + message + "\n  Service version: 1\n  Client version: " + message.arg1);
                    return;
            }
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt("data_calling_uid", Binder.getCallingUid());
            return super.sendMessageAtTime(message, j);
        }

        public void c(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        String xL;
        Bundle xM;
        h xN;
        BrowserRoot xO;
        HashMap<String, List<Pair<IBinder, Bundle>>> xP = new HashMap<>();

        a() {
        }
    }

    /* loaded from: classes2.dex */
    public static class Result<T> {
        private int mFlags;
        private Object xY;
        private boolean xZ;
        private boolean ya;

        Result(Object obj) {
            this.xY = obj;
        }

        public void sendResult(T t) {
            if (this.ya) {
                throw new IllegalStateException("sendResult() called twice for: " + this.xY);
            }
            this.ya = true;
            b(t, this.mFlags);
        }

        public void detach() {
            if (this.xZ) {
                throw new IllegalStateException("detach() called when detach() had already been called for: " + this.xY);
            }
            if (this.ya) {
                throw new IllegalStateException("detach() called when sendResult() had already been called for: " + this.xY);
            }
            this.xZ = true;
        }

        boolean isDone() {
            return this.xZ || this.ya;
        }

        void setFlags(int i) {
            this.mFlags = i;
        }

        void b(T t, int i) {
        }
    }

    /* loaded from: classes2.dex */
    private class g {
        g() {
        }

        public void a(final String str, final int i, final Bundle bundle, final h hVar) {
            if (!MediaBrowserServiceCompat.this.isValidPackage(str, i)) {
                throw new IllegalArgumentException("Package/uid mismatch: uid=" + i + " package=" + str);
            }
            MediaBrowserServiceCompat.this.mHandler.c(new Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.g.1
                @Override // java.lang.Runnable
                public void run() {
                    IBinder asBinder = hVar.asBinder();
                    MediaBrowserServiceCompat.this.mConnections.remove(asBinder);
                    a aVar = new a();
                    aVar.xL = str;
                    aVar.xM = bundle;
                    aVar.xN = hVar;
                    aVar.xO = MediaBrowserServiceCompat.this.onGetRoot(str, i, bundle);
                    if (aVar.xO == null) {
                        Log.i(MediaBrowserServiceCompat.TAG, "No root for client " + str + " from service " + getClass().getName());
                        try {
                            hVar.mo2do();
                            return;
                        } catch (RemoteException e) {
                            Log.w(MediaBrowserServiceCompat.TAG, "Calling onConnectFailed() failed. Ignoring. pkg=" + str);
                            return;
                        }
                    }
                    try {
                        MediaBrowserServiceCompat.this.mConnections.put(asBinder, aVar);
                        if (MediaBrowserServiceCompat.this.mSession != null) {
                            hVar.a(aVar.xO.getRootId(), MediaBrowserServiceCompat.this.mSession, aVar.xO.getExtras());
                        }
                    } catch (RemoteException e2) {
                        Log.w(MediaBrowserServiceCompat.TAG, "Calling onConnect() failed. Dropping client. pkg=" + str);
                        MediaBrowserServiceCompat.this.mConnections.remove(asBinder);
                    }
                }
            });
        }

        public void a(final h hVar) {
            MediaBrowserServiceCompat.this.mHandler.c(new Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.g.2
                @Override // java.lang.Runnable
                public void run() {
                    if (MediaBrowserServiceCompat.this.mConnections.remove(hVar.asBinder()) != null) {
                    }
                }
            });
        }

        public void a(final String str, final IBinder iBinder, final Bundle bundle, final h hVar) {
            MediaBrowserServiceCompat.this.mHandler.c(new Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.g.3
                @Override // java.lang.Runnable
                public void run() {
                    a aVar = MediaBrowserServiceCompat.this.mConnections.get(hVar.asBinder());
                    if (aVar == null) {
                        Log.w(MediaBrowserServiceCompat.TAG, "addSubscription for callback that isn't registered id=" + str);
                    } else {
                        MediaBrowserServiceCompat.this.addSubscription(str, aVar, iBinder, bundle);
                    }
                }
            });
        }

        public void a(final String str, final IBinder iBinder, final h hVar) {
            MediaBrowserServiceCompat.this.mHandler.c(new Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.g.4
                @Override // java.lang.Runnable
                public void run() {
                    a aVar = MediaBrowserServiceCompat.this.mConnections.get(hVar.asBinder());
                    if (aVar == null) {
                        Log.w(MediaBrowserServiceCompat.TAG, "removeSubscription for callback that isn't registered id=" + str);
                    } else if (!MediaBrowserServiceCompat.this.removeSubscription(str, aVar, iBinder)) {
                        Log.w(MediaBrowserServiceCompat.TAG, "removeSubscription called for " + str + " which is not subscribed");
                    }
                }
            });
        }

        public void a(final String str, final ResultReceiver resultReceiver, final h hVar) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                MediaBrowserServiceCompat.this.mHandler.c(new Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.g.5
                    @Override // java.lang.Runnable
                    public void run() {
                        a aVar = MediaBrowserServiceCompat.this.mConnections.get(hVar.asBinder());
                        if (aVar == null) {
                            Log.w(MediaBrowserServiceCompat.TAG, "getMediaItem for callback that isn't registered id=" + str);
                        } else {
                            MediaBrowserServiceCompat.this.performLoadItem(str, aVar, resultReceiver);
                        }
                    }
                });
            }
        }

        public void a(final h hVar, final Bundle bundle) {
            MediaBrowserServiceCompat.this.mHandler.c(new Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.g.6
                @Override // java.lang.Runnable
                public void run() {
                    IBinder asBinder = hVar.asBinder();
                    MediaBrowserServiceCompat.this.mConnections.remove(asBinder);
                    a aVar = new a();
                    aVar.xN = hVar;
                    aVar.xM = bundle;
                    MediaBrowserServiceCompat.this.mConnections.put(asBinder, aVar);
                }
            });
        }

        public void b(final h hVar) {
            MediaBrowserServiceCompat.this.mHandler.c(new Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.g.7
                @Override // java.lang.Runnable
                public void run() {
                    MediaBrowserServiceCompat.this.mConnections.remove(hVar.asBinder());
                }
            });
        }
    }

    /* loaded from: classes2.dex */
    private class i implements h {
        final Messenger yh;

        i(Messenger messenger) {
            this.yh = messenger;
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.h
        public IBinder asBinder() {
            return this.yh.getBinder();
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.h
        public void a(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt("extra_service_version", 1);
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putParcelable("data_media_session_token", token);
            bundle2.putBundle("data_root_hints", bundle);
            b(1, bundle2);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.h
        /* renamed from: do */
        public void mo2do() throws RemoteException {
            b(2, null);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.h
        public void a(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putBundle("data_options", bundle);
            if (list != null) {
                bundle2.putParcelableArrayList("data_media_item_list", list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
            }
            b(3, bundle2);
        }

        private void b(int i, Bundle bundle) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            this.yh.send(obtain);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 24 || BuildCompat.isAtLeastN()) {
            this.mImpl = new e();
        } else if (Build.VERSION.SDK_INT >= 23) {
            this.mImpl = new d();
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.mImpl = new c();
        } else {
            this.mImpl = new f();
        }
        this.mImpl.onCreate();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mImpl.onBind(intent);
    }

    @Override // android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public void onLoadChildren(String str, Result<List<MediaBrowserCompat.MediaItem>> result, Bundle bundle) {
        result.setFlags(1);
        onLoadChildren(str, result);
    }

    public void onLoadItem(String str, Result<MediaBrowserCompat.MediaItem> result) {
        result.setFlags(2);
        result.sendResult(null);
    }

    public void setSessionToken(MediaSessionCompat.Token token) {
        if (token == null) {
            throw new IllegalArgumentException("Session token may not be null.");
        }
        if (this.mSession != null) {
            throw new IllegalStateException("The session token has already been set.");
        }
        this.mSession = token;
        this.mImpl.setSessionToken(token);
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.mSession;
    }

    public final Bundle getBrowserRootHints() {
        return this.mImpl.getBrowserRootHints();
    }

    public void notifyChildrenChanged(String str) {
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        this.mImpl.notifyChildrenChanged(str, null);
    }

    public void notifyChildrenChanged(String str, Bundle bundle) {
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        if (bundle == null) {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
        this.mImpl.notifyChildrenChanged(str, bundle);
    }

    boolean isValidPackage(String str, int i2) {
        if (str == null) {
            return false;
        }
        for (String str2 : getPackageManager().getPackagesForUid(i2)) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    void addSubscription(String str, a aVar, IBinder iBinder, Bundle bundle) {
        List<Pair<IBinder, Bundle>> list = aVar.xP.get(str);
        ArrayList arrayList = list == null ? new ArrayList() : list;
        for (Pair<IBinder, Bundle> pair : arrayList) {
            if (iBinder == pair.first && MediaBrowserCompatUtils.areSameOptions(bundle, pair.second)) {
                return;
            }
        }
        arrayList.add(new Pair<>(iBinder, bundle));
        aVar.xP.put(str, arrayList);
        performLoadChildren(str, aVar, bundle);
    }

    boolean removeSubscription(String str, a aVar, IBinder iBinder) {
        boolean z;
        if (iBinder == null) {
            return aVar.xP.remove(str) != null;
        }
        List<Pair<IBinder, Bundle>> list = aVar.xP.get(str);
        if (list != null) {
            Iterator<Pair<IBinder, Bundle>> it = list.iterator();
            z = false;
            while (it.hasNext()) {
                if (iBinder == it.next().first) {
                    it.remove();
                    z = true;
                }
            }
            if (list.size() == 0) {
                aVar.xP.remove(str);
            }
        } else {
            z = false;
        }
        return z;
    }

    void performLoadChildren(final String str, final a aVar, final Bundle bundle) {
        Result<List<MediaBrowserCompat.MediaItem>> result = new Result<List<MediaBrowserCompat.MediaItem>>(str) { // from class: android.support.v4.media.MediaBrowserServiceCompat.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
            public void b(List<MediaBrowserCompat.MediaItem> list, int i2) {
                if (MediaBrowserServiceCompat.this.mConnections.get(aVar.xN.asBinder()) != aVar) {
                    if (MediaBrowserServiceCompat.DEBUG) {
                        Log.d(MediaBrowserServiceCompat.TAG, "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + aVar.xL + " id=" + str);
                        return;
                    }
                    return;
                }
                if ((i2 & 1) != 0) {
                    list = MediaBrowserServiceCompat.this.applyOptions(list, bundle);
                }
                try {
                    aVar.xN.a(str, list, bundle);
                } catch (RemoteException e2) {
                    Log.w(MediaBrowserServiceCompat.TAG, "Calling onLoadChildren() failed for id=" + str + " package=" + aVar.xL);
                }
            }
        };
        this.mCurConnection = aVar;
        if (bundle == null) {
            onLoadChildren(str, result);
        } else {
            onLoadChildren(str, result, bundle);
        }
        this.mCurConnection = null;
        if (!result.isDone()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + aVar.xL + " id=" + str);
        }
    }

    List<MediaBrowserCompat.MediaItem> applyOptions(List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        int i2 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
        int i3 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        if (i2 != -1 || i3 != -1) {
            int i4 = i3 * i2;
            int i5 = i4 + i3;
            if (i2 < 0 || i3 < 1 || i4 >= list.size()) {
                return Collections.EMPTY_LIST;
            }
            if (i5 > list.size()) {
                i5 = list.size();
            }
            return list.subList(i4, i5);
        }
        return list;
    }

    void performLoadItem(String str, a aVar, final ResultReceiver resultReceiver) {
        Result<MediaBrowserCompat.MediaItem> result = new Result<MediaBrowserCompat.MediaItem>(str) { // from class: android.support.v4.media.MediaBrowserServiceCompat.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
            /* renamed from: a */
            public void b(MediaBrowserCompat.MediaItem mediaItem, int i2) {
                if ((i2 & 2) != 0) {
                    resultReceiver.send(-1, null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM, mediaItem);
                resultReceiver.send(0, bundle);
            }
        };
        this.mCurConnection = aVar;
        onLoadItem(str, result);
        this.mCurConnection = null;
        if (!result.isDone()) {
            throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
        }
    }

    /* loaded from: classes2.dex */
    public static final class BrowserRoot {
        public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
        public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
        public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";
        public static final String EXTRA_SUGGESTION_KEYWORDS = "android.service.media.extra.SUGGESTION_KEYWORDS";
        private final Bundle mExtras;
        private final String xq;

        public BrowserRoot(String str, Bundle bundle) {
            if (str == null) {
                throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
            }
            this.xq = str;
            this.mExtras = bundle;
        }

        public String getRootId() {
            return this.xq;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }
    }
}
