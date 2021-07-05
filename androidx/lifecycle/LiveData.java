package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class LiveData<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Object NOT_SET;
    public static final int START_VERSION = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public int mActiveCount;
    public volatile Object mData;
    public final Object mDataLock;
    public boolean mDispatchInvalidated;
    public boolean mDispatchingValue;
    public SafeIterableMap<Observer<? super T>, LiveData<T>.ObserverWrapper> mObservers;
    public volatile Object mPendingData;
    public final Runnable mPostValueRunnable;
    public int mVersion;

    /* loaded from: classes.dex */
    public class AlwaysActiveObserver extends LiveData<T>.ObserverWrapper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveData this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AlwaysActiveObserver(LiveData liveData, Observer<? super T> observer) {
            super(liveData, observer);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveData, observer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((LiveData) objArr2[0], (Observer) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = liveData;
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public boolean shouldBeActive() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class LifecycleBoundObserver extends LiveData<T>.ObserverWrapper implements LifecycleEventObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final LifecycleOwner mOwner;
        public final /* synthetic */ LiveData this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LifecycleBoundObserver(@NonNull LiveData liveData, LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
            super(liveData, observer);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveData, lifecycleOwner, observer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((LiveData) objArr2[0], (Observer) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = liveData;
            this.mOwner = lifecycleOwner;
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public void detachObserver() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.mOwner.getLifecycle().removeObserver(this);
            }
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public boolean isAttachedTo(LifecycleOwner lifecycleOwner) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lifecycleOwner)) == null) ? this.mOwner == lifecycleOwner : invokeL.booleanValue;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, lifecycleOwner, event) == null) {
                if (this.mOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
                    this.this$0.removeObserver(this.mObserver);
                } else {
                    activeStateChanged(shouldBeActive());
                }
            }
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public boolean shouldBeActive() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) : invokeV.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public abstract class ObserverWrapper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mActive;
        public int mLastVersion;
        public final Observer<? super T> mObserver;
        public final /* synthetic */ LiveData this$0;

        public ObserverWrapper(LiveData liveData, Observer<? super T> observer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveData, observer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = liveData;
            this.mLastVersion = -1;
            this.mObserver = observer;
        }

        public void activeStateChanged(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || z == this.mActive) {
                return;
            }
            this.mActive = z;
            boolean z2 = this.this$0.mActiveCount == 0;
            this.this$0.mActiveCount += this.mActive ? 1 : -1;
            if (z2 && this.mActive) {
                this.this$0.onActive();
            }
            LiveData liveData = this.this$0;
            if (liveData.mActiveCount == 0 && !this.mActive) {
                liveData.onInactive();
            }
            if (this.mActive) {
                this.this$0.dispatchingValue(this);
            }
        }

        public void detachObserver() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public boolean isAttachedTo(LifecycleOwner lifecycleOwner) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lifecycleOwner)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        public abstract boolean shouldBeActive();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(886563558, "Landroidx/lifecycle/LiveData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(886563558, "Landroidx/lifecycle/LiveData;");
                return;
            }
        }
        NOT_SET = new Object();
    }

    public LiveData(T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mDataLock = new Object();
        this.mObservers = new SafeIterableMap<>();
        this.mActiveCount = 0;
        this.mPendingData = NOT_SET;
        this.mPostValueRunnable = new Runnable(this) { // from class: androidx.lifecycle.LiveData.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LiveData this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: androidx.lifecycle.LiveData */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                Object obj;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    synchronized (this.this$0.mDataLock) {
                        obj = this.this$0.mPendingData;
                        this.this$0.mPendingData = LiveData.NOT_SET;
                    }
                    this.this$0.setValue(obj);
                }
            }
        };
        this.mData = t;
        this.mVersion = 0;
    }

    public static void assertMainThread(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, str) == null) || ArchTaskExecutor.getInstance().isMainThread()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    private void considerNotify(LiveData<T>.ObserverWrapper observerWrapper) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65540, this, observerWrapper) == null) && observerWrapper.mActive) {
            if (!observerWrapper.shouldBeActive()) {
                observerWrapper.activeStateChanged(false);
                return;
            }
            int i2 = observerWrapper.mLastVersion;
            int i3 = this.mVersion;
            if (i2 >= i3) {
                return;
            }
            observerWrapper.mLastVersion = i3;
            observerWrapper.mObserver.onChanged((Object) this.mData);
        }
    }

    public void dispatchingValue(@Nullable LiveData<T>.ObserverWrapper observerWrapper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observerWrapper) == null) {
            if (this.mDispatchingValue) {
                this.mDispatchInvalidated = true;
                return;
            }
            this.mDispatchingValue = true;
            do {
                this.mDispatchInvalidated = false;
                if (observerWrapper != null) {
                    considerNotify(observerWrapper);
                    observerWrapper = null;
                } else {
                    SafeIterableMap<Observer<? super T>, LiveData<T>.ObserverWrapper>.IteratorWithAdditions iteratorWithAdditions = this.mObservers.iteratorWithAdditions();
                    while (iteratorWithAdditions.hasNext()) {
                        considerNotify((ObserverWrapper) iteratorWithAdditions.next().getValue());
                        if (this.mDispatchInvalidated) {
                            break;
                        }
                    }
                }
            } while (this.mDispatchInvalidated);
            this.mDispatchingValue = false;
        }
    }

    @Nullable
    public T getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            T t = (T) this.mData;
            if (t != NOT_SET) {
                return t;
            }
            return null;
        }
        return (T) invokeV.objValue;
    }

    public int getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mVersion : invokeV.intValue;
    }

    public boolean hasActiveObservers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mActiveCount > 0 : invokeV.booleanValue;
    }

    public boolean hasObservers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mObservers.size() > 0 : invokeV.booleanValue;
    }

    @MainThread
    public void observe(@NonNull LifecycleOwner lifecycleOwner, @NonNull Observer<? super T> observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, lifecycleOwner, observer) == null) {
            assertMainThread("observe");
            if (lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
                return;
            }
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(this, lifecycleOwner, observer);
            LiveData<T>.ObserverWrapper putIfAbsent = this.mObservers.putIfAbsent(observer, lifecycleBoundObserver);
            if (putIfAbsent != null && !putIfAbsent.isAttachedTo(lifecycleOwner)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            }
            if (putIfAbsent != null) {
                return;
            }
            lifecycleOwner.getLifecycle().addObserver(lifecycleBoundObserver);
        }
    }

    @MainThread
    public void observeForever(@NonNull Observer<? super T> observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, observer) == null) {
            assertMainThread("observeForever");
            AlwaysActiveObserver alwaysActiveObserver = new AlwaysActiveObserver(this, observer);
            LiveData<T>.ObserverWrapper putIfAbsent = this.mObservers.putIfAbsent(observer, alwaysActiveObserver);
            if (putIfAbsent instanceof LifecycleBoundObserver) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            }
            if (putIfAbsent != null) {
                return;
            }
            alwaysActiveObserver.activeStateChanged(true);
        }
    }

    public void onActive() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public void onInactive() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public void postValue(T t) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, t) == null) {
            synchronized (this.mDataLock) {
                z = this.mPendingData == NOT_SET;
                this.mPendingData = t;
            }
            if (z) {
                ArchTaskExecutor.getInstance().postToMainThread(this.mPostValueRunnable);
            }
        }
    }

    @MainThread
    public void removeObserver(@NonNull Observer<? super T> observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, observer) == null) {
            assertMainThread("removeObserver");
            LiveData<T>.ObserverWrapper remove = this.mObservers.remove(observer);
            if (remove == null) {
                return;
            }
            remove.detachObserver();
            remove.activeStateChanged(false);
        }
    }

    @MainThread
    public void removeObservers(@NonNull LifecycleOwner lifecycleOwner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, lifecycleOwner) == null) {
            assertMainThread("removeObservers");
            Iterator<Map.Entry<Observer<? super T>, LiveData<T>.ObserverWrapper>> it = this.mObservers.iterator();
            while (it.hasNext()) {
                Map.Entry<Observer<? super T>, LiveData<T>.ObserverWrapper> next = it.next();
                if (next.getValue().isAttachedTo(lifecycleOwner)) {
                    removeObserver(next.getKey());
                }
            }
        }
    }

    @MainThread
    public void setValue(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, t) == null) {
            assertMainThread("setValue");
            this.mVersion++;
            this.mData = t;
            dispatchingValue(null);
        }
    }

    public LiveData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mDataLock = new Object();
        this.mObservers = new SafeIterableMap<>();
        this.mActiveCount = 0;
        this.mPendingData = NOT_SET;
        this.mPostValueRunnable = new Runnable(this) { // from class: androidx.lifecycle.LiveData.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LiveData this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: androidx.lifecycle.LiveData */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                Object obj;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    synchronized (this.this$0.mDataLock) {
                        obj = this.this$0.mPendingData;
                        this.this$0.mPendingData = LiveData.NOT_SET;
                    }
                    this.this$0.setValue(obj);
                }
            }
        };
        this.mData = NOT_SET;
        this.mVersion = -1;
    }
}
