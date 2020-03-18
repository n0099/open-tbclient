package com.baidu.crabsdk.sender;

import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.crabsdk.OnUploadFilesCallback;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class o implements Runnable {
    final /* synthetic */ OnUploadFilesCallback SR;
    final /* synthetic */ String SS;
    final /* synthetic */ String ST;
    final /* synthetic */ String SU;
    final /* synthetic */ String SV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(OnUploadFilesCallback onUploadFilesCallback, String str, String str2, String str3, String str4) {
        this.SR = onUploadFilesCallback;
        this.SS = str;
        this.ST = str2;
        this.SU = str3;
        this.SV = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String I = com.baidu.crabsdk.b.o.I();
        if (!((I.equals("NONE") || I.equals(RomUtils.UNKNOWN)) ? false : true)) {
            this.SR.onFailed("Network is not connected!");
            return;
        }
        JSONObject a = com.baidu.crabsdk.b.j.a(this.SS, this.SR, this.ST, this.SU, this.SV);
        if (a != null) {
            String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, this.SS);
            try {
                byte[] b = com.baidu.crabsdk.c.d.b(com.baidu.crabsdk.c.c.cm(a.toString()), c);
                String cq = com.baidu.crabsdk.c.e.cq(c);
                String e = com.baidu.crabsdk.a.e();
                com.baidu.crabsdk.c.a.cj("sendLogRecord postUrl:" + e);
                String b2 = r.b(e, b, cq);
                if (TextUtils.isEmpty(b2)) {
                    com.baidu.crabsdk.c.a.ck("result is empty!");
                    this.SR.onFailed("Result is empty!");
                } else if (b2 != null && b2.equals("N/A")) {
                    this.SR.onFailed("Not connected to server!");
                } else {
                    com.baidu.crabsdk.c.a.v("Result is: " + b2);
                    try {
                        JSONObject jSONObject = new JSONObject(b2);
                        if (jSONObject.has("code")) {
                            if (jSONObject.optInt("code", -1) == 0) {
                                this.SR.onSuccess();
                            } else {
                                this.SR.onFailed(jSONObject.optString("msg", "No errorMessage!"));
                            }
                        }
                    } catch (Exception e2) {
                        com.baidu.crabsdk.c.a.f("Parse result error!", e2);
                        this.SR.onFailed("Parse result error!");
                    }
                }
            } catch (Exception e3) {
                com.baidu.crabsdk.c.a.f("crash content AES failed!", e3);
                this.SR.onFailed(e3.getMessage());
            } catch (OutOfMemoryError e4) {
                com.baidu.crabsdk.c.a.f("OutOfMemoryError", e4);
                this.SR.onFailed(e4.getMessage());
            }
        }
    }
}
