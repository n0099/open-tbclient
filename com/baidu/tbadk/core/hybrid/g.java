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
    private a aer = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g aeD = new g();
    }

    public static g ua() {
        return c.aeD;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.aer = new a(i, jVar);
                this.aer.uc();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        private final List<Long> aeB = new ArrayList(240);
        private final List<Integer> aeC = new ArrayList(15);
        protected a aer;

        public b(a aVar) {
            this.aer = aVar;
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
            this.aeB.add(Long.valueOf(j));
            this.aer.uc();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.aer = null;
            this.aeB.clear();
            this.aeC.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> aes;
        private final Object aet;
        private final Class<?> aeu;
        private final Method aev;
        private final Object aew;
        private final Method aex;
        private final b aey;
        private final j aez;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.aeu = Class.forName("android.view.Choreographer");
            this.aes = Class.forName("android.view.Choreographer$FrameCallback");
            this.aey = new b(this);
            this.aet = Proxy.newProxyInstance(this.aes.getClassLoader(), new Class[]{this.aes}, this.aey);
            this.aev = this.aeu.getMethod("getInstance", new Class[0]);
            this.aew = this.aev.invoke(null, new Object[0]);
            this.aex = this.aeu.getMethod("postFrameCallback", this.aes);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.aez = jVar;
        }

        private void ub() throws InvocationTargetException, IllegalAccessException {
            this.aex.invoke(this.aew, this.aet);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void uc() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.fw().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.aez.t(a.this.ue());
                        a.this.aey.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                ub();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> ud() {
            return this.aey.aeB;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.aey.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> ue() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> ud = ud();
            int size = ud.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(ud.get(i2 + 1).longValue() - ud.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
