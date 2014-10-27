package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.io.File;
/* loaded from: classes.dex */
public class av {
    public static void h(Activity activity) {
        try {
            if (!s.bm()) {
                if (activity instanceof BaseActivity) {
                    ((BaseActivity) activity).showToast(s.lu());
                } else if (activity instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) activity).showToast(s.lu());
                }
            } else {
                File bt = s.bt("camera.jpg");
                if (bt != null) {
                    Uri fromFile = Uri.fromFile(bt);
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", fromFile);
                    activity.startActivityForResult(intent, 12001);
                } else if (activity instanceof BaseActivity) {
                    ((BaseActivity) activity).showToast(activity.getString(com.baidu.tieba.y.error_sd_error));
                } else if (activity instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) activity).showToast(activity.getString(com.baidu.tieba.y.error_sd_error));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void a(Activity activity, String str) {
        String str2;
        try {
            if (!s.bm()) {
                if (activity instanceof BaseActivity) {
                    ((BaseActivity) activity).showToast(s.lu());
                    return;
                } else if (activity instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) activity).showToast(s.lu());
                    return;
                } else {
                    return;
                }
            }
            boolean z = false;
            if (s.bo(s.mI + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR)) {
                File file = new File(String.valueOf(str2) + "/" + str);
                if (!file.exists()) {
                    z = file.createNewFile();
                } else {
                    z = true;
                }
                if (z) {
                    Uri fromFile = Uri.fromFile(file);
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", fromFile);
                    activity.startActivityForResult(intent, 12001);
                }
            }
            if (!z) {
                if (activity instanceof BaseActivity) {
                    ((BaseActivity) activity).showToast(activity.getString(com.baidu.tieba.y.error_sd_error));
                } else if (activity instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) activity).showToast(activity.getString(com.baidu.tieba.y.error_sd_error));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void i(Activity activity) {
        j(activity);
    }

    public static void j(Activity activity) {
        try {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction("android.intent.action.GET_CONTENT");
            activity.startActivityForResult(intent, 12002);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
