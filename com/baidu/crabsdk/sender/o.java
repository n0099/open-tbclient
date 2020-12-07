package com.baidu.crabsdk.sender;

import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.crabsdk.OnUploadFilesCallback;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class o implements Runnable {
    final /* synthetic */ OnUploadFilesCallback arp;
    final /* synthetic */ String arq;
    final /* synthetic */ String arr;
    final /* synthetic */ String ars;
    final /* synthetic */ String art;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(OnUploadFilesCallback onUploadFilesCallback, String str, String str2, String str3, String str4) {
        this.arp = onUploadFilesCallback;
        this.arq = str;
        this.arr = str2;
        this.ars = str3;
        this.art = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String I = com.baidu.crabsdk.b.o.I();
        if (!((I.equals("NONE") || I.equals(RomUtils.UNKNOWN)) ? false : true)) {
            this.arp.onFailed("Network is not connected!");
            return;
        }
        JSONObject a2 = com.baidu.crabsdk.b.j.a(this.arq, this.arp, this.arr, this.ars, this.art);
        if (a2 != null) {
            String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, this.arq);
            try {
                byte[] b = com.baidu.crabsdk.c.d.b(com.baidu.crabsdk.c.c.dH(a2.toString()), c);
                String dL = com.baidu.crabsdk.c.e.dL(c);
                String e = com.baidu.crabsdk.a.e();
                com.baidu.crabsdk.c.a.dE("sendLogRecord postUrl:" + e);
                String b2 = r.b(e, b, dL);
                if (TextUtils.isEmpty(b2)) {
                    com.baidu.crabsdk.c.a.dF("result is empty!");
                    this.arp.onFailed("Result is empty!");
                } else if (b2 != null && b2.equals("N/A")) {
                    this.arp.onFailed("Not connected to server!");
                } else {
                    com.baidu.crabsdk.c.a.v("Result is: " + b2);
                    try {
                        JSONObject jSONObject = new JSONObject(b2);
                        if (jSONObject.has("code")) {
                            if (jSONObject.optInt("code", -1) == 0) {
                                this.arp.onSuccess();
                            } else {
                                this.arp.onFailed(jSONObject.optString("msg", "No errorMessage!"));
                            }
                        }
                    } catch (Exception e2) {
                        com.baidu.crabsdk.c.a.a("Parse result error!", e2);
                        this.arp.onFailed("Parse result error!");
                    }
                }
            } catch (Exception e3) {
                com.baidu.crabsdk.c.a.a("crash content AES failed!", e3);
                this.arp.onFailed(e3.getMessage());
            } catch (OutOfMemoryError e4) {
                com.baidu.crabsdk.c.a.a("OutOfMemoryError", e4);
                this.arp.onFailed(e4.getMessage());
            }
        }
    }
}
