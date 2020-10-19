package com.baidu.swan.pms.c;

import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.swan.pms.c.f;
import okhttp3.Response;
/* loaded from: classes15.dex */
public class g implements StatResponseCallback<String> {
    private final f.a dTE;

    public g(f.a aVar) {
        this.dTE = aVar;
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
        if (Pq()) {
            this.dTE.b(str, str2, networkStatRecord.toUBCJson());
        }
        return str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.callback.StatResponseCallback
    public void onSuccess(String str, int i) {
        if (Pq()) {
            this.dTE.onSuccess(str, i);
        }
    }

    @Override // com.baidu.searchbox.http.callback.StatResponseCallback
    public void onFail(Exception exc) {
        if (Pq()) {
            this.dTE.onFail(exc);
        }
    }

    private boolean Pq() {
        return this.dTE != null;
    }
}
