package com.baidu.smallgame.sdk.gpuimage.graphics;

import java.nio.FloatBuffer;
/* loaded from: classes2.dex */
public class Drawable2d {
    private Prefab aDF;
    private static final float[] TRIANGLE_COORDS = {0.0f, 0.57735026f, -0.5f, -0.28867513f, 0.5f, -0.28867513f};
    private static final float[] TRIANGLE_TEX_COORDS = {0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private static final FloatBuffer TRIANGLE_BUF = a.createFloatBuffer(TRIANGLE_COORDS);
    private static final FloatBuffer TRIANGLE_TEX_BUF = a.createFloatBuffer(TRIANGLE_TEX_COORDS);
    private static final float[] RECTANGLE_COORDS = {-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};
    private static final float[] RECTANGLE_TEX_COORDS = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private static final FloatBuffer RECTANGLE_BUF = a.createFloatBuffer(RECTANGLE_COORDS);
    private static final FloatBuffer RECTANGLE_TEX_BUF = a.createFloatBuffer(RECTANGLE_TEX_COORDS);
    private static final float[] FULL_RECTANGLE_COORDS = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private static final float[] aDB = {1.0f, -1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f};
    private static final float[] FULL_RECTANGLE_TEX_COORDS = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private static final float[] aDC = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final FloatBuffer FULL_RECTANGLE_BUF = a.createFloatBuffer(FULL_RECTANGLE_COORDS);
    public static final FloatBuffer aDD = a.createFloatBuffer(aDB);
    public static final FloatBuffer FULL_RECTANGLE_TEX_BUF = a.createFloatBuffer(FULL_RECTANGLE_TEX_COORDS);
    public static final FloatBuffer aDE = a.createFloatBuffer(aDC);

    /* loaded from: classes2.dex */
    public enum Prefab {
        TRIANGLE,
        RECTANGLE,
        FULL_RECTANGLE,
        FULL_RECTANGLE_MIRRORED
    }

    public String toString() {
        return this.aDF != null ? "[Drawable2d: " + this.aDF + "]" : "[Drawable2d: ...]";
    }
}
