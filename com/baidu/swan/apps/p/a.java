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
    private e axM;
    private SharedPreferences.Editor mEditor;

    /* renamed from: com.baidu.swan.apps.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0164a {
        void Aa();
    }

    private a() {
        this.axM = new e("aiapps_guide_dialog_sp");
        this.mEditor = this.axM.edit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b {
        private static final a axQ = new a();
    }

    public static a DM() {
        return b.axQ;
    }

    private boolean C(@NonNull Activity activity) {
        boolean DN = DN();
        if (DEBUG) {
            Log.e("SwanAppGuideDialogManager", "is first in " + DN);
        }
        if (DN) {
            return true;
        }
        int E = E(activity);
        int aZ = aZ(activity);
        if (DEBUG) {
            Log.e("SwanAppGuideDialogManager", "version =" + E + " curVerCode" + aZ);
        }
        return aZ > E;
    }

    private int aZ(@NonNull Context context) {
        PackageInfo X = ac.X(context, context.getPackageName());
        if (X != null) {
            return X.versionCode;
        }
        return -1;
    }

    public boolean b(@NonNull WeakReference<Activity> weakReference) {
        com.baidu.swan.apps.ae.b Mh;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        Activity activity = weakReference.get();
        if (!TextUtils.equals("0", DP()) && (Mh = com.baidu.swan.apps.ae.b.Mh()) != null && !Mh.Mr().getBoolean("boolean_var_key_fav_guide_show", false)) {
            return C(activity) && !TextUtils.isEmpty(DO());
        }
        return false;
    }

    private void D(@NonNull Activity activity) {
        bl(false);
        cy(aZ(activity));
    }

    private void bl(boolean z) {
        this.mEditor.putBoolean("new_first_in", z).apply();
    }

    private boolean DN() {
        return this.axM.getBoolean("new_first_in", true);
    }

    private void cy(int i) {
        if (DEBUG) {
            Log.e("SwanAppGuideDialogManager", "versionCode " + i);
        }
        this.mEditor.putInt("up_first_in", i).apply();
    }

    private int E(Activity activity) {
        return this.axM.getInt("up_first_in", aZ(activity));
    }

    public String DO() {
        return this.axM.getString("url", "");
    }

    public String DP() {
        return this.axM.getString("switch", "1");
    }

    public boolean a(@NonNull Activity activity, String str, final InterfaceC0164a interfaceC0164a) {
        if (activity == null || activity.isFinishing() || !SwanAppNetworkUtils.isNetworkConnected(activity)) {
            return false;
        }
        final c cVar = new c(activity, a.i.SwanFavoriteGuideDialog);
        com.baidu.swan.apps.an.b.b(activity, cVar);
        cVar.setContentView(a.g.aiapps_entry_guide_layout);
        cVar.findViewById(a.f.root).setBackground(activity.getResources().getDrawable(a.e.aiapps_entry_guide_bg));
        cVar.findViewById(a.f.nightmode_mask).setVisibility(com.baidu.swan.apps.u.a.EJ().Fi() ? 0 : 8);
        ((SimpleDraweeView) cVar.findViewById(a.f.aiapps_guide_image)).setImageURI(str);
        cVar.findViewById(a.f.aiapps_split_line).setBackgroundColor(activity.getResources().getColor(a.c.aiapps_entry_guide_split_line3));
        TextView textView = (TextView) cVar.findViewById(a.f.aiapps_bottom_button);
        textView.setOnTouchListener(new com.baidu.swan.apps.p.b());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.p.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                cVar.dismiss();
                if (interfaceC0164a != null) {
                    interfaceC0164a.Aa();
                }
            }
        });
        cVar.show();
        D(activity);
        if (DEBUG) {
            Log.e("SwanAppGuideDialogManager", "dialog has shown");
        }
        return true;
    }
}
