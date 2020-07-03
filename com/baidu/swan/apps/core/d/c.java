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
    private com.baidu.swan.apps.v.b.b bLT;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_error_fragment, viewGroup, false);
        ag(inflate);
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
        eU(-1);
        eV(ViewCompat.MEASURED_STATE_MASK);
        dH(true);
        setRightZoneVisibility(false);
        String acZ = this.bLT == null ? "" : this.bLT.acZ();
        if (!TextUtils.isEmpty(acZ)) {
            jq(acZ);
        }
        this.bZO.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.Zk();
            }
        });
    }

    public void ag(View view) {
        if (aIB() == null) {
            if (DEBUG) {
                Log.e("SwanAppErrorFragment", "getIntent() is null");
                return;
            }
            return;
        }
        this.bLT = ((SwanAppErrorActivity) aIB()).Sb();
        if (this.bLT == null) {
            if (DEBUG) {
                Log.e("SwanAppErrorFragment", "launchInfo is null,error");
                return;
            }
            return;
        }
        ((LinearLayout) view.findViewById(a.f.error_layout)).setBackgroundColor(getResources().getColor(a.c.aiapps_error_fragment_background));
        TextView textView = (TextView) view.findViewById(a.f.ai_apps_error_msg);
        textView.setText(this.bLT.ahE());
        textView.setTextColor(getResources().getColor(a.c.aiapps_error_msg_color));
        TextView textView2 = (TextView) view.findViewById(a.f.ai_apps_error_text_one);
        textView2.setText(this.bLT.ahD());
        textView2.setTextColor(getResources().getColor(a.c.aiapps_error_detail_color));
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void YV() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean UE() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean YW() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Ui() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void UI() {
    }
}
