package com.baidu.spswitch.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.spswitch.b.e;
/* loaded from: classes3.dex */
public class c {
    private int czh = -1;
    private final View czi;
    private com.baidu.spswitch.a czj;
    private Context mContext;
    private static final String TAG = c.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.spswitch.b.b.isDebug();

    public c(View view) {
        this.czi = view;
        this.mContext = view.getContext();
    }

    public void Z(int i, int i2) {
        if (this.mContext instanceof Activity) {
            Activity activity = (Activity) this.mContext;
            if (e.A(activity) && this.czi.getFitsSystemWindows()) {
                Rect rect = new Rect();
                this.czi.getWindowVisibleDisplayFrame(rect);
                i2 = rect.bottom - rect.top;
                if (DEBUG) {
                    Log.d(TAG, "TranslucentStatus && FitsSystemWindows = true, height: " + i2);
                }
            }
            if (e.B(activity) && this.czi.getFitsSystemWindows()) {
                Rect rect2 = new Rect();
                this.czi.getWindowVisibleDisplayFrame(rect2);
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
            if (this.czh < 0) {
                if (DEBUG) {
                    Log.d(TAG, "onMeasure, oldHeight < 0, oldHeight: " + this.czh);
                }
                this.czh = i2;
                return;
            }
            int i3 = this.czh - i2;
            if (i3 == 0) {
                if (DEBUG) {
                    Log.d(TAG, "offset == 0, break;");
                    return;
                }
                return;
            }
            this.czh = i2;
            com.baidu.spswitch.a ar = ar(this.czi);
            if (ar == null) {
                if (DEBUG) {
                    Log.d(TAG, "cannot find the valid panel layout, give up!");
                    return;
                }
                return;
            }
            int visibility = ((LinearLayout) ar).getVisibility();
            if (DEBUG) {
                Log.d(TAG, "panel visibility: " + visibility);
            }
            if (Math.abs(i3) < com.baidu.spswitch.b.c.bV(this.czi.getContext())) {
                if (DEBUG) {
                    Log.d(TAG, "layout change min, not caused by softinput/panel switch!");
                }
            } else if (Math.abs(i3) > com.baidu.spswitch.b.c.bW(this.czi.getContext())) {
                if (DEBUG) {
                    Log.d(TAG, "layout change max , but not caused by softinput/panel switch!");
                }
            } else if (i3 > 0) {
                if (DEBUG) {
                    Log.d(TAG, "offset > 0, offset : " + i3 + ", panel->handleHide...");
                }
                ar.afh();
            } else {
                if (DEBUG) {
                    Log.d(TAG, "offset < 0, offset : " + i3 + ", panel->handleShow...");
                }
                ar.afg();
            }
        }
    }

    private com.baidu.spswitch.a ar(View view) {
        if (this.czj != null) {
            return this.czj;
        }
        if (view instanceof com.baidu.spswitch.a) {
            this.czj = (com.baidu.spswitch.a) view;
            return this.czj;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                com.baidu.spswitch.a ar = ar(viewGroup.getChildAt(i));
                if (ar != null) {
                    this.czj = ar;
                    return this.czj;
                }
            }
        }
        return null;
    }
}
