package com.baidu.swan.apps.core.d;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.v;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class g extends c {
    private String cVi;
    private JSONObject cVj;
    private boolean cVk = true;

    public static g bC(String str, String str2) {
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
            this.cVi = arguments.getString("plugin_fun_page_path");
            this.cVj = v.parseString(arguments.getString("plugin_pay_params"));
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.swan_app_plugin_fun_page_fragment, viewGroup, false);
        av(inflate);
        ap(inflate);
        if (ase()) {
            inflate = az(inflate);
        }
        return a(inflate, this);
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
        com.baidu.swan.apps.runtime.d.aMg().aMc().aMw().aNU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void av(View view) {
        ay(view);
        ik(-1);
        il(ViewCompat.MEASURED_STATE_MASK);
        no(getString(a.h.swan_app_plugin_fun_page_title));
        fn(true);
        setRightZoneVisibility(false);
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void arB() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean amM() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean arC() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aml() {
        if (this.cVk && this.cVj != null) {
            com.baidu.swan.apps.ac.c.c.a aVar = new com.baidu.swan.apps.ac.c.c.a(this.cVj.optString("componentId"));
            aVar.cNP = this.cVj.optString("slaveId");
            aVar.aIn();
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void amS() {
    }

    private void ap(View view) {
        if (view != null && this.cVj != null) {
            TextView textView = (TextView) view.findViewById(a.f.id_swan_app_plugin_app_name);
            com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
            if (aMl != null) {
                textView.setText(aMl.aju().awx());
            }
            final JSONObject optJSONObject = this.cVj.optJSONObject("args");
            if (optJSONObject != null) {
                ((TextView) view.findViewById(a.f.id_swan_app_plugin_money)).setText(String.format(Locale.CHINA, "%.2f", Double.valueOf((optJSONObject.optLong("fee") * 1.0d) / 100.0d)));
                TextView textView2 = (TextView) view.findViewById(a.f.id_swan_app_plugin_service_name);
                com.baidu.swan.pms.model.h rH = com.baidu.swan.apps.ac.g.b.rH(this.cVj.optString("pluginProvider"));
                if (rH != null) {
                    textView2.setText(rH.appName);
                }
                ((Button) view.findViewById(a.f.id_swan_app_plugin_pay)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        com.baidu.swan.apps.v.f.aDG().b(new com.baidu.swan.apps.ac.c.c.b(g.this.cVi, optJSONObject.toString(), g.this.cVj.optString("slaveId")).aIo());
                        g.this.cVk = false;
                    }
                });
            }
        }
    }
}
