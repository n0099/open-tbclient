package com.baidu.swan.apps.media.chooser.d;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.baidu.android.util.media.MimeType;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.media.chooser.b.c;
import com.baidu.swan.apps.media.chooser.c.d;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class b extends a {
    private static final String[] cmE = {MimeType.Image.JPEG, MimeType.Image.PNG, "image/gif"};
    private String clG;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> cmD = new ArrayList<>();
    private ArrayList<MediaModel> clr = new ArrayList<>();

    public b(String str, d dVar) {
        this.cmB = this.cmD;
        this.clG = str;
        a(dVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Boolean doInBackground(Void... voidArr) {
        ajd();
        aje();
        p(this.cmD);
        com.baidu.swan.apps.media.chooser.model.a aVar = new com.baidu.swan.apps.media.chooser.model.a();
        aVar.lI(com.baidu.swan.apps.media.chooser.b.d.U(AppRuntime.getAppContext(), this.clG));
        aVar.cmz = this.clr;
        this.cmD.add(0, aVar);
        Iterator<com.baidu.swan.apps.media.chooser.model.a> it = this.cmD.iterator();
        while (it.hasNext()) {
            Collections.sort(it.next().aiU());
        }
        return true;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x00db */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    private void ajd() {
        Cursor cursor;
        if (!TextUtils.equals(this.clG, "video")) {
            ?? r1 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            ContentResolver contentResolver = AppRuntime.getAppContext().getContentResolver();
            StringBuilder sb = new StringBuilder();
            sb.append("mime_type").append("=?");
            sb.append(" or ");
            sb.append("mime_type").append("=?");
            String[] strArr = {cmE[0], cmE[1]};
            if (c.cmk) {
                sb.append(" or ");
                sb.append("mime_type").append("=?");
                strArr = cmE;
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
                                if (file.exists() && (c.cmk || !com.baidu.swan.apps.media.chooser.b.d.isGif(string))) {
                                    ImageModel imageModel = new ImageModel(string);
                                    imageModel.ba(j);
                                    imageModel.setSize(j2);
                                    a(file, imageModel);
                                }
                            } catch (Exception e) {
                                e = e;
                                if (c.DEBUG) {
                                    e.printStackTrace();
                                }
                                com.baidu.swan.e.d.closeSafely(cursor);
                                return;
                            }
                        }
                        com.baidu.swan.e.d.closeSafely(cursor);
                        return;
                    }
                    com.baidu.swan.e.d.closeSafely(cursor);
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.e.d.closeSafely(r1);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                r1 = 0;
                com.baidu.swan.e.d.closeSafely(r1);
                throw th;
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x00ab */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.baidu.swan.apps.media.chooser.d.b] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v2 */
    private void aje() {
        Cursor cursor;
        ?? r1 = "Image";
        try {
            if (!TextUtils.equals(this.clG, "Image")) {
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
                                    videoModel.ba(j);
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
                                com.baidu.swan.e.d.closeSafely(cursor);
                                return;
                            }
                        }
                        com.baidu.swan.e.d.closeSafely(cursor);
                        return;
                    }
                    com.baidu.swan.e.d.closeSafely(cursor);
                } catch (Exception e2) {
                    e = e2;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    r1 = 0;
                    com.baidu.swan.e.d.closeSafely(r1);
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
        aVar.lI(name);
        aVar.lJ(path);
        int indexOf = this.cmD.indexOf(aVar);
        if (indexOf >= 0) {
            this.cmD.get(indexOf).h(mediaModel);
        } else {
            aVar.h(mediaModel);
            this.cmD.add(aVar);
        }
        this.clr.add(mediaModel);
    }

    private void p(ArrayList<com.baidu.swan.apps.media.chooser.model.a> arrayList) {
        Iterator<com.baidu.swan.apps.media.chooser.model.a> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.media.chooser.model.a next = it.next();
            next.aZ(new File(next.aiZ()).lastModified());
        }
        Collections.sort(arrayList);
    }
}
