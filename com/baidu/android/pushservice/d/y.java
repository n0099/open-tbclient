package com.baidu.android.pushservice.d;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.pushservice.d.a;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.mobstat.Config;
import com.tencent.connect.common.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class y implements Runnable {
    private Context a;
    private int b = 3;
    private int c;
    private boolean d;
    private a.C0032a e;

    public y(Context context, a.C0032a c0032a) {
        this.a = context.getApplicationContext();
        this.e = c0032a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.io.Closeable[] */
    /* JADX WARN: Multi-variable type inference failed */
    private boolean b() {
        Throwable th;
        InputStream inputStream;
        boolean z;
        String str;
        String str2 = null;
        String d = com.baidu.android.pushservice.g.d();
        try {
            try {
                com.baidu.android.pushservice.e.a a = com.baidu.android.pushservice.e.b.a(d, "POST", c());
                int b = a.b();
                inputStream = a.a();
                try {
                    if (b == 200) {
                        JSONObject jSONObject = new JSONObject(com.baidu.android.pushservice.g.a.b.a(inputStream)).getJSONObject("response_params");
                        if (jSONObject != null) {
                            String string = jSONObject.getString("channel_id");
                            String string2 = com.baidu.android.pushservice.g.f() ? jSONObject.getString("rsa_channel_token") : jSONObject.getString("channel_token");
                            jSONObject.getString(Constants.PARAM_EXPIRES_TIME);
                            if (com.baidu.android.pushservice.b.d.b(this.a)) {
                                str = jSONObject.optString("new_channel_id");
                                str2 = com.baidu.android.pushservice.g.f() ? jSONObject.optString("new_rsa_channel_token") : jSONObject.optString("new_channel_token");
                                jSONObject.optString("new_expires_time");
                            } else {
                                str = null;
                            }
                            com.baidu.android.pushservice.i.a(this.a).a(string, string2, str, str2);
                            z = true;
                        } else {
                            z = false;
                        }
                    } else {
                        com.baidu.android.pushservice.g.a.b.a(inputStream);
                        z = false;
                    }
                    try {
                        this.c = 0;
                        if (inputStream == null) {
                            this.d = true;
                        } else {
                            this.d = false;
                        }
                        com.baidu.android.pushservice.e.b.a(inputStream);
                    } catch (IOException e) {
                        this.d = true;
                        com.baidu.android.pushservice.e.b.a(inputStream);
                        return z;
                    } catch (Exception e2) {
                        this.d = false;
                        com.baidu.android.pushservice.e.b.a(inputStream);
                        return z;
                    }
                } catch (IOException e3) {
                    z = false;
                } catch (Exception e4) {
                    z = false;
                }
            } catch (Throwable th2) {
                th = th2;
                com.baidu.android.pushservice.e.b.a(d);
                throw th;
            }
        } catch (IOException e5) {
            inputStream = null;
            z = false;
        } catch (Exception e6) {
            inputStream = null;
            z = false;
        } catch (Throwable th3) {
            d = null;
            th = th3;
            com.baidu.android.pushservice.e.b.a(d);
            throw th;
        }
        return z;
    }

    private HashMap<String, String> c() throws Exception {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("method", "token");
        b.a(hashMap);
        hashMap.put("device_type", "3");
        String deviceID = DeviceId.getDeviceID(this.a);
        if (com.baidu.android.pushservice.g.f()) {
            hashMap.put("rsa_device_id", com.baidu.android.pushservice.j.b.a(BaiduAppSSOJni.encryptR(deviceID.getBytes(), 1), "utf-8"));
        } else {
            hashMap.put("device_id", deviceID);
        }
        hashMap.put("device_name", Build.MODEL);
        int b = com.baidu.android.pushservice.i.i.b(this.a, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", -1);
        String a = com.baidu.android.pushservice.i.i.a(this.a, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE");
        if (b == 2) {
            hashMap.put("bduss", com.baidu.android.pushservice.i.i.a(this.a, "com.baidu.android.pushservice.PushManager.BDUSS"));
            hashMap.put("appid", a);
        } else if (b == 1) {
            hashMap.put("access_token", a);
        } else {
            hashMap.put("apikey", a);
        }
        if (com.baidu.android.pushservice.b.d.b(this.a)) {
            hashMap.put("mode", t.a(this.a) + "");
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("api_level", Build.VERSION.SDK_INT);
        int[] a2 = com.baidu.android.pushservice.i.l.a(this.a);
        jSONObject.put("screen_height", a2[0]);
        jSONObject.put("screen_width", a2[1]);
        String str = Build.MODEL;
        if (str.length() > 128) {
            str = str.substring(0, 127);
        }
        jSONObject.put("model", str);
        jSONObject.put("isroot", 0);
        jSONObject.put("is_baidu_app", com.baidu.android.pushservice.i.l.e(this.a, this.a.getPackageName()) ? 1 : 0);
        jSONObject.put("push_sdk_version", (int) com.baidu.android.pushservice.a.a());
        String str2 = Build.MANUFACTURER;
        if (str2.length() > 128) {
            str2 = str2.substring(0, 127);
        }
        jSONObject.put("manufacturer", str2);
        hashMap.put(Config.LAUNCH_INFO, jSONObject.toString());
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
        if (this.e != null) {
            this.e.a(Boolean.valueOf(b));
        } else {
            com.baidu.android.pushservice.i.l.b("TokenRequester#execute-->mListener is null !!!!!", this.a);
        }
        com.baidu.android.pushservice.i.l.b("TokenRequester#execute-->RequestTokenThread connectResult: " + b, this.a);
        if (!b) {
            com.baidu.android.pushservice.i.l.e(this.a);
            return;
        }
        b.a(this.a);
        if (com.baidu.android.pushservice.f.a != null) {
            com.baidu.android.pushservice.i.l.b("TokenRequester#execute-->TokenRequester start PushService after Request finish. ", this.a);
            com.baidu.android.pushservice.i.k.a(this.a, new Intent());
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
