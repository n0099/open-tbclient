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
    public static final String f5279a = "g";

    /* renamed from: b  reason: collision with root package name */
    public static final HashSet<Class<?>> f5280b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    public static final HashSet<Class<?>> f5281c = new HashSet<>();

    /* renamed from: d  reason: collision with root package name */
    public final int f5282d;

    /* renamed from: e  reason: collision with root package name */
    public final int f5283e;

    static {
        f5280b.add(UnknownHostException.class);
        f5280b.add(SocketException.class);
        f5280b.add(ProtocolException.class);
        f5281c.add(SSLException.class);
        f5281c.add(SocketTimeoutException.class);
    }

    public g(int i, int i2) {
        this.f5282d = i;
        this.f5283e = i2;
    }

    public boolean a(Exception exc, int i) {
        boolean z = false;
        if (i <= this.f5282d && (a(f5280b, exc) || !a(f5281c, exc))) {
            z = true;
        }
        String str = f5279a;
        LogUtil.d(str, f5279a + " retryRequest is called ,retry flag is " + z);
        if (z) {
            SystemClock.sleep(this.f5283e);
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
