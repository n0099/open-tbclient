package com.baidu.swan.apps.media.a.b;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.media.a.b.c;
import com.baidu.swan.apps.media.a.b.d;
import com.baidu.ubc.UBC;
import java.io.File;
import java.net.URI;
/* loaded from: classes2.dex */
public class a extends c.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String[] aAq = {"_id", "_data", UBC.CONTENT_KEY_DURATION, "_size", "height", "width"};

    public a(d.a aVar) {
        super(aVar);
    }

    @Override // com.baidu.swan.apps.media.a.b.c.b
    public c.C0145c a(Context context, c.C0145c c0145c) {
        if (c0145c == null) {
            c0145c = new c.C0145c();
        }
        if (this.aAv.uri == null) {
            return c0145c.d(true, "uri is Null");
        }
        if (DEBUG) {
            Log.i("AlbumTaskStrategy", "AlbumTaskStrategy doInBackground uri=" + this.aAv.uri);
        }
        boolean a = a(c0145c);
        if (!a) {
            a = b(context, c0145c);
        }
        if (!a) {
            return c0145c.d(true, "can not handle uri:" + this.aAv.uri);
        }
        if (f(this.aAv)) {
            c0145c.b(1, this.aAv);
            return c0145c;
        }
        c0145c.b(2, this.aAv);
        return c0145c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [135=4, 120=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:48:0x0110 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: android.media.MediaMetadataRetriever */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r1v6 */
    private boolean b(@NonNull Context context, @NonNull c.C0145c c0145c) {
        MediaMetadataRetriever mediaMetadataRetriever;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            MediaMetadataRetriever mediaMetadataRetriever2 = this.aAv.uri;
            Cursor query = contentResolver.query(mediaMetadataRetriever2, aAq, null, null, null);
            try {
            } catch (Exception e) {
                if (DEBUG) {
                    Log.i("AlbumTaskStrategy", "query exception", e);
                }
                c0145c.d(true, "query occurs exception:" + e.getMessage());
            } finally {
                com.baidu.swan.c.b.c(query);
            }
            if (query == null) {
                c0145c.d(true, "query return null:" + this.aAv.uri);
                return false;
            } else if (query.moveToFirst()) {
                d.c cVar = new d.c();
                cVar.id = query.getLong(0);
                cVar.aAL = query.getString(1);
                cVar.duration = query.getLong(2);
                cVar.size = query.getLong(3);
                cVar.aAJ = query.getLong(4);
                cVar.aAK = query.getLong(5);
                if (cVar.aAK == 0 || cVar.aAJ == 0) {
                    try {
                        if (!TextUtils.isEmpty(cVar.aAL)) {
                            try {
                                mediaMetadataRetriever = new MediaMetadataRetriever();
                                try {
                                    mediaMetadataRetriever.setDataSource(cVar.aAL);
                                    String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                                    String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                                    cVar.aAK = Long.parseLong(extractMetadata);
                                    cVar.aAJ = Long.parseLong(extractMetadata2);
                                    if (mediaMetadataRetriever != null) {
                                        mediaMetadataRetriever.release();
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    if (DEBUG) {
                                        Log.e("AlbumTaskStrategy", "Exception", e);
                                    }
                                    if (mediaMetadataRetriever != null) {
                                        mediaMetadataRetriever.release();
                                    }
                                    this.aAv.aAE = cVar;
                                    return true;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                mediaMetadataRetriever = null;
                            } catch (Throwable th) {
                                th = th;
                                mediaMetadataRetriever2 = 0;
                                if (mediaMetadataRetriever2 != 0) {
                                    mediaMetadataRetriever2.release();
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                this.aAv.aAE = cVar;
                return true;
            } else {
                return false;
            }
        } catch (Exception e4) {
            c0145c.d(true, e4.getMessage());
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [168=6, 169=5] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x007d -> B:10:0x0039). Please submit an issue!!! */
    private boolean a(@NonNull c.C0145c c0145c) {
        File file;
        MediaMetadataRetriever mediaMetadataRetriever = null;
        try {
            try {
                file = new File(new URI(this.aAv.uri.toString()));
            } catch (Exception e) {
                e = e;
            }
            if (!file.exists()) {
                if (0 != 0) {
                    mediaMetadataRetriever.release();
                }
                return false;
            }
            d.c cVar = new d.c();
            cVar.aAL = file.getPath();
            if (TextUtils.isEmpty(cVar.aAL)) {
                c0145c.d(true, "can not find path");
                if (0 != 0) {
                    mediaMetadataRetriever.release();
                    return true;
                }
                return true;
            }
            cVar.size = file.length();
            MediaMetadataRetriever mediaMetadataRetriever2 = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever2.setDataSource(cVar.aAL);
                String extractMetadata = mediaMetadataRetriever2.extractMetadata(18);
                String extractMetadata2 = mediaMetadataRetriever2.extractMetadata(19);
                String extractMetadata3 = mediaMetadataRetriever2.extractMetadata(9);
                cVar.aAK = Long.parseLong(extractMetadata);
                cVar.aAJ = Long.parseLong(extractMetadata2);
                cVar.duration = Long.parseLong(extractMetadata3);
                this.aAv.aAE = cVar;
                if (mediaMetadataRetriever2 != null) {
                    mediaMetadataRetriever2.release();
                    return true;
                }
                return true;
            } catch (Exception e2) {
                e = e2;
                mediaMetadataRetriever = mediaMetadataRetriever2;
                if (DEBUG) {
                    Log.e("AlbumTaskStrategy", "extractVideoInfoFromFile", e);
                }
                if (mediaMetadataRetriever != null) {
                    mediaMetadataRetriever.release();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                mediaMetadataRetriever = mediaMetadataRetriever2;
                if (mediaMetadataRetriever != null) {
                    mediaMetadataRetriever.release();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
