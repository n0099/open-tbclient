package com.baidu.tbadk.album;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes6.dex */
public class f {
    private a ahO;
    private final Context mContext;
    private final String ahC = TbConfig.getTempDirName();
    private int ahP = 0;
    private String[] ahQ = {"bucket_id", "bucket_display_name", "_data", "mime_type", "date_added", "_size", "date_modified"};
    private String[] ahR = {"_id", "_data", "title", "mime_type", "_display_name", "duration", "datetaken", "date_modified", "date_added"};
    private String[] ahS = {"video_id", "_data", "width", "height"};
    private HashMap<String, com.baidu.tbadk.album.a> ahT = new HashMap<>();

    public f(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g uU() {
        this.ahT.clear();
        g gVar = new g();
        List<ImageFileInfo> imageList = getImageList();
        List<VideoFileInfo> list = null;
        if (this.ahP != 2) {
            list = uV();
        }
        ArrayList arrayList = new ArrayList();
        if (!v.J(imageList)) {
            arrayList.addAll(imageList);
        }
        if (!v.J(list)) {
            arrayList.addAll(list);
        }
        if (!v.J(arrayList)) {
            Collections.sort(arrayList, new Comparator<MediaFileInfo>() { // from class: com.baidu.tbadk.album.f.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(MediaFileInfo mediaFileInfo, MediaFileInfo mediaFileInfo2) {
                    long sortTime = mediaFileInfo2.getSortTime() - mediaFileInfo.getSortTime();
                    if (sortTime == 0) {
                        return 0;
                    }
                    return sortTime > 0 ? 1 : -1;
                }
            });
        }
        ArrayList arrayList2 = new ArrayList(this.ahT.values());
        if (!v.J(arrayList2)) {
            Collections.sort(arrayList2, new Comparator<com.baidu.tbadk.album.a>() { // from class: com.baidu.tbadk.album.f.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(com.baidu.tbadk.album.a aVar, com.baidu.tbadk.album.a aVar2) {
                    if (f.this.ahC.equals(aVar.getName())) {
                        return -1;
                    }
                    if (f.this.ahC.equals(aVar2.getName())) {
                        return 1;
                    }
                    long sortTime = aVar2.uO().getSortTime() - aVar.uO().getSortTime();
                    if (sortTime == 0) {
                        return 0;
                    }
                    return sortTime <= 0 ? -1 : 1;
                }
            });
        }
        gVar.ahW = arrayList2;
        gVar.ahY = list;
        gVar.ahX = arrayList;
        return gVar;
    }

    public List<ImageFileInfo> getImageList() {
        ArrayList arrayList = new ArrayList();
        List<ImageFileInfo> e = e(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        if (e != null) {
            arrayList.addAll(e);
        }
        List<ImageFileInfo> e2 = e(MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        if (e2 != null) {
            arrayList.addAll(e2);
        }
        return arrayList;
    }

    private List<ImageFileInfo> e(Uri uri) {
        com.baidu.tbadk.album.a aVar;
        Cursor cursor = null;
        if (this.mContext == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            cursor = this.mContext.getContentResolver().query(uri, this.ahQ, "mime_type like 'image/%'", null, "date_added DESC");
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            com.baidu.adp.lib.g.a.e(cursor);
        }
        if (cursor == null || !cursor.moveToFirst()) {
            return arrayList;
        }
        do {
            String string = cursor.getString(cursor.getColumnIndex("bucket_id"));
            String string2 = cursor.getString(cursor.getColumnIndex("bucket_display_name"));
            String string3 = cursor.getString(cursor.getColumnIndex("_data"));
            String string4 = cursor.getString(cursor.getColumnIndex("mime_type"));
            long j = cursor.getLong(cursor.getColumnIndex("date_added"));
            int i = cursor.getInt(cursor.getColumnIndex("_size"));
            long j2 = cursor.getLong(cursor.getColumnIndex("date_modified"));
            boolean endsWith = string4.endsWith("gif");
            if (!endsWith || i <= 3145728) {
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setAlbumnId(string);
                imageFileInfo.setFilePath(string3);
                imageFileInfo.setIsGif(endsWith);
                imageFileInfo.setModifyTime(ao.V(j2));
                imageFileInfo.setSortTime(j);
                arrayList.add(imageFileInfo);
                com.baidu.tbadk.album.a aVar2 = this.ahT.get(string);
                if (aVar2 == null) {
                    com.baidu.tbadk.album.a aVar3 = new com.baidu.tbadk.album.a();
                    this.ahT.put(string, aVar3);
                    aVar = aVar3;
                } else {
                    aVar = aVar2;
                }
                aVar.dn(string);
                aVar.setName(string2);
                aVar.uN();
                if (aVar.uO() == null) {
                    aVar.a(imageFileInfo);
                }
                List<MediaFileInfo> uQ = aVar.uQ();
                if (aVar.uQ() == null) {
                    uQ = new ArrayList<>();
                    aVar.y(uQ);
                }
                uQ.add(imageFileInfo);
            }
        } while (cursor.moveToNext());
        return arrayList;
    }

    private List<VideoFileInfo> uV() {
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        if (this.mContext == null) {
            return arrayList;
        }
        ContentResolver contentResolver = this.mContext.getContentResolver();
        HashSet hashSet = new HashSet();
        Cursor cursor2 = null;
        try {
            cursor = contentResolver.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, this.ahR, null, null, "date_added DESC");
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        do {
                            int i = cursor.getInt(cursor.getColumnIndex("_id"));
                            String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                            String string2 = cursor.getString(cursor.getColumnIndexOrThrow("title"));
                            String string3 = cursor.getString(cursor.getColumnIndexOrThrow("_display_name"));
                            String string4 = cursor.getString(cursor.getColumnIndexOrThrow("mime_type"));
                            int i2 = cursor.getInt(cursor.getColumnIndexOrThrow("duration"));
                            long j = cursor.getLong(cursor.getColumnIndexOrThrow("date_modified"));
                            long j2 = cursor.getLong(cursor.getColumnIndexOrThrow("date_added"));
                            if (!hashSet.contains(string)) {
                                hashSet.add(string);
                                File file = new File(string);
                                if (file != null && file.exists() && file.isFile() && com.baidu.adp.lib.util.f.n(file) > 0) {
                                    VideoFileInfo videoFileInfo = new VideoFileInfo();
                                    videoFileInfo.videoId = i;
                                    videoFileInfo.videoPath = string;
                                    videoFileInfo.displayName = string3;
                                    videoFileInfo.title = string2;
                                    videoFileInfo.mimeType = string4;
                                    videoFileInfo.videoDuration = i2;
                                    videoFileInfo.lastModified = j;
                                    videoFileInfo.setSortTime(j2);
                                    arrayList.add(videoFileInfo);
                                }
                            }
                        } while (cursor.moveToNext());
                    }
                } catch (Exception e) {
                    com.baidu.adp.lib.g.a.e(cursor);
                    return arrayList;
                } catch (Throwable th) {
                    cursor2 = cursor;
                    th = th;
                    com.baidu.adp.lib.g.a.e(cursor2);
                    throw th;
                }
            }
            com.baidu.adp.lib.g.a.e(cursor);
        } catch (Exception e2) {
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
        }
        return arrayList;
    }

    public boolean a(int i, e eVar) {
        if (eVar == null) {
            return false;
        }
        uW();
        this.ahP = i;
        this.ahO = new a(eVar);
        this.ahO.setPriority(3);
        this.ahO.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<Object, Integer, g> {
        private final e ahV;

        public a(e eVar) {
            this.ahV = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public g doInBackground(Object... objArr) {
            return f.this.uU();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.ahV != null) {
                this.ahV.onPreLoad();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(g gVar) {
            super.onPostExecute(gVar);
            if (this.ahV != null) {
                this.ahV.a(gVar);
            }
        }
    }

    public void uW() {
        if (this.ahO != null) {
            this.ahO.cancel();
            this.ahO = null;
        }
    }
}
