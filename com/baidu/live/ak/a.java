package com.baidu.live.ak;

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
    private Activity bNY;
    private d bNZ;
    private CustomMessageListener bOa;

    public a(Activity activity) {
        this.bNY = activity;
        WY();
    }

    public void a(c cVar) {
        if (cVar != null && !TextUtils.isEmpty(cVar.url)) {
            String str = cVar.url;
            dismiss();
            this.bNZ = new d(this.bNY);
            this.bNZ.WZ().setBackgroundColor(hW(str));
            g gVar = new g();
            gVar.y(this.bNY).a(this.bNZ).a(this.bNZ.WZ().getSchemeCallback());
            com.baidu.live.view.web.a[] WX = gVar.WX();
            for (com.baidu.live.view.web.a aVar : WX) {
                this.bNZ.WZ().addJavascriptInterface(aVar, aVar.getName());
            }
            this.bNZ.b(cVar);
        }
    }

    public void resume() {
        if (this.bNZ != null && this.bNZ.isShowing() && this.bNZ.WZ() != null) {
            this.bNZ.WZ().onResume();
        }
    }

    public void pause() {
        if (this.bNZ != null && this.bNZ.isShowing() && this.bNZ.WZ() != null) {
            this.bNZ.WZ().onPause();
        }
    }

    public void dismiss() {
        if (this.bNZ != null) {
            this.bNZ.Xa();
            this.bNZ = null;
        }
    }

    public void dI(int i) {
        if (this.bNZ != null && this.bNZ.isShowing()) {
            this.bNZ.dI(i);
        }
    }

    public void Ht() {
        dismiss();
    }

    public void release() {
        Ht();
        MessageManager.getInstance().unRegisterListener(this.bOa);
        this.bOa = null;
    }

    private void WY() {
        if (this.bOa == null) {
            this.bOa = new CustomMessageListener(2913123) { // from class: com.baidu.live.ak.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.bNZ != null && a.this.bNZ.isShowing()) {
                        a.this.bNZ.dismiss();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bOa);
        }
    }

    private int hW(String str) {
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
