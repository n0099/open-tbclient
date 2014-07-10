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
import com.baidu.adp.base.BdBaseFragmentActivity;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.mobstat.StatService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.bo;
import com.baidu.tbadk.i;
import com.baidu.tieba.u;
import com.compatible.menukey.MenuKeyUtils;
/* loaded from: classes.dex */
public abstract class BaseFragmentActivity extends BdBaseFragmentActivity {
    private ProgressBar d;
    private c e;
    protected ProgressDialog a = null;
    private DialogInterface.OnCancelListener c = null;
    protected int b = -1;

    protected abstract void b(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (i.a().a("is_exit_app_not_start_websocket", false)) {
            i.a().c("is_exit_app_not_start_websocket", false);
            BdSocketLinkService.startService(false, "app start");
        }
        MenuKeyUtils.hideSmartBarMenu(this);
        super.onCreate(bundle);
        TbadkApplication.setIsAppRunning(true);
        bo.a(getClass().getName());
        this.e = new c();
        if (TbadkApplication.m252getInst().getIsUseBaiduStatOn()) {
            try {
                StatService.setAppChannel(TbConfig.getFrom());
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        MenuKeyUtils.hideSoftMenuKey(getWindow());
        super.onResume();
        a(TbadkApplication.m252getInst().getSkinType());
        if (TbadkApplication.m252getInst().getIsUseBaiduStatOn()) {
            try {
                StatService.onResume((Context) this);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        TbadkApplication.m252getInst().AddResumeNum();
        bo.a(getClass().getName());
    }

    public void a(int i) {
        if (i != this.b) {
            this.b = i;
            b(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        TbadkApplication.m252getInst().DelResumeNum();
        if (TbadkApplication.m252getInst().getIsUseBaiduStatOn()) {
            try {
                StatService.onPause((Context) this);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.e != null) {
            this.e.a();
        }
        super.onDestroy();
    }

    public c c() {
        return this.e;
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
        if (this.e == null) {
            this.e = new c();
        }
        this.e.a(str, context, attributeSet);
        return super.onCreateView(str, context, attributeSet);
    }

    public void e_() {
        a(0, 0);
    }

    public void a(int i, int i2) {
        if (this.d == null) {
            this.d = new ProgressBar(this);
            this.d.setIndeterminateDrawable(getResources().getDrawable(u.progressbar));
            ((FrameLayout) findViewById(16908290)).addView(this.d, new FrameLayout.LayoutParams(-2, -2, 17));
        }
        this.d.setPadding(j.a(this, i), j.a(this, i2), 0, 0);
        this.d.setVisibility(0);
    }

    public void e() {
        if (this.d != null) {
            this.d.setVisibility(8);
        }
    }

    public boolean f() {
        return this.d != null && this.d.getVisibility() == 0;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82 && keyEvent.isLongPress()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
