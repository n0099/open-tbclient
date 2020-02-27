package com.baidu.smallgame.sdk.gpuimage.graphics;

import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes11.dex */
public class a {
    public static final float[] IDENTITY_MATRIX = new float[16];
    public static final float[] aZg;
    public static final float[] aZh;
    public static final float[] aZi;

    static {
        Matrix.setIdentityM(IDENTITY_MATRIX, 0);
        aZg = new float[16];
        Matrix.setIdentityM(aZg, 0);
        Matrix.scaleM(aZg, 0, -1.0f, 1.0f, 1.0f);
        aZh = new float[16];
        Matrix.setIdentityM(aZh, 0);
        Matrix.scaleM(aZh, 0, 1.0f, -1.0f, 1.0f);
        aZi = new float[16];
        Matrix.setIdentityM(aZi, 0);
        Matrix.scaleM(aZi, 0, -1.0f, -1.0f, 1.0f);
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
