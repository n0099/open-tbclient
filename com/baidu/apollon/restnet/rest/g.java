package com.baidu.apollon.restnet.rest;

import android.os.SystemClock;
import com.baidu.apollon.utils.LogUtil;
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
    public static final String f3778a = "g";

    /* renamed from: b  reason: collision with root package name */
    public static final HashSet<Class<?>> f3779b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    public static final HashSet<Class<?>> f3780c = new HashSet<>();

    /* renamed from: d  reason: collision with root package name */
    public final int f3781d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3782e;

    static {
        f3779b.add(UnknownHostException.class);
        f3779b.add(SocketException.class);
        f3779b.add(ProtocolException.class);
        f3780c.add(SSLException.class);
        f3780c.add(SocketTimeoutException.class);
    }

    public g(int i, int i2) {
        this.f3781d = i;
        this.f3782e = i2;
    }

    public boolean a(Exception exc, int i) {
        boolean z = false;
        if (i <= this.f3781d && (a(f3779b, exc) || !a(f3780c, exc))) {
            z = true;
        }
        String str = f3778a;
        LogUtil.d(str, f3778a + " retryRequest is called ,retry flag is " + z);
        if (z) {
            SystemClock.sleep(this.f3782e);
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
