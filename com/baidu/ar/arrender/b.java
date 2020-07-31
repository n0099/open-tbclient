package com.baidu.ar.arrender;

import android.graphics.PointF;
import com.baidu.ar.DuMixInput;
import com.baidu.ar.DuMixOutput;
import com.baidu.ar.arplay.core.engine.pixel.PixelRotation;
import com.baidu.ar.arplay.core.engine.rotate.Orientation;
import com.baidu.ar.arplay.core.filter.OutputFillMode;
import com.baidu.ar.bean.Size;
import java.util.HashMap;
/* loaded from: classes11.dex */
class b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static PixelRotation a(DuMixOutput.b bVar, DuMixOutput.a aVar) {
        PixelRotation pixelRotation = PixelRotation.NoRotation;
        switch (bVar) {
            case ROTATE_0:
                return aVar == DuMixOutput.a.NO_MIRRIOR ? PixelRotation.NoRotation : aVar == DuMixOutput.a.MIRRIOR_VERTICAL ? PixelRotation.FlipVertical : aVar == DuMixOutput.a.MIRRIOR_HORIZONTAL ? PixelRotation.FlipHorizontal : pixelRotation;
            case ROTATE_90:
                return aVar == DuMixOutput.a.NO_MIRRIOR ? PixelRotation.RotateRight : aVar == DuMixOutput.a.MIRRIOR_VERTICAL ? PixelRotation.RotateRightFlipVertical : aVar == DuMixOutput.a.MIRRIOR_HORIZONTAL ? PixelRotation.RotateRightFlipHorizontal : pixelRotation;
            case ROTATE_180:
                return aVar == DuMixOutput.a.NO_MIRRIOR ? PixelRotation.Rotate180 : aVar == DuMixOutput.a.MIRRIOR_VERTICAL ? PixelRotation.FlipHorizontal : aVar == DuMixOutput.a.MIRRIOR_HORIZONTAL ? PixelRotation.FlipVertical : pixelRotation;
            case ROTATE_270:
                return aVar == DuMixOutput.a.NO_MIRRIOR ? PixelRotation.RotateLeft : aVar == DuMixOutput.a.MIRRIOR_VERTICAL ? PixelRotation.RotateRightFlipHorizontal : aVar == DuMixOutput.a.MIRRIOR_HORIZONTAL ? PixelRotation.RotateRightFlipVertical : pixelRotation;
            default:
                return pixelRotation;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PixelRotation a(boolean z, int i) {
        if (z) {
            return PixelRotation.FlipVertical;
        }
        switch (Math.abs(i % 360)) {
            case 0:
                return PixelRotation.FlipVertical;
            case 90:
                return PixelRotation.RotateRightFlipVertical;
            case 180:
                return PixelRotation.FlipHorizontal;
            case 270:
                return PixelRotation.RotateRightFlipHorizontal;
            default:
                return PixelRotation.FlipVertical;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OutputFillMode a(DuMixOutput.c cVar) {
        switch (cVar) {
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
    public static void a(PointF pointF, boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
        float f;
        float f2;
        if (pointF == null || duMixInput == null || duMixOutput == null || duMixOutput.getScaleType() == DuMixOutput.c.FIT_XY) {
            return;
        }
        float inputHeight = z ? duMixInput.getInputHeight() / duMixInput.getInputWidth() : duMixInput.getInputWidth() / duMixInput.getInputHeight();
        float outputWidth = duMixOutput.getOutputWidth() / duMixOutput.getOutputHeight();
        if (inputHeight != outputWidth) {
            float f3 = pointF.x;
            float f4 = pointF.y;
            if (inputHeight >= outputWidth) {
                switch (duMixOutput.getScaleType()) {
                    case CENTER_CROP:
                        f2 = ((inputHeight * ((f3 * 2.0f) - 1.0f)) + outputWidth) / (2.0f * outputWidth);
                        f = f4;
                        break;
                    case CENTER_INSIDE:
                        f = f4;
                        f2 = f3;
                        break;
                    default:
                        f = f4;
                        f2 = f3;
                        break;
                }
            } else {
                switch (duMixOutput.getScaleType()) {
                    case CENTER_CROP:
                        float f5 = 1.0f / outputWidth;
                        f = (((1.0f / inputHeight) * ((f4 * 2.0f) - 1.0f)) + f5) / (2.0f * f5);
                        f2 = f3;
                        break;
                    case CENTER_INSIDE:
                        f = f4;
                        f2 = f3;
                        break;
                    default:
                        f = f4;
                        f2 = f3;
                        break;
                }
            }
            pointF.set(f2, f);
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
