package com.baidu.smallgame.sdk.gpuimage.graphics;

import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes2.dex */
public class a {
    public static final float[] IDENTITY_MATRIX = new float[16];
    public static final float[] ajj;
    public static final float[] ajk;
    public static final float[] ajl;

    static {
        Matrix.setIdentityM(IDENTITY_MATRIX, 0);
        ajj = new float[16];
        Matrix.setIdentityM(ajj, 0);
        Matrix.scaleM(ajj, 0, -1.0f, 1.0f, 1.0f);
        ajk = new float[16];
        Matrix.setIdentityM(ajk, 0);
        Matrix.scaleM(ajk, 0, 1.0f, -1.0f, 1.0f);
        ajl = new float[16];
        Matrix.setIdentityM(ajl, 0);
        Matrix.scaleM(ajl, 0, -1.0f, -1.0f, 1.0f);
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
