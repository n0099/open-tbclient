package aegon.chrome.base;

import androidx.annotation.VisibleForTesting;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class LifetimeAssert {
    public static /* synthetic */ Interceptable $ic;
    public static TestHook sTestHook;
    public transient /* synthetic */ FieldHolder $fh;
    @VisibleForTesting
    public final WrappedReference mWrapper;

    /* loaded from: classes.dex */
    public static class CreationException extends RuntimeException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CreationException() {
            super("vvv This is where object was created. vvv");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class LifetimeAssertException extends RuntimeException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LifetimeAssertException(String str, Throwable th) {
            super(str, th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, th};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Throwable) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface TestHook {
        void onCleaned(WrappedReference wrappedReference, String str);
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class WrappedReference extends PhantomReference<Object> {
        public static /* synthetic */ Interceptable $ic;
        public static Set<WrappedReference> sActiveWrappers;
        public static ReferenceQueue<Object> sReferenceQueue;
        public transient /* synthetic */ FieldHolder $fh;
        public final CreationException mCreationException;
        public boolean mSafeToGc;
        public final Class<?> mTargetClass;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1521666110, "Laegon/chrome/base/LifetimeAssert$WrappedReference;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1521666110, "Laegon/chrome/base/LifetimeAssert$WrappedReference;");
                    return;
                }
            }
            sReferenceQueue = new ReferenceQueue<>();
            sActiveWrappers = Collections.synchronizedSet(new HashSet());
            new Thread("GcStateAssertQueue") { // from class: aegon.chrome.base.LifetimeAssert.WrappedReference.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r7);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r7};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    setDaemon(true);
                    start();
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    WrappedReference wrappedReference;
                    String format;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
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
                            } catch (InterruptedException e2) {
                                throw new RuntimeException(e2);
                            }
                        }
                        throw new LifetimeAssertException(format, wrappedReference.mCreationException);
                    }
                }
            };
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WrappedReference(Object obj, CreationException creationException, boolean z) {
            super(obj, sReferenceQueue);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj, creationException, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(objArr2[0], (ReferenceQueue) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mCreationException = creationException;
            this.mSafeToGc = z;
            this.mTargetClass = obj.getClass();
            sActiveWrappers.add(this);
        }
    }

    public LifetimeAssert(WrappedReference wrappedReference) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wrappedReference};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mWrapper = wrappedReference;
    }
}
