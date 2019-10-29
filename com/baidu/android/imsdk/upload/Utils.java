package com.baidu.android.imsdk.upload;

import android.os.Environment;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.utils.LogUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes6.dex */
public class Utils {
    public static final int MEDIA_TYPE_AUDIO = 2;
    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 3;
    public static final String PACKAGE_FILE_MSG_LOCAL = IMConstants.IM_FILE_ROOT + File.separator + "msgslocal";
    public static final String PACKAGE_FILE_MSG_UPLOAD = IMConstants.IM_FILE_ROOT + File.separator + "msgsupload";
    private static final String TAG = "Utils";

    public static File localMediaStorageDir(boolean z) {
        String str;
        if (z) {
            str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + PACKAGE_FILE_MSG_UPLOAD;
        } else {
            str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + PACKAGE_FILE_MSG_LOCAL;
        }
        File file = new File(str);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        LogUtils.d(TAG, "fail to create directory !");
        return null;
    }

    public static File localOutputMediaFile(int i, boolean z) {
        File localMediaStorageDir = localMediaStorageDir(z);
        if (localMediaStorageDir != null) {
            String format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA).format(new Date());
            if (i == 1) {
                return new File(localMediaStorageDir.getPath() + File.separator + "IMG_" + format);
            }
            if (i == 2) {
                return new File(localMediaStorageDir.getPath() + File.separator + "AUDIO_" + format);
            }
            if (3 == i) {
                return new File(localMediaStorageDir.getPath() + File.separator + "VIDEO_" + format);
            }
            return null;
        }
        return null;
    }
}
