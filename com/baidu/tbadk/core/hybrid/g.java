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
    private a bPf = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g bPr = new g();
    }

    public static g ahq() {
        return c.bPr;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.bPf = new a(i, jVar);
                this.bPf.ahs();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a bPf;
        private final List<Long> bPp = new ArrayList(240);
        private final List<Integer> bPq = new ArrayList(15);

        public b(a aVar) {
            this.bPf = aVar;
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
            this.bPp.add(Long.valueOf(j));
            this.bPf.ahs();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.bPf = null;
            this.bPp.clear();
            this.bPq.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> bPg;
        private final Object bPh;
        private final Class<?> bPi;
        private final Method bPj;
        private final Object bPk;
        private final Method bPl;
        private final b bPm;
        private final j bPn;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.bPi = Class.forName("android.view.Choreographer");
            this.bPg = Class.forName("android.view.Choreographer$FrameCallback");
            this.bPm = new b(this);
            this.bPh = Proxy.newProxyInstance(this.bPg.getClassLoader(), new Class[]{this.bPg}, this.bPm);
            this.bPj = this.bPi.getMethod("getInstance", new Class[0]);
            this.bPk = this.bPj.invoke(null, new Object[0]);
            this.bPl = this.bPi.getMethod("postFrameCallback", this.bPg);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.bPn = jVar;
        }

        private void ahr() throws InvocationTargetException, IllegalAccessException {
            this.bPl.invoke(this.bPk, this.bPh);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ahs() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bPn.X(a.this.ahu());
                        a.this.bPm.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                ahr();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> aht() {
            return this.bPm.bPp;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.bPm.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> ahu() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> aht = aht();
            int size = aht.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(aht.get(i2 + 1).longValue() - aht.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
