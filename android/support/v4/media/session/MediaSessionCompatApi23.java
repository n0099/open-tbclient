package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.d;
/* loaded from: classes2.dex */
class MediaSessionCompatApi23 {

    /* loaded from: classes2.dex */
    public interface Callback extends d.a {
        void onPlayFromUri(Uri uri, Bundle bundle);
    }

    public static Object a(Callback callback) {
        return new a(callback);
    }

    /* loaded from: classes2.dex */
    static class a<T extends Callback> extends d.b<T> {
        public a(T t) {
            super(t);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromUri(Uri uri, Bundle bundle) {
            ((Callback) this.zZ).onPlayFromUri(uri, bundle);
        }
    }
}
