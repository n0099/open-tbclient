package com.baidu.adp.plugin.proxy.activity;

import android.content.ComponentName;
import android.content.Intent;
import com.baidu.adp.plugin.a;
import com.baidu.adp.plugin.util.e;
/* loaded from: classes.dex */
class b implements e {
    final /* synthetic */ a ED;
    private final /* synthetic */ com.baidu.adp.plugin.a EE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, com.baidu.adp.plugin.a aVar2) {
        this.ED = aVar;
        this.EE = aVar2;
    }

    @Override // com.baidu.adp.plugin.util.e
    public void a(a.b bVar, String str) {
        LoadingActivity loadingActivity;
        LoadingActivity loadingActivity2;
        LoadingActivity loadingActivity3;
        LoadingActivity loadingActivity4;
        loadingActivity = this.ED.EC;
        Intent intent = new Intent(loadingActivity.getIntent());
        loadingActivity2 = this.ED.EC;
        intent.setComponent(new ComponentName(str, loadingActivity2.getIntent().getStringExtra("intent_extra_redirect_activity")));
        com.baidu.adp.plugin.a aVar = this.EE;
        loadingActivity3 = this.ED.EC;
        aVar.i(loadingActivity3.getPageContext().getContext(), intent);
        loadingActivity4 = this.ED.EC;
        loadingActivity4.finish();
    }
}
