package com.baidu.cyberplayer.sdk;
/* loaded from: classes3.dex */
public class CyberRenderSizeHelper {
    public static final String TAG = "CyberRenderSizeHelper";
    public int mDisplayMode;
    public float[] mDisplayScale;
    public float[] mDisplayTranslate;
    public int mSurfaceWidth = 0;
    public int mSurfaceHeight = 0;
    public int mVideoSarNum = 1;
    public int mVideoSarDen = 1;
    public int mClientRotation = 0;
    public int mRawFrameRotation = 0;
    public int mDrawFrameRotation = 0;
    public int mVideoWidth = 0;
    public int mVideoHeight = 0;

    public CyberRenderSizeHelper() {
        this.mDisplayMode = 0;
        this.mDisplayScale = r3;
        float[] fArr = {1.0f, 1.0f};
        this.mDisplayTranslate = r3;
        float[] fArr2 = {0.0f, 0.0f};
        this.mDisplayMode = 2;
    }

    public int getDisplayMode() {
        return this.mDisplayMode;
    }

    public float[] getDisplayScale() {
        return this.mDisplayScale;
    }

    public float[] getDisplayTranslate() {
        return this.mDisplayTranslate;
    }

    public int getDrawFrameRotation() {
        return this.mDrawFrameRotation;
    }

    public int getSurfaceHeight() {
        return this.mSurfaceHeight;
    }

    public int getSurfaceWidth() {
        return this.mSurfaceWidth;
    }

    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public boolean isNeedTranslate() {
        int i = this.mDisplayMode;
        if (i != 7 && i != 8 && i != 9 && i != 10) {
            return false;
        }
        return true;
    }

    public void reset() {
        this.mSurfaceWidth = 0;
        this.mSurfaceHeight = 0;
        this.mVideoSarNum = 1;
        this.mVideoSarDen = 1;
        this.mClientRotation = 0;
        this.mRawFrameRotation = 0;
        this.mDrawFrameRotation = 0;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        float[] fArr = this.mDisplayScale;
        fArr[0] = 1.0f;
        fArr[1] = 1.0f;
        this.mDisplayMode = 2;
    }

    public void resetForSurfaceReuse() {
        this.mVideoSarNum = 1;
        this.mVideoSarDen = 1;
        this.mClientRotation = 0;
        this.mRawFrameRotation = 0;
        this.mDrawFrameRotation = 0;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        float[] fArr = this.mDisplayScale;
        fArr[0] = 1.0f;
        fArr[1] = 1.0f;
        this.mDisplayMode = 2;
    }

    public boolean onClientRotationChanged(int i) {
        if (this.mClientRotation != i) {
            this.mClientRotation = i;
            this.mDrawFrameRotation = ((360 - this.mRawFrameRotation) + i) % 360;
            return true;
        }
        return false;
    }

    public boolean onDisplayModeChanged(int i) {
        if (this.mDisplayMode != i) {
            this.mDisplayMode = i;
            return true;
        }
        return false;
    }

    public boolean onRawFrameRotationChanged(int i) {
        if (this.mRawFrameRotation != i) {
            this.mRawFrameRotation = i;
            this.mDrawFrameRotation = ((this.mClientRotation + 360) - i) % 360;
            return true;
        }
        return false;
    }

    public boolean onSurfaceSizeChanged(int i, int i2) {
        if (this.mSurfaceWidth == i && this.mSurfaceHeight == i2) {
            return false;
        }
        this.mSurfaceWidth = i;
        this.mSurfaceHeight = i2;
        return true;
    }

