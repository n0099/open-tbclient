package com.baidu.adp.framework.client.socket;

import android.app.Application;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.shell.SapiErrorCode;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class h {
    private static int BASE_ERROR_NO = -100000000;
    public static final int qJ = BASE_ERROR_NO + SapiErrorCode.NETWORK_FAILED;
    public static final int qK = BASE_ERROR_NO + SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE;
    public static final int qL = BASE_ERROR_NO - 210;
    public static final int qM = BASE_ERROR_NO - 211;
    public static final int qN = BASE_ERROR_NO - 212;
    public static final int qO = BASE_ERROR_NO - 213;
    public static final int qP = BASE_ERROR_NO - 214;
    public static final int qQ = BASE_ERROR_NO - 220;
    public static final int qR = BASE_ERROR_NO - 221;
    public static final int qS = BASE_ERROR_NO - 230;
    public static final int qT = BASE_ERROR_NO - 231;
    public static final int qU = BASE_ERROR_NO - 232;
    public static final int qV = BASE_ERROR_NO - 233;
    public static final int qW = BASE_ERROR_NO - 234;
    public static final int qX = BASE_ERROR_NO - 235;
    public static final int qY = BASE_ERROR_NO - 236;
    public static final int qZ = BASE_ERROR_NO + GetTplStokenResult.ERROR_CODE_BDUSS_NOT_EXIST;
    public static final int ra = BASE_ERROR_NO + GetTplStokenResult.ERROR_CODE_TARGET_TPL_LIST_EMPTY;
    public static final int rb = BASE_ERROR_NO - 303;
    public static final int rc = BASE_ERROR_NO + GetTplStokenResult.ERROR_CODE_PARSE_DATA_FAIL;
    public static final int rd = BASE_ERROR_NO + GetTplStokenResult.ERROR_CODE_PTOKEN_EMPTY;
    public static final int re = BASE_ERROR_NO + GetTplStokenResult.ERROR_CODE_STOKENS_NOT_MATCH;
    public static final int rf = BASE_ERROR_NO - 307;
    public static final int rg = BASE_ERROR_NO - 308;
    public static final int rh = BASE_ERROR_NO - 309;
    public static final int ri = BASE_ERROR_NO - 310;
    public static final int rj = BASE_ERROR_NO - 311;
    public static final int rk = BASE_ERROR_NO - 312;
    public static final int rl = BASE_ERROR_NO - 313;
    public static final int rm = BASE_ERROR_NO - 314;
    public static final int ro = BASE_ERROR_NO - 310;
    public static final int rp = BASE_ERROR_NO - 311;
    public static final int rq = BASE_ERROR_NO - 400;
    public static final int rr = BASE_ERROR_NO - 501;
    private static String rs = null;
    private static String rt = null;
    private static String[] ru = null;
    private static int[] rv = com.baidu.adp.framework.c.reconStrategy;
    private static ArrayList<BasicNameValuePair> rw = null;

    public static String R(int i) {
        int i2 = BASE_ERROR_NO - i;
        Application app = BdBaseApplication.getInst().getApp();
        return (i2 <= -300 || i2 > -200) ? app.getString(R.string.im_error_default) : app.getString(R.string.im_error_codec);
    }

    public static int[] dh() {
        return rv;
    }

    public static void b(int[] iArr) {
        if (iArr != null) {
            rv = iArr;
        }
    }

    public static String getUrl() {
        return rs;
    }

    public static void setUrl(String str) {
        rs = str;
    }

    public static String di() {
        return rt;
    }

    public static void K(String str) {
        rt = str;
    }

    public static ArrayList<BasicNameValuePair> dj() {
        return rw;
    }

    public static void c(ArrayList<BasicNameValuePair> arrayList) {
        rw = arrayList;
    }
}
