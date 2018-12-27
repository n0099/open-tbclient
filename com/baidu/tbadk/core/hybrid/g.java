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
    private a ayf = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g ayr = new g();
    }

    public static g Cc() {
        return c.ayr;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.ayf = new a(i, jVar);
                this.ayf.Ce();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a ayf;
        private final List<Long> ayp = new ArrayList(240);
        private final List<Integer> ayq = new ArrayList(15);

        public b(a aVar) {
            this.ayf = aVar;
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
            this.ayp.add(Long.valueOf(j));
            this.ayf.Ce();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.ayf = null;
            this.ayp.clear();
            this.ayq.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> ayg;
        private final Object ayh;
        private final Class<?> ayi;
        private final Method ayj;
        private final Object ayk;
        private final Method ayl;
        private final b aym;
        private final j ayn;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.ayi = Class.forName("android.view.Choreographer");
            this.ayg = Class.forName("android.view.Choreographer$FrameCallback");
            this.aym = new b(this);
            this.ayh = Proxy.newProxyInstance(this.ayg.getClassLoader(), new Class[]{this.ayg}, this.aym);
            this.ayj = this.ayi.getMethod("getInstance", new Class[0]);
            this.ayk = this.ayj.invoke(null, new Object[0]);
            this.ayl = this.ayi.getMethod("postFrameCallback", this.ayg);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.ayn = jVar;
        }

        private void Cd() throws InvocationTargetException, IllegalAccessException {
            this.ayl.invoke(this.ayk, this.ayh);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Ce() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.ayn.F(a.this.Cg());
                        a.this.aym.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                Cd();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> Cf() {
            return this.aym.ayp;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.aym.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> Cg() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> Cf = Cf();
            int size = Cf.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(Cf.get(i2 + 1).longValue() - Cf.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
