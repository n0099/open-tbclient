package com.baidu.ar.arrender;

import android.content.Context;
import android.graphics.PointF;
import android.opengl.Matrix;
import com.baidu.ar.DuMixInput;
import com.baidu.ar.DuMixOutput;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelRotation;
import com.baidu.ar.arplay.core.engine.rotate.Orientation;
import com.baidu.ar.arplay.core.filter.OutputFillMode;
import com.baidu.ar.bean.MirriorType;
import com.baidu.ar.bean.RotationType;
import com.baidu.ar.bean.ScaleType;
import com.baidu.ar.bean.Size;
import com.baidu.ar.g.q;
import java.util.HashMap;
/* loaded from: classes14.dex */
class b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static PixelRotation a(RotationType rotationType, MirriorType mirriorType) {
        PixelRotation pixelRotation = PixelRotation.NoRotation;
        switch (rotationType) {
            case ROTATE_0:
                return mirriorType == MirriorType.NO_MIRRIOR ? PixelRotation.NoRotation : mirriorType == MirriorType.VERTICAL_MIRRIOR ? PixelRotation.FlipVertical : mirriorType == MirriorType.HORIZONTAL_MIRRIOR ? PixelRotation.FlipHorizontal : pixelRotation;
            case ROTATE_90:
                return mirriorType == MirriorType.NO_MIRRIOR ? PixelRotation.RotateRight : mirriorType == MirriorType.VERTICAL_MIRRIOR ? PixelRotation.RotateRightFlipVertical : mirriorType == MirriorType.HORIZONTAL_MIRRIOR ? PixelRotation.RotateRightFlipHorizontal : pixelRotation;
            case ROTATE_180:
                return mirriorType == MirriorType.NO_MIRRIOR ? PixelRotation.Rotate180 : mirriorType == MirriorType.VERTICAL_MIRRIOR ? PixelRotation.FlipHorizontal : mirriorType == MirriorType.HORIZONTAL_MIRRIOR ? PixelRotation.FlipVertical : pixelRotation;
            case ROTATE_270:
                return mirriorType == MirriorType.NO_MIRRIOR ? PixelRotation.RotateLeft : mirriorType == MirriorType.VERTICAL_MIRRIOR ? PixelRotation.RotateRightFlipHorizontal : mirriorType == MirriorType.HORIZONTAL_MIRRIOR ? PixelRotation.RotateRightFlipVertical : pixelRotation;
            default:
                return pixelRotation;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PixelRotation a(boolean z, RotationType rotationType, MirriorType mirriorType) {
        return z ? PixelRotation.FlipVertical : a(rotationType, mirriorType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OutputFillMode a(ScaleType scaleType) {
        switch (scaleType) {
            case CENTER_CROP:
                return OutputFillMode.KeepRatioCrop;
            case CENTER_INSIDE:
                return OutputFillMode.KeepRatioFill;
            case FIT_XY:
                return OutputFillMode.KeepRatioFill;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Size a(int i, int i2, int i3, int i4) {
        Size size = new Size(i, i2);
        if (i > 0 && i2 > 0 && i3 > 0 && i4 > 0) {
            float f = i / i2;
            float f2 = i3 / i4;
            if (f < f2) {
                size.setWidth((int) (i2 * f2));
                size.setHeight(i2);
            } else if (f > f2) {
                size.setWidth(i);
                size.setHeight((int) (i / f2));
            }
        }
        return size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static HashMap a(Orientation orientation) {
        HashMap hashMap = new HashMap();
        switch (orientation) {
            case PORTRAIT:
                hashMap.put("orient", "portrait");
                break;
            case LANDSCAPE:
                hashMap.put("orient", "landscape_right");
                break;
            case LANDSCAPE_REVERSE:
                hashMap.put("orient", "landscape_left");
                break;
            default:
                hashMap.put("orient", "portrait");
                break;
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, boolean z, PixelReadParams pixelReadParams) {
        if (q.gL()) {
            if (pixelReadParams.getIsPortrait()) {
                if (z) {
                    pixelReadParams.setPixelRotate(PixelRotation.RotateRightFlipVertical);
                } else {
                    pixelReadParams.setPixelRotate(PixelRotation.RotateRight);
                }
            } else if (z) {
                pixelReadParams.setPixelRotate(PixelRotation.Rotate180);
            } else {
                pixelReadParams.setPixelRotate(PixelRotation.NoRotation);
            }
        } else if (!q.gM()) {
            if (q.D(context) && pixelReadParams.getIsPortrait() && z) {
                pixelReadParams.setPixelRotate(PixelRotation.RotateRightFlipVertical);
            }
        } else if (pixelReadParams.getIsPortrait()) {
            if (z) {
                pixelReadParams.setPixelRotate(PixelRotation.RotateRightFlipHorizontal);
            } else {
                pixelReadParams.setPixelRotate(PixelRotation.RotateLeft);
            }
        } else if (z) {
            pixelReadParams.setPixelRotate(PixelRotation.NoRotation);
        } else {
            pixelReadParams.setPixelRotate(PixelRotation.Rotate180);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, float[] fArr, boolean z) {
        Matrix.setIdentityM(fArr, 0);
        if (q.gL() || q.D(context)) {
            Matrix.rotateM(fArr, 0, 90.0f, 0.0f, 0.0f, 1.0f);
            Matrix.translateM(fArr, 0, 0.0f, -1.0f, 0.0f);
            if (z) {
                return;
            }
            Matrix.rotateM(fArr, 0, 180.0f, 0.0f, 1.0f, 0.0f);
            Matrix.translateM(fArr, 0, -1.0f, 0.0f, 0.0f);
        } else if (q.gM()) {
            Matrix.rotateM(fArr, 0, 270.0f, 0.0f, 0.0f, 1.0f);
            Matrix.translateM(fArr, 0, -1.0f, 0.0f, 0.0f);
            if (z) {
                return;
            }
            Matrix.rotateM(fArr, 0, 180.0f, 0.0f, 1.0f, 0.0f);
            Matrix.translateM(fArr, 0, -1.0f, 0.0f, 0.0f);
        } else if (z) {
            Matrix.rotateM(fArr, 0, 270.0f, 0.0f, 0.0f, 1.0f);
            Matrix.translateM(fArr, 0, -1.0f, 0.0f, 0.0f);
        } else {
            Matrix.rotateM(fArr, 0, 90.0f, 0.0f, 0.0f, 1.0f);
            Matrix.translateM(fArr, 0, 0.0f, -1.0f, 0.0f);
            Matrix.rotateM(fArr, 0, 180.0f, 0.0f, 1.0f, 0.0f);
            Matrix.translateM(fArr, 0, -1.0f, 0.0f, 0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(PointF pointF, boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput, boolean z2) {
        if (pointF == null || duMixInput == null || duMixOutput == null || duMixOutput.getScaleType() == ScaleType.FIT_XY) {
            return;
        }
        float inputHeight = z ? duMixInput.getInputHeight() / duMixInput.getInputWidth() : duMixInput.getInputWidth() / duMixInput.getInputHeight();
        float outputHeight = z2 ? duMixOutput.getOutputHeight() / duMixOutput.getOutputWidth() : duMixOutput.getOutputWidth() / duMixOutput.getOutputHeight();
        if (inputHeight != outputHeight) {
            float f = pointF.x;
            float f2 = pointF.y;
            if (inputHeight >= outputHeight) {
                switch (duMixOutput.getScaleType()) {
                    case CENTER_CROP:
                        f = ((((f * 2.0f) - 1.0f) * inputHeight) + outputHeight) / (outputHeight * 2.0f);
                        break;
                }
            } else {
                switch (duMixOutput.getScaleType()) {
                    case CENTER_CROP:
                        float f3 = 1.0f / outputHeight;
                        f2 = ((((f2 * 2.0f) - 1.0f) * (1.0f / inputHeight)) + f3) / (f3 * 2.0f);
                        break;
                }
            }
            pointF.set(f, f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Size b(int i, int i2, int i3, int i4) {
        Size size = new Size(i, i2);
        if (i > 0 && i2 > 0 && i3 > 0 && i4 > 0) {
            float f = i / i2;
            float f2 = i3 / i4;
            if (f > f2) {
                size.setWidth((int) (i2 * f2));
                size.setHeight(i2);
            } else if (f < f2) {
                size.setWidth(i);
                size.setHeight((int) (i / f2));
            }
        }
        return size;
    }
}
