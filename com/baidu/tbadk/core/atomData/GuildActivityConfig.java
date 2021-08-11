package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class GuildActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FROM_ABOUT_PAGE = "from_about_page";
    public static final String FROM_LOGO_PAGE = "from_logo_page";
    public static final String FROM_PAGE = "from_page";
    public static final String GUIDE_TYPE = "guide_type";
    public static final int GUIDE_TYPE_CUSTOM = 2;
    public static final int GUIDE_TYPE_VERSION = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildActivityConfig(Context context) {
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

    public GuildActivityConfig createNormalCfg(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            if (z) {
                return createNormalCfg(str, 2);
            }
            return createNormalCfg(str, 1);
        }
        return (GuildActivityConfig) invokeLZ.objValue;
    }

    public GuildActivityConfig createNormalCfg(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i2)) == null) {
            Intent intent = getIntent();
            intent.putExtra(FROM_PAGE, str);
            intent.putExtra(GUIDE_TYPE, i2);
            return this;
        }
        return (GuildActivityConfig) invokeLI.objValue;
    }
}
