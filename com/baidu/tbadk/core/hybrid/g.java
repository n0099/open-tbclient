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
    private a aoZ = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g apl = new g();
    }

    public static g yJ() {
        return c.apl;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.aoZ = new a(i, jVar);
                this.aoZ.yL();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a aoZ;
        private final List<Long> apj = new ArrayList(240);
        private final List<Integer> apk = new ArrayList(15);

        public b(a aVar) {
            this.aoZ = aVar;
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
            this.apj.add(Long.valueOf(j));
            this.aoZ.yL();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.aoZ = null;
            this.apj.clear();
            this.apk.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> apa;
        private final Object apb;
        private final Class<?> apc;
        private final Method apd;
        private final Object ape;
        private final Method apf;
        private final b apg;
        private final j aph;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.apc = Class.forName("android.view.Choreographer");
            this.apa = Class.forName("android.view.Choreographer$FrameCallback");
            this.apg = new b(this);
            this.apb = Proxy.newProxyInstance(this.apa.getClassLoader(), new Class[]{this.apa}, this.apg);
            this.apd = this.apc.getMethod("getInstance", new Class[0]);
            this.ape = this.apd.invoke(null, new Object[0]);
            this.apf = this.apc.getMethod("postFrameCallback", this.apa);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.aph = jVar;
        }

        private void yK() throws InvocationTargetException, IllegalAccessException {
            this.apf.invoke(this.ape, this.apb);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void yL() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.jt().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.aph.w(a.this.yN());
                        a.this.apg.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                yK();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> yM() {
            return this.apg.apj;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.apg.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> yN() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> yM = yM();
            int size = yM.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(yM.get(i2 + 1).longValue() - yM.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
