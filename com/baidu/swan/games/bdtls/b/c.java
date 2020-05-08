package com.baidu.swan.games.bdtls.b;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.as.m;
import java.util.HashMap;
import okhttp3.Response;
/* loaded from: classes11.dex */
public class c {

    /* loaded from: classes11.dex */
    public interface a {
        void b(boolean z, byte[] bArr);
    }

    public void a(byte[] bArr, final a aVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/octet-stream");
        hashMap.put("Bdtls", "Bdtls");
        HttpManager.getDefault(AppRuntime.getAppContext()).postByteRequest().url("https://mbd.baidu.com/ma/bdtls").cookieManager(com.baidu.swan.apps.w.a.acl().Qi()).headers(hashMap).content(bArr).build().executeAsync(new ResponseCallback<byte[]>() { // from class: com.baidu.swan.games.bdtls.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public byte[] parseResponse(Response response, int i) throws Exception {
                return response.body().bytes();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: g */
            public void onSuccess(final byte[] bArr2, int i) {
                m.postOnSerial(new Runnable() { // from class: com.baidu.swan.games.bdtls.b.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (aVar != null) {
                            aVar.b(true, bArr2);
                        }
                    }
                }, "HandshakeRequest");
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                m.postOnSerial(new Runnable() { // from class: com.baidu.swan.games.bdtls.b.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (aVar != null) {
                            aVar.b(false, null);
                        }
                    }
                }, "HandshakeRequest");
            }
        });
    }
}
