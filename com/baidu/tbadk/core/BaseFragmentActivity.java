package com.baidu.tbadk.core;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.BdBaseFragmentActivity;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.t;
import com.compatible.menukey.MenuKeyUtils;
/* loaded from: classes.dex */
public abstract class BaseFragmentActivity extends BdBaseFragmentActivity {
    private ProgressBar e;
    private c f;
    protected ProgressDialog b = null;
    private DialogInterface.OnCancelListener d = null;
    protected int c = -1;

    protected abstract void b(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (com.baidu.tbadk.h.a().a("is_exit_app_not_start_websocket", false)) {
            com.baidu.tbadk.h.a().b("is_exit_app_not_start_websocket", false);
            BdSocketLinkService.startService(false, "app start");
        }
        MenuKeyUtils.hideSmartBarMenu(this);
        super.onCreate(bundle);
        TbadkApplication.setIsAppRunning(true);
        be.a(getClass().getName());
        this.f = new c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        MenuKeyUtils.hideSoftMenuKey(getWindow());
        super.onResume();
        a(TbadkApplication.m252getInst().getSkinType());
        TbadkApplication.m252getInst().AddResumeNum();
        be.a(getClass().getName());
    }

    public void a(int i) {
        if (i != this.c) {
            this.c = i;
            try {
                b(this.c);
            } catch (OutOfMemoryError e) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        TbadkApplication.m252getInst().DelResumeNum();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.f != null) {
            this.f.a();
        }
        super.onDestroy();
    }

    public c c() {
        return this.f;
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public void a(String str) {
        j.a((Context) this, str);
    }

    public void c(int i) {
        j.a((Context) this, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, int i) {
        BdToast.a(this, str, i).b();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.f == null) {
            this.f = new c();
        }
        this.f.a(str, context, attributeSet);
        return super.onCreateView(str, context, attributeSet);
    }

    public void e_() {
        try {
            a(0, 0);
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
        }
    }

    public void a(int i, int i2) {
        if (this.e == null) {
            this.e = new ProgressBar(this);
            this.e.setIndeterminateDrawable(getResources().getDrawable(t.progressbar));
            ((FrameLayout) findViewById(16908290)).addView(this.e, new FrameLayout.LayoutParams(-2, -2, 17));
        }
        this.e.setPadding(j.a(this, i), j.a(this, i2), 0, 0);
        this.e.setVisibility(0);
    }

    public void e() {
        if (this.e != null) {
            this.e.setVisibility(8);
        }
    }

    public boolean f() {
        return this.e != null && this.e.getVisibility() == 0;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82) {
            try {
                if (keyEvent.isLongPress()) {
                    return true;
                }
            } catch (IllegalStateException e) {
                if (i == 4) {
                    finish();
                    return true;
                }
                return false;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        try {
            return super.onKeyUp(i, keyEvent);
        } catch (IllegalStateException e) {
            if (i == 4) {
                finish();
            }
            return true;
        }
    }
}
