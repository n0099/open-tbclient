package com.baidu.crabsdk.sender;

import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.crabsdk.OnUploadFilesCallback;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class o implements Runnable {
    final /* synthetic */ OnUploadFilesCallback amM;
    final /* synthetic */ String amN;
    final /* synthetic */ String amO;
    final /* synthetic */ String amP;
    final /* synthetic */ String amQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(OnUploadFilesCallback onUploadFilesCallback, String str, String str2, String str3, String str4) {
        this.amM = onUploadFilesCallback;
        this.amN = str;
        this.amO = str2;
        this.amP = str3;
        this.amQ = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String I = com.baidu.crabsdk.b.o.I();
        if (!((I.equals("NONE") || I.equals(RomUtils.UNKNOWN)) ? false : true)) {
            this.amM.onFailed("Network is not connected!");
            return;
        }
        JSONObject a = com.baidu.crabsdk.b.j.a(this.amN, this.amM, this.amO, this.amP, this.amQ);
        if (a != null) {
            String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, this.amN);
            try {
                byte[] b = com.baidu.crabsdk.c.d.b(com.baidu.crabsdk.c.c.dj(a.toString()), c);
                String dn = com.baidu.crabsdk.c.e.dn(c);
                String e = com.baidu.crabsdk.a.e();
                com.baidu.crabsdk.c.a.dg("sendLogRecord postUrl:" + e);
                String b2 = r.b(e, b, dn);
                if (TextUtils.isEmpty(b2)) {
                    com.baidu.crabsdk.c.a.dh("result is empty!");
                    this.amM.onFailed("Result is empty!");
                } else if (b2 != null && b2.equals("N/A")) {
                    this.amM.onFailed("Not connected to server!");
                } else {
                    com.baidu.crabsdk.c.a.v("Result is: " + b2);
                    try {
                        JSONObject jSONObject = new JSONObject(b2);
                        if (jSONObject.has("code")) {
                            if (jSONObject.optInt("code", -1) == 0) {
                                this.amM.onSuccess();
                            } else {
                                this.amM.onFailed(jSONObject.optString("msg", "No errorMessage!"));
                            }
                        }
                    } catch (Exception e2) {
                        com.baidu.crabsdk.c.a.a("Parse result error!", e2);
                        this.amM.onFailed("Parse result error!");
                    }
                }
            } catch (Exception e3) {
                com.baidu.crabsdk.c.a.a("crash content AES failed!", e3);
                this.amM.onFailed(e3.getMessage());
            } catch (OutOfMemoryError e4) {
                com.baidu.crabsdk.c.a.a("OutOfMemoryError", e4);
                this.amM.onFailed(e4.getMessage());
            }
        }
    }
}
