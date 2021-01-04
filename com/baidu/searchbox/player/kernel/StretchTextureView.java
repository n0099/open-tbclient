package com.baidu.searchbox.player.kernel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import com.baidu.searchbox.player.utils.BdVideoLog;
/* loaded from: classes3.dex */
public class StretchTextureView extends TextureView {
    public static final int STYLE_DEFAULT = 0;
    public static final int STYLE_MATCH_HEIGHT = 1;
    public static final int STYLE_MATCH_WIDTH = 2;
    public static final int STYLE_MATCH_WIDTH_HEIGHT = 3;
    private static final String TAG = "MiniVideoTextureView";
    private int mStyle;
    private int mVideoHeight;
    private int mVideoWidth;

    public StretchTextureView(Context context) {
        super(context);
        this.mStyle = 0;
    }

    public StretchTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStyle = 0;
    }

    public void setRenderStyle(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 3) {
            this.mStyle = i;
        } else {
            this.mStyle = 0;
        }
        requestLayout();
    }

    public void setVideoWidthAndHeight(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00fb, code lost:
        if (r1 > r2) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0121  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i, int i2) {
        int i3;
        int defaultSize = getDefaultSize(this.mVideoWidth, i);
        int defaultSize2 = getDefaultSize(this.mVideoHeight, i2);
        BdVideoLog.d(TAG, "onMeasure ** mVideoWidth : " + this.mVideoWidth + ", mVideoHeight : " + this.mVideoHeight + ", TextureViewWidth : " + defaultSize + ", TextureViewHeight : " + defaultSize2);
        if (this.mStyle == 0) {
            int defaultSize3 = getDefaultSize(this.mVideoWidth, i);
            int defaultSize4 = getDefaultSize(this.mVideoHeight, i2);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                int mode = View.MeasureSpec.getMode(i);
                i3 = View.MeasureSpec.getSize(i);
                int mode2 = View.MeasureSpec.getMode(i2);
                defaultSize2 = View.MeasureSpec.getSize(i2);
                if (mode == 1073741824 && mode2 == 1073741824) {
                    if (this.mVideoWidth * defaultSize2 < this.mVideoHeight * i3) {
                        i3 = (this.mVideoWidth * defaultSize2) / this.mVideoHeight;
                    } else if (this.mVideoWidth * defaultSize2 > this.mVideoHeight * i3) {
                        defaultSize2 = (this.mVideoHeight * i3) / this.mVideoWidth;
                    }
                } else if (mode == 1073741824) {
                    int i4 = (this.mVideoHeight * i3) / this.mVideoWidth;
                    if (mode2 != Integer.MIN_VALUE || i4 <= defaultSize2) {
                        defaultSize2 = i4;
                    }
                } else if (mode2 == 1073741824) {
                    defaultSize = (this.mVideoWidth * defaultSize2) / this.mVideoHeight;
                    if (mode == Integer.MIN_VALUE) {
                    }
                } else {
                    defaultSize = this.mVideoWidth;
                    int i5 = this.mVideoHeight;
                    if (mode2 != Integer.MIN_VALUE || i5 <= defaultSize2) {
                        defaultSize2 = i5;
                    } else {
                        defaultSize = (this.mVideoWidth * defaultSize2) / this.mVideoHeight;
                    }
                    if (mode == Integer.MIN_VALUE && defaultSize > i3) {
                        defaultSize2 = (this.mVideoHeight * i3) / this.mVideoWidth;
                    }
                }
                if (getRotation() != 0.0f && getRotation() % 90.0f == 0.0f) {
                    if (defaultSize3 >= defaultSize4) {
                        if (i3 > defaultSize2) {
                            i3 = (int) ((i3 * defaultSize3) / defaultSize2);
                            defaultSize2 = defaultSize3;
                        } else {
                            defaultSize2 = (int) ((defaultSize2 * i3) / defaultSize3);
                            i3 = defaultSize3;
                        }
                    } else if (i3 > defaultSize2) {
                        defaultSize2 = (int) ((defaultSize2 * i3) / defaultSize3);
                        i3 = defaultSize3;
                    } else {
                        i3 = (int) ((i3 * defaultSize3) / defaultSize2);
                        defaultSize2 = defaultSize3;
                    }
                }
                defaultSize = i3;
            }
            i3 = defaultSize;
            if (getRotation() != 0.0f) {
                if (defaultSize3 >= defaultSize4) {
                }
            }
            defaultSize = i3;
        } else if (this.mStyle == 1) {
            defaultSize = setStyleMatchHeight(defaultSize, defaultSize2, this.mVideoWidth, this.mVideoHeight);
        } else if (this.mStyle == 2) {
            defaultSize2 = setStyleMatchWidth(defaultSize, defaultSize2, this.mVideoWidth, this.mVideoHeight);
        } else if (this.mStyle == 3 && this.mVideoWidth > 0 && this.mVideoHeight > 0) {
            if (this.mVideoWidth / this.mVideoHeight <= 1.0f) {
                if (this.mVideoWidth / this.mVideoHeight <= defaultSize / defaultSize2) {
                    defaultSize2 = setStyleMatchWidth(defaultSize, defaultSize2, this.mVideoWidth, this.mVideoHeight);
                } else {
                    defaultSize = setStyleMatchHeight(defaultSize, defaultSize2, this.mVideoWidth, this.mVideoHeight);
                }
            } else {
                defaultSize2 = setStyleMatchWidth(defaultSize, defaultSize2, this.mVideoWidth, this.mVideoHeight);
            }
        }
        BdVideoLog.d(TAG, "setMeasuredDimension **  TextureViewWidth : " + defaultSize + ", TextureViewHeight : " + defaultSize2);
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    private int setStyleMatchHeight(int i, int i2, int i3, int i4) {
        if (i3 > 0 && i4 > 0) {
            return (int) ((i2 / i4) * i3);
        }
        return i;
    }

    private int setStyleMatchWidth(int i, int i2, int i3, int i4) {
        if (i3 > 0 && i4 > 0) {
            return (int) ((i / i3) * i4);
        }
        return i2;
    }
}
