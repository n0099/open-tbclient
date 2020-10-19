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
    private a evG = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g evS = new g();
    }

    public static g blq() {
        return c.evS;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.evG = new a(i, jVar);
                this.evG.blr();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a evG;
        private final List<Long> evQ = new ArrayList(240);
        private final List<Integer> evR = new ArrayList(15);

        public b(a aVar) {
            this.evG = aVar;
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
            this.evQ.add(Long.valueOf(j));
            this.evG.blr();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.evG = null;
            this.evQ.clear();
            this.evR.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> evH;
        private final Object evI;
        private final Class<?> evJ;
        private final Method evK;
        private final Object evL;
        private final Method evM;
        private final b evN;
        private final j evO;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.evJ = Class.forName("android.view.Choreographer");
            this.evH = Class.forName("android.view.Choreographer$FrameCallback");
            this.evN = new b(this);
            this.evI = Proxy.newProxyInstance(this.evH.getClassLoader(), new Class[]{this.evH}, this.evN);
            this.evK = this.evJ.getMethod("getInstance", new Class[0]);
            this.evL = this.evK.invoke(null, new Object[0]);
            this.evM = this.evJ.getMethod("postFrameCallback", this.evH);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.evO = jVar;
        }

        private void kY() throws InvocationTargetException, IllegalAccessException {
            this.evM.invoke(this.evL, this.evI);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void blr() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.evO.bb(a.this.blt());
                        a.this.evN.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                kY();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> bls() {
            return this.evN.evQ;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.evN.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> blt() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> bls = bls();
            int size = bls.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(bls.get(i2 + 1).longValue() - bls.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
