package com.baidu.adp.lib.a;

import android.content.SharedPreferences;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public final class c {
    private static String a = "_crashtime";
    private static String b = "_crashtype";
    private int c;
    private int d;
    private a e;

    public c(a aVar) {
        this.c = 0;
        this.d = 0;
        this.e = null;
        if (aVar == null) {
            throw new InvalidParameterException("SwitchHolder data is null");
        }
        this.e = aVar;
        if (this.e.b() > 0 && this.e.c() != null) {
            this.c = com.baidu.adp.a.b.a().b().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.e.a()) + a, -1);
            if (this.c == -1) {
                b();
            }
        }
        this.d = com.baidu.adp.a.b.a().b().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.e.a()) + b, this.e.e());
        this.e.a(this.d);
    }

    public final int a() {
        return this.d;
    }

    public final boolean a(int i) {
        if (this.e.b() >= 0 && this.c >= this.e.b() + 2) {
            i = this.e.d();
        }
        if (i == this.d) {
            return false;
        }
        this.d = i;
        this.e.a(this.d);
        b(i);
        return true;
    }

    public final boolean a(String str) {
        if (str == null || this.e.b() <= 0 || this.e.c() == null) {
            return false;
        }
        for (String str2 : this.e.c()) {
            if (str.indexOf(str2) != -1) {
                this.c++;
                c(this.c);
                if (this.c >= this.e.b()) {
                    b(this.e.d());
                    this.d = this.e.d();
                    this.e.a(this.e.d());
                }
                return true;
            }
        }
        return false;
    }

    private void b(int i) {
        SharedPreferences.Editor edit = com.baidu.adp.a.b.a().b().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.e.a()) + b, i);
        edit.commit();
    }

    private void c(int i) {
        SharedPreferences.Editor edit = com.baidu.adp.a.b.a().b().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.e.a()) + a, i);
        edit.commit();
    }

    public final void b() {
        this.c = 0;
        c(0);
        b(this.e.e());
    }
}
