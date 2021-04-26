package com.baidu.android.pushservice.frequency;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.c.c;
import com.baidu.android.pushservice.h;
import com.baidu.android.pushservice.h.d;
import com.baidu.android.pushservice.j.i;
import com.baidu.android.pushservice.j.k;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f3085a;

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return new JSONObject(str).optInt("error_code");
        } catch (JSONException unused) {
            return 30602;
        }
    }

    public static b a() {
        if (f3085a == null) {
            synchronized (b.class) {
                if (f3085a == null) {
                    f3085a = new b();
                }
            }
        }
        return f3085a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Context context, String str) {
        String cuid = DeviceId.getCUID(context);
        String a2 = i.a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE");
        if (TextUtils.isEmpty(cuid) || TextUtils.isEmpty(a2)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONArray.put(str);
        try {
            jSONObject2.put(SavedStateHandle.KEYS, jSONArray);
            String encodeToString = Base64.encodeToString(k.a(jSONObject2.toString().getBytes(), BaiduAppSSOJni.getPublicKey(3)), 2);
            jSONObject.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, a2);
            jSONObject.put("cuid", cuid);
            jSONObject.put("data", encodeToString);
            jSONObject.put("data_len", encodeToString.length());
        } catch (JSONException | Exception unused) {
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a(Context context, boolean z, String str, int i2, String str2) {
        String str3;
        String a2 = i.a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE");
        String str4 = "";
        if (z) {
            str3 = i.a(context, "token");
        } else {
            str3 = "";
            str4 = DeviceId.getCUID(context);
        }
        long currentTimeMillis = System.currentTimeMillis();
        String upperCase = Build.MANUFACTURER.toUpperCase();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONArray f2 = c.f(context);
        try {
            jSONObject.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, a2);
            if (z) {
                jSONObject.put("token", str3);
                jSONObject.put("uuid", str);
            } else {
                jSONObject.put("cuid", str4);
            }
            jSONObject.put("upload_time", currentTimeMillis);
            jSONObject.put("manufacture", upperCase);
            jSONObject2.put("event_time", currentTimeMillis);
            jSONObject2.put("vendor_notice", i2);
            jSONObject2.put("payload", str2);
            f2.put(jSONObject2);
            jSONObject.put("data", f2);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, HashMap<String, Object> hashMap) {
        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (entry.getKey().equals(PushConstants.EXTRA_BDUSS_ACTION)) {
                i.a(context, PushConstants.EXTRA_BDUSS_ACTION, entry.getValue().toString());
            } else {
                c.a(context, entry.getKey(), entry.getValue().toString(), Long.valueOf(currentTimeMillis));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, JSONObject jSONObject) {
        try {
            c.a(context, jSONObject.getJSONArray("data"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, Object> b(Context context, HashMap<String, Object> hashMap) {
        Iterator<Map.Entry<String, Object>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> next = it.next();
            if (next.getValue() == null || (!c.d(context, next.getKey(), next.getValue().toString()) && !next.getKey().equals(PushConstants.EXTRA_BDUSS_ACTION))) {
                it.remove();
            }
        }
        if (hashMap.containsKey(PushConstants.EXTRA_BDUSS_ACTION) && !hashMap.containsKey("bduss")) {
            hashMap.remove(PushConstants.EXTRA_BDUSS_ACTION);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, JSONObject jSONObject) {
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    c.a(context, next, jSONObject.get(next).toString(), (Long) null);
                } catch (JSONException unused) {
                }
            }
        }
    }

    private boolean b(Context context, String str, a aVar) {
        String e2 = c.e(context, str);
        if (TextUtils.isEmpty(e2)) {
            return false;
        }
        try {
            if (str.equals(PushConstants.EXTRA_PUSH_FREQ)) {
                int parseInt = Integer.parseInt(e2);
                if (parseInt >= 1 && parseInt <= 3) {
                    ((GetFrequencyListener) aVar).onResult(0, parseInt);
                    return true;
                }
            } else if (str.equals("do_not_disturb")) {
                JSONObject jSONObject = new JSONObject(e2);
                int i2 = jSONObject.getInt("from");
                int i3 = jSONObject.getInt("to");
                if (i2 >= 0 && i2 <= 86400 && i3 <= 86400 && i3 >= 0) {
                    ((GetNoDisturbListener) aVar).onResult(0, i2, i3);
                    return true;
                }
            }
        } catch (NumberFormatException | JSONException unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(Context context, HashMap<String, Object> hashMap) {
        String cuid = DeviceId.getCUID(context);
        String a2 = i.a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE");
        if (TextUtils.isEmpty(cuid) || TextUtils.isEmpty(a2)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
            JSONArray a3 = k.a(jSONObject2.toString(), 3, 2);
            jSONObject.put("info", a3);
            jSONObject.put("info_len", a3.length());
            jSONObject.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, a2);
            jSONObject.put("cuid", cuid);
        } catch (JSONException | Exception unused) {
        }
        return jSONObject.toString();
    }

    public JSONObject a(int i2, int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tz", TimeZone.getDefault().getID());
        } catch (JSONException unused) {
        }
        if (i2 == i3 && i2 == -1) {
            return jSONObject;
        }
        jSONObject.put("from", i2);
        jSONObject.put("to", i3);
        return jSONObject;
    }

    public void a(final Context context, final String str, final a aVar) {
        if (b(context, str, aVar)) {
            return;
        }
        final String str2 = h.f3120c + h.f3124g;
        final HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        d.a().a(new com.baidu.android.pushservice.h.c() { // from class: com.baidu.android.pushservice.frequency.b.3
            /* JADX WARN: Can't wrap try/catch for region: R(7:(2:7|8)|(1:10)(2:26|(7:28|29|30|12|13|14|(2:16|17)(2:19|(2:21|22)(1:23))))|11|12|13|14|(0)(0)) */
            /* JADX WARN: Removed duplicated region for block: B:25:0x0083  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x008b  */
            @Override // com.baidu.android.pushservice.h.c
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void a() {
                int i2;
                int i3;
                int i4;
                JSONObject jSONObject;
                Context context2 = context;
                com.baidu.android.pushservice.e.b a2 = com.baidu.android.pushservice.e.c.a(context2, str2, "POST", b.this.a(context2, str), hashMap, "application/json");
                int i5 = 0;
                if (a2 != null) {
                    String a3 = m.a(context, a2.a());
                    i2 = a2.b();
                    if (i2 == 200 && (i2 = b.this.a(a3)) == 0) {
                        try {
                            jSONObject = new JSONObject(a3).getJSONObject("data");
                        } catch (JSONException unused) {
                        }
                        if (str.equals(PushConstants.EXTRA_PUSH_FREQ)) {
                            i5 = jSONObject.getInt(PushConstants.EXTRA_PUSH_FREQ);
                        } else if (str.equals("do_not_disturb")) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("do_not_disturb");
                            i4 = jSONObject2.getInt("from");
                            try {
                                i3 = jSONObject2.getInt("to");
                                b.this.b(context, jSONObject);
                            } catch (JSONException unused2) {
                                i3 = 0;
                            }
                            if (str.equals(PushConstants.EXTRA_PUSH_FREQ)) {
                                ((GetFrequencyListener) aVar).onResult(i2, i5);
                                return;
                            } else if (str.equals("do_not_disturb")) {
                                ((GetNoDisturbListener) aVar).onResult(i2, i4, i3);
                                return;
                            } else {
                                return;
                            }
                        }
                        i3 = 0;
                        i4 = 0;
                        b.this.b(context, jSONObject);
                        if (str.equals(PushConstants.EXTRA_PUSH_FREQ)) {
                        }
                    }
                } else {
                    i2 = 10001;
                }
                i3 = 0;
                i4 = 0;
                if (str.equals(PushConstants.EXTRA_PUSH_FREQ)) {
                }
            }
        });
    }

    public void a(final Context context, final HashMap<String, Object> hashMap, final UploadDataListener uploadDataListener) {
        final String str = h.f3120c + h.f3122e;
        final HashMap hashMap2 = new HashMap();
        hashMap2.put("Content-Type", "application/json");
        d.a().a(new com.baidu.android.pushservice.h.c() { // from class: com.baidu.android.pushservice.frequency.b.1
            @Override // com.baidu.android.pushservice.h.c
            public void a() {
                if (hashMap.containsKey("bduss")) {
                    HashMap hashMap3 = hashMap;
                    hashMap3.put("bduss", "bduss=" + hashMap.get("bduss"));
                }
                HashMap b2 = b.this.b(context, hashMap);
                if (b2.containsKey("bduss")) {
                    if (b2.containsKey(PushConstants.EXTRA_BDUSS_ACTION)) {
                        HashMap hashMap4 = hashMap2;
                        hashMap4.put("cookie", b2.get("bduss") + "");
                    }
                    b2.remove("bduss");
                }
                if (b2.isEmpty() && !hashMap2.containsKey("bduss")) {
                    uploadDataListener.onResult(0);
                    return;
                }
                int i2 = 10001;
                com.baidu.android.pushservice.e.b a2 = com.baidu.android.pushservice.e.c.a(context, str, "POST", b.this.c(context, b2), hashMap2, "application/json");
                if (a2 != null) {
                    String a3 = m.a(context, a2.a());
                    if (a2.b() == 200 && (i2 = b.this.a(a3)) == 0) {
                        if (hashMap2.containsKey("cookie")) {
                            b2.put("bduss", hashMap2.get("cookie"));
                        }
                        b.this.a(context, b2);
                    }
                }
                uploadDataListener.onResult(i2);
            }
        });
    }

    public void a(Context context, boolean z, int i2, String str) {
        if (context == null) {
            return;
        }
        a(context.getApplicationContext(), z, i2, " ", str);
    }

    public void a(final Context context, final boolean z, final int i2, final String str, final String str2) {
        if (TextUtils.isEmpty(i.a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE"))) {
            return;
        }
        if (i.b(context, "click_data_size", -1) != -1 || z) {
            final String str3 = h.f3126i + h.j;
            final HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            d.a().a(new com.baidu.android.pushservice.h.c() { // from class: com.baidu.android.pushservice.frequency.b.2
                @Override // com.baidu.android.pushservice.h.c
                public void a() {
                    JSONObject a2 = b.this.a(context, z, str, i2, str2);
                    int i3 = 2;
                    do {
                        com.baidu.android.pushservice.e.b a3 = a2 != null ? com.baidu.android.pushservice.e.c.a(context, str3, "POST", a2.toString(), hashMap, "application/json") : null;
                        if (a3 != null) {
                            int b2 = a3.b();
                            String a4 = m.a(context, a3.a());
                            if (b2 == 200 && b.this.a(a4) == 0) {
                                return;
                            }
                        }
                        if (i3 == 1) {
                            b.this.a(context, a2);
                        }
                        i3--;
                    } while (i3 > 0);
                }
            });
        }
    }
}
