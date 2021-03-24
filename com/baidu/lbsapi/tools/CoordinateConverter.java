package com.baidu.lbsapi.tools;

import com.baidu.pano.platform.comjni.JNITool;
/* loaded from: classes2.dex */
public class CoordinateConverter {

    /* renamed from: com.baidu.lbsapi.tools.CoordinateConverter$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$lbsapi$tools$CoordinateConverter$COOR_TYPE;

        static {
            int[] iArr = new int[COOR_TYPE.values().length];
            $SwitchMap$com$baidu$lbsapi$tools$CoordinateConverter$COOR_TYPE = iArr;
            try {
                iArr[COOR_TYPE.COOR_TYPE_WGS84.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$lbsapi$tools$CoordinateConverter$COOR_TYPE[COOR_TYPE.COOR_TYPE_GCJ02.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum COOR_TYPE {
        COOR_TYPE_WGS84,
        COOR_TYPE_GCJ02
    }

    public static Point LLConverter2MC(double d2, double d3) {
        return JNITool.ll2mc(d2, d3);
    }

    public static Point MCConverter2LL(double d2, double d3) {
        return JNITool.mc2ll(d2, d3);
    }

    public static String a(COOR_TYPE coor_type) {
        int i = AnonymousClass1.$SwitchMap$com$baidu$lbsapi$tools$CoordinateConverter$COOR_TYPE[coor_type.ordinal()];
        return (i == 1 || i != 2) ? "WGS84" : "GCJ02";
    }

    public static Point converter(COOR_TYPE coor_type, Point point) {
        return JNITool.coorUtil(a(coor_type), point.x, point.y);
    }
}
