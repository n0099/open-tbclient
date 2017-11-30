package com.baidu.sofire.rp.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class a {
    public SharedPreferences QB;
    public SharedPreferences.Editor QC;
    private SharedPreferences.Editor QD;
    public SharedPreferences.Editor QE;
    public SharedPreferences a;
    public SharedPreferences b;

    public a(Context context) {
        try {
            this.a = context.getSharedPreferences("re_po_rt", 0);
            this.QC = this.a.edit();
            this.b = context.getSharedPreferences("leroadcfg", 0);
            this.QD = this.b.edit();
            this.QB = context.getSharedPreferences("leroadcfg", 0);
            this.QE = this.QB.edit();
        } catch (Throwable th) {
            com.baidu.sofire.rp.f.b.a();
        }
    }

    public final void a(b bVar) {
        if (bVar != null) {
            this.QC.putString("re_con", this.a.getString("re_con", "") + "||" + b.b(bVar));
            this.QC.commit();
        }
    }

    public final List<b> a() {
        b bZ;
        String string = this.a.getString("re_con", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String[] split = string.split("\\|\\|");
        for (String str : split) {
            if (!TextUtils.isEmpty(str) && (bZ = b.bZ(str)) != null) {
                arrayList.add(bZ);
            }
        }
        return arrayList;
    }
}
