package com.baidu.mario.gldraw2d.e;

import android.opengl.Matrix;
import android.util.Log;
import com.baidu.mario.gldraw2d.d.c;
import com.baidu.mario.gldraw2d.d.d;
import com.baidu.mario.gldraw2d.params.MirrorType;
import com.baidu.mario.gldraw2d.params.ScaleType;
/* loaded from: classes11.dex */
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
                    f = 1.0f;
                    f2 = 1.0f;
                    break;
                case FIT_CENTER:
                    if (width > width2) {
                        f = width2 / width;
                        f2 = 1.0f;
                        break;
                    } else {
                        f2 = width / width2;
                        f = 1.0f;
                        break;
                    }
                case CENTER_CROP:
                    if (width > width2) {
                        f2 = width / width2;
                        f = 1.0f;
                        break;
                    } else {
                        f = width2 / width;
                        f2 = 1.0f;
                        break;
                    }
                case EQUAL_SCALE:
                    f2 = f;
                    break;
                default:
                    f = 1.0f;
                    f2 = 1.0f;
                    break;
            }
            Matrix.scaleM(fArr, 0, f2, f, 1.0f);
        }
    }

    public static void a(float[] fArr, float f, float f2) {
        Matrix.translateM(fArr, 0, f, f2, 1.0f);
    }

    public static void v(float[] fArr) {
        Matrix.setIdentityM(fArr, 0);
    }
}
