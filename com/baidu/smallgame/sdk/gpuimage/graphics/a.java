package com.baidu.smallgame.sdk.gpuimage.graphics;

import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes2.dex */
public class a {
    public static final float[] IDENTITY_MATRIX = new float[16];
    public static final float[] akC;
    public static final float[] akD;
    public static final float[] akE;

    static {
        Matrix.setIdentityM(IDENTITY_MATRIX, 0);
        akC = new float[16];
        Matrix.setIdentityM(akC, 0);
        Matrix.scaleM(akC, 0, -1.0f, 1.0f, 1.0f);
        akD = new float[16];
        Matrix.setIdentityM(akD, 0);
        Matrix.scaleM(akD, 0, 1.0f, -1.0f, 1.0f);
        akE = new float[16];
        Matrix.setIdentityM(akE, 0);
        Matrix.scaleM(akE, 0, -1.0f, -1.0f, 1.0f);
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
