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
    private a ayI = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g ayU = new g();
    }

    public static g Cp() {
        return c.ayU;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.ayI = new a(i, jVar);
                this.ayI.Cr();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a ayI;
        private final List<Long> ayS = new ArrayList(240);
        private final List<Integer> ayT = new ArrayList(15);

        public b(a aVar) {
            this.ayI = aVar;
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
            this.ayS.add(Long.valueOf(j));
            this.ayI.Cr();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.ayI = null;
            this.ayS.clear();
            this.ayT.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> ayJ;
        private final Object ayK;
        private final Class<?> ayL;
        private final Method ayM;
        private final Object ayN;
        private final Method ayO;
        private final b ayP;
        private final j ayQ;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.ayL = Class.forName("android.view.Choreographer");
            this.ayJ = Class.forName("android.view.Choreographer$FrameCallback");
            this.ayP = new b(this);
            this.ayK = Proxy.newProxyInstance(this.ayJ.getClassLoader(), new Class[]{this.ayJ}, this.ayP);
            this.ayM = this.ayL.getMethod("getInstance", new Class[0]);
            this.ayN = this.ayM.invoke(null, new Object[0]);
            this.ayO = this.ayL.getMethod("postFrameCallback", this.ayJ);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.ayQ = jVar;
        }

        private void Cq() throws InvocationTargetException, IllegalAccessException {
            this.ayO.invoke(this.ayN, this.ayK);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Cr() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.ayQ.F(a.this.Ct());
                        a.this.ayP.destroy();
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
            return this.ayP.ayS;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.ayP.destroy();
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
