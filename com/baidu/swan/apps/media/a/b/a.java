package com.baidu.swan.apps.media.a.b;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.swan.apps.media.a.b.c;
import com.baidu.swan.apps.media.a.b.d;
import java.io.File;
import java.net.URI;
/* loaded from: classes2.dex */
public class a extends c.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String[] aVr = {IMConstants.MSG_ROW_ID, "_data", "duration", "_size", "height", "width"};

    public a(d.a aVar) {
        super(aVar);
    }

    @Override // com.baidu.swan.apps.media.a.b.c.b
    public c.C0193c a(Context context, c.C0193c c0193c) {
        if (c0193c == null) {
            c0193c = new c.C0193c();
        }
        if (this.aVw.uri == null) {
            return c0193c.e(true, "uri is Null");
        }
        if (DEBUG) {
            Log.i("AlbumTaskStrategy", "AlbumTaskStrategy doInBackground uri=" + this.aVw.uri);
        }
        boolean a = a(c0193c);
        if (!a) {
            a = b(context, c0193c);
        }
        if (!a) {
            return c0193c.e(true, "can not handle uri:" + this.aVw.uri);
        }
        if (f(this.aVw)) {
            c0193c.f(1, this.aVw);
            return c0193c;
        }
        c0193c.f(2, this.aVw);
        return c0193c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [120=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:48:0x0110 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: android.media.MediaMetadataRetriever */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r1v6 */
    private boolean b(@NonNull Context context, @NonNull c.C0193c c0193c) {
        MediaMetadataRetriever mediaMetadataRetriever;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            MediaMetadataRetriever mediaMetadataRetriever2 = this.aVw.uri;
            Cursor query = contentResolver.query(mediaMetadataRetriever2, aVr, null, null, null);
            try {
            } catch (Exception e) {
                if (DEBUG) {
                    Log.i("AlbumTaskStrategy", "query exception", e);
                }
                c0193c.e(true, "query occurs exception:" + e.getMessage());
            } finally {
                com.baidu.swan.c.a.b(query);
            }
            if (query == null) {
                c0193c.e(true, "query return null:" + this.aVw.uri);
                return false;
            } else if (query.moveToFirst()) {
                d.c cVar = new d.c();
                cVar.id = query.getLong(0);
                cVar.aVM = query.getString(1);
                cVar.duration = query.getLong(2);
                cVar.size = query.getLong(3);
                cVar.aVK = query.getLong(4);
                cVar.aVL = query.getLong(5);
                if (cVar.aVL == 0 || cVar.aVK == 0) {
                    try {
                        if (!TextUtils.isEmpty(cVar.aVM)) {
                            try {
                                mediaMetadataRetriever = new MediaMetadataRetriever();
                                try {
                                    mediaMetadataRetriever.setDataSource(cVar.aVM);
                                    String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                                    String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                                    cVar.aVL = Long.parseLong(extractMetadata);
                                    cVar.aVK = Long.parseLong(extractMetadata2);
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
                                    this.aVw.aVF = cVar;
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
                this.aVw.aVF = cVar;
                return true;
            } else {
                return false;
            }
        } catch (Exception e4) {
            c0193c.e(true, e4.getMessage());
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [168=6, 169=5] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x007d -> B:10:0x0039). Please submit an issue!!! */
    private boolean a(@NonNull c.C0193c c0193c) {
        File file;
        MediaMetadataRetriever mediaMetadataRetriever = null;
        try {
            try {
                file = new File(new URI(this.aVw.uri.toString()));
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
            cVar.aVM = file.getPath();
            if (TextUtils.isEmpty(cVar.aVM)) {
                c0193c.e(true, "can not find path");
                if (0 != 0) {
                    mediaMetadataRetriever.release();
                    return true;
                }
                return true;
            }
            cVar.size = file.length();
            MediaMetadataRetriever mediaMetadataRetriever2 = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever2.setDataSource(cVar.aVM);
                String extractMetadata = mediaMetadataRetriever2.extractMetadata(18);
                String extractMetadata2 = mediaMetadataRetriever2.extractMetadata(19);
                String extractMetadata3 = mediaMetadataRetriever2.extractMetadata(9);
                cVar.aVL = Long.parseLong(extractMetadata);
                cVar.aVK = Long.parseLong(extractMetadata2);
                cVar.duration = Long.parseLong(extractMetadata3);
                this.aVw.aVF = cVar;
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
