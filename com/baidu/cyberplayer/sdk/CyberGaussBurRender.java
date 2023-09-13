package com.baidu.cyberplayer.sdk;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.baidu.cyberplayer.sdk.ICyberRenderView;
import com.baidu.searchbox.afx.recode.TextureRender;
import java.nio.Buffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes3.dex */
public class CyberGaussBurRender extends CyberRender {
    public static final String TAG = "CyberGaussBurRender";
    public final Object mFilterLock = new Object();
    public int mWidthHandle = -1;
    public int mHeightHandle = -1;
    public int mLeftHandle = -1;
    public int mRightHandle = -1;
    public int mTopHandle = -1;
    public int mBottomHandle = -1;
    public float mLeft = 0.0f;
    public float mRight = 0.0f;
    public float mTop = 0.0f;
    public float mBottom = 0.0f;
    public boolean mIsFilterSuccess = true;
    public final String mFragmentShaderGauss = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float width;\nuniform float height;\nuniform float left;uniform float right;\nuniform float top;uniform float bottom;\nvec2 clampCoord(vec2 coord) {\nreturn vec2(clamp(coord.x, left, right), clamp(coord.y, top, bottom));}\nvec4 gauss(vec4 src, vec2 offset, int ksize) {\nint index = 0;float sum = 0.0;\nfloat mind = (float(ksize) - 1.0)/2.0;float sigma = 0.3*(float(ksize-1)*0.5-1.0)+0.8;\nvec4 color = vec4(0.0);\nfor(int y=0;y<ksize;y++) {\n  for(int x = 0;x<ksize;x++) {\n    float xpoint = abs(float(x) - mind); float ypoint = abs(float(y) - mind);\n    float weight = (1.0/(2.0*3.1415*sigma*sigma))*pow(2.718,((-(xpoint*xpoint+ypoint*ypoint))/((2.0*sigma)*(2.0*sigma))));\n    vec4 currentColor = texture2D(sTexture, clampCoord(vTextureCoord + vec2(float(-1+x)*offset.x,float(-1+y)*offset.y)));\n    color += currentColor*weight;index++;sum += weight;}\n}\nreturn vec4(color.rgb / sum, src.a);\n}\nvoid main() {\nvec4 sourceColor = texture2D(sTexture, vTextureCoord);\nif (vTextureCoord.x > left && vTextureCoord.x < right && vTextureCoord.y > top && vTextureCoord.y < bottom) {\n     int radius = 8;\n     vec2 blurOffset = vec2(5.0 / width, 5.0 / height);\n     sourceColor= gauss(sourceColor, blurOffset, (2 * radius + 1));\n}\ngl_FragColor = sourceColor;\n}\n";

    public CyberGaussBurRender() {
        this.mProgram = 0;
        this.mVertexProgram = 0;
        this.mFragmentProgram = 0;
        CyberLog.d(TAG, TAG);
    }

