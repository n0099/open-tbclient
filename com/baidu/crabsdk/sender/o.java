package com.baidu.crabsdk.sender;

import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.crabsdk.OnUploadFilesCallback;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class o implements Runnable {
    final /* synthetic */ OnUploadFilesCallback arL;
    final /* synthetic */ String arM;
    final /* synthetic */ String arN;
    final /* synthetic */ String arO;
    final /* synthetic */ String arP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(OnUploadFilesCallback onUploadFilesCallback, String str, String str2, String str3, String str4) {
        this.arL = onUploadFilesCallback;
        this.arM = str;
        this.arN = str2;
        this.arO = str3;
        this.arP = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String I = com.baidu.crabsdk.b.o.I();
        if (!((I.equals("NONE") || I.equals(RomUtils.UNKNOWN)) ? false : true)) {
            this.arL.onFailed("Network is not connected!");
            return;
        }
        JSONObject a2 = com.baidu.crabsdk.b.j.a(this.arM, this.arL, this.arN, this.arO, this.arP);
        if (a2 != null) {
            String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, this.arM);
            try {
                byte[] b2 = com.baidu.crabsdk.c.d.b(com.baidu.crabsdk.c.c.dA(a2.toString()), c);
                String dE = com.baidu.crabsdk.c.e.dE(c);
                String e = com.baidu.crabsdk.a.e();
                com.baidu.crabsdk.c.a.dx("sendLogRecord postUrl:" + e);
                String b3 = r.b(e, b2, dE);
                if (TextUtils.isEmpty(b3)) {
                    com.baidu.crabsdk.c.a.dy("result is empty!");
                    this.arL.onFailed("Result is empty!");
                } else if (b3 != null && b3.equals("N/A")) {
                    this.arL.onFailed("Not connected to server!");
                } else {
                    com.baidu.crabsdk.c.a.v("Result is: " + b3);
                    try {
                        JSONObject jSONObject = new JSONObject(b3);
                        if (jSONObject.has("code")) {
                            if (jSONObject.optInt("code", -1) == 0) {
                                this.arL.onSuccess();
                            } else {
                                this.arL.onFailed(jSONObject.optString("msg", "No errorMessage!"));
                            }
                        }
                    } catch (Exception e2) {
                        com.baidu.crabsdk.c.a.a("Parse result error!", e2);
                        this.arL.onFailed("Parse result error!");
                    }
                }
            } catch (Exception e3) {
                com.baidu.crabsdk.c.a.a("crash content AES failed!", e3);
                this.arL.onFailed(e3.getMessage());
            } catch (OutOfMemoryError e4) {
                com.baidu.crabsdk.c.a.a("OutOfMemoryError", e4);
                this.arL.onFailed(e4.getMessage());
            }
        }
    }
}
