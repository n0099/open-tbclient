package com.baidu.tbadk.core.c;

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
    private a XT = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final h Yg = new h();
    }

    public static h tP() {
        return c.Yg;
    }

    public void a(int i, l lVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.XT = new a(i, lVar, null);
                this.XT.tR();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a XT;
        private final List<Long> Ye = new ArrayList(240);
        private final List<Integer> Yf = new ArrayList(15);

        public b(a aVar) {
            this.XT = aVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            if ("doFrame".equals(name)) {
                switch (parameterTypes.length) {
                    case 1:
                        if (parameterTypes[0] == Long.TYPE) {
                            p(((Long) objArr[0]).longValue());
                            return null;
                        }
                        return null;
                    default:
                        return null;
                }
            }
            return null;
        }

        private void p(long j) {
            this.Ye.add(Long.valueOf(j));
            this.XT.tR();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.XT = null;
            this.Ye.clear();
            this.Yf.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final Class<?> XU;
        private final Object XV;
        private final Class<?> XW;
        private final Method XX;
        private final Object XY;
        private final Method XZ;
        private final b Ya;
        private final int Yb;
        private final l Yc;
        private int index;

        private a(int i, l lVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.XW = Class.forName("android.view.Choreographer");
            this.XU = Class.forName("android.view.Choreographer$FrameCallback");
            this.Ya = new b(this);
            this.XV = Proxy.newProxyInstance(this.XU.getClassLoader(), new Class[]{this.XU}, this.Ya);
            this.XX = this.XW.getMethod("getInstance", new Class[0]);
            this.XY = this.XX.invoke(null, new Object[0]);
            this.XZ = this.XW.getMethod("postFrameCallback", this.XU);
            this.Yb = i <= 0 ? 16 : i;
            this.Yc = lVar;
        }

        /* synthetic */ a(int i, l lVar, a aVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this(i, lVar);
        }

        private void tQ() throws InvocationTargetException, IllegalAccessException {
            this.XZ.invoke(this.XY, this.XV);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void tR() {
            if (this.index >= this.Yb) {
                com.baidu.adp.lib.h.h.eG().post(new i(this));
                return;
            }
            this.index++;
            try {
                tQ();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> tS() {
            return this.Ya.Ye;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.Ya.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> tT() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> tS = tS();
            int size = tS.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(tS.get(i2 + 1).longValue() - tS.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
