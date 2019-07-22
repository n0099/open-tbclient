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
    private e axo;
    private SharedPreferences.Editor mEditor;

    /* renamed from: com.baidu.swan.apps.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0150a {
        void zW();
    }

    private a() {
        this.axo = new e("aiapps_guide_dialog_sp");
        this.mEditor = this.axo.edit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b {
        private static final a axs = new a();
    }

    public static a DI() {
        return b.axs;
    }

    private boolean C(@NonNull Activity activity) {
        boolean DJ = DJ();
        if (DEBUG) {
            Log.e("SwanAppGuideDialogManager", "is first in " + DJ);
        }
        if (DJ) {
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
        com.baidu.swan.apps.ae.b Md;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        Activity activity = weakReference.get();
        if (!TextUtils.equals("0", DL()) && (Md = com.baidu.swan.apps.ae.b.Md()) != null && !Md.Mn().getBoolean("boolean_var_key_fav_guide_show", false)) {
            return C(activity) && !TextUtils.isEmpty(DK());
        }
        return false;
    }

    private void D(@NonNull Activity activity) {
        bl(false);
        cx(aZ(activity));
    }

    private void bl(boolean z) {
        this.mEditor.putBoolean("new_first_in", z).apply();
    }

    private boolean DJ() {
        return this.axo.getBoolean("new_first_in", true);
    }

    private void cx(int i) {
        if (DEBUG) {
            Log.e("SwanAppGuideDialogManager", "versionCode " + i);
        }
        this.mEditor.putInt("up_first_in", i).apply();
    }

    private int E(Activity activity) {
        return this.axo.getInt("up_first_in", aZ(activity));
    }

    public String DK() {
        return this.axo.getString("url", "");
    }

    public String DL() {
        return this.axo.getString("switch", "1");
    }

    public boolean a(@NonNull Activity activity, String str, final InterfaceC0150a interfaceC0150a) {
        if (activity == null || activity.isFinishing() || !SwanAppNetworkUtils.isNetworkConnected(activity)) {
            return false;
        }
        final c cVar = new c(activity, a.i.SwanFavoriteGuideDialog);
        com.baidu.swan.apps.an.b.a(activity, cVar);
        cVar.setContentView(a.g.aiapps_entry_guide_layout);
        cVar.findViewById(a.f.root).setBackground(activity.getResources().getDrawable(a.e.aiapps_entry_guide_bg));
        cVar.findViewById(a.f.nightmode_mask).setVisibility(com.baidu.swan.apps.u.a.EF().Fe() ? 0 : 8);
        ((SimpleDraweeView) cVar.findViewById(a.f.aiapps_guide_image)).setImageURI(str);
        cVar.findViewById(a.f.aiapps_split_line).setBackgroundColor(activity.getResources().getColor(a.c.aiapps_entry_guide_split_line3));
        TextView textView = (TextView) cVar.findViewById(a.f.aiapps_bottom_button);
        textView.setOnTouchListener(new com.baidu.swan.apps.p.b());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.p.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                cVar.dismiss();
                if (interfaceC0150a != null) {
                    interfaceC0150a.zW();
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
