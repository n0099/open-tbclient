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
import java.io.File;
import java.net.URI;
/* loaded from: classes2.dex */
public class a extends c.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String[] aCu = {"_id", "_data", "duration", "_size", "height", "width"};

    public a(d.a aVar) {
        super(aVar);
    }

    @Override // com.baidu.swan.apps.media.a.b.c.b
    public c.C0161c a(Context context, c.C0161c c0161c) {
        if (c0161c == null) {
            c0161c = new c.C0161c();
        }
        if (this.aCz.uri == null) {
            return c0161c.d(true, "uri is Null");
        }
        if (DEBUG) {
            Log.i("AlbumTaskStrategy", "AlbumTaskStrategy doInBackground uri=" + this.aCz.uri);
        }
        boolean a = a(c0161c);
        if (!a) {
            a = b(context, c0161c);
        }
        if (!a) {
            return c0161c.d(true, "can not handle uri:" + this.aCz.uri);
        }
        if (f(this.aCz)) {
            c0161c.b(1, this.aCz);
            return c0161c;
        }
        c0161c.b(2, this.aCz);
        return c0161c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [120=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:48:0x0110 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: android.media.MediaMetadataRetriever */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r1v6 */
    private boolean b(@NonNull Context context, @NonNull c.C0161c c0161c) {
        MediaMetadataRetriever mediaMetadataRetriever;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            MediaMetadataRetriever mediaMetadataRetriever2 = this.aCz.uri;
            Cursor query = contentResolver.query(mediaMetadataRetriever2, aCu, null, null, null);
            try {
            } catch (Exception e) {
                if (DEBUG) {
                    Log.i("AlbumTaskStrategy", "query exception", e);
                }
                c0161c.d(true, "query occurs exception:" + e.getMessage());
            } finally {
                com.baidu.swan.c.a.c(query);
            }
            if (query == null) {
                c0161c.d(true, "query return null:" + this.aCz.uri);
                return false;
            } else if (query.moveToFirst()) {
                d.c cVar = new d.c();
                cVar.id = query.getLong(0);
                cVar.aCP = query.getString(1);
                cVar.duration = query.getLong(2);
                cVar.size = query.getLong(3);
                cVar.aCN = query.getLong(4);
                cVar.aCO = query.getLong(5);
                if (cVar.aCO == 0 || cVar.aCN == 0) {
                    try {
                        if (!TextUtils.isEmpty(cVar.aCP)) {
                            try {
                                mediaMetadataRetriever = new MediaMetadataRetriever();
                                try {
                                    mediaMetadataRetriever.setDataSource(cVar.aCP);
                                    String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                                    String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                                    cVar.aCO = Long.parseLong(extractMetadata);
                                    cVar.aCN = Long.parseLong(extractMetadata2);
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
                                    this.aCz.aCI = cVar;
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
                this.aCz.aCI = cVar;
                return true;
            } else {
                return false;
            }
        } catch (Exception e4) {
            c0161c.d(true, e4.getMessage());
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [168=6, 169=5] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x007d -> B:10:0x0039). Please submit an issue!!! */
    private boolean a(@NonNull c.C0161c c0161c) {
        File file;
        MediaMetadataRetriever mediaMetadataRetriever = null;
        try {
            try {
                file = new File(new URI(this.aCz.uri.toString()));
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
            cVar.aCP = file.getPath();
            if (TextUtils.isEmpty(cVar.aCP)) {
                c0161c.d(true, "can not find path");
                if (0 != 0) {
                    mediaMetadataRetriever.release();
                    return true;
                }
                return true;
            }
            cVar.size = file.length();
            MediaMetadataRetriever mediaMetadataRetriever2 = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever2.setDataSource(cVar.aCP);
                String extractMetadata = mediaMetadataRetriever2.extractMetadata(18);
                String extractMetadata2 = mediaMetadataRetriever2.extractMetadata(19);
                String extractMetadata3 = mediaMetadataRetriever2.extractMetadata(9);
                cVar.aCO = Long.parseLong(extractMetadata);
                cVar.aCN = Long.parseLong(extractMetadata2);
                cVar.duration = Long.parseLong(extractMetadata3);
                this.aCz.aCI = cVar;
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
