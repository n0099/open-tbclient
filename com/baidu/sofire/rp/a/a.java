package com.baidu.sofire.rp.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class a {
    public SharedPreferences PU;
    public SharedPreferences.Editor PV;
    private SharedPreferences.Editor PW;
    public SharedPreferences.Editor PX;
    public SharedPreferences a;
    public SharedPreferences b;

    public a(Context context) {
        try {
            this.a = context.getSharedPreferences("re_po_rt", 0);
            this.PV = this.a.edit();
            this.b = context.getSharedPreferences("leroadcfg", 0);
            this.PW = this.b.edit();
            this.PU = context.getSharedPreferences("leroadcfg", 0);
            this.PX = this.PU.edit();
        } catch (Throwable th) {
            com.baidu.sofire.rp.f.b.a();
        }
    }

    public final void a(b bVar) {
        if (bVar != null) {
            this.PV.putString("re_con", this.a.getString("re_con", "") + "||" + b.b(bVar));
            this.PV.commit();
        }
    }

    public final List<b> a() {
        b bU;
        String string = this.a.getString("re_con", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String[] split = string.split("\\|\\|");
        for (String str : split) {
            if (!TextUtils.isEmpty(str) && (bU = b.bU(str)) != null) {
                arrayList.add(bU);
            }
        }
        return arrayList;
    }
}
