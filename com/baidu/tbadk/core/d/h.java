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
    private a WD = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final h WP = new h();
    }

    public static h tu() {
        return c.WP;
    }

    public void a(int i, l lVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.WD = new a(i, lVar, null);
                this.WD.tw();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a WD;
        private final List<Long> WN = new ArrayList(240);
        private final List<Integer> WO = new ArrayList(15);

        public b(a aVar) {
            this.WD = aVar;
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
            this.WN.add(Long.valueOf(j));
            this.WD.tw();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.WD = null;
            this.WN.clear();
            this.WO.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> WE;
        private final Object WF;
        private final Class<?> WG;
        private final Method WH;
        private final Object WI;
        private final Method WJ;
        private final b WK;
        private final l WL;
        private int index;

        private a(int i, l lVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.WG = Class.forName("android.view.Choreographer");
            this.WE = Class.forName("android.view.Choreographer$FrameCallback");
            this.WK = new b(this);
            this.WF = Proxy.newProxyInstance(this.WE.getClassLoader(), new Class[]{this.WE}, this.WK);
            this.WH = this.WG.getMethod("getInstance", new Class[0]);
            this.WI = this.WH.invoke(null, new Object[0]);
            this.WJ = this.WG.getMethod("postFrameCallback", this.WE);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.WL = lVar;
        }

        /* synthetic */ a(int i, l lVar, a aVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this(i, lVar);
        }

        private void tv() throws InvocationTargetException, IllegalAccessException {
            this.WJ.invoke(this.WI, this.WF);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void tw() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.h.eE().post(new i(this));
                return;
            }
            this.index++;
            try {
                tv();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> tx() {
            return this.WK.WN;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.WK.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> ty() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> tx = tx();
            int size = tx.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(tx.get(i2 + 1).longValue() - tx.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
