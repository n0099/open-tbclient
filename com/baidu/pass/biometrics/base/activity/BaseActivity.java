package com.baidu.pass.biometrics.base.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.pass.biometrics.R;
import com.baidu.pass.biometrics.base.NoProguard;
import com.baidu.pass.biometrics.base.utils.PassBioGlobalUtils;
/* loaded from: classes2.dex */
public class BaseActivity extends Activity implements NoProguard {

    /* renamed from: c  reason: collision with root package name */
    public String f9030c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f9028a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f9029b = true;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9031d = false;

    @TargetApi(24)
    private void a() {
        if (Build.VERSION.SDK_INT < 24 || !isInMultiWindowMode()) {
            return;
        }
        if (this.f9028a) {
            PassBioGlobalUtils.toastWithText(getActivity(), this.f9030c, 1);
        }
        if (this.f9029b) {
            return;
        }
        finish();
    }

    public Activity getActivity() {
        return this;
    }

    public boolean isActivityInForeground() {
        return this.f9031d;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9030c = getResources().getString(R.string.pass_bio_multi_window_tips);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    @TargetApi(5)
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 82 && keyEvent.isLongPress()) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity
    @TargetApi(24)
    public void onMultiWindowModeChanged(boolean z) {
        if (Build.VERSION.SDK_INT >= 24) {
            super.onMultiWindowModeChanged(z);
            if (z && isActivityInForeground()) {
                if (this.f9028a) {
                    PassBioGlobalUtils.toastWithText(getActivity(), this.f9030c, 1);
                }
                if (this.f9029b) {
                    return;
                }
                finish();
            }
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.f9031d = false;
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.f9031d = true;
        a();
    }

    public void setIsMultiWindowAvailable(boolean z) {
        if (z != this.f9029b) {
            this.f9029b = z;
        }
    }

    public void setIsShowMultiWindowTips(boolean z) {
        if (z != this.f9028a) {
            this.f9028a = z;
        }
    }

    public void setMultiWindowTipsId(String str) {
        this.f9030c = str;
    }
}
