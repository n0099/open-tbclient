package com.baidu.android.pushservice.d;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobstat.Config;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class e extends d {
    protected int e;
    private int f;
    private String g;

    public e(i iVar, Context context, int i, int i2) {
        super(iVar, context);
        this.e = 0;
        this.e = i;
        this.f = i2;
        if (this.e == 0) {
            this.d = true;
        }
    }

    public e(i iVar, Context context, int i, int i2, String str) {
        super(iVar, context);
        this.e = 0;
        this.e = i;
        this.f = i2;
        this.g = str;
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
        if (com.baidu.android.pushservice.b.d.b(this.f1258a)) {
            String cuid = DeviceId.getCUID(this.f1258a);
            if (!TextUtils.isEmpty(cuid)) {
                hashMap.put("cuid", cuid);
            }
            hashMap.put("new_channel_id", com.baidu.android.pushservice.j.a(this.f1258a).c());
        }
        if (!TextUtils.isEmpty(this.g)) {
            hashMap.put("bind_notify_status", this.g);
        }
        if (!TextUtils.isEmpty(this.f1259b.i) && com.baidu.android.pushservice.b.d.q(this.f1258a)) {
            hashMap.put("push_proxy", this.f1259b.i);
        }
        hashMap.put("manufacture", Build.MANUFACTURER);
        if (com.baidu.android.pushservice.i.m.n()) {
            hashMap.put(Config.ROM, com.baidu.android.pushservice.i.m.m(this.f1258a));
        }
        if (com.baidu.android.pushservice.i.m.o(this.f1258a)) {
            hashMap.put("connect_version", "3");
        } else {
            hashMap.put("connect_version", "2");
        }
        hashMap.put("sdk_int", Build.VERSION.SDK_INT + "");
        String str = this.f1259b.d;
        if (!TextUtils.isEmpty(str) && str.length() <= 128) {
            hashMap.put("package_name", str);
        }
        String deviceID = DeviceId.getDeviceID(this.f1258a);
        if (com.baidu.android.pushservice.h.f()) {
            try {
                hashMap.put("rsa_device_id", Base64.encodeToString(com.baidu.android.pushservice.i.k.a(deviceID.getBytes(), BaiduAppSSOJni.getPublicKey(1)), 2));
            } catch (Exception e) {
            }
        } else {
            hashMap.put("device_id", deviceID);
        }
        hashMap.put(HttpConstants.DEVICE_TYPE, "3");
        hashMap.put("app_alone_conn", (com.baidu.android.pushservice.b.d.e(this.f1258a) ? 1 : 0) + "");
        hashMap.put("dual_channel", (com.baidu.android.pushservice.b.d.c(this.f1258a) ? 1 : 0) + "");
        hashMap.put("ignore_token", (this.f1259b.k ? 1 : 0) + "");
        if (PushSettings.e(this.f1258a)) {
            return;
        }
        hashMap.put("check_sdk", com.baidu.android.pushservice.i.i.a(this.f1258a, "com.baidu.android.pushservice.CHECK_SDK"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.d.d, com.baidu.android.pushservice.d.a
    public String b(String str) {
        String b2 = super.b(str);
        if (!TextUtils.isEmpty(this.f1259b.d)) {
            com.baidu.android.pushservice.a.b.a(this.f1258a).e(this.f1259b.d);
            if (!TextUtils.isEmpty(this.f1259b.g)) {
                com.baidu.android.pushservice.a.b.a(this.f1258a).a(this.f1259b.d, new f(this.f1259b.g, b2));
            }
        }
        return b2;
    }
}
