package com.baidu.live.tbadk.album;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.safe.BdCloseHelper;
import com.baidu.live.adp.lib.util.BdFileHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.searchbox.picture.component.BaseBrowseView;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class MediaStoreLoader {
    public static final int LOEDER_TYPE_ALL = 0;
    public static final int LOEDER_TYPE_NOT_IMAGE = 1;
    public static final int LOEDER_TYPE_NOT_VIDEO = 2;
    private static final long MAX_GIF_FILE_SIZE = 3145728;
    private final Context mContext;
    private MediaLoadAsyncTask mMediaListLoadAsyncTask;
    private final String TIEBA = TbConfig.getTempDirName();
    private int mMediaLoaderType = 0;
    private String[] mAlbumColumns = {"bucket_id", "bucket_display_name", "_data", "mime_type", "date_added", "_size", "date_modified"};
    private String[] mVideoColumns = {IMConstants.MSG_ROW_ID, "_data", "title", "mime_type", "_display_name", "duration", "datetaken", "date_modified", "date_added"};
    private String[] mVideoThumbColumns = {"video_id", "_data", "width", "height"};
    private HashMap<String, AlbumData> mAlbumHashMap = new HashMap<>();

    public MediaStoreLoader(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ResutMediaStore getAllMediaList() {
        this.mAlbumHashMap.clear();
        ResutMediaStore resutMediaStore = new ResutMediaStore();
        List<ImageFileInfo> imageList = getImageList();
        List<VideoFileInfo> list = null;
        if (this.mMediaLoaderType != 2) {
            list = getVideoFileList();
        }
        ArrayList arrayList = new ArrayList();
        if (!ListUtils.isEmpty(imageList)) {
            arrayList.addAll(imageList);
        }
        if (!ListUtils.isEmpty(list)) {
            arrayList.addAll(list);
        }
        if (!ListUtils.isEmpty(arrayList)) {
            Collections.sort(arrayList, new Comparator<MediaFileInfo>() { // from class: com.baidu.live.tbadk.album.MediaStoreLoader.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
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
        if (!ListUtils.isEmpty(arrayList2)) {
            Collections.sort(arrayList2, new Comparator<AlbumData>() { // from class: com.baidu.live.tbadk.album.MediaStoreLoader.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                public int compare(AlbumData albumData, AlbumData albumData2) {
                    if (MediaStoreLoader.this.TIEBA.equals(albumData.getName())) {
                        return -1;
                    }
                    if (MediaStoreLoader.this.TIEBA.equals(albumData2.getName())) {
                        return 1;
                    }
                    long sortTime = albumData2.getLastFileInfo().getSortTime() - albumData.getLastFileInfo().getSortTime();
                    if (sortTime == 0) {
                        return 0;
                    }
                    return sortTime <= 0 ? -1 : 1;
                }
            });
        }
        resutMediaStore.albumList = arrayList2;
        resutMediaStore.videoFileList = list;
        resutMediaStore.allList = arrayList;
        return resutMediaStore;
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
        AlbumData albumData;
        Cursor cursor = null;
        if (this.mContext == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            cursor = this.mContext.getContentResolver().query(uri, this.mAlbumColumns, "mime_type like 'image/%'", null, "date_added DESC");
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            BdCloseHelper.close(cursor);
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
            boolean endsWith = string4.endsWith(BaseBrowseView.IMG_TYPE_GIF);
            if (!endsWith || i <= MAX_GIF_FILE_SIZE) {
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setAlbumnId(string);
                imageFileInfo.setFilePath(string3);
                imageFileInfo.setIsGif(endsWith);
                imageFileInfo.setModifyTime(StringHelper.getChineseFormatTimeString(j2));
                imageFileInfo.setSortTime(j);
                arrayList.add(imageFileInfo);
                AlbumData albumData2 = this.mAlbumHashMap.get(string);
                if (albumData2 == null) {
                    AlbumData albumData3 = new AlbumData();
                    this.mAlbumHashMap.put(string, albumData3);
                    albumData = albumData3;
                } else {
                    albumData = albumData2;
                }
                albumData.setAlbumId(string);
                albumData.setName(string2);
                albumData.addCount();
                if (albumData.getLastFileInfo() == null) {
                    albumData.setLastFileInfo(imageFileInfo);
                }
                List<MediaFileInfo> fileList = albumData.getFileList();
                if (albumData.getFileList() == null) {
                    fileList = new ArrayList<>();
                    albumData.setFileList(fileList);
                }
                fileList.add(imageFileInfo);
            }
        } while (cursor.moveToNext());
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
            cursor = contentResolver.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, this.mVideoColumns, null, null, "date_added DESC");
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        do {
                            int i = cursor.getInt(cursor.getColumnIndex(IMConstants.MSG_ROW_ID));
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
                                if (file != null && file.exists() && file.isFile() && BdFileHelper.getFileSize(file) > 0) {
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
                    BdCloseHelper.close(cursor);
                    return arrayList;
                } catch (Throwable th) {
                    cursor2 = cursor;
                    th = th;
                    BdCloseHelper.close(cursor2);
                    throw th;
                }
            }
            BdCloseHelper.close(cursor);
        } catch (Exception e2) {
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
        }
        return arrayList;
    }

    private void queryThumbnails(int i, VideoFileInfo videoFileInfo) {
        Cursor cursor;
        Cursor cursor2 = null;
        if (this.mContext != null) {
            try {
                cursor = this.mContext.getContentResolver().query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, this.mVideoThumbColumns, "video_id=" + i, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            videoFileInfo.thumbPath = cursor.getString(cursor.getColumnIndex("_data"));
                        }
                    } catch (Exception e) {
                        BdCloseHelper.close(cursor);
                        return;
                    } catch (Throwable th) {
                        cursor2 = cursor;
                        th = th;
                        BdCloseHelper.close(cursor2);
                        throw th;
                    }
                }
                BdCloseHelper.close(cursor);
            } catch (Exception e2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public boolean loadAll(int i, MediaStoreLoadCallback mediaStoreLoadCallback) {
        if (mediaStoreLoadCallback == null) {
            return false;
        }
        cancelLoadTask();
        this.mMediaLoaderType = i;
        this.mMediaListLoadAsyncTask = new MediaLoadAsyncTask(mediaStoreLoadCallback);
        this.mMediaListLoadAsyncTask.setPriority(3);
        this.mMediaListLoadAsyncTask.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class MediaLoadAsyncTask extends BdAsyncTask<Object, Integer, ResutMediaStore> {
        private final MediaStoreLoadCallback mCallBack;

        public MediaLoadAsyncTask(MediaStoreLoadCallback mediaStoreLoadCallback) {
            this.mCallBack = mediaStoreLoadCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public ResutMediaStore doInBackground(Object... objArr) {
            return MediaStoreLoader.this.getAllMediaList();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.mCallBack != null) {
                this.mCallBack.onPreLoad();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPostExecute(ResutMediaStore resutMediaStore) {
            super.onPostExecute((MediaLoadAsyncTask) resutMediaStore);
            if (this.mCallBack != null) {
                this.mCallBack.onPostLoad(resutMediaStore);
            }
        }
    }

    public void cancelLoadTask() {
        if (this.mMediaListLoadAsyncTask != null) {
            this.mMediaListLoadAsyncTask.cancel();
            this.mMediaListLoadAsyncTask = null;
        }
    }
}
