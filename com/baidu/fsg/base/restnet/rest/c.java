package com.baidu.fsg.base.restnet.rest;

import com.baidu.fsg.base.restnet.RestRequestCallbacker;
import com.baidu.fsg.base.restnet.http.HttpStatus;
import com.baidu.fsg.base.utils.LogUtil;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;
/* loaded from: classes5.dex */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final int f1911a = 30000;

    /* renamed from: b  reason: collision with root package name */
    public static final int f1912b = 30000;
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

    /* JADX WARN: Removed duplicated region for block: B:19:0x005b A[LOOP:0: B:3:0x000d->B:19:0x005b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b8 A[SYNTHETIC] */
    @Override // com.baidu.fsg.base.restnet.rest.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e a(d dVar) throws Exception {
        Exception timeoutException;
        boolean z;
        Exception exc = null;
        String k = dVar.k();
        RestRequestCallbacker.IRestRequestCallback requestCallback = RestRequestCallbacker.getRequestCallback();
        int i = 0;
        boolean z2 = true;
        while (z2) {
            try {
                e a2 = this.i.a(dVar);
                if (a2 != null && a2.e() == HttpStatus.OK && requestCallback != null) {
                    requestCallback.onSuccess(dVar.k(), dVar.d());
                }
                return a2;
            } catch (IOException e2) {
                i++;
                z2 = this.j.a(e2, i);
                timeoutException = e2;
                if (!z2) {
                    if (requestCallback != null) {
                        LogUtil.errord(h, "RestHttpNetwork performRequest retry count:" + i + " failure, url:" + dVar.d() + ", origUrl:" + k);
                        throw timeoutException;
                    }
                    throw timeoutException;
                }
                exc = timeoutException;
            } catch (NullPointerException e3) {
                timeoutException = new NullPointerException("NPE in HttpClient: " + e3.getMessage());
                i++;
                z2 = this.j.a(timeoutException, i);
                if (!z2) {
                }
            } catch (UnknownHostException e4) {
                timeoutException = new UnknownHostException("UnknownHostException exception: " + e4.getMessage());
                if (i > 0) {
                    i++;
                    if (this.j.a(e4, i)) {
                        z = true;
                        z2 = z;
                        if (!z2) {
                        }
                    }
                }
                z = false;
                z2 = z;
                if (!z2) {
                }
            } catch (TimeoutException e5) {
                timeoutException = new TimeoutException("TimeoutException exception: " + e5.getMessage());
                i++;
                z2 = this.j.a(e5, i);
                if (!z2) {
                }
            }
        }
        throw exc;
    }

    @Override // com.baidu.fsg.base.restnet.rest.b
    public void a() {
        this.i.a();
    }
}
