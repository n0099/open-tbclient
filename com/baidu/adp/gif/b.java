package com.baidu.adp.gif;

import android.graphics.Bitmap;
import android.graphics.Canvas;
/* loaded from: classes.dex */
public interface b {
    boolean R(int i);

    int S(int i);

    boolean a(Bitmap bitmap, Canvas canvas);

    void close();

    int getFrameCount();

    int getHeight();

    int getWidth();
}
