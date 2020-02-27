package com.baidu.pass.biometrics.base.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.pass.biometrics.base.NoProguard;
import com.baidu.pass.biometrics.base.R;
import com.baidu.pass.biometrics.base.utils.PassBioGlobalUtils;
/* loaded from: classes6.dex */
public class BaseActivity extends Activity implements NoProguard {
    private String mMultiWindowTips;
    private boolean mIsShowMultiWindowTips = false;
    private boolean mIsMultiWindowAvailable = true;
    private boolean mIsActivityInForeground = false;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mMultiWindowTips = getResources().getString(R.string.pass_bio_multi_window_tips);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.mIsActivityInForeground = true;
        showMultiWindowTips();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mIsActivityInForeground = false;
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

    public boolean isActivityInForeground() {
        return this.mIsActivityInForeground;
    }

    @Override // android.app.Activity
    @TargetApi(24)
    public void onMultiWindowModeChanged(boolean z) {
        if (Build.VERSION.SDK_INT >= 24) {
            super.onMultiWindowModeChanged(z);
            if (z && isActivityInForeground()) {
                if (this.mIsShowMultiWindowTips) {
                    PassBioGlobalUtils.toastWithText(getActivity(), this.mMultiWindowTips, 1);
                }
                if (!this.mIsMultiWindowAvailable) {
                    finish();
                }
            }
        }
    }

    public Activity getActivity() {
        return this;
    }

    @TargetApi(24)
    private void showMultiWindowTips() {
        if (Build.VERSION.SDK_INT >= 24 && isInMultiWindowMode()) {
            if (this.mIsShowMultiWindowTips) {
                PassBioGlobalUtils.toastWithText(getActivity(), this.mMultiWindowTips, 1);
            }
            if (!this.mIsMultiWindowAvailable) {
                finish();
            }
        }
    }

    protected void setIsShowMultiWindowTips(boolean z) {
        if (z != this.mIsShowMultiWindowTips) {
            this.mIsShowMultiWindowTips = z;
        }
    }

    protected void setIsMultiWindowAvailable(boolean z) {
        if (z != this.mIsMultiWindowAvailable) {
            this.mIsMultiWindowAvailable = z;
        }
    }

    protected void setMultiWindowTipsId(String str) {
        this.mMultiWindowTips = str;
    }
}
