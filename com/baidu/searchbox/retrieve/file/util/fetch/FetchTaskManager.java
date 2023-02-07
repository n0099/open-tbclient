package com.baidu.searchbox.retrieve.file.util.fetch;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.KVStorageFactory;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class FetchTaskManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String JSON_TIMER_JOB_ID_KEY = "jobId";
    public static final String JSON_TIMER_JOB_ORIGIN_KEY = "jobOrigin";
    public static final String SP_FETCH_DEBUG_KEY = "fetch_debug_key";
    public static final String SP_FETCH_TASK_STORE = "com.baidu.searchbox.fetch.task";
    public static final String SP_TASK_ORIGIN_KEY = "fetch_task_origin";
    public static final String SP_TASK_ORIGIN_TIMER_LIST_KEY = "fetch_task_origin_timer_list";
    public static final String SP_TASK_RETRY_COUNT_KEY = "fetch_task_retry_count";
    public static final String TAG = "FetchTaskManager";
    public static volatile FetchTaskManager sSingleton;
    public transient /* synthetic */ FieldHolder $fh;
    public final SharedPrefsWrapper mSharedPrefsWrapper;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1905523579, "Lcom/baidu/searchbox/retrieve/file/util/fetch/FetchTaskManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1905523579, "Lcom/baidu/searchbox/retrieve/file/util/fetch/FetchTaskManager;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public FetchTaskManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSharedPrefsWrapper = new SharedPrefsWrapper(KVStorageFactory.getSharedPreferences(SP_FETCH_TASK_STORE));
    }

    public static FetchTaskManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sSingleton == null) {
                synchronized (FetchTaskManager.class) {
                    if (sSingleton == null) {
                        sSingleton = new FetchTaskManager();
                    }
                }
            }
            return sSingleton;
        }
        return (FetchTaskManager) invokeV.objValue;
    }

    public void clearOriginData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            saveOriginData("");
        }
    }

    public String getOriginData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mSharedPrefsWrapper.getString(SP_TASK_ORIGIN_KEY, "");
        }
        return (String) invokeV.objValue;
    }

    public int getRetryCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mSharedPrefsWrapper.getInt(SP_TASK_RETRY_COUNT_KEY, 0);
        }
        return invokeV.intValue;
    }

    public boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mSharedPrefsWrapper.getBoolean(SP_FETCH_DEBUG_KEY, false);
        }
        return invokeV.booleanValue;
    }

    public synchronized List<JSONObject> getAllOriginTimerData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                String string = this.mSharedPrefsWrapper.getString(SP_TASK_ORIGIN_TIMER_LIST_KEY, "");
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(((JSONObject) jSONArray.get(i)).optJSONObject(JSON_TIMER_JOB_ORIGIN_KEY));
                    }
                } catch (JSONException e) {
                    if (DEBUG) {
                        Log.e(TAG, e.getMessage());
                    }
                    this.mSharedPrefsWrapper.putString(SP_TASK_ORIGIN_TIMER_LIST_KEY, "");
                }
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    public synchronized void removeOriginTimerData(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            synchronized (this) {
                String string = this.mSharedPrefsWrapper.getString(SP_TASK_ORIGIN_TIMER_LIST_KEY, "");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(str)) {
                    try {
                        JSONArray jSONArray = new JSONArray(string);
                        JSONArray jSONArray2 = new JSONArray();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                            if (!str.equals(jSONObject.optString("jobId"))) {
                                jSONArray2.put(jSONObject);
                            }
                        }
                        SharedPrefsWrapper sharedPrefsWrapper = this.mSharedPrefsWrapper;
                        if (jSONArray2.length() > 0) {
                            str2 = jSONArray.toString();
                        } else {
                            str2 = "";
                        }
                        sharedPrefsWrapper.putString(SP_TASK_ORIGIN_TIMER_LIST_KEY, str2);
                    } catch (JSONException e) {
                        if (DEBUG) {
                            Log.e(TAG, e.getMessage());
                        }
                        this.mSharedPrefsWrapper.putString(SP_TASK_ORIGIN_TIMER_LIST_KEY, "");
                    }
                }
            }
        }
    }

    public void saveOriginData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            SharedPrefsWrapper sharedPrefsWrapper = this.mSharedPrefsWrapper;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sharedPrefsWrapper.putString(SP_TASK_ORIGIN_KEY, str);
        }
    }

    public void saveRetryCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.mSharedPrefsWrapper.putInt(SP_TASK_RETRY_COUNT_KEY, i);
        }
    }

    public void setDebug(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.mSharedPrefsWrapper.putBoolean(SP_FETCH_DEBUG_KEY, z);
        }
    }

    public synchronized void saveOriginTimerData(String str, JSONObject jSONObject) {
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, jSONObject) == null) {
            synchronized (this) {
                String string = this.mSharedPrefsWrapper.getString(SP_TASK_ORIGIN_TIMER_LIST_KEY, "");
                try {
                    if (TextUtils.isEmpty(string)) {
                        jSONArray = new JSONArray();
                    } else {
                        jSONArray = new JSONArray(string);
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("jobId", str);
                    jSONObject2.put(JSON_TIMER_JOB_ORIGIN_KEY, jSONObject);
                    jSONArray.put(jSONObject2);
                    this.mSharedPrefsWrapper.putString(SP_TASK_ORIGIN_TIMER_LIST_KEY, jSONArray.toString());
                } catch (JSONException e) {
                    if (DEBUG) {
                        Log.e(TAG, e.getMessage());
                    }
                }
            }
        }
    }
}
