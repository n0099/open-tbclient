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
/* loaded from: classes8.dex */
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

    public void rt(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean a2 = ai.a(str, stringBuffer);
        final String stringBuffer2 = stringBuffer.toString();
        setIcon(a.e.aiapps_empty_icon_error);
        setTitle(a.h.aiapps_emptyview_domain_error_title);
        com.baidu.swan.apps.al.a tO = new com.baidu.swan.apps.al.a().db(5L).dc(41L).tO("domain not in white list--" + stringBuffer2);
        final e aIO = e.aIO();
        if (aIO != null) {
            final String format = String.format(getContext().getResources().getString(a.h.aiapps_open_failed_detail_format), ak.getVersionName(), com.baidu.swan.apps.swancore.b.a(f.aAo().azQ(), aIO.agc().getAppFrameType()), String.valueOf(tO.aNi()));
            setSubTitle("(" + (a2 ? stringBuffer2 : format) + ")");
            this.dwW.setVisibility(0);
            this.dwW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.ui.DomainErrorView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.swan.apps.t.a.axi().f(aIO.aIH(), aIO.getAppKey(), aIO.getName(), ai.cG(format, stringBuffer2));
                }
            });
        }
        this.mTitle.setText(getResources().getText(a.h.swanapp_path_forbidden));
        this.dwS.setPadding(ah.T(70.0f), 0, ah.T(70.0f), 0);
        h.b(new com.baidu.swan.apps.statistic.a.d().i(tO).sW(h.jv(0)).sX(e.aIP()).cw("errorDomain", stringBuffer2).cw("path", ak.aOu().getPage()));
    }
}
