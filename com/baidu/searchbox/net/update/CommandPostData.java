package com.baidu.searchbox.net.update;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CommandPostData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "CommandPostData";
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject data;
    public JSONObject pubData;
    public JSONObject version;

    /* renamed from: com.baidu.searchbox.net.update.CommandPostData$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static final class SubPostDataKey {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String dataKey;
        public String versionKey;

        public SubPostDataKey() {
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

        public /* synthetic */ SubPostDataKey(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-537298688, "Lcom/baidu/searchbox/net/update/CommandPostData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-537298688, "Lcom/baidu/searchbox/net/update/CommandPostData;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public void cleanEmptyData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            cleanEmptyData(this.version);
            cleanEmptyData(this.data);
        }
    }

    public JSONObject getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.data;
        }
        return (JSONObject) invokeV.objValue;
    }

    public JSONObject getPubData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.pubData;
        }
        return (JSONObject) invokeV.objValue;
    }

    public JSONObject getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.version;
        }
        return (JSONObject) invokeV.objValue;
    }

    public CommandPostData(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, jSONObject2, jSONObject3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (DEBUG && (jSONObject == null || jSONObject2 == null)) {
            throw new RuntimeException("version and data can not be null, it is impossible");
        }
        this.version = jSONObject == null ? new JSONObject() : jSONObject;
        this.data = jSONObject2 == null ? new JSONObject() : jSONObject2;
        this.pubData = jSONObject3;
    }

    private void cleanEmptyData(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, jSONObject) == null) {
            LinkedList<String> linkedList = new LinkedList();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                if (optJSONObject != null && optJSONObject.length() == 0) {
                    linkedList.add(next);
                }
            }
            for (String str : linkedList) {
                jSONObject.remove(str);
            }
        }
    }

    public CommandPostData getSubPostData(String str) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            SubPostDataKey subPostDataKey = getSubPostDataKey(str);
            JSONObject jSONObject = this.version;
            JSONObject jSONObject2 = this.data;
            JSONObject optJSONObject = jSONObject.optJSONObject(subPostDataKey.versionKey);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
                jSONObject.put(subPostDataKey.versionKey, optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject2.optJSONObject(subPostDataKey.dataKey);
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
                jSONObject2.put(subPostDataKey.dataKey, optJSONObject2);
            }
            return new CommandPostData(optJSONObject, optJSONObject2, this.pubData);
        }
        return (CommandPostData) invokeL.objValue;
    }

    public static String getKey(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            return str2 + str + str3;
        }
        return (String) invokeLLL.objValue;
    }

    private SubPostDataKey getSubPostDataKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            SubPostDataKey subPostDataKey = new SubPostDataKey(null);
            subPostDataKey.versionKey = getKey(str, null, "_v");
            subPostDataKey.dataKey = getKey(str, null, null);
            return subPostDataKey;
        }
        return (SubPostDataKey) invokeL.objValue;
    }

    public void removeEmptySubPostData(String str, CommandPostData commandPostData) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, commandPostData) == null) {
            SubPostDataKey subPostDataKey = getSubPostDataKey(str);
            JSONObject jSONObject = this.version;
            JSONObject jSONObject2 = this.data;
            JSONObject version = commandPostData.getVersion();
            JSONObject data = commandPostData.getData();
            if (version.length() <= 0) {
                jSONObject.put(subPostDataKey.versionKey, (Object) null);
            }
            if (data.length() <= 0) {
                jSONObject2.put(subPostDataKey.dataKey, (Object) null);
            }
        }
    }
}
