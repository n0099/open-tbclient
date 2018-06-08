package com.baidu.baiduarsdk.filter.a;

import com.baidu.baiduarsdk.filter.configdata.FilterData;
/* loaded from: classes3.dex */
public class p {
    public static q a(FilterData filterData) {
        if (filterData == null) {
            return null;
        }
        FilterData.PassType b = filterData.b();
        FilterData.PassSubType c = filterData.c();
        switch (b) {
            case COLOR_ADJUST:
                switch (c) {
                    case BRIGHTNESS:
                        return new b();
                    case CONTRAST:
                        return new c();
                    case SATURATION:
                        return new n();
                    case SATURATION_PS:
                        return new o();
                    case EXPOSURE:
                        return new h();
                    case GRAY_SCALE:
                        return new j();
                    case HSB:
                        return new k();
                    default:
                        return null;
                }
            case BEAUTY:
                return new a();
            case MASK_BLEND:
                switch (c) {
                    case LOOK_UP:
                        return new l();
                    case MULTI_PICTURE_BLEND:
                        return new m();
                    case CURVE_PS:
                        return new e();
                    case CURVE_RIGHT:
                        return new f();
                    case CURVE_LEFT:
                        return new d();
                    default:
                        return null;
                }
            case CUSTOM:
                return new g();
            case STYLIZE:
                switch (c) {
                    case GAUSSIAN_BLUR:
                        return new i();
                    default:
                        return null;
                }
            default:
                return null;
        }
    }
}
