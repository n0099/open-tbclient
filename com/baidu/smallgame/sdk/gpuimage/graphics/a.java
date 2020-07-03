package com.baidu.smallgame.sdk.gpuimage.graphics;

import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes11.dex */
public class a {
    public static final float[] IDENTITY_MATRIX = new float[16];
    public static final float[] bKr;
    public static final float[] bKs;
    public static final float[] bKt;

    static {
        Matrix.setIdentityM(IDENTITY_MATRIX, 0);
        bKr = new float[16];
        Matrix.setIdentityM(bKr, 0);
        Matrix.scaleM(bKr, 0, -1.0f, 1.0f, 1.0f);
        bKs = new float[16];
        Matrix.setIdentityM(bKs, 0);
        Matrix.scaleM(bKs, 0, 1.0f, -1.0f, 1.0f);
        bKt = new float[16];
        Matrix.setIdentityM(bKt, 0);
        Matrix.scaleM(bKt, 0, -1.0f, -1.0f, 1.0f);
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
