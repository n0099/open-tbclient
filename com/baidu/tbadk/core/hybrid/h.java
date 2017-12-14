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
    private a adj = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final h adv = new h();
    }

    public static h tG() {
        return c.adv;
    }

    public void a(int i, k kVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.adj = new a(i, kVar);
                this.adj.tI();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a adj;
        private final List<Long> adt = new ArrayList(240);
        private final List<Integer> adu = new ArrayList(15);

        public b(a aVar) {
            this.adj = aVar;
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
            this.adt.add(Long.valueOf(j));
            this.adj.tI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.adj = null;
            this.adt.clear();
            this.adu.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> adk;
        private final Object adl;
        private final Class<?> adm;
        private final Method adn;
        private final Object ado;
        private final Method adp;
        private final b adq;
        private final k adr;
        private int index;

        private a(int i, k kVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.adm = Class.forName("android.view.Choreographer");
            this.adk = Class.forName("android.view.Choreographer$FrameCallback");
            this.adq = new b(this);
            this.adl = Proxy.newProxyInstance(this.adk.getClassLoader(), new Class[]{this.adk}, this.adq);
            this.adn = this.adm.getMethod("getInstance", new Class[0]);
            this.ado = this.adn.invoke(null, new Object[0]);
            this.adp = this.adm.getMethod("postFrameCallback", this.adk);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.adr = kVar;
        }

        private void tH() throws InvocationTargetException, IllegalAccessException {
            this.adp.invoke(this.ado, this.adl);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void tI() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.h.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.adr.p(a.this.tK());
                        a.this.adq.destroy();
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
            return this.adq.adt;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.adq.destroy();
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
