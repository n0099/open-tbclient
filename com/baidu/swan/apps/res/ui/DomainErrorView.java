package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.v.f;
/* loaded from: classes3.dex */
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

    public void qr(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean a = ai.a(str, stringBuffer);
        final String stringBuffer2 = stringBuffer.toString();
        setIcon(a.e.aiapps_empty_icon_error);
        setTitle(a.h.aiapps_emptyview_domain_error_title);
        com.baidu.swan.apps.am.a sH = new com.baidu.swan.apps.am.a().bP(5L).bQ(41L).sH("domain not in white list--" + stringBuffer2);
        final e aAs = e.aAs();
        if (aAs != null) {
            final String format = String.format(getContext().getResources().getString(a.h.aiapps_open_failed_detail_format), ak.getVersionName(), com.baidu.swan.apps.swancore.b.a(f.asJ().ask(), aAs.YI().getAppFrameType()), String.valueOf(sH.aEM()));
            setSubTitle("(" + (a ? stringBuffer2 : format) + ")");
            this.cNa.setVisibility(0);
            this.cNa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.ui.DomainErrorView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.swan.apps.t.a.apD().d(aAs.aAl(), aAs.getAppKey(), aAs.getName(), ai.cw(format, stringBuffer2));
                }
            });
        }
        this.mTitle.setText(getResources().getText(a.h.swanapp_path_forbidden));
        this.mSubTitle.setPadding(ah.H(70.0f), 0, ah.H(70.0f), 0);
        h.b(new com.baidu.swan.apps.statistic.a.d().i(sH).rO(h.jG(0)).rP(e.aAt()).cm("errorDomain", stringBuffer2).cm("path", ak.aFZ().getPage()));
    }
}
