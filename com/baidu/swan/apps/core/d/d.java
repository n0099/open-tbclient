package com.baidu.swan.apps.core.d;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
/* loaded from: classes7.dex */
public class d extends c {
    private ForbiddenInfo bMr;
    private String bMs;

    public static d a(String str, ForbiddenInfo forbiddenInfo) {
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putString("swan_error_type", str);
        bundle.putParcelable("key_forbidden_info", forbiddenInfo);
        dVar.setArguments(bundle);
        return dVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.bMs = arguments.getString("swan_error_type");
            this.bMr = (ForbiddenInfo) arguments.getParcelable("key_forbidden_info");
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_error_fragment, viewGroup, false);
        aj(inflate);
        ah(inflate);
        if (immersionEnabled()) {
            return initImmersion(inflate);
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ah(View view) {
        super.ah(view);
        eZ(-1);
        fa(ViewCompat.MEASURED_STATE_MASK);
        dL(false);
        setRightZoneVisibility(true);
        this.cbt.setRightMenuOnClickListener(null);
        this.cbt.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (d.this.mActivity != null) {
                    d.this.mActivity.finish();
                }
            }
        });
        if (this.bMr != null && !TextUtils.isEmpty(this.bMr.appTitle)) {
            jH(this.bMr.appTitle);
        }
    }

    public void aj(View view) {
        if (view != null) {
            ImageView imageView = (ImageView) view.findViewById(a.f.ai_apps_error_image);
            TextView textView = (TextView) view.findViewById(a.f.ai_apps_emptyview_btn);
            TextView textView2 = (TextView) view.findViewById(a.f.ai_apps_error_text_one);
            TextView textView3 = (TextView) view.findViewById(a.f.ai_apps_error_feedback);
            String str = null;
            if (this.bMs != null) {
                String str2 = this.bMs;
                char c = 65535;
                switch (str2.hashCode()) {
                    case -429452284:
                        if (str2.equals("type_path_forbidden")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 38398066:
                        if (str2.equals("type_network_error")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 157273878:
                        if (str2.equals("type_app_forbidden")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 731215244:
                        if (str2.equals("type_normal")) {
                            c = 3;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        str = getContext().getString(a.h.swanapp_app_forbidden);
                        break;
                    case 1:
                        str = getContext().getString(a.h.swanapp_path_forbidden);
                        break;
                    case 2:
                        str = getContext().getString(a.h.aiapps_common_emptyview_detail_text);
                        imageView.setImageDrawable(getContext().getResources().getDrawable(a.e.aiapps_empty_icon_network));
                        textView.setVisibility(0);
                        textView2.setVisibility(8);
                        break;
                    case 3:
                        String string = getContext().getString(a.h.swanapp_normal_error);
                        textView.setVisibility(0);
                        str = string;
                        break;
                }
            }
            TextView textView4 = (TextView) view.findViewById(a.f.ai_apps_error_msg);
            if (str == null) {
                str = getContext().getString(a.h.swanapp_normal_error);
            }
            textView4.setText(str);
            final com.baidu.swan.apps.u.c.b Sq = ((SwanAppErrorActivity) aMt()).Sq();
            if (this.bMr != null && !TextUtils.isEmpty(this.bMr.forbiddenDetail)) {
                textView2.setText("(" + this.bMr.forbiddenDetail + ")");
                textView2.setTextColor(getResources().getColor(a.c.aiapps_error_detail_color));
            }
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.mActivity != null && SwanAppNetworkUtils.isNetworkConnected(d.this.mActivity)) {
                        SwanLauncher.aeL().a(Sq, (Bundle) null);
                        d.this.aao();
                    }
                }
            });
            if (al.axe() && !TextUtils.equals(this.bMs, "type_network_error")) {
                textView3.setVisibility(0);
                textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.d.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (d.this.bMr != null && !TextUtils.isEmpty(d.this.bMr.forbiddenDetail)) {
                            com.baidu.swan.apps.t.a.ahs().n(d.this.aMt(), Sq.getAppKey(), d.this.bMr.forbiddenDetail);
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void ZQ() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean Vi() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean ZR() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean UJ() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void Vn() {
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return aaF();
    }

    private boolean aaF() {
        if (this.bMr == null) {
            return false;
        }
        return this.bMr.aaF();
    }
}
