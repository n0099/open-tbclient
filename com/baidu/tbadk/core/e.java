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
import com.baidu.adp.lib.util.i;
import com.baidu.mobstat.StatService;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.a.l;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.be;
import com.compatible.menukey.MenuKeyUtils;
/* loaded from: classes.dex */
public abstract class e extends com.baidu.adp.a.c {
    private ProgressBar d;
    private c e;
    protected ProgressDialog a = null;
    private DialogInterface.OnCancelListener c = null;
    protected int b = -1;

    protected abstract void c(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.a.c, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        MenuKeyUtils.hideSmartBarMenu(this);
        super.onCreate(bundle);
        l.a().c();
        TbadkApplication.a(true);
        be.a(getClass().getName());
        this.e = new c();
        if (TbadkApplication.j().x()) {
            try {
                StatService.setAppChannel(n.j());
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "onCreate", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        MenuKeyUtils.hideSoftMenuKey(getWindow());
        super.onResume();
        a(TbadkApplication.j().l());
        if (TbadkApplication.j().x()) {
            try {
                StatService.onResume(this);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "onResume", e.getMessage());
            }
        }
        TbadkApplication.j().n();
        be.a(getClass().getName());
    }

    public final void a(int i) {
        if (i != this.b) {
            this.b = i;
            c(this.b);
        }
    }

    public final void b(int i) {
        this.b = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        TbadkApplication.j().o();
        if (TbadkApplication.j().x()) {
            try {
                StatService.onPause(this);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "onPause", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.a.c, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.e != null) {
            this.e.b();
        }
        super.onDestroy();
    }

    public final c b() {
        return this.e;
    }

    public final void a(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (str != null) {
            this.a = ProgressDialog.show(this, "", str, true, true, onCancelListener);
        } else {
            this.a = ProgressDialog.show(this, "", getResources().getString(com.baidu.tbadk.l.Waiting), true, true, onCancelListener);
        }
    }

    public final void c() {
        if (this.a != null) {
            try {
                if (this.a.isShowing()) {
                    this.a.dismiss();
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "closeLoadingDialog", e.getMessage());
            }
            this.a = null;
        }
    }

    @Override // com.baidu.adp.a.c
    public final void a(String str) {
        i.a((Context) this, str);
    }

    public final void d(int i) {
        i.a((Context) this, i);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.e == null) {
            this.e = new c();
        }
        this.e.a(str, context, attributeSet);
        return super.onCreateView(str, context, attributeSet);
    }

    public final void g_() {
        if (this.d == null) {
            this.d = new ProgressBar(this);
            this.d.setIndeterminateDrawable(getResources().getDrawable(com.baidu.tbadk.i.progressbar));
            ((FrameLayout) findViewById(16908290)).addView(this.d, new FrameLayout.LayoutParams(-2, -2, 17));
        }
        this.d.setPadding(i.a((Context) this, 0.0f), i.a((Context) this, 0.0f), 0, 0);
        this.d.setVisibility(0);
    }

    public final void e() {
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
