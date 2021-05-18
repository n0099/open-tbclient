package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<Integer> f8004a;

    /* renamed from: b  reason: collision with root package name */
    public Context f8005b;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final d f8006a = new d();
    }

    public d() {
        this.f8004a = new ArrayList<>();
    }

    private int a(String str) {
        Context context = this.f8005b;
        if (context == null) {
            return -101;
        }
        return context.getSharedPreferences("ad_auth", 0).getInt(str, 0);
    }

    public static d a() {
        return a.f8006a;
    }

    private void a(String str, int i2) {
        Context context = this.f8005b;
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ad_auth", 0).edit().putInt(str, i2).apply();
    }

    public void a(int i2) {
        if (i2 == -1 && (i2 = a("ad_key")) == -101) {
            return;
        }
        for (int i3 = i2; i3 != 0; i3 /= 2) {
            this.f8004a.add(Integer.valueOf(i3 % 2));
        }
        a("ad_key", i2);
    }

    public void a(Context context) {
        this.f8005b = context;
    }

    public boolean b() {
        ArrayList<Integer> arrayList = this.f8004a;
        return arrayList != null && arrayList.size() > 0 && this.f8004a.get(0).intValue() == 1;
    }
}
