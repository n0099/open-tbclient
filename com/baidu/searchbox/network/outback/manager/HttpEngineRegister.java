package com.baidu.searchbox.network.outback.manager;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.IOutbackClientIPProvider;
import com.baidu.searchbox.network.outback.IOutbackContext;
import com.baidu.searchbox.network.outback.OutbackComponent;
import com.baidu.searchbox.network.outback.core.CallFactory;
import com.baidu.searchbox.network.outback.statistics.IAdditionalRecord;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public final class HttpEngineRegister {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public HttpEngineRegister() {
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

    public static void register(Context context, String str, String str2, List<CallFactory.CallFactoryProducer> list, IOutbackClientIPProvider iOutbackClientIPProvider, IAdditionalRecord iAdditionalRecord) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, str, str2, list, iOutbackClientIPProvider, iAdditionalRecord}) == null) {
            HashMap hashMap = new HashMap();
            if (!list.isEmpty()) {
                for (CallFactory.CallFactoryProducer callFactoryProducer : list) {
                    hashMap.put(callFactoryProducer.getEngineName(), callFactoryProducer);
                }
                OutbackComponent.getInstance().setOutbackContext(new IOutbackContext(context, hashMap, str, iOutbackClientIPProvider, iAdditionalRecord, str2) { // from class: com.baidu.searchbox.network.outback.manager.HttpEngineRegister.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ IAdditionalRecord val$additionalRecord;
                    public final /* synthetic */ String val$backupEngineName;
                    public final /* synthetic */ IOutbackClientIPProvider val$clientIPProvider;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$defaultEngineName;
                    public final /* synthetic */ HashMap val$outbackEngines;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {context, hashMap, str, iOutbackClientIPProvider, iAdditionalRecord, str2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$context = context;
                        this.val$outbackEngines = hashMap;
                        this.val$defaultEngineName = str;
                        this.val$clientIPProvider = iOutbackClientIPProvider;
                        this.val$additionalRecord = iAdditionalRecord;
                        this.val$backupEngineName = str2;
                    }

                    @Override // com.baidu.searchbox.network.outback.IOutbackContext
                    public CallFactory.CallFactoryProducer getBackupCallFactoryProducer() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            if (!this.val$outbackEngines.containsKey(this.val$backupEngineName)) {
                                return getDefaultCallFactoryProducer();
                            }
                            return (CallFactory.CallFactoryProducer) this.val$outbackEngines.get(this.val$backupEngineName);
                        }
                        return (CallFactory.CallFactoryProducer) invokeV.objValue;
                    }

                    @Override // com.baidu.searchbox.network.outback.IOutbackContext
                    public IOutbackClientIPProvider getClientIPProvider() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            return this.val$clientIPProvider;
                        }
                        return (IOutbackClientIPProvider) invokeV.objValue;
                    }

                    @Override // com.baidu.searchbox.network.outback.IOutbackContext
                    public Context getContext() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                            return this.val$context;
                        }
                        return (Context) invokeV.objValue;
                    }

                    @Override // com.baidu.searchbox.network.outback.IOutbackContext
                    public CallFactory.CallFactoryProducer getDefaultCallFactoryProducer() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                            if (this.val$outbackEngines.containsKey(this.val$defaultEngineName)) {
                                return (CallFactory.CallFactoryProducer) this.val$outbackEngines.get(this.val$defaultEngineName);
                            }
                            throw new IllegalStateException("No CallFactory producer available!");
                        }
                        return (CallFactory.CallFactoryProducer) invokeV.objValue;
                    }

                    @Override // com.baidu.searchbox.network.outback.IOutbackContext
                    public IAdditionalRecord getIAdditionalRecord() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                            return this.val$additionalRecord;
                        }
                        return (IAdditionalRecord) invokeV.objValue;
                    }

                    @Override // com.baidu.searchbox.network.outback.IOutbackContext
                    public HashMap<String, CallFactory.CallFactoryProducer> getOutbackEngines() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                            return this.val$outbackEngines;
                        }
                        return (HashMap) invokeV.objValue;
                    }
                });
                return;
            }
            throw new IllegalStateException("OutbackEngine is null!");
        }
    }
}
