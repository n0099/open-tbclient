package com.baidu.adp.plugin.proxy.activity;

import android.content.ComponentName;
import android.content.Intent;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.util.e;
/* loaded from: classes.dex */
class b implements e {
    final /* synthetic */ a vR;
    private final /* synthetic */ Plugin vS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, Plugin plugin2) {
        this.vR = aVar;
        this.vS = plugin2;
    }

    @Override // com.baidu.adp.plugin.util.e
    public void a(Plugin.b bVar, String str) {
        LoadingActivity loadingActivity;
        LoadingActivity loadingActivity2;
        LoadingActivity loadingActivity3;
        LoadingActivity loadingActivity4;
        loadingActivity = this.vR.vQ;
        Intent intent = new Intent(loadingActivity.getIntent());
        loadingActivity2 = this.vR.vQ;
        intent.setComponent(new ComponentName(str, loadingActivity2.getIntent().getStringExtra(Plugin.INTENT_EXTRA_REDIRECT_ACTIVITY)));
        Plugin plugin2 = this.vS;
        loadingActivity3 = this.vR.vQ;
        plugin2.launchIntent(loadingActivity3.getPageContext().getContext(), intent);
        loadingActivity4 = this.vR.vQ;
        loadingActivity4.finish();
    }
}
