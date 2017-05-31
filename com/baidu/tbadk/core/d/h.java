package com.baidu.tbadk.core.d;

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
    private a abC = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final h abO = new h();
    }

    public static h tA() {
        return c.abO;
    }

    public void a(int i, l lVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.abC = new a(i, lVar, null);
                this.abC.tC();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a abC;
        private final List<Long> abM = new ArrayList(240);
        private final List<Integer> abN = new ArrayList(15);

        public b(a aVar) {
            this.abC = aVar;
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
            this.abM.add(Long.valueOf(j));
            this.abC.tC();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.abC = null;
            this.abM.clear();
            this.abN.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> abD;
        private final Object abE;
        private final Class<?> abF;
        private final Method abG;
        private final Object abH;
        private final Method abI;
        private final b abJ;
        private final l abK;
        private int index;

        private a(int i, l lVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.abF = Class.forName("android.view.Choreographer");
            this.abD = Class.forName("android.view.Choreographer$FrameCallback");
            this.abJ = new b(this);
            this.abE = Proxy.newProxyInstance(this.abD.getClassLoader(), new Class[]{this.abD}, this.abJ);
            this.abG = this.abF.getMethod("getInstance", new Class[0]);
            this.abH = this.abG.invoke(null, new Object[0]);
            this.abI = this.abF.getMethod("postFrameCallback", this.abD);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.abK = lVar;
        }

        /* synthetic */ a(int i, l lVar, a aVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this(i, lVar);
        }

        private void tB() throws InvocationTargetException, IllegalAccessException {
            this.abI.invoke(this.abH, this.abE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void tC() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.h.fS().post(new i(this));
                return;
            }
            this.index++;
            try {
                tB();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> tD() {
            return this.abJ.abM;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.abJ.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> tE() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> tD = tD();
            int size = tD.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(tD.get(i2 + 1).longValue() - tD.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
