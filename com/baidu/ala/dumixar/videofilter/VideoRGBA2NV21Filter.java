package com.baidu.ala.dumixar.videofilter;

import android.opengl.GLES20;
import android.util.Log;
import com.baidu.ala.dumixar.gles.GlUtil;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class VideoRGBA2NV21Filter extends VideoFilter {
    private static final String FRAGMENT_SHADER_BGR2NV21 = "precision mediump float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform float inputImageWidth;\nuniform int onlyYColor;\nuniform int isMirrored;const mediump vec3 ycoeff = vec3( 0.257,  0.504,  0.098);\nconst mediump vec3 ucoeff = vec3(-0.148, -0.291,  0.439);\nconst mediump vec3 vcoeff = vec3( 0.439, -0.368, -0.071);\nvoid main() {\n   float widthOfPixel = 1.0 / inputImageWidth;\n   widthOfPixel = isMirrored == 1 ? -widthOfPixel : widthOfPixel;\n   vec2 coords1 = vec2(max(0.0, textureCoordinate.x - 1.5*widthOfPixel), textureCoordinate.y);\n   vec2 coords2 = vec2(max(0.0, textureCoordinate.x - 0.5*widthOfPixel), textureCoordinate.y);\n   vec2 coords3 = vec2(min(1.0, textureCoordinate.x + 0.5*widthOfPixel), textureCoordinate.y);\n   vec2 coords4 = vec2(min(1.0, textureCoordinate.x + 1.5*widthOfPixel), textureCoordinate.y);\n   vec2 coords5 = vec2(max(0.0, textureCoordinate.x - 1.0*widthOfPixel), textureCoordinate.y);\n   vec2 coords6 = vec2(min(1.0, textureCoordinate.x + 1.0*widthOfPixel), textureCoordinate.y);\n\n   float flag = onlyYColor == 1 ? 1.0 : 0.0;\n   gl_FragColor.r = (dot(texture2D(inputImageTexture, coords5).rgb, vcoeff) + 0.5) * (1.0 - flag) + (dot(texture2D(inputImageTexture, coords1).rgb, ycoeff) + 0.0625) * flag;\n   gl_FragColor.g = (dot(texture2D(inputImageTexture, coords5).rgb, ucoeff) + 0.5) * (1.0 - flag) + (dot(texture2D(inputImageTexture, coords2).rgb, ycoeff) + 0.0625) * flag;\n   gl_FragColor.b = (dot(texture2D(inputImageTexture, coords6).rgb, vcoeff) + 0.5) * (1.0 - flag) + (dot(texture2D(inputImageTexture, coords3).rgb, ycoeff) + 0.0625) * flag;\n   gl_FragColor.a = (dot(texture2D(inputImageTexture, coords6).rgb, ucoeff) + 0.5) * (1.0 - flag) + (dot(texture2D(inputImageTexture, coords4).rgb, ycoeff) + 0.0625) * flag;\n}\n";
    private static final String TAG = "VideoBGRA2NV21Filter";
    private ByteBuffer mGLYUVBuffer;
    private byte[] mGLYUVBytes;
    private int mGLYUVFrameBufferId;
    private int mGLYUVTextureId;
    private int mUniformInputTexWidth;
    private int mUniformIsMirrored;
    private int mUniformOnlyYColor;

    public VideoRGBA2NV21Filter() {
        super("uniform mat4 uMVPMatrix;uniform mat4 uTexMatrix;attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main() {    gl_Position = uMVPMatrix * position;    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;}", FRAGMENT_SHADER_BGR2NV21);
        this.mUniformInputTexWidth = -1;
        this.mUniformOnlyYColor = -1;
        this.mUniformIsMirrored = -1;
        this.mGLYUVTextureId = -1;
        this.mGLYUVFrameBufferId = -1;
    }

    @Override // com.baidu.ala.dumixar.videofilter.VideoFilter
    public void onInitialized() {
        super.onInitialized();
        this.mUniformInputTexWidth = GLES20.glGetUniformLocation(getProgram(), "inputImageWidth");
        GlUtil.checkLocation(this.mUniformInputTexWidth, "inputImageWidth");
        this.mUniformOnlyYColor = GLES20.glGetUniformLocation(getProgram(), "onlyYColor");
        GlUtil.checkLocation(this.mUniformOnlyYColor, "onlyYColor");
        this.mUniformIsMirrored = GLES20.glGetUniformLocation(getProgram(), "isMirrored");
        GlUtil.checkLocation(this.mUniformIsMirrored, "isMirrored");
    }

    private void createYUVTextureAndFBO(int i, int i2) {
        Log.i(TAG, "Calling createThumbnailTextureAndFBO()");
        if (this.mGLYUVTextureId != -1 && this.mGLYUVFrameBufferId != -1) {
            deleteYUVTextureAndFBO();
        }
        this.mGLYUVTextureId = GlUtil.createTextureObject(3553, 0, i, i2);
        this.mGLYUVFrameBufferId = GlUtil.createFBOForTexture(this.mGLYUVTextureId, 3553);
    }

    private void deleteYUVTextureAndFBO() {
        if (this.mGLYUVTextureId != -1) {
            GlUtil.destroyTextureObject(this.mGLYUVTextureId);
            this.mGLYUVTextureId = -1;
        }
        if (this.mGLYUVFrameBufferId != -1) {
            GlUtil.destroyFramebufferObject(this.mGLYUVFrameBufferId);
            this.mGLYUVFrameBufferId = -1;
        }
    }

    @Override // com.baidu.ala.dumixar.videofilter.VideoFilter
    public void onOutputSizeChanged(int i, int i2) {
        if (this.mOutputWidth != i || this.mOutputHeight != i2) {
            super.onOutputSizeChanged(i, i2);
            deleteYUVTextureAndFBO();
        }
    }

    @Override // com.baidu.ala.dumixar.videofilter.VideoFilter
    public void draw(int i) {
        if (this.mGLYUVBuffer == null) {
            this.mGLYUVBytes = new byte[((this.mOutputWidth * this.mOutputHeight) * 3) / 2];
            this.mGLYUVBuffer = ByteBuffer.wrap(this.mGLYUVBytes);
        }
        if (this.mMvpMatrix == null) {
            this.mMvpMatrix = (float[]) GlUtil.VERT_FLIP_MATRIX.clone();
        }
        if (this.mTexMatrix == null) {
            this.mTexMatrix = (float[]) GlUtil.IDENTITY_MATRIX.clone();
        }
        if (this.mGLYUVTextureId == -1 || this.mGLYUVFrameBufferId == -1) {
            createYUVTextureAndFBO(this.mOutputWidth >> 2, (this.mOutputHeight * 3) / 2);
        }
        GLES20.glBindFramebuffer(36160, this.mGLYUVFrameBufferId);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glUseProgram(getProgram());
        if (this.mUniformInputTexWidth >= 0) {
            GLES20.glUniform1f(this.mUniformInputTexWidth, this.mOutputWidth);
        }
        if (this.mUniformMVPMatrix >= 0) {
            GLES20.glUniformMatrix4fv(getUniformMvpMatrix(), 1, false, this.mMvpMatrix, 0);
        }
        if (this.mUniformTexMatrix >= 0) {
            GLES20.glUniformMatrix4fv(getUniformTexMatrix(), 1, false, this.mTexMatrix, 0);
        }
        if (this.mUniformIsMirrored >= 0 && this.mMvpMatrix[0] < 0.0f) {
            GLES20.glUniform1i(this.mUniformIsMirrored, 1);
        } else {
            GLES20.glUniform1i(this.mUniformIsMirrored, 0);
        }
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glUniform1i(getUniformTexture(), 0);
        GLES20.glEnableVertexAttribArray(getAttribPosition());
        GLES20.glVertexAttribPointer(getAttribPosition(), 2, 5126, false, 0, (Buffer) this.mRectDrawable.getVertexArray());
        GLES20.glEnableVertexAttribArray(getAttribTextureCoordinate());
        GLES20.glVertexAttribPointer(getAttribTextureCoordinate(), 2, 5126, false, 0, (Buffer) this.mRectDrawable.getTexCoordArray());
        this.mGLYUVBuffer.clear();
        renderYColor(i);
        renderUVColor(i);
        this.mGLYUVBuffer.flip();
        GLES20.glDisableVertexAttribArray(getAttribPosition());
        GLES20.glDisableVertexAttribArray(getAttribTextureCoordinate());
        GLES20.glBindTexture(3553, 0);
        GLES20.glUseProgram(0);
    }

    private void renderYColor(int i) {
        GLES20.glViewport(0, 0, this.mOutputWidth >> 2, this.mOutputHeight);
        GLES20.glUniform1i(this.mUniformOnlyYColor, 1);
        GLES20.glDrawArrays(5, 0, 4);
    }

    private void renderUVColor(int i) {
        GLES20.glViewport(0, this.mOutputHeight, this.mOutputWidth >> 2, this.mOutputHeight >> 1);
        GLES20.glUniform1i(this.mUniformOnlyYColor, 0);
        GLES20.glDrawArrays(5, 0, 4);
    }

    @Override // com.baidu.ala.dumixar.videofilter.VideoFilter
    public void onReleased() {
        deleteYUVTextureAndFBO();
        super.onReleased();
    }

    public byte[] getYUVData() {
        GLES20.glReadPixels(0, 0, this.mOutputWidth >> 2, (this.mOutputHeight * 3) / 2, 6408, 5121, this.mGLYUVBuffer);
        return this.mGLYUVBuffer.array();
    }
}
