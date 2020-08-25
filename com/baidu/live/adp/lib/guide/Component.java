package com.baidu.live.adp.lib.guide;

import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes7.dex */
public interface Component {
    public static final int ANCHOR_BOTTOM = 4;
    public static final int ANCHOR_LEFT = 1;
    public static final int ANCHOR_OVER = 5;
    public static final int ANCHOR_RIGHT = 3;
    public static final int ANCHOR_TOP = 2;
    public static final int FIT_CENTER = 32;
    public static final int FIT_END = 48;
    public static final int FIT_START = 16;

    int getAnchor();

    int getFitPosition();

    View getView(LayoutInflater layoutInflater);

    int getXOffset();

    int getYOffset();
}
