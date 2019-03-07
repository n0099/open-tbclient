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
import com.baidu.swan.apps.an.m;
import com.baidu.swan.apps.b;
/* loaded from: classes2.dex */
public class c extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private TextView aqi;
    private TextView aqj;
    private LinearLayout mRootLayout;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(b.g.aiapps_error_fragment, viewGroup, false);
        O(inflate);
        M(inflate);
        if (yj()) {
            return Q(inflate);
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.c.b
    public void M(View view) {
        super.M(view);
        cc(-1);
        cd(ViewCompat.MEASURED_STATE_MASK);
        aW(true);
        setRightMenuVisibility(false);
        String a = m.a(this.mActivity.getIntent(), "aiapps_app_title");
        if (!TextUtils.isEmpty(a)) {
            dR(a);
        }
        this.apV.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.ye();
            }
        });
    }

    public void O(View view) {
        if (Sy() == null) {
            if (DEBUG) {
                Log.e("SwanAppErrorFragment", "getIntent() is null");
                return;
            }
            return;
        }
        com.baidu.swan.apps.v.b.b uB = ((SwanAppErrorActivity) Sy()).uB();
        if (uB == null) {
            if (DEBUG) {
                Log.e("SwanAppErrorFragment", "launchInfo is null,error");
                return;
            }
            return;
        }
        this.mRootLayout = (LinearLayout) view.findViewById(b.f.error_layout);
        this.mRootLayout.setBackgroundColor(getResources().getColor(b.c.aiapps_error_fragment_background));
        this.aqi = (TextView) view.findViewById(b.f.ai_apps_error_msg);
        this.aqi.setText(uB.mErrorMsg);
        this.aqi.setTextColor(getResources().getColor(b.c.aiapps_error_msg_color));
        this.aqj = (TextView) view.findViewById(b.f.ai_apps_error_text_one);
        this.aqj.setText(uB.axI);
        this.aqj.setTextColor(getResources().getColor(b.c.aiapps_error_detail_color));
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xX() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.c.b
    public boolean xY() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.c.b
    public boolean vY() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xW() {
    }
}
