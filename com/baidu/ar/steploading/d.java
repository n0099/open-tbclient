package com.baidu.ar.steploading;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.arplay.core.message.ARPMessage;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.bean.ARCaseBundleInfo;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.callback.ICallback;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.ICancellable;
import com.baidu.ar.callback.IError;
import com.baidu.ar.ihttp.IProgressCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class d implements com.baidu.ar.lua.c, IStepLoading {
    private Context mContext;
    private ARCaseBundleInfo vJ;
    private a vK;
    private ICallbackWith<IStepLoading> vL;
    private String vM;
    private boolean vN;

    public d(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private ICancellable a(String str, ICallback iCallback, IError iError, IProgressCallback iProgressCallback) {
        return com.baidu.ar.d.d.b(new e(this.mContext, this.vJ, this.vK), str).d(new c(this.vJ, str, this.vK, iProgressCallback)).d(new b(iCallback, iError));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str, int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("request_id", str);
        hashMap.put("ret", Integer.valueOf(i));
        ARPMessage.getInstance().sendMessage(5003, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str, int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("request_id", str);
        hashMap.put("progress", Integer.valueOf(i));
        ARPMessage.getInstance().sendMessage(5002, hashMap);
    }

    private void t(HashMap<String, Object> hashMap) {
        String str = (String) hashMap.get("res_path");
        final String str2 = (String) hashMap.get("request_id");
        final boolean z = ((Integer) hashMap.get("need_progress")).intValue() != 0;
        this.vM = str;
        a(str, new ICallback() { // from class: com.baidu.ar.steploading.d.1
            @Override // com.baidu.ar.callback.ICallback
            public void run() {
                if (z) {
                    d.d(str2, 100);
                }
                d.c(str2, 0);
            }
        }, new IError() { // from class: com.baidu.ar.steploading.d.2
            @Override // com.baidu.ar.callback.IError
            public void onError(int i, String str3, Exception exc) {
                d.c(str2, -1);
            }
        }, new IProgressCallback() { // from class: com.baidu.ar.steploading.d.3
            @Override // com.baidu.ar.ihttp.IProgressCallback
            public void onProgress(int i, int i2) {
                if (!z || i2 <= 0) {
                    return;
                }
                d.d(str2, (int) (((i * 90) * 1.0f) / i2));
            }
        });
    }

    @Override // com.baidu.ar.lua.c
    public void a(int i, int i2, HashMap<String, Object> hashMap) {
        if (i == 5001) {
            if (hashMap != null) {
                this.vN = false;
                t(hashMap);
            }
        } else if (i == 1901 && com.baidu.ar.arplay.c.c.a(hashMap.get("id"), -1) == 3010) {
            this.vN = true;
            if (this.vL != null) {
                this.vL.run(this);
            } else {
                cancel();
            }
        }
    }

    public void b(com.baidu.ar.lua.b bVar) {
        bVar.c(this);
    }

    @Override // com.baidu.ar.steploading.IStepLoading
    public void cancel() {
        if (!this.vN || TextUtils.isEmpty(this.vM)) {
            return;
        }
        this.vN = false;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", 3021);
        hashMap.put("if_download", 0);
        hashMap.put("download_batchid", this.vM);
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    @Override // com.baidu.ar.lua.c
    public List<Integer> n() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf((int) ARPMessageType.MSG_TYPE_RES_REQUEST));
        arrayList.add(Integer.valueOf((int) ARPMessageType.MSG_TYPE_LUA_SDK_BRIDGE));
        return arrayList;
    }

    public void release() {
        this.vN = false;
        this.vM = null;
        this.vL = null;
        this.mContext = null;
        this.vJ = null;
        this.vK = null;
    }

    @Override // com.baidu.ar.steploading.IStepLoading
    public void retry() {
        if (!this.vN || TextUtils.isEmpty(this.vM)) {
            return;
        }
        this.vN = false;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", 3021);
        hashMap.put("if_download", 1);
        hashMap.put("download_batchid", this.vM);
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    @Override // com.baidu.ar.steploading.IStepLoading
    public void setLoadErrorListener(ICallbackWith<IStepLoading> iCallbackWith) {
        this.vL = iCallbackWith;
    }

    public void switchCase(String str) {
        this.vJ = new ARCaseBundleInfo();
        this.vJ.caseDir = str;
        this.vJ.arKey = ARConfig.getARKey();
        this.vK = new a(this.vJ.caseDir);
    }
}
