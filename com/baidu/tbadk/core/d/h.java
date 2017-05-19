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
    private a abD = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final h abP = new h();
    }

    public static h tB() {
        return c.abP;
    }

    public void a(int i, l lVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.abD = new a(i, lVar, null);
                this.abD.tD();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a abD;
        private final List<Long> abN = new ArrayList(240);
        private final List<Integer> abO = new ArrayList(15);

        public b(a aVar) {
            this.abD = aVar;
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
            this.abN.add(Long.valueOf(j));
            this.abD.tD();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.abD = null;
            this.abN.clear();
            this.abO.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> abE;
        private final Object abF;
        private final Class<?> abG;
        private final Method abH;
        private final Object abI;
        private final Method abJ;
        private final b abK;
        private final l abL;
        private int index;

        private a(int i, l lVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.abG = Class.forName("android.view.Choreographer");
            this.abE = Class.forName("android.view.Choreographer$FrameCallback");
            this.abK = new b(this);
            this.abF = Proxy.newProxyInstance(this.abE.getClassLoader(), new Class[]{this.abE}, this.abK);
            this.abH = this.abG.getMethod("getInstance", new Class[0]);
            this.abI = this.abH.invoke(null, new Object[0]);
            this.abJ = this.abG.getMethod("postFrameCallback", this.abE);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.abL = lVar;
        }

        /* synthetic */ a(int i, l lVar, a aVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this(i, lVar);
        }

        private void tC() throws InvocationTargetException, IllegalAccessException {
            this.abJ.invoke(this.abI, this.abF);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void tD() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.h.fS().post(new i(this));
                return;
            }
            this.index++;
            try {
                tC();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> tE() {
            return this.abK.abN;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.abK.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> tF() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> tE = tE();
            int size = tE.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(tE.get(i2 + 1).longValue() - tE.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
