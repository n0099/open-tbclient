package com.baidu.smallgame.sdk.gpuimage.graphics;

import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes11.dex */
public class a {
    public static final float[] IDENTITY_MATRIX = new float[16];
    public static final float[] aZv;
    public static final float[] aZw;
    public static final float[] aZx;

    static {
        Matrix.setIdentityM(IDENTITY_MATRIX, 0);
        aZv = new float[16];
        Matrix.setIdentityM(aZv, 0);
        Matrix.scaleM(aZv, 0, -1.0f, 1.0f, 1.0f);
        aZw = new float[16];
        Matrix.setIdentityM(aZw, 0);
        Matrix.scaleM(aZw, 0, 1.0f, -1.0f, 1.0f);
        aZx = new float[16];
        Matrix.setIdentityM(aZx, 0);
        Matrix.scaleM(aZx, 0, -1.0f, -1.0f, 1.0f);
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
