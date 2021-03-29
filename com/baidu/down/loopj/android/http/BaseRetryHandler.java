package com.baidu.down.loopj.android.http;

import com.baidu.down.loopj.android.http.exp.IntercepterException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.http.conn.ConnectTimeoutException;
/* loaded from: classes.dex */
public class BaseRetryHandler {
    public static final boolean DEBUG = false;
    public static final String TAG = "BaseRetryHandler";
    public final long[] retryIntervals;
    public static HashSet<Class<?>> exceptionWhitelist = new HashSet<>();
    public static HashSet<Class<?>> exceptionBlacklist = new HashSet<>();

    static {
        exceptionWhitelist.add(UnknownHostException.class);
        exceptionWhitelist.add(SocketException.class);
        exceptionWhitelist.add(SocketTimeoutException.class);
        exceptionWhitelist.add(ConnectTimeoutException.class);
        exceptionBlacklist.add(IntercepterException.class);
    }

    public BaseRetryHandler(long[] jArr) {
        this.retryIntervals = jArr;
    }

    public boolean isInList(HashSet<Class<?>> hashSet, Throwable th) {
        Iterator<Class<?>> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().isInstance(th)) {
                return true;
            }
        }
        return false;
    }
}
