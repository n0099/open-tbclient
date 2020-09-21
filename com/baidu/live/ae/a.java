package com.baidu.live.ae;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.graphics.ColorUtils;
import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.view.web.g;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes4.dex */
public class a {
    private Activity byQ;
    private d byR;
    private CustomMessageListener byS;

    public a(Activity activity) {
        this.byQ = activity;
        RF();
    }

    public void a(c cVar) {
        if (cVar != null && !TextUtils.isEmpty(cVar.url)) {
            String str = cVar.url;
            dismiss();
            this.byR = new d(this.byQ);
            this.byR.RG().setBackgroundColor(hq(str));
            g gVar = new g();
            gVar.w(this.byQ).a(this.byR).a(this.byR.RG().getSchemeCallback());
            com.baidu.live.view.web.a[] RE = gVar.RE();
            for (com.baidu.live.view.web.a aVar : RE) {
                this.byR.RG().addJavascriptInterface(aVar, aVar.getName());
            }
            this.byR.b(cVar);
        }
    }

    public void resume() {
        if (this.byR != null && this.byR.isShowing() && this.byR.RG() != null) {
            this.byR.RG().onResume();
        }
    }

    public void pause() {
        if (this.byR != null && this.byR.isShowing() && this.byR.RG() != null) {
            this.byR.RG().onPause();
        }
    }

    public void dismiss() {
        if (this.byR != null) {
            this.byR.RH();
            this.byR = null;
        }
    }

    public void dD(int i) {
        if (this.byR != null && this.byR.isShowing()) {
            this.byR.dD(i);
        }
    }

    public void FB() {
        dismiss();
    }

    public void release() {
        FB();
        MessageManager.getInstance().unRegisterListener(this.byS);
        this.byS = null;
    }

    private void RF() {
        if (this.byS == null) {
            this.byS = new CustomMessageListener(2913123) { // from class: com.baidu.live.ae.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.byR != null && a.this.byR.isShowing()) {
                        a.this.byR.dismiss();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.byS);
        }
    }

    private int hq(String str) {
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
