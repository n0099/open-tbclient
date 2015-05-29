package com.baidu.adp.plugin.proxy.activity;

import android.content.ComponentName;
import android.content.Intent;
import com.baidu.adp.plugin.util.f;
/* loaded from: classes.dex */
class b implements f {
    final /* synthetic */ a EB;
    private final /* synthetic */ com.baidu.adp.plugin.a EC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, com.baidu.adp.plugin.a aVar2) {
        this.EB = aVar;
        this.EC = aVar2;
    }

    @Override // com.baidu.adp.plugin.util.f
    public void c(boolean z, String str) {
        LoadingActivity loadingActivity;
        LoadingActivity loadingActivity2;
        LoadingActivity loadingActivity3;
        LoadingActivity loadingActivity4;
        loadingActivity = this.EB.EA;
        Intent intent = new Intent(loadingActivity.getIntent());
        loadingActivity2 = this.EB.EA;
        intent.setComponent(new ComponentName(str, loadingActivity2.getIntent().getStringExtra("intent_extra_redirect_activity")));
        com.baidu.adp.plugin.a aVar = this.EC;
        loadingActivity3 = this.EB.EA;
        aVar.i(loadingActivity3.getPageContext().getContext(), intent);
        loadingActivity4 = this.EB.EA;
        loadingActivity4.finish();
    }
}
