package com.baidu.android.pushservice.e;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class f extends d {
    protected int e;
    private String f;
    private int g;
    private String h;
    private String i;
    private String j;
    private int k;

    public f(l lVar, Context context, int i, String str, int i2, int i3) {
        super(lVar, context);
        this.e = 0;
        this.e = i;
        this.f = str;
        this.g = i2;
        if (this.e == 0) {
            this.d = true;
        }
        this.k = i3;
    }

    public f(l lVar, Context context, int i, String str, int i2, String str2, int i3) {
        super(lVar, context);
        this.e = 0;
        this.e = i;
        this.f = str;
        this.g = i2;
        this.h = str2;
        this.i = lVar.j;
        this.j = lVar.l;
        if (this.e == 0) {
            this.d = true;
        }
        this.k = i3;
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
        hashMap.put("current_push_versions", ((int) com.baidu.android.pushservice.a.a()) + "");
        hashMap.put("push_bind_type", this.k + "");
        hashMap.put(PushConstants.EXTRA_METHOD, "bind");
        hashMap.put("bind_name", TextUtils.isEmpty(this.f) ? Build.MODEL : this.f);
        hashMap.put("bind_status", this.e + "");
        hashMap.put("push_sdk_version", this.g + "");
        if (!TextUtils.isEmpty(this.i) && this.i.equalsIgnoreCase("true")) {
            hashMap.put("is_baidu_internal_bind", "true");
        }
        if (!TextUtils.isEmpty(this.h)) {
            hashMap.put("bind_notify_status", this.h);
        }
        if (!TextUtils.isEmpty(this.b.l) && com.baidu.android.pushservice.c.d.d(this.a)) {
            hashMap.put("push_proxy", this.b.l);
            try {
                hashMap.put("manufacture", Build.MANUFACTURER);
                hashMap.put("model", Build.MODEL);
                hashMap.put("sdk_int", Build.VERSION.SDK_INT + "");
                hashMap.put("rom", com.baidu.android.pushservice.j.q.B(this.a));
            } catch (Exception e) {
                com.baidu.android.pushservice.g.a.a("Bind", e);
            }
        }
        if (com.baidu.android.pushservice.j.q.E(this.a)) {
            hashMap.put("connect_version", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
        } else {
            hashMap.put("connect_version", "2");
        }
        hashMap.put("sdk_int", Build.VERSION.SDK_INT + "");
        String str = this.b.e;
        if (!TextUtils.isEmpty(str) && str.length() <= 128) {
            hashMap.put("package_name", str);
        }
        com.baidu.android.pushservice.g.a.c("Bind", "BIND param -- " + b.a(hashMap));
        if (com.baidu.android.pushservice.a.b() > 0) {
            com.baidu.android.pushservice.h.p.a(this.a, "039903", 0, this.b.i);
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
