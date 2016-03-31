package com.baidu.tbadk.core.c;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private a Yf = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g Ys = new g();
    }

    public static g uO() {
        return c.Ys;
    }

    public void a(int i, k kVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.Yf = new a(i, kVar, null);
                this.Yf.uQ();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a Yf;
        private final List<Long> Yq = new ArrayList(240);
        private final List<Integer> Yr = new ArrayList(15);

        public b(a aVar) {
            this.Yf = aVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            if ("doFrame".equals(name)) {
                switch (parameterTypes.length) {
                    case 1:
                        if (parameterTypes[0] == Long.TYPE) {
                            t(((Long) objArr[0]).longValue());
                            return null;
                        }
                        return null;
                    default:
                        return null;
                }
            }
            return null;
        }

        private void t(long j) {
            this.Yq.add(Long.valueOf(j));
            this.Yf.uQ();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.Yf = null;
            this.Yq.clear();
            this.Yr.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final Class<?> Yg;
        private final Object Yh;
        private final Class<?> Yi;
        private final Method Yj;
        private final Object Yk;
        private final Method Yl;
        private final b Ym;
        private final int Yn;
        private final k Yo;
        private int index;

        private a(int i, k kVar) {
            this.index = 0;
            this.Yi = Class.forName("android.view.Choreographer");
            this.Yg = Class.forName("android.view.Choreographer$FrameCallback");
            this.Ym = new b(this);
            this.Yh = Proxy.newProxyInstance(this.Yg.getClassLoader(), new Class[]{this.Yg}, this.Ym);
            this.Yj = this.Yi.getMethod("getInstance", new Class[0]);
            this.Yk = this.Yj.invoke(null, new Object[0]);
            this.Yl = this.Yi.getMethod("postFrameCallback", this.Yg);
            this.Yn = i <= 0 ? 16 : i;
            this.Yo = kVar;
        }

        /* synthetic */ a(int i, k kVar, a aVar) {
            this(i, kVar);
        }

        private void uP() {
            this.Yl.invoke(this.Yk, this.Yh);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void uQ() {
            if (this.index >= this.Yn) {
                com.baidu.adp.lib.h.h.hx().post(new h(this));
                return;
            }
            this.index++;
            try {
                uP();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> uR() {
            return this.Ym.Yq;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.Ym.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> uS() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> uR = uR();
            int size = uR.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(uR.get(i2 + 1).longValue() - uR.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
