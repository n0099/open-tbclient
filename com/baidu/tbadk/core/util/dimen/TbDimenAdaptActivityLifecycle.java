package com.baidu.tbadk.core.util.dimen;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDefaultMetrics = displayMetrics;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) {
            String simpleName = activity.getClass().getSimpleName();
            if (this.mDefaultMetrics != null) {
                if (!"ImageViewerActivity".equalsIgnoreCase(simpleName) && !"LiveShowActivity".equalsIgnoreCase(simpleName) && !"AlaMasterLiveRoomActivity".equalsIgnoreCase(simpleName) && !"AlaGiftTabActivity".equalsIgnoreCase(simpleName) && !"LiveListActivity".equalsIgnoreCase(simpleName) && !"YuyinLivePlayerActivity".equalsIgnoreCase(simpleName) && !"YuyinAlaCreateLiveRoomActivity".equalsIgnoreCase(simpleName)) {
                    TbDimenManager.getInstance().adaptDimen(activity);
                    return;
                }
                TbDimenManager tbDimenManager = TbDimenManager.getInstance();
                DisplayMetrics displayMetrics = this.mDefaultMetrics;
                tbDimenManager.adaptDimen(activity, displayMetrics.density, displayMetrics.densityDpi);
                return;
            }
            TbDimenManager.getInstance().adaptDimen(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, activity, bundle) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
            String simpleName = activity.getClass().getSimpleName();
            if (this.mDefaultMetrics != null) {
                if (!"ImageViewerActivity".equalsIgnoreCase(simpleName) && !"LiveShowActivity".equalsIgnoreCase(simpleName) && !"AlaMasterLiveRoomActivity".equalsIgnoreCase(simpleName) && !"AlaGiftTabActivity".equalsIgnoreCase(simpleName) && !"LiveListActivity".equalsIgnoreCase(simpleName) && !"YuyinLivePlayerActivity".equalsIgnoreCase(simpleName) && !"YuyinAlaCreateLiveRoomActivity".equalsIgnoreCase(simpleName)) {
                    TbDimenManager.getInstance().adaptDimen(activity);
                    return;
                }
                TbDimenManager tbDimenManager = TbDimenManager.getInstance();
                DisplayMetrics displayMetrics = this.mDefaultMetrics;
                tbDimenManager.adaptDimen(activity, displayMetrics.density, displayMetrics.densityDpi);
                return;
            }
            TbDimenManager.getInstance().adaptDimen(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
        }
    }
}
