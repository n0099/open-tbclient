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
    private a adA = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final i adM = new i();
    }

    public static i tP() {
        return c.adM;
    }

    public void a(int i, m mVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.adA = new a(i, mVar);
                this.adA.tR();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a adA;
        private final List<Long> adK = new ArrayList(240);
        private final List<Integer> adL = new ArrayList(15);

        public b(a aVar) {
            this.adA = aVar;
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
            this.adK.add(Long.valueOf(j));
            this.adA.tR();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.adA = null;
            this.adK.clear();
            this.adL.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> adB;
        private final Object adC;
        private final Class<?> adD;
        private final Method adE;
        private final Object adF;
        private final Method adG;
        private final b adH;
        private final m adI;
        private int index;

        private a(int i, m mVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.adD = Class.forName("android.view.Choreographer");
            this.adB = Class.forName("android.view.Choreographer$FrameCallback");
            this.adH = new b(this);
            this.adC = Proxy.newProxyInstance(this.adB.getClassLoader(), new Class[]{this.adB}, this.adH);
            this.adE = this.adD.getMethod("getInstance", new Class[0]);
            this.adF = this.adE.invoke(null, new Object[0]);
            this.adG = this.adD.getMethod("postFrameCallback", this.adB);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.adI = mVar;
        }

        private void tQ() throws InvocationTargetException, IllegalAccessException {
            this.adG.invoke(this.adF, this.adC);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void tR() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.ga().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.i.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.adI.n(a.this.tT());
                        a.this.adH.destroy();
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
            return this.adH.adK;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.adH.destroy();
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
