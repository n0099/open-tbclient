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
    public static final int pE = BASE_ERROR_NO + SapiErrorCode.NETWORK_FAILED;
    public static final int pF = BASE_ERROR_NO + SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE;
    public static final int pG = BASE_ERROR_NO - 210;
    public static final int pH = BASE_ERROR_NO - 211;
    public static final int pI = BASE_ERROR_NO - 212;
    public static final int pJ = BASE_ERROR_NO - 220;
    public static final int pK = BASE_ERROR_NO - 221;
    public static final int pL = BASE_ERROR_NO - 230;
    public static final int pM = BASE_ERROR_NO - 231;
    public static final int pN = BASE_ERROR_NO - 232;
    public static final int pO = BASE_ERROR_NO - 233;
    public static final int pP = BASE_ERROR_NO - 234;
    public static final int pQ = BASE_ERROR_NO - 235;
    public static final int pR = BASE_ERROR_NO - 236;
    public static final int pS = BASE_ERROR_NO - 301;
    public static final int pT = BASE_ERROR_NO - 302;
    public static final int pU = BASE_ERROR_NO - 303;
    public static final int pV = BASE_ERROR_NO - 304;
    public static final int pW = BASE_ERROR_NO - 305;
    public static final int pX = BASE_ERROR_NO - 306;
    public static final int pY = BASE_ERROR_NO - 307;
    public static final int pZ = BASE_ERROR_NO - 308;
    public static final int qa = BASE_ERROR_NO - 309;
    public static final int qb = BASE_ERROR_NO - 310;
    public static final int qc = BASE_ERROR_NO - 311;
    public static final int qd = BASE_ERROR_NO - 312;
    public static final int qe = BASE_ERROR_NO - 313;
    public static final int qf = BASE_ERROR_NO - 314;
    public static final int qg = BASE_ERROR_NO - 310;
    public static final int qh = BASE_ERROR_NO - 311;
    public static final int qi = BASE_ERROR_NO - 400;
    public static final int qj = BASE_ERROR_NO - 501;
    private static String qk = null;
    private static String ql = null;
    private static String[] qm = null;
    private static int[] qn = com.baidu.adp.framework.c.reconStrategy;
    private static ArrayList<BasicNameValuePair> qo = null;

    public static String Q(int i) {
        int i2 = BASE_ERROR_NO - i;
        Application app = BdBaseApplication.getInst().getApp();
        return (i2 <= -300 || i2 > -200) ? app.getString(R.string.im_error_default) : app.getString(R.string.im_error_codec);
    }

    public static int[] cY() {
        return qn;
    }

    public static void b(int[] iArr) {
        if (iArr != null) {
            qn = iArr;
        }
    }

    public static String getUrl() {
        return qk;
    }

    public static void setUrl(String str) {
        qk = str;
    }

    public static String cZ() {
        return ql;
    }

    public static void B(String str) {
        ql = str;
    }

    public static ArrayList<BasicNameValuePair> da() {
        return qo;
    }

    public static void c(ArrayList<BasicNameValuePair> arrayList) {
        qo = arrayList;
    }
}
