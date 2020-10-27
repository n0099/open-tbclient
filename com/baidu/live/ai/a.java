package com.baidu.live.ai;

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
    private Activity bIs;
    private d bIt;
    private CustomMessageListener bIu;

    public a(Activity activity) {
        this.bIs = activity;
        Uy();
    }

    public void a(c cVar) {
        if (cVar != null && !TextUtils.isEmpty(cVar.url)) {
            String str = cVar.url;
            dismiss();
            this.bIt = new d(this.bIs);
            this.bIt.Uz().setBackgroundColor(hP(str));
            g gVar = new g();
            gVar.x(this.bIs).a(this.bIt).a(this.bIt.Uz().getSchemeCallback());
            com.baidu.live.view.web.a[] Ux = gVar.Ux();
            for (com.baidu.live.view.web.a aVar : Ux) {
                this.bIt.Uz().addJavascriptInterface(aVar, aVar.getName());
            }
            this.bIt.b(cVar);
        }
    }

    public void resume() {
        if (this.bIt != null && this.bIt.isShowing() && this.bIt.Uz() != null) {
            this.bIt.Uz().onResume();
        }
    }

    public void pause() {
        if (this.bIt != null && this.bIt.isShowing() && this.bIt.Uz() != null) {
            this.bIt.Uz().onPause();
        }
    }

    public void dismiss() {
        if (this.bIt != null) {
            this.bIt.UA();
            this.bIt = null;
        }
    }

    public void dI(int i) {
        if (this.bIt != null && this.bIt.isShowing()) {
            this.bIt.dI(i);
        }
    }

    public void GS() {
        dismiss();
    }

    public void release() {
        GS();
        MessageManager.getInstance().unRegisterListener(this.bIu);
        this.bIu = null;
    }

    private void Uy() {
        if (this.bIu == null) {
            this.bIu = new CustomMessageListener(2913123) { // from class: com.baidu.live.ai.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.bIt != null && a.this.bIt.isShowing()) {
                        a.this.bIt.dismiss();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bIu);
        }
    }

    private int hP(String str) {
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
