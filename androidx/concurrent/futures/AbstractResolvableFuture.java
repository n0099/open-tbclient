package androidx.concurrent.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class AbstractResolvableFuture<V> implements ListenableFuture<V> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final AtomicHelper ATOMIC_HELPER;
    public static final boolean GENERATE_CANCELLATION_CAUSES;
    public static final Object NULL;
    public static final long SPIN_THRESHOLD_NANOS = 1000;
    public static final Logger log;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public volatile Listener listeners;
    @Nullable
    public volatile Object value;
    @Nullable
    public volatile Waiter waiters;

    /* renamed from: androidx.concurrent.futures.AbstractResolvableFuture$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public void afterDone() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public void interruptTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class AtomicHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract boolean casListeners(AbstractResolvableFuture<?> abstractResolvableFuture, Listener listener, Listener listener2);

        public abstract boolean casValue(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2);

        public abstract boolean casWaiters(AbstractResolvableFuture<?> abstractResolvableFuture, Waiter waiter, Waiter waiter2);

        public abstract void putNext(Waiter waiter, Waiter waiter2);

        public abstract void putThread(Waiter waiter, Thread thread);

        public AtomicHelper() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ AtomicHelper(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class Cancellation {
        public static /* synthetic */ Interceptable $ic;
        public static final Cancellation CAUSELESS_CANCELLED;
        public static final Cancellation CAUSELESS_INTERRUPTED;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public final Throwable cause;
        public final boolean wasInterrupted;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-647562199, "Landroidx/concurrent/futures/AbstractResolvableFuture$Cancellation;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-647562199, "Landroidx/concurrent/futures/AbstractResolvableFuture$Cancellation;");
                    return;
                }
            }
            if (AbstractResolvableFuture.GENERATE_CANCELLATION_CAUSES) {
                CAUSELESS_CANCELLED = null;
                CAUSELESS_INTERRUPTED = null;
                return;
            }
            CAUSELESS_CANCELLED = new Cancellation(false, null);
            CAUSELESS_INTERRUPTED = new Cancellation(true, null);
        }

        public Cancellation(boolean z, @Nullable Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), th};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.wasInterrupted = z;
            this.cause = th;
        }
    }

    /* loaded from: classes.dex */
    public static final class Failure {
        public static /* synthetic */ Interceptable $ic;
        public static final Failure FALLBACK_INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;
        public final Throwable exception;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1307133120, "Landroidx/concurrent/futures/AbstractResolvableFuture$Failure;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1307133120, "Landroidx/concurrent/futures/AbstractResolvableFuture$Failure;");
                    return;
                }
            }
            FALLBACK_INSTANCE = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: androidx.concurrent.futures.AbstractResolvableFuture.Failure.1
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // java.lang.Throwable
                public synchronized Throwable fillInStackTrace() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        synchronized (this) {
                        }
                        return this;
                    }
                    return (Throwable) invokeV.objValue;
                }
            });
        }

        public Failure(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.exception = (Throwable) AbstractResolvableFuture.checkNotNull(th);
        }
    }

    /* loaded from: classes.dex */
    public static final class Listener {
        public static /* synthetic */ Interceptable $ic;
        public static final Listener TOMBSTONE;
        public transient /* synthetic */ FieldHolder $fh;
        public final Executor executor;
        @Nullable
        public Listener next;
        public final Runnable task;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1168451352, "Landroidx/concurrent/futures/AbstractResolvableFuture$Listener;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1168451352, "Landroidx/concurrent/futures/AbstractResolvableFuture$Listener;");
                    return;
                }
            }
            TOMBSTONE = new Listener(null, null);
        }

        public Listener(Runnable runnable, Executor executor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {runnable, executor};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.task = runnable;
            this.executor = executor;
        }
    }

    /* loaded from: classes.dex */
    public static final class SafeAtomicHelper extends AtomicHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Listener> listenersUpdater;
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> valueUpdater;
        public final AtomicReferenceFieldUpdater<Waiter, Waiter> waiterNextUpdater;
        public final AtomicReferenceFieldUpdater<Waiter, Thread> waiterThreadUpdater;
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Waiter> waitersUpdater;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<Waiter, Waiter> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Waiter> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Listener> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> atomicReferenceFieldUpdater5) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atomicReferenceFieldUpdater, atomicReferenceFieldUpdater2, atomicReferenceFieldUpdater3, atomicReferenceFieldUpdater4, atomicReferenceFieldUpdater5};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((AnonymousClass1) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.waiterThreadUpdater = atomicReferenceFieldUpdater;
            this.waiterNextUpdater = atomicReferenceFieldUpdater2;
            this.waitersUpdater = atomicReferenceFieldUpdater3;
            this.listenersUpdater = atomicReferenceFieldUpdater4;
            this.valueUpdater = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public boolean casListeners(AbstractResolvableFuture<?> abstractResolvableFuture, Listener listener, Listener listener2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, abstractResolvableFuture, listener, listener2)) == null) {
                return this.listenersUpdater.compareAndSet(abstractResolvableFuture, listener, listener2);
            }
            return invokeLLL.booleanValue;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public boolean casValue(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, abstractResolvableFuture, obj, obj2)) == null) {
                return this.valueUpdater.compareAndSet(abstractResolvableFuture, obj, obj2);
            }
            return invokeLLL.booleanValue;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public boolean casWaiters(AbstractResolvableFuture<?> abstractResolvableFuture, Waiter waiter, Waiter waiter2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, abstractResolvableFuture, waiter, waiter2)) == null) {
                return this.waitersUpdater.compareAndSet(abstractResolvableFuture, waiter, waiter2);
            }
            return invokeLLL.booleanValue;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public void putNext(Waiter waiter, Waiter waiter2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, waiter, waiter2) == null) {
                this.waiterNextUpdater.lazySet(waiter, waiter2);
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public void putThread(Waiter waiter, Thread thread) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, waiter, thread) == null) {
                this.waiterThreadUpdater.lazySet(waiter, thread);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class SetFuture<V> implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ListenableFuture<? extends V> future;
        public final AbstractResolvableFuture<V> owner;

        public SetFuture(AbstractResolvableFuture<V> abstractResolvableFuture, ListenableFuture<? extends V> listenableFuture) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractResolvableFuture, listenableFuture};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.owner = abstractResolvableFuture;
            this.future = listenableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.owner.value != this) {
                return;
            }
            if (AbstractResolvableFuture.ATOMIC_HELPER.casValue(this.owner, this, AbstractResolvableFuture.getFutureValue(this.future))) {
                AbstractResolvableFuture.complete(this.owner);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class SynchronizedHelper extends AtomicHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SynchronizedHelper() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((AnonymousClass1) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public boolean casListeners(AbstractResolvableFuture<?> abstractResolvableFuture, Listener listener, Listener listener2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, abstractResolvableFuture, listener, listener2)) == null) {
                synchronized (abstractResolvableFuture) {
                    if (abstractResolvableFuture.listeners == listener) {
                        abstractResolvableFuture.listeners = listener2;
                        return true;
                    }
                    return false;
                }
            }
            return invokeLLL.booleanValue;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public boolean casValue(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, abstractResolvableFuture, obj, obj2)) == null) {
                synchronized (abstractResolvableFuture) {
                    if (abstractResolvableFuture.value == obj) {
                        abstractResolvableFuture.value = obj2;
                        return true;
                    }
                    return false;
                }
            }
            return invokeLLL.booleanValue;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public boolean casWaiters(AbstractResolvableFuture<?> abstractResolvableFuture, Waiter waiter, Waiter waiter2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, abstractResolvableFuture, waiter, waiter2)) == null) {
                synchronized (abstractResolvableFuture) {
                    if (abstractResolvableFuture.waiters == waiter) {
                        abstractResolvableFuture.waiters = waiter2;
                        return true;
                    }
                    return false;
                }
            }
            return invokeLLL.booleanValue;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public void putNext(Waiter waiter, Waiter waiter2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, waiter, waiter2) == null) {
                waiter.next = waiter2;
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public void putThread(Waiter waiter, Thread thread) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, waiter, thread) == null) {
                waiter.thread = thread;
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class Waiter {
        public static /* synthetic */ Interceptable $ic;
        public static final Waiter TOMBSTONE;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public volatile Waiter next;
        @Nullable
        public volatile Thread thread;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1634276118, "Landroidx/concurrent/futures/AbstractResolvableFuture$Waiter;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1634276118, "Landroidx/concurrent/futures/AbstractResolvableFuture$Waiter;");
                    return;
                }
            }
            TOMBSTONE = new Waiter(false);
        }

        public Waiter() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            AbstractResolvableFuture.ATOMIC_HELPER.putThread(this, Thread.currentThread());
        }

        public void unpark() {
            Thread thread;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (thread = this.thread) != null) {
                this.thread = null;
                LockSupport.unpark(thread);
            }
        }

        public Waiter(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                }
            }
        }

        public void setNext(Waiter waiter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, waiter) == null) {
                AbstractResolvableFuture.ATOMIC_HELPER.putNext(this, waiter);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        AtomicHelper synchronizedHelper;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(929824710, "Landroidx/concurrent/futures/AbstractResolvableFuture;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(929824710, "Landroidx/concurrent/futures/AbstractResolvableFuture;");
                return;
            }
        }
        GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        log = Logger.getLogger(AbstractResolvableFuture.class.getName());
        try {
            synchronizedHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, UnitedSchemeConstants.UNITED_SCHEME_NEXT), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Waiter.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Listener.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Object.class, "value"));
            th = null;
        } catch (Throwable th) {
            th = th;
            synchronizedHelper = new SynchronizedHelper();
        }
        ATOMIC_HELPER = synchronizedHelper;
        if (th != null) {
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        NULL = new Object();
    }

    @Override // java.util.concurrent.Future
    public final V get() throws InterruptedException, ExecutionException {
        InterceptResult invokeV;
        boolean z;
        Object obj;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!Thread.interrupted()) {
                Object obj2 = this.value;
                if (obj2 != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z & (!(obj2 instanceof SetFuture))) {
                    return getDoneValue(obj2);
                }
                Waiter waiter = this.waiters;
                if (waiter != Waiter.TOMBSTONE) {
                    Waiter waiter2 = new Waiter();
                    do {
                        waiter2.setNext(waiter);
                        if (ATOMIC_HELPER.casWaiters(this, waiter, waiter2)) {
                            do {
                                LockSupport.park(this);
                                if (!Thread.interrupted()) {
                                    obj = this.value;
                                    if (obj != null) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                } else {
                                    removeWaiter(waiter2);
                                    throw new InterruptedException();
                                }
                            } while (!(z2 & (!(obj instanceof SetFuture))));
                            return getDoneValue(obj);
                        }
                        waiter = this.waiters;
                    } while (waiter != Waiter.TOMBSTONE);
                    return getDoneValue(this.value);
                }
                return getDoneValue(this.value);
            }
            throw new InterruptedException();
        }
        return (V) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append("[status=");
            if (isCancelled()) {
                sb.append("CANCELLED");
            } else if (isDone()) {
                addDoneString(sb);
            } else {
                try {
                    str = pendingToString();
                } catch (RuntimeException e) {
                    str = "Exception thrown from implementation: " + e.getClass();
                }
                if (str != null && !str.isEmpty()) {
                    sb.append("PENDING, info=[");
                    sb.append(str);
                    sb.append(PreferencesUtil.RIGHT_MOUNT);
                } else if (isDone()) {
                    addDoneString(sb);
                } else {
                    sb.append("PENDING");
                }
            }
            sb.append(PreferencesUtil.RIGHT_MOUNT);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public AbstractResolvableFuture() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private void releaseWaiters() {
        Waiter waiter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            do {
                waiter = this.waiters;
            } while (!ATOMIC_HELPER.casWaiters(this, waiter, Waiter.TOMBSTONE));
            while (waiter != null) {
                waiter.unpark();
                waiter = waiter.next;
            }
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.value instanceof Cancellation;
        }
        return invokeV.booleanValue;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Object obj = this.value;
            if (obj != null) {
                z = true;
            } else {
                z = false;
            }
            return (!(obj instanceof SetFuture)) & z;
        }
        return invokeV.booleanValue;
    }

    public final boolean wasInterrupted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            Object obj = this.value;
            if ((obj instanceof Cancellation) && ((Cancellation) obj).wasInterrupted) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void addDoneString(StringBuilder sb) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, sb) == null) {
            try {
                Object uninterruptibly = getUninterruptibly(this);
                sb.append("SUCCESS, result=[");
                sb.append(userObjectToString(uninterruptibly));
                sb.append(PreferencesUtil.RIGHT_MOUNT);
            } catch (CancellationException unused) {
                sb.append("CANCELLED");
            } catch (RuntimeException e) {
                sb.append("UNKNOWN, cause=[");
                sb.append(e.getClass());
                sb.append(" thrown from get()]");
            } catch (ExecutionException e2) {
                sb.append("FAILURE, cause=[");
                sb.append(e2.getCause());
                sb.append(PreferencesUtil.RIGHT_MOUNT);
            }
        }
    }

    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        InterceptResult invokeL;
        Failure failure;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, listenableFuture)) == null) {
            checkNotNull(listenableFuture);
            Object obj = this.value;
            if (obj == null) {
                if (listenableFuture.isDone()) {
                    if (!ATOMIC_HELPER.casValue(this, null, getFutureValue(listenableFuture))) {
                        return false;
                    }
                    complete(this);
                    return true;
                }
                SetFuture setFuture = new SetFuture(this, listenableFuture);
                if (ATOMIC_HELPER.casValue(this, null, setFuture)) {
                    try {
                        listenableFuture.addListener(setFuture, DirectExecutor.INSTANCE);
                    } catch (Throwable th) {
                        try {
                            failure = new Failure(th);
                        } catch (Throwable unused) {
                            failure = Failure.FALLBACK_INSTANCE;
                        }
                        ATOMIC_HELPER.casValue(this, setFuture, failure);
                    }
                    return true;
                }
                obj = this.value;
            }
            if (obj instanceof Cancellation) {
                listenableFuture.cancel(((Cancellation) obj).wasInterrupted);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static CancellationException cancellationExceptionWithCause(@Nullable String str, @Nullable Throwable th) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, th)) == null) {
            CancellationException cancellationException = new CancellationException(str);
            cancellationException.initCause(th);
            return cancellationException;
        }
        return (CancellationException) invokeLL.objValue;
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t)) == null) {
            if (t != null) {
                return t;
            }
            throw null;
        }
        return (T) invokeL.objValue;
    }

    private Listener clearListeners(Listener listener) {
        Listener listener2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, listener)) == null) {
            do {
                listener2 = this.listeners;
            } while (!ATOMIC_HELPER.casListeners(this, listener2, Listener.TOMBSTONE));
            Listener listener3 = listener;
            Listener listener4 = listener2;
            while (listener4 != null) {
                Listener listener5 = listener4.next;
                listener4.next = listener3;
                listener3 = listener4;
                listener4 = listener5;
            }
            return listener3;
        }
        return (Listener) invokeL.objValue;
    }

    public static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
        InterceptResult invokeL;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, future)) == null) {
            boolean z = false;
            while (true) {
                try {
                    v = future.get();
                    break;
                } catch (InterruptedException unused) {
                    z = true;
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            return v;
        }
        return (V) invokeL.objValue;
    }

    private String userObjectToString(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, obj)) == null) {
            if (obj == this) {
                return "this future";
            }
            return String.valueOf(obj);
        }
        return (String) invokeL.objValue;
    }

    public final void maybePropagateCancellationTo(@Nullable Future<?> future) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, future) == null) {
            if (future != null) {
                z = true;
            } else {
                z = false;
            }
            if (z & isCancelled()) {
                future.cancel(wasInterrupted());
            }
        }
    }

    public boolean set(@Nullable V v) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, v)) == null) {
            if (v == null) {
                v = (V) NULL;
            }
            if (ATOMIC_HELPER.casValue(this, null, v)) {
                complete(this);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean setException(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, th)) == null) {
            if (ATOMIC_HELPER.casValue(this, null, new Failure((Throwable) checkNotNull(th)))) {
                complete(this);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x0005 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper] */
    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.concurrent.futures.AbstractResolvableFuture<?>, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.concurrent.futures.AbstractResolvableFuture] */
    /* JADX WARN: Type inference failed for: r4v6, types: [androidx.concurrent.futures.AbstractResolvableFuture, androidx.concurrent.futures.AbstractResolvableFuture<V>] */
    public static void complete(AbstractResolvableFuture<?> abstractResolvableFuture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, abstractResolvableFuture) == null) {
            Listener listener = null;
            while (true) {
                abstractResolvableFuture.releaseWaiters();
                abstractResolvableFuture.afterDone();
                Listener clearListeners = abstractResolvableFuture.clearListeners(listener);
                while (clearListeners != null) {
                    listener = clearListeners.next;
                    Runnable runnable = clearListeners.task;
                    if (runnable instanceof SetFuture) {
                        SetFuture setFuture = (SetFuture) runnable;
                        abstractResolvableFuture = setFuture.owner;
                        if (abstractResolvableFuture.value == setFuture) {
                            if (ATOMIC_HELPER.casValue(abstractResolvableFuture, setFuture, getFutureValue(setFuture.future))) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        executeListener(runnable, clearListeners.executor);
                    }
                    clearListeners = listener;
                }
                return;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    private V getDoneValue(Object obj) throws ExecutionException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, obj)) == null) {
            if (!(obj instanceof Cancellation)) {
                if (!(obj instanceof Failure)) {
                    if (obj == NULL) {
                        return null;
                    }
                    return obj;
                }
                throw new ExecutionException(((Failure) obj).exception);
            }
            throw cancellationExceptionWithCause("Task was cancelled.", ((Cancellation) obj).cause);
        }
        return (V) invokeL.objValue;
    }

    private void removeWaiter(Waiter waiter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, waiter) == null) {
            waiter.thread = null;
            while (true) {
                Waiter waiter2 = this.waiters;
                if (waiter2 == Waiter.TOMBSTONE) {
                    return;
                }
                Waiter waiter3 = null;
                while (waiter2 != null) {
                    Waiter waiter4 = waiter2.next;
                    if (waiter2.thread != null) {
                        waiter3 = waiter2;
                    } else if (waiter3 != null) {
                        waiter3.next = waiter4;
                        if (waiter3.thread == null) {
                            break;
                        }
                    } else if (!ATOMIC_HELPER.casWaiters(this, waiter2, waiter4)) {
                        break;
                    }
                    waiter2 = waiter4;
                }
                return;
            }
        }
    }

    public static void executeListener(Runnable runnable, Executor executor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, runnable, executor) == null) {
            try {
                executor.execute(runnable);
            } catch (RuntimeException e) {
                Logger logger = log;
                Level level = Level.SEVERE;
                logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e);
            }
        }
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable runnable, Executor executor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, runnable, executor) == null) {
            checkNotNull(runnable);
            checkNotNull(executor);
            Listener listener = this.listeners;
            if (listener != Listener.TOMBSTONE) {
                Listener listener2 = new Listener(runnable, executor);
                do {
                    listener2.next = listener;
                    if (ATOMIC_HELPER.casListeners(this, listener, listener2)) {
                        return;
                    }
                    listener = this.listeners;
                } while (listener != Listener.TOMBSTONE);
                executeListener(runnable, executor);
            }
            executeListener(runnable, executor);
        }
    }

    public static Object getFutureValue(ListenableFuture<?> listenableFuture) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, listenableFuture)) == null) {
            if (listenableFuture instanceof AbstractResolvableFuture) {
                Object obj = ((AbstractResolvableFuture) listenableFuture).value;
                if (obj instanceof Cancellation) {
                    Cancellation cancellation = (Cancellation) obj;
                    if (cancellation.wasInterrupted) {
                        if (cancellation.cause != null) {
                            return new Cancellation(false, cancellation.cause);
                        }
                        return Cancellation.CAUSELESS_CANCELLED;
                    }
                    return obj;
                }
                return obj;
            }
            boolean isCancelled = listenableFuture.isCancelled();
            if ((!GENERATE_CANCELLATION_CAUSES) & isCancelled) {
                return Cancellation.CAUSELESS_CANCELLED;
            }
            try {
                Object uninterruptibly = getUninterruptibly(listenableFuture);
                if (uninterruptibly == null) {
                    return NULL;
                }
                return uninterruptibly;
            } catch (CancellationException e) {
                if (!isCancelled) {
                    return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e));
                }
                return new Cancellation(false, e);
            } catch (ExecutionException e2) {
                return new Failure(e2.getCause());
            } catch (Throwable th) {
                return new Failure(th);
            }
        }
        return invokeL.objValue;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        Cancellation cancellation;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            Object obj = this.value;
            if (obj == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 | (obj instanceof SetFuture)) {
                if (GENERATE_CANCELLATION_CAUSES) {
                    cancellation = new Cancellation(z, new CancellationException("Future.cancel() was called."));
                } else if (z) {
                    cancellation = Cancellation.CAUSELESS_INTERRUPTED;
                } else {
                    cancellation = Cancellation.CAUSELESS_CANCELLED;
                }
                boolean z4 = false;
                AbstractResolvableFuture<V> abstractResolvableFuture = this;
                while (true) {
                    if (ATOMIC_HELPER.casValue(abstractResolvableFuture, obj, cancellation)) {
                        if (z) {
                            abstractResolvableFuture.interruptTask();
                        }
                        complete(abstractResolvableFuture);
                        if (!(obj instanceof SetFuture)) {
                            return true;
                        }
                        ListenableFuture<? extends V> listenableFuture = ((SetFuture) obj).future;
                        if (listenableFuture instanceof AbstractResolvableFuture) {
                            abstractResolvableFuture = (AbstractResolvableFuture) listenableFuture;
                            obj = abstractResolvableFuture.value;
                            if (obj == null) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (!(z3 | (obj instanceof SetFuture))) {
                                return true;
                            }
                            z4 = true;
                        } else {
                            listenableFuture.cancel(z);
                            return true;
                        }
                    } else {
                        obj = abstractResolvableFuture.value;
                        if (!(obj instanceof SetFuture)) {
                            return z4;
                        }
                    }
                }
            } else {
                return false;
            }
        } else {
            return invokeZ.booleanValue;
        }
    }

    @Override // java.util.concurrent.Future
    public final V get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        InterceptResult invokeJL;
        boolean z;
        long j2;
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048580, this, j, timeUnit)) == null) {
            long nanos = timeUnit.toNanos(j);
            if (!Thread.interrupted()) {
                Object obj = this.value;
                if (obj != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z & (!(obj instanceof SetFuture))) {
                    return getDoneValue(obj);
                }
                if (nanos > 0) {
                    j2 = System.nanoTime() + nanos;
                } else {
                    j2 = 0;
                }
                if (nanos >= 1000) {
                    Waiter waiter = this.waiters;
                    if (waiter != Waiter.TOMBSTONE) {
                        Waiter waiter2 = new Waiter();
                        do {
                            waiter2.setNext(waiter);
                            if (ATOMIC_HELPER.casWaiters(this, waiter, waiter2)) {
                                do {
                                    LockSupport.parkNanos(this, nanos);
                                    if (!Thread.interrupted()) {
                                        Object obj2 = this.value;
                                        if (obj2 != null) {
                                            z4 = true;
                                        } else {
                                            z4 = false;
                                        }
                                        if (z4 & (!(obj2 instanceof SetFuture))) {
                                            return getDoneValue(obj2);
                                        }
                                        nanos = j2 - System.nanoTime();
                                    } else {
                                        removeWaiter(waiter2);
                                        throw new InterruptedException();
                                    }
                                } while (nanos >= 1000);
                                removeWaiter(waiter2);
                            } else {
                                waiter = this.waiters;
                            }
                        } while (waiter != Waiter.TOMBSTONE);
                        return getDoneValue(this.value);
                    }
                    return getDoneValue(this.value);
                }
                while (nanos > 0) {
                    Object obj3 = this.value;
                    if (obj3 != null) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3 & (!(obj3 instanceof SetFuture))) {
                        return getDoneValue(obj3);
                    }
                    if (!Thread.interrupted()) {
                        nanos = j2 - System.nanoTime();
                    } else {
                        throw new InterruptedException();
                    }
                }
                String abstractResolvableFuture = toString();
                String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
                String str = "Waited " + j + " " + timeUnit.toString().toLowerCase(Locale.ROOT);
                if (nanos + 1000 < 0) {
                    String str2 = str + " (plus ";
                    long j3 = -nanos;
                    long convert = timeUnit.convert(j3, TimeUnit.NANOSECONDS);
                    long nanos2 = j3 - timeUnit.toNanos(convert);
                    int i = (convert > 0L ? 1 : (convert == 0L ? 0 : -1));
                    if (i != 0 && nanos2 <= 1000) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (i > 0) {
                        String str3 = str2 + convert + " " + lowerCase;
                        if (z2) {
                            str3 = str3 + ",";
                        }
                        str2 = str3 + " ";
                    }
                    if (z2) {
                        str2 = str2 + nanos2 + " nanoseconds ";
                    }
                    str = str2 + "delay)";
                }
                if (isDone()) {
                    throw new TimeoutException(str + " but future completed as timeout expired");
                }
                throw new TimeoutException(str + " for " + abstractResolvableFuture);
            }
            throw new InterruptedException();
        }
        return (V) invokeJL.objValue;
    }

    @Nullable
    public String pendingToString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Object obj = this.value;
            if (obj instanceof SetFuture) {
                return "setFuture=[" + userObjectToString(((SetFuture) obj).future) + PreferencesUtil.RIGHT_MOUNT;
            } else if (this instanceof ScheduledFuture) {
                return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
            } else {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }
}
