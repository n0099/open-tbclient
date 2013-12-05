package com.baidu.android.pushservice.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushService;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.util.PushDatabase;
import com.baidu.cloudsdk.social.core.SocialConstants;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static String f707a = "";
    private static volatile o c = null;
    private Context b;
    private r d;
    private boolean e = false;

    public o(Context context) {
        this.b = null;
        this.d = null;
        this.b = context.getApplicationContext();
        this.d = r.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InputStream a(HttpEntity httpEntity) {
        Header contentEncoding = httpEntity.getContentEncoding();
        if (contentEncoding == null || contentEncoding.getValue().toLowerCase().indexOf("gzip") == -1) {
            return null;
        }
        return new GZIPInputStream(httpEntity.getContent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(InputStream inputStream) {
        return m.a(inputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(InputStream inputStream) {
        String a2 = m.a(inputStream);
        if (!TextUtils.isEmpty(a2)) {
            try {
                JSONObject jSONObject = new JSONObject(a2);
                int i = jSONObject.getInt("config_type");
                int i2 = jSONObject.getInt("interval");
                if (i == 0) {
                    if (i2 > 0) {
                        PushSettings.c(i2);
                    }
                } else if (i == 1) {
                    this.e = true;
                } else if (i == 2 && i2 > 0) {
                    PushSettings.b(1);
                    Intent intent = new Intent(PushConstants.ACTION_METHOD);
                    intent.putExtra(PushConstants.EXTRA_METHOD, "com.baidu.android.pushservice.action.ENBALE_APPSTAT");
                    intent.setClass(this.b, PushService.class);
                    PendingIntent service = PendingIntent.getService(this.b.getApplicationContext(), 0, intent, 268435456);
                    AlarmManager alarmManager = (AlarmManager) this.b.getSystemService("alarm");
                    alarmManager.cancel(service);
                    alarmManager.set(1, SystemClock.elapsedRealtime() + i2, service);
                }
            } catch (JSONException e) {
                if (com.baidu.android.pushservice.b.a(this.b)) {
                    Log.d("StatisticPoster", "parse 201 exception" + e);
                }
            }
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(InputStream inputStream) {
        String a2 = m.a(inputStream);
        if (!TextUtils.isEmpty(a2)) {
            try {
                JSONObject jSONObject = new JSONObject(a2);
                int i = jSONObject.getInt(SocialConstants.PARAM_ERROR_CODE);
                jSONObject.getString("error_msg");
                if (i == 50009) {
                    PushSettings.b(1);
                }
            } catch (JSONException e) {
            }
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        if (PushSettings.e() == 1 || this.e) {
            return false;
        }
        if (System.currentTimeMillis() - PushSettings.c(this.b) <= 43200000) {
            return PushDatabase.getBehaviorInfoCounts(PushDatabase.getDb(this.b)) >= 10 && m.c(this.b);
        }
        return true;
    }

    public String a() {
        byte[] bArr;
        String a2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", "1.0");
            String b = this.d.b();
            if (!TextUtils.isEmpty(b)) {
                jSONObject.put("common", new JSONObject(b));
            }
            a2 = this.d.a();
        } catch (JSONException e) {
        }
        if (TextUtils.isEmpty(a2)) {
            return "";
        }
        jSONObject.put("application_info", new JSONArray(a2));
        try {
            bArr = g.a(jSONObject.toString());
            bArr[0] = 117;
            bArr[1] = 123;
        } catch (IOException e2) {
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 0);
    }

    public void b() {
        try {
            new Thread(new p(this), "PushCheckSendS").start();
        } catch (OutOfMemoryError e) {
            Log.e("StatisticPoster", "OutOfMemoryError when PushCheckSendS");
        }
    }

    public void c() {
        String a2 = a();
        try {
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            new q(this, "http://statsonline.pushct.baidu.com/pushlog", a2).start();
        } catch (OutOfMemoryError e) {
            Log.e("StatisticPoster", "OutOfMemoryError when posting");
        }
    }
}
