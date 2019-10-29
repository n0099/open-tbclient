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
    private a cgN = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g cha = new g();
    }

    public static g alt() {
        return c.cha;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.cgN = new a(i, jVar);
                this.cgN.alv();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a cgN;
        private final List<Long> cgY = new ArrayList(240);
        private final List<Integer> cgZ = new ArrayList(15);

        public b(a aVar) {
            this.cgN = aVar;
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
            this.cgY.add(Long.valueOf(j));
            this.cgN.alv();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.cgN = null;
            this.cgY.clear();
            this.cgZ.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final Class<?> cgO;
        private final Object cgP;
        private final Class<?> cgQ;
        private final Method cgR;
        private final Object cgS;
        private final Method cgT;
        private final b cgU;
        private final int cgV;
        private final j cgW;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.cgQ = Class.forName("android.view.Choreographer");
            this.cgO = Class.forName("android.view.Choreographer$FrameCallback");
            this.cgU = new b(this);
            this.cgP = Proxy.newProxyInstance(this.cgO.getClassLoader(), new Class[]{this.cgO}, this.cgU);
            this.cgR = this.cgQ.getMethod("getInstance", new Class[0]);
            this.cgS = this.cgR.invoke(null, new Object[0]);
            this.cgT = this.cgQ.getMethod("postFrameCallback", this.cgO);
            this.cgV = i <= 0 ? 16 : i;
            this.cgW = jVar;
        }

        private void alu() throws InvocationTargetException, IllegalAccessException {
            this.cgT.invoke(this.cgS, this.cgP);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void alv() {
            if (this.index >= this.cgV) {
                com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cgW.au(a.this.alx());
                        a.this.cgU.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                alu();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> alw() {
            return this.cgU.cgY;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.cgU.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> alx() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> alw = alw();
            int size = alw.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(alw.get(i2 + 1).longValue() - alw.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
