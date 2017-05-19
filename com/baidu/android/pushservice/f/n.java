package com.baidu.android.pushservice.f;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.tbadk.TbConfig;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class n {
    public static String a = "";
    private Context b;
    private o c;
    private boolean d = false;

    public n(Context context) {
        this.b = null;
        this.c = null;
        this.b = context.getApplicationContext();
        this.c = o.a(context);
    }

    private boolean a(String str, String str2, String str3) {
        InputStream inputStream;
        Throwable th;
        if (com.baidu.android.pushservice.h.k.a(this.b)) {
            HashMap hashMap = new HashMap();
            hashMap.put("stats", str2);
            hashMap.put("pbVer", str3);
            hashMap.put("os", "android");
            InputStream inputStream2 = null;
            long j = 1000;
            for (int i = 0; i < 3; i++) {
                try {
                    com.baidu.android.pushservice.e.a.b("StatisticPoster", "Statistics request time=" + i + ", url=" + str);
                    com.baidu.android.pushservice.d.a a2 = com.baidu.android.pushservice.d.b.a(str, "POST", hashMap);
                    int b = a2.b();
                    inputStream2 = a2.a();
                    String a3 = com.baidu.android.pushservice.f.a.b.a(inputStream2);
                    if (b == 200) {
                        com.baidu.android.pushservice.e.a.b("StatisticPoster", "Statistics request time=" + i + ", upload success!");
                        com.baidu.android.pushservice.d.b.a(inputStream2);
                        return true;
                    }
                    if (b == 201) {
                        a(a3);
                    } else if (b == 403) {
                        b(a3);
                    }
                    if (b == 200 || b == 201 || b == 403) {
                        break;
                    }
                    j += i * 300;
                    Thread.sleep(j);
                } catch (Exception e) {
                    inputStream = inputStream2;
                    try {
                        com.baidu.android.pushservice.e.a.a("StatisticPoster", e);
                        p.a(this.b, e);
                        com.baidu.android.pushservice.d.b.a(inputStream);
                        return false;
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
            com.baidu.android.pushservice.d.b.a(inputStream2);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        if (!com.baidu.android.pushservice.f.a.b.d(this.b) || this.d || PushSettings.f(this.b)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long d = PushSettings.d(this.b);
        com.baidu.android.pushservice.e.a.c("StatisticPoster", "checkSendStatisticData currentTime:" + currentTimeMillis + " lastSendTime " + d);
        if (com.baidu.android.pushservice.h.k.b(this.b) || currentTimeMillis - d >= PushSettings.e(this.b)) {
            return com.baidu.android.pushservice.h.o.b(this.b, currentTimeMillis, d);
        }
        return false;
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("user_device", com.baidu.android.pushservice.f.a.b.e(this.b));
            jSONObject.put("user_network", com.baidu.android.pushservice.f.a.b.f(this.b));
            jSONObject2.put("channel_id", PushSettings.a(this.b));
            jSONObject2.put("push_running_version", (int) com.baidu.android.pushservice.a.a());
            jSONObject.put("push_channel", jSONObject2);
        } catch (JSONException e) {
            com.baidu.android.pushservice.e.a.a("StatisticPoster", e);
        }
        return jSONObject.toString();
    }

    public String a(long j, long j2, int i, int i2) {
        byte[] bArr;
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", "1.0");
            String a2 = a();
            if (!TextUtils.isEmpty(a2)) {
                jSONObject.put("common", new JSONObject(a2));
            }
            String a3 = this.c.a(j, j2, i, i2);
            if (!TextUtils.isEmpty(a3)) {
                jSONObject.put("application_info", new JSONArray(a3));
            }
        } catch (JSONException e) {
        }
        try {
            bArr = com.baidu.android.pushservice.f.a.a.a(jSONObject.toString());
            bArr[0] = 117;
            bArr[1] = 123;
        } catch (IOException e2) {
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        try {
            str = com.baidu.android.pushservice.i.b.a(bArr, "utf-8");
        } catch (UnsupportedEncodingException e3) {
            com.baidu.android.pushservice.e.a.e("StatisticPoster", "error " + e3.getMessage());
            str = null;
        }
        return str;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("config_type");
            int i2 = jSONObject.getInt("interval");
            if (i == 0) {
                if (i2 > 0) {
                    PushSettings.b(this.b, i2 * 1000);
                }
            } else if (i == 1) {
                this.d = true;
            } else if (i == 2) {
                if (i2 > 0) {
                    PushSettings.a(this.b, 1);
                    Intent intent = new Intent(PushConstants.ACTION_METHOD);
                    intent.putExtra(PushConstants.EXTRA_METHOD, "com.baidu.android.pushservice.action.ENBALE_APPSTAT");
                    intent.setClassName(this.b, "com.baidu.android.pushservice.PushService");
                    PendingIntent service = PendingIntent.getService(this.b.getApplicationContext(), 0, intent, 268435456);
                    AlarmManager alarmManager = (AlarmManager) this.b.getSystemService("alarm");
                    alarmManager.cancel(service);
                    alarmManager.set(1, SystemClock.elapsedRealtime() + i2, service);
                }
            } else if (i == 10) {
                PushSettings.j(this.b);
            } else if (i == 11) {
                PushSettings.k(this.b);
            }
        } catch (JSONException e) {
            com.baidu.android.pushservice.e.a.c("StatisticPoster", "parse 201 exception" + e);
        }
    }

    public void b() {
        com.baidu.android.pushservice.g.d.a().a(new com.baidu.android.pushservice.g.c("checkSendStatisticData", (short) 90) { // from class: com.baidu.android.pushservice.f.n.1
            @Override // com.baidu.android.pushservice.g.c
            public void a() {
                if (n.this.d()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    int i = (int) ((currentTimeMillis / TbConfig.USE_TIME_INTERVAL) % 5);
                    int i2 = ((int) (currentTimeMillis / 1000)) % 60;
                    if (i == 0 && i2 < 15) {
                        try {
                            Thread.sleep((long) (Math.random() * 60.0d * 1000.0d));
                        } catch (InterruptedException e) {
                            com.baidu.android.pushservice.e.a.e("StatisticPoster", "InterruptedException: " + e);
                        }
                        if (!com.baidu.android.pushservice.f.a.b.d(n.this.b)) {
                            return;
                        }
                    }
                    n.this.c();
                }
            }
        });
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("error_code");
            jSONObject.getString(PushConstants.EXTRA_ERROR_CODE);
            if (i == 50009) {
                PushSettings.a(this.b, 1);
            }
        } catch (JSONException e) {
        }
    }

    public boolean b(long j, long j2, int i, int i2) {
        String a2 = a(j, j2, i, i2);
        try {
            if (!TextUtils.isEmpty(a2)) {
                return a("https://statsonline.pushct.baidu.com/pushlog_special", a2, "1.0");
            }
        } catch (OutOfMemoryError e) {
            com.baidu.android.pushservice.e.a.e("StatisticPoster", "OutOfMemoryError when posting");
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0027, code lost:
        if (r7 > 1000) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
        if (r7 <= 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
        r0 = b(r1, r3, r5, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (r0 == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:
        com.baidu.android.pushservice.PushSettings.a(r9.b, java.lang.System.currentTimeMillis());
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
        com.baidu.android.pushservice.h.o.d(r9.b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0043, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0044, code lost:
        com.baidu.android.pushservice.e.a.e("StatisticPoster", "clearBehaviorInfo exception" + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
        r0 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void c() {
        long currentTimeMillis = System.currentTimeMillis();
        long d = PushSettings.d(this.b);
        int i = 0;
        int a2 = com.baidu.android.pushservice.h.o.a(this.b, currentTimeMillis, d);
        while (true) {
            if (a2 < 1000) {
                break;
            } else if (!b(currentTimeMillis, d, i, 1000)) {
                break;
            } else {
                i += 1000;
                a2 -= 1000;
            }
        }
    }
}
