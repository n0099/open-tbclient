package com.baidu.swan.apps.core.pms;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.ao.ae;
import com.baidu.swan.apps.core.pms.j;
import java.io.File;
import java.util.Set;
/* loaded from: classes9.dex */
public class k<T extends j> extends com.baidu.swan.pms.a.b<com.baidu.swan.pms.model.g> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    private final T cVm;

    public k(@NonNull T t) {
        this.cVm = t;
    }

    public String getAppKey() {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.a.c
    /* renamed from: e */
    public String U(com.baidu.swan.pms.model.g gVar) {
        if (TextUtils.isEmpty(gVar.appId)) {
            gVar.appId = getAppKey();
        }
        if (gVar.category == 0) {
            return com.baidu.swan.apps.core.pms.f.b.bA(gVar.appId, String.valueOf(gVar.versionCode));
        }
        if (gVar.category == 1) {
            return com.baidu.swan.apps.core.pms.f.b.bB(gVar.appId, String.valueOf(gVar.versionCode));
        }
        return null;
    }

    @Override // com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle bundle2 = new Bundle();
        if (set.contains("event_performance_ubc")) {
            this.cVm.bp(bundle.getString("performance_ubc_event_id"), bundle.getString("performance_ubc_extra_key_for_event"));
            set.remove("event_performance_ubc");
        }
        return bundle2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
    /* renamed from: c */
    public void S(com.baidu.swan.pms.model.g gVar) {
        super.S(gVar);
        if (DEBUG) {
            Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadStart " + gVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
    /* renamed from: f */
    public final void Q(com.baidu.swan.pms.model.g gVar) {
        super.Q(gVar);
        a(gVar, g(gVar));
        if (DEBUG) {
            Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadFinish " + gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void a(@NonNull com.baidu.swan.pms.model.g gVar, @Nullable com.baidu.swan.apps.al.a aVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
    @CallSuper
    public void a(com.baidu.swan.pms.model.g gVar, com.baidu.swan.pms.model.a aVar) {
        super.a((k<T>) gVar, aVar);
        com.baidu.swan.c.d.yO(gVar.filePath);
        if (DEBUG) {
            Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadError " + gVar + ", error=" + aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.a.b
    public int getPriority() {
        return super.getPriority();
    }

    private com.baidu.swan.apps.al.a g(com.baidu.swan.pms.model.g gVar) {
        if (!ae.e(new File(gVar.filePath), gVar.sign)) {
            return new com.baidu.swan.apps.al.a().db(12L).dd(2300L).tF("分包签名校验失败");
        }
        if (!com.baidu.swan.apps.core.pms.f.b.j(gVar)) {
            return new com.baidu.swan.apps.al.a().db(12L).dd(2320L).tF("分包解压失败");
        }
        return null;
    }
}
