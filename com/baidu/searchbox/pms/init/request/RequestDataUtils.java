package com.baidu.searchbox.pms.init.request;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.cloudcontrol.CloudControlManager;
import com.baidu.searchbox.cloudcontrol.data.CloudControlRequestInfo;
import com.baidu.searchbox.pms.bean.DegradeData;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.bean.PackageParams;
import com.baidu.searchbox.pms.callback.IDataInterceptor;
import com.baidu.searchbox.pms.callback.PackageCallback;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.searchbox.pms.db.PackageManager;
import com.baidu.searchbox.pms.init.ApsCloudControlProcessor;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.searchbox.pms.init.response.ResponseDataProcess;
import com.baidu.searchbox.pms.utils.CollectionUtils;
import com.baidu.searchbox.pms.utils.CommonUtils;
import com.baidu.searchbox.pms.utils.DebugUtils;
import com.baidu.searchbox.pms.utils.StatisticUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class RequestDataUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public RequestDataUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static JSONObject addFilter(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            if (!jSONObject.has(PmsConstant.EnvParam.Key.CPU_ABI)) {
                try {
                    jSONObject.put(PmsConstant.EnvParam.Key.CPU_ABI, CommonUtils.getCpuAbi());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static String checkParamsWithMsg(RequestParams requestParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, requestParams)) == null) {
            if (requestParams == null) {
                return "params should not be null";
            }
            if (TextUtils.isEmpty(requestParams.getRunType())) {
                return "runType should not be null";
            }
            if (CommonUtils.isEmpty(requestParams.getChannelList())) {
                return "channelList should not be empty";
            }
            Iterator<RequestParams.Channel> it = requestParams.getChannelList().iterator();
            while (it.hasNext()) {
                RequestParams.Channel next = it.next();
                if (next == null) {
                    it.remove();
                } else if (next.getDataInterceptor() == null) {
                    if (TextUtils.isEmpty(next.getChannelId())) {
                        ResponseDataProcess.dispatchFetchError(new ErrorInfo(2102, "channelId should not be null"), next);
                        it.remove();
                    } else if (!next.isFetchAllPackages() && CommonUtils.isEmpty(next.getPackageParamsList())) {
                        ResponseDataProcess.dispatchFetchError(new ErrorInfo(2102, "packageNames should not be empty"), next);
                        it.remove();
                    }
                }
            }
            if (CommonUtils.isEmpty(requestParams.getChannelList())) {
                return "channelList should not be empty";
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static PackageInfo createPackageFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            PackageInfo packageInfo = new PackageInfo();
            packageInfo.packageName = str;
            packageInfo.updateVersion = -1L;
            return packageInfo;
        }
        return (PackageInfo) invokeL.objValue;
    }

    public static JSONObject getEnvStr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(PmsConstant.EnvParam.Key.CPU_ABI, CommonUtils.getCpuAbi());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static String getKey(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            return str + "_" + str2;
        }
        return (String) invokeLL.objValue;
    }

    public static JSONObject getPostData(String str, List<RequestParams.Channel> list) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, list)) == null) {
            if (list == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            ArrayList arrayList = new ArrayList();
            for (RequestParams.Channel channel : list) {
                if (channel != null) {
                    IDataInterceptor dataInterceptor = channel.getDataInterceptor();
                    if (dataInterceptor != null) {
                        putInterceptor(dataInterceptor, channel.getChannelId(), jSONObject);
                    } else {
                        putNormalChannel(str, channel, jSONObject, arrayList);
                    }
                }
            }
            StatisticUtils.sendDegradeData(arrayList);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static CloudControlRequestInfo getRequestInfo(RequestParams requestParams, Object obj) {
        InterceptResult invokeLL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, requestParams, obj)) == null) {
            if (requestParams == null) {
                return null;
            }
            String runNode = requestParams.getRunNode();
            if (TextUtils.isEmpty(runNode)) {
                runNode = "aps";
            }
            String str = runNode;
            HashMap hashMap = new HashMap();
            JSONObject addFilter = addFilter(requestParams.getFilter());
            try {
                jSONObject = getPostData(str, requestParams.getChannelList());
            } catch (JSONException e2) {
                e2.printStackTrace();
                jSONObject = null;
            }
            DebugUtils.log("【请求参数】", jSONObject);
            if (jSONObject == null || jSONObject.length() == 0) {
                return null;
            }
            return new CloudControlRequestInfo(str, jSONObject, hashMap, obj, addFilter, true);
        }
        return (CloudControlRequestInfo) invokeLL.objValue;
    }

    public static boolean isChannelDegrade(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? CloudControlManager.getInstance().isInDegradeList("aps", str, (String) null) : invokeL.booleanValue;
    }

    public static boolean isPackageNameDegrade(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, str2)) == null) ? CloudControlManager.getInstance().isInDegradeList("aps", str, str2) : invokeLL.booleanValue;
    }

    public static void putInterceptor(IDataInterceptor iDataInterceptor, String str, @NonNull JSONObject jSONObject) throws JSONException {
        JSONObject uploadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65548, null, iDataInterceptor, str, jSONObject) == null) || (uploadData = iDataInterceptor.getUploadData()) == null) {
            return;
        }
        jSONObject.put(str, uploadData);
    }

    public static void putNormalChannel(String str, @NonNull RequestParams.Channel channel, @NonNull JSONObject jSONObject, @NonNull List<DegradeData> list) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65549, null, str, channel, jSONObject, list) == null) {
            String channelId = channel.getChannelId();
            if (TextUtils.isEmpty(channelId)) {
                return;
            }
            if (isChannelDegrade(str, channelId)) {
                PackageCallback callback = channel.getCallback();
                if (callback != null) {
                    DegradeData degradeData = new DegradeData();
                    degradeData.isAllDegrade = true;
                    degradeData.channelId = channelId;
                    callback.onDegradeData(degradeData);
                    list.add(degradeData);
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (channel.isFetchAllPackages()) {
                jSONObject.put(channelId, new JSONObject());
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            removeDegradePackageNames(str, channel, arrayList2, arrayList);
            if (arrayList2.size() > 0) {
                putPackageInfo(str, channel, arrayList2, jSONObject);
            }
            PackageCallback callback2 = channel.getCallback();
            if (callback2 == null || arrayList.size() <= 0) {
                return;
            }
            DegradeData degradeData2 = new DegradeData();
            degradeData2.isAllDegrade = false;
            degradeData2.channelId = channelId;
            degradeData2.packageNames = arrayList;
            callback2.onDegradeData(degradeData2);
            list.add(degradeData2);
        }
    }

    public static void putPackageInfo(String str, RequestParams.Channel channel, List<PackageParams> list, JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65550, null, str, channel, list, jSONObject) == null) {
            JSONObject jSONObject2 = new JSONObject();
            if (channel.isUsePmsVersionData()) {
                for (PackageInfo packageInfo : queryItems(channel.getChannelId(), CollectionUtils.convertToPackageNameList(list))) {
                    if (!TextUtils.isEmpty(packageInfo.packageName)) {
                        jSONObject2.put(packageInfo.packageName, TextUtils.equals(str, ApsCloudControlProcessor.SERVER_DPM) ? packageInfo.updateSign : packageInfo.updateVersion + "");
                    }
                }
            } else {
                for (PackageParams packageParams : list) {
                    jSONObject2.put(packageParams.packageName, packageParams.getUpdateParams());
                }
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put(channel.getChannelId(), jSONObject2);
            }
        }
    }

    @NonNull
    public static List<PackageInfo> queryItems(@NonNull String str, @Nullable List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, list)) == null) {
            ArrayList arrayList = new ArrayList();
            Map<String, PackageInfo> finishedPackageFiles = PackageManager.getFinishedPackageFiles(str, list);
            if (CommonUtils.isEmpty(list)) {
                return arrayList;
            }
            for (String str2 : list) {
                PackageInfo packageInfo = finishedPackageFiles.get(str2);
                if (packageInfo == null) {
                    packageInfo = createPackageFile(str2);
                }
                arrayList.add(packageInfo);
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static void removeDegradePackageNames(String str, RequestParams.Channel channel, List<PackageParams> list, List<String> list2) {
        List<PackageParams> packageParamsList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65552, null, str, channel, list, list2) == null) || channel == null || (packageParamsList = channel.getPackageParamsList()) == null) {
            return;
        }
        for (PackageParams packageParams : packageParamsList) {
            if (isPackageNameDegrade(str, channel.getChannelId(), packageParams.packageName)) {
                list2.add(packageParams.packageName);
            } else {
                list.add(packageParams);
            }
        }
    }

    public static boolean isChannelDegrade(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) ? CloudControlManager.getInstance().isInDegradeList(str, str2, (String) null) : invokeLL.booleanValue;
    }

    public static boolean isPackageNameDegrade(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, str, str2, str3)) == null) ? CloudControlManager.getInstance().isInDegradeList(str, str2, str3) : invokeLLL.booleanValue;
    }
}
