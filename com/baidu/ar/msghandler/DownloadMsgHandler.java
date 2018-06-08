package com.baidu.ar.msghandler;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.ar.base.MsgField;
import com.baidu.ar.bean.c;
import com.baidu.ar.load.DownloadTask;
import com.baidu.ar.load.FileManageTask;
import com.baidu.ar.load.downloader.DownloadManager;
import com.baidu.ar.load.downloader.IDownloadParamsParser;
import com.baidu.ar.load.util.DownloadConstants;
import com.baidu.ar.parser.ARResourceKey;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.task.ActionResponseListener;
import com.baidu.ar.util.ARFileUtils;
import com.baidu.ar.util.ARLog;
import com.baidu.ar.util.NetworkUtil;
import com.baidu.ar.util.UrlUtils;
import com.baidu.baiduarsdk.ArBridge;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DownloadMsgHandler {
    public static final int LOAD_STATUS_DOWNLOAD_ANSWER = 3021;
    public static final int LOAD_STATUS_DOWNLOAD_RETRY_SHOWDIALOG = 3010;
    public static final String SDK_TO_LUA_DOWNLOAD_FAILED_RETRY_IF_DOWNLOAD = "if_download";
    public static final String SDK_TO_LUA_DOWNLOAD_FAILED_RETRY_RES_PATH = "download_batchid";
    String a;
    com.baidu.ar.bean.c b;
    private Context c;
    private String d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements ActionResponseListener<String> {
        String a;
        boolean b;
        int c;
        int d = -1;

        a(String str, boolean z, String str2) {
            this.c = 70;
            this.a = str;
            this.b = z;
            if (str2.equalsIgnoreCase("gzip")) {
                this.c = 70;
            } else {
                this.c = 90;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.ar.task.HttpResponseListener
        /* renamed from: a */
        public void onResponse(String str) {
            try {
                if (new JSONObject(str).getInt("id") != 0) {
                    DownloadMsgHandler.responseEngineDownload(this.a, -1);
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
                DownloadMsgHandler.responseEngineDownload(this.a, -1);
            } catch (JSONException e2) {
                e2.printStackTrace();
                DownloadMsgHandler.responseEngineDownload(this.a, -1);
            }
        }

        @Override // com.baidu.ar.task.HttpResponseListener
        public void onErrorResponse(String str) {
        }

        @Override // com.baidu.ar.task.ActionResponseListener
        public void onProgress(int i) {
            if (this.b) {
                int i2 = (int) (((this.c * i) * 1.0f) / 100.0f);
                if (i2 > this.d) {
                    DownloadMsgHandler.responseEngineDownloadProgress(this.a, i2);
                }
                this.d = i2;
            }
        }

        @Override // com.baidu.ar.task.ActionResponseListener
        public void onUpdate(boolean z, float f) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b implements IDownloadParamsParser {
        String a;

        public b(String str) {
            this.a = str;
        }

        @Override // com.baidu.ar.load.downloader.IDownloadParamsParser
        public IDownloadParamsParser.DownloadParam parser(String str) {
            IDownloadParamsParser.DownloadParam downloadParam = new IDownloadParamsParser.DownloadParam();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("errorNum", -1) == 0) {
                    String optString = jSONObject.optString("data");
                    if (TextUtils.isEmpty(optString)) {
                        downloadParam.mErrorCode = 100;
                    } else {
                        downloadParam.mErrorCode = 0;
                        downloadParam.mDownloadUrl = optString;
                    }
                } else {
                    downloadParam.mErrorCode = 100;
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
                downloadParam.mErrorCode = 100;
            } catch (JSONException e2) {
                e2.printStackTrace();
                downloadParam.mErrorCode = 100;
            }
            return downloadParam;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c implements ActionResponseListener<String> {
        String a;
        boolean b;
        int c;
        int d = -1;

        c(String str, boolean z, String str2) {
            this.c = 30;
            this.a = str;
            this.b = z;
            if (str2.equalsIgnoreCase("gzip")) {
                this.c = 30;
            } else {
                this.c = 10;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.ar.task.HttpResponseListener
        /* renamed from: a */
        public void onResponse(String str) {
            try {
                if (new JSONObject(str).getInt("id") == 0) {
                    DownloadMsgHandler.responseEngineDownload(this.a, 0);
                } else {
                    DownloadMsgHandler.responseEngineDownload(this.a, -1);
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
                DownloadMsgHandler.responseEngineDownload(this.a, -1);
            } catch (JSONException e2) {
                e2.printStackTrace();
                DownloadMsgHandler.responseEngineDownload(this.a, -1);
            }
        }

        @Override // com.baidu.ar.task.HttpResponseListener
        public void onErrorResponse(String str) {
        }

        @Override // com.baidu.ar.task.ActionResponseListener
        public void onProgress(int i) {
            if (this.b) {
                int i2 = (100 - this.c) + ((int) (((this.c * i) * 1.0f) / 100.0f));
                if (i2 > this.d) {
                    DownloadMsgHandler.responseEngineDownloadProgress(this.a, i2);
                }
                this.d = i2;
            }
        }

        @Override // com.baidu.ar.task.ActionResponseListener
        public void onUpdate(boolean z, float f) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class d implements ActionResponseListener<String> {
        String a;
        IDownloadParamsParser b;

        d(String str, IDownloadParamsParser iDownloadParamsParser) {
            this.a = str;
            this.b = iDownloadParamsParser;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.ar.task.HttpResponseListener
        /* renamed from: a */
        public void onResponse(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getInt("id") == 0) {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.getString("httpResult"));
                    if (jSONObject2 == null || jSONObject2.optInt("errorNum", -1) != 0) {
                        DownloadMsgHandler.responseEngineDownload(this.a, -1);
                    } else if (this.b.parser(jSONObject2.toString()).mErrorCode != 0) {
                        DownloadMsgHandler.responseEngineDownload(this.a, -1);
                    }
                } else {
                    DownloadMsgHandler.responseEngineDownload(this.a, -1);
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
                DownloadMsgHandler.responseEngineDownload(this.a, -1);
            } catch (JSONException e2) {
                e2.printStackTrace();
                DownloadMsgHandler.responseEngineDownload(this.a, -1);
            }
        }

        @Override // com.baidu.ar.task.HttpResponseListener
        public void onErrorResponse(String str) {
        }

        @Override // com.baidu.ar.task.ActionResponseListener
        public void onProgress(int i) {
        }

        @Override // com.baidu.ar.task.ActionResponseListener
        public void onUpdate(boolean z, float f) {
        }
    }

    public DownloadMsgHandler(String str, Context context) {
        this.a = str;
        this.c = (Context) new WeakReference(context).get();
    }

    public static void responseEngineDownload(String str, int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(StatisticConstants.REQUEST_ID, str);
        hashMap.put(ARResourceKey.HTTP_RET, Integer.valueOf(i));
        ARLog.e("bdar:responseEngineDownload requestId:" + str + " result:" + i);
        ArBridge.getInstance().sendMessage(5003, hashMap);
    }

    public static void responseEngineDownloadProgress(String str, int i) {
        ARLog.e("bdar:DownloadMsgHandler:responseEngineDownloadProgress progress = " + i);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(StatisticConstants.REQUEST_ID, str);
        hashMap.put(NotificationCompat.CATEGORY_PROGRESS, Integer.valueOf(i));
        ArBridge.getInstance().sendMessage(5002, hashMap);
    }

    public void cancelDownloadBatch() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", Integer.valueOf((int) LOAD_STATUS_DOWNLOAD_ANSWER));
        hashMap.put(SDK_TO_LUA_DOWNLOAD_FAILED_RETRY_IF_DOWNLOAD, 0);
        hashMap.put(SDK_TO_LUA_DOWNLOAD_FAILED_RETRY_RES_PATH, getResPath());
        ArBridge.getInstance().sendMessage(ArBridge.MessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    public String getResPath() {
        return this.d;
    }

    public void handleDownloadMsg(HashMap<String, Object> hashMap) {
        String str;
        String str2 = (String) hashMap.get("res_path");
        String str3 = (String) hashMap.get(StatisticConstants.REQUEST_ID);
        boolean z = ((Integer) hashMap.get("need_progress")).intValue() != 0;
        if (this.b == null) {
            responseEngineDownload(str3, -1);
            return;
        }
        c.a a2 = this.b.a(str2.toLowerCase());
        if (a2 == null) {
            responseEngineDownload(str3, -1);
            return;
        }
        String b2 = a2.b();
        if (TextUtils.isEmpty(b2)) {
            responseEngineDownload(str3, -1);
        } else if (b2.equals(RecentlyVisitedForumModel.LOCAL_ACCOUNT)) {
            responseEngineDownload(str3, 0);
        } else {
            String c2 = a2.c();
            if (TextUtils.isEmpty(c2)) {
                responseEngineDownload(str3, -1);
                return;
            }
            String str4 = null;
            if (c2.equalsIgnoreCase("gzip")) {
                str = ".zip";
                str4 = ARFileUtils.getARCaseDirPath(this.a);
            } else if (c2.equalsIgnoreCase(HTTP.IDENTITY_CODING)) {
                str4 = ARFileUtils.getARCaseFullPath(this.a) + str2;
                str = str2.substring(str2.lastIndexOf("."));
            } else {
                str = "";
            }
            String str5 = ARFileUtils.getARCaseTempDir(this.a) + File.separator + a2.b() + str;
            b bVar = new b(b2);
            d dVar = new d(str3, bVar);
            a aVar = new a(str3, z, c2);
            c cVar = new c(str3, z, c2);
            Bundle bundle = new Bundle();
            bundle.putString(DownloadConstants.QUERY_URL, UrlUtils.getStepLoadingBatchUrl().concat("?id=").concat(a2.b()));
            bundle.putString(DownloadConstants.QUERY_PARAMS, "");
            bundle.putInt(DownloadConstants.QUERY_REQUEST_MODE, 0);
            this.d = a2.a();
            if (isNetworkConnect()) {
                DownloadManager.getInstance().downloadRes(this.a, b2, bundle, null, bVar, str5, DownloadTask.FileStoreStrategy.SKIP, str4, false, FileManageTask.FileMergeStrategy.SKIP, null, dVar, aVar, cVar);
            } else {
                responseEngineDownload(str3, -1);
            }
        }
    }

    public boolean isNetworkConnect() {
        if (this.c != null) {
            return NetworkUtil.isNetworkConnected(this.c);
        }
        return false;
    }

    public void onDownloadError() {
        com.baidu.ar.base.d.a((int) MsgField.MSG_ON_LOAD_BATCH_RETRY, this);
    }

    public void parseAndExcuteDownloadMsg(HashMap<String, Object> hashMap) {
        handleDownloadMsg(hashMap);
    }

    public void release() {
        this.c = null;
    }

    public void retryDownloadBatch() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", Integer.valueOf((int) LOAD_STATUS_DOWNLOAD_ANSWER));
        hashMap.put(SDK_TO_LUA_DOWNLOAD_FAILED_RETRY_IF_DOWNLOAD, 1);
        hashMap.put(SDK_TO_LUA_DOWNLOAD_FAILED_RETRY_RES_PATH, getResPath());
        ArBridge.getInstance().sendMessage(ArBridge.MessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    public void setResConfigs(com.baidu.ar.bean.c cVar) {
        this.b = cVar;
    }
}
