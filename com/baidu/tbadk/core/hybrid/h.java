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
    private a aSW = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final h aTi = new h();
    }

    public static h Bt() {
        return c.aTi;
    }

    public void a(int i, k kVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.aSW = new a(i, kVar);
                this.aSW.Bv();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a aSW;
        private final List<Long> aTg = new ArrayList(240);
        private final List<Integer> aTh = new ArrayList(15);

        public b(a aVar) {
            this.aSW = aVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            if ("doFrame".equals(name)) {
                switch (parameterTypes.length) {
                    case 1:
                        if (parameterTypes[0] == Long.TYPE) {
                            doFrame(((Long) objArr[0]).longValue());
                            return null;
                        }
                        return null;
                    default:
                        return null;
                }
            }
            return null;
        }

        private void doFrame(long j) {
            this.aTg.add(Long.valueOf(j));
            this.aSW.Bv();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.aSW = null;
            this.aTg.clear();
            this.aTh.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> aSX;
        private final Object aSY;
        private final Class<?> aSZ;
        private final Method aTa;
        private final Object aTb;
        private final Method aTc;
        private final b aTd;
        private final k aTe;
        private int index;

        private a(int i, k kVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.aSZ = Class.forName("android.view.Choreographer");
            this.aSX = Class.forName("android.view.Choreographer$FrameCallback");
            this.aTd = new b(this);
            this.aSY = Proxy.newProxyInstance(this.aSX.getClassLoader(), new Class[]{this.aSX}, this.aTd);
            this.aTa = this.aSZ.getMethod("getInstance", new Class[0]);
            this.aTb = this.aTa.invoke(null, new Object[0]);
            this.aTc = this.aSZ.getMethod("postFrameCallback", this.aSX);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.aTe = kVar;
        }

        private void Bu() throws InvocationTargetException, IllegalAccessException {
            this.aTc.invoke(this.aTb, this.aSY);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Bv() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.h.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.aTe.z(a.this.Bx());
                        a.this.aTd.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                Bu();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> Bw() {
            return this.aTd.aTg;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.aTd.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> Bx() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> Bw = Bw();
            int size = Bw.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(Bw.get(i2 + 1).longValue() - Bw.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
