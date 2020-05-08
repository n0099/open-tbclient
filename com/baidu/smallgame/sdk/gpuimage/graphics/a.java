package com.baidu.smallgame.sdk.gpuimage.graphics;

import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes11.dex */
public class a {
    public static final float[] IDENTITY_MATRIX = new float[16];
    public static final float[] bya;
    public static final float[] byb;
    public static final float[] byc;

    static {
        Matrix.setIdentityM(IDENTITY_MATRIX, 0);
        bya = new float[16];
        Matrix.setIdentityM(bya, 0);
        Matrix.scaleM(bya, 0, -1.0f, 1.0f, 1.0f);
        byb = new float[16];
        Matrix.setIdentityM(byb, 0);
        Matrix.scaleM(byb, 0, 1.0f, -1.0f, 1.0f);
        byc = new float[16];
        Matrix.setIdentityM(byc, 0);
        Matrix.scaleM(byc, 0, -1.0f, -1.0f, 1.0f);
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
