package com.baidu.swan.apps.core.c;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.m;
/* loaded from: classes2.dex */
public class c extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private TextView aqn;
    private TextView aqo;
    private LinearLayout mRootLayout;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_error_fragment, viewGroup, false);
        O(inflate);
        M(inflate);
        if (yi()) {
            return Q(inflate);
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.c.b
    public void M(View view) {
        super.M(view);
        cb(-1);
        cc(ViewCompat.MEASURED_STATE_MASK);
        aW(true);
        setRightMenuVisibility(false);
        String a = m.a(this.mActivity.getIntent(), "aiapps_app_title");
        if (!TextUtils.isEmpty(a)) {
            dT(a);
        }
        this.aqa.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.yd();
            }
        });
    }

    public void O(View view) {
        if (Sw() == null) {
            if (DEBUG) {
                Log.e("SwanAppErrorFragment", "getIntent() is null");
                return;
            }
            return;
        }
        com.baidu.swan.apps.v.b.b uA = ((SwanAppErrorActivity) Sw()).uA();
        if (uA == null) {
            if (DEBUG) {
                Log.e("SwanAppErrorFragment", "launchInfo is null,error");
                return;
            }
            return;
        }
        this.mRootLayout = (LinearLayout) view.findViewById(a.f.error_layout);
        this.mRootLayout.setBackgroundColor(getResources().getColor(a.c.aiapps_error_fragment_background));
        this.aqn = (TextView) view.findViewById(a.f.ai_apps_error_msg);
        this.aqn.setText(uA.mErrorMsg);
        this.aqn.setTextColor(getResources().getColor(a.c.aiapps_error_msg_color));
        this.aqo = (TextView) view.findViewById(a.f.ai_apps_error_text_one);
        this.aqo.setText(uA.axM);
        this.aqo.setTextColor(getResources().getColor(a.c.aiapps_error_detail_color));
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xW() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.c.b
    public boolean xX() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.c.b
    public boolean vX() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xV() {
    }
}
