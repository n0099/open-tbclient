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
    private a bGD = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g bGP = new g();
    }

    public static g abw() {
        return c.bGP;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.bGD = new a(i, jVar);
                this.bGD.aby();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a bGD;
        private final List<Long> bGN = new ArrayList(240);
        private final List<Integer> bGO = new ArrayList(15);

        public b(a aVar) {
            this.bGD = aVar;
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
            this.bGN.add(Long.valueOf(j));
            this.bGD.aby();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.bGD = null;
            this.bGN.clear();
            this.bGO.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> bGE;
        private final Object bGF;
        private final Class<?> bGG;
        private final Method bGH;
        private final Object bGI;
        private final Method bGJ;
        private final b bGK;
        private final j bGL;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.bGG = Class.forName("android.view.Choreographer");
            this.bGE = Class.forName("android.view.Choreographer$FrameCallback");
            this.bGK = new b(this);
            this.bGF = Proxy.newProxyInstance(this.bGE.getClassLoader(), new Class[]{this.bGE}, this.bGK);
            this.bGH = this.bGG.getMethod("getInstance", new Class[0]);
            this.bGI = this.bGH.invoke(null, new Object[0]);
            this.bGJ = this.bGG.getMethod("postFrameCallback", this.bGE);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.bGL = jVar;
        }

        private void abx() throws InvocationTargetException, IllegalAccessException {
            this.bGJ.invoke(this.bGI, this.bGF);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aby() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bGL.Q(a.this.abA());
                        a.this.bGK.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                abx();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> abz() {
            return this.bGK.bGN;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.bGK.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> abA() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> abz = abz();
            int size = abz.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(abz.get(i2 + 1).longValue() - abz.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
