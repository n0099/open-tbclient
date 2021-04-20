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
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3814a = "g";

    /* renamed from: b  reason: collision with root package name */
    public static final HashSet<Class<?>> f3815b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    public static final HashSet<Class<?>> f3816c = new HashSet<>();

    /* renamed from: d  reason: collision with root package name */
    public final int f3817d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3818e;

    static {
        f3815b.add(UnknownHostException.class);
        f3815b.add(SocketException.class);
        f3815b.add(ProtocolException.class);
        f3816c.add(SSLException.class);
        f3816c.add(SocketTimeoutException.class);
    }

    public g(int i, int i2) {
        this.f3817d = i;
        this.f3818e = i2;
    }

    public boolean a(Exception exc, int i) {
        boolean z = false;
        if (i <= this.f3817d && (a(f3815b, exc) || !a(f3816c, exc))) {
            z = true;
        }
        String str = f3814a;
        LogUtil.d(str, f3814a + " retryRequest is called ,retry flag is " + z);
        if (z) {
            SystemClock.sleep(this.f3818e);
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
