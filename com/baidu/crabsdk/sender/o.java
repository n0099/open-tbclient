package com.baidu.crabsdk.sender;

import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.crabsdk.OnUploadFilesCallback;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class o implements Runnable {
    final /* synthetic */ OnUploadFilesCallback aso;
    final /* synthetic */ String asp;
    final /* synthetic */ String asq;
    final /* synthetic */ String asr;
    final /* synthetic */ String ass;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(OnUploadFilesCallback onUploadFilesCallback, String str, String str2, String str3, String str4) {
        this.aso = onUploadFilesCallback;
        this.asp = str;
        this.asq = str2;
        this.asr = str3;
        this.ass = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String I = com.baidu.crabsdk.b.o.I();
        if (!((I.equals("NONE") || I.equals(RomUtils.UNKNOWN)) ? false : true)) {
            this.aso.onFailed("Network is not connected!");
            return;
        }
        JSONObject a2 = com.baidu.crabsdk.b.j.a(this.asp, this.aso, this.asq, this.asr, this.ass);
        if (a2 != null) {
            String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, this.asp);
            try {
                byte[] b = com.baidu.crabsdk.c.d.b(com.baidu.crabsdk.c.c.dz(a2.toString()), c);
                String dD = com.baidu.crabsdk.c.e.dD(c);
                String e = com.baidu.crabsdk.a.e();
                com.baidu.crabsdk.c.a.dw("sendLogRecord postUrl:" + e);
                String b2 = r.b(e, b, dD);
                if (TextUtils.isEmpty(b2)) {
                    com.baidu.crabsdk.c.a.dx("result is empty!");
                    this.aso.onFailed("Result is empty!");
                } else if (b2 != null && b2.equals("N/A")) {
                    this.aso.onFailed("Not connected to server!");
                } else {
                    com.baidu.crabsdk.c.a.v("Result is: " + b2);
                    try {
                        JSONObject jSONObject = new JSONObject(b2);
                        if (jSONObject.has("code")) {
                            if (jSONObject.optInt("code", -1) == 0) {
                                this.aso.onSuccess();
                            } else {
                                this.aso.onFailed(jSONObject.optString("msg", "No errorMessage!"));
                            }
                        }
                    } catch (Exception e2) {
                        com.baidu.crabsdk.c.a.a("Parse result error!", e2);
                        this.aso.onFailed("Parse result error!");
                    }
                }
            } catch (Exception e3) {
                com.baidu.crabsdk.c.a.a("crash content AES failed!", e3);
                this.aso.onFailed(e3.getMessage());
            } catch (OutOfMemoryError e4) {
                com.baidu.crabsdk.c.a.a("OutOfMemoryError", e4);
                this.aso.onFailed(e4.getMessage());
            }
        }
    }
}
