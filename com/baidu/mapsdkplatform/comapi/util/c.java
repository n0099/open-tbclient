package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import java.util.ArrayList;
/* loaded from: classes15.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<Integer> f3216a;

    /* renamed from: b  reason: collision with root package name */
    private Context f3217b;

    /* loaded from: classes15.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final c f3218a = new c();
    }

    private c() {
        this.f3216a = new ArrayList<>();
    }

    private int a(String str) {
        if (this.f3217b == null) {
            return -101;
        }
        return this.f3217b.getSharedPreferences("ad_auth", 0).getInt(str, 0);
    }

    public static c a() {
        return a.f3218a;
    }

    private void a(String str, int i) {
        if (this.f3217b == null) {
            return;
        }
        this.f3217b.getSharedPreferences("ad_auth", 0).edit().putInt(str, i).apply();
    }

    public void a(int i) {
        if (i == -1 && (i = a("ad_key")) == -101) {
            return;
        }
        for (int i2 = i; i2 != 0; i2 /= 2) {
            this.f3216a.add(Integer.valueOf(i2 % 2));
        }
        a("ad_key", i);
    }

    public void a(Context context) {
        this.f3217b = context;
    }

    public boolean b() {
        return this.f3216a != null && this.f3216a.size() > 0 && this.f3216a.get(0).intValue() == 1;
    }
}
