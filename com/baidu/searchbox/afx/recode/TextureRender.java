package com.baidu.searchbox.afx.recode;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.StatusCode;
import com.faceunity.gles.GeneratedTexture;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes3.dex */
public class TextureRender {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FLOAT_SIZE_BYTES = 4;
    public static final String FRAGMENT_SHADER = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    public static final String TAG = "TextureRender";
    public static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
    public static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 20;
    public static final int TRIANGLE_VERTICES_DATA_UV_OFFSET = 3;
    public static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
    public transient /* synthetic */ FieldHolder $fh;
    public float[] mMVPMatrix;
    public int mProgram;
    public float[] mSTMatrix;
    public int mTextureID;
    public FloatBuffer mTriangleVertices;
    public final float[] mTriangleVerticesData;
    public int maPositionHandle;
    public int maTextureHandle;
    public int muMVPMatrixHandle;
    public int muSTMatrixHandle;

    public TextureRender() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        float[] fArr = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.mTriangleVerticesData = fArr;
        this.mMVPMatrix = new float[16];
        this.mSTMatrix = new float[16];
        this.mTextureID = -12345;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mTriangleVertices = asFloatBuffer;
        asFloatBuffer.put(this.mTriangleVerticesData).position(0);
        Matrix.setIdentityM(this.mSTMatrix, 0);
    }

    private int createProgram(String str, String str2) {
        InterceptResult invokeLL;
        int loadShader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, str2)) == null) {
            int loadShader2 = loadShader(35633, str);
            if (loadShader2 == 0 || (loadShader = loadShader(35632, str2)) == 0) {
                return 0;
            }
            int glCreateProgram = GLES20.glCreateProgram();
            checkGlError("glCreateProgram");
            if (glCreateProgram == 0) {
                Log.e(TAG, "Could not create program");
            }
            GLES20.glAttachShader(glCreateProgram, loadShader2);
            checkGlError("glAttachShader");
            GLES20.glAttachShader(glCreateProgram, loadShader);
            checkGlError("glAttachShader");
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                Log.e(TAG, "Could not link program: ");
                Log.e(TAG, GLES20.glGetProgramInfoLog(glCreateProgram));
                GLES20.glDeleteProgram(glCreateProgram);
                return 0;
            }
            return glCreateProgram;
        }
        return invokeLL.intValue;
    }

    private int loadShader(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, this, i2, str)) == null) {
            int glCreateShader = GLES20.glCreateShader(i2);
            checkGlError("glCreateShader type=" + i2);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                Log.e(TAG, "Could not compile shader " + i2 + ":");
                StringBuilder sb = new StringBuilder();
                sb.append(" ");
                sb.append(GLES20.glGetShaderInfoLog(glCreateShader));
                Log.e(TAG, sb.toString());
                GLES20.glDeleteShader(glCreateShader);
                return 0;
            }
            return glCreateShader;
        }
        return invokeIL.intValue;
    }

    public static void saveFrame(String str, int i2, int i3) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65539, null, str, i2, i3) == null) {
            int i4 = i2 * i3;
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i4 * 4);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            GLES20.glReadPixels(0, 0, i2, i3, GeneratedTexture.FORMAT, 5121, allocateDirect);
            allocateDirect.rewind();
            int[] iArr = new int[i4];
            allocateDirect.asIntBuffer().get(iArr);
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = iArr[i5];
                iArr[i5] = ((i6 & 255) << 16) | ((-16711936) & i6) | ((16711680 & i6) >> 16);
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(str);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e2) {
                e = e2;
            }
            try {
                Bitmap createBitmap = Bitmap.createBitmap(iArr, i2, i3, Bitmap.Config.ARGB_8888);
                createBitmap.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
                createBitmap.recycle();
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    throw new RuntimeException("Failed to close file " + str, e3);
                }
            } catch (IOException e4) {
                e = e4;
                throw new RuntimeException("Failed to write file " + str, e);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e5) {
                        throw new RuntimeException("Failed to close file " + str, e5);
                    }
                }
                throw th;
            }
        }
    }

    public void changeFragmentShader(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            GLES20.glDeleteProgram(this.mProgram);
            int createProgram = createProgram(VERTEX_SHADER, str);
            this.mProgram = createProgram;
            if (createProgram == 0) {
                throw new RuntimeException("failed creating program");
            }
        }
    }

    public void checkGlError(String str) {
        int glGetError;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (glGetError = GLES20.glGetError()) == 0) {
            return;
        }
        Log.e(TAG, str + ": glError " + glGetError);
        throw new RuntimeException(str + ": glError " + glGetError);
    }

    public void drawFrame(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, surfaceTexture) == null) {
            checkGlError("onDrawFrame start");
            surfaceTexture.getTransformMatrix(this.mSTMatrix);
            GLES20.glClearColor(0.0f, 1.0f, 0.0f, 1.0f);
            GLES20.glClear(16640);
            GLES20.glUseProgram(this.mProgram);
            checkGlError("glUseProgram");
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, this.mTextureID);
            this.mTriangleVertices.position(0);
            GLES20.glVertexAttribPointer(this.maPositionHandle, 3, (int) StatusCode.PUBLIC_SECURITY_AUTH_NOT_EXIST, false, 20, (Buffer) this.mTriangleVertices);
            checkGlError("glVertexAttribPointer maPosition");
            GLES20.glEnableVertexAttribArray(this.maPositionHandle);
            checkGlError("glEnableVertexAttribArray maPositionHandle");
            this.mTriangleVertices.position(3);
            GLES20.glVertexAttribPointer(this.maTextureHandle, 2, (int) StatusCode.PUBLIC_SECURITY_AUTH_NOT_EXIST, false, 20, (Buffer) this.mTriangleVertices);
            checkGlError("glVertexAttribPointer maTextureHandle");
            GLES20.glEnableVertexAttribArray(this.maTextureHandle);
            checkGlError("glEnableVertexAttribArray maTextureHandle");
            Matrix.setIdentityM(this.mMVPMatrix, 0);
            GLES20.glUniformMatrix4fv(this.muMVPMatrixHandle, 1, false, this.mMVPMatrix, 0);
            GLES20.glUniformMatrix4fv(this.muSTMatrixHandle, 1, false, this.mSTMatrix, 0);
            GLES20.glDrawArrays(5, 0, 4);
            checkGlError("glDrawArrays");
            GLES20.glFinish();
        }
    }

    public int getTextureId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mTextureID : invokeV.intValue;
    }

    public void surfaceCreated() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int createProgram = createProgram(VERTEX_SHADER, FRAGMENT_SHADER);
            this.mProgram = createProgram;
            if (createProgram != 0) {
                this.maPositionHandle = GLES20.glGetAttribLocation(createProgram, "aPosition");
                checkGlError("glGetAttribLocation aPosition");
                if (this.maPositionHandle != -1) {
                    this.maTextureHandle = GLES20.glGetAttribLocation(this.mProgram, "aTextureCoord");
                    checkGlError("glGetAttribLocation aTextureCoord");
                    if (this.maTextureHandle != -1) {
                        this.muMVPMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uMVPMatrix");
                        checkGlError("glGetUniformLocation uMVPMatrix");
                        if (this.muMVPMatrixHandle != -1) {
                            this.muSTMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uSTMatrix");
                            checkGlError("glGetUniformLocation uSTMatrix");
                            if (this.muSTMatrixHandle != -1) {
                                int[] iArr = new int[1];
                                GLES20.glGenTextures(1, iArr, 0);
                                int i2 = iArr[0];
                                this.mTextureID = i2;
                                GLES20.glBindTexture(36197, i2);
                                checkGlError("glBindTexture mTextureID");
                                GLES20.glTexParameterf(36197, 10241, 9728.0f);
                                GLES20.glTexParameterf(36197, 10240, 9729.0f);
                                GLES20.glTexParameteri(36197, 10242, 33071);
                                GLES20.glTexParameteri(36197, 10243, 33071);
                                checkGlError("glTexParameter");
                                return;
                            }
                            throw new RuntimeException("Could not get attrib location for uSTMatrix");
                        }
                        throw new RuntimeException("Could not get attrib location for uMVPMatrix");
                    }
                    throw new RuntimeException("Could not get attrib location for aTextureCoord");
                }
                throw new RuntimeException("Could not get attrib location for aPosition");
            }
            throw new RuntimeException("failed creating program");
        }
    }
}
