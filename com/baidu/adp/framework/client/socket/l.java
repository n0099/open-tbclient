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
    public static final int dA = BASE_ERROR_NO + SapiErrorCode.NETWORK_FAILED;
    public static final int dB = BASE_ERROR_NO - 201;
    public static final int dC = BASE_ERROR_NO - 210;
    public static final int dD = BASE_ERROR_NO - 211;
    public static final int dE = BASE_ERROR_NO - 212;
    public static final int dF = BASE_ERROR_NO - 220;
    public static final int dG = BASE_ERROR_NO - 221;
    public static final int dH = BASE_ERROR_NO - 230;
    public static final int dI = BASE_ERROR_NO - 231;
    public static final int dJ = BASE_ERROR_NO - 232;
    public static final int dK = BASE_ERROR_NO - 233;
    public static final int dL = BASE_ERROR_NO - 234;
    public static final int dM = BASE_ERROR_NO - 235;
    public static final int dN = BASE_ERROR_NO - 236;
    public static final int dO = BASE_ERROR_NO - 301;
    public static final int dP = BASE_ERROR_NO - 302;
    public static final int dQ = BASE_ERROR_NO - 303;
    public static final int dR = BASE_ERROR_NO - 304;
    public static final int dS = BASE_ERROR_NO - 305;
    public static final int dT = BASE_ERROR_NO - 306;
    public static final int dU = BASE_ERROR_NO - 307;
    public static final int dV = BASE_ERROR_NO - 308;
    public static final int dW = BASE_ERROR_NO - 309;
    public static final int dX = BASE_ERROR_NO - 310;
    public static final int dY = BASE_ERROR_NO - 311;
    public static final int dZ = BASE_ERROR_NO - 312;
    public static final int ea = BASE_ERROR_NO - 313;
    public static final int eb = BASE_ERROR_NO - 314;
    public static final int ec = BASE_ERROR_NO - 310;
    public static final int ed = BASE_ERROR_NO - 311;
    public static final int ee = BASE_ERROR_NO - 400;
    public static final int ef = BASE_ERROR_NO - 501;
    private static String eg = null;
    private static String eh = null;
    private static String[] ei = null;
    private static int[] ej = com.baidu.adp.framework.b.reconStrategy;
    private static ArrayList<BasicNameValuePair> ek = null;

    public static String w(int i) {
        int i2 = BASE_ERROR_NO - i;
        Application app = BdBaseApplication.getInst().getApp();
        return (i2 <= -300 || i2 > -200) ? app.getString(R.string.im_error_default) : app.getString(R.string.im_error_codec);
    }

    public static int[] bb() {
        return ej;
    }

    public static void a(int[] iArr) {
        if (iArr != null) {
            ej = iArr;
        }
    }

    public static String getUrl() {
        return eg;
    }

    public static void setUrl(String str) {
        eg = str;
    }

    public static String bc() {
        return eh;
    }

    public static void z(String str) {
        eh = str;
    }

    public static ArrayList<BasicNameValuePair> bd() {
        return ek;
    }

    public static void e(ArrayList<BasicNameValuePair> arrayList) {
        ek = arrayList;
    }
}
