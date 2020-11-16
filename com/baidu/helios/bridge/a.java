package com.baidu.helios.bridge;

import android.content.Context;
import android.os.Bundle;
import com.baidu.helios.channels.b;
import com.baidu.helios.ids.b;
import java.util.concurrent.ExecutorService;
/* loaded from: classes17.dex */
public abstract class a {
    protected C0139a auH;
    protected b auI;

    /* renamed from: com.baidu.helios.bridge.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static class C0139a {
        public Context applicationContext;
        public b.a auJ;
        public b.a auK;
        public ExecutorService auL;
        public ExecutorService auM;
    }

    /* loaded from: classes17.dex */
    public static class b {
    }

    /* loaded from: classes17.dex */
    public interface c<T> {
        void a(int i, Exception exc, Bundle bundle);

        void a(T t, Bundle bundle);
    }

    /* loaded from: classes17.dex */
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

        public static d fs(String str) {
            d dVar = new d();
            dVar.errCode = 0;
            dVar.id = str;
            return dVar;
        }

        public boolean isSuccess() {
            return this.errCode == 0;
        }
    }

    public void a(C0139a c0139a) {
        this.auH = c0139a;
    }

    public void a(b bVar) {
        this.auI = bVar;
        b(bVar);
    }

    public abstract void a(String str, Bundle bundle, c<String> cVar);

    public abstract void b(b bVar);

    public abstract d c(String str, Bundle bundle);

    public abstract boolean fr(String str);
}
