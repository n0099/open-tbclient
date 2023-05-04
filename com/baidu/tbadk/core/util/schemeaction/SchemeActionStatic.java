package com.baidu.tbadk.core.util.schemeaction;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionManager;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkAction;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkItem;
import com.baidu.tieba.fg9;
import com.baidu.tieba.g10;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.JsonObject;
/* loaded from: classes3.dex */
public class SchemeActionStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1874024830, "Lcom/baidu/tbadk/core/util/schemeaction/SchemeActionStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1874024830, "Lcom/baidu/tbadk/core/util/schemeaction/SchemeActionStatic;");
                return;
            }
        }
        registerLinkActionHandler();
    }

    public SchemeActionStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void registerLinkActionHandler() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            SchemeActionHelper.printLog("------registerLinkActionHandler-----");
            SchemeActionManager.SchemeActionHandler schemeActionHandler = new SchemeActionManager.SchemeActionHandler() { // from class: com.baidu.tbadk.core.util.schemeaction.SchemeActionStatic.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.tbadk.core.util.schemeaction.SchemeActionManager.SchemeActionHandler
                public void deal(TbPageContext<?> tbPageContext, UriBuilder uriBuilder, Bundle bundle) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, tbPageContext, uriBuilder, bundle) == null) {
                        DeepLinkAction.dealDeepLink(tbPageContext.getPageActivity(), uriBuilder, bundle);
                    }
                }
            };
            SchemeActionManager.getInstance().registerSchemeAction(SchemeActionName.SCHEME_ACTION_DEEPLINK, schemeActionHandler);
            SchemeActionManager.getInstance().registerSchemeAction(SchemeActionName.SCHEME_ACTION_DOLINK, schemeActionHandler);
            SchemeActionManager.getInstance().registerSchemeAction("tiebaapp://router/portal", new SchemeActionManager.SchemeActionHandler() { // from class: com.baidu.tbadk.core.util.schemeaction.SchemeActionStatic.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.tbadk.core.util.schemeaction.SchemeActionManager.SchemeActionHandler
                public void deal(TbPageContext<?> tbPageContext, UriBuilder uriBuilder, Bundle bundle) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, tbPageContext, uriBuilder, bundle) == null) {
                        fg9.b(tbPageContext, new String[]{uriBuilder.getUriString()});
                    }
                }
            });
        }
    }

    public static String wrapThirdDeeplink(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(DeepLinkItem.DEEPLINK_APPURL_KEY, str);
            jsonObject.addProperty(DeepLinkItem.DEEPLINK_WEBURL_KEY, str2);
            return UrlUtils.appendParam(SchemeActionName.SCHEME_ACTION_DEEPLINK, "params", g10.a(jsonObject.toString()));
        }
        return (String) invokeLL.objValue;
    }
}
