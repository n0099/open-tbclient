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
    public static final String TAG = "MiniVideoTextureView";
    public int mStyle;
    public int mVideoHeight;
    public int mVideoWidth;

    private int setStyleMatchHeight(int i, int i2, int i3, int i4) {
        if (i3 <= 0 || i4 <= 0) {
            return i;
        }
        return (int) (i3 * (i2 / i4));
    }

    private int setStyleMatchWidth(int i, int i2, int i3, int i4) {
        if (i3 <= 0 || i4 <= 0) {
            return i2;
        }
        return (int) (i4 * (i / i3));
    }

    public StretchTextureView(Context context) {
        super(context);
        this.mStyle = 0;
    }

    public void setRenderStyle(int i) {
        if (i != 0 && i != 1 && i != 2 && i != 3) {
            this.mStyle = 0;
        } else {
            this.mStyle = i;
        }
        requestLayout();
    }

    public StretchTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStyle = 0;
    }

    public void setVideoWidthAndHeight(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00e2, code lost:
        r1 = (int) ((r1 * r0) / r2);
        r0 = r2;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int defaultSize = TextureView.getDefaultSize(this.mVideoWidth, i);
        int defaultSize2 = TextureView.getDefaultSize(this.mVideoHeight, i2);
        BdVideoLog.d(TAG, "onMeasure ** mVideoWidth : " + this.mVideoWidth + ", mVideoHeight : " + this.mVideoHeight + ", TextureViewWidth : " + defaultSize + ", TextureViewHeight : " + defaultSize2);
        int i5 = this.mStyle;
        if (i5 == 0) {
            int defaultSize3 = TextureView.getDefaultSize(this.mVideoWidth, i);
            int defaultSize4 = TextureView.getDefaultSize(this.mVideoHeight, i2);
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                int mode = View.MeasureSpec.getMode(i);
                int size = View.MeasureSpec.getSize(i);
                int mode2 = View.MeasureSpec.getMode(i2);
                int size2 = View.MeasureSpec.getSize(i2);
                if (mode == 1073741824 && mode2 == 1073741824) {
                    int i6 = this.mVideoWidth;
                    int i7 = i6 * size2;
                    int i8 = this.mVideoHeight;
                    if (i7 < size * i8) {
                        defaultSize = (i6 * size2) / i8;
                        defaultSize2 = size2;
                    } else {
                        if (i6 * size2 > size * i8) {
                            defaultSize2 = (i8 * size) / i6;
                            defaultSize = size;
                        }
                        defaultSize = size;
                        defaultSize2 = size2;
                    }
                } else if (mode == 1073741824) {
                    int i9 = (this.mVideoHeight * size) / this.mVideoWidth;
                    if (mode2 != Integer.MIN_VALUE || i9 <= size2) {
                        defaultSize2 = i9;
                        defaultSize = size;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                } else if (mode2 == 1073741824) {
                    int i10 = (this.mVideoWidth * size2) / this.mVideoHeight;
                    if (mode != Integer.MIN_VALUE || i10 <= size) {
                        defaultSize = i10;
                        defaultSize2 = size2;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                } else {
                    int i11 = this.mVideoWidth;
                    int i12 = this.mVideoHeight;
                    if (mode2 == Integer.MIN_VALUE && i12 > size2) {
                        i11 = (i11 * size2) / i12;
                        defaultSize2 = size2;
                    } else {
                        defaultSize2 = i12;
                    }
                    if (mode == Integer.MIN_VALUE && i11 > size) {
                        defaultSize2 = (this.mVideoHeight * size) / this.mVideoWidth;
                        defaultSize = size;
                    } else {
                        defaultSize = i11;
                    }
                }
            }
            if (getRotation() != 0.0f && getRotation() % 90.0f == 0.0f) {
                if (defaultSize3 < defaultSize4) {
                    defaultSize = (int) ((defaultSize * defaultSize3) / defaultSize2);
                    defaultSize2 = defaultSize3;
                } else {
                    defaultSize = (int) ((defaultSize * defaultSize3) / defaultSize2);
                    defaultSize2 = defaultSize3;
                }
            }
        } else if (i5 == 1) {
            defaultSize = setStyleMatchHeight(defaultSize, defaultSize2, this.mVideoWidth, this.mVideoHeight);
        } else if (i5 == 2) {
            defaultSize2 = setStyleMatchWidth(defaultSize, defaultSize2, this.mVideoWidth, this.mVideoHeight);
        } else if (i5 == 3 && (i3 = this.mVideoWidth) > 0 && (i4 = this.mVideoHeight) > 0) {
            if (i3 / i4 <= 1.0f) {
                if (i3 / i4 <= defaultSize / defaultSize2) {
                    defaultSize2 = setStyleMatchWidth(defaultSize, defaultSize2, i3, i4);
                } else {
                    defaultSize = setStyleMatchHeight(defaultSize, defaultSize2, i3, i4);
                }
            } else {
                defaultSize2 = setStyleMatchWidth(defaultSize, defaultSize2, i3, i4);
            }
        }
        BdVideoLog.d(TAG, "setMeasuredDimension **  TextureViewWidth : " + defaultSize + ", TextureViewHeight : " + defaultSize2);
        setMeasuredDimension(defaultSize, defaultSize2);
    }
}
