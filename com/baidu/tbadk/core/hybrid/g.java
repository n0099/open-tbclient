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
    private a eXI = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g eXU = new g();
    }

    public static g brs() {
        return c.eXU;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.eXI = new a(i, jVar);
                this.eXI.brt();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a eXI;
        private final List<Long> eXS = new ArrayList(240);
        private final List<Integer> eXT = new ArrayList(15);

        public b(a aVar) {
            this.eXI = aVar;
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
            this.eXS.add(Long.valueOf(j));
            this.eXI.brt();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.eXI = null;
            this.eXS.clear();
            this.eXT.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> eXJ;
        private final Object eXK;
        private final Class<?> eXL;
        private final Method eXM;
        private final Object eXN;
        private final Method eXO;
        private final b eXP;
        private final j eXQ;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.eXL = Class.forName("android.view.Choreographer");
            this.eXJ = Class.forName("android.view.Choreographer$FrameCallback");
            this.eXP = new b(this);
            this.eXK = Proxy.newProxyInstance(this.eXJ.getClassLoader(), new Class[]{this.eXJ}, this.eXP);
            this.eXM = this.eXL.getMethod("getInstance", new Class[0]);
            this.eXN = this.eXM.invoke(null, new Object[0]);
            this.eXO = this.eXL.getMethod("postFrameCallback", this.eXJ);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.eXQ = jVar;
        }

        private void kw() throws InvocationTargetException, IllegalAccessException {
            this.eXO.invoke(this.eXN, this.eXK);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void brt() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.eXQ.by(a.this.brv());
                        a.this.eXP.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                kw();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> bru() {
            return this.eXP.eXS;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.eXP.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> brv() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> bru = bru();
            int size = bru.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(bru.get(i2 + 1).longValue() - bru.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
