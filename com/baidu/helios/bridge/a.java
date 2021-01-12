package com.baidu.helios.bridge;

import android.content.Context;
import android.os.Bundle;
import com.baidu.helios.channels.b;
import com.baidu.helios.ids.b;
import java.util.concurrent.ExecutorService;
/* loaded from: classes14.dex */
public abstract class a {
    protected C0121a arq;
    protected b arr;

    /* renamed from: com.baidu.helios.bridge.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static class C0121a {
        public Context applicationContext;
        public b.a ars;
        public b.a art;
        public ExecutorService aru;
        public ExecutorService arv;
    }

    /* loaded from: classes14.dex */
    public static class b {
    }

    /* loaded from: classes14.dex */
    public interface c<T> {
        void a(int i, Exception exc, Bundle bundle);

        void a(T t, Bundle bundle);
    }

    /* loaded from: classes14.dex */
    public static class d {
        public int errCode;
        public Exception exception;
        public String id;

        public d() {
        }

        public d(int i, String str, Exception exc) {
            this.errCode = i;
            this.id = str;
            this.exception = exc;
        }

        public static d d(int i, Exception exc) {
            d dVar = new d();
            dVar.errCode = i;
            dVar.exception = exc;
            return dVar;
        }

        public static d dV(String str) {
            d dVar = new d();
            dVar.errCode = 0;
            dVar.id = str;
            return dVar;
        }

        public boolean isSuccess() {
            return this.errCode == 0;
        }
    }

    public void a(C0121a c0121a) {
        this.arq = c0121a;
    }

    public void a(b bVar) {
        this.arr = bVar;
        b(bVar);
    }

    public abstract void a(String str, Bundle bundle, c<String> cVar);

    public abstract void b(b bVar);

    public abstract d d(String str, Bundle bundle);

    public abstract boolean dU(String str);
}
