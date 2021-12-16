package c.a.r0.a;

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
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class s {
    public static /* synthetic */ Interceptable $ic;
    public static View.OnClickListener a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbPageContext<?> d2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Object tag = view.getTag();
                if (tag instanceof CompleteTaskToastData) {
                    CompleteTaskToastData completeTaskToastData = (CompleteTaskToastData) tag;
                    if (TextUtils.isEmpty(completeTaskToastData.url) || (d2 = s.d()) == null) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(d2, new String[]{completeTaskToastData.url});
                    c.a.r0.a.d0.c.b(completeTaskToastData.activityId, completeTaskToastData.missionId);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-635342367, "Lc/a/r0/a/s;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-635342367, "Lc/a/r0/a/s;");
                return;
            }
        }
        a = new a();
    }

    public static void a(MotionEvent motionEvent, int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{motionEvent, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && motionEvent != null && motionEvent.getAction() == 0) {
            g(i2, j2);
        }
    }

    public static void b(int i2, int i3, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), str}) == null) {
            MissionEvent missionEvent = new MissionEvent();
            missionEvent.tid = j2;
            missionEvent.pageId = i3;
            missionEvent.pageType = i2;
            missionEvent.actionType = str;
            c.a.r0.k0.h.i(missionEvent);
        }
    }

    public static void c(int i2, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str}) == null) {
            MissionEvent missionEvent = new MissionEvent();
            missionEvent.tid = j2;
            missionEvent.pageId = i2;
            missionEvent.actionType = str;
            c.a.r0.k0.h.i(missionEvent);
        }
    }

    public static TbPageContext d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
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

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? TbadkCoreApplication.getInst().isMainProcess(true) : invokeV.booleanValue;
    }

    public static void f(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            if (e()) {
                d.y().G();
            } else {
                c(i2, j2, MissionEvent.MESSAGE_PAUSE);
            }
        }
    }

    public static void g(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            if (e()) {
                d.y().H();
            } else {
                c(i2, j2, MissionEvent.MESSAGE_TOUCH);
            }
        }
    }

    public static void h(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            if (e()) {
                d.y().M(i2, j2);
            } else {
                c(i2, j2, MissionEvent.MESSAGE_ACTIVITY);
            }
        }
    }

    public static c.a.r0.s.t.e i(CompleteTaskToastData completeTaskToastData) {
        InterceptResult invokeL;
        TbPageContext d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, completeTaskToastData)) == null) {
            if (completeTaskToastData == null || (d2 = d()) == null || d2.getUniqueId() == null || completeTaskToastData.pageId != d2.getUniqueId().getId()) {
                return null;
            }
            c.a.r0.s.t.e f2 = c.a.r0.s.t.e.f(d2.getPageActivity(), completeTaskToastData.message);
            f2.g(completeTaskToastData.duration);
            f2.h(a);
            f2.i(completeTaskToastData);
            f2.j();
            return f2;
        }
        return (c.a.r0.s.t.e) invokeL.objValue;
    }

    public static void j(int i2, int i3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            if (e()) {
                d.y().R(i2, j2);
            } else {
                b(i2, i3, j2, "onResume");
            }
        }
    }
}
