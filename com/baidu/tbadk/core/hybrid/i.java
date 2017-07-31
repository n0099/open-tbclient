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
public class i {
    private a ady = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final i adK = new i();
    }

    public static i tP() {
        return c.adK;
    }

    public void a(int i, m mVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.ady = new a(i, mVar);
                this.ady.tR();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        private final List<Long> adI = new ArrayList(240);
        private final List<Integer> adJ = new ArrayList(15);
        protected a ady;

        public b(a aVar) {
            this.ady = aVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            if ("doFrame".equals(name)) {
                switch (parameterTypes.length) {
                    case 1:
                        if (parameterTypes[0] == Long.TYPE) {
                            n(((Long) objArr[0]).longValue());
                            return null;
                        }
                        return null;
                    default:
                        return null;
                }
            }
            return null;
        }

        private void n(long j) {
            this.adI.add(Long.valueOf(j));
            this.ady.tR();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.ady = null;
            this.adI.clear();
            this.adJ.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Object adA;
        private final Class<?> adB;
        private final Method adC;
        private final Object adD;
        private final Method adE;
        private final b adF;
        private final m adG;
        private final Class<?> adz;
        private int index;

        private a(int i, m mVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.adB = Class.forName("android.view.Choreographer");
            this.adz = Class.forName("android.view.Choreographer$FrameCallback");
            this.adF = new b(this);
            this.adA = Proxy.newProxyInstance(this.adz.getClassLoader(), new Class[]{this.adz}, this.adF);
            this.adC = this.adB.getMethod("getInstance", new Class[0]);
            this.adD = this.adC.invoke(null, new Object[0]);
            this.adE = this.adB.getMethod("postFrameCallback", this.adz);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.adG = mVar;
        }

        private void tQ() throws InvocationTargetException, IllegalAccessException {
            this.adE.invoke(this.adD, this.adA);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void tR() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.ga().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.i.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.adG.n(a.this.tT());
                        a.this.adF.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                tQ();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> tS() {
            return this.adF.adI;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.adF.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> tT() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> tS = tS();
            int size = tS.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(tS.get(i2 + 1).longValue() - tS.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
