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
    private a acH = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final h acT = new h();
    }

    public static h tG() {
        return c.acT;
    }

    public void a(int i, k kVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.acH = new a(i, kVar);
                this.acH.tI();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a acH;
        private final List<Long> acR = new ArrayList(240);
        private final List<Integer> acS = new ArrayList(15);

        public b(a aVar) {
            this.acH = aVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            if ("doFrame".equals(name)) {
                switch (parameterTypes.length) {
                    case 1:
                        if (parameterTypes[0] == Long.TYPE) {
                            n(((Long) objArr[0]).longValue());
                            return null;
                        }
                        return null;
                    default:
                        return null;
                }
            }
            return null;
        }

        private void n(long j) {
            this.acR.add(Long.valueOf(j));
            this.acH.tI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.acH = null;
            this.acR.clear();
            this.acS.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> acI;
        private final Object acJ;
        private final Class<?> acK;
        private final Method acL;
        private final Object acM;
        private final Method acN;
        private final b acO;
        private final k acP;
        private int index;

        private a(int i, k kVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.acK = Class.forName("android.view.Choreographer");
            this.acI = Class.forName("android.view.Choreographer$FrameCallback");
            this.acO = new b(this);
            this.acJ = Proxy.newProxyInstance(this.acI.getClassLoader(), new Class[]{this.acI}, this.acO);
            this.acL = this.acK.getMethod("getInstance", new Class[0]);
            this.acM = this.acL.invoke(null, new Object[0]);
            this.acN = this.acK.getMethod("postFrameCallback", this.acI);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.acP = kVar;
        }

        private void tH() throws InvocationTargetException, IllegalAccessException {
            this.acN.invoke(this.acM, this.acJ);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void tI() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.h.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.acP.n(a.this.tK());
                        a.this.acO.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                tH();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> tJ() {
            return this.acO.acR;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.acO.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> tK() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> tJ = tJ();
            int size = tJ.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(tJ.get(i2 + 1).longValue() - tJ.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
