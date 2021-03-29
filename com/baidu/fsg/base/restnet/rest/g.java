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
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5244a = "g";

    /* renamed from: b  reason: collision with root package name */
    public static final HashSet<Class<?>> f5245b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    public static final HashSet<Class<?>> f5246c = new HashSet<>();

    /* renamed from: d  reason: collision with root package name */
    public final int f5247d;

    /* renamed from: e  reason: collision with root package name */
    public final int f5248e;

    static {
        f5245b.add(UnknownHostException.class);
        f5245b.add(SocketException.class);
        f5245b.add(ProtocolException.class);
        f5246c.add(SSLException.class);
        f5246c.add(SocketTimeoutException.class);
    }

    public g(int i, int i2) {
        this.f5247d = i;
        this.f5248e = i2;
    }

    public boolean a(Exception exc, int i) {
        boolean z = false;
        if (i <= this.f5247d && (a(f5245b, exc) || !a(f5246c, exc))) {
            z = true;
        }
        String str = f5244a;
        LogUtil.d(str, f5244a + " retryRequest is called ,retry flag is " + z);
        if (z) {
            SystemClock.sleep(this.f5248e);
        } else {
            exc.printStackTrace();
        }
        return z;
    }

    public boolean a(HashSet<Class<?>> hashSet, Throwable th) {
        Iterator<Class<?>> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().isInstance(th)) {
                return true;
            }
        }
        return false;
    }
}
