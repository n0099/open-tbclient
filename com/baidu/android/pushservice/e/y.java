package com.baidu.android.pushservice.e;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.pushservice.e.a;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.util.IoUtils;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.tencent.connect.common.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class y implements Runnable {
    private Context a;
    private int c;
    private boolean d;
    private a.C0030a f;
    private int b = 3;
    private boolean e = true;

    public y(Context context, a.C0030a c0030a) {
        this.a = context.getApplicationContext();
        this.f = c0030a;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:49:0x00f6 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.io.Closeable[] */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    private boolean b() {
        InputStream inputStream;
        boolean z;
        String str;
        String str2 = null;
        String d = com.baidu.android.pushservice.h.d();
        int i = this.c;
        String str3 = d;
        String str4 = i;
        if (i > 2) {
            String b = com.baidu.android.pushservice.h.b(this.a, this.e);
            this.e = false;
            boolean isEmpty = TextUtils.isEmpty(b);
            str3 = d;
            str4 = b;
            if (!isEmpty) {
                String str5 = "http://" + b;
                str3 = d.replace(com.baidu.android.pushservice.h.b(), str5);
                str4 = str5;
            }
        }
        try {
            try {
                com.baidu.android.pushservice.f.a a = com.baidu.android.pushservice.f.b.a(str3, "POST", c());
                int b2 = a.b();
                inputStream = a.a();
                try {
                    if (b2 == 200) {
                        JSONObject jSONObject = new JSONObject(com.baidu.android.pushservice.h.a.b.a(inputStream)).getJSONObject("response_params");
                        if (jSONObject != null) {
                            String string = jSONObject.getString("channel_id");
                            String string2 = com.baidu.android.pushservice.h.f() ? jSONObject.getString("rsa_channel_token") : jSONObject.getString("channel_token");
                            jSONObject.getString(Constants.PARAM_EXPIRES_TIME);
                            if (com.baidu.android.pushservice.c.e.b(this.a)) {
                                str = jSONObject.optString("new_channel_id");
                                str2 = com.baidu.android.pushservice.h.f() ? jSONObject.optString("new_rsa_channel_token") : jSONObject.optString("new_channel_token");
                                jSONObject.optString("new_expires_time");
                            } else {
                                str = null;
                            }
                            com.baidu.android.pushservice.j.a(this.a).a(string, string2, str, str2);
                            z = true;
                        } else {
                            z = false;
                        }
                    } else {
                        com.baidu.android.pushservice.h.a.b.a(inputStream);
                        z = false;
                    }
                    try {
                        this.c = 0;
                        if (inputStream == null) {
                            this.d = true;
                        } else {
                            this.d = false;
                        }
                        com.baidu.android.pushservice.f.b.a(inputStream);
                    } catch (IOException e) {
                        this.d = true;
                        com.baidu.android.pushservice.f.b.a(inputStream);
                        return z;
                    } catch (Exception e2) {
                        this.d = false;
                        com.baidu.android.pushservice.f.b.a(inputStream);
                        return z;
                    }
                } catch (IOException e3) {
                    z = false;
                } catch (Exception e4) {
                    z = false;
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.android.pushservice.f.b.a(str4);
                throw th;
            }
        } catch (IOException e5) {
            inputStream = null;
            z = false;
        } catch (Exception e6) {
            inputStream = null;
            z = false;
        } catch (Throwable th2) {
            th = th2;
            str4 = null;
            com.baidu.android.pushservice.f.b.a(str4);
            throw th;
        }
        return z;
    }

    private HashMap<String, String> c() throws Exception {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("method", com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_TOKEN);
        b.a(hashMap);
        hashMap.put(StatisticConstants.DEVICE_TYPE, "3");
        String b = com.baidu.android.pushservice.k.e.b(this.a);
        if (com.baidu.android.pushservice.h.f()) {
            hashMap.put("rsa_device_id", com.baidu.android.pushservice.k.b.a(BaiduAppSSOJni.encryptR(b.getBytes(), 1), IoUtils.UTF_8));
        } else {
            hashMap.put("device_id", b);
        }
        hashMap.put("device_name", Build.MODEL);
        int b2 = com.baidu.android.pushservice.j.j.b(this.a, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", -1);
        String a = com.baidu.android.pushservice.j.j.a(this.a, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE");
        if (b2 == 2) {
            hashMap.put("bduss", com.baidu.android.pushservice.j.j.a(this.a, "com.baidu.android.pushservice.PushManager.BDUSS"));
            hashMap.put("appid", a);
        } else if (b2 == 1) {
            hashMap.put("access_token", a);
        } else {
            hashMap.put("apikey", a);
        }
        if (com.baidu.android.pushservice.c.e.b(this.a)) {
            hashMap.put("mode", t.a(this.a) + "");
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("api_level", Build.VERSION.SDK_INT);
        int[] b3 = com.baidu.android.pushservice.j.m.b(this.a);
        jSONObject.put("screen_height", b3[0]);
        jSONObject.put("screen_width", b3[1]);
        String str = Build.MODEL;
        if (str.length() > 128) {
            str = str.substring(0, 127);
        }
        jSONObject.put("model", str);
        jSONObject.put("isroot", com.baidu.android.pushservice.j.m.a(this.a) ? 1 : 0);
        jSONObject.put("is_baidu_app", com.baidu.android.pushservice.j.m.e(this.a, this.a.getPackageName()) ? 1 : 0);
        jSONObject.put("push_sdk_version", (int) com.baidu.android.pushservice.a.a());
        String str2 = Build.MANUFACTURER;
        if (str2.length() > 128) {
            str2 = str2.substring(0, 127);
        }
        jSONObject.put("manufacturer", str2);
        hashMap.put(LoginActivityConfig.INFO, jSONObject.toString());
        return hashMap;
    }

    private void d() {
        this.c++;
        if (this.c >= this.b) {
            this.d = false;
            return;
        }
        try {
            Thread.sleep((1 << (this.c - 1)) * 5 * 1000);
        } catch (InterruptedException e) {
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
        } else {
            com.baidu.android.pushservice.j.m.b("TokenRequester#execute-->mListener is null !!!!!", this.a);
        }
        com.baidu.android.pushservice.j.m.b("TokenRequester#execute-->RequestTokenThread connectResult: " + b, this.a);
        if (!b) {
            com.baidu.android.pushservice.j.m.e(this.a);
            return;
        }
        b.a(this.a);
        if (com.baidu.android.pushservice.g.a != null) {
            com.baidu.android.pushservice.j.m.b("TokenRequester#execute-->TokenRequester start PushService after Request finish. ", this.a);
            com.baidu.android.pushservice.j.l.a(this.a, new Intent());
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
