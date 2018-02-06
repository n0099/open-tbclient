package android.support.v4.media;

import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
class MediaBrowserServiceCompatApi21 {

    /* loaded from: classes2.dex */
    public interface ServiceCompatProxy {
        a onGetRoot(String str, int i, Bundle bundle);

        void onLoadChildren(String str, c<List<Parcel>> cVar);
    }

    public static Object a(Context context, ServiceCompatProxy serviceCompatProxy) {
        return new b(context, serviceCompatProxy);
    }

    public static void s(Object obj) {
        ((MediaBrowserService) obj).onCreate();
    }

    public static IBinder a(Object obj, Intent intent) {
        return ((MediaBrowserService) obj).onBind(intent);
    }

    public static void e(Object obj, Object obj2) {
        ((MediaBrowserService) obj).setSessionToken((MediaSession.Token) obj2);
    }

    public static void e(Object obj, String str) {
        ((MediaBrowserService) obj).notifyChildrenChanged(str);
    }

    /* loaded from: classes2.dex */
    static class c<T> {
        MediaBrowserService.Result yj;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(MediaBrowserService.Result result) {
            this.yj = result;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: android.service.media.MediaBrowserService$Result */
        /* JADX WARN: Multi-variable type inference failed */
        public void sendResult(T t) {
            if (t instanceof List) {
                this.yj.sendResult(h((List) t));
            } else if (t instanceof Parcel) {
                Parcel parcel = (Parcel) t;
                this.yj.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            } else {
                this.yj.sendResult(null);
            }
        }

        public void detach() {
            this.yj.detach();
        }

        List<MediaBrowser.MediaItem> h(List<Parcel> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcel parcel : list) {
                parcel.setDataPosition(0);
                arrayList.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            }
            return arrayList;
        }
    }

    /* loaded from: classes2.dex */
    static class a {
        final Bundle mExtras;
        final String xq;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(String str, Bundle bundle) {
            this.xq = str;
            this.mExtras = bundle;
        }
    }

    /* loaded from: classes2.dex */
    static class b extends MediaBrowserService {
        final ServiceCompatProxy mServiceProxy;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(Context context, ServiceCompatProxy serviceCompatProxy) {
            attachBaseContext(context);
            this.mServiceProxy = serviceCompatProxy;
        }

        @Override // android.service.media.MediaBrowserService
        public MediaBrowserService.BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
            a onGetRoot = this.mServiceProxy.onGetRoot(str, i, bundle);
            if (onGetRoot == null) {
                return null;
            }
            return new MediaBrowserService.BrowserRoot(onGetRoot.xq, onGetRoot.mExtras);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result) {
            this.mServiceProxy.onLoadChildren(str, new c<>(result));
        }
    }
}
