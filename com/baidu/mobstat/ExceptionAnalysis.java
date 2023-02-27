package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ExceptionAnalysis {
    public static ExceptionAnalysis a = new ExceptionAnalysis();
    public Context c;
    public String e;
    public List<String> f;
    public Callback mCallback;
    public boolean b = false;
    public HeadObject d = new HeadObject();
    public boolean g = true;

    /* loaded from: classes2.dex */
    public interface Callback {
        void onCallback(JSONObject jSONObject);
    }

    public ExceptionAnalysis() {
    }

    private JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Config.TRACE_APPLICATION_SESSION, 0);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put(Config.TRACE_FAILED_CNT, 0);
        } catch (Exception unused2) {
        }
        return jSONObject;
    }

    public static ExceptionAnalysis getInstance() {
        return a;
    }

    public ExceptionAnalysis(Callback callback) {
        this.mCallback = callback;
    }

    public void setCrashExtraInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.length() > 256) {
            str = str.substring(0, 256);
        }
        this.e = str;
    }

    public void setEnableSend(boolean z) {
        this.g = z;
    }

    public void setFilterPackageList(List<String> list) {
        if (list != null && list.size() > 0) {
            this.f = list;
        }
    }

    @SuppressLint({"NewApi"})
    private JSONObject a(Context context) {
        int i;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return null;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        JSONObject jSONObject = new JSONObject();
        try {
            if (Build.VERSION.SDK_INT >= 16) {
                jSONObject.put("total", memoryInfo.totalMem);
            }
            jSONObject.put("free", memoryInfo.availMem);
            if (memoryInfo.lowMemory) {
                i = 1;
            } else {
                i = 0;
            }
            jSONObject.put(Config.EXCEPTION_MEMORY_LOW, i);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public void openExceptionAnalysis(Context context, boolean z) {
        if (context != null) {
            this.c = context.getApplicationContext();
        }
        if (this.c == null || this.b) {
            return;
        }
        this.b = true;
        ab.a().a(this.c);
        if (!z) {
            NativeCrashHandler.init(this.c);
        }
    }

    public void saveCrashInfo(Context context, long j, String str, String str2, int i, int i2) {
        BDStatCore.instance().autoTrackSessionEndTime(context);
        if (context != null && str != null && !str.trim().equals("")) {
            try {
                StringBuilder sb = new StringBuilder(str);
                if (!TextUtils.isEmpty(this.e)) {
                    sb.append("\n");
                    sb.append("ExtraInfo:");
                    sb.append(this.e);
                }
                String appVersionName = CooperService.instance().getAppVersionName(context);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("t", j);
                jSONObject.put("c", sb.toString());
                jSONObject.put("y", str2);
                jSONObject.put("v", appVersionName);
                jSONObject.put(Config.EXCEPTION_CRASH_TYPE, i);
                jSONObject.put("mem", a(context));
                jSONObject.put("ty", i2);
                jSONObject.put("sv", "4.0.9.7");
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                this.d.installHeader(context, jSONObject2);
                jSONObject2.put("ss", 0);
                jSONObject2.put(Config.SEQUENCE_INDEX, 0);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(Config.HEADER_PART, jSONObject2);
                jSONObject3.put("pr", new JSONArray());
                jSONObject3.put(Config.EVENT_PART, new JSONArray());
                jSONObject3.put(Config.EXCEPTION_PART, jSONArray);
                jSONObject3.put(Config.TRACE_PART, a());
                if (this.mCallback != null) {
                    this.mCallback.onCallback(jSONObject3);
                }
                bn.a(context, Config.PREFIX_SEND_DATA + System.currentTimeMillis(), jSONObject3.toString(), false);
                bb.c().a("dump exception, exception: " + str);
            } catch (Exception unused) {
            }
        }
    }

    public void saveCrashInfo(Context context, Throwable th, boolean z) {
        String str;
        int i;
        if (context != null) {
            this.c = context.getApplicationContext();
        }
        if (this.c == null) {
            return;
        }
        String th2 = th.toString();
        String str2 = "";
        if (!TextUtils.isEmpty(th2)) {
            try {
                String[] split = th2.split(":");
                str2 = split.length > 1 ? split[0] : th2;
            } catch (Exception unused) {
            }
        }
        if (TextUtils.isEmpty(str2)) {
            str = th2;
        } else {
            str = str2;
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String obj = stringWriter.toString();
        if (!z) {
            if (th instanceof Exception) {
                i = 11;
            } else if (th instanceof Error) {
                i = 12;
            } else {
                i = 13;
            }
        } else {
            i = 0;
        }
        saveCrashInfo(this.c, System.currentTimeMillis(), obj, str, 0, i);
    }
}
