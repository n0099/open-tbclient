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
public class g {
    private a ejy = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g ejK = new g();
    }

    public static g biH() {
        return c.ejK;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.ejy = new a(i, jVar);
                this.ejy.biI();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        private final List<Long> ejI = new ArrayList(240);
        private final List<Integer> ejJ = new ArrayList(15);
        protected a ejy;

        public b(a aVar) {
            this.ejy = aVar;
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
            this.ejI.add(Long.valueOf(j));
            this.ejy.biI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.ejy = null;
            this.ejI.clear();
            this.ejJ.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Object ejA;
        private final Class<?> ejB;
        private final Method ejC;
        private final Object ejD;
        private final Method ejE;
        private final b ejF;
        private final j ejG;
        private final Class<?> ejz;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.ejB = Class.forName("android.view.Choreographer");
            this.ejz = Class.forName("android.view.Choreographer$FrameCallback");
            this.ejF = new b(this);
            this.ejA = Proxy.newProxyInstance(this.ejz.getClassLoader(), new Class[]{this.ejz}, this.ejF);
            this.ejC = this.ejB.getMethod("getInstance", new Class[0]);
            this.ejD = this.ejC.invoke(null, new Object[0]);
            this.ejE = this.ejB.getMethod("postFrameCallback", this.ejz);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.ejG = jVar;
        }

        private void kX() throws InvocationTargetException, IllegalAccessException {
            this.ejE.invoke(this.ejD, this.ejA);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void biI() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.f.e.mX().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.ejG.aY(a.this.biK());
                        a.this.ejF.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                kX();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> biJ() {
            return this.ejF.ejI;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.ejF.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> biK() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> biJ = biJ();
            int size = biJ.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(biJ.get(i2 + 1).longValue() - biJ.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
