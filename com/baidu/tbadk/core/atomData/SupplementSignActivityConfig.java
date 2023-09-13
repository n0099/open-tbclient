package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class SupplementSignActivityConfig extends TbWebViewActivityConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static String CONTINUOUS_SIGN_ALL_DAYS = "continuous_sign_all_days";
    public static String FORUM_ID = "forum_id";
    public static String JUMP_URL = null;
    public static String SIGN_BONUS_POINT = "signBonusPoint";
    public static String SUPPLEMENT_SIGN_DAYS = "supplement_sign_days";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1828004781, "Lcom/baidu/tbadk/core/atomData/SupplementSignActivityConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1828004781, "Lcom/baidu/tbadk/core/atomData/SupplementSignActivityConfig;");
                return;
            }
        }
        JUMP_URL = TbConfig.TIEBA_ADDRESS + "mo/q/resign/index";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SupplementSignActivityConfig(Context context, int i, int i2) {
        super(context, r4, JUMP_URL + "?forum_id=" + i + "&_client_version=" + TbConfig.getVersion(), true, true, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (String) objArr2[2], ((Boolean) objArr2[3]).booleanValue(), ((Boolean) objArr2[4]).booleanValue(), ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        String string = context.getResources().getString(R.string.obfuscated_res_0x7f0f1274);
        getIntent().putExtra(FORUM_ID, i);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
