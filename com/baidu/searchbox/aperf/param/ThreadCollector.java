package com.baidu.searchbox.aperf.param;

import android.os.Looper;
import android.util.Log;
import com.android.internal.http.multipart.Part;
import java.util.Map;
/* loaded from: classes2.dex */
public class ThreadCollector {
    public static String getAllThreadStacks() {
        StringBuilder sb = new StringBuilder();
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces != null && allStackTraces.size() >= 1) {
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                sb.append(getThreadInfo(entry.getKey()));
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static String getMainThreadStackTrace() {
        return getThreadStack(Looper.getMainLooper().getThread());
    }

    public static String getThreadInfo(Thread thread) {
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
                sb.append("state: ");
                sb.append(thread.getState());
                sb.append("\n");
                sb.append("stacktrace: \n");
                StackTraceElement[] stackTrace = thread.getStackTrace();
                if (stackTrace != null && stackTrace.length >= 1) {
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
                Log.e("ThreadCollector", "ThreadInfo Collector Interrupted!!", e2);
            }
        }
        return sb.toString();
    }

    public static String getThreadStack(Thread thread) {
        StringBuilder sb = new StringBuilder();
        if (thread != null) {
            try {
                StackTraceElement[] stackTrace = thread.getStackTrace();
                if (stackTrace != null && stackTrace.length >= 1) {
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        sb.append(stackTraceElement.toString() + Part.CRLF);
                    }
                }
            } catch (Exception e2) {
                Log.e("ThreadCollector", "ThreadInfo Collector Interrupted!!", e2);
            }
        }
        return sb.toString();
    }
}
