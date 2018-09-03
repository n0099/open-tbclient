package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.content.Intent;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.f;
import java.io.File;
/* loaded from: classes.dex */
public class al {
    public static void b(TbPageContext<?> tbPageContext) {
        try {
            if (!l.gd()) {
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) tbPageContext.getOrignalPage()).showToast(l.yh());
                } else if (tbPageContext instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(l.yh());
                }
            } else {
                File ea = l.ea("camera.jpg");
                if (ea != null) {
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", UtilHelper.getUriFromFile(ea, intent, tbPageContext.getPageActivity()));
                    tbPageContext.getPageActivity().startActivityForResult(intent, 12001);
                } else if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(f.j.error_sd_error));
                } else if (tbPageContext instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(f.j.error_sd_error));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void a(TbPageContext<?> tbPageContext, String str) {
        try {
            if (!l.gd()) {
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) tbPageContext.getOrignalPage()).showToast(l.yh());
                    return;
                } else if (tbPageContext instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(l.yh());
                    return;
                } else {
                    return;
                }
            }
            String str2 = l.CD + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR;
            boolean z = false;
            if (l.dR(str2)) {
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
                    ((BaseActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(f.j.error_sd_error));
                } else if (tbPageContext instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(f.j.error_sd_error));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void r(Activity activity) {
        s(activity);
    }

    public static void s(Activity activity) {
        try {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction("android.intent.action.GET_CONTENT");
            activity.startActivityForResult(intent, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
