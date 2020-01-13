package com.baidu.crabsdk.b;

import java.util.Map;
/* loaded from: classes6.dex */
public final class r {
    public static String L() {
        StringBuilder sb = new StringBuilder();
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces != null && allStackTraces.size() > 0) {
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                sb.append(a(entry.getKey())).append("\n");
            }
        }
        return sb.toString();
    }

    public static String a(Thread thread) {
        String name;
        StringBuilder sb = new StringBuilder();
        if (thread != null) {
            try {
                sb.append("threadId： ").append(thread.getId()).append("\n");
                if (thread.getName() != null) {
                    sb.append("name: ").append(thread.getName()).append("\n");
                }
                sb.append("priority: ").append(thread.getPriority()).append("\n");
                ThreadGroup threadGroup = thread.getThreadGroup();
                if (threadGroup != null && (name = threadGroup.getName()) != null) {
                    sb.append("groupName: ").append(name).append("\n");
                }
                sb.append("state: ").append(thread.getState()).append("\n");
                sb.append("stacktrace: \n");
                StackTraceElement[] stackTrace = thread.getStackTrace();
                if (stackTrace != null && stackTrace.length > 0) {
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
                com.baidu.crabsdk.c.a.f("ThreadInfo Collector Interrupted!!", e);
            }
        }
        return sb.toString();
    }
}
