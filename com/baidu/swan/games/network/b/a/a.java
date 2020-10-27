package com.baidu.swan.games.network.b.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.binding.model.c;
import com.baidu.swan.games.network.a.d;
import com.baidu.swan.games.network.b.e;
import java.io.File;
import okhttp3.Request;
/* loaded from: classes10.dex */
public class a extends com.baidu.swan.games.network.a.b implements com.baidu.swan.games.network.b.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private e dRI;

    public a(com.baidu.swan.games.f.b bVar, c cVar) {
        super(bVar, cVar);
        this.dRI = new e(this);
    }

    @Override // com.baidu.swan.games.network.a
    public void j(c cVar) {
        super.j(cVar);
        this.dRI.aTT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.network.a.b
    public void a(Request request, String str, String str2, com.baidu.swan.games.network.b bVar, d dVar) {
        if (this.dRr != null && !xd(str)) {
            String optString = this.dRr.optString("url");
            if (DEBUG) {
                Log.d("PreDownloadTask", "doDownload start: " + optString);
            }
            com.baidu.swan.games.network.b.d.aTS().a(optString, this);
            super.a(request, str, str2, bVar, dVar);
        }
    }

    @Override // com.baidu.swan.games.network.a.b
    @Nullable
    protected String xc(@NonNull String str) {
        File parentFile;
        String tt = f.axo().awU().tt(str);
        if (tt == null || tt.endsWith(File.separator) || (parentFile = new File(tt).getParentFile()) == null) {
            return null;
        }
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        return tt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.network.a
    public void onSuccess(Object obj) {
        this.dRI.onSuccess(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.network.a.b, com.baidu.swan.games.network.a
    public void k(String str, int i, String str2) {
        this.dRI.k(str, i, str2);
    }

    @Override // com.baidu.swan.games.network.a, com.baidu.searchbox.v8engine.event.EventTargetImpl, com.baidu.searchbox.v8engine.event.EventTarget
    public boolean dispatchEvent(JSEvent jSEvent) {
        return this.dRI.b(jSEvent);
    }

    @Override // com.baidu.swan.games.network.b.a
    public void a(com.baidu.swan.games.network.b.b bVar) {
        if (bVar != null && bVar.data != null) {
            if (DEBUG) {
                Log.d("PreDownloadTask", "onDispatchResponseData type:" + bVar.type + ";data:" + bVar.data);
            }
            switch (bVar.type) {
                case 1:
                    super.onSuccess(bVar.data);
                    return;
                case 2:
                    com.baidu.swan.games.network.c.b bVar2 = (com.baidu.swan.games.network.c.b) bVar.data;
                    super.k(bVar2.url, bVar2.statusCode, bVar2.errMsg);
                    return;
                case 3:
                    super.dispatchEvent((JSEvent) bVar.data);
                    return;
                default:
                    return;
            }
        }
    }

    private boolean xd(String str) {
        String tt = f.axo().awU().tt(str);
        if (TextUtils.isEmpty(tt)) {
            return false;
        }
        return new File(tt).exists();
    }
}
