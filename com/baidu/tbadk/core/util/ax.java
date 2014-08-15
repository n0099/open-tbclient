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
public class ax {
    public static void a(Activity activity) {
        try {
            if (!s.a()) {
                if (activity instanceof BaseActivity) {
                    ((BaseActivity) activity).showToast(s.b());
                } else if (activity instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) activity).a(s.b());
                }
            } else {
                File f = s.f("camera.jpg");
                if (f != null) {
                    Uri fromFile = Uri.fromFile(f);
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", fromFile);
                    activity.startActivityForResult(intent, 12001);
                } else if (activity instanceof BaseActivity) {
                    ((BaseActivity) activity).showToast(activity.getString(com.baidu.tieba.x.error_sd_error));
                } else if (activity instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) activity).a(activity.getString(com.baidu.tieba.x.error_sd_error));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void a(Activity activity, String str) {
        String str2;
        try {
            if (!s.a()) {
                if (activity instanceof BaseActivity) {
                    ((BaseActivity) activity).showToast(s.b());
                    return;
                } else if (activity instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) activity).a(s.b());
                    return;
                } else {
                    return;
                }
            }
            boolean z = false;
            if (s.a(s.a + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR)) {
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
                    ((BaseActivity) activity).showToast(activity.getString(com.baidu.tieba.x.error_sd_error));
                } else if (activity instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) activity).a(activity.getString(com.baidu.tieba.x.error_sd_error));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void b(Activity activity) {
        c(activity);
    }

    public static void c(Activity activity) {
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
