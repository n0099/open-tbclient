package com.baidu.crabsdk.sender;

import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.crabsdk.OnUploadFilesCallback;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class o implements Runnable {
    final /* synthetic */ OnUploadFilesCallback alj;
    final /* synthetic */ String alk;
    final /* synthetic */ String alm;
    final /* synthetic */ String aln;
    final /* synthetic */ String alo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(OnUploadFilesCallback onUploadFilesCallback, String str, String str2, String str3, String str4) {
        this.alj = onUploadFilesCallback;
        this.alk = str;
        this.alm = str2;
        this.aln = str3;
        this.alo = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String I = com.baidu.crabsdk.b.o.I();
        if (!((I.equals("NONE") || I.equals(RomUtils.UNKNOWN)) ? false : true)) {
            this.alj.onFailed("Network is not connected!");
            return;
        }
        JSONObject a = com.baidu.crabsdk.b.j.a(this.alk, this.alj, this.alm, this.aln, this.alo);
        if (a != null) {
            String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, this.alk);
            try {
                byte[] b = com.baidu.crabsdk.c.d.b(com.baidu.crabsdk.c.c.dh(a.toString()), c);
                String dl = com.baidu.crabsdk.c.e.dl(c);
                String e = com.baidu.crabsdk.a.e();
                com.baidu.crabsdk.c.a.de("sendLogRecord postUrl:" + e);
                String b2 = r.b(e, b, dl);
                if (TextUtils.isEmpty(b2)) {
                    com.baidu.crabsdk.c.a.df("result is empty!");
                    this.alj.onFailed("Result is empty!");
                } else if (b2 != null && b2.equals("N/A")) {
                    this.alj.onFailed("Not connected to server!");
                } else {
                    com.baidu.crabsdk.c.a.v("Result is: " + b2);
                    try {
                        JSONObject jSONObject = new JSONObject(b2);
                        if (jSONObject.has("code")) {
                            if (jSONObject.optInt("code", -1) == 0) {
                                this.alj.onSuccess();
                            } else {
                                this.alj.onFailed(jSONObject.optString("msg", "No errorMessage!"));
                            }
                        }
                    } catch (Exception e2) {
                        com.baidu.crabsdk.c.a.a("Parse result error!", e2);
                        this.alj.onFailed("Parse result error!");
                    }
                }
            } catch (Exception e3) {
                com.baidu.crabsdk.c.a.a("crash content AES failed!", e3);
                this.alj.onFailed(e3.getMessage());
            } catch (OutOfMemoryError e4) {
                com.baidu.crabsdk.c.a.a("OutOfMemoryError", e4);
                this.alj.onFailed(e4.getMessage());
            }
        }
    }
}
