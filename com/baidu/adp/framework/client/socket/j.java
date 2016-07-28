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
    public static final int ft = BASE_ERROR_NO + SapiErrorCode.NETWORK_FAILED;
    public static final int fu = BASE_ERROR_NO + SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE;
    public static final int fv = BASE_ERROR_NO - 210;
    public static final int fw = BASE_ERROR_NO - 211;
    public static final int fx = BASE_ERROR_NO - 212;
    public static final int fy = BASE_ERROR_NO - 220;
    public static final int fz = BASE_ERROR_NO - 221;
    public static final int fA = BASE_ERROR_NO - 230;
    public static final int fB = BASE_ERROR_NO - 231;
    public static final int fC = BASE_ERROR_NO - 232;
    public static final int fD = BASE_ERROR_NO - 233;
    public static final int fE = BASE_ERROR_NO - 234;
    public static final int fF = BASE_ERROR_NO - 235;
    public static final int fG = BASE_ERROR_NO - 236;
    public static final int fH = BASE_ERROR_NO - 301;
    public static final int fI = BASE_ERROR_NO - 302;
    public static final int fJ = BASE_ERROR_NO - 303;
    public static final int fK = BASE_ERROR_NO - 304;
    public static final int fL = BASE_ERROR_NO - 305;
    public static final int fM = BASE_ERROR_NO - 306;
    public static final int fN = BASE_ERROR_NO - 307;
    public static final int fO = BASE_ERROR_NO - 308;
    public static final int fP = BASE_ERROR_NO - 309;
    public static final int fQ = BASE_ERROR_NO - 310;
    public static final int fR = BASE_ERROR_NO - 311;
    public static final int fS = BASE_ERROR_NO - 312;
    public static final int fT = BASE_ERROR_NO - 313;
    public static final int fU = BASE_ERROR_NO - 314;
    public static final int fV = BASE_ERROR_NO - 310;
    public static final int fW = BASE_ERROR_NO - 311;
    public static final int fX = BASE_ERROR_NO - 400;
    public static final int fY = BASE_ERROR_NO - 501;
    private static String fZ = null;
    private static String ga = null;
    private static String[] gb = null;
    private static int[] gc = com.baidu.adp.framework.c.reconStrategy;
    private static ArrayList<BasicNameValuePair> gd = null;

    public static String C(int i) {
        int i2 = BASE_ERROR_NO - i;
        Application app = BdBaseApplication.getInst().getApp();
        return (i2 <= -300 || i2 > -200) ? app.getString(R.string.im_error_default) : app.getString(R.string.im_error_codec);
    }

    public static int[] aU() {
        return gc;
    }

    public static void b(int[] iArr) {
        if (iArr != null) {
            gc = iArr;
        }
    }

    public static String getUrl() {
        return fZ;
    }

    public static void setUrl(String str) {
        fZ = str;
    }

    public static String aV() {
        return ga;
    }

    public static void B(String str) {
        ga = str;
    }

    public static ArrayList<BasicNameValuePair> aW() {
        return gd;
    }

    public static void c(ArrayList<BasicNameValuePair> arrayList) {
        gd = arrayList;
    }
}
