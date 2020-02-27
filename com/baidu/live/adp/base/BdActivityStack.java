package com.baidu.live.adp.base;

import android.app.Activity;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public final class BdActivityStack {
    private static ArrayList<SoftReference<Activity>> sActivityStack;
    private static BdActivityStack sInstance;
    private OnAllActivityClosed mActivityClosed;
    private int mActivityStackMaxSize = 0;

    /* loaded from: classes3.dex */
    public interface OnAllActivityClosed {
        void onActivityClosed();
    }

    public void setOnActivityAllClosed(OnAllActivityClosed onAllActivityClosed) {
        this.mActivityClosed = onAllActivityClosed;
    }

    private BdActivityStack() {
        if (sActivityStack == null) {
            sActivityStack = new ArrayList<>(20);
        }
    }

    public static BdActivityStack getInst() {
        if (sInstance == null) {
            sInstance = new BdActivityStack();
        }
        return sInstance;
    }

    public int getSize() {
        return sActivityStack.size();
    }

    public void pushActivity(Activity activity) {
        if (activity != null) {
            sActivityStack.add(new SoftReference<>(activity));
            checkAndMaintainActivityStack(this.mActivityStackMaxSize);
        }
    }

    public Activity popActivity() {
        SoftReference<Activity> remove;
        int size = sActivityStack.size();
        if (size != 0 && (remove = sActivityStack.remove(size - 1)) != null) {
            return remove.get();
        }
        return null;
    }

    public Activity popActivity(int i) {
        int size = sActivityStack.size();
        if (size == 0) {
            return null;
        }
        if (i < 0 || i >= size) {
            return null;
        }
        SoftReference<Activity> remove = sActivityStack.remove(i);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    public void popActivity(Activity activity) {
        if (activity != null) {
            int size = sActivityStack.size();
            if (size == 0) {
                if (this.mActivityClosed != null) {
                    this.mActivityClosed.onActivityClosed();
                    return;
                }
                return;
            }
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = sActivityStack.get(i);
                if (softReference == null) {
                    sActivityStack.remove(i);
                } else if (activity.equals(softReference.get())) {
                    sActivityStack.remove(i);
                    if (sActivityStack.size() == 0 && this.mActivityClosed != null) {
                        this.mActivityClosed.onActivityClosed();
                        return;
                    }
                    return;
                } else if (sActivityStack.size() == 0 && this.mActivityClosed != null) {
                    this.mActivityClosed.onActivityClosed();
                }
            }
        }
    }

    public Activity currentActivity() {
        SoftReference<Activity> softReference;
        int size = sActivityStack.size();
        if (size != 0 && (softReference = sActivityStack.get(size - 1)) != null) {
            return softReference.get();
        }
        return null;
    }

    public void setActivityStackMaxSize(int i) {
        if (i >= 10 || i == 0) {
            this.mActivityStackMaxSize = i;
        }
    }

    public void releaseAllPossibleAcitivities() {
        checkAndMaintainActivityStack(3);
    }

    public void releaseAllAcitivities() {
        Activity activity;
        if (sActivityStack != null) {
            while (!sActivityStack.isEmpty()) {
                SoftReference<Activity> remove = sActivityStack.remove(0);
                if (remove != null && remove.get() != null && (activity = remove.get()) != null) {
                    activity.finish();
                }
            }
        }
        if (this.mActivityClosed != null) {
            this.mActivityClosed.onActivityClosed();
        }
    }

    public int getActivityStackMaxSize() {
        return this.mActivityStackMaxSize;
    }

    private void checkAndMaintainActivityStack(int i) {
        if (i != 0) {
            int size = getInst().getSize();
            while (size > i) {
                size--;
                Activity popActivity = getInst().popActivity(1);
                if (popActivity != null) {
                    popActivity.finish();
                }
            }
        }
    }
}
