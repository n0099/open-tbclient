package com.baidu.mario.gldraw2d.e;

import android.opengl.Matrix;
import android.util.Log;
import com.baidu.mario.gldraw2d.d.c;
import com.baidu.mario.gldraw2d.d.d;
import com.baidu.mario.gldraw2d.params.MirrorType;
import com.baidu.mario.gldraw2d.params.ScaleType;
/* loaded from: classes15.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();

    public static void a(float[] fArr, MirrorType mirrorType) {
        if (fArr == null) {
            Log.e(TAG, "mirrorDraw2DMVP mvpMatrix == NULLLLLLL!!!");
        }
        if (mirrorType == MirrorType.HORIZONTALLY) {
            Matrix.rotateM(fArr, 0, 180.0f, 0.0f, 1.0f, 0.0f);
        } else if (mirrorType == MirrorType.VERTICALLY) {
            Matrix.rotateM(fArr, 0, 180.0f, 1.0f, 0.0f, 0.0f);
            fArr[6] = 0.0f;
            fArr[9] = 0.0f;
        }
    }

    public static void a(float[] fArr, float f) {
        if (fArr == null) {
            Log.e(TAG, "rotateDraw2DMVP mvpMatrix == NULLLLLLL!!!");
        }
        Matrix.rotateM(fArr, 0, f, 0.0f, 0.0f, 1.0f);
    }

    public static void a(float[] fArr, d dVar, c cVar, ScaleType scaleType, float f) {
        float f2;
        float f3;
        if (fArr == null) {
            Log.e(TAG, "scaleDraw2DMVP mvpMatrix == NULLLLLLL!!!");
        } else if (dVar == null || dVar.getWidth() <= 0 || dVar.getHeight() <= 0) {
            Log.e(TAG, "scaleDraw2DMVP source texture error!!!");
        } else if (cVar == null || cVar.getWidth() <= 0 || cVar.getHeight() <= 0) {
            Log.e(TAG, "scaleDraw2DMVP draw target error!!!");
        } else {
            float width = (dVar.getWidth() * 1.0f) / dVar.getHeight();
            float width2 = (cVar.getWidth() * 1.0f) / cVar.getHeight();
            switch (scaleType) {
                case FIT_XY:
                    f2 = 1.0f;
                    f3 = 1.0f;
                    break;
                case FIT_CENTER:
                    if (width > width2) {
                        f2 = width2 / width;
                        f3 = 1.0f;
                        break;
                    } else {
                        float f4 = width / width2;
                        f2 = 1.0f;
                        f3 = f4;
                        break;
                    }
                case CENTER_CROP:
                    if (width > width2) {
                        float f5 = width / width2;
                        f2 = 1.0f;
                        f3 = f5;
                        break;
                    } else {
                        f2 = width2 / width;
                        f3 = 1.0f;
                        break;
                    }
                case EQUAL_SCALE:
                    f2 = f;
                    f3 = f;
                    break;
                default:
                    f2 = 1.0f;
                    f3 = 1.0f;
                    break;
            }
            Matrix.scaleM(fArr, 0, f3, f2, 1.0f);
        }
    }

    public static void a(float[] fArr, float f, float f2) {
        Matrix.translateM(fArr, 0, f, f2, 1.0f);
    }

    public static void u(float[] fArr) {
        Matrix.setIdentityM(fArr, 0);
    }
}
