package com.baidu.live.t;

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
    private CustomMessageListener bcy;
    private b bpa;
    private Activity mActivity;

    public c(Activity activity) {
        this.mActivity = activity;
        IT();
    }

    @Override // com.baidu.live.t.a
    public void hN(String str) {
        if (this.mActivity != null && !this.mActivity.isFinishing()) {
            this.bpa = new b(this.mActivity);
            g gVar = new g();
            gVar.x(this.mActivity).a(this.bpa).a(this.bpa.Oh());
            com.baidu.live.view.web.a[] Wo = gVar.Wo();
            for (com.baidu.live.view.web.a aVar : Wo) {
                this.bpa.a(aVar, aVar.getName());
            }
            this.bpa.g(UtilHelper.getRealScreenOrientation(this.mActivity), hQ(str), str);
        }
    }

    @Override // com.baidu.live.t.a
    public void resume() {
        if (this.bpa != null && this.bpa.isShowing()) {
            this.bpa.eU(UtilHelper.getRealScreenOrientation(this.mActivity));
        }
    }

    @Override // com.baidu.live.t.a
    public void pause() {
        if (this.bpa != null && this.bpa.isShowing()) {
            this.bpa.pause();
        }
    }

    @Override // com.baidu.live.t.a
    public void release() {
        if (this.bpa != null) {
            this.bpa.dismiss();
        }
        Oj();
    }

    private void IT() {
        this.bcy = new CustomMessageListener(2913097) { // from class: com.baidu.live.t.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913097) {
                    c.this.release();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bcy);
    }

    private void Oj() {
        MessageManager.getInstance().unRegisterListener(this.bcy);
    }

    private int hQ(String str) {
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
