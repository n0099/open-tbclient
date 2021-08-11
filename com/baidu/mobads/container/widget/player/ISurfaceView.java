package com.baidu.mobads.container.widget.player;
/* loaded from: classes5.dex */
public interface ISurfaceView {
    public static final int DISPLAY_MODE_16_9 = 4;
    public static final int DISPLAY_MODE_4_3 = 5;
    public static final int DISPLAY_MODE_HEIGHT_MATCH = 6;
    public static final int DISPLAY_MODE_MATCH_PARENT = 2;
    public static final int DISPLAY_MODE_ORIGIN_SIZE = 3;
    public static final int DISPLAY_MODE_SCALE_MAX = 7;
    public static final int DISPLAY_MODE_SCALE_ZOOM = 1;
    public static final int DISPLAY_MODE_SMART_PARENT = 0;

    void onVideoSizeChanged(int i2, int i3);

    void setDisplayMode(int i2);

    void setEndSurface();
}
