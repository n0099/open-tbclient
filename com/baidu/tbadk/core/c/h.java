package com.baidu.tbadk.core.c;

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
    private a Ut = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final h UH = new h();
    }

    public static h sr() {
        return c.UH;
    }

    public void a(int i, l lVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.Ut = new a(i, lVar, null);
                this.Ut.st();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        private final List<Long> UF = new ArrayList(240);
        private final List<Integer> UG = new ArrayList(15);
        protected a Ut;

        public b(a aVar) {
            this.Ut = aVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            if ("doFrame".equals(name)) {
                switch (parameterTypes.length) {
                    case 1:
                        if (parameterTypes[0] == Long.TYPE) {
                            q(((Long) objArr[0]).longValue());
                            return null;
                        }
                        return null;
                    default:
                        return null;
                }
            }
            return null;
        }

        private void q(long j) {
            this.UF.add(Long.valueOf(j));
            this.Ut.st();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.Ut = null;
            this.UF.clear();
            this.UG.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final b UB;
        private final int UC;
        private final l UD;
        private final Class<?> Uu;
        private final Object Uv;
        private final Class<?> Uw;
        private final Method Ux;
        private final Object Uy;
        private final Method Uz;
        private int index;

        private a(int i, l lVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.Uw = Class.forName("android.view.Choreographer");
            this.Uu = Class.forName("android.view.Choreographer$FrameCallback");
            this.UB = new b(this);
            this.Uv = Proxy.newProxyInstance(this.Uu.getClassLoader(), new Class[]{this.Uu}, this.UB);
            this.Ux = this.Uw.getMethod("getInstance", new Class[0]);
            this.Uy = this.Ux.invoke(null, new Object[0]);
            this.Uz = this.Uw.getMethod("postFrameCallback", this.Uu);
            this.UC = i <= 0 ? 16 : i;
            this.UD = lVar;
        }

        /* synthetic */ a(int i, l lVar, a aVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this(i, lVar);
        }

        private void ss() throws InvocationTargetException, IllegalAccessException {
            this.Uz.invoke(this.Uy, this.Uv);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void st() {
            if (this.index >= this.UC) {
                com.baidu.adp.lib.h.h.dL().post(new i(this));
                return;
            }
            this.index++;
            try {
                ss();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> su() {
            return this.UB.UF;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.UB.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> sv() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> su = su();
            int size = su.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(su.get(i2 + 1).longValue() - su.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
