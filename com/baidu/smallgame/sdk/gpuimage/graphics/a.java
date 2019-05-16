package com.baidu.smallgame.sdk.gpuimage.graphics;

import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes2.dex */
public class a {
    public static final float[] IDENTITY_MATRIX = new float[16];
    public static final float[] ajC;
    public static final float[] ajD;
    public static final float[] ajE;

    static {
        Matrix.setIdentityM(IDENTITY_MATRIX, 0);
        ajC = new float[16];
        Matrix.setIdentityM(ajC, 0);
        Matrix.scaleM(ajC, 0, -1.0f, 1.0f, 1.0f);
        ajD = new float[16];
        Matrix.setIdentityM(ajD, 0);
        Matrix.scaleM(ajD, 0, 1.0f, -1.0f, 1.0f);
        ajE = new float[16];
        Matrix.setIdentityM(ajE, 0);
        Matrix.scaleM(ajE, 0, -1.0f, -1.0f, 1.0f);
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
