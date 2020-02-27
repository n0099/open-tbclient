package com.baidu.mario.gldraw2d.d;

import java.nio.FloatBuffer;
/* loaded from: classes11.dex */
public class a {
    protected int mCoordsPerVertex;
    protected FloatBuffer mTexCoordArray;
    protected int mTexCoordStride;
    protected FloatBuffer mVertexArray;
    protected int mVertexCount;
    protected int mVertexStride;

    public FloatBuffer getVertexArray() {
        return this.mVertexArray;
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

    public int getCoordsPerVertex() {
        return this.mCoordsPerVertex;
    }
}
