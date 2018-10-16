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
    private a atR = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g aud = new g();
    }

    public static g AR() {
        return c.aud;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.atR = new a(i, jVar);
                this.atR.AT();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a atR;
        private final List<Long> aub = new ArrayList(240);
        private final List<Integer> auc = new ArrayList(15);

        public b(a aVar) {
            this.atR = aVar;
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
            this.aub.add(Long.valueOf(j));
            this.atR.AT();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.atR = null;
            this.aub.clear();
            this.auc.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> atS;
        private final Object atT;
        private final Class<?> atU;
        private final Method atV;
        private final Object atW;
        private final Method atX;
        private final b atY;
        private final j atZ;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.atU = Class.forName("android.view.Choreographer");
            this.atS = Class.forName("android.view.Choreographer$FrameCallback");
            this.atY = new b(this);
            this.atT = Proxy.newProxyInstance(this.atS.getClassLoader(), new Class[]{this.atS}, this.atY);
            this.atV = this.atU.getMethod("getInstance", new Class[0]);
            this.atW = this.atV.invoke(null, new Object[0]);
            this.atX = this.atU.getMethod("postFrameCallback", this.atS);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.atZ = jVar;
        }

        private void AS() throws InvocationTargetException, IllegalAccessException {
            this.atX.invoke(this.atW, this.atT);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void AT() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.g.e.jI().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.atZ.G(a.this.AV());
                        a.this.atY.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                AS();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> AU() {
            return this.atY.aub;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.atY.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> AV() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> AU = AU();
            int size = AU.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(AU.get(i2 + 1).longValue() - AU.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
