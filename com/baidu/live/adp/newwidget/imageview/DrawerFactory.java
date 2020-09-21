package com.baidu.live.adp.newwidget.imageview;
/* loaded from: classes4.dex */
public class DrawerFactory {
    public static final int COMMON = 0;
    public static final int COMMON_NO_COLOR_FILTER = 6;
    public static final int PATH_CLIP_HARDWARE = 2;
    public static final int PATH_CLIP_SOFTWARE = 3;
    public static final int SHADER = 1;
    public static final int SHADER_CLIP_HARDWARE = 5;
    public static final int SHADER_CLIP_SOFTWARE = 4;
    public static DrawerFactory mInstance = new DrawerFactory();

    private DrawerFactory() {
    }

    public static DrawerFactory getInstance() {
        return mInstance;
    }

    public AbsDrawer getDecoratorByType(int i) {
        switch (i) {
            case 0:
                return new CommonDrawer();
            case 1:
                return new ShaderDrawer();
            case 2:
                return new HardwarePathClipDrawer();
            case 3:
                return new SoftwarePathClipDrawer();
            case 4:
                return new SoftwareClipShaderDrawer();
            case 5:
                return new HardwareClipShaderDrawer();
            case 6:
                return new NoColorFilterCommonDrawer();
            default:
                return new CommonDrawer();
        }
    }
}
