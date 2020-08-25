package com.baidu.crabsdk.sender;

import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.crabsdk.OnUploadFilesCallback;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class o implements Runnable {
    final /* synthetic */ OnUploadFilesCallback aoX;
    final /* synthetic */ String aoY;
    final /* synthetic */ String aoZ;
    final /* synthetic */ String apa;
    final /* synthetic */ String apb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(OnUploadFilesCallback onUploadFilesCallback, String str, String str2, String str3, String str4) {
        this.aoX = onUploadFilesCallback;
        this.aoY = str;
        this.aoZ = str2;
        this.apa = str3;
        this.apb = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String I = com.baidu.crabsdk.b.o.I();
        if (!((I.equals("NONE") || I.equals(RomUtils.UNKNOWN)) ? false : true)) {
            this.aoX.onFailed("Network is not connected!");
            return;
        }
        JSONObject a = com.baidu.crabsdk.b.j.a(this.aoY, this.aoX, this.aoZ, this.apa, this.apb);
        if (a != null) {
            String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, this.aoY);
            try {
                byte[] b = com.baidu.crabsdk.c.d.b(com.baidu.crabsdk.c.c.dv(a.toString()), c);
                String dz = com.baidu.crabsdk.c.e.dz(c);
                String e = com.baidu.crabsdk.a.e();
                com.baidu.crabsdk.c.a.ds("sendLogRecord postUrl:" + e);
                String b2 = r.b(e, b, dz);
                if (TextUtils.isEmpty(b2)) {
                    com.baidu.crabsdk.c.a.dt("result is empty!");
                    this.aoX.onFailed("Result is empty!");
                } else if (b2 != null && b2.equals("N/A")) {
                    this.aoX.onFailed("Not connected to server!");
                } else {
                    com.baidu.crabsdk.c.a.v("Result is: " + b2);
                    try {
                        JSONObject jSONObject = new JSONObject(b2);
                        if (jSONObject.has("code")) {
                            if (jSONObject.optInt("code", -1) == 0) {
                                this.aoX.onSuccess();
                            } else {
                                this.aoX.onFailed(jSONObject.optString("msg", "No errorMessage!"));
                            }
                        }
                    } catch (Exception e2) {
                        com.baidu.crabsdk.c.a.a("Parse result error!", e2);
                        this.aoX.onFailed("Parse result error!");
                    }
                }
            } catch (Exception e3) {
                com.baidu.crabsdk.c.a.a("crash content AES failed!", e3);
                this.aoX.onFailed(e3.getMessage());
            } catch (OutOfMemoryError e4) {
                com.baidu.crabsdk.c.a.a("OutOfMemoryError", e4);
                this.aoX.onFailed(e4.getMessage());
            }
        }
    }
}
