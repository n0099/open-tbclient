package com.baidu.pass.biometrics.base.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.pass.biometrics.base.NoProguard;
import com.baidu.pass.biometrics.base.utils.PassBioGlobalUtils;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class BaseActivity extends Activity implements NoProguard {
    public String c;
    public boolean a = false;
    public boolean b = true;
    public boolean d = false;

    public Activity getActivity() {
        return this;
    }

    @TargetApi(24)
    private void a() {
        if (Build.VERSION.SDK_INT >= 24 && isInMultiWindowMode()) {
            if (this.a) {
                PassBioGlobalUtils.toastWithText(getActivity(), this.c, 1);
            }
            if (!this.b) {
                finish();
            }
        }
    }

    public boolean isActivityInForeground() {
        return this.d;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
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

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = getResources().getString(R.string.obfuscated_res_0x7f0f0f45);
    }

    @Override // android.app.Activity
    @TargetApi(24)
    public void onMultiWindowModeChanged(boolean z) {
        if (Build.VERSION.SDK_INT >= 24) {
            super.onMultiWindowModeChanged(z);
            if (z && isActivityInForeground()) {
                if (this.a) {
                    PassBioGlobalUtils.toastWithText(getActivity(), this.c, 1);
                }
                if (!this.b) {
                    finish();
                }
            }
        }
    }

    public void setIsMultiWindowAvailable(boolean z) {
        if (z != this.b) {
            this.b = z;
        }
    }

    public void setIsShowMultiWindowTips(boolean z) {
        if (z != this.a) {
            this.a = z;
        }
    }

    public void setMultiWindowTipsId(String str) {
        this.c = str;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    @TargetApi(5)
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82 && keyEvent.isLongPress()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
