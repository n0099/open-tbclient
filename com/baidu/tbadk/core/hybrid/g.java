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
    private a cfW = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g cgj = new g();
    }

    public static g alr() {
        return c.cgj;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.cfW = new a(i, jVar);
                this.cfW.alt();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a cfW;
        private final List<Long> cgh = new ArrayList(240);
        private final List<Integer> cgi = new ArrayList(15);

        public b(a aVar) {
            this.cfW = aVar;
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
            this.cgh.add(Long.valueOf(j));
            this.cfW.alt();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.cfW = null;
            this.cgh.clear();
            this.cgi.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final Class<?> cfX;
        private final Object cfY;
        private final Class<?> cfZ;
        private final Method cga;
        private final Object cgb;
        private final Method cgc;
        private final b cgd;
        private final int cge;
        private final j cgf;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.cfZ = Class.forName("android.view.Choreographer");
            this.cfX = Class.forName("android.view.Choreographer$FrameCallback");
            this.cgd = new b(this);
            this.cfY = Proxy.newProxyInstance(this.cfX.getClassLoader(), new Class[]{this.cfX}, this.cgd);
            this.cga = this.cfZ.getMethod("getInstance", new Class[0]);
            this.cgb = this.cga.invoke(null, new Object[0]);
            this.cgc = this.cfZ.getMethod("postFrameCallback", this.cfX);
            this.cge = i <= 0 ? 16 : i;
            this.cgf = jVar;
        }

        private void als() throws InvocationTargetException, IllegalAccessException {
            this.cgc.invoke(this.cgb, this.cfY);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void alt() {
            if (this.index >= this.cge) {
                com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cgf.au(a.this.alv());
                        a.this.cgd.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                als();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> alu() {
            return this.cgd.cgh;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.cgd.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> alv() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> alu = alu();
            int size = alu.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(alu.get(i2 + 1).longValue() - alu.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
