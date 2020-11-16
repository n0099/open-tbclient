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
    private a eIT = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g eJf = new g();
    }

    public static g boW() {
        return c.eJf;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.eIT = new a(i, jVar);
                this.eIT.boX();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a eIT;
        private final List<Long> eJd = new ArrayList(240);
        private final List<Integer> eJe = new ArrayList(15);

        public b(a aVar) {
            this.eIT = aVar;
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
            this.eJd.add(Long.valueOf(j));
            this.eIT.boX();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.eIT = null;
            this.eJd.clear();
            this.eJe.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> eIU;
        private final Object eIV;
        private final Class<?> eIW;
        private final Method eIX;
        private final Object eIY;
        private final Method eIZ;
        private final b eJa;
        private final j eJb;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.eIW = Class.forName("android.view.Choreographer");
            this.eIU = Class.forName("android.view.Choreographer$FrameCallback");
            this.eJa = new b(this);
            this.eIV = Proxy.newProxyInstance(this.eIU.getClassLoader(), new Class[]{this.eIU}, this.eJa);
            this.eIX = this.eIW.getMethod("getInstance", new Class[0]);
            this.eIY = this.eIX.invoke(null, new Object[0]);
            this.eIZ = this.eIW.getMethod("postFrameCallback", this.eIU);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.eJb = jVar;
        }

        private void kY() throws InvocationTargetException, IllegalAccessException {
            this.eIZ.invoke(this.eIY, this.eIV);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void boX() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.eJb.bs(a.this.boZ());
                        a.this.eJa.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                kY();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> boY() {
            return this.eJa.eJd;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.eJa.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> boZ() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> boY = boY();
            int size = boY.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(boY.get(i2 + 1).longValue() - boY.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
