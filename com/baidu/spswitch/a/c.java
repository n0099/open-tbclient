package com.baidu.spswitch.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.spswitch.b.e;
/* loaded from: classes24.dex */
public class c {
    private int bTf = -1;
    private final View bTg;
    private com.baidu.spswitch.a bTh;
    private Context mContext;
    private static final String TAG = c.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.spswitch.b.b.isDebug();

    public c(View view) {
        this.bTg = view;
        this.mContext = view.getContext();
    }

    public void ac(int i, int i2) {
        if (this.mContext instanceof Activity) {
            Activity activity = (Activity) this.mContext;
            if (e.B(activity) && this.bTg.getFitsSystemWindows()) {
                Rect rect = new Rect();
                this.bTg.getWindowVisibleDisplayFrame(rect);
                i2 = rect.bottom - rect.top;
                if (DEBUG) {
                    Log.d(TAG, "TranslucentStatus && FitsSystemWindows = true, height: " + i2);
                }
            }
            if (e.C(activity) && this.bTg.getFitsSystemWindows()) {
                Rect rect2 = new Rect();
                this.bTg.getWindowVisibleDisplayFrame(rect2);
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
            if (this.bTf < 0) {
                if (DEBUG) {
                    Log.d(TAG, "onMeasure, oldHeight < 0, oldHeight: " + this.bTf);
                }
                this.bTf = i2;
                return;
            }
            int i3 = this.bTf - i2;
            if (i3 == 0) {
                if (DEBUG) {
                    Log.d(TAG, "offset == 0, break;");
                    return;
                }
                return;
            }
            this.bTf = i2;
            com.baidu.spswitch.a ag = ag(this.bTg);
            if (ag == null) {
                if (DEBUG) {
                    Log.d(TAG, "cannot find the valid panel layout, give up!");
                    return;
                }
                return;
            }
            int visibility = ((LinearLayout) ag).getVisibility();
            if (DEBUG) {
                Log.d(TAG, "panel visibility: " + visibility);
            }
            if (Math.abs(i3) < com.baidu.spswitch.b.c.bb(this.bTg.getContext())) {
                if (DEBUG) {
                    Log.d(TAG, "layout change min, not caused by softinput/panel switch!");
                }
            } else if (Math.abs(i3) > com.baidu.spswitch.b.c.bc(this.bTg.getContext())) {
                if (DEBUG) {
                    Log.d(TAG, "layout change max , but not caused by softinput/panel switch!");
                }
            } else if (i3 > 0) {
                if (DEBUG) {
                    Log.d(TAG, "offset > 0, offset : " + i3 + ", panel->handleHide...");
                }
                ag.Yl();
            } else {
                if (DEBUG) {
                    Log.d(TAG, "offset < 0, offset : " + i3 + ", panel->handleShow...");
                }
                ag.Yk();
            }
        }
    }

    private com.baidu.spswitch.a ag(View view) {
        if (this.bTh != null) {
            return this.bTh;
        }
        if (view instanceof com.baidu.spswitch.a) {
            this.bTh = (com.baidu.spswitch.a) view;
            return this.bTh;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                com.baidu.spswitch.a ag = ag(viewGroup.getChildAt(i));
                if (ag != null) {
                    this.bTh = ag;
                    return this.bTh;
                }
            }
        }
        return null;
    }
}
