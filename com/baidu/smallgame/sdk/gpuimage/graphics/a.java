package com.baidu.smallgame.sdk.gpuimage.graphics;

import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes14.dex */
public class a {
    public static final float[] IDENTITY_MATRIX = new float[16];
    public static final float[] VERT_FLIP_MATRIX;
    public static final float[] cCm;
    public static final float[] cCn;

    static {
        Matrix.setIdentityM(IDENTITY_MATRIX, 0);
        cCm = new float[16];
        Matrix.setIdentityM(cCm, 0);
        Matrix.scaleM(cCm, 0, -1.0f, 1.0f, 1.0f);
        VERT_FLIP_MATRIX = new float[16];
        Matrix.setIdentityM(VERT_FLIP_MATRIX, 0);
        Matrix.scaleM(VERT_FLIP_MATRIX, 0, 1.0f, -1.0f, 1.0f);
        cCn = new float[16];
        Matrix.setIdentityM(cCn, 0);
        Matrix.scaleM(cCn, 0, -1.0f, -1.0f, 1.0f);
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
