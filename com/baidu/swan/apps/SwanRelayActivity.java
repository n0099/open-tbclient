package com.baidu.swan.apps;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class SwanRelayActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SwanRelayActivity() {
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

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        ActivityManager activityManager;
        List<ActivityManager.AppTask> appTasks;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            int intExtra = getIntent().getIntExtra("key_task_id", 0);
            if (intExtra > 0 && (activityManager = (ActivityManager) getSystemService("activity")) != null && (appTasks = activityManager.getAppTasks()) != null && !appTasks.isEmpty()) {
                Iterator<ActivityManager.AppTask> it = appTasks.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.AppTask next = it.next();
                    if (next != null && next.getTaskInfo() != null && next.getTaskInfo().id == intExtra) {
                        next.moveToFront();
                        break;
                    }
                }
            }
            finish();
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            if (!isFinishing() && !isDestroyed()) {
                finish();
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }
}
