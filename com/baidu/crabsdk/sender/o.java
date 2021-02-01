package com.baidu.crabsdk.sender;

import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.crabsdk.OnUploadFilesCallback;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class o implements Runnable {
    final /* synthetic */ OnUploadFilesCallback aqO;
    final /* synthetic */ String aqP;
    final /* synthetic */ String aqQ;
    final /* synthetic */ String aqR;
    final /* synthetic */ String aqS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(OnUploadFilesCallback onUploadFilesCallback, String str, String str2, String str3, String str4) {
        this.aqO = onUploadFilesCallback;
        this.aqP = str;
        this.aqQ = str2;
        this.aqR = str3;
        this.aqS = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String I = com.baidu.crabsdk.b.o.I();
        if (!((I.equals("NONE") || I.equals(RomUtils.UNKNOWN)) ? false : true)) {
            this.aqO.onFailed("Network is not connected!");
            return;
        }
        JSONObject a2 = com.baidu.crabsdk.b.j.a(this.aqP, this.aqO, this.aqQ, this.aqR, this.aqS);
        if (a2 != null) {
            String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, this.aqP);
            try {
                byte[] b2 = com.baidu.crabsdk.c.d.b(com.baidu.crabsdk.c.c.dv(a2.toString()), c);
                String dz = com.baidu.crabsdk.c.e.dz(c);
                String e = com.baidu.crabsdk.a.e();
                com.baidu.crabsdk.c.a.ds("sendLogRecord postUrl:" + e);
                String b3 = r.b(e, b2, dz);
                if (TextUtils.isEmpty(b3)) {
                    com.baidu.crabsdk.c.a.dt("result is empty!");
                    this.aqO.onFailed("Result is empty!");
                } else if (b3 != null && b3.equals("N/A")) {
                    this.aqO.onFailed("Not connected to server!");
                } else {
                    com.baidu.crabsdk.c.a.v("Result is: " + b3);
                    try {
                        JSONObject jSONObject = new JSONObject(b3);
                        if (jSONObject.has("code")) {
                            if (jSONObject.optInt("code", -1) == 0) {
                                this.aqO.onSuccess();
                            } else {
                                this.aqO.onFailed(jSONObject.optString("msg", "No errorMessage!"));
                            }
                        }
                    } catch (Exception e2) {
                        com.baidu.crabsdk.c.a.a("Parse result error!", e2);
                        this.aqO.onFailed("Parse result error!");
                    }
                }
            } catch (Exception e3) {
                com.baidu.crabsdk.c.a.a("crash content AES failed!", e3);
                this.aqO.onFailed(e3.getMessage());
            } catch (OutOfMemoryError e4) {
                com.baidu.crabsdk.c.a.a("OutOfMemoryError", e4);
                this.aqO.onFailed(e4.getMessage());
            }
        }
    }
}
