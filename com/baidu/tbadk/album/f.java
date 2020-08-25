package com.baidu.tbadk.album;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.img.ImageFileInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes15.dex */
public class f {
    private a dRO;
    private final Context mContext;
    private final String TIEBA = TbConfig.getTempDirName();
    private int mMediaLoaderType = 0;
    private String[] mAlbumColumns = {IMConstants.MSG_ROW_ID, "bucket_id", "bucket_display_name", "_data", "mime_type", "date_added", "_size", "date_modified"};
    private String[] mVideoColumns = {IMConstants.MSG_ROW_ID, "_data", "title", "mime_type", "_display_name", "duration", "datetaken", "date_modified", "date_added"};
    private String[] mVideoThumbColumns = {"video_id", "_data", "width", "height"};
    private HashMap<String, com.baidu.tbadk.album.a> mAlbumHashMap = new HashMap<>();

    public f(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g bax() {
        this.mAlbumHashMap.clear();
        g gVar = new g();
        List<ImageFileInfo> imageList = getImageList();
        List<VideoFileInfo> list = null;
        if (this.mMediaLoaderType != 2) {
            list = getVideoFileList();
        }
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(imageList)) {
            arrayList.addAll(imageList);
        }
        if (!y.isEmpty(list)) {
            arrayList.addAll(list);
        }
        if (!y.isEmpty(arrayList)) {
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
        ArrayList arrayList2 = new ArrayList(this.mAlbumHashMap.values());
        if (!y.isEmpty(arrayList2)) {
            Collections.sort(arrayList2, new Comparator<com.baidu.tbadk.album.a>() { // from class: com.baidu.tbadk.album.f.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(com.baidu.tbadk.album.a aVar, com.baidu.tbadk.album.a aVar2) {
                    if (f.this.TIEBA.equals(aVar.getName())) {
                        return -1;
                    }
                    if (f.this.TIEBA.equals(aVar2.getName())) {
                        return 1;
                    }
                    long sortTime = aVar2.bas().getSortTime() - aVar.bas().getSortTime();
                    if (sortTime == 0) {
                        return 0;
                    }
                    return sortTime <= 0 ? -1 : 1;
                }
            });
        }
        gVar.albumList = arrayList2;
        gVar.videoFileList = list;
        gVar.allList = arrayList;
        return gVar;
    }

    public List<ImageFileInfo> getImageList() {
        ArrayList arrayList = new ArrayList();
        List<ImageFileInfo> imageListByUri = getImageListByUri(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        if (imageListByUri != null) {
            arrayList.addAll(imageListByUri);
        }
        List<ImageFileInfo> imageListByUri2 = getImageListByUri(MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        if (imageListByUri2 != null) {
            arrayList.addAll(imageListByUri2);
        }
        return arrayList;
    }

    private List<ImageFileInfo> getImageListByUri(Uri uri) {
        Cursor cursor;
        com.baidu.tbadk.album.a aVar;
        if (this.mContext == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            cursor = this.mContext.getContentResolver().query(uri, this.mAlbumColumns, "mime_type like 'image/%'", null, "date_added DESC");
            if (cursor != null) {
                try {
                    try {
                        if (cursor.moveToFirst()) {
                            do {
                                Uri withAppendedId = ContentUris.withAppendedId(uri, cursor.getLong(cursor.getColumnIndex(IMConstants.MSG_ROW_ID)));
                                String str = null;
                                if (withAppendedId != null) {
                                    str = withAppendedId.toString();
                                }
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
                                    imageFileInfo.setContentUriStr(str);
                                    imageFileInfo.setFilePath(string3);
                                    imageFileInfo.setIsGif(endsWith);
                                    imageFileInfo.setModifyTime(at.getChineseFormatTimeString(j2));
                                    imageFileInfo.setSortTime(j);
                                    arrayList.add(imageFileInfo);
                                    com.baidu.tbadk.album.a aVar2 = this.mAlbumHashMap.get(string);
                                    if (aVar2 == null) {
                                        com.baidu.tbadk.album.a aVar3 = new com.baidu.tbadk.album.a();
                                        this.mAlbumHashMap.put(string, aVar3);
                                        aVar = aVar3;
                                    } else {
                                        aVar = aVar2;
                                    }
                                    aVar.setAlbumId(string);
                                    aVar.setName(string2);
                                    aVar.addCount();
                                    if (aVar.bas() == null) {
                                        aVar.a(imageFileInfo);
                                    }
                                    List<MediaFileInfo> fileList = aVar.getFileList();
                                    if (aVar.getFileList() == null) {
                                        fileList = new ArrayList<>();
                                        aVar.setFileList(fileList);
                                    }
                                    fileList.add(imageFileInfo);
                                }
                            } while (cursor.moveToNext());
                        }
                    } catch (Exception e) {
                        e = e;
                        BdLog.detailException(e);
                        com.baidu.adp.lib.f.a.close(cursor);
                        return arrayList;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.f.a.close(cursor);
                    throw th;
                }
            }
            com.baidu.adp.lib.f.a.close(cursor);
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            com.baidu.adp.lib.f.a.close(cursor);
            throw th;
        }
        return arrayList;
    }

    private List<VideoFileInfo> getVideoFileList() {
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        if (this.mContext == null) {
            return arrayList;
        }
        ContentResolver contentResolver = this.mContext.getContentResolver();
        HashSet hashSet = new HashSet();
        Cursor cursor2 = null;
        try {
            Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            cursor = contentResolver.query(uri, this.mVideoColumns, null, null, "date_added DESC");
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        do {
                            int i = cursor.getInt(cursor.getColumnIndex(IMConstants.MSG_ROW_ID));
                            Uri withAppendedId = ContentUris.withAppendedId(uri, i);
                            String str = null;
                            if (withAppendedId != null) {
                                str = withAppendedId.toString();
                            }
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
                                if (file != null && file.exists() && file.isFile() && com.baidu.adp.lib.util.f.getFileSize(file) > 0) {
                                    VideoFileInfo videoFileInfo = new VideoFileInfo();
                                    videoFileInfo.videoId = i;
                                    videoFileInfo.contentUriStr = str;
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
                    com.baidu.adp.lib.f.a.close(cursor);
                    return arrayList;
                } catch (Throwable th) {
                    cursor2 = cursor;
                    th = th;
                    com.baidu.adp.lib.f.a.close(cursor2);
                    throw th;
                }
            }
            com.baidu.adp.lib.f.a.close(cursor);
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
        cancelLoadTask();
        this.mMediaLoaderType = i;
        this.dRO = new a(eVar);
        this.dRO.setPriority(3);
        this.dRO.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a extends BdAsyncTask<Object, Integer, g> {
        private final e dRQ;

        public a(e eVar) {
            this.dRQ = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public g doInBackground(Object... objArr) {
            return f.this.bax();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.dRQ != null) {
                this.dRQ.onPreLoad();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(g gVar) {
            super.onPostExecute(gVar);
            if (this.dRQ != null) {
                this.dRQ.a(gVar);
            }
        }
    }

    public void cancelLoadTask() {
        if (this.dRO != null) {
            this.dRO.cancel();
            this.dRO = null;
        }
    }
}
