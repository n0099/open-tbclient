package com.baidu.swan.apps.q;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.statistic.a.e;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.apps.storage.c.g;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private g bUu;
    private SharedPreferences.Editor mEditor;

    /* loaded from: classes11.dex */
    public interface a {
        void VJ();
    }

    private c() {
        this.bUu = new g("aiapps_guide_dialog_sp");
        this.mEditor = this.bUu.edit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static final class b {
        private static final c bUA = new c();
    }

    public static c abb() {
        return b.bUA;
    }

    private int bE(@NonNull Context context) {
        PackageInfo packageInfo = ai.getPackageInfo(context, context.getPackageName());
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return -1;
    }

    private void I(@NonNull Activity activity) {
        dB(false);
        fb(bE(activity));
    }

    private void dB(boolean z) {
        this.mEditor.putBoolean("new_first_in", z).apply();
    }

    private void fb(int i) {
        if (DEBUG) {
            Log.e("SwanAppGuideDialogManager", "versionCode " + i);
        }
        this.mEditor.putInt("up_first_in", i).apply();
    }

    public void a(@NonNull Activity activity, final String str, final String str2, final a aVar) {
        if (activity != null && !activity.isFinishing() && SwanAppNetworkUtils.isNetworkConnected(activity)) {
            final com.baidu.swan.apps.res.widget.dialog.c cVar = new com.baidu.swan.apps.res.widget.dialog.c(activity, a.i.SwanFavoriteGuideDialog);
            com.baidu.swan.apps.as.c.b(activity, cVar);
            cVar.setContentView(a.g.aiapps_entry_guide_layout);
            View findViewById = cVar.findViewById(a.f.root);
            cVar.findViewById(a.f.nightmode_mask).setVisibility(com.baidu.swan.apps.w.a.acj().getNightModeSwitcherState() ? 0 : 8);
            if (TextUtils.isEmpty(str)) {
                LottieAnimationView lottieAnimationView = (LottieAnimationView) cVar.findViewById(a.f.aiapps_guide_anim_view);
                lottieAnimationView.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                layoutParams.height = af.dip2px(activity, 312.3f);
                findViewById.setLayoutParams(layoutParams);
                lottieAnimationView.setImageAssetsFolder("lottieImage/images");
                lottieAnimationView.setAnimation("lottieImage/closeGuide.json");
                lottieAnimationView.playAnimation();
            } else {
                findViewById.setBackground(activity.getResources().getDrawable(a.e.aiapps_entry_guide_bg));
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) cVar.findViewById(a.f.aiapps_guide_image);
                simpleDraweeView.setVisibility(0);
                cVar.findViewById(a.f.aiapps_split_line).setVisibility(0);
                simpleDraweeView.setController(com.facebook.drawee.a.a.c.dnM().vC(true).Og(str).doD());
            }
            TextView textView = (TextView) cVar.findViewById(a.f.aiapps_bottom_button);
            textView.setOnTouchListener(new d());
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.q.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.y(str, str2, "click");
                    cVar.dismiss();
                    if (aVar != null) {
                        aVar.VJ();
                    }
                }
            });
            cVar.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.swan.apps.q.c.2
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    c.this.y(str, str2, "show");
                }
            });
            cVar.show();
            I(activity);
            if (DEBUG) {
                Log.e("SwanAppGuideDialogManager", "dialog has shown");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            e eVar = new e();
            eVar.mPage = f.gz(com.baidu.swan.apps.runtime.d.akJ().Ol());
            eVar.mType = str3;
            if (TextUtils.equals(str2, "source_back")) {
                eVar.mValue = "back";
            } else {
                eVar.mValue = "close";
                eVar.mSource = str2;
            }
            eVar.s("appid", com.baidu.swan.apps.runtime.e.akO());
            eVar.s("img", str);
            f.a("970", eVar);
        }
    }

    public boolean abc() {
        com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
        if (akM == null) {
            return false;
        }
        return akM.alc().b("boolean_var_key_fav_guide_show", (Boolean) false).booleanValue();
    }
}
