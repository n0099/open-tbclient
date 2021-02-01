package aegon.chrome.base;

import androidx.annotation.VisibleForTesting;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class LifetimeAssert {
    public static TestHook sTestHook;
    @VisibleForTesting
    public final WrappedReference mWrapper;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class CreationException extends RuntimeException {
        public CreationException() {
            super("vvv This is where object was created. vvv");
        }
    }

    /* loaded from: classes3.dex */
    static class LifetimeAssertException extends RuntimeException {
        public LifetimeAssertException(String str, Throwable th) {
            super(str, th);
        }
    }

    /* loaded from: classes3.dex */
    interface TestHook {
        void onCleaned(WrappedReference wrappedReference, String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public static class WrappedReference extends PhantomReference<Object> {
        public final CreationException mCreationException;
        public boolean mSafeToGc;
        public final Class<?> mTargetClass;
        public static ReferenceQueue<Object> sReferenceQueue = new ReferenceQueue<>();
        public static Set<WrappedReference> sActiveWrappers = Collections.synchronizedSet(new HashSet());

        static {
            new Thread("GcStateAssertQueue") { // from class: aegon.chrome.base.LifetimeAssert.WrappedReference.1
                {
                    setDaemon(true);
                    start();
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    WrappedReference wrappedReference;
                    String format;
                    while (true) {
                        try {
                            wrappedReference = (WrappedReference) WrappedReference.sReferenceQueue.remove();
                            WrappedReference.sActiveWrappers.remove(wrappedReference);
                            if (!wrappedReference.mSafeToGc) {
                                format = String.format("Object of type %s was GC'ed without cleanup. Refer to \"Caused by\" for where object was created.", wrappedReference.mTargetClass.getName());
                                if (LifetimeAssert.sTestHook == null) {
                                    break;
                                }
                                LifetimeAssert.sTestHook.onCleaned(wrappedReference, format);
                            } else if (LifetimeAssert.sTestHook != null) {
                                LifetimeAssert.sTestHook.onCleaned(wrappedReference, null);
                            }
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    throw new LifetimeAssertException(format, wrappedReference.mCreationException);
                }
            };
        }

        public WrappedReference(Object obj, CreationException creationException, boolean z) {
            super(obj, sReferenceQueue);
            this.mCreationException = creationException;
            this.mSafeToGc = z;
            this.mTargetClass = obj.getClass();
            sActiveWrappers.add(this);
        }
    }

    public LifetimeAssert(WrappedReference wrappedReference) {
        this.mWrapper = wrappedReference;
    }
}
