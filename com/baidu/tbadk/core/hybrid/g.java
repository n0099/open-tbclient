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
    private a cWJ = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g cWW = new g();
    }

    public static g aFg() {
        return c.cWW;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.cWJ = new a(i, jVar);
                this.cWJ.aFh();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a cWJ;
        private final List<Long> cWU = new ArrayList(240);
        private final List<Integer> cWV = new ArrayList(15);

        public b(a aVar) {
            this.cWJ = aVar;
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
            this.cWU.add(Long.valueOf(j));
            this.cWJ.aFh();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.cWJ = null;
            this.cWU.clear();
            this.cWV.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final Class<?> cWK;
        private final Object cWL;
        private final Class<?> cWM;
        private final Method cWN;
        private final Object cWO;
        private final Method cWP;
        private final b cWQ;
        private final int cWR;
        private final j cWS;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.cWM = Class.forName("android.view.Choreographer");
            this.cWK = Class.forName("android.view.Choreographer$FrameCallback");
            this.cWQ = new b(this);
            this.cWL = Proxy.newProxyInstance(this.cWK.getClassLoader(), new Class[]{this.cWK}, this.cWQ);
            this.cWN = this.cWM.getMethod("getInstance", new Class[0]);
            this.cWO = this.cWN.invoke(null, new Object[0]);
            this.cWP = this.cWM.getMethod("postFrameCallback", this.cWK);
            this.cWR = i <= 0 ? 16 : i;
            this.cWS = jVar;
        }

        private void dI() throws InvocationTargetException, IllegalAccessException {
            this.cWP.invoke(this.cWO, this.cWL);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aFh() {
            if (this.index >= this.cWR) {
                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cWS.aA(a.this.aFj());
                        a.this.cWQ.destroy();
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
            return this.cWQ.cWU;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.cWQ.destroy();
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
