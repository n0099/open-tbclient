package com.baidu.browser.sailor.b.b;

import android.text.TextUtils;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.browser.sailor.a.n;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.webkit.sdk.Log;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
final class b implements Runnable {
    final /* synthetic */ n WH;
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String d;
    final /* synthetic */ String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, String str2, n nVar, String str3, String str4) {
        this.a = str;
        this.b = str2;
        this.WH = nVar;
        this.d = str3;
        this.e = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            f fVar = new f(this.a, "UTF-8", this.b);
            if (!TextUtils.isEmpty(this.d)) {
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(this.d);
                        JSONArray optJSONArray = jSONObject.optJSONArray("param");
                        if (optJSONArray != null) {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                try {
                                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                                    String string = jSONObject2.getString(RimArmor.KEY);
                                    String string2 = jSONObject2.getString("value");
                                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                                        fVar.WK.append((CharSequence) ("--" + fVar.a)).append((CharSequence) SystemInfoUtil.LINE_END);
                                        fVar.WK.append((CharSequence) ("Content-Disposition: form-data; name=\"" + string + "\"")).append((CharSequence) SystemInfoUtil.LINE_END);
                                        fVar.WK.append((CharSequence) ("Content-Type: text/plain; charset=" + fVar.b)).append((CharSequence) SystemInfoUtil.LINE_END);
                                        fVar.WK.append((CharSequence) SystemInfoUtil.LINE_END);
                                        fVar.WK.append((CharSequence) string2).append((CharSequence) SystemInfoUtil.LINE_END);
                                        fVar.WK.flush();
                                    }
                                } catch (JSONException e) {
                                    this.WH.bD(1);
                                    Log.d("BdWebappNativeAbility", e.getMessage());
                                }
                            }
                        }
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("file");
                        if (optJSONArray2 != null) {
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                                String string3 = jSONObject3.getString(RimArmor.KEY);
                                String string4 = jSONObject3.getString("value");
                                if (!TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string4)) {
                                    File file = new File(string4);
                                    if (com.baidu.browser.sailor.feature.a.d.a(com.baidu.browser.sailor.b.a.qP().getAppContext().getCacheDir(), file)) {
                                        fVar.a(string3, file);
                                    } else if (!com.baidu.browser.sailor.util.c.a(this.e, file)) {
                                        this.WH.bD(4);
                                        return;
                                    } else {
                                        fVar.a(string3, file);
                                    }
                                }
                            }
                        }
                    } catch (JSONException e2) {
                        this.WH.bD(1);
                        e2.printStackTrace();
                    }
                } catch (IOException e3) {
                    this.WH.bD(1);
                    e3.printStackTrace();
                }
            }
            try {
                try {
                    try {
                        String str = fVar.a().get(0);
                        if (str != null) {
                            this.WH.aG(true);
                            this.WH.addField("response", str);
                        }
                        this.WH.qN();
                    } catch (IllegalStateException e4) {
                        this.WH.bD(1);
                        e4.printStackTrace();
                    }
                } catch (IllegalStateException e5) {
                    this.WH.bD(2);
                    e5.printStackTrace();
                }
            } catch (UnsupportedEncodingException e6) {
                this.WH.bD(1);
                e6.printStackTrace();
            } catch (IOException e7) {
                this.WH.bD(1);
                e7.printStackTrace();
            }
        } catch (IOException e8) {
            this.WH.bD(2);
            e8.printStackTrace();
        }
    }
}
