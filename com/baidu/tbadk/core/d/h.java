package com.baidu.tbadk.core.d;

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
    private a acg = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final h acs = new h();
    }

    public static h up() {
        return c.acs;
    }

    public void a(int i, l lVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.acg = new a(i, lVar, null);
                this.acg.ur();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a acg;
        private final List<Long> acq = new ArrayList(240);
        private final List<Integer> acr = new ArrayList(15);

        public b(a aVar) {
            this.acg = aVar;
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
            this.acq.add(Long.valueOf(j));
            this.acg.ur();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.acg = null;
            this.acq.clear();
            this.acr.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> ach;
        private final Object aci;
        private final Class<?> acj;
        private final Method ack;
        private final Object acl;
        private final Method acm;
        private final b acn;
        private final l aco;
        private int index;

        private a(int i, l lVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.acj = Class.forName("android.view.Choreographer");
            this.ach = Class.forName("android.view.Choreographer$FrameCallback");
            this.acn = new b(this);
            this.aci = Proxy.newProxyInstance(this.ach.getClassLoader(), new Class[]{this.ach}, this.acn);
            this.ack = this.acj.getMethod("getInstance", new Class[0]);
            this.acl = this.ack.invoke(null, new Object[0]);
            this.acm = this.acj.getMethod("postFrameCallback", this.ach);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.aco = lVar;
        }

        /* synthetic */ a(int i, l lVar, a aVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this(i, lVar);
        }

        private void uq() throws InvocationTargetException, IllegalAccessException {
            this.acm.invoke(this.acl, this.aci);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ur() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.h.fR().post(new i(this));
                return;
            }
            this.index++;
            try {
                uq();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> us() {
            return this.acn.acq;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.acn.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> ut() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> us = us();
            int size = us.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(us.get(i2 + 1).longValue() - us.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
