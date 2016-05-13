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
    private a Tt = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g TG = new g();
    }

    public static g su() {
        return c.TG;
    }

    public void a(int i, k kVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.Tt = new a(i, kVar, null);
                this.Tt.sw();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        private final List<Long> TE = new ArrayList(240);
        private final List<Integer> TF = new ArrayList(15);
        protected a Tt;

        public b(a aVar) {
            this.Tt = aVar;
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
            this.TE.add(Long.valueOf(j));
            this.Tt.sw();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.Tt = null;
            this.TE.clear();
            this.TF.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final b TA;
        private final int TB;
        private final k TC;
        private final Class<?> Tu;
        private final Object Tv;
        private final Class<?> Tw;
        private final Method Tx;
        private final Object Ty;
        private final Method Tz;
        private int index;

        private a(int i, k kVar) {
            this.index = 0;
            this.Tw = Class.forName("android.view.Choreographer");
            this.Tu = Class.forName("android.view.Choreographer$FrameCallback");
            this.TA = new b(this);
            this.Tv = Proxy.newProxyInstance(this.Tu.getClassLoader(), new Class[]{this.Tu}, this.TA);
            this.Tx = this.Tw.getMethod("getInstance", new Class[0]);
            this.Ty = this.Tx.invoke(null, new Object[0]);
            this.Tz = this.Tw.getMethod("postFrameCallback", this.Tu);
            this.TB = i <= 0 ? 16 : i;
            this.TC = kVar;
        }

        /* synthetic */ a(int i, k kVar, a aVar) {
            this(i, kVar);
        }

        private void sv() {
            this.Tz.invoke(this.Ty, this.Tv);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sw() {
            if (this.index >= this.TB) {
                com.baidu.adp.lib.h.h.dL().post(new h(this));
                return;
            }
            this.index++;
            try {
                sv();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> sx() {
            return this.TA.TE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.TA.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> sy() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> sx = sx();
            int size = sx.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(sx.get(i2 + 1).longValue() - sx.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
