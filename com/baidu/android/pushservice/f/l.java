package com.baidu.android.pushservice.f;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushSettings;
import java.io.InputStream;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class l {
    protected Context a;
    protected String b;
    private boolean c = false;
    private boolean d = false;

    public l(Context context) {
        this.a = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        InputStream inputStream;
        Throwable th;
        Exception exc;
        if (TextUtils.isEmpty(this.b)) {
            com.baidu.android.pushservice.e.a.e("Statistics-BaseSender", "mUrl is null");
            return;
        }
        InputStream inputStream2 = null;
        long j = 1000;
        try {
            String a = a(z);
            if (!TextUtils.isEmpty(a)) {
                if (!b()) {
                    this.b += com.baidu.android.pushservice.j.a(this.a).a();
                }
                HashMap<String, String> hashMap = new HashMap<>();
                com.baidu.android.pushservice.c.b.b(hashMap);
                a(a, hashMap);
                for (int i = 0; i < 3; i++) {
                    try {
                        com.baidu.android.pushservice.e.a.c("Statistics-BaseSender", "a request send, url=" + this.b);
                        com.baidu.android.pushservice.d.a a2 = com.baidu.android.pushservice.d.b.a(this.b, "POST", hashMap);
                        int b = a2.b();
                        inputStream2 = a2.a();
                        String a3 = com.baidu.android.pushservice.f.a.b.a(inputStream2);
                        com.baidu.android.pushservice.e.a.c("Statistics-BaseSender", "return response, code= " + b + ", result=" + a3);
                        if (b == 200) {
                            b(a3);
                        } else if (b == 201) {
                            c(a3);
                        } else if (b == 403) {
                            d(a3);
                        }
                        if (b == 200 || b == 201 || b == 403) {
                            break;
                        }
                        j += i * 300;
                        Thread.sleep(j);
                    } catch (Exception e) {
                        inputStream = inputStream2;
                        exc = e;
                        try {
                            com.baidu.android.pushservice.e.a.e("Statistics-BaseSender", "startSendLoop Exception: " + exc);
                            com.baidu.android.pushservice.d.b.a(inputStream);
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            com.baidu.android.pushservice.d.b.a(inputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        inputStream = inputStream2;
                        th = th3;
                        com.baidu.android.pushservice.d.b.a(inputStream);
                        throw th;
                    }
                }
            }
            com.baidu.android.pushservice.d.b.a(inputStream2);
        } catch (Exception e2) {
            inputStream = null;
            exc = e2;
        } catch (Throwable th4) {
            inputStream = null;
            th = th4;
        }
    }

    abstract String a(boolean z);

    abstract void a(String str);

    abstract void a(String str, HashMap<String, String> hashMap);

    abstract boolean a();

    public void b(String str) {
        a(str);
    }

    public synchronized void b(final boolean z) {
        if (!this.c) {
            if (!a()) {
                com.baidu.android.pushservice.e.a.d("Statistics-BaseSender", "No new data producted, do nothing!");
            } else if (com.baidu.android.pushservice.j.a(this.a).c()) {
                this.c = true;
                com.baidu.android.pushservice.g.d.a().a(new com.baidu.android.pushservice.g.c("PushService-stats-sender", (short) 90) { // from class: com.baidu.android.pushservice.f.l.1
                    @Override // com.baidu.android.pushservice.g.c
                    public void a() {
                        if (!com.baidu.android.pushservice.h.k.e(l.this.a)) {
                            com.baidu.android.pushservice.e.a.d("Statistics-BaseSender", "Network is not reachable!");
                            return;
                        }
                        l.this.c(z);
                        l.this.c = false;
                    }
                });
            } else {
                com.baidu.android.pushservice.e.a.e("Statistics-BaseSender", "Fail Send Statistics. Token invalid!");
            }
        }
    }

    abstract boolean b();

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("config_type");
            int i2 = jSONObject.getInt("interval");
            com.baidu.android.pushservice.e.a.c("Statistics-BaseSender", "lbs config_type = " + i + " interval = " + i2);
            if (i != 0) {
                if (i == 1 || i == 2) {
                }
            } else if (i2 > 0) {
                PushSettings.b(this.a, i2);
            }
        } catch (JSONException e) {
            com.baidu.android.pushservice.e.a.e("Statistics-BaseSender", "parse 201 exception" + e);
        }
    }

    public boolean c() {
        return this.d;
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("error_code");
            com.baidu.android.pushservice.e.a.c("Statistics-BaseSender", "error code = " + i + " error_msg = " + jSONObject.getString(PushConstants.EXTRA_ERROR_CODE));
            if (i == 50009) {
                PushSettings.j(this.a);
            }
        } catch (JSONException e) {
            com.baidu.android.pushservice.e.a.e("Statistics-BaseSender", " parse 403 exception" + e);
        }
    }
}
