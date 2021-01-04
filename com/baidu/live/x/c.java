package com.baidu.live.x;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.graphics.ColorUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.view.web.g;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes11.dex */
public class c implements a {
    private CustomMessageListener bih;
    private b byV;
    private Activity mActivity;

    public c(Activity activity) {
        this.mActivity = activity;
        Ku();
    }

    @Override // com.baidu.live.x.a
    public void ie(String str) {
        if (this.mActivity != null && !this.mActivity.isFinishing()) {
            this.byV = new b(this.mActivity);
            g gVar = new g();
            gVar.w(this.mActivity).a(this.byV).a(this.byV.RE());
            com.baidu.live.view.web.a[] aae = gVar.aae();
            for (com.baidu.live.view.web.a aVar : aae) {
                this.byV.a(aVar, aVar.getName());
            }
            this.byV.h(UtilHelper.getRealScreenOrientation(this.mActivity), ih(str), str);
        }
    }

    @Override // com.baidu.live.x.a
    public void resume() {
        if (this.byV != null && this.byV.isShowing()) {
            this.byV.fs(UtilHelper.getRealScreenOrientation(this.mActivity));
        }
    }

    @Override // com.baidu.live.x.a
    public void pause() {
        if (this.byV != null && this.byV.isShowing()) {
            this.byV.pause();
        }
    }

    @Override // com.baidu.live.x.a
    public void release() {
        if (this.byV != null) {
            this.byV.dismiss();
        }
        RG();
    }

    private void Ku() {
        this.bih = new CustomMessageListener(2913097) { // from class: com.baidu.live.x.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913097) {
                    c.this.release();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bih);
    }

    private void RG() {
        MessageManager.getInstance().unRegisterListener(this.bih);
    }

    private int ih(String str) {
        String str2 = null;
        try {
            str2 = Uri.parse(str).getQueryParameter("background");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if ((TextUtils.isEmpty(str2) || str2.length() != 8) && str.indexOf("?") > 0) {
            String[] split = str.split("\\?");
            if (split.length >= 2) {
                String[] split2 = split[1].split(ETAG.ITEM_SEPARATOR);
                if (split2.length > 0) {
                    int length = split2.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        String str3 = split2[i];
                        if (str3 != null) {
                            String[] split3 = str3.split("=");
                            if (split3.length >= 2 && "background".equals(split3[0]) && !TextUtils.isEmpty(split3[1])) {
                                str2 = split3[1];
                                break;
                            }
                        }
                        i++;
                    }
                }
            }
        }
        if (TextUtils.isEmpty(str2) || str2.length() != 8) {
            return 0;
        }
        try {
            int parseInt = Integer.parseInt(str2.substring(6, 8), 16);
            return (parseInt < 0 || parseInt > 255) ? 0 : ColorUtils.setAlphaComponent(Color.parseColor('#' + str2.substring(0, 6)), parseInt);
        } catch (Exception e) {
            return 0;
        }
    }
}
