package com.baidu.adp.gif;

import android.graphics.Bitmap;
import android.graphics.Canvas;
/* loaded from: classes.dex */
public interface b {
    boolean a(Bitmap bitmap, Canvas canvas);

    boolean cM(int i);

    int cN(int i);

    void close();

    int getFrameCount();

    int getHeight();

    int getWidth();
}
