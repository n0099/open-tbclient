package com.baidu.live.ao;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.graphics.ColorUtils;
import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.view.web.g;
import com.baidu.live.view.web.h;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes4.dex */
public class a {
    private h bRm = new h() { // from class: com.baidu.live.ao.a.1
        @Override // com.baidu.live.view.web.h
        public void jr(String str) {
            if (!TextUtils.isEmpty(str)) {
                c cVar = new c();
                cVar.isFullScreen = a.this.aZ(str, "fullscreen");
                cVar.url = str;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
            }
        }
    };
    private d bRv;
    private CustomMessageListener bRw;
    private Activity beD;

    public a(Activity activity) {
        this.beD = activity;
        YP();
    }

    public void a(c cVar) {
        if (cVar != null && !TextUtils.isEmpty(cVar.url)) {
            String str = cVar.url;
            dismiss();
            this.bRv = new d(this.beD);
            this.bRv.getWebView().setBackgroundColor(iu(str));
            g gVar = new g();
            gVar.x(this.beD).a(this.bRv).a(this.bRv.getWebView().getSchemeCallback()).b(this.bRm);
            com.baidu.live.view.web.a[] YO = gVar.YO();
            for (com.baidu.live.view.web.a aVar : YO) {
                this.bRv.getWebView().addJavascriptInterface(aVar, aVar.getName());
            }
            this.bRv.b(cVar);
        }
    }

    public void resume() {
        if (this.bRv != null && this.bRv.isShowing() && this.bRv.getWebView() != null) {
            this.bRv.getWebView().onResume();
        }
    }

    public void pause() {
        if (this.bRv != null && this.bRv.isShowing() && this.bRv.getWebView() != null) {
            this.bRv.getWebView().onPause();
        }
    }

    public void dismiss() {
        if (this.bRv != null) {
            this.bRv.YQ();
            this.bRv = null;
        }
    }

    public void dX(int i) {
        if (this.bRv != null && this.bRv.isShowing()) {
            this.bRv.dX(i);
        }
    }

    public void IB() {
        dismiss();
    }

    public void release() {
        IB();
        MessageManager.getInstance().unRegisterListener(this.bRw);
        this.bRw = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aZ(String str, String str2) {
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

    private void YP() {
        if (this.bRw == null) {
            this.bRw = new CustomMessageListener(2913123) { // from class: com.baidu.live.ao.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.bRv != null && a.this.bRv.isShowing()) {
                        a.this.bRv.dismiss();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bRw);
        }
    }

    private int iu(String str) {
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
            return (parseInt < 0 || parseInt > 255) ? 0 : ColorUtils.setAlphaComponent(Color.parseColor(UgcConstant.TOPIC_PATTERN_TAG + str2.substring(0, 6)), parseInt);
        } catch (Exception e) {
            return 0;
        }
    }
}
