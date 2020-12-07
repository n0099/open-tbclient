package com.baidu.ala.recorder.video.gles;

import android.annotation.TargetApi;
import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.FloatBuffer;
@TargetApi(15)
/* loaded from: classes9.dex */
public class GLShader {
    private int fragmentShader;
    private int program = GLES20.glCreateProgram();
    private int vertexShader;

    private static int compileShader(int i, String str) {
        int[] iArr = {0};
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 1) {
            GlUtil.logPrint("Could not compile shader " + i + ":" + GLES20.glGetShaderInfoLog(glCreateShader));
            throw new RuntimeException(GLES20.glGetShaderInfoLog(glCreateShader));
        }
        GlUtil.checkGlError("compileShader");
        return glCreateShader;
    }

    public GLShader(String str, String str2) {
        this.vertexShader = compileShader(35633, str);
        this.fragmentShader = compileShader(35632, str2);
        if (this.program == 0) {
            throw new RuntimeException("Could not create program");
        }
        GLES20.glAttachShader(this.program, this.vertexShader);
        GLES20.glAttachShader(this.program, this.fragmentShader);
        GLES20.glLinkProgram(this.program);
        int[] iArr = {0};
        GLES20.glGetProgramiv(this.program, 35714, iArr, 0);
        if (iArr[0] != 1) {
            GlUtil.logPrint("Could not link program: " + GLES20.glGetProgramInfoLog(this.program));
            throw new RuntimeException(GLES20.glGetProgramInfoLog(this.program));
        } else {
            GlUtil.checkGlError("Creating GlShader");
        }
    }

    public int getAttribLocation(String str) {
        if (this.program == -1) {
            throw new RuntimeException("The program has been released");
        }
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.program, str);
        if (glGetAttribLocation < 0) {
            throw new RuntimeException("Could not locate '" + str + "' in program");
        }
        return glGetAttribLocation;
    }

    public void setVertexAttribArray(String str, int i, FloatBuffer floatBuffer) {
        if (this.program == -1) {
            throw new RuntimeException("The program has been released");
        }
        int attribLocation = getAttribLocation(str);
        GLES20.glEnableVertexAttribArray(attribLocation);
        GLES20.glVertexAttribPointer(attribLocation, i, 5126, false, 0, (Buffer) floatBuffer);
        GlUtil.checkGlError("setVertexAttribArray");
    }

    public int getUniformLocation(String str) {
        if (this.program == -1) {
            throw new RuntimeException("The program has been released");
        }
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.program, str);
        if (glGetUniformLocation < 0) {
            throw new RuntimeException("Could not locate uniform '" + str + "' in program");
        }
        return glGetUniformLocation;
    }

    public void useProgram() {
        if (this.program == -1) {
            throw new RuntimeException("The program has been released");
        }
        GLES20.glUseProgram(this.program);
        GlUtil.checkGlError("glUseProgram");
    }

    public void release() {
        GlUtil.logPrint("Deleting shader.");
        if (this.vertexShader != -1) {
            GLES20.glDeleteShader(this.vertexShader);
            this.vertexShader = -1;
        }
        if (this.fragmentShader != -1) {
            GLES20.glDeleteShader(this.fragmentShader);
            this.fragmentShader = -1;
        }
        if (this.program != -1) {
            GLES20.glDeleteProgram(this.program);
            this.program = -1;
        }
    }

    public int getProgram() {
        return this.program;
    }
}
