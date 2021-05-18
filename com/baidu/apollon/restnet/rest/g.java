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
    public static final String f3865a = "g";

    /* renamed from: b  reason: collision with root package name */
    public static final HashSet<Class<?>> f3866b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    public static final HashSet<Class<?>> f3867c = new HashSet<>();

    /* renamed from: d  reason: collision with root package name */
    public final int f3868d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3869e;

    static {
        f3866b.add(UnknownHostException.class);
        f3866b.add(SocketException.class);
        f3866b.add(ProtocolException.class);
        f3867c.add(SSLException.class);
        f3867c.add(SocketTimeoutException.class);
    }

    public g(int i2, int i3) {
        this.f3868d = i2;
        this.f3869e = i3;
    }

    public boolean a(Exception exc, int i2) {
        boolean z = false;
        if (i2 <= this.f3868d && (a(f3866b, exc) || !a(f3867c, exc))) {
            z = true;
        }
        String str = f3865a;
        LogUtil.d(str, f3865a + " retryRequest is called ,retry flag is " + z);
        if (z) {
            SystemClock.sleep(this.f3869e);
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
