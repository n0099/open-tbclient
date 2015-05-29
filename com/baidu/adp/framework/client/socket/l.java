package com.baidu.adp.framework.client.socket;

import android.app.Application;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.shell.SapiErrorCode;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class l {
    private static int BASE_ERROR_NO = -100000000;
    public static final int oT = BASE_ERROR_NO + SapiErrorCode.NETWORK_FAILED;
    public static final int oU = BASE_ERROR_NO + SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE;
    public static final int oV = BASE_ERROR_NO - 210;
    public static final int oW = BASE_ERROR_NO - 211;
    public static final int oX = BASE_ERROR_NO - 212;
    public static final int oY = BASE_ERROR_NO - 220;
    public static final int oZ = BASE_ERROR_NO - 221;
    public static final int pa = BASE_ERROR_NO - 230;
    public static final int pd = BASE_ERROR_NO - 231;
    public static final int pe = BASE_ERROR_NO - 232;
    public static final int pf = BASE_ERROR_NO - 233;
    public static final int pg = BASE_ERROR_NO - 234;
    public static final int ph = BASE_ERROR_NO - 235;
    public static final int pi = BASE_ERROR_NO - 236;
    public static final int pj = BASE_ERROR_NO - 301;
    public static final int pl = BASE_ERROR_NO - 302;
    public static final int po = BASE_ERROR_NO - 303;
    public static final int pp = BASE_ERROR_NO - 304;
    public static final int pq = BASE_ERROR_NO - 305;
    public static final int pr = BASE_ERROR_NO - 306;
    public static final int ps = BASE_ERROR_NO - 307;
    public static final int pt = BASE_ERROR_NO - 308;
    public static final int pu = BASE_ERROR_NO - 309;
    public static final int pv = BASE_ERROR_NO - 310;
    public static final int pw = BASE_ERROR_NO - 311;
    public static final int px = BASE_ERROR_NO - 312;
    public static final int py = BASE_ERROR_NO - 313;
    public static final int pz = BASE_ERROR_NO - 314;
    public static final int pA = BASE_ERROR_NO - 310;
    public static final int pB = BASE_ERROR_NO - 311;
    public static final int pC = BASE_ERROR_NO - 400;
    public static final int pD = BASE_ERROR_NO - 501;
    private static String pE = null;
    private static String pF = null;
    private static String[] pG = null;
    private static int[] pH = com.baidu.adp.framework.c.reconStrategy;
    private static ArrayList<BasicNameValuePair> pI = null;

    public static String y(int i) {
        int i2 = BASE_ERROR_NO - i;
        Application app = BdBaseApplication.getInst().getApp();
        return (i2 <= -300 || i2 > -200) ? app.getString(R.string.im_error_default) : app.getString(R.string.im_error_codec);
    }

    public static int[] eB() {
        return pH;
    }

    public static void a(int[] iArr) {
        if (iArr != null) {
            pH = iArr;
        }
    }

    public static String getUrl() {
        return pE;
    }

    public static void setUrl(String str) {
        pE = str;
    }

    public static String eC() {
        return pF;
    }

    public static void K(String str) {
        pF = str;
    }

    public static ArrayList<BasicNameValuePair> eD() {
        return pI;
    }

    public static void e(ArrayList<BasicNameValuePair> arrayList) {
        pI = arrayList;
    }
}
