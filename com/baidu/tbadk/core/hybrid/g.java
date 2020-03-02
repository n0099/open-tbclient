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
    private a cWI = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g cWV = new g();
    }

    public static g aFg() {
        return c.cWV;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.cWI = new a(i, jVar);
                this.cWI.aFh();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a cWI;
        private final List<Long> cWT = new ArrayList(240);
        private final List<Integer> cWU = new ArrayList(15);

        public b(a aVar) {
            this.cWI = aVar;
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
            this.cWT.add(Long.valueOf(j));
            this.cWI.aFh();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.cWI = null;
            this.cWT.clear();
            this.cWU.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final Class<?> cWJ;
        private final Object cWK;
        private final Class<?> cWL;
        private final Method cWM;
        private final Object cWN;
        private final Method cWO;
        private final b cWP;
        private final int cWQ;
        private final j cWR;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.cWL = Class.forName("android.view.Choreographer");
            this.cWJ = Class.forName("android.view.Choreographer$FrameCallback");
            this.cWP = new b(this);
            this.cWK = Proxy.newProxyInstance(this.cWJ.getClassLoader(), new Class[]{this.cWJ}, this.cWP);
            this.cWM = this.cWL.getMethod("getInstance", new Class[0]);
            this.cWN = this.cWM.invoke(null, new Object[0]);
            this.cWO = this.cWL.getMethod("postFrameCallback", this.cWJ);
            this.cWQ = i <= 0 ? 16 : i;
            this.cWR = jVar;
        }

        private void dI() throws InvocationTargetException, IllegalAccessException {
            this.cWO.invoke(this.cWN, this.cWK);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aFh() {
            if (this.index >= this.cWQ) {
                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cWR.aA(a.this.aFj());
                        a.this.cWP.destroy();
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

        private List<Long> aFi() {
            return this.cWP.cWT;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.cWP.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> aFj() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> aFi = aFi();
            int size = aFi.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(aFi.get(i2 + 1).longValue() - aFi.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
