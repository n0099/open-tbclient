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
public class h {
    private a aRA = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final h aRM = new h();
    }

    public static h AZ() {
        return c.aRM;
    }

    public void a(int i, k kVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.aRA = new a(i, kVar);
                this.aRA.Bb();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a aRA;
        private final List<Long> aRK = new ArrayList(240);
        private final List<Integer> aRL = new ArrayList(15);

        public b(a aVar) {
            this.aRA = aVar;
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
            this.aRK.add(Long.valueOf(j));
            this.aRA.Bb();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.aRA = null;
            this.aRK.clear();
            this.aRL.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> aRB;
        private final Object aRC;
        private final Class<?> aRD;
        private final Method aRE;
        private final Object aRF;
        private final Method aRG;
        private final b aRH;
        private final k aRI;
        private int index;

        private a(int i, k kVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.aRD = Class.forName("android.view.Choreographer");
            this.aRB = Class.forName("android.view.Choreographer$FrameCallback");
            this.aRH = new b(this);
            this.aRC = Proxy.newProxyInstance(this.aRB.getClassLoader(), new Class[]{this.aRB}, this.aRH);
            this.aRE = this.aRD.getMethod("getInstance", new Class[0]);
            this.aRF = this.aRE.invoke(null, new Object[0]);
            this.aRG = this.aRD.getMethod("postFrameCallback", this.aRB);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.aRI = kVar;
        }

        private void Ba() throws InvocationTargetException, IllegalAccessException {
            this.aRG.invoke(this.aRF, this.aRC);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Bb() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.h.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.aRI.z(a.this.Bd());
                        a.this.aRH.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                Ba();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> Bc() {
            return this.aRH.aRK;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.aRH.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> Bd() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> Bc = Bc();
            int size = Bc.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(Bc.get(i2 + 1).longValue() - Bc.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
