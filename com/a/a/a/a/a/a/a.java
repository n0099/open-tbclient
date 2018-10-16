package com.a.a.a.a.a.a;

import java.io.PrintWriter;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public final class a {
    static final AbstractC0005a mR;

    /* renamed from: com.a.a.a.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static abstract class AbstractC0005a {
        protected static final Throwable[] mS = new Throwable[0];

        AbstractC0005a() {
        }

        public abstract void a(Throwable th);

        public abstract void a(Throwable th, PrintWriter printWriter);
    }

    /* loaded from: classes2.dex */
    static final class b {
        private final ConcurrentHashMap<C0006a, List<Throwable>> a = new ConcurrentHashMap<>(16, 0.75f, 10);
        private final ReferenceQueue<Throwable> mT = new ReferenceQueue<>();

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.a.a.a.a.a.a.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0006a extends WeakReference<Throwable> {
            private final int a;

            public C0006a(Throwable th) {
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
                    C0006a c0006a = (C0006a) obj;
                    return this.a == c0006a.a && get() == c0006a.get();
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
            Reference<? extends Throwable> poll = this.mT.poll();
            while (poll != null) {
                this.a.remove(poll);
                poll = this.mT.poll();
            }
            return this.a.get(new C0006a(th));
        }
    }

    /* loaded from: classes2.dex */
    static final class c extends AbstractC0005a {
        private final b mU = new b();

        c() {
        }

        @Override // com.a.a.a.a.a.a.a.AbstractC0005a
        public final void a(Throwable th) {
            th.printStackTrace();
            List<Throwable> f = this.mU.f(th);
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

        @Override // com.a.a.a.a.a.a.a.AbstractC0005a
        public final void a(Throwable th, PrintWriter printWriter) {
            th.printStackTrace(printWriter);
            List<Throwable> f = this.mU.f(th);
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

    /* loaded from: classes2.dex */
    static final class d extends AbstractC0005a {
        d() {
        }

        @Override // com.a.a.a.a.a.a.a.AbstractC0005a
        public final void a(Throwable th) {
            th.printStackTrace();
        }

        @Override // com.a.a.a.a.a.a.a.AbstractC0005a
        public final void a(Throwable th, PrintWriter printWriter) {
            th.printStackTrace(printWriter);
        }
    }

    /* loaded from: classes2.dex */
    static final class e extends AbstractC0005a {
        e() {
        }

        @Override // com.a.a.a.a.a.a.a.AbstractC0005a
        public final void a(Throwable th) {
            th.printStackTrace();
        }

        @Override // com.a.a.a.a.a.a.a.AbstractC0005a
        public final void a(Throwable th, PrintWriter printWriter) {
            th.printStackTrace(printWriter);
        }
    }

    static {
        AbstractC0005a dVar;
        try {
            Integer a = a();
            if (a == null || a.intValue() < 19) {
                dVar = !Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ? new c() : new d();
            } else {
                dVar = new e();
            }
        } catch (Throwable th) {
            System.err.println("An error has occured when initializing the try-with-resources desuguring strategy. The default strategy " + d.class.getName() + "will be used. The error is: ");
            th.printStackTrace(System.err);
            dVar = new d();
        }
        mR = dVar;
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
        mR.a(th);
    }

    public static void a(Throwable th, PrintWriter printWriter) {
        mR.a(th, printWriter);
    }
}
