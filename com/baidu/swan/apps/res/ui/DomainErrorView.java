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

    public void rE(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean a2 = ai.a(str, stringBuffer);
        final String stringBuffer2 = stringBuffer.toString();
        setIcon(a.e.aiapps_empty_icon_error);
        setTitle(a.h.aiapps_emptyview_domain_error_title);
        com.baidu.swan.apps.am.a tV = new com.baidu.swan.apps.am.a().cv(5L).cw(41L).tV("domain not in white list--" + stringBuffer2);
        final e aGN = e.aGN();
        if (aGN != null) {
            final String format = String.format(getContext().getResources().getString(a.h.aiapps_open_failed_detail_format), ak.getVersionName(), com.baidu.swan.apps.swancore.b.a(f.azg().ayI(), aGN.afg().getAppFrameType()), String.valueOf(tV.aLh()));
            setSubTitle("(" + (a2 ? stringBuffer2 : format) + ")");
            this.dlS.setVisibility(0);
            this.dlS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.ui.DomainErrorView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.swan.apps.t.a.awb().d(aGN.aGG(), aGN.getAppKey(), aGN.getName(), ai.cH(format, stringBuffer2));
                }
            });
        }
        this.mTitle.setText(getResources().getText(a.h.swanapp_path_forbidden));
        this.mSubTitle.setPadding(ah.M(70.0f), 0, ah.M(70.0f), 0);
        h.b(new com.baidu.swan.apps.statistic.a.d().i(tV).td(h.ku(0)).te(e.aGO()).cx("errorDomain", stringBuffer2).cx("path", ak.aMu().getPage()));
    }
}
