package com.baidu.down.loopj.android.http;

import com.baidu.down.loopj.android.http.exp.IntercepterException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.http.conn.ConnectTimeoutException;
/* loaded from: classes5.dex */
public class BaseRetryHandler {
    protected static final boolean DEBUG = false;
    protected final long[] retryIntervals;
    protected static final String TAG = BaseRetryHandler.class.getSimpleName();
    protected static HashSet<Class<?>> exceptionWhitelist = new HashSet<>();
    protected static HashSet<Class<?>> exceptionBlacklist = new HashSet<>();

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

    /* JADX INFO: Access modifiers changed from: protected */
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
