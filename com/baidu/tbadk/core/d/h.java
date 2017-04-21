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
    private a ach = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final h act = new h();
    }

    public static h up() {
        return c.act;
    }

    public void a(int i, l lVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.ach = new a(i, lVar, null);
                this.ach.ur();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a ach;
        private final List<Long> acr = new ArrayList(240);
        private final List<Integer> acs = new ArrayList(15);

        public b(a aVar) {
            this.ach = aVar;
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
            this.acr.add(Long.valueOf(j));
            this.ach.ur();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.ach = null;
            this.acr.clear();
            this.acs.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> aci;
        private final Object acj;
        private final Class<?> ack;
        private final Method acl;
        private final Object acm;
        private final Method acn;
        private final b aco;
        private final l acp;
        private int index;

        private a(int i, l lVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.ack = Class.forName("android.view.Choreographer");
            this.aci = Class.forName("android.view.Choreographer$FrameCallback");
            this.aco = new b(this);
            this.acj = Proxy.newProxyInstance(this.aci.getClassLoader(), new Class[]{this.aci}, this.aco);
            this.acl = this.ack.getMethod("getInstance", new Class[0]);
            this.acm = this.acl.invoke(null, new Object[0]);
            this.acn = this.ack.getMethod("postFrameCallback", this.aci);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.acp = lVar;
        }

        /* synthetic */ a(int i, l lVar, a aVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this(i, lVar);
        }

        private void uq() throws InvocationTargetException, IllegalAccessException {
            this.acn.invoke(this.acm, this.acj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ur() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.h.fS().post(new i(this));
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
            return this.aco.acr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.aco.destroy();
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
