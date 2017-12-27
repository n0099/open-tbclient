package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Parcel;
/* loaded from: classes2.dex */
class b {

    /* loaded from: classes2.dex */
    interface a {
        void c(Parcel parcel);

        void onError(String str);
    }

    public static Object a(a aVar) {
        return new C0004b(aVar);
    }

    public static void b(Object obj, String str, Object obj2) {
        ((MediaBrowser) obj).getItem(str, (MediaBrowser.ItemCallback) obj2);
    }

    /* renamed from: android.support.v4.media.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0004b<T extends a> extends MediaBrowser.ItemCallback {
        protected final T xF;

        public C0004b(T t) {
            this.xF = t;
        }

        @Override // android.media.browse.MediaBrowser.ItemCallback
        public void onItemLoaded(MediaBrowser.MediaItem mediaItem) {
            Parcel obtain = Parcel.obtain();
            mediaItem.writeToParcel(obtain, 0);
            this.xF.c(obtain);
        }

        @Override // android.media.browse.MediaBrowser.ItemCallback
        public void onError(String str) {
            this.xF.onError(str);
        }
    }
}
