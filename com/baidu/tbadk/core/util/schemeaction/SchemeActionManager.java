package com.baidu.tbadk.core.util.schemeaction;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkProcessor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public class SchemeActionManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MATCH = 0;
    public static final int MATCH_AND_FINISH_WEBVIEW = 1;
    public static final int MATCH_REDIRECT_BACK = 2;
    public static final int NOT_MATCH = 3;
    public static SchemeActionManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, SchemeActionProcessor> mHandlers;

    /* loaded from: classes11.dex */
    public interface SchemeActionProcessor {
        void doSchemeAction(TbPageContext<?> tbPageContext, String str, Bundle bundle);

        String getSchemeAction();
    }

    public SchemeActionManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHandlers = new ConcurrentHashMap<>();
        registerSchemeActionProcessor(new DeepLinkProcessor());
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

    public int doSchemeAction(TbPageContext<?> tbPageContext, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, str)) == null) ? doSchemeAction(tbPageContext, str, null) : invokeLL.intValue;
    }

    public void registerSchemeActionProcessor(SchemeActionProcessor schemeActionProcessor) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, schemeActionProcessor) == null) || schemeActionProcessor == null || StringUtils.isNull(schemeActionProcessor.getSchemeAction())) {
            return;
        }
        this.mHandlers.put(schemeActionProcessor.getSchemeAction(), schemeActionProcessor);
    }

    public void unRegisterSchemeActionProcessor(SchemeActionProcessor schemeActionProcessor) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, schemeActionProcessor) == null) || schemeActionProcessor == null || StringUtils.isNull(schemeActionProcessor.getSchemeAction())) {
            return;
        }
        unRegisterSchemeActionProcessor(schemeActionProcessor.getSchemeAction());
    }

    public int doSchemeAction(TbPageContext<?> tbPageContext, String str, Bundle bundle) {
        InterceptResult invokeLLL;
        SchemeActionProcessor schemeActionProcessor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, str, bundle)) == null) {
            if (str != null && str.length() != 0) {
                String schemeActionFromScheme = SchemeActionParser.getSchemeActionFromScheme(str);
                if (!StringUtils.isNull(schemeActionFromScheme) && (schemeActionProcessor = this.mHandlers.get(schemeActionFromScheme)) != null) {
                    schemeActionProcessor.doSchemeAction(tbPageContext, str, bundle);
                    return 0;
                }
            }
            return 3;
        }
        return invokeLLL.intValue;
    }

    public void unRegisterSchemeActionProcessor(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        String schemeActionFromScheme = SchemeActionParser.getSchemeActionFromScheme(str);
        if (StringUtils.isNull(schemeActionFromScheme)) {
            return;
        }
        this.mHandlers.remove(schemeActionFromScheme);
    }
}
