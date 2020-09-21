package com.baidu.swan.apps.view.narootview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class SwanAppInlineFullScreenContainer extends FrameLayout {
    public SwanAppInlineFullScreenContainer(Context context) {
        super(context);
        setBackgroundColor(context.getResources().getColor(17170444));
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
