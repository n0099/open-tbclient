package com.baidu.live.tbadk.img;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.baidu.live.adp.lib.safe.BdCloseHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.Md5;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbImgSetting;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.ErrorData;
import com.baidu.live.tbadk.core.util.FileHelper;
import com.baidu.live.tbadk.core.util.NetWork;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.u.a;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class ImageUploader {
    private int bigHeight;
    private int bigWidth;
    private String from;
    private boolean isCancelled;
    private ImageUploadStrategy mUploadStrategy;
    private ImageUploadProgressCallback progressCallback;
    private Object progressObject;
    private int smallHeight;
    private int smallWidth;
    private int chunkSize = 512000;
    private String groupId = "1";
    private NetWork mNetwork = null;

    /* loaded from: classes3.dex */
    public interface ImageUploadProgressCallback {
        void onImageDataSentInBackground(String str, Object obj, long j, long j2);
    }

    public ImageUploader(String str) {
        this.from = str;
    }

    public void setServersideResize(int i, int i2, int i3, int i4) {
        this.bigWidth = i;
        this.bigHeight = i2;
        this.smallWidth = i3;
        this.smallHeight = i4;
    }

    public void setImageUploadProgressCallback(ImageUploadProgressCallback imageUploadProgressCallback, Object obj) {
        this.progressCallback = imageUploadProgressCallback;
        this.progressObject = obj;
        if (imageUploadProgressCallback != null) {
            this.chunkSize = 10240;
        }
    }

    public void cancel() {
        this.isCancelled = true;
        if (this.mNetwork != null) {
            this.mNetwork.cancelNetConnect();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0065, code lost:
        r2.setError_code(-53);
        r2.setError_msg(r4.error_msg);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ErrorData uploadMustAllSuccInBackground(WriteImagesInfo writeImagesInfo, boolean z) {
        ErrorData errorData = new ErrorData();
        if (writeImagesInfo == null || writeImagesInfo.size() == 0) {
            errorData.setError_code(-53);
            errorData.setError_msg(TbadkCoreApplication.getInst().getString(a.i.sdk_upload_error));
            return errorData;
        }
        LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= chosedFiles.size()) {
                break;
            }
            ImageFileInfo imageFileInfo = chosedFiles.get(i2);
            if (!imageFileInfo.isAlreadyUploadedToServer()) {
                if (this.isCancelled) {
                    break;
                }
                ImageUploadResult uploadInBackground = uploadInBackground(imageFileInfo, writeImagesInfo.isOriginalImg(), z);
                if (uploadInBackground != null) {
                    UploadedImageInfo uploadedPicInfo = uploadInBackground.getUploadedPicInfo();
                    if (uploadedPicInfo == null || TextUtils.isEmpty(uploadedPicInfo.toPostString())) {
                        break;
                    }
                    imageFileInfo.setServerImageCode(uploadedPicInfo.toPostString());
                } else {
                    errorData.setError_code(-53);
                    errorData.setError_msg(TbadkCoreApplication.getInst().getString(a.i.sdk_upload_error));
                    return errorData;
                }
            }
            i = i2 + 1;
        }
        return null;
    }

    public void uploadInBackgroundIgnoreAlreadyUploaded(WriteImagesInfo writeImagesInfo, boolean z) {
        UploadedImageInfo uploadedPicInfo;
        if (writeImagesInfo != null && writeImagesInfo.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
            for (int i = 0; i < chosedFiles.size(); i++) {
                ImageFileInfo imageFileInfo = chosedFiles.get(i);
                if (imageFileInfo != null && !imageFileInfo.isAlreadyUploadedToServer()) {
                    if (!this.isCancelled) {
                        ImageUploadResult uploadInBackground = uploadInBackground(imageFileInfo, writeImagesInfo.isOriginalImg() || imageFileInfo.isGif(), z);
                        if (uploadInBackground != null && (uploadedPicInfo = uploadInBackground.getUploadedPicInfo()) != null) {
                            imageFileInfo.setServerImageCode(uploadedPicInfo.toPostString());
                            imageFileInfo.serverPicInfo = uploadInBackground.picInfo;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public ImageUploadResult uploadInBackground(ImageFileInfo imageFileInfo, boolean z, boolean z2) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.mUploadStrategy == null) {
            this.mUploadStrategy = new ImageUploadStrategy();
        }
        return uploadInBackground(this.mUploadStrategy.getUploadFilePathByStrategy(imageFileInfo, z), z, z2);
    }

    public ImageUploadResult uploadInBackground(ImageFileInfo imageFileInfo, boolean z) {
        return uploadInBackground(imageFileInfo, false, z);
    }

    public ImageUploadResult uploadInBackground(String str, boolean z) {
        return uploadInBackground(str, false, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [426=6, 427=4] */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x03af, code lost:
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x03b0, code lost:
        r20.append("|startChunk=");
        r20.append(r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageUploadResult uploadInBackground(String str, boolean z, boolean z2) {
        RandomAccessFile randomAccessFile;
        ImageUploadResult imageUploadResult;
        RandomAccessFile randomAccessFile2;
        int i;
        byte[] bArr;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        if (options.outWidth == 0 || options.outHeight == 0) {
            return null;
        }
        ImageUploadResult imageUploadResult2 = null;
        RandomAccessFile randomAccessFile3 = null;
        StringBuilder sb = new StringBuilder();
        try {
            try {
                File file = new File(str);
                long length = file.length();
                long j = 0;
                if (length <= ImageUploadStrategy.FILE_SIZE_5M) {
                    String md5 = Md5.toMd5(FileHelper.GetStreamFromFile(file));
                    sb.append("path=");
                    sb.append(str);
                    sb.append("|length=");
                    sb.append(length);
                    sb.append("|md5=");
                    sb.append(md5);
                    if (length == 0 || md5 == null) {
                        ImageUploadResult imageUploadResult3 = new ImageUploadResult();
                        try {
                            imageUploadResult3.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                            imageUploadResult3.error_msg = TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_file_not_exist);
                            TiebaInitialize.imgError(-1007, "file error: " + imageUploadResult3.error_msg, sb.toString());
                            imageUploadResult = imageUploadResult3;
                            randomAccessFile2 = null;
                        } catch (Exception e) {
                            randomAccessFile = null;
                            imageUploadResult = imageUploadResult3;
                            e = e;
                        }
                    } else {
                        String str2 = md5 + this.chunkSize;
                        long j2 = length % ((long) this.chunkSize) == 0 ? length / this.chunkSize : (length / this.chunkSize) + 1;
                        sb.append("|chunkNo=");
                        sb.append(j2);
                        randomAccessFile2 = new RandomAccessFile(str, "r");
                        byte[] bArr2 = null;
                        try {
                            try {
                                sb.append("|width=");
                                sb.append(this.bigWidth);
                                sb.append("|height=");
                                sb.append(this.bigHeight);
                                sb.append("|smallWidth=");
                                sb.append(this.smallWidth);
                                sb.append("|smallHeight=");
                                sb.append(this.smallHeight);
                                sb.append("|groupId=");
                                sb.append(this.groupId);
                                int i2 = 1;
                                int i3 = 0;
                                while (true) {
                                    long j3 = j;
                                    i = i2;
                                    imageUploadResult = imageUploadResult2;
                                    if (i > j2) {
                                        break;
                                    }
                                    try {
                                        if (!this.isCancelled) {
                                            int i4 = 0;
                                            if (i > j2) {
                                                i4 = 0;
                                                bArr = null;
                                            } else {
                                                if (i < j2) {
                                                    i4 = this.chunkSize;
                                                } else if (i == j2) {
                                                    i4 = (int) (length - (this.chunkSize * (j2 - 1)));
                                                }
                                                if (bArr2 == null || bArr2.length != i4) {
                                                    bArr2 = new byte[i4];
                                                }
                                                randomAccessFile2.seek(this.chunkSize * (i - 1));
                                                randomAccessFile2.read(bArr2, 0, i4);
                                                bArr = bArr2;
                                            }
                                            this.mNetwork = new NetWork(TbConfig.UPLOAD_IMG_URL);
                                            this.mNetwork.addPostData("resourceId", str2);
                                            this.mNetwork.addPostData("chunkNo", String.valueOf(i));
                                            if (i >= j2) {
                                                this.mNetwork.addPostData("isFinish", String.valueOf(1));
                                            } else {
                                                this.mNetwork.addPostData("isFinish", String.valueOf(0));
                                            }
                                            if (this.bigWidth > 0 && this.bigHeight > 0) {
                                                this.mNetwork.addPostData("width", String.valueOf(this.bigWidth));
                                                this.mNetwork.addPostData("height", String.valueOf(this.bigHeight));
                                            }
                                            if (this.smallWidth > 0 && this.smallHeight > 0) {
                                                this.mNetwork.addPostData("smallWidth", String.valueOf(this.smallWidth));
                                                this.mNetwork.addPostData("smallHeight", String.valueOf(this.smallHeight));
                                            }
                                            this.mNetwork.addPostData(TbEnum.SystemMessage.KEY_GROUP_ID, String.valueOf(this.groupId));
                                            this.mNetwork.addPostData("alt", "json");
                                            if (bArr != null) {
                                                this.mNetwork.addPostData("chunk", bArr);
                                            }
                                            if (z) {
                                                this.mNetwork.addPostData("saveOrigin", "1");
                                            } else {
                                                this.mNetwork.addPostData("saveOrigin", "0");
                                            }
                                            if (z2) {
                                                int imageWaterType = TbImgSetting.getInstance().getImageWaterType();
                                                if (imageWaterType != 0) {
                                                    this.mNetwork.addPostData("pic_water_type", String.valueOf(imageWaterType));
                                                }
                                                String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
                                                if (!StringUtils.isNull(currentAccountName) && imageWaterType == 1) {
                                                    this.mNetwork.addPostData("user_name", currentAccountName);
                                                }
                                                String forumNameForWaterImage = TbImgSetting.getInstance().getForumNameForWaterImage();
                                                if (!StringUtils.isNull(forumNameForWaterImage) && imageWaterType == 2) {
                                                    this.mNetwork.addPostData("forum_name", forumNameForWaterImage);
                                                }
                                            }
                                            String postMultiNetData = this.mNetwork.postMultiNetData();
                                            imageUploadResult2 = ImageUploadResult.parser(postMultiNetData);
                                            if (postMultiNetData == null || imageUploadResult2 == null) {
                                                break;
                                            }
                                            try {
                                                if (imageUploadResult2.error_code != 0 && imageUploadResult2.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                    break;
                                                }
                                                if (imageUploadResult2.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                    int i5 = i + 1;
                                                    long j4 = j3 + i4;
                                                    long j5 = i5 > 1 ? j4 + ((i5 - 1) * this.chunkSize) : j4;
                                                    if (this.progressCallback != null) {
                                                        this.progressCallback.onImageDataSentInBackground(str, this.progressObject, j5, length);
                                                    }
                                                    i2 = i5;
                                                    j = j4;
                                                } else if (i == imageUploadResult2.chunkNo || imageUploadResult2.chunkNo <= 0) {
                                                    break;
                                                } else {
                                                    i2 = imageUploadResult2.chunkNo;
                                                    j = j3;
                                                }
                                                int i6 = i3 + 1;
                                                if (i6 > 2 * j2) {
                                                    sb.append("|possbile dead loop found. tryCount=").append(i6).append(", chunkNo=").append(j2);
                                                    imageUploadResult = imageUploadResult2;
                                                    break;
                                                }
                                                i3 = i6;
                                                bArr2 = bArr;
                                            } catch (Exception e2) {
                                                randomAccessFile = randomAccessFile2;
                                                e = e2;
                                                imageUploadResult = imageUploadResult2;
                                            }
                                        } else {
                                            sb.append("|startChunk=");
                                            sb.append(i);
                                            break;
                                        }
                                    } catch (Exception e3) {
                                        randomAccessFile = randomAccessFile2;
                                        e = e3;
                                    }
                                }
                                sb.append("|startChunk=");
                                sb.append(i);
                                sb.append("|picNull=");
                                sb.append(imageUploadResult2 == null);
                                sb.append("|picErrNo=");
                                if (imageUploadResult2 != null) {
                                    sb.append(imageUploadResult2.error_code);
                                    imageUploadResult = imageUploadResult2;
                                } else {
                                    imageUploadResult = imageUploadResult2;
                                }
                            } catch (Throwable th) {
                                randomAccessFile3 = randomAccessFile2;
                                th = th;
                                BdCloseHelper.close(randomAccessFile3);
                                this.mNetwork = null;
                                throw th;
                            }
                        } catch (Exception e4) {
                            randomAccessFile = randomAccessFile2;
                            e = e4;
                            imageUploadResult = null;
                        }
                    }
                    BdCloseHelper.close(randomAccessFile2);
                    this.mNetwork = null;
                    return imageUploadResult;
                }
                ImageUploadResult imageUploadResult4 = new ImageUploadResult();
                try {
                    imageUploadResult4.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                    imageUploadResult4.error_msg = TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_file_size_over);
                    BdCloseHelper.close((Closeable) null);
                    this.mNetwork = null;
                    return imageUploadResult4;
                } catch (Exception e5) {
                    randomAccessFile = null;
                    imageUploadResult = imageUploadResult4;
                    e = e5;
                }
            } catch (Exception e6) {
                e = e6;
                randomAccessFile = null;
                imageUploadResult = null;
            }
            try {
                if (this.isCancelled) {
                    sb.append("|request cancelled.");
                } else {
                    BdLog.e(e.getMessage());
                }
                if (imageUploadResult != null) {
                    int i7 = imageUploadResult.error_code;
                }
                if (imageUploadResult != null) {
                    String str3 = imageUploadResult.error_msg;
                } else {
                    e.getMessage();
                }
                BdCloseHelper.close(randomAccessFile);
                this.mNetwork = null;
                return imageUploadResult;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile3 = randomAccessFile;
                BdCloseHelper.close(randomAccessFile3);
                this.mNetwork = null;
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public int getBigWidth() {
        return this.bigWidth;
    }

    public void setBigWidth(int i) {
        this.bigWidth = i;
    }

    public int getBigHeight() {
        return this.bigHeight;
    }

    public void setBigHeight(int i) {
        this.bigHeight = i;
    }

    public int getSmallWidth() {
        return this.smallWidth;
    }

    public void setSmallWidth(int i) {
        this.smallWidth = i;
    }

    public int getSmallHeight() {
        return this.smallHeight;
    }

    public void setSmallHeight(int i) {
        this.smallHeight = i;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }
}
