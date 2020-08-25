package com.baidu.smallgame.sdk.gpuimage.graphics;

import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes20.dex */
public class a {
    public static final float[] IDENTITY_MATRIX = new float[16];
    public static final float[] VERT_FLIP_MATRIX;
    public static final float[] bQl;
    public static final float[] bQm;

    static {
        Matrix.setIdentityM(IDENTITY_MATRIX, 0);
        bQl = new float[16];
        Matrix.setIdentityM(bQl, 0);
        Matrix.scaleM(bQl, 0, -1.0f, 1.0f, 1.0f);
        VERT_FLIP_MATRIX = new float[16];
        Matrix.setIdentityM(VERT_FLIP_MATRIX, 0);
        Matrix.scaleM(VERT_FLIP_MATRIX, 0, 1.0f, -1.0f, 1.0f);
        bQm = new float[16];
        Matrix.setIdentityM(bQm, 0);
        Matrix.scaleM(bQm, 0, -1.0f, -1.0f, 1.0f);
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
