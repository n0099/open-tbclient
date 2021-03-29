package com.baidu.adp.plugin.proxy.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.base.BdBaseActivity;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import d.b.b.a.f;
import d.b.b.h.g.b;
import d.b.b.h.k.c;
/* loaded from: classes.dex */
public class LoadingActivity extends BdBaseActivity<LoadingActivity> {

    /* loaded from: classes.dex */
    public class a implements b {

        /* renamed from: com.baidu.adp.plugin.proxy.activity.LoadingActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0022a implements c {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Plugin f2235a;

            public C0022a(Plugin plugin2) {
                this.f2235a = plugin2;
            }

            @Override // d.b.b.h.k.c
            public void a(Plugin.c cVar, String str) {
                Intent intent = new Intent(LoadingActivity.this.getIntent());
                intent.setComponent(new ComponentName(str, LoadingActivity.this.getIntent().getStringExtra(Plugin.INTENT_EXTRA_REDIRECT_ACTIVITY)));
                this.f2235a.launchIntent(LoadingActivity.this.getPageContext().getContext(), intent);
                LoadingActivity.this.finish();
            }
        }

        public a() {
        }

        @Override // d.b.b.h.g.b
        public void a(String str, String str2) {
            LoadingActivity.this.showToast(PluginCenter.getInstance().getCommonErrorShowText());
        }

        @Override // d.b.b.h.g.b
        public void b(String str) {
            Plugin plugin2 = PluginCenter.getInstance().getPlugin(str);
            if (plugin2 != null) {
                plugin2.asyncInit(str, new C0022a(plugin2));
            }
        }
    }

    private void initLoadingView(String str) {
        try {
            LinearLayout linearLayout = new LinearLayout(getPageContext().getPageActivity());
            linearLayout.setGravity(17);
            ProgressBar progressBar = new ProgressBar(getPageContext().getPageActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            linearLayout.addView(progressBar, layoutParams);
            setContentView(linearLayout);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, d.b.b.a.g
    public f<LoadingActivity> getPageContext() {
        return null;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra(Plugin.INTENT_EXTRA_PACKAGE_NAME);
        if (PluginCenter.getInstance().isLoaded(stringExtra)) {
            finish();
            return;
        }
        initLoadingView(stringExtra);
        PluginPackageManager.O().o0(stringExtra, new a());
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
