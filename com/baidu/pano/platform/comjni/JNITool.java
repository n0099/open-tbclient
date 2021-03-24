package com.baidu.pano.platform.comjni;

import com.baidu.lbsapi.tools.Point;
/* loaded from: classes2.dex */
public class JNITool {
    public static native Point coorUtil(String str, double d2, double d3);

    public static native Point ll2mc(double d2, double d3);

    public static native Point mc2ll(double d2, double d3);
}
