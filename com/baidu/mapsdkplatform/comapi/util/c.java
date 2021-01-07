package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<Integer> f3217a;

    /* renamed from: b  reason: collision with root package name */
    private Context f3218b;

    /* loaded from: classes3.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final c f3219a = new c();
    }

    private c() {
        this.f3217a = new ArrayList<>();
    }

    private int a(String str) {
        if (this.f3218b == null) {
            return -101;
        }
        return this.f3218b.getSharedPreferences("ad_auth", 0).getInt(str, 0);
    }

    public static c a() {
        return a.f3219a;
    }

    private void a(String str, int i) {
        if (this.f3218b == null) {
            return;
        }
        this.f3218b.getSharedPreferences("ad_auth", 0).edit().putInt(str, i).apply();
    }

    public void a(int i) {
        if (i == -1 && (i = a("ad_key")) == -101) {
            return;
        }
        for (int i2 = i; i2 != 0; i2 /= 2) {
            this.f3217a.add(Integer.valueOf(i2 % 2));
        }
        a("ad_key", i);
    }

    public void a(Context context) {
        this.f3218b = context;
    }

    public boolean b() {
        return this.f3217a != null && this.f3217a.size() > 0 && this.f3217a.get(0).intValue() == 1;
    }
}
