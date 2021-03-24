package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.File;
/* loaded from: classes3.dex */
public class StorageFile {
    public static final int DIRECTORY_COUNT = 20;
    public static final long MAX_BUBBULE_CACHE_TIME = -1702967296;
    public static StorageFile mInstance;

    private void deleteBubbleCache(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    deleteImageCache(file2);
                    file2.delete();
                } else if (currentTimeMillis - file2.lastModified() >= MAX_BUBBULE_CACHE_TIME) {
                    file2.delete();
                }
            }
        }
    }

    private void deleteImageCache(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    deleteImageCache(file2);
                    file2.delete();
                } else {
                    file2.delete();
                }
            }
        }
    }

    public static synchronized StorageFile getInstance() {
        StorageFile storageFile;
        synchronized (StorageFile.class) {
            if (mInstance == null) {
                mInstance = new StorageFile();
            }
            storageFile = mInstance;
        }
        return storageFile;
    }

    public void clearBubbleCache() {
        deleteBubbleCache(new File(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + FileHelper.getPrefixByType(3)));
    }

    public void clearImageCache() {
        deleteImageCache(new File(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/image"));
        deleteImageCache(new File(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/images"));
    }

    public boolean copyFile(String str, String str2) {
        String str3 = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
        if (!FileHelper.CheckTempDir(str3)) {
            FileHelper.makeRootDirectory(str3);
        }
        String str4 = str3 + getDirectoryName(str2);
        if (!FileHelper.CheckTempDir(str4)) {
            FileHelper.makeRootDirectory(str4);
        }
        String str5 = str4 + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return FileHelper.CopyFile(str, str5, true);
    }

    public String getDirectoryName(String str) {
        if (str == null) {
            return null;
        }
        long j = 0;
        for (byte b2 : str.getBytes()) {
            j += b2;
        }
        return FileUtils.IMAGE_FILE_START + (j % 20);
    }

    public Bitmap getImage(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return FileHelper.getImage(getDirectoryName(str), str);
    }

    public int getImageSize(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) FileHelper.checkImageFileSize(getDirectoryName(str), str);
    }

    public boolean isGif(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return FileHelper.isGif(getDirectoryName(str), str);
    }

    public void saveImage(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        FileHelper.SaveFile(getDirectoryName(str), str, bArr);
    }

    public void saveNineImage(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        FileHelper.SaveFile(FileHelper.getPrefixByType(3), str, bArr);
    }
}
