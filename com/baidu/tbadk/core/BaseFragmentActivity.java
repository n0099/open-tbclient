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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.mobstat.StatService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.u;
import com.baidu.tieba.y;
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
        MenuKeyUtils.hideSmartBarMenu(this);
        super.onCreate(bundle);
        TbadkApplication.setIsAppRunning(true);
        bi.a(getClass().getName());
        this.e = new c();
        if (TbadkApplication.m252getInst().getIsUseBaiduStatOn()) {
            try {
                StatService.setAppChannel(TbConfig.getFrom());
            } catch (Throwable th) {
                BdLog.e(getClass().getName(), "onCreate", th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        MenuKeyUtils.hideSoftMenuKey(getWindow());
        super.onResume();
        a(TbadkApplication.m252getInst().getSkinType());
        if (TbadkApplication.m252getInst().getIsUseBaiduStatOn()) {
            try {
                StatService.onResume((Context) this);
            } catch (Exception e) {
                BdLog.e(getClass().getName(), "onResume", e.getMessage());
            }
        }
        TbadkApplication.m252getInst().AddResumeNum();
        bi.a(getClass().getName());
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
                BdLog.e(getClass().getName(), "onPause", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.e != null) {
            this.e.b();
        }
        super.onDestroy();
    }

    public c a() {
        return this.e;
    }

    public void a(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (str != null) {
            this.a = ProgressDialog.show(this, "", str, true, true, onCancelListener);
        } else {
            this.a = ProgressDialog.show(this, "", getResources().getString(y.Waiting), true, true, onCancelListener);
        }
    }

    public void b() {
        if (this.a != null) {
            try {
                if (this.a.isShowing()) {
                    this.a.dismiss();
                }
            } catch (Exception e) {
                BdLog.e(getClass().getName(), "closeLoadingDialog", e.getMessage());
            }
            this.a = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public void a(String str) {
        k.a((Context) this, str);
    }

    public void c(int i) {
        k.a((Context) this, i);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.e == null) {
            this.e = new c();
        }
        this.e.a(str, context, attributeSet);
        return super.onCreateView(str, context, attributeSet);
    }

    public void c() {
        a(0, 0);
    }

    public void a(int i, int i2) {
        if (this.d == null) {
            this.d = new ProgressBar(this);
            this.d.setIndeterminateDrawable(getResources().getDrawable(u.progressbar));
            ((FrameLayout) findViewById(16908290)).addView(this.d, new FrameLayout.LayoutParams(-2, -2, 17));
        }
        this.d.setPadding(k.a(this, i), k.a(this, i2), 0, 0);
        this.d.setVisibility(0);
    }

    public void e_() {
        if (this.d != null) {
            this.d.setVisibility(8);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82 && keyEvent.isLongPress()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
