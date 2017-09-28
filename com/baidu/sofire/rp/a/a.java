package com.baidu.sofire.rp.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class a {
    public SharedPreferences Qg;
    public SharedPreferences.Editor Qh;
    private SharedPreferences.Editor Qi;
    public SharedPreferences.Editor Qj;
    public SharedPreferences a;
    public SharedPreferences b;

    public a(Context context) {
        try {
            this.a = context.getSharedPreferences("re_po_rt", 0);
            this.Qh = this.a.edit();
            this.b = context.getSharedPreferences("leroadcfg", 0);
            this.Qi = this.b.edit();
            this.Qg = context.getSharedPreferences("leroadcfg", 0);
            this.Qj = this.Qg.edit();
        } catch (Throwable th) {
            com.baidu.sofire.rp.f.b.a();
        }
    }

    public final void a(b bVar) {
        if (bVar != null) {
            this.Qh.putString("re_con", this.a.getString("re_con", "") + "||" + b.b(bVar));
            this.Qh.commit();
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
