package com.baidu.searchbox.net.update.v2;

import android.content.Context;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class CommandListenerRegistry {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "CommandListenerRegistry";
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<Pair<String, String>, AbstractCommandListener> mListenerMap;

    public CommandListenerRegistry() {
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
        this.mListenerMap = new HashMap();
        registerListeners();
    }

    private Pair<String, String> pair(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, str2)) == null) ? new Pair<>(str, str2) : (Pair) invokeLL.objValue;
    }

    private void registerListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
        }
    }

    public void collectPostData(Context context, CommandPostData commandPostData, IUpdatePostDataFilter iUpdatePostDataFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, commandPostData, iUpdatePostDataFilter) == null) {
            for (Pair<String, String> pair : this.mListenerMap.keySet()) {
                if (iUpdatePostDataFilter == null || !iUpdatePostDataFilter.isNeedFilter((String) pair.first, (String) pair.second)) {
                    try {
                        AbstractCommandListener commandListener = getCommandListener((String) pair.first, (String) pair.second);
                        JSONObject version = commandPostData.getVersion();
                        JSONObject data = commandPostData.getData();
                        JSONObject optJSONObject = version.optJSONObject((String) pair.first);
                        if (optJSONObject == null) {
                            optJSONObject = new JSONObject();
                            version.put((String) pair.first, optJSONObject);
                        }
                        JSONObject optJSONObject2 = data.optJSONObject((String) pair.first);
                        if (optJSONObject2 == null) {
                            optJSONObject2 = new JSONObject();
                            data.put((String) pair.first, optJSONObject2);
                        }
                        commandListener.addPostData(context, (String) pair.first, (String) pair.second, new CommandPostData(optJSONObject, optJSONObject2, commandPostData.getPubData()));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        if (AppConfig.isDebug()) {
                            String str = "addPostData error " + e2.getMessage();
                        }
                    }
                }
            }
            commandPostData.cleanEmptyData();
        }
    }

    public AbstractCommandListener getCommandListener(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) ? this.mListenerMap.get(pair(str, str2)) : (AbstractCommandListener) invokeLL.objValue;
    }

    public void registerCommandListener(String str, String str2, AbstractCommandListener abstractCommandListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, abstractCommandListener) == null) {
            this.mListenerMap.put(pair(str, str2), abstractCommandListener);
        }
    }
}
