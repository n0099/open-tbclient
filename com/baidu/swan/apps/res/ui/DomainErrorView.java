package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.f;
import java.net.MalformedURLException;
import java.net.URL;
/* loaded from: classes9.dex */
public class DomainErrorView extends CommonEmptyView {
    public DomainErrorView(Context context) {
        super(context);
    }

    public DomainErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DomainErrorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void kl(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        } else {
            try {
                URL url = new URL(str);
                if (!TextUtils.isEmpty(url.getProtocol()) && !TextUtils.isEmpty(url.getHost())) {
                    str = url.getProtocol() + "://" + url.getHost();
                }
            } catch (MalformedURLException e) {
            }
        }
        setIcon(a.e.aiapps_empty_icon_error);
        setTitle(a.h.aiapps_emptyview_domain_error_title);
        setSubTitle(String.format("不支持跳转非业务域名，请重新配置\n%s", str));
        this.mSubTitle.setPadding(af.T(70.0f), 0, af.T(70.0f), 0);
        f.b(new com.baidu.swan.apps.statistic.a.d().e(new com.baidu.swan.apps.ap.a().aB(5L).aC(41L).mh("domain not in white list--" + str)).lv(f.ga(0)).lw(e.ZU()).be("errorDomain", str).be("path", ai.aeB().getPage()));
    }
}
