package com.baidu.spswitch.handler;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.spswitch.IPanelConflictLayout;
import com.baidu.spswitch.utils.SPConfig;
import com.baidu.spswitch.utils.SoftInputUtil;
import com.baidu.spswitch.utils.ViewUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class SPSwitchRootLayoutHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "SPSwitchRootLayoutHandler";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public int mOldHeight;
    public IPanelConflictLayout mPanelLayout;
    public final View mRootLayout;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-386276381, "Lcom/baidu/spswitch/handler/SPSwitchRootLayoutHandler;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-386276381, "Lcom/baidu/spswitch/handler/SPSwitchRootLayoutHandler;");
                return;
            }
        }
        DEBUG = SPConfig.isDebug();
    }

    public SPSwitchRootLayoutHandler(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mOldHeight = -1;
        this.mRootLayout = view;
        this.mContext = view.getContext();
    }

    private IPanelConflictLayout getPanelLayout(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, view)) == null) {
            IPanelConflictLayout iPanelConflictLayout = this.mPanelLayout;
            if (iPanelConflictLayout != null) {
                return iPanelConflictLayout;
            }
            if (view instanceof IPanelConflictLayout) {
                IPanelConflictLayout iPanelConflictLayout2 = (IPanelConflictLayout) view;
                this.mPanelLayout = iPanelConflictLayout2;
                return iPanelConflictLayout2;
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    IPanelConflictLayout panelLayout = getPanelLayout(viewGroup.getChildAt(i));
                    if (panelLayout != null) {
                        this.mPanelLayout = panelLayout;
                        return panelLayout;
                    }
                }
                return null;
            } else {
                return null;
            }
        }
        return (IPanelConflictLayout) invokeL.objValue;
    }

    public void handleBeforeMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            Context context = this.mContext;
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (ViewUtil.isTranslucentStatus(activity) && this.mRootLayout.getFitsSystemWindows()) {
                    Rect rect = new Rect();
                    this.mRootLayout.getWindowVisibleDisplayFrame(rect);
                    i2 = rect.bottom - rect.top;
                    if (DEBUG) {
                        String str = TAG;
                        Log.d(str, "TranslucentStatus && FitsSystemWindows = true, height: " + i2);
                    }
                }
                if (ViewUtil.isSystemUILayoutFullScreen(activity) && this.mRootLayout.getFitsSystemWindows()) {
                    Rect rect2 = new Rect();
                    this.mRootLayout.getWindowVisibleDisplayFrame(rect2);
                    i2 = rect2.bottom - rect2.top;
                    if (DEBUG) {
                        String str2 = TAG;
                        Log.d(str2, "systemUILayoutFullScreen && FitsSystemWindows = true, height: " + i2);
                    }
                }
            }
            if (DEBUG) {
                String str3 = TAG;
                Log.d(str3, "onMeasure, width: " + i + " height: " + i2);
            }
            if (i2 < 0) {
                return;
            }
            int i3 = this.mOldHeight;
            if (i3 < 0) {
                if (DEBUG) {
                    String str4 = TAG;
                    Log.d(str4, "onMeasure, oldHeight < 0, oldHeight: " + this.mOldHeight);
                }
                this.mOldHeight = i2;
                return;
            }
            int i4 = i3 - i2;
            if (i4 == 0) {
                if (DEBUG) {
                    Log.d(TAG, "offset == 0, break;");
                    return;
                }
                return;
            }
            this.mOldHeight = i2;
            IPanelConflictLayout panelLayout = getPanelLayout(this.mRootLayout);
            if (panelLayout == null) {
                if (DEBUG) {
                    Log.d(TAG, "cannot find the valid panel layout, give up!");
                    return;
                }
                return;
            }
            int visibility = ((LinearLayout) panelLayout).getVisibility();
            if (DEBUG) {
                String str5 = TAG;
                Log.d(str5, "panel visibility: " + visibility);
            }
            if (Math.abs(i4) < SoftInputUtil.getMinSoftInputHeight(this.mRootLayout.getContext())) {
                if (DEBUG) {
                    Log.d(TAG, "layout change min, not caused by softinput/panel switch!");
                }
            } else if (Math.abs(i4) > SoftInputUtil.getMaxSoftInputHeight(this.mRootLayout.getContext())) {
                if (DEBUG) {
                    Log.d(TAG, "layout change max , but not caused by softinput/panel switch!");
                }
            } else if (i4 > 0) {
                if (DEBUG) {
                    String str6 = TAG;
                    Log.d(str6, "offset > 0, offset : " + i4 + ", panel->handleHide...");
                }
                panelLayout.handleHide();
            } else {
                if (DEBUG) {
                    String str7 = TAG;
                    Log.d(str7, "offset < 0, offset : " + i4 + ", panel->handleShow...");
                }
                panelLayout.handleShow();
            }
        }
    }
}
