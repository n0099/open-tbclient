package com.baidu.ala.dumixar.gles;

import java.nio.FloatBuffer;
/* loaded from: classes2.dex */
public class Drawable2d {
    private static final int SIZEOF_FLOAT = 4;
    private int mCoordsPerVertex;
    private Prefab mPrefab;
    private FloatBuffer mTexCoordArray;
    private FloatBuffer mTexCoordArray2;
    private int mTexCoordStride;
    private FloatBuffer mVertexArray;
    private int mVertexCount;
    private int mVertexStride;
    private static final float[] TRIANGLE_COORDS = {0.0f, 0.57735026f, -0.5f, -0.28867513f, 0.5f, -0.28867513f};
    private static final float[] TRIANGLE_TEX_COORDS = {0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private static final FloatBuffer TRIANGLE_BUF = GlUtil.createFloatBuffer(TRIANGLE_COORDS);
    private static final FloatBuffer TRIANGLE_TEX_BUF = GlUtil.createFloatBuffer(TRIANGLE_TEX_COORDS);
    private static final float[] RECTANGLE_COORDS = {-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};
    private static final float[] RECTANGLE_TEX_COORDS = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private static final FloatBuffer RECTANGLE_BUF = GlUtil.createFloatBuffer(RECTANGLE_COORDS);
    private static final FloatBuffer RECTANGLE_TEX_BUF = GlUtil.createFloatBuffer(RECTANGLE_TEX_COORDS);
    private static final float[] FULL_RECTANGLE_COORDS = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private static final float[] FULL_RECTANGLE_TEX_COORDS = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private static final FloatBuffer FULL_RECTANGLE_BUF = GlUtil.createFloatBuffer(FULL_RECTANGLE_COORDS);
    private static final FloatBuffer FULL_RECTANGLE_TEX_BUF = GlUtil.createFloatBuffer(FULL_RECTANGLE_TEX_COORDS);
    private static final FloatBuffer FULL_RECTANGLE_TEX_BUF2 = GlUtil.createFloatBuffer(FULL_RECTANGLE_TEX_COORDS);

    /* loaded from: classes2.dex */
    public enum Prefab {
        TRIANGLE,
        RECTANGLE,
        FULL_RECTANGLE
    }

    public Drawable2d(Prefab prefab) {
        switch (prefab) {
            case TRIANGLE:
                this.mVertexArray = TRIANGLE_BUF;
                this.mTexCoordArray = TRIANGLE_TEX_BUF;
                this.mCoordsPerVertex = 2;
                this.mVertexStride = this.mCoordsPerVertex * 4;
                this.mVertexCount = TRIANGLE_COORDS.length / this.mCoordsPerVertex;
                break;
            case RECTANGLE:
                this.mVertexArray = RECTANGLE_BUF;
                this.mTexCoordArray = RECTANGLE_TEX_BUF;
                this.mCoordsPerVertex = 2;
                this.mVertexStride = this.mCoordsPerVertex * 4;
                this.mVertexCount = RECTANGLE_COORDS.length / this.mCoordsPerVertex;
                break;
            case FULL_RECTANGLE:
                this.mVertexArray = FULL_RECTANGLE_BUF;
                this.mTexCoordArray = FULL_RECTANGLE_TEX_BUF;
                this.mTexCoordArray2 = FULL_RECTANGLE_TEX_BUF2;
                this.mCoordsPerVertex = 2;
                this.mVertexStride = this.mCoordsPerVertex * 4;
                this.mVertexCount = FULL_RECTANGLE_COORDS.length / this.mCoordsPerVertex;
                break;
            default:
                throw new RuntimeException("Unknown shape " + prefab);
        }
        this.mTexCoordStride = 8;
        this.mPrefab = prefab;
    }

    public FloatBuffer getVertexArray() {
        return this.mVertexArray;
    }

    public void setScale(float f, float f2) {
        this.mVertexArray.put(new float[]{(-1.0f) * f2, (-1.0f) * f, 1.0f * f2, (-1.0f) * f, (-1.0f) * f2, 1.0f * f, 1.0f * f2, 1.0f * f});
        this.mVertexArray.position(0);
    }

    public void setScaleAndTranslate(float f, float f2, float f3, float f4) {
        float[] fArr = new float[8];
        fArr[0] = (-1.0f) * f;
        fArr[1] = (-1.0f) * f2;
        fArr[2] = 1.0f * f;
        fArr[3] = (-1.0f) * f2;
        fArr[4] = (-1.0f) * f;
        fArr[5] = 1.0f * f2;
        fArr[6] = 1.0f * f;
        fArr[7] = 1.0f * f2;
        for (int i = 0; i < fArr.length; i++) {
            if (i % 2 == 0) {
                fArr[i] = fArr[i] + f3;
            } else if (i == 1 || i == 3) {
                fArr[i] = fArr[i] + f4;
            } else {
                fArr[i] = (float) (fArr[i] + (f4 / 1.25d));
            }
        }
        this.mVertexArray.put(fArr);
        this.mVertexArray.position(0);
    }

    public FloatBuffer getTexCoordArray() {
        return this.mTexCoordArray;
    }

    public int getVertexCount() {
        return this.mVertexCount;
    }

    public int getVertexStride() {
        return this.mVertexStride;
    }

    public int getTexCoordStride() {
        return this.mTexCoordStride;
    }

    public FloatBuffer getTexCoordArray2() {
        return this.mTexCoordArray2;
    }

    public int getCoordsPerVertex() {
        return this.mCoordsPerVertex;
    }

    public String toString() {
        return this.mPrefab != null ? "[Drawable2d: " + this.mPrefab + "]" : "[Drawable2d: ...]";
    }
}
