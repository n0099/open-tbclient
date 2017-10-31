package com.baidu.sofire.rp.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class a {
    public SharedPreferences Qj;
    public SharedPreferences.Editor Qk;
    private SharedPreferences.Editor Ql;
    public SharedPreferences.Editor Qm;
    public SharedPreferences a;
    public SharedPreferences b;

    public a(Context context) {
        try {
            this.a = context.getSharedPreferences("re_po_rt", 0);
            this.Qk = this.a.edit();
            this.b = context.getSharedPreferences("leroadcfg", 0);
            this.Ql = this.b.edit();
            this.Qj = context.getSharedPreferences("leroadcfg", 0);
            this.Qm = this.Qj.edit();
        } catch (Throwable th) {
            com.baidu.sofire.rp.f.b.a();
        }
    }

    public final void a(b bVar) {
        if (bVar != null) {
            this.Qk.putString("re_con", this.a.getString("re_con", "") + "||" + b.b(bVar));
            this.Qk.commit();
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
