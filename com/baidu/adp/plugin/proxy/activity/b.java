package com.baidu.adp.plugin.proxy.activity;

import android.content.ComponentName;
import android.content.Intent;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.util.e;
/* loaded from: classes.dex */
class b implements e {
    final /* synthetic */ a vP;
    private final /* synthetic */ Plugin vQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, Plugin plugin2) {
        this.vP = aVar;
        this.vQ = plugin2;
    }

    @Override // com.baidu.adp.plugin.util.e
    public void a(Plugin.b bVar, String str) {
        LoadingActivity loadingActivity;
        LoadingActivity loadingActivity2;
        LoadingActivity loadingActivity3;
        LoadingActivity loadingActivity4;
        loadingActivity = this.vP.vO;
        Intent intent = new Intent(loadingActivity.getIntent());
        loadingActivity2 = this.vP.vO;
        intent.setComponent(new ComponentName(str, loadingActivity2.getIntent().getStringExtra(Plugin.INTENT_EXTRA_REDIRECT_ACTIVITY)));
        Plugin plugin2 = this.vQ;
        loadingActivity3 = this.vP.vO;
        plugin2.launchIntent(loadingActivity3.getPageContext().getContext(), intent);
        loadingActivity4 = this.vP.vO;
        loadingActivity4.finish();
    }
}
