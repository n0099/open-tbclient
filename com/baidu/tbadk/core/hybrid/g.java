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
    private a cWH = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g cWU = new g();
    }

    public static g aFe() {
        return c.cWU;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.cWH = new a(i, jVar);
                this.cWH.aFf();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a cWH;
        private final List<Long> cWS = new ArrayList(240);
        private final List<Integer> cWT = new ArrayList(15);

        public b(a aVar) {
            this.cWH = aVar;
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
            this.cWS.add(Long.valueOf(j));
            this.cWH.aFf();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.cWH = null;
            this.cWS.clear();
            this.cWT.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final Class<?> cWI;
        private final Object cWJ;
        private final Class<?> cWK;
        private final Method cWL;
        private final Object cWM;
        private final Method cWN;
        private final b cWO;
        private final int cWP;
        private final j cWQ;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.cWK = Class.forName("android.view.Choreographer");
            this.cWI = Class.forName("android.view.Choreographer$FrameCallback");
            this.cWO = new b(this);
            this.cWJ = Proxy.newProxyInstance(this.cWI.getClassLoader(), new Class[]{this.cWI}, this.cWO);
            this.cWL = this.cWK.getMethod("getInstance", new Class[0]);
            this.cWM = this.cWL.invoke(null, new Object[0]);
            this.cWN = this.cWK.getMethod("postFrameCallback", this.cWI);
            this.cWP = i <= 0 ? 16 : i;
            this.cWQ = jVar;
        }

        private void dI() throws InvocationTargetException, IllegalAccessException {
            this.cWN.invoke(this.cWM, this.cWJ);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aFf() {
            if (this.index >= this.cWP) {
                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cWQ.aA(a.this.aFh());
                        a.this.cWO.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                dI();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> aFg() {
            return this.cWO.cWS;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.cWO.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> aFh() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> aFg = aFg();
            int size = aFg.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(aFg.get(i2 + 1).longValue() - aFg.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
