package com.baidu.android.pushservice.h;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushSettings;
import java.io.InputStream;
import java.util.HashMap;
import org.apache.http.client.methods.HttpPost;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class m {
    protected Context a;
    protected String b;
    private boolean c = false;
    private boolean d = false;

    public m(Context context) {
        this.a = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        InputStream inputStream;
        Throwable th;
        if (TextUtils.isEmpty(this.b)) {
            return;
        }
        InputStream inputStream2 = null;
        long j = 1000;
        try {
            try {
                String a = a(z);
                if (!TextUtils.isEmpty(a)) {
                    if (!b()) {
                        this.b += com.baidu.android.pushservice.j.a(this.a).a();
                    }
                    HashMap<String, String> hashMap = new HashMap<>();
                    com.baidu.android.pushservice.e.b.a(hashMap);
                    a(a, hashMap);
                    int i = 0;
                    while (true) {
                        if (i >= 2) {
                            break;
                        }
                        try {
                            com.baidu.android.pushservice.f.a a2 = com.baidu.android.pushservice.f.b.a(this.b, HttpPost.METHOD_NAME, hashMap);
                            int b = a2.b();
                            inputStream2 = a2.a();
                            String a3 = com.baidu.android.pushservice.h.a.b.a(inputStream2);
                            if (b == 200) {
                                b(a3);
                                break;
                            } else if (b == 201) {
                                c(a3);
                                break;
                            } else if (b == 403) {
                                d(a3);
                                break;
                            } else {
                                j += i * 300;
                                Thread.sleep(j);
                                i++;
                            }
                        } catch (Throwable th2) {
                            inputStream = inputStream2;
                            th = th2;
                            com.baidu.android.pushservice.f.b.a(inputStream);
                            throw th;
                        }
                    }
                }
                com.baidu.android.pushservice.f.b.a(inputStream2);
            } catch (Exception e) {
                com.baidu.android.pushservice.f.b.a(null);
            }
        } catch (Throwable th3) {
            inputStream = null;
            th = th3;
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
        if (!this.c && a() && com.baidu.android.pushservice.j.a(this.a).c()) {
            this.c = true;
            com.baidu.android.pushservice.i.d.a().a(new com.baidu.android.pushservice.i.c("PushService-stats-sender", (short) 90) { // from class: com.baidu.android.pushservice.h.m.1
                @Override // com.baidu.android.pushservice.i.c
                public void a() {
                    if (com.baidu.android.pushservice.j.k.e(m.this.a)) {
                        m.this.c(z);
                        m.this.c = false;
                    }
                }
            });
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
            if (i != 0) {
                if (i == 1 || i == 2) {
                }
            } else if (i2 > 0) {
                PushSettings.b(this.a, i2);
            }
        } catch (JSONException e) {
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
            jSONObject.getString(PushConstants.EXTRA_ERROR_CODE);
            if (i == 50009) {
                PushSettings.j(this.a);
            }
        } catch (JSONException e) {
        }
    }
}
