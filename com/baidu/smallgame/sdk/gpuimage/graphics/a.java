package com.baidu.smallgame.sdk.gpuimage.graphics;

import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes2.dex */
public class a {
    public static final float[] IDENTITY_MATRIX = new float[16];
    public static final float[] aDG;
    public static final float[] aDH;
    public static final float[] aDI;

    static {
        Matrix.setIdentityM(IDENTITY_MATRIX, 0);
        aDG = new float[16];
        Matrix.setIdentityM(aDG, 0);
        Matrix.scaleM(aDG, 0, -1.0f, 1.0f, 1.0f);
        aDH = new float[16];
        Matrix.setIdentityM(aDH, 0);
        Matrix.scaleM(aDH, 0, 1.0f, -1.0f, 1.0f);
        aDI = new float[16];
        Matrix.setIdentityM(aDI, 0);
        Matrix.scaleM(aDI, 0, -1.0f, -1.0f, 1.0f);
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
