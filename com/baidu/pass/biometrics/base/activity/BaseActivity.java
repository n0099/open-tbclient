package com.baidu.pass.biometrics.base.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.pass.biometrics.base.NoProguard;
import com.baidu.pass.biometrics.base.R;
import com.baidu.pass.biometrics.base.utils.PassBioGlobalUtils;
/* loaded from: classes5.dex */
public class BaseActivity extends Activity implements NoProguard {
    private String c;

    /* renamed from: a  reason: collision with root package name */
    private boolean f3975a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3976b = true;
    private boolean d = false;

    @TargetApi(24)
    private void a() {
        if (Build.VERSION.SDK_INT < 24 || !isInMultiWindowMode()) {
            return;
        }
        if (this.f3975a) {
            PassBioGlobalUtils.toastWithText(getActivity(), this.c, 1);
        }
        if (this.f3976b) {
            return;
        }
        finish();
    }

    public Activity getActivity() {
        return this;
    }

    public boolean isActivityInForeground() {
        return this.d;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = getResources().getString(R.string.pass_bio_multi_window_tips);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    @TargetApi(5)
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82 && keyEvent.isLongPress()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    @TargetApi(24)
    public void onMultiWindowModeChanged(boolean z) {
        if (Build.VERSION.SDK_INT >= 24) {
            super.onMultiWindowModeChanged(z);
            if (z && isActivityInForeground()) {
                if (this.f3975a) {
                    PassBioGlobalUtils.toastWithText(getActivity(), this.c, 1);
                }
                if (this.f3976b) {
                    return;
                }
                finish();
            }
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.d = false;
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.d = true;
        a();
    }

    protected void setIsMultiWindowAvailable(boolean z) {
        if (z != this.f3976b) {
            this.f3976b = z;
        }
    }

    protected void setIsShowMultiWindowTips(boolean z) {
        if (z != this.f3975a) {
            this.f3975a = z;
        }
    }

    protected void setMultiWindowTipsId(String str) {
        this.c = str;
    }
}
