package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import java.util.List;
/* loaded from: classes2.dex */
class a {

    /* renamed from: android.support.v4.media.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    interface InterfaceC0003a {
        void onConnected();

        void onConnectionFailed();

        void onConnectionSuspended();
    }

    /* loaded from: classes2.dex */
    interface d {
        void onChildrenLoaded(String str, List<?> list);

        void onError(String str);
    }

    public static Object a(InterfaceC0003a interfaceC0003a) {
        return new b(interfaceC0003a);
    }

    public static Object a(Context context, ComponentName componentName, Object obj, Bundle bundle) {
        return new MediaBrowser(context, componentName, (MediaBrowser.ConnectionCallback) obj, bundle);
    }

    public static void k(Object obj) {
        ((MediaBrowser) obj).connect();
    }

    public static void l(Object obj) {
        ((MediaBrowser) obj).disconnect();
    }

    public static boolean m(Object obj) {
        return ((MediaBrowser) obj).isConnected();
    }

    public static ComponentName n(Object obj) {
        return ((MediaBrowser) obj).getServiceComponent();
    }

    public static String o(Object obj) {
        return ((MediaBrowser) obj).getRoot();
    }

    public static Bundle getExtras(Object obj) {
        return ((MediaBrowser) obj).getExtras();
    }

    public static Object p(Object obj) {
        return ((MediaBrowser) obj).getSessionToken();
    }

    public static Object a(d dVar) {
        return new e(dVar);
    }

    public static void a(Object obj, String str, Object obj2) {
        ((MediaBrowser) obj).subscribe(str, (MediaBrowser.SubscriptionCallback) obj2);
    }

    public static void d(Object obj, String str) {
        ((MediaBrowser) obj).unsubscribe(str);
    }

    /* loaded from: classes2.dex */
    static class b<T extends InterfaceC0003a> extends MediaBrowser.ConnectionCallback {
        protected final T xD;

        public b(T t) {
            this.xD = t;
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnected() {
            this.xD.onConnected();
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionSuspended() {
            this.xD.onConnectionSuspended();
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionFailed() {
            this.xD.onConnectionFailed();
        }
    }

    /* loaded from: classes2.dex */
    static class e<T extends d> extends MediaBrowser.SubscriptionCallback {
        protected final T xE;

        public e(T t) {
            this.xE = t;
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(String str, List<MediaBrowser.MediaItem> list) {
            this.xE.onChildrenLoaded(str, list);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(String str) {
            this.xE.onError(str);
        }
    }

    /* loaded from: classes2.dex */
    static class c {
        public static int q(Object obj) {
            return ((MediaBrowser.MediaItem) obj).getFlags();
        }

        public static Object r(Object obj) {
            return ((MediaBrowser.MediaItem) obj).getDescription();
        }
    }
}
