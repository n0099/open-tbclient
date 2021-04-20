package com.baidu.apollon.base;

import android.app.Activity;
import android.os.Bundle;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.utils.LogUtil;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ApollonBaseActivity extends Activity implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3546a = "ApollonBaseActivity";
    public static LinkedList<ApollonBaseActivity> mActivityStack = new LinkedList<>();
    public static int mLiveActivityNum = 0;
    public int mFlag = -1;

    public static void addLiveActivityNum() {
        mLiveActivityNum++;
    }

    public static synchronized void addToTask(ApollonBaseActivity apollonBaseActivity) {
        synchronized (ApollonBaseActivity.class) {
            mActivityStack.remove(apollonBaseActivity);
            mActivityStack.add(apollonBaseActivity);
        }
    }

    public static synchronized void clearTask() {
        synchronized (ApollonBaseActivity.class) {
            Iterator<ApollonBaseActivity> it = mActivityStack.iterator();
            while (it.hasNext()) {
                it.next().finish();
            }
        }
    }

    public static synchronized void clearTaskExcept(ApollonBaseActivity apollonBaseActivity) {
        synchronized (ApollonBaseActivity.class) {
            Iterator<ApollonBaseActivity> it = mActivityStack.iterator();
            while (it.hasNext()) {
                ApollonBaseActivity next = it.next();
                if (next != apollonBaseActivity) {
                    next.finish();
                }
            }
        }
    }

    public static synchronized void clearTasksTopOf(ApollonBaseActivity apollonBaseActivity) {
        synchronized (ApollonBaseActivity.class) {
            LogUtil.d(f3546a, "clearTasksTopOf. stack size = " + mActivityStack.size());
            for (int size = mActivityStack.size() + (-1); size > 0; size--) {
                ApollonBaseActivity apollonBaseActivity2 = mActivityStack.get(size);
                if (apollonBaseActivity2 == apollonBaseActivity) {
                    break;
                }
                apollonBaseActivity2.finish();
            }
        }
    }

    public static synchronized void clearTasksWithFlag(int i) {
        synchronized (ApollonBaseActivity.class) {
            LogUtil.d(f3546a, "clearTasksWithFlag. stack size = " + mActivityStack.size());
            Iterator<ApollonBaseActivity> it = mActivityStack.iterator();
            while (it.hasNext()) {
                ApollonBaseActivity next = it.next();
                if (next.mFlag == i) {
                    next.finish();
                    next.overridePendingTransition(0, 0);
                }
            }
        }
    }

    public static void decLiveActivityNum() {
        mLiveActivityNum--;
    }

    public static ApollonBaseActivity getTopActivity() throws Throwable {
        return mActivityStack.getLast();
    }

    public static boolean isAppInForeground() {
        return mLiveActivityNum > 0;
    }

    public static synchronized void removeFromTask(ApollonBaseActivity apollonBaseActivity) {
        synchronized (ApollonBaseActivity.class) {
            mActivityStack.remove(apollonBaseActivity);
        }
    }

    public Activity getActivity() {
        return this;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addToTask(this);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        removeFromTask(this);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        decLiveActivityNum();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        addLiveActivityNum();
    }
}
