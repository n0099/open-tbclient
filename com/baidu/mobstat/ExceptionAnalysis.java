package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes17.dex */
public class ExceptionAnalysis {

    /* renamed from: a  reason: collision with root package name */
    private static ExceptionAnalysis f2494a = new ExceptionAnalysis();
    private Context c;
    private String e;
    public Callback mCallback;
    private boolean b = false;
    private HeadObject d = new HeadObject();

    /* loaded from: classes17.dex */
    public interface Callback {
        void onCallback(JSONObject jSONObject);
    }

    public static ExceptionAnalysis getInstance() {
        return f2494a;
    }

    private ExceptionAnalysis() {
    }

    public ExceptionAnalysis(Callback callback) {
        this.mCallback = callback;
    }

    public void openExceptionAnalysis(Context context, boolean z) {
        if (context != null) {
            this.c = context.getApplicationContext();
        }
        if (this.c != null && !this.b) {
            this.b = true;
            ad.a().a(this.c);
            if (!z) {
                NativeCrashHandler.init(this.c);
            }
        }
    }

    public void saveCrashInfo(Context context, Throwable th, boolean z) {
        int i;
        if (context != null) {
            this.c = context.getApplicationContext();
        }
        if (this.c != null) {
            String th2 = th.toString();
            String str = "";
            if (!TextUtils.isEmpty(th2)) {
                try {
                    String[] split = th2.split(":");
                    str = split.length > 1 ? split[0] : th2;
                } catch (Exception e) {
                    str = "";
                }
            }
            String str2 = TextUtils.isEmpty(str) ? th2 : str;
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String obj = stringWriter.toString();
            if (z) {
                i = 0;
            } else if (th instanceof Exception) {
                i = 11;
            } else if (th instanceof Error) {
                i = 12;
            } else {
                i = 13;
            }
            saveCrashInfo(this.c, System.currentTimeMillis(), obj, str2, 0, i);
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
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                this.d.installHeader(context, jSONObject2);
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
            } catch (Exception e) {
            }
        }
    }

    private JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Config.TRACE_APPLICATION_SESSION, 0);
        } catch (Exception e) {
        }
        try {
            jSONObject.put(Config.TRACE_FAILED_CNT, 0);
        } catch (Exception e2) {
        }
        return jSONObject;
    }

    @SuppressLint({"NewApi"})
    private JSONObject a(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
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
            return jSONObject;
        } catch (Exception e) {
            return jSONObject;
        }
    }

    public void setCrashExtraInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 256) {
                str = str.substring(0, 256);
            }
            this.e = str;
        }
    }
}
