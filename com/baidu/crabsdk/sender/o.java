package com.baidu.crabsdk.sender;

import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.crabsdk.OnUploadFilesCallback;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class o implements Runnable {
    final /* synthetic */ OnUploadFilesCallback aqn;
    final /* synthetic */ String aqo;
    final /* synthetic */ String aqp;
    final /* synthetic */ String aqq;
    final /* synthetic */ String aqr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(OnUploadFilesCallback onUploadFilesCallback, String str, String str2, String str3, String str4) {
        this.aqn = onUploadFilesCallback;
        this.aqo = str;
        this.aqp = str2;
        this.aqq = str3;
        this.aqr = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String I = com.baidu.crabsdk.b.o.I();
        if (!((I.equals("NONE") || I.equals(RomUtils.UNKNOWN)) ? false : true)) {
            this.aqn.onFailed("Network is not connected!");
            return;
        }
        JSONObject a2 = com.baidu.crabsdk.b.j.a(this.aqo, this.aqn, this.aqp, this.aqq, this.aqr);
        if (a2 != null) {
            String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, this.aqo);
            try {
                byte[] b = com.baidu.crabsdk.c.d.b(com.baidu.crabsdk.c.c.dD(a2.toString()), c);
                String dH = com.baidu.crabsdk.c.e.dH(c);
                String e = com.baidu.crabsdk.a.e();
                com.baidu.crabsdk.c.a.dA("sendLogRecord postUrl:" + e);
                String b2 = r.b(e, b, dH);
                if (TextUtils.isEmpty(b2)) {
                    com.baidu.crabsdk.c.a.dB("result is empty!");
                    this.aqn.onFailed("Result is empty!");
                } else if (b2 != null && b2.equals("N/A")) {
                    this.aqn.onFailed("Not connected to server!");
                } else {
                    com.baidu.crabsdk.c.a.v("Result is: " + b2);
                    try {
                        JSONObject jSONObject = new JSONObject(b2);
                        if (jSONObject.has("code")) {
                            if (jSONObject.optInt("code", -1) == 0) {
                                this.aqn.onSuccess();
                            } else {
                                this.aqn.onFailed(jSONObject.optString("msg", "No errorMessage!"));
                            }
                        }
                    } catch (Exception e2) {
                        com.baidu.crabsdk.c.a.a("Parse result error!", e2);
                        this.aqn.onFailed("Parse result error!");
                    }
                }
            } catch (Exception e3) {
                com.baidu.crabsdk.c.a.a("crash content AES failed!", e3);
                this.aqn.onFailed(e3.getMessage());
            } catch (OutOfMemoryError e4) {
                com.baidu.crabsdk.c.a.a("OutOfMemoryError", e4);
                this.aqn.onFailed(e4.getMessage());
            }
        }
    }
}
