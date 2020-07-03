package com.baidu.crabsdk.sender;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.util.Base64;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public final class c extends a {
    private ActivityManager anM;
    private int bB;

    public c(Context context) {
        super(context);
        this.anM = null;
        this.bB = -100;
        this.anM = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
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
            hashMap.put("threadList", com.baidu.crabsdk.b.s.tj());
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("封装anr数据失败!", e);
        }
        try {
            byte[] dN = i.dN(str);
            if (dN == null || dN.length <= 0) {
                com.baidu.crabsdk.c.a.w("read trace file error! " + str);
            } else {
                hashMap.put(Config.TRACE_PART, Base64.encodeToString(dN, 0));
            }
        } catch (Exception e2) {
            com.baidu.crabsdk.c.a.a("wrap trace to anrRecord error!", e2);
        } catch (OutOfMemoryError e3) {
            com.baidu.crabsdk.c.a.w(e3.getMessage());
        }
        return hashMap;
    }

    private boolean h(String str) {
        try {
            ActivityManager.ProcessErrorStateInfo ts = ts();
            if (ts == null) {
                return false;
            }
            if (ts.pid == Process.myPid()) {
                com.baidu.crabsdk.c.a.di("anr info catched...");
                Map<String, Object> a = a(ts, str);
                if (com.baidu.crabsdk.a.P != null) {
                    com.baidu.crabsdk.a.P.onAnrStarted(a);
                }
                Map<String, Object> a2 = g.a(this.anJ, (Throwable) null, false);
                if (a2 == null) {
                    com.baidu.crabsdk.c.a.dj("info map is null!");
                    return true;
                }
                a2.putAll(a);
                g.b(a2);
                i.a(this.anJ, i.e(a2));
                h.ag();
                if (h.tv()) {
                    com.baidu.crabsdk.c.a.di("begin to upload anr info...");
                    k.a(false, this.anJ);
                }
            } else {
                com.baidu.crabsdk.c.a.di("Anr occur! But not the current pid!" + Process.myPid());
            }
            com.baidu.crabsdk.c.a.di("getLogcatErrorInfo return true");
            return true;
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("getLogcatErrorInfo error!", e);
            return true;
        } catch (OutOfMemoryError e2) {
            com.baidu.crabsdk.c.a.w(e2.getMessage());
            return true;
        }
    }

    private ActivityManager.ProcessErrorStateInfo ts() {
        try {
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = this.anM.getProcessesInErrorState();
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
    public final void e(String str) {
        if (this.bB != Process.myPid()) {
            this.bB = Process.myPid();
            try {
                com.baidu.crabsdk.c.a.di("anr trace logic thread.");
                boolean h = h(str);
                long nanoTime = System.nanoTime();
                while (!h) {
                    try {
                        Thread.sleep(50L);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    h = h(str);
                    if ((System.nanoTime() - nanoTime) / TimeUtils.NANOS_PER_MS > 30000) {
                        com.baidu.crabsdk.c.a.dj("anr trace logic timeout!");
                        return;
                    }
                }
            } catch (Exception e2) {
                com.baidu.crabsdk.c.a.a("processErrorStateInfo error!", e2);
            }
        }
    }
}
