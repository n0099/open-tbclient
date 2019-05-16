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
    private a bOe = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g bOq = new g();
    }

    public static g ago() {
        return c.bOq;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.bOe = new a(i, jVar);
                this.bOe.agq();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a bOe;
        private final List<Long> bOo = new ArrayList(240);
        private final List<Integer> bOp = new ArrayList(15);

        public b(a aVar) {
            this.bOe = aVar;
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
            this.bOo.add(Long.valueOf(j));
            this.bOe.agq();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.bOe = null;
            this.bOo.clear();
            this.bOp.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> bOf;
        private final Object bOg;
        private final Class<?> bOh;
        private final Method bOi;
        private final Object bOj;
        private final Method bOk;
        private final b bOl;
        private final j bOm;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.bOh = Class.forName("android.view.Choreographer");
            this.bOf = Class.forName("android.view.Choreographer$FrameCallback");
            this.bOl = new b(this);
            this.bOg = Proxy.newProxyInstance(this.bOf.getClassLoader(), new Class[]{this.bOf}, this.bOl);
            this.bOi = this.bOh.getMethod("getInstance", new Class[0]);
            this.bOj = this.bOi.invoke(null, new Object[0]);
            this.bOk = this.bOh.getMethod("postFrameCallback", this.bOf);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.bOm = jVar;
        }

        private void agp() throws InvocationTargetException, IllegalAccessException {
            this.bOk.invoke(this.bOj, this.bOg);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void agq() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bOm.X(a.this.ags());
                        a.this.bOl.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                agp();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> agr() {
            return this.bOl.bOo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.bOl.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> ags() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> agr = agr();
            int size = agr.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(agr.get(i2 + 1).longValue() - agr.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
