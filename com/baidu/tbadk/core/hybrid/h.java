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
    private a aRy = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final h aRK = new h();
    }

    public static h Bg() {
        return c.aRK;
    }

    public void a(int i, k kVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.aRy = new a(i, kVar);
                this.aRy.Bi();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        private final List<Long> aRI = new ArrayList(240);
        private final List<Integer> aRJ = new ArrayList(15);
        protected a aRy;

        public b(a aVar) {
            this.aRy = aVar;
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
            this.aRI.add(Long.valueOf(j));
            this.aRy.Bi();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.aRy = null;
            this.aRI.clear();
            this.aRJ.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Object aRA;
        private final Class<?> aRB;
        private final Method aRC;
        private final Object aRD;
        private final Method aRE;
        private final b aRF;
        private final k aRG;
        private final Class<?> aRz;
        private int index;

        private a(int i, k kVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.aRB = Class.forName("android.view.Choreographer");
            this.aRz = Class.forName("android.view.Choreographer$FrameCallback");
            this.aRF = new b(this);
            this.aRA = Proxy.newProxyInstance(this.aRz.getClassLoader(), new Class[]{this.aRz}, this.aRF);
            this.aRC = this.aRB.getMethod("getInstance", new Class[0]);
            this.aRD = this.aRC.invoke(null, new Object[0]);
            this.aRE = this.aRB.getMethod("postFrameCallback", this.aRz);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.aRG = kVar;
        }

        private void Bh() throws InvocationTargetException, IllegalAccessException {
            this.aRE.invoke(this.aRD, this.aRA);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Bi() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.nr().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.h.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.aRG.z(a.this.Bk());
                        a.this.aRF.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                Bh();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> Bj() {
            return this.aRF.aRI;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.aRF.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> Bk() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> Bj = Bj();
            int size = Bj.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(Bj.get(i2 + 1).longValue() - Bj.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
