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
    private String boC;
    private JSONObject boD;
    private boolean boE = true;

    public static f az(String str, String str2) {
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
            this.boC = arguments.getString("plugin_fun_page_path");
            this.boD = s.parseString(arguments.getString("plugin_pay_params"));
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
        com.baidu.swan.apps.runtime.d.acF().acC().acS().aee();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void ae(View view) {
        ag(view);
        et(-1);
        eu(ViewCompat.MEASURED_STATE_MASK);
        gS(getString(a.h.swan_app_plugin_fun_page_title));
        cr(true);
        setRightZoneVisibility(false);
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Ny() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Ji() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Nz() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean IN() {
        if (this.boE && this.boD != null) {
            com.baidu.swan.apps.ag.c.c.a aVar = new com.baidu.swan.apps.ag.c.c.a(this.boD.optString("componentId"));
            aVar.biB = this.boD.optString("slaveId");
            aVar.aaj();
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Jl() {
    }

    private void initView(View view) {
        if (view != null && this.boD != null) {
            TextView textView = (TextView) view.findViewById(a.f.id_swan_app_plugin_app_name);
            com.baidu.swan.apps.runtime.e acJ = com.baidu.swan.apps.runtime.e.acJ();
            if (acJ != null) {
                textView.setText(acJ.GJ().Re());
            }
            final JSONObject optJSONObject = this.boD.optJSONObject("args");
            if (optJSONObject != null) {
                ((TextView) view.findViewById(a.f.id_swan_app_plugin_money)).setText(String.format(Locale.CHINA, "%.2f", Double.valueOf((optJSONObject.optLong("fee") * 1.0d) / 100.0d)));
                TextView textView2 = (TextView) view.findViewById(a.f.id_swan_app_plugin_service_name);
                com.baidu.swan.pms.model.h kj = com.baidu.swan.apps.ag.g.b.kj(this.boD.optString("pluginProvider"));
                if (kj != null) {
                    textView2.setText(kj.appName);
                }
                ((Button) view.findViewById(a.f.id_swan_app_plugin_pay)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.f.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        com.baidu.swan.apps.y.f.WV().a(new com.baidu.swan.apps.ag.c.c.b(f.this.boC, optJSONObject.toString(), f.this.boD.optString("slaveId")).aak());
                        f.this.boE = false;
                    }
                });
            }
        }
    }
}
