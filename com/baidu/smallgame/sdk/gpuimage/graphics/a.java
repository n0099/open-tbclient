package com.baidu.smallgame.sdk.gpuimage.graphics;

import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes11.dex */
public class a {
    public static final float[] IDENTITY_MATRIX = new float[16];
    public static final float[] bxV;
    public static final float[] bxW;
    public static final float[] bxX;

    static {
        Matrix.setIdentityM(IDENTITY_MATRIX, 0);
        bxV = new float[16];
        Matrix.setIdentityM(bxV, 0);
        Matrix.scaleM(bxV, 0, -1.0f, 1.0f, 1.0f);
        bxW = new float[16];
        Matrix.setIdentityM(bxW, 0);
        Matrix.scaleM(bxW, 0, 1.0f, -1.0f, 1.0f);
        bxX = new float[16];
        Matrix.setIdentityM(bxX, 0);
        Matrix.scaleM(bxX, 0, -1.0f, -1.0f, 1.0f);
    }

    public static FloatBuffer createFloatBuffer(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }
}
