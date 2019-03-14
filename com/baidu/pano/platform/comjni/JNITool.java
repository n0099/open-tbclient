package com.baidu.pano.platform.comjni;

import com.baidu.lbsapi.tools.Point;
/* loaded from: classes5.dex */
public class JNITool {
    public static native Point coorUtil(String str, double d, double d2);

    public static native Point ll2mc(double d, double d2);

    public static native Point mc2ll(double d, double d2);
}
