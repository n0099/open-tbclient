package com.baidu.swan.apps.core.d;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.v;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class g extends c {
    private String ciq;
    private JSONObject cir;
    private boolean cis = true;

    public static g bl(String str, String str2) {
        g gVar = new g();
        if (!TextUtils.isEmpty(str2)) {
            Bundle bundle = new Bundle();
            bundle.putString("plugin_fun_page_path", str);
            bundle.putString("plugin_pay_params", str2);
            gVar.setArguments(bundle);
        }
        return gVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.ciq = arguments.getString("plugin_fun_page_path");
            this.cir = v.parseString(arguments.getString("plugin_pay_params"));
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.swan_app_plugin_fun_page_fragment, viewGroup, false);
        ai(inflate);
        ak(inflate);
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        setRequestedOrientation(1);
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        this.mActivity = null;
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.swan.apps.runtime.d.azE().azA().azU().aBr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ai(View view) {
        al(view);
        gV(-1);
        gW(ViewCompat.MEASURED_STATE_MASK);
        lg(getString(a.h.swan_app_plugin_fun_page_title));
        dV(true);
        setRightZoneVisibility(false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aga() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean abn() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean agb() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aaM() {
        if (this.cis && this.cir != null) {
            com.baidu.swan.apps.ac.c.c.a aVar = new com.baidu.swan.apps.ac.c.c.a(this.cir.optString("componentId"));
            aVar.caU = this.cir.optString("slaveId");
            aVar.awG();
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void abt() {
    }

    private void ak(View view) {
        if (view != null && this.cir != null) {
            TextView textView = (TextView) view.findViewById(a.f.id_swan_app_plugin_app_name);
            com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
            if (azJ != null) {
                textView.setText(azJ.XZ().akO());
            }
            final JSONObject optJSONObject = this.cir.optJSONObject("args");
            if (optJSONObject != null) {
                ((TextView) view.findViewById(a.f.id_swan_app_plugin_money)).setText(String.format(Locale.CHINA, "%.2f", Double.valueOf((optJSONObject.optLong("fee") * 1.0d) / 100.0d)));
                TextView textView2 = (TextView) view.findViewById(a.f.id_swan_app_plugin_service_name);
                com.baidu.swan.pms.model.h pA = com.baidu.swan.apps.ac.g.b.pA(this.cir.optString("pluginProvider"));
                if (pA != null) {
                    textView2.setText(pA.appName);
                }
                ((Button) view.findViewById(a.f.id_swan_app_plugin_pay)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        com.baidu.swan.apps.v.f.arY().b(new com.baidu.swan.apps.ac.c.c.b(g.this.ciq, optJSONObject.toString(), g.this.cir.optString("slaveId")).awH());
                        g.this.cis = false;
                    }
                });
            }
        }
    }
}
