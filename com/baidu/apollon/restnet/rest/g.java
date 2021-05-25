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
    public static final String f3868a = "g";

    /* renamed from: b  reason: collision with root package name */
    public static final HashSet<Class<?>> f3869b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    public static final HashSet<Class<?>> f3870c = new HashSet<>();

    /* renamed from: d  reason: collision with root package name */
    public final int f3871d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3872e;

    static {
        f3869b.add(UnknownHostException.class);
        f3869b.add(SocketException.class);
        f3869b.add(ProtocolException.class);
        f3870c.add(SSLException.class);
        f3870c.add(SocketTimeoutException.class);
    }

    public g(int i2, int i3) {
        this.f3871d = i2;
        this.f3872e = i3;
    }

    public boolean a(Exception exc, int i2) {
        boolean z = false;
        if (i2 <= this.f3871d && (a(f3869b, exc) || !a(f3870c, exc))) {
            z = true;
        }
        String str = f3868a;
        LogUtil.d(str, f3868a + " retryRequest is called ,retry flag is " + z);
        if (z) {
            SystemClock.sleep(this.f3872e);
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
