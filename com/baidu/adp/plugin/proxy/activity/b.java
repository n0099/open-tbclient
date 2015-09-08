package com.baidu.adp.plugin.proxy.activity;

import android.content.ComponentName;
import android.content.Intent;
import com.baidu.adp.plugin.a;
import com.baidu.adp.plugin.util.e;
/* loaded from: classes.dex */
class b implements e {
    final /* synthetic */ a EC;
    private final /* synthetic */ com.baidu.adp.plugin.a ED;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, com.baidu.adp.plugin.a aVar2) {
        this.EC = aVar;
        this.ED = aVar2;
    }

    @Override // com.baidu.adp.plugin.util.e
    public void a(a.b bVar, String str) {
        LoadingActivity loadingActivity;
        LoadingActivity loadingActivity2;
        LoadingActivity loadingActivity3;
        LoadingActivity loadingActivity4;
        loadingActivity = this.EC.EB;
        Intent intent = new Intent(loadingActivity.getIntent());
        loadingActivity2 = this.EC.EB;
        intent.setComponent(new ComponentName(str, loadingActivity2.getIntent().getStringExtra("intent_extra_redirect_activity")));
        com.baidu.adp.plugin.a aVar = this.ED;
        loadingActivity3 = this.EC.EB;
        aVar.i(loadingActivity3.getPageContext().getContext(), intent);
        loadingActivity4 = this.EC.EB;
        loadingActivity4.finish();
    }
}
