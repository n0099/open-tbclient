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
    private a dRh = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g dRt = new g();
    }

    public static g aVs() {
        return c.dRt;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.dRh = new a(i, jVar);
                this.dRh.aVt();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a dRh;
        private final List<Long> dRr = new ArrayList(240);
        private final List<Integer> dRs = new ArrayList(15);

        public b(a aVar) {
            this.dRh = aVar;
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
            this.dRr.add(Long.valueOf(j));
            this.dRh.aVt();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.dRh = null;
            this.dRr.clear();
            this.dRs.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> dRi;
        private final Object dRj;
        private final Class<?> dRk;
        private final Method dRl;
        private final Object dRm;
        private final Method dRn;
        private final b dRo;
        private final j dRp;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.dRk = Class.forName("android.view.Choreographer");
            this.dRi = Class.forName("android.view.Choreographer$FrameCallback");
            this.dRo = new b(this);
            this.dRj = Proxy.newProxyInstance(this.dRi.getClassLoader(), new Class[]{this.dRi}, this.dRo);
            this.dRl = this.dRk.getMethod("getInstance", new Class[0]);
            this.dRm = this.dRl.invoke(null, new Object[0]);
            this.dRn = this.dRk.getMethod("postFrameCallback", this.dRi);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.dRp = jVar;
        }

        private void jx() throws InvocationTargetException, IllegalAccessException {
            this.dRn.invoke(this.dRm, this.dRj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aVt() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.dRp.aM(a.this.aVv());
                        a.this.dRo.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                jx();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> aVu() {
            return this.dRo.dRr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.dRo.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> aVv() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> aVu = aVu();
            int size = aVu.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(aVu.get(i2 + 1).longValue() - aVu.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
