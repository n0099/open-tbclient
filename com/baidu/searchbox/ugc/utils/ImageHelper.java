package com.baidu.searchbox.ugc.utils;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.ugc.model.ImageStruct;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* loaded from: classes12.dex */
public class ImageHelper {
    private static final String PHOTO_FILE = "take_photo";
    private static List<ImageStruct> mList = new ArrayList();
    private static File mTakeImageFile;

    public static void setImageList(List<ImageStruct> list) {
        mList.clear();
        mList.addAll(list);
    }

    public static List<ImageStruct> getImageList() {
        return mList;
    }

    public static void clear() {
        mList.clear();
    }

    public static void takePicture(Activity activity, int i) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.setFlags(67108864);
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            if (existSDCard()) {
                mTakeImageFile = new File(Environment.getExternalStorageDirectory(), "/SearchBox/");
            } else {
                mTakeImageFile = Environment.getDataDirectory();
            }
            mTakeImageFile = createFile(mTakeImageFile, "IMG_", ".jpg");
            if (mTakeImageFile != null) {
                Uri fromFile = Uri.fromFile(mTakeImageFile);
                if (DeviceUtil.OSInfo.hasNougat()) {
                    fromFile = FileProvider.getUriForFile(activity, activity.getPackageName() + ".fileprovider", mTakeImageFile);
                }
                DefaultSharedPrefsWrapper.getInstance().putString(PHOTO_FILE, mTakeImageFile.toString());
                intent.putExtra("output", fromFile);
            }
        }
        activity.startActivityForResult(intent, i);
        UgcUBCUtils.enterUgc();
    }

    public static File getTakeImageFile() {
        return mTakeImageFile;
    }

    public static File createFile(File file, String str, String str2) {
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        return new File(file, str + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA).format(new Date(System.currentTimeMillis())) + str2);
    }

    public static boolean existSDCard() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static synchronized Bitmap createBitmapThumbnail(String str, int i, int i2) {
        BitmapFactory.Options options;
        Bitmap bitmap = null;
        synchronized (ImageHelper.class) {
            if (str != null) {
                if (!str.isEmpty() && (options = SelectUtil.getOptions(str)) != null) {
                    options.inSampleSize = calculateInSampleSize(options, i, i2);
                    options.inJustDecodeBounds = false;
                    bitmap = MediaUtils.loadBitmap(str, options);
                }
            }
        }
        return bitmap;
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            if (i4 > i3) {
                i5 = Math.round(i3 / i2);
            } else {
                i5 = Math.round(i4 / i);
            }
            while ((i3 * i4) / (i5 * i5) > i * i2 * 2) {
                i5++;
            }
        }
        return i5;
    }
}
