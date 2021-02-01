package com.baidu.ala.recorder.video.gles;

import android.annotation.TargetApi;
import android.opengl.GLES20;
@TargetApi(16)
/* loaded from: classes6.dex */
public class FrameBuffer {
    private int[] mFrameBuffer;
    private int lastWidth = 0;
    private int lastHeight = 0;

    public int bindFrameBuffer(int i, int i2) {
        return bindFrameBuffer(i, i2, false);
    }

    public int bindFrameBuffer(int i, int i2, boolean z) {
        if (this.lastWidth != i || this.lastHeight != i2) {
            destroyFrameBuffer();
            this.lastWidth = i;
            this.lastHeight = i2;
        }
        return this.mFrameBuffer == null ? createFrameBuffer(z, i, i2, 3553, 6408, 9729, 9729, 33071, 33071) : bindFrameBuffer();
    }

    public int bindFrameBuffer() {
        if (this.mFrameBuffer == null) {
            return -1;
        }
        GLES20.glGetIntegerv(36006, this.mFrameBuffer, 3);
        GLES20.glBindFramebuffer(36160, this.mFrameBuffer[0]);
        return GLES20.glGetError();
    }

    public int createFrameBuffer(boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.mFrameBuffer = new int[4];
        GLES20.glGenFramebuffers(1, this.mFrameBuffer, 0);
        GLES20.glGenTextures(1, this.mFrameBuffer, 1);
        GLES20.glBindTexture(i3, this.mFrameBuffer[1]);
        GLES20.glTexImage2D(i3, 0, i4, i, i2, 0, i4, 5121, null);
        GLES20.glTexParameteri(i3, 10241, i5);
        GLES20.glTexParameteri(i3, 10240, i6);
        GLES20.glTexParameteri(i3, 10242, i7);
        GLES20.glTexParameteri(i3, 10243, i8);
        GLES20.glGetIntegerv(36006, this.mFrameBuffer, 3);
        GLES20.glBindFramebuffer(36160, this.mFrameBuffer[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, i3, this.mFrameBuffer[1], 0);
        if (z) {
            GLES20.glGenRenderbuffers(1, this.mFrameBuffer, 2);
            GLES20.glBindRenderbuffer(36161, this.mFrameBuffer[2]);
            GLES20.glRenderbufferStorage(36161, 33189, i, i2);
            GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.mFrameBuffer[2]);
        }
        return GLES20.glGetError();
    }

    public void unBindFrameBuffer() {
        if (this.mFrameBuffer != null) {
            GLES20.glBindFramebuffer(36160, this.mFrameBuffer[3]);
        }
    }

    public int getCacheTextureId() {
        if (this.mFrameBuffer != null) {
            return this.mFrameBuffer[1];
        }
        return -1;
    }

    public void destroyFrameBuffer() {
        if (this.mFrameBuffer != null) {
            GLES20.glDeleteFramebuffers(1, this.mFrameBuffer, 0);
            GLES20.glDeleteTextures(1, this.mFrameBuffer, 1);
            if (this.mFrameBuffer[2] > 0) {
                GLES20.glDeleteRenderbuffers(1, this.mFrameBuffer, 2);
            }
            this.mFrameBuffer = null;
        }
    }
}
