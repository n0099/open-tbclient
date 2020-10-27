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
    private a eEf = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g eEr = new g();
    }

    public static g bnj() {
        return c.eEr;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.eEf = new a(i, jVar);
                this.eEf.bnk();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a eEf;
        private final List<Long> eEp = new ArrayList(240);
        private final List<Integer> eEq = new ArrayList(15);

        public b(a aVar) {
            this.eEf = aVar;
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
            this.eEp.add(Long.valueOf(j));
            this.eEf.bnk();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.eEf = null;
            this.eEp.clear();
            this.eEq.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> eEg;
        private final Object eEh;
        private final Class<?> eEi;
        private final Method eEj;
        private final Object eEk;
        private final Method eEl;
        private final b eEm;
        private final j eEn;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.eEi = Class.forName("android.view.Choreographer");
            this.eEg = Class.forName("android.view.Choreographer$FrameCallback");
            this.eEm = new b(this);
            this.eEh = Proxy.newProxyInstance(this.eEg.getClassLoader(), new Class[]{this.eEg}, this.eEm);
            this.eEj = this.eEi.getMethod("getInstance", new Class[0]);
            this.eEk = this.eEj.invoke(null, new Object[0]);
            this.eEl = this.eEi.getMethod("postFrameCallback", this.eEg);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.eEn = jVar;
        }

        private void kY() throws InvocationTargetException, IllegalAccessException {
            this.eEl.invoke(this.eEk, this.eEh);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bnk() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.eEn.bl(a.this.bnm());
                        a.this.eEm.destroy();
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

        private List<Long> bnl() {
            return this.eEm.eEp;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.eEm.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> bnm() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> bnl = bnl();
            int size = bnl.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(bnl.get(i2 + 1).longValue() - bnl.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
