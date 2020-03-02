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
/* loaded from: classes13.dex */
public class c {
    private int aZZ = -1;
    private final View baa;
    private com.baidu.spswitch.a bab;
    private Context mContext;
    private static final String TAG = c.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.spswitch.b.b.isDebug();

    public c(View view) {
        this.baa = view;
        this.mContext = view.getContext();
    }

    public void T(int i, int i2) {
        if (this.mContext instanceof Activity) {
            Activity activity = (Activity) this.mContext;
            if (g.D(activity) && this.baa.getFitsSystemWindows()) {
                Rect rect = new Rect();
                this.baa.getWindowVisibleDisplayFrame(rect);
                i2 = rect.bottom - rect.top;
                if (DEBUG) {
                    Log.d(TAG, "TranslucentStatus && FitsSystemWindows = true, height: " + i2);
                }
            }
            if (g.E(activity) && this.baa.getFitsSystemWindows()) {
                Rect rect2 = new Rect();
                this.baa.getWindowVisibleDisplayFrame(rect2);
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
            if (this.aZZ < 0) {
                if (DEBUG) {
                    Log.d(TAG, "onMeasure, oldHeight < 0, oldHeight: " + this.aZZ);
                }
                this.aZZ = i2;
                return;
            }
            int i3 = this.aZZ - i2;
            if (i3 == 0) {
                if (DEBUG) {
                    Log.d(TAG, "offset == 0, break;");
                    return;
                }
                return;
            }
            this.aZZ = i2;
            com.baidu.spswitch.a Y = Y(this.baa);
            if (Y == null) {
                if (DEBUG) {
                    Log.d(TAG, "cannot find the valid panel layout, give up!");
                    return;
                }
                return;
            }
            int visibility = ((LinearLayout) Y).getVisibility();
            if (DEBUG) {
                Log.d(TAG, "panel visibility: " + visibility);
            }
            if (Math.abs(i3) < e.bi(this.baa.getContext())) {
                if (DEBUG) {
                    Log.d(TAG, "layout change min, not caused by softinput/panel switch!");
                }
            } else if (Math.abs(i3) > e.bj(this.baa.getContext())) {
                if (DEBUG) {
                    Log.d(TAG, "layout change max , but not caused by softinput/panel switch!");
                }
            } else if (i3 > 0) {
                if (DEBUG) {
                    Log.d(TAG, "offset > 0, offset : " + i3 + ", panel->handleHide...");
                }
                Y.Gi();
            } else {
                if (DEBUG) {
                    Log.d(TAG, "offset < 0, offset : " + i3 + ", panel->handleShow...");
                }
                Y.Gh();
            }
        }
    }

    private com.baidu.spswitch.a Y(View view) {
        if (this.bab != null) {
            return this.bab;
        }
        if (view instanceof com.baidu.spswitch.a) {
            this.bab = (com.baidu.spswitch.a) view;
            return this.bab;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                com.baidu.spswitch.a Y = Y(viewGroup.getChildAt(i));
                if (Y != null) {
                    this.bab = Y;
                    return this.bab;
                }
            }
        }
        return null;
    }
}
