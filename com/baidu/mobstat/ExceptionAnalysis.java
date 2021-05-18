package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ExceptionAnalysis {

    /* renamed from: a  reason: collision with root package name */
    public static ExceptionAnalysis f8473a = new ExceptionAnalysis();

    /* renamed from: c  reason: collision with root package name */
    public Context f8475c;

    /* renamed from: e  reason: collision with root package name */
    public String f8477e;
    public Callback mCallback;

    /* renamed from: b  reason: collision with root package name */
    public boolean f8474b = false;

    /* renamed from: d  reason: collision with root package name */
    public HeadObject f8476d = new HeadObject();

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
        return f8473a;
    }

    public void openExceptionAnalysis(Context context, boolean z) {
        if (context != null) {
            this.f8475c = context.getApplicationContext();
        }
        if (this.f8475c == null || this.f8474b) {
            return;
        }
        this.f8474b = true;
        ad.a().a(this.f8475c);
        if (z) {
            return;
        }
        NativeCrashHandler.init(this.f8475c);
    }

    public void saveCrashInfo(Context context, Throwable th, boolean z) {
        int i2;
        if (context != null) {
            this.f8475c = context.getApplicationContext();
        }
        if (this.f8475c == null) {
            return;
        }
        String th2 = th.toString();
        String str = "";
        if (!TextUtils.isEmpty(th2)) {
            try {
                String[] split = th2.split(":");
                str = split.length > 1 ? split[0] : th2;
            } catch (Exception unused) {
            }
        }
        String str2 = TextUtils.isEmpty(str) ? th2 : str;
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String obj = stringWriter.toString();
        if (z) {
            i2 = 0;
        } else if (th instanceof Exception) {
            i2 = 11;
        } else {
            i2 = th instanceof Error ? 12 : 13;
        }
        saveCrashInfo(this.f8475c, System.currentTimeMillis(), obj, str2, 0, i2);
    }

    public void setCrashExtraInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.length() > 256) {
            str = str.substring(0, 256);
        }
        this.f8477e = str;
    }

    public ExceptionAnalysis(Callback callback) {
        this.mCallback = callback;
    }

    @SuppressLint({"NewApi"})
    private JSONObject a(Context context) {
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
            jSONObject.put(Config.EXCEPTION_MEMORY_LOW, memoryInfo.lowMemory ? 1 : 0);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public void saveCrashInfo(Context context, long j, String str, String str2, int i2, int i3) {
        BDStatCore.instance().autoTrackSessionEndTime(context);
        if (context != null && str != null && !str.trim().equals("")) {
            try {
                StringBuilder sb = new StringBuilder(str);
                if (!TextUtils.isEmpty(this.f8477e)) {
                    sb.append("\n");
                    sb.append("ExtraInfo:");
                    sb.append(this.f8477e);
                }
                String appVersionName = CooperService.instance().getAppVersionName(context);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("t", j);
                jSONObject.put("c", sb.toString());
                jSONObject.put("y", str2);
                jSONObject.put("v", appVersionName);
                jSONObject.put(Config.EXCEPTION_CRASH_TYPE, i2);
                jSONObject.put("mem", a(context));
                jSONObject.put("ty", i3);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                this.f8476d.installHeader(context, jSONObject2);
                jSONObject2.put("ss", 0);
                jSONObject2.put(Config.SEQUENCE_INDEX, 0);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(Config.HEADER_PART, jSONObject2);
                jSONObject3.put(Config.PRINCIPAL_PART, new JSONArray());
                jSONObject3.put("ev", new JSONArray());
                jSONObject3.put(Config.EXCEPTION_PART, jSONArray);
                jSONObject3.put(Config.TRACE_PART, a());
                if (this.mCallback != null) {
                    this.mCallback.onCallback(jSONObject3);
                }
                bo.a(context, Config.PREFIX_SEND_DATA + System.currentTimeMillis(), jSONObject3.toString(), false);
                bc.c().a("dump exception, exception: " + str);
            } catch (Exception unused) {
            }
        }
    }
}
