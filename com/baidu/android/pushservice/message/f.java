package com.baidu.android.pushservice.message;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.TbConfig;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends d {
    public f(Context context) {
        super(context);
    }

    private byte[] a(long j, g gVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        com.baidu.android.pushservice.j.f fVar = new com.baidu.android.pushservice.j.f(byteArrayOutputStream);
        try {
            fVar.a(j);
            fVar.b(gVar.a());
            fVar.b(0);
            if (gVar.b() != null) {
                fVar.a(gVar.b());
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
            }
            try {
                fVar.a();
                return byteArray;
            } catch (IOException e2) {
                return byteArray;
            }
        } catch (Exception e3) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e4) {
            }
            try {
                fVar.a();
            } catch (IOException e5) {
            }
            return null;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e6) {
            }
            try {
                fVar.a();
            } catch (IOException e7) {
            }
            throw th;
        }
    }

    private byte[] a(String str, int i) {
        byte[] bArr = new byte[i];
        if (str != null) {
            byte[] bytes = str.getBytes();
            System.arraycopy(bytes, 0, bArr, 0, Math.min(bArr.length, bytes.length));
        }
        return bArr;
    }

    private byte[] a(short s, byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        com.baidu.android.pushservice.j.f fVar = new com.baidu.android.pushservice.j.f(byteArrayOutputStream);
        int length = bArr != null ? bArr.length : 0;
        try {
            fVar.a((int) s);
            if (s != h.MSG_ID_TINY_HEARTBEAT_CLIENT.a() && s != h.MSG_ID_TINY_HEARTBEAT_SERVER.a()) {
                fVar.a((int) com.baidu.android.pushservice.a.a());
                fVar.b(0);
                fVar.a(a(m.e(this.a, this.a.getPackageName()) ? "BaiduApp" : "DevApp", 16));
                fVar.b(-76508268);
                fVar.b(1);
                fVar.b(length);
                if (bArr != null) {
                    fVar.a(bArr);
                }
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            com.baidu.android.pushservice.f.b.a(byteArrayOutputStream);
            try {
                fVar.a();
                return byteArray;
            } catch (Exception e) {
                return byteArray;
            }
        } catch (Exception e2) {
            com.baidu.android.pushservice.f.b.a(byteArrayOutputStream);
            try {
                fVar.a();
            } catch (Exception e3) {
            }
            return null;
        } catch (Throwable th) {
            com.baidu.android.pushservice.f.b.a(byteArrayOutputStream);
            try {
                fVar.a();
            } catch (Exception e4) {
            }
            throw th;
        }
    }

    private String d() {
        try {
            switch (m.t(this.a)) {
                case 1:
                    return "wifi";
                case 2:
                    return "2g";
                case 3:
                    return "3g";
                case 4:
                    return "4g";
                default:
                    return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    private String e() {
        try {
            WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
            if (windowManager != null) {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                return defaultDisplay.getHeight() + "_" + defaultDisplay.getWidth();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private String f() {
        String simOperator;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.a.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
            if (telephonyManager != null && (simOperator = telephonyManager.getSimOperator()) != null) {
                if (simOperator.equals("46000") || simOperator.equals("46002") || simOperator.equals("46007")) {
                    return "cm";
                }
                if (simOperator.equals("46001")) {
                    return "uni";
                }
                if (simOperator.equals("46003")) {
                    return "ct";
                }
            }
        } catch (Exception e) {
        } catch (NoSuchFieldError e2) {
        }
        return null;
    }

    private String g() {
        TelephonyManager telephonyManager;
        try {
            if (!m.u(this.a, "android.permission.READ_PHONE_STATE") || (telephonyManager = (TelephonyManager) this.a.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)) == null) {
                return null;
            }
            return telephonyManager.getSubscriberId();
        } catch (Exception e) {
            return null;
        }
    }

    private String h() {
        WifiManager wifiManager;
        try {
            if (!m.u(this.a, "android.permission.ACCESS_WIFI_STATE") || (wifiManager = (WifiManager) this.a.getSystemService("wifi")) == null) {
                return null;
            }
            return wifiManager.getConnectionInfo().getMacAddress();
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.baidu.android.pushservice.message.d
    public e a(byte[] bArr, int i) throws IOException {
        byte[] bArr2;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        com.baidu.android.pushservice.j.e eVar = new com.baidu.android.pushservice.j.e(byteArrayInputStream);
        short c = eVar.c();
        e eVar2 = new e(c);
        if (c == h.MSG_ID_TINY_HEARTBEAT_SERVER.a() || c == h.MSG_ID_TINY_HEARTBEAT_CLIENT.a()) {
            byteArrayInputStream.close();
            eVar.a();
            return eVar2;
        }
        eVar.c();
        eVar.b();
        eVar.a(new byte[16]);
        eVar.b();
        eVar.b();
        int b = eVar.b();
        if (b > 0) {
            bArr2 = new byte[b <= 20480 ? b : 20480];
            eVar.a(bArr2);
        } else {
            bArr2 = null;
        }
        eVar2.c = bArr2;
        byteArrayInputStream.close();
        eVar.a();
        return eVar2;
    }

    @Override // com.baidu.android.pushservice.message.d
    public void a(int i) {
        JSONObject jSONObject = new JSONObject();
        String str = null;
        try {
            jSONObject.put("channel_token", com.baidu.android.pushservice.j.a(this.a).b());
            jSONObject.put("channel_id", com.baidu.android.pushservice.j.a(this.a).a());
            if (com.baidu.android.pushservice.c.e.b(this.a)) {
                jSONObject.put("new_channel_token", com.baidu.android.pushservice.j.a(this.a).d());
                jSONObject.put("new_channel_id", com.baidu.android.pushservice.j.a(this.a).c());
            }
            jSONObject.put("sa_mode", com.baidu.android.pushservice.c.e.a(this.a).b());
            jSONObject.put("highest_version", com.baidu.android.pushservice.c.e.a(this.a).d());
            jSONObject.put("period", TbConfig.POST_IMAGE_MIDDLE);
            jSONObject.put("channel_type", 3);
            jSONObject.put("tinyheart", 1);
            if (m.F(this.a)) {
                jSONObject.put("connect_version", 3);
                String str2 = Build.MANUFACTURER;
                if (!TextUtils.isEmpty(str2) && str2.length() <= 128) {
                    jSONObject.put("manufacture", str2);
                }
            } else {
                jSONObject.put("connect_version", 2);
            }
            jSONObject.put("app_alone_conn", com.baidu.android.pushservice.a.d(this.a) ? 1 : 0);
            jSONObject.put(PushConstants.PACKAGE_NAME, this.a.getPackageName());
            jSONObject.put("tiny_msghead", 1);
            jSONObject.put("alarm_function", 1);
            JSONObject jSONObject2 = new JSONObject();
            String str3 = Build.MODEL;
            if (!TextUtils.isEmpty(str3)) {
                jSONObject2.put("model", str3);
            }
            String f = f();
            if (!TextUtils.isEmpty(f)) {
                jSONObject2.put("carrier", f);
            }
            String e = e();
            if (!TextUtils.isEmpty(e)) {
                jSONObject2.put("resolution", e);
            }
            String d = d();
            if (!TextUtils.isEmpty(d)) {
                jSONObject2.put(LivenessRecogActivity.f.J, d);
            }
            String h = h();
            if (!TextUtils.isEmpty(h)) {
                jSONObject2.put("mac", h);
            }
            String a = com.baidu.android.pushservice.k.e.a(this.a);
            if (!TextUtils.isEmpty(a)) {
                jSONObject2.put("cuid", a);
            }
            String g = g();
            if (!TextUtils.isEmpty(g)) {
                jSONObject2.put("imsi", g);
            }
            int length = jSONObject2.toString().length();
            jSONObject.put("devinfo", com.baidu.android.pushservice.k.b.a(BaiduAppSSOJni.encryptAES(jSONObject2.toString(), 1), "utf-8"));
            jSONObject.put("devinfolength", length);
            str = jSONObject.toString();
        } catch (Exception e2) {
        } catch (UnsatisfiedLinkError e3) {
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        byte[] a2 = a(h.MSG_ID_HANDSHAKE.a(), str.getBytes());
        e eVar = new e(h.MSG_ID_HANDSHAKE.a());
        eVar.c = a2;
        eVar.d = true;
        eVar.a(false);
        a(eVar);
    }

    @Override // com.baidu.android.pushservice.message.d
    public void b() {
    }

    @Override // com.baidu.android.pushservice.message.d
    public void b(e eVar) throws Exception {
        if (eVar == null) {
            return;
        }
        a aVar = new a(this.a);
        h a = h.a(eVar.a);
        c a2 = aVar.a(a);
        if (a2 != null) {
            g a3 = a2.a(eVar);
            if (eVar.e) {
                e eVar2 = new e(eVar.a);
                if (a == h.MSG_ID_PUSH_MSG) {
                    eVar2.c = a(h.MSG_ID_PUSH_MSG.a(), a(eVar.d().g(), a3));
                } else if (a == h.MSG_ID_TINY_HEARTBEAT_SERVER || a == h.MSG_ID_HEARTBEAT_SERVER) {
                    eVar2.c = a(eVar.a, (byte[]) null);
                }
                a(eVar2);
            }
        }
    }

    @Override // com.baidu.android.pushservice.message.d
    public void c() {
        byte[] a = a(h.MSG_ID_TINY_HEARTBEAT_CLIENT.a(), (byte[]) null);
        e eVar = new e(h.MSG_ID_TINY_HEARTBEAT_CLIENT.a());
        eVar.c = a;
        eVar.d = true;
        eVar.a(true);
        a(eVar);
    }
}
