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
    private a bGA = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g bGM = new g();
    }

    public static g abz() {
        return c.bGM;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.bGA = new a(i, jVar);
                this.bGA.abB();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a bGA;
        private final List<Long> bGK = new ArrayList(240);
        private final List<Integer> bGL = new ArrayList(15);

        public b(a aVar) {
            this.bGA = aVar;
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
            this.bGK.add(Long.valueOf(j));
            this.bGA.abB();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.bGA = null;
            this.bGK.clear();
            this.bGL.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> bGB;
        private final Object bGC;
        private final Class<?> bGD;
        private final Method bGE;
        private final Object bGF;
        private final Method bGG;
        private final b bGH;
        private final j bGI;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.bGD = Class.forName("android.view.Choreographer");
            this.bGB = Class.forName("android.view.Choreographer$FrameCallback");
            this.bGH = new b(this);
            this.bGC = Proxy.newProxyInstance(this.bGB.getClassLoader(), new Class[]{this.bGB}, this.bGH);
            this.bGE = this.bGD.getMethod("getInstance", new Class[0]);
            this.bGF = this.bGE.invoke(null, new Object[0]);
            this.bGG = this.bGD.getMethod("postFrameCallback", this.bGB);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.bGI = jVar;
        }

        private void abA() throws InvocationTargetException, IllegalAccessException {
            this.bGG.invoke(this.bGF, this.bGC);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void abB() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bGI.Q(a.this.abD());
                        a.this.bGH.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                abA();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> abC() {
            return this.bGH.bGK;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.bGH.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> abD() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> abC = abC();
            int size = abC.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(abC.get(i2 + 1).longValue() - abC.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
