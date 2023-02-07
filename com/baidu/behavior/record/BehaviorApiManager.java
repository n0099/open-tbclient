package com.baidu.behavior.record;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.behavior.record.api.Behavior;
import com.baidu.behavior.record.api.IBehaviorApi;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BehaviorApiManager implements IBehaviorApi {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BEHAVIOR_TYPE = "t";
    public static final String EXT = "ext";
    public static final String FROM = "from";
    public static final String FROM_VALUE = "PrivateList";
    public static final String INFO_NAME = "i";
    public static final String SOURCE = "source";
    public static final String TAG = "BehaviorApiManager";
    public static final String TYPE = "type";
    public static final String UBC_ID = "5029";
    public static final String USE_COUNT = "c";
    public static final String VALUE = "value";
    public static volatile BehaviorApiManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;

    public BehaviorApiManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static BehaviorApiManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sInstance == null) {
                synchronized (BehaviorApiManager.class) {
                    if (sInstance == null) {
                        sInstance = new BehaviorApiManager();
                    }
                }
            }
            return sInstance;
        }
        return (BehaviorApiManager) invokeV.objValue;
    }

    public static boolean isInfoNameIdValid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                if (!AppConfig.isDebug()) {
                    return false;
                }
                throw new RuntimeException("addBehavior: infoName must not be null!");
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean isNull(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                if (!AppConfig.isDebug()) {
                    return true;
                }
                throw new RuntimeException("addBehavior: scene must not be null!");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void upload(String str, List<Behavior> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, list) == null) {
            try {
                if (!list.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    for (Behavior behavior : list) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("i", behavior.getInfoName());
                        jSONObject.put("c", behavior.getUseCount());
                        jSONObject.put("t", behavior.getBehaviorType());
                        jSONArray.put(jSONObject);
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("p", jSONArray);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.putOpt("source", str);
                    jSONObject3.put("from", FROM_VALUE);
                    jSONObject3.putOpt("ext", jSONObject2);
                    if (AppConfig.isDebug()) {
                        Log.d(TAG, jSONObject3.toString());
                    }
                    ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(UBC_ID, jSONObject3);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.baidu.behavior.record.api.IBehaviorApi
    public void addBehavior(int i, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeILL(1048576, this, i, str, str2) != null) || !isInfoNameIdValid(str) || isNull(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("i", str);
            jSONObject.put("c", 1);
            jSONObject.put("t", i);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("p", jSONArray);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("source", str2);
            jSONObject3.put("from", FROM_VALUE);
            jSONObject3.putOpt("ext", jSONObject2);
            if (AppConfig.isDebug()) {
                Log.d(TAG, jSONObject3.toString());
            }
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(UBC_ID, jSONObject3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.behavior.record.api.IBehaviorApi
    public void addBehavior(int i, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, str2, str3}) != null) || !isInfoNameIdValid(str) || isNull(str3)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("i", str);
            jSONObject.put("c", 1);
            jSONObject.put("t", i);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("p", jSONArray);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("source", str3);
            jSONObject3.put("from", FROM_VALUE);
            jSONObject3.putOpt("ext", jSONObject2);
            if (AppConfig.isDebug()) {
                Log.d(TAG, jSONObject3.toString());
            }
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(UBC_ID, jSONObject3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0018  */
    @Override // com.baidu.behavior.record.api.IBehaviorApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addBehavior(List<Behavior> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && list != null && !list.isEmpty()) {
            for (Behavior behavior : list) {
                if (!isInfoNameIdValid(behavior.getInfoName()) || isNull(behavior.getScene())) {
                    return;
                }
                while (r0.hasNext()) {
                }
            }
            try {
                HashMap hashMap = new HashMap();
                ArrayList arrayList = new ArrayList();
                for (Behavior behavior2 : list) {
                    if (TextUtils.isEmpty(behavior2.getScene())) {
                        arrayList.add(behavior2);
                    } else {
                        List list2 = (List) hashMap.get(behavior2.getScene());
                        if (list2 == null) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(behavior2);
                            hashMap.put(behavior2.getScene(), arrayList2);
                        } else {
                            list2.add(behavior2);
                        }
                    }
                }
                upload("", arrayList);
                for (Map.Entry entry : hashMap.entrySet()) {
                    upload((String) entry.getKey(), (List) entry.getValue());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
