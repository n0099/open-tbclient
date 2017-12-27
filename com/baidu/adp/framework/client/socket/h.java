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
    public static final int adc = BASE_ERROR_NO + SapiErrorCode.NETWORK_FAILED;
    public static final int ade = BASE_ERROR_NO + SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE;
    public static final int adf = BASE_ERROR_NO - 210;
    public static final int adg = BASE_ERROR_NO - 211;
    public static final int adh = BASE_ERROR_NO - 212;
    public static final int adi = BASE_ERROR_NO - 213;
    public static final int adj = BASE_ERROR_NO - 214;
    public static final int adk = BASE_ERROR_NO - 220;
    public static final int adl = BASE_ERROR_NO - 221;
    public static final int adm = BASE_ERROR_NO - 230;
    public static final int adn = BASE_ERROR_NO - 231;
    public static final int ado = BASE_ERROR_NO - 232;
    public static final int adp = BASE_ERROR_NO - 233;
    public static final int adq = BASE_ERROR_NO - 234;
    public static final int adr = BASE_ERROR_NO - 235;
    public static final int ads = BASE_ERROR_NO - 236;
    public static final int adt = BASE_ERROR_NO - 301;
    public static final int adu = BASE_ERROR_NO + GetTplStokenResult.ERROR_CODE_TARGET_TPL_LIST_EMPTY;
    public static final int adv = BASE_ERROR_NO - 303;
    public static final int adw = BASE_ERROR_NO + GetTplStokenResult.ERROR_CODE_PARSE_DATA_FAIL;
    public static final int adx = BASE_ERROR_NO + GetTplStokenResult.ERROR_CODE_PTOKEN_EMPTY;
    public static final int ady = BASE_ERROR_NO + GetTplStokenResult.ERROR_CODE_STOKENS_NOT_MATCH;
    public static final int adz = BASE_ERROR_NO - 307;
    public static final int adA = BASE_ERROR_NO - 308;
    public static final int adB = BASE_ERROR_NO - 309;
    public static final int adC = BASE_ERROR_NO - 310;
    public static final int adD = BASE_ERROR_NO - 311;
    public static final int adE = BASE_ERROR_NO - 312;
    public static final int adF = BASE_ERROR_NO - 313;
    public static final int adG = BASE_ERROR_NO - 314;
    public static final int adH = BASE_ERROR_NO - 310;
    public static final int adI = BASE_ERROR_NO - 311;
    public static final int adJ = BASE_ERROR_NO - 400;
    public static final int adK = BASE_ERROR_NO - 501;
    private static String adL = null;
    private static String adM = null;
    private static String[] adN = null;
    private static int[] adO = com.baidu.adp.framework.c.reconStrategy;
    private static ArrayList<BasicNameValuePair> adP = null;

    public static String cH(int i) {
        int i2 = BASE_ERROR_NO - i;
        Application app = BdBaseApplication.getInst().getApp();
        return (i2 <= -300 || i2 > -200) ? app.getString(R.string.im_error_default) : app.getString(R.string.im_error_codec);
    }

    public static int[] kB() {
        return adO;
    }

    public static void g(int[] iArr) {
        if (iArr != null) {
            adO = iArr;
        }
    }

    public static String getUrl() {
        return adL;
    }

    public static void setUrl(String str) {
        adL = str;
    }

    public static String kC() {
        return adM;
    }

    public static void K(String str) {
        adM = str;
    }

    public static ArrayList<BasicNameValuePair> kD() {
        return adP;
    }

    public static void d(ArrayList<BasicNameValuePair> arrayList) {
        adP = arrayList;
    }
}
