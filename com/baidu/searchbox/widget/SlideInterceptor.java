package com.baidu.searchbox.widget;

import android.view.MotionEvent;
/* loaded from: classes7.dex */
public interface SlideInterceptor {
    public static final int TOUCH_MODE_SCROLL_START = 6;

    boolean isSlidable(MotionEvent motionEvent);
}
