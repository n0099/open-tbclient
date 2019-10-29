package com.baidu.swan.apps.p;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.widget.dialog.c;
import com.baidu.swan.apps.storage.b.e;
import com.facebook.drawee.view.SimpleDraweeView;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private e aRb;
    private SharedPreferences.Editor aRc;

    /* renamed from: com.baidu.swan.apps.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0196a {
        void EV();
    }

    private a() {
        this.aRb = new e("aiapps_guide_dialog_sp");
        this.aRc = this.aRb.edit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b {
        private static final a aRg = new a();
    }

    public static a IG() {
        return b.aRg;
    }

    private boolean B(@NonNull Activity activity) {
        boolean IH = IH();
        if (DEBUG) {
            Log.e("SwanAppGuideDialogManager", "is first in " + IH);
        }
        if (IH) {
            return true;
        }
        int D = D(activity);
        int bb = bb(activity);
        if (DEBUG) {
            Log.e("SwanAppGuideDialogManager", "version =" + D + " curVerCode" + bb);
        }
        return bb > D;
    }

    private int bb(@NonNull Context context) {
        PackageInfo W = ac.W(context, context.getPackageName());
        if (W != null) {
            return W.versionCode;
        }
        return -1;
    }

    public boolean b(@NonNull WeakReference<Activity> weakReference) {
        com.baidu.swan.apps.ae.b QZ;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        Activity activity = weakReference.get();
        if (!TextUtils.equals("0", IJ()) && (QZ = com.baidu.swan.apps.ae.b.QZ()) != null && !QZ.Rj().getBoolean("boolean_var_key_fav_guide_show", false)) {
            return B(activity) && !TextUtils.isEmpty(II());
        }
        return false;
    }

    private void C(@NonNull Activity activity) {
        bD(false);
        dt(bb(activity));
    }

    private void bD(boolean z) {
        this.aRc.putBoolean("new_first_in", z).apply();
    }

    private boolean IH() {
        return this.aRb.getBoolean("new_first_in", true);
    }

    private void dt(int i) {
        if (DEBUG) {
            Log.e("SwanAppGuideDialogManager", "versionCode " + i);
        }
        this.aRc.putInt("up_first_in", i).apply();
    }

    private int D(Activity activity) {
        return this.aRb.getInt("up_first_in", bb(activity));
    }

    public String II() {
        return this.aRb.getString("url", "");
    }

    public String IJ() {
        return this.aRb.getString("switch", "1");
    }

    public boolean a(@NonNull Activity activity, String str, final InterfaceC0196a interfaceC0196a) {
        if (activity == null || activity.isFinishing() || !SwanAppNetworkUtils.isNetworkConnected(activity)) {
            return false;
        }
        final c cVar = new c(activity, a.i.SwanFavoriteGuideDialog);
        com.baidu.swan.apps.an.b.b(activity, cVar);
        cVar.setContentView(a.g.aiapps_entry_guide_layout);
        cVar.findViewById(a.f.root).setBackground(activity.getResources().getDrawable(a.e.aiapps_entry_guide_bg));
        cVar.findViewById(a.f.nightmode_mask).setVisibility(com.baidu.swan.apps.u.a.JD().Kc() ? 0 : 8);
        ((SimpleDraweeView) cVar.findViewById(a.f.aiapps_guide_image)).setImageURI(str);
        cVar.findViewById(a.f.aiapps_split_line).setBackgroundColor(activity.getResources().getColor(a.c.aiapps_entry_guide_split_line3));
        TextView textView = (TextView) cVar.findViewById(a.f.aiapps_bottom_button);
        textView.setOnTouchListener(new com.baidu.swan.apps.p.b());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.p.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                cVar.dismiss();
                if (interfaceC0196a != null) {
                    interfaceC0196a.EV();
                }
            }
        });
        cVar.show();
        C(activity);
        if (DEBUG) {
            Log.e("SwanAppGuideDialogManager", "dialog has shown");
        }
        return true;
    }
}
