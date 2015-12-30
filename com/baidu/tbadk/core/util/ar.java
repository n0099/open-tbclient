package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.n;
import java.io.File;
/* loaded from: classes.dex */
public class ar {
    public static void c(TbPageContext<?> tbPageContext) {
        try {
            if (!n.fi()) {
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) tbPageContext.getOrignalPage()).showToast(n.tQ());
                } else if (tbPageContext instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(n.tQ());
                }
            } else {
                File cY = n.cY("camera.jpg");
                if (cY != null) {
                    Uri fromFile = Uri.fromFile(cY);
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", fromFile);
                    tbPageContext.getPageActivity().startActivityForResult(intent, 12001);
                } else if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(n.j.error_sd_error));
                } else if (tbPageContext instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(n.j.error_sd_error));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void b(TbPageContext<?> tbPageContext, String str) {
        String str2;
        try {
            if (!n.fi()) {
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) tbPageContext.getOrignalPage()).showToast(n.tQ());
                    return;
                } else if (tbPageContext instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(n.tQ());
                    return;
                } else {
                    return;
                }
            }
            boolean z = false;
            if (n.cR(n.yc + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR)) {
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
                    tbPageContext.getPageActivity().startActivityForResult(intent, 12001);
                }
            }
            if (!z) {
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(n.j.error_sd_error));
                } else if (tbPageContext instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(n.j.error_sd_error));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void p(Activity activity) {
        q(activity);
    }

    public static void q(Activity activity) {
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
