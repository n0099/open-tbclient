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
    private a eVs = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g eVE = new g();
    }

    public static g bqZ() {
        return c.eVE;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.eVs = new a(i, jVar);
                this.eVs.bra();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        private final List<Long> eVC = new ArrayList(240);
        private final List<Integer> eVD = new ArrayList(15);
        protected a eVs;

        public b(a aVar) {
            this.eVs = aVar;
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
            this.eVC.add(Long.valueOf(j));
            this.eVs.bra();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.eVs = null;
            this.eVC.clear();
            this.eVD.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final j eVA;
        private final Class<?> eVt;
        private final Object eVu;
        private final Class<?> eVv;
        private final Method eVw;
        private final Object eVx;
        private final Method eVy;
        private final b eVz;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.eVv = Class.forName("android.view.Choreographer");
            this.eVt = Class.forName("android.view.Choreographer$FrameCallback");
            this.eVz = new b(this);
            this.eVu = Proxy.newProxyInstance(this.eVt.getClassLoader(), new Class[]{this.eVt}, this.eVz);
            this.eVw = this.eVv.getMethod("getInstance", new Class[0]);
            this.eVx = this.eVw.invoke(null, new Object[0]);
            this.eVy = this.eVv.getMethod("postFrameCallback", this.eVt);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.eVA = jVar;
        }

        private void kx() throws InvocationTargetException, IllegalAccessException {
            this.eVy.invoke(this.eVx, this.eVu);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bra() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.eVA.bD(a.this.brc());
                        a.this.eVz.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                kx();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> brb() {
            return this.eVz.eVC;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.eVz.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> brc() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> brb = brb();
            int size = brb.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(brb.get(i2 + 1).longValue() - brb.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
