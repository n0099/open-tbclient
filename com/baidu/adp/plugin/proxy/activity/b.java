package com.baidu.adp.plugin.proxy.activity;

import android.content.ComponentName;
import android.content.Intent;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.util.e;
/* loaded from: classes.dex */
class b implements e {
    final /* synthetic */ a yv;
    private final /* synthetic */ Plugin yw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, Plugin plugin2) {
        this.yv = aVar;
        this.yw = plugin2;
    }

    @Override // com.baidu.adp.plugin.util.e
    public void a(Plugin.b bVar, String str) {
        LoadingActivity loadingActivity;
        LoadingActivity loadingActivity2;
        LoadingActivity loadingActivity3;
        LoadingActivity loadingActivity4;
        loadingActivity = this.yv.yu;
        Intent intent = new Intent(loadingActivity.getIntent());
        loadingActivity2 = this.yv.yu;
        intent.setComponent(new ComponentName(str, loadingActivity2.getIntent().getStringExtra(Plugin.INTENT_EXTRA_REDIRECT_ACTIVITY)));
        Plugin plugin2 = this.yw;
        loadingActivity3 = this.yv.yu;
        plugin2.launchIntent(loadingActivity3.getPageContext().getContext(), intent);
        loadingActivity4 = this.yv.yu;
        loadingActivity4.finish();
    }
}
