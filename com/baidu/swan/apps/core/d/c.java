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
/* loaded from: classes2.dex */
public class c extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.v.b.b aEi;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_error_fragment, viewGroup, false);
        W(inflate);
        U(inflate);
        if (EI()) {
            return Y(inflate);
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void U(View view) {
        super.U(view);
        cY(-1);
        cZ(ViewCompat.MEASURED_STATE_MASK);
        bv(true);
        setRightZoneVisibility(false);
        String Ht = this.aEi == null ? "" : this.aEi.Ht();
        if (!TextUtils.isEmpty(Ht)) {
            eu(Ht);
        }
        this.aKy.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.ED();
            }
        });
    }

    public void W(View view) {
        if (abV() == null) {
            if (DEBUG) {
                Log.e("SwanAppErrorFragment", "getIntent() is null");
                return;
            }
            return;
        }
        this.aEi = ((SwanAppErrorActivity) abV()).AJ();
        if (this.aEi == null) {
            if (DEBUG) {
                Log.e("SwanAppErrorFragment", "launchInfo is null,error");
                return;
            }
            return;
        }
        ((LinearLayout) view.findViewById(a.f.error_layout)).setBackgroundColor(getResources().getColor(a.c.aiapps_error_fragment_background));
        TextView textView = (TextView) view.findViewById(a.f.ai_apps_error_msg);
        textView.setText(this.aEi.Kx());
        textView.setTextColor(getResources().getColor(a.c.aiapps_error_msg_color));
        TextView textView2 = (TextView) view.findViewById(a.f.ai_apps_error_text_one);
        textView2.setText(this.aEi.Kw());
        textView2.setTextColor(getResources().getColor(a.c.aiapps_error_detail_color));
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Eu() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean CB() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Ev() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Cn() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Et() {
    }
}
