package com.baidu.crabsdk.b;

import java.util.Map;
/* loaded from: classes2.dex */
public final class s {
    public static String a() {
        StringBuilder sb = new StringBuilder();
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces != null && allStackTraces.size() > 0) {
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                sb.append(b(entry.getKey()));
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static String b(Thread thread) {
        String name;
        StringBuilder sb = new StringBuilder();
        if (thread != null) {
            try {
                sb.append("threadId： ");
                sb.append(thread.getId());
                sb.append("\n");
                if (thread.getName() != null) {
                    sb.append("name: ");
                    sb.append(thread.getName());
                    sb.append("\n");
                }
                sb.append("priority: ");
                sb.append(thread.getPriority());
                sb.append("\n");
                ThreadGroup threadGroup = thread.getThreadGroup();
                if (threadGroup != null && (name = threadGroup.getName()) != null) {
                    sb.append("groupName: ");
                    sb.append(name);
                    sb.append("\n");
                }
                sb.append("state: ");
                sb.append(thread.getState());
                sb.append("\n");
                sb.append("stacktrace: \n");
                StackTraceElement[] stackTrace = thread.getStackTrace();
                if (stackTrace != null && stackTrace.length > 0) {
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        String methodName = stackTraceElement.getMethodName();
                        String str = "unknown";
                        if (methodName == null) {
                            methodName = "unknown";
                        }
                        sb.append("\tat ");
                        sb.append(methodName);
                        sb.append("(");
                        String fileName = stackTraceElement.getFileName();
                        if (fileName != null) {
                            str = fileName;
                        }
                        sb.append(str);
                        sb.append(":");
                        sb.append(stackTraceElement.getLineNumber());
                        sb.append(")\n");
                    }
                }
            } catch (Exception e2) {
                com.baidu.crabsdk.c.a.a("ThreadInfo Collector Interrupted!!", e2);
            }
        }
        return sb.toString();
    }

    public static String c(Thread thread) {
        StringBuilder sb = new StringBuilder();
        if (thread != null) {
            try {
                StackTraceElement[] stackTrace = thread.getStackTrace();
                if (stackTrace != null && stackTrace.length > 0) {
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        sb.append("at ");
                        sb.append(stackTraceElement.toString() + "\n");
                    }
                }
            } catch (Exception e2) {
                com.baidu.crabsdk.c.a.a("ThreadInfo Collector Interrupted!!", e2);
            }
        }
        return sb.toString();
    }

    public static String d(Thread thread) {
        StringBuilder sb = new StringBuilder();
        if (thread != null) {
            try {
                StackTraceElement[] stackTrace = thread.getStackTrace();
                if (stackTrace != null && stackTrace.length > 0) {
                    sb.append(stackTrace[0]);
                }
            } catch (Exception e2) {
                com.baidu.crabsdk.c.a.a("ThreadInfo Collector Interrupted!!", e2);
            }
        }
        return sb.toString();
    }

    public static Thread e(String str) {
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces == null || allStackTraces.size() <= 0) {
            return null;
        }
        for (Thread thread : allStackTraces.keySet()) {
            if (thread.getName().equals(str)) {
                return thread;
            }
        }
        return null;
    }
}
