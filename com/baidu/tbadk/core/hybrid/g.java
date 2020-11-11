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
    private a eJU = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g eKg = new g();
    }

    public static g bpJ() {
        return c.eKg;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.eJU = new a(i, jVar);
                this.eJU.bpK();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a eJU;
        private final List<Long> eKe = new ArrayList(240);
        private final List<Integer> eKf = new ArrayList(15);

        public b(a aVar) {
            this.eJU = aVar;
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
            this.eKe.add(Long.valueOf(j));
            this.eJU.bpK();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.eJU = null;
            this.eKe.clear();
            this.eKf.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> eJV;
        private final Object eJW;
        private final Class<?> eJX;
        private final Method eJY;
        private final Object eJZ;
        private final Method eKa;
        private final b eKb;
        private final j eKc;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.eJX = Class.forName("android.view.Choreographer");
            this.eJV = Class.forName("android.view.Choreographer$FrameCallback");
            this.eKb = new b(this);
            this.eJW = Proxy.newProxyInstance(this.eJV.getClassLoader(), new Class[]{this.eJV}, this.eKb);
            this.eJY = this.eJX.getMethod("getInstance", new Class[0]);
            this.eJZ = this.eJY.invoke(null, new Object[0]);
            this.eKa = this.eJX.getMethod("postFrameCallback", this.eJV);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.eKc = jVar;
        }

        private void kY() throws InvocationTargetException, IllegalAccessException {
            this.eKa.invoke(this.eJZ, this.eJW);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bpK() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.eKc.bs(a.this.bpM());
                        a.this.eKb.destroy();
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

        private List<Long> bpL() {
            return this.eKb.eKe;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.eKb.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> bpM() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> bpL = bpL();
            int size = bpL.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(bpL.get(i2 + 1).longValue() - bpL.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
