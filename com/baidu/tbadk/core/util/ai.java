package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.content.Intent;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.d;
import java.io.File;
/* loaded from: classes.dex */
public class ai {
    public static void c(TbPageContext<?> tbPageContext) {
        try {
            if (!k.dH()) {
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) tbPageContext.getOrignalPage()).showToast(k.uE());
                } else if (tbPageContext instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(k.uE());
                }
            } else {
                File ds = k.ds("camera.jpg");
                if (ds != null) {
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", UtilHelper.getUriFromFile(ds, intent, tbPageContext.getPageActivity()));
                    tbPageContext.getPageActivity().startActivityForResult(intent, 12001);
                } else if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(d.l.error_sd_error));
                } else if (tbPageContext instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(d.l.error_sd_error));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void b(TbPageContext<?> tbPageContext, String str) {
        try {
            if (!k.dH()) {
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) tbPageContext.getOrignalPage()).showToast(k.uE());
                    return;
                } else if (tbPageContext instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(k.uE());
                    return;
                } else {
                    return;
                }
            }
            String str2 = k.xQ + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR;
            boolean z = false;
            if (k.dl(str2)) {
                File file = new File(str2 + "/" + str);
                if (!file.exists()) {
                    z = file.createNewFile();
                } else {
                    z = true;
                }
                if (z) {
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", UtilHelper.getUriFromFile(file, intent, tbPageContext.getPageActivity()));
                    tbPageContext.getPageActivity().startActivityForResult(intent, 12001);
                }
            }
            if (!z) {
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(d.l.error_sd_error));
                } else if (tbPageContext instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(d.l.error_sd_error));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void q(Activity activity) {
        r(activity);
    }

    public static void r(Activity activity) {
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
