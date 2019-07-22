package com.baidu.smallgame.sdk.gpuimage.graphics;

import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes2.dex */
public class a {
    public static final float[] IDENTITY_MATRIX = new float[16];
    public static final float[] ake;
    public static final float[] akf;
    public static final float[] akg;

    static {
        Matrix.setIdentityM(IDENTITY_MATRIX, 0);
        ake = new float[16];
        Matrix.setIdentityM(ake, 0);
        Matrix.scaleM(ake, 0, -1.0f, 1.0f, 1.0f);
        akf = new float[16];
        Matrix.setIdentityM(akf, 0);
        Matrix.scaleM(akf, 0, 1.0f, -1.0f, 1.0f);
        akg = new float[16];
        Matrix.setIdentityM(akg, 0);
        Matrix.scaleM(akg, 0, -1.0f, -1.0f, 1.0f);
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
