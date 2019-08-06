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
    private a bPl = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g bPx = new g();
    }

    public static g ahs() {
        return c.bPx;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.bPl = new a(i, jVar);
                this.bPl.ahu();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a bPl;
        private final List<Long> bPv = new ArrayList(240);
        private final List<Integer> bPw = new ArrayList(15);

        public b(a aVar) {
            this.bPl = aVar;
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
            this.bPv.add(Long.valueOf(j));
            this.bPl.ahu();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.bPl = null;
            this.bPv.clear();
            this.bPw.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> bPm;
        private final Object bPn;
        private final Class<?> bPo;
        private final Method bPp;
        private final Object bPq;
        private final Method bPr;
        private final b bPs;
        private final j bPt;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.bPo = Class.forName("android.view.Choreographer");
            this.bPm = Class.forName("android.view.Choreographer$FrameCallback");
            this.bPs = new b(this);
            this.bPn = Proxy.newProxyInstance(this.bPm.getClassLoader(), new Class[]{this.bPm}, this.bPs);
            this.bPp = this.bPo.getMethod("getInstance", new Class[0]);
            this.bPq = this.bPp.invoke(null, new Object[0]);
            this.bPr = this.bPo.getMethod("postFrameCallback", this.bPm);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.bPt = jVar;
        }

        private void aht() throws InvocationTargetException, IllegalAccessException {
            this.bPr.invoke(this.bPq, this.bPn);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ahu() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bPt.X(a.this.ahw());
                        a.this.bPs.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                aht();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> ahv() {
            return this.bPs.bPv;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.bPs.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> ahw() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> ahv = ahv();
            int size = ahv.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(ahv.get(i2 + 1).longValue() - ahv.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
