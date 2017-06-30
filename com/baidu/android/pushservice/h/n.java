package com.baidu.android.pushservice.h;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushService;
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
        if (com.baidu.android.pushservice.j.l.a(this.b)) {
            HashMap hashMap = new HashMap();
            hashMap.put("stats", str2);
            hashMap.put("pbVer", str3);
            hashMap.put("os", "android");
            InputStream inputStream2 = null;
            long j = 1000;
            for (int i = 0; i < 3; i++) {
                try {
                    com.baidu.android.pushservice.g.a.b("StatisticPoster", "Statistics request time=" + i + ", url=" + str);
                    com.baidu.android.pushservice.f.a a2 = com.baidu.android.pushservice.f.b.a(str, "POST", hashMap);
                    int b = a2.b();
                    inputStream2 = a2.a();
                    String a3 = com.baidu.android.pushservice.h.a.b.a(inputStream2);
                    if (b == 200) {
                        com.baidu.android.pushservice.g.a.b("StatisticPoster", "Statistics request time=" + i + ", upload success!");
                        com.baidu.android.pushservice.f.b.a(inputStream2);
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
                        com.baidu.android.pushservice.g.a.a("StatisticPoster", e);
                        p.a(this.b, e);
                        com.baidu.android.pushservice.f.b.a(inputStream);
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        com.baidu.android.pushservice.f.b.a(inputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    inputStream = inputStream2;
                    th = th3;
                    com.baidu.android.pushservice.f.b.a(inputStream);
                    throw th;
                }
            }
            com.baidu.android.pushservice.f.b.a(inputStream2);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        long j;
        long j2 = 259200000;
        if (!com.baidu.android.pushservice.h.a.b.d(this.b) || this.d || PushSettings.f(this.b)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long d = PushSettings.d(this.b);
        com.baidu.android.pushservice.g.a.c("StatisticPoster", "checkSendStatisticData currentTime:" + currentTimeMillis + " lastSendTime " + d);
        long j3 = currentTimeMillis - d;
        if (j3 > 259200000) {
            j = currentTimeMillis - 259200000;
            PushSettings.a(this.b, j);
        } else {
            j2 = j3;
            j = d;
        }
        if (com.baidu.android.pushservice.j.l.b(this.b)) {
            if (j2 < 3600000) {
                return false;
            }
        } else if (j2 < PushSettings.e(this.b)) {
            return false;
        }
        return com.baidu.android.pushservice.d.a.b(this.b, currentTimeMillis, j);
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("user_device", com.baidu.android.pushservice.h.a.b.e(this.b));
            jSONObject.put("user_network", com.baidu.android.pushservice.h.a.b.f(this.b));
            jSONObject2.put("channel_id", PushSettings.a(this.b));
            jSONObject2.put("push_running_version", (int) com.baidu.android.pushservice.a.a());
            jSONObject.put("push_channel", jSONObject2);
        } catch (JSONException e) {
            com.baidu.android.pushservice.g.a.a("StatisticPoster", e);
        }
        return jSONObject.toString();
    }

    public String a(long j, long j2, int i) {
        byte[] bArr;
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", "1.0");
            String a2 = a();
            if (!TextUtils.isEmpty(a2)) {
                jSONObject.put("common", new JSONObject(a2));
            }
            String a3 = this.c.a(j, j2, i);
            if (!TextUtils.isEmpty(a3)) {
                jSONObject.put("application_info", new JSONArray(a3));
            }
        } catch (JSONException e) {
        }
        try {
            bArr = com.baidu.android.pushservice.h.a.a.a(jSONObject.toString());
            bArr[0] = 117;
            bArr[1] = 123;
        } catch (IOException e2) {
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        try {
            str = com.baidu.android.pushservice.k.b.a(bArr, "utf-8");
        } catch (UnsupportedEncodingException e3) {
            com.baidu.android.pushservice.g.a.e("StatisticPoster", "error " + e3.getMessage());
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
                    intent.setClass(this.b, PushService.class);
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
            com.baidu.android.pushservice.g.a.c("StatisticPoster", "parse 201 exception" + e);
        }
    }

    public void b() {
        com.baidu.android.pushservice.i.d.a().a(new com.baidu.android.pushservice.i.c("checkSendStatisticData", (short) 90) { // from class: com.baidu.android.pushservice.h.n.1
            @Override // com.baidu.android.pushservice.i.c
            public void a() {
                if (n.this.d()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    int i = (int) ((currentTimeMillis / TbConfig.USE_TIME_INTERVAL) % 5);
                    int i2 = ((int) (currentTimeMillis / 1000)) % 60;
                    if (i == 0 && i2 < 15) {
                        try {
                            Thread.sleep((long) (Math.random() * 60.0d * 1000.0d));
                        } catch (InterruptedException e) {
                            com.baidu.android.pushservice.g.a.e("StatisticPoster", "InterruptedException: " + e);
                        }
                        if (!com.baidu.android.pushservice.h.a.b.d(n.this.b)) {
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

    public boolean b(long j, long j2, int i) {
        String a2 = a(j, j2, i);
        try {
            if (!TextUtils.isEmpty(a2)) {
                return a("https://statsonline.pushct.baidu.com/pushlog_special", a2, "1.0");
            }
        } catch (OutOfMemoryError e) {
            com.baidu.android.pushservice.g.a.e("StatisticPoster", "OutOfMemoryError when posting");
        }
        return false;
    }

    public synchronized void c() {
        long currentTimeMillis = System.currentTimeMillis();
        long d = PushSettings.d(this.b);
        if (com.baidu.android.pushservice.d.a.a(this.b, currentTimeMillis, d) > 0 ? b(currentTimeMillis, d, 1000) : true) {
            PushSettings.a(this.b, System.currentTimeMillis());
            try {
                com.baidu.android.pushservice.d.a.d(this.b);
            } catch (Exception e) {
                com.baidu.android.pushservice.g.a.e("StatisticPoster", "clearBehaviorInfo exception" + e);
            }
        }
    }
}
