package com.baidu.spswitch.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.spswitch.b.e;
/* loaded from: classes6.dex */
public class c {
    private int cza = -1;
    private final View czb;
    private com.baidu.spswitch.a czc;
    private Context mContext;
    private static final String TAG = c.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.spswitch.b.b.isDebug();

    public c(View view) {
        this.czb = view;
        this.mContext = view.getContext();
    }

    public void ae(int i, int i2) {
        if (this.mContext instanceof Activity) {
            Activity activity = (Activity) this.mContext;
            if (e.B(activity) && this.czb.getFitsSystemWindows()) {
                Rect rect = new Rect();
                this.czb.getWindowVisibleDisplayFrame(rect);
                i2 = rect.bottom - rect.top;
                if (DEBUG) {
                    Log.d(TAG, "TranslucentStatus && FitsSystemWindows = true, height: " + i2);
                }
            }
            if (e.C(activity) && this.czb.getFitsSystemWindows()) {
                Rect rect2 = new Rect();
                this.czb.getWindowVisibleDisplayFrame(rect2);
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
            if (this.cza < 0) {
                if (DEBUG) {
                    Log.d(TAG, "onMeasure, oldHeight < 0, oldHeight: " + this.cza);
                }
                this.cza = i2;
                return;
            }
            int i3 = this.cza - i2;
            if (i3 == 0) {
                if (DEBUG) {
                    Log.d(TAG, "offset == 0, break;");
                    return;
                }
                return;
            }
            this.cza = i2;
            com.baidu.spswitch.a ap = ap(this.czb);
            if (ap == null) {
                if (DEBUG) {
                    Log.d(TAG, "cannot find the valid panel layout, give up!");
                    return;
                }
                return;
            }
            int visibility = ((LinearLayout) ap).getVisibility();
            if (DEBUG) {
                Log.d(TAG, "panel visibility: " + visibility);
            }
            if (Math.abs(i3) < com.baidu.spswitch.b.c.bN(this.czb.getContext())) {
                if (DEBUG) {
                    Log.d(TAG, "layout change min, not caused by softinput/panel switch!");
                }
            } else if (Math.abs(i3) > com.baidu.spswitch.b.c.bO(this.czb.getContext())) {
                if (DEBUG) {
                    Log.d(TAG, "layout change max , but not caused by softinput/panel switch!");
                }
            } else if (i3 > 0) {
                if (DEBUG) {
                    Log.d(TAG, "offset > 0, offset : " + i3 + ", panel->handleHide...");
                }
                ap.ahR();
            } else {
                if (DEBUG) {
                    Log.d(TAG, "offset < 0, offset : " + i3 + ", panel->handleShow...");
                }
                ap.ahQ();
            }
        }
    }

    private com.baidu.spswitch.a ap(View view) {
        if (this.czc != null) {
            return this.czc;
        }
        if (view instanceof com.baidu.spswitch.a) {
            this.czc = (com.baidu.spswitch.a) view;
            return this.czc;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                com.baidu.spswitch.a ap = ap(viewGroup.getChildAt(i));
                if (ap != null) {
                    this.czc = ap;
                    return this.czc;
                }
            }
        }
        return null;
    }
}
