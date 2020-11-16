package com.baidu.ar.arplay.core.engine.pixel;
/* loaded from: classes12.dex */
public interface IPixelReader {
    void createPixelReader(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener);

    void destroyPixelReader(PixelReadListener pixelReadListener);
}
