package com.baidu.android.pushservice.message;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends d {
    public f(Context context) {
        super(context);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, IGET, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, IGET, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, IGET, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, IGET, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, IGET, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, IGET, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, IGET, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    private byte[] a(long j, g gVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        com.baidu.android.pushservice.i.e eVar = new com.baidu.android.pushservice.i.e(byteArrayOutputStream);
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
                    return byteArray;
                } catch (IOException e) {
                    return byteArray;
                }
            } catch (Exception e2) {
                new b.c(this.f1460a).a(Log.getStackTraceString(e2)).a();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                    new b.c(this.f1460a).a(Log.getStackTraceString(e3)).a();
                }
                try {
                    eVar.a();
                } catch (IOException e4) {
                    new b.c(this.f1460a).a(Log.getStackTraceString(e4)).a();
                }
                return null;
            }
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e5) {
                new b.c(this.f1460a).a(Log.getStackTraceString(e5)).a();
            }
            try {
                eVar.a();
            } catch (IOException e6) {
                new b.c(this.f1460a).a(Log.getStackTraceString(e6)).a();
            }
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
        com.baidu.android.pushservice.i.e eVar = new com.baidu.android.pushservice.i.e(byteArrayOutputStream);
        int length = bArr != null ? bArr.length : 0;
        try {
            try {
                eVar.a((int) s);
                if (s != h.MSG_ID_TINY_HEARTBEAT_CLIENT.b() && s != h.MSG_ID_TINY_HEARTBEAT_SERVER.b()) {
                    eVar.a((int) com.baidu.android.pushservice.a.a());
                    eVar.b(0);
                    eVar.a(a(m.d(this.f1460a, this.f1460a.getPackageName()) ? "BaiduApp" : "DevApp", 16));
                    eVar.b(-76508268);
                    eVar.b(1);
                    eVar.b(length);
                    if (bArr != null) {
                        eVar.a(bArr);
                    }
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                com.baidu.android.pushservice.e.b.a(this.f1460a, byteArrayOutputStream);
                try {
                    eVar.a();
                    return byteArray;
                } catch (Exception e) {
                    new b.c(this.f1460a).a(Log.getStackTraceString(e)).a();
                    return byteArray;
                }
            } catch (Throwable th) {
                com.baidu.android.pushservice.e.b.a(this.f1460a, byteArrayOutputStream);
                try {
                    eVar.a();
                } catch (Exception e2) {
                    new b.c(this.f1460a).a(Log.getStackTraceString(e2)).a();
                }
                throw th;
            }
        } catch (Exception e3) {
            new b.c(this.f1460a).a(Log.getStackTraceString(e3)).a();
            com.baidu.android.pushservice.e.b.a(this.f1460a, byteArrayOutputStream);
            try {
                eVar.a();
            } catch (Exception e4) {
                new b.c(this.f1460a).a(Log.getStackTraceString(e4)).a();
            }
            return null;
        }
    }

    private String e() {
        try {
            switch (m.i(this.f1460a)) {
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
            new b.c(this.f1460a).a(Log.getStackTraceString(e)).a();
            return null;
        }
    }

    private String f() {
        try {
            WindowManager windowManager = (WindowManager) this.f1460a.getSystemService("window");
            if (windowManager != null) {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                return defaultDisplay.getHeight() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + defaultDisplay.getWidth();
            }
        } catch (Exception e) {
            new b.c(this.f1460a).a(Log.getStackTraceString(e)).a();
        }
        return null;
    }

    private String g() {
        String simOperator;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.f1460a.getSystemService("phone");
            if (telephonyManager != null && (simOperator = telephonyManager.getSimOperator()) != null) {
                if (simOperator.equals("46000") || simOperator.equals("46002") || simOperator.equals("46007")) {
                    return IXAdRequestInfo.MAX_CONTENT_LENGTH;
                }
                if (simOperator.equals("46001")) {
                    return "uni";
                }
                if (simOperator.equals("46003")) {
                    return Config.EXCEPTION_CRASH_TYPE;
                }
            }
        } catch (Exception e) {
            new b.c(this.f1460a).a(Log.getStackTraceString(e)).a();
        } catch (NoSuchFieldError e2) {
            new b.c(this.f1460a).a(Log.getStackTraceString(e2)).a();
        }
        return null;
    }

    @Override // com.baidu.android.pushservice.message.d
    public e a(byte[] bArr) throws IOException {
        byte[] bArr2;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        com.baidu.android.pushservice.i.d dVar = new com.baidu.android.pushservice.i.d(byteArrayInputStream);
        short c = dVar.c();
        e eVar = new e(c);
        if (c == h.MSG_ID_TINY_HEARTBEAT_SERVER.b() || c == h.MSG_ID_TINY_HEARTBEAT_CLIENT.b()) {
            byteArrayInputStream.close();
            dVar.a();
            return eVar;
        }
        dVar.c();
        dVar.b();
        dVar.a(new byte[16]);
        dVar.b();
        dVar.b();
        int b2 = dVar.b();
        if (b2 > 0) {
            bArr2 = new byte[b2 <= 20480 ? b2 : 20480];
            dVar.a(bArr2);
        } else {
            bArr2 = null;
        }
        eVar.f1463b = bArr2;
        byteArrayInputStream.close();
        dVar.a();
        return eVar;
    }

    @Override // com.baidu.android.pushservice.message.d
    public void b() {
        JSONObject jSONObject = new JSONObject();
        String str = null;
        try {
            jSONObject.put("channel_token", com.baidu.android.pushservice.j.a(this.f1460a).b());
            jSONObject.put(SharedPrefConfig.CHANNEL_ID, com.baidu.android.pushservice.j.a(this.f1460a).a());
            if (com.baidu.android.pushservice.b.d.b(this.f1460a)) {
                jSONObject.put("new_channel_token", com.baidu.android.pushservice.j.a(this.f1460a).d());
                jSONObject.put("new_channel_id", com.baidu.android.pushservice.j.a(this.f1460a).c());
            }
            jSONObject.put("sa_mode", com.baidu.android.pushservice.b.d.a(this.f1460a).b());
            jSONObject.put("highest_version", com.baidu.android.pushservice.b.d.a(this.f1460a).c());
            jSONObject.put("period", 1800);
            jSONObject.put("channel_type", 3);
            jSONObject.put("tinyheart", 1);
            if (m.o(this.f1460a)) {
                jSONObject.put("connect_version", 3);
                String str2 = Build.MANUFACTURER;
                if (!TextUtils.isEmpty(str2) && str2.length() <= 128) {
                    jSONObject.put("manufacture", str2);
                }
            } else {
                jSONObject.put("connect_version", 2);
            }
            jSONObject.put("app_alone_conn", com.baidu.android.pushservice.b.d.e(this.f1460a) ? 1 : 0);
            jSONObject.put("pkg_name", this.f1460a.getPackageName());
            jSONObject.put("proxy_conn", com.baidu.android.pushservice.b.d.c(this.f1460a) ? 1 : 0);
            jSONObject.put("noti_enable", com.baidu.android.pushservice.i.h.a(this.f1460a));
            if (this.f1460a.getPackageName().equals(GlobalConstants.SEARCHBOX_PACKAGE_NAME)) {
                jSONObject.put("pkg_version", m.a(this.f1460a));
            }
            jSONObject.put("tiny_msghead", 1);
            jSONObject.put("alarm_function", 1);
            JSONObject jSONObject2 = new JSONObject();
            String str3 = Build.MODEL;
            if (!TextUtils.isEmpty(str3)) {
                jSONObject2.put("model", str3);
            }
            String g = g();
            if (!TextUtils.isEmpty(g)) {
                jSONObject2.put("carrier", g);
            }
            String f = f();
            if (!TextUtils.isEmpty(f)) {
                jSONObject2.put("resolution", f);
            }
            String e = e();
            if (!TextUtils.isEmpty(e)) {
                jSONObject2.put("network", e);
            }
            String cuid = DeviceId.getCUID(this.f1460a);
            if (!TextUtils.isEmpty(cuid)) {
                jSONObject2.put("cuid", cuid);
            }
            int length = jSONObject2.toString().length();
            jSONObject.put("devinfo", Base64.encodeToString(BaiduAppSSOJni.encryptAES(jSONObject2.toString(), 1), 2));
            jSONObject.put("devinfolength", length);
            str = jSONObject.toString();
        } catch (Exception e2) {
            new b.c(this.f1460a).a(Log.getStackTraceString(e2)).a();
        } catch (UnsatisfiedLinkError e3) {
            new b.c(this.f1460a).a(Log.getStackTraceString(e3)).a();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        byte[] a2 = a(h.MSG_ID_HANDSHAKE.b(), str.getBytes());
        e eVar = new e(h.MSG_ID_HANDSHAKE.b());
        eVar.f1463b = a2;
        eVar.c = true;
        eVar.a(false);
        a(eVar);
    }

    @Override // com.baidu.android.pushservice.message.d
    public void b(e eVar) {
        if (eVar == null) {
            return;
        }
        a aVar = new a(this.f1460a);
        h a2 = h.a(eVar.f1462a);
        c a3 = aVar.a(a2);
        if (a3 != null) {
            g a4 = a3.a(eVar);
            if (eVar.d) {
                e eVar2 = new e(eVar.f1462a);
                if (a2 == h.MSG_ID_PUSH_MSG) {
                    eVar2.f1463b = a(h.MSG_ID_PUSH_MSG.b(), a(eVar.e().d(), a4));
                } else if (a2 == h.MSG_ID_TINY_HEARTBEAT_SERVER || a2 == h.MSG_ID_HEARTBEAT_SERVER) {
                    eVar2.f1463b = a(eVar.f1462a, (byte[]) null);
                }
                a(eVar2);
            }
        }
    }

    @Override // com.baidu.android.pushservice.message.d
    public void c() {
    }

    @Override // com.baidu.android.pushservice.message.d
    public void d() {
        byte[] a2 = a(h.MSG_ID_TINY_HEARTBEAT_CLIENT.b(), (byte[]) null);
        e eVar = new e(h.MSG_ID_TINY_HEARTBEAT_CLIENT.b());
        eVar.f1463b = a2;
        eVar.c = true;
        eVar.a(true);
        a(eVar);
    }
}
