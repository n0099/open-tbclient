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
    private a bOf = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g bOr = new g();
    }

    public static g ago() {
        return c.bOr;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.bOf = new a(i, jVar);
                this.bOf.agq();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a bOf;
        private final List<Long> bOp = new ArrayList(240);
        private final List<Integer> bOq = new ArrayList(15);

        public b(a aVar) {
            this.bOf = aVar;
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
            this.bOp.add(Long.valueOf(j));
            this.bOf.agq();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.bOf = null;
            this.bOp.clear();
            this.bOq.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> bOg;
        private final Object bOh;
        private final Class<?> bOi;
        private final Method bOj;
        private final Object bOk;
        private final Method bOl;
        private final b bOm;
        private final j bOn;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.bOi = Class.forName("android.view.Choreographer");
            this.bOg = Class.forName("android.view.Choreographer$FrameCallback");
            this.bOm = new b(this);
            this.bOh = Proxy.newProxyInstance(this.bOg.getClassLoader(), new Class[]{this.bOg}, this.bOm);
            this.bOj = this.bOi.getMethod("getInstance", new Class[0]);
            this.bOk = this.bOj.invoke(null, new Object[0]);
            this.bOl = this.bOi.getMethod("postFrameCallback", this.bOg);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.bOn = jVar;
        }

        private void agp() throws InvocationTargetException, IllegalAccessException {
            this.bOl.invoke(this.bOk, this.bOh);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void agq() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bOn.X(a.this.ags());
                        a.this.bOm.destroy();
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
            return this.bOm.bOp;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.bOm.destroy();
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
