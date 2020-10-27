package com.baidu.swan.videoplayer;

import android.util.Log;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes12.dex */
public final class b {
    private int ehA;
    private int ehB;
    private int ehC = 0;
    private WeakReference<View> ehy;
    private int ehz;
    private int mMeasuredHeight;
    private int mMeasuredWidth;
    private int mVideoHeight;
    private int mVideoWidth;

    public b(View view) {
        this.ehy = new WeakReference<>(view);
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    public void setVideoSampleAspectRatio(int i, int i2) {
        this.ehz = i;
        this.ehA = i2;
    }

    public void setVideoRotation(int i) {
        this.ehB = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0104, code lost:
        if (r0 > r2) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void aG(int i, int i2) {
        int i3;
        float f;
        float f2;
        int i4;
        int i5;
        if (this.ehB == 90 || this.ehB == 270) {
            i = i2;
            i2 = i;
        }
        int defaultSize = View.getDefaultSize(this.mVideoWidth, i);
        int defaultSize2 = View.getDefaultSize(this.mVideoHeight, i2);
        if (this.ehC != 3) {
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                int mode = View.MeasureSpec.getMode(i);
                int size = View.MeasureSpec.getSize(i);
                int mode2 = View.MeasureSpec.getMode(i2);
                int size2 = View.MeasureSpec.getSize(i2);
                if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
                    float f3 = size / size2;
                    switch (this.ehC) {
                        case 4:
                            f = 1.7777778f;
                            if (this.ehB == 90 || this.ehB == 270) {
                                f2 = 1.0f / 1.7777778f;
                                break;
                            }
                            f2 = f;
                            break;
                        case 5:
                            f = 1.3333334f;
                            if (this.ehB == 90 || this.ehB == 270) {
                                f2 = 1.0f / 1.3333334f;
                                break;
                            }
                            f2 = f;
                            break;
                        default:
                            f = this.mVideoWidth / this.mVideoHeight;
                            if (this.ehz > 0 && this.ehA > 0) {
                                f2 = (f * this.ehz) / this.ehA;
                                break;
                            }
                            f2 = f;
                            break;
                    }
                    boolean z = f2 > f3;
                    switch (this.ehC) {
                        case 0:
                        case 4:
                        case 5:
                            if (z) {
                                i4 = (int) (size / f2);
                                i5 = size;
                                break;
                            } else {
                                i5 = (int) (size2 * f2);
                                i4 = size2;
                                break;
                            }
                        case 1:
                            if (z) {
                                i5 = (int) (size2 * f2);
                                i4 = size2;
                                break;
                            } else {
                                i4 = (int) (size / f2);
                                i5 = size;
                                break;
                            }
                        case 2:
                        case 3:
                        default:
                            if (z) {
                                i5 = Math.min(this.mVideoWidth, size);
                                i4 = (int) (i5 / f2);
                                break;
                            } else {
                                i4 = Math.min(this.mVideoHeight, size2);
                                i5 = (int) (i4 * f2);
                                break;
                            }
                    }
                    size = i5;
                    size2 = i4;
                } else if (mode == 1073741824 && mode2 == 1073741824) {
                    if (this.mVideoWidth * size2 < this.mVideoHeight * size) {
                        size = (this.mVideoWidth * size2) / this.mVideoHeight;
                    } else if (this.mVideoWidth * size2 > this.mVideoHeight * size) {
                        size2 = (this.mVideoHeight * size) / this.mVideoWidth;
                    }
                } else if (mode == 1073741824) {
                    int i6 = (this.mVideoHeight * size) / this.mVideoWidth;
                    if (mode2 != Integer.MIN_VALUE || i6 <= size2) {
                        size2 = i6;
                    }
                } else if (mode2 == 1073741824) {
                    i3 = (this.mVideoWidth * size2) / this.mVideoHeight;
                    if (mode == Integer.MIN_VALUE) {
                    }
                    size = i3;
                } else {
                    int i7 = this.mVideoWidth;
                    int i8 = this.mVideoHeight;
                    if (mode2 != Integer.MIN_VALUE || i8 <= size2) {
                        size2 = i8;
                        i3 = i7;
                    } else {
                        i3 = (this.mVideoWidth * size2) / this.mVideoHeight;
                    }
                    if (mode == Integer.MIN_VALUE && i3 > size) {
                        size2 = (this.mVideoHeight * size) / this.mVideoWidth;
                    }
                    size = i3;
                }
                i2 = size2;
                i = size;
            } else {
                Log.d("MeasureHelper", "no size yet");
                i2 = defaultSize2;
                i = defaultSize;
            }
        }
        this.mMeasuredWidth = i;
        this.mMeasuredHeight = i2;
    }

    public int bbX() {
        return this.mMeasuredWidth;
    }

    public int bbY() {
        return this.mMeasuredHeight;
    }

    public void setAspectRatio(int i) {
        this.ehC = i;
    }
}
