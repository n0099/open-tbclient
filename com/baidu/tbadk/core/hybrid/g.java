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
    private a ayH = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g ayT = new g();
    }

    public static g Cp() {
        return c.ayT;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.ayH = new a(i, jVar);
                this.ayH.Cr();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a ayH;
        private final List<Long> ayR = new ArrayList(240);
        private final List<Integer> ayS = new ArrayList(15);

        public b(a aVar) {
            this.ayH = aVar;
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
            this.ayR.add(Long.valueOf(j));
            this.ayH.Cr();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.ayH = null;
            this.ayR.clear();
            this.ayS.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> ayI;
        private final Object ayJ;
        private final Class<?> ayK;
        private final Method ayL;
        private final Object ayM;
        private final Method ayN;
        private final b ayO;
        private final j ayP;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.ayK = Class.forName("android.view.Choreographer");
            this.ayI = Class.forName("android.view.Choreographer$FrameCallback");
            this.ayO = new b(this);
            this.ayJ = Proxy.newProxyInstance(this.ayI.getClassLoader(), new Class[]{this.ayI}, this.ayO);
            this.ayL = this.ayK.getMethod("getInstance", new Class[0]);
            this.ayM = this.ayL.invoke(null, new Object[0]);
            this.ayN = this.ayK.getMethod("postFrameCallback", this.ayI);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.ayP = jVar;
        }

        private void Cq() throws InvocationTargetException, IllegalAccessException {
            this.ayN.invoke(this.ayM, this.ayJ);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Cr() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.ayP.F(a.this.Ct());
                        a.this.ayO.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                Cq();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> Cs() {
            return this.ayO.ayR;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.ayO.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> Ct() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> Cs = Cs();
            int size = Cs.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(Cs.get(i2 + 1).longValue() - Cs.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
