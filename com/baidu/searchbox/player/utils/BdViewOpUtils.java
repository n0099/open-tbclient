package com.baidu.searchbox.player.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class BdViewOpUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long DELAY_MILLIS = 300;
    public static final String KEY_DISPLAY_CUTOUT_MODE = "activity_layoutInDisplayCutoutMode";
    public static final String KEY_SYSTEM_UI_VISIBILITY = "activity_mSystemUiVisibility";
    public static final int SYSTEM_UI_FLAG_NONE = -1;
    public static final String TAG = "BdViewOpUtils";
    public transient /* synthetic */ FieldHolder $fh;

    public BdViewOpUtils() {
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

    public static int getImmersiveSystemUiVisibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return 5638;
            }
            return 1542;
        }
        return invokeV.intValue;
    }

    @Nullable
    public static ViewGroup getDecorView(@Nullable Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, activity)) == null) {
            if (activity != null) {
                return (ViewGroup) activity.getWindow().getDecorView();
            }
            return null;
        }
        return (ViewGroup) invokeL.objValue;
    }

    public static int getDisplayCutoutMode(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, activity)) == null) {
            if (activity.getIntent() == null) {
                return 0;
            }
            return activity.getIntent().getIntExtra(KEY_DISPLAY_CUTOUT_MODE, 0);
        }
        return invokeL.intValue;
    }

    public static int getSystemUiVisibility(@Nullable Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, activity)) == null) {
            if (activity == null || activity.getIntent() == null) {
                return -1;
            }
            return activity.getIntent().getIntExtra(KEY_SYSTEM_UI_VISIBILITY, -1);
        }
        return invokeL.intValue;
    }

    public static boolean hasChild(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, viewGroup)) == null) {
            if (viewGroup == null || viewGroup.getChildCount() <= 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean hasParent(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, view2)) == null) {
            if (view2 != null && view2.getParent() != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean hasPermanentMenuKey(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            if (context != null) {
                return !ViewConfiguration.get(context).hasPermanentMenuKey();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isParent(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, view2)) == null) {
            if (view2 == null || view2.getParent() == null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isZeroSize(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, view2)) == null) {
            if (view2 != null && view2.getWidth() != 0 && view2.getHeight() != 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void restoreSystemUiVisibility(@Nullable Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65555, null, activity) != null) || !hasPermanentMenuKey(activity)) {
            return;
        }
        ViewGroup decorView = getDecorView(activity);
        int systemUiVisibility = getSystemUiVisibility(activity);
        if (decorView != null && systemUiVisibility != -1) {
            decorView.postDelayed(new Runnable(decorView, activity) { // from class: com.baidu.searchbox.player.utils.BdViewOpUtils.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Activity val$activity;
                public final /* synthetic */ View val$decorView;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {decorView, activity};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$decorView = decorView;
                    this.val$activity = activity;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int immersiveSystemUiVisibility = BdViewOpUtils.getImmersiveSystemUiVisibility();
                        int systemUiVisibility2 = this.val$decorView.getSystemUiVisibility();
                        int systemUiVisibility3 = BdViewOpUtils.getSystemUiVisibility(this.val$activity);
                        if (immersiveSystemUiVisibility != systemUiVisibility2) {
                            systemUiVisibility3 |= systemUiVisibility2;
                        }
                        BdVideoLog.d(BdViewOpUtils.TAG, "RESTORE KEY_SYSTEM_UI_VISIBILITY=" + systemUiVisibility3);
                        this.val$decorView.setSystemUiVisibility(systemUiVisibility3);
                    }
                }
            }, 300L);
        }
    }

    public static void showSystemUi(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65559, null, view2) == null) && view2 != null) {
            view2.setSystemUiVisibility(0);
        }
    }

    public static boolean attachDecor(Activity activity, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, activity, view2)) == null) {
            if (activity != null && view2 != null) {
                ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                removeView(view2);
                viewGroup.removeView(view2);
                viewGroup.addView(view2);
                if (hasPermanentMenuKey(activity)) {
                    saveSystemUiVisibility(activity);
                    setSystemUiVisibility(viewGroup, true);
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void fixFullScreen4Notch(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, z) != null) || activity == null || Build.VERSION.SDK_INT < 28) {
            return;
        }
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            saveDisplayCutoutMode(activity, attributes.layoutInDisplayCutoutMode);
            attributes.layoutInDisplayCutoutMode = 1;
        } else {
            attributes.layoutInDisplayCutoutMode = getDisplayCutoutMode(activity);
        }
        window.setAttributes(attributes);
    }

    public static void setSystemUiVisibility(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65558, null, view2, z) == null) {
            BdVideoLog.d(TAG, "setSystemUiVisibility immersive: " + z);
            if (view2 == null) {
                return;
            }
            if (z) {
                view2.setSystemUiVisibility(getImmersiveSystemUiVisibility());
            } else {
                view2.setSystemUiVisibility(0);
            }
        }
    }

    public static boolean attachView(View view2, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, view2, viewGroup)) == null) {
            if (view2 != null && viewGroup != null && viewGroup.getParent() != null) {
                BdVideoLog.d(TAG, "attachView " + view2.hashCode() + " " + viewGroup.hashCode());
                try {
                    viewGroup.addView(view2);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void fixFullScreen4Notch(Dialog dialog, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65541, null, dialog, z) != null) || dialog == null || Build.VERSION.SDK_INT < 28) {
            return;
        }
        Window window = dialog.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.layoutInDisplayCutoutMode = 1;
        } else {
            attributes.layoutInDisplayCutoutMode = 0;
        }
        window.setAttributes(attributes);
    }

    public static boolean isAttachDecor(Activity activity, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, activity, view2)) == null) {
            if (activity == null || view2 == null || ((ViewGroup) activity.getWindow().getDecorView()).indexOfChild(view2) == -1) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean isParentView(View view2, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, view2, viewGroup)) == null) {
            if (view2 == null || viewGroup == null || viewGroup != ((ViewGroup) view2.getParent())) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void saveDisplayCutoutMode(Activity activity, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65556, null, activity, i) == null) && activity.getIntent() != null) {
            activity.getIntent().putExtra(KEY_DISPLAY_CUTOUT_MODE, i);
        }
    }

    public static boolean removeChilds(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, viewGroup)) == null) {
            if (viewGroup != null) {
                BdVideoLog.d(TAG, "removeChilds " + viewGroup.hashCode());
                viewGroup.removeAllViews();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean removeView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, view2)) == null) {
            if (view2 != null && view2.getParent() != null && (view2.getParent() instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) view2.getParent();
                if (viewGroup.indexOfChild(view2) != -1) {
                    try {
                        BdVideoLog.d(TAG, "removeView " + view2.hashCode());
                        viewGroup.removeView(view2);
                        return true;
                    } catch (Exception e) {
                        BdVideoLog.e("removeView(" + System.identityHashCode(view2) + SmallTailInfo.EMOTION_SUFFIX, e);
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void saveSystemUiVisibility(@Nullable Activity activity) {
        ViewGroup decorView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65557, null, activity) == null) && activity != null && activity.getIntent() != null && (decorView = getDecorView(activity)) != null) {
            BdVideoLog.d(TAG, "SAVE KEY_SYSTEM_UI_VISIBILITY=" + decorView.getSystemUiVisibility());
            activity.getIntent().putExtra(KEY_SYSTEM_UI_VISIBILITY, decorView.getSystemUiVisibility());
        }
    }
}
