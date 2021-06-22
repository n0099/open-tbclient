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
    public String f8994c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f8992a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f8993b = true;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8995d = false;

    @TargetApi(24)
    private void a() {
        if (Build.VERSION.SDK_INT < 24 || !isInMultiWindowMode()) {
            return;
        }
        if (this.f8992a) {
            PassBioGlobalUtils.toastWithText(getActivity(), this.f8994c, 1);
        }
        if (this.f8993b) {
            return;
        }
        finish();
    }

    public Activity getActivity() {
        return this;
    }

    public boolean isActivityInForeground() {
        return this.f8995d;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f8994c = getResources().getString(R.string.pass_bio_multi_window_tips);
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
                if (this.f8992a) {
                    PassBioGlobalUtils.toastWithText(getActivity(), this.f8994c, 1);
                }
                if (this.f8993b) {
                    return;
                }
                finish();
            }
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.f8995d = false;
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.f8995d = true;
        a();
    }

    public void setIsMultiWindowAvailable(boolean z) {
        if (z != this.f8993b) {
            this.f8993b = z;
        }
    }

    public void setIsShowMultiWindowTips(boolean z) {
        if (z != this.f8992a) {
            this.f8992a = z;
        }
    }

    public void setMultiWindowTipsId(String str) {
        this.f8994c = str;
    }
}
