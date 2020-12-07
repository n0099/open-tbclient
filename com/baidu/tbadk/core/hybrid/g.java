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
    private a eQe = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g eQq = new g();
    }

    public static g bsq() {
        return c.eQq;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.eQe = new a(i, jVar);
                this.eQe.bsr();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a eQe;
        private final List<Long> eQo = new ArrayList(240);
        private final List<Integer> eQp = new ArrayList(15);

        public b(a aVar) {
            this.eQe = aVar;
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
            this.eQo.add(Long.valueOf(j));
            this.eQe.bsr();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.eQe = null;
            this.eQo.clear();
            this.eQp.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> eQf;
        private final Object eQg;
        private final Class<?> eQh;
        private final Method eQi;
        private final Object eQj;
        private final Method eQk;
        private final b eQl;
        private final j eQm;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.eQh = Class.forName("android.view.Choreographer");
            this.eQf = Class.forName("android.view.Choreographer$FrameCallback");
            this.eQl = new b(this);
            this.eQg = Proxy.newProxyInstance(this.eQf.getClassLoader(), new Class[]{this.eQf}, this.eQl);
            this.eQi = this.eQh.getMethod("getInstance", new Class[0]);
            this.eQj = this.eQi.invoke(null, new Object[0]);
            this.eQk = this.eQh.getMethod("postFrameCallback", this.eQf);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.eQm = jVar;
        }

        private void kY() throws InvocationTargetException, IllegalAccessException {
            this.eQk.invoke(this.eQj, this.eQg);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bsr() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.eQm.bw(a.this.bst());
                        a.this.eQl.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                kY();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> bss() {
            return this.eQl.eQo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.eQl.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> bst() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> bss = bss();
            int size = bss.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(bss.get(i2 + 1).longValue() - bss.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
