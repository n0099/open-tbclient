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
    private e awJ;
    private SharedPreferences.Editor mEditor;

    /* renamed from: com.baidu.swan.apps.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0153a {
        void zp();
    }

    private a() {
        this.awJ = new e("aiapps_guide_dialog_sp");
        this.mEditor = this.awJ.edit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b {
        private static final a awN = new a();
    }

    public static a CZ() {
        return b.awN;
    }

    private boolean z(@NonNull Activity activity) {
        boolean Da = Da();
        if (DEBUG) {
            Log.e("SwanAppGuideDialogManager", "is first in " + Da);
        }
        if (Da) {
            return true;
        }
        int B = B(activity);
        int aZ = aZ(activity);
        if (DEBUG) {
            Log.e("SwanAppGuideDialogManager", "version =" + B + " curVerCode" + aZ);
        }
        return aZ > B;
    }

    private int aZ(@NonNull Context context) {
        PackageInfo X = ac.X(context, context.getPackageName());
        if (X != null) {
            return X.versionCode;
        }
        return -1;
    }

    public boolean b(@NonNull WeakReference<Activity> weakReference) {
        com.baidu.swan.apps.ae.b Lq;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        Activity activity = weakReference.get();
        if (!TextUtils.equals("0", Dc()) && (Lq = com.baidu.swan.apps.ae.b.Lq()) != null && !Lq.LA().getBoolean("boolean_var_key_fav_guide_show", false)) {
            return z(activity) && !TextUtils.isEmpty(Db());
        }
        return false;
    }

    private void A(@NonNull Activity activity) {
        bi(false);
        cx(aZ(activity));
    }

    private void bi(boolean z) {
        this.mEditor.putBoolean("new_first_in", z).apply();
    }

    private boolean Da() {
        return this.awJ.getBoolean("new_first_in", true);
    }

    private void cx(int i) {
        if (DEBUG) {
            Log.e("SwanAppGuideDialogManager", "versionCode " + i);
        }
        this.mEditor.putInt("up_first_in", i).apply();
    }

    private int B(Activity activity) {
        return this.awJ.getInt("up_first_in", aZ(activity));
    }

    public String Db() {
        return this.awJ.getString("url", "");
    }

    public String Dc() {
        return this.awJ.getString("switch", "1");
    }

    public boolean a(@NonNull Activity activity, String str, final InterfaceC0153a interfaceC0153a) {
        if (activity == null || activity.isFinishing() || !SwanAppNetworkUtils.isNetworkConnected(activity)) {
            return false;
        }
        final c cVar = new c(activity, a.i.SwanFavoriteGuideDialog);
        com.baidu.swan.apps.an.b.a(activity, cVar);
        cVar.setContentView(a.g.aiapps_entry_guide_layout);
        cVar.findViewById(a.f.root).setBackground(activity.getResources().getDrawable(a.e.aiapps_entry_guide_bg));
        cVar.findViewById(a.f.nightmode_mask).setVisibility(com.baidu.swan.apps.u.a.DW().Ev() ? 0 : 8);
        ((SimpleDraweeView) cVar.findViewById(a.f.aiapps_guide_image)).setImageURI(str);
        cVar.findViewById(a.f.aiapps_split_line).setBackgroundColor(activity.getResources().getColor(a.c.aiapps_entry_guide_split_line3));
        TextView textView = (TextView) cVar.findViewById(a.f.aiapps_bottom_button);
        textView.setOnTouchListener(new com.baidu.swan.apps.p.b());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.p.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                cVar.dismiss();
                if (interfaceC0153a != null) {
                    interfaceC0153a.zp();
                }
            }
        });
        cVar.show();
        A(activity);
        if (DEBUG) {
            Log.e("SwanAppGuideDialogManager", "dialog has shown");
        }
        return true;
    }
}
