package com.baidu.crabsdk.sender;

import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.crabsdk.OnUploadFilesCallback;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class o implements Runnable {
    final /* synthetic */ OnUploadFilesCallback apD;
    final /* synthetic */ String apE;
    final /* synthetic */ String apF;
    final /* synthetic */ String apG;
    final /* synthetic */ String apH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(OnUploadFilesCallback onUploadFilesCallback, String str, String str2, String str3, String str4) {
        this.apD = onUploadFilesCallback;
        this.apE = str;
        this.apF = str2;
        this.apG = str3;
        this.apH = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String I = com.baidu.crabsdk.b.o.I();
        if (!((I.equals("NONE") || I.equals(RomUtils.UNKNOWN)) ? false : true)) {
            this.apD.onFailed("Network is not connected!");
            return;
        }
        JSONObject a = com.baidu.crabsdk.b.j.a(this.apE, this.apD, this.apF, this.apG, this.apH);
        if (a != null) {
            String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, this.apE);
            try {
                byte[] b = com.baidu.crabsdk.c.d.b(com.baidu.crabsdk.c.c.dy(a.toString()), c);
                String dC = com.baidu.crabsdk.c.e.dC(c);
                String e = com.baidu.crabsdk.a.e();
                com.baidu.crabsdk.c.a.dv("sendLogRecord postUrl:" + e);
                String b2 = r.b(e, b, dC);
                if (TextUtils.isEmpty(b2)) {
                    com.baidu.crabsdk.c.a.dw("result is empty!");
                    this.apD.onFailed("Result is empty!");
                } else if (b2 != null && b2.equals("N/A")) {
                    this.apD.onFailed("Not connected to server!");
                } else {
                    com.baidu.crabsdk.c.a.v("Result is: " + b2);
                    try {
                        JSONObject jSONObject = new JSONObject(b2);
                        if (jSONObject.has("code")) {
                            if (jSONObject.optInt("code", -1) == 0) {
                                this.apD.onSuccess();
                            } else {
                                this.apD.onFailed(jSONObject.optString("msg", "No errorMessage!"));
                            }
                        }
                    } catch (Exception e2) {
                        com.baidu.crabsdk.c.a.a("Parse result error!", e2);
                        this.apD.onFailed("Parse result error!");
                    }
                }
            } catch (Exception e3) {
                com.baidu.crabsdk.c.a.a("crash content AES failed!", e3);
                this.apD.onFailed(e3.getMessage());
            } catch (OutOfMemoryError e4) {
                com.baidu.crabsdk.c.a.a("OutOfMemoryError", e4);
                this.apD.onFailed(e4.getMessage());
            }
        }
    }
}
