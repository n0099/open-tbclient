package com.baidu.adp.gif;

import android.graphics.Bitmap;
import android.graphics.Canvas;
/* loaded from: classes.dex */
public interface b {
    int A(int i);

    boolean a(Bitmap bitmap, Canvas canvas);

    void close();

    int getFrameCount();

    int getHeight();

    int getWidth();

    boolean z(int i);
}
