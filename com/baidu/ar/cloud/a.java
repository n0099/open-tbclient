package com.baidu.ar.cloud;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.base.MsgField;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.cloud.CloudRecognitionManager;
import com.baidu.ar.util.Debug;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.UiThreadUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class a extends com.baidu.ar.base.b implements CloudRecognitionManager.a {
    private int s;
    private ExecutorService t;
    private String u;

    public a(Context context) {
        super(context);
        this.s = -1;
        this.t = Executors.newSingleThreadExecutor();
        this.u = Res.getString("bdar_recg_error");
        Debug.resetBaseTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        com.baidu.ar.base.d.a((int) MsgField.IMSG_CLOUDAR_TOAST_ERROR, str);
    }

    public void a(int i) {
        this.s = i;
    }

    @Override // com.baidu.ar.cloud.CloudRecognitionManager.a
    public void a(boolean z, final String str, int i) {
        if (z) {
            this.s = 0;
        } else {
            this.s = -1;
        }
        if (i == 0 || i == 1054 || i == 1057) {
            return;
        }
        this.s = 2;
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.cloud.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.c(TextUtils.isEmpty(str) ? a.this.u : str);
            }
        });
    }

    @Override // com.baidu.ar.base.b
    protected void a(final byte[] bArr, final com.baidu.ar.d.a aVar) {
        if (this.s == -1) {
            if (TextUtils.isEmpty(ARConfig.getARKey())) {
                com.baidu.ar.base.d.a((int) MsgField.IMSG_CLORD_ID_START, " recg inited!");
            }
            this.s = 2;
            this.t.execute(new Runnable() { // from class: com.baidu.ar.cloud.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Debug.print("previewFrame start");
                    CloudRecognitionManager.getInstance().setYUVFile(bArr, aVar.a, aVar.b);
                }
            });
        }
    }

    @Override // com.baidu.ar.cloud.CloudRecognitionManager.a
    public void b(boolean z, final String str, int i) {
        if (!z || TextUtils.isEmpty(str)) {
            this.s = -1;
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.cloud.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.ar.base.d.a((int) MsgField.IMSG_CLOUDAR_RECG_RESULT, str);
                }
            });
        }
    }

    @Override // com.baidu.ar.base.b
    public void d() {
        super.d();
        CloudRecognitionManager.getInstance().initCloudRecognition(this.a, this);
        this.s = -1;
    }

    @Override // com.baidu.ar.base.b
    public void e() {
        super.e();
        CloudRecognitionManager.releaseInstance();
        this.s = 2;
    }

    @Override // com.baidu.ar.base.b
    public void f() {
        super.f();
        CloudRecognitionManager.releaseInstance();
    }

    @Override // com.baidu.ar.base.b
    public void j() {
        CloudRecognitionManager.releaseInstance();
    }
}
