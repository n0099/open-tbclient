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
    private a cSv = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g cSI = new g();
    }

    public static g aCB() {
        return c.cSI;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.cSv = new a(i, jVar);
                this.cSv.aCC();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        private final List<Long> cSG = new ArrayList(240);
        private final List<Integer> cSH = new ArrayList(15);
        protected a cSv;

        public b(a aVar) {
            this.cSv = aVar;
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
            this.cSG.add(Long.valueOf(j));
            this.cSv.aCC();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.cSv = null;
            this.cSG.clear();
            this.cSH.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final Object cSA;
        private final Method cSB;
        private final b cSC;
        private final int cSD;
        private final j cSE;
        private final Class<?> cSw;
        private final Object cSx;
        private final Class<?> cSy;
        private final Method cSz;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.cSy = Class.forName("android.view.Choreographer");
            this.cSw = Class.forName("android.view.Choreographer$FrameCallback");
            this.cSC = new b(this);
            this.cSx = Proxy.newProxyInstance(this.cSw.getClassLoader(), new Class[]{this.cSw}, this.cSC);
            this.cSz = this.cSy.getMethod("getInstance", new Class[0]);
            this.cSA = this.cSz.invoke(null, new Object[0]);
            this.cSB = this.cSy.getMethod("postFrameCallback", this.cSw);
            this.cSD = i <= 0 ? 16 : i;
            this.cSE = jVar;
        }

        private void dH() throws InvocationTargetException, IllegalAccessException {
            this.cSB.invoke(this.cSA, this.cSx);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aCC() {
            if (this.index >= this.cSD) {
                com.baidu.adp.lib.f.e.gy().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cSE.aB(a.this.aCE());
                        a.this.cSC.destroy();
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

        private List<Long> aCD() {
            return this.cSC.cSG;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.cSC.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> aCE() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> aCD = aCD();
            int size = aCD.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(aCD.get(i2 + 1).longValue() - aCD.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
