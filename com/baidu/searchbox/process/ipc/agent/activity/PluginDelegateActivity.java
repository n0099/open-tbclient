package com.baidu.searchbox.process.ipc.agent.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import com.baidu.searchbox.process.ipc.util.TranslucentUtils;
/* loaded from: classes10.dex */
public class PluginDelegateActivity extends ProcessDelegateBaseActivity {
    private static final boolean DEBUG = false;
    public static final String ENABLE_FALLBACK_FINISH_KEY = "fallback_finish_key";
    private static final boolean FALLBACK_FINISH_DEFAULT_VALUE = true;
    private static final String TAG = "PluginDelegateActivity";
    private int mResumeCount = 0;
    private boolean mFallbackFinish = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.process.ipc.agent.activity.ProcessDelegateBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT == 26) {
            TranslucentUtils.convertFromTranslucent(this);
            setRequestedOrientation(this.mDelegation.getScreenOrientation());
            TranslucentUtils.convertToTranslucent(this);
        } else {
            setRequestedOrientation(this.mDelegation.getScreenOrientation());
        }
        if (!this.mDelegation.mParams.isEmpty()) {
            this.mFallbackFinish = this.mDelegation.mParams.getBoolean(ENABLE_FALLBACK_FINISH_KEY, true);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.mFallbackFinish) {
            int i = this.mResumeCount + 1;
            this.mResumeCount = i;
            if (i > 1) {
                this.mDelegation.onSelfFinish();
                exit(6, "");
            }
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mFallbackFinish) {
            this.mDelegation.onSelfFinish();
            exit(5, "by TouchEvent");
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }
}
