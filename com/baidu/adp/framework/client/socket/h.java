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
    public static final int ow = BASE_ERROR_NO + SapiErrorCode.NETWORK_FAILED;
    public static final int ox = BASE_ERROR_NO + SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE;
    public static final int oy = BASE_ERROR_NO - 210;
    public static final int oz = BASE_ERROR_NO - 211;
    public static final int oA = BASE_ERROR_NO - 212;
    public static final int oB = BASE_ERROR_NO - 213;
    public static final int oC = BASE_ERROR_NO - 214;
    public static final int oD = BASE_ERROR_NO - 220;
    public static final int oE = BASE_ERROR_NO - 221;
    public static final int oF = BASE_ERROR_NO - 230;
    public static final int oG = BASE_ERROR_NO - 231;
    public static final int oH = BASE_ERROR_NO - 232;
    public static final int oI = BASE_ERROR_NO - 233;
    public static final int oJ = BASE_ERROR_NO - 234;
    public static final int oK = BASE_ERROR_NO - 235;
    public static final int oL = BASE_ERROR_NO - 236;
    public static final int oM = BASE_ERROR_NO - 301;
    public static final int oN = BASE_ERROR_NO + GetTplStokenResult.ERROR_CODE_TARGET_TPL_LIST_EMPTY;
    public static final int oO = BASE_ERROR_NO - 303;
    public static final int oP = BASE_ERROR_NO + GetTplStokenResult.ERROR_CODE_PARSE_DATA_FAIL;
    public static final int oQ = BASE_ERROR_NO + GetTplStokenResult.ERROR_CODE_PTOKEN_EMPTY;
    public static final int oR = BASE_ERROR_NO + GetTplStokenResult.ERROR_CODE_STOKENS_NOT_MATCH;
    public static final int oS = BASE_ERROR_NO - 307;
    public static final int oT = BASE_ERROR_NO - 308;
    public static final int oU = BASE_ERROR_NO - 309;
    public static final int oV = BASE_ERROR_NO - 310;
    public static final int oW = BASE_ERROR_NO - 311;
    public static final int oX = BASE_ERROR_NO - 312;
    public static final int oY = BASE_ERROR_NO - 313;
    public static final int oZ = BASE_ERROR_NO - 314;
    public static final int pa = BASE_ERROR_NO - 310;
    public static final int pd = BASE_ERROR_NO - 311;
    public static final int pe = BASE_ERROR_NO - 400;
    public static final int pf = BASE_ERROR_NO - 501;
    private static String pg = null;
    private static String ph = null;
    private static String[] pi = null;
    private static int[] pj = com.baidu.adp.framework.c.reconStrategy;
    private static ArrayList<BasicNameValuePair> pl = null;

    public static String N(int i) {
        int i2 = BASE_ERROR_NO - i;
        Application app = BdBaseApplication.getInst().getApp();
        return (i2 <= -300 || i2 > -200) ? app.getString(R.string.im_error_default) : app.getString(R.string.im_error_codec);
    }

    public static int[] cX() {
        return pj;
    }

    public static void b(int[] iArr) {
        if (iArr != null) {
            pj = iArr;
        }
    }

    public static String getUrl() {
        return pg;
    }

    public static void setUrl(String str) {
        pg = str;
    }

    public static String cY() {
        return ph;
    }

    public static void D(String str) {
        ph = str;
    }

    public static ArrayList<BasicNameValuePair> cZ() {
        return pl;
    }

    public static void c(ArrayList<BasicNameValuePair> arrayList) {
        pl = arrayList;
    }
}
