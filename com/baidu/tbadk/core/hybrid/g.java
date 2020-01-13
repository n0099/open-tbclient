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
    private a cSF = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g cSS = new g();
    }

    public static g aCU() {
        return c.cSS;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.cSF = new a(i, jVar);
                this.cSF.aCV();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a cSF;
        private final List<Long> cSQ = new ArrayList(240);
        private final List<Integer> cSR = new ArrayList(15);

        public b(a aVar) {
            this.cSF = aVar;
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
            this.cSQ.add(Long.valueOf(j));
            this.cSF.aCV();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.cSF = null;
            this.cSQ.clear();
            this.cSR.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final Class<?> cSG;
        private final Object cSH;
        private final Class<?> cSI;
        private final Method cSJ;
        private final Object cSK;
        private final Method cSL;
        private final b cSM;
        private final int cSN;
        private final j cSO;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.cSI = Class.forName("android.view.Choreographer");
            this.cSG = Class.forName("android.view.Choreographer$FrameCallback");
            this.cSM = new b(this);
            this.cSH = Proxy.newProxyInstance(this.cSG.getClassLoader(), new Class[]{this.cSG}, this.cSM);
            this.cSJ = this.cSI.getMethod("getInstance", new Class[0]);
            this.cSK = this.cSJ.invoke(null, new Object[0]);
            this.cSL = this.cSI.getMethod("postFrameCallback", this.cSG);
            this.cSN = i <= 0 ? 16 : i;
            this.cSO = jVar;
        }

        private void dH() throws InvocationTargetException, IllegalAccessException {
            this.cSL.invoke(this.cSK, this.cSH);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aCV() {
            if (this.index >= this.cSN) {
                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cSO.aA(a.this.aCX());
                        a.this.cSM.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                dH();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> aCW() {
            return this.cSM.cSQ;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.cSM.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> aCX() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> aCW = aCW();
            int size = aCW.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(aCW.get(i2 + 1).longValue() - aCW.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
