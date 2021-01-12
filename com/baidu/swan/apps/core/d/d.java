package com.baidu.swan.apps.core.d;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
/* loaded from: classes8.dex */
public class d extends c {
    private ForbiddenInfo czO;
    private String czP;

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
            this.czP = arguments.getString("swan_error_type");
            this.czO = (ForbiddenInfo) arguments.getParcelable("key_forbidden_info");
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_error_fragment, viewGroup, false);
        ap(inflate);
        av(inflate);
        if (aok()) {
            return az(inflate);
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void av(View view) {
        super.av(view);
        gE(-1);
        gF(ViewCompat.MEASURED_STATE_MASK);
        fj(false);
        setRightZoneVisibility(true);
        this.cPt.setRightMenuOnClickListener(null);
        this.cPt.setRightExitOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (d.this.mActivity != null) {
                    d.this.mActivity.finish();
                }
            }
        });
        if (this.czO != null && !TextUtils.isEmpty(this.czO.appTitle)) {
            md(this.czO.appTitle);
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
    public void ap(View view) {
        String str;
        final com.baidu.swan.apps.u.c.b afN;
        final String str2 = null;
        if (view != null) {
            ImageView imageView = (ImageView) view.findViewById(a.f.ai_apps_error_image);
            TextView textView = (TextView) view.findViewById(a.f.ai_apps_emptyview_btn);
            TextView textView2 = (TextView) view.findViewById(a.f.ai_apps_error_text_one);
            TextView textView3 = (TextView) view.findViewById(a.f.ai_apps_error_feedback);
            if (this.czP != null) {
                String str3 = this.czP;
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
                afN = !(this.mActivity instanceof SwanAppErrorActivity) ? ((SwanAppErrorActivity) this.mActivity).afN() : null;
                com.baidu.swan.apps.runtime.e aIs = com.baidu.swan.apps.runtime.e.aIs();
                if (afN == null) {
                    str2 = afN.getAppId();
                } else if (aIs != null) {
                    str2 = aIs.getAppKey();
                }
                if (this.czO != null && !TextUtils.isEmpty(this.czO.forbiddenDetail)) {
                    textView2.setText("(" + this.czO.forbiddenDetail + ")");
                    textView2.setTextColor(getResources().getColor(a.c.aiapps_error_detail_color));
                }
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.d.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (d.this.mActivity != null && SwanAppNetworkUtils.isNetworkConnected(d.this.mActivity)) {
                            SwanLauncher.atk().a(afN, (Bundle) null);
                            d.this.mActivity.finish();
                        }
                    }
                });
                if (!ak.aNW() && !TextUtils.equals(this.czP, "type_network_error")) {
                    textView3.setVisibility(0);
                    textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.d.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (d.this.czO != null && !TextUtils.isEmpty(d.this.czO.forbiddenDetail)) {
                                com.baidu.swan.apps.t.a.awH().f(d.this.bdH(), str2, d.this.czO.appTitle, d.this.czO.forbiddenDetail);
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
            com.baidu.swan.apps.runtime.e aIs2 = com.baidu.swan.apps.runtime.e.aIs();
            if (afN == null) {
            }
            if (this.czO != null) {
                textView2.setText("(" + this.czO.forbiddenDetail + ")");
                textView2.setTextColor(getResources().getColor(a.c.aiapps_error_detail_color));
            }
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.mActivity != null && SwanAppNetworkUtils.isNetworkConnected(d.this.mActivity)) {
                        SwanLauncher.atk().a(afN, (Bundle) null);
                        d.this.mActivity.finish();
                    }
                }
            });
            if (!ak.aNW()) {
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void anH() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean aiT() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean anI() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean ais() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aiZ() {
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return aoB();
    }

    private boolean aoB() {
        if (this.czO == null) {
            return false;
        }
        return this.czO.aoB();
    }
}
