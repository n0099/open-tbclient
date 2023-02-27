package com.baidu.live.arch.utils;

import android.app.Activity;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.LiveGetHostActivitiesService;
import java.util.List;
/* loaded from: classes2.dex */
public class LiveActivityHelper {
    public static final String MEDIA_ACTIVITY_NAME = "com.baidu.searchbox.live.list.LiveListActivity";
    public static final String MIX_ACTIVITY_NAME = "com.baidu.searchbox.live.list.MixLiveActivity";
    public static final String MIX_TRANSLUCENT_ACTIVITY_NAME = "com.baidu.searchbox.live.list.MixLiveTranslucentActivity";

    public static boolean isOnlyOneLiveActivity() {
        List<Activity> allActivity;
        LiveGetHostActivitiesService liveGetHostActivitiesService = (LiveGetHostActivitiesService) ServiceManager.getService(LiveGetHostActivitiesService.Companion.getSERVICE_REFERENCE());
        if (liveGetHostActivitiesService == null || (allActivity = liveGetHostActivitiesService.getAllActivity()) == null || allActivity.isEmpty() || allActivity.size() != 1 || !isLiveActivity(allActivity.get(0))) {
            return false;
        }
        return true;
    }

    public static boolean isLiveActivity(Activity activity) {
        if (activity != null) {
            String className = activity.getComponentName().getClassName();
            if (MEDIA_ACTIVITY_NAME.equals(className) || MIX_ACTIVITY_NAME.equals(className) || MIX_TRANSLUCENT_ACTIVITY_NAME.equals(className)) {
                return true;
            }
            return false;
        }
        return false;
    }
}
