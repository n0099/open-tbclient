package com.baidu.crabsdk.sender;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.util.Base64;
import com.baidu.crabsdk.b.r;
import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public final class c extends a {
    private ActivityManager aay;
    private int by;

    public c(Context context) {
        super(context);
        this.aay = null;
        this.by = -100;
        this.aay = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
    }

    private static Map<String, Object> a(ActivityManager.ProcessErrorStateInfo processErrorStateInfo, String str) {
        HashMap hashMap = new HashMap();
        try {
            StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
            if (stackTrace == null || stackTrace.length <= 0) {
                hashMap.put("mainThread", "N/A");
                hashMap.put("errorLine", "N/A");
                hashMap.put("errorOriLine", "N/A");
            } else {
                StringBuilder sb = new StringBuilder();
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb.append(stackTraceElement.toString()).append("\n");
                }
                hashMap.put("mainThread", sb.toString());
                hashMap.put("errorLine", stackTrace[0].toString());
                hashMap.put("errorOriLine", stackTrace[0].toString());
            }
            hashMap.put("apiType", "ANR");
            hashMap.put("errorType", "ANR");
            String str2 = "";
            if (processErrorStateInfo.shortMsg != null && processErrorStateInfo.shortMsg.contains("(")) {
                str2 = processErrorStateInfo.shortMsg.substring(0, processErrorStateInfo.shortMsg.indexOf("("));
            }
            hashMap.put("type", str2);
            hashMap.put("anrMsg", processErrorStateInfo.longMsg);
            hashMap.put("processId", Integer.valueOf(processErrorStateInfo.pid));
            hashMap.put("processName", processErrorStateInfo.processName);
            hashMap.put("time", Long.valueOf(System.currentTimeMillis()));
            hashMap.put("threadList", r.L());
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("封装anr数据失败!", e);
        }
        try {
            byte[] cu = i.cu(str);
            if (cu == null || cu.length <= 0) {
                com.baidu.crabsdk.c.a.w("read trace file error! " + str);
            } else {
                hashMap.put(Config.TRACE_PART, Base64.encodeToString(cu, 0));
            }
        } catch (Exception e2) {
            com.baidu.crabsdk.c.a.a("wrap trace to anrRecord error!", e2);
        } catch (OutOfMemoryError e3) {
            com.baidu.crabsdk.c.a.w(e3.getMessage());
        }
        return hashMap;
    }

    private boolean g(String str) {
        try {
            ActivityManager.ProcessErrorStateInfo rr = rr();
            if (rr == null) {
                return false;
            }
            if (rr.pid == Process.myPid()) {
                com.baidu.crabsdk.c.a.ch("anr info catched...");
                Map<String, Object> a = a(rr, str);
                if (com.baidu.crabsdk.a.N != null) {
                    com.baidu.crabsdk.a.N.onAnrStarted(a);
                }
                Map<String, Object> a2 = g.a(this.aaw, (Throwable) null, false);
                if (a2 == null) {
                    com.baidu.crabsdk.c.a.cj("info map is null!");
                    return true;
                }
                a2.putAll(a);
                g.b(a2);
                i.a(this.aaw, i.i(a2));
                h.ab();
                if (h.ru()) {
                    com.baidu.crabsdk.c.a.ch("begin to upload anr info...");
                    k.a(false, this.aaw);
                }
            } else {
                com.baidu.crabsdk.c.a.ch("Anr occur! But not the current pid!" + Process.myPid());
            }
            com.baidu.crabsdk.c.a.ch("getLogcatErrorInfo return true");
            return true;
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("getLogcatErrorInfo error!", e);
            return true;
        } catch (OutOfMemoryError e2) {
            com.baidu.crabsdk.c.a.w(e2.getMessage());
            return true;
        }
    }

    private ActivityManager.ProcessErrorStateInfo rr() {
        try {
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = this.aay.getProcessesInErrorState();
            if (processesInErrorState != null) {
                for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                    if (processErrorStateInfo.condition == 2) {
                        return processErrorStateInfo;
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("getProcessErrorStateInfo error!", e);
        }
        return null;
    }

    @Override // com.baidu.crabsdk.sender.a
    public final void d(String str) {
        if (this.by != Process.myPid()) {
            this.by = Process.myPid();
            try {
                com.baidu.crabsdk.c.a.ch("anr trace logic thread.");
                boolean g = g(str);
                long nanoTime = System.nanoTime();
                while (!g) {
                    try {
                        Thread.sleep(50L);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    g = g(str);
                    if ((System.nanoTime() - nanoTime) / 1000000 > StatisticConfig.MIN_UPLOAD_INTERVAL) {
                        com.baidu.crabsdk.c.a.cj("anr trace logic timeout!");
                        return;
                    }
                }
            } catch (Exception e2) {
                com.baidu.crabsdk.c.a.a("processErrorStateInfo error!", e2);
            }
        }
    }
}
