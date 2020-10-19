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
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
/* loaded from: classes10.dex */
public class d extends c {
    private ForbiddenInfo cgf;
    private String cgg;

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
            this.cgg = arguments.getString("swan_error_type");
            this.cgf = (ForbiddenInfo) arguments.getParcelable("key_forbidden_info");
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_error_fragment, viewGroup, false);
        an(inflate);
        al(inflate);
        if (immersionEnabled()) {
            return initImmersion(inflate);
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void al(View view) {
        super.al(view);
        hB(-1);
        hC(ViewCompat.MEASURED_STATE_MASK);
        eq(false);
        setRightZoneVisibility(true);
        this.cvM.setRightMenuOnClickListener(null);
        this.cvM.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (d.this.mActivity != null) {
                    d.this.mActivity.finish();
                }
            }
        });
        if (this.cgf != null && !TextUtils.isEmpty(this.cgf.appTitle)) {
            mm(this.cgf.appTitle);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0169  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void an(View view) {
        String str;
        final com.baidu.swan.apps.u.c.b abG;
        final String str2 = null;
        if (view != null) {
            ImageView imageView = (ImageView) view.findViewById(a.f.ai_apps_error_image);
            TextView textView = (TextView) view.findViewById(a.f.ai_apps_emptyview_btn);
            TextView textView2 = (TextView) view.findViewById(a.f.ai_apps_error_text_one);
            TextView textView3 = (TextView) view.findViewById(a.f.ai_apps_error_feedback);
            if (this.cgg != null) {
                String str3 = this.cgg;
                char c = 65535;
                switch (str3.hashCode()) {
                    case -1242268664:
                        if (str3.equals("type_need_update_sdk")) {
                            c = 4;
                            break;
                        }
                        break;
                    case -429452284:
                        if (str3.equals("type_path_forbidden")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 38398066:
                        if (str3.equals("type_network_error")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 157273878:
                        if (str3.equals("type_app_forbidden")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 731215244:
                        if (str3.equals("type_normal")) {
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
                    case 4:
                        String string2 = getContext().getString(a.h.swanapp_normal_error);
                        textView.setVisibility(8);
                        str = string2;
                        break;
                }
                TextView textView4 = (TextView) view.findViewById(a.f.ai_apps_error_msg);
                if (str == null) {
                    str = getContext().getString(a.h.swanapp_normal_error);
                }
                textView4.setText(str);
                abG = !(this.mActivity instanceof SwanAppErrorActivity) ? ((SwanAppErrorActivity) this.mActivity).abG() : null;
                com.baidu.swan.apps.runtime.e aDb = com.baidu.swan.apps.runtime.e.aDb();
                if (abG == null) {
                    str2 = abG.getAppId();
                } else if (aDb != null) {
                    str2 = aDb.getAppKey();
                }
                if (this.cgf != null && !TextUtils.isEmpty(this.cgf.forbiddenDetail)) {
                    textView2.setText("(" + this.cgf.forbiddenDetail + ")");
                    textView2.setTextColor(getResources().getColor(a.c.aiapps_error_detail_color));
                }
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.d.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (d.this.mActivity != null && SwanAppNetworkUtils.isNetworkConnected(d.this.mActivity)) {
                            SwanLauncher.aoP().a(abG, (Bundle) null);
                            d.this.mActivity.finish();
                        }
                    }
                });
                if (!ak.aIG() && !TextUtils.equals(this.cgg, "type_network_error")) {
                    textView3.setVisibility(0);
                    textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.d.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (d.this.cgf != null && !TextUtils.isEmpty(d.this.cgf.forbiddenDetail)) {
                                com.baidu.swan.apps.t.a.asp().d(d.this.aYo(), str2, d.this.cgf.appTitle, d.this.cgf.forbiddenDetail);
                            }
                        }
                    });
                    return;
                }
            }
            str = null;
            TextView textView42 = (TextView) view.findViewById(a.f.ai_apps_error_msg);
            if (str == null) {
            }
            textView42.setText(str);
            if (!(this.mActivity instanceof SwanAppErrorActivity)) {
            }
            com.baidu.swan.apps.runtime.e aDb2 = com.baidu.swan.apps.runtime.e.aDb();
            if (abG == null) {
            }
            if (this.cgf != null) {
                textView2.setText("(" + this.cgf.forbiddenDetail + ")");
                textView2.setTextColor(getResources().getColor(a.c.aiapps_error_detail_color));
            }
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.mActivity != null && SwanAppNetworkUtils.isNetworkConnected(d.this.mActivity)) {
                        SwanLauncher.aoP().a(abG, (Bundle) null);
                        d.this.mActivity.finish();
                    }
                }
            });
            if (!ak.aIG()) {
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void ajv() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean aeI() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean ajw() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aeh() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aeO() {
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return akk();
    }

    private boolean akk() {
        if (this.cgf == null) {
            return false;
        }
        return this.cgf.akk();
    }
}
