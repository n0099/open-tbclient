package com.baidu.adp.framework.client.socket;

import android.app.Application;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.shell.SapiErrorCode;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class j {
    private static int BASE_ERROR_NO = -100000000;
    public static final int hG = BASE_ERROR_NO + SapiErrorCode.NETWORK_FAILED;
    public static final int hH = BASE_ERROR_NO + SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE;
    public static final int hI = BASE_ERROR_NO - 210;
    public static final int hJ = BASE_ERROR_NO - 211;
    public static final int hK = BASE_ERROR_NO - 212;
    public static final int hL = BASE_ERROR_NO - 220;
    public static final int hM = BASE_ERROR_NO - 221;
    public static final int hN = BASE_ERROR_NO - 230;
    public static final int hO = BASE_ERROR_NO - 231;
    public static final int hP = BASE_ERROR_NO - 232;
    public static final int hQ = BASE_ERROR_NO - 233;
    public static final int hR = BASE_ERROR_NO - 234;
    public static final int hS = BASE_ERROR_NO - 235;
    public static final int hT = BASE_ERROR_NO - 236;
    public static final int hU = BASE_ERROR_NO - 301;
    public static final int hV = BASE_ERROR_NO - 302;
    public static final int hW = BASE_ERROR_NO - 303;
    public static final int hX = BASE_ERROR_NO - 304;
    public static final int hY = BASE_ERROR_NO - 305;
    public static final int hZ = BASE_ERROR_NO - 306;
    public static final int ia = BASE_ERROR_NO - 307;
    public static final int ib = BASE_ERROR_NO - 308;
    public static final int ic = BASE_ERROR_NO - 309;
    public static final int ie = BASE_ERROR_NO - 310;

    /* renamed from: if  reason: not valid java name */
    public static final int f0if = BASE_ERROR_NO - 311;
    public static final int ig = BASE_ERROR_NO - 312;
    public static final int ih = BASE_ERROR_NO - 313;
    public static final int ii = BASE_ERROR_NO - 314;
    public static final int ij = BASE_ERROR_NO - 310;
    public static final int ik = BASE_ERROR_NO - 311;
    public static final int il = BASE_ERROR_NO - 400;
    public static final int im = BASE_ERROR_NO - 501;
    private static String io = null;
    private static String iq = null;
    private static String[] ir = null;
    private static int[] iu = com.baidu.adp.framework.c.reconStrategy;
    private static ArrayList<BasicNameValuePair> iw = null;

    public static String P(int i) {
        int i2 = BASE_ERROR_NO - i;
        Application app = BdBaseApplication.getInst().getApp();
        return (i2 <= -300 || i2 > -200) ? app.getString(R.string.im_error_default) : app.getString(R.string.im_error_codec);
    }

    public static int[] bP() {
        return iu;
    }

    public static void b(int[] iArr) {
        if (iArr != null) {
            iu = iArr;
        }
    }

    public static String getUrl() {
        return io;
    }

    public static void setUrl(String str) {
        io = str;
    }

    public static String bQ() {
        return iq;
    }

    public static void C(String str) {
        iq = str;
    }

    public static ArrayList<BasicNameValuePair> bR() {
        return iw;
    }

    public static void c(ArrayList<BasicNameValuePair> arrayList) {
        iw = arrayList;
    }
}
