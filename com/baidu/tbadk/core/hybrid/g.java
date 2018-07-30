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
    private a amt = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g amF = new g();
    }

    public static g xD() {
        return c.amF;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.amt = new a(i, jVar);
                this.amt.xF();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        private final List<Long> amD = new ArrayList(240);
        private final List<Integer> amE = new ArrayList(15);
        protected a amt;

        public b(a aVar) {
            this.amt = aVar;
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
            this.amD.add(Long.valueOf(j));
            this.amt.xF();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.amt = null;
            this.amD.clear();
            this.amE.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final b amA;
        private final j amB;
        private final Class<?> amu;
        private final Object amv;
        private final Class<?> amw;
        private final Method amx;
        private final Object amy;
        private final Method amz;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.amw = Class.forName("android.view.Choreographer");
            this.amu = Class.forName("android.view.Choreographer$FrameCallback");
            this.amA = new b(this);
            this.amv = Proxy.newProxyInstance(this.amu.getClassLoader(), new Class[]{this.amu}, this.amA);
            this.amx = this.amw.getMethod("getInstance", new Class[0]);
            this.amy = this.amx.invoke(null, new Object[0]);
            this.amz = this.amw.getMethod("postFrameCallback", this.amu);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.amB = jVar;
        }

        private void xE() throws InvocationTargetException, IllegalAccessException {
            this.amz.invoke(this.amy, this.amv);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void xF() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.in().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.amB.w(a.this.xH());
                        a.this.amA.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                xE();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> xG() {
            return this.amA.amD;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.amA.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> xH() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> xG = xG();
            int size = xG.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(xG.get(i2 + 1).longValue() - xG.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
