package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.v.f;
import java.net.MalformedURLException;
import java.net.URL;
/* loaded from: classes7.dex */
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

    public void nZ(String str) {
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
        com.baidu.swan.apps.an.a qm = new com.baidu.swan.apps.an.a().bJ(5L).bK(41L).qm("domain not in white list--" + str);
        final e arw = e.arw();
        if (arw != null) {
            final String format = String.format(getContext().getResources().getString(a.h.aiapps_open_failed_detail_format), al.getVersionName(), com.baidu.swan.apps.swancore.b.a(f.akr().ajT(), arw.Se().getAppFrameType()), String.valueOf(qm.avT()));
            setSubTitle("(" + format + ")");
            this.cCI.setVisibility(0);
            this.cCI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.ui.DomainErrorView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.swan.apps.t.a.ahs().n(arw.arp(), arw.getAppKey(), format);
                }
            });
        }
        this.mTitle.setText(getResources().getText(a.h.swanapp_path_forbidden));
        this.mSubTitle.setPadding(ai.D(70.0f), 0, ai.D(70.0f), 0);
        h.b(new com.baidu.swan.apps.statistic.a.d().f(qm).pu(h.ho(0)).pv(e.arx()).bV("errorDomain", str).bV("path", al.axg().getPage()));
    }
}
