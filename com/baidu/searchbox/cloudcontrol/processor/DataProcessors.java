package com.baidu.searchbox.cloudcontrol.processor;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.cloudcontrol.runtime.ICloudControlRegister;
import com.baidu.tieba.gn8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
@Autowired
/* loaded from: classes2.dex */
public class DataProcessors {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, ICloudControlProcessor> mDataProcessors;

    public DataProcessors() {
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
        this.mDataProcessors = new HashMap<>();
        collectProcessors();
    }

    @Inject
    private ICloudControlRegister getCloudControlRegister() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            return gn8.a();
        }
        return (ICloudControlRegister) invokeV.objValue;
    }

    public void collectProcessors() {
        ICloudControlRegister cloudControlRegister;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (cloudControlRegister = getCloudControlRegister()) != null) {
            cloudControlRegister.registerAllProcessors(this);
        }
    }

    public HashMap<String, ICloudControlProcessor> getProcessors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mDataProcessors;
        }
        return (HashMap) invokeV.objValue;
    }

    public void addProcessor(String str, ICloudControlProcessor iCloudControlProcessor) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, iCloudControlProcessor) == null) && iCloudControlProcessor != null && !TextUtils.isEmpty(str)) {
            this.mDataProcessors.put(str, iCloudControlProcessor);
        }
    }

    public boolean containKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return this.mDataProcessors.containsKey(str);
        }
        return invokeL.booleanValue;
    }

    public ICloudControlProcessor getProcessor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.mDataProcessors.get(str);
        }
        return (ICloudControlProcessor) invokeL.objValue;
    }
}
