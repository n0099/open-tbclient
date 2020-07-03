package com.baidu.crabsdk.sender;

import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.crabsdk.OnUploadFilesCallback;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class o implements Runnable {
    final /* synthetic */ OnUploadFilesCallback aoe;
    final /* synthetic */ String aof;
    final /* synthetic */ String aog;
    final /* synthetic */ String aoh;
    final /* synthetic */ String aoi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(OnUploadFilesCallback onUploadFilesCallback, String str, String str2, String str3, String str4) {
        this.aoe = onUploadFilesCallback;
        this.aof = str;
        this.aog = str2;
        this.aoh = str3;
        this.aoi = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String I = com.baidu.crabsdk.b.o.I();
        if (!((I.equals("NONE") || I.equals(RomUtils.UNKNOWN)) ? false : true)) {
            this.aoe.onFailed("Network is not connected!");
            return;
        }
        JSONObject a = com.baidu.crabsdk.b.j.a(this.aof, this.aoe, this.aog, this.aoh, this.aoi);
        if (a != null) {
            String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, this.aof);
            try {
                byte[] b = com.baidu.crabsdk.c.d.b(com.baidu.crabsdk.c.c.dl(a.toString()), c);
                String dp = com.baidu.crabsdk.c.e.dp(c);
                String e = com.baidu.crabsdk.a.e();
                com.baidu.crabsdk.c.a.di("sendLogRecord postUrl:" + e);
                String b2 = r.b(e, b, dp);
                if (TextUtils.isEmpty(b2)) {
                    com.baidu.crabsdk.c.a.dj("result is empty!");
                    this.aoe.onFailed("Result is empty!");
                } else if (b2 != null && b2.equals("N/A")) {
                    this.aoe.onFailed("Not connected to server!");
                } else {
                    com.baidu.crabsdk.c.a.v("Result is: " + b2);
                    try {
                        JSONObject jSONObject = new JSONObject(b2);
                        if (jSONObject.has("code")) {
                            if (jSONObject.optInt("code", -1) == 0) {
                                this.aoe.onSuccess();
                            } else {
                                this.aoe.onFailed(jSONObject.optString("msg", "No errorMessage!"));
                            }
                        }
                    } catch (Exception e2) {
                        com.baidu.crabsdk.c.a.a("Parse result error!", e2);
                        this.aoe.onFailed("Parse result error!");
                    }
                }
            } catch (Exception e3) {
                com.baidu.crabsdk.c.a.a("crash content AES failed!", e3);
                this.aoe.onFailed(e3.getMessage());
            } catch (OutOfMemoryError e4) {
                com.baidu.crabsdk.c.a.a("OutOfMemoryError", e4);
                this.aoe.onFailed(e4.getMessage());
            }
        }
    }
}
