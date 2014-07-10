package com.baidu.adp.framework.client.socket;

import android.app.Application;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.sapi2.shell.SapiErrorCode;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class l {
    private static int F = -100000000;
    public static final int a = F + SapiErrorCode.NETWORK_FAILED;
    public static final int b = F - 201;
    public static final int c = F - 210;
    public static final int d = F - 211;
    public static final int e = F - 212;
    public static final int f = F - 220;
    public static final int g = F - 221;
    public static final int h = F - 230;
    public static final int i = F - 231;
    public static final int j = F - 232;
    public static final int k = F - 233;
    public static final int l = F - 234;
    public static final int m = F - 235;
    public static final int n = F - 236;
    public static final int o = F - 301;
    public static final int p = F - 302;
    public static final int q = F - 303;
    public static final int r = F - 304;
    public static final int s = F - 305;
    public static final int t = F - 306;
    public static final int u = F - 307;
    public static final int v = F - 308;
    public static final int w = F - 309;
    public static final int x = F - 310;
    public static final int y = F - 311;
    public static final int z = F - 312;
    public static final int A = F - 313;
    public static final int B = F - 314;
    public static final int C = F - 310;
    public static final int D = F - 400;
    public static final int E = F - 501;
    private static String G = null;
    private static String H = null;
    private static String[] I = null;
    private static int[] J = com.baidu.adp.framework.b.a;
    private static ArrayList<BasicNameValuePair> K = null;

    public static String a(int i2) {
        int i3 = F - i2;
        Application app = BdBaseApplication.getInst().getApp();
        return (i3 <= -300 || i3 > -200) ? app.getString(com.baidu.adp.f.im_error_default) : app.getString(com.baidu.adp.f.im_error_codec);
    }

    public static int[] a() {
        return J;
    }

    public static void a(int[] iArr) {
        if (iArr != null) {
            J = iArr;
        }
    }

    public static String b() {
        return G;
    }

    public static void a(String str) {
        G = str;
    }

    public static String c() {
        return H;
    }

    public static void b(String str) {
        H = str;
    }

    public static ArrayList<BasicNameValuePair> d() {
        return K;
    }

    public static void a(ArrayList<BasicNameValuePair> arrayList) {
        K = arrayList;
    }
}
