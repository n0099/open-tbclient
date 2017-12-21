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
    private a adm = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final h ady = new h();
    }

    public static h tG() {
        return c.ady;
    }

    public void a(int i, k kVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.adm = new a(i, kVar);
                this.adm.tI();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a adm;
        private final List<Long> adw = new ArrayList(240);
        private final List<Integer> adx = new ArrayList(15);

        public b(a aVar) {
            this.adm = aVar;
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
            this.adw.add(Long.valueOf(j));
            this.adm.tI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.adm = null;
            this.adw.clear();
            this.adx.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> adn;
        private final Object ado;
        private final Class<?> adp;
        private final Method adq;
        private final Object adr;
        private final Method ads;
        private final b adt;
        private final k adu;
        private int index;

        private a(int i, k kVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.adp = Class.forName("android.view.Choreographer");
            this.adn = Class.forName("android.view.Choreographer$FrameCallback");
            this.adt = new b(this);
            this.ado = Proxy.newProxyInstance(this.adn.getClassLoader(), new Class[]{this.adn}, this.adt);
            this.adq = this.adp.getMethod("getInstance", new Class[0]);
            this.adr = this.adq.invoke(null, new Object[0]);
            this.ads = this.adp.getMethod("postFrameCallback", this.adn);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.adu = kVar;
        }

        private void tH() throws InvocationTargetException, IllegalAccessException {
            this.ads.invoke(this.adr, this.ado);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void tI() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.h.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.adu.p(a.this.tK());
                        a.this.adt.destroy();
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
            return this.adt.adw;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.adt.destroy();
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
