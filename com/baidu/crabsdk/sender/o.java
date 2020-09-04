package com.baidu.crabsdk.sender;

import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.crabsdk.OnUploadFilesCallback;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class o implements Runnable {
    final /* synthetic */ OnUploadFilesCallback aoZ;
    final /* synthetic */ String apa;
    final /* synthetic */ String apb;
    final /* synthetic */ String apc;
    final /* synthetic */ String apd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(OnUploadFilesCallback onUploadFilesCallback, String str, String str2, String str3, String str4) {
        this.aoZ = onUploadFilesCallback;
        this.apa = str;
        this.apb = str2;
        this.apc = str3;
        this.apd = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String I = com.baidu.crabsdk.b.o.I();
        if (!((I.equals("NONE") || I.equals(RomUtils.UNKNOWN)) ? false : true)) {
            this.aoZ.onFailed("Network is not connected!");
            return;
        }
        JSONObject a = com.baidu.crabsdk.b.j.a(this.apa, this.aoZ, this.apb, this.apc, this.apd);
        if (a != null) {
            String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, this.apa);
            try {
                byte[] b = com.baidu.crabsdk.c.d.b(com.baidu.crabsdk.c.c.dw(a.toString()), c);
                String dA = com.baidu.crabsdk.c.e.dA(c);
                String e = com.baidu.crabsdk.a.e();
                com.baidu.crabsdk.c.a.dt("sendLogRecord postUrl:" + e);
                String b2 = r.b(e, b, dA);
                if (TextUtils.isEmpty(b2)) {
                    com.baidu.crabsdk.c.a.du("result is empty!");
                    this.aoZ.onFailed("Result is empty!");
                } else if (b2 != null && b2.equals("N/A")) {
                    this.aoZ.onFailed("Not connected to server!");
                } else {
                    com.baidu.crabsdk.c.a.v("Result is: " + b2);
                    try {
                        JSONObject jSONObject = new JSONObject(b2);
                        if (jSONObject.has("code")) {
                            if (jSONObject.optInt("code", -1) == 0) {
                                this.aoZ.onSuccess();
                            } else {
                                this.aoZ.onFailed(jSONObject.optString("msg", "No errorMessage!"));
                            }
                        }
                    } catch (Exception e2) {
                        com.baidu.crabsdk.c.a.a("Parse result error!", e2);
                        this.aoZ.onFailed("Parse result error!");
                    }
                }
            } catch (Exception e3) {
                com.baidu.crabsdk.c.a.a("crash content AES failed!", e3);
                this.aoZ.onFailed(e3.getMessage());
            } catch (OutOfMemoryError e4) {
                com.baidu.crabsdk.c.a.a("OutOfMemoryError", e4);
                this.aoZ.onFailed(e4.getMessage());
            }
        }
    }
}
