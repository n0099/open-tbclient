package com.baidu.adp.plugin.proxy.activity;

import android.content.ComponentName;
import android.content.Intent;
import com.baidu.adp.plugin.util.d;
/* loaded from: classes.dex */
class b implements d {
    final /* synthetic */ a EL;
    private final /* synthetic */ com.baidu.adp.plugin.b EM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, com.baidu.adp.plugin.b bVar) {
        this.EL = aVar;
        this.EM = bVar;
    }

    @Override // com.baidu.adp.plugin.util.d
    public void c(boolean z, String str) {
        LoadingActivity loadingActivity;
        LoadingActivity loadingActivity2;
        LoadingActivity loadingActivity3;
        LoadingActivity loadingActivity4;
        loadingActivity = this.EL.EK;
        Intent intent = new Intent(loadingActivity.getIntent());
        loadingActivity2 = this.EL.EK;
        intent.setComponent(new ComponentName(str, loadingActivity2.getIntent().getStringExtra("intent_extra_redirect_activity")));
        com.baidu.adp.plugin.b bVar = this.EM;
        loadingActivity3 = this.EL.EK;
        bVar.i(loadingActivity3.getPageContext().getContext(), intent);
        loadingActivity4 = this.EL.EK;
        loadingActivity4.finish();
    }
}
