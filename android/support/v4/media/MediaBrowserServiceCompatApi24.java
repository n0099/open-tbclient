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
    private static Field yl;

    /* loaded from: classes2.dex */
    public interface ServiceCompatProxy extends MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        void onLoadChildren(String str, b bVar, Bundle bundle);
    }

    static {
        try {
            yl = MediaBrowserService.Result.class.getDeclaredField("mFlags");
            yl.setAccessible(true);
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
        MediaBrowserService.Result yk;

        b(MediaBrowserService.Result result) {
            this.yk = result;
        }

        public void c(List<Parcel> list, int i) {
            try {
                MediaBrowserServiceCompatApi24.yl.setInt(this.yk, i);
            } catch (IllegalAccessException e) {
                Log.w("MBSCompatApi24", e);
            }
            this.yk.sendResult(h(list));
        }

        public void detach() {
            this.yk.detach();
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
