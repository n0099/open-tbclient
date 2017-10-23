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
public class h {
    private a acv = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final h acH = new h();
    }

    public static h tz() {
        return c.acH;
    }

    public void a(int i, k kVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.acv = new a(i, kVar);
                this.acv.tB();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        private final List<Long> acF = new ArrayList(240);
        private final List<Integer> acG = new ArrayList(15);
        protected a acv;

        public b(a aVar) {
            this.acv = aVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            if ("doFrame".equals(name)) {
                switch (parameterTypes.length) {
                    case 1:
                        if (parameterTypes[0] == Long.TYPE) {
                            o(((Long) objArr[0]).longValue());
                            return null;
                        }
                        return null;
                    default:
                        return null;
                }
            }
            return null;
        }

        private void o(long j) {
            this.acF.add(Long.valueOf(j));
            this.acv.tB();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.acv = null;
            this.acF.clear();
            this.acG.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Object acA;
        private final Method acB;
        private final b acC;
        private final k acD;
        private final Class<?> acw;
        private final Object acx;
        private final Class<?> acy;
        private final Method acz;
        private int index;

        private a(int i, k kVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.acy = Class.forName("android.view.Choreographer");
            this.acw = Class.forName("android.view.Choreographer$FrameCallback");
            this.acC = new b(this);
            this.acx = Proxy.newProxyInstance(this.acw.getClassLoader(), new Class[]{this.acw}, this.acC);
            this.acz = this.acy.getMethod("getInstance", new Class[0]);
            this.acA = this.acz.invoke(null, new Object[0]);
            this.acB = this.acy.getMethod("postFrameCallback", this.acw);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.acD = kVar;
        }

        private void tA() throws InvocationTargetException, IllegalAccessException {
            this.acB.invoke(this.acA, this.acx);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void tB() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.h.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.acD.n(a.this.tD());
                        a.this.acC.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                tA();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> tC() {
            return this.acC.acF;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.acC.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> tD() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> tC = tC();
            int size = tC.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(tC.get(i2 + 1).longValue() - tC.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
