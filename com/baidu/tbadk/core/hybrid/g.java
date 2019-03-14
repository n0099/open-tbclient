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
    private a bGB = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g bGN = new g();
    }

    public static g abz() {
        return c.bGN;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.bGB = new a(i, jVar);
                this.bGB.abB();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a bGB;
        private final List<Long> bGL = new ArrayList(240);
        private final List<Integer> bGM = new ArrayList(15);

        public b(a aVar) {
            this.bGB = aVar;
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
            this.bGL.add(Long.valueOf(j));
            this.bGB.abB();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.bGB = null;
            this.bGL.clear();
            this.bGM.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> bGC;
        private final Object bGD;
        private final Class<?> bGE;
        private final Method bGF;
        private final Object bGG;
        private final Method bGH;
        private final b bGI;
        private final j bGJ;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.bGE = Class.forName("android.view.Choreographer");
            this.bGC = Class.forName("android.view.Choreographer$FrameCallback");
            this.bGI = new b(this);
            this.bGD = Proxy.newProxyInstance(this.bGC.getClassLoader(), new Class[]{this.bGC}, this.bGI);
            this.bGF = this.bGE.getMethod("getInstance", new Class[0]);
            this.bGG = this.bGF.invoke(null, new Object[0]);
            this.bGH = this.bGE.getMethod("postFrameCallback", this.bGC);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.bGJ = jVar;
        }

        private void abA() throws InvocationTargetException, IllegalAccessException {
            this.bGH.invoke(this.bGG, this.bGD);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void abB() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bGJ.Q(a.this.abD());
                        a.this.bGI.destroy();
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
            return this.bGI.bGL;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.bGI.destroy();
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
