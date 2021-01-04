package com.baidu.fsg.base.restnet.rest;

import android.os.SystemClock;
import com.baidu.fsg.base.utils.LogUtil;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import javax.net.ssl.SSLException;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1966a = g.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final HashSet<Class<?>> f1967b = new HashSet<>();
    private static final HashSet<Class<?>> c = new HashSet<>();
    private final int d;
    private final int e;

    static {
        f1967b.add(UnknownHostException.class);
        f1967b.add(SocketException.class);
        f1967b.add(ProtocolException.class);
        c.add(SSLException.class);
        c.add(SocketTimeoutException.class);
    }

    public g(int i, int i2) {
        this.d = i;
        this.e = i2;
    }

    public boolean a(Exception exc, int i) {
        boolean z = false;
        if (i <= this.d) {
            if (a(f1967b, exc)) {
                z = true;
            } else if (!a(c, exc)) {
                z = true;
            }
        }
        LogUtil.d(f1966a, f1966a + " retryRequest is called ,retry flag is " + z);
        if (z) {
            SystemClock.sleep(this.e);
        } else {
            exc.printStackTrace();
        }
        return z;
    }

    protected boolean a(HashSet<Class<?>> hashSet, Throwable th) {
        Iterator<Class<?>> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().isInstance(th)) {
                return true;
            }
        }
        return false;
    }
}
