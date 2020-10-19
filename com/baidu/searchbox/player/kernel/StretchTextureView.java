package com.baidu.searchbox.player.kernel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import com.baidu.searchbox.player.utils.BdVideoLog;
/* loaded from: classes15.dex */
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

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(this.mVideoWidth, i);
        int defaultSize2 = getDefaultSize(this.mVideoHeight, i2);
        BdVideoLog.d(TAG, "onMeasure ** mVideoWidth : " + this.mVideoWidth + ", mVideoHeight : " + this.mVideoHeight + ", TextureViewWidth : " + defaultSize + ", TextureViewHeight : " + defaultSize2);
        if (this.mStyle == 0) {
            int defaultSize3 = getDefaultSize(this.mVideoWidth, i);
            int defaultSize4 = getDefaultSize(this.mVideoHeight, i2);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                int mode = View.MeasureSpec.getMode(i);
                int size = View.MeasureSpec.getSize(i);
                int mode2 = View.MeasureSpec.getMode(i2);
                defaultSize2 = View.MeasureSpec.getSize(i2);
                if (mode == 1073741824 && mode2 == 1073741824) {
                    if (this.mVideoWidth * defaultSize2 < this.mVideoHeight * size) {
                        defaultSize = (this.mVideoWidth * defaultSize2) / this.mVideoHeight;
                    } else if (this.mVideoWidth * defaultSize2 > this.mVideoHeight * size) {
                        defaultSize2 = (this.mVideoHeight * size) / this.mVideoWidth;
                        defaultSize = size;
                    } else {
                        defaultSize = size;
                    }
                } else if (mode == 1073741824) {
                    int i3 = (this.mVideoHeight * size) / this.mVideoWidth;
                    if (mode2 != Integer.MIN_VALUE || i3 <= defaultSize2) {
                        defaultSize2 = i3;
                        defaultSize = size;
                    } else {
                        defaultSize = size;
                    }
                } else if (mode2 == 1073741824) {
                    defaultSize = (this.mVideoWidth * defaultSize2) / this.mVideoHeight;
                    if (mode == Integer.MIN_VALUE && defaultSize > size) {
                        defaultSize = size;
                    }
                } else {
                    int i4 = this.mVideoWidth;
                    int i5 = this.mVideoHeight;
                    if (mode2 != Integer.MIN_VALUE || i5 <= defaultSize2) {
                        defaultSize2 = i5;
                        defaultSize = i4;
                    } else {
                        defaultSize = (this.mVideoWidth * defaultSize2) / this.mVideoHeight;
                    }
                    if (mode == Integer.MIN_VALUE && defaultSize > size) {
                        defaultSize2 = (this.mVideoHeight * size) / this.mVideoWidth;
                        defaultSize = size;
                    }
                }
            }
            if (getRotation() == 0.0f || getRotation() % 90.0f != 0.0f) {
                defaultSize3 = defaultSize;
            } else if (defaultSize3 < defaultSize4) {
                if (defaultSize > defaultSize2) {
                    int i6 = (int) ((defaultSize * defaultSize3) / defaultSize2);
                    defaultSize2 = defaultSize3;
                    defaultSize3 = i6;
                } else {
                    defaultSize2 = (int) ((defaultSize2 * defaultSize) / defaultSize3);
                }
            } else if (defaultSize > defaultSize2) {
                defaultSize2 = (int) ((defaultSize2 * defaultSize) / defaultSize3);
            } else {
                int i7 = (int) ((defaultSize * defaultSize3) / defaultSize2);
                defaultSize2 = defaultSize3;
                defaultSize3 = i7;
            }
            defaultSize = defaultSize3;
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