    private boolean resetProgram(String str) {
        boolean z;
        try {
            int createProgram = createProgram(TextureRender.VERTEX_SHADER, str);
            this.mProgram = createProgram;
            if (createProgram == 0) {
                CyberLog.e(TAG, "resetProgram mProgram = 0");
                return false;
            }
            this.maPositionHandle = GLES20.glGetAttribLocation(createProgram, "aPosition");
            checkGlError("glGetAttribLocation aPosition");
            if (this.maPositionHandle == -1) {
                CyberLog.e(TAG, "Could not get attrib location for aPosition");
                return false;
            }
            this.maTextureHandle = GLES20.glGetAttribLocation(this.mProgram, "aTextureCoord");
            checkGlError("glGetAttribLocation aTextureCoord");
            if (this.maTextureHandle == -1) {
                CyberLog.e(TAG, "Could not get attrib location for aTextureCoord");
                return false;
            }
            this.muMVPMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uMVPMatrix");
            checkGlError("glGetUniformLocation uMVPMatrix");
            if (this.muMVPMatrixHandle == -1) {
                CyberLog.e(TAG, "Could not get attrib location for uMVPMatrix");
                return false;
            }
            this.muSTMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uSTMatrix");
            checkGlError("glGetUniformLocation uSTMatrix");
            if (this.muMVPMatrixHandle == -1) {
                CyberLog.e(TAG, "Could not get attrib location for uSTMatrix");
                return false;
            }
            this.mWidthHandle = GLES20.glGetUniformLocation(this.mProgram, "width");
            this.mHeightHandle = GLES20.glGetUniformLocation(this.mProgram, "height");
            this.mLeftHandle = GLES20.glGetUniformLocation(this.mProgram, "left");
            this.mRightHandle = GLES20.glGetUniformLocation(this.mProgram, "right");
            this.mTopHandle = GLES20.glGetUniformLocation(this.mProgram, "top");
            int glGetUniformLocation = GLES20.glGetUniformLocation(this.mProgram, "bottom");
            this.mBottomHandle = glGetUniformLocation;
            if (this.mWidthHandle != -1 && this.mHeightHandle != -1 && this.mLeftHandle != -1 && this.mRightHandle != -1 && this.mTopHandle != -1 && glGetUniformLocation != -1) {
                z = true;
                GLES20.glTexParameterf(CyberRender.GL_TEXTURE_EXTERNAL_OES, 10241, 9728.0f);
                GLES20.glTexParameterf(CyberRender.GL_TEXTURE_EXTERNAL_OES, 10240, 9729.0f);
                return z;
            }
            CyberLog.e(TAG, "Could not get attrib location for filter");
            z = false;
            GLES20.glTexParameterf(CyberRender.GL_TEXTURE_EXTERNAL_OES, 10241, 9728.0f);
            GLES20.glTexParameterf(CyberRender.GL_TEXTURE_EXTERNAL_OES, 10240, 9729.0f);
            return z;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberRender
    public void onDrawFrameSurfaceTexImpl() {
        int i = this.mProgram;
        if (i == 0) {
            return;
        }
        GLES20.glUseProgram(i);
        checkGlError("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(CyberRender.GL_TEXTURE_EXTERNAL_OES, this.mTextureID);
        this.mVertices.position(0);
        GLES20.glVertexAttribPointer(this.maPositionHandle, 3, 5126, false, 20, (Buffer) this.mVertices);
        checkGlError("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.maPositionHandle);
        checkGlError("glEnableVertexAttribArray maPositionHandle");
        this.mVertices.position(3);
        GLES20.glVertexAttribPointer(this.maTextureHandle, 3, 5126, false, 20, (Buffer) this.mVertices);
        checkGlError("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.maTextureHandle);
        checkGlError("glEnableVertexAttribArray maTextureHandle");
        Matrix.setIdentityM(this.mMVPMatrix, 0);
        float[] displayScale = this.mCyberRenderSizeHelper.getDisplayScale();
        if (this.mCyberRenderSizeHelper.isNeedTranslate()) {
            float[] displayTranslate = this.mCyberRenderSizeHelper.getDisplayTranslate();
            Matrix.translateM(this.mMVPMatrix, 0, displayTranslate[0], displayTranslate[1], 0.0f);
        }
        Matrix.scaleM(this.mMVPMatrix, 0, displayScale[0], displayScale[1], 0.0f);
        Matrix.rotateM(this.mMVPMatrix, 0, this.mCyberRenderSizeHelper.getDrawFrameRotation(), 0.0f, 0.0f, 1.0f);
        GLES20.glUniformMatrix4fv(this.muMVPMatrixHandle, 1, false, this.mMVPMatrix, 0);
        GLES20.glUniformMatrix4fv(this.muSTMatrixHandle, 1, false, this.mSTMatrix, 0);
        if (this.mIsFilterSuccess) {
            synchronized (this.mFilterLock) {
                float surfaceWidth = displayScale[0] * this.mCyberRenderSizeHelper.getSurfaceWidth();
                float surfaceHeight = displayScale[1] * this.mCyberRenderSizeHelper.getSurfaceHeight();
                if (Math.abs(surfaceWidth - 0.0f) <= 1.0E-6d || Math.abs(surfaceHeight - 0.0f) <= 1.0E-6d) {
                    surfaceWidth = 1280.0f;
                    surfaceHeight = 720.0f;
                }
                GLES20.glUniform1f(this.mWidthHandle, surfaceWidth);
                GLES20.glUniform1f(this.mHeightHandle, surfaceHeight);
                GLES20.glUniform1f(this.mLeftHandle, this.mLeft);
                GLES20.glUniform1f(this.mRightHandle, this.mRight);
                GLES20.glUniform1f(this.mTopHandle, this.mTop);
                GLES20.glUniform1f(this.mBottomHandle, this.mBottom);
            }
        }
        GLES20.glDrawArrays(5, 0, 4);
        checkGlError("glDrawArrays");
        GLES20.glFinish();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberRender, android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        CyberLog.d(TAG, "onSurfaceCreated");
        if (this.mIsFilterSuccess) {
            boolean resetProgram = resetProgram("#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float width;\nuniform float height;\nuniform float left;uniform float right;\nuniform float top;uniform float bottom;\nvec2 clampCoord(vec2 coord) {\nreturn vec2(clamp(coord.x, left, right), clamp(coord.y, top, bottom));}\nvec4 gauss(vec4 src, vec2 offset, int ksize) {\nint index = 0;float sum = 0.0;\nfloat mind = (float(ksize) - 1.0)/2.0;float sigma = 0.3*(float(ksize-1)*0.5-1.0)+0.8;\nvec4 color = vec4(0.0);\nfor(int y=0;y<ksize;y++) {\n  for(int x = 0;x<ksize;x++) {\n    float xpoint = abs(float(x) - mind); float ypoint = abs(float(y) - mind);\n    float weight = (1.0/(2.0*3.1415*sigma*sigma))*pow(2.718,((-(xpoint*xpoint+ypoint*ypoint))/((2.0*sigma)*(2.0*sigma))));\n    vec4 currentColor = texture2D(sTexture, clampCoord(vTextureCoord + vec2(float(-1+x)*offset.x,float(-1+y)*offset.y)));\n    color += currentColor*weight;index++;sum += weight;}\n}\nreturn vec4(color.rgb / sum, src.a);\n}\nvoid main() {\nvec4 sourceColor = texture2D(sTexture, vTextureCoord);\nif (vTextureCoord.x > left && vTextureCoord.x < right && vTextureCoord.y > top && vTextureCoord.y < bottom) {\n     int radius = 8;\n     vec2 blurOffset = vec2(5.0 / width, 5.0 / height);\n     sourceColor= gauss(sourceColor, blurOffset, (2 * radius + 1));\n}\ngl_FragColor = sourceColor;\n}\n");
            this.mIsFilterSuccess = resetProgram;
            if (!resetProgram) {
                int i = this.mVertexProgram;
                if (i != 0) {
                    GLES20.glDeleteShader(i);
                }
                int i2 = this.mFragmentProgram;
                if (i2 != 0) {
                    GLES20.glDeleteShader(i2);
                }
                int i3 = this.mProgram;
                if (i3 != 0) {
                    GLES20.glDeleteProgram(i3);
                }
            }
        }
        if (!this.mIsFilterSuccess) {
            resetProgram(TextureRender.FRAGMENT_SHADER);
        }
        ICyberRenderView.ICyberSurfaceListener iCyberSurfaceListener = this.mCyberSufaceListener;
        if (iCyberSurfaceListener != null && iCyberSurfaceListener.onSurfaceReady(0)) {
            synchronized (this.mSurfaceMonitor) {
                this.mUpdateSurface = false;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberRender
    public void reset() {
        CyberLog.d(TAG, "CyberGaussBurRender reset");
        this.mCyberRenderSizeHelper.resetForSurfaceReuse();
        this.mLeft = 0.0f;
        this.mRight = 0.0f;
        this.mTop = 0.0f;
        this.mBottom = 0.0f;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberRender
    public boolean setFilterRegion(int i, float f, float f2, float f3, float f4) {
        float max;
        float max2;
        float max3;
        float max4;
        if (i == 256 && this.mIsFilterSuccess) {
            try {
                max = Math.max(Math.min(f, 1.0f), 0.0f);
                max2 = Math.max(Math.min(f2, 1.0f), 0.0f);
                max3 = Math.max(Math.min(f3, 1.0f), 0.0f);
                max4 = Math.max(Math.min(f4, 1.0f), 0.0f);
            } catch (Exception unused) {
            }
            if (Math.abs(this.mLeft - max) <= 1.0E-6d && Math.abs(this.mRight - max2) <= 1.0E-6d && Math.abs(this.mTop - max3) <= 1.0E-6d && Math.abs(this.mBottom - max4) <= 1.0E-6d) {
                return true;
            }
            synchronized (this.mFilterLock) {
                this.mLeft = max;
                this.mRight = max2;
                this.mTop = max3;
                this.mBottom = max4;
            }
            if (this.mFirstDisplay && this.mOnRequestRenderListener != null) {
                this.mOnRequestRenderListener.onRequestRender();
            }
            return true;
        }
        return false;
    }
}
