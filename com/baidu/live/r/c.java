package com.baidu.live.r;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.graphics.ColorUtils;
import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.view.web.g;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes4.dex */
public class c implements a {
    private CustomMessageListener bbC;
    private b bnF;
    private Activity mActivity;

    public c(Activity activity) {
        this.mActivity = activity;
        II();
    }

    @Override // com.baidu.live.r.a
    public void hE(String str) {
        if (this.mActivity != null && !this.mActivity.isFinishing()) {
            this.bnF = new b(this.mActivity);
            g gVar = new g();
            gVar.x(this.mActivity).a(this.bnF).a(this.bnF.NS());
            com.baidu.live.view.web.a[] Tx = gVar.Tx();
            for (com.baidu.live.view.web.a aVar : Tx) {
                this.bnF.a(aVar, aVar.getName());
            }
            this.bnF.g(UtilHelper.getRealScreenOrientation(this.mActivity), hH(str), str);
        }
    }

    @Override // com.baidu.live.r.a
    public void resume() {
        if (this.bnF != null && this.bnF.isShowing()) {
            this.bnF.eV(UtilHelper.getRealScreenOrientation(this.mActivity));
        }
    }

    @Override // com.baidu.live.r.a
    public void pause() {
        if (this.bnF != null && this.bnF.isShowing()) {
            this.bnF.pause();
        }
    }

    @Override // com.baidu.live.r.a
    public void release() {
        if (this.bnF != null) {
            this.bnF.dismiss();
        }
        NU();
    }

    private void II() {
        this.bbC = new CustomMessageListener(2913097) { // from class: com.baidu.live.r.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913097) {
                    c.this.release();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bbC);
    }

    private void NU() {
        MessageManager.getInstance().unRegisterListener(this.bbC);
    }

    private int hH(String str) {
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
                            String[] split3 = str3.split(ETAG.EQUAL);
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
            return (parseInt < 0 || parseInt > 255) ? 0 : ColorUtils.setAlphaComponent(Color.parseColor(UgcConstant.TOPIC_PATTERN_TAG + str2.substring(0, 6)), parseInt);
        } catch (Exception e) {
            return 0;
        }
    }
}
