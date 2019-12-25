package com.baidu.smallgame.sdk.gpuimage.graphics;

import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes9.dex */
public class a {
    public static final float[] IDENTITY_MATRIX = new float[16];
    public static final float[] aUc;
    public static final float[] aUd;
    public static final float[] aUe;

    static {
        Matrix.setIdentityM(IDENTITY_MATRIX, 0);
        aUc = new float[16];
        Matrix.setIdentityM(aUc, 0);
        Matrix.scaleM(aUc, 0, -1.0f, 1.0f, 1.0f);
        aUd = new float[16];
        Matrix.setIdentityM(aUd, 0);
        Matrix.scaleM(aUd, 0, 1.0f, -1.0f, 1.0f);
        aUe = new float[16];
        Matrix.setIdentityM(aUe, 0);
        Matrix.scaleM(aUe, 0, -1.0f, -1.0f, 1.0f);
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
