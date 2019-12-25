package com.baidu.searchbox.ugc.upload;

import android.graphics.BitmapFactory;
import android.util.Log;
import com.baidu.android.util.media.MimeType;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ugc.utils.FileUtils;
import com.baidu.searchbox.ugc.utils.SelectUtil;
import com.baidubce.services.bos.model.ObjectMetadata;
import java.io.File;
/* loaded from: classes11.dex */
public class UploadImageTask extends UploadFileTask {
    private String imageType;
    private static String TAG = UploadImageTask.class.getSimpleName();
    public static final boolean DEBUG = AppConfig.isDebug();
    private static String CONTENT_TYPE = MimeType.Image.JPEG;
    private static String CONTENT_TYPE_GIF = "image/gif";

    public UploadImageTask(String str) {
        this.imageType = CONTENT_TYPE;
        setFileName(str);
        if (SelectUtil.supportGifLongImg) {
            if (SelectUtil.isGif(str)) {
                setCompressFileName(FileUtils.createTempFileName(FileUtils.getUploadCacheDir(), ".gif", str));
                this.imageType = CONTENT_TYPE_GIF;
            } else {
                setCompressFileName(FileUtils.createTempFileName(FileUtils.getUploadCacheDir(), ".jpg", str));
                this.imageType = CONTENT_TYPE;
            }
        } else {
            setCompressFileName(FileUtils.createTempFileName(FileUtils.getUploadCacheDir(), ".jpg", str));
            this.imageType = CONTENT_TYPE;
        }
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(this.imageType);
        setObjectMetadata(objectMetadata);
    }

    @Override // com.baidu.searchbox.ugc.upload.UploadFileTask
    public boolean handleCompress() {
        if (!isCompressSuccess()) {
            if (this.imageType == CONTENT_TYPE) {
                CompressImageUtil.compressImage(getFileName(), getCompressFileName());
                if (DEBUG) {
                    Log.e(TAG, "压缩完毕" + getFileName());
                }
            } else {
                CompressImageUtil.copyFile(getFileName(), getCompressFileName());
                if (DEBUG) {
                    Log.e(TAG, "copy完毕" + getFileName());
                }
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(getCompressFileName(), options);
            this.width = options.outWidth;
            this.height = options.outHeight;
            this.size = new File(getCompressFileName()).length();
            setCompressSuccess(true);
        }
        return true;
    }

    @Override // com.baidu.searchbox.ugc.upload.UploadFileTask, java.lang.Runnable
    public void run() {
        setStatus(2);
        if (this.mCallback != null) {
            this.mCallback.onStart(this);
        }
        boolean uploadFile = uploadFile(getCompressFileName());
        this.mStatus = uploadFile ? 4 : 5;
        notifySuccessOrFailed(uploadFile);
    }

    @Override // com.baidu.searchbox.ugc.upload.UploadFileTask
    public void stop() {
        super.stop();
    }
}
