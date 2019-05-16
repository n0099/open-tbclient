package com.baidu.mario.gldraw2d.d;

import java.nio.FloatBuffer;
/* loaded from: classes2.dex */
public class b extends a {
    private static final float[] FULL_RECTANGLE_COORDS = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private static final float[] FULL_RECTANGLE_TEX_COORDS = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private static final FloatBuffer FULL_RECTANGLE_BUF = com.baidu.mario.gldraw2d.e.a.createFloatBuffer(FULL_RECTANGLE_COORDS);
    private static final FloatBuffer FULL_RECTANGLE_TEX_BUF = com.baidu.mario.gldraw2d.e.a.createFloatBuffer(FULL_RECTANGLE_TEX_COORDS);

    public b() {
        this.mVertexArray = FULL_RECTANGLE_BUF;
        this.mTexCoordArray = FULL_RECTANGLE_TEX_BUF;
        this.mCoordsPerVertex = 2;
        this.mVertexStride = this.mCoordsPerVertex * 4;
        this.mVertexCount = FULL_RECTANGLE_COORDS.length / this.mCoordsPerVertex;
        this.mTexCoordStride = 8;
    }
}
