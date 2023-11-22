package com.baidu.tbadk.BdToken;

import android.app.Activity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskToastData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.mutiprocess.MutiProcessManager;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.e05;
import com.baidu.tieba.lo4;
import com.baidu.tieba.mp4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class MutiProcessMissionHelper {
    public static /* synthetic */ Interceptable $ic;
    public static View.OnClickListener mOnClickListener;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            TbPageContext<?> currentActivityPageContext;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Object tag = view2.getTag();
                if (tag instanceof CompleteTaskToastData) {
                    CompleteTaskToastData completeTaskToastData = (CompleteTaskToastData) tag;
                    if (TextUtils.isEmpty(completeTaskToastData.url) || (currentActivityPageContext = MutiProcessMissionHelper.getCurrentActivityPageContext()) == null) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(currentActivityPageContext, new String[]{completeTaskToastData.url});
                    mp4.b(completeTaskToastData.activityId, completeTaskToastData.missionId);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1303697480, "Lcom/baidu/tbadk/BdToken/MutiProcessMissionHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1303697480, "Lcom/baidu/tbadk/BdToken/MutiProcessMissionHelper;");
                return;
            }
        }
        mOnClickListener = new a();
    }

    public MutiProcessMissionHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean isMainProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return TbadkCoreApplication.getInst().isMainProcess(true);
        }
        return invokeV.booleanValue;
    }

    public static void behaviorTiebaMotionEvent(MotionEvent motionEvent, int i, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{motionEvent, Integer.valueOf(i), Long.valueOf(j)}) == null) && motionEvent != null && motionEvent.getAction() == 0) {
            refreshTouchTimeMission(i, j);
        }
    }

    public static void dispatchMutiProcessMessage(int i, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i), Long.valueOf(j), str}) == null) {
            MissionEvent missionEvent = new MissionEvent();
            missionEvent.tid = j;
            missionEvent.pageId = i;
            missionEvent.actionType = str;
            MutiProcessManager.publishEvent(missionEvent);
        }
    }

    public static void startThreadBrowseTimeMission(int i, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            if (isMainProcess()) {
                lo4.w().Q(i, j);
            } else {
                dispatchMutiProcessMessage(i, i2, j, "onResume");
            }
        }
    }

    public static void dispatchMutiProcessMessage(int i, int i2, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), str}) == null) {
            MissionEvent missionEvent = new MissionEvent();
            missionEvent.tid = j;
            missionEvent.pageId = i2;
            missionEvent.pageType = i;
            missionEvent.actionType = str;
            MutiProcessManager.publishEvent(missionEvent);
        }
    }

    public static TbPageContext getCurrentActivityPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof BaseActivity) {
                return ((BaseActivity) currentActivity).getPageContext();
            }
            if (currentActivity instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) currentActivity).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public static void pauseBrowseTimeMission(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            if (isMainProcess()) {
                lo4.w().E();
            } else {
                dispatchMutiProcessMessage(i, j, MissionEvent.MESSAGE_PAUSE);
            }
        }
    }

    public static void refreshTouchTimeMission(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            if (isMainProcess()) {
                lo4.w().F();
            } else {
                dispatchMutiProcessMessage(i, j, MissionEvent.MESSAGE_TOUCH);
            }
        }
    }

    public static void setCurrentActivityTid(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            if (isMainProcess()) {
                lo4.w().L(i, j);
            } else {
                dispatchMutiProcessMessage(i, j, MissionEvent.MESSAGE_ACTIVITY);
            }
        }
    }

    public static e05 showCompleteTaskToast(CompleteTaskToastData completeTaskToastData) {
        InterceptResult invokeL;
        TbPageContext currentActivityPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, completeTaskToastData)) == null) {
            if (completeTaskToastData == null || (currentActivityPageContext = getCurrentActivityPageContext()) == null || currentActivityPageContext.getUniqueId() == null || completeTaskToastData.pageId != currentActivityPageContext.getUniqueId().getId()) {
                return null;
            }
            e05 f = e05.f(currentActivityPageContext.getPageActivity(), completeTaskToastData.message);
            f.g(completeTaskToastData.duration);
            f.h(mOnClickListener);
            f.i(completeTaskToastData);
            f.k();
            return f;
        }
        return (e05) invokeL.objValue;
    }
}
