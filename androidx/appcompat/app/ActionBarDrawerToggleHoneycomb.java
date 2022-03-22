package androidx.appcompat.app;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class ActionBarDrawerToggleHoneycomb {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ActionBarDrawerToggleHC";
    public static final int[] THEME_ATTRS;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class SetIndicatorInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Method setHomeActionContentDescription;
        public Method setHomeAsUpIndicator;
        public ImageView upIndicatorView;

        public SetIndicatorInfo(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            try {
                this.setHomeAsUpIndicator = android.app.ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", Drawable.class);
                this.setHomeActionContentDescription = android.app.ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", Integer.TYPE);
            } catch (NoSuchMethodException unused) {
                View findViewById = activity.findViewById(androidx.legacy.app.ActionBarDrawerToggle.ID_HOME);
                if (findViewById == null) {
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
                if (viewGroup.getChildCount() != 2) {
                    return;
                }
                View childAt = viewGroup.getChildAt(0);
                childAt = childAt.getId() == 16908332 ? viewGroup.getChildAt(1) : childAt;
                if (childAt instanceof ImageView) {
                    this.upIndicatorView = (ImageView) childAt;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1366535347, "Landroidx/appcompat/app/ActionBarDrawerToggleHoneycomb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1366535347, "Landroidx/appcompat/app/ActionBarDrawerToggleHoneycomb;");
                return;
            }
        }
        THEME_ATTRS = new int[]{16843531};
    }

    public ActionBarDrawerToggleHoneycomb() {
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

    public static Drawable getThemeUpIndicator(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(THEME_ATTRS);
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }
        return (Drawable) invokeL.objValue;
    }

    public static SetIndicatorInfo setActionBarDescription(SetIndicatorInfo setIndicatorInfo, Activity activity, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, setIndicatorInfo, activity, i)) == null) {
            if (setIndicatorInfo == null) {
                setIndicatorInfo = new SetIndicatorInfo(activity);
            }
            if (setIndicatorInfo.setHomeAsUpIndicator != null) {
                try {
                    android.app.ActionBar actionBar = activity.getActionBar();
                    setIndicatorInfo.setHomeActionContentDescription.invoke(actionBar, Integer.valueOf(i));
                    if (Build.VERSION.SDK_INT <= 19) {
                        actionBar.setSubtitle(actionBar.getSubtitle());
                    }
                } catch (Exception e2) {
                    Log.w(TAG, "Couldn't set content description via JB-MR2 API", e2);
                }
            }
            return setIndicatorInfo;
        }
        return (SetIndicatorInfo) invokeLLI.objValue;
    }

    public static SetIndicatorInfo setActionBarUpIndicator(Activity activity, Drawable drawable, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, drawable, i)) == null) {
            SetIndicatorInfo setIndicatorInfo = new SetIndicatorInfo(activity);
            if (setIndicatorInfo.setHomeAsUpIndicator != null) {
                try {
                    android.app.ActionBar actionBar = activity.getActionBar();
                    setIndicatorInfo.setHomeAsUpIndicator.invoke(actionBar, drawable);
                    setIndicatorInfo.setHomeActionContentDescription.invoke(actionBar, Integer.valueOf(i));
                } catch (Exception e2) {
                    Log.w(TAG, "Couldn't set home-as-up indicator via JB-MR2 API", e2);
                }
            } else {
                ImageView imageView = setIndicatorInfo.upIndicatorView;
                if (imageView != null) {
                    imageView.setImageDrawable(drawable);
                } else {
                    Log.w(TAG, "Couldn't set home-as-up indicator");
                }
            }
            return setIndicatorInfo;
        }
        return (SetIndicatorInfo) invokeLLI.objValue;
    }
}
