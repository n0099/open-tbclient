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
    private a ehj = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g ehv = new g();
    }

    public static g bhN() {
        return c.ehv;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.ehj = new a(i, jVar);
                this.ehj.bhO();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a ehj;
        private final List<Long> eht = new ArrayList(240);
        private final List<Integer> ehu = new ArrayList(15);

        public b(a aVar) {
            this.ehj = aVar;
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
            this.eht.add(Long.valueOf(j));
            this.ehj.bhO();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.ehj = null;
            this.eht.clear();
            this.ehu.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> ehk;
        private final Object ehl;
        private final Class<?> ehm;
        private final Method ehn;
        private final Object eho;
        private final Method ehp;
        private final b ehq;
        private final j ehr;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.ehm = Class.forName("android.view.Choreographer");
            this.ehk = Class.forName("android.view.Choreographer$FrameCallback");
            this.ehq = new b(this);
            this.ehl = Proxy.newProxyInstance(this.ehk.getClassLoader(), new Class[]{this.ehk}, this.ehq);
            this.ehn = this.ehm.getMethod("getInstance", new Class[0]);
            this.eho = this.ehn.invoke(null, new Object[0]);
            this.ehp = this.ehm.getMethod("postFrameCallback", this.ehk);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.ehr = jVar;
        }

        private void kW() throws InvocationTargetException, IllegalAccessException {
            this.ehp.invoke(this.eho, this.ehl);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bhO() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.f.e.mS().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.ehr.aU(a.this.bhQ());
                        a.this.ehq.destroy();
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
            return this.ehq.eht;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.ehq.destroy();
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
