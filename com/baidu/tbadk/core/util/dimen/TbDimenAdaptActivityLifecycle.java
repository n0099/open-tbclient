package com.baidu.tbadk.core.util.dimen;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class TbDimenAdaptActivityLifecycle implements Application.ActivityLifecycleCallbacks {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final DisplayMetrics mDefaultMetrics;

    public TbDimenAdaptActivityLifecycle(DisplayMetrics displayMetrics) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {displayMetrics};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDefaultMetrics = displayMetrics;
    }

    public boolean isActivityNeedAdapte(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, activity)) == null) {
            if (activity != null && activity.getClass() != null) {
                String simpleName = activity.getClass().getSimpleName();
                if (!"ImageViewerActivity".equalsIgnoreCase(simpleName) && !"LiveShowActivity".equalsIgnoreCase(simpleName) && !"AlaMasterLiveRoomActivity".equalsIgnoreCase(simpleName) && !"AlaGiftTabActivity".equalsIgnoreCase(simpleName) && !"LiveListActivity".equalsIgnoreCase(simpleName) && !"YuyinLivePlayerActivity".equalsIgnoreCase(simpleName) && !"YuyinAlaCreateLiveRoomActivity".equalsIgnoreCase(simpleName)) {
                    String canonicalName = activity.getClass().getCanonicalName();
                    if (TextUtils.isEmpty(canonicalName)) {
                        return false;
                    }
                    return canonicalName.contains("com.baidu.tieba") || canonicalName.contains("com.baidu.tbadk");
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, bundle) == null) {
            reDimenActivity(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, activity, bundle) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
            reDimenActivity(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, activity) == null) {
        }
    }

    public void reDimenActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity) == null) {
            if (isActivityNeedAdapte(activity)) {
                TbDimenManager.getInstance().adaptDimen(activity);
            } else if (this.mDefaultMetrics != null) {
                TbDimenManager tbDimenManager = TbDimenManager.getInstance();
                DisplayMetrics displayMetrics = this.mDefaultMetrics;
                tbDimenManager.adaptDimen(activity, displayMetrics.density, displayMetrics.densityDpi);
            } else {
                TbDimenManager.getInstance().adaptDimen(activity);
            }
        }
    }
}
