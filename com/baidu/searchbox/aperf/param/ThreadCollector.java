package com.baidu.searchbox.aperf.param;

import android.os.Looper;
import android.util.Log;
import java.util.Map;
/* loaded from: classes6.dex */
public class ThreadCollector {
    public static String getThreadInfo(Thread thread) {
        StringBuilder sb = new StringBuilder();
        if (thread != null) {
            try {
                sb.append("threadId： ").append(thread.getId()).append("\n");
                if (thread.getName() != null) {
                    sb.append("name: ").append(thread.getName()).append("\n");
                }
                sb.append("priority: ").append(thread.getPriority()).append("\n");
                sb.append("state: ").append(thread.getState()).append("\n");
                sb.append("stacktrace: \n");
                StackTraceElement[] stackTrace = thread.getStackTrace();
                if (stackTrace != null && stackTrace.length >= 1) {
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        String methodName = stackTraceElement.getMethodName();
                        if (methodName == null) {
                            methodName = "unknown";
                        }
                        sb.append("\tat ").append(methodName).append("(");
                        String fileName = stackTraceElement.getFileName();
                        if (fileName == null) {
                            fileName = "unknown";
                        }
                        sb.append(fileName).append(":").append(stackTraceElement.getLineNumber()).append(")\n");
                    }
                }
            } catch (Exception e) {
                Log.e("ThreadCollector", "ThreadInfo Collector Interrupted!!", e);
            }
        }
        return sb.toString();
    }

    public static String getAllThreadStacks() {
        StringBuilder sb = new StringBuilder();
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces != null && allStackTraces.size() >= 1) {
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                sb.append(getThreadInfo(entry.getKey())).append("\n");
            }
        }
        return sb.toString();
    }

    public static String getMainThreadStackTrace() {
        return getThreadStack(Looper.getMainLooper().getThread());
    }

    public static String getThreadStack(Thread thread) {
        StringBuilder sb = new StringBuilder();
        if (thread != null) {
            try {
                StackTraceElement[] stackTrace = thread.getStackTrace();
                if (stackTrace != null && stackTrace.length >= 1) {
                    int length = stackTrace.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(stackTrace[i].toString() + "\r\n");
                    }
                }
            } catch (Exception e) {
                Log.e("ThreadCollector", "ThreadInfo Collector Interrupted!!", e);
            }
        }
        return sb.toString();
    }
}
