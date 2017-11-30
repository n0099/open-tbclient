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
    private a adp = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final h adB = new h();
    }

    public static h tJ() {
        return c.adB;
    }

    public void a(int i, k kVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.adp = new a(i, kVar);
                this.adp.tL();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a adp;
        private final List<Long> adz = new ArrayList(240);
        private final List<Integer> adA = new ArrayList(15);

        public b(a aVar) {
            this.adp = aVar;
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
            this.adz.add(Long.valueOf(j));
            this.adp.tL();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.adp = null;
            this.adz.clear();
            this.adA.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> adq;
        private final Object adr;
        private final Class<?> ads;
        private final Method adt;
        private final Object adu;
        private final Method adv;
        private final b adw;
        private final k adx;
        private int index;

        private a(int i, k kVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.ads = Class.forName("android.view.Choreographer");
            this.adq = Class.forName("android.view.Choreographer$FrameCallback");
            this.adw = new b(this);
            this.adr = Proxy.newProxyInstance(this.adq.getClassLoader(), new Class[]{this.adq}, this.adw);
            this.adt = this.ads.getMethod("getInstance", new Class[0]);
            this.adu = this.adt.invoke(null, new Object[0]);
            this.adv = this.ads.getMethod("postFrameCallback", this.adq);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.adx = kVar;
        }

        private void tK() throws InvocationTargetException, IllegalAccessException {
            this.adv.invoke(this.adu, this.adr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void tL() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.h.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.adx.p(a.this.tN());
                        a.this.adw.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                tK();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> tM() {
            return this.adw.adz;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.adw.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> tN() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> tM = tM();
            int size = tM.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(tM.get(i2 + 1).longValue() - tM.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
