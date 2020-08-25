package com.baidu.tbadk.core.hybrid;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g {
    private a ehf = null;

    /* loaded from: classes2.dex */
    private static final class c {
        private static final g ehr = new g();
    }

    public static g bhN() {
        return c.ehr;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.ehf = new a(i, jVar);
                this.ehf.bhO();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements InvocationHandler {
        protected a ehf;
        private final List<Long> ehp = new ArrayList(240);
        private final List<Integer> ehq = new ArrayList(15);

        public b(a aVar) {
            this.ehf = aVar;
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
            this.ehp.add(Long.valueOf(j));
            this.ehf.bhO();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.ehf = null;
            this.ehp.clear();
            this.ehq.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> ehg;
        private final Object ehh;
        private final Class<?> ehi;
        private final Method ehj;
        private final Object ehk;
        private final Method ehl;
        private final b ehm;
        private final j ehn;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.ehi = Class.forName("android.view.Choreographer");
            this.ehg = Class.forName("android.view.Choreographer$FrameCallback");
            this.ehm = new b(this);
            this.ehh = Proxy.newProxyInstance(this.ehg.getClassLoader(), new Class[]{this.ehg}, this.ehm);
            this.ehj = this.ehi.getMethod("getInstance", new Class[0]);
            this.ehk = this.ehj.invoke(null, new Object[0]);
            this.ehl = this.ehi.getMethod("postFrameCallback", this.ehg);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.ehn = jVar;
        }

        private void kW() throws InvocationTargetException, IllegalAccessException {
            this.ehl.invoke(this.ehk, this.ehh);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bhO() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.f.e.mS().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.ehn.aU(a.this.bhQ());
                        a.this.ehm.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                kW();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> bhP() {
            return this.ehm.ehp;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.ehm.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> bhQ() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> bhP = bhP();
            int size = bhP.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(bhP.get(i2 + 1).longValue() - bhP.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
