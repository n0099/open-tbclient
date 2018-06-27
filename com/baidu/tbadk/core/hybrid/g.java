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
    private a amT = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g anf = new g();
    }

    public static g xL() {
        return c.anf;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.amT = new a(i, jVar);
                this.amT.xN();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a amT;
        private final List<Long> and = new ArrayList(240);
        private final List<Integer> ane = new ArrayList(15);

        public b(a aVar) {
            this.amT = aVar;
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
            this.and.add(Long.valueOf(j));
            this.amT.xN();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.amT = null;
            this.and.clear();
            this.ane.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> amU;
        private final Object amV;
        private final Class<?> amW;
        private final Method amX;
        private final Object amY;
        private final Method amZ;
        private final b ana;
        private final j anb;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.amW = Class.forName("android.view.Choreographer");
            this.amU = Class.forName("android.view.Choreographer$FrameCallback");
            this.ana = new b(this);
            this.amV = Proxy.newProxyInstance(this.amU.getClassLoader(), new Class[]{this.amU}, this.ana);
            this.amX = this.amW.getMethod("getInstance", new Class[0]);
            this.amY = this.amX.invoke(null, new Object[0]);
            this.amZ = this.amW.getMethod("postFrameCallback", this.amU);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.anb = jVar;
        }

        private void xM() throws InvocationTargetException, IllegalAccessException {
            this.amZ.invoke(this.amY, this.amV);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void xN() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.im().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.anb.x(a.this.xP());
                        a.this.ana.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                xM();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> xO() {
            return this.ana.and;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.ana.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> xP() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> xO = xO();
            int size = xO.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(xO.get(i2 + 1).longValue() - xO.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
