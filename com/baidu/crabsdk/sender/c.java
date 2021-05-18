package com.baidu.crabsdk.sender;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.util.Base64;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class c extends a {

    /* renamed from: b  reason: collision with root package name */
    public ActivityManager f4763b;

    /* renamed from: c  reason: collision with root package name */
    public int f4764c;

    public c(Context context) {
        super(context);
        this.f4763b = null;
        this.f4764c = -100;
        this.f4763b = (ActivityManager) context.getSystemService("activity");
    }

    public static Map<String, Object> c(ActivityManager.ProcessErrorStateInfo processErrorStateInfo, String str) {
        String str2 = "N/A";
        HashMap hashMap = new HashMap();
        try {
            StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
            if (stackTrace == null || stackTrace.length <= 0) {
                hashMap.put("mainThread", "N/A");
                hashMap.put("errorLine", "N/A");
            } else {
                StringBuilder sb = new StringBuilder();
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
                hashMap.put("mainThread", sb.toString());
                hashMap.put("errorLine", stackTrace[0].toString());
                str2 = stackTrace[0].toString();
            }
            hashMap.put("errorOriLine", str2);
            hashMap.put("apiType", "ANR");
            hashMap.put("errorType", "ANR");
            String str3 = "";
            if (processErrorStateInfo.shortMsg != null && processErrorStateInfo.shortMsg.contains("(")) {
                str3 = processErrorStateInfo.shortMsg.substring(0, processErrorStateInfo.shortMsg.indexOf("("));
            }
            hashMap.put("type", str3);
            hashMap.put("anrMsg", processErrorStateInfo.longMsg);
            hashMap.put("processId", Integer.valueOf(processErrorStateInfo.pid));
            hashMap.put("processName", processErrorStateInfo.processName);
            hashMap.put("time", Long.valueOf(System.currentTimeMillis()));
            hashMap.put("threadList", com.baidu.crabsdk.b.s.a());
        } catch (Exception e2) {
            com.baidu.crabsdk.c.a.a("封装anr数据失败!", e2);
        }
        try {
            byte[] l = i.l(str);
            if (l == null || l.length <= 0) {
                com.baidu.crabsdk.c.a.d("read trace file error! " + str);
            } else {
                hashMap.put(Config.TRACE_PART, Base64.encodeToString(l, 0));
            }
        } catch (Exception e3) {
            com.baidu.crabsdk.c.a.a("wrap trace to anrRecord error!", e3);
        } catch (OutOfMemoryError e4) {
            com.baidu.crabsdk.c.a.d(e4.getMessage());
        }
        return hashMap;
    }

    @Override // com.baidu.crabsdk.sender.a
    public final void a(String str) {
        if (this.f4764c != Process.myPid()) {
            this.f4764c = Process.myPid();
            try {
                com.baidu.crabsdk.c.a.b("anr trace logic thread.");
                boolean d2 = d(str);
                long nanoTime = System.nanoTime();
                while (!d2) {
                    try {
                        Thread.sleep(50L);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    d2 = d(str);
                    if ((System.nanoTime() - nanoTime) / 1000000 > StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD) {
                        com.baidu.crabsdk.c.a.e("anr trace logic timeout!");
                        return;
                    }
                }
            } catch (Exception e3) {
                com.baidu.crabsdk.c.a.a("processErrorStateInfo error!", e3);
            }
        }
    }

    public final ActivityManager.ProcessErrorStateInfo b() {
        try {
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = this.f4763b.getProcessesInErrorState();
            if (processesInErrorState != null) {
                for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                    if (processErrorStateInfo.condition == 2) {
                        return processErrorStateInfo;
                    }
                }
                return null;
            }
            return null;
        } catch (Exception e2) {
            com.baidu.crabsdk.c.a.a("getProcessErrorStateInfo error!", e2);
            return null;
        }
    }

    public final boolean d(String str) {
        try {
            ActivityManager.ProcessErrorStateInfo b2 = b();
            if (b2 == null) {
                return false;
            }
            if (b2.pid == Process.myPid()) {
                com.baidu.crabsdk.c.a.b("anr info catched...");
                Map<String, Object> c2 = c(b2, str);
                if (com.baidu.crabsdk.a.P != null) {
                    com.baidu.crabsdk.a.P.onAnrStarted(c2);
                }
                Map<String, Object> c3 = g.c(this.f4760a, null, false);
                if (c3 == null) {
                    com.baidu.crabsdk.c.a.e("info map is null!");
                    return true;
                }
                c3.putAll(c2);
                g.h(c3);
                i.b(this.f4760a, i.h(c3));
                h.k();
                if (h.a()) {
                    com.baidu.crabsdk.c.a.b("begin to upload anr info...");
                    k.b(false, this.f4760a);
                }
            } else {
                com.baidu.crabsdk.c.a.b("Anr occur! But not the current pid!" + Process.myPid());
            }
            com.baidu.crabsdk.c.a.b("getLogcatErrorInfo return true");
            return true;
        } catch (Exception e2) {
            com.baidu.crabsdk.c.a.a("getLogcatErrorInfo error!", e2);
            return true;
        } catch (OutOfMemoryError e3) {
            com.baidu.crabsdk.c.a.d(e3.getMessage());
            return true;
        }
    }
}
