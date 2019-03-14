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
/* loaded from: classes6.dex */
public class DataCore {
    private static JSONObject a = new JSONObject();
    private static DataCore b = new DataCore();
    private StatService.WearListener h;
    private JSONObject i;
    private JSONArray c = new JSONArray();
    private JSONArray d = new JSONArray();
    private JSONArray e = new JSONArray();
    private boolean f = false;
    private volatile int g = 0;
    private Object j = new Object();

    public static DataCore instance() {
        return b;
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
                bj.c().b("[WARNING] data to put exceed limit, ignored");
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
                bj.c().b("[WARNING] data to put exceed limit, ignored");
                return;
            }
            synchronized (this.d) {
                EventAnalysis.doEventMerge(this.d, jSONObject);
            }
        }
    }

    public void installHeader(Context context) {
        synchronized (a) {
            CooperService.instance().getHeadObject().installHeader(context, a);
        }
    }

    public void flush(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            synchronized (this.c) {
                jSONObject.put(Config.PRINCIPAL_PART, new JSONArray(this.c.toString()));
            }
            synchronized (this.d) {
                jSONObject.put(Config.EVENT_PART, new JSONArray(this.d.toString()));
            }
            synchronized (a) {
                jSONObject.put(Config.HEADER_PART, new JSONObject(a.toString()));
            }
        } catch (Exception e) {
        }
        String jSONObject2 = jSONObject.toString();
        if (a()) {
            bj.c().a("[WARNING] stat cache exceed 184320 Bytes, ignored");
            return;
        }
        int length = jSONObject2.getBytes().length;
        if (length >= 184320) {
            a(true);
            return;
        }
        this.g = length;
        bv.a(context, cc.u(context) + Config.STAT_CACHE_FILE_NAME, jSONObject2, false);
        synchronized (this.e) {
            bv.a(context, Config.LAST_AP_INFO_FILE_NAME, this.e.toString(), false);
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
            String str = cc.u(context) + Config.LAST_SESSION_FILE_NAME;
            if (bv.c(context, str)) {
                String a2 = bv.a(context, str);
                if (!TextUtils.isEmpty(a2)) {
                    bv.a(context, str, new JSONObject().toString(), false);
                    putSession(a2);
                    flush(context);
                }
            }
        }
    }

    public void loadWifiData(Context context) {
        JSONArray jSONArray;
        if (context != null && bv.c(context, Config.LAST_AP_INFO_FILE_NAME)) {
            try {
                JSONArray jSONArray2 = new JSONArray(bv.a(context, Config.LAST_AP_INFO_FILE_NAME));
                int length = jSONArray2.length();
                if (length >= 10) {
                    jSONArray = new JSONArray();
                    for (int i = length - 10; i < length; i++) {
                        jSONArray.put(jSONArray2.get(i));
                    }
                } else {
                    jSONArray = jSONArray2;
                }
                String g = cc.g(1, context);
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
            String str = cc.u(context) + Config.STAT_CACHE_FILE_NAME;
            if (bv.c(context, str)) {
                String a2 = bv.a(context, str);
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
                            JSONArray jSONArray2 = jSONObject.getJSONArray(Config.EVENT_PART);
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
                                synchronized (a) {
                                    a = jSONObject4;
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
            jSONObject2.put(Config.APP_KEY, str);
            jSONObject.put(Config.HEADER_PART, jSONObject2);
            try {
                jSONObject.put(Config.PRINCIPAL_PART, jSONArray);
                try {
                    jSONObject.put(Config.EVENT_PART, jSONArray);
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
                jSONObject2.put(Config.TRACE_CIRCLE, am.c());
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
            if (jSONArray != null) {
                if (jSONArray.length() != 0) {
                    while (true) {
                        try {
                            int i3 = i2;
                            i2 = i;
                            if (i3 < jSONArray.length()) {
                                JSONObject jSONObject3 = (JSONObject) jSONArray.get(i3);
                                i = (jSONObject3.getLong("e") == 0 || jSONObject3.getLong("c") != 0) ? i2 : i2 + 1;
                                i2 = i3 + 1;
                            } else {
                                return i2;
                            }
                        } catch (Exception e2) {
                            return i2;
                        }
                    }
                }
            }
            return i;
        } catch (Exception e3) {
            return i;
        }
    }

    private void a(Context context, JSONObject jSONObject, long j, int i) {
        long longValue;
        int i2;
        long j2;
        Object obj;
        String[] split;
        long longValue2 = al.a().a(context).longValue();
        if (longValue2 <= 0 && i != 0) {
            al.a().a(context, j);
            longValue2 = j;
        }
        a(jSONObject, Config.TRACE_VISIT_FIRST, Long.valueOf(longValue2));
        if (i != 0) {
            long longValue3 = al.a().b(context).longValue();
            longValue = j - longValue3;
            if (longValue3 != 0 && longValue <= 0) {
                longValue = -1;
            } else if (longValue3 == 0) {
                longValue = 0;
            }
            al.a().b(context, j);
            al.a().c(context, longValue);
        } else {
            longValue = al.a().c(context).longValue();
        }
        a(jSONObject, Config.TRACE_VISIT_SESSION_LAST_INTERVAL, Long.valueOf(longValue));
        String str = "";
        String str2 = "";
        String d = al.a().d(context);
        if (!TextUtils.isEmpty(d) && d.contains(Config.TRACE_TODAY_VISIT_SPLIT) && (split = d.split(Config.TRACE_TODAY_VISIT_SPLIT)) != null && split.length == 2) {
            str = split[0];
            str2 = split[1];
        }
        if (TextUtils.isEmpty(str2)) {
            i2 = 0;
        } else {
            try {
                i2 = Integer.valueOf(str2).intValue();
            } catch (Exception e) {
                i2 = 0;
            }
        }
        String a2 = cd.a(j);
        int i3 = (TextUtils.isEmpty(str) || a2.equals(str)) ? i + i2 : i;
        if (i != 0) {
            al.a().a(context, a2 + Config.TRACE_TODAY_VISIT_SPLIT + i3);
        }
        a(jSONObject, Config.TRACE_VISIT_SESSION_TODAY_COUNT, Integer.valueOf(i3));
        if (TextUtils.isEmpty(str)) {
            j2 = 0;
        } else {
            try {
                j2 = Integer.valueOf(str).intValue();
            } catch (Exception e2) {
                j2 = 0;
            }
        }
        if (j2 != 0 && !TextUtils.isEmpty(str) && !a2.equals(str) && i != 0) {
            JSONArray a3 = a(context, j2, i2);
            al.a().b(context, a3.toString());
            a(jSONObject, Config.TRACE_VISIT_RECENT, a3);
            return;
        }
        String e3 = al.a().e(context);
        if (TextUtils.isEmpty(e3)) {
            obj = null;
        } else {
            try {
                obj = new JSONArray(e3);
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
        String e = al.a().e(context);
        if (!TextUtils.isEmpty(e)) {
            try {
                JSONArray jSONArray = new JSONArray(e);
                if (jSONArray != null && jSONArray.length() != 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add((JSONObject) jSONArray.get(i));
                    }
                }
            } catch (Exception e2) {
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
                jSONObject.put(Config.TRACE_VISIT_RECENT_COUNT, j2);
                arrayList.add(jSONObject);
            } catch (Exception e3) {
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

    public void saveLogData(Context context, boolean z, boolean z2, long j, boolean z3) {
        HeadObject headObject = CooperService.instance().getHeadObject();
        if (headObject != null) {
            synchronized (a) {
                if (TextUtils.isEmpty(headObject.e)) {
                    headObject.installHeader(context, a);
                } else {
                    headObject.updateHeader(context, a);
                }
            }
            if (TextUtils.isEmpty(headObject.e)) {
                bj.c().c("[WARNING] 无法找到有效APP Key, 请参考文档配置");
                return;
            }
        }
        JSONObject jSONObject = new JSONObject();
        synchronized (a) {
            try {
                a.put("t", System.currentTimeMillis());
                a.put(Config.SEQUENCE_INDEX, z ? 0 : 1);
                a.put("ss", j);
                synchronized (this.e) {
                    a.put(Config.WIFI_LOCATION, this.e);
                }
                a.put("sign", CooperService.instance().getUUID());
                jSONObject.put(Config.HEADER_PART, a);
                synchronized (this.c) {
                    try {
                        jSONObject.put(Config.PRINCIPAL_PART, this.c);
                        synchronized (this.d) {
                            try {
                                jSONObject.put(Config.EVENT_PART, this.d);
                                try {
                                    jSONObject.put(Config.EXCEPTION_PART, new JSONArray());
                                    a(context, jSONObject, z2);
                                    b(jSONObject);
                                    a(context, jSONObject.toString(), z, z3);
                                    this.i = jSONObject;
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

    private void b(JSONObject jSONObject) {
    }

    private void a(Context context, String str, boolean z, boolean z2) {
        if (this.h != null && this.h.onSendLogData(str)) {
            bj.c().a("Log has been passed to app level, log: " + str);
            return;
        }
        LogSender.instance().saveLogData(context, str, false);
        bj.c().a("Save log: " + str);
        if (z) {
            if (z2) {
                bc.a(context);
            } else {
                bc.b(context);
            }
        }
    }

    public void clearCache(Context context) {
        a(false);
        synchronized (a) {
            a = new JSONObject();
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
