package com.baidu.android.pushservice.e;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.media.TransportMediator;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.e.a;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class x implements Runnable {
    private Context a;
    private int b = 3;
    private int c = 0;
    private boolean d = false;
    private boolean e = true;
    private a.C0019a f;

    public x(Context context, a.C0019a c0019a) {
        this.a = context.getApplicationContext();
        this.f = c0019a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.io.Closeable[] */
    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(1:5))|6|(4:7|8|9|10)|(2:12|(10:14|(1:16)(1:35)|17|18|19|20|21|(1:23)(2:27|28)|24|25)(1:36))(1:38)|37|19|20|21|(0)(0)|24|25|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0195, code lost:
        com.baidu.android.pushservice.g.a.e("TokenRequester", "error : " + r3.getMessage());
        com.baidu.android.pushservice.g.a.b("TokenRequester", "io exception, schedule retry");
        r9.d = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x01bf, code lost:
        com.baidu.android.pushservice.f.b.a(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x01cd, code lost:
        r3 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x01d3, code lost:
        com.baidu.android.pushservice.g.a.e("TokenRequester", "Connect Exception:" + r3);
        r9.d = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x01f0, code lost:
        com.baidu.android.pushservice.f.b.a(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0209, code lost:
        r3 = e;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x012a A[Catch: IOException -> 0x01cd, all -> 0x0203, Exception -> 0x0209, TRY_LEAVE, TryCatch #1 {all -> 0x0203, blocks: (B:11:0x0083, B:13:0x00af, B:15:0x00bf, B:16:0x00c6, B:19:0x0126, B:21:0x012a, B:34:0x01c9, B:31:0x0195, B:40:0x01d3, B:24:0x0135, B:25:0x013d, B:27:0x0159), top: B:54:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b() {
        InputStream inputStream;
        Exception e;
        boolean z;
        IOException e2;
        int b;
        String d = com.baidu.android.pushservice.h.d();
        if (this.c > 2) {
            String b2 = com.baidu.android.pushservice.h.b(this.a, this.e);
            com.baidu.android.pushservice.g.a.c("TokenRequester", " --- token request use httpIp: " + b2);
            this.e = false;
            if (!TextUtils.isEmpty(b2)) {
                d = d.replace(com.baidu.android.pushservice.h.b(), "http://" + b2);
            }
        }
        String str = ">>> token request:" + d;
        com.baidu.android.pushservice.g.a.c("TokenRequester", str);
        try {
            try {
                com.baidu.android.pushservice.f.a a = com.baidu.android.pushservice.f.b.a(d, "POST", c());
                b = a.b();
                inputStream = a.a();
                try {
                } catch (IOException e3) {
                    e2 = e3;
                    z = false;
                } catch (Exception e4) {
                    e = e4;
                    z = false;
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.android.pushservice.f.b.a(str);
                throw th;
            }
        } catch (IOException e5) {
            inputStream = null;
            e2 = e5;
            z = false;
        } catch (Exception e6) {
            inputStream = null;
            e = e6;
            z = false;
        } catch (Throwable th2) {
            th = th2;
            str = null;
            com.baidu.android.pushservice.f.b.a(str);
            throw th;
        }
        if (b == 200) {
            String a2 = com.baidu.android.pushservice.h.a.b.a(inputStream);
            com.baidu.android.pushservice.g.a.b("TokenRequester", "<<< RequestToken return string :  " + a2);
            JSONObject jSONObject = new JSONObject(a2).getJSONObject("response_params");
            if (jSONObject != null) {
                String string = jSONObject.getString("channel_id");
                String string2 = com.baidu.android.pushservice.h.f() ? jSONObject.getString("rsa_channel_token") : jSONObject.getString("channel_token");
                String string3 = jSONObject.getString("expires_time");
                com.baidu.android.pushservice.g.a.b("TokenRequester", "RequestToken channelId :  " + string);
                com.baidu.android.pushservice.g.a.b("TokenRequester", "RequestToken mChannelToken :  " + string2);
                com.baidu.android.pushservice.g.a.b("TokenRequester", "RequestToken expiresTime :  " + string3);
                com.baidu.android.pushservice.j.a(this.a).a(string, string2);
                z = true;
                this.c = 0;
                if (inputStream != null) {
                    this.d = true;
                } else {
                    this.d = false;
                }
                com.baidu.android.pushservice.f.b.a(inputStream);
                return z;
            }
            com.baidu.android.pushservice.g.a.b("TokenRequester", "RequestToken failed :  " + a2);
        } else {
            String a3 = com.baidu.android.pushservice.h.a.b.a(inputStream);
            com.baidu.android.pushservice.g.a.b("TokenRequester", "RequestToken request failed  " + b);
            com.baidu.android.pushservice.g.a.b("TokenRequester", "<<< RequestToken return string :  " + a3);
        }
        z = false;
        this.c = 0;
        if (inputStream != null) {
        }
        com.baidu.android.pushservice.f.b.a(inputStream);
        return z;
    }

    private HashMap<String, String> c() throws Exception {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(PushConstants.EXTRA_METHOD, Constants.EXTRA_KEY_TOKEN);
        b.b(hashMap);
        hashMap.put("device_type", "3");
        String b = com.baidu.android.pushservice.k.e.b(this.a);
        if (com.baidu.android.pushservice.h.f()) {
            hashMap.put("rsa_device_id", com.baidu.android.pushservice.k.b.a(com.baidu.android.pushservice.k.g.b(b.getBytes(), "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC/7VlVn9LIrZ71PL2RZMbK/Yxc\r\ndb046w/cXVylxS7ouPY06namZUFVhdbUnNRJzmGUZlzs3jUbvMO3l+4c9cw/n9aQ\r\nrm/brgaRDeZbeSrQYRZv60xzJIimuFFxsRM+ku6/dAyYmXiQXlRbgvFQ0MsVng4j\r\nv+cXhtTis2Kbwb8mQwIDAQAB\r\n"), "utf-8"));
        } else {
            hashMap.put("device_id", b);
        }
        hashMap.put("device_name", Build.MODEL);
        int b2 = com.baidu.android.pushservice.j.m.b(this.a, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", -1);
        String a = com.baidu.android.pushservice.j.m.a(this.a, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE");
        if (b2 == 2) {
            hashMap.put(SapiAccountManager.SESSION_BDUSS, com.baidu.android.pushservice.j.m.a(this.a, "com.baidu.android.pushservice.PushManager.BDUSS"));
            hashMap.put("appid", a);
        } else if (b2 == 1) {
            hashMap.put("access_token", a);
        } else {
            hashMap.put("apikey", a);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("api_level", Build.VERSION.SDK_INT);
        int[] b3 = com.baidu.android.pushservice.j.p.b(this.a);
        jSONObject.put("screen_height", b3[0]);
        jSONObject.put("screen_width", b3[1]);
        String str = Build.MODEL;
        if (str.length() > 128) {
            str = str.substring(0, TransportMediator.KEYCODE_MEDIA_PAUSE);
        }
        jSONObject.put("model", str);
        jSONObject.put("isroot", com.baidu.android.pushservice.j.p.a(this.a) ? 1 : 0);
        jSONObject.put("is_baidu_app", com.baidu.android.pushservice.j.p.e(this.a, this.a.getPackageName()) ? 1 : 0);
        jSONObject.put("push_sdk_version", (int) com.baidu.android.pushservice.a.a());
        String str2 = Build.MANUFACTURER;
        if (str2.length() > 128) {
            str2 = str2.substring(0, TransportMediator.KEYCODE_MEDIA_PAUSE);
        }
        jSONObject.put("manufacturer", str2);
        hashMap.put(LoginActivityConfig.INFO, jSONObject.toString());
        com.baidu.android.pushservice.g.a.c("TokenRequester", "TOKEN param -- " + b.a(hashMap));
        return hashMap;
    }

    private void d() {
        this.c++;
        if (this.c >= this.b) {
            com.baidu.android.pushservice.g.a.b("TokenRequester", "hava reconnect " + this.b + " times, all failed.");
            this.d = false;
            return;
        }
        int i = (1 << (this.c - 1)) * 5 * 1000;
        com.baidu.android.pushservice.g.a.b("TokenRequester", "schedule retry-- retry times: " + this.c + "time delay: " + i);
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            com.baidu.android.pushservice.g.a.e("TokenRequester", "error : " + e.getMessage());
        }
    }

    protected void a() {
        boolean b;
        do {
            b = b();
            if (this.d) {
                d();
            }
            if (this.b <= 0) {
                break;
            }
        } while (this.d);
        if (this.f != null) {
            this.f.a(Boolean.valueOf(b));
            com.baidu.android.pushservice.g.a.c("TokenRequester", "get ChannelToken result = " + b);
        } else {
            com.baidu.android.pushservice.j.p.b("TokenRequester#execute-->mListener is null !!!!!", this.a);
        }
        com.baidu.android.pushservice.g.a.b("TokenRequester", "RequestTokenThread connectResult: " + b);
        com.baidu.android.pushservice.j.p.b("TokenRequester#execute-->RequestTokenThread connectResult: " + b, this.a);
        if (!b) {
            com.baidu.android.pushservice.j.p.e(this.a);
            return;
        }
        b.a(this.a);
        if (com.baidu.android.pushservice.g.a != null) {
            com.baidu.android.pushservice.g.a.b("TokenRequester", "TokenRequester start PushService after Request finish.");
            com.baidu.android.pushservice.j.p.b("TokenRequester#execute-->TokenRequester start PushService after Request finish. ", this.a);
            com.baidu.android.pushservice.j.o.a(this.a, new Intent());
        }
    }

    public void a(int i) {
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
    }
}
