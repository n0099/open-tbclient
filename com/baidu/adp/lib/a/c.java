package com.baidu.adp.lib.a;

import android.content.SharedPreferences;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static String f354a = "_crashtime";
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
            this.c = e();
            if (this.c == -1) {
                c();
            }
        }
        this.d = d();
        this.e.a(this.d);
    }

    public int a() {
        return this.e.e();
    }

    public int b() {
        return this.d;
    }

    public boolean a(int i) {
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

    public boolean a(String str) {
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
        SharedPreferences.Editor edit = com.baidu.adp.a.b.a().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.e.a()) + b, i);
        edit.commit();
    }

    private int d() {
        return com.baidu.adp.a.b.a().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.e.a()) + b, this.e.e());
    }

    private int e() {
        return com.baidu.adp.a.b.a().getSharedPreferences("adp_feature_switch", 0).getInt(String.valueOf(this.e.a()) + f354a, -1);
    }

    private void c(int i) {
        SharedPreferences.Editor edit = com.baidu.adp.a.b.a().getSharedPreferences("adp_feature_switch", 0).edit();
        edit.putInt(String.valueOf(this.e.a()) + f354a, i);
        edit.commit();
    }

    public void c() {
        this.c = 0;
        c(0);
        b(a());
    }
}
