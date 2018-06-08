package com.baidu.ar.msghandler;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.ar.base.MsgField;
import com.baidu.ar.load.downloader.DownloadManager;
import com.baidu.ar.load.util.DownloadConstants;
import com.baidu.ar.load.util.ResponseUtil;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.task.ActionResponseListener;
import com.baidu.ar.util.ARLog;
import com.baidu.ar.util.NetworkUtil;
import com.baidu.baiduarsdk.ArBridge;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class f {
    private String a;
    private Context b;

    /* loaded from: classes3.dex */
    private static class a implements ActionResponseListener<String> {
        String a;

        a(String str) {
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.ar.task.HttpResponseListener
        /* renamed from: a */
        public void onResponse(String str) {
            if (TextUtils.isEmpty(str)) {
                f.a(this.a, "{}");
            } else if (ResponseUtil.getIdFromResponse(str) != 0) {
                f.a(this.a, "{}");
            } else {
                String httpResultFromResponse = ResponseUtil.getHttpResultFromResponse(str);
                if (TextUtils.isEmpty(httpResultFromResponse)) {
                    f.a(this.a, "{}");
                } else {
                    f.a(this.a, httpResultFromResponse);
                }
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

    public f(String str, Context context) {
        this.a = str;
        this.b = (Context) new WeakReference(context).get();
    }

    public static void a(String str, int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", Integer.valueOf((int) MsgField.MSG_STAT_FIRST_LOAD_FILE_MANAGE_FAILURE));
        hashMap.put(StatisticConstants.REQUEST_ID, str);
        hashMap.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(i));
        ArBridge.getInstance().sendMessage(ArBridge.MessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    public static void a(String str, String str2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", Integer.valueOf((int) MsgField.MSG_STAT_START_DOWNLOAD_3D_RES));
        hashMap.put(StatisticConstants.REQUEST_ID, str);
        hashMap.put("data", str2);
        ArBridge.getInstance().sendMessage(ArBridge.MessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    public void a() {
        this.b = null;
    }

    public void a(HashMap<String, Object> hashMap) {
        int i;
        String str = (String) hashMap.get(StatisticConstants.REQUEST_ID);
        if (TextUtils.isEmpty(str)) {
            ARLog.e("requestId can not be null!");
            return;
        }
        String str2 = (String) hashMap.get("request_method");
        String str3 = (String) hashMap.get("url");
        String str4 = (String) hashMap.get("content");
        if (!b()) {
            a(str, 1);
        } else if (str3 == null || !str3.contains("https://")) {
            a(str, 2);
        } else if (str2 == null) {
            a(str, 2);
        } else {
            if (str2.equals("get") || str2.equals("GET")) {
                i = 0;
            } else if (!str2.equals("post") && !str2.equals("POST")) {
                a(str, 2);
                return;
            } else {
                i = 1;
            }
            a aVar = new a(str);
            Bundle bundle = new Bundle();
            bundle.putString(DownloadConstants.QUERY_URL, str3);
            bundle.putString(DownloadConstants.QUERY_PARAMS, str4);
            bundle.putInt(DownloadConstants.QUERY_REQUEST_MODE, i);
            DownloadManager.getInstance().doQuery(this.a, str, bundle, null, aVar);
        }
    }

    public boolean b() {
        if (this.b != null) {
            return NetworkUtil.isNetworkConnected(this.b);
        }
        return false;
    }
}
