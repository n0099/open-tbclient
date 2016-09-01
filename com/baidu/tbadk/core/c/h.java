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
    private a Xi = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final h Xv = new h();
    }

    public static h tw() {
        return c.Xv;
    }

    public void a(int i, l lVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.Xi = new a(i, lVar, null);
                this.Xi.ty();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a Xi;
        private final List<Long> Xt = new ArrayList(240);
        private final List<Integer> Xu = new ArrayList(15);

        public b(a aVar) {
            this.Xi = aVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            if ("doFrame".equals(name)) {
                switch (parameterTypes.length) {
                    case 1:
                        if (parameterTypes[0] == Long.TYPE) {
                            q(((Long) objArr[0]).longValue());
                            return null;
                        }
                        return null;
                    default:
                        return null;
                }
            }
            return null;
        }

        private void q(long j) {
            this.Xt.add(Long.valueOf(j));
            this.Xi.ty();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.Xi = null;
            this.Xt.clear();
            this.Xu.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final Class<?> Xj;
        private final Object Xk;
        private final Class<?> Xl;
        private final Method Xm;
        private final Object Xn;
        private final Method Xo;
        private final b Xp;
        private final int Xq;
        private final l Xr;
        private int index;

        private a(int i, l lVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.Xl = Class.forName("android.view.Choreographer");
            this.Xj = Class.forName("android.view.Choreographer$FrameCallback");
            this.Xp = new b(this);
            this.Xk = Proxy.newProxyInstance(this.Xj.getClassLoader(), new Class[]{this.Xj}, this.Xp);
            this.Xm = this.Xl.getMethod("getInstance", new Class[0]);
            this.Xn = this.Xm.invoke(null, new Object[0]);
            this.Xo = this.Xl.getMethod("postFrameCallback", this.Xj);
            this.Xq = i <= 0 ? 16 : i;
            this.Xr = lVar;
        }

        /* synthetic */ a(int i, l lVar, a aVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this(i, lVar);
        }

        private void tx() throws InvocationTargetException, IllegalAccessException {
            this.Xo.invoke(this.Xn, this.Xk);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ty() {
            if (this.index >= this.Xq) {
                com.baidu.adp.lib.h.h.eG().post(new i(this));
                return;
            }
            this.index++;
            try {
                tx();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> tz() {
            return this.Xp.Xt;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.Xp.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> tA() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> tz = tz();
            int size = tz.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(tz.get(i2 + 1).longValue() - tz.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
