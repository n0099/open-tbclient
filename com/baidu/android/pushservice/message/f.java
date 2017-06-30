package com.baidu.android.pushservice.message;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.android.pushservice.j.q;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends d {
    private com.baidu.android.pushservice.j.i b;

    public f(Context context) {
        super(context);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, CONST_STR, INVOKE, MOVE_EXCEPTION, INVOKE, CONST_STR, INVOKE, MOVE_EXCEPTION, CONST_STR, INVOKE, MOVE_EXCEPTION] complete} */
    private byte[] a(long j, g gVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        com.baidu.android.pushservice.j.j jVar = new com.baidu.android.pushservice.j.j(byteArrayOutputStream);
        try {
            try {
                jVar.a(j);
                jVar.b(gVar.a());
                jVar.b(0);
                com.baidu.android.pushservice.g.a.c("MessageHandler", "reply null? " + (gVar.b() == null));
                if (gVar.b() != null) {
                    jVar.a(gVar.b());
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    return byteArray;
                } catch (IOException e) {
                    return byteArray;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    com.baidu.android.pushservice.g.a.a("MessageHandler", e2);
                }
                try {
                    jVar.a();
                } catch (IOException e3) {
                    com.baidu.android.pushservice.g.a.a("MessageHandler", e3);
                }
            }
        } catch (Exception e4) {
            com.baidu.android.pushservice.g.a.e("MessageHandler", "wrapMsgHead error : " + e4.getMessage());
            try {
                byteArrayOutputStream.close();
            } catch (IOException e5) {
                com.baidu.android.pushservice.g.a.a("MessageHandler", e5);
            }
            try {
                jVar.a();
            } catch (IOException e6) {
                com.baidu.android.pushservice.g.a.a("MessageHandler", e6);
            }
            return null;
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
        com.baidu.android.pushservice.j.j jVar = new com.baidu.android.pushservice.j.j(byteArrayOutputStream);
        int length = bArr != null ? bArr.length : 0;
        try {
            try {
                jVar.a((int) s);
                if (s != h.MSG_ID_TINY_HEARTBEAT_CLIENT.a() && s != h.MSG_ID_TINY_HEARTBEAT_SERVER.a()) {
                    jVar.a((int) com.baidu.android.pushservice.a.a());
                    jVar.b(0);
                    jVar.a(a(q.e(this.a, this.a.getPackageName()) ? "BaiduApp" : "DevApp", 16));
                    jVar.b(-76508268);
                    jVar.b(1);
                    jVar.b(length);
                    if (bArr != null) {
                        jVar.a(bArr);
                    }
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                com.baidu.android.pushservice.f.b.a(byteArrayOutputStream);
                try {
                    jVar.a();
                    return byteArray;
                } catch (Exception e) {
                    com.baidu.android.pushservice.g.a.a("MessageHandler", e);
                    return byteArray;
                }
            } catch (Throwable th) {
                com.baidu.android.pushservice.f.b.a(byteArrayOutputStream);
                try {
                    jVar.a();
                } catch (Exception e2) {
                    com.baidu.android.pushservice.g.a.a("MessageHandler", e2);
                }
                throw th;
            }
        } catch (Exception e3) {
            com.baidu.android.pushservice.g.a.e("MessageHandler", "error " + e3.getMessage());
            com.baidu.android.pushservice.f.b.a(byteArrayOutputStream);
            try {
                jVar.a();
            } catch (Exception e4) {
                com.baidu.android.pushservice.g.a.a("MessageHandler", e4);
            }
            return null;
        }
    }

    private String d() {
        try {
            switch (q.s(this.a)) {
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
            com.baidu.android.pushservice.g.a.a("MessageHandler", e);
            return null;
        }
    }

    private String e() {
        try {
            Display defaultDisplay = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay();
            return defaultDisplay.getHeight() + "_" + defaultDisplay.getWidth();
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("MessageHandler", e);
            return null;
        }
    }

    private String f() {
        try {
            String simOperator = ((TelephonyManager) this.a.getSystemService("phone")).getSimOperator();
            if (simOperator != null) {
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
            com.baidu.android.pushservice.g.a.a("MessageHandler", e);
        }
        return null;
    }

    private String g() {
        try {
            if (q.t(this.a, "android.permission.READ_PHONE_STATE")) {
                return ((TelephonyManager) this.a.getSystemService("phone")).getSubscriberId();
            }
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("MessageHandler", e);
        }
        return null;
    }

    private String h() {
        try {
            return ((WifiManager) this.a.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("MessageHandler", e);
            return null;
        }
    }

    @Override // com.baidu.android.pushservice.message.d
    public e a(byte[] bArr, int i) throws IOException {
        byte[] bArr2;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        this.b = new com.baidu.android.pushservice.j.i(byteArrayInputStream);
        short c = this.b.c();
        e eVar = new e(c);
        if (c == h.MSG_ID_TINY_HEARTBEAT_SERVER.a() || c == h.MSG_ID_TINY_HEARTBEAT_CLIENT.a()) {
            com.baidu.android.pushservice.g.a.b("MessageHandler", "readMessage tiny heart beat from server, msgType:" + ((int) c));
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            if (this.b != null) {
                this.b.a();
            }
            return eVar;
        }
        short c2 = this.b.c();
        int b = this.b.b();
        this.b.a(new byte[16]);
        int b2 = this.b.b();
        int b3 = this.b.b();
        int b4 = this.b.b();
        com.baidu.android.pushservice.g.a.b("MessageHandler", "readMessage nshead, msgId:" + ((int) c) + " magicNum:" + Integer.toHexString(b2) + " length:" + b4 + " version =" + ((int) c2) + " logId =" + b + " reserved = " + b3);
        if (b4 > 0) {
            bArr2 = new byte[b4 <= 20480 ? b4 : 20480];
            this.b.a(bArr2);
        } else {
            bArr2 = null;
        }
        eVar.c = bArr2;
        if (byteArrayInputStream != null) {
            byteArrayInputStream.close();
        }
        if (this.b != null) {
            this.b.a();
        }
        return eVar;
    }

    @Override // com.baidu.android.pushservice.message.d
    public void a(int i) {
        JSONObject jSONObject = new JSONObject();
        String str = null;
        try {
            jSONObject.put("channel_token", com.baidu.android.pushservice.j.a(this.a).b());
            jSONObject.put("channel_id", com.baidu.android.pushservice.j.a(this.a).a());
            jSONObject.put("sa_mode", com.baidu.android.pushservice.c.d.a(this.a).b());
            jSONObject.put("highest_version", com.baidu.android.pushservice.c.d.a(this.a).d());
            jSONObject.put("period", 1800);
            jSONObject.put("channel_type", 3);
            jSONObject.put("tinyheart", 1);
            if (q.E(this.a)) {
                jSONObject.put("connect_version", 3);
                String str2 = Build.MANUFACTURER;
                if (!TextUtils.isEmpty(str2) && str2.length() <= 128) {
                    jSONObject.put("manufacture", str2);
                }
                com.baidu.android.pushservice.g.a.c("MessageHandler", "******** login sa by V3 ********" + this.a.getPackageName());
            } else {
                jSONObject.put("connect_version", 2);
                com.baidu.android.pushservice.g.a.c("MessageHandler", "******** login sa by V2 ********" + this.a.getPackageName());
            }
            jSONObject.put("tiny_msghead", 1);
            jSONObject.put("alarm_function", 1);
            JSONObject jSONObject2 = new JSONObject();
            String str3 = Build.MODEL;
            if (str3 != null && str3 != "") {
                jSONObject2.put("model", str3);
            }
            String f = f();
            if (f != null && f != "") {
                jSONObject2.put("carrier", f);
            }
            String e = e();
            if (e != null && e != "") {
                jSONObject2.put("resolution", e);
            }
            String d = d();
            if (d != null && d != "") {
                jSONObject2.put("network", d);
            }
            String h = h();
            if (h != null && h != "") {
                jSONObject2.put("mac", h);
            }
            String a = com.baidu.android.pushservice.k.e.a(this.a);
            if (a != null && a != "") {
                jSONObject2.put("cuid", a);
            }
            String g = g();
            if (g != null && g != "") {
                jSONObject2.put("imsi", g);
            }
            int length = jSONObject2.toString().length();
            com.baidu.android.pushservice.g.a.c("MessageHandler", "jsonDevInfo = " + jSONObject2.toString());
            String a2 = com.baidu.android.pushservice.k.b.a(BaiduAppSSOJni.encryptAES(jSONObject2.toString(), 1), "utf-8");
            com.baidu.android.pushservice.g.a.c("MessageHandler", "devinfo = " + a2);
            com.baidu.android.pushservice.g.a.c("MessageHandler", "devinfolength = " + length);
            jSONObject.put("devinfo", a2);
            jSONObject.put("devinfolength", length);
            str = jSONObject.toString();
        } catch (Exception e2) {
            com.baidu.android.pushservice.g.a.a("MessageHandler", e2);
        } catch (UnsatisfiedLinkError e3) {
            com.baidu.android.pushservice.g.a.a("MessageHandler", e3);
        }
        com.baidu.android.pushservice.g.a.b("MessageHandler", "onSessionOpened, send handshake msg :" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        byte[] a3 = a(h.MSG_ID_HANDSHAKE.a(), str.getBytes());
        e eVar = new e(h.MSG_ID_HANDSHAKE.a());
        eVar.c = a3;
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
                    com.baidu.android.pushservice.g.a.c("MessageHandler", "message need reply , send msg msgId :" + eVar.d().g() + " ret: " + a3.a());
                    eVar2.c = a(h.MSG_ID_PUSH_MSG.a(), a(eVar.d().g(), a3));
                } else if (a == h.MSG_ID_TINY_HEARTBEAT_SERVER || a == h.MSG_ID_HEARTBEAT_SERVER) {
                    com.baidu.android.pushservice.g.a.b("MessageHandler", "handleServerHeartbeatMsg, send handshake return msg ");
                    eVar2.c = a(eVar.a, (byte[]) null);
                }
                a(eVar2);
            }
        }
    }

    @Override // com.baidu.android.pushservice.message.d
    public void c() {
        com.baidu.android.pushservice.g.a.b("MessageHandler", "sendHeartbeatMessage ");
        byte[] a = a(h.MSG_ID_TINY_HEARTBEAT_CLIENT.a(), (byte[]) null);
        e eVar = new e(h.MSG_ID_TINY_HEARTBEAT_CLIENT.a());
        eVar.c = a;
        eVar.d = true;
        eVar.a(true);
        a(eVar);
    }
}
