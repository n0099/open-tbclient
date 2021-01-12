package com.baidu.swan.pms.c;

import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.swan.pms.c.f;
import okhttp3.Response;
/* loaded from: classes6.dex */
public class g implements StatResponseCallback<String> {
    private final f.a esh;

    public g(f.a aVar) {
        this.esh = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.callback.StatResponseCallback
    /* renamed from: a */
    public String parseResponse(Response response, int i, NetworkStatRecord networkStatRecord) throws Exception {
        String str = "";
        String str2 = "";
        if (response != null && response.body() != null) {
            str = response.request().url().toString();
            str2 = response.body().string();
        }
        if (RV()) {
            this.esh.b(str, str2, networkStatRecord.toUBCJson());
        }
        return str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.callback.StatResponseCallback
    /* renamed from: S */
    public void onSuccess(String str, int i) {
        if (RV()) {
            this.esh.S(str, i);
        }
    }

    @Override // com.baidu.searchbox.http.callback.StatResponseCallback
    public void onFail(Exception exc) {
        if (RV()) {
            this.esh.onFail(exc);
        }
    }

    private boolean RV() {
        return this.esh != null;
    }
}
