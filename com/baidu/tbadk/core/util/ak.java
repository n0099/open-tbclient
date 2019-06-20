package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.content.Intent;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
import java.io.File;
/* loaded from: classes.dex */
public class ak {
    public static void c(TbPageContext<?> tbPageContext) {
        try {
            if (!m.gs()) {
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) tbPageContext.getOrignalPage()).showToast(m.agZ());
                } else if (tbPageContext instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(m.agZ());
                }
            } else {
                File ne = m.ne("camera.jpg");
                if (ne != null) {
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", UtilHelper.getUriFromFile(ne, intent, tbPageContext.getPageActivity()));
                    tbPageContext.getPageActivity().startActivityForResult(intent, 12001);
                } else if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(R.string.error_sd_error));
                } else if (tbPageContext instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(R.string.error_sd_error));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void a(TbPageContext<?> tbPageContext, String str) {
        try {
            if (!m.gs()) {
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) tbPageContext.getOrignalPage()).showToast(m.agZ());
                    return;
                } else if (tbPageContext instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(m.agZ());
                    return;
                } else {
                    return;
                }
            }
            String str2 = m.Dt + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR;
            boolean z = false;
            if (m.mV(str2)) {
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
                    ((BaseActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(R.string.error_sd_error));
                } else if (tbPageContext instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(R.string.error_sd_error));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void W(Activity activity) {
        X(activity);
    }

    public static void X(Activity activity) {
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
