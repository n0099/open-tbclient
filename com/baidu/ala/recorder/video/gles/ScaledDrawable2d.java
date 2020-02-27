package com.baidu.ala.recorder.video.gles;

import com.baidu.ala.recorder.video.gles.Drawable2d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes3.dex */
public class ScaledDrawable2d extends Drawable2d {
    private static final int SIZEOF_FLOAT = 4;
    private boolean mRecalculate;
    private float mScale;
    private FloatBuffer mTweakedTexCoordArray;

    public ScaledDrawable2d(Drawable2d.Prefab prefab) {
        super(prefab);
        this.mScale = 1.0f;
        this.mRecalculate = true;
    }

    public void setScale(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new RuntimeException("invalid scale " + f);
        }
        this.mScale = f;
        this.mRecalculate = true;
    }

    @Override // com.baidu.ala.recorder.video.gles.Drawable2d
    public FloatBuffer getTexCoordArray() {
        if (this.mRecalculate) {
            FloatBuffer texCoordArray = super.getTexCoordArray();
            int capacity = texCoordArray.capacity();
            if (this.mTweakedTexCoordArray == null) {
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(capacity * 4);
                allocateDirect.order(ByteOrder.nativeOrder());
                this.mTweakedTexCoordArray = allocateDirect.asFloatBuffer();
            }
            FloatBuffer floatBuffer = this.mTweakedTexCoordArray;
            float f = this.mScale;
            for (int i = 0; i < capacity; i++) {
                floatBuffer.put(i, ((texCoordArray.get(i) - 0.5f) * f) + 0.5f);
            }
            this.mRecalculate = false;
        }
        return this.mTweakedTexCoordArray;
    }
}
