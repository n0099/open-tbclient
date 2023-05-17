package com.baidu.android.ext.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.ui.BdShimmerView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class LoadingViewHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final WeakHashMap<ViewGroup, LoadingViewHolder> CACHE_VIEWS;
    public static final boolean DEBUG = false;
    public static final String TAG = "LoadingViewHelper";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-286339461, "Lcom/baidu/android/ext/widget/LoadingViewHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-286339461, "Lcom/baidu/android/ext/widget/LoadingViewHelper;");
                return;
            }
        }
        CACHE_VIEWS = new WeakHashMap<>();
    }

    public LoadingViewHelper() {
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

    public static void clearCachedLoadingViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            for (ViewGroup viewGroup : CACHE_VIEWS.keySet()) {
                LoadingViewHolder loadingViewHolder = CACHE_VIEWS.get(viewGroup);
                if (loadingViewHolder != null && loadingViewHolder.getLoadingView() != null) {
                    viewGroup.removeView(loadingViewHolder.getLoadingView());
                }
            }
            CACHE_VIEWS.clear();
        }
    }

    public static boolean dismissLoadingView(ViewGroup viewGroup) {
        InterceptResult invokeL;
        LoadingViewHolder loadingViewHolder;
        View loadingView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, viewGroup)) == null) {
            if (viewGroup == null) {
                return false;
            }
            LoadingViewHolder loadingViewHolder2 = CACHE_VIEWS.get(viewGroup);
            if (loadingViewHolder2 != null && loadingViewHolder2.getLoadingView() != null) {
                loadingViewHolder2.getLoadingView().setVisibility(8);
                return true;
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if ((viewGroup.getChildAt(i) instanceof LoadingViewHolder) && (loadingView = (loadingViewHolder = (LoadingViewHolder) viewGroup.getChildAt(i)).getLoadingView()) != null) {
                    loadingView.setVisibility(8);
                    CACHE_VIEWS.put(viewGroup, loadingViewHolder);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean showCachedLoadingView(ViewGroup viewGroup) {
        InterceptResult invokeL;
        LoadingViewHolder loadingViewHolder;
        View loadingView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, viewGroup)) == null) {
            if (viewGroup == null) {
                return false;
            }
            LoadingViewHolder loadingViewHolder2 = CACHE_VIEWS.get(viewGroup);
            if (loadingViewHolder2 != null && loadingViewHolder2.getLoadingView() != null) {
                loadingViewHolder2.getLoadingView().setVisibility(0);
                return true;
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if ((viewGroup.getChildAt(i) instanceof LoadingViewHolder) && (loadingView = (loadingViewHolder = (LoadingViewHolder) viewGroup.getChildAt(i)).getLoadingView()) != null) {
                    loadingView.setVisibility(0);
                    CACHE_VIEWS.put(viewGroup, loadingViewHolder);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean removeLoadingView(ViewGroup viewGroup) {
        InterceptResult invokeL;
        LoadingViewHolder loadingViewHolder;
        View loadingView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, viewGroup)) == null) {
            if (viewGroup == null) {
                return false;
            }
            LoadingViewHolder loadingViewHolder2 = CACHE_VIEWS.get(viewGroup);
            if (loadingViewHolder2 != null) {
                View loadingView2 = loadingViewHolder2.getLoadingView();
                if (loadingView2 != null) {
                    if (loadingView2 instanceof BdShimmerView) {
                        ((BdShimmerView) loadingView2).stopShimmerAnimation();
                    }
                    loadingView2.setVisibility(8);
                    viewGroup.removeView(loadingView2);
                    CACHE_VIEWS.remove(viewGroup);
                }
                return true;
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if ((viewGroup.getChildAt(i) instanceof LoadingViewHolder) && (loadingView = (loadingViewHolder = (LoadingViewHolder) viewGroup.getChildAt(i)).getLoadingView()) != null) {
                    loadingView.setVisibility(8);
                    viewGroup.removeView((View) loadingViewHolder);
                    CACHE_VIEWS.remove(viewGroup);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean showLoadingView(Context context, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, viewGroup)) == null) {
            return showLoadingView(context, viewGroup, "");
        }
        return invokeLL.booleanValue;
    }

    public static boolean showShimmerLoadingView(Context context, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, viewGroup)) == null) {
            return showShimmerLoadingView(context, viewGroup, 0);
        }
        return invokeLL.booleanValue;
    }

    public static boolean showLoadingView(Context context, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, context, viewGroup, layoutParams)) == null) {
            return showLoadingView(context, viewGroup, layoutParams, "");
        }
        return invokeLLL.booleanValue;
    }

    public static boolean showLoadingView(Context context, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65544, null, context, viewGroup, layoutParams, str)) == null) {
            if (context != null && viewGroup != null && layoutParams != null) {
                if (showCachedLoadingView(viewGroup)) {
                    return true;
                }
                LoadingView loadingView = new LoadingView(context);
                LoadingView loadingView2 = loadingView.getLoadingView();
                if (loadingView2 == null) {
                    return false;
                }
                if (!TextUtils.isEmpty(str)) {
                    loadingView2.setMsg(str);
                }
                ViewGroup viewGroup2 = (ViewGroup) loadingView2.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(loadingView2);
                }
                if ((viewGroup instanceof RelativeLayout) && (layoutParams instanceof RelativeLayout.LayoutParams)) {
                    viewGroup.addView(loadingView2, layoutParams);
                } else if ((viewGroup instanceof LinearLayout) && (layoutParams instanceof LinearLayout.LayoutParams)) {
                    viewGroup.addView(loadingView2, layoutParams);
                } else if ((viewGroup instanceof FrameLayout) && (layoutParams instanceof FrameLayout.LayoutParams)) {
                    viewGroup.addView(loadingView2, layoutParams);
                }
                CACHE_VIEWS.put(viewGroup, loadingView);
                loadingView2.setVisibility(0);
                return true;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static boolean showLoadingView(Context context, ViewGroup viewGroup, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, context, viewGroup, str)) == null) {
            if (context != null && viewGroup != null) {
                if (showCachedLoadingView(viewGroup)) {
                    return true;
                }
                LoadingView loadingView = new LoadingView(context);
                LoadingView loadingView2 = loadingView.getLoadingView();
                if (loadingView2 == null) {
                    return false;
                }
                if (!TextUtils.isEmpty(str)) {
                    loadingView2.setMsg(str);
                }
                ViewGroup viewGroup2 = (ViewGroup) loadingView2.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(loadingView2);
                }
                if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    viewGroup.addView(loadingView2, layoutParams);
                } else if (viewGroup instanceof LinearLayout) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 17;
                    viewGroup.addView(loadingView2, layoutParams2);
                } else if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams3.gravity = 17;
                    viewGroup.addView(loadingView2, layoutParams3);
                }
                CACHE_VIEWS.put(viewGroup, loadingView);
                loadingView2.setVisibility(0);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean showShimmerLoadingView(Context context, ViewGroup viewGroup, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65547, null, context, viewGroup, i)) == null) {
            if (context != null && viewGroup != null) {
                if (showCachedLoadingView(viewGroup)) {
                    return true;
                }
                BdShimmerView bdShimmerView = new BdShimmerView(context);
                BdShimmerView loadingView = bdShimmerView.getLoadingView();
                if (loadingView == null) {
                    return false;
                }
                loadingView.setType(i);
                ViewGroup viewGroup2 = (ViewGroup) loadingView.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(loadingView);
                }
                if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    viewGroup.addView(loadingView, layoutParams);
                } else if (viewGroup instanceof LinearLayout) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 17;
                    viewGroup.addView(loadingView, layoutParams2);
                } else if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams3.gravity = 17;
                    viewGroup.addView(loadingView, layoutParams3);
                }
                CACHE_VIEWS.put(viewGroup, bdShimmerView);
                loadingView.setVisibility(0);
                loadingView.startShimmerAnimation();
                return true;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }
}
