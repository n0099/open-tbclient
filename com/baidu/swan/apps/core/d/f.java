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
import com.baidu.swan.apps.aq.t;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f extends b {
    private String bVX;
    private JSONObject bVY;
    private boolean bVZ = true;

    public static f aZ(String str, String str2) {
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
            this.bVX = arguments.getString("plugin_fun_page_path");
            this.bVY = t.parseString(arguments.getString("plugin_pay_params"));
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.swan_app_plugin_fun_page_fragment, viewGroup, false);
        ae(inflate);
        ag(inflate);
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
        com.baidu.swan.apps.runtime.d.aoB().aox().aoR().aql();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void ae(View view) {
        ah(view);
        eJ(-1);
        eK(ViewCompat.MEASURED_STATE_MASK);
        ji(getString(a.h.swan_app_plugin_fun_page_title));
        dC(true);
        setRightZoneVisibility(false);
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void XP() {
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Ty() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean XQ() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Tc() {
        if (this.bVZ && this.bVY != null) {
            com.baidu.swan.apps.ae.c.c.a aVar = new com.baidu.swan.apps.ae.c.c.a(this.bVY.optString("componentId"));
            aVar.bPG = this.bVY.optString("slaveId");
            aVar.alU();
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void TC() {
    }

    private void ag(View view) {
        if (view != null && this.bVY != null) {
            TextView textView = (TextView) view.findViewById(a.f.id_swan_app_plugin_app_name);
            com.baidu.swan.apps.runtime.e aoG = com.baidu.swan.apps.runtime.e.aoG();
            if (aoG != null) {
                textView.setText(aoG.QJ().abT());
            }
            final JSONObject optJSONObject = this.bVY.optJSONObject("args");
            if (optJSONObject != null) {
                ((TextView) view.findViewById(a.f.id_swan_app_plugin_money)).setText(String.format(Locale.CHINA, "%.2f", Double.valueOf((optJSONObject.optLong("fee") * 1.0d) / 100.0d)));
                TextView textView2 = (TextView) view.findViewById(a.f.id_swan_app_plugin_service_name);
                com.baidu.swan.pms.model.h mN = com.baidu.swan.apps.ae.g.b.mN(this.bVY.optString("pluginProvider"));
                if (mN != null) {
                    textView2.setText(mN.appName);
                }
                ((Button) view.findViewById(a.f.id_swan_app_plugin_pay)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.f.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        com.baidu.swan.apps.w.f.ahV().a(new com.baidu.swan.apps.ae.c.c.b(f.this.bVX, optJSONObject.toString(), f.this.bVY.optString("slaveId")).alV());
                        f.this.bVZ = false;
                    }
                });
            }
        }
    }
}
