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
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5243a = "g";

    /* renamed from: b  reason: collision with root package name */
    public static final HashSet<Class<?>> f5244b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    public static final HashSet<Class<?>> f5245c = new HashSet<>();

    /* renamed from: d  reason: collision with root package name */
    public final int f5246d;

    /* renamed from: e  reason: collision with root package name */
    public final int f5247e;

    static {
        f5244b.add(UnknownHostException.class);
        f5244b.add(SocketException.class);
        f5244b.add(ProtocolException.class);
        f5245c.add(SSLException.class);
        f5245c.add(SocketTimeoutException.class);
    }

    public g(int i, int i2) {
        this.f5246d = i;
        this.f5247e = i2;
    }

    public boolean a(Exception exc, int i) {
        boolean z = false;
        if (i <= this.f5246d && (a(f5244b, exc) || !a(f5245c, exc))) {
            z = true;
        }
        String str = f5243a;
        LogUtil.d(str, f5243a + " retryRequest is called ,retry flag is " + z);
        if (z) {
            SystemClock.sleep(this.f5247e);
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
