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
    private a bPM = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g bPY = new g();
    }

    public static g ahw() {
        return c.bPY;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.bPM = new a(i, jVar);
                this.bPM.ahy();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a bPM;
        private final List<Long> bPW = new ArrayList(240);
        private final List<Integer> bPX = new ArrayList(15);

        public b(a aVar) {
            this.bPM = aVar;
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
            this.bPW.add(Long.valueOf(j));
            this.bPM.ahy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.bPM = null;
            this.bPW.clear();
            this.bPX.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> bPN;
        private final Object bPO;
        private final Class<?> bPP;
        private final Method bPQ;
        private final Object bPR;
        private final Method bPS;
        private final b bPT;
        private final j bPU;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.bPP = Class.forName("android.view.Choreographer");
            this.bPN = Class.forName("android.view.Choreographer$FrameCallback");
            this.bPT = new b(this);
            this.bPO = Proxy.newProxyInstance(this.bPN.getClassLoader(), new Class[]{this.bPN}, this.bPT);
            this.bPQ = this.bPP.getMethod("getInstance", new Class[0]);
            this.bPR = this.bPQ.invoke(null, new Object[0]);
            this.bPS = this.bPP.getMethod("postFrameCallback", this.bPN);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.bPU = jVar;
        }

        private void ahx() throws InvocationTargetException, IllegalAccessException {
            this.bPS.invoke(this.bPR, this.bPO);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ahy() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bPU.X(a.this.ahA());
                        a.this.bPT.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                ahx();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> ahz() {
            return this.bPT.bPW;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.bPT.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> ahA() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> ahz = ahz();
            int size = ahz.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(ahz.get(i2 + 1).longValue() - ahz.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
