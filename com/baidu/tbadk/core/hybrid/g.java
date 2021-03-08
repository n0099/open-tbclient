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
    private a eZh = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g eZt = new g();
    }

    public static g brt() {
        return c.eZt;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.eZh = new a(i, jVar);
                this.eZh.bru();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a eZh;
        private final List<Long> eZr = new ArrayList(240);
        private final List<Integer> eZs = new ArrayList(15);

        public b(a aVar) {
            this.eZh = aVar;
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
            this.eZr.add(Long.valueOf(j));
            this.eZh.bru();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.eZh = null;
            this.eZr.clear();
            this.eZs.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> eZi;
        private final Object eZj;
        private final Class<?> eZk;
        private final Method eZl;
        private final Object eZm;
        private final Method eZn;
        private final b eZo;
        private final j eZp;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.eZk = Class.forName("android.view.Choreographer");
            this.eZi = Class.forName("android.view.Choreographer$FrameCallback");
            this.eZo = new b(this);
            this.eZj = Proxy.newProxyInstance(this.eZi.getClassLoader(), new Class[]{this.eZi}, this.eZo);
            this.eZl = this.eZk.getMethod("getInstance", new Class[0]);
            this.eZm = this.eZl.invoke(null, new Object[0]);
            this.eZn = this.eZk.getMethod("postFrameCallback", this.eZi);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.eZp = jVar;
        }

        private void kw() throws InvocationTargetException, IllegalAccessException {
            this.eZn.invoke(this.eZm, this.eZj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bru() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.eZp.by(a.this.brw());
                        a.this.eZo.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                kw();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> brv() {
            return this.eZo.eZr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.eZo.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> brw() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> brv = brv();
            int size = brv.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(brv.get(i2 + 1).longValue() - brv.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
