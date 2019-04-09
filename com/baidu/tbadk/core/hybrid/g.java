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
    private a bGE = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g bGQ = new g();
    }

    public static g abw() {
        return c.bGQ;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.bGE = new a(i, jVar);
                this.bGE.aby();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a bGE;
        private final List<Long> bGO = new ArrayList(240);
        private final List<Integer> bGP = new ArrayList(15);

        public b(a aVar) {
            this.bGE = aVar;
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
            this.bGO.add(Long.valueOf(j));
            this.bGE.aby();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.bGE = null;
            this.bGO.clear();
            this.bGP.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> bGF;
        private final Object bGG;
        private final Class<?> bGH;
        private final Method bGI;
        private final Object bGJ;
        private final Method bGK;
        private final b bGL;
        private final j bGM;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.bGH = Class.forName("android.view.Choreographer");
            this.bGF = Class.forName("android.view.Choreographer$FrameCallback");
            this.bGL = new b(this);
            this.bGG = Proxy.newProxyInstance(this.bGF.getClassLoader(), new Class[]{this.bGF}, this.bGL);
            this.bGI = this.bGH.getMethod("getInstance", new Class[0]);
            this.bGJ = this.bGI.invoke(null, new Object[0]);
            this.bGK = this.bGH.getMethod("postFrameCallback", this.bGF);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.bGM = jVar;
        }

        private void abx() throws InvocationTargetException, IllegalAccessException {
            this.bGK.invoke(this.bGJ, this.bGG);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aby() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bGM.Q(a.this.abA());
                        a.this.bGL.destroy();
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
            return this.bGL.bGO;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.bGL.destroy();
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
