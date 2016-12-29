package com.baidu.tbadk.core.c;

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
    private a Xn = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final h XA = new h();
    }

    public static h tA() {
        return c.XA;
    }

    public void a(int i, l lVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.Xn = new a(i, lVar, null);
                this.Xn.tC();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a Xn;
        private final List<Long> Xy = new ArrayList(240);
        private final List<Integer> Xz = new ArrayList(15);

        public b(a aVar) {
            this.Xn = aVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            if ("doFrame".equals(name)) {
                switch (parameterTypes.length) {
                    case 1:
                        if (parameterTypes[0] == Long.TYPE) {
                            p(((Long) objArr[0]).longValue());
                            return null;
                        }
                        return null;
                    default:
                        return null;
                }
            }
            return null;
        }

        private void p(long j) {
            this.Xy.add(Long.valueOf(j));
            this.Xn.tC();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.Xn = null;
            this.Xy.clear();
            this.Xz.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final Class<?> Xo;
        private final Object Xp;
        private final Class<?> Xq;
        private final Method Xr;
        private final Object Xs;
        private final Method Xt;
        private final b Xu;
        private final int Xv;
        private final l Xw;
        private int index;

        private a(int i, l lVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.Xq = Class.forName("android.view.Choreographer");
            this.Xo = Class.forName("android.view.Choreographer$FrameCallback");
            this.Xu = new b(this);
            this.Xp = Proxy.newProxyInstance(this.Xo.getClassLoader(), new Class[]{this.Xo}, this.Xu);
            this.Xr = this.Xq.getMethod("getInstance", new Class[0]);
            this.Xs = this.Xr.invoke(null, new Object[0]);
            this.Xt = this.Xq.getMethod("postFrameCallback", this.Xo);
            this.Xv = i <= 0 ? 16 : i;
            this.Xw = lVar;
        }

        /* synthetic */ a(int i, l lVar, a aVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this(i, lVar);
        }

        private void tB() throws InvocationTargetException, IllegalAccessException {
            this.Xt.invoke(this.Xs, this.Xp);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void tC() {
            if (this.index >= this.Xv) {
                com.baidu.adp.lib.h.h.eG().post(new i(this));
                return;
            }
            this.index++;
            try {
                tB();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> tD() {
            return this.Xu.Xy;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.Xu.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> tE() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> tD = tD();
            int size = tD.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(tD.get(i2 + 1).longValue() - tD.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
