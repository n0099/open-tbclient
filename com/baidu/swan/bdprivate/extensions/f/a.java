package com.baidu.swan.bdprivate.extensions.f;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adaptation.a.ak;
import com.baidu.swan.apps.ag.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.c.d;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a implements ak {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.m.a dsE = new com.baidu.m.a();

    @Override // com.baidu.swan.apps.adaptation.a.ak
    public boolean J(String str, String str2, String str3) {
        e aMm;
        b.a aMp;
        if (!c.aNJ() || (aMm = e.aMm()) == null || (aMp = aMm.aMp()) == null) {
            return false;
        }
        b(str, com.baidu.swan.ubc.e.bio().getUserId(AppRuntime.getAppContext()), com.baidu.swan.apps.t.a.aAx().cd(com.baidu.swan.apps.t.a.aAs()), com.baidu.swan.bdprivate.a.a.dX(aMm.getApplicationContext()), str2, str3, com.baidu.swan.apps.t.a.aBe().getHostName(), aMp.aCw());
        return true;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ak
    public void amc() {
        String readFileData = d.readFileData(aTx());
        final long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (!TextUtils.isEmpty(readFileData)) {
            try {
                if (currentTimeMillis - Long.parseLong(readFileData) < 86400) {
                    if (DEBUG) {
                        Log.d("RebateInfoManager", "requestBatchRebateInfo: 相邻请求时间需要大于一天");
                        return;
                    }
                    return;
                }
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                    return;
                }
                return;
            }
        }
        this.dsE.a(new com.baidu.poly.b.a() { // from class: com.baidu.swan.bdprivate.extensions.f.a.1
            @Override // com.baidu.poly.b.a
            public void onResult(int i, String str) {
                if (a.DEBUG) {
                    Log.d("RebateInfoManager", "requestBatchRebateInfo onResult: " + i + " " + str);
                }
                d.deleteFile(a.aTx());
                d.saveFile(String.valueOf(currentTimeMillis), a.aTx());
            }
        });
    }

    private void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("masterId", str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("userPassId", str2);
            }
            jSONObject.put("cuid", str3);
            jSONObject.put("bduss", str4);
            jSONObject.put("itemId", str5);
            jSONObject.put("businessId", str6);
            jSONObject.put("naid", str7);
            jSONObject.put("scene", str8);
            this.dsE.a(jSONObject, new com.baidu.poly.b.a() { // from class: com.baidu.swan.bdprivate.extensions.f.a.2
                @Override // com.baidu.poly.b.a
                public void onResult(int i, String str9) {
                    if (a.DEBUG) {
                        Log.d("RebateInfoManager", "requestSingleRebateInfo onResult: " + i + " " + str9);
                    }
                }
            });
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File aTx() {
        return new File(AppRuntime.getAppContext().getFilesDir().getPath(), "rebate_info_timestamp");
    }
}
