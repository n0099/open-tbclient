package com.baidu.crabsdk.sender;

import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.crabsdk.OnUploadFilesCallback;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public final class o implements Runnable {
    final /* synthetic */ OnUploadFilesCallback aoa;
    final /* synthetic */ String aob;
    final /* synthetic */ String aoc;
    final /* synthetic */ String aod;
    final /* synthetic */ String aoe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(OnUploadFilesCallback onUploadFilesCallback, String str, String str2, String str3, String str4) {
        this.aoa = onUploadFilesCallback;
        this.aob = str;
        this.aoc = str2;
        this.aod = str3;
        this.aoe = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String I = com.baidu.crabsdk.b.o.I();
        if (!((I.equals("NONE") || I.equals(RomUtils.UNKNOWN)) ? false : true)) {
            this.aoa.onFailed("Network is not connected!");
            return;
        }
        JSONObject a = com.baidu.crabsdk.b.j.a(this.aob, this.aoa, this.aoc, this.aod, this.aoe);
        if (a != null) {
            String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, this.aob);
            try {
                byte[] b = com.baidu.crabsdk.c.d.b(com.baidu.crabsdk.c.c.dk(a.toString()), c);
                String m19do = com.baidu.crabsdk.c.e.m19do(c);
                String e = com.baidu.crabsdk.a.e();
                com.baidu.crabsdk.c.a.dh("sendLogRecord postUrl:" + e);
                String b2 = r.b(e, b, m19do);
                if (TextUtils.isEmpty(b2)) {
                    com.baidu.crabsdk.c.a.di("result is empty!");
                    this.aoa.onFailed("Result is empty!");
                } else if (b2 != null && b2.equals("N/A")) {
                    this.aoa.onFailed("Not connected to server!");
                } else {
                    com.baidu.crabsdk.c.a.v("Result is: " + b2);
                    try {
                        JSONObject jSONObject = new JSONObject(b2);
                        if (jSONObject.has("code")) {
                            if (jSONObject.optInt("code", -1) == 0) {
                                this.aoa.onSuccess();
                            } else {
                                this.aoa.onFailed(jSONObject.optString("msg", "No errorMessage!"));
                            }
                        }
                    } catch (Exception e2) {
                        com.baidu.crabsdk.c.a.a("Parse result error!", e2);
                        this.aoa.onFailed("Parse result error!");
                    }
                }
            } catch (Exception e3) {
                com.baidu.crabsdk.c.a.a("crash content AES failed!", e3);
                this.aoa.onFailed(e3.getMessage());
            } catch (OutOfMemoryError e4) {
                com.baidu.crabsdk.c.a.a("OutOfMemoryError", e4);
                this.aoa.onFailed(e4.getMessage());
            }
        }
    }
}
