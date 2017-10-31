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
    private a acT = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final h adg = new h();
    }

    public static h tG() {
        return c.adg;
    }

    public void a(int i, k kVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.acT = new a(i, kVar);
                this.acT.tI();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a acT;
        private final List<Long> ade = new ArrayList(240);
        private final List<Integer> adf = new ArrayList(15);

        public b(a aVar) {
            this.acT = aVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            if ("doFrame".equals(name)) {
                switch (parameterTypes.length) {
                    case 1:
                        if (parameterTypes[0] == Long.TYPE) {
                            o(((Long) objArr[0]).longValue());
                            return null;
                        }
                        return null;
                    default:
                        return null;
                }
            }
            return null;
        }

        private void o(long j) {
            this.ade.add(Long.valueOf(j));
            this.acT.tI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.acT = null;
            this.ade.clear();
            this.adf.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> acU;
        private final Object acV;
        private final Class<?> acW;
        private final Method acX;
        private final Object acY;
        private final Method acZ;
        private final b ada;
        private final k adb;
        private int index;

        private a(int i, k kVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.acW = Class.forName("android.view.Choreographer");
            this.acU = Class.forName("android.view.Choreographer$FrameCallback");
            this.ada = new b(this);
            this.acV = Proxy.newProxyInstance(this.acU.getClassLoader(), new Class[]{this.acU}, this.ada);
            this.acX = this.acW.getMethod("getInstance", new Class[0]);
            this.acY = this.acX.invoke(null, new Object[0]);
            this.acZ = this.acW.getMethod("postFrameCallback", this.acU);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.adb = kVar;
        }

        private void tH() throws InvocationTargetException, IllegalAccessException {
            this.acZ.invoke(this.acY, this.acV);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void tI() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.h.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.adb.o(a.this.tK());
                        a.this.ada.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                tH();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> tJ() {
            return this.ada.ade;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.ada.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> tK() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> tJ = tJ();
            int size = tJ.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(tJ.get(i2 + 1).longValue() - tJ.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
