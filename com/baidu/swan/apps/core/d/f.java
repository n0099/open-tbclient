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
import com.baidu.swan.apps.as.s;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f extends b {
    private String boo;
    private JSONObject bop;
    private boolean boq = true;

    public static f aA(String str, String str2) {
        f fVar = new f();
        if (!TextUtils.isEmpty(str2)) {
            Bundle bundle = new Bundle();
            bundle.putString("plugin_fun_page_path", str);
            bundle.putString("plugin_pay_params", str2);
            fVar.setArguments(bundle);
        }
        return fVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.boo = arguments.getString("plugin_fun_page_path");
            this.bop = s.parseString(arguments.getString("plugin_pay_params"));
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.swan_app_plugin_fun_page_fragment, viewGroup, false);
        ae(inflate);
        initView(inflate);
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        setRequestedOrientation(1);
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onDetach() {
        this.mActivity = null;
        super.onDetach();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.swan.apps.runtime.d.acA().acx().acN().adZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void ae(View view) {
        ag(view);
        et(-1);
        eu(ViewCompat.MEASURED_STATE_MASK);
        gT(getString(a.h.swan_app_plugin_fun_page_title));
        cq(true);
        setRightZoneVisibility(false);
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Nt() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Jd() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Nu() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean II() {
        if (this.boq && this.bop != null) {
            com.baidu.swan.apps.ag.c.c.a aVar = new com.baidu.swan.apps.ag.c.c.a(this.bop.optString("componentId"));
            aVar.bil = this.bop.optString("slaveId");
            aVar.aae();
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Jg() {
    }

    private void initView(View view) {
        if (view != null && this.bop != null) {
            TextView textView = (TextView) view.findViewById(a.f.id_swan_app_plugin_app_name);
            com.baidu.swan.apps.runtime.e acE = com.baidu.swan.apps.runtime.e.acE();
            if (acE != null) {
                textView.setText(acE.GC().QZ());
            }
            final JSONObject optJSONObject = this.bop.optJSONObject("args");
            if (optJSONObject != null) {
                ((TextView) view.findViewById(a.f.id_swan_app_plugin_money)).setText(String.format(Locale.CHINA, "%.2f", Double.valueOf((optJSONObject.optLong("fee") * 1.0d) / 100.0d)));
                TextView textView2 = (TextView) view.findViewById(a.f.id_swan_app_plugin_service_name);
                com.baidu.swan.pms.model.h kk = com.baidu.swan.apps.ag.g.b.kk(this.bop.optString("pluginProvider"));
                if (kk != null) {
                    textView2.setText(kk.appName);
                }
                ((Button) view.findViewById(a.f.id_swan_app_plugin_pay)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.f.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        com.baidu.swan.apps.y.f.WQ().a(new com.baidu.swan.apps.ag.c.c.b(f.this.boo, optJSONObject.toString(), f.this.bop.optString("slaveId")).aaf());
                        f.this.boq = false;
                    }
                });
            }
        }
    }
}
