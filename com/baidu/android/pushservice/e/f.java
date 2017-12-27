package com.baidu.android.pushservice.e;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushSettings;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class f extends d {
    protected int e;
    private int f;
    private String g;
    private String h;

    public f(l lVar, Context context, int i, int i2) {
        super(lVar, context);
        this.e = 0;
        this.e = i;
        this.f = i2;
        if (this.e == 0) {
            this.d = true;
        }
    }

    public f(l lVar, Context context, int i, int i2, String str) {
        super(lVar, context);
        this.e = 0;
        this.e = i;
        this.f = i2;
        this.g = str;
        this.h = lVar.j;
        if (this.e == 0) {
            this.d = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.e.a
    public void a(Intent intent) {
        intent.putExtra("bind_status", this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.e.a
    public void a(HashMap<String, String> hashMap) {
        super.a(hashMap);
        hashMap.put("method", "bind");
        hashMap.put("bind_name", Build.MODEL);
        hashMap.put("bind_status", this.e + "");
        hashMap.put("push_sdk_version", this.f + "");
        if (!TextUtils.isEmpty(this.h) && this.h.equalsIgnoreCase("true")) {
            hashMap.put("is_baidu_internal_bind", "true");
        }
        if (!TextUtils.isEmpty(this.g)) {
            hashMap.put("bind_notify_status", this.g);
        }
        if (!TextUtils.isEmpty(this.b.l) && com.baidu.android.pushservice.c.d.g(this.a)) {
            hashMap.put("push_proxy", this.b.l);
        }
        try {
            hashMap.put("manufacture", Build.MANUFACTURER);
            if (Build.MANUFACTURER.toLowerCase().contains("huawei") || Build.MANUFACTURER.toLowerCase().contains("xiaomi") || Build.MANUFACTURER.toLowerCase().contains("oppo")) {
                hashMap.put("rom", com.baidu.android.pushservice.j.p.C(this.a));
            }
        } catch (Exception e) {
        }
        if (com.baidu.android.pushservice.j.p.F(this.a)) {
            hashMap.put("connect_version", "3");
        } else {
            hashMap.put("connect_version", "2");
        }
        hashMap.put("sdk_int", Build.VERSION.SDK_INT + "");
        String str = this.b.e;
        if (!TextUtils.isEmpty(str) && str.length() <= 128) {
            hashMap.put("package_name", str);
        }
        if (!PushSettings.c(this.a)) {
            hashMap.put("check_sdk", com.baidu.android.pushservice.j.m.a(this.a, "com.baidu.android.pushservice.CHECK_SDK"));
        }
        if (com.baidu.android.pushservice.a.b() > 0) {
            com.baidu.android.pushservice.h.q.a(this.a, "039903", 0, this.b.i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.e.d, com.baidu.android.pushservice.e.a
    public String b(String str) {
        String b = super.b(str);
        if (!TextUtils.isEmpty(this.b.e)) {
            com.baidu.android.pushservice.b.b.a(this.a).g(this.b.e);
            if (!TextUtils.isEmpty(this.b.i)) {
                com.baidu.android.pushservice.b.b.a(this.a).a(this.b.e, new g(this.b.i, b));
            }
        }
        return b;
    }
}
