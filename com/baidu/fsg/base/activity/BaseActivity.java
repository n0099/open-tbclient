package com.baidu.fsg.base.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.fsg.base.NoProguard;
import com.baidu.fsg.base.restnet.beans.business.BeanConstants;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.base.utils.ResUtils;
import com.baidu.fsg.base.utils.RimAnimUtils;
import com.baidu.fsg.base.utils.RimGlobalUtils;
import com.baidu.fsg.base.widget.SafeScrollView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class BaseActivity extends Activity implements NoProguard {
    public static final int DIALOG_LOADING = 242;
    public static final int DIALOG_PROMPT = 241;
    public static final int FLAG_PAY_SKD = 1;
    public static final String WITH_ANIM = "with_anim";

    /* renamed from: a  reason: collision with root package name */
    public static final String f5092a = "BaseActivity";

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f5093b = false;

    /* renamed from: h  reason: collision with root package name */
    public long f5099h;
    public RimStatisticsUtil mStatUtil;
    public static LinkedList<BaseActivity> mActivityStack = new LinkedList<>();
    public static int mLiveActivityNum = 0;
    public static final String MULTI_WINDOW_TIPS = ResUtils.string("multi_window_tips");
    public static final String MULTI_WINDOW_TIPS_CLOSE = ResUtils.string("multi_window_tips_close");
    public int mFlag = -1;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5094c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5095d = true;

    /* renamed from: e  reason: collision with root package name */
    public String f5096e = MULTI_WINDOW_TIPS;

    /* renamed from: f  reason: collision with root package name */
    public SafeScrollView f5097f = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5098g = false;

    @TargetApi(24)
    private void a() {
        if (Build.VERSION.SDK_INT < 24 || !isInMultiWindowMode()) {
            return;
        }
        if (this.f5094c) {
            RimGlobalUtils.toastWithText(getActivity(), this.f5096e, 1);
        }
        if (this.f5095d) {
            return;
        }
        finish();
    }

    public static void addLiveActivityNum() {
        mLiveActivityNum++;
    }

    public static synchronized void addToTask(BaseActivity baseActivity) {
        synchronized (BaseActivity.class) {
            mActivityStack.remove(baseActivity);
            mActivityStack.add(baseActivity);
        }
    }

    public static synchronized void clearTask() {
        synchronized (BaseActivity.class) {
            Iterator<BaseActivity> it = mActivityStack.iterator();
            while (it.hasNext()) {
                it.next().finish();
            }
        }
    }

    public static synchronized void clearTaskExcept(BaseActivity baseActivity) {
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

    public static synchronized void clearTasksTopOf(BaseActivity baseActivity) {
        synchronized (BaseActivity.class) {
            LogUtil.d("BaseActivity", "clearTasksTopOf. stack size = " + mActivityStack.size());
            for (int size = mActivityStack.size() + (-1); size > 0; size--) {
                BaseActivity baseActivity2 = mActivityStack.get(size);
                if (baseActivity2 == baseActivity) {
                    break;
                }
                baseActivity2.finish();
            }
        }
    }

    public static synchronized void clearTasksWithFlag(int i2) {
        synchronized (BaseActivity.class) {
            LogUtil.d("BaseActivity", "clearTasksWithFlag. stack size = " + mActivityStack.size());
            Iterator<BaseActivity> it = mActivityStack.iterator();
            while (it.hasNext()) {
                BaseActivity next = it.next();
                if (next.mFlag == i2) {
                    next.finish();
                    next.overridePendingTransition(0, 0);
                }
            }
        }
    }

    public static void decLiveActivityNum() {
        mLiveActivityNum--;
    }

    public static BaseActivity getTopActivity() throws Throwable {
        return mActivityStack.getLast();
    }

    public static boolean isAppInForeground() {
        return mLiveActivityNum > 0;
    }

    public static synchronized void removeFromTask(BaseActivity baseActivity) {
        synchronized (BaseActivity.class) {
            mActivityStack.remove(baseActivity);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if ("1".equals(BeanConstants.ANIMSTYLE)) {
            RimAnimUtils.finishActivityAnim(getActivity());
        }
    }

    public void finishWithoutAnim() {
        super.finish();
    }

    public Activity getActivity() {
        return this;
    }

    public ArrayList<String> getHandlerFailureData(int i2, int i3, String str) {
        String str2;
        String str3 = "";
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            str2 = String.valueOf(i2);
            try {
                str3 = String.valueOf(i3);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            str2 = "";
        }
        arrayList.add(str2);
        arrayList.add(str3);
        arrayList.add(str);
        return arrayList;
    }

    public boolean isActivityInForeground() {
        return this.f5098g;
    }

    public boolean isRequestedOrientation() {
        return true;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if ("1".equals(BeanConstants.ANIMSTYLE)) {
            RimAnimUtils.finishActivityAnim(getActivity());
        }
    }

    public void onBackPressedWithoutAnim() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        this.f5099h = System.currentTimeMillis();
        this.mStatUtil = RimStatisticsUtil.getInstance();
        RimStatisticsUtil.onPush(getClass().getSimpleName());
        if (isRequestedOrientation()) {
            setRequestedOrientation(1);
        }
        super.onCreate(bundle);
        LogUtil.e("debug_msg", "onCreate-----" + getClass().getName(), null);
        addToTask(this);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        if (i2 != 242) {
            return super.onCreateDialog(i2);
        }
        return new com.baidu.fsg.base.activity.a.a(this);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        removeFromTask(this);
        RimStatisticsUtil.onBack(getClass().getSimpleName());
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
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
            SafeScrollView safeScrollView = this.f5097f;
            if (safeScrollView != null) {
                safeScrollView.dismissKeyBoard();
            }
            if (z && isActivityInForeground()) {
                if (this.f5094c) {
                    RimGlobalUtils.toastWithText(getActivity(), this.f5096e, 1);
                }
                if (this.f5095d) {
                    return;
                }
                finish();
            }
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        decLiveActivityNum();
        this.f5098g = false;
        RimStatisticsUtil.onOut(getClass().getSimpleName());
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        addLiveActivityNum();
        this.f5098g = true;
        if (0 != this.f5099h) {
            RimStatisticsUtil.onIn(getClass().getSimpleName(), System.currentTimeMillis() - this.f5099h);
            this.f5099h = 0L;
        } else {
            RimStatisticsUtil.onIn(getClass().getSimpleName(), 0L);
        }
        a();
    }

    public void setFlagPaySdk() {
        this.mFlag = 1;
    }

    public void setIsMultiWindowAvailable(boolean z) {
        if (z != this.f5095d) {
            this.f5095d = z;
        }
    }

    public void setIsShowMultiWindowTips(boolean z) {
        if (z != this.f5094c) {
            this.f5094c = z;
        }
    }

    public void setMultiWindowTipsId(String str) {
        this.f5096e = str;
    }

    public void setSafeScrollView(SafeScrollView safeScrollView) {
        this.f5097f = safeScrollView;
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        startActivityForResult(intent, -1);
    }

    public void startActivityForResult(Class<?> cls, int i2) {
        startActivityForResult(new Intent(this, cls), i2);
    }

    public void startActivityForResultWithoutAnim(Intent intent, int i2) {
        super.startActivityForResult(intent, i2);
    }

    public void startActivityWithExtras(Bundle bundle, Class<?> cls) {
        startActivityWithExtras(bundle, cls, true);
    }

    public void startActivityWithoutAnim(Intent intent) {
        super.startActivityForResult(intent, -1);
    }

    public void startActivity(Class<?> cls) {
        startActivityForResult(new Intent(getActivity(), cls), -1);
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

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i2) {
        super.startActivityForResult(intent, i2);
        if ("1".equals(BeanConstants.ANIMSTYLE)) {
            RimAnimUtils.startActivityAnim(getActivity());
        }
    }
}
