package com.baidu.tbadk.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.WindowManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.pluginArch.Plugin;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.plugins.BdBrowserDelegate;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes.dex */
public class WebBdActivity extends BaseActivity implements Observer {
    protected boolean xC = false;
    protected boolean xD = false;
    private BdBrowserDelegate xE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, String str, String str2, String str3, boolean z, boolean z2) {
        if (UtilHelper.webViewIsProbablyCorrupt(context)) {
            com.baidu.adp.lib.util.m.showToast(context, context.getString(com.baidu.tieba.y.web_view_corrupted));
            return;
        }
        Intent intent = new Intent(context, WebBdActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        intent.putExtra(ImageViewerConfig.URL, str);
        intent.putExtra(SapiAccountManager.SESSION_BDUSS, str2);
        intent.putExtra(SapiAccountManager.SESSION_PTOKEN, str3);
        intent.putExtra("autoOrientaion", z);
        intent.putExtra("fullScreen", z2);
        context.startActivity(intent);
    }

    protected void a(Intent intent, Bundle bundle) {
        if (bundle != null) {
            this.xC = bundle.getBoolean("autoOrientaion", false);
            this.xD = bundle.getBoolean("fullScreen", false);
        } else if (intent != null) {
            this.xC = intent.getBooleanExtra("autoOrientaion", false);
            this.xD = intent.getBooleanExtra("fullScreen", false);
        }
        if (this.xD) {
            getWindow().setFlags(1024, 1024);
        } else {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.flags &= -1025;
            getWindow().setAttributes(attributes);
            getWindow().clearFlags(512);
        }
        if (this.xC) {
            if (getRequestedOrientation() != 4) {
                setRequestedOrientation(4);
            }
        } else if (getRequestedOrientation() != 1) {
            setRequestedOrientation(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(getIntent(), bundle);
        if (PluginCenter.getInstance() == null) {
            a.a((Context) this, getIntent().getStringExtra(ImageViewerConfig.URL), true);
            finish();
            return;
        }
        Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_BROWSER);
        if (pluginByName != null) {
            this.xE = (BdBrowserDelegate) pluginByName.getClassInstance(BdBrowserDelegate.class);
        }
        if (this.xE == null) {
            a.a((Context) this, getIntent().getStringExtra(ImageViewerConfig.URL), true);
            finish();
            return;
        }
        try {
            this.xE.setActivity(this);
            this.xE.setCallback(new r(this));
            this.xE.onCreate(bundle);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            a.a((Context) this, getIntent().getStringExtra(ImageViewerConfig.URL), true);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("autoOrientaion", this.xC);
        bundle.putBoolean("fullScreen", this.xD);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.xC = bundle.getBoolean("autoOrientaion", false);
        this.xD = bundle.getBoolean("fullScreen", false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.xE != null) {
            this.xE.onPause();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(getIntent(), null);
        if (this.xE != null) {
            this.xE.onNewIntent(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.xE != null) {
            try {
                this.xE.onResume();
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.xE != null) {
            this.xE.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.xE != null) {
            this.xE.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.xE != null && (this.xE.onKeyUp(i, keyEvent) || super.onKeyUp(i, keyEvent));
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.xE != null) {
            this.xE.onActivityResult(i, i2, intent);
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (this.xE != null) {
            this.xE.update(observable, obj);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.xE != null && (this.xE.onKeyDown(i, keyEvent) || super.onKeyDown(i, keyEvent));
    }
}
