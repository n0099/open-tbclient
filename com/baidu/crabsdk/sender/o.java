package com.baidu.crabsdk.sender;

import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.crabsdk.OnUploadFilesCallback;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class o implements Runnable {
    final /* synthetic */ OnUploadFilesCallback ald;
    final /* synthetic */ String ale;
    final /* synthetic */ String alf;
    final /* synthetic */ String alg;
    final /* synthetic */ String alh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(OnUploadFilesCallback onUploadFilesCallback, String str, String str2, String str3, String str4) {
        this.ald = onUploadFilesCallback;
        this.ale = str;
        this.alf = str2;
        this.alg = str3;
        this.alh = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String I = com.baidu.crabsdk.b.o.I();
        if (!((I.equals("NONE") || I.equals(RomUtils.UNKNOWN)) ? false : true)) {
            this.ald.onFailed("Network is not connected!");
            return;
        }
        JSONObject a = com.baidu.crabsdk.b.j.a(this.ale, this.ald, this.alf, this.alg, this.alh);
        if (a != null) {
            String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, this.ale);
            try {
                byte[] b = com.baidu.crabsdk.c.d.b(com.baidu.crabsdk.c.c.dh(a.toString()), c);
                String dl = com.baidu.crabsdk.c.e.dl(c);
                String e = com.baidu.crabsdk.a.e();
                com.baidu.crabsdk.c.a.de("sendLogRecord postUrl:" + e);
                String b2 = r.b(e, b, dl);
                if (TextUtils.isEmpty(b2)) {
                    com.baidu.crabsdk.c.a.df("result is empty!");
                    this.ald.onFailed("Result is empty!");
                } else if (b2 != null && b2.equals("N/A")) {
                    this.ald.onFailed("Not connected to server!");
                } else {
                    com.baidu.crabsdk.c.a.v("Result is: " + b2);
                    try {
                        JSONObject jSONObject = new JSONObject(b2);
                        if (jSONObject.has("code")) {
                            if (jSONObject.optInt("code", -1) == 0) {
                                this.ald.onSuccess();
                            } else {
                                this.ald.onFailed(jSONObject.optString("msg", "No errorMessage!"));
                            }
                        }
                    } catch (Exception e2) {
                        com.baidu.crabsdk.c.a.f("Parse result error!", e2);
                        this.ald.onFailed("Parse result error!");
                    }
                }
            } catch (Exception e3) {
                com.baidu.crabsdk.c.a.f("crash content AES failed!", e3);
                this.ald.onFailed(e3.getMessage());
            } catch (OutOfMemoryError e4) {
                com.baidu.crabsdk.c.a.f("OutOfMemoryError", e4);
                this.ald.onFailed(e4.getMessage());
            }
        }
    }
}
