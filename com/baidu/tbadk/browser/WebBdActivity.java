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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.plugins.BdBrowserDelegate;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes.dex */
public class WebBdActivity extends BaseActivity implements Observer {
    protected boolean a = false;
    protected boolean b = false;
    private BdBrowserDelegate c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, String str, String str2, String str3, boolean z, boolean z2) {
        if (UtilHelper.webViewIsProbablyCorrupt(context)) {
            com.baidu.adp.lib.util.k.a(context, context.getString(com.baidu.tieba.y.web_view_corrupted));
            return;
        }
        Intent intent = new Intent(context, WebBdActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        intent.putExtra("url", str);
        intent.putExtra(SapiAccountManager.SESSION_BDUSS, str2);
        intent.putExtra(SapiAccountManager.SESSION_PTOKEN, str3);
        intent.putExtra("autoOrientaion", z);
        intent.putExtra("fullScreen", z2);
        context.startActivity(intent);
    }

    protected void a(Intent intent, Bundle bundle) {
        if (bundle != null) {
            this.a = bundle.getBoolean("autoOrientaion", false);
            this.b = bundle.getBoolean("fullScreen", false);
        } else if (intent != null) {
            this.a = intent.getBooleanExtra("autoOrientaion", false);
            this.b = intent.getBooleanExtra("fullScreen", false);
        }
        if (this.b) {
            getWindow().setFlags(1024, 1024);
        } else {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.flags &= -1025;
            getWindow().setAttributes(attributes);
            getWindow().clearFlags(512);
        }
        if (this.a) {
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
        if (com.baidu.tbadk.tbplugin.m.a() == null) {
            a.a(this, getIntent().getStringExtra("url"), true);
            finish();
            return;
        }
        this.c = (BdBrowserDelegate) com.baidu.tbadk.tbplugin.m.a().b(BdBrowserDelegate.class);
        if (this.c == null) {
            a.a(this, getIntent().getStringExtra("url"), true);
            finish();
            return;
        }
        try {
            this.c.setActivity(this);
            this.c.setCallback(new r(this));
            this.c.onCreate(bundle);
        } catch (Throwable th) {
            BdLog.e("Exception: " + th.getMessage());
            a.a(this, getIntent().getStringExtra("url"), true);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("autoOrientaion", this.a);
        bundle.putBoolean("fullScreen", this.b);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.a = bundle.getBoolean("autoOrientaion", false);
        this.b = bundle.getBoolean("fullScreen", false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.c != null) {
            this.c.onPause();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(getIntent(), null);
        if (this.c != null) {
            this.c.onNewIntent(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.c != null) {
            this.c.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.c != null) {
            this.c.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.c != null) {
            this.c.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.c != null && (this.c.onKeyUp(i, keyEvent) || super.onKeyUp(i, keyEvent));
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.c != null) {
            this.c.onActivityResult(i, i2, intent);
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (this.c != null) {
            this.c.update(observable, obj);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.c != null && (this.c.onKeyDown(i, keyEvent) || super.onKeyDown(i, keyEvent));
    }
}
