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
/* loaded from: classes9.dex */
public class SupplementSignActivityConfig extends TbWebViewActivityConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static String CONTINUOUS_SIGN_ALL_DAYS = "continuous_sign_all_days";
    public static String FORUM_ID = "forum_id";
    public static String JUMP_URL = "http://tieba.baidu.com/mo/q/resign/index";
    public static String SIGN_BONUS_POINT = "signBonusPoint";
    public static String SUPPLEMENT_SIGN_DAYS = "supplement_sign_days";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1828004781, "Lcom/baidu/tbadk/core/atomData/SupplementSignActivityConfig;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1828004781, "Lcom/baidu/tbadk/core/atomData/SupplementSignActivityConfig;");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SupplementSignActivityConfig(Context context, int i2, int i3) {
        super(context, r4, JUMP_URL + "?forum_id=" + i2 + "&_client_version=" + TbConfig.getVersion(), true, true, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (String) objArr2[2], ((Boolean) objArr2[3]).booleanValue(), ((Boolean) objArr2[4]).booleanValue(), ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        String string = context.getResources().getString(R.string.resign);
        getIntent().putExtra(FORUM_ID, i2);
        setRequestCode(i3);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
