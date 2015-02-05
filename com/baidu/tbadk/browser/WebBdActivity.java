package com.baidu.tbadk.browser;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.WindowManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.plugins.BdBrowserDelegate;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes.dex */
public class WebBdActivity extends BaseActivity<WebBdActivity> implements Observer {
    protected boolean Bh = false;
    protected boolean Bi = false;
    private BdBrowserDelegate Bj;

    protected void a(Intent intent, Bundle bundle) {
        if (bundle != null) {
            this.Bh = bundle.getBoolean("autoOrientaion", false);
            this.Bi = bundle.getBoolean("fullScreen", false);
        } else if (intent != null) {
            this.Bh = intent.getBooleanExtra("autoOrientaion", false);
            this.Bi = intent.getBooleanExtra("fullScreen", false);
        }
        if (this.Bi) {
            getWindow().setFlags(1024, 1024);
        } else {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.flags &= -1025;
            getWindow().setAttributes(attributes);
            getWindow().clearFlags(512);
        }
        if (this.Bh) {
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
        a.d(getPageContext().getPageActivity(), getIntent().getStringExtra(ImageViewerConfig.URL), true);
        finish();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("autoOrientaion", this.Bh);
        bundle.putBoolean("fullScreen", this.Bi);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.Bh = bundle.getBoolean("autoOrientaion", false);
        this.Bi = bundle.getBoolean("fullScreen", false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.Bj != null) {
            this.Bj.onPause();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(getIntent(), null);
        if (this.Bj != null) {
            this.Bj.onNewIntent(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.Bj != null) {
            try {
                this.Bj.onResume();
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.Bj != null) {
            this.Bj.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.Bj != null) {
            this.Bj.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.Bj != null && (this.Bj.onKeyUp(i, keyEvent) || super.onKeyUp(i, keyEvent));
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.Bj != null) {
            this.Bj.onActivityResult(i, i2, intent);
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (this.Bj != null) {
            this.Bj.update(observable, obj);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.Bj != null && (this.Bj.onKeyDown(i, keyEvent) || super.onKeyDown(i, keyEvent));
    }
}
