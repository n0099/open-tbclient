package com.baidu.adp.plugin.proxy.activity;

import android.content.ComponentName;
import android.content.Intent;
import com.baidu.adp.plugin.a;
import com.baidu.adp.plugin.util.e;
/* loaded from: classes.dex */
class b implements e {
    final /* synthetic */ a Ff;
    private final /* synthetic */ com.baidu.adp.plugin.a Fg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, com.baidu.adp.plugin.a aVar2) {
        this.Ff = aVar;
        this.Fg = aVar2;
    }

    @Override // com.baidu.adp.plugin.util.e
    public void a(a.b bVar, String str) {
        LoadingActivity loadingActivity;
        LoadingActivity loadingActivity2;
        LoadingActivity loadingActivity3;
        LoadingActivity loadingActivity4;
        loadingActivity = this.Ff.Fe;
        Intent intent = new Intent(loadingActivity.getIntent());
        loadingActivity2 = this.Ff.Fe;
        intent.setComponent(new ComponentName(str, loadingActivity2.getIntent().getStringExtra("intent_extra_redirect_activity")));
        com.baidu.adp.plugin.a aVar = this.Fg;
        loadingActivity3 = this.Ff.Fe;
        aVar.i(loadingActivity3.getPageContext().getContext(), intent);
        loadingActivity4 = this.Ff.Fe;
        loadingActivity4.finish();
    }
}
