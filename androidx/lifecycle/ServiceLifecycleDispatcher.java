package androidx.lifecycle;

import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ServiceLifecycleDispatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler mHandler;
    public DispatchRunnable mLastDispatchRunnable;
    public final LifecycleRegistry mRegistry;

    /* loaded from: classes.dex */
    public static class DispatchRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Lifecycle.Event mEvent;
        public final LifecycleRegistry mRegistry;
        public boolean mWasExecuted;

        public DispatchRunnable(LifecycleRegistry lifecycleRegistry, Lifecycle.Event event) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lifecycleRegistry, event};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mWasExecuted = false;
            this.mRegistry = lifecycleRegistry;
            this.mEvent = event;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.mWasExecuted) {
                this.mRegistry.handleLifecycleEvent(this.mEvent);
                this.mWasExecuted = true;
            }
        }
    }

    public ServiceLifecycleDispatcher(LifecycleOwner lifecycleOwner) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lifecycleOwner};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRegistry = new LifecycleRegistry(lifecycleOwner);
        this.mHandler = new Handler();
    }

    private void postDispatchRunnable(Lifecycle.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, event) == null) {
            DispatchRunnable dispatchRunnable = this.mLastDispatchRunnable;
            if (dispatchRunnable != null) {
                dispatchRunnable.run();
            }
            DispatchRunnable dispatchRunnable2 = new DispatchRunnable(this.mRegistry, event);
            this.mLastDispatchRunnable = dispatchRunnable2;
            this.mHandler.postAtFrontOfQueue(dispatchRunnable2);
        }
    }

    public Lifecycle getLifecycle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mRegistry;
        }
        return (Lifecycle) invokeV.objValue;
    }

    public void onServicePreSuperOnBind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            postDispatchRunnable(Lifecycle.Event.ON_START);
        }
    }

    public void onServicePreSuperOnCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            postDispatchRunnable(Lifecycle.Event.ON_CREATE);
        }
    }

    public void onServicePreSuperOnDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            postDispatchRunnable(Lifecycle.Event.ON_STOP);
            postDispatchRunnable(Lifecycle.Event.ON_DESTROY);
        }
    }

    public void onServicePreSuperOnStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            postDispatchRunnable(Lifecycle.Event.ON_START);
        }
    }
}
