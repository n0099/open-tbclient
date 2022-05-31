package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class SquareSearchActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BACK_SPECIAL = "back_special";
    public static final String FROM = "start_from";
    public static final String IS_FROM_ENTER_FROUM = "is_from_enter_forum";
    public static boolean IS_SHOW_LIKE_FORUM = false;
    public static boolean IS_SHOW_RECOMMEND_FORUM = true;
    public static final String SEARCH_TITLE = "search";
    public static final String SEARCH_VALUE = "searchValue";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1411207934, "Lcom/baidu/tbadk/core/atomData/SquareSearchActivityConfig;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1411207934, "Lcom/baidu/tbadk/core/atomData/SquareSearchActivityConfig;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareSearchActivityConfig(Context context, String str, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        getIntent().putExtra("start_from", str);
        getIntent().putExtra("back_special", z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareSearchActivityConfig(Context context, String str, boolean z, String str2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Boolean.valueOf(z), str2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        getIntent().putExtra("start_from", str);
        getIntent().putExtra("back_special", z);
        getIntent().putExtra("search", str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareSearchActivityConfig(Context context, String str, boolean z, String str2, String str3) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Boolean.valueOf(z), str2, str3};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        getIntent().putExtra("start_from", str);
        getIntent().putExtra("back_special", z);
        getIntent().putExtra("search", str2);
        getIntent().putExtra(SEARCH_VALUE, str3);
    }
}
