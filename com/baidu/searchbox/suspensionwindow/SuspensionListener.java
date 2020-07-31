package com.baidu.searchbox.suspensionwindow;

import android.graphics.Rect;
import android.support.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes5.dex */
public interface SuspensionListener {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes5.dex */
    public @interface SuspensionState {
        public static final int CREATE = 3;
        public static final int DESTROY = 4;
        public static final int HIDE = 2;
        public static final int SHOW = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes5.dex */
    public @interface TouchState {
        public static final int CLICK = 2;
        public static final int DRAG_END_RELEASE = 4;
        public static final int DRAG_END_REMOVE = 5;
        public static final int DRAG_START = 3;
        public static final int PRESS = 1;
    }

    void onStateChange(String str, int i);

    void onTouchChange(String str, int i, @Nullable Rect rect);
}
