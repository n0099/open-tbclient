package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<Integer> f2249a;
    private Context b;

    /* loaded from: classes7.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final c f2250a = new c();
    }

    private c() {
        this.f2249a = new ArrayList<>();
    }

    private int a(String str) {
        if (this.b == null) {
            return -101;
        }
        return this.b.getSharedPreferences("ad_auth", 0).getInt(str, 0);
    }

    public static c a() {
        return a.f2250a;
    }

    private void a(String str, int i) {
        if (this.b == null) {
            return;
        }
        this.b.getSharedPreferences("ad_auth", 0).edit().putInt(str, i).apply();
    }

    public void a(int i) {
        if (i == -1 && (i = a("ad_key")) == -101) {
            return;
        }
        for (int i2 = i; i2 != 0; i2 /= 2) {
            this.f2249a.add(Integer.valueOf(i2 % 2));
        }
        a("ad_key", i);
    }

    public void a(Context context) {
        this.b = context;
    }

    public boolean b() {
        return this.f2249a != null && this.f2249a.size() > 0 && this.f2249a.get(0).intValue() == 1;
    }
}
