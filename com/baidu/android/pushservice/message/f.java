package com.baidu.android.pushservice.message;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends d {
    public f(Context context) {
        super(context);
    }

    private byte[] a(long j, g gVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        com.baidu.android.pushservice.j.e eVar = new com.baidu.android.pushservice.j.e(byteArrayOutputStream);
        try {
            try {
                eVar.a(j);
                eVar.b(gVar.a());
                eVar.b(0);
                if (gVar.b() != null) {
                    eVar.a(gVar.b());
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    new b.c(this.f3489a).a(Log.getStackTraceString(e2)).a();
                }
                try {
                    eVar.a();
                } catch (IOException e3) {
                    new b.c(this.f3489a).a(Log.getStackTraceString(e3)).a();
                }
                return byteArray;
            } catch (Exception e4) {
                new b.c(this.f3489a).a(Log.getStackTraceString(e4)).a();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e5) {
                    new b.c(this.f3489a).a(Log.getStackTraceString(e5)).a();
                }
                try {
                    eVar.a();
                    return null;
                } catch (IOException e6) {
                    new b.c(this.f3489a).a(Log.getStackTraceString(e6)).a();
                    return null;
                }
            }
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e7) {
                new b.c(this.f3489a).a(Log.getStackTraceString(e7)).a();
            }
            try {
                eVar.a();
            } catch (IOException e8) {
                new b.c(this.f3489a).a(Log.getStackTraceString(e8)).a();
            }
            throw th;
        }
    }

    private byte[] a(String str, int i) {
        byte[] bArr = new byte[i];
        if (str != null) {
            byte[] bytes = str.getBytes();
            System.arraycopy(bytes, 0, bArr, 0, Math.min(i, bytes.length));
        }
        return bArr;
    }

    private byte[] a(short s, byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        com.baidu.android.pushservice.j.e eVar = new com.baidu.android.pushservice.j.e(byteArrayOutputStream);
        int length = bArr != null ? bArr.length : 0;
        try {
            try {
                eVar.a((int) s);
                if (s != h.MSG_ID_TINY_HEARTBEAT_CLIENT.b() && s != h.MSG_ID_TINY_HEARTBEAT_SERVER.b()) {
                    eVar.a((int) com.baidu.android.pushservice.a.a());
                    eVar.b(0);
                    eVar.a(a(m.d(this.f3489a, this.f3489a.getPackageName()) ? "BaiduApp" : "DevApp", 16));
                    eVar.b(-76508268);
                    eVar.b(1);
                    eVar.b(length);
                    if (bArr != null) {
                        eVar.a(bArr);
                    }
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                com.baidu.android.pushservice.e.c.a(this.f3489a, byteArrayOutputStream);
                try {
                    eVar.a();
                } catch (Exception e2) {
                    new b.c(this.f3489a).a(Log.getStackTraceString(e2)).a();
                }
                return byteArray;
            } catch (Throwable th) {
                com.baidu.android.pushservice.e.c.a(this.f3489a, byteArrayOutputStream);
                try {
                    eVar.a();
                } catch (Exception e3) {
                    new b.c(this.f3489a).a(Log.getStackTraceString(e3)).a();
                }
                throw th;
            }
        } catch (Exception e4) {
            new b.c(this.f3489a).a(Log.getStackTraceString(e4)).a();
            com.baidu.android.pushservice.e.c.a(this.f3489a, byteArrayOutputStream);
            try {
                eVar.a();
                return null;
            } catch (Exception e5) {
                new b.c(this.f3489a).a(Log.getStackTraceString(e5)).a();
                return null;
            }
        }
    }

    @Override // com.baidu.android.pushservice.message.d
    public e a(byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        com.baidu.android.pushservice.j.d dVar = new com.baidu.android.pushservice.j.d(byteArrayInputStream);
        short c2 = dVar.c();
        e eVar = new e(c2);
        if (c2 != h.MSG_ID_TINY_HEARTBEAT_SERVER.b() && c2 != h.MSG_ID_TINY_HEARTBEAT_CLIENT.b()) {
            dVar.c();
            dVar.b();
            dVar.a(new byte[16]);
            dVar.b();
            dVar.b();
            int b2 = dVar.b();
            byte[] bArr2 = null;
            if (b2 > 0) {
                if (b2 > 20480) {
                    b2 = LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_EXTRA;
                }
                bArr2 = new byte[b2];
                dVar.a(bArr2);
            }
            eVar.f3492b = bArr2;
        }
        byteArrayInputStream.close();
        dVar.a();
        return eVar;
    }

    @Override // com.baidu.android.pushservice.message.d
    public void a(int i, String str, byte[] bArr) {
        g gVar = new g();
        gVar.a(i);
        if (bArr != null) {
            gVar.a(bArr);
        }
        e eVar = new e(h.MSG_ID_PUSH_MSG.b());
        try {
            eVar.f3492b = a(h.MSG_ID_PUSH_MSG.b(), a(Long.parseLong(str), gVar));
            a(eVar);
        } catch (NumberFormatException e2) {
            new b.c(this.f3489a).a(Log.getStackTraceString(e2)).a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0164 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0165  */
    @Override // com.baidu.android.pushservice.message.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b() {
        b.c cVar;
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("channel_token", com.baidu.android.pushservice.k.a(this.f3489a).b());
            jSONObject.put("channel_id", com.baidu.android.pushservice.k.a(this.f3489a).a());
            if (com.baidu.android.pushservice.b.d.b(this.f3489a)) {
                jSONObject.put("new_channel_token", com.baidu.android.pushservice.k.a(this.f3489a).d());
                jSONObject.put("new_channel_id", com.baidu.android.pushservice.k.a(this.f3489a).c());
            }
            jSONObject.put("sa_mode", com.baidu.android.pushservice.b.d.a(this.f3489a).b());
            jSONObject.put("highest_version", com.baidu.android.pushservice.b.d.a(this.f3489a).c());
            jSONObject.put("period", 1800);
            jSONObject.put("channel_type", 3);
            jSONObject.put("tinyheart", 1);
            if (m.o(this.f3489a)) {
                jSONObject.put("connect_version", 3);
                String str2 = Build.MANUFACTURER;
                if (!TextUtils.isEmpty(str2) && str2.length() <= 128) {
                    jSONObject.put("manufacture", str2);
                }
            } else {
                jSONObject.put("connect_version", 2);
            }
            jSONObject.put("app_alone_conn", com.baidu.android.pushservice.b.d.e(this.f3489a) ? 1 : 0);
            jSONObject.put(EmotionResourceInfo.JSON_KEY_PKG_NAME, this.f3489a.getPackageName());
            jSONObject.put("proxy_conn", com.baidu.android.pushservice.b.d.c(this.f3489a) ? 1 : 0);
            jSONObject.put("noti_enable", com.baidu.android.pushservice.j.h.b(this.f3489a));
            if (this.f3489a.getPackageName().equals("com.baidu.searchbox")) {
                jSONObject.put("pkg_version", m.a(this.f3489a));
            }
            jSONObject.put("tiny_msghead", 1);
            jSONObject.put("alarm_function", 1);
            JSONObject jSONObject2 = new JSONObject();
            String str3 = Build.MODEL;
            if (!TextUtils.isEmpty(str3)) {
                jSONObject2.put("model", str3);
            }
            String cuid = DeviceId.getCUID(this.f3489a);
            if (!TextUtils.isEmpty(cuid)) {
                jSONObject2.put("cuid", cuid);
            }
            int length = jSONObject2.toString().length();
            jSONObject.put("devinfo", Base64.encodeToString(BaiduAppSSOJni.encryptAES(jSONObject2.toString(), 1), 2));
            jSONObject.put("devinfolength", length);
            str = jSONObject.toString();
        } catch (Exception e2) {
            e = e2;
            cVar = new b.c(this.f3489a);
            cVar.a(Log.getStackTraceString(e)).a();
            str = null;
            if (TextUtils.isEmpty(str)) {
            }
        } catch (UnsatisfiedLinkError e3) {
            e = e3;
            cVar = new b.c(this.f3489a);
            cVar.a(Log.getStackTraceString(e)).a();
            str = null;
            if (TextUtils.isEmpty(str)) {
            }
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        byte[] a2 = a(h.MSG_ID_HANDSHAKE.b(), str.getBytes());
        e eVar = new e(h.MSG_ID_HANDSHAKE.b());
        eVar.f3492b = a2;
        eVar.f3493c = true;
        eVar.a(false);
        a(eVar);
    }

    @Override // com.baidu.android.pushservice.message.d
    public void b(e eVar) {
        g a2;
        if (eVar == null) {
            return;
        }
        a aVar = new a(this.f3489a);
        h a3 = h.a(eVar.f3491a);
        c a4 = aVar.a(a3);
        if (a4 == null || (a2 = a4.a(eVar)) == null || !eVar.f3494d) {
            return;
        }
        e eVar2 = new e(eVar.f3491a);
        if (a3 == h.MSG_ID_PUSH_MSG) {
            eVar2.f3492b = a(h.MSG_ID_PUSH_MSG.b(), a(eVar.e().e(), a2));
        } else if (a3 == h.MSG_ID_TINY_HEARTBEAT_SERVER || a3 == h.MSG_ID_HEARTBEAT_SERVER) {
            eVar2.f3492b = a(eVar.f3491a, (byte[]) null);
        }
        a(eVar2);
    }

    @Override // com.baidu.android.pushservice.message.d
    public void c() {
    }

    @Override // com.baidu.android.pushservice.message.d
    public void d() {
        byte[] a2 = a(h.MSG_ID_TINY_HEARTBEAT_CLIENT.b(), (byte[]) null);
        e eVar = new e(h.MSG_ID_TINY_HEARTBEAT_CLIENT.b());
        eVar.f3492b = a2;
        eVar.f3493c = true;
        eVar.a(true);
        a(eVar);
    }
}
