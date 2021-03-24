package com.baidu.crabsdk.lite.a;

import java.util.Map;
/* loaded from: classes2.dex */
public final class q {
    public static String a(Thread thread) {
        StringBuilder sb = new StringBuilder();
        if (thread != null) {
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
            if (thread.getThreadGroup() != null && thread.getThreadGroup().getName() != null) {
                sb.append("groupName: ");
                sb.append(thread.getThreadGroup().getName());
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
        }
        return sb.toString();
    }

    public static String b() {
        StringBuilder sb = new StringBuilder();
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces != null && allStackTraces.size() > 0) {
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                sb.append(a(entry.getKey()));
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
