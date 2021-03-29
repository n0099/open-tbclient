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
/* loaded from: classes2.dex */
public class SPSwitchRootLayoutHandler {
    public static final boolean DEBUG = SPConfig.isDebug();
    public static final String TAG = "SPSwitchRootLayoutHandler";
    public Context mContext;
    public int mOldHeight = -1;
    public IPanelConflictLayout mPanelLayout;
    public final View mRootLayout;

    public SPSwitchRootLayoutHandler(View view) {
        this.mRootLayout = view;
        this.mContext = view.getContext();
    }

    private IPanelConflictLayout getPanelLayout(View view) {
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

    public void handleBeforeMeasure(int i, int i2) {
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
