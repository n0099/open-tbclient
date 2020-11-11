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
/* loaded from: classes10.dex */
public class g extends c {
    private String cLc;
    private JSONObject cLd;
    private boolean cLe = true;

    public static g bx(String str, String str2) {
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
            this.cLc = arguments.getString("plugin_fun_page_path");
            this.cLd = v.parseString(arguments.getString("plugin_pay_params"));
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.swan_app_plugin_fun_page_fragment, viewGroup, false);
        ar(inflate);
        al(inflate);
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
        com.baidu.swan.apps.runtime.d.aHq().aHm().aHG().aJe();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ar(View view) {
        at(view);
        hW(-1);
        hX(ViewCompat.MEASURED_STATE_MASK);
        mU(getString(a.h.swan_app_plugin_fun_page_title));
        eM(true);
        setRightZoneVisibility(false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void anP() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean ajc() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean anQ() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aiB() {
        if (this.cLe && this.cLd != null) {
            com.baidu.swan.apps.ac.c.c.a aVar = new com.baidu.swan.apps.ac.c.c.a(this.cLd.optString("componentId"));
            aVar.cDL = this.cLd.optString("slaveId");
            aVar.aEu();
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aji() {
    }

    private void al(View view) {
        if (view != null && this.cLd != null) {
            TextView textView = (TextView) view.findViewById(a.f.id_swan_app_plugin_app_name);
            com.baidu.swan.apps.runtime.e aHv = com.baidu.swan.apps.runtime.e.aHv();
            if (aHv != null) {
                textView.setText(aHv.afO().asF());
            }
            final JSONObject optJSONObject = this.cLd.optJSONObject("args");
            if (optJSONObject != null) {
                ((TextView) view.findViewById(a.f.id_swan_app_plugin_money)).setText(String.format(Locale.CHINA, "%.2f", Double.valueOf((optJSONObject.optLong("fee") * 1.0d) / 100.0d)));
                TextView textView2 = (TextView) view.findViewById(a.f.id_swan_app_plugin_service_name);
                com.baidu.swan.pms.model.h rn = com.baidu.swan.apps.ac.g.b.rn(this.cLd.optString("pluginProvider"));
                if (rn != null) {
                    textView2.setText(rn.appName);
                }
                ((Button) view.findViewById(a.f.id_swan_app_plugin_pay)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        com.baidu.swan.apps.v.f.azO().b(new com.baidu.swan.apps.ac.c.c.b(g.this.cLc, optJSONObject.toString(), g.this.cLd.optString("slaveId")).aEv());
                        g.this.cLe = false;
                    }
                });
            }
        }
    }
}
