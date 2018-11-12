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
    private a auE = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g auQ = new g();
    }

    public static g AY() {
        return c.auQ;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.auE = new a(i, jVar);
                this.auE.Ba();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a auE;
        private final List<Long> auO = new ArrayList(240);
        private final List<Integer> auP = new ArrayList(15);

        public b(a aVar) {
            this.auE = aVar;
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
            this.auO.add(Long.valueOf(j));
            this.auE.Ba();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.auE = null;
            this.auO.clear();
            this.auP.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> auF;
        private final Object auG;
        private final Class<?> auH;
        private final Method auI;
        private final Object auJ;
        private final Method auK;
        private final b auL;
        private final j auM;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.auH = Class.forName("android.view.Choreographer");
            this.auF = Class.forName("android.view.Choreographer$FrameCallback");
            this.auL = new b(this);
            this.auG = Proxy.newProxyInstance(this.auF.getClassLoader(), new Class[]{this.auF}, this.auL);
            this.auI = this.auH.getMethod("getInstance", new Class[0]);
            this.auJ = this.auI.invoke(null, new Object[0]);
            this.auK = this.auH.getMethod("postFrameCallback", this.auF);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.auM = jVar;
        }

        private void AZ() throws InvocationTargetException, IllegalAccessException {
            this.auK.invoke(this.auJ, this.auG);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Ba() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.auM.F(a.this.Bc());
                        a.this.auL.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                AZ();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> Bb() {
            return this.auL.auO;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.auL.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> Bc() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> Bb = Bb();
            int size = Bb.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(Bb.get(i2 + 1).longValue() - Bb.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
