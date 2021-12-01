package com.baidu.searchbox.pms.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.bean.DegradeData;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.searchbox.pms.statistic.PackageFileStatisticManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class StatisticUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public StatisticUtils() {
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

    public static void sendBulkDownload(List<PackageInfo> list, List<PackageInfo> list2, List<PackageInfo> list3, int i2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65537, null, list, list2, list3, i2) == null) {
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
    }

    public static void sendCloudCtrl(String str, List<RequestParams.Channel> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, list) == null) {
            StringBuilder sb = new StringBuilder();
            if (list != null) {
                for (RequestParams.Channel channel : list) {
                    sb.append(channel);
                    sb.append(",");
                }
            }
            PackageFileStatisticManager.getInstance().addFetchStatistic2(2108, str, sb.toString(), null);
        }
    }

    public static void sendDegradeData(List<DegradeData> list) {
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, list) == null) || list == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, packageInfo, i2) == null) {
            sendDownload(packageInfo, new ErrorInfo(i2));
        }
    }

    public static void sendDownload(PackageInfo packageInfo, ErrorInfo errorInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, packageInfo, errorInfo) == null) {
            PackageFileStatisticManager.getInstance().addDownloadStatistic2(errorInfo.code, errorInfo.errorMsg, packageInfo.channelId, packageInfo.packageName, packageInfo.version, packageInfo.downloadUrl, "", 0, packageInfo.retryCount);
        }
    }
}
