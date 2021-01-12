package com.baidu.crabsdk.sender;

import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.crabsdk.OnUploadFilesCallback;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public final class o implements Runnable {
    final /* synthetic */ OnUploadFilesCallback aqY;
    final /* synthetic */ String aqZ;
    final /* synthetic */ String ara;
    final /* synthetic */ String arb;
    final /* synthetic */ String arc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(OnUploadFilesCallback onUploadFilesCallback, String str, String str2, String str3, String str4) {
        this.aqY = onUploadFilesCallback;
        this.aqZ = str;
        this.ara = str2;
        this.arb = str3;
        this.arc = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String I = com.baidu.crabsdk.b.o.I();
        if (!((I.equals("NONE") || I.equals(RomUtils.UNKNOWN)) ? false : true)) {
            this.aqY.onFailed("Network is not connected!");
            return;
        }
        JSONObject a2 = com.baidu.crabsdk.b.j.a(this.aqZ, this.aqY, this.ara, this.arb, this.arc);
        if (a2 != null) {
            String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, this.aqZ);
            try {
                byte[] b2 = com.baidu.crabsdk.c.d.b(com.baidu.crabsdk.c.c.dv(a2.toString()), c);
                String dz = com.baidu.crabsdk.c.e.dz(c);
                String e = com.baidu.crabsdk.a.e();
                com.baidu.crabsdk.c.a.ds("sendLogRecord postUrl:" + e);
                String b3 = r.b(e, b2, dz);
                if (TextUtils.isEmpty(b3)) {
                    com.baidu.crabsdk.c.a.dt("result is empty!");
                    this.aqY.onFailed("Result is empty!");
                } else if (b3 != null && b3.equals("N/A")) {
                    this.aqY.onFailed("Not connected to server!");
                } else {
                    com.baidu.crabsdk.c.a.v("Result is: " + b3);
                    try {
                        JSONObject jSONObject = new JSONObject(b3);
                        if (jSONObject.has("code")) {
                            if (jSONObject.optInt("code", -1) == 0) {
                                this.aqY.onSuccess();
                            } else {
                                this.aqY.onFailed(jSONObject.optString("msg", "No errorMessage!"));
                            }
                        }
                    } catch (Exception e2) {
                        com.baidu.crabsdk.c.a.a("Parse result error!", e2);
                        this.aqY.onFailed("Parse result error!");
                    }
                }
            } catch (Exception e3) {
                com.baidu.crabsdk.c.a.a("crash content AES failed!", e3);
                this.aqY.onFailed(e3.getMessage());
            } catch (OutOfMemoryError e4) {
                com.baidu.crabsdk.c.a.a("OutOfMemoryError", e4);
                this.aqY.onFailed(e4.getMessage());
            }
        }
    }
}
