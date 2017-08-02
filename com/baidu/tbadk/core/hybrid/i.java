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
public class i {
    private a acb = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final i acn = new i();
    }

    public static i tF() {
        return c.acn;
    }

    public void a(int i, m mVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.acb = new a(i, mVar);
                this.acb.tH();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a acb;
        private final List<Long> acl = new ArrayList(240);
        private final List<Integer> acm = new ArrayList(15);

        public b(a aVar) {
            this.acb = aVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            if ("doFrame".equals(name)) {
                switch (parameterTypes.length) {
                    case 1:
                        if (parameterTypes[0] == Long.TYPE) {
                            n(((Long) objArr[0]).longValue());
                            return null;
                        }
                        return null;
                    default:
                        return null;
                }
            }
            return null;
        }

        private void n(long j) {
            this.acl.add(Long.valueOf(j));
            this.acb.tH();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.acb = null;
            this.acl.clear();
            this.acm.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> acc;
        private final Object acd;
        private final Class<?> ace;
        private final Method acf;
        private final Object acg;
        private final Method ach;
        private final b aci;
        private final m acj;
        private int index;

        private a(int i, m mVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.ace = Class.forName("android.view.Choreographer");
            this.acc = Class.forName("android.view.Choreographer$FrameCallback");
            this.aci = new b(this);
            this.acd = Proxy.newProxyInstance(this.acc.getClassLoader(), new Class[]{this.acc}, this.aci);
            this.acf = this.ace.getMethod("getInstance", new Class[0]);
            this.acg = this.acf.invoke(null, new Object[0]);
            this.ach = this.ace.getMethod("postFrameCallback", this.acc);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.acj = mVar;
        }

        private void tG() throws InvocationTargetException, IllegalAccessException {
            this.ach.invoke(this.acg, this.acd);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void tH() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.i.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.acj.n(a.this.tJ());
                        a.this.aci.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                tG();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> tI() {
            return this.aci.acl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.aci.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> tJ() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> tI = tI();
            int size = tI.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(tI.get(i2 + 1).longValue() - tI.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
