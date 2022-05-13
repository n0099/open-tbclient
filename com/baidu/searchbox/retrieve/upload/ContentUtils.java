package com.baidu.searchbox.retrieve.upload;

import android.text.TextUtils;
import androidx.annotation.NonNull;
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
import com.repackage.jd9;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ContentUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEBUG;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-334518514, "Lcom/baidu/searchbox/retrieve/upload/ContentUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-334518514, "Lcom/baidu/searchbox/retrieve/upload/ContentUtils;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public ContentUtils() {
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

    public static JSONObject createActiveReqContent(@NonNull ActiveUpObj activeUpObj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, activeUpObj)) != null) {
            return (JSONObject) invokeL.objValue;
        }
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("type", activeUpObj.getType());
                jSONObject2.put(UploadConstant.DATA_ID, activeUpObj.getDataId());
                jSONObject2.put("space", activeUpObj.getSpace().toString());
                jSONObject2.put(UploadConstant.FILEMETA, activeUpObj.getFileMeta());
                jSONObject2.put("fileid", activeUpObj.getFileID());
                jSONObject2.put("timestamp", String.valueOf(System.currentTimeMillis() / TimeUnit.SECONDS.toMillis(1L)));
                jSONObject2.put(UploadConstant.FILE_TYPE, activeUpObj.getFileType());
                jSONObject2.put("sign", createSign(jSONObject2, "acupload"));
                return jSONObject2;
            } catch (JSONException e) {
                e = e;
                jSONObject = jSONObject2;
                if (DEBUG) {
                    e.printStackTrace();
                }
                return jSONObject;
            }
        } catch (JSONException e2) {
            e = e2;
        }
    }

    public static JSONObject createFetchReqContent(@NonNull FetchTaskObj fetchTaskObj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, null, fetchTaskObj)) != null) {
            return (JSONObject) invokeL.objValue;
        }
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("type", fetchTaskObj.getType());
                jSONObject2.put("value", fetchTaskObj.getValue());
                jSONObject2.put("jobid", fetchTaskObj.getJobID());
                jSONObject2.put("version", fetchTaskObj.getVersion());
                if (!TextUtils.isEmpty(fetchTaskObj.getStatus())) {
                    jSONObject2.put("status", fetchTaskObj.getStatus());
                }
                if (!TextUtils.isEmpty(fetchTaskObj.getOrigin())) {
                    jSONObject2.put("origin", fetchTaskObj.getOrigin());
                }
                if (!TextUtils.isEmpty(fetchTaskObj.getFileMeta())) {
                    jSONObject2.put(UploadConstant.FILEMETA, fetchTaskObj.getFileMeta());
                }
                if (!TextUtils.isEmpty(fetchTaskObj.getFileID())) {
                    jSONObject2.put("fileid", fetchTaskObj.getFileID());
                }
                jSONObject2.put("timestamp", String.valueOf(System.currentTimeMillis() / TimeUnit.SECONDS.toMillis(1L)));
                jSONObject2.put("sign", createSign(jSONObject2, "fetchlog"));
                return jSONObject2;
            } catch (JSONException e) {
                e = e;
                jSONObject = jSONObject2;
                if (DEBUG) {
                    e.printStackTrace();
                }
                return jSONObject;
            }
        } catch (JSONException e2) {
            e = e2;
        }
    }

    public static FetchResult createResult(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return new FetchResult(jSONObject.optString("jobid"), jSONObject.optString("valid"));
        }
        return (FetchResult) invokeL.objValue;
    }

    public static String createSign(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, jSONObject, str)) == null) {
            if (jSONObject != null) {
                StringBuffer stringBuffer = new StringBuffer();
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        String string = jSONObject.getString(next);
                        if (!TextUtils.isEmpty(string)) {
                            hashMap.put(next, string);
                        }
                    } catch (JSONException e) {
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
                ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                Collections.sort(arrayList, new Comparator<Map.Entry<String, String>>() { // from class: com.baidu.searchbox.retrieve.upload.ContentUtils.1
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

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.Comparator
                    public int compare(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
                        InterceptResult invokeLL2;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL2 = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entry, entry2)) == null) ? entry.getKey().compareTo(entry2.getKey()) : invokeLL2.intValue;
                    }
                });
                for (Map.Entry entry : arrayList) {
                    stringBuffer.append((String) entry.getKey());
                    stringBuffer.append("=");
                    stringBuffer.append((String) entry.getValue());
                }
                stringBuffer.append(str);
                return jd9.c(stringBuffer.toString().getBytes(), false);
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }
}
