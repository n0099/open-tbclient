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
    private a amu = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g amG = new g();
    }

    public static g xC() {
        return c.amG;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.amu = new a(i, jVar);
                this.amu.xE();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        private final List<Long> amE = new ArrayList(240);
        private final List<Integer> amF = new ArrayList(15);
        protected a amu;

        public b(a aVar) {
            this.amu = aVar;
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
            this.amE.add(Long.valueOf(j));
            this.amu.xE();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.amu = null;
            this.amE.clear();
            this.amF.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Method amA;
        private final b amB;
        private final j amC;
        private final Class<?> amv;
        private final Object amw;
        private final Class<?> amx;
        private final Method amy;
        private final Object amz;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.amx = Class.forName("android.view.Choreographer");
            this.amv = Class.forName("android.view.Choreographer$FrameCallback");
            this.amB = new b(this);
            this.amw = Proxy.newProxyInstance(this.amv.getClassLoader(), new Class[]{this.amv}, this.amB);
            this.amy = this.amx.getMethod("getInstance", new Class[0]);
            this.amz = this.amy.invoke(null, new Object[0]);
            this.amA = this.amx.getMethod("postFrameCallback", this.amv);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.amC = jVar;
        }

        private void xD() throws InvocationTargetException, IllegalAccessException {
            this.amA.invoke(this.amz, this.amw);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void xE() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.in().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.amC.w(a.this.xG());
                        a.this.amB.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                xD();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> xF() {
            return this.amB.amE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.amB.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> xG() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> xF = xF();
            int size = xF.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(xF.get(i2 + 1).longValue() - xF.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
