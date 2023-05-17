package com.baidu.searchbox.pms.init.response;

import android.text.TextUtils;
import androidx.annotation.NonNull;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ResponseDataProcess {
    public List<RequestParams.Channel> mChannelList;
    public Map<String, PackageInfo> mLocalMap;
    public List<PackageInfo> mRemoteList;
    public CloudControlResponseInfo mResponseInfo;

    public Map<String, PackageInfo> getLocalMap() {
        return this.mLocalMap;
    }

    public List<PackageInfo> getRemoteList() {
        return this.mRemoteList;
    }

    private boolean checkFilterAndRemove(String str, String str2, List<PackageInfo> list) {
        String key = RequestDataUtils.getKey(str, str2);
        if (list != null) {
            Iterator<PackageInfo> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PackageInfo next = it.next();
                if (TextUtils.equals(key, RequestDataUtils.getKey(next.channelId, next.packageName))) {
                    if (next.errNo == 0) {
                        return false;
                    }
                    it.remove();
                }
            }
        }
        return true;
    }

    @NonNull
    private Map<String, List<PackageInfo>> convertMap(List<PackageInfo> list) {
        HashMap hashMap = new HashMap();
        for (PackageInfo packageInfo : list) {
            List list2 = (List) hashMap.get(packageInfo.channelId);
            if (list2 == null) {
                list2 = new ArrayList();
                hashMap.put(packageInfo.channelId, list2);
            }
            list2.add(packageInfo);
        }
        return hashMap;
    }

    public void setChannelList(List<RequestParams.Channel> list) {
        if (list != null) {
            this.mChannelList = new ArrayList(list);
        }
    }

    public void setResponseInfo(CloudControlResponseInfo cloudControlResponseInfo) {
        this.mResponseInfo = cloudControlResponseInfo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0075, code lost:
        if (r0.updateVersion == r11.updateVersion) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void dispatchChannelCallbacks(@NonNull RequestParams.Channel channel, @NonNull List<PackageInfo> list, @NonNull Map<String, PackageInfo> map) {
        PackageCallback packageCallback;
        List<PackageInfo> list2;
        String channelId = channel.getChannelId();
        PackageCallback callback = channel.getCallback();
        if (!TextUtils.isEmpty(channelId) && callback != null) {
            List<PackageInfo> filteredAndRemove = getFilteredAndRemove(channel, list, map);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            Iterator<PackageInfo> it = list.iterator();
            while (true) {
                boolean z = true;
                if (!it.hasNext()) {
                    break;
                }
                PackageInfo next = it.next();
                PackageInfo packageInfo = map.get(next.packageName);
                z = (packageInfo == null || !ABIUtils.checkLocalABIIsValid(packageInfo.abi, next.abi)) ? false : false;
                if (next.isValid() && ABIUtils.checkABIIsValid(next.abi)) {
                    if (packageInfo != null) {
                        if (!next.isOlderThan(packageInfo)) {
                            packageCallback = callback;
                            list2 = filteredAndRemove;
                        } else {
                            packageCallback = callback;
                            list2 = filteredAndRemove;
                        }
                        arrayList.add(next);
                    } else {
                        packageCallback = callback;
                        list2 = filteredAndRemove;
                    }
                    if (packageInfo == null) {
                        arrayList2.add(next);
                    } else if (!packageInfo.isOlderThan(next) && (packageInfo.version != next.version || z)) {
                        try {
                            PackageInfo packageInfo2 = (PackageInfo) packageInfo.clone();
                            next.copyTo(packageInfo2);
                            PackageControl.getInstance().addOrUpdate(packageInfo2);
                        } catch (CloneNotSupportedException e) {
                            DebugUtils.printStackTrace(e);
                        }
                        arrayList4.add(next);
                    } else {
                        arrayList3.add(next);
                    }
                } else {
                    packageCallback = callback;
                    list2 = filteredAndRemove;
                    arrayList.add(next);
                }
                callback = packageCallback;
                filteredAndRemove = list2;
            }
            PackageCallback packageCallback2 = callback;
            List<PackageInfo> list3 = filteredAndRemove;
            if (AppConfig.isDebug()) {
                Iterator<PackageInfo> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    DebugUtils.logE("【无效资源】channelId:", channelId, it2.next());
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

    public static void dispatchFetchError(ErrorInfo errorInfo, RequestParams.Channel channel) {
        dispatchFetchError(errorInfo, Collections.singletonList(channel));
    }

    private void dispatchInvalidCallback(@NonNull RequestParams.Channel channel, @NonNull List<PackageInfo> list) {
        String packageInfo;
        if (!CommonUtils.isEmpty(list)) {
            PackageInfo packageInfo2 = list.get(0);
            if (packageInfo2 == null) {
                packageInfo = "";
            } else {
                packageInfo = packageInfo2.toString();
            }
            dispatchFetchError(new ErrorInfo(2103, "all PackageInfo is invalid ,such as:" + packageInfo), channel);
        }
    }

    public static void dispatchFetchError(ErrorInfo errorInfo, List<RequestParams.Channel> list) {
        if (list != null && errorInfo != null) {
            StringBuilder sb = new StringBuilder();
            for (RequestParams.Channel channel : list) {
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

    private void dispatchFetchResult(List<PackageInfo> list) {
        if (this.mChannelList == null) {
            return;
        }
        Map<String, List<PackageInfo>> convertMap = convertMap(list);
        this.mLocalMap = new HashMap();
        for (RequestParams.Channel channel : this.mChannelList) {
            if (channel != null) {
                String channelId = channel.getChannelId();
                PackageCallback callback = channel.getCallback();
                if (!TextUtils.isEmpty(channelId) && callback != null) {
                    Map<String, PackageInfo> map = null;
                    if (channel.isUsePmsVersionData()) {
                        map = PackageManager.getFinishedPackageInfo(channelId, null);
                    }
                    if (!CommonUtils.isEmpty(map)) {
                        this.mLocalMap.putAll(map);
                    }
                    if (map == null) {
                        map = new HashMap<>();
                    }
                    List<PackageInfo> list2 = convertMap.get(channelId);
                    if (list2 == null) {
                        list2 = new ArrayList<>(0);
                    }
                    dispatchChannelCallbacks(channel, list2, map);
                } else {
                    return;
                }
            }
        }
    }

    public void process(String str) {
        if (this.mResponseInfo != null && !CommonUtils.isEmpty(this.mChannelList)) {
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
                List<PackageInfo> parseItems = ParseUtils.parseItems(str, serviceData);
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

    private void dispatchInterceptorAndRemove(List<RequestParams.Channel> list, JSONObject jSONObject, CloudControlErrorBean cloudControlErrorBean) {
        JSONObject jSONObject2;
        int i;
        Iterator<RequestParams.Channel> it = list.iterator();
        while (it.hasNext()) {
            RequestParams.Channel next = it.next();
            if (next == null) {
                it.remove();
            } else {
                IDataInterceptor dataInterceptor = next.getDataInterceptor();
                if (dataInterceptor != null) {
                    if (jSONObject != null) {
                        jSONObject2 = jSONObject.optJSONObject(next.getChannelId());
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

    private List<PackageInfo> getFilteredAndRemove(RequestParams.Channel channel, List<PackageInfo> list, Map<String, PackageInfo> map) {
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
                    PackageInfo packageInfo = map.get(str);
                    if (packageInfo == null) {
                        packageInfo = RequestDataUtils.createPackageFile(str);
                    }
                    arrayList.add(packageInfo);
                }
            }
        }
        return arrayList;
    }

    public static void sendCloudControlUBCData(ICloudControlUBCCallBack iCloudControlUBCCallBack, ResponseDataProcess responseDataProcess) {
        Map<String, PackageInfo> map;
        int i;
        int i2;
        String str;
        PackageInfo packageInfo;
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
                        if (!CommonUtils.isEmpty(map) && (packageInfo = map.get(packageInfo2.packageName)) != null) {
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
