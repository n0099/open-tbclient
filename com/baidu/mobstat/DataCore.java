package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobstat.StatService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DataCore {

    /* renamed from: a  reason: collision with root package name */
    private static JSONObject f3594a = new JSONObject();

    /* renamed from: b  reason: collision with root package name */
    private static DataCore f3595b = new DataCore();
    private StatService.WearListener h;
    private JSONObject i;
    private JSONArray c = new JSONArray();
    private JSONArray d = new JSONArray();
    private JSONArray e = new JSONArray();
    private boolean f = false;
    private volatile int g = 0;
    private Object j = new Object();

    public static DataCore instance() {
        return f3595b;
    }

    private DataCore() {
    }

    public void init(Context context) {
        instance().loadStatData(context);
        instance().loadLastSession(context);
        instance().installHeader(context);
    }

    public int getCacheFileSzie() {
        return this.g;
    }

    public JSONObject getLogData() {
        return this.i;
    }

    public void putSession(Session session) {
        putSession(session.constructJSONObject());
    }

    public void putSession(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (a(jSONObject.toString())) {
                bc.c().b("[WARNING] data to put exceed limit, ignored");
                return;
            }
            synchronized (this.c) {
                try {
                    this.c.put(this.c.length(), jSONObject);
                } catch (JSONException e) {
                }
            }
        }
    }

    public void putSession(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(new JSONObject().toString())) {
            try {
                putSession(new JSONObject(str));
            } catch (JSONException e) {
            }
        }
    }

    private boolean a(String str) {
        return (str.getBytes().length + BDStatCore.instance().getSessionSize()) + this.g > 184320;
    }

    public void putEvent(Context context, JSONObject jSONObject) {
        if (jSONObject != null) {
            if (a(jSONObject.toString())) {
                bc.c().b("[WARNING] data to put exceed limit, ignored");
                return;
            }
            synchronized (this.d) {
                EventAnalysis.doEventMerge(this.d, jSONObject);
            }
        }
    }

    public void installHeader(Context context) {
        synchronized (f3594a) {
            CooperService.instance().getHeadObject().installHeader(context, f3594a);
        }
    }

    public void flush(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            synchronized (this.c) {
                jSONObject.put(Config.PRINCIPAL_PART, new JSONArray(this.c.toString()));
            }
            synchronized (this.d) {
                jSONObject.put("ev", new JSONArray(this.d.toString()));
            }
            synchronized (f3594a) {
                jSONObject.put(Config.HEADER_PART, new JSONObject(f3594a.toString()));
            }
        } catch (Exception e) {
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
        this.g = length;
        bo.a(context, bw.u(context) + Config.STAT_CACHE_FILE_NAME, jSONObject2, false);
        synchronized (this.e) {
            bo.a(context, Config.LAST_AP_INFO_FILE_NAME, this.e.toString(), false);
        }
    }

    private void a(boolean z) {
        this.f = z;
    }

    private boolean a() {
        return this.f;
    }

    public void loadLastSession(Context context) {
        if (context != null) {
            String str = bw.u(context) + Config.LAST_SESSION_FILE_NAME;
            if (bo.c(context, str)) {
                String a2 = bo.a(context, str);
                if (!TextUtils.isEmpty(a2)) {
                    bo.a(context, str, new JSONObject().toString(), false);
                    putSession(a2);
                    flush(context);
                }
            }
        }
    }

    public void loadWifiData(Context context) {
        JSONArray jSONArray;
        if (context != null && bo.c(context, Config.LAST_AP_INFO_FILE_NAME)) {
            try {
                JSONArray jSONArray2 = new JSONArray(bo.a(context, Config.LAST_AP_INFO_FILE_NAME));
                int length = jSONArray2.length();
                if (length >= 10) {
                    jSONArray = new JSONArray();
                    for (int i = length - 10; i < length; i++) {
                        jSONArray.put(jSONArray2.get(i));
                    }
                } else {
                    jSONArray = jSONArray2;
                }
                String g = bw.g(1, context);
                if (!TextUtils.isEmpty(g)) {
                    jSONArray.put(g);
                }
                synchronized (this.e) {
                    this.e = jSONArray;
                }
            } catch (JSONException e) {
            }
        }
    }

    public void loadStatData(Context context) {
        if (context != null) {
            String str = bw.u(context) + Config.STAT_CACHE_FILE_NAME;
            if (bo.c(context, str)) {
                String a2 = bo.a(context, str);
                if (!TextUtils.isEmpty(a2)) {
                    JSONObject jSONObject = null;
                    try {
                        jSONObject = new JSONObject(a2);
                    } catch (Exception e) {
                    }
                    if (jSONObject != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                            JSONArray jSONArray = jSONObject.getJSONArray(Config.PRINCIPAL_PART);
                            if (jSONArray != null) {
                                for (int i = 0; i < jSONArray.length(); i++) {
                                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                                    if (currentTimeMillis - jSONObject2.getLong("s") <= 604800000) {
                                        putSession(jSONObject2);
                                    }
                                }
                            }
                        } catch (Exception e2) {
                        }
                        try {
                            JSONArray jSONArray2 = jSONObject.getJSONArray("ev");
                            if (jSONArray2 != null) {
                                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                                    if (currentTimeMillis - jSONObject3.getLong("t") <= 604800000) {
                                        putEvent(context, jSONObject3);
                                    }
                                }
                            }
                        } catch (Exception e3) {
                        }
                        try {
                            JSONObject jSONObject4 = jSONObject.getJSONObject(Config.HEADER_PART);
                            if (jSONObject4 != null) {
                                synchronized (f3594a) {
                                    f3594a = jSONObject4;
                                    if (TextUtils.isEmpty(bq.a().s(context))) {
                                        String string = f3594a.getString(Config.DEVICE_ID_SEC);
                                        if (!TextUtils.isEmpty(string)) {
                                            bq.a().k(context, string);
                                        }
                                    }
                                }
                            }
                        } catch (Exception e4) {
                        }
                    }
                }
            }
        }
    }

    public String constructLogWithEmptyBody(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        HeadObject headObject = CooperService.instance().getHeadObject();
        if (TextUtils.isEmpty(headObject.e)) {
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
            jSONObject2.put("k", str);
            jSONObject.put(Config.HEADER_PART, jSONObject2);
            try {
                jSONObject.put(Config.PRINCIPAL_PART, jSONArray);
                try {
                    jSONObject.put("ev", jSONArray);
                    try {
                        jSONObject.put(Config.EXCEPTION_PART, jSONArray);
                        return jSONObject.toString();
                    } catch (JSONException e) {
                        return null;
                    }
                } catch (JSONException e2) {
                    return null;
                }
            } catch (JSONException e3) {
                return null;
            }
        } catch (Exception e4) {
            return null;
        }
    }

    private void a(Context context, JSONObject jSONObject, boolean z) {
        boolean z2 = true;
        if (jSONObject != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(Config.TRACE_APPLICATION_SESSION, z ? 1 : 0);
            } catch (Exception e) {
            }
            try {
                jSONObject2.put(Config.TRACE_FAILED_CNT, 0);
            } catch (Exception e2) {
            }
            try {
                jSONObject2.put(Config.TRACE_CIRCLE, af.c());
            } catch (Exception e3) {
            }
            try {
                jSONObject.put(Config.TRACE_PART, jSONObject2);
            } catch (Exception e4) {
                z2 = false;
            }
            if (z2) {
                a(context, jSONObject, jSONObject2);
            }
        }
    }

    private void a(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        long j;
        int a2 = a(jSONObject);
        try {
            JSONObject jSONObject3 = jSONObject.getJSONObject(Config.HEADER_PART);
            j = jSONObject3 != null ? jSONObject3.getLong("ss") : 0L;
        } catch (Exception e) {
            j = 0;
        }
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        a(context, jSONObject2, j, a2);
    }

    private int a(JSONObject jSONObject) {
        int i;
        int i2 = 0;
        if (jSONObject == null) {
            return 0;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(Config.HEADER_PART);
            i = (jSONObject2.getLong("ss") <= 0 || jSONObject2.getLong(Config.SEQUENCE_INDEX) != 0) ? 0 : 1;
        } catch (Exception e) {
            i = 0;
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(Config.PRINCIPAL_PART);
            if (jSONArray != null && jSONArray.length() != 0) {
                while (i2 < jSONArray.length()) {
                    JSONObject jSONObject3 = (JSONObject) jSONArray.get(i2);
                    i2++;
                    i = (jSONObject3.getLong("e") == 0 || jSONObject3.getLong("c") != 0) ? i : i + 1;
                }
            }
        } catch (Exception e2) {
        }
        return i;
    }

    private void a(Context context, JSONObject jSONObject, long j, int i) {
        long longValue;
        int i2;
        long j2;
        Object obj;
        String[] split;
        long longValue2 = ae.a().b(context).longValue();
        if (longValue2 <= 0 && i != 0) {
            ae.a().a(context, j);
            longValue2 = j;
        }
        a(jSONObject, Config.TRACE_VISIT_FIRST, Long.valueOf(longValue2));
        if (i != 0) {
            long longValue3 = ae.a().c(context).longValue();
            longValue = j - longValue3;
            if (longValue3 != 0 && longValue <= 0) {
                longValue = -1;
            } else if (longValue3 == 0) {
                longValue = 0;
            }
            ae.a().b(context, j);
            ae.a().c(context, longValue);
        } else {
            longValue = ae.a().d(context).longValue();
        }
        a(jSONObject, Config.TRACE_VISIT_SESSION_LAST_INTERVAL, Long.valueOf(longValue));
        String str = "";
        String str2 = "";
        String e = ae.a().e(context);
        if (!TextUtils.isEmpty(e) && e.contains(":") && (split = e.split(":")) != null && split.length == 2) {
            str = split[0];
            str2 = split[1];
        }
        if (TextUtils.isEmpty(str2)) {
            i2 = 0;
        } else {
            try {
                i2 = Integer.valueOf(str2).intValue();
            } catch (Exception e2) {
                i2 = 0;
            }
        }
        String a2 = bx.a(j);
        int i3 = (TextUtils.isEmpty(str) || a2.equals(str)) ? i + i2 : i;
        if (i != 0) {
            ae.a().a(context, a2 + ":" + i3);
        }
        a(jSONObject, Config.TRACE_VISIT_SESSION_TODAY_COUNT, Integer.valueOf(i3));
        if (TextUtils.isEmpty(str)) {
            j2 = 0;
        } else {
            try {
                j2 = Integer.valueOf(str).intValue();
            } catch (Exception e3) {
                j2 = 0;
            }
        }
        if (j2 != 0 && !TextUtils.isEmpty(str) && !a2.equals(str) && i != 0) {
            JSONArray a3 = a(context, j2, i2);
            ae.a().b(context, a3.toString());
            a(jSONObject, Config.TRACE_VISIT_RECENT, a3);
            return;
        }
        String f = ae.a().f(context);
        if (TextUtils.isEmpty(f)) {
            obj = null;
        } else {
            try {
                obj = new JSONArray(f);
            } catch (Exception e4) {
                obj = null;
            }
        }
        if (obj == null) {
            obj = new JSONArray();
        }
        a(jSONObject, Config.TRACE_VISIT_RECENT, obj);
    }

    private JSONArray a(Context context, long j, long j2) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        String f = ae.a().f(context);
        if (!TextUtils.isEmpty(f)) {
            try {
                JSONArray jSONArray = new JSONArray(f);
                if (jSONArray != null && jSONArray.length() != 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add((JSONObject) jSONArray.get(i));
                    }
                }
            } catch (Exception e) {
            }
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            } else if (((JSONObject) it.next()).getLong(Config.TRACE_VISIT_RECENT_DAY) == j) {
                z = false;
                break;
            }
        }
        if (z) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Config.TRACE_VISIT_RECENT_DAY, j);
                jSONObject.put("count", j2);
                arrayList.add(jSONObject);
            } catch (Exception e2) {
            }
        }
        int size = arrayList.size();
        return new JSONArray((Collection) (size > 5 ? arrayList.subList(size - 5, size) : arrayList));
    }

    private void a(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject != null) {
            if (!jSONObject.has(Config.TRACE_VISIT)) {
                try {
                    jSONObject.put(Config.TRACE_VISIT, new JSONObject());
                } catch (Exception e) {
                }
            }
            try {
                ((JSONObject) jSONObject.get(Config.TRACE_VISIT)).put(str, obj);
            } catch (Exception e2) {
            }
        }
    }

    public void saveLogDataAndSendForRaven(Context context) {
        synchronized (this.j) {
        }
    }

    public void sendDataForDueros(Context context) {
    }

    public void saveLogData(Context context, boolean z, boolean z2, long j, boolean z3) {
        saveLogData(context, z, z2, j, z3, null);
    }

    public void saveLogData(Context context, boolean z, boolean z2, long j, boolean z3, JSONObject jSONObject) {
        HeadObject headObject = CooperService.instance().getHeadObject();
        if (headObject != null) {
            synchronized (f3594a) {
                if (TextUtils.isEmpty(headObject.e)) {
                    headObject.installHeader(context, f3594a);
                } else {
                    headObject.updateHeader(context, f3594a);
                }
            }
            if (TextUtils.isEmpty(headObject.e)) {
                bc.c().c("[WARNING] 无法找到有效APP Key, 请参考文档配置");
                return;
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        synchronized (f3594a) {
            try {
                f3594a.put("t", System.currentTimeMillis());
                f3594a.put(Config.SEQUENCE_INDEX, z ? 0 : 1);
                f3594a.put("ss", j);
                synchronized (this.e) {
                    f3594a.put(Config.WIFI_LOCATION, this.e);
                }
                f3594a.put("sign", CooperService.instance().getUUID());
                b(context, f3594a, jSONObject);
                jSONObject2.put(Config.HEADER_PART, f3594a);
                synchronized (this.c) {
                    try {
                        jSONObject2.put(Config.PRINCIPAL_PART, this.c);
                        synchronized (this.d) {
                            try {
                                jSONObject2.put("ev", this.d);
                                try {
                                    jSONObject2.put(Config.EXCEPTION_PART, new JSONArray());
                                    a(context, jSONObject2, z2);
                                    b(jSONObject2);
                                    a(context, jSONObject2);
                                    a(context, jSONObject2.toString(), z, z3);
                                    this.i = jSONObject2;
                                    clearCache(context);
                                } catch (JSONException e) {
                                }
                            } catch (JSONException e2) {
                            }
                        }
                    } catch (JSONException e3) {
                    }
                }
            } catch (Exception e4) {
            }
        }
    }

    private void b(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject.length() != 0 && jSONObject2 != null && jSONObject2.length() != 0) {
            try {
                jSONObject.put(Config.LAUNCH, jSONObject2);
            } catch (Exception e) {
            }
        }
    }

    private void b(JSONObject jSONObject) {
    }

    private void a(Context context, JSONObject jSONObject) {
    }

    private void a(Context context, String str, boolean z, boolean z2) {
        if (this.h != null && this.h.onSendLogData(str)) {
            bc.c().a("Log has been passed to app level, log: " + str);
            return;
        }
        LogSender.instance().saveLogData(context, str, false);
        bc.c().a("Save log: " + str);
        if (z) {
            if (z2) {
                av.a(context);
            } else {
                av.a(context, true);
            }
        }
    }

    public void clearCache(Context context) {
        a(false);
        synchronized (f3594a) {
            f3594a = new JSONObject();
        }
        installHeader(context);
        a(context);
    }

    private void a(Context context) {
        synchronized (this.d) {
            this.d = new JSONArray();
        }
        synchronized (this.c) {
            this.c = new JSONArray();
        }
        synchronized (this.e) {
            this.e = new JSONArray();
        }
        flush(context);
    }
}
