package com.baidu.searchbox.afx.gl;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.afx.gl.GLTextureView;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes4.dex */
public class AlphaVideoRenderer implements GLTextureView.Renderer, SurfaceTexture.OnFrameAvailableListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AlphaVideoRenderer";
    public transient /* synthetic */ FieldHolder $fh;
    public int aPositionHandle;
    public int aTextureAlphaHandle;
    public int aTextureColorHandle;
    public volatile boolean clearLastFrame;
    public float mDismissFlag;
    public float mFilterFactor;
    public float[] mMVPMatrix;
    public OnSurfacePrepareListener mOnSurfacePrepareListener;
    public int mProgram;
    public float[] mSTMatrix;
    public SurfaceTexture mSurfaceTexture;
    public FloatBuffer mTriangleVertices;
    public volatile boolean mUpdateSurface;
    public volatile boolean onPlay;
    public int uDismissFlagHandle;
    public int uFilterFactorHandle;
    public int uMVPMatrixHandle;
    public int uSTMatrixHandle;

    /* loaded from: classes4.dex */
    public interface OnSurfacePrepareListener {
        void onSurfacePrepared(Surface surface);
    }

    public AlphaVideoRenderer() {
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
        this.mMVPMatrix = new float[16];
        this.mSTMatrix = new float[16];
        this.mFilterFactor = 0.0f;
        this.mDismissFlag = 0.0f;
        this.clearLastFrame = false;
        this.onPlay = false;
        this.mUpdateSurface = false;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(AlphaVideoCoords.VERTICES.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mTriangleVertices = asFloatBuffer;
        asFloatBuffer.put(AlphaVideoCoords.VERTICES).position(0);
        Matrix.setIdentityM(this.mSTMatrix, 0);
    }

    private void checkGlError(String str) {
        int glGetError;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, str) == null) || (glGetError = GLES20.glGetError()) == 0) {
            return;
        }
        String str2 = str + ": glError " + glGetError;
        throw new RuntimeException(str + ": glError " + glGetError);
    }

    private int createProgram(String str, String str2) {
        InterceptResult invokeLL;
        int loadShader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, str2)) == null) {
            int loadShader2 = loadShader(35633, str);
            if (loadShader2 == 0 || (loadShader = loadShader(35632, str2)) == 0) {
                return 0;
            }
            int glCreateProgram = GLES20.glCreateProgram();
            if (glCreateProgram != 0) {
                GLES20.glAttachShader(glCreateProgram, loadShader2);
                checkGlError("glAttachShader");
                GLES20.glAttachShader(glCreateProgram, loadShader);
                checkGlError("glAttachShader");
                GLES20.glLinkProgram(glCreateProgram);
                int[] iArr = new int[1];
                GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
                if (iArr[0] != 1) {
                    GLES20.glGetProgramInfoLog(glCreateProgram);
                    GLES20.glDeleteProgram(glCreateProgram);
                    return 0;
                }
            }
            return glCreateProgram;
        }
        return invokeLL.intValue;
    }

    private int loadShader(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65539, this, i2, str)) == null) {
            int glCreateShader = GLES20.glCreateShader(i2);
            if (glCreateShader != 0) {
                GLES20.glShaderSource(glCreateShader, str);
                GLES20.glCompileShader(glCreateShader);
                int[] iArr = new int[1];
                GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
                if (iArr[0] == 0) {
                    String str2 = "Could not compile shader " + i2 + ":";
                    GLES20.glGetShaderInfoLog(glCreateShader);
                    GLES20.glDeleteShader(glCreateShader);
                    return 0;
                }
                return glCreateShader;
            }
            return glCreateShader;
        }
        return invokeIL.intValue;
    }

    private void prepareSurface() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            int i2 = iArr[0];
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, i2);
            checkGlError("glBindTexture textureID");
            GLES20.glTexParameterf(36197, 10241, 9728.0f);
            GLES20.glTexParameterf(36197, 10240, 9729.0f);
            SurfaceTexture surfaceTexture = new SurfaceTexture(i2);
            this.mSurfaceTexture = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this);
            Surface surface = new Surface(this.mSurfaceTexture);
            OnSurfacePrepareListener onSurfacePrepareListener = this.mOnSurfacePrepareListener;
            if (onSurfacePrepareListener != null) {
                onSurfacePrepareListener.onSurfacePrepared(surface);
            }
            synchronized (this) {
                this.mUpdateSurface = false;
            }
        }
    }

    public synchronized void clearLastFrame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                this.clearLastFrame = true;
            }
        }
    }

    @Override // com.baidu.searchbox.afx.gl.GLTextureView.Renderer
    public void onDrawFrame(GL10 gl10) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gl10) == null) {
            synchronized (this) {
                if (this.mUpdateSurface) {
                    this.mSurfaceTexture.updateTexImage();
                    this.mSurfaceTexture.getTransformMatrix(this.mSTMatrix);
                    this.mUpdateSurface = false;
                }
            }
            GLES20.glClear(16640);
            GLES20.glEnable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
            GLES20.glBlendFunc(BankSignFactory.BEAN_ID_QUERY, BankSignFactory.BEAN_ID_BIND_CARD);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glUseProgram(this.mProgram);
            checkGlError("glUseProgram");
            this.mTriangleVertices.position(0);
            GLES20.glVertexAttribPointer(this.aPositionHandle, 3, 5126, false, 28, (Buffer) this.mTriangleVertices);
            checkGlError("glVertexAttribPointer maPosition");
            GLES20.glEnableVertexAttribArray(this.aPositionHandle);
            checkGlError("glEnableVertexAttribArray aPositionHandle");
            this.mTriangleVertices.position(3);
            GLES20.glVertexAttribPointer(this.aTextureAlphaHandle, 2, 5126, false, 28, (Buffer) this.mTriangleVertices);
            checkGlError("glVertexAttribPointer aTextureAlphaHandle");
            GLES20.glEnableVertexAttribArray(this.aTextureAlphaHandle);
            checkGlError("glEnableVertexAttribArray aTextureAlphaHandle");
            this.mTriangleVertices.position(5);
            GLES20.glVertexAttribPointer(this.aTextureColorHandle, 2, 5126, false, 28, (Buffer) this.mTriangleVertices);
            checkGlError("glVertexAttribPointer aTextureColorHandle");
            GLES20.glEnableVertexAttribArray(this.aTextureColorHandle);
            checkGlError("glEnableVertexAttribArray aTextureColorHandle");
            Matrix.setIdentityM(this.mMVPMatrix, 0);
            GLES20.glUniformMatrix4fv(this.uMVPMatrixHandle, 1, false, this.mMVPMatrix, 0);
            GLES20.glUniformMatrix4fv(this.uSTMatrixHandle, 1, false, this.mSTMatrix, 0);
            GLES20.glUniform1f(this.uFilterFactorHandle, this.mFilterFactor);
            GLES20.glDrawArrays(5, 0, 4);
            checkGlError("glDrawArrays");
            synchronized (this) {
                f2 = this.clearLastFrame ? -1.0f : 0.0f;
                this.mDismissFlag = f2;
            }
            GLES20.glUniform1f(this.uDismissFlagHandle, f2);
            GLES20.glFinish();
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, surfaceTexture) == null) {
            synchronized (this) {
                this.mUpdateSurface = true;
                if (this.onPlay) {
                    this.clearLastFrame = false;
                    this.onPlay = false;
                }
            }
        }
    }

    public synchronized void onPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                this.onPlay = true;
            }
        }
    }

    @Override // com.baidu.searchbox.afx.gl.GLTextureView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, gl10, i2, i3) == null) {
            GLES20.glViewport(0, 0, i2, i3);
        }
    }

    @Override // com.baidu.searchbox.afx.gl.GLTextureView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, gl10, eGLConfig) == null) {
            int createProgram = createProgram(AlphaVideoShaders.SHADER_VERTEX, AlphaVideoShaders.SHADER_FRAGMENT);
            this.mProgram = createProgram;
            if (createProgram == 0) {
                return;
            }
            this.aPositionHandle = GLES20.glGetAttribLocation(createProgram, "aPosition");
            checkGlError("glGetAttribLocation aPosition");
            if (this.aPositionHandle != -1) {
                this.aTextureAlphaHandle = GLES20.glGetAttribLocation(this.mProgram, "aTextureAlphaCoord");
                checkGlError("glGetAttribLocation aTextureAlphaCoord");
                if (this.aTextureAlphaHandle != -1) {
                    this.aTextureColorHandle = GLES20.glGetAttribLocation(this.mProgram, "aTextureColorCoord");
                    checkGlError("glGetAttribLocation aTextureColorCoord");
                    if (this.aTextureColorHandle != -1) {
                        this.uMVPMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uMVPMatrix");
                        checkGlError("glGetUniformLocation uMVPMatrix");
                        if (this.uMVPMatrixHandle != -1) {
                            this.uSTMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uSTMatrix");
                            checkGlError("glGetUniformLocation uSTMatrix");
                            if (this.uSTMatrixHandle != -1) {
                                this.uFilterFactorHandle = GLES20.glGetUniformLocation(this.mProgram, "uFilterFactor");
                                checkGlError("glGetUniformLocation uFilterFactor");
                                if (this.uFilterFactorHandle != -1) {
                                    this.uDismissFlagHandle = GLES20.glGetUniformLocation(this.mProgram, "uDismissFlag");
                                    checkGlError("glGetUniformLocation uDismissFlag");
                                    if (this.uDismissFlagHandle != -1) {
                                        prepareSurface();
                                        return;
                                    }
                                    throw new RuntimeException("Could not get attrib location for uDismissFlag");
                                }
                                throw new RuntimeException("Could not get attrib location for uFilterFactor");
                            }
                            throw new RuntimeException("Could not get attrib location for uSTMatrix");
                        }
                        throw new RuntimeException("Could not get attrib location for uMVPMatrix");
                    }
                    throw new RuntimeException("Could not get attrib color location for aTextureColorCoord");
                }
                throw new RuntimeException("Could not get attrib alpha location for aTextureAlphaCoord");
            }
            throw new RuntimeException("Could not get attrib location for aPosition");
        }
    }

    public void setDarkFilter(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
            if (f2 < 0.0f) {
                this.mFilterFactor = 0.0f;
            } else if (f2 > 1.0f) {
                this.mFilterFactor = 1.0f;
            } else {
                this.mFilterFactor = f2;
            }
        }
    }

    public void setOnSurfacePrepareListener(OnSurfacePrepareListener onSurfacePrepareListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onSurfacePrepareListener) == null) {
            this.mOnSurfacePrepareListener = onSurfacePrepareListener;
        }
    }
}
