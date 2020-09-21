package com.baidu.swan.apps.media.chooser.d;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.baidu.android.util.media.MimeType;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.media.chooser.b.c;
import com.baidu.swan.apps.media.chooser.b.d;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a implements Runnable {
    private static final String[] cDk = {MimeType.Image.JPEG, MimeType.Image.PNG, "image/gif"};
    private String cwD;
    private Handler mHandler;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> cDj = new ArrayList<>();
    private ArrayList<MediaModel> cCd = new ArrayList<>();

    public a(String str, Handler handler) {
        this.cwD = str;
        this.mHandler = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        atW();
        atX();
        u(this.cDj);
        com.baidu.swan.apps.media.chooser.model.a aVar = new com.baidu.swan.apps.media.chooser.model.a();
        aVar.oK(d.aa(AppRuntime.getAppContext(), this.cwD));
        aVar.cDi = this.cCd;
        this.cDj.add(0, aVar);
        Iterator<com.baidu.swan.apps.media.chooser.model.a> it = this.cDj.iterator();
        while (it.hasNext()) {
            Collections.sort(it.next().atN());
        }
        if (this.mHandler != null) {
            Message obtainMessage = this.mHandler.obtainMessage(0);
            obtainMessage.obj = this.cDj;
            this.mHandler.sendMessage(obtainMessage);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x00db */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    private void atW() {
        Cursor cursor;
        if (!TextUtils.equals(this.cwD, "video")) {
            ?? r1 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            ContentResolver contentResolver = AppRuntime.getAppContext().getContentResolver();
            StringBuilder sb = new StringBuilder();
            sb.append("mime_type").append("=?");
            sb.append(" or ");
            sb.append("mime_type").append("=?");
            String[] strArr = {cDk[0], cDk[1]};
            if (c.cCT) {
                sb.append(" or ");
                sb.append("mime_type").append("=?");
                strArr = cDk;
            }
            try {
                try {
                    cursor = contentResolver.query(r1, null, sb.toString(), strArr, "date_added DESC");
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                String string = cursor.getString(cursor.getColumnIndex("_data"));
                                long j = cursor.getLong(cursor.getColumnIndexOrThrow("date_added"));
                                long j2 = cursor.getLong(cursor.getColumnIndexOrThrow("_size"));
                                File file = new File(string);
                                if (file.exists() && (c.cCT || !d.isGif(string))) {
                                    ImageModel imageModel = new ImageModel(string);
                                    imageModel.bk(j);
                                    imageModel.setSize(j2);
                                    a(file, imageModel);
                                }
                            } catch (Exception e) {
                                e = e;
                                if (c.DEBUG) {
                                    e.printStackTrace();
                                }
                                com.baidu.swan.c.d.closeSafely(cursor);
                                return;
                            }
                        }
                        com.baidu.swan.c.d.closeSafely(cursor);
                        return;
                    }
                    com.baidu.swan.c.d.closeSafely(cursor);
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.c.d.closeSafely(r1);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                r1 = 0;
                com.baidu.swan.c.d.closeSafely(r1);
                throw th;
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x00ab */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.baidu.swan.apps.media.chooser.d.a] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v2 */
    private void atX() {
        Cursor cursor;
        ?? r1 = "Image";
        try {
            if (!TextUtils.equals(this.cwD, "Image")) {
                try {
                    cursor = AppRuntime.getAppContext().getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, null, null, "date_added DESC");
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                                long j = cursor.getLong(cursor.getColumnIndexOrThrow("date_added"));
                                long j2 = cursor.getInt(cursor.getColumnIndexOrThrow("duration"));
                                long j3 = cursor.getLong(cursor.getColumnIndexOrThrow("_size"));
                                int i = cursor.getInt(cursor.getColumnIndexOrThrow("width"));
                                int i2 = cursor.getInt(cursor.getColumnIndexOrThrow("height"));
                                File file = new File(string);
                                if (file.exists()) {
                                    VideoModel videoModel = new VideoModel(string);
                                    videoModel.bk(j);
                                    videoModel.setDuration(j2);
                                    videoModel.setSize(j3);
                                    videoModel.setWidth(i);
                                    videoModel.setHeight(i2);
                                    a(file, videoModel);
                                }
                            } catch (Exception e) {
                                e = e;
                                if (c.DEBUG) {
                                    e.printStackTrace();
                                }
                                com.baidu.swan.c.d.closeSafely(cursor);
                                return;
                            }
                        }
                        com.baidu.swan.c.d.closeSafely(cursor);
                        return;
                    }
                    com.baidu.swan.c.d.closeSafely(cursor);
                } catch (Exception e2) {
                    e = e2;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    r1 = 0;
                    com.baidu.swan.c.d.closeSafely(r1);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void a(File file, MediaModel mediaModel) {
        String name;
        String path;
        if (file.getParentFile() != null) {
            name = file.getParentFile().getName();
            path = file.getParent();
        } else {
            name = file.getName();
            path = file.getPath();
        }
        com.baidu.swan.apps.media.chooser.model.a aVar = new com.baidu.swan.apps.media.chooser.model.a();
        aVar.oK(name);
        aVar.oL(path);
        int indexOf = this.cDj.indexOf(aVar);
        if (indexOf >= 0) {
            this.cDj.get(indexOf).h(mediaModel);
        } else {
            aVar.h(mediaModel);
            this.cDj.add(aVar);
        }
        this.cCd.add(mediaModel);
    }

    private void u(ArrayList<com.baidu.swan.apps.media.chooser.model.a> arrayList) {
        Iterator<com.baidu.swan.apps.media.chooser.model.a> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.media.chooser.model.a next = it.next();
            next.bj(new File(next.atS()).lastModified());
        }
        Collections.sort(arrayList);
    }
}
