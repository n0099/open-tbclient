package com.baidu.crabsdk.sender;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.util.Base64;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.perfframe.ioc.Constant;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public final class c extends a {
    private ActivityManager arU;
    private int bB;

    public c(Context context) {
        super(context);
        this.arU = null;
        this.bB = -100;
        this.arU = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
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
            hashMap.put(Constant.KEY_PROCESS_NAME, processErrorStateInfo.processName);
            hashMap.put("time", Long.valueOf(System.currentTimeMillis()));
            hashMap.put("threadList", com.baidu.crabsdk.b.s.Q());
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("封装anr数据失败!", e);
        }
        try {
            byte[] dY = i.dY(str);
            if (dY == null || dY.length <= 0) {
                com.baidu.crabsdk.c.a.w("read trace file error! " + str);
            } else {
                hashMap.put(Config.TRACE_PART, Base64.encodeToString(dY, 0));
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
            ActivityManager.ProcessErrorStateInfo uw = uw();
            if (uw == null) {
                return false;
            }
            if (uw.pid == Process.myPid()) {
                com.baidu.crabsdk.c.a.dw("anr info catched...");
                Map<String, Object> a2 = a(uw, str);
                if (com.baidu.crabsdk.a.P != null) {
                    com.baidu.crabsdk.a.P.onAnrStarted(a2);
                }
                Map<String, Object> a3 = g.a(this.arR, (Throwable) null, false);
                if (a3 == null) {
                    com.baidu.crabsdk.c.a.dx("info map is null!");
                    return true;
                }
                a3.putAll(a2);
                g.b(a3);
                i.a(this.arR, i.e(a3));
                h.ag();
                if (h.uy()) {
                    com.baidu.crabsdk.c.a.dw("begin to upload anr info...");
                    k.a(false, this.arR);
                }
            } else {
                com.baidu.crabsdk.c.a.dw("Anr occur! But not the current pid!" + Process.myPid());
            }
            com.baidu.crabsdk.c.a.dw("getLogcatErrorInfo return true");
            return true;
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("getLogcatErrorInfo error!", e);
            return true;
        } catch (OutOfMemoryError e2) {
            com.baidu.crabsdk.c.a.w(e2.getMessage());
            return true;
        }
    }

    private ActivityManager.ProcessErrorStateInfo uw() {
        try {
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = this.arU.getProcessesInErrorState();
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
                com.baidu.crabsdk.c.a.dw("anr trace logic thread.");
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
                        com.baidu.crabsdk.c.a.dx("anr trace logic timeout!");
                        return;
                    }
                }
            } catch (Exception e2) {
                com.baidu.crabsdk.c.a.a("processErrorStateInfo error!", e2);
            }
        }
    }
}
