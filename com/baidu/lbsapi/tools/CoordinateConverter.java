package com.baidu.lbsapi.tools;

import com.baidu.pano.platform.comjni.JNITool;
/* loaded from: classes7.dex */
public class CoordinateConverter {

    /* loaded from: classes7.dex */
    public enum COOR_TYPE {
        COOR_TYPE_WGS84,
        COOR_TYPE_GCJ02
    }

    public static Point converter(COOR_TYPE coor_type, Point point) {
        return JNITool.coorUtil(a(coor_type), point.x, point.y);
    }

    public static Point LLConverter2MC(double d, double d2) {
        return JNITool.ll2mc(d, d2);
    }

    public static Point MCConverter2LL(double d, double d2) {
        return JNITool.mc2ll(d, d2);
    }

    private static String a(COOR_TYPE coor_type) {
        switch (coor_type) {
            case COOR_TYPE_WGS84:
                return "WGS84";
            case COOR_TYPE_GCJ02:
                return "GCJ02";
            default:
                return "WGS84";
        }
    }
}
