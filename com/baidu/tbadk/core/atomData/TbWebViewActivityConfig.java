package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class TbWebViewActivityConfig extends WebViewActivityConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static String GOD_INVITE_JUMP_URL = "https://tiebac.baidu.com/mo/q/god/inviteGod";
    public static final String JUMP_PARAMS_PAGE_TYPE = "?page_type=open_full_screen_opacity_web_page";
    public static final String KEY_IS_FROM_SCHEMA = "key_is_from_schema";
    public static final String KEY_USE_CUSTOM_HISTORY_STACK = "use_custom_history_stack";
    public static final String PAGE_TYPE_BLACK_TRANSLUCENT = "open_full_screen_opacity_web_page";
    public static final String PAGE_TYPE_NORMAL = "normal";
    public static final String PARAMS_KEY_PAGE_FROM = "page_from";
    public static final String PARAMS_KEY_PAGE_TYPE = "page_type";
    public static final String V_PAGE_FROM_LIVE = "live";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1411175622, "Lcom/baidu/tbadk/core/atomData/TbWebViewActivityConfig;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1411175622, "Lcom/baidu/tbadk/core/atomData/TbWebViewActivityConfig;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbWebViewActivityConfig(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TbWebViewActivityConfig(Context context, String str, String str2, boolean z) {
        this(context, str, str2, true, z, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (String) objArr2[2], ((Boolean) objArr2[3]).booleanValue(), ((Boolean) objArr2[4]).booleanValue(), ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbWebViewActivityConfig(Context context, String str, String str2, boolean z, boolean z2, boolean z3) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
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
        init(str, TextUtils.isEmpty(str2) ? str2 : processUrl(Uri.parse(str2)), z2, z, z3);
    }

    private String processUrl(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, uri)) == null) {
            if (uri == null) {
                return "";
            }
            String path = uri.getPath();
            if (!TextUtils.isEmpty(path) && path.contains("/panelIcon")) {
                String queryParameter = uri.getQueryParameter("user_id");
                if (TextUtils.isEmpty(queryParameter)) {
                    return uri.toString();
                }
                if (!queryParameter.equals(String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                    return uri.toString();
                }
                return uri.getScheme() + "://" + uri.getHost() + "/mo/q/icon/home?" + uri.getQuery();
            }
            return uri.toString();
        }
        return (String) invokeL.objValue;
    }

    public void setIsFromSchema(boolean z) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (intent = getIntent()) != null) {
            intent.putExtra(KEY_IS_FROM_SCHEMA, z);
        }
    }

    public void setUri(Uri uri) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri) != null) || uri == null) {
            return;
        }
        String processUrl = processUrl(uri);
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(IntentConfig.KEY_URI, Uri.parse(processUrl));
        }
    }

    public void setUseCustomHistoryStack(boolean z) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && (intent = getIntent()) != null) {
            intent.putExtra(KEY_USE_CUSTOM_HISTORY_STACK, z);
        }
    }
}
