package com.baidu.searchbox.net.update.v2;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.developer.DebugException;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, str2)) == null) ? new Pair<>(str, str2) : (Pair) invokeLL.objValue;
    }

    private void registerListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
        }
    }

    public void collectPostData(Context context, CommandPostData commandPostData, IUpdatePostDataFilter iUpdatePostDataFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, commandPostData, iUpdatePostDataFilter) == null) {
            for (Pair<String, String> pair : this.mListenerMap.keySet()) {
                if (iUpdatePostDataFilter == null || !iUpdatePostDataFilter.isNeedFilter((String) pair.first, (String) pair.second)) {
                    try {
                        collectPostData(context, getCommandListener((String) pair.first, (String) pair.second), commandPostData, (String) pair.first, (String) pair.second);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        if (AppConfig.isDebug()) {
                            Log.e(TAG, "addPostData error " + e2.getMessage());
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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) ? this.mListenerMap.get(pair(str, str2)) : (AbstractCommandListener) invokeLL.objValue;
    }

    public void registerCommandListener(String str, String str2, AbstractCommandListener abstractCommandListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, abstractCommandListener) == null) {
            this.mListenerMap.put(pair(str, str2), abstractCommandListener);
        }
    }

    public void collectPostData(Context context, CommandPostData commandPostData, ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, commandPostData, arrayList) == null) || arrayList == null) {
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next != null) {
                try {
                    String[] split = next.split("/");
                    if (split.length == 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                        AbstractCommandListener commandListener = getCommandListener(split[0], split[1]);
                        if (commandListener == null) {
                            if (AppConfig.isDebug()) {
                                throw new DebugException("Please Remove UnUsed Preload Item In List");
                                break;
                            }
                        } else {
                            collectPostData(context, commandListener, commandPostData, split[0], split[1]);
                        }
                    }
                } catch (Exception e2) {
                    if (AppConfig.isDebug()) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        commandPostData.cleanEmptyData();
    }

    private void collectPostData(Context context, AbstractCommandListener abstractCommandListener, CommandPostData commandPostData, String str, String str2) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65537, this, context, abstractCommandListener, commandPostData, str, str2) == null) || context == null || abstractCommandListener == null || commandPostData == null) {
            return;
        }
        JSONObject version = commandPostData.getVersion();
        JSONObject data = commandPostData.getData();
        JSONObject optJSONObject = version.optJSONObject(str);
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
            version.put(str, optJSONObject);
        }
        JSONObject optJSONObject2 = data.optJSONObject(str);
        if (optJSONObject2 == null) {
            optJSONObject2 = new JSONObject();
            data.put(str, optJSONObject2);
        }
        abstractCommandListener.addPostData(context, str, str2, new CommandPostData(optJSONObject, optJSONObject2, commandPostData.getPubData()));
    }
}
