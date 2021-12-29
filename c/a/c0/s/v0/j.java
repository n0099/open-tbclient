package c.a.c0.s.v0;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.player.utils.BdViewOpUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f2539e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f2540f;

        public a(View view, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2539e = view;
            this.f2540f = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int g2 = j.g();
                int systemUiVisibility = this.f2539e.getSystemUiVisibility();
                int h2 = j.h(this.f2540f);
                if (g2 != systemUiVisibility) {
                    h2 |= systemUiVisibility;
                }
                h.b(BdViewOpUtils.TAG, "RESTORE KEY_SYSTEM_UI_VISIBILITY=" + h2);
                this.f2539e.setSystemUiVisibility(h2);
            }
        }
    }

    public static boolean b(Activity activity, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, activity, view)) == null) {
            if (activity == null || view == null) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            k(view);
            viewGroup.removeView(view);
            viewGroup.addView(view);
            if (i(activity)) {
                n(activity);
                o(viewGroup, true);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean c(View view, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, view, viewGroup)) == null) {
            if (view != null && viewGroup != null && viewGroup.getParent() != null) {
                h.b(BdViewOpUtils.TAG, "attachView " + view.hashCode() + " " + viewGroup.hashCode());
                try {
                    viewGroup.addView(view);
                    return true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65539, null, activity, z) == null) || activity == null || Build.VERSION.SDK_INT < 28) {
            return;
        }
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            m(activity, attributes.layoutInDisplayCutoutMode);
            attributes.layoutInDisplayCutoutMode = 1;
        } else {
            attributes.layoutInDisplayCutoutMode = f(activity);
        }
        window.setAttributes(attributes);
    }

    @Nullable
    public static ViewGroup e(@Nullable Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity)) == null) {
            if (activity != null) {
                return (ViewGroup) activity.getWindow().getDecorView();
            }
            return null;
        }
        return (ViewGroup) invokeL.objValue;
    }

    public static int f(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, activity)) == null) {
            if (activity.getIntent() != null) {
                return activity.getIntent().getIntExtra(BdViewOpUtils.KEY_DISPLAY_CUTOUT_MODE, 0);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? Build.VERSION.SDK_INT >= 19 ? 5638 : 1542 : invokeV.intValue;
    }

    public static int h(@Nullable Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, activity)) == null) {
            if (activity == null || activity.getIntent() == null) {
                return -1;
            }
            return activity.getIntent().getIntExtra(BdViewOpUtils.KEY_SYSTEM_UI_VISIBILITY, -1);
        }
        return invokeL.intValue;
    }

    public static boolean i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            if (context != null) {
                return !ViewConfiguration.get(context).hasPermanentMenuKey();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, viewGroup)) == null) {
            if (viewGroup != null) {
                h.b(BdViewOpUtils.TAG, "removeChilds " + viewGroup.hashCode());
                viewGroup.removeAllViews();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean k(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, view)) == null) {
            if (view == null || view.getParent() == null || !(view.getParent() instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup.indexOfChild(view) != -1) {
                try {
                    h.b(BdViewOpUtils.TAG, "removeView " + view.hashCode());
                    viewGroup.removeView(view);
                    return true;
                } catch (Exception e2) {
                    h.f("removeView(" + System.identityHashCode(view) + SmallTailInfo.EMOTION_SUFFIX, e2);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void l(@Nullable Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, activity) == null) && i(activity)) {
            ViewGroup e2 = e(activity);
            int h2 = h(activity);
            if (e2 == null || h2 == -1) {
                return;
            }
            e2.postDelayed(new a(e2, activity), 300L);
        }
    }

    public static void m(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65548, null, activity, i2) == null) || activity.getIntent() == null) {
            return;
        }
        activity.getIntent().putExtra(BdViewOpUtils.KEY_DISPLAY_CUTOUT_MODE, i2);
    }

    public static void n(@Nullable Activity activity) {
        ViewGroup e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, activity) == null) || activity == null || activity.getIntent() == null || (e2 = e(activity)) == null) {
            return;
        }
        h.b(BdViewOpUtils.TAG, "SAVE KEY_SYSTEM_UI_VISIBILITY=" + e2.getSystemUiVisibility());
        activity.getIntent().putExtra(BdViewOpUtils.KEY_SYSTEM_UI_VISIBILITY, e2.getSystemUiVisibility());
    }

    public static void o(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65550, null, view, z) == null) {
            h.b(BdViewOpUtils.TAG, "setSystemUiVisibility immersive: " + z);
            if (view == null) {
                return;
            }
            if (z) {
                view.setSystemUiVisibility(g());
            } else {
                view.setSystemUiVisibility(0);
            }
        }
    }
}
