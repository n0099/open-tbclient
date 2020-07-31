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
import com.baidu.swan.apps.aq.v;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g extends c {
    private String cct;
    private JSONObject ccu;
    private boolean ccv = true;

    public static g bd(String str, String str2) {
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
            this.cct = arguments.getString("plugin_fun_page_path");
            this.ccu = v.parseString(arguments.getString("plugin_pay_params"));
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.swan_app_plugin_fun_page_fragment, viewGroup, false);
        ah(inflate);
        aj(inflate);
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
        com.baidu.swan.apps.runtime.d.arr().arn().arH().atj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ah(View view) {
        ak(view);
        eZ(-1);
        fa(ViewCompat.MEASURED_STATE_MASK);
        jH(getString(a.h.swan_app_plugin_fun_page_title));
        dL(true);
        setRightZoneVisibility(false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void ZQ() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean Vi() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean ZR() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean UJ() {
        if (this.ccv && this.ccu != null) {
            com.baidu.swan.apps.ad.c.c.a aVar = new com.baidu.swan.apps.ad.c.c.a(this.ccu.optString("componentId"));
            aVar.bVm = this.ccu.optString("slaveId");
            aVar.aoJ();
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void Vn() {
    }

    private void aj(View view) {
        if (view != null && this.ccu != null) {
            TextView textView = (TextView) view.findViewById(a.f.id_swan_app_plugin_app_name);
            com.baidu.swan.apps.runtime.e arw = com.baidu.swan.apps.runtime.e.arw();
            if (arw != null) {
                textView.setText(arw.Se().aee());
            }
            final JSONObject optJSONObject = this.ccu.optJSONObject("args");
            if (optJSONObject != null) {
                ((TextView) view.findViewById(a.f.id_swan_app_plugin_money)).setText(String.format(Locale.CHINA, "%.2f", Double.valueOf((optJSONObject.optLong("fee") * 1.0d) / 100.0d)));
                TextView textView2 = (TextView) view.findViewById(a.f.id_swan_app_plugin_service_name);
                com.baidu.swan.pms.model.h nC = com.baidu.swan.apps.ad.g.b.nC(this.ccu.optString("pluginProvider"));
                if (nC != null) {
                    textView2.setText(nC.appName);
                }
                ((Button) view.findViewById(a.f.id_swan_app_plugin_pay)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        com.baidu.swan.apps.v.f.akr().a(new com.baidu.swan.apps.ad.c.c.b(g.this.cct, optJSONObject.toString(), g.this.ccu.optString("slaveId")).aoK());
                        g.this.ccv = false;
                    }
                });
            }
        }
    }
}
