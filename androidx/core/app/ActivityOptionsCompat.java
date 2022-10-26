package androidx.core.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ActivityOptionsCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_USAGE_TIME_REPORT = "android.activity.usage_time";
    public static final String EXTRA_USAGE_TIME_REPORT_PACKAGES = "android.usage_time_packages";
    public transient /* synthetic */ FieldHolder $fh;

    public Rect getLaunchBounds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (Rect) invokeV.objValue;
    }

    public void requestUsageTimeReport(PendingIntent pendingIntent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pendingIntent) == null) {
        }
    }

    public ActivityOptionsCompat setLaunchBounds(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rect)) == null) ? this : (ActivityOptionsCompat) invokeL.objValue;
    }

    public Bundle toBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (Bundle) invokeV.objValue;
    }

    public void update(ActivityOptionsCompat activityOptionsCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activityOptionsCompat) == null) {
        }
    }

    /* loaded from: classes.dex */
    public static class ActivityOptionsCompatImpl extends ActivityOptionsCompat {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ActivityOptions mActivityOptions;

        public ActivityOptionsCompatImpl(ActivityOptions activityOptions) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activityOptions};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mActivityOptions = activityOptions;
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public void requestUsageTimeReport(PendingIntent pendingIntent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pendingIntent) == null) && Build.VERSION.SDK_INT >= 23) {
                this.mActivityOptions.requestUsageTimeReport(pendingIntent);
            }
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public ActivityOptionsCompat setLaunchBounds(Rect rect) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rect)) == null) {
                if (Build.VERSION.SDK_INT < 24) {
                    return this;
                }
                return new ActivityOptionsCompatImpl(this.mActivityOptions.setLaunchBounds(rect));
            }
            return (ActivityOptionsCompat) invokeL.objValue;
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public void update(ActivityOptionsCompat activityOptionsCompat) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, activityOptionsCompat) == null) && (activityOptionsCompat instanceof ActivityOptionsCompatImpl)) {
                this.mActivityOptions.update(((ActivityOptionsCompatImpl) activityOptionsCompat).mActivityOptions);
            }
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public Rect getLaunchBounds() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (Build.VERSION.SDK_INT < 24) {
                    return null;
                }
                return this.mActivityOptions.getLaunchBounds();
            }
            return (Rect) invokeV.objValue;
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public Bundle toBundle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.mActivityOptions.toBundle();
            }
            return (Bundle) invokeV.objValue;
        }
    }

    public ActivityOptionsCompat() {
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

    public static ActivityOptionsCompat makeBasic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return new ActivityOptionsCompatImpl(ActivityOptions.makeBasic());
            }
            return new ActivityOptionsCompat();
        }
        return (ActivityOptionsCompat) invokeV.objValue;
    }

    public static ActivityOptionsCompat makeTaskLaunchBehind() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new ActivityOptionsCompatImpl(ActivityOptions.makeTaskLaunchBehind());
            }
            return new ActivityOptionsCompat();
        }
        return (ActivityOptionsCompat) invokeV.objValue;
    }

    public static ActivityOptionsCompat makeClipRevealAnimation(View view2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return new ActivityOptionsCompatImpl(ActivityOptions.makeClipRevealAnimation(view2, i, i2, i3, i4));
            }
            return new ActivityOptionsCompat();
        }
        return (ActivityOptionsCompat) invokeCommon.objValue;
    }

    public static ActivityOptionsCompat makeScaleUpAnimation(View view2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return new ActivityOptionsCompatImpl(ActivityOptions.makeScaleUpAnimation(view2, i, i2, i3, i4));
            }
            return new ActivityOptionsCompat();
        }
        return (ActivityOptionsCompat) invokeCommon.objValue;
    }

    public static ActivityOptionsCompat makeCustomAnimation(Context context, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, context, i, i2)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return new ActivityOptionsCompatImpl(ActivityOptions.makeCustomAnimation(context, i, i2));
            }
            return new ActivityOptionsCompat();
        }
        return (ActivityOptionsCompat) invokeLII.objValue;
    }

    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity activity, View view2, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, activity, view2, str)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new ActivityOptionsCompatImpl(ActivityOptions.makeSceneTransitionAnimation(activity, view2, str));
            }
            return new ActivityOptionsCompat();
        }
        return (ActivityOptionsCompat) invokeLLL.objValue;
    }

    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity activity, Pair<View, String>... pairArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, activity, pairArr)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                android.util.Pair[] pairArr2 = null;
                if (pairArr != null) {
                    pairArr2 = new android.util.Pair[pairArr.length];
                    for (int i = 0; i < pairArr.length; i++) {
                        pairArr2[i] = android.util.Pair.create(pairArr[i].first, pairArr[i].second);
                    }
                }
                return new ActivityOptionsCompatImpl(ActivityOptions.makeSceneTransitionAnimation(activity, pairArr2));
            }
            return new ActivityOptionsCompat();
        }
        return (ActivityOptionsCompat) invokeLL.objValue;
    }

    public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View view2, Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65544, null, view2, bitmap, i, i2)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return new ActivityOptionsCompatImpl(ActivityOptions.makeThumbnailScaleUpAnimation(view2, bitmap, i, i2));
            }
            return new ActivityOptionsCompat();
        }
        return (ActivityOptionsCompat) invokeLLII.objValue;
    }
}
