package com.baidu.ala.recorder.video.gles;

import android.annotation.TargetApi;
import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.LinkedList;
@TargetApi(16)
/* loaded from: classes7.dex */
public abstract class BaseFilter implements Renderer {
    public static final String BASE_VERT = "attribute vec4 aVertexCo;\nattribute vec2 aTextureCo;\n\nuniform mat4 uVertexMatrix;\nuniform mat4 uTextureMatrix;\n\nvarying vec2 vTextureCo;\n\nvoid main(){\n    gl_Position = uVertexMatrix*aVertexCo;\n    vTextureCo = (uTextureMatrix*vec4(aTextureCo,0,1)).xy;\n}";
    private String mFragment;
    private int mGLHeight;
    protected int mGLTexture;
    protected int mGLTextureCo;
    protected int mGLTextureMatrix;
    protected int mGLVertexCo;
    protected int mGLVertexMatrix;
    private int mGLWidth;
    protected int mHeight;
    protected GLShader mShader;
    protected FloatBuffer mTextureBuffer;
    private String mVertex;
    protected FloatBuffer mVertexBuffer;
    protected int mWidth;
    private float[] mVertexMatrix = GlUtil.getIdentityMatrix4();
    private float[] mTextureMatrix = GlUtil.getIdentityMatrix4();
    private boolean isUseSize = false;
    private final LinkedList<Runnable> mTasks = new LinkedList<>();
    private FrameBuffer mFrameBuffer = new FrameBuffer();

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseFilter(String str, String str2) {
        this.mVertex = str;
        this.mFragment = str2;
        initBuffer();
    }

    protected void initBuffer() {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(32);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.mVertexBuffer = allocateDirect.asFloatBuffer();
        this.mVertexBuffer.put(GlUtil.getIdentityVertexMatrix());
        this.mVertexBuffer.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(32);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.mTextureBuffer = allocateDirect2.asFloatBuffer();
        this.mTextureBuffer.put(GlUtil.getIdentityTextureMatrix());
        this.mTextureBuffer.position(0);
    }

    public void setVertexCo(float[] fArr) {
        this.mVertexBuffer.clear();
        this.mVertexBuffer.put(fArr);
        this.mVertexBuffer.position(0);
    }

    public void setTextureCo(float[] fArr) {
        this.mTextureBuffer.clear();
        this.mTextureBuffer.put(fArr);
        this.mTextureBuffer.position(0);
    }

    public void setVertexBuffer(FloatBuffer floatBuffer) {
        this.mVertexBuffer = floatBuffer;
    }

    public void setTextureBuffer(FloatBuffer floatBuffer) {
        this.mTextureBuffer = floatBuffer;
    }

    public void setVertexMatrix(float[] fArr) {
        this.mVertexMatrix = fArr;
    }

    public void setTextureMatrix(float[] fArr) {
        this.mTextureMatrix = fArr;
    }

    public float[] getVertexMatrix() {
        return this.mVertexMatrix;
    }

    public float[] getTextureMatrix() {
        return this.mTextureMatrix;
    }

    protected void shaderNeedTextureSize(boolean z) {
        this.isUseSize = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCreate() {
        this.mShader = new GLShader(this.mVertex, this.mFragment);
        this.mGLVertexCo = this.mShader.getAttribLocation("aVertexCo");
        this.mGLTextureCo = this.mShader.getAttribLocation("aTextureCo");
        this.mGLVertexMatrix = this.mShader.getUniformLocation("uVertexMatrix");
        this.mGLTextureMatrix = this.mShader.getUniformLocation("uTextureMatrix");
        this.mGLTexture = this.mShader.getUniformLocation("uTexture");
        if (this.isUseSize) {
            this.mGLWidth = this.mShader.getUniformLocation("uWidth");
            this.mGLHeight = this.mShader.getUniformLocation("uHeight");
        }
    }

    protected void onSizeChanged(int i, int i2) {
    }

    @Override // com.baidu.ala.recorder.video.gles.Renderer
    public final void create() {
        if (this.mVertex != null && this.mFragment != null) {
            onCreate();
        }
    }

    @Override // com.baidu.ala.recorder.video.gles.Renderer
    public void sizeChanged(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
        onSizeChanged(i, i2);
        this.mFrameBuffer.destroyFrameBuffer();
    }

    @Override // com.baidu.ala.recorder.video.gles.Renderer
    public void draw(int i) {
        GlUtil.checkGlError("draw begin.");
        onClear();
        onUseProgram();
        GlUtil.checkGlError("onUseProgram ");
        onSetExpandData();
        GlUtil.checkGlError("onSetExpandData ");
        onBindTexture(i);
        GlUtil.checkGlError("onBindTexture ");
        onDraw();
        GlUtil.checkGlError("draw end.");
    }

    public int drawToTexture(int i) {
        this.mFrameBuffer.bindFrameBuffer(this.mWidth, this.mHeight);
        draw(i);
        this.mFrameBuffer.unBindFrameBuffer();
        return this.mFrameBuffer.getCacheTextureId();
    }

    @Override // com.baidu.ala.recorder.video.gles.Renderer
    public void destroy() {
        this.mFrameBuffer.destroyFrameBuffer();
        this.mShader.release();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onTaskExec() {
        while (!this.mTasks.isEmpty()) {
            this.mTasks.removeFirst().run();
        }
    }

    protected void onUseProgram() {
        this.mShader.useProgram();
        onTaskExec();
    }

    protected void onDraw() {
        GLES20.glEnableVertexAttribArray(this.mGLVertexCo);
        GLES20.glVertexAttribPointer(this.mGLVertexCo, 2, 5126, false, 0, (Buffer) this.mVertexBuffer);
        GLES20.glEnableVertexAttribArray(this.mGLTextureCo);
        GLES20.glVertexAttribPointer(this.mGLTextureCo, 2, 5126, false, 0, (Buffer) this.mTextureBuffer);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.mGLVertexCo);
        GLES20.glDisableVertexAttribArray(this.mGLTextureCo);
    }

    protected void onClear() {
        GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        GLES20.glClear(16640);
    }

    public void runOnGLThread(Runnable runnable) {
        this.mTasks.addLast(runnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSetExpandData() {
        GLES20.glUniformMatrix4fv(this.mGLVertexMatrix, 1, false, this.mVertexMatrix, 0);
        GLES20.glUniformMatrix4fv(this.mGLTextureMatrix, 1, false, this.mTextureMatrix, 0);
        if (this.isUseSize) {
            GLES20.glUniform1f(this.mGLWidth, this.mWidth);
            GLES20.glUniform1f(this.mGLHeight, this.mHeight);
        }
    }

    protected void onBindTexture(int i) {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glUniform1i(this.mGLTexture, 0);
    }
}
