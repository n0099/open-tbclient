package com.baidu.ar.base;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.ARResource;
import com.baidu.ar.parser.ParserJson;
import com.baidu.ar.resloader.d;
import com.baidu.ar.task.ActionResponseListener;
import com.baidu.ar.task.DownLoaderTask;
import com.baidu.ar.task.HttpHandle;
import com.baidu.ar.task.HttpResponseListener;
import com.baidu.ar.task.HttpTaskUtility;
import com.baidu.ar.util.ARFileUtils;
import com.baidu.ar.util.ARLog;
import com.baidu.ar.util.ArResourceUtils;
import com.baidu.ar.util.Constants;
import com.baidu.ar.util.NetworkUtil;
import com.baidu.ar.util.UiThreadUtil;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class RequestController {
    private static boolean a = false;
    private DownLoaderTask b;
    private c d;
    private a e;
    private Context f;
    private ARResource h;
    private com.baidu.ar.resloader.d i;
    private d.a j;
    private b k;
    private long m;
    private HttpHandle c = null;
    private boolean g = false;
    private boolean l = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements ActionResponseListener<String> {
        private WeakReference<RequestController> a;

        public a(RequestController requestController) {
            this.a = new WeakReference<>(requestController);
        }

        public void a() {
            this.a.clear();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.ar.task.HttpResponseListener
        /* renamed from: a */
        public void onResponse(String str) {
            if (this.a == null || this.a.get() == null) {
                return;
            }
            this.a.get().b(str);
        }

        @Override // com.baidu.ar.task.HttpResponseListener
        public void onErrorResponse(String str) {
            if (this.a == null || this.a.get() == null) {
                return;
            }
            this.a.get().c(str);
        }

        @Override // com.baidu.ar.task.ActionResponseListener
        public void onProgress(int i) {
            ARLog.d("onProgress: " + i);
        }

        @Override // com.baidu.ar.task.ActionResponseListener
        public void onUpdate(boolean z, float f) {
            ARLog.d("onUpdate: isUpdate=" + z + ", size=" + f);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(ARResource aRResource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c implements HttpResponseListener<JSONObject> {
        private WeakReference<RequestController> a;

        public c(RequestController requestController) {
            this.a = new WeakReference<>(requestController);
        }

        public void a() {
            this.a.clear();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.ar.task.HttpResponseListener
        /* renamed from: a */
        public void onResponse(JSONObject jSONObject) {
            if (this.a == null || this.a.get() == null) {
                return;
            }
            this.a.get().a(jSONObject);
        }

        @Override // com.baidu.ar.task.HttpResponseListener
        public void onErrorResponse(String str) {
            if (this.a == null || this.a.get() == null) {
                return;
            }
            this.a.get().a(str);
        }
    }

    public RequestController(Context context) {
        if (context != null) {
            this.f = context.getApplicationContext();
            this.i = new com.baidu.ar.resloader.d(this.f);
        }
    }

    private void a() {
        if (a) {
            b();
            return;
        }
        ARLog.d("queryArType");
        d.a(2300);
        this.d = new c(this);
        this.c = HttpTaskUtility.doQueryArResource(this.f, this.d);
        if (this.c == null) {
            ARLog.e("Http Request Occur Error! Please Check");
        }
    }

    private void a(ARResource aRResource) {
        switch (aRResource.getErrCode()) {
            case Constants.HTTP_ERRCODE_VERSION_LOW /* 1044 */:
                d.a(1801, aRResource.getErrMsg());
                return;
            default:
                Log.e("bdar", "error code = " + aRResource.getErrCode() + ", error msg = " + aRResource.getErrMsg());
                d.a((int) MsgField.MSG_ON_QUERY_RESOURCE_ERROR_SERVER, aRResource.getErrMsg());
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.l) {
            return;
        }
        d.a((int) MsgField.MSG_STAT_FIRST_LOAD_QUERY_FAILURE);
        if (this.g) {
            return;
        }
        ARLog.e("http error msg = " + str);
        d.a(2301, this);
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        if (this.l || this.g) {
            return;
        }
        ARResource parseARResource = ParserJson.parseARResource(jSONObject);
        if (parseARResource == null) {
            ARLog.e("ARResource parse error!");
            d.a((int) MsgField.MSG_STAT_FIRST_LOAD_QUERY_FAILURE);
        } else if (parseARResource.getErrCode() != 0) {
            a(parseARResource);
            d.a((int) MsgField.MSG_STAT_FIRST_LOAD_QUERY_FAILURE);
        } else if (parseARResource.isRefused() || !parseARResource.isHardwareSatisfied()) {
            d.a((int) MsgField.IMSG_DEVICE_NOT_SUPPORT, parseARResource);
            d.a((int) MsgField.MSG_STAT_FIRST_LOAD_QUERY_FAILURE);
        } else {
            this.h = parseARResource;
            this.c = null;
            startDownload();
        }
    }

    private void b() {
        this.d = new c(this);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.base.RequestController.1
            @Override // java.lang.Runnable
            public void run() {
                RequestController.this.d.onResponse(com.baidu.ar.test.a.a(ARConfig.getARType()));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (this.l) {
            return;
        }
        this.h.setCaseConfigJsonInfo(str);
        try {
            this.h.setResFilePath((String) new JSONObject(str).opt("unzip_path"));
            this.h.setZipFilePath(ARFileUtils.getARCaseMainZipFullPath(this.h.getKey(), this.h.getVersionCode()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (this.g) {
            return;
        }
        d.a((int) MsgField.MSG_ON_DOWNLOAD_RES_SUCCESS);
        if (this.k != null) {
            this.k.a(this.h);
        }
        Log.e("qatest", "查询下载: " + (System.currentTimeMillis() - this.m) + " ms");
    }

    private void c() {
        this.e = new a(this);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.base.RequestController.3
            @Override // java.lang.Runnable
            public void run() {
                RequestController.this.e.onResponse(ArResourceUtils.generateResult(com.baidu.ar.test.a.a()));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (this.l || this.g) {
            return;
        }
        Log.e("bdar", "download res error: " + str);
        d.a((int) MsgField.MSG_ON_DOWNLOAD_RES_ERROR, this);
    }

    public static void setLoadLocalArRes(boolean z) {
        a = z;
    }

    public void cancelDownloadTask() {
        if (this.b != null) {
            this.b.setPause(false);
            this.b.cancel(true);
            this.b = null;
        }
        if (this.i != null) {
            this.i.a();
        }
    }

    public void cancelQueryRes() {
        if (this.c != null) {
            this.c.finish();
            this.c = null;
        }
        if (this.d != null) {
            this.d.a();
        }
        if (this.e != null) {
            this.e.a();
        }
    }

    public void downloadArResource() {
        if (a) {
            c();
        } else if (this.h == null) {
            ARLog.e("ERROR!! bundle data is null");
        } else {
            String[] multiResourceUrl = this.h.getMultiResourceUrl();
            if (multiResourceUrl == null || multiResourceUrl.length == 0) {
                return;
            }
            String str = multiResourceUrl[0];
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.e = new a(this);
            this.b = DownLoaderTask.doDownLoadWork(this.h.getKey(), ARFileUtils.getARCaseMainZipFullPath(this.h.getKey(), this.h.getVersionCode()), str, Constants.RE_EXTRACT, this.f != null ? this.f.getContentResolver() : null, this.e);
            d.a((int) MsgField.MSG_ON_DOWNLOAD_RES, this);
        }
    }

    public void downloadCodeResource() {
        ARResource aRResource = this.h;
        if (aRResource == null || this.i == null) {
            ARLog.e("ERROR!! bundle data is null");
            return;
        }
        d.a((int) MsgField.MSG_ON_DOWNLOAD_SO);
        String codeDownloadUrl = aRResource.getCodeDownloadUrl();
        this.i.a(new d.a() { // from class: com.baidu.ar.base.RequestController.2
            @Override // com.baidu.ar.resloader.d.a
            public void a(boolean z) {
                if (RequestController.this.j != null) {
                    RequestController.this.j.a(z);
                }
                if (z) {
                    RequestController.this.downloadArResource();
                } else if (RequestController.this.g) {
                } else {
                    d.a((int) MsgField.MSG_ON_DOWNLOAD_SO_ERROR, RequestController.this);
                    ARLog.d(MsgField.SMSG_SO_DOWNLOAD_ERROR);
                }
            }
        });
        this.i.a(codeDownloadUrl);
    }

    public DownLoaderTask getDownloadTask() {
        return this.b;
    }

    public void onPause() {
        this.g = true;
        if (this.b != null) {
            this.b.cancel(true);
        }
    }

    public void onResume() {
        this.g = false;
    }

    public void release() {
        onPause();
        cancelQueryRes();
        cancelDownloadTask();
        this.g = false;
        this.l = true;
    }

    public void setARResource(ARResource aRResource) {
        this.h = aRResource;
    }

    public void setOnARResourceRequestListener(b bVar) {
        this.k = bVar;
    }

    public void setOnSoLoadCallback(d.a aVar) {
        this.j = aVar;
    }

    public void start() {
        if (a) {
            startRequest();
        } else if (ARConfig.getARType() == 6 || ARConfig.getARType() == 7) {
            ARResource aRResource = new ARResource();
            aRResource.setType(ARConfig.getARType());
            if (this.k != null) {
                this.k.a(aRResource);
            }
        } else if (!NetworkUtil.isNetworkConnected(this.f)) {
            Log.e("bdar", "No network");
            d.a((int) MsgField.MSG_NO_NETWORK_FOR_START_QUERY_RES, this);
        } else if (NetworkUtil.isWifiNetworkConnected(this.f)) {
            startRequest();
        } else if (NetworkUtil.isMobileNetworkConnected(this.f)) {
            d.a((int) MsgField.MSG_MOBILE_NETWORK_FOR_START_QUERY_RES, this);
        }
    }

    public void startDownload() {
        if (a) {
            downloadCodeResource();
            return;
        }
        d.a((int) MsgField.MSG_STAT_FIRST_LOAD_QUERY_SUCCESS);
        if (NetworkUtil.isNetworkConnected(this.f)) {
            downloadCodeResource();
            return;
        }
        Log.e("bdar", "No network");
        d.a((int) MsgField.MSG_NO_NETWORK_FOR_DOWNLOAD_RES, this);
    }

    public void startRequest() {
        this.m = System.currentTimeMillis();
        if (this.g) {
            return;
        }
        if (this.h == null) {
            a();
        } else if (this.h.getResFilePath() != null) {
            b(this.h.getResFilePath());
        } else {
            startDownload();
        }
    }
}
