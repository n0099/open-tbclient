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
import com.qq.e.comm.constants.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class d implements com.baidu.ar.lua.c, IStepLoading {
    private Context mContext;
    private ARCaseBundleInfo xA;
    private a xB;
    private ICallbackWith<IStepLoading> xC;
    private String xD;
    private boolean xE;

    public d(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private ICancellable a(String str, ICallback iCallback, IError iError, IProgressCallback iProgressCallback) {
        return com.baidu.ar.e.d.b(new e(this.mContext, this.xA, this.xB), str).d(new c(this.xA, str, this.xB, iProgressCallback)).d(new b(iCallback, iError));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str, int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("request_id", str);
        hashMap.put(Constants.KEYS.RET, Integer.valueOf(i));
        ARPMessage.getInstance().sendMessage(5003, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(String str, int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("request_id", str);
        hashMap.put("progress", Integer.valueOf(i));
        ARPMessage.getInstance().sendMessage(5002, hashMap);
    }

    private void r(HashMap<String, Object> hashMap) {
        String str = (String) hashMap.get("res_path");
        final String str2 = (String) hashMap.get("request_id");
        final boolean z = ((Integer) hashMap.get("need_progress")).intValue() != 0;
        this.xD = str;
        a(str, new ICallback() { // from class: com.baidu.ar.steploading.d.1
            @Override // com.baidu.ar.callback.ICallback
            public void run() {
                if (z) {
                    d.e(str2, 100);
                }
                d.d(str2, 0);
            }
        }, new IError() { // from class: com.baidu.ar.steploading.d.2
            @Override // com.baidu.ar.callback.IError
            public void onError(int i, String str3, Exception exc) {
                d.d(str2, -1);
            }
        }, new IProgressCallback() { // from class: com.baidu.ar.steploading.d.3
            @Override // com.baidu.ar.ihttp.IProgressCallback
            public void onProgress(int i, int i2) {
                if (!z || i2 <= 0) {
                    return;
                }
                d.e(str2, (int) (((i * 90) * 1.0f) / i2));
            }
        });
    }

    @Override // com.baidu.ar.lua.c
    public void a(int i, int i2, HashMap<String, Object> hashMap) {
        if (i == 5001) {
            if (hashMap != null) {
                this.xE = false;
                r(hashMap);
            }
        } else if (i == 1901 && com.baidu.ar.arplay.c.c.a(hashMap.get("id"), -1) == 3010) {
            this.xE = true;
            if (this.xC != null) {
                this.xC.run(this);
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
        if (!this.xE || TextUtils.isEmpty(this.xD)) {
            return;
        }
        this.xE = false;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", 3021);
        hashMap.put("if_download", 0);
        hashMap.put("download_batchid", this.xD);
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
        this.xE = false;
        this.xD = null;
        this.xC = null;
        this.mContext = null;
        this.xA = null;
        this.xB = null;
    }

    @Override // com.baidu.ar.steploading.IStepLoading
    public void retry() {
        if (!this.xE || TextUtils.isEmpty(this.xD)) {
            return;
        }
        this.xE = false;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", 3021);
        hashMap.put("if_download", 1);
        hashMap.put("download_batchid", this.xD);
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    @Override // com.baidu.ar.steploading.IStepLoading
    public void setLoadErrorListener(ICallbackWith<IStepLoading> iCallbackWith) {
        this.xC = iCallbackWith;
    }

    public void switchCase(String str) {
        this.xA = new ARCaseBundleInfo();
        this.xA.caseDir = str;
        this.xA.arKey = ARConfig.getARKey();
        this.xB = new a(this.xA.caseDir);
    }
}
