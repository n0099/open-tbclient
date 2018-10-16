package com.baidu.searchbox.ng.ai.apps.ar.draw;

import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
/* loaded from: classes2.dex */
public class ARDrawer {
    private static final int COORDS_PER_VERTEX = 2;
    private static float[] squareCoords = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
    private static float[] textureVertices = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    private ShortBuffer drawListBuffer;
    private int mPositionHandle;
    private final int mProgram;
    private int mTextureCoordHandle;
    private int mTextureTarget;
    private int texture;
    private FloatBuffer textureVerticesBuffer;
    private FloatBuffer vertexBuffer;
    private final String vertexShaderCode = "attribute vec4 vPosition;attribute vec2 inputTextureCoordinate;varying vec2 textureCoordinate;void main(){gl_Position = vPosition;textureCoordinate = inputTextureCoordinate;}";
    private final String fragmentShaderCode = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;varying vec2 textureCoordinate;\nuniform samplerExternalOES s_texture;\nvoid main() {  gl_FragColor = texture2D( s_texture, textureCoordinate );\n}";
    private short[] drawOrder = {0, 1, 2, 0, 2, 3};
    private final int vertexStride = 8;

    public ARDrawer(int i, int i2, boolean z) {
        this.texture = i;
        this.mTextureTarget = i2;
        setScreenOrientationLandscape(z);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(squareCoords.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.vertexBuffer = allocateDirect.asFloatBuffer();
        this.vertexBuffer.put(squareCoords);
        this.vertexBuffer.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.drawOrder.length * 2);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.drawListBuffer = allocateDirect2.asShortBuffer();
        this.drawListBuffer.put(this.drawOrder);
        this.drawListBuffer.position(0);
        ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(textureVertices.length * 4);
        allocateDirect3.order(ByteOrder.nativeOrder());
        this.textureVerticesBuffer = allocateDirect3.asFloatBuffer();
        this.textureVerticesBuffer.put(textureVertices);
        this.textureVerticesBuffer.position(0);
        int loadShader = loadShader(35633, "attribute vec4 vPosition;attribute vec2 inputTextureCoordinate;varying vec2 textureCoordinate;void main(){gl_Position = vPosition;textureCoordinate = inputTextureCoordinate;}");
        int loadShader2 = loadShader(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;varying vec2 textureCoordinate;\nuniform samplerExternalOES s_texture;\nvoid main() {  gl_FragColor = texture2D( s_texture, textureCoordinate );\n}");
        this.mProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(this.mProgram, loadShader);
        GLES20.glAttachShader(this.mProgram, loadShader2);
        GLES20.glLinkProgram(this.mProgram);
    }

    public void draw(float[] fArr) {
        GLES20.glUseProgram(this.mProgram);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mTextureTarget, this.texture);
        this.mPositionHandle = GLES20.glGetAttribLocation(this.mProgram, "vPosition");
        GLES20.glEnableVertexAttribArray(this.mPositionHandle);
        GLES20.glVertexAttribPointer(this.mPositionHandle, 2, 5126, false, 8, (Buffer) this.vertexBuffer);
        this.mTextureCoordHandle = GLES20.glGetAttribLocation(this.mProgram, "inputTextureCoordinate");
        GLES20.glEnableVertexAttribArray(this.mTextureCoordHandle);
        GLES20.glVertexAttribPointer(this.mTextureCoordHandle, 2, 5126, false, 8, (Buffer) this.textureVerticesBuffer);
        GLES20.glDrawElements(4, this.drawOrder.length, 5123, this.drawListBuffer);
        GLES20.glDisableVertexAttribArray(this.mPositionHandle);
        GLES20.glDisableVertexAttribArray(this.mTextureCoordHandle);
    }

    private int loadShader(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        return glCreateShader;
    }

    public void setScreenOrientationLandscape(boolean z) {
        if (z) {
            squareCoords = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f};
        } else {
            squareCoords = new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
        }
    }
}
