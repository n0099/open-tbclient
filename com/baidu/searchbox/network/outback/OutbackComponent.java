package com.baidu.searchbox.network.outback;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.g0.a.b.a;
import c.a.g0.a.b.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.CallFactory;
import com.baidu.searchbox.network.outback.core.CallFactoryParams;
import com.baidu.searchbox.network.outback.statistics.IAdditionalRecord;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class OutbackComponent {
    public static /* synthetic */ Interceptable $ic;
    public static volatile OutbackComponent sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public OutbackComponentHolder componentHolder;

    public OutbackComponent() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.componentHolder = new OutbackComponentHolder();
    }

    public static OutbackComponent getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sInstance == null) {
                synchronized (OutbackComponent.class) {
                    if (sInstance == null) {
                        sInstance = new OutbackComponent();
                    }
                }
            }
            return sInstance;
        }
        return (OutbackComponent) invokeV.objValue;
    }

    public CallFactory chooseCallFactory(String str, CallFactoryParams callFactoryParams) {
        InterceptResult invokeLL;
        CallFactory.CallFactoryProducer callFactoryProducer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, callFactoryParams)) == null) {
            if (!isRightEngine(str)) {
                callFactoryProducer = this.componentHolder.outbackContextHolder.get().getDefaultCallFactoryProducer();
            } else {
                callFactoryProducer = this.componentHolder.outbackContextHolder.get().getOutbackEngines().get(str);
            }
            return callFactoryProducer.produceCallFactory(callFactoryParams);
        }
        return (CallFactory) invokeLL.objValue;
    }

    public IAdditionalRecord getAdditionalRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c<IOutbackContext> cVar = this.componentHolder.outbackContextHolder;
            if (cVar != null && cVar.get() != null) {
                return this.componentHolder.outbackContextHolder.get().getIAdditionalRecord();
            }
            throw new IllegalStateException("No Context provided!");
        }
        return (IAdditionalRecord) invokeV.objValue;
    }

    public CallFactory getBackupCallFactory(CallFactoryParams callFactoryParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, callFactoryParams)) == null) ? this.componentHolder.outbackContextHolder.get().getBackupCallFactoryProducer().produceCallFactory(callFactoryParams) : (CallFactory) invokeL.objValue;
    }

    public IOutbackClientIPProvider getClientIPProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c<IOutbackContext> cVar = this.componentHolder.outbackContextHolder;
            if (cVar != null && cVar.get() != null) {
                return this.componentHolder.outbackContextHolder.get().getClientIPProvider();
            }
            throw new IllegalStateException("No Context provided!");
        }
        return (IOutbackClientIPProvider) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c<IOutbackContext> cVar = this.componentHolder.outbackContextHolder;
            if (cVar != null && cVar.get() != null) {
                return this.componentHolder.outbackContextHolder.get().getContext();
            }
            throw new IllegalStateException("No Context provided!");
        }
        return (Context) invokeV.objValue;
    }

    public boolean isCallFactoryProducerAvailable() {
        InterceptResult invokeV;
        IOutbackContext iOutbackContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c<IOutbackContext> cVar = this.componentHolder.outbackContextHolder;
            return (cVar == null || (iOutbackContext = cVar.get()) == null || iOutbackContext.getDefaultCallFactoryProducer() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean isRightEngine(String str) {
        InterceptResult invokeL;
        IOutbackContext iOutbackContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            c<IOutbackContext> cVar = this.componentHolder.outbackContextHolder;
            if (cVar == null || (iOutbackContext = cVar.get()) == null) {
                return false;
            }
            return iOutbackContext.getOutbackEngines().containsKey(str);
        }
        return invokeL.booleanValue;
    }

    public CallFactory newCallFactory(CallFactoryParams callFactoryParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, callFactoryParams)) == null) {
            if (isCallFactoryProducerAvailable()) {
                return this.componentHolder.outbackContextHolder.get().getDefaultCallFactoryProducer().produceCallFactory(callFactoryParams);
            }
            throw new IllegalStateException("No CallFactory producer available!");
        }
        return (CallFactory) invokeL.objValue;
    }

    public OutbackComponent setOutbackContext(IOutbackContext iOutbackContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iOutbackContext)) == null) {
            OutbackComponentHolder outbackComponentHolder = this.componentHolder;
            if (outbackComponentHolder.outbackContextHolder == null) {
                outbackComponentHolder.outbackContextHolder = new a();
            }
            this.componentHolder.outbackContextHolder.a(new c.a.g0.a.a<IOutbackContext>(this, iOutbackContext) { // from class: com.baidu.searchbox.network.outback.OutbackComponent.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ OutbackComponent this$0;
                public final /* synthetic */ IOutbackContext val$outbackContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iOutbackContext};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$outbackContext = iOutbackContext;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // c.a.g0.a.a
                public IOutbackContext get() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.val$outbackContext : (IOutbackContext) invokeV.objValue;
                }
            });
            return this;
        }
        return (OutbackComponent) invokeL.objValue;
    }
}
