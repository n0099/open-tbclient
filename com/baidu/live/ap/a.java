package com.baidu.live.ap;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.graphics.ColorUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.view.web.g;
import com.baidu.live.view.web.h;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes11.dex */
public class a {
    private h bWS = new h() { // from class: com.baidu.live.ap.a.1
        @Override // com.baidu.live.view.web.h
        public void jk(String str) {
            if (!TextUtils.isEmpty(str)) {
                c cVar = new c();
                cVar.isFullScreen = a.this.aU(str, "fullscreen");
                cVar.url = str;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
            }
        }
    };
    private d bXc;
    private CustomMessageListener bXd;
    private Activity mContext;

    public a(Activity activity) {
        this.mContext = activity;
        aaf();
    }

    public void a(c cVar) {
        if (cVar != null && !TextUtils.isEmpty(cVar.url)) {
            String str = cVar.url;
            dismiss();
            this.bXc = new d(this.mContext);
            this.bXc.getWebView().setBackgroundColor(ih(str));
            g gVar = new g();
            gVar.w(this.mContext).a(this.bXc).a(this.bXc.getWebView().getSchemeCallback()).b(this.bWS);
            com.baidu.live.view.web.a[] aae = gVar.aae();
            for (com.baidu.live.view.web.a aVar : aae) {
                this.bXc.getWebView().addJavascriptInterface(aVar, aVar.getName());
            }
            this.bXc.c(cVar);
        }
    }

    public void b(c cVar) {
        if (cVar != null && !TextUtils.isEmpty(cVar.url)) {
            String str = cVar.url;
            dismiss();
            this.bXc = new d(this.mContext);
            this.bXc.getWebView().setBackgroundColor(ih(str));
            g gVar = new g();
            gVar.w(this.mContext).a(this.bXc).a(this.bXc.getWebView().getSchemeCallback()).b(this.bWS);
            com.baidu.live.view.web.a[] aae = gVar.aae();
            for (com.baidu.live.view.web.a aVar : aae) {
                this.bXc.getWebView().addJavascriptInterface(aVar, aVar.getName());
            }
            this.bXc.d(cVar);
        }
    }

    public void resume() {
        if (this.bXc != null && this.bXc.isShowing() && this.bXc.getWebView() != null) {
            this.bXc.getWebView().onResume();
        }
    }

    public void pause() {
        if (this.bXc != null && this.bXc.isShowing() && this.bXc.getWebView() != null) {
            this.bXc.getWebView().onPause();
        }
    }

    public void dismiss() {
        if (this.bXc != null) {
            this.bXc.aag();
            this.bXc = null;
        }
    }

    public void dU(int i) {
        if (this.bXc != null && this.bXc.isShowing()) {
            this.bXc.dU(i);
        }
    }

    public void Id() {
        dismiss();
    }

    public void release() {
        Id();
        MessageManager.getInstance().unRegisterListener(this.bXd);
        this.bXd = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aU(String str, String str2) {
        String queryParameter = Uri.parse(str).getQueryParameter(str2);
        if (TextUtils.isEmpty(queryParameter)) {
            int indexOf = str.indexOf(str2 + "=");
            int length = str2.length() + 1;
            if (indexOf >= 0 && indexOf + length + 1 <= str.length()) {
                queryParameter = str.substring(indexOf + length, indexOf + length + 1);
            }
        }
        if (TextUtils.isEmpty(queryParameter)) {
            return false;
        }
        try {
            return Integer.parseInt(queryParameter) == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void aaf() {
        if (this.bXd == null) {
            this.bXd = new CustomMessageListener(2913123) { // from class: com.baidu.live.ap.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.bXc != null && a.this.bXc.isShowing()) {
                        a.this.bXc.dismiss();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bXd);
        }
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
