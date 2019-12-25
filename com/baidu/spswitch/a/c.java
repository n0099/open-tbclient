package com.baidu.spswitch.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.spswitch.b.e;
import com.baidu.spswitch.b.g;
/* loaded from: classes11.dex */
public class c {
    private int aUU = -1;
    private final View aUV;
    private com.baidu.spswitch.a aUW;
    private Context mContext;
    private static final String TAG = c.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.spswitch.b.b.isDebug();

    public c(View view) {
        this.aUV = view;
        this.mContext = view.getContext();
    }

    public void P(int i, int i2) {
        if (this.mContext instanceof Activity) {
            Activity activity = (Activity) this.mContext;
            if (g.B(activity) && this.aUV.getFitsSystemWindows()) {
                Rect rect = new Rect();
                this.aUV.getWindowVisibleDisplayFrame(rect);
                i2 = rect.bottom - rect.top;
                if (DEBUG) {
                    Log.d(TAG, "TranslucentStatus && FitsSystemWindows = true, height: " + i2);
                }
            }
            if (g.C(activity) && this.aUV.getFitsSystemWindows()) {
                Rect rect2 = new Rect();
                this.aUV.getWindowVisibleDisplayFrame(rect2);
                i2 = rect2.bottom - rect2.top;
                if (DEBUG) {
                    Log.d(TAG, "systemUILayoutFullScreen && FitsSystemWindows = true, height: " + i2);
                }
            }
        }
        if (DEBUG) {
            Log.d(TAG, "onMeasure, width: " + i + " height: " + i2);
        }
        if (i2 >= 0) {
            if (this.aUU < 0) {
                if (DEBUG) {
                    Log.d(TAG, "onMeasure, oldHeight < 0, oldHeight: " + this.aUU);
                }
                this.aUU = i2;
                return;
            }
            int i3 = this.aUU - i2;
            if (i3 == 0) {
                if (DEBUG) {
                    Log.d(TAG, "offset == 0, break;");
                    return;
                }
                return;
            }
            this.aUU = i2;
            com.baidu.spswitch.a U = U(this.aUV);
            if (U == null) {
                if (DEBUG) {
                    Log.d(TAG, "cannot find the valid panel layout, give up!");
                    return;
                }
                return;
            }
            int visibility = ((LinearLayout) U).getVisibility();
            if (DEBUG) {
                Log.d(TAG, "panel visibility: " + visibility);
            }
            if (Math.abs(i3) < e.be(this.aUV.getContext())) {
                if (DEBUG) {
                    Log.d(TAG, "layout change min, not caused by softinput/panel switch!");
                }
            } else if (Math.abs(i3) > e.bf(this.aUV.getContext())) {
                if (DEBUG) {
                    Log.d(TAG, "layout change max , but not caused by softinput/panel switch!");
                }
            } else if (i3 > 0) {
                if (DEBUG) {
                    Log.d(TAG, "offset > 0, offset : " + i3 + ", panel->handleHide...");
                }
                U.Dv();
            } else {
                if (DEBUG) {
                    Log.d(TAG, "offset < 0, offset : " + i3 + ", panel->handleShow...");
                }
                U.Du();
            }
        }
    }

    private com.baidu.spswitch.a U(View view) {
        if (this.aUW != null) {
            return this.aUW;
        }
        if (view instanceof com.baidu.spswitch.a) {
            this.aUW = (com.baidu.spswitch.a) view;
            return this.aUW;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                com.baidu.spswitch.a U = U(viewGroup.getChildAt(i));
                if (U != null) {
                    this.aUW = U;
                    return this.aUW;
                }
            }
        }
        return null;
    }
}
