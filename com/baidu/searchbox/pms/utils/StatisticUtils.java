package com.baidu.searchbox.pms.utils;

import com.baidu.searchbox.pms.bean.DegradeData;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.searchbox.pms.statistic.PackageFileStatisticManager;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class StatisticUtils {
    public static void sendBulkDownload(List<PackageInfo> list, List<PackageInfo> list2, List<PackageInfo> list3, int i2) {
        String str;
        String format = String.format(ErrorConstant.ErrorMsg.DOWNLOAD_BULK_DOWNLOADED, Integer.valueOf(list.size()), Integer.valueOf(list2.size()), Integer.valueOf(list3.size()));
        if (list.size() > 0) {
            str = list.get(0).channelId;
        } else if (list2.size() > 0) {
            str = list2.get(0).channelId;
        } else {
            str = list3.size() > 0 ? list3.get(0).channelId : "";
        }
        PackageFileStatisticManager.getInstance().addDownloadStatistic2(ErrorConstant.Code.DOWNLOAD_BULK_DOWNLOADED, format, str, null, 0L, "", "", 0, i2);
    }

    public static void sendCloudCtrl(String str, List<RequestParams.Channel> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            for (RequestParams.Channel channel : list) {
                sb.append(channel);
                sb.append(",");
            }
        }
        PackageFileStatisticManager.getInstance().addFetchStatistic2(2108, str, sb.toString(), null);
    }

    public static void sendDegradeData(List<DegradeData> list) {
        JSONArray jSONArray;
        if (list == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (DegradeData degradeData : list) {
                if (degradeData != null) {
                    if (degradeData.isAllDegrade) {
                        jSONArray = new JSONArray();
                    } else if (CommonUtils.isEmpty(degradeData.packageNames)) {
                        jSONArray = null;
                    } else {
                        jSONArray = new JSONArray();
                        for (String str : degradeData.packageNames) {
                            jSONArray.put(str);
                        }
                    }
                    if (jSONArray != null) {
                        jSONObject.put(degradeData.channelId, jSONArray);
                    }
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (jSONObject.length() > 0) {
            PackageFileStatisticManager.getInstance().addFetchStatistic2(-1, null, null, jSONObject);
        }
    }

    public static void sendDownload(PackageInfo packageInfo, int i2) {
        sendDownload(packageInfo, new ErrorInfo(i2));
    }

    public static void sendDownload(PackageInfo packageInfo, ErrorInfo errorInfo) {
        PackageFileStatisticManager.getInstance().addDownloadStatistic2(errorInfo.code, errorInfo.errorMsg, packageInfo.channelId, packageInfo.packageName, packageInfo.version, packageInfo.downloadUrl, "", 0, packageInfo.retryCount);
    }
}
