package com.baidu.pass.biometrics.base.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.pass.biometrics.base.NoProguard;
import com.baidu.pass.biometrics.base.R;
import com.baidu.pass.biometrics.base.utils.PassBioGlobalUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class BaseActivity extends Activity implements NoProguard {
    protected static final int FLAG_PAY_SKD = 1;
    private static final String TAG = "BaseActivity";
    public static final String WITH_ANIM = "with_anim";
    public static LinkedList<BaseActivity> mActivityStack = new LinkedList<>();
    public static int mLiveActivityNum = 0;
    private String mMultiWindowTips;
    public int mFlag = -1;
    private boolean mIsShowMultiWindowTips = false;
    private boolean mIsMultiWindowAvailable = true;
    private boolean mIsActivityInForeground = false;

    public static boolean isAppInForeground() {
        return mLiveActivityNum > 0;
    }

    protected static synchronized void removeFromTask(BaseActivity baseActivity) {
        synchronized (BaseActivity.class) {
            mActivityStack.remove(baseActivity);
        }
    }

    protected static synchronized void clearTask() {
        synchronized (BaseActivity.class) {
            Iterator<BaseActivity> it = mActivityStack.iterator();
            while (it.hasNext()) {
                it.next().finish();
            }
        }
    }

    protected static BaseActivity getTopActivity() throws Throwable {
        return mActivityStack.getLast();
    }

    protected static synchronized void addToTask(BaseActivity baseActivity) {
        synchronized (BaseActivity.class) {
            mActivityStack.remove(baseActivity);
            mActivityStack.add(baseActivity);
        }
    }

    protected static synchronized void clearTaskExcept(BaseActivity baseActivity) {
        synchronized (BaseActivity.class) {
            Iterator<BaseActivity> it = mActivityStack.iterator();
            while (it.hasNext()) {
                BaseActivity next = it.next();
                if (next != baseActivity) {
                    next.finish();
                }
            }
        }
    }

    protected static void addLiveActivityNum() {
        mLiveActivityNum++;
    }

    protected static void decLiveActivityNum() {
        mLiveActivityNum--;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mMultiWindowTips = getResources().getString(R.string.pass_bio_multi_window_tips);
        addToTask(this);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        addLiveActivityNum();
        this.mIsActivityInForeground = true;
        showMultiWindowTips();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @TargetApi(5)
    public void onBackPressedWithoutAnim() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        decLiveActivityNum();
        this.mIsActivityInForeground = false;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        removeFromTask(this);
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
    public void finish() {
        super.finish();
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        startActivityForResult(intent, -1);
    }

    public void startActivityForResult(Class<?> cls, int i) {
        startActivityForResult(new Intent(this, cls), i);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        super.startActivityForResult(intent, i);
    }

    public void startActivityForResultWithoutAnim(Intent intent, int i) {
        super.startActivityForResult(intent, i);
    }

    public void startActivityWithExtras(Bundle bundle, Class<?> cls) {
        startActivityWithExtras(bundle, cls, true);
    }

    public void startActivityWithExtras(Bundle bundle, Class<?> cls, boolean z) {
        if (bundle == null) {
            bundle = getIntent().getExtras();
        }
        Intent intent = new Intent(getActivity(), cls);
        intent.putExtras(bundle);
        if (z) {
            startActivity(intent);
        } else {
            startActivityWithoutAnim(intent);
        }
    }

    public void startActivity(Class<?> cls) {
        startActivityForResult(new Intent(getActivity(), cls), -1);
    }

    public void startActivityWithoutAnim(Intent intent) {
        super.startActivityForResult(intent, -1);
    }

    public void finishWithoutAnim() {
        super.finish();
    }

    public void setFlagPaySdk() {
        this.mFlag = 1;
    }

    protected ArrayList<String> getHandlerFailureData(int i, int i2, String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        String str2 = "";
        String str3 = "";
        try {
            str2 = String.valueOf(i);
            str3 = String.valueOf(i2);
        } catch (Exception e) {
        }
        arrayList.add(str2);
        arrayList.add(str3);
        arrayList.add(str);
        return arrayList;
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
