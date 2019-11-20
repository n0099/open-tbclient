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
    private e aQJ;
    private SharedPreferences.Editor aQK;

    /* renamed from: com.baidu.swan.apps.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0196a {
        void EW();
    }

    private a() {
        this.aQJ = new e("aiapps_guide_dialog_sp");
        this.aQK = this.aQJ.edit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b {
        private static final a aQO = new a();
    }

    public static a IH() {
        return b.aQO;
    }

    private boolean B(@NonNull Activity activity) {
        boolean II = II();
        if (DEBUG) {
            Log.e("SwanAppGuideDialogManager", "is first in " + II);
        }
        if (II) {
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
        com.baidu.swan.apps.ae.b Ra;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        Activity activity = weakReference.get();
        if (!TextUtils.equals("0", IK()) && (Ra = com.baidu.swan.apps.ae.b.Ra()) != null && !Ra.Rl().getBoolean("boolean_var_key_fav_guide_show", false)) {
            return B(activity) && !TextUtils.isEmpty(IJ());
        }
        return false;
    }

    private void C(@NonNull Activity activity) {
        bD(false);
        dt(bb(activity));
    }

    private void bD(boolean z) {
        this.aQK.putBoolean("new_first_in", z).apply();
    }

    private boolean II() {
        return this.aQJ.getBoolean("new_first_in", true);
    }

    private void dt(int i) {
        if (DEBUG) {
            Log.e("SwanAppGuideDialogManager", "versionCode " + i);
        }
        this.aQK.putInt("up_first_in", i).apply();
    }

    private int D(Activity activity) {
        return this.aQJ.getInt("up_first_in", bb(activity));
    }

    public String IJ() {
        return this.aQJ.getString("url", "");
    }

    public String IK() {
        return this.aQJ.getString("switch", "1");
    }

    public boolean a(@NonNull Activity activity, String str, final InterfaceC0196a interfaceC0196a) {
        if (activity == null || activity.isFinishing() || !SwanAppNetworkUtils.isNetworkConnected(activity)) {
            return false;
        }
        final c cVar = new c(activity, a.i.SwanFavoriteGuideDialog);
        com.baidu.swan.apps.an.b.b(activity, cVar);
        cVar.setContentView(a.g.aiapps_entry_guide_layout);
        cVar.findViewById(a.f.root).setBackground(activity.getResources().getDrawable(a.e.aiapps_entry_guide_bg));
        cVar.findViewById(a.f.nightmode_mask).setVisibility(com.baidu.swan.apps.u.a.JE().Kd() ? 0 : 8);
        ((SimpleDraweeView) cVar.findViewById(a.f.aiapps_guide_image)).setImageURI(str);
        cVar.findViewById(a.f.aiapps_split_line).setBackgroundColor(activity.getResources().getColor(a.c.aiapps_entry_guide_split_line3));
        TextView textView = (TextView) cVar.findViewById(a.f.aiapps_bottom_button);
        textView.setOnTouchListener(new com.baidu.swan.apps.p.b());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.p.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                cVar.dismiss();
                if (interfaceC0196a != null) {
                    interfaceC0196a.EW();
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
