package com.baidu.tbadk.core.util.schemeaction;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class SchemeActionManager {
    public static /* synthetic */ Interceptable $ic;
    public static SchemeActionManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, SchemeActionHandler> mHandlers;

    /* loaded from: classes5.dex */
    public interface SchemeActionHandler {
        void deal(TbPageContext<?> tbPageContext, UriBuilder uriBuilder, Bundle bundle);
    }

    public SchemeActionManager() {
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
        this.mHandlers = new ConcurrentHashMap<>();
    }

    public static SchemeActionManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sInstance == null) {
                synchronized (SchemeActionManager.class) {
                    if (sInstance == null) {
                        sInstance = new SchemeActionManager();
                    }
                }
            }
            return sInstance;
        }
        return (SchemeActionManager) invokeV.objValue;
    }

    public boolean doSchemeAction(TbPageContext<?> tbPageContext, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, str)) == null) ? doSchemeAction(tbPageContext, str, null) : invokeLL.booleanValue;
    }

    public void registerSchemeAction(String str, SchemeActionHandler schemeActionHandler) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, schemeActionHandler) == null) || StringUtils.isNull(str) || schemeActionHandler == null) {
            return;
        }
        this.mHandlers.put(str, schemeActionHandler);
    }

    public void unRegisterSchemeAction(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.mHandlers.remove(str);
    }

    public boolean doSchemeAction(TbPageContext<?> tbPageContext, String str, Bundle bundle) {
        InterceptResult invokeLLL;
        SchemeActionHandler schemeActionHandler;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, str, bundle)) == null) {
            SchemeActionHelper.printLog("doSchemeAction -->" + str);
            if (str != null && str.length() != 0) {
                String parserSchemeAction = SchemeActionHelper.parserSchemeAction(str);
                if (!TextUtils.isEmpty(parserSchemeAction) && (schemeActionHandler = this.mHandlers.get(parserSchemeAction)) != null) {
                    schemeActionHandler.deal(tbPageContext, new UriBuilder(str), bundle);
                    return true;
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
