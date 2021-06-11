package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobstat.StatService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DataCore {

    /* renamed from: a  reason: collision with root package name */
    public static JSONObject f8422a = new JSONObject();

    /* renamed from: b  reason: collision with root package name */
    public static DataCore f8423b = new DataCore();

    /* renamed from: h  reason: collision with root package name */
    public StatService.WearListener f8429h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f8430i;

    /* renamed from: c  reason: collision with root package name */
    public JSONArray f8424c = new JSONArray();

    /* renamed from: d  reason: collision with root package name */
    public JSONArray f8425d = new JSONArray();

    /* renamed from: e  reason: collision with root package name */
    public JSONArray f8426e = new JSONArray();

    /* renamed from: f  reason: collision with root package name */
    public boolean f8427f = false;

    /* renamed from: g  reason: collision with root package name */
    public volatile int f8428g = 0;
    public Object j = new Object();

    private void a(Context context, JSONObject jSONObject) {
    }

    private boolean a(String str) {
        return (str.getBytes().length + BDStatCore.instance().getSessionSize()) + this.f8428g > 184320;
    }

    private void b(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject.length() != 0 && jSONObject2 != null && jSONObject2.length() != 0) {
            try {
                jSONObject.put("launch", jSONObject2);
            } catch (Exception unused) {
            }
        }
    }

    private void b(JSONObject jSONObject) {
    }

    public static DataCore instance() {
        return f8423b;
    }

    public void clearCache(Context context) {
        a(false);
        synchronized (f8422a) {
            f8422a = new JSONObject();
        }
        installHeader(context);
        a(context);
    }

    public String constructLogWithEmptyBody(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        HeadObject headObject = CooperService.instance().getHeadObject();
        if (TextUtils.isEmpty(headObject.f8454e)) {
            headObject.installHeader(context, jSONObject2);
        } else {
            headObject.updateHeader(context, jSONObject2);
        }
        JSONArray jSONArray = new JSONArray();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            jSONObject2.put("t", currentTimeMillis);
            jSONObject2.put("ss", currentTimeMillis);
            jSONObject2.put(Config.WIFI_LOCATION, jSONArray);
            jSONObject2.put(Config.SEQUENCE_INDEX, 0);
            jSONObject2.put("sign", CooperService.instance().getUUID());
            jSONObject2.put(Config.APP_KEY, str);
            jSONObject.put(Config.HEADER_PART, jSONObject2);
            jSONObject.put(Config.PRINCIPAL_PART, jSONArray);
            jSONObject.put("ev", jSONArray);
            jSONObject.put(Config.EXCEPTION_PART, jSONArray);
            return jSONObject.toString();
        } catch (JSONException | Exception unused) {
            return null;
        }
    }

    public void flush(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            synchronized (this.f8424c) {
                jSONObject.put(Config.PRINCIPAL_PART, new JSONArray(this.f8424c.toString()));
            }
            synchronized (this.f8425d) {
                jSONObject.put("ev", new JSONArray(this.f8425d.toString()));
            }
            synchronized (f8422a) {
                jSONObject.put(Config.HEADER_PART, new JSONObject(f8422a.toString()));
            }
        } catch (Exception unused) {
        }
        String jSONObject2 = jSONObject.toString();
        if (a()) {
            bc.c().a("[WARNING] stat cache exceed 184320 Bytes, ignored");
            return;
        }
        int length = jSONObject2.getBytes().length;
        if (length >= 184320) {
            a(true);
            return;
        }
        this.f8428g = length;
        String u = bw.u(context);
        bo.a(context, u + Config.STAT_CACHE_FILE_NAME, jSONObject2, false);
        synchronized (this.f8426e) {
            bo.a(context, Config.LAST_AP_INFO_FILE_NAME, this.f8426e.toString(), false);
        }
    }

    public int getCacheFileSzie() {
        return this.f8428g;
    }

    public JSONObject getLogData() {
        return this.f8430i;
    }

    public void init(Context context) {
        instance().loadStatData(context);
        instance().loadLastSession(context);
        instance().installHeader(context);
    }

    public void installHeader(Context context) {
        synchronized (f8422a) {
            CooperService.instance().getHeadObject().installHeader(context, f8422a);
        }
    }

    public void loadLastSession(Context context) {
        if (context == null) {
            return;
        }
        String str = bw.u(context) + Config.LAST_SESSION_FILE_NAME;
        if (bo.c(context, str)) {
            String a2 = bo.a(context, str);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            bo.a(context, str, new JSONObject().toString(), false);
            putSession(a2);
            flush(context);
        }
    }

    public void loadStatData(Context context) {
        if (context == null) {
            return;
        }
        String str = bw.u(context) + Config.STAT_CACHE_FILE_NAME;
        if (bo.c(context, str)) {
            String a2 = bo.a(context, str);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            JSONObject jSONObject = null;
            try {
                jSONObject = new JSONObject(a2);
            } catch (Exception unused) {
            }
            if (jSONObject == null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray(Config.PRINCIPAL_PART);
                if (jSONArray != null) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        if (currentTimeMillis - jSONObject2.getLong("s") <= 604800000) {
                            putSession(jSONObject2);
                        }
                    }
                }
            } catch (Exception unused2) {
            }
            try {
                JSONArray jSONArray2 = jSONObject.getJSONArray("ev");
                if (jSONArray2 != null) {
                    for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i3);
                        if (currentTimeMillis - jSONObject3.getLong("t") <= 604800000) {
                            putEvent(context, jSONObject3);
                        }
                    }
                }
            } catch (Exception unused3) {
            }
            try {
                JSONObject jSONObject4 = jSONObject.getJSONObject(Config.HEADER_PART);
                if (jSONObject4 != null) {
                    synchronized (f8422a) {
                        f8422a = jSONObject4;
                        if (TextUtils.isEmpty(bq.a().s(context))) {
                            String string = f8422a.getString(Config.DEVICE_ID_SEC);
                            if (!TextUtils.isEmpty(string)) {
                                bq.a().k(context, string);
                            }
                        }
                    }
                }
            } catch (Exception unused4) {
            }
        }
    }

    public void loadWifiData(Context context) {
        if (context != null && bo.c(context, Config.LAST_AP_INFO_FILE_NAME)) {
            try {
                JSONArray jSONArray = new JSONArray(bo.a(context, Config.LAST_AP_INFO_FILE_NAME));
                int length = jSONArray.length();
                if (length >= 10) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i2 = length - 10; i2 < length; i2++) {
                        jSONArray2.put(jSONArray.get(i2));
                    }
                    jSONArray = jSONArray2;
                }
                String g2 = bw.g(1, context);
                if (!TextUtils.isEmpty(g2)) {
                    jSONArray.put(g2);
                }
                synchronized (this.f8426e) {
                    this.f8426e = jSONArray;
                }
            } catch (JSONException unused) {
            }
        }
    }

    public void putEvent(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (a(jSONObject.toString())) {
            bc.c().b("[WARNING] data to put exceed limit, ignored");
            return;
        }
        synchronized (this.f8425d) {
            EventAnalysis.doEventMerge(this.f8425d, jSONObject);
        }
    }

    public void putSession(Session session) {
        putSession(session.constructJSONObject());
    }

    public void saveLogData(Context context, boolean z, boolean z2, long j, boolean z3) {
        saveLogData(context, z, z2, j, z3, null);
    }

    public void saveLogDataAndSendForRaven(Context context) {
        synchronized (this.j) {
        }
    }

    public void sendDataForDueros(Context context) {
    }

    public void putSession(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (a(jSONObject.toString())) {
            bc.c().b("[WARNING] data to put exceed limit, ignored");
            return;
        }
        synchronized (this.f8424c) {
            try {
                this.f8424c.put(this.f8424c.length(), jSONObject);
            } catch (JSONException unused) {
            }
        }
    }

    public void saveLogData(Context context, boolean z, boolean z2, long j, boolean z3, JSONObject jSONObject) {
        HeadObject headObject = CooperService.instance().getHeadObject();
        if (headObject != null) {
            synchronized (f8422a) {
                if (TextUtils.isEmpty(headObject.f8454e)) {
                    headObject.installHeader(context, f8422a);
                } else {
                    headObject.updateHeader(context, f8422a);
                }
            }
            if (TextUtils.isEmpty(headObject.f8454e)) {
                bc.c().c("[WARNING] 无法找到有效APP Key, 请参考文档配置");
                return;
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        synchronized (f8422a) {
            try {
                f8422a.put("t", System.currentTimeMillis());
                f8422a.put(Config.SEQUENCE_INDEX, z ? 0 : 1);
                f8422a.put("ss", j);
                synchronized (this.f8426e) {
                    f8422a.put(Config.WIFI_LOCATION, this.f8426e);
                }
                f8422a.put("sign", CooperService.instance().getUUID());
                b(context, f8422a, jSONObject);
                jSONObject2.put(Config.HEADER_PART, f8422a);
                synchronized (this.f8424c) {
                    try {
                        jSONObject2.put(Config.PRINCIPAL_PART, this.f8424c);
                        synchronized (this.f8425d) {
                            try {
                                jSONObject2.put("ev", this.f8425d);
                                try {
                                    jSONObject2.put(Config.EXCEPTION_PART, new JSONArray());
                                    a(context, jSONObject2, z2);
                                    b(jSONObject2);
                                    a(context, jSONObject2);
                                    a(context, jSONObject2.toString(), z, z3);
                                    this.f8430i = jSONObject2;
                                    clearCache(context);
                                } catch (JSONException unused) {
                                }
                            } catch (JSONException unused2) {
                            }
                        }
                    } catch (JSONException unused3) {
                    }
                }
            } catch (Exception unused4) {
            }
        }
    }

    private void a(boolean z) {
        this.f8427f = z;
    }

    private boolean a() {
        return this.f8427f;
    }

    private void a(Context context, JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        boolean z2 = true;
        try {
            jSONObject2.put(Config.TRACE_APPLICATION_SESSION, z ? 1 : 0);
        } catch (Exception unused) {
        }
        try {
            jSONObject2.put(Config.TRACE_FAILED_CNT, 0);
        } catch (Exception unused2) {
        }
        try {
            jSONObject2.put(Config.TRACE_CIRCLE, af.c());
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put(Config.TRACE_PART, jSONObject2);
        } catch (Exception unused4) {
            z2 = false;
        }
        if (z2) {
            a(context, jSONObject, jSONObject2);
        }
    }

    public void putSession(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(new JSONObject().toString())) {
            try {
                putSession(new JSONObject(str));
            } catch (JSONException unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        long j;
        JSONObject jSONObject3;
        int a2 = a(jSONObject);
        try {
            jSONObject3 = jSONObject.getJSONObject(Config.HEADER_PART);
        } catch (Exception unused) {
        }
        if (jSONObject3 != null) {
            j = jSONObject3.getLong("ss");
            a(context, jSONObject2, j != 0 ? System.currentTimeMillis() : j, a2);
        }
        j = 0;
        a(context, jSONObject2, j != 0 ? System.currentTimeMillis() : j, a2);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:5|(3:6|7|8)|(5:12|13|14|(2:(5:20|21|(2:25|26)|27|18)|30)|32)|34|13|14|(3:16|(1:18)|30)|32) */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0039 A[Catch: Exception -> 0x0058, TRY_LEAVE, TryCatch #0 {Exception -> 0x0058, blocks: (B:13:0x0025, B:15:0x002d, B:17:0x0033, B:19:0x0039), top: B:29:0x0025 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int a(JSONObject jSONObject) {
        int i2;
        JSONArray jSONArray;
        JSONObject jSONObject2;
        long j;
        if (jSONObject == null) {
            return 0;
        }
        try {
            jSONObject2 = jSONObject.getJSONObject(Config.HEADER_PART);
            j = jSONObject2.getLong(Config.SEQUENCE_INDEX);
        } catch (Exception unused) {
        }
        if (jSONObject2.getLong("ss") > 0 && j == 0) {
            i2 = 1;
            jSONArray = jSONObject.getJSONArray(Config.PRINCIPAL_PART);
            if (jSONArray != null && jSONArray.length() != 0) {
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject3 = (JSONObject) jSONArray.get(i3);
                    long j2 = jSONObject3.getLong("c");
                    if (jSONObject3.getLong("e") != 0 && j2 == 0) {
                        i2++;
                    }
                }
            }
            return i2;
        }
        i2 = 0;
        jSONArray = jSONObject.getJSONArray(Config.PRINCIPAL_PART);
        if (jSONArray != null) {
            while (i3 < jSONArray.length()) {
            }
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0131 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Context context, JSONObject jSONObject, long j, int i2) {
        long longValue;
        String str;
        long intValue;
        String f2;
        Object obj;
        String[] split;
        long longValue2 = ae.a().b(context).longValue();
        if (longValue2 <= 0 && i2 != 0) {
            ae.a().a(context, j);
            longValue2 = j;
        }
        a(jSONObject, Config.TRACE_VISIT_FIRST, Long.valueOf(longValue2));
        if (i2 != 0) {
            long longValue3 = ae.a().c(context).longValue();
            longValue = j - longValue3;
            int i3 = (longValue3 > 0L ? 1 : (longValue3 == 0L ? 0 : -1));
            if (i3 != 0 && longValue <= 0) {
                longValue = -1;
            } else if (i3 == 0) {
                longValue = 0;
            }
            ae.a().b(context, j);
            ae.a().c(context, longValue);
        } else {
            longValue = ae.a().d(context).longValue();
        }
        a(jSONObject, Config.TRACE_VISIT_SESSION_LAST_INTERVAL, Long.valueOf(longValue));
        String e2 = ae.a().e(context);
        int i4 = 0;
        String str2 = "";
        if (TextUtils.isEmpty(e2) || !e2.contains(":") || (split = e2.split(":")) == null || split.length != 2) {
            str = "";
        } else {
            String str3 = split[0];
            str2 = split[1];
            str = str3;
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                i4 = Integer.valueOf(str2).intValue();
            } catch (Exception unused) {
            }
        }
        String a2 = bx.a(j);
        int i5 = (TextUtils.isEmpty(str) || a2.equals(str)) ? i2 + i4 : i2;
        if (i2 != 0) {
            ae.a().a(context, a2 + ":" + i5);
        }
        a(jSONObject, Config.TRACE_VISIT_SESSION_TODAY_COUNT, Integer.valueOf(i5));
        if (!TextUtils.isEmpty(str)) {
            try {
                intValue = Integer.valueOf(str).intValue();
            } catch (Exception unused2) {
            }
            if (intValue == 0 && !TextUtils.isEmpty(str) && !a2.equals(str) && i2 != 0) {
                JSONArray a3 = a(context, intValue, i4);
                ae.a().b(context, a3.toString());
                a(jSONObject, Config.TRACE_VISIT_RECENT, a3);
                return;
            }
            f2 = ae.a().f(context);
            obj = null;
            if (!TextUtils.isEmpty(f2)) {
                try {
                    obj = new JSONArray(f2);
                } catch (Exception unused3) {
                }
            }
            if (obj == null) {
                obj = new JSONArray();
            }
            a(jSONObject, Config.TRACE_VISIT_RECENT, obj);
        }
        intValue = 0;
        if (intValue == 0) {
        }
        f2 = ae.a().f(context);
        obj = null;
        if (!TextUtils.isEmpty(f2)) {
        }
        if (obj == null) {
        }
        a(jSONObject, Config.TRACE_VISIT_RECENT, obj);
    }

    private JSONArray a(Context context, long j, long j2) {
        List arrayList = new ArrayList();
        String f2 = ae.a().f(context);
        boolean z = false;
        if (!TextUtils.isEmpty(f2)) {
            try {
                JSONArray jSONArray = new JSONArray(f2);
                if (jSONArray.length() != 0) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        arrayList.add((JSONObject) jSONArray.get(i2));
                    }
                }
            } catch (Exception unused) {
            }
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            } else if (((JSONObject) it.next()).getLong(Config.TRACE_VISIT_RECENT_DAY) == j) {
                break;
            }
        }
        if (z) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Config.TRACE_VISIT_RECENT_DAY, j);
                jSONObject.put("count", j2);
                arrayList.add(jSONObject);
            } catch (Exception unused2) {
            }
        }
        int size = arrayList.size();
        if (size > 5) {
            arrayList = arrayList.subList(size - 5, size);
        }
        return new JSONArray((Collection) arrayList);
    }

    private void a(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject == null) {
            return;
        }
        if (!jSONObject.has(Config.TRACE_VISIT)) {
            try {
                jSONObject.put(Config.TRACE_VISIT, new JSONObject());
            } catch (Exception unused) {
            }
        }
        try {
            ((JSONObject) jSONObject.get(Config.TRACE_VISIT)).put(str, obj);
        } catch (Exception unused2) {
        }
    }

    private void a(Context context, String str, boolean z, boolean z2) {
        StatService.WearListener wearListener = this.f8429h;
        if (wearListener != null && wearListener.onSendLogData(str)) {
            bc c2 = bc.c();
            c2.a("Log has been passed to app level, log: " + str);
            return;
        }
        LogSender.instance().saveLogData(context, str, false);
        bc c3 = bc.c();
        c3.a("Save log: " + str);
        if (z) {
            if (z2) {
                av.a(context);
            } else {
                av.a(context, true);
            }
        }
    }

    private void a(Context context) {
        synchronized (this.f8425d) {
            this.f8425d = new JSONArray();
        }
        synchronized (this.f8424c) {
            this.f8424c = new JSONArray();
        }
        synchronized (this.f8426e) {
            this.f8426e = new JSONArray();
        }
        flush(context);
    }
}
