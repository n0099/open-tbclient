package com.baidu.browser.sailor.platform.nativeability;

import android.text.TextUtils;
import com.baidu.browser.sailor.lightapp.BdLightappConstants;
import com.baidu.browser.sailor.lightapp.BdLightappKernelJsCallback;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.down.common.intercepter.IIntercepter;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
final class b implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ BdLightappKernelJsCallback acZ;
    final /* synthetic */ String b;
    final /* synthetic */ String d;
    final /* synthetic */ String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, String str2, BdLightappKernelJsCallback bdLightappKernelJsCallback, String str3, String str4) {
        this.a = str;
        this.b = str2;
        this.acZ = bdLightappKernelJsCallback;
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
                                    String string = jSONObject2.getString("key");
                                    String string2 = jSONObject2.getString("value");
                                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                                        fVar.ade.append((CharSequence) ("--" + fVar.a)).append((CharSequence) "\r\n");
                                        fVar.ade.append((CharSequence) ("Content-Disposition: form-data; name=\"" + string + "\"")).append((CharSequence) "\r\n");
                                        fVar.ade.append((CharSequence) ("Content-Type: text/plain; charset=" + fVar.b)).append((CharSequence) "\r\n");
                                        fVar.ade.append((CharSequence) "\r\n");
                                        fVar.ade.append((CharSequence) string2).append((CharSequence) "\r\n");
                                        fVar.ade.flush();
                                    }
                                } catch (JSONException e) {
                                    this.acZ.sendCallBackWithRetCode(1);
                                    Log.d("BdWebappNativeAbility", e.getMessage());
                                }
                            }
                        }
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("file");
                        if (optJSONArray2 != null) {
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                                String string3 = jSONObject3.getString("key");
                                String string4 = jSONObject3.getString("value");
                                if (!TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string4)) {
                                    File file = new File(string4);
                                    File file2 = new File(BdSailorPlatform.getInstance().getAppContext().getCacheDir(), BdLightappConstants.PLUGIN_PACKAGE_NAME);
                                    File file3 = WebKitFactory.getContext() != null ? new File(WebKitFactory.getContext().getExternalFilesDir(""), "/baidu/SearchBox/com.baidu.searchbox.plugins.xsearch") : null;
                                    String absolutePath = file.getAbsolutePath();
                                    if (absolutePath.startsWith(file2.getAbsolutePath()) || (file3 != null && absolutePath.startsWith(file3.getAbsolutePath()))) {
                                        fVar.a(string3, file);
                                    } else if (!com.baidu.browser.sailor.util.b.a(this.e, file)) {
                                        this.acZ.sendCallBackWithRetCode(4);
                                        return;
                                    } else {
                                        fVar.a(string3, file);
                                    }
                                }
                            }
                        }
                    } catch (JSONException e2) {
                        this.acZ.sendCallBackWithRetCode(1);
                        e2.printStackTrace();
                    }
                } catch (IOException e3) {
                    this.acZ.sendCallBackWithRetCode(1);
                    e3.printStackTrace();
                }
            }
            try {
                try {
                    try {
                        String str = fVar.a().get(0);
                        if (str != null) {
                            this.acZ.setResult(true);
                            this.acZ.addField(IIntercepter.TYPE_RESPONSE, str);
                        }
                        this.acZ.notifyResult();
                    } catch (IllegalStateException e4) {
                        this.acZ.sendCallBackWithRetCode(1);
                        e4.printStackTrace();
                    }
                } catch (IllegalStateException e5) {
                    this.acZ.sendCallBackWithRetCode(2);
                    e5.printStackTrace();
                }
            } catch (UnsupportedEncodingException e6) {
                this.acZ.sendCallBackWithRetCode(1);
                e6.printStackTrace();
            } catch (IOException e7) {
                this.acZ.sendCallBackWithRetCode(1);
                e7.printStackTrace();
            }
        } catch (IOException e8) {
            this.acZ.sendCallBackWithRetCode(2);
            e8.printStackTrace();
        }
    }
}
