package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ai;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.v.f;
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

    public void rl(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean a2 = ai.a(str, stringBuffer);
        final String stringBuffer2 = stringBuffer.toString();
        setIcon(a.e.aiapps_empty_icon_error);
        setTitle(a.h.aiapps_emptyview_domain_error_title);
        com.baidu.swan.apps.al.a tH = new com.baidu.swan.apps.al.a().db(5L).dc(41L).tH("domain not in white list--" + stringBuffer2);
        final e aIL = e.aIL();
        if (aIL != null) {
            final String format = String.format(getContext().getResources().getString(a.h.aiapps_open_failed_detail_format), ak.getVersionName(), com.baidu.swan.apps.swancore.b.a(f.aAl().azN(), aIL.afZ().getAppFrameType()), String.valueOf(tH.aNf()));
            setSubTitle("(" + (a2 ? stringBuffer2 : format) + ")");
            this.dvv.setVisibility(0);
            this.dvv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.ui.DomainErrorView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.swan.apps.t.a.axf().f(aIL.aIE(), aIL.getAppKey(), aIL.getName(), ai.cG(format, stringBuffer2));
                }
            });
        }
        this.mTitle.setText(getResources().getText(a.h.swanapp_path_forbidden));
        this.dvr.setPadding(ah.P(70.0f), 0, ah.P(70.0f), 0);
        h.b(new com.baidu.swan.apps.statistic.a.d().i(tH).sP(h.ju(0)).sQ(e.aIM()).cw("errorDomain", stringBuffer2).cw("path", ak.aOr().getPage()));
    }
}
