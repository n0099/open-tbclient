package com.baidu.fsg.base.restnet.rest;

import com.baidu.fsg.base.restnet.RestRequestCallbacker;
import com.baidu.fsg.base.restnet.http.HttpStatus;
import com.baidu.fsg.base.utils.LogUtil;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;
/* loaded from: classes2.dex */
public class c implements b {
    public static final int a = 30000;
    public static final int b = 30000;
    public static final int c = 10;
    public static final int d = 10;
    public static final int e = 8192;
    public static final int f = 3;
    public static final int g = 1000;
    public static final String h = "RestHttpNetwork";
    protected final b i;
    protected final g j = new g(3, 1000);

    public c(b bVar) {
        this.i = bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005e A[LOOP:0: B:3:0x000d->B:19:0x005e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c7 A[SYNTHETIC] */
    @Override // com.baidu.fsg.base.restnet.rest.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e a(d dVar) throws Exception {
        Exception exc;
        int i;
        boolean z;
        Exception exc2 = null;
        String k = dVar.k();
        RestRequestCallbacker.IRestRequestCallback requestCallback = RestRequestCallbacker.getRequestCallback();
        int i2 = 0;
        boolean z2 = true;
        while (z2) {
            try {
                e a2 = this.i.a(dVar);
                if (a2 != null && a2.e() == HttpStatus.OK && requestCallback != null) {
                    requestCallback.onSuccess(dVar.k(), dVar.d());
                }
                return a2;
            } catch (NullPointerException e2) {
                Exception nullPointerException = new NullPointerException("NPE in HttpClient: " + e2.getMessage());
                i = i2 + 1;
                z2 = this.j.a(nullPointerException, i);
                exc = nullPointerException;
                if (!z2) {
                    if (requestCallback != null) {
                        LogUtil.errord(h, "RestHttpNetwork performRequest retry count:" + i + " failure, url:" + dVar.d() + ", origUrl:" + k);
                        throw exc;
                    }
                    throw exc;
                }
                int i3 = i;
                exc2 = exc;
                i2 = i3;
            } catch (UnknownHostException e3) {
                Exception unknownHostException = new UnknownHostException("UnknownHostException exception: " + e3.getMessage());
                if (i2 > 0) {
                    i2++;
                    if (this.j.a(e3, i2)) {
                        i = i2;
                        z = true;
                        z2 = z;
                        exc = unknownHostException;
                        if (!z2) {
                        }
                    }
                }
                i = i2;
                z = false;
                z2 = z;
                exc = unknownHostException;
                if (!z2) {
                }
            } catch (IOException e4) {
                int i4 = i2 + 1;
                z2 = this.j.a(e4, i4);
                exc = e4;
                i = i4;
                if (!z2) {
                }
            } catch (TimeoutException e5) {
                Exception timeoutException = new TimeoutException("TimeoutException exception: " + e5.getMessage());
                int i5 = i2 + 1;
                boolean a3 = this.j.a(e5, i5);
                exc = timeoutException;
                z2 = a3;
                i = i5;
                if (!z2) {
                }
            }
        }
        throw exc2;
    }

    @Override // com.baidu.fsg.base.restnet.rest.b
    public void a() {
        this.i.a();
    }
}
