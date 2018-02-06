package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.annotation.RestrictTo;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.a;
import android.support.v4.media.b;
import android.support.v4.media.c;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.BuildCompat;
import android.support.v4.os.ResultReceiver;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public final class MediaBrowserCompat {
    static final boolean DEBUG = Log.isLoggable("MediaBrowserCompat", 3);
    public static final String EXTRA_PAGE = "android.media.browse.extra.PAGE";
    public static final String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";
    private final b wU;

    /* loaded from: classes2.dex */
    interface b {
        void connect();

        void disconnect();

        Bundle getExtras();

        void getItem(String str, ItemCallback itemCallback);

        String getRoot();

        ComponentName getServiceComponent();

        MediaSessionCompat.Token getSessionToken();

        boolean isConnected();

        void subscribe(String str, Bundle bundle, SubscriptionCallback subscriptionCallback);

        void unsubscribe(String str, SubscriptionCallback subscriptionCallback);
    }

    /* loaded from: classes2.dex */
    interface g {
        void a(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);

        void a(Messenger messenger, String str, List list, Bundle bundle);

        void b(Messenger messenger);
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 24 || BuildCompat.isAtLeastN()) {
            this.wU = new e(context, componentName, connectionCallback, bundle);
        } else if (Build.VERSION.SDK_INT >= 23) {
            this.wU = new d(context, componentName, connectionCallback, bundle);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.wU = new c(context, componentName, connectionCallback, bundle);
        } else {
            this.wU = new f(context, componentName, connectionCallback, bundle);
        }
    }

    public void connect() {
        this.wU.connect();
    }

    public void disconnect() {
        this.wU.disconnect();
    }

    public boolean isConnected() {
        return this.wU.isConnected();
    }

    public ComponentName getServiceComponent() {
        return this.wU.getServiceComponent();
    }

    public String getRoot() {
        return this.wU.getRoot();
    }

    public Bundle getExtras() {
        return this.wU.getExtras();
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.wU.getSessionToken();
    }

    public void subscribe(String str, SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (subscriptionCallback == null) {
            throw new IllegalArgumentException("callback is null");
        }
        this.wU.subscribe(str, null, subscriptionCallback);
    }

    public void subscribe(String str, Bundle bundle, SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (subscriptionCallback == null) {
            throw new IllegalArgumentException("callback is null");
        }
        if (bundle == null) {
            throw new IllegalArgumentException("options are null");
        }
        this.wU.subscribe(str, bundle, subscriptionCallback);
    }

    public void unsubscribe(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        this.wU.unsubscribe(str, null);
    }

    public void unsubscribe(String str, SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (subscriptionCallback == null) {
            throw new IllegalArgumentException("callback is null");
        }
        this.wU.unsubscribe(str, subscriptionCallback);
    }

    public void getItem(String str, ItemCallback itemCallback) {
        this.wU.getItem(str, itemCallback);
    }

    /* loaded from: classes2.dex */
    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() { // from class: android.support.v4.media.MediaBrowserCompat.MediaItem.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: d */
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ae */
            public MediaItem[] newArray(int i) {
                return new MediaItem[i];
            }
        };
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;
        private final int mFlags;
        private final MediaDescriptionCompat xx;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo
        /* loaded from: classes2.dex */
        public @interface Flags {
        }

        public static MediaItem fromMediaItem(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new MediaItem(MediaDescriptionCompat.fromMediaDescription(a.c.r(obj)), a.c.q(obj));
        }

        public static List<MediaItem> fromMediaItemList(List<?> list) {
            if (list == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(fromMediaItem(it.next()));
            }
            return arrayList;
        }

        public MediaItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("description cannot be null");
            }
            if (TextUtils.isEmpty(mediaDescriptionCompat.getMediaId())) {
                throw new IllegalArgumentException("description must have a non-empty media id");
            }
            this.mFlags = i;
            this.xx = mediaDescriptionCompat;
        }

        MediaItem(Parcel parcel) {
            this.mFlags = parcel.readInt();
            this.xx = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mFlags);
            this.xx.writeToParcel(parcel, i);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("MediaItem{");
            sb.append("mFlags=").append(this.mFlags);
            sb.append(", mDescription=").append(this.xx);
            sb.append('}');
            return sb.toString();
        }

        public int getFlags() {
            return this.mFlags;
        }

        public boolean isBrowsable() {
            return (this.mFlags & 1) != 0;
        }

        public boolean isPlayable() {
            return (this.mFlags & 2) != 0;
        }

        public MediaDescriptionCompat getDescription() {
            return this.xx;
        }

        public String getMediaId() {
            return this.xx.getMediaId();
        }
    }

    /* loaded from: classes2.dex */
    public static class ConnectionCallback {
        final Object wX;
        a wY;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public interface a {
            void onConnected();

            void onConnectionFailed();

            void onConnectionSuspended();
        }

        public ConnectionCallback() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.wX = android.support.v4.media.a.a(new b());
            } else {
                this.wX = null;
            }
        }

        public void onConnected() {
        }

        public void onConnectionSuspended() {
        }

        public void onConnectionFailed() {
        }

        void a(a aVar) {
            this.wY = aVar;
        }

        /* loaded from: classes2.dex */
        private class b implements a.InterfaceC0003a {
            b() {
            }

            @Override // android.support.v4.media.a.InterfaceC0003a
            public void onConnected() {
                if (ConnectionCallback.this.wY != null) {
                    ConnectionCallback.this.wY.onConnected();
                }
                ConnectionCallback.this.onConnected();
            }

            @Override // android.support.v4.media.a.InterfaceC0003a
            public void onConnectionSuspended() {
                if (ConnectionCallback.this.wY != null) {
                    ConnectionCallback.this.wY.onConnectionSuspended();
                }
                ConnectionCallback.this.onConnectionSuspended();
            }

            @Override // android.support.v4.media.a.InterfaceC0003a
            public void onConnectionFailed() {
                if (ConnectionCallback.this.wY != null) {
                    ConnectionCallback.this.wY.onConnectionFailed();
                }
                ConnectionCallback.this.onConnectionFailed();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class SubscriptionCallback {
        private final IBinder wb;
        private final Object xA;
        WeakReference<i> xB;

        public SubscriptionCallback() {
            if (Build.VERSION.SDK_INT >= 24 || BuildCompat.isAtLeastN()) {
                this.xA = android.support.v4.media.c.a(new b());
                this.wb = null;
            } else if (Build.VERSION.SDK_INT >= 21) {
                this.xA = android.support.v4.media.a.a(new a());
                this.wb = new Binder();
            } else {
                this.xA = null;
                this.wb = new Binder();
            }
        }

        public void onChildrenLoaded(String str, List<MediaItem> list) {
        }

        public void onChildrenLoaded(String str, List<MediaItem> list, Bundle bundle) {
        }

        public void onError(String str) {
        }

        public void onError(String str, Bundle bundle) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(i iVar) {
            this.xB = new WeakReference<>(iVar);
        }

        /* loaded from: classes2.dex */
        private class a implements a.d {
            a() {
            }

            @Override // android.support.v4.media.a.d
            public void onChildrenLoaded(String str, List<?> list) {
                i iVar = SubscriptionCallback.this.xB == null ? null : SubscriptionCallback.this.xB.get();
                if (iVar == null) {
                    SubscriptionCallback.this.onChildrenLoaded(str, MediaItem.fromMediaItemList(list));
                    return;
                }
                List<MediaItem> fromMediaItemList = MediaItem.fromMediaItemList(list);
                List<SubscriptionCallback> dn = iVar.dn();
                List<Bundle> dm = iVar.dm();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < dn.size()) {
                        Bundle bundle = dm.get(i2);
                        if (bundle == null) {
                            SubscriptionCallback.this.onChildrenLoaded(str, fromMediaItemList);
                        } else {
                            SubscriptionCallback.this.onChildrenLoaded(str, applyOptions(fromMediaItemList, bundle), bundle);
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }

            @Override // android.support.v4.media.a.d
            public void onError(String str) {
                SubscriptionCallback.this.onError(str);
            }

            List<MediaItem> applyOptions(List<MediaItem> list, Bundle bundle) {
                if (list == null) {
                    return null;
                }
                int i = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
                int i2 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
                if (i != -1 || i2 != -1) {
                    int i3 = i2 * i;
                    int i4 = i3 + i2;
                    if (i < 0 || i2 < 1 || i3 >= list.size()) {
                        return Collections.EMPTY_LIST;
                    }
                    if (i4 > list.size()) {
                        i4 = list.size();
                    }
                    return list.subList(i3, i4);
                }
                return list;
            }
        }

        /* loaded from: classes2.dex */
        private class b extends a implements c.a {
            b() {
                super();
            }

            @Override // android.support.v4.media.c.a
            public void onChildrenLoaded(String str, List<?> list, Bundle bundle) {
                SubscriptionCallback.this.onChildrenLoaded(str, MediaItem.fromMediaItemList(list), bundle);
            }

            @Override // android.support.v4.media.c.a
            public void onError(String str, Bundle bundle) {
                SubscriptionCallback.this.onError(str, bundle);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class ItemCallback {
        final Object xa;

        public ItemCallback() {
            if (Build.VERSION.SDK_INT >= 23) {
                this.xa = android.support.v4.media.b.a(new a());
            } else {
                this.xa = null;
            }
        }

        public void onItemLoaded(MediaItem mediaItem) {
        }

        public void onError(String str) {
        }

        /* loaded from: classes2.dex */
        private class a implements b.a {
            a() {
            }

            @Override // android.support.v4.media.b.a
            public void c(Parcel parcel) {
                parcel.setDataPosition(0);
                parcel.recycle();
                ItemCallback.this.onItemLoaded(MediaItem.CREATOR.createFromParcel(parcel));
            }

            @Override // android.support.v4.media.b.a
            public void onError(String str) {
                ItemCallback.this.onError(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class f implements b, g {
        final Context mContext;
        private Bundle mExtras;
        final Bundle xf;
        h xi;
        Messenger xj;
        final ComponentName xn;
        final ConnectionCallback xo;
        a xp;
        private String xq;
        private MediaSessionCompat.Token xr;
        final a xg = new a(this);
        private final ArrayMap<String, i> xh = new ArrayMap<>();
        int mState = 0;

        public f(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            if (context == null) {
                throw new IllegalArgumentException("context must not be null");
            }
            if (componentName == null) {
                throw new IllegalArgumentException("service component must not be null");
            }
            if (connectionCallback == null) {
                throw new IllegalArgumentException("connection callback must not be null");
            }
            this.mContext = context;
            this.xn = componentName;
            this.xo = connectionCallback;
            this.xf = bundle == null ? null : new Bundle(bundle);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void connect() {
            if (this.mState != 0) {
                throw new IllegalStateException("connect() called while not disconnected (state=" + ad(this.mState) + ")");
            }
            if (MediaBrowserCompat.DEBUG && this.xp != null) {
                throw new RuntimeException("mServiceConnection should be null. Instead it is " + this.xp);
            }
            if (this.xi != null) {
                throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + this.xi);
            }
            if (this.xj != null) {
                throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + this.xj);
            }
            this.mState = 1;
            Intent intent = new Intent(MediaBrowserServiceCompat.SERVICE_INTERFACE);
            intent.setComponent(this.xn);
            final a aVar = new a();
            this.xp = aVar;
            boolean z = false;
            try {
                z = this.mContext.bindService(intent, this.xp, 1);
            } catch (Exception e) {
                Log.e("MediaBrowserCompat", "Failed binding to service " + this.xn);
            }
            if (!z) {
                this.xg.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.f.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (aVar == f.this.xp) {
                            f.this.dl();
                            f.this.xo.onConnectionFailed();
                        }
                    }
                });
            }
            if (MediaBrowserCompat.DEBUG) {
                Log.d("MediaBrowserCompat", "connect...");
                dump();
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void disconnect() {
            if (this.xj != null) {
                try {
                    this.xi.c(this.xj);
                } catch (RemoteException e) {
                    Log.w("MediaBrowserCompat", "RemoteException during connect for " + this.xn);
                }
            }
            dl();
            if (MediaBrowserCompat.DEBUG) {
                Log.d("MediaBrowserCompat", "disconnect...");
                dump();
            }
        }

        void dl() {
            if (this.xp != null) {
                this.mContext.unbindService(this.xp);
            }
            this.mState = 0;
            this.xp = null;
            this.xi = null;
            this.xj = null;
            this.xg.a(null);
            this.xq = null;
            this.xr = null;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public boolean isConnected() {
            return this.mState == 2;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public ComponentName getServiceComponent() {
            if (!isConnected()) {
                throw new IllegalStateException("getServiceComponent() called while not connected (state=" + this.mState + ")");
            }
            return this.xn;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public String getRoot() {
            if (!isConnected()) {
                throw new IllegalStateException("getRoot() called while not connected(state=" + ad(this.mState) + ")");
            }
            return this.xq;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public Bundle getExtras() {
            if (!isConnected()) {
                throw new IllegalStateException("getExtras() called while not connected (state=" + ad(this.mState) + ")");
            }
            return this.mExtras;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public MediaSessionCompat.Token getSessionToken() {
            if (!isConnected()) {
                throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.mState + ")");
            }
            return this.xr;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void subscribe(String str, Bundle bundle, SubscriptionCallback subscriptionCallback) {
            i iVar = this.xh.get(str);
            if (iVar == null) {
                iVar = new i();
                this.xh.put(str, iVar);
            }
            iVar.a(bundle, subscriptionCallback);
            if (this.mState == 2) {
                try {
                    this.xi.a(str, subscriptionCallback.wb, bundle, this.xj);
                } catch (RemoteException e) {
                    Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException parentId=" + str);
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void unsubscribe(String str, SubscriptionCallback subscriptionCallback) {
            i iVar = this.xh.get(str);
            if (iVar != null) {
                try {
                    if (subscriptionCallback == null) {
                        if (this.mState == 2) {
                            this.xi.a(str, (IBinder) null, this.xj);
                        }
                    } else {
                        List<SubscriptionCallback> dn = iVar.dn();
                        List<Bundle> dm = iVar.dm();
                        for (int size = dn.size() - 1; size >= 0; size--) {
                            if (dn.get(size) == subscriptionCallback) {
                                if (this.mState == 2) {
                                    this.xi.a(str, subscriptionCallback.wb, this.xj);
                                }
                                dn.remove(size);
                                dm.remove(size);
                            }
                        }
                    }
                } catch (RemoteException e) {
                    Log.d("MediaBrowserCompat", "removeSubscription failed with RemoteException parentId=" + str);
                }
                if (iVar.isEmpty() || subscriptionCallback == null) {
                    this.xh.remove(str);
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void getItem(final String str, final ItemCallback itemCallback) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("mediaId is empty");
            }
            if (itemCallback == null) {
                throw new IllegalArgumentException("cb is null");
            }
            if (this.mState != 2) {
                Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
                this.xg.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.f.2
                    @Override // java.lang.Runnable
                    public void run() {
                        itemCallback.onError(str);
                    }
                });
                return;
            }
            try {
                this.xi.a(str, new ItemReceiver(str, itemCallback, this.xg), this.xj);
            } catch (RemoteException e) {
                Log.i("MediaBrowserCompat", "Remote error getting media item.");
                this.xg.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        itemCallback.onError(str);
                    }
                });
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.g
        public void a(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
            if (a(messenger, "onConnect")) {
                if (this.mState != 1) {
                    Log.w("MediaBrowserCompat", "onConnect from service while mState=" + ad(this.mState) + "... ignoring");
                    return;
                }
                this.xq = str;
                this.xr = token;
                this.mExtras = bundle;
                this.mState = 2;
                if (MediaBrowserCompat.DEBUG) {
                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                    dump();
                }
                this.xo.onConnected();
                try {
                    for (Map.Entry<String, i> entry : this.xh.entrySet()) {
                        String key = entry.getKey();
                        i value = entry.getValue();
                        List<SubscriptionCallback> dn = value.dn();
                        List<Bundle> dm = value.dm();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < dn.size()) {
                                this.xi.a(key, dn.get(i2).wb, dm.get(i2), this.xj);
                                i = i2 + 1;
                            }
                        }
                    }
                } catch (RemoteException e) {
                    Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException.");
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.g
        public void b(Messenger messenger) {
            Log.e("MediaBrowserCompat", "onConnectFailed for " + this.xn);
            if (a(messenger, "onConnectFailed")) {
                if (this.mState != 1) {
                    Log.w("MediaBrowserCompat", "onConnect from service while mState=" + ad(this.mState) + "... ignoring");
                    return;
                }
                dl();
                this.xo.onConnectionFailed();
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.g
        public void a(Messenger messenger, String str, List list, Bundle bundle) {
            if (a(messenger, "onLoadChildren")) {
                if (MediaBrowserCompat.DEBUG) {
                    Log.d("MediaBrowserCompat", "onLoadChildren for " + this.xn + " id=" + str);
                }
                i iVar = this.xh.get(str);
                if (iVar == null) {
                    if (MediaBrowserCompat.DEBUG) {
                        Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + str);
                        return;
                    }
                    return;
                }
                SubscriptionCallback g = iVar.g(bundle);
                if (g != null) {
                    if (bundle == null) {
                        g.onChildrenLoaded(str, list);
                    } else {
                        g.onChildrenLoaded(str, list, bundle);
                    }
                }
            }
        }

        private static String ad(int i) {
            switch (i) {
                case 0:
                    return "CONNECT_STATE_DISCONNECTED";
                case 1:
                    return "CONNECT_STATE_CONNECTING";
                case 2:
                    return "CONNECT_STATE_CONNECTED";
                case 3:
                    return "CONNECT_STATE_SUSPENDED";
                default:
                    return "UNKNOWN/" + i;
            }
        }

        private boolean a(Messenger messenger, String str) {
            if (this.xj != messenger) {
                if (this.mState != 0) {
                    Log.i("MediaBrowserCompat", str + " for " + this.xn + " with mCallbacksMessenger=" + this.xj + " this=" + this);
                }
                return false;
            }
            return true;
        }

        void dump() {
            Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
            Log.d("MediaBrowserCompat", "  mServiceComponent=" + this.xn);
            Log.d("MediaBrowserCompat", "  mCallback=" + this.xo);
            Log.d("MediaBrowserCompat", "  mRootHints=" + this.xf);
            Log.d("MediaBrowserCompat", "  mState=" + ad(this.mState));
            Log.d("MediaBrowserCompat", "  mServiceConnection=" + this.xp);
            Log.d("MediaBrowserCompat", "  mServiceBinderWrapper=" + this.xi);
            Log.d("MediaBrowserCompat", "  mCallbacksMessenger=" + this.xj);
            Log.d("MediaBrowserCompat", "  mRootId=" + this.xq);
            Log.d("MediaBrowserCompat", "  mMediaSessionToken=" + this.xr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public class a implements ServiceConnection {
            a() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(final ComponentName componentName, final IBinder iBinder) {
                c(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.f.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaBrowserCompat.DEBUG) {
                            Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceConnected name=" + componentName + " binder=" + iBinder);
                            f.this.dump();
                        }
                        if (a.this.y("onServiceConnected")) {
                            f.this.xi = new h(iBinder, f.this.xf);
                            f.this.xj = new Messenger(f.this.xg);
                            f.this.xg.a(f.this.xj);
                            f.this.mState = 1;
                            try {
                                if (MediaBrowserCompat.DEBUG) {
                                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                                    f.this.dump();
                                }
                                f.this.xi.a(f.this.mContext, f.this.xj);
                            } catch (RemoteException e) {
                                Log.w("MediaBrowserCompat", "RemoteException during connect for " + f.this.xn);
                                if (MediaBrowserCompat.DEBUG) {
                                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                                    f.this.dump();
                                }
                            }
                        }
                    }
                });
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(final ComponentName componentName) {
                c(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.f.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaBrowserCompat.DEBUG) {
                            Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceDisconnected name=" + componentName + " this=" + this + " mServiceConnection=" + f.this.xp);
                            f.this.dump();
                        }
                        if (a.this.y("onServiceDisconnected")) {
                            f.this.xi = null;
                            f.this.xj = null;
                            f.this.xg.a(null);
                            f.this.mState = 3;
                            f.this.xo.onConnectionSuspended();
                        }
                    }
                });
            }

            private void c(Runnable runnable) {
                if (Thread.currentThread() == f.this.xg.getLooper().getThread()) {
                    runnable.run();
                } else {
                    f.this.xg.post(runnable);
                }
            }

            boolean y(String str) {
                if (f.this.xp != this) {
                    if (f.this.mState != 0) {
                        Log.i("MediaBrowserCompat", str + " for " + f.this.xn + " with mServiceConnection=" + f.this.xp + " this=" + this);
                    }
                    return false;
                }
                return true;
            }
        }
    }

    /* loaded from: classes2.dex */
    static class c implements ConnectionCallback.a, b, g {
        protected final Object xe;
        protected final Bundle xf;
        protected final a xg = new a(this);
        private final ArrayMap<String, i> xh = new ArrayMap<>();
        protected h xi;
        protected Messenger xj;

        public c(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            if (Build.VERSION.SDK_INT < 25) {
                bundle = bundle == null ? new Bundle() : bundle;
                bundle.putInt("extra_client_version", 1);
                this.xf = new Bundle(bundle);
            } else {
                this.xf = bundle == null ? null : new Bundle(bundle);
            }
            connectionCallback.a(this);
            this.xe = android.support.v4.media.a.a(context, componentName, connectionCallback.wX, this.xf);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void connect() {
            android.support.v4.media.a.k(this.xe);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void disconnect() {
            if (this.xi != null && this.xj != null) {
                try {
                    this.xi.e(this.xj);
                } catch (RemoteException e) {
                    Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
                }
            }
            android.support.v4.media.a.l(this.xe);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public boolean isConnected() {
            return android.support.v4.media.a.m(this.xe);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public ComponentName getServiceComponent() {
            return android.support.v4.media.a.n(this.xe);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public String getRoot() {
            return android.support.v4.media.a.o(this.xe);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public Bundle getExtras() {
            return android.support.v4.media.a.getExtras(this.xe);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public MediaSessionCompat.Token getSessionToken() {
            return MediaSessionCompat.Token.fromToken(android.support.v4.media.a.p(this.xe));
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void subscribe(String str, Bundle bundle, SubscriptionCallback subscriptionCallback) {
            i iVar = this.xh.get(str);
            if (iVar == null) {
                iVar = new i();
                this.xh.put(str, iVar);
            }
            subscriptionCallback.a(iVar);
            iVar.a(bundle, subscriptionCallback);
            if (this.xi == null) {
                android.support.v4.media.a.a(this.xe, str, subscriptionCallback.xA);
                return;
            }
            try {
                this.xi.a(str, subscriptionCallback.wb, bundle, this.xj);
            } catch (RemoteException e) {
                Log.i("MediaBrowserCompat", "Remote error subscribing media item: " + str);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void unsubscribe(String str, SubscriptionCallback subscriptionCallback) {
            i iVar = this.xh.get(str);
            if (iVar != null) {
                if (this.xi == null) {
                    if (subscriptionCallback == null) {
                        android.support.v4.media.a.d(this.xe, str);
                    } else {
                        List<SubscriptionCallback> dn = iVar.dn();
                        List<Bundle> dm = iVar.dm();
                        for (int size = dn.size() - 1; size >= 0; size--) {
                            if (dn.get(size) == subscriptionCallback) {
                                dn.remove(size);
                                dm.remove(size);
                            }
                        }
                        if (dn.size() == 0) {
                            android.support.v4.media.a.d(this.xe, str);
                        }
                    }
                } else {
                    try {
                        if (subscriptionCallback == null) {
                            this.xi.a(str, (IBinder) null, this.xj);
                        } else {
                            List<SubscriptionCallback> dn2 = iVar.dn();
                            List<Bundle> dm2 = iVar.dm();
                            for (int size2 = dn2.size() - 1; size2 >= 0; size2--) {
                                if (dn2.get(size2) == subscriptionCallback) {
                                    this.xi.a(str, subscriptionCallback.wb, this.xj);
                                    dn2.remove(size2);
                                    dm2.remove(size2);
                                }
                            }
                        }
                    } catch (RemoteException e) {
                        Log.d("MediaBrowserCompat", "removeSubscription failed with RemoteException parentId=" + str);
                    }
                }
                if (iVar.isEmpty() || subscriptionCallback == null) {
                    this.xh.remove(str);
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void getItem(final String str, final ItemCallback itemCallback) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("mediaId is empty");
            }
            if (itemCallback == null) {
                throw new IllegalArgumentException("cb is null");
            }
            if (!android.support.v4.media.a.m(this.xe)) {
                Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
                this.xg.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        itemCallback.onError(str);
                    }
                });
            } else if (this.xi == null) {
                this.xg.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        itemCallback.onError(str);
                    }
                });
            } else {
                try {
                    this.xi.a(str, new ItemReceiver(str, itemCallback, this.xg), this.xj);
                } catch (RemoteException e) {
                    Log.i("MediaBrowserCompat", "Remote error getting media item: " + str);
                    this.xg.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.c.3
                        @Override // java.lang.Runnable
                        public void run() {
                            itemCallback.onError(str);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.a
        public void onConnected() {
            IBinder binder;
            Bundle extras = android.support.v4.media.a.getExtras(this.xe);
            if (extras != null && (binder = BundleCompat.getBinder(extras, "extra_messenger")) != null) {
                this.xi = new h(binder, this.xf);
                this.xj = new Messenger(this.xg);
                this.xg.a(this.xj);
                try {
                    this.xi.d(this.xj);
                } catch (RemoteException e) {
                    Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.a
        public void onConnectionSuspended() {
            this.xi = null;
            this.xj = null;
            this.xg.a(null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.a
        public void onConnectionFailed() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.g
        public void a(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.g
        public void b(Messenger messenger) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.g
        public void a(Messenger messenger, String str, List list, Bundle bundle) {
            if (this.xj == messenger) {
                i iVar = this.xh.get(str);
                if (iVar == null) {
                    if (MediaBrowserCompat.DEBUG) {
                        Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + str);
                        return;
                    }
                    return;
                }
                SubscriptionCallback g = iVar.g(bundle);
                if (g != null) {
                    if (bundle == null) {
                        g.onChildrenLoaded(str, list);
                    } else {
                        g.onChildrenLoaded(str, list, bundle);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    static class d extends c {
        public d(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c, android.support.v4.media.MediaBrowserCompat.b
        public void getItem(String str, ItemCallback itemCallback) {
            if (this.xi == null) {
                android.support.v4.media.b.b(this.xe, str, itemCallback.xa);
            } else {
                super.getItem(str, itemCallback);
            }
        }
    }

    /* loaded from: classes2.dex */
    static class e extends d {
        public e(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c, android.support.v4.media.MediaBrowserCompat.b
        public void subscribe(String str, Bundle bundle, SubscriptionCallback subscriptionCallback) {
            if (bundle == null) {
                android.support.v4.media.a.a(this.xe, str, subscriptionCallback.xA);
            } else {
                android.support.v4.media.c.a(this.xe, str, bundle, subscriptionCallback.xA);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c, android.support.v4.media.MediaBrowserCompat.b
        public void unsubscribe(String str, SubscriptionCallback subscriptionCallback) {
            if (subscriptionCallback == null) {
                android.support.v4.media.a.d(this.xe, str);
            } else {
                android.support.v4.media.c.c(this.xe, str, subscriptionCallback.xA);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class i {
        private final List<SubscriptionCallback> xy = new ArrayList();
        private final List<Bundle> xz = new ArrayList();

        public boolean isEmpty() {
            return this.xy.isEmpty();
        }

        public List<Bundle> dm() {
            return this.xz;
        }

        public List<SubscriptionCallback> dn() {
            return this.xy;
        }

        public SubscriptionCallback g(Bundle bundle) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.xz.size()) {
                    if (!MediaBrowserCompatUtils.areSameOptions(this.xz.get(i2), bundle)) {
                        i = i2 + 1;
                    } else {
                        return this.xy.get(i2);
                    }
                } else {
                    return null;
                }
            }
        }

        public void a(Bundle bundle, SubscriptionCallback subscriptionCallback) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.xz.size()) {
                    if (!MediaBrowserCompatUtils.areSameOptions(this.xz.get(i2), bundle)) {
                        i = i2 + 1;
                    } else {
                        this.xy.set(i2, subscriptionCallback);
                        return;
                    }
                } else {
                    this.xy.add(subscriptionCallback);
                    this.xz.add(bundle);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends Handler {
        private final WeakReference<g> wV;
        private WeakReference<Messenger> wW;

        a(g gVar) {
            this.wV = new WeakReference<>(gVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.wW != null && this.wW.get() != null && this.wV.get() != null) {
                Bundle data = message.getData();
                data.setClassLoader(MediaSessionCompat.class.getClassLoader());
                switch (message.what) {
                    case 1:
                        this.wV.get().a(this.wW.get(), data.getString("data_media_item_id"), (MediaSessionCompat.Token) data.getParcelable("data_media_session_token"), data.getBundle("data_root_hints"));
                        return;
                    case 2:
                        this.wV.get().b(this.wW.get());
                        return;
                    case 3:
                        this.wV.get().a(this.wW.get(), data.getString("data_media_item_id"), data.getParcelableArrayList("data_media_item_list"), data.getBundle("data_options"));
                        return;
                    default:
                        Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: 1\n  Service version: " + message.arg1);
                        return;
                }
            }
        }

        void a(Messenger messenger) {
            this.wW = new WeakReference<>(messenger);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class h {
        private Messenger mMessenger;
        private Bundle xf;

        public h(IBinder iBinder, Bundle bundle) {
            this.mMessenger = new Messenger(iBinder);
            this.xf = bundle;
        }

        void a(Context context, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString("data_package_name", context.getPackageName());
            bundle.putBundle("data_root_hints", this.xf);
            a(1, bundle, messenger);
        }

        void c(Messenger messenger) throws RemoteException {
            a(2, (Bundle) null, messenger);
        }

        void a(String str, IBinder iBinder, Bundle bundle, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            BundleCompat.putBinder(bundle2, "data_callback_token", iBinder);
            bundle2.putBundle("data_options", bundle);
            a(3, bundle2, messenger);
        }

        void a(String str, IBinder iBinder, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString("data_media_item_id", str);
            BundleCompat.putBinder(bundle, "data_callback_token", iBinder);
            a(4, bundle, messenger);
        }

        void a(String str, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString("data_media_item_id", str);
            bundle.putParcelable("data_result_receiver", resultReceiver);
            a(5, bundle, messenger);
        }

        void d(Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putBundle("data_root_hints", this.xf);
            a(6, bundle, messenger);
        }

        void e(Messenger messenger) throws RemoteException {
            a(7, (Bundle) null, messenger);
        }

        private void a(int i, Bundle bundle, Messenger messenger) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            obtain.replyTo = messenger;
            this.mMessenger.send(obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ItemReceiver extends ResultReceiver {
        private final String xc;
        private final ItemCallback xd;

        ItemReceiver(String str, ItemCallback itemCallback, Handler handler) {
            super(handler);
            this.xc = str;
            this.xd = itemCallback;
        }

        @Override // android.support.v4.os.ResultReceiver
        protected void onReceiveResult(int i, Bundle bundle) {
            bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            if (i != 0 || bundle == null || !bundle.containsKey(MediaBrowserServiceCompat.KEY_MEDIA_ITEM)) {
                this.xd.onError(this.xc);
                return;
            }
            Parcelable parcelable = bundle.getParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM);
            if (parcelable == null || (parcelable instanceof MediaItem)) {
                this.xd.onItemLoaded((MediaItem) parcelable);
            } else {
                this.xd.onError(this.xc);
            }
        }
    }
}
