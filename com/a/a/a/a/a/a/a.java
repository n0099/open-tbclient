package com.a.a.a.a.a.a;

import java.io.PrintWriter;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public final class a {
    static final int b;
    static final AbstractC0007a zr;

    /* renamed from: com.a.a.a.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    static abstract class AbstractC0007a {
        protected static final Throwable[] zs = new Throwable[0];

        AbstractC0007a() {
        }

        public abstract void a(Throwable th);

        public abstract void a(Throwable th, PrintWriter printWriter);
    }

    /* loaded from: classes11.dex */
    static final class b {
        private final ConcurrentHashMap<C0008a, List<Throwable>> a = new ConcurrentHashMap<>(16, 0.75f, 10);
        private final ReferenceQueue<Throwable> zt = new ReferenceQueue<>();

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.a.a.a.a.a.a.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static final class C0008a extends WeakReference<Throwable> {
            private final int a;

            public C0008a(Throwable th) {
                super(th, null);
                if (th == null) {
                    throw new NullPointerException("The referent cannot be null");
                }
                this.a = System.identityHashCode(th);
            }

            public final boolean equals(Object obj) {
                if (obj == null || obj.getClass() != getClass()) {
                    return false;
                }
                if (this != obj) {
                    C0008a c0008a = (C0008a) obj;
                    return this.a == c0008a.a && get() == c0008a.get();
                }
                return true;
            }

            public final int hashCode() {
                return this.a;
            }
        }

        b() {
        }

        public final List<Throwable> f(Throwable th) {
            Reference<? extends Throwable> poll = this.zt.poll();
            while (poll != null) {
                this.a.remove(poll);
                poll = this.zt.poll();
            }
            return this.a.get(new C0008a(th));
        }
    }

    /* loaded from: classes11.dex */
    static final class c extends AbstractC0007a {
        private final b zu = new b();

        c() {
        }

        @Override // com.a.a.a.a.a.a.a.AbstractC0007a
        public final void a(Throwable th) {
            th.printStackTrace();
            List<Throwable> f = this.zu.f(th);
            if (f == null) {
                return;
            }
            synchronized (f) {
                for (Throwable th2 : f) {
                    System.err.print("Suppressed: ");
                    th2.printStackTrace();
                }
            }
        }

        @Override // com.a.a.a.a.a.a.a.AbstractC0007a
        public final void a(Throwable th, PrintWriter printWriter) {
            th.printStackTrace(printWriter);
            List<Throwable> f = this.zu.f(th);
            if (f == null) {
                return;
            }
            synchronized (f) {
                for (Throwable th2 : f) {
                    printWriter.print("Suppressed: ");
                    th2.printStackTrace(printWriter);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    static final class d extends AbstractC0007a {
        d() {
        }

        @Override // com.a.a.a.a.a.a.a.AbstractC0007a
        public final void a(Throwable th) {
            th.printStackTrace();
        }

        @Override // com.a.a.a.a.a.a.a.AbstractC0007a
        public final void a(Throwable th, PrintWriter printWriter) {
            th.printStackTrace(printWriter);
        }
    }

    /* loaded from: classes11.dex */
    static final class e extends AbstractC0007a {
        e() {
        }

        @Override // com.a.a.a.a.a.a.a.AbstractC0007a
        public final void a(Throwable th) {
            th.printStackTrace();
        }

        @Override // com.a.a.a.a.a.a.a.AbstractC0007a
        public final void a(Throwable th, PrintWriter printWriter) {
            th.printStackTrace(printWriter);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0065  */
    static {
        Integer num;
        Throwable th;
        AbstractC0007a dVar;
        try {
            num = a();
        } catch (Throwable th2) {
            num = null;
            th = th2;
        }
        if (num != null) {
            try {
            } catch (Throwable th3) {
                th = th3;
                System.err.println("An error has occured when initializing the try-with-resources desuguring strategy. The default strategy " + d.class.getName() + "will be used. The error is: ");
                th.printStackTrace(System.err);
                dVar = new d();
                zr = dVar;
                b = num == null ? 1 : num.intValue();
            }
            if (num.intValue() >= 19) {
                dVar = new e();
                zr = dVar;
                b = num == null ? 1 : num.intValue();
            }
        }
        dVar = !Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ? new c() : new d();
        zr = dVar;
        b = num == null ? 1 : num.intValue();
    }

    private static Integer a() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e2) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e2.printStackTrace(System.err);
            return null;
        }
    }

    public static void a(Throwable th) {
        zr.a(th);
    }

    public static void a(Throwable th, PrintWriter printWriter) {
        zr.a(th, printWriter);
    }
}
