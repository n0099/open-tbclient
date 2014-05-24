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
public class bb {
    public static void a(Activity activity) {
        try {
            if (!x.a()) {
                if (activity instanceof BaseActivity) {
                    ((BaseActivity) activity).showToast(x.b());
                } else if (activity instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) activity).a(x.b());
                }
            } else {
                File f = x.f("camera.jpg");
                if (f != null) {
                    Uri fromFile = Uri.fromFile(f);
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", fromFile);
                    activity.startActivityForResult(intent, 12001);
                } else if (activity instanceof BaseActivity) {
                    ((BaseActivity) activity).showToast(activity.getString(com.baidu.tieba.y.error_sd_error));
                } else if (activity instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) activity).a(activity.getString(com.baidu.tieba.y.error_sd_error));
                }
            }
        } catch (Exception e) {
            BdLog.e("WriteUtil", "takePhoto", "error = " + e.getMessage());
        }
    }

    public static void a(Activity activity, String str) {
        String str2;
        try {
            if (!x.a()) {
                if (activity instanceof BaseActivity) {
                    ((BaseActivity) activity).showToast(x.b());
                    return;
                } else if (activity instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) activity).a(x.b());
                    return;
                } else {
                    return;
                }
            }
            boolean z = false;
            if (x.a(x.a + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR)) {
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
                    ((BaseFragmentActivity) activity).a(activity.getString(com.baidu.tieba.y.error_sd_error));
                }
            }
        } catch (Exception e) {
            BdLog.e("WriteUtil", "takePhoto", "error = " + e.getMessage());
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
            BdLog.e("WriteUtil", "getAlbumImage", "error = " + e.getMessage());
        }
    }
}
