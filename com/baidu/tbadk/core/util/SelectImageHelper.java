package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
import java.io.File;
/* loaded from: classes3.dex */
public class SelectImageHelper {
    public static final int REQUEST_WRITE_EXTERNAL_STORGE_AND_CAMERA_PERMISSON = 1;
    public static final String TMP_IMAGE_NAME = "camera.jpg";

    public static Bitmap AlbumImageResult(Context context, Uri uri, int i2) {
        try {
            return BitmapHelper.subSampleBitmap(context, uri, i2);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return null;
        }
    }

    public static Bitmap ImageResult(int i2, Context context, Uri uri, int i3) {
        if (i2 == 12001) {
            return photoResult(i3);
        }
        return AlbumImageResult(context, uri, i3);
    }

    public static void getAlbumImage(Activity activity) {
        getSystemAlbumImage(activity);
    }

    public static void getSystemAlbumImage(Activity activity) {
        try {
            Intent intent = new Intent();
            intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
            intent.setAction("android.intent.action.GET_CONTENT");
            activity.startActivityForResult(intent, 12002);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public static Bitmap photoResult(int i2) {
        try {
            int readPictureDegree = readPictureDegree(FileHelper.getFileDireciory(TMP_IMAGE_NAME));
            Bitmap subSampleBitmap = BitmapHelper.subSampleBitmap(TMP_IMAGE_NAME, i2);
            return (readPictureDegree == 0 || subSampleBitmap == null) ? subSampleBitmap : BitmapHelper.rotateBitmapBydegree(subSampleBitmap, readPictureDegree);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return null;
        }
    }

    public static int readPictureDegree(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    return attributeInt != 8 ? 0 : 270;
                }
                return 90;
            }
            return 180;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return 0;
        }
    }

    public static void takePhoto(TbPageContext<?> tbPageContext) {
        try {
            if (!FileHelper.checkSD()) {
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) tbPageContext.getOrignalPage()).showToast(FileHelper.getSdErrorString());
                    return;
                } else if (tbPageContext instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(FileHelper.getSdErrorString());
                    return;
                } else {
                    return;
                }
            }
            File CreateFile = FileHelper.CreateFile(TMP_IMAGE_NAME);
            if (CreateFile != null) {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra("output", UtilHelper.getUriFromFile(CreateFile, intent, tbPageContext.getPageActivity()));
                tbPageContext.getPageActivity().startActivityForResult(intent, 12001);
            } else if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                ((BaseActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(R.string.error_sd_error));
            } else if (tbPageContext instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(R.string.error_sd_error));
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public static void takePhoto(TbPageContext<?> tbPageContext, String str) {
        try {
            if (!FileHelper.checkSD()) {
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) tbPageContext.getOrignalPage()).showToast(FileHelper.getSdErrorString());
                    return;
                } else if (tbPageContext instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(FileHelper.getSdErrorString());
                    return;
                } else {
                    return;
                }
            }
            String str2 = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR;
            boolean z = false;
            if (FileHelper.CheckTempDir(str2)) {
                File file = new File(str2 + "/" + str);
                z = !file.exists() ? file.createNewFile() : true;
                if (z) {
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", UtilHelper.getUriFromFile(file, intent, tbPageContext.getPageActivity()));
                    tbPageContext.getPageActivity().startActivityForResult(intent, 12001);
                }
            }
            if (z) {
                return;
            }
            if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                ((BaseActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(R.string.error_sd_error));
            } else if (tbPageContext instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(R.string.error_sd_error));
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
