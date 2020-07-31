package com.baidu.smallgame.sdk.gpuimage.graphics;

import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes10.dex */
public class a {
    public static final float[] IDENTITY_MATRIX = new float[16];
    public static final float[] bKN;
    public static final float[] bKO;
    public static final float[] bKP;

    static {
        Matrix.setIdentityM(IDENTITY_MATRIX, 0);
        bKN = new float[16];
        Matrix.setIdentityM(bKN, 0);
        Matrix.scaleM(bKN, 0, -1.0f, 1.0f, 1.0f);
        bKO = new float[16];
        Matrix.setIdentityM(bKO, 0);
        Matrix.scaleM(bKO, 0, 1.0f, -1.0f, 1.0f);
        bKP = new float[16];
        Matrix.setIdentityM(bKP, 0);
        Matrix.scaleM(bKP, 0, -1.0f, -1.0f, 1.0f);
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
