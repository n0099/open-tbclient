package com.baidu.spswitch.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.spswitch.b.e;
/* loaded from: classes13.dex */
public class c {
    private int bGv = -1;
    private final View bGw;
    private com.baidu.spswitch.a bGx;
    private Context mContext;
    private static final String TAG = c.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.spswitch.b.b.isDebug();

    public c(View view) {
        this.bGw = view;
        this.mContext = view.getContext();
    }

    public void Y(int i, int i2) {
        if (this.mContext instanceof Activity) {
            Activity activity = (Activity) this.mContext;
            if (e.A(activity) && this.bGw.getFitsSystemWindows()) {
                Rect rect = new Rect();
                this.bGw.getWindowVisibleDisplayFrame(rect);
                i2 = rect.bottom - rect.top;
                if (DEBUG) {
                    Log.d(TAG, "TranslucentStatus && FitsSystemWindows = true, height: " + i2);
                }
            }
            if (e.B(activity) && this.bGw.getFitsSystemWindows()) {
                Rect rect2 = new Rect();
                this.bGw.getWindowVisibleDisplayFrame(rect2);
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
            if (this.bGv < 0) {
                if (DEBUG) {
                    Log.d(TAG, "onMeasure, oldHeight < 0, oldHeight: " + this.bGv);
                }
                this.bGv = i2;
                return;
            }
            int i3 = this.bGv - i2;
            if (i3 == 0) {
                if (DEBUG) {
                    Log.d(TAG, "offset == 0, break;");
                    return;
                }
                return;
            }
            this.bGv = i2;
            com.baidu.spswitch.a aa = aa(this.bGw);
            if (aa == null) {
                if (DEBUG) {
                    Log.d(TAG, "cannot find the valid panel layout, give up!");
                    return;
                }
                return;
            }
            int visibility = ((LinearLayout) aa).getVisibility();
            if (DEBUG) {
                Log.d(TAG, "panel visibility: " + visibility);
            }
            if (Math.abs(i3) < com.baidu.spswitch.b.c.aV(this.bGw.getContext())) {
                if (DEBUG) {
                    Log.d(TAG, "layout change min, not caused by softinput/panel switch!");
                }
            } else if (Math.abs(i3) > com.baidu.spswitch.b.c.aW(this.bGw.getContext())) {
                if (DEBUG) {
                    Log.d(TAG, "layout change max , but not caused by softinput/panel switch!");
                }
            } else if (i3 > 0) {
                if (DEBUG) {
                    Log.d(TAG, "offset > 0, offset : " + i3 + ", panel->handleHide...");
                }
                aa.Qm();
            } else {
                if (DEBUG) {
                    Log.d(TAG, "offset < 0, offset : " + i3 + ", panel->handleShow...");
                }
                aa.Ql();
            }
        }
    }

    private com.baidu.spswitch.a aa(View view) {
        if (this.bGx != null) {
            return this.bGx;
        }
        if (view instanceof com.baidu.spswitch.a) {
            this.bGx = (com.baidu.spswitch.a) view;
            return this.bGx;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                com.baidu.spswitch.a aa = aa(viewGroup.getChildAt(i));
                if (aa != null) {
                    this.bGx = aa;
                    return this.bGx;
                }
            }
        }
        return null;
    }
}
