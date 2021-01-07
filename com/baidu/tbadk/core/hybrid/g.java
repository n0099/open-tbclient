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
    private a fad = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g fap = new g();
    }

    public static g buT() {
        return c.fap;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.fad = new a(i, jVar);
                this.fad.buU();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a fad;
        private final List<Long> fan = new ArrayList(240);
        private final List<Integer> fao = new ArrayList(15);

        public b(a aVar) {
            this.fad = aVar;
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
            this.fan.add(Long.valueOf(j));
            this.fad.buU();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.fad = null;
            this.fan.clear();
            this.fao.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> fae;
        private final Object faf;
        private final Class<?> fag;
        private final Method fah;
        private final Object fai;
        private final Method faj;
        private final b fak;
        private final j fal;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.fag = Class.forName("android.view.Choreographer");
            this.fae = Class.forName("android.view.Choreographer$FrameCallback");
            this.fak = new b(this);
            this.faf = Proxy.newProxyInstance(this.fae.getClassLoader(), new Class[]{this.fae}, this.fak);
            this.fah = this.fag.getMethod("getInstance", new Class[0]);
            this.fai = this.fah.invoke(null, new Object[0]);
            this.faj = this.fag.getMethod("postFrameCallback", this.fae);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.fal = jVar;
        }

        private void kx() throws InvocationTargetException, IllegalAccessException {
            this.faj.invoke(this.fai, this.faf);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void buU() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.fal.bD(a.this.buW());
                        a.this.fak.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                kx();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> buV() {
            return this.fak.fan;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.fak.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> buW() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> buV = buV();
            int size = buV.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(buV.get(i2 + 1).longValue() - buV.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
