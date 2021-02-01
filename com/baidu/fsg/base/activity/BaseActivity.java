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
/* loaded from: classes5.dex */
public class BaseActivity extends Activity implements NoProguard {
    public static final int DIALOG_LOADING = 242;
    public static final int DIALOG_PROMPT = 241;
    protected static final int FLAG_PAY_SKD = 1;
    public static final String WITH_ANIM = "with_anim";

    /* renamed from: a  reason: collision with root package name */
    private static final String f1865a = "BaseActivity";

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f1866b = false;
    private long h;
    protected RimStatisticsUtil mStatUtil;
    public static LinkedList<BaseActivity> mActivityStack = new LinkedList<>();
    public static int mLiveActivityNum = 0;
    public static final String MULTI_WINDOW_TIPS = ResUtils.string("multi_window_tips");
    public static final String MULTI_WINDOW_TIPS_CLOSE = ResUtils.string("multi_window_tips_close");
    public int mFlag = -1;
    private boolean c = false;
    private boolean d = true;
    private String e = MULTI_WINDOW_TIPS;
    private SafeScrollView f = null;
    private boolean g = false;

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

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case DIALOG_LOADING /* 242 */:
                return new com.baidu.fsg.base.activity.a.a(this);
            default:
                return super.onCreateDialog(i);
        }
    }

    protected static synchronized void clearTasksWithFlag(int i) {
        synchronized (BaseActivity.class) {
            LogUtil.d(f1865a, "clearTasksWithFlag. stack size = " + mActivityStack.size());
            Iterator<BaseActivity> it = mActivityStack.iterator();
            while (it.hasNext()) {
                BaseActivity next = it.next();
                if (next.mFlag == i) {
                    next.finish();
                    next.overridePendingTransition(0, 0);
                }
            }
        }
    }

    protected static synchronized void clearTasksTopOf(BaseActivity baseActivity) {
        synchronized (BaseActivity.class) {
            LogUtil.d(f1865a, "clearTasksTopOf. stack size = " + mActivityStack.size());
            for (int size = mActivityStack.size() - 1; size > 0; size--) {
                BaseActivity baseActivity2 = mActivityStack.get(size);
                if (baseActivity2 == baseActivity) {
                    break;
                }
                baseActivity2.finish();
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
        this.h = System.currentTimeMillis();
        this.mStatUtil = RimStatisticsUtil.getInstance();
        RimStatisticsUtil.onPush(getClass().getSimpleName());
        if (isRequestedOrientation()) {
            setRequestedOrientation(1);
        }
        super.onCreate(bundle);
        LogUtil.e("debug_msg", "onCreate-----" + getClass().getName(), null);
        addToTask(this);
    }

    protected boolean isRequestedOrientation() {
        return true;
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        addLiveActivityNum();
        this.g = true;
        if (0 != this.h) {
            RimStatisticsUtil.onIn(getClass().getSimpleName(), System.currentTimeMillis() - this.h);
            this.h = 0L;
        } else {
            RimStatisticsUtil.onIn(getClass().getSimpleName(), 0L);
        }
        a();
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
    public void onPause() {
        super.onPause();
        decLiveActivityNum();
        this.g = false;
        RimStatisticsUtil.onOut(getClass().getSimpleName());
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        removeFromTask(this);
        RimStatisticsUtil.onBack(getClass().getSimpleName());
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82 && keyEvent.isLongPress()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if ("1".equals(BeanConstants.ANIMSTYLE)) {
            RimAnimUtils.finishActivityAnim(getActivity());
        }
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
        if ("1".equals(BeanConstants.ANIMSTYLE)) {
            RimAnimUtils.startActivityAnim(getActivity());
        }
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
        return this.g;
    }

    @Override // android.app.Activity
    @TargetApi(24)
    public void onMultiWindowModeChanged(boolean z) {
        if (Build.VERSION.SDK_INT >= 24) {
            super.onMultiWindowModeChanged(z);
            if (this.f != null) {
                this.f.dismissKeyBoard();
            }
            if (z && isActivityInForeground()) {
                if (this.c) {
                    RimGlobalUtils.toastWithText(getActivity(), this.e, 1);
                }
                if (!this.d) {
                    finish();
                }
            }
        }
    }

    public Activity getActivity() {
        return this;
    }

    @TargetApi(24)
    private void a() {
        if (Build.VERSION.SDK_INT >= 24 && isInMultiWindowMode()) {
            if (this.c) {
                RimGlobalUtils.toastWithText(getActivity(), this.e, 1);
            }
            if (!this.d) {
                finish();
            }
        }
    }

    protected void setIsShowMultiWindowTips(boolean z) {
        if (z != this.c) {
            this.c = z;
        }
    }

    protected void setIsMultiWindowAvailable(boolean z) {
        if (z != this.d) {
            this.d = z;
        }
    }

    protected void setMultiWindowTipsId(String str) {
        this.e = str;
    }

    protected void setSafeScrollView(SafeScrollView safeScrollView) {
        this.f = safeScrollView;
    }
}
