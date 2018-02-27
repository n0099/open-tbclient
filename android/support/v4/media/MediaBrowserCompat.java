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
    private final b wP;

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
            this.wP = new e(context, componentName, connectionCallback, bundle);
        } else if (Build.VERSION.SDK_INT >= 23) {
            this.wP = new d(context, componentName, connectionCallback, bundle);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.wP = new c(context, componentName, connectionCallback, bundle);
        } else {
            this.wP = new f(context, componentName, connectionCallback, bundle);
        }
    }

    public void connect() {
        this.wP.connect();
    }

    public void disconnect() {
        this.wP.disconnect();
    }

    public boolean isConnected() {
        return this.wP.isConnected();
    }

    public ComponentName getServiceComponent() {
        return this.wP.getServiceComponent();
    }

    public String getRoot() {
        return this.wP.getRoot();
    }

    public Bundle getExtras() {
        return this.wP.getExtras();
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.wP.getSessionToken();
    }

    public void subscribe(String str, SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (subscriptionCallback == null) {
            throw new IllegalArgumentException("callback is null");
        }
        this.wP.subscribe(str, null, subscriptionCallback);
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
        this.wP.subscribe(str, bundle, subscriptionCallback);
    }

    public void unsubscribe(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        this.wP.unsubscribe(str, null);
    }

    public void unsubscribe(String str, SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (subscriptionCallback == null) {
            throw new IllegalArgumentException("callback is null");
        }
        this.wP.unsubscribe(str, subscriptionCallback);
    }

    public void getItem(String str, ItemCallback itemCallback) {
        this.wP.getItem(str, itemCallback);
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
        private final MediaDescriptionCompat xs;

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
            this.xs = mediaDescriptionCompat;
        }

        MediaItem(Parcel parcel) {
            this.mFlags = parcel.readInt();
            this.xs = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mFlags);
            this.xs.writeToParcel(parcel, i);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("MediaItem{");
            sb.append("mFlags=").append(this.mFlags);
            sb.append(", mDescription=").append(this.xs);
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
            return this.xs;
        }

        public String getMediaId() {
            return this.xs.getMediaId();
        }
    }

    /* loaded from: classes2.dex */
    public static class ConnectionCallback {
        final Object wS;
        a wT;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public interface a {
            void onConnected();

            void onConnectionFailed();

            void onConnectionSuspended();
        }

        public ConnectionCallback() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.wS = android.support.v4.media.a.a(new b());
            } else {
                this.wS = null;
            }
        }

        public void onConnected() {
        }

        public void onConnectionSuspended() {
        }

        public void onConnectionFailed() {
        }

        void a(a aVar) {
            this.wT = aVar;
        }

        /* loaded from: classes2.dex */
        private class b implements a.InterfaceC0003a {
            b() {
            }

            @Override // android.support.v4.media.a.InterfaceC0003a
            public void onConnected() {
                if (ConnectionCallback.this.wT != null) {
                    ConnectionCallback.this.wT.onConnected();
                }
                ConnectionCallback.this.onConnected();
            }

            @Override // android.support.v4.media.a.InterfaceC0003a
            public void onConnectionSuspended() {
                if (ConnectionCallback.this.wT != null) {
                    ConnectionCallback.this.wT.onConnectionSuspended();
                }
                ConnectionCallback.this.onConnectionSuspended();
            }

            @Override // android.support.v4.media.a.InterfaceC0003a
            public void onConnectionFailed() {
                if (ConnectionCallback.this.wT != null) {
                    ConnectionCallback.this.wT.onConnectionFailed();
                }
                ConnectionCallback.this.onConnectionFailed();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class SubscriptionCallback {
        private final IBinder wa;
        private final Object xv;
        WeakReference<i> xw;

        public SubscriptionCallback() {
            if (Build.VERSION.SDK_INT >= 24 || BuildCompat.isAtLeastN()) {
                this.xv = android.support.v4.media.c.a(new b());
                this.wa = null;
            } else if (Build.VERSION.SDK_INT >= 21) {
                this.xv = android.support.v4.media.a.a(new a());
                this.wa = new Binder();
            } else {
                this.xv = null;
                this.wa = new Binder();
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
            this.xw = new WeakReference<>(iVar);
        }

        /* loaded from: classes2.dex */
        private class a implements a.d {
            a() {
            }

            @Override // android.support.v4.media.a.d
            public void onChildrenLoaded(String str, List<?> list) {
                i iVar = SubscriptionCallback.this.xw == null ? null : SubscriptionCallback.this.xw.get();
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
        final Object wV;

        public ItemCallback() {
            if (Build.VERSION.SDK_INT >= 23) {
                this.wV = android.support.v4.media.b.a(new a());
            } else {
                this.wV = null;
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
        final Bundle xa;
        h xd;
        Messenger xe;
        final ComponentName xi;
        final ConnectionCallback xj;
        a xk;
        private String xl;
        private MediaSessionCompat.Token xm;
        final a xb = new a(this);
        private final ArrayMap<String, i> xc = new ArrayMap<>();
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
            this.xi = componentName;
            this.xj = connectionCallback;
            this.xa = bundle == null ? null : new Bundle(bundle);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void connect() {
            if (this.mState != 0) {
                throw new IllegalStateException("connect() called while not disconnected (state=" + ad(this.mState) + ")");
            }
            if (MediaBrowserCompat.DEBUG && this.xk != null) {
                throw new RuntimeException("mServiceConnection should be null. Instead it is " + this.xk);
            }
            if (this.xd != null) {
                throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + this.xd);
            }
            if (this.xe != null) {
                throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + this.xe);
            }
            this.mState = 1;
            Intent intent = new Intent(MediaBrowserServiceCompat.SERVICE_INTERFACE);
            intent.setComponent(this.xi);
            final a aVar = new a();
            this.xk = aVar;
            boolean z = false;
            try {
                z = this.mContext.bindService(intent, this.xk, 1);
            } catch (Exception e) {
                Log.e("MediaBrowserCompat", "Failed binding to service " + this.xi);
            }
            if (!z) {
                this.xb.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.f.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (aVar == f.this.xk) {
                            f.this.dl();
                            f.this.xj.onConnectionFailed();
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
            if (this.xe != null) {
                try {
                    this.xd.c(this.xe);
                } catch (RemoteException e) {
                    Log.w("MediaBrowserCompat", "RemoteException during connect for " + this.xi);
                }
            }
            dl();
            if (MediaBrowserCompat.DEBUG) {
                Log.d("MediaBrowserCompat", "disconnect...");
                dump();
            }
        }

        void dl() {
            if (this.xk != null) {
                this.mContext.unbindService(this.xk);
            }
            this.mState = 0;
            this.xk = null;
            this.xd = null;
            this.xe = null;
            this.xb.a(null);
            this.xl = null;
            this.xm = null;
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
            return this.xi;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public String getRoot() {
            if (!isConnected()) {
                throw new IllegalStateException("getRoot() called while not connected(state=" + ad(this.mState) + ")");
            }
            return this.xl;
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
            return this.xm;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void subscribe(String str, Bundle bundle, SubscriptionCallback subscriptionCallback) {
            i iVar = this.xc.get(str);
            if (iVar == null) {
                iVar = new i();
                this.xc.put(str, iVar);
            }
            iVar.a(bundle, subscriptionCallback);
            if (this.mState == 2) {
                try {
                    this.xd.a(str, subscriptionCallback.wa, bundle, this.xe);
                } catch (RemoteException e) {
                    Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException parentId=" + str);
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void unsubscribe(String str, SubscriptionCallback subscriptionCallback) {
            i iVar = this.xc.get(str);
            if (iVar != null) {
                try {
                    if (subscriptionCallback == null) {
                        if (this.mState == 2) {
                            this.xd.a(str, (IBinder) null, this.xe);
                        }
                    } else {
                        List<SubscriptionCallback> dn = iVar.dn();
                        List<Bundle> dm = iVar.dm();
                        for (int size = dn.size() - 1; size >= 0; size--) {
                            if (dn.get(size) == subscriptionCallback) {
                                if (this.mState == 2) {
                                    this.xd.a(str, subscriptionCallback.wa, this.xe);
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
                    this.xc.remove(str);
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
                this.xb.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.f.2
                    @Override // java.lang.Runnable
                    public void run() {
                        itemCallback.onError(str);
                    }
                });
                return;
            }
            try {
                this.xd.a(str, new ItemReceiver(str, itemCallback, this.xb), this.xe);
            } catch (RemoteException e) {
                Log.i("MediaBrowserCompat", "Remote error getting media item.");
                this.xb.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.f.3
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
                this.xl = str;
                this.xm = token;
                this.mExtras = bundle;
                this.mState = 2;
                if (MediaBrowserCompat.DEBUG) {
                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                    dump();
                }
                this.xj.onConnected();
                try {
                    for (Map.Entry<String, i> entry : this.xc.entrySet()) {
                        String key = entry.getKey();
                        i value = entry.getValue();
                        List<SubscriptionCallback> dn = value.dn();
                        List<Bundle> dm = value.dm();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < dn.size()) {
                                this.xd.a(key, dn.get(i2).wa, dm.get(i2), this.xe);
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
            Log.e("MediaBrowserCompat", "onConnectFailed for " + this.xi);
            if (a(messenger, "onConnectFailed")) {
                if (this.mState != 1) {
                    Log.w("MediaBrowserCompat", "onConnect from service while mState=" + ad(this.mState) + "... ignoring");
                    return;
                }
                dl();
                this.xj.onConnectionFailed();
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.g
        public void a(Messenger messenger, String str, List list, Bundle bundle) {
            if (a(messenger, "onLoadChildren")) {
                if (MediaBrowserCompat.DEBUG) {
                    Log.d("MediaBrowserCompat", "onLoadChildren for " + this.xi + " id=" + str);
                }
                i iVar = this.xc.get(str);
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
            if (this.xe != messenger) {
                if (this.mState != 0) {
                    Log.i("MediaBrowserCompat", str + " for " + this.xi + " with mCallbacksMessenger=" + this.xe + " this=" + this);
                }
                return false;
            }
            return true;
        }

        void dump() {
            Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
            Log.d("MediaBrowserCompat", "  mServiceComponent=" + this.xi);
            Log.d("MediaBrowserCompat", "  mCallback=" + this.xj);
            Log.d("MediaBrowserCompat", "  mRootHints=" + this.xa);
            Log.d("MediaBrowserCompat", "  mState=" + ad(this.mState));
            Log.d("MediaBrowserCompat", "  mServiceConnection=" + this.xk);
            Log.d("MediaBrowserCompat", "  mServiceBinderWrapper=" + this.xd);
            Log.d("MediaBrowserCompat", "  mCallbacksMessenger=" + this.xe);
            Log.d("MediaBrowserCompat", "  mRootId=" + this.xl);
            Log.d("MediaBrowserCompat", "  mMediaSessionToken=" + this.xm);
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
                            f.this.xd = new h(iBinder, f.this.xa);
                            f.this.xe = new Messenger(f.this.xb);
                            f.this.xb.a(f.this.xe);
                            f.this.mState = 1;
                            try {
                                if (MediaBrowserCompat.DEBUG) {
                                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                                    f.this.dump();
                                }
                                f.this.xd.a(f.this.mContext, f.this.xe);
                            } catch (RemoteException e) {
                                Log.w("MediaBrowserCompat", "RemoteException during connect for " + f.this.xi);
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
                            Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceDisconnected name=" + componentName + " this=" + this + " mServiceConnection=" + f.this.xk);
                            f.this.dump();
                        }
                        if (a.this.y("onServiceDisconnected")) {
                            f.this.xd = null;
                            f.this.xe = null;
                            f.this.xb.a(null);
                            f.this.mState = 3;
                            f.this.xj.onConnectionSuspended();
                        }
                    }
                });
            }

            private void c(Runnable runnable) {
                if (Thread.currentThread() == f.this.xb.getLooper().getThread()) {
                    runnable.run();
                } else {
                    f.this.xb.post(runnable);
                }
            }

            boolean y(String str) {
                if (f.this.xk != this) {
                    if (f.this.mState != 0) {
                        Log.i("MediaBrowserCompat", str + " for " + f.this.xi + " with mServiceConnection=" + f.this.xk + " this=" + this);
                    }
                    return false;
                }
                return true;
            }
        }
    }

    /* loaded from: classes2.dex */
    static class c implements ConnectionCallback.a, b, g {
        protected final Object wZ;
        protected final Bundle xa;
        protected final a xb = new a(this);
        private final ArrayMap<String, i> xc = new ArrayMap<>();
        protected h xd;
        protected Messenger xe;

        public c(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            if (Build.VERSION.SDK_INT < 25) {
                bundle = bundle == null ? new Bundle() : bundle;
                bundle.putInt("extra_client_version", 1);
                this.xa = new Bundle(bundle);
            } else {
                this.xa = bundle == null ? null : new Bundle(bundle);
            }
            connectionCallback.a(this);
            this.wZ = android.support.v4.media.a.a(context, componentName, connectionCallback.wS, this.xa);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void connect() {
            android.support.v4.media.a.k(this.wZ);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void disconnect() {
            if (this.xd != null && this.xe != null) {
                try {
                    this.xd.e(this.xe);
                } catch (RemoteException e) {
                    Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
                }
            }
            android.support.v4.media.a.l(this.wZ);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public boolean isConnected() {
            return android.support.v4.media.a.m(this.wZ);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public ComponentName getServiceComponent() {
            return android.support.v4.media.a.n(this.wZ);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public String getRoot() {
            return android.support.v4.media.a.o(this.wZ);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public Bundle getExtras() {
            return android.support.v4.media.a.getExtras(this.wZ);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public MediaSessionCompat.Token getSessionToken() {
            return MediaSessionCompat.Token.fromToken(android.support.v4.media.a.p(this.wZ));
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void subscribe(String str, Bundle bundle, SubscriptionCallback subscriptionCallback) {
            i iVar = this.xc.get(str);
            if (iVar == null) {
                iVar = new i();
                this.xc.put(str, iVar);
            }
            subscriptionCallback.a(iVar);
            iVar.a(bundle, subscriptionCallback);
            if (this.xd == null) {
                android.support.v4.media.a.a(this.wZ, str, subscriptionCallback.xv);
                return;
            }
            try {
                this.xd.a(str, subscriptionCallback.wa, bundle, this.xe);
            } catch (RemoteException e) {
                Log.i("MediaBrowserCompat", "Remote error subscribing media item: " + str);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b
        public void unsubscribe(String str, SubscriptionCallback subscriptionCallback) {
            i iVar = this.xc.get(str);
            if (iVar != null) {
                if (this.xd == null) {
                    if (subscriptionCallback == null) {
                        android.support.v4.media.a.d(this.wZ, str);
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
                            android.support.v4.media.a.d(this.wZ, str);
                        }
                    }
                } else {
                    try {
                        if (subscriptionCallback == null) {
                            this.xd.a(str, (IBinder) null, this.xe);
                        } else {
                            List<SubscriptionCallback> dn2 = iVar.dn();
                            List<Bundle> dm2 = iVar.dm();
                            for (int size2 = dn2.size() - 1; size2 >= 0; size2--) {
                                if (dn2.get(size2) == subscriptionCallback) {
                                    this.xd.a(str, subscriptionCallback.wa, this.xe);
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
                    this.xc.remove(str);
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
            if (!android.support.v4.media.a.m(this.wZ)) {
                Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
                this.xb.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        itemCallback.onError(str);
                    }
                });
            } else if (this.xd == null) {
                this.xb.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        itemCallback.onError(str);
                    }
                });
            } else {
                try {
                    this.xd.a(str, new ItemReceiver(str, itemCallback, this.xb), this.xe);
                } catch (RemoteException e) {
                    Log.i("MediaBrowserCompat", "Remote error getting media item: " + str);
                    this.xb.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.c.3
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
            Bundle extras = android.support.v4.media.a.getExtras(this.wZ);
            if (extras != null && (binder = BundleCompat.getBinder(extras, "extra_messenger")) != null) {
                this.xd = new h(binder, this.xa);
                this.xe = new Messenger(this.xb);
                this.xb.a(this.xe);
                try {
                    this.xd.d(this.xe);
                } catch (RemoteException e) {
                    Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.a
        public void onConnectionSuspended() {
            this.xd = null;
            this.xe = null;
            this.xb.a(null);
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
            if (this.xe == messenger) {
                i iVar = this.xc.get(str);
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
            if (this.xd == null) {
                android.support.v4.media.b.b(this.wZ, str, itemCallback.wV);
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
                android.support.v4.media.a.a(this.wZ, str, subscriptionCallback.xv);
            } else {
                android.support.v4.media.c.a(this.wZ, str, bundle, subscriptionCallback.xv);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c, android.support.v4.media.MediaBrowserCompat.b
        public void unsubscribe(String str, SubscriptionCallback subscriptionCallback) {
            if (subscriptionCallback == null) {
                android.support.v4.media.a.d(this.wZ, str);
            } else {
                android.support.v4.media.c.c(this.wZ, str, subscriptionCallback.xv);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class i {
        private final List<SubscriptionCallback> xt = new ArrayList();
        private final List<Bundle> xu = new ArrayList();

        public boolean isEmpty() {
            return this.xt.isEmpty();
        }

        public List<Bundle> dm() {
            return this.xu;
        }

        public List<SubscriptionCallback> dn() {
            return this.xt;
        }

        public SubscriptionCallback g(Bundle bundle) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.xu.size()) {
                    if (!MediaBrowserCompatUtils.areSameOptions(this.xu.get(i2), bundle)) {
                        i = i2 + 1;
                    } else {
                        return this.xt.get(i2);
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
                if (i2 < this.xu.size()) {
                    if (!MediaBrowserCompatUtils.areSameOptions(this.xu.get(i2), bundle)) {
                        i = i2 + 1;
                    } else {
                        this.xt.set(i2, subscriptionCallback);
                        return;
                    }
                } else {
                    this.xt.add(subscriptionCallback);
                    this.xu.add(bundle);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends Handler {
        private final WeakReference<g> wQ;
        private WeakReference<Messenger> wR;

        a(g gVar) {
            this.wQ = new WeakReference<>(gVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.wR != null && this.wR.get() != null && this.wQ.get() != null) {
                Bundle data = message.getData();
                data.setClassLoader(MediaSessionCompat.class.getClassLoader());
                switch (message.what) {
                    case 1:
                        this.wQ.get().a(this.wR.get(), data.getString("data_media_item_id"), (MediaSessionCompat.Token) data.getParcelable("data_media_session_token"), data.getBundle("data_root_hints"));
                        return;
                    case 2:
                        this.wQ.get().b(this.wR.get());
                        return;
                    case 3:
                        this.wQ.get().a(this.wR.get(), data.getString("data_media_item_id"), data.getParcelableArrayList("data_media_item_list"), data.getBundle("data_options"));
                        return;
                    default:
                        Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: 1\n  Service version: " + message.arg1);
                        return;
                }
            }
        }

        void a(Messenger messenger) {
            this.wR = new WeakReference<>(messenger);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class h {
        private Messenger mMessenger;
        private Bundle xa;

        public h(IBinder iBinder, Bundle bundle) {
            this.mMessenger = new Messenger(iBinder);
            this.xa = bundle;
        }

        void a(Context context, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString("data_package_name", context.getPackageName());
            bundle.putBundle("data_root_hints", this.xa);
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
            bundle.putBundle("data_root_hints", this.xa);
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
        private final String wX;
        private final ItemCallback wY;

        ItemReceiver(String str, ItemCallback itemCallback, Handler handler) {
            super(handler);
            this.wX = str;
            this.wY = itemCallback;
        }

        @Override // android.support.v4.os.ResultReceiver
        protected void onReceiveResult(int i, Bundle bundle) {
            bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            if (i != 0 || bundle == null || !bundle.containsKey(MediaBrowserServiceCompat.KEY_MEDIA_ITEM)) {
                this.wY.onError(this.wX);
                return;
            }
            Parcelable parcelable = bundle.getParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM);
            if (parcelable == null || (parcelable instanceof MediaItem)) {
                this.wY.onItemLoaded((MediaItem) parcelable);
            } else {
                this.wY.onError(this.wX);
            }
        }
    }
}
