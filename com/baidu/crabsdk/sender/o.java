package com.baidu.crabsdk.sender;

import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.crabsdk.OnUploadFilesCallback;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class o implements Runnable {
    final /* synthetic */ OnUploadFilesCallback aqt;
    final /* synthetic */ String aqu;
    final /* synthetic */ String aqv;
    final /* synthetic */ String aqw;
    final /* synthetic */ String aqx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(OnUploadFilesCallback onUploadFilesCallback, String str, String str2, String str3, String str4) {
        this.aqt = onUploadFilesCallback;
        this.aqu = str;
        this.aqv = str2;
        this.aqw = str3;
        this.aqx = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String I = com.baidu.crabsdk.b.o.I();
        if (!((I.equals("NONE") || I.equals(RomUtils.UNKNOWN)) ? false : true)) {
            this.aqt.onFailed("Network is not connected!");
            return;
        }
        JSONObject a2 = com.baidu.crabsdk.b.j.a(this.aqu, this.aqt, this.aqv, this.aqw, this.aqx);
        if (a2 != null) {
            String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, this.aqu);
            try {
                byte[] b = com.baidu.crabsdk.c.d.b(com.baidu.crabsdk.c.c.dF(a2.toString()), c);
                String dJ = com.baidu.crabsdk.c.e.dJ(c);
                String e = com.baidu.crabsdk.a.e();
                com.baidu.crabsdk.c.a.dC("sendLogRecord postUrl:" + e);
                String b2 = r.b(e, b, dJ);
                if (TextUtils.isEmpty(b2)) {
                    com.baidu.crabsdk.c.a.dD("result is empty!");
                    this.aqt.onFailed("Result is empty!");
                } else if (b2 != null && b2.equals("N/A")) {
                    this.aqt.onFailed("Not connected to server!");
                } else {
                    com.baidu.crabsdk.c.a.v("Result is: " + b2);
                    try {
                        JSONObject jSONObject = new JSONObject(b2);
                        if (jSONObject.has("code")) {
                            if (jSONObject.optInt("code", -1) == 0) {
                                this.aqt.onSuccess();
                            } else {
                                this.aqt.onFailed(jSONObject.optString("msg", "No errorMessage!"));
                            }
                        }
                    } catch (Exception e2) {
                        com.baidu.crabsdk.c.a.a("Parse result error!", e2);
                        this.aqt.onFailed("Parse result error!");
                    }
                }
            } catch (Exception e3) {
                com.baidu.crabsdk.c.a.a("crash content AES failed!", e3);
                this.aqt.onFailed(e3.getMessage());
            } catch (OutOfMemoryError e4) {
                com.baidu.crabsdk.c.a.a("OutOfMemoryError", e4);
                this.aqt.onFailed(e4.getMessage());
            }
        }
    }
}
