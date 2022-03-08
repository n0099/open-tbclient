package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.frs.accelerator.AcceleratorData;
import com.baidu.tieba.frs.accelerator.PkgNameAndNodeInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class AcceleratorActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACCELERATOR_DATA = "accelerator_data";
    public static final String FID = "fid";
    public static final String IS_NEW_ITEM = "is_new_item";
    public static final String NODE_INFO = "node_info";
    public static final String SOURCE = "source";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AcceleratorActivityConfig(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public AcceleratorActivityConfig setAcceleratorData(AcceleratorData acceleratorData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, acceleratorData)) == null) {
            if (acceleratorData != null) {
                getIntent().putExtra(ACCELERATOR_DATA, acceleratorData);
            }
            return this;
        }
        return (AcceleratorActivityConfig) invokeL.objValue;
    }

    public AcceleratorActivityConfig setCurrentNodeInfo(PkgNameAndNodeInfoData pkgNameAndNodeInfoData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pkgNameAndNodeInfoData)) == null) {
            if (pkgNameAndNodeInfoData != null) {
                getIntent().putExtra(NODE_INFO, pkgNameAndNodeInfoData);
            }
            return this;
        }
        return (AcceleratorActivityConfig) invokeL.objValue;
    }

    public AcceleratorActivityConfig setFid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!StringUtils.isNull(str)) {
                getIntent().putExtra("fid", str);
            }
            return this;
        }
        return (AcceleratorActivityConfig) invokeL.objValue;
    }

    public AcceleratorActivityConfig setIsNewItem(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            getIntent().putExtra(IS_NEW_ITEM, z);
            return this;
        }
        return (AcceleratorActivityConfig) invokeZ.objValue;
    }

    public AcceleratorActivityConfig setSource(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            getIntent().putExtra("source", i2);
            return this;
        }
        return (AcceleratorActivityConfig) invokeI.objValue;
    }
}
