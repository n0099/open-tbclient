package com.baidu.swan.apps.core.d;

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
/* loaded from: classes11.dex */
public class c extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.x.b.b baT;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_error_fragment, viewGroup, false);
        initView(inflate);
        ae(inflate);
        if (immersionEnabled()) {
            return initImmersion(inflate);
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void ae(View view) {
        super.ae(view);
        et(-1);
        eu(ViewCompat.MEASURED_STATE_MASK);
        cq(true);
        setRightZoneVisibility(false);
        String QZ = this.baT == null ? "" : this.baT.QZ();
        if (!TextUtils.isEmpty(QZ)) {
            gT(QZ);
        }
        this.bnv.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.onActionBarBackPressed();
            }
        });
    }

    public void initView(View view) {
        if (auy() == null) {
            if (DEBUG) {
                Log.e("SwanAppErrorFragment", "getIntent() is null");
                return;
            }
            return;
        }
        this.baT = ((SwanAppErrorActivity) auy()).GQ();
        if (this.baT == null) {
            if (DEBUG) {
                Log.e("SwanAppErrorFragment", "launchInfo is null,error");
                return;
            }
            return;
        }
        ((LinearLayout) view.findViewById(a.f.error_layout)).setBackgroundColor(getResources().getColor(a.c.aiapps_error_fragment_background));
        TextView textView = (TextView) view.findViewById(a.f.ai_apps_error_msg);
        textView.setText(this.baT.Vv());
        textView.setTextColor(getResources().getColor(a.c.aiapps_error_msg_color));
        TextView textView2 = (TextView) view.findViewById(a.f.ai_apps_error_text_one);
        textView2.setText(this.baT.Vu());
        textView2.setTextColor(getResources().getColor(a.c.aiapps_error_detail_color));
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Nt() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Jd() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Nu() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean II() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Jg() {
    }
}
