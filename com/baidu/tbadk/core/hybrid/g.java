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
    private a dwl = null;

    /* loaded from: classes.dex */
    private static final class c {
        private static final g dwx = new g();
    }

    public static g aNw() {
        return c.dwx;
    }

    public void a(int i, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                this.dwl = new a(i, jVar);
                this.dwl.aNx();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements InvocationHandler {
        protected a dwl;
        private final List<Long> dwv = new ArrayList(240);
        private final List<Integer> dww = new ArrayList(15);

        public b(a aVar) {
            this.dwl = aVar;
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
            this.dwv.add(Long.valueOf(j));
            this.dwl.aNx();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.dwl = null;
            this.dwv.clear();
            this.dww.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final int MAX_FRAME_COUNT;
        private final Class<?> dwm;
        private final Object dwn;
        private final Class<?> dwo;
        private final Method dwp;
        private final Object dwq;
        private final Method dwr;
        private final b dws;
        private final j dwt;
        private int index;

        private a(int i, j jVar) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            this.index = 0;
            this.dwo = Class.forName("android.view.Choreographer");
            this.dwm = Class.forName("android.view.Choreographer$FrameCallback");
            this.dws = new b(this);
            this.dwn = Proxy.newProxyInstance(this.dwm.getClassLoader(), new Class[]{this.dwm}, this.dws);
            this.dwp = this.dwo.getMethod("getInstance", new Class[0]);
            this.dwq = this.dwp.invoke(null, new Object[0]);
            this.dwr = this.dwo.getMethod("postFrameCallback", this.dwm);
            this.MAX_FRAME_COUNT = i <= 0 ? 16 : i;
            this.dwt = jVar;
        }

        private void jh() throws InvocationTargetException, IllegalAccessException {
            this.dwr.invoke(this.dwq, this.dwn);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aNx() {
            if (this.index >= this.MAX_FRAME_COUNT) {
                com.baidu.adp.lib.f.e.lb().post(new Runnable() { // from class: com.baidu.tbadk.core.hybrid.g.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.dwt.aJ(a.this.aNz());
                        a.this.dws.destroy();
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

        private List<Long> aNy() {
            return this.dws.dwv;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.dws.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Long> aNz() {
            ArrayList arrayList = new ArrayList(24);
            List<Long> aNy = aNy();
            int size = aNy.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    arrayList.add(Long.valueOf(aNy.get(i2 + 1).longValue() - aNy.get(i2).longValue()));
                    i = i2 + 1;
                } else {
                    return arrayList;
                }
            }
        }
    }
}
