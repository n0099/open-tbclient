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
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.storage.b.e;
import com.facebook.drawee.view.SimpleDraweeView;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private e awi;
    private SharedPreferences.Editor mEditor;

    private a() {
        this.awi = new e("aiapps_guide_dialog_sp");
        this.mEditor = this.awi.edit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0148a {
        private static final a awl = new a();
    }

    public static a BZ() {
        return C0148a.awl;
    }

    private boolean z(@NonNull Activity activity) {
        boolean Ca = Ca();
        if (DEBUG) {
            Log.e("SwanAppGuideDialogManager", "is first in " + Ca);
        }
        if (Ca) {
            return true;
        }
        int B = B(activity);
        int bF = bF(activity);
        if (DEBUG) {
            Log.e("SwanAppGuideDialogManager", "version =" + B + " curVerCode" + bF);
        }
        return bF > B;
    }

    private int bF(@NonNull Context context) {
        PackageInfo al = aa.al(context, context.getPackageName());
        if (al != null) {
            return al.versionCode;
        }
        return -1;
    }

    public boolean b(@NonNull WeakReference<Activity> weakReference) {
        com.baidu.swan.apps.ae.b IX;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        Activity activity = weakReference.get();
        if (!TextUtils.equals("0", Cc()) && (IX = com.baidu.swan.apps.ae.b.IX()) != null && !IX.Jh().getBoolean("boolean_var_key_fav_guide_show", false)) {
            String Cb = Cb();
            if (z(activity) && !TextUtils.isEmpty(Cb) && d(activity, Cb)) {
                A(activity);
                return true;
            }
            return false;
        }
        return false;
    }

    private void A(@NonNull Activity activity) {
        bd(false);
        cx(bF(activity));
    }

    private void bd(boolean z) {
        this.mEditor.putBoolean("new_first_in", z).apply();
    }

    private boolean Ca() {
        return this.awi.getBoolean("new_first_in", true);
    }

    private void cx(int i) {
        if (DEBUG) {
            Log.e("SwanAppGuideDialogManager", "versionCode " + i);
        }
        this.mEditor.putInt("up_first_in", i).apply();
    }

    private int B(Activity activity) {
        return this.awi.getInt("up_first_in", bF(activity));
    }

    public String Cb() {
        return this.awi.getString("url", "");
    }

    public String Cc() {
        return this.awi.getString("switch", "1");
    }

    private boolean d(@NonNull final Activity activity, String str) {
        if (activity == null || activity.isFinishing()) {
            return false;
        }
        final com.baidu.swan.apps.res.widget.dialog.b bVar = new com.baidu.swan.apps.res.widget.dialog.b(activity, a.i.NoTitleDialog);
        com.baidu.swan.apps.an.b.a(activity, bVar);
        bVar.setContentView(a.g.aiapps_entry_guide_layout);
        bVar.findViewById(a.f.root).setBackground(activity.getResources().getDrawable(a.e.aiapps_entry_guide_bg));
        bVar.findViewById(a.f.nightmode_mask).setVisibility(com.baidu.swan.apps.u.a.CT().Ds() ? 0 : 8);
        ((SimpleDraweeView) bVar.findViewById(a.f.aiapps_guide_image)).setImageURI(str);
        bVar.findViewById(a.f.aiapps_split_line).setBackgroundColor(activity.getResources().getColor(a.c.aiapps_entry_guide_split_line3));
        TextView textView = (TextView) bVar.findViewById(a.f.aiapps_bottom_button);
        textView.setOnTouchListener(new b());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.p.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bVar.dismiss();
                if (activity != null) {
                    activity.moveTaskToBack(true);
                }
            }
        });
        bVar.show();
        if (DEBUG) {
            Log.e("SwanAppGuideDialogManager", "dialog has shown");
        }
        return true;
    }
}
