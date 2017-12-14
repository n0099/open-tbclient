package com.baidu.sofire.rp.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.sofire.b.d;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"InlinedApi"})
/* loaded from: classes.dex */
public final class a {
    private SharedPreferences QF;
    private SharedPreferences.Editor QG;
    public SharedPreferences a;
    public SharedPreferences b;
    public SharedPreferences.Editor c;
    private Context f;

    public a(Context context) {
        try {
            this.f = context;
            this.a = context.getSharedPreferences("re_po_rt", 0);
            this.c = this.a.edit();
            this.b = context.getSharedPreferences("leroadcfg", 0);
            this.QF = context.getSharedPreferences("leroadcfg", 0);
            this.QG = this.QF.edit();
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public final void a(b bVar) {
        this.c.putString("re_con", this.a.getString("re_con", "") + "||" + b.b(bVar));
        this.c.commit();
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

    public final int b() {
        int i = this.a.getInt("re_net_hr", 3);
        try {
            String[] e = d.e(this.f);
            if (e != null && e.length == 2 && !TextUtils.isEmpty(e[0]) && !TextUtils.isEmpty(e[1]) && "200080".equals(e[0])) {
                if ("com.baidu.BaiduMap".equals(this.f.getPackageName()) && i < 24) {
                    return 24;
                }
            }
        } catch (Throwable th) {
        }
        return i;
    }
}
