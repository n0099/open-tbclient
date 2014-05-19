package com.baidu.mobstat;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class DataCore {
    private static JSONObject b = new JSONObject();
    private static DataCore h = new DataCore();
    private int a = 0;
    private JSONArray c = new JSONArray();
    private JSONArray d = new JSONArray();
    private JSONArray e = new JSONArray();
    private JSONArray f = new JSONArray();
    private boolean g = false;

    private DataCore() {
    }

    private void a(boolean z) {
        this.g = z;
    }

    private boolean b() {
        return this.g;
    }

    public static DataCore getInstance() {
        return h;
    }

    public void flush(Context context) {
        com.baidu.mobstat.a.e.a("statsdk", "flush cache to __local_stat_cache.json");
        JSONObject jSONObject = new JSONObject();
        try {
            synchronized (this.c) {
                jSONObject.put("pr", new JSONArray(this.c.toString()));
            }
            synchronized (this.d) {
                jSONObject.put("ev", new JSONArray(this.d.toString()));
            }
            synchronized (this.f) {
                jSONObject.put("ex", new JSONArray(this.f.toString()));
            }
        } catch (JSONException e) {
            com.baidu.mobstat.a.e.a("statsdk", "flushLogWithoutHeader() construct cache error");
        }
        String jSONObject2 = jSONObject.toString();
        if (b()) {
            com.baidu.mobstat.a.e.a("statsdk", "cache.json exceed 204800B,stop flush.");
            return;
        }
        int length = jSONObject2.getBytes().length;
        if (length >= 204800) {
            a(true);
            return;
        }
        this.a = length;
        com.baidu.mobstat.a.e.a("statsdk", "flush:cacheFileSize is:" + this.a);
        com.baidu.mobstat.a.c.a(false, context, "__local_stat_cache.json", jSONObject2, false);
    }

    public void getMemInfo(Context context) {
    }

    public synchronized void installHeader(Context context) {
        CooperService.a().b(context);
    }

    public boolean isPartEmpty() {
        return this.c.length() == 0 && this.d.length() == 0 && this.f.length() == 0;
    }

    public void loadLastSession(Context context) {
        com.baidu.mobstat.a.e.a("statsdk", "LoadLastSession()");
        if (context != null && com.baidu.mobstat.a.c.c(context, "__local_last_session.json")) {
            String a = com.baidu.mobstat.a.c.a(false, context, "__local_last_session.json");
            if (a.equals("")) {
                com.baidu.mobstat.a.e.a("statsdk", "loadLastSession(): last_session.json file not found.");
                return;
            }
            com.baidu.mobstat.a.c.a(false, context, "__local_last_session.json", new JSONObject().toString(), false);
            putSession(a);
            flush(context);
        }
    }

    public void loadStatData(Context context) {
        if (context != null && com.baidu.mobstat.a.c.c(context, "__local_stat_cache.json")) {
            String a = com.baidu.mobstat.a.c.a(false, context, "__local_stat_cache.json");
            if (a.equals("")) {
                com.baidu.mobstat.a.e.a("statsdk", "stat_cache file not found.");
                return;
            }
            com.baidu.mobstat.a.e.a("statsdk", "loadStatData, ");
            try {
                this.a = a.getBytes().length;
                com.baidu.mobstat.a.e.a("statsdk", "load Stat Data:cacheFileSize is:" + this.a);
                JSONObject jSONObject = new JSONObject(a);
                com.baidu.mobstat.a.e.a("statsdk", "Load cache:" + a);
                long currentTimeMillis = System.currentTimeMillis();
                JSONArray jSONArray = jSONObject.getJSONArray("pr");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    if (currentTimeMillis - jSONObject2.getLong("s") <= 604800000) {
                        putSession(jSONObject2, true);
                    }
                }
                JSONArray jSONArray2 = jSONObject.getJSONArray("ev");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                    if (currentTimeMillis - jSONObject3.getLong("t") <= 604800000) {
                        putEvent(jSONObject3, true);
                    }
                }
                JSONArray jSONArray3 = jSONObject.getJSONArray("ex");
                for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                    JSONObject jSONObject4 = jSONArray3.getJSONObject(i3);
                    if (currentTimeMillis - jSONObject4.getLong("t") <= 604800000) {
                        putException(jSONObject4, true);
                    }
                }
            } catch (JSONException e) {
                com.baidu.mobstat.a.e.a("statsdk", "Load stat data error:" + e);
            }
        }
    }

    public void putEvent(String str, String str2, int i, long j, long j2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("i", str);
            jSONObject.put("l", str2);
            jSONObject.put("c", i);
            jSONObject.put("t", j);
            jSONObject.put("d", j2);
            putEvent(jSONObject, false);
            com.baidu.mobstat.a.e.a("statsdk", "put event:" + jSONObject.toString());
        } catch (JSONException e) {
            com.baidu.mobstat.a.e.a("statsdk", e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0085, code lost:
        if (r2.equals("") != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void putEvent(JSONObject jSONObject, boolean z) {
        if (jSONObject != null && !z) {
            int length = jSONObject.toString().getBytes().length;
            com.baidu.mobstat.a.e.a("statsdk", "putEvent:eventSize is:", Integer.valueOf(length));
            if (length + this.a > 204800) {
                com.baidu.mobstat.a.e.a("statsdk", "putEvent: size is full!");
                return;
            }
        }
        int i = 0;
        try {
            String string = jSONObject.getString("i");
            String string2 = jSONObject.getString("l");
            long j = jSONObject.getLong("t") / 3600000;
            String optString = jSONObject.optString("s");
            try {
                i = jSONObject.getInt("d");
            } catch (JSONException e) {
                com.baidu.mobstat.a.e.a("statsdk", "old version data, No duration Tag");
            }
            if (i != 0) {
                synchronized (this.d) {
                    int length2 = this.d.length();
                    try {
                        jSONObject.put("s", "0");
                        this.d.put(length2, jSONObject);
                    } catch (JSONException e2) {
                        com.baidu.mobstat.a.e.a("statsdk", e2);
                    }
                }
                return;
            }
            synchronized (this.d) {
                int length3 = this.d.length();
                if (optString != null) {
                    try {
                    } catch (JSONException e3) {
                        com.baidu.mobstat.a.e.a("statsdk", "event put s fail");
                    }
                }
                jSONObject.put("s", "0|");
                int i2 = 0;
                int i3 = length3;
                while (true) {
                    if (i2 >= length3) {
                        i2 = i3;
                        break;
                    }
                    try {
                        JSONObject jSONObject2 = this.d.getJSONObject(i2);
                        com.baidu.mobstat.a.e.a("statsdk", ";event_iter=" + jSONObject2.toString());
                        String string3 = jSONObject2.getString("i");
                        String string4 = jSONObject2.getString("l");
                        long j2 = jSONObject2.getLong("t") / 3600000;
                        int i4 = 0;
                        try {
                            i4 = jSONObject2.getInt("d");
                        } catch (JSONException e4) {
                            com.baidu.mobstat.a.e.a("statsdk", "old version data, No duration Tag");
                        }
                        if (j2 == j && i4 == 0) {
                            com.baidu.mobstat.a.e.a("statsdk", ";event_iter=" + jSONObject2.toString());
                            if (string3.equals(string) && string4.equals(string2)) {
                                int i5 = jSONObject2.getInt("c") + jSONObject.getInt("c");
                                String optString2 = jSONObject2.optString("s");
                                String str = ((optString2 == null || optString2.equalsIgnoreCase("")) ? "0|" : "0|") + (jSONObject.getLong("t") - jSONObject2.getLong("t")) + "|";
                                try {
                                    jSONObject2.remove("c");
                                    jSONObject2.put("c", i5);
                                    jSONObject2.put("s", str);
                                    break;
                                } catch (JSONException e5) {
                                    e = e5;
                                    i3 = i2;
                                    com.baidu.mobstat.a.e.a("statsdk", e);
                                    i2++;
                                }
                            }
                        }
                    } catch (JSONException e6) {
                        e = e6;
                    }
                    i2++;
                }
                if (i2 < length3) {
                    return;
                }
                try {
                    this.d.put(length3, jSONObject);
                } catch (JSONException e7) {
                    com.baidu.mobstat.a.e.a("statsdk", e7);
                }
            }
        } catch (JSONException e8) {
            com.baidu.mobstat.a.e.a("statsdk", e8);
        }
    }

    public void putException(long j, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", j);
            jSONObject.put("y", str2);
            if (str.getBytes().length > 5120) {
                byte[] bArr = new byte[5120];
                str.getBytes(0, 5120, bArr, 0);
                com.baidu.mobstat.a.e.a("exception bytes=" + bArr.length);
                jSONObject.put("c", new String(bArr));
            } else {
                jSONObject.put("c", str);
            }
        } catch (JSONException e) {
            com.baidu.mobstat.a.e.a("statsdk", e);
        }
        putException(jSONObject, false);
    }

    public void putException(JSONObject jSONObject, boolean z) {
        if (jSONObject != null && !z) {
            int length = jSONObject.toString().getBytes().length;
            com.baidu.mobstat.a.e.a("statsdk", "putException:addSize is:", Integer.valueOf(length));
            if (length + this.a > 204800) {
                com.baidu.mobstat.a.e.a("statsdk", "putException: size is full!");
                return;
            }
        }
        synchronized (this.f) {
            try {
                this.f.put(this.f.length(), jSONObject);
            } catch (JSONException e) {
                com.baidu.mobstat.a.e.a("statsdk", e);
            }
        }
    }

    public void putSession(String str) {
        if (str.equals("{}") || str.equals("")) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            putSession(jSONObject, false);
            com.baidu.mobstat.a.e.a("statsdk", "Load last session:" + jSONObject);
        } catch (JSONException e) {
            com.baidu.mobstat.a.e.a("statsdk", "putSession()" + e);
        }
    }

    public void putSession(JSONObject jSONObject, boolean z) {
        if (jSONObject != null && !z) {
            int length = jSONObject.toString().getBytes().length;
            com.baidu.mobstat.a.e.a("statsdk", "putSession:addSize is:", Integer.valueOf(length));
            if (length + this.a > 204800) {
                com.baidu.mobstat.a.e.a("statsdk", "putSession: size is full!");
                return;
            }
        }
        synchronized (this.c) {
            try {
                this.c.put(this.c.length(), jSONObject);
            } catch (JSONException e) {
                com.baidu.mobstat.a.e.a("statsdk", e);
            }
        }
    }

    public boolean sendLogData(Context context) {
        boolean z = false;
        com.baidu.mobstat.a.e.a("statsdk", "sendLogData() begin.");
        if (CooperService.a() != null && (CooperService.a().c == null || "".equalsIgnoreCase(CooperService.a().c))) {
            CooperService.a().a(context);
            com.baidu.mobstat.a.e.a("statsdk", "constructHeader() begin.");
            if (CooperService.a().c == null || "".equalsIgnoreCase(CooperService.a().c)) {
                com.baidu.mobstat.a.e.c("不能在manifest.xml中找到APP Key||can't find app key in manifest.xml.");
                return z;
            }
        }
        JSONObject jSONObject = new JSONObject();
        synchronized (b) {
            try {
                b.put("t", System.currentTimeMillis());
                b.put("ss", q.b().d());
                jSONObject.put("he", b);
                synchronized (this.c) {
                    try {
                        jSONObject.put("pr", this.c);
                        synchronized (this.d) {
                            try {
                                jSONObject.put("ev", this.d);
                                synchronized (this.e) {
                                    synchronized (this.f) {
                                        try {
                                            jSONObject.put("ex", this.f);
                                            String jSONObject2 = jSONObject.toString();
                                            com.baidu.mobstat.a.e.a("statsdk", "---Send Data Is:" + jSONObject2);
                                            try {
                                                y.a(context, "http://hmma.baidu.com/app.gif", jSONObject2, 50000, 50000);
                                                z = true;
                                            } catch (Exception e) {
                                                com.baidu.mobstat.a.e.c("statsdk", "send error++++++" + e);
                                            }
                                            com.baidu.mobstat.a.e.a("statsdk", "send log data over. result=" + z + "data=" + jSONObject2);
                                            if (z) {
                                                a(false);
                                                this.f = new JSONArray();
                                                this.d = new JSONArray();
                                                this.c = new JSONArray();
                                                flush(context);
                                                q.b().c();
                                                k.a().c(context);
                                            }
                                        } catch (JSONException e2) {
                                            com.baidu.mobstat.a.e.a("statsdk", e2);
                                        }
                                    }
                                }
                            } catch (JSONException e3) {
                                com.baidu.mobstat.a.e.a("statsdk", e3);
                            }
                        }
                    } catch (JSONException e4) {
                        com.baidu.mobstat.a.e.a("statsdk", e4.toString());
                    }
                }
            } catch (JSONException e5) {
                com.baidu.mobstat.a.e.a("statsdk", e5);
            }
        }
        com.baidu.mobstat.a.e.a("statsdk", "sendLogData() end.");
        return z;
    }

    public void setAppChannel(Context context, String str, boolean z) {
        if (str == null || str.equals("")) {
            com.baidu.mobstat.a.e.c("sdkstat", "设置的渠道不能为空或者为null || The channel that you have been set is null or empty, please check it.");
        }
        CooperService.a().j = str;
        if (z && str != null && !str.equals("")) {
            BasicStoreTools.getInstance().setAppChannelWithPreference(context, str);
            BasicStoreTools.getInstance().setAppChannelWithCode(context, true);
        }
        if (z) {
            return;
        }
        BasicStoreTools.getInstance().setAppChannelWithPreference(context, "");
        BasicStoreTools.getInstance().setAppChannelWithCode(context, false);
    }

    public void setAppChannel(String str) {
        if (str == null || str.equals("")) {
            com.baidu.mobstat.a.e.c("sdkstat", "设置的渠道不能为空或者为null || The channel that you have been set is null or empty, please check it.");
        }
        CooperService.a().j = str;
    }

    public void setAppKey(String str) {
        CooperService.a().c = str;
    }
}
