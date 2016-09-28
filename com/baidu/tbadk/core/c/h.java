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
    private a Xv = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final h XI = new h();
    }

    public static h tL() {
        return c.XI;
    }

    public void a(int i, l lVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.Xv = new a(i, lVar, null);
                this.Xv.tN();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        private final List<Long> XG = new ArrayList(240);
        private final List<Integer> XH = new ArrayList(15);
        protected a Xv;

        public b(a aVar) {
            this.Xv = aVar;
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
            this.XG.add(Long.valueOf(j));
            this.Xv.tN();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.Xv = null;
            this.XG.clear();
            this.XH.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final Object XA;
        private final Method XB;
        private final b XC;
        private final int XD;
        private final l XE;
        private final Class<?> Xw;
        private final Object Xx;
        private final Class<?> Xy;
        private final Method Xz;
        private int index;

        private a(int i, l lVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.Xy = Class.forName("android.view.Choreographer");
            this.Xw = Class.forName("android.view.Choreographer$FrameCallback");
            this.XC = new b(this);
            this.Xx = Proxy.newProxyInstance(this.Xw.getClassLoader(), new Class[]{this.Xw}, this.XC);
            this.Xz = this.Xy.getMethod("getInstance", new Class[0]);
            this.XA = this.Xz.invoke(null, new Object[0]);
            this.XB = this.Xy.getMethod("postFrameCallback", this.Xw);
            this.XD = i <= 0 ? 16 : i;
            this.XE = lVar;
        }

        /* synthetic */ a(int i, l lVar, a aVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this(i, lVar);
        }

        private void tM() throws InvocationTargetException, IllegalAccessException {
            this.XB.invoke(this.XA, this.Xx);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void tN() {
            if (this.index >= this.XD) {
                com.baidu.adp.lib.h.h.eG().post(new i(this));
                return;
            }
            this.index++;
            try {
                tM();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> tO() {
            return this.XC.XG;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.XC.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> tP() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> tO = tO();
            int size = tO.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(tO.get(i2 + 1).longValue() - tO.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
