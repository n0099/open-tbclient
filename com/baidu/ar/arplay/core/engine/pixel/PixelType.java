package com.baidu.ar.arplay.core.engine.pixel;
/* loaded from: classes12.dex */
public enum PixelType {
    RGBA(0),
    BGRA(1),
    BGR(2),
    NV12(3),
    NV21(4),
    I420(5),
    YV12(6),
    GRAY(7),
    RGB(8),
    RED(9),
    GREEN(10),
    BLUE(11),
    ALPHA(12);
    
    private final int value;

    PixelType(int i) {
        this.value = i;
    }

    public static PixelType valueOf(int i) {
        return i == RGBA.getValue() ? RGBA : i == BGRA.getValue() ? BGRA : i == BGR.getValue() ? BGR : i == NV12.getValue() ? NV12 : i == NV21.getValue() ? NV21 : i == I420.getValue() ? I420 : i == YV12.getValue() ? YV12 : i == GRAY.getValue() ? GRAY : i == RGB.getValue() ? RGB : i == RED.getValue() ? RED : i == GREEN.getValue() ? GREEN : i == BLUE.getValue() ? BLUE : i == ALPHA.getValue() ? ALPHA : RGBA;
    }

    public int getValue() {
        return this.value;
    }
}
