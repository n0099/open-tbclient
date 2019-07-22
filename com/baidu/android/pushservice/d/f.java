package com.baidu.android.pushservice.d;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.mobstat.Config;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
/* loaded from: classes3.dex */
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
    @Override // com.baidu.android.pushservice.d.a
    public void a(Intent intent) {
        intent.putExtra("bind_status", this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.d.a
    public void a(HashMap<String, String> hashMap) {
        super.a(hashMap);
        hashMap.put("method", "bind");
        hashMap.put("bind_name", Build.MODEL);
        hashMap.put("bind_status", this.e + "");
        hashMap.put("push_sdk_version", this.f + "");
        if (com.baidu.android.pushservice.b.d.b(this.a)) {
            String cuid = DeviceId.getCUID(this.a);
            if (!TextUtils.isEmpty(cuid)) {
                hashMap.put("cuid", cuid);
            }
            hashMap.put("new_channel_id", com.baidu.android.pushservice.i.a(this.a).c());
        }
        if (!TextUtils.isEmpty(this.h) && this.h.equalsIgnoreCase("true")) {
            hashMap.put("is_baidu_internal_bind", "true");
        }
        if (!TextUtils.isEmpty(this.g)) {
            hashMap.put("bind_notify_status", this.g);
        }
        if (!TextUtils.isEmpty(this.b.l) && com.baidu.android.pushservice.b.d.k(this.a)) {
            hashMap.put("push_proxy", this.b.l);
        }
        hashMap.put("manufacture", Build.MANUFACTURER);
        if (com.baidu.android.pushservice.i.l.i()) {
            hashMap.put(Config.ROM, com.baidu.android.pushservice.i.l.B(this.a));
        }
        if (com.baidu.android.pushservice.i.l.D(this.a)) {
            hashMap.put("connect_version", "3");
        } else {
            hashMap.put("connect_version", "2");
        }
        hashMap.put("sdk_int", Build.VERSION.SDK_INT + "");
        String str = this.b.e;
        if (!TextUtils.isEmpty(str) && str.length() <= 128) {
            hashMap.put(Constants.PACKAGE_NAME, str);
        }
        hashMap.put("app_alone_conn", (com.baidu.android.pushservice.a.d(this.a) ? 1 : 0) + "");
        if (PushSettings.d(this.a)) {
            return;
        }
        hashMap.put("check_sdk", com.baidu.android.pushservice.i.i.a(this.a, "com.baidu.android.pushservice.CHECK_SDK"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.d.d, com.baidu.android.pushservice.d.a
    public String b(String str) {
        String b = super.b(str);
        if (!TextUtils.isEmpty(this.b.e)) {
            com.baidu.android.pushservice.a.b.a(this.a).g(this.b.e);
            if (!TextUtils.isEmpty(this.b.i)) {
                com.baidu.android.pushservice.a.b.a(this.a).a(this.b.e, new g(this.b.i, b));
            }
        }
        return b;
    }
}
