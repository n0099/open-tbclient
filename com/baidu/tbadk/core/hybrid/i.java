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
public class i {
    private a acG = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final i acS = new i();
    }

    public static i tM() {
        return c.acS;
    }

    public void a(int i, m mVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.acG = new a(i, mVar);
                this.acG.tO();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a acG;
        private final List<Long> acQ = new ArrayList(240);
        private final List<Integer> acR = new ArrayList(15);

        public b(a aVar) {
            this.acG = aVar;
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
            this.acQ.add(Long.valueOf(j));
            this.acG.tO();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.acG = null;
            this.acQ.clear();
            this.acR.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> acH;
        private final Object acI;
        private final Class<?> acJ;
        private final Method acK;
        private final Object acL;
        private final Method acM;
        private final b acN;
        private final m acO;
        private int index;

        private a(int i, m mVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.acJ = Class.forName("android.view.Choreographer");
            this.acH = Class.forName("android.view.Choreographer$FrameCallback");
            this.acN = new b(this);
            this.acI = Proxy.newProxyInstance(this.acH.getClassLoader(), new Class[]{this.acH}, this.acN);
            this.acK = this.acJ.getMethod("getInstance", new Class[0]);
            this.acL = this.acK.invoke(null, new Object[0]);
            this.acM = this.acJ.getMethod("postFrameCallback", this.acH);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.acO = mVar;
        }

        private void tN() throws InvocationTargetException, IllegalAccessException {
            this.acM.invoke(this.acL, this.acI);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void tO() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.fQ().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.i.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.acO.n(a.this.tQ());
                        a.this.acN.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                tN();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> tP() {
            return this.acN.acQ;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.acN.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> tQ() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> tP = tP();
            int size = tP.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(tP.get(i2 + 1).longValue() - tP.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
