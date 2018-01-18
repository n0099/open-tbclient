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
    private a aRx = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final h aRJ = new h();
    }

    public static h AY() {
        return c.aRJ;
    }

    public void a(int i, k kVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.aRx = new a(i, kVar);
                this.aRx.Ba();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        private final List<Long> aRH = new ArrayList(240);
        private final List<Integer> aRI = new ArrayList(15);
        protected a aRx;

        public b(a aVar) {
            this.aRx = aVar;
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
            this.aRH.add(Long.valueOf(j));
            this.aRx.Ba();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.aRx = null;
            this.aRH.clear();
            this.aRI.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> aRA;
        private final Method aRB;
        private final Object aRC;
        private final Method aRD;
        private final b aRE;
        private final k aRF;
        private final Class<?> aRy;
        private final Object aRz;
        private int index;

        private a(int i, k kVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.aRA = Class.forName("android.view.Choreographer");
            this.aRy = Class.forName("android.view.Choreographer$FrameCallback");
            this.aRE = new b(this);
            this.aRz = Proxy.newProxyInstance(this.aRy.getClassLoader(), new Class[]{this.aRy}, this.aRE);
            this.aRB = this.aRA.getMethod("getInstance", new Class[0]);
            this.aRC = this.aRB.invoke(null, new Object[0]);
            this.aRD = this.aRA.getMethod("postFrameCallback", this.aRy);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.aRF = kVar;
        }

        private void AZ() throws InvocationTargetException, IllegalAccessException {
            this.aRD.invoke(this.aRC, this.aRz);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Ba() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.nr().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.h.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.aRF.z(a.this.Bc());
                        a.this.aRE.destroy();
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
            return this.aRE.aRH;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.aRE.destroy();
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
