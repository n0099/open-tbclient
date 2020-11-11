package com.baidu.live.tbadk.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.util.BitmapHelper;
import com.baidu.live.tbadk.core.util.FileHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import java.io.File;
/* loaded from: classes4.dex */
public class WriteUtil {
    private static final String TMP_IMAGE_NAME = "camera.jpg";

    public static void takePhoto(TbPageContext<?> tbPageContext) {
        try {
            if (!FileHelper.checkSD()) {
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) tbPageContext.getOrignalPage()).showToast(FileHelper.getSdErrorString());
                } else if (tbPageContext instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(FileHelper.getSdErrorString());
                }
            } else {
                File CreateFile = FileHelper.CreateFile("camera.jpg");
                if (CreateFile != null) {
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", UtilHelper.getUriFromFile(CreateFile, intent, tbPageContext.getPageActivity()));
                    tbPageContext.getPageActivity().startActivityForResult(intent, RequestResponseCode.REQUEST_CAMERA);
                } else if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(a.h.sdk_error_sd_error));
                } else if (tbPageContext instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(a.h.sdk_error_sd_error));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void takePhoto(TbPageContext<?> tbPageContext, String str) {
        try {
            if (!FileHelper.checkSD()) {
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) tbPageContext.getOrignalPage()).showToast(FileHelper.getSdErrorString());
                    return;
                } else if (tbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(FileHelper.getSdErrorString());
                    return;
                } else {
                    return;
                }
            }
            String str2 = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/cameras";
            boolean z = false;
            if (FileHelper.CheckTempDir(str2)) {
                File file = new File(str2 + "/" + str);
                if (!file.exists()) {
                    z = file.createNewFile();
                } else {
                    z = true;
                }
                if (z) {
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", UtilHelper.getUriFromFile(file, intent, tbPageContext.getPageActivity()));
                    tbPageContext.getPageActivity().startActivityForResult(intent, RequestResponseCode.REQUEST_CAMERA);
                }
            }
            if (!z) {
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(a.h.sdk_error_sd_error));
                } else if (tbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(a.h.sdk_error_sd_error));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void getAlbumImage(Activity activity) {
        getSystemAlbumImage(activity);
    }

    public static void getSystemAlbumImage(Activity activity) {
        try {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction("android.intent.action.GET_CONTENT");
            activity.startActivityForResult(intent, RequestResponseCode.REQUEST_ALBUM_IMAGE);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static int readPictureDegree(String str) {
        try {
            switch (new ExifInterface(str).getAttributeInt(android.support.media.ExifInterface.TAG_ORIENTATION, 1)) {
                case 3:
                    return 180;
                case 4:
                case 5:
                case 7:
                default:
                    return 0;
                case 6:
                    return 90;
                case 8:
                    return 270;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return 0;
        }
    }

    private static Bitmap photoResult(int i) {
        Exception e;
        try {
            int readPictureDegree = readPictureDegree(FileHelper.getFileDireciory("camera.jpg"));
            Bitmap subSampleBitmap = BitmapHelper.subSampleBitmap("camera.jpg", i);
            if (readPictureDegree != 0 && subSampleBitmap != null) {
                try {
                    return BitmapHelper.rotateBitmapBydegree(subSampleBitmap, readPictureDegree);
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    return null;
                }
            }
            return subSampleBitmap;
        } catch (Exception e3) {
            e = e3;
        }
    }

    private static Bitmap AlbumImageResult(Context context, String str, int i) {
        Exception e;
        try {
            int readPictureDegree = readPictureDegree(str);
            Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, i, i);
            if (readPictureDegree != 0 && loadResizedBitmap != null) {
                try {
                    return BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    return null;
                }
            }
            return loadResizedBitmap;
        } catch (Exception e3) {
            e = e3;
        }
    }

    private static Bitmap AlbumImageResult(Context context, Uri uri, int i) {
        Exception e;
        try {
            int readPictureDegree = readPictureDegree(uri.getPath());
            Bitmap subSampleBitmap = BitmapHelper.subSampleBitmap(context, uri, i);
            if (readPictureDegree != 0 && subSampleBitmap != null) {
                try {
                    return BitmapHelper.rotateBitmapBydegree(subSampleBitmap, readPictureDegree);
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    return null;
                }
            }
            return subSampleBitmap;
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static Bitmap ImageResult(int i, Context context, Uri uri, String str, int i2) {
        if (i == 12001) {
            return photoResult(i2);
        }
        if (!TextUtils.isEmpty(str)) {
            return AlbumImageResult(context, str, i2);
        }
        return AlbumImageResult(context, uri, i2);
    }
}
