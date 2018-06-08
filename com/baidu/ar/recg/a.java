package com.baidu.ar.recg;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.base.MsgField;
import com.baidu.ar.base.b;
import com.baidu.ar.base.d;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.util.NetworkUtil;
/* loaded from: classes3.dex */
public class a extends b {
    private boolean s;
    private boolean t;
    private boolean u;

    public a(Context context) {
        super(context);
        this.s = false;
        this.t = false;
        this.u = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        d.a(1401, str);
    }

    @Override // com.baidu.ar.base.b
    protected void a(byte[] bArr, com.baidu.ar.d.a aVar) {
        if (!this.b || this.s || !this.u || this.t) {
            return;
        }
        d.a((int) MsgField.IMSG_ON_DEVICE_IR_START, " recg inited!");
        if (aVar != null) {
            this.t = true;
            ImageRecognitionManager.getInstance().recognizeFrame(aVar.a, aVar.b, bArr);
        }
    }

    @Override // com.baidu.ar.base.b
    public void d() {
        super.d();
        this.t = false;
        m();
    }

    public void d(boolean z) {
        this.t = z;
    }

    @Override // com.baidu.ar.base.b
    public void f() {
        ImageRecognitionManager.getInstance().release();
        super.f();
    }

    @Override // com.baidu.ar.base.b
    public void j() {
        ImageRecognitionManager.getInstance().release();
    }

    public void m() {
        this.u = true;
        if (!NetworkUtil.isNetworkConnected(this.a)) {
            Log.e("bdar", "no network");
            d.a((int) MsgField.IMSG_NO_NETWORK, MsgField.SMSG_NO_NETWORK);
        } else if (TextUtils.isEmpty(ARConfig.getARKey())) {
            ImageRecognitionManager.getInstance().initRecognition(this.a, new ImageRecognitionCallback() { // from class: com.baidu.ar.recg.a.1
                @Override // com.baidu.ar.recg.ImageRecognitionCallback
                public void onFeatureDBInit(boolean z) {
                    a.this.t = false;
                    if (z) {
                        d.a((int) MsgField.IMSG_ON_DEVICE_IR_TIMERR_START);
                    } else {
                        a.this.c("");
                    }
                }

                @Override // com.baidu.ar.recg.ImageRecognitionCallback
                public void onRecognizeResult(boolean z, String str) {
                    if (a.this.s || !a.this.t) {
                        return;
                    }
                    if (TextUtils.isEmpty(str)) {
                        a.this.t = false;
                    } else {
                        a.this.t = true;
                    }
                    if (z && TextUtils.isEmpty(ARConfig.getARKey())) {
                        ImageRecognitionManager.getInstance().stopRecognition();
                        d.a((int) MsgField.MSG_ON_DEVICE_IR_RESULT, str);
                    }
                }

                @Override // com.baidu.ar.recg.ImageRecognitionCallback
                public void onResourceDownload(boolean z) {
                    if (!z) {
                        a.this.c("");
                        return;
                    }
                    ImageRecognitionManager.getInstance().startRecognition();
                    d.a((int) MsgField.IMSG_ON_DEVICE_IR_TIMERR_START);
                }

                @Override // com.baidu.ar.recg.ImageRecognitionCallback
                public void onResourceRequest(boolean z, int i, String str) {
                    if (z) {
                        return;
                    }
                    a.this.c(str);
                }
            });
        }
    }
}
