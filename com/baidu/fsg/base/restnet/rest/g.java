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
    public static final String f5413a = "g";

    /* renamed from: b  reason: collision with root package name */
    public static final HashSet<Class<?>> f5414b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    public static final HashSet<Class<?>> f5415c = new HashSet<>();

    /* renamed from: d  reason: collision with root package name */
    public final int f5416d;

    /* renamed from: e  reason: collision with root package name */
    public final int f5417e;

    static {
        f5414b.add(UnknownHostException.class);
        f5414b.add(SocketException.class);
        f5414b.add(ProtocolException.class);
        f5415c.add(SSLException.class);
        f5415c.add(SocketTimeoutException.class);
    }

    public g(int i2, int i3) {
        this.f5416d = i2;
        this.f5417e = i3;
    }

    public boolean a(Exception exc, int i2) {
        boolean z = false;
        if (i2 <= this.f5416d && (a(f5414b, exc) || !a(f5415c, exc))) {
            z = true;
        }
        String str = f5413a;
        LogUtil.d(str, f5413a + " retryRequest is called ,retry flag is " + z);
        if (z) {
            SystemClock.sleep(this.f5417e);
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
