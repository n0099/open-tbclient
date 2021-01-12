package com.baidu.ala.dumixar;

import android.opengl.EGLContext;
/* loaded from: classes14.dex */
public interface ITextureReader {
    void onTextureUpdate(int i, int i2, int i3);

    void release();

    void setup(EGLContext eGLContext);
}
