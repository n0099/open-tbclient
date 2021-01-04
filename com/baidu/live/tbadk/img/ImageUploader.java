package com.baidu.live.tbadk.img;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.baidu.live.adp.lib.safe.BdCloseHelper;
import com.baidu.live.adp.lib.util.Md5;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbImgSetting;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.ErrorData;
import com.baidu.live.tbadk.core.util.FileHelper;
import com.baidu.live.tbadk.core.util.NetWork;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedList;
/* loaded from: classes11.dex */
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
    private int chunkSize = IoUtils.DEFAULT_IMAGE_TOTAL_SIZE;
    private String groupId = "1";
    private NetWork mNetwork = null;

    /* loaded from: classes11.dex */
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
            errorData.setError_msg(TbadkCoreApplication.getInst().getString(a.h.sdk_upload_error));
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
                    errorData.setError_msg(TbadkCoreApplication.getInst().getString(a.h.sdk_upload_error));
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
    /* JADX DEBUG: Multi-variable search result rejected for r6v7, resolved type: int */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x035c, code lost:
        if (r24.isCancelled != false) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x035e, code lost:
        r20.append("|request cancelled.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0366, code lost:
        if (r6 != null) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0368, code lost:
        r4 = r6.error_code;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x036a, code lost:
        if (r6 != null) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x036c, code lost:
        r4 = r6.error_msg;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x036e, code lost:
        com.baidu.live.adp.lib.safe.BdCloseHelper.close(r8);
        r24.mNetwork = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0393, code lost:
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x03a5, code lost:
        r20.append("|startChunk=");
        r20.append(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x03b2, code lost:
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x040b, code lost:
        com.baidu.live.adp.lib.util.BdLog.e(r7.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0414, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0415, code lost:
        r6 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0418, code lost:
        r7.getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0439, code lost:
        r7 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x043a, code lost:
        r8 = r4;
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0444, code lost:
        r6 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:?, code lost:
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x017b, code lost:
        r20.append("|startChunk=");
        r20.append(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0188, code lost:
        r6 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x02dd, code lost:
        r20.append("|startChunk=");
        r20.append(r8);
        r20.append("|picNull=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x02f2, code lost:
        if (r12 != null) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x02f4, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x02f5, code lost:
        r20.append(r5);
        r20.append("|picErrNo=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0302, code lost:
        if (r12 == null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0304, code lost:
        r20.append(r12.error_code);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x030b, code lost:
        r6 = r12;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageUploadResult uploadInBackground(String str, boolean z, boolean z2) {
        Exception e;
        RandomAccessFile randomAccessFile;
        ImageUploadResult imageUploadResult;
        Throwable th;
        ImageUploadResult imageUploadResult2;
        RandomAccessFile randomAccessFile2;
        byte[] bArr;
        int i;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        if (options.outWidth == 0 || options.outHeight == 0) {
            return null;
        }
        ImageUploadResult imageUploadResult3 = null;
        StringBuilder sb = new StringBuilder();
        try {
            try {
                File file = new File(str);
                long length = file.length();
                long j = 0;
                int i2 = (length > ImageUploadStrategy.FILE_SIZE_5M ? 1 : (length == ImageUploadStrategy.FILE_SIZE_5M ? 0 : -1));
                try {
                    if (i2 > 0) {
                        ImageUploadResult imageUploadResult4 = new ImageUploadResult();
                        imageUploadResult4.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                        imageUploadResult4.error_msg = TbadkCoreApplication.getInst().getApp().getString(a.h.sdk_file_size_over);
                        BdCloseHelper.close((Closeable) null);
                        this.mNetwork = null;
                        return imageUploadResult4;
                    }
                    String md5 = Md5.toMd5(FileHelper.GetStreamFromFile(file));
                    sb.append("path=");
                    sb.append(str);
                    sb.append("|length=");
                    sb.append(length);
                    sb.append("|md5=");
                    sb.append(md5);
                    if (length == 0 || md5 == null) {
                        imageUploadResult2 = new ImageUploadResult();
                        imageUploadResult2.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                        imageUploadResult2.error_msg = TbadkCoreApplication.getInst().getApp().getString(a.h.sdk_file_not_exist);
                        TiebaInitialize.imgError(-1007, "file error: " + imageUploadResult2.error_msg, sb.toString());
                        randomAccessFile2 = null;
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
                                int i3 = 1;
                                int i4 = 0;
                                while (true) {
                                    ImageUploadResult imageUploadResult5 = imageUploadResult3;
                                    if (i3 > j2) {
                                        imageUploadResult2 = imageUploadResult5;
                                        break;
                                    }
                                    try {
                                        if (!this.isCancelled) {
                                            int i5 = 0;
                                            if (i3 > j2) {
                                                i5 = 0;
                                                bArr = null;
                                            } else {
                                                if (i3 < j2) {
                                                    i5 = this.chunkSize;
                                                } else if (i3 == j2) {
                                                    i5 = (int) (length - (this.chunkSize * (j2 - 1)));
                                                }
                                                if (bArr2 == null || bArr2.length != i5) {
                                                    bArr2 = new byte[i5];
                                                }
                                                randomAccessFile2.seek(this.chunkSize * (i3 - 1));
                                                randomAccessFile2.read(bArr2, 0, i5);
                                                bArr = bArr2;
                                            }
                                            this.mNetwork = new NetWork(TbConfig.UPLOAD_IMG_URL);
                                            this.mNetwork.addPostData("resourceId", str2);
                                            this.mNetwork.addPostData("chunkNo", String.valueOf(i3));
                                            if (i3 >= j2) {
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
                                            imageUploadResult3 = ImageUploadResult.parser(postMultiNetData);
                                            if (postMultiNetData == null || imageUploadResult3 == null) {
                                                break;
                                            }
                                            try {
                                                if (imageUploadResult3.error_code != 0 && imageUploadResult3.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                    break;
                                                }
                                                if (imageUploadResult3.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                    int i6 = i3 + 1;
                                                    j += i5;
                                                    long j3 = i6 > 1 ? j + ((i6 - 1) * this.chunkSize) : j;
                                                    if (this.progressCallback != null) {
                                                        this.progressCallback.onImageDataSentInBackground(str, this.progressObject, j3, length);
                                                    }
                                                    i = i6;
                                                } else if (i3 == imageUploadResult3.chunkNo || imageUploadResult3.chunkNo <= 0) {
                                                    break;
                                                } else {
                                                    i = imageUploadResult3.chunkNo;
                                                }
                                                int i7 = i4 + 1;
                                                if (i7 > 2 * j2) {
                                                    sb.append("|possbile dead loop found. tryCount=").append(i7).append(", chunkNo=").append(j2);
                                                    imageUploadResult2 = imageUploadResult3;
                                                    break;
                                                }
                                                i3 = i;
                                                i4 = i7;
                                                bArr2 = bArr;
                                            } catch (Exception e2) {
                                                e = e2;
                                                randomAccessFile = randomAccessFile2;
                                                imageUploadResult = imageUploadResult3;
                                            }
                                        } else {
                                            break;
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        randomAccessFile = randomAccessFile2;
                                        imageUploadResult = imageUploadResult5;
                                    }
                                }
                            } catch (Exception e4) {
                                e = e4;
                                randomAccessFile = randomAccessFile2;
                                imageUploadResult = null;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            randomAccessFile = randomAccessFile2;
                            BdCloseHelper.close(randomAccessFile);
                            this.mNetwork = null;
                            throw th;
                        }
                    }
                    BdCloseHelper.close(randomAccessFile2);
                    this.mNetwork = null;
                    return imageUploadResult2;
                } catch (Exception e5) {
                    e = e5;
                    randomAccessFile = null;
                    imageUploadResult = i2;
                }
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
            }
        } catch (Exception e6) {
            e = e6;
            randomAccessFile = null;
            imageUploadResult = null;
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
