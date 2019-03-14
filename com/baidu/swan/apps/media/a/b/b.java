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
    public c.C0145c a(Context context, c.C0145c c0145c) {
        MediaMetadataRetriever mediaMetadataRetriever;
        if (DEBUG) {
            Log.i("CameraTaskStrategy", "CameraTaskStrategy doInBackground uri=" + this.aAs.uri);
        }
        if (c0145c == null) {
            c0145c = new c.C0145c();
        }
        if (this.aAs.uri == null) {
            c0145c.d(true, "uri in pickData is null");
        } else {
            String path = this.aAs.uri.getPath();
            if (TextUtils.isEmpty(path)) {
                c0145c.d(true, this.aAs.uri + " get file path failed");
            } else {
                d.c cVar = new d.c();
                cVar.aAI = path;
                try {
                    mediaMetadataRetriever = new MediaMetadataRetriever();
                    try {
                        try {
                            mediaMetadataRetriever.setDataSource(cVar.aAI);
                            String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                            String extractMetadata3 = mediaMetadataRetriever.extractMetadata(9);
                            cVar.aAH = Long.parseLong(extractMetadata);
                            cVar.aAG = Long.parseLong(extractMetadata2);
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
                            this.aAs.aAB = cVar;
                            if (f(this.aAs)) {
                            }
                            return c0145c;
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
                this.aAs.aAB = cVar;
                if (f(this.aAs)) {
                    this.aAs.aAB.aAF = com.baidu.swan.apps.storage.b.aD(path, com.baidu.swan.apps.ae.b.Ji());
                    c0145c.b(0, this.aAs);
                } else {
                    c0145c.b(1, this.aAs);
                }
            }
        }
        return c0145c;
    }
}
