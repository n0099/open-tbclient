package com.baidu.crabsdk.sender;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.util.Base64;
import com.baidu.crabsdk.b.r;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.base.network.Apn;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public final class c extends a {
    private ActivityManager aab;
    private int by;

    public c(Context context) {
        super(context);
        this.aab = null;
        this.by = -100;
        this.aab = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
    }

    private static Map<String, Object> a(ActivityManager.ProcessErrorStateInfo processErrorStateInfo, String str) {
        HashMap hashMap = new HashMap();
        try {
            StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
            if (stackTrace == null || stackTrace.length <= 0) {
                hashMap.put("mainThread", Apn.APN_UNKNOWN);
                hashMap.put("errorLine", Apn.APN_UNKNOWN);
                hashMap.put("errorOriLine", Apn.APN_UNKNOWN);
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
            hashMap.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, Long.valueOf(System.currentTimeMillis()));
            hashMap.put("threadList", r.L());
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("封装anr数据失败!", e);
        }
        try {
            byte[] cs = i.cs(str);
            if (cs == null || cs.length <= 0) {
                com.baidu.crabsdk.c.a.w("read trace file error! " + str);
            } else {
                hashMap.put(Config.TRACE_PART, Base64.encodeToString(cs, 0));
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
            ActivityManager.ProcessErrorStateInfo qU = qU();
            if (qU == null) {
                return false;
            }
            if (qU.pid == Process.myPid()) {
                com.baidu.crabsdk.c.a.cf("anr info catched...");
                Map<String, Object> a = a(qU, str);
                if (com.baidu.crabsdk.a.N != null) {
                    com.baidu.crabsdk.a.N.onAnrStarted(a);
                }
                Map<String, Object> a2 = g.a(this.ZZ, (Throwable) null, false);
                if (a2 == null) {
                    com.baidu.crabsdk.c.a.ch("info map is null!");
                    return true;
                }
                a2.putAll(a);
                g.b(a2);
                i.a(this.ZZ, i.i(a2));
                h.ab();
                if (h.qX()) {
                    com.baidu.crabsdk.c.a.cf("begin to upload anr info...");
                    k.a(false, this.ZZ);
                }
            } else {
                com.baidu.crabsdk.c.a.cf("Anr occur! But not the current pid!" + Process.myPid());
            }
            com.baidu.crabsdk.c.a.cf("getLogcatErrorInfo return true");
            return true;
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("getLogcatErrorInfo error!", e);
            return true;
        } catch (OutOfMemoryError e2) {
            com.baidu.crabsdk.c.a.w(e2.getMessage());
            return true;
        }
    }

    private ActivityManager.ProcessErrorStateInfo qU() {
        try {
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = this.aab.getProcessesInErrorState();
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
                com.baidu.crabsdk.c.a.cf("anr trace logic thread.");
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
                        com.baidu.crabsdk.c.a.ch("anr trace logic timeout!");
                        return;
                    }
                }
            } catch (Exception e2) {
                com.baidu.crabsdk.c.a.a("processErrorStateInfo error!", e2);
            }
        }
    }
}
