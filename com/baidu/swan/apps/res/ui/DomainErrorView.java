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
/* loaded from: classes10.dex */
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

    public void rw(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean a2 = ai.a(str, stringBuffer);
        final String stringBuffer2 = stringBuffer.toString();
        setIcon(a.e.aiapps_empty_icon_error);
        setTitle(a.h.aiapps_emptyview_domain_error_title);
        com.baidu.swan.apps.am.a tM = new com.baidu.swan.apps.am.a().bZ(5L).ca(41L).tM("domain not in white list--" + stringBuffer2);
        final e aEV = e.aEV();
        if (aEV != null) {
            final String format = String.format(getContext().getResources().getString(a.h.aiapps_open_failed_detail_format), ak.getVersionName(), com.baidu.swan.apps.swancore.b.a(f.axo().awQ(), aEV.ado().getAppFrameType()), String.valueOf(tM.aJp()));
            setSubTitle("(" + (a2 ? stringBuffer2 : format) + ")");
            this.dhE.setVisibility(0);
            this.dhE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.ui.DomainErrorView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.swan.apps.t.a.auj().d(aEV.aEO(), aEV.getAppKey(), aEV.getName(), ai.cI(format, stringBuffer2));
                }
            });
        }
        this.mTitle.setText(getResources().getText(a.h.swanapp_path_forbidden));
        this.mSubTitle.setPadding(ah.L(70.0f), 0, ah.L(70.0f), 0);
        h.b(new com.baidu.swan.apps.statistic.a.d().i(tM).sU(h.ko(0)).sV(e.aEW()).cy("errorDomain", stringBuffer2).cy("path", ak.aKC().getPage()));
    }
}
