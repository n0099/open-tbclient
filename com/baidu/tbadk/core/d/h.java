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
    private a abR = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final h acd = new h();
    }

    public static h tR() {
        return c.acd;
    }

    public void a(int i, l lVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.abR = new a(i, lVar, null);
                this.abR.tT();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a abR;
        private final List<Long> acb = new ArrayList(240);
        private final List<Integer> acc = new ArrayList(15);

        public b(a aVar) {
            this.abR = aVar;
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
            this.acb.add(Long.valueOf(j));
            this.abR.tT();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.abR = null;
            this.acb.clear();
            this.acc.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> abS;
        private final Object abT;
        private final Class<?> abU;
        private final Method abV;
        private final Object abW;
        private final Method abX;
        private final b abY;
        private final l abZ;
        private int index;

        private a(int i, l lVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.abU = Class.forName("android.view.Choreographer");
            this.abS = Class.forName("android.view.Choreographer$FrameCallback");
            this.abY = new b(this);
            this.abT = Proxy.newProxyInstance(this.abS.getClassLoader(), new Class[]{this.abS}, this.abY);
            this.abV = this.abU.getMethod("getInstance", new Class[0]);
            this.abW = this.abV.invoke(null, new Object[0]);
            this.abX = this.abU.getMethod("postFrameCallback", this.abS);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.abZ = lVar;
        }

        /* synthetic */ a(int i, l lVar, a aVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this(i, lVar);
        }

        private void tS() throws InvocationTargetException, IllegalAccessException {
            this.abX.invoke(this.abW, this.abT);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void tT() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.h.fM().post(new i(this));
                return;
            }
            this.index++;
            try {
                tS();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> tU() {
            return this.abY.acb;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.abY.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> tV() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> tU = tU();
            int size = tU.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(tU.get(i2 + 1).longValue() - tU.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
