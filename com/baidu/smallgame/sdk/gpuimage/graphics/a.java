package com.baidu.smallgame.sdk.gpuimage.graphics;

import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes2.dex */
public class a {
    public static final float[] IDENTITY_MATRIX = new float[16];
    public static final float[] ajp;
    public static final float[] ajq;
    public static final float[] ajr;

    static {
        Matrix.setIdentityM(IDENTITY_MATRIX, 0);
        ajp = new float[16];
        Matrix.setIdentityM(ajp, 0);
        Matrix.scaleM(ajp, 0, -1.0f, 1.0f, 1.0f);
        ajq = new float[16];
        Matrix.setIdentityM(ajq, 0);
        Matrix.scaleM(ajq, 0, 1.0f, -1.0f, 1.0f);
        ajr = new float[16];
        Matrix.setIdentityM(ajr, 0);
        Matrix.scaleM(ajr, 0, -1.0f, -1.0f, 1.0f);
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
