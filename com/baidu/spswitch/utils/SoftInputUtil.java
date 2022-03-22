package com.baidu.spswitch.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.spswitch.IPanelHeightTarget;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class SoftInputUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "SoftInputUtil";
    public static WeakReference<ViewGroup> sContentViewRef;
    public static int sLastSaveSoftInputHeight;
    public static int sMaxPanelHeight;
    public static int sMaxSoftInputHeight;
    public static int sMinPanelHeight;
    public static int sMinSoftInputHeight;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public interface OnSoftInputShowingListener {
        void onSoftInputShowing(boolean z);
    }

    /* loaded from: classes4.dex */
    public static class SoftInputStatusListener implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Activity mActivity;
        public final ViewGroup mContentView;
        public boolean mLastSoftInputShowing;
        public final IPanelHeightTarget mPanelHeightTarget;
        public int mPreviousDisplayHeight;
        public final OnSoftInputShowingListener mSoftInputShowingListener;
        public int maxOverlayLayoutHeight;

        public SoftInputStatusListener(Activity activity, ViewGroup viewGroup, IPanelHeightTarget iPanelHeightTarget, OnSoftInputShowingListener onSoftInputShowingListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, viewGroup, iPanelHeightTarget, onSoftInputShowingListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mPreviousDisplayHeight = 0;
            this.mActivity = activity;
            this.mSoftInputShowingListener = onSoftInputShowingListener;
            this.mContentView = viewGroup;
            this.mPanelHeightTarget = iPanelHeightTarget;
        }

        private void calculateSoftInputHeight(int i) {
            int abs;
            View view;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(65537, this, i) == null) {
                if (SoftInputUtil.DEBUG) {
                    Log.d(SoftInputUtil.TAG, "****** calculateSoftInputHeight ******");
                }
                if (SoftInputUtil.DEBUG) {
                    Log.d(SoftInputUtil.TAG, "displayHeight: " + i + ", previousDisplayHeight: " + this.mPreviousDisplayHeight);
                }
                if (this.mPreviousDisplayHeight == 0) {
                    this.mPreviousDisplayHeight = i;
                    int validPanelHeight = SoftInputUtil.getValidPanelHeight(getContext());
                    if (SoftInputUtil.DEBUG) {
                        Log.d(SoftInputUtil.TAG, "previous display height = 0, refresh Height : " + validPanelHeight);
                    }
                    this.mPanelHeightTarget.refreshHeight(validPanelHeight);
                }
                if (SPSwitchConflictUtil.isHandleByPlaceholder(this.mContentView.getContext())) {
                    abs = ((View) this.mContentView.getParent()).getHeight() - i;
                    if (SoftInputUtil.DEBUG) {
                        Log.d(SoftInputUtil.TAG, "handle by placeholder, action bar overlay layout height " + view.getHeight() + ", display height: " + i + ", softInputHeight: " + abs);
                    }
                } else {
                    abs = Math.abs(i - this.mPreviousDisplayHeight);
                }
                if (abs <= SoftInputUtil.getMinSoftInputHeight(getContext())) {
                    if (SoftInputUtil.DEBUG) {
                        Log.d(SoftInputUtil.TAG, "softInputHeight is invalid, too small. softInputHeight: " + abs);
                    }
                    if (Math.abs(abs) == UIUtils.getStatusBarHeight(this.mContentView.getContext())) {
                        this.mPreviousDisplayHeight -= abs;
                        return;
                    }
                    return;
                }
                Log.d(SoftInputUtil.TAG, String.format("pre display height: %d, display height: %d, softinput: %d ", Integer.valueOf(this.mPreviousDisplayHeight), Integer.valueOf(i), Integer.valueOf(abs)));
                if (SoftInputUtil.saveSoftInputHeight(getContext(), abs)) {
                    int validPanelHeight2 = SoftInputUtil.getValidPanelHeight(getContext());
                    if (this.mPanelHeightTarget.getHeight() != validPanelHeight2) {
                        if (SoftInputUtil.DEBUG) {
                            Log.d(SoftInputUtil.TAG, "panel height changed, new height: " + validPanelHeight2);
                        }
                        this.mPanelHeightTarget.refreshHeight(validPanelHeight2);
                    } else if (SoftInputUtil.DEBUG) {
                        Log.d(SoftInputUtil.TAG, "panel no need to refresh, panelHeight: " + this.mPanelHeightTarget.getHeight() + ", validPanelHeight: " + validPanelHeight2);
                    }
                }
            }
        }

        private void calculateSoftInputShowing(int i) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(65538, this, i) == null) {
                if (SoftInputUtil.DEBUG) {
                    Log.d(SoftInputUtil.TAG, "###### calculateSoftInputShowing ######");
                }
                View view = (View) this.mContentView.getParent();
                int height = view.getHeight() - view.getPaddingTop();
                if (SPSwitchConflictUtil.isHandleByPlaceholder(this.mContentView.getContext())) {
                    z = height > i;
                } else {
                    int i2 = this.maxOverlayLayoutHeight;
                    if (i2 == 0) {
                        z = this.mLastSoftInputShowing;
                    } else {
                        z = i < i2 - SoftInputUtil.getMinSoftInputHeight(getContext());
                    }
                    this.maxOverlayLayoutHeight = Math.max(this.maxOverlayLayoutHeight, height);
                }
                if (SoftInputUtil.DEBUG) {
                    Log.d(SoftInputUtil.TAG, "maxOverlayLayoutHeight: " + this.maxOverlayLayoutHeight + ", isSoftInputShowing : " + z + ", mLastSoftInputShowing : " + this.mLastSoftInputShowing);
                }
                if (this.mLastSoftInputShowing != z) {
                    if (SoftInputUtil.DEBUG) {
                        Log.d(SoftInputUtil.TAG, String.format("displayHeight %d, actionBarOverlayLayoutHeight %d, softinput showing: %B", Integer.valueOf(i), Integer.valueOf(height), Boolean.valueOf(z)));
                    }
                    this.mPanelHeightTarget.onSoftInputShowing(z);
                    OnSoftInputShowingListener onSoftInputShowingListener = this.mSoftInputShowingListener;
                    if (onSoftInputShowingListener != null) {
                        onSoftInputShowingListener.onSoftInputShowing(z);
                    }
                }
                this.mLastSoftInputShowing = z;
            }
        }

        private Context getContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? this.mContentView.getContext() : (Context) invokeV.objValue;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                View childAt = this.mContentView.getChildAt(0);
                Rect rect = new Rect();
                if (childAt == null) {
                    if (SoftInputUtil.DEBUG) {
                        Log.d(SoftInputUtil.TAG, "SoftInputUtil, user root view not ready so ignore layout changed");
                    }
                    i = -1;
                } else if (!SPSwitchConflictUtil.isHandleByPlaceholder(this.mContentView.getContext()) && (!ViewUtil.isSystemUILayoutFullScreen(this.mActivity) || !ViewUtil.isFitsSystemWindows(this.mActivity))) {
                    i = childAt.getHeight();
                    if (SoftInputUtil.DEBUG) {
                        Log.d(SoftInputUtil.TAG, "#onGlobalLayout#, displayHeight calc by userRootView.getHeight()");
                    }
                } else {
                    childAt.getWindowVisibleDisplayFrame(rect);
                    i = rect.bottom - rect.top;
                    if (SoftInputUtil.DEBUG) {
                        Log.d(SoftInputUtil.TAG, "#onGlobalLayout#, displayHeight calc by getWindowVisibleDisplayFrame");
                    }
                }
                if (i == -1) {
                    return;
                }
                if (SoftInputUtil.DEBUG) {
                    Log.d(SoftInputUtil.TAG, "displayHeight: " + i);
                }
                calculateSoftInputHeight(i);
                calculateSoftInputShowing(i);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1644322041, "Lcom/baidu/spswitch/utils/SoftInputUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1644322041, "Lcom/baidu/spswitch/utils/SoftInputUtil;");
                return;
            }
        }
        DEBUG = SPConfig.isDebug();
        sMinSoftInputHeight = 0;
        sMaxSoftInputHeight = 0;
        sMinPanelHeight = 0;
        sMaxPanelHeight = 0;
        sLastSaveSoftInputHeight = 0;
    }

    public SoftInputUtil() {
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

    public static ViewTreeObserver.OnGlobalLayoutListener attach(Activity activity, ViewGroup viewGroup, IPanelHeightTarget iPanelHeightTarget, OnSoftInputShowingListener onSoftInputShowingListener) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, viewGroup, iPanelHeightTarget, onSoftInputShowingListener)) == null) {
            if (viewGroup == null) {
                viewGroup = (ViewGroup) activity.findViewById(16908290);
            }
            SoftInputStatusListener softInputStatusListener = new SoftInputStatusListener(activity, viewGroup, iPanelHeightTarget, onSoftInputShowingListener);
            viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(softInputStatusListener);
            sContentViewRef = new WeakReference<>(viewGroup);
            return softInputStatusListener;
        }
        return (ViewTreeObserver.OnGlobalLayoutListener) invokeLLLL.objValue;
    }

    public static void detach(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, activity, onGlobalLayoutListener) == null) {
            ((ViewGroup) activity.findViewById(16908290)).getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public static ViewGroup getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            WeakReference<ViewGroup> weakReference = sContentViewRef;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }
        return (ViewGroup) invokeV.objValue;
    }

    public static int getMaxPanelHeight(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, resources)) == null) {
            if (sMaxPanelHeight == 0) {
                sMaxPanelHeight = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703d2);
            }
            return sMaxPanelHeight;
        }
        return invokeL.intValue;
    }

    public static int getMaxSoftInputHeight(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            if (sMaxSoftInputHeight == 0) {
                sMaxSoftInputHeight = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703d3);
            }
            return sMaxSoftInputHeight;
        }
        return invokeL.intValue;
    }

    public static int getMinPanelHeight(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, resources)) == null) {
            if (sMinPanelHeight == 0) {
                sMinPanelHeight = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703d4);
            }
            return sMinPanelHeight;
        }
        return invokeL.intValue;
    }

    public static int getMinSoftInputHeight(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            if (sMinSoftInputHeight == 0) {
                sMinSoftInputHeight = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703d5);
            }
            return sMinSoftInputHeight;
        }
        return invokeL.intValue;
    }

    public static int getSoftInputHeight(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            if (sLastSaveSoftInputHeight == 0) {
                sLastSaveSoftInputHeight = SoftInputSharedPreferences.get(context, getMinPanelHeight(context.getResources()));
            }
            return sLastSaveSoftInputHeight;
        }
        return invokeL.intValue;
    }

    public static int getValidPanelHeight(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) ? Math.min(getMaxPanelHeight(context.getResources()), Math.max(getMinPanelHeight(context.getResources()), getSoftInputHeight(context))) : invokeL.intValue;
    }

    public static void hideSoftInput(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, view) == null) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static boolean saveSoftInputHeight(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65550, null, context, i)) == null) {
            if (sLastSaveSoftInputHeight != i && i >= 0) {
                sLastSaveSoftInputHeight = i;
                if (DEBUG) {
                    Log.d(TAG, "save softInput height: " + i);
                }
                return SoftInputSharedPreferences.save(context, i);
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static void setContentView(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, viewGroup) == null) {
            sContentViewRef = new WeakReference<>(viewGroup);
        }
    }

    public static void showSoftInput(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, view) == null) {
            view.requestFocus();
            ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
        }
    }

    public static void showSoftInputDelay(View view, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65553, null, view, j) == null) {
            view.postDelayed(new Runnable(view) { // from class: com.baidu.spswitch.utils.SoftInputUtil.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ View val$focusView;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {view};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$focusView = view;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        SoftInputUtil.showSoftInput(this.val$focusView);
                    }
                }
            }, j);
        }
    }
}
