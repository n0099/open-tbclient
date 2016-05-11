package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.t;
import java.io.File;
/* loaded from: classes.dex */
public class as {
    public static void c(TbPageContext<?> tbPageContext) {
        try {
            if (!m.bF()) {
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) tbPageContext.getOrignalPage()).showToast(m.sX());
                } else if (tbPageContext instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(m.sX());
                }
            } else {
                File cW = m.cW("camera.jpg");
                if (cW != null) {
                    Uri fromFile = Uri.fromFile(cW);
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", fromFile);
                    tbPageContext.getPageActivity().startActivityForResult(intent, 12001);
                } else if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(t.j.error_sd_error));
                } else if (tbPageContext instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(t.j.error_sd_error));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void b(TbPageContext<?> tbPageContext, String str) {
        String str2;
        try {
            if (!m.bF()) {
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) tbPageContext.getOrignalPage()).showToast(m.sX());
                    return;
                } else if (tbPageContext instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(m.sX());
                    return;
                } else {
                    return;
                }
            }
            boolean z = false;
            if (m.cP(m.oH + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR)) {
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
                    ((BaseActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(t.j.error_sd_error));
                } else if (tbPageContext instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(t.j.error_sd_error));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void j(Activity activity) {
        k(activity);
    }

    public static void k(Activity activity) {
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
