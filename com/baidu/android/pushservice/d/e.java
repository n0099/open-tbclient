package com.baidu.android.pushservice.d;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.mobstat.Config;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e extends d {

    /* renamed from: e  reason: collision with root package name */
    public int f3001e;

    /* renamed from: f  reason: collision with root package name */
    public int f3002f;

    /* renamed from: g  reason: collision with root package name */
    public String f3003g;

    public e(i iVar, Context context, int i2, int i3) {
        super(iVar, context);
        this.f3001e = 0;
        this.f3001e = i2;
        this.f3002f = i3;
        if (i2 == 0) {
            ((d) this).f3000d = true;
        }
    }

    public e(i iVar, Context context, int i2, int i3, String str) {
        super(iVar, context);
        this.f3001e = 0;
        this.f3001e = i2;
        this.f3002f = i3;
        this.f3003g = str;
        if (i2 == 0) {
            ((d) this).f3000d = true;
        }
    }

    @Override // com.baidu.android.pushservice.d.a
    public void a(Intent intent) {
        intent.putExtra("bind_status", this.f3001e);
    }

    @Override // com.baidu.android.pushservice.d.a
    public void a(HashMap<String, String> hashMap) {
        super.a(hashMap);
        String d2 = com.baidu.android.pushservice.c.c.d(((a) this).f2995a, "bduss");
        if (TextUtils.isEmpty(d2)) {
            return;
        }
        hashMap.put("cookie", d2);
    }

    @Override // com.baidu.android.pushservice.d.d, com.baidu.android.pushservice.d.a
    public String b(String str) {
        String b2 = super.b(str);
        if (!TextUtils.isEmpty(((a) this).f2996b.f3014d)) {
            com.baidu.android.pushservice.a.b.a(((a) this).f2995a).e(((a) this).f2996b.f3014d);
            if (!TextUtils.isEmpty(((a) this).f2996b.f3017g)) {
                com.baidu.android.pushservice.a.b.a(((a) this).f2995a).a(((a) this).f2996b.f3014d, new f(((a) this).f2996b.f3017g, b2));
            }
        }
        return b2;
    }

    @Override // com.baidu.android.pushservice.d.a
    public void b(HashMap<String, String> hashMap) {
        super.b(hashMap);
        hashMap.put("method", "bind");
        hashMap.put("bind_name", Build.MODEL);
        hashMap.put("bind_status", this.f3001e + "");
        hashMap.put("push_sdk_version", this.f3002f + "");
        if (com.baidu.android.pushservice.b.d.b(((a) this).f2995a)) {
            String cuid = DeviceId.getCUID(((a) this).f2995a);
            if (!TextUtils.isEmpty(cuid)) {
                hashMap.put("cuid", cuid);
                String d2 = com.baidu.android.pushservice.c.c.d(((a) this).f2995a, PushConstants.EXTRA_PUSH_FREQ);
                if (!TextUtils.isEmpty(d2)) {
                    hashMap.put(PushConstants.EXTRA_PUSH_FREQ, d2);
                }
            }
            hashMap.put("new_channel_id", com.baidu.android.pushservice.k.a(((a) this).f2995a).c());
        }
        String d3 = com.baidu.android.pushservice.c.c.d(((a) this).f2995a, PushConstants.EXTRA_APP_NOTIFY_STATUS);
        if (!TextUtils.isEmpty(d3)) {
            hashMap.put(PushConstants.EXTRA_APP_NOTIFY_STATUS, d3);
        }
        String m = com.baidu.android.pushservice.j.m.m(((a) this).f2995a);
        if (!TextUtils.isEmpty(m)) {
            hashMap.put("app_version", m);
        }
        String d4 = com.baidu.android.pushservice.c.c.d(((a) this).f2995a, "do_not_disturb");
        if (!TextUtils.isEmpty(d4)) {
            hashMap.put("do_not_disturb", d4);
        }
        String a2 = com.baidu.android.pushservice.j.i.a(((a) this).f2995a, PushConstants.EXTRA_BDUSS_ACTION);
        if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(com.baidu.android.pushservice.c.c.d(((a) this).f2995a, "bduss"))) {
            hashMap.put("bd_action", a2);
        }
        if (!TextUtils.isEmpty(this.f3003g)) {
            hashMap.put("bind_notify_status", this.f3003g);
        }
        if (!TextUtils.isEmpty(((a) this).f2996b.f3019i) && com.baidu.android.pushservice.b.d.q(((a) this).f2995a)) {
            hashMap.put("push_proxy", ((a) this).f2996b.f3019i);
        }
        hashMap.put("manufacture", Build.MANUFACTURER);
        if (com.baidu.android.pushservice.j.m.n()) {
            hashMap.put(Config.ROM, com.baidu.android.pushservice.j.m.l(((a) this).f2995a));
        }
        if (com.baidu.android.pushservice.j.m.o(((a) this).f2995a)) {
            hashMap.put("connect_version", "3");
        } else {
            hashMap.put("connect_version", "2");
        }
        hashMap.put("sdk_int", Build.VERSION.SDK_INT + "");
        String str = ((a) this).f2996b.f3014d;
        if (!TextUtils.isEmpty(str) && str.length() <= 128) {
            hashMap.put("package_name", str);
        }
        String deviceID = DeviceId.getDeviceID(((a) this).f2995a);
        if (com.baidu.android.pushservice.h.f()) {
            try {
                hashMap.put("rsa_device_id", Base64.encodeToString(com.baidu.android.pushservice.j.k.a(deviceID.getBytes(), BaiduAppSSOJni.getPublicKey(1)), 2));
            } catch (Exception unused) {
            }
        } else {
            hashMap.put(Constants.KEY_DEVICE_ID, deviceID);
        }
        hashMap.put("device_type", "3");
        hashMap.put("app_alone_conn", (com.baidu.android.pushservice.b.d.e(((a) this).f2995a) ? 1 : 0) + "");
        hashMap.put("dual_channel", (com.baidu.android.pushservice.b.d.c(((a) this).f2995a) ? 1 : 0) + "");
        hashMap.put("ignore_token", (((a) this).f2996b.k ? 1 : 0) + "");
        if (PushSettings.e(((a) this).f2995a)) {
            return;
        }
        hashMap.put("check_sdk", com.baidu.android.pushservice.j.i.a(((a) this).f2995a, "com.baidu.android.pushservice.CHECK_SDK"));
    }
}
