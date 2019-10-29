package com.baidu.smallgame.sdk.gpuimage.graphics;

import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes2.dex */
public class a {
    public static final float[] IDENTITY_MATRIX = new float[16];
    public static final float[] aDY;
    public static final float[] aDZ;
    public static final float[] aEa;

    static {
        Matrix.setIdentityM(IDENTITY_MATRIX, 0);
        aDY = new float[16];
        Matrix.setIdentityM(aDY, 0);
        Matrix.scaleM(aDY, 0, -1.0f, 1.0f, 1.0f);
        aDZ = new float[16];
        Matrix.setIdentityM(aDZ, 0);
        Matrix.scaleM(aDZ, 0, 1.0f, -1.0f, 1.0f);
        aEa = new float[16];
        Matrix.setIdentityM(aEa, 0);
        Matrix.scaleM(aEa, 0, -1.0f, -1.0f, 1.0f);
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
