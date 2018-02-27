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
    private a aSU = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final h aTg = new h();
    }

    public static h Bs() {
        return c.aTg;
    }

    public void a(int i, k kVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.aSU = new a(i, kVar);
                this.aSU.Bu();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a aSU;
        private final List<Long> aTe = new ArrayList(240);
        private final List<Integer> aTf = new ArrayList(15);

        public b(a aVar) {
            this.aSU = aVar;
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
            this.aTe.add(Long.valueOf(j));
            this.aSU.Bu();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.aSU = null;
            this.aTe.clear();
            this.aTf.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> aSV;
        private final Object aSW;
        private final Class<?> aSX;
        private final Method aSY;
        private final Object aSZ;
        private final Method aTa;
        private final b aTb;
        private final k aTc;
        private int index;

        private a(int i, k kVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.aSX = Class.forName("android.view.Choreographer");
            this.aSV = Class.forName("android.view.Choreographer$FrameCallback");
            this.aTb = new b(this);
            this.aSW = Proxy.newProxyInstance(this.aSV.getClassLoader(), new Class[]{this.aSV}, this.aTb);
            this.aSY = this.aSX.getMethod("getInstance", new Class[0]);
            this.aSZ = this.aSY.invoke(null, new Object[0]);
            this.aTa = this.aSX.getMethod("postFrameCallback", this.aSV);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.aTc = kVar;
        }

        private void Bt() throws InvocationTargetException, IllegalAccessException {
            this.aTa.invoke(this.aSZ, this.aSW);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Bu() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.h.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.aTc.z(a.this.Bw());
                        a.this.aTb.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                Bt();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> Bv() {
            return this.aTb.aTe;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.aTb.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> Bw() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> Bv = Bv();
            int size = Bv.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(Bv.get(i2 + 1).longValue() - Bv.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
