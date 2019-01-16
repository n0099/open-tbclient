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
    private a amx;
    private final Context mContext;
    private final String aml = TbConfig.getTempDirName();
    private int amy = 0;
    private String[] amz = {"bucket_id", "bucket_display_name", "_data", "mime_type", "date_added", "_size", "date_modified"};
    private String[] amA = {"_id", "_data", "title", "mime_type", "_display_name", "duration", "datetaken", "date_modified", "date_added"};
    private String[] amB = {"video_id", "_data", "width", "height"};
    private HashMap<String, com.baidu.tbadk.album.a> amC = new HashMap<>();

    public f(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g wp() {
        this.amC.clear();
        g gVar = new g();
        List<ImageFileInfo> imageList = getImageList();
        List<VideoFileInfo> list = null;
        if (this.amy != 2) {
            list = wq();
        }
        ArrayList arrayList = new ArrayList();
        if (!v.I(imageList)) {
            arrayList.addAll(imageList);
        }
        if (!v.I(list)) {
            arrayList.addAll(list);
        }
        if (!v.I(arrayList)) {
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
        ArrayList arrayList2 = new ArrayList(this.amC.values());
        if (!v.I(arrayList2)) {
            Collections.sort(arrayList2, new Comparator<com.baidu.tbadk.album.a>() { // from class: com.baidu.tbadk.album.f.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(com.baidu.tbadk.album.a aVar, com.baidu.tbadk.album.a aVar2) {
                    if (f.this.aml.equals(aVar.getName())) {
                        return -1;
                    }
                    if (f.this.aml.equals(aVar2.getName())) {
                        return 1;
                    }
                    long sortTime = aVar2.wj().getSortTime() - aVar.wj().getSortTime();
                    if (sortTime == 0) {
                        return 0;
                    }
                    return sortTime <= 0 ? -1 : 1;
                }
            });
        }
        gVar.amF = arrayList2;
        gVar.amH = list;
        gVar.amG = arrayList;
        return gVar;
    }

    public List<ImageFileInfo> getImageList() {
        ArrayList arrayList = new ArrayList();
        List<ImageFileInfo> f = f(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        if (f != null) {
            arrayList.addAll(f);
        }
        List<ImageFileInfo> f2 = f(MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        if (f2 != null) {
            arrayList.addAll(f2);
        }
        return arrayList;
    }

    private List<ImageFileInfo> f(Uri uri) {
        com.baidu.tbadk.album.a aVar;
        Cursor cursor = null;
        if (this.mContext == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            cursor = this.mContext.getContentResolver().query(uri, this.amz, "mime_type like 'image/%'", null, "date_added DESC");
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
                imageFileInfo.setModifyTime(ao.af(j2));
                imageFileInfo.setSortTime(j);
                arrayList.add(imageFileInfo);
                com.baidu.tbadk.album.a aVar2 = this.amC.get(string);
                if (aVar2 == null) {
                    com.baidu.tbadk.album.a aVar3 = new com.baidu.tbadk.album.a();
                    this.amC.put(string, aVar3);
                    aVar = aVar3;
                } else {
                    aVar = aVar2;
                }
                aVar.dE(string);
                aVar.setName(string2);
                aVar.wi();
                if (aVar.wj() == null) {
                    aVar.a(imageFileInfo);
                }
                List<MediaFileInfo> wl = aVar.wl();
                if (aVar.wl() == null) {
                    wl = new ArrayList<>();
                    aVar.x(wl);
                }
                wl.add(imageFileInfo);
            }
        } while (cursor.moveToNext());
        return arrayList;
    }

    private List<VideoFileInfo> wq() {
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        if (this.mContext == null) {
            return arrayList;
        }
        ContentResolver contentResolver = this.mContext.getContentResolver();
        HashSet hashSet = new HashSet();
        Cursor cursor2 = null;
        try {
            cursor = contentResolver.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, this.amA, null, null, "date_added DESC");
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
        wr();
        this.amy = i;
        this.amx = new a(eVar);
        this.amx.setPriority(3);
        this.amx.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<Object, Integer, g> {
        private final e amE;

        public a(e eVar) {
            this.amE = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public g doInBackground(Object... objArr) {
            return f.this.wp();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.amE != null) {
                this.amE.onPreLoad();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(g gVar) {
            super.onPostExecute(gVar);
            if (this.amE != null) {
                this.amE.a(gVar);
            }
        }
    }

    public void wr() {
        if (this.amx != null) {
            this.amx.cancel();
            this.amx = null;
        }
    }
}
