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

    public void rd(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean a2 = ai.a(str, stringBuffer);
        final String stringBuffer2 = stringBuffer.toString();
        setIcon(a.e.aiapps_empty_icon_error);
        setTitle(a.h.aiapps_emptyview_domain_error_title);
        com.baidu.swan.apps.am.a tt = new com.baidu.swan.apps.am.a().bX(5L).bY(41L).tt("domain not in white list--" + stringBuffer2);
        final e aDb = e.aDb();
        if (aDb != null) {
            final String format = String.format(getContext().getResources().getString(a.h.aiapps_open_failed_detail_format), ak.getVersionName(), com.baidu.swan.apps.swancore.b.a(f.avu().auW(), aDb.abu().getAppFrameType()), String.valueOf(tt.aHv()));
            setSubTitle("(" + (a2 ? stringBuffer2 : format) + ")");
            this.cZd.setVisibility(0);
            this.cZd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.ui.DomainErrorView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.swan.apps.t.a.asp().d(aDb.aCU(), aDb.getAppKey(), aDb.getName(), ai.cB(format, stringBuffer2));
                }
            });
        }
        this.mTitle.setText(getResources().getText(a.h.swanapp_path_forbidden));
        this.mSubTitle.setPadding(ah.J(70.0f), 0, ah.J(70.0f), 0);
        h.b(new com.baidu.swan.apps.statistic.a.d().i(tt).sB(h.kd(0)).sC(e.aDc()).cr("errorDomain", stringBuffer2).cr("path", ak.aII().getPage()));
    }
}
