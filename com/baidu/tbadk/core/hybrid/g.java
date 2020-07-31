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
    private a dXz = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g dXL = new g();
    }

    public static g aZs() {
        return c.dXL;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.dXz = new a(i, jVar);
                this.dXz.aZt();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        private final List<Long> dXJ = new ArrayList(240);
        private final List<Integer> dXK = new ArrayList(15);
        protected a dXz;

        public b(a aVar) {
            this.dXz = aVar;
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
            this.dXJ.add(Long.valueOf(j));
            this.dXz.aZt();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.dXz = null;
            this.dXJ.clear();
            this.dXK.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> dXA;
        private final Object dXB;
        private final Class<?> dXC;
        private final Method dXD;
        private final Object dXE;
        private final Method dXF;
        private final b dXG;
        private final j dXH;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.dXC = Class.forName("android.view.Choreographer");
            this.dXA = Class.forName("android.view.Choreographer$FrameCallback");
            this.dXG = new b(this);
            this.dXB = Proxy.newProxyInstance(this.dXA.getClassLoader(), new Class[]{this.dXA}, this.dXG);
            this.dXD = this.dXC.getMethod("getInstance", new Class[0]);
            this.dXE = this.dXD.invoke(null, new Object[0]);
            this.dXF = this.dXC.getMethod("postFrameCallback", this.dXA);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.dXH = jVar;
        }

        private void jx() throws InvocationTargetException, IllegalAccessException {
            this.dXF.invoke(this.dXE, this.dXB);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aZt() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.dXH.aT(a.this.aZv());
                        a.this.dXG.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                jx();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> aZu() {
            return this.dXG.dXJ;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.dXG.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> aZv() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> aZu = aZu();
            int size = aZu.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(aZu.get(i2 + 1).longValue() - aZu.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
