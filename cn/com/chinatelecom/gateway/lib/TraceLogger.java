package cn.com.chinatelecom.gateway.lib;
/* loaded from: classes4.dex */
public interface TraceLogger {
    void debug(String str, String str2);

    void error(String str, String str2, Throwable th);

    void info(String str, String str2);

    void verbose(String str, String str2);

    void warn(String str, String str2, Throwable th);
}
