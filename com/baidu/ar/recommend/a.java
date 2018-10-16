package com.baidu.ar.recommend;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.ar.bean.ARResource;
import com.baidu.ar.load.DownloadTask;
import com.baidu.ar.load.FileManageTask;
import com.baidu.ar.load.QueryTask;
import com.baidu.ar.load.downloader.DownloadManager;
import com.baidu.ar.load.downloader.IDownloadParamsParser;
import com.baidu.ar.load.util.DownloadConstants;
import com.baidu.ar.load.util.ResponseUtil;
import com.baidu.ar.parser.ARResourceKey;
import com.baidu.ar.task.ActionResponseListener;
import com.baidu.ar.task.HttpTaskUtility;
import com.baidu.ar.util.ARFileUtils;
import com.baidu.ar.util.ArResourceUtils;
import com.baidu.ar.util.Debug;
import com.baidu.ar.util.UrlUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private InterfaceC0041a a;

    /* renamed from: com.baidu.ar.recommend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0041a {
        void a(String str, int i);

        void a(String str, boolean z, String str2);
    }

    /* loaded from: classes3.dex */
    private static class b implements IDownloadParamsParser {
        private ARResource a;

        public b(ARResource aRResource) {
            this.a = aRResource;
        }

        @Override // com.baidu.ar.load.downloader.IDownloadParamsParser
        public IDownloadParamsParser.DownloadParam parser(String str) {
            JSONObject optJSONObject;
            JSONArray optJSONArray;
            IDownloadParamsParser.DownloadParam downloadParam = new IDownloadParamsParser.DownloadParam();
            downloadParam.mErrorCode = 100;
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt(ARResourceKey.HTTP_ERR_CODE, -1) == 0 && (optJSONArray = (optJSONObject = jSONObject.optJSONObject(ARResourceKey.HTTP_RET)).optJSONArray(ARResourceKey.HTTP_AR_MULTI_RESOURCE)) != null && optJSONArray.length() >= 1) {
                    String optString = optJSONArray.optString(0);
                    if (!TextUtils.isEmpty(optString)) {
                        this.a.setVersionCode(optJSONObject.optString("version_code"));
                        downloadParam.mErrorCode = 0;
                        downloadParam.mDownloadUrl = optString;
                        String aRCaseMainZipFullPath = ARFileUtils.getARCaseMainZipFullPath(this.a.getKey(), this.a.getVersionCode());
                        String aRCaseDirPath = ARFileUtils.getARCaseDirPath(this.a.getKey());
                        downloadParam.mDownloadPath = aRCaseMainZipFullPath;
                        downloadParam.mFileManagePath = aRCaseDirPath;
                        this.a.setZipFilePath(aRCaseMainZipFullPath);
                        this.a.setResFilePath(aRCaseDirPath);
                        this.a.setResourceUrl(optString);
                        this.a.setMultiResourceUrl(new String[]{optString});
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return downloadParam;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str) {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(ARResourceKey.HTTP_ERR_CODE, -1) == 0 && (optJSONArray = jSONObject.optJSONObject(ARResourceKey.HTTP_RET).optJSONArray(ARResourceKey.HTTP_AR_MULTI_RESOURCE)) != null) {
                if (optJSONArray.length() >= 1) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void a(final Context context, final ARResource aRResource) {
        final String key = aRResource.getKey();
        aRResource.setDownloadStatus(0);
        Bundle bundle = new Bundle();
        bundle.putString(DownloadConstants.QUERY_URL, UrlUtils.getQueryResourceUrl());
        bundle.putInt(DownloadConstants.QUERY_REQUEST_MODE, 1);
        QueryTask.ExtraOperateListener extraOperateListener = new QueryTask.ExtraOperateListener() { // from class: com.baidu.ar.recommend.a.1
            @Override // com.baidu.ar.load.QueryTask.ExtraOperateListener
            public String excuteChangeResult(String str) {
                return HttpTaskUtility.getHttpParamsForCaseSwitch(context, key);
            }
        };
        b bVar = new b(aRResource);
        ActionResponseListener<String> actionResponseListener = new ActionResponseListener<String>() { // from class: com.baidu.ar.recommend.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.ar.task.HttpResponseListener
            /* renamed from: a */
            public void onResponse(String str) {
                int idFromResponse = ResponseUtil.getIdFromResponse(str);
                Debug.print("Query:arkey:" + aRResource.getKey() + ", onResponse id:" + idFromResponse);
                if (idFromResponse != 0) {
                    aRResource.setDownloadStatus(-3);
                    if (a.this.a != null) {
                        a.this.a.a(key, false, null);
                    }
                } else if (a.b(ResponseUtil.getHttpResultFromResponse(str))) {
                } else {
                    aRResource.setDownloadStatus(-3);
                    if (a.this.a != null) {
                        a.this.a.a(key, false, null);
                    }
                }
            }

            @Override // com.baidu.ar.task.HttpResponseListener
            public void onErrorResponse(String str) {
            }

            @Override // com.baidu.ar.task.ActionResponseListener
            public void onProgress(int i) {
                Debug.print("Query:arkey:" + aRResource.getKey() + ", progress:" + i);
            }

            @Override // com.baidu.ar.task.ActionResponseListener
            public void onUpdate(boolean z, float f) {
            }
        };
        ActionResponseListener<String> actionResponseListener2 = new ActionResponseListener<String>() { // from class: com.baidu.ar.recommend.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.ar.task.HttpResponseListener
            /* renamed from: a */
            public void onResponse(String str) {
                int idFromResponse = ResponseUtil.getIdFromResponse(str);
                Debug.print("Download:arkey:" + aRResource.getKey() + ", response id:" + idFromResponse);
                if (idFromResponse != 0) {
                    aRResource.setDownloadStatus(-3);
                    if (a.this.a != null) {
                        a.this.a.a(key, false, null);
                    }
                }
            }

            @Override // com.baidu.ar.task.HttpResponseListener
            public void onErrorResponse(String str) {
            }

            @Override // com.baidu.ar.task.ActionResponseListener
            public void onProgress(int i) {
                Debug.print("Download:arkey:" + aRResource.getKey() + ", progress:" + i);
                int i2 = i / 2;
                aRResource.setDownloadStatus(i2);
                if (a.this.a != null) {
                    a.this.a.a(key, i2);
                }
            }

            @Override // com.baidu.ar.task.ActionResponseListener
            public void onUpdate(boolean z, float f) {
            }
        };
        ActionResponseListener<String> actionResponseListener3 = new ActionResponseListener<String>() { // from class: com.baidu.ar.recommend.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.ar.task.HttpResponseListener
            /* renamed from: a */
            public void onResponse(String str) {
                int idFromResponse = ResponseUtil.getIdFromResponse(str);
                Debug.print("Unzip:arkey:" + aRResource.getKey() + ", response id:" + idFromResponse);
                boolean z = idFromResponse == 0;
                aRResource.setDownloadStatus(z ? -2 : -3);
                if (a.this.a != null) {
                    a.this.a.a(key, z, ResponseUtil.getMsgFromResponse(str));
                }
            }

            @Override // com.baidu.ar.task.HttpResponseListener
            public void onErrorResponse(String str) {
            }

            @Override // com.baidu.ar.task.ActionResponseListener
            public void onProgress(int i) {
                Debug.print("Unzip:arkey:" + aRResource.getKey() + ", progress:" + i);
                int i2 = (i / 2) + 50;
                aRResource.setDownloadStatus(i2);
                if (a.this.a != null) {
                    a.this.a.a(key, i2);
                }
            }

            @Override // com.baidu.ar.task.ActionResponseListener
            public void onUpdate(boolean z, float f) {
            }
        };
        DownloadManager.getInstance().downloadRes(key, null, bundle, extraOperateListener, bVar, null, DownloadTask.FileStoreStrategy.SKIP, null, true, FileManageTask.FileMergeStrategy.SKIP, new FileManageTask.ExtraOperateListener() { // from class: com.baidu.ar.recommend.a.5
            @Override // com.baidu.ar.load.FileManageTask.ExtraOperateListener
            public String excuteChangeResult(String str) {
                return ArResourceUtils.generateResult(str);
            }
        }, actionResponseListener, actionResponseListener2, actionResponseListener3);
    }

    public void a(InterfaceC0041a interfaceC0041a) {
        this.a = interfaceC0041a;
    }
}
