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
/* loaded from: classes2.dex */
public class ResponseDataProcess {
    public List<RequestParams.Channel> mChannelList;
    public Map<String, PackageInfo> mLocalMap;
    public List<PackageInfo> mRemoteList;
    public CloudControlResponseInfo mResponseInfo;

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

    private void dispatchChannelCallbacks(@NonNull RequestParams.Channel channel, @NonNull List<PackageInfo> list, @NonNull Map<String, PackageInfo> map) {
        String channelId = channel.getChannelId();
        PackageCallback callback = channel.getCallback();
        if (TextUtils.isEmpty(channelId) || callback == null) {
            return;
        }
        List<PackageInfo> filteredAndRemove = getFilteredAndRemove(channel, list, map);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (PackageInfo packageInfo : list) {
            PackageInfo packageInfo2 = map.get(packageInfo.packageName);
            if (!packageInfo.isValid() || (packageInfo2 != null && packageInfo2.updateVersion > packageInfo.updateVersion)) {
                arrayList.add(packageInfo);
            } else if (packageInfo2 == null) {
                arrayList2.add(packageInfo);
            } else if (packageInfo2.isOlderThan(packageInfo)) {
                arrayList3.add(packageInfo);
            } else {
                try {
                    PackageInfo packageInfo3 = (PackageInfo) packageInfo2.clone();
                    packageInfo.copyTo(packageInfo3);
                    PackageControl.getInstance().addOrUpdate(packageInfo3);
                } catch (CloneNotSupportedException e2) {
                    DebugUtils.printStackTrace(e2);
                }
                arrayList4.add(packageInfo);
            }
        }
        if (AppConfig.isDebug()) {
            Iterator<PackageInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                DebugUtils.logE("【无效资源】channelId:", channelId, it.next());
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
        resultData.filterList = filteredAndRemove;
        resultData.invalidList = arrayList;
        DebugUtils.log("【响应结果】channelId:", channelId, resultData);
        callback.onResultData(resultData);
    }

    public static void dispatchFetchError(ErrorInfo errorInfo, RequestParams.Channel channel) {
        dispatchFetchError(errorInfo, Collections.singletonList(channel));
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
                if (TextUtils.isEmpty(channelId) || callback == null) {
                    return;
                }
                Map<String, PackageInfo> finishedPackageInfo = channel.isUsePmsVersionData() ? PackageManager.getFinishedPackageInfo(channelId, null) : null;
                if (!CommonUtils.isEmpty(finishedPackageInfo)) {
                    this.mLocalMap.putAll(finishedPackageInfo);
                }
                if (finishedPackageInfo == null) {
                    finishedPackageInfo = new HashMap<>();
                }
                List<PackageInfo> list2 = convertMap.get(channelId);
                if (list2 == null) {
                    list2 = new ArrayList<>(0);
                }
                dispatchChannelCallbacks(channel, list2, finishedPackageInfo);
            }
        }
    }

    private void dispatchInterceptorAndRemove(List<RequestParams.Channel> list, JSONObject jSONObject, CloudControlErrorBean cloudControlErrorBean) {
        Iterator<RequestParams.Channel> it = list.iterator();
        while (it.hasNext()) {
            RequestParams.Channel next = it.next();
            if (next == null) {
                it.remove();
            } else {
                IDataInterceptor dataInterceptor = next.getDataInterceptor();
                if (dataInterceptor != null) {
                    dataInterceptor.onReceiveData(jSONObject != null ? jSONObject.optJSONObject(next.getChannelId()) : null, cloudControlErrorBean != null ? cloudControlErrorBean.getErrorCode() : -1, cloudControlErrorBean != null ? cloudControlErrorBean.getSubErrorCode() : -1, null);
                    it.remove();
                }
            }
        }
    }

    private void dispatchInvalidCallback(@NonNull RequestParams.Channel channel, @NonNull List<PackageInfo> list) {
        if (CommonUtils.isEmpty(list)) {
            return;
        }
        PackageInfo packageInfo = list.get(0);
        String packageInfo2 = packageInfo == null ? "" : packageInfo.toString();
        dispatchFetchError(new ErrorInfo(2103, "all PackageInfo is invalid ,such as:" + packageInfo2), channel);
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
        int i2;
        int i3;
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
        if (CommonUtils.isEmpty(list)) {
            i2 = 0;
            i3 = 0;
        } else {
            i2 = 0;
            i3 = 0;
            for (PackageInfo packageInfo2 : list) {
                if (packageInfo2 != null) {
                    try {
                        if (!CommonUtils.isEmpty(map) && (packageInfo = map.get(packageInfo2.packageName)) != null) {
                            if (packageInfo2.updateVersion <= packageInfo.updateVersion) {
                                i2++;
                                str = "2";
                            } else if (packageInfo2.version < packageInfo.version) {
                                i3++;
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
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    str = "1";
                    JSONObject jSONObject2 = new JSONObject();
                }
            }
        }
        int i4 = (size - i2) - i3;
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("count", String.format("%s,%s,%s", Integer.valueOf(size), Integer.valueOf(i4), Integer.valueOf(i2)));
            jSONObject3.put("items", jSONArray);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        DebugUtils.log(jSONObject3);
        if (iCloudControlUBCCallBack != null) {
            iCloudControlUBCCallBack.setServiceInfo(jSONObject3);
        }
    }

    public Map<String, PackageInfo> getLocalMap() {
        return this.mLocalMap;
    }

    public List<PackageInfo> getRemoteList() {
        return this.mRemoteList;
    }

    public void process(String str) {
        if (this.mResponseInfo == null || CommonUtils.isEmpty(this.mChannelList)) {
            return;
        }
        JSONObject serviceData = this.mResponseInfo.getServiceData();
        CloudControlErrorBean cloudControlErrorBean = this.mResponseInfo.getCloudControlErrorBean();
        dispatchInterceptorAndRemove(this.mChannelList, serviceData, cloudControlErrorBean);
        int i2 = 2108;
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
            i2 = 2101;
        } else if (errorCode == 2) {
            i2 = 2105;
        } else if (errorCode == 3) {
            i2 = 2103;
        }
        dispatchFetchError(new ErrorInfo(i2, "server errCode:" + errorCode), this.mChannelList);
    }

    public void setChannelList(List<RequestParams.Channel> list) {
        if (list != null) {
            this.mChannelList = new ArrayList(list);
        }
    }

    public void setResponseInfo(CloudControlResponseInfo cloudControlResponseInfo) {
        this.mResponseInfo = cloudControlResponseInfo;
    }

    public static void dispatchFetchError(ErrorInfo errorInfo, List<RequestParams.Channel> list) {
        if (list == null || errorInfo == null) {
            return;
        }
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
