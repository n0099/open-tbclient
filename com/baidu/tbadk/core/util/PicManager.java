package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.util.resourceLoader.IMImageSize;
import d.a.c.j.d.a;
import d.a.m0.a0.c;
/* loaded from: classes3.dex */
public class PicManager {
    public static PicManager instance;
    public static final BdUniqueId taskId = BdUniqueId.gen();

    /* loaded from: classes3.dex */
    public class SaveImgCacheAsyncTask extends BdAsyncTask<String, String, String> {
        public final String imageUrl;
        public final boolean isNeedReSize;
        public final boolean isNeedRound;
        public final String localFileFullPath;
        public final boolean put2MemoryCache;

        public SaveImgCacheAsyncTask(String str, String str2, boolean z, boolean z2, boolean z3) {
            this.imageUrl = str;
            this.localFileFullPath = str2;
            this.put2MemoryCache = z;
            this.isNeedRound = z2;
            this.isNeedReSize = z3;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, PicManager.taskId));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                PicManager.this.saveImageToCacheDisk(this.imageUrl, this.localFileFullPath, this.put2MemoryCache, this.isNeedRound, this.isNeedReSize);
            } finally {
                return null;
            }
            return null;
        }
    }

    public static void addPicMemoryCache(String str, a aVar) {
        c.k().d(str, aVar);
    }

    public static synchronized PicManager getInstance() {
        PicManager picManager;
        synchronized (PicManager.class) {
            if (instance == null) {
                instance = new PicManager();
            }
            picManager = instance;
        }
        return picManager;
    }

    public Bitmap getFixBitmap(Bitmap bitmap, boolean z, boolean z2, String str) {
        if (z2) {
            bitmap = getReSizeBitmap(bitmap);
        }
        if (z && bitmap != null) {
            float f2 = 10.0f;
            bitmap = BitmapHelper.getRoundedCornerBitmap(bitmap, (bitmap.getHeight() < 100 || bitmap.getWidth() < 100) ? 5.0f : 5.0f, true);
        }
        if (!TextUtils.isEmpty(str)) {
            StorageFile.getInstance().saveImage(str, BitmapHelper.Bitmap2Bytes(bitmap, 100));
        }
        return bitmap;
    }

    public IMImageSize getImageSize(int i2, int i3, boolean z) {
        int i4;
        int i5;
        boolean z2;
        int i6;
        int msgSPicMaxSizeInt = LocalViewSize.getInstance().getMsgSPicMaxSizeInt();
        if (z) {
            if (i2 / i3 >= 3) {
                i5 = i2 / 2;
                z2 = true;
                i4 = i2;
            } else if (i3 / i2 >= 3) {
                i4 = i3 / 2;
                i5 = i3;
                z2 = true;
            }
            if (i4 <= i5 && i4 > msgSPicMaxSizeInt) {
                i6 = (int) (i5 / (i4 / msgSPicMaxSizeInt));
            } else if (i5 > i4 || i5 <= msgSPicMaxSizeInt) {
                msgSPicMaxSizeInt = i4;
                i6 = i5;
            } else {
                msgSPicMaxSizeInt = (int) (i4 / (i5 / msgSPicMaxSizeInt));
                i6 = msgSPicMaxSizeInt;
            }
            if (z2 && i2 <= msgSPicMaxSizeInt && i3 <= i6) {
                i6 = (int) (i6 * 0.9d);
                msgSPicMaxSizeInt = (int) (msgSPicMaxSizeInt * 0.9d);
            }
            if (msgSPicMaxSizeInt < 70 && i6 < 70) {
                i6 = 70;
                msgSPicMaxSizeInt = 70;
            }
            return new IMImageSize(msgSPicMaxSizeInt, i6, z2);
        }
        i4 = i2;
        i5 = i3;
        z2 = false;
        if (i4 <= i5) {
        }
        if (i5 > i4) {
        }
        msgSPicMaxSizeInt = i4;
        i6 = i5;
        if (z2) {
            i6 = (int) (i6 * 0.9d);
            msgSPicMaxSizeInt = (int) (msgSPicMaxSizeInt * 0.9d);
        }
        if (msgSPicMaxSizeInt < 70) {
            i6 = 70;
            msgSPicMaxSizeInt = 70;
        }
        return new IMImageSize(msgSPicMaxSizeInt, i6, z2);
    }

    public Bitmap getReSizeBitmap(Bitmap bitmap) {
        return getReSizeBitmap(bitmap, true);
    }

    public void saveImageToCacheDisk(String str, String str2, boolean z, boolean z2, boolean z3) {
        if (str2 == null || str == null) {
            return;
        }
        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
        StorageFile.getInstance().copyFile(str2, nameMd5FromUrl);
        if (z || z2 || z3) {
            synchronized (BitmapHelper.lockForSyncImageDecoder) {
                int imageSize = StorageFile.getInstance().getImageSize(nameMd5FromUrl);
                if (imageSize <= 0) {
                    return;
                }
                if (z) {
                    Bitmap image = StorageFile.getInstance().getImage(nameMd5FromUrl);
                    c.k().i(imageSize);
                    if (image != null) {
                        addPicMemoryCache(str, image, z2, StorageFile.getInstance().isGif(nameMd5FromUrl), z3, nameMd5FromUrl);
                    }
                }
            }
        }
    }

    public void saveImageToCacheDiskAsync(String str, String str2, boolean z, boolean z2, boolean z3) {
        new SaveImgCacheAsyncTask(str2, str2, z3, z3, z3).execute(new String[0]);
    }

    private void addPicMemoryCache(String str, Bitmap bitmap, boolean z, boolean z2, boolean z3, String str2) {
        try {
            Bitmap fixBitmap = getFixBitmap(bitmap, z, z3, str2);
            if (fixBitmap == null) {
                return;
            }
            addPicMemoryCache(str, new a(fixBitmap, z2));
        } catch (Exception e2) {
            TiebaStatic.imgError(-1006, "addPicMemoryCache error: " + e2.toString(), str);
        }
    }

    public Bitmap getReSizeBitmap(Bitmap bitmap, boolean z) {
        try {
            IMImageSize imageSize = getImageSize(bitmap.getWidth(), bitmap.getHeight(), z);
            int i2 = imageSize.width;
            int i3 = imageSize.height;
            if (i2 == bitmap.getWidth() && i3 == bitmap.getHeight()) {
                return bitmap;
            }
            Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(bitmap, i2, i3);
            return resizedBitmap != null ? resizedBitmap : bitmap;
        } catch (Exception e2) {
            FieldBuilder fieldBuilder = new FieldBuilder();
            if (bitmap == null) {
                fieldBuilder.append("bitmap", StringUtil.NULL_STRING);
            } else {
                fieldBuilder.append("bitW", Integer.valueOf(bitmap.getWidth()));
                fieldBuilder.append("bitH", Integer.valueOf(bitmap.getHeight()));
            }
            TiebaStatic.imgError(-1005, "getResizedBitmap error: " + e2.toString(), fieldBuilder.toString());
            return bitmap;
        }
    }
}
