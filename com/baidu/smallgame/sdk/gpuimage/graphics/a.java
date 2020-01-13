package com.baidu.smallgame.sdk.gpuimage.graphics;

import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes10.dex */
public class a {
    public static final float[] IDENTITY_MATRIX = new float[16];
    public static final float[] aUU;
    public static final float[] aUV;
    public static final float[] aUW;

    static {
        Matrix.setIdentityM(IDENTITY_MATRIX, 0);
        aUU = new float[16];
        Matrix.setIdentityM(aUU, 0);
        Matrix.scaleM(aUU, 0, -1.0f, 1.0f, 1.0f);
        aUV = new float[16];
        Matrix.setIdentityM(aUV, 0);
        Matrix.scaleM(aUV, 0, 1.0f, -1.0f, 1.0f);
        aUW = new float[16];
        Matrix.setIdentityM(aUW, 0);
        Matrix.scaleM(aUW, 0, -1.0f, -1.0f, 1.0f);
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
