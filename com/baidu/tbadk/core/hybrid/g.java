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
    private a aye = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g ayq = new g();
    }

    public static g Cc() {
        return c.ayq;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.aye = new a(i, jVar);
                this.aye.Ce();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a aye;
        private final List<Long> ayo = new ArrayList(240);
        private final List<Integer> ayp = new ArrayList(15);

        public b(a aVar) {
            this.aye = aVar;
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
            this.ayo.add(Long.valueOf(j));
            this.aye.Ce();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.aye = null;
            this.ayo.clear();
            this.ayp.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> ayf;
        private final Object ayg;
        private final Class<?> ayh;
        private final Method ayi;
        private final Object ayj;
        private final Method ayk;
        private final b ayl;
        private final j aym;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.ayh = Class.forName("android.view.Choreographer");
            this.ayf = Class.forName("android.view.Choreographer$FrameCallback");
            this.ayl = new b(this);
            this.ayg = Proxy.newProxyInstance(this.ayf.getClassLoader(), new Class[]{this.ayf}, this.ayl);
            this.ayi = this.ayh.getMethod("getInstance", new Class[0]);
            this.ayj = this.ayi.invoke(null, new Object[0]);
            this.ayk = this.ayh.getMethod("postFrameCallback", this.ayf);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.aym = jVar;
        }

        private void Cd() throws InvocationTargetException, IllegalAccessException {
            this.ayk.invoke(this.ayj, this.ayg);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Ce() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.aym.F(a.this.Cg());
                        a.this.ayl.destroy();
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
            return this.ayl.ayo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.ayl.destroy();
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
