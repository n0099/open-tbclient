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
    private a dwh = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g dwt = new g();
    }

    public static g aNy() {
        return c.dwt;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.dwh = new a(i, jVar);
                this.dwh.aNz();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a dwh;
        private final List<Long> dwr = new ArrayList(240);
        private final List<Integer> dws = new ArrayList(15);

        public b(a aVar) {
            this.dwh = aVar;
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
            this.dwr.add(Long.valueOf(j));
            this.dwh.aNz();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.dwh = null;
            this.dwr.clear();
            this.dws.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> dwi;
        private final Object dwj;
        private final Class<?> dwk;
        private final Method dwl;
        private final Object dwm;
        private final Method dwn;
        private final b dwo;
        private final j dwp;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.dwk = Class.forName("android.view.Choreographer");
            this.dwi = Class.forName("android.view.Choreographer$FrameCallback");
            this.dwo = new b(this);
            this.dwj = Proxy.newProxyInstance(this.dwi.getClassLoader(), new Class[]{this.dwi}, this.dwo);
            this.dwl = this.dwk.getMethod("getInstance", new Class[0]);
            this.dwm = this.dwl.invoke(null, new Object[0]);
            this.dwn = this.dwk.getMethod("postFrameCallback", this.dwi);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.dwp = jVar;
        }

        private void jh() throws InvocationTargetException, IllegalAccessException {
            this.dwn.invoke(this.dwm, this.dwj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aNz() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.f.e.lb().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.dwp.aJ(a.this.aNB());
                        a.this.dwo.destroy();
                        a.this.destroy();
                    }
                });
                return;
            }
            this.index++;
            try {
                jh();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        private List<Long> aNA() {
            return this.dwo.dwr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.dwo.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> aNB() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> aNA = aNA();
            int size = aNA.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(aNA.get(i2 + 1).longValue() - aNA.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
