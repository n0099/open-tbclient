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
    private a dKr = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g dKD = new g();
    }

    public static g aTA() {
        return c.dKD;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.dKr = new a(i, jVar);
                this.dKr.aTB();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        private final List<Long> dKB = new ArrayList(240);
        private final List<Integer> dKC = new ArrayList(15);
        protected a dKr;

        public b(a aVar) {
            this.dKr = aVar;
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
            this.dKB.add(Long.valueOf(j));
            this.dKr.aTB();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.dKr = null;
            this.dKB.clear();
            this.dKC.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> dKs;
        private final Object dKt;
        private final Class<?> dKu;
        private final Method dKv;
        private final Object dKw;
        private final Method dKx;
        private final b dKy;
        private final j dKz;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.dKu = Class.forName("android.view.Choreographer");
            this.dKs = Class.forName("android.view.Choreographer$FrameCallback");
            this.dKy = new b(this);
            this.dKt = Proxy.newProxyInstance(this.dKs.getClassLoader(), new Class[]{this.dKs}, this.dKy);
            this.dKv = this.dKu.getMethod("getInstance", new Class[0]);
            this.dKw = this.dKv.invoke(null, new Object[0]);
            this.dKx = this.dKu.getMethod("postFrameCallback", this.dKs);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.dKz = jVar;
        }

        private void jh() throws InvocationTargetException, IllegalAccessException {
            this.dKx.invoke(this.dKw, this.dKt);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aTB() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.dKz.aE(a.this.aTD());
                        a.this.dKy.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                jh();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> aTC() {
            return this.dKy.dKB;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.dKy.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> aTD() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> aTC = aTC();
            int size = aTC.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(aTC.get(i2 + 1).longValue() - aTC.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
