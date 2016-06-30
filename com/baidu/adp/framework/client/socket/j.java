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
    public static final int eR = BASE_ERROR_NO + SapiErrorCode.NETWORK_FAILED;
    public static final int eS = BASE_ERROR_NO + SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE;
    public static final int eT = BASE_ERROR_NO - 210;
    public static final int eU = BASE_ERROR_NO - 211;
    public static final int eV = BASE_ERROR_NO - 212;
    public static final int eW = BASE_ERROR_NO - 220;
    public static final int eX = BASE_ERROR_NO - 221;
    public static final int eY = BASE_ERROR_NO - 230;
    public static final int eZ = BASE_ERROR_NO - 231;
    public static final int fa = BASE_ERROR_NO - 232;
    public static final int fb = BASE_ERROR_NO - 233;
    public static final int fc = BASE_ERROR_NO - 234;
    public static final int fd = BASE_ERROR_NO - 235;
    public static final int fe = BASE_ERROR_NO - 236;
    public static final int ff = BASE_ERROR_NO - 301;
    public static final int fg = BASE_ERROR_NO - 302;
    public static final int fh = BASE_ERROR_NO - 303;
    public static final int fi = BASE_ERROR_NO - 304;
    public static final int fj = BASE_ERROR_NO - 305;
    public static final int fk = BASE_ERROR_NO - 306;
    public static final int fl = BASE_ERROR_NO - 307;
    public static final int fm = BASE_ERROR_NO - 308;
    public static final int fn = BASE_ERROR_NO - 309;
    public static final int fo = BASE_ERROR_NO - 310;
    public static final int fp = BASE_ERROR_NO - 311;
    public static final int fq = BASE_ERROR_NO - 312;
    public static final int fr = BASE_ERROR_NO - 313;
    public static final int fs = BASE_ERROR_NO - 314;
    public static final int ft = BASE_ERROR_NO - 310;
    public static final int fu = BASE_ERROR_NO - 311;
    public static final int fv = BASE_ERROR_NO - 400;
    public static final int fw = BASE_ERROR_NO - 501;
    private static String fx = null;
    private static String fy = null;
    private static String[] fz = null;
    private static int[] fA = com.baidu.adp.framework.c.reconStrategy;
    private static ArrayList<BasicNameValuePair> fB = null;

    public static String z(int i) {
        int i2 = BASE_ERROR_NO - i;
        Application app = BdBaseApplication.getInst().getApp();
        return (i2 <= -300 || i2 > -200) ? app.getString(R.string.im_error_default) : app.getString(R.string.im_error_codec);
    }

    public static int[] aV() {
        return fA;
    }

    public static void b(int[] iArr) {
        if (iArr != null) {
            fA = iArr;
        }
    }

    public static String getUrl() {
        return fx;
    }

    public static void setUrl(String str) {
        fx = str;
    }

    public static String aW() {
        return fy;
    }

    public static void z(String str) {
        fy = str;
    }

    public static ArrayList<BasicNameValuePair> aX() {
        return fB;
    }

    public static void b(ArrayList<BasicNameValuePair> arrayList) {
        fB = arrayList;
    }
}
