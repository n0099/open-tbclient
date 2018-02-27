package android.support.v4.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserServiceCompatApi23;
import android.util.Log;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
class MediaBrowserServiceCompatApi24 {
    private static Field yf;

    /* loaded from: classes2.dex */
    public interface ServiceCompatProxy extends MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        void onLoadChildren(String str, b bVar, Bundle bundle);
    }

    static {
        try {
            yf = MediaBrowserService.Result.class.getDeclaredField("mFlags");
            yf.setAccessible(true);
        } catch (NoSuchFieldException e) {
            Log.w("MBSCompatApi24", e);
        }
    }

    public static Object a(Context context, ServiceCompatProxy serviceCompatProxy) {
        return new a(context, serviceCompatProxy);
    }

    public static void a(Object obj, String str, Bundle bundle) {
        ((MediaBrowserService) obj).notifyChildrenChanged(str, bundle);
    }

    public static Bundle t(Object obj) {
        return ((MediaBrowserService) obj).getBrowserRootHints();
    }

    /* loaded from: classes2.dex */
    static class b {
        MediaBrowserService.Result ye;

        b(MediaBrowserService.Result result) {
            this.ye = result;
        }

        public void c(List<Parcel> list, int i) {
            try {
                MediaBrowserServiceCompatApi24.yf.setInt(this.ye, i);
            } catch (IllegalAccessException e) {
                Log.w("MBSCompatApi24", e);
            }
            this.ye.sendResult(h(list));
        }

        public void detach() {
            this.ye.detach();
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
    static class a extends MediaBrowserServiceCompatApi23.a {
        a(Context context, ServiceCompatProxy serviceCompatProxy) {
            super(context, serviceCompatProxy);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result, Bundle bundle) {
            ((ServiceCompatProxy) this.mServiceProxy).onLoadChildren(str, new b(result), bundle);
        }
    }
}
