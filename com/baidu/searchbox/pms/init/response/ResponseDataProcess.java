package com.baidu.searchbox.pms.init.response;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.cloudcontrol.ICloudControlUBCCallBack;
import com.baidu.searchbox.cloudcontrol.data.CloudControlErrorBean;
import com.baidu.searchbox.cloudcontrol.data.CloudControlResponseInfo;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.bean.ResultData;
import com.baidu.searchbox.pms.callback.IDataInterceptor;
import com.baidu.searchbox.pms.callback.PackageCallback;
import com.baidu.searchbox.pms.db.PackageControl;
import com.baidu.searchbox.pms.db.PackageManager;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.searchbox.pms.init.request.RequestDataUtils;
import com.baidu.searchbox.pms.statistic.PackageFileStatisticManager;
import com.baidu.searchbox.pms.utils.ABIUtils;
import com.baidu.searchbox.pms.utils.CommonUtils;
import com.baidu.searchbox.pms.utils.DebugUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ResponseDataProcess {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List mChannelList;
    public Map mLocalMap;
    public List mRemoteList;
    public CloudControlResponseInfo mResponseInfo;

    public ResponseDataProcess() {
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

    public Map getLocalMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mLocalMap;
        }
        return (Map) invokeV.objValue;
    }

    public List getRemoteList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mRemoteList;
        }
        return (List) invokeV.objValue;
    }

    private boolean checkFilterAndRemove(String str, String str2, List list) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, str, str2, list)) == null) {
            String key = RequestDataUtils.getKey(str, str2);
            if (list != null) {
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PackageInfo packageInfo = (PackageInfo) it.next();
                    if (TextUtils.equals(key, RequestDataUtils.getKey(packageInfo.channelId, packageInfo.packageName))) {
                        if (packageInfo.errNo == 0) {
                            return false;
                        }
                        it.remove();
                    }
                }
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    private Map convertMap(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, list)) == null) {
            HashMap hashMap = new HashMap();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                PackageInfo packageInfo = (PackageInfo) it.next();
                List list2 = (List) hashMap.get(packageInfo.channelId);
                if (list2 == null) {
                    list2 = new ArrayList();
                    hashMap.put(packageInfo.channelId, list2);
                }
                list2.add(packageInfo);
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    private void dispatchChannelCallbacks(RequestParams.Channel channel, List list, Map map) {
        PackageCallback packageCallback;
        List list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, this, channel, list, map) == null) {
            String channelId = channel.getChannelId();
            PackageCallback callback = channel.getCallback();
            if (!TextUtils.isEmpty(channelId) && callback != null) {
                List filteredAndRemove = getFilteredAndRemove(channel, list, map);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                Iterator it = list.iterator();
                while (true) {
                    boolean z = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    PackageInfo packageInfo = (PackageInfo) it.next();
                    PackageInfo packageInfo2 = (PackageInfo) map.get(packageInfo.packageName);
                    z = (packageInfo2 == null || !ABIUtils.checkLocalABIIsValid(packageInfo2.abi, packageInfo.abi)) ? false : false;
                    if (packageInfo.isValid() && ABIUtils.checkABIIsValid(packageInfo.abi)) {
                        if (packageInfo2 != null) {
                            packageCallback = callback;
                            list2 = filteredAndRemove;
                            if (packageInfo2.updateVersion > packageInfo.updateVersion && z) {
                                arrayList.add(packageInfo);
                            }
                        } else {
                            packageCallback = callback;
                            list2 = filteredAndRemove;
                        }
                        if (packageInfo2 == null) {
                            arrayList2.add(packageInfo);
                        } else if (!packageInfo2.isOlderThan(packageInfo) && (packageInfo2.version != packageInfo.version || z)) {
                            try {
                                PackageInfo packageInfo3 = (PackageInfo) packageInfo2.clone();
                                packageInfo.copyTo(packageInfo3);
                                PackageControl.getInstance().addOrUpdate(packageInfo3);
                            } catch (CloneNotSupportedException e) {
                                DebugUtils.printStackTrace(e);
                            }
                            arrayList4.add(packageInfo);
                        } else {
                            arrayList3.add(packageInfo);
                        }
                    } else {
                        packageCallback = callback;
                        list2 = filteredAndRemove;
                        arrayList.add(packageInfo);
                    }
                    callback = packageCallback;
                    filteredAndRemove = list2;
                }
                PackageCallback packageCallback2 = callback;
                List list3 = filteredAndRemove;
                if (AppConfig.isDebug()) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        DebugUtils.logE("【无效资源】channelId:", channelId, (PackageInfo) it2.next());
                    }
                }
                if (list.size() > 0 && list.size() == arrayList.size()) {
                    dispatchInvalidCallback(channel, arrayList);
                    return;
                }
                ResultData resultData = new ResultData();
                resultData.addList = arrayList2;
                resultData.updateList = arrayList3;
                resultData.configChangeList = arrayList4;
                resultData.filterList = list3;
                resultData.invalidList = arrayList;
                DebugUtils.log("【响应结果】channelId:", channelId, resultData);
                packageCallback2.onResultData(resultData);
            }
        }
    }

    public static void dispatchFetchError(ErrorInfo errorInfo, RequestParams.Channel channel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, errorInfo, channel) == null) {
            dispatchFetchError(errorInfo, Collections.singletonList(channel));
        }
    }

    public static void dispatchFetchError(ErrorInfo errorInfo, List list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, null, errorInfo, list) == null) && list != null && errorInfo != null) {
            StringBuilder sb = new StringBuilder();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                RequestParams.Channel channel = (RequestParams.Channel) it.next();
                if (channel != null) {
                    DebugUtils.log("【响应结果】 channelId:", channel.getChannelId(), errorInfo.toString());
                    PackageCallback callback = channel.getCallback();
                    if (callback != null) {
                        callback.onFetchError(errorInfo);
                        sb.append(channel.getChannelId());
                        sb.append(",");
                    }
                }
            }
            PackageFileStatisticManager.getInstance().addFetchStatistic2(errorInfo.code, errorInfo.errorMsg, sb.toString(), null);
        }
    }

    private void dispatchFetchResult(List list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, this, list) != null) || this.mChannelList == null) {
            return;
        }
        Map convertMap = convertMap(list);
        this.mLocalMap = new HashMap();
        for (RequestParams.Channel channel : this.mChannelList) {
            if (channel != null) {
                String channelId = channel.getChannelId();
                PackageCallback callback = channel.getCallback();
                if (!TextUtils.isEmpty(channelId) && callback != null) {
                    Map map = null;
                    if (channel.isUsePmsVersionData()) {
                        map = PackageManager.getFinishedPackageInfo(channelId, null);
                    }
                    if (!CommonUtils.isEmpty(map)) {
                        this.mLocalMap.putAll(map);
                    }
                    if (map == null) {
                        map = new HashMap();
                    }
                    List list2 = (List) convertMap.get(channelId);
                    if (list2 == null) {
                        list2 = new ArrayList(0);
                    }
                    dispatchChannelCallbacks(channel, list2, map);
                } else {
                    return;
                }
            }
        }
    }

    public void process(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && this.mResponseInfo != null && !CommonUtils.isEmpty(this.mChannelList)) {
            JSONObject serviceData = this.mResponseInfo.getServiceData();
            CloudControlErrorBean cloudControlErrorBean = this.mResponseInfo.getCloudControlErrorBean();
            dispatchInterceptorAndRemove(this.mChannelList, serviceData, cloudControlErrorBean);
            int i = 2108;
            if (cloudControlErrorBean == null) {
                dispatchFetchError(new ErrorInfo(2108, "errorBean is null"), this.mChannelList);
                return;
            }
            int errorCode = cloudControlErrorBean.getErrorCode();
            if (errorCode == 0) {
                List parseItems = ParseUtils.parseItems(str, serviceData);
                this.mRemoteList = parseItems;
                if (parseItems == null) {
                    this.mRemoteList = new ArrayList();
                }
                dispatchFetchResult(this.mRemoteList);
                return;
            }
            if (errorCode == 1) {
                i = 2101;
            } else if (errorCode == 2) {
                i = 2105;
            } else if (errorCode == 3) {
                i = 2103;
            }
            dispatchFetchError(new ErrorInfo(i, "server errCode:" + errorCode), this.mChannelList);
        }
    }

    private void dispatchInterceptorAndRemove(List list, JSONObject jSONObject, CloudControlErrorBean cloudControlErrorBean) {
        JSONObject jSONObject2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, this, list, jSONObject, cloudControlErrorBean) == null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                RequestParams.Channel channel = (RequestParams.Channel) it.next();
                if (channel == null) {
                    it.remove();
                } else {
                    IDataInterceptor dataInterceptor = channel.getDataInterceptor();
                    if (dataInterceptor != null) {
                        if (jSONObject != null) {
                            jSONObject2 = jSONObject.optJSONObject(channel.getChannelId());
                        } else {
                            jSONObject2 = null;
                        }
                        int i2 = -1;
                        if (cloudControlErrorBean != null) {
                            i = cloudControlErrorBean.getErrorCode();
                        } else {
                            i = -1;
                        }
                        if (cloudControlErrorBean != null) {
                            i2 = cloudControlErrorBean.getSubErrorCode();
                        }
                        dataInterceptor.onReceiveData(jSONObject2, i, i2, null);
                        it.remove();
                    }
                }
            }
        }
    }

    private List getFilteredAndRemove(RequestParams.Channel channel, List list, Map map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, this, channel, list, map)) == null) {
            ArrayList arrayList = new ArrayList();
            if (channel == null) {
                return arrayList;
            }
            String channelId = channel.getChannelId();
            List<String> packageNames = channel.getPackageNames();
            PackageCallback callback = channel.getCallback();
            if (!TextUtils.isEmpty(channelId) && packageNames != null && callback != null) {
                for (String str : packageNames) {
                    if (checkFilterAndRemove(channelId, str, list)) {
                        PackageInfo packageInfo = (PackageInfo) map.get(str);
                        if (packageInfo == null) {
                            packageInfo = RequestDataUtils.createPackageFile(str);
                        }
                        arrayList.add(packageInfo);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }

    private void dispatchInvalidCallback(RequestParams.Channel channel, List list) {
        String packageInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, this, channel, list) == null) && !CommonUtils.isEmpty(list)) {
            PackageInfo packageInfo2 = (PackageInfo) list.get(0);
            if (packageInfo2 == null) {
                packageInfo = "";
            } else {
                packageInfo = packageInfo2.toString();
            }
            dispatchFetchError(new ErrorInfo(2103, "all PackageInfo is invalid ,such as:" + packageInfo), channel);
        }
    }

    public static void sendCloudControlUBCData(ICloudControlUBCCallBack iCloudControlUBCCallBack, ResponseDataProcess responseDataProcess) {
        Map map;
        int i;
        int i2;
        String str;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, iCloudControlUBCCallBack, responseDataProcess) == null) {
            List<PackageInfo> list = null;
            if (responseDataProcess != null) {
                list = responseDataProcess.getRemoteList();
                map = responseDataProcess.getLocalMap();
            } else {
                map = null;
            }
            if (list == null) {
                return;
            }
            int size = list.size();
            JSONArray jSONArray = new JSONArray();
            if (!CommonUtils.isEmpty(list)) {
                i = 0;
                i2 = 0;
                for (PackageInfo packageInfo2 : list) {
                    if (packageInfo2 != null) {
                        try {
                            if (!CommonUtils.isEmpty(map) && (packageInfo = (PackageInfo) map.get(packageInfo2.packageName)) != null) {
                                if (packageInfo2.updateVersion <= packageInfo.updateVersion) {
                                    i++;
                                    str = "2";
                                } else if (packageInfo2.version < packageInfo.version) {
                                    i2++;
                                    str = "0";
                                }
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("product", packageInfo2.channelId + "/" + packageInfo2.packageName);
                                jSONObject.put("valid", str);
                                jSONObject.put("version", packageInfo2.updateVersion);
                                jSONArray.put(jSONObject);
                            }
                            jSONObject.put("product", packageInfo2.channelId + "/" + packageInfo2.packageName);
                            jSONObject.put("valid", str);
                            jSONObject.put("version", packageInfo2.updateVersion);
                            jSONArray.put(jSONObject);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        str = "1";
                        JSONObject jSONObject2 = new JSONObject();
                    }
                }
            } else {
                i = 0;
                i2 = 0;
            }
            int i3 = (size - i) - i2;
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("count", String.format("%s,%s,%s", Integer.valueOf(size), Integer.valueOf(i3), Integer.valueOf(i)));
                jSONObject3.put("items", jSONArray);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            DebugUtils.log(jSONObject3);
            if (iCloudControlUBCCallBack != null) {
                iCloudControlUBCCallBack.setServiceInfo(jSONObject3);
            }
        }
    }

    public void setChannelList(List list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && list != null) {
            this.mChannelList = new ArrayList(list);
        }
    }

    public void setResponseInfo(CloudControlResponseInfo cloudControlResponseInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cloudControlResponseInfo) == null) {
            this.mResponseInfo = cloudControlResponseInfo;
        }
    }
}
