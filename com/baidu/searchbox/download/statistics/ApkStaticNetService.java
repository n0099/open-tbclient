package com.baidu.searchbox.download.statistics;

import android.content.Context;
import android.util.Log;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.PostFormRequest;
import java.util.HashMap;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class ApkStaticNetService {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final int DELAY_MILLISECONDS = 3000;
    public static final String DOWNFAIL_STATISTIC_URL = "https://appc.baidu.com/appsrv?action=statistic&pu=osname@baiduappsearch&item=downfail&status=";
    public static final String DOWNFINISH_STATISTIC_URL = "https://appc.baidu.com/appsrv?action=statistic&pu=osname@baiduappsearch&item=downfinish";
    public static final String DOWNHIJACK_STATISTIC_URL = "https://appc.baidu.com/appsrv?action=statistic&pu=osname@baiduappsearch&item=downhijack";
    public static final String DOWNINSTALLED_STATISTIC_URL = "https://appc.baidu.com/appsrv?action=statistic&pu=osname@baiduappsearch&item=downinstalled";
    public static final String DOWNPAUSED_STATISTIC_URL = "https://appc.baidu.com/appsrv?action=statistic&pu=osname@baiduappsearch&item=downpaused";
    public static final String DOWNRESUME_STATISTIC_URL = "https://appc.baidu.com/appsrv?action=statistic&pu=osname@baiduappsearch&item=downresume";
    public static final String DOWNSTARTINSTALL_STATISTIC_URL = "https://appc.baidu.com/appsrv?action=statistic&pu=osname@baiduappsearch&item=downstartinstall";
    public static final String FILE_OPEN_STATISTIC_URL = "https://appc.baidu.com/appsrv?action=statistic&pu=osname@baiduappsearch&item=fileclick";
    public static final String INSTALLHIJACK_STATISTIC_URL = "https://appc.baidu.com/appsrv?action=statistic&pu=osname@baiduappsearch&item=installhijack";
    public static final String KEY_CUID = "cuid";
    public static final String KEY_STATIC_TYPE = "static_type";
    public static final String PLUGIN_OPEN_STATISTIC_URL = "https://appc.baidu.com/appsrv?action=statistic&pu=osname@baiduappsearch&item=pluginopen";
    public static final String STATIC_DOWNLOAD_CATEGORY = "category";
    public static final String STATIC_DOWNLOAD_CHANNEL = "channel";
    public static final int STATIC_DOWNLOAD_EXTRAINFO_KEY = 5;
    public static final String STATIC_DOWNLOAD_FILETYPE = "fileType";
    public static final int STATIC_DOWNLOAD_FILETYPE_KEY = 4;
    public static final String STATIC_DOWNLOAD_FROM = "f";
    public static final int STATIC_DOWNLOAD_NAME_KEY = 3;
    public static final String STATIC_DOWNLOAD_NET = "operatorwifi";
    public static final String STATIC_DOWNLOAD_PKG = "pkg";
    public static final String STATIC_DOWNLOAD_REDIRECT_URL = "redirect_uris";
    public static final String STATIC_DOWNLOAD_REFER = "from_refer";
    public static final int STATIC_DOWNLOAD_REFER_KEY = 2;
    public static final String STATIC_DOWNLOAD_SID = "sid";
    public static final String STATIC_DOWNLOAD_SIZE = "totalsize";
    public static final int STATIC_DOWNLOAD_SIZE_KEY = 1;
    public static final String STATIC_DOWNLOAD_SOURCE = "source";
    public static final String STATIC_DOWNLOAD_URL = "downurl";
    public static final int STATIC_DOWNLOAD_URL_KEY = 0;
    public static final String STATIC_DOWNLOAD_VER = "download_Version";
    public static final String STATIC_HOST_DOWNLOAD_VERSION_NAME = "host_version_name";
    public static final String STATIC_HOST_URL = "https://appc.baidu.com";
    public static final String SYSAPP_OPEN_STATISTIC_URL = "https://appc.baidu.com/appsrv?action=statistic&pu=osname@baiduappsearch&item=sysappopen";
    public static final String WEBDOWNLOAD_URL = "https://appc.baidu.com/app?action=download&pu=osname@baiduappsearch";

    public static void requestApkAnalysisService(Context context, String str) {
        if (context != null && NetWorkUtils.isNetworkConnected()) {
            try {
                String buildApkAnalysisParamsUrl = ApkCloudStatisticsUtils.buildApkAnalysisParamsUrl();
                CookieManager cookieManager = HttpManager.getDefault(context).getCookieManager(false, false);
                HashMap hashMap = new HashMap();
                hashMap.put("data", str);
                PostFormRequest build = ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(context).postFormRequest().url(buildApkAnalysisParamsUrl)).cookieManager(cookieManager)).params(hashMap).autoRetry(false)).readTimeout(3000)).connectionTimeout(3000)).writeTimeout(3000)).enableStat(true)).requestFrom(10)).requestSubFrom(1022)).build();
                if (build.makeRequestCall() == null) {
                    return;
                }
                build.executeAsync(new ResponseCallback<String>() { // from class: com.baidu.searchbox.download.statistics.ApkStaticNetService.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    public void onSuccess(String str2, int i) {
                    }

                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    public void onFail(Exception exc) {
                        if (ApkStaticNetService.DEBUG) {
                            Log.e("appsearch", "应用信息提报接口onFail返回");
                        }
                    }

                    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, IF, INVOKE, INVOKE, IF, INVOKE, MOVE_EXCEPTION] complete} */
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    public String parseResponse(Response response, int i) throws Exception {
                        if (response != null) {
                            try {
                                if (response.isSuccessful() && response.body() != null) {
                                    return response.body().string();
                                }
                            } finally {
                                if (response != null) {
                                    try {
                                        if (response.body() != null) {
                                            response.body().close();
                                        }
                                    } catch (Exception e) {
                                        if (ApkStaticNetService.DEBUG) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                        if (response != null) {
                            try {
                                if (response.body() != null) {
                                    response.body().close();
                                }
                            } catch (Exception e2) {
                                if (ApkStaticNetService.DEBUG) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                        return null;
                    }
                });
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }
}
