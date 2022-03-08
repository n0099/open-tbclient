package com.baidu.spswitch.handler;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    IPanelConflictLayout panelLayout = getPanelLayout(viewGroup.getChildAt(i2));
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

    public void handleBeforeMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            Context context = this.mContext;
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (ViewUtil.isTranslucentStatus(activity) && this.mRootLayout.getFitsSystemWindows()) {
                    Rect rect = new Rect();
                    this.mRootLayout.getWindowVisibleDisplayFrame(rect);
                    i3 = rect.bottom - rect.top;
                    if (DEBUG) {
                        String str = "TranslucentStatus && FitsSystemWindows = true, height: " + i3;
                    }
                }
                if (ViewUtil.isSystemUILayoutFullScreen(activity) && this.mRootLayout.getFitsSystemWindows()) {
                    Rect rect2 = new Rect();
                    this.mRootLayout.getWindowVisibleDisplayFrame(rect2);
                    i3 = rect2.bottom - rect2.top;
                    if (DEBUG) {
                        String str2 = "systemUILayoutFullScreen && FitsSystemWindows = true, height: " + i3;
                    }
                }
            }
            if (DEBUG) {
                String str3 = "onMeasure, width: " + i2 + " height: " + i3;
            }
            if (i3 < 0) {
                return;
            }
            int i4 = this.mOldHeight;
            if (i4 < 0) {
                if (DEBUG) {
                    String str4 = "onMeasure, oldHeight < 0, oldHeight: " + this.mOldHeight;
                }
                this.mOldHeight = i3;
                return;
            }
            int i5 = i4 - i3;
            if (i5 == 0) {
                boolean z = DEBUG;
                return;
            }
            this.mOldHeight = i3;
            IPanelConflictLayout panelLayout = getPanelLayout(this.mRootLayout);
            if (panelLayout == null) {
                boolean z2 = DEBUG;
                return;
            }
            int visibility = ((LinearLayout) panelLayout).getVisibility();
            if (DEBUG) {
                String str5 = "panel visibility: " + visibility;
            }
            if (Math.abs(i5) < SoftInputUtil.getMinSoftInputHeight(this.mRootLayout.getContext())) {
                boolean z3 = DEBUG;
            } else if (Math.abs(i5) > SoftInputUtil.getMaxSoftInputHeight(this.mRootLayout.getContext())) {
                boolean z4 = DEBUG;
            } else if (i5 > 0) {
                if (DEBUG) {
                    String str6 = "offset > 0, offset : " + i5 + ", panel->handleHide...";
                }
                panelLayout.handleHide();
            } else {
                if (DEBUG) {
                    String str7 = "offset < 0, offset : " + i5 + ", panel->handleShow...";
                }
                panelLayout.handleShow();
            }
        }
    }
}
