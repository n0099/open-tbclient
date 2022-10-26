package com.baidu.live.arch.utils;

import android.app.Activity;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.LiveGetHostActivitiesService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class LiveActivityHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MEDIA_ACTIVITY_NAME = "com.baidu.searchbox.live.list.LiveListActivity";
    public static final String MIX_ACTIVITY_NAME = "com.baidu.searchbox.live.list.MixLiveActivity";
    public static final String MIX_TRANSLUCENT_ACTIVITY_NAME = "com.baidu.searchbox.live.list.MixLiveTranslucentActivity";
    public transient /* synthetic */ FieldHolder $fh;

    public LiveActivityHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean isLiveActivity(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, activity)) == null) {
            if (activity != null) {
                String className = activity.getComponentName().getClassName();
                if (MEDIA_ACTIVITY_NAME.equals(className) || MIX_ACTIVITY_NAME.equals(className) || MIX_TRANSLUCENT_ACTIVITY_NAME.equals(className)) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isOnlyOneLiveActivity() {
        InterceptResult invokeV;
        List allActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            LiveGetHostActivitiesService liveGetHostActivitiesService = (LiveGetHostActivitiesService) ServiceManager.getService(LiveGetHostActivitiesService.Companion.getSERVICE_REFERENCE());
            if (liveGetHostActivitiesService == null || (allActivity = liveGetHostActivitiesService.getAllActivity()) == null || allActivity.isEmpty() || allActivity.size() != 1 || !isLiveActivity((Activity) allActivity.get(0))) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
