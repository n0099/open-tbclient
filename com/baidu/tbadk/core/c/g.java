package com.baidu.tbadk.core.c;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private a TK = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g TY = new g();
    }

    public static g ss() {
        return c.TY;
    }

    public void a(int i, k kVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.TK = new a(i, kVar, null);
                this.TK.su();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a TK;
        private final List<Long> TW = new ArrayList(240);
        private final List<Integer> TX = new ArrayList(15);

        public b(a aVar) {
            this.TK = aVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            if ("doFrame".equals(name)) {
                switch (parameterTypes.length) {
                    case 1:
                        if (parameterTypes[0] == Long.TYPE) {
                            v(((Long) objArr[0]).longValue());
                            return null;
                        }
                        return null;
                    default:
                        return null;
                }
            }
            return null;
        }

        private void v(long j) {
            this.TW.add(Long.valueOf(j));
            this.TK.su();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.TK = null;
            this.TW.clear();
            this.TX.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final Class<?> TL;
        private final Object TM;
        private final Class<?> TO;
        private final Method TP;
        private final Object TQ;
        private final Method TR;
        private final b TS;
        private final int TT;
        private final k TU;
        private int index;

        private a(int i, k kVar) {
            this.index = 0;
            this.TO = Class.forName("android.view.Choreographer");
            this.TL = Class.forName("android.view.Choreographer$FrameCallback");
            this.TS = new b(this);
            this.TM = Proxy.newProxyInstance(this.TL.getClassLoader(), new Class[]{this.TL}, this.TS);
            this.TP = this.TO.getMethod("getInstance", new Class[0]);
            this.TQ = this.TP.invoke(null, new Object[0]);
            this.TR = this.TO.getMethod("postFrameCallback", this.TL);
            this.TT = i <= 0 ? 16 : i;
            this.TU = kVar;
        }

        /* synthetic */ a(int i, k kVar, a aVar) {
            this(i, kVar);
        }

        private void st() {
            this.TR.invoke(this.TQ, this.TM);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void su() {
            if (this.index >= this.TT) {
                com.baidu.adp.lib.h.h.dM().post(new h(this));
                return;
            }
            this.index++;
            try {
                st();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> sv() {
            return this.TS.TW;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.TS.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> sw() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> sv = sv();
            int size = sv.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(sv.get(i2 + 1).longValue() - sv.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
