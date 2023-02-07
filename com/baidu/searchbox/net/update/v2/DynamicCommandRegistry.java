package com.baidu.searchbox.net.update.v2;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
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
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DynamicCommandRegistry {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DynamicCommandRegistry";
    public static volatile DynamicCommandRegistry mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<Pair<String, String>, AbstractCommandListener> mDynamicListenerMap;

    public DynamicCommandRegistry() {
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
        this.mDynamicListenerMap = new HashMap();
    }

    public static DynamicCommandRegistry getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (mInstance == null) {
                synchronized (DynamicCommandRegistry.class) {
                    if (mInstance == null) {
                        mInstance = new DynamicCommandRegistry();
                    }
                }
            }
            return mInstance;
        }
        return (DynamicCommandRegistry) invokeV.objValue;
    }

    public Map<Pair<String, String>, AbstractCommandListener> getDynamicListenerMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mDynamicListenerMap;
        }
        return (Map) invokeV.objValue;
    }

    private void collectPostData(Context context, AbstractCommandListener abstractCommandListener, CommandPostData commandPostData, String str, String str2) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLLL(65537, this, context, abstractCommandListener, commandPostData, str, str2) == null) && context != null && abstractCommandListener != null && commandPostData != null) {
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

    private Pair<String, String> pair(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, str2)) == null) {
            return new Pair<>(str, str2);
        }
        return (Pair) invokeLL.objValue;
    }

    public AbstractCommandListener getDynamicCommandListener(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            return this.mDynamicListenerMap.get(pair(str, str2));
        }
        return (AbstractCommandListener) invokeLL.objValue;
    }

    public void collectDynamicPostData(Context context, CommandPostData commandPostData, IUpdatePostDataFilter iUpdatePostDataFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, commandPostData, iUpdatePostDataFilter) == null) {
            for (Pair<String, String> pair : this.mDynamicListenerMap.keySet()) {
                if (iUpdatePostDataFilter == null || !iUpdatePostDataFilter.isNeedFilter((String) pair.first, (String) pair.second)) {
                    try {
                        collectPostData(context, getDynamicCommandListener((String) pair.first, (String) pair.second), commandPostData, (String) pair.first, (String) pair.second);
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (AppConfig.isDebug()) {
                            Log.e(TAG, "addPostData error " + e.getMessage());
                        }
                    }
                }
            }
            commandPostData.cleanEmptyData();
        }
    }

    public void registerDynamicCommandListener(String str, String str2, AbstractCommandListener abstractCommandListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, abstractCommandListener) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mDynamicListenerMap.put(pair(str, str2), abstractCommandListener);
        }
    }

    public void registerDynamicCommandListener(String str, List<String> list, AbstractCommandListener abstractCommandListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048580, this, str, list, abstractCommandListener) == null) && list != null && list.size() > 0) {
            for (String str2 : list) {
                registerDynamicCommandListener(str, str2, abstractCommandListener);
            }
        }
    }
}
