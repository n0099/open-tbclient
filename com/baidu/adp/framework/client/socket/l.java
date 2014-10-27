package com.baidu.adp.framework.client.socket;

import android.app.Application;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.sapi2.shell.SapiErrorCode;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class l {
    private static int BASE_ERROR_NO = -100000000;
    public static final int bt = BASE_ERROR_NO + SapiErrorCode.NETWORK_FAILED;
    public static final int bu = BASE_ERROR_NO - 201;
    public static final int bv = BASE_ERROR_NO - 210;
    public static final int bw = BASE_ERROR_NO - 211;
    public static final int bx = BASE_ERROR_NO - 212;
    public static final int by = BASE_ERROR_NO - 220;
    public static final int bz = BASE_ERROR_NO - 221;
    public static final int bA = BASE_ERROR_NO - 230;
    public static final int bB = BASE_ERROR_NO - 231;
    public static final int bC = BASE_ERROR_NO - 232;
    public static final int bD = BASE_ERROR_NO - 233;
    public static final int bE = BASE_ERROR_NO - 234;
    public static final int bF = BASE_ERROR_NO - 235;
    public static final int bG = BASE_ERROR_NO - 236;
    public static final int bH = BASE_ERROR_NO - 301;
    public static final int bI = BASE_ERROR_NO - 302;
    public static final int bJ = BASE_ERROR_NO - 303;
    public static final int bK = BASE_ERROR_NO - 304;
    public static final int bL = BASE_ERROR_NO - 305;
    public static final int bM = BASE_ERROR_NO - 306;
    public static final int bN = BASE_ERROR_NO - 307;
    public static final int bO = BASE_ERROR_NO - 308;
    public static final int bP = BASE_ERROR_NO - 309;
    public static final int bQ = BASE_ERROR_NO - 310;
    public static final int bR = BASE_ERROR_NO - 311;
    public static final int bS = BASE_ERROR_NO - 312;
    public static final int bT = BASE_ERROR_NO - 313;
    public static final int bU = BASE_ERROR_NO - 314;
    public static final int bV = BASE_ERROR_NO - 310;
    public static final int bW = BASE_ERROR_NO - 400;
    public static final int bX = BASE_ERROR_NO - 501;
    private static String bY = null;
    private static String bZ = null;
    private static String[] ca = null;
    private static int[] cb = com.baidu.adp.framework.b.reconStrategy;
    private static ArrayList<BasicNameValuePair> cc = null;

    public static String j(int i) {
        int i2 = BASE_ERROR_NO - i;
        Application app = BdBaseApplication.getInst().getApp();
        return (i2 <= -300 || i2 > -200) ? app.getString(R.string.im_error_default) : app.getString(R.string.im_error_codec);
    }

    public static int[] aB() {
        return cb;
    }

    public static void a(int[] iArr) {
        if (iArr != null) {
            cb = iArr;
        }
    }

    public static String getUrl() {
        return bY;
    }

    public static void setUrl(String str) {
        bY = str;
    }

    public static String aC() {
        return bZ;
    }

    public static void k(String str) {
        bZ = str;
    }

    public static ArrayList<BasicNameValuePair> aD() {
        return cc;
    }

    public static void b(ArrayList<BasicNameValuePair> arrayList) {
        cc = arrayList;
    }
}
