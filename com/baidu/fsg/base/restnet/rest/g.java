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
    public static final String f5210a = "g";

    /* renamed from: b  reason: collision with root package name */
    public static final HashSet<Class<?>> f5211b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    public static final HashSet<Class<?>> f5212c = new HashSet<>();

    /* renamed from: d  reason: collision with root package name */
    public final int f5213d;

    /* renamed from: e  reason: collision with root package name */
    public final int f5214e;

    static {
        f5211b.add(UnknownHostException.class);
        f5211b.add(SocketException.class);
        f5211b.add(ProtocolException.class);
        f5212c.add(SSLException.class);
        f5212c.add(SocketTimeoutException.class);
    }

    public g(int i2, int i3) {
        this.f5213d = i2;
        this.f5214e = i3;
    }

    public boolean a(Exception exc, int i2) {
        boolean z = false;
        if (i2 <= this.f5213d && (a(f5211b, exc) || !a(f5212c, exc))) {
            z = true;
        }
        String str = f5210a;
        LogUtil.d(str, f5210a + " retryRequest is called ,retry flag is " + z);
        if (z) {
            SystemClock.sleep(this.f5214e);
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
