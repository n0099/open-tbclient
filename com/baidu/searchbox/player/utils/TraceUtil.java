package com.baidu.searchbox.player.utils;

import com.baidu.searchbox.player.model.BasicVideoSeries;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a\f\u0010\u0004\u001a\u00020\u0001*\u0004\u0018\u00010\u0005\u001a\f\u0010\u0006\u001a\u00020\u0001*\u0004\u0018\u00010\u0005\u001a\f\u0010\u0007\u001a\u00020\u0001*\u0004\u0018\u00010\u0005\u001a\u0016\u0010\b\u001a\u00020\t*\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0001\u001a\u0016\u0010\u000b\u001a\u00020\t*\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0001\u001a\u0016\u0010\r\u001a\u00020\t*\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"LOG_ID", "", "SESSION_ID", "TRACE_ID", "getLogId", "Lcom/baidu/searchbox/player/model/BasicVideoSeries;", "getSessionId", "getTraceId", "setLogId", "", "logId", "setSessionId", "sessionId", "setTraceId", "traceId", "bdvideoplayer-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "TraceUtil")
/* loaded from: classes4.dex */
public final class TraceUtil {
    public static final String LOG_ID = "log_id";
    public static final String SESSION_ID = "session_id";
    public static final String TRACE_ID = "trace_id";

    public static final String getLogId(BasicVideoSeries basicVideoSeries) {
        String str;
        if (basicVideoSeries != null) {
            Object obj = basicVideoSeries.getExtMap().get("log_id");
            if (!(obj instanceof String)) {
                obj = "";
            }
            str = (String) obj;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static final String getSessionId(BasicVideoSeries basicVideoSeries) {
        String str;
        if (basicVideoSeries != null) {
            Object obj = basicVideoSeries.getExtMap().get("session_id");
            if (!(obj instanceof String)) {
                obj = "";
            }
            str = (String) obj;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static final String getTraceId(BasicVideoSeries basicVideoSeries) {
        String str;
        if (basicVideoSeries != null) {
            Object obj = basicVideoSeries.getExtMap().get("trace_id");
            if (!(obj instanceof String)) {
                obj = "";
            }
            str = (String) obj;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static final void setLogId(BasicVideoSeries basicVideoSeries, String str) {
        if (basicVideoSeries != null) {
            if (str == null) {
                str = "";
            }
            basicVideoSeries.set("log_id", str);
        }
    }

    public static final void setSessionId(BasicVideoSeries basicVideoSeries, String str) {
        if (basicVideoSeries != null) {
            if (str == null) {
                str = "";
            }
            basicVideoSeries.set("session_id", str);
        }
    }

    public static final void setTraceId(BasicVideoSeries basicVideoSeries, String str) {
        if (basicVideoSeries != null) {
            if (str == null) {
                str = "";
            }
            basicVideoSeries.set("trace_id", str);
        }
    }
}
