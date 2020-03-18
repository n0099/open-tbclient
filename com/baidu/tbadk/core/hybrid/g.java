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
public class g {
    private a cWW = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g cXj = new g();
    }

    public static g aFk() {
        return c.cXj;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.cWW = new a(i, jVar);
                this.cWW.aFl();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a cWW;
        private final List<Long> cXh = new ArrayList(240);
        private final List<Integer> cXi = new ArrayList(15);

        public b(a aVar) {
            this.cWW = aVar;
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
            this.cXh.add(Long.valueOf(j));
            this.cWW.aFl();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.cWW = null;
            this.cXh.clear();
            this.cXi.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final Class<?> cWX;
        private final Object cWY;
        private final Class<?> cWZ;
        private final Method cXa;
        private final Object cXb;
        private final Method cXc;
        private final b cXd;
        private final int cXe;
        private final j cXf;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.cWZ = Class.forName("android.view.Choreographer");
            this.cWX = Class.forName("android.view.Choreographer$FrameCallback");
            this.cXd = new b(this);
            this.cWY = Proxy.newProxyInstance(this.cWX.getClassLoader(), new Class[]{this.cWX}, this.cXd);
            this.cXa = this.cWZ.getMethod("getInstance", new Class[0]);
            this.cXb = this.cXa.invoke(null, new Object[0]);
            this.cXc = this.cWZ.getMethod("postFrameCallback", this.cWX);
            this.cXe = i <= 0 ? 16 : i;
            this.cXf = jVar;
        }

        private void dI() throws InvocationTargetException, IllegalAccessException {
            this.cXc.invoke(this.cXb, this.cWY);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aFl() {
            if (this.index >= this.cXe) {
                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cXf.aA(a.this.aFn());
                        a.this.cXd.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                dI();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> aFm() {
            return this.cXd.cXh;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.cXd.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> aFn() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> aFm = aFm();
            int size = aFm.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(aFm.get(i2 + 1).longValue() - aFm.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
