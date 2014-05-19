package com.baidu.adp.lib.network.websocket;

import android.app.Application;
import com.baidu.sapi2.shell.SapiErrorCode;
/* loaded from: classes.dex */
public class i {
    private static int v = -100000000;
    public static final int a = v + SapiErrorCode.NETWORK_FAILED;
    public static final int b = v - 201;
    public static final int c = v - 210;
    public static final int d = v - 211;
    public static final int e = v - 212;
    public static final int f = v - 220;
    public static final int g = v - 221;
    public static final int h = v - 230;
    public static final int i = v - 231;
    public static final int j = v - 232;
    public static final int k = v - 233;
    public static final int l = v - 301;
    public static final int m = v - 302;
    public static final int n = v - 303;
    public static final int o = v - 304;
    public static final int p = v - 305;
    public static final int q = v - 306;
    public static final int r = v - 307;
    public static final int s = v - 308;
    public static final int t = v - 309;
    public static final int u = v - 501;

    public static String a(int i2) {
        int i3 = v - i2;
        Application app = com.baidu.adp.base.a.getInst().getApp();
        return (i3 <= 199 || i3 >= 300) ? app.getString(com.baidu.adp.f.im_error_default) : app.getString(com.baidu.adp.f.im_error_codec);
    }
}
