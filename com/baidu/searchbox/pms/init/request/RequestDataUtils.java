package com.baidu.searchbox.pms.init.request;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class RequestDataUtils {
    public static JSONObject addFilter(JSONObject jSONObject) {
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

    public static String checkParamsWithMsg(RequestParams requestParams) {
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

    public static PackageInfo createPackageFile(String str) {
        PackageInfo packageInfo = new PackageInfo();
        packageInfo.packageName = str;
        packageInfo.updateVersion = -1L;
        return packageInfo;
    }

    public static JSONObject getEnvStr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PmsConstant.EnvParam.Key.CPU_ABI, CommonUtils.getCpuAbi());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static String getKey(String str, String str2) {
        return str + "_" + str2;
    }

    public static JSONObject getPostData(List<RequestParams.Channel> list) throws JSONException {
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
                    putNormalChannel(channel, jSONObject, arrayList);
                }
            }
        }
        StatisticUtils.sendDegradeData(arrayList);
        return jSONObject;
    }

    public static CloudControlRequestInfo getRequestInfo(RequestParams requestParams, Object obj) {
        JSONObject jSONObject;
        if (requestParams == null) {
            return null;
        }
        String str = ApsCloudControlProcessor.SERVER_APS;
        HashMap hashMap = new HashMap();
        JSONObject addFilter = addFilter(requestParams.getFilter());
        try {
            jSONObject = getPostData(requestParams.getChannelList());
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

    public static boolean isChannelDegrade(String str) {
        return CloudControlManager.getInstance().isInDegradeList(ApsCloudControlProcessor.SERVER_APS, str, (String) null);
    }

    public static boolean isPackageNameDegrade(String str, String str2) {
        return CloudControlManager.getInstance().isInDegradeList(ApsCloudControlProcessor.SERVER_APS, str, str2);
    }

    public static void putInterceptor(IDataInterceptor iDataInterceptor, String str, @NonNull JSONObject jSONObject) throws JSONException {
        JSONObject uploadData = iDataInterceptor.getUploadData();
        if (uploadData == null) {
            return;
        }
        jSONObject.put(str, uploadData);
    }

    public static void putNormalChannel(@NonNull RequestParams.Channel channel, @NonNull JSONObject jSONObject, @NonNull List<DegradeData> list) throws JSONException {
        String channelId = channel.getChannelId();
        if (TextUtils.isEmpty(channelId)) {
            return;
        }
        if (isChannelDegrade(channelId)) {
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
        removeDegradePackageNames(channel, arrayList2, arrayList);
        if (arrayList2.size() > 0) {
            putPackageInfo(channel, arrayList2, jSONObject);
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

    public static void putPackageInfo(RequestParams.Channel channel, List<PackageParams> list, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        if (channel.isUsePmsVersionData()) {
            for (PackageInfo packageInfo : queryItems(channel.getChannelId(), CollectionUtils.convertToPackageNameList(list))) {
                if (!TextUtils.isEmpty(packageInfo.packageName)) {
                    String str = packageInfo.packageName;
                    jSONObject2.put(str, packageInfo.updateVersion + "");
                }
            }
        } else {
            for (PackageParams packageParams : list) {
                String str2 = packageParams.packageName;
                jSONObject2.put(str2, packageParams.updateVersion + "");
            }
        }
        if (jSONObject2.length() > 0) {
            jSONObject.put(channel.getChannelId(), jSONObject2);
        }
    }

    @NonNull
    public static List<PackageInfo> queryItems(@NonNull String str, @Nullable List<String> list) {
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

    public static void removeDegradePackageNames(RequestParams.Channel channel, List<PackageParams> list, List<String> list2) {
        List<PackageParams> packageParamsList;
        if (channel == null || (packageParamsList = channel.getPackageParamsList()) == null) {
            return;
        }
        for (PackageParams packageParams : packageParamsList) {
            if (isPackageNameDegrade(channel.getChannelId(), packageParams.packageName)) {
                list2.add(packageParams.packageName);
            } else {
                list.add(packageParams);
            }
        }
    }
}
