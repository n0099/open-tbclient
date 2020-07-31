package com.baidu.searchbox.suspension.activity;

import android.app.Activity;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class SuspensionViewManager {
    private static SuspensionViewManager sInstance;
    private HashMap<String, SuspensionViewAdapter> mSuspensionViewAdapters = new HashMap<>();

    public static final SuspensionViewManager getInstance() {
        if (sInstance == null) {
            synchronized (SuspensionViewManager.class) {
                if (sInstance == null) {
                    sInstance = new SuspensionViewManager();
                }
            }
        }
        return sInstance;
    }

    private SuspensionViewManager() {
    }

    public void addSuspensionView(String str, SuspensionViewAdapter suspensionViewAdapter) {
        SuspensionViewAdapter suspensionViewAdapter2 = this.mSuspensionViewAdapters.get(str);
        if (suspensionViewAdapter2 != null) {
            suspensionViewAdapter2.removeView();
        }
        this.mSuspensionViewAdapters.put(str, suspensionViewAdapter);
    }

    public void addAndShowSuspensionView(Activity activity, String str, SuspensionViewAdapter suspensionViewAdapter) {
        SuspensionViewAdapter suspensionViewAdapter2 = this.mSuspensionViewAdapters.get(str);
        if (suspensionViewAdapter2 != null) {
            suspensionViewAdapter2.removeView();
        }
        this.mSuspensionViewAdapters.put(str, suspensionViewAdapter);
        if (activity != null && !isActivityFinish(activity)) {
            suspensionViewAdapter.showView(activity);
        }
    }

    public void removeSuspensionView(String str) {
        SuspensionViewAdapter remove = this.mSuspensionViewAdapters.remove(str);
        if (remove != null) {
            remove.removeView();
        }
    }

    public void onActivityResume(Activity activity) {
        for (SuspensionViewAdapter suspensionViewAdapter : this.mSuspensionViewAdapters.values()) {
            suspensionViewAdapter.removeView();
            if (!suspensionViewAdapter.filterActivity(activity)) {
                suspensionViewAdapter.showView(activity);
            } else {
                return;
            }
        }
    }

    private boolean isActivityFinish(Activity activity) {
        return activity.isDestroyed() || activity.isFinishing();
    }
}
