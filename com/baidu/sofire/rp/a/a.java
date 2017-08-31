package com.baidu.sofire.rp.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class a {
    public SharedPreferences PR;
    public SharedPreferences.Editor PS;
    private SharedPreferences.Editor PT;
    public SharedPreferences.Editor PU;
    public SharedPreferences a;
    public SharedPreferences b;

    public a(Context context) {
        try {
            this.a = context.getSharedPreferences("re_po_rt", 0);
            this.PS = this.a.edit();
            this.b = context.getSharedPreferences("leroadcfg", 0);
            this.PT = this.b.edit();
            this.PR = context.getSharedPreferences("leroadcfg", 0);
            this.PU = this.PR.edit();
        } catch (Throwable th) {
            com.baidu.sofire.rp.f.b.a();
        }
    }

    public final void a(b bVar) {
        if (bVar != null) {
            this.PS.putString("re_con", this.a.getString("re_con", "") + "||" + b.b(bVar));
            this.PS.commit();
        }
    }

    public final List<b> a() {
        b bV;
        String string = this.a.getString("re_con", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String[] split = string.split("\\|\\|");
        for (String str : split) {
            if (!TextUtils.isEmpty(str) && (bV = b.bV(str)) != null) {
                arrayList.add(bV);
            }
        }
        return arrayList;
    }
}
