package com.baidu.swan.apps.media.a.b;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.media.a.b.c;
import com.baidu.swan.apps.media.a.b.d;
import java.io.File;
/* loaded from: classes2.dex */
public class b extends c.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public b(d.a aVar) {
        super(aVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [72=4] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d7  */
    @Override // com.baidu.swan.apps.media.a.b.c.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c.C0152c a(Context context, c.C0152c c0152c) {
        MediaMetadataRetriever mediaMetadataRetriever;
        if (DEBUG) {
            Log.i("CameraTaskStrategy", "CameraTaskStrategy doInBackground uri=" + this.aCb.uri);
        }
        if (c0152c == null) {
            c0152c = new c.C0152c();
        }
        if (this.aCb.uri == null) {
            c0152c.d(true, "uri in pickData is null");
        } else {
            String path = this.aCb.uri.getPath();
            if (TextUtils.isEmpty(path)) {
                c0152c.d(true, this.aCb.uri + " get file path failed");
            } else {
                d.c cVar = new d.c();
                cVar.aCr = path;
                try {
                    mediaMetadataRetriever = new MediaMetadataRetriever();
                    try {
                        try {
                            mediaMetadataRetriever.setDataSource(cVar.aCr);
                            String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                            String extractMetadata3 = mediaMetadataRetriever.extractMetadata(9);
                            cVar.aCq = Long.parseLong(extractMetadata);
                            cVar.aCp = Long.parseLong(extractMetadata2);
                            cVar.duration = Long.parseLong(extractMetadata3);
                            cVar.size = new File(path).length();
                            if (mediaMetadataRetriever != null) {
                                mediaMetadataRetriever.release();
                            }
                        } catch (Exception e) {
                            e = e;
                            if (DEBUG) {
                                Log.e("CameraTaskStrategy", "Exception", e);
                            }
                            if (mediaMetadataRetriever != null) {
                                mediaMetadataRetriever.release();
                            }
                            this.aCb.aCk = cVar;
                            if (f(this.aCb)) {
                            }
                            return c0152c;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (mediaMetadataRetriever != null) {
                            mediaMetadataRetriever.release();
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    mediaMetadataRetriever = null;
                } catch (Throwable th2) {
                    th = th2;
                    mediaMetadataRetriever = null;
                    if (mediaMetadataRetriever != null) {
                    }
                    throw th;
                }
                this.aCb.aCk = cVar;
                if (f(this.aCb)) {
                    this.aCb.aCk.aCo = com.baidu.swan.apps.storage.b.aG(path, com.baidu.swan.apps.ae.b.Mo());
                    c0152c.b(0, this.aCb);
                } else {
                    c0152c.b(1, this.aCb);
                }
            }
        }
        return c0152c;
    }
}
