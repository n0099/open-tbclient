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

    public void se(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean a2 = ai.a(str, stringBuffer);
        final String stringBuffer2 = stringBuffer.toString();
        setIcon(a.e.aiapps_empty_icon_error);
        setTitle(a.h.aiapps_emptyview_domain_error_title);
        com.baidu.swan.apps.al.a uz = new com.baidu.swan.apps.al.a().cV(5L).cW(41L).uz("domain not in white list--" + stringBuffer2);
        final e aMl = e.aMl();
        if (aMl != null) {
            final String format = String.format(getContext().getResources().getString(a.h.aiapps_open_failed_detail_format), ak.getVersionName(), com.baidu.swan.apps.swancore.b.a(f.aDG().aDi(), aMl.aju().getAppFrameType()), String.valueOf(uz.aQF()));
            setSubTitle("(" + (a2 ? stringBuffer2 : format) + ")");
            this.dxX.setVisibility(0);
            this.dxX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.ui.DomainErrorView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.swan.apps.t.a.aAA().f(aMl.aMe(), aMl.getAppKey(), aMl.getName(), ai.cN(format, stringBuffer2));
                }
            });
        }
        this.mTitle.setText(getResources().getText(a.h.swanapp_path_forbidden));
        this.dxT.setPadding(ah.O(70.0f), 0, ah.O(70.0f), 0);
        h.b(new com.baidu.swan.apps.statistic.a.d().i(uz).tH(h.kX(0)).tI(e.aMm()).cD("errorDomain", stringBuffer2).cD("path", ak.aRR().getPage()));
    }
}
