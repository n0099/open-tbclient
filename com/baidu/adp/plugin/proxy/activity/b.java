package com.baidu.adp.plugin.proxy.activity;

import android.content.ComponentName;
import android.content.Intent;
import com.baidu.adp.plugin.util.d;
/* loaded from: classes.dex */
class b implements d {
    final /* synthetic */ a tU;
    private final /* synthetic */ com.baidu.adp.plugin.b tV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, com.baidu.adp.plugin.b bVar) {
        this.tU = aVar;
        this.tV = bVar;
    }

    @Override // com.baidu.adp.plugin.util.d
    public void c(boolean z, String str) {
        LoadingActivity loadingActivity;
        LoadingActivity loadingActivity2;
        LoadingActivity loadingActivity3;
        LoadingActivity loadingActivity4;
        loadingActivity = this.tU.tT;
        Intent intent = new Intent(loadingActivity.getIntent());
        loadingActivity2 = this.tU.tT;
        intent.setComponent(new ComponentName(str, loadingActivity2.getIntent().getStringExtra("intent_extra_redirect_activity")));
        com.baidu.adp.plugin.b bVar = this.tV;
        loadingActivity3 = this.tU.tT;
        bVar.i(loadingActivity3.getPageContext().getContext(), intent);
        loadingActivity4 = this.tU.tT;
        loadingActivity4.finish();
    }
}
