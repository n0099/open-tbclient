package com.baidu.live.tbadk.img;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.live.adp.widget.imageview.BdImage;
import com.baidu.live.tbadk.core.util.BitmapHelper;
import com.baidu.live.tbadk.core.util.FileHelper;
import com.baidu.live.tbadk.img.effect.ImageOperation;
import java.util.LinkedList;
/* loaded from: classes10.dex */
public class ImageUploadStrategy {
    public static final long FILE_SIZE_10M = 10485760;
    public static final long FILE_SIZE_4M = 4194304;
    public static final long FILE_SIZE_5M = 5242880;
    public static final long FILE_SIZE_7M = 7340032;
    private AsyncLocalImageLoader localImageLoader;
    private IImageUploadStrategy mNormalNotLongImageStrategy = new IImageUploadStrategy() { // from class: com.baidu.live.tbadk.img.ImageUploadStrategy.1
        @Override // com.baidu.live.tbadk.img.IImageUploadStrategy
        public String getUploadFilePathByStrategy(ImageFileInfo imageFileInfo) {
            String str = null;
            if (imageFileInfo != null) {
                if (ImageUploadStrategy.this.localImageLoader == null) {
                    ImageUploadStrategy.this.localImageLoader = new AsyncLocalImageLoader();
                }
                String filePath = imageFileInfo.getFilePath();
                LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
                imageFileInfo.setPageActionsList(null);
                BdImage image = ImageUploadStrategy.this.localImageLoader.getImage(imageFileInfo, true);
                if (image == null) {
                    Bitmap loadImageAndApplyEffects = ImageUploadStrategy.this.localImageLoader.loadImageAndApplyEffects(imageFileInfo, true);
                    int readPictureDegree = BitmapHelper.readPictureDegree(filePath);
                    if (readPictureDegree != 0 && loadImageAndApplyEffects != null) {
                        loadImageAndApplyEffects = BitmapHelper.rotateBitmapBydegree(loadImageAndApplyEffects, readPictureDegree);
                    }
                    str = ImageUploadStrategy.this.saveTempUploadFile(loadImageAndApplyEffects, 85);
                } else {
                    str = ImageUploadStrategy.this.saveTempUploadFile(image.getRawBitmap(), 85);
                }
                imageFileInfo.setPageActionsList(pageActionsList);
            }
            return str;
        }
    };
    private IImageUploadStrategy mOriginalNotLongImageStrategy = new IImageUploadStrategy() { // from class: com.baidu.live.tbadk.img.ImageUploadStrategy.2
        @Override // com.baidu.live.tbadk.img.IImageUploadStrategy
        public String getUploadFilePathByStrategy(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return null;
            }
            return ImageUploadStrategy.this.compressOriginalImageFile(imageFileInfo.getFilePath());
        }
    };
    private IImageUploadStrategy mOriginalLongImageStrategy = this.mOriginalNotLongImageStrategy;
    private IImageUploadStrategy mNormalLongImageStrategy = new IImageUploadStrategy() { // from class: com.baidu.live.tbadk.img.ImageUploadStrategy.3
        @Override // com.baidu.live.tbadk.img.IImageUploadStrategy
        public String getUploadFilePathByStrategy(ImageFileInfo imageFileInfo) {
            if (imageFileInfo == null) {
                return null;
            }
            return ImageUploadStrategy.this.saveTempUploadFile(ImageUploadStrategy.this.getUploadFileBitmap(imageFileInfo.getFilePath()), 85);
        }
    };

    public String getUploadFilePathByStrategy(ImageFileInfo imageFileInfo, boolean z) {
        IImageUploadStrategy iImageUploadStrategy;
        if (imageFileInfo == null) {
            return null;
        }
        boolean checkIsLongImage = FileHelper.checkIsLongImage(imageFileInfo.getFilePath());
        if (imageFileInfo.isGif() || (z && !imageFileInfo.hasActionsWithoutResize())) {
            if (checkIsLongImage) {
                iImageUploadStrategy = this.mOriginalLongImageStrategy;
            } else {
                iImageUploadStrategy = this.mOriginalNotLongImageStrategy;
            }
        } else if (checkIsLongImage) {
            iImageUploadStrategy = this.mNormalLongImageStrategy;
        } else {
            iImageUploadStrategy = this.mNormalNotLongImageStrategy;
        }
        return iImageUploadStrategy.getUploadFilePathByStrategy(imageFileInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String compressOriginalImageFile(String str) {
        int i;
        long fileSize = FileHelper.getFileSize(str);
        if (fileSize >= 20971520) {
            i = 60;
        } else if (fileSize >= 10485760 && fileSize < 20971520) {
            i = 75;
        } else if (fileSize >= FILE_SIZE_7M && fileSize < 10485760) {
            i = 85;
        } else {
            i = (fileSize < FILE_SIZE_5M || fileSize >= FILE_SIZE_7M) ? 100 : 95;
        }
        try {
            int readPictureDegree = BitmapHelper.readPictureDegree(str);
            if (readPictureDegree != 0 || i != 100) {
                Bitmap uploadFileBitmap = getUploadFileBitmap(str);
                if (readPictureDegree != 0 && uploadFileBitmap != null) {
                    return saveTempUploadFile(BitmapHelper.rotateBitmapBydegree(uploadFileBitmap, readPictureDegree), i);
                }
                return saveTempUploadFile(uploadFileBitmap, i);
            }
            return str;
        } catch (Throwable th) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap getUploadFileBitmap(String str) {
        BitmapFactory.Options newSizeBitmapOptions = newSizeBitmapOptions(str);
        int i = newSizeBitmapOptions.outWidth;
        int i2 = newSizeBitmapOptions.outHeight;
        if (i == 0 || i2 == 0) {
            return null;
        }
        Bitmap loadBitmap = BitmapHelper.loadBitmap(str);
        if (loadBitmap == null || loadBitmap.isRecycled()) {
            int i3 = 1;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= 3) {
                    return null;
                }
                newSizeBitmapOptions.inSampleSize = i3 * 2;
                Bitmap loadBitmap2 = BitmapHelper.loadBitmap(str, newSizeBitmapOptions);
                if (loadBitmap2 == null || loadBitmap2.isRecycled()) {
                    i3++;
                    i4 = i5 + 1;
                } else {
                    return loadBitmap2;
                }
            }
        } else {
            return loadBitmap;
        }
    }

    private BitmapFactory.Options newSizeBitmapOptions(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return options;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String saveTempUploadFile(Bitmap bitmap, int i) {
        return FileHelper.compressBitmapToFile("img_upload_temp_file.temp", bitmap, 5242880.0f, i);
    }
}