    public boolean onVideoSizeChanged(int i, int i2, int i3, int i4) {
        if (this.mVideoWidth == i && i2 == this.mVideoHeight && this.mVideoSarNum == i3 && this.mVideoSarDen == i4) {
            return false;
        }
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        if (i4 != 0 && i3 != 0) {
            this.mVideoSarNum = i3;
            this.mVideoSarDen = i4;
        } else {
            this.mVideoSarNum = 1;
            this.mVideoSarDen = 1;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bc, code lost:
        if (r5 > r3) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0100, code lost:
        if (0.5625f > r3) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0107, code lost:
        if (0.75f > r3) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x010f, code lost:
        if (0.8f > r3) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0111, code lost:
        r3 = r3 / r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0113, code lost:
        r5 = r0 / r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0118, code lost:
        if (r5 > r3) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0121, code lost:
        if (r5 > r3) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x011b A[PHI: r4 r7 
      PHI: (r4v1 float) = (r4v0 float), (r4v6 float) binds: [B:31:0x00b7, B:70:0x0126] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r7v2 float) = (r7v1 float), (r7v4 float) binds: [B:31:0x00b7, B:70:0x0126] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateDisplaySize() {
        boolean z;
        int i;
        float f;
        int i2;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        if (this.mSurfaceWidth != 0 && this.mSurfaceHeight != 0 && this.mVideoWidth != 0 && this.mVideoHeight != 0) {
            int i3 = this.mDisplayMode;
            if (i3 != 0 && i3 != 2) {
                z = false;
            } else {
                z = true;
            }
            float f7 = 1.0f;
            float f8 = (this.mSurfaceHeight * 1.0f) / this.mSurfaceWidth;
            float f9 = (this.mVideoHeight * 1.0f) / this.mVideoWidth;
            int i4 = this.mDrawFrameRotation;
            if ((i4 == 90 || i4 == 270) && (i = this.mVideoHeight) != 0) {
                f9 = (this.mVideoWidth * 1.0f) / i;
                if (z) {
                    f = this.mVideoSarNum * 1.0f;
                    i2 = this.mVideoSarDen;
                    f9 *= f / i2;
                }
                CyberLog.d(TAG, "updateDisplaySize called mVideoWidth:" + this.mVideoWidth + " mVideoHeight:" + this.mVideoHeight + " mVideoSarNum:" + this.mVideoSarNum + " mVideoSarDen:" + this.mVideoSarDen + " mSurfaceWidth:" + this.mSurfaceWidth + " mSurfaceHeight:" + this.mSurfaceHeight + " mDisplayMode:" + this.mDisplayMode);
                float f10 = 0.0f;
                switch (this.mDisplayMode) {
                    case 1:
                        f2 = 0.0f;
                        f3 = 1.0f;
                        break;
                    case 3:
                        f4 = 0.8f;
                        break;
                    case 4:
                        f4 = 0.75f;
                        break;
                    case 5:
                        f4 = 0.5625f;
                        break;
                    case 6:
                        float f11 = (this.mVideoWidth * 1.0f) / this.mSurfaceWidth;
                        f3 = (this.mVideoHeight * 1.0f) / this.mSurfaceHeight;
                        f7 = f11;
                        f2 = 0.0f;
                        break;
                    case 7:
                        if (f9 <= f8) {
                            f5 = f8 / f9;
                            f6 = 1.0f - f5;
                            f10 = f6;
                            f7 = f5;
                            f2 = 0.0f;
                            f3 = 1.0f;
                            break;
                        }
                        f3 = f9 / f8;
                        f2 = 0.0f;
                        break;
                    case 8:
                        if (f9 <= f8) {
                            f5 = f8 / f9;
                            f6 = f5 - 1.0f;
                            f10 = f6;
                            f7 = f5;
                            f2 = 0.0f;
                            f3 = 1.0f;
                            break;
                        }
                        f3 = f9 / f8;
                        f2 = 0.0f;
                        break;
                    case 9:
                        if (f9 > f8) {
                            f3 = f9 / f8;
                            f2 = f3 - 1.0f;
                            break;
                        }
                        f5 = f8 / f9;
                        f7 = f5;
                        f2 = 0.0f;
                        f3 = 1.0f;
                        break;
                    case 10:
                        if (f9 > f8) {
                            f3 = f9 / f8;
                            f2 = 1.0f - f3;
                            break;
                        }
                        f5 = f8 / f9;
                        f7 = f5;
                        f2 = 0.0f;
                        f3 = 1.0f;
                        break;
                }
                float[] fArr = this.mDisplayScale;
                fArr[0] = f7;
                fArr[1] = f3;
                float[] fArr2 = this.mDisplayTranslate;
                fArr2[0] = f10;
                fArr2[1] = f2;
                CyberLog.d(TAG, "updateDisplaySize called sx:" + f7 + " sy:" + f3 + " translateX:" + f10 + " translateY:" + f2);
            }
            if (z) {
                f = this.mVideoSarDen * 1.0f;
                i2 = this.mVideoSarNum;
                f9 *= f / i2;
            }
            CyberLog.d(TAG, "updateDisplaySize called mVideoWidth:" + this.mVideoWidth + " mVideoHeight:" + this.mVideoHeight + " mVideoSarNum:" + this.mVideoSarNum + " mVideoSarDen:" + this.mVideoSarDen + " mSurfaceWidth:" + this.mSurfaceWidth + " mSurfaceHeight:" + this.mSurfaceHeight + " mDisplayMode:" + this.mDisplayMode);
            float f102 = 0.0f;
            switch (this.mDisplayMode) {
            }
            float[] fArr3 = this.mDisplayScale;
            fArr3[0] = f7;
            fArr3[1] = f3;
            float[] fArr22 = this.mDisplayTranslate;
            fArr22[0] = f102;
            fArr22[1] = f2;
            CyberLog.d(TAG, "updateDisplaySize called sx:" + f7 + " sy:" + f3 + " translateX:" + f102 + " translateY:" + f2);
        }
    }
}
