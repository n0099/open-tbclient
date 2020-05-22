package com.baidu.smallgame.sdk.gpuimage.graphics;

import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes11.dex */
public class a {
    public static final float[] IDENTITY_MATRIX = new float[16];
    public static final float[] bFD;
    public static final float[] bFE;
    public static final float[] bFF;

    static {
        Matrix.setIdentityM(IDENTITY_MATRIX, 0);
        bFD = new float[16];
        Matrix.setIdentityM(bFD, 0);
        Matrix.scaleM(bFD, 0, -1.0f, 1.0f, 1.0f);
        bFE = new float[16];
        Matrix.setIdentityM(bFE, 0);
        Matrix.scaleM(bFE, 0, 1.0f, -1.0f, 1.0f);
        bFF = new float[16];
        Matrix.setIdentityM(bFF, 0);
        Matrix.scaleM(bFF, 0, -1.0f, -1.0f, 1.0f);
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
