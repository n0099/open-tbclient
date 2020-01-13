package com.baidu.android.pushservice.g;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushService;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.data.Config;
import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class k {
    public static String a = "";
    private Context b;
    private l c;
    private boolean d = false;

    public k(Context context) {
        this.b = null;
        this.c = null;
        this.b = context.getApplicationContext();
        this.c = l.a(context);
    }

    private boolean a(String str, String str2, String str3) {
        InputStream inputStream;
        Throwable th;
        if (com.baidu.android.pushservice.i.g.a(this.b)) {
            HashMap hashMap = new HashMap();
            hashMap.put("stats", str2);
            hashMap.put("pbVer", str3);
            hashMap.put("os", PraiseDataPassUtil.KEY_FROM_OS);
            InputStream inputStream2 = null;
            long j = 1000;
            int i = 0;
            while (true) {
                if (i >= 2) {
                    break;
                }
                try {
                    com.baidu.android.pushservice.e.a a2 = com.baidu.android.pushservice.e.b.a(str, "POST", hashMap);
                    int b = a2.b();
                    inputStream2 = a2.a();
                    String a3 = com.baidu.android.pushservice.g.a.b.a(inputStream2);
                    if (b == 200) {
                        com.baidu.android.pushservice.e.b.a(inputStream2);
                        return true;
                    } else if (b == 201) {
                        a(a3);
                        break;
                    } else if (b == 403) {
                        b(a3);
                        break;
                    } else {
                        j += i * 300;
                        Thread.sleep(j);
                        i++;
                    }
                } catch (Exception e) {
                    inputStream = inputStream2;
                    try {
                        m.a(this.b, e);
                        com.baidu.android.pushservice.e.b.a(inputStream);
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        com.baidu.android.pushservice.e.b.a(inputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    inputStream = inputStream2;
                    th = th3;
                    com.baidu.android.pushservice.e.b.a(inputStream);
                    throw th;
                }
            }
            com.baidu.android.pushservice.e.b.a(inputStream2);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        long j;
        long j2 = Config.THREAD_IMAGE_SAVE_MAX_TIME;
        if (!com.baidu.android.pushservice.g.a.b.c(this.b) || this.d || PushSettings.g(this.b)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long e = PushSettings.e(this.b);
        long j3 = currentTimeMillis - e;
        if (j3 > Config.THREAD_IMAGE_SAVE_MAX_TIME) {
            j = currentTimeMillis - Config.THREAD_IMAGE_SAVE_MAX_TIME;
            PushSettings.a(this.b, j);
        } else {
            j2 = j3;
            j = e;
        }
        if (com.baidu.android.pushservice.i.g.b(this.b)) {
            if (j2 < 21600000) {
                return false;
            }
        } else if (j2 < PushSettings.f(this.b)) {
            return false;
        }
        return com.baidu.android.pushservice.c.a.b(this.b, currentTimeMillis, j);
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("user_device", com.baidu.android.pushservice.g.a.b.e(this.b));
            jSONObject.put("user_network", com.baidu.android.pushservice.g.a.b.d(this.b));
            jSONObject2.put(SharedPrefConfig.CHANNEL_ID, PushSettings.a(this.b));
            jSONObject2.put("push_running_version", (int) com.baidu.android.pushservice.a.a());
            jSONObject.put("push_channel", jSONObject2);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }

    public String a(long j, long j2, int i) {
        byte[] bArr;
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
            bArr = com.baidu.android.pushservice.g.a.a.a(jSONObject.toString());
            bArr[0] = 117;
            bArr[1] = 123;
        } catch (IOException e2) {
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        try {
            return com.baidu.android.pushservice.j.b.a(bArr, "utf-8");
        } catch (UnsupportedEncodingException e3) {
            return null;
        }
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
            } else if (i == 2 && i2 > 0) {
                PushSettings.a(this.b, 1);
                Intent intent = new Intent(PushConstants.ACTION_METHOD);
                intent.putExtra("method", "com.baidu.android.pushservice.action.ENBALE_APPSTAT");
                intent.setClass(this.b, PushService.class);
                PendingIntent service = PendingIntent.getService(this.b.getApplicationContext(), 0, intent, 268435456);
                AlarmManager alarmManager = (AlarmManager) this.b.getSystemService(NotificationCompat.CATEGORY_ALARM);
                alarmManager.cancel(service);
                alarmManager.set(1, SystemClock.elapsedRealtime() + i2, service);
            }
        } catch (JSONException e) {
        }
    }

    public void b() {
        com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c("checkSendStatisticData", (short) 90) { // from class: com.baidu.android.pushservice.g.k.1
            @Override // com.baidu.android.pushservice.h.c
            public void a() {
                if (k.this.d()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    int i = (int) ((currentTimeMillis / 60000) % 5);
                    int i2 = ((int) (currentTimeMillis / 1000)) % 60;
                    if (i == 0 && i2 < 15) {
                        try {
                            Thread.sleep((long) (Math.random() * 60.0d * 1000.0d));
                        } catch (InterruptedException e) {
                        }
                        if (!com.baidu.android.pushservice.g.a.b.c(k.this.b)) {
                            return;
                        }
                    }
                    k.this.c();
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
        }
        return false;
    }

    public synchronized void c() {
        long currentTimeMillis = System.currentTimeMillis();
        long e = PushSettings.e(this.b);
        if (com.baidu.android.pushservice.c.a.a(this.b, currentTimeMillis, e) > 0 ? b(currentTimeMillis, e, 1000) : true) {
            PushSettings.a(this.b, System.currentTimeMillis());
            try {
                com.baidu.android.pushservice.c.a.b(this.b);
            } catch (Exception e2) {
            }
        }
    }
}
