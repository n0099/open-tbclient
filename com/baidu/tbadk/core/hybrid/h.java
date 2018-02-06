package com.baidu.tbadk.core.hybrid;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private a aTf = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final h aTr = new h();
    }

    public static h Bs() {
        return c.aTr;
    }

    public void a(int i, k kVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.aTf = new a(i, kVar);
                this.aTf.Bu();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a aTf;
        private final List<Long> aTp = new ArrayList(240);
        private final List<Integer> aTq = new ArrayList(15);

        public b(a aVar) {
            this.aTf = aVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            if ("doFrame".equals(name)) {
                switch (parameterTypes.length) {
                    case 1:
                        if (parameterTypes[0] == Long.TYPE) {
                            doFrame(((Long) objArr[0]).longValue());
                            return null;
                        }
                        return null;
                    default:
                        return null;
                }
            }
            return null;
        }

        private void doFrame(long j) {
            this.aTp.add(Long.valueOf(j));
            this.aTf.Bu();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.aTf = null;
            this.aTp.clear();
            this.aTq.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> aTg;
        private final Object aTh;
        private final Class<?> aTi;
        private final Method aTj;
        private final Object aTk;
        private final Method aTl;
        private final b aTm;
        private final k aTn;
        private int index;

        private a(int i, k kVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.aTi = Class.forName("android.view.Choreographer");
            this.aTg = Class.forName("android.view.Choreographer$FrameCallback");
            this.aTm = new b(this);
            this.aTh = Proxy.newProxyInstance(this.aTg.getClassLoader(), new Class[]{this.aTg}, this.aTm);
            this.aTj = this.aTi.getMethod("getInstance", new Class[0]);
            this.aTk = this.aTj.invoke(null, new Object[0]);
            this.aTl = this.aTi.getMethod("postFrameCallback", this.aTg);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.aTn = kVar;
        }

        private void Bt() throws InvocationTargetException, IllegalAccessException {
            this.aTl.invoke(this.aTk, this.aTh);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Bu() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.h.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.aTn.z(a.this.Bw());
                        a.this.aTm.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                Bt();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> Bv() {
            return this.aTm.aTp;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.aTm.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> Bw() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> Bv = Bv();
            int size = Bv.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(Bv.get(i2 + 1).longValue() - Bv.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
