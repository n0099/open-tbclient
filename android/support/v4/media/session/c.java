package android.support.v4.media.session;

import android.media.Rating;
import android.media.RemoteControlClient;
import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.b;
import com.baidu.fsg.base.router.RouterCallback;
/* loaded from: classes2.dex */
class c {

    /* loaded from: classes2.dex */
    interface a extends b.a {
        void Q(Object obj);
    }

    public static void a(Object obj, long j) {
        ((RemoteControlClient) obj).setTransportControlFlags(m(j));
    }

    public static Object a(a aVar) {
        return new b(aVar);
    }

    public static void a(Object obj, Bundle bundle, long j) {
        RemoteControlClient.MetadataEditor editMetadata = ((RemoteControlClient) obj).editMetadata(true);
        android.support.v4.media.session.a.a(bundle, editMetadata);
        b(bundle, editMetadata);
        if ((128 & j) != 0) {
            editMetadata.addEditableKey(RouterCallback.CODE_ERROR);
        }
        editMetadata.apply();
    }

    public static void h(Object obj, Object obj2) {
        ((RemoteControlClient) obj).setMetadataUpdateListener((RemoteControlClient.OnMetadataUpdateListener) obj2);
    }

    static int m(long j) {
        int m = android.support.v4.media.session.b.m(j);
        if ((128 & j) != 0) {
            return m | 512;
        }
        return m;
    }

    static void b(Bundle bundle, RemoteControlClient.MetadataEditor metadataEditor) {
        if (bundle != null) {
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_YEAR)) {
                metadataEditor.putLong(8, bundle.getLong(MediaMetadataCompat.METADATA_KEY_YEAR));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_RATING)) {
                metadataEditor.putObject(101, (Object) bundle.getParcelable(MediaMetadataCompat.METADATA_KEY_RATING));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_USER_RATING)) {
                metadataEditor.putObject(RouterCallback.CODE_ERROR, (Object) bundle.getParcelable(MediaMetadataCompat.METADATA_KEY_USER_RATING));
            }
        }
    }

    /* loaded from: classes2.dex */
    static class b<T extends a> implements RemoteControlClient.OnMetadataUpdateListener {
        protected final T zT;

        public b(T t) {
            this.zT = t;
        }

        @Override // android.media.RemoteControlClient.OnMetadataUpdateListener
        public void onMetadataUpdate(int i, Object obj) {
            if (i == 268435457 && (obj instanceof Rating)) {
                this.zT.Q(obj);
            }
        }
    }
}
