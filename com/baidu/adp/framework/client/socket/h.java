package com.baidu.adp.framework.client.socket;

import android.app.Application;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.sapi2.biometrics.liveness.result.LivenessRecogResult;
import com.baidu.sapi2.shell.SapiErrorCode;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class h {
    private static int BASE_ERROR_NO = -100000000;
    public static final int tA = BASE_ERROR_NO + SapiErrorCode.NETWORK_FAILED;
    public static final int tB = BASE_ERROR_NO - 201;
    public static final int tC = BASE_ERROR_NO - 210;
    public static final int tD = BASE_ERROR_NO - 211;
    public static final int tE = BASE_ERROR_NO - 212;
    public static final int tF = BASE_ERROR_NO - 213;
    public static final int tG = BASE_ERROR_NO - 214;
    public static final int tH = BASE_ERROR_NO - 220;
    public static final int tI = BASE_ERROR_NO - 221;
    public static final int tJ = BASE_ERROR_NO - 230;
    public static final int tK = BASE_ERROR_NO - 231;
    public static final int tL = BASE_ERROR_NO - 232;
    public static final int tM = BASE_ERROR_NO - 233;
    public static final int tN = BASE_ERROR_NO - 234;
    public static final int tO = BASE_ERROR_NO - 235;
    public static final int tP = BASE_ERROR_NO - 236;
    public static final int tQ = BASE_ERROR_NO - 301;
    public static final int tR = BASE_ERROR_NO - 302;
    public static final int tS = BASE_ERROR_NO + LivenessRecogResult.ERROR_CODE_FACE_SDK_INIT_FAIL;
    public static final int tT = BASE_ERROR_NO - 304;
    public static final int tU = BASE_ERROR_NO - 305;
    public static final int tV = BASE_ERROR_NO - 306;
    public static final int tW = BASE_ERROR_NO + LivenessRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION;
    public static final int tX = BASE_ERROR_NO + LivenessRecogResult.ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION;
    public static final int tY = BASE_ERROR_NO + LivenessRecogResult.ERROR_CODE_VIDEO_IS_REVIEWING;
    public static final int tZ = BASE_ERROR_NO - 310;
    public static final int ub = BASE_ERROR_NO - 311;
    public static final int uc = BASE_ERROR_NO - 312;
    public static final int ud = BASE_ERROR_NO - 313;
    public static final int ue = BASE_ERROR_NO - 314;
    public static final int uf = BASE_ERROR_NO - 310;
    public static final int ug = BASE_ERROR_NO - 311;
    public static final int uh = BASE_ERROR_NO - 400;
    public static final int ui = BASE_ERROR_NO - 501;
    private static String uj = null;
    private static String uk = null;
    private static String[] ul = null;
    private static int[] um = com.baidu.adp.framework.c.reconStrategy;
    private static ArrayList<BasicNameValuePair> uo = null;

    public static String I(int i) {
        int i2 = BASE_ERROR_NO - i;
        Application app = BdBaseApplication.getInst().getApp();
        return (i2 <= -300 || i2 > -200) ? app.getString(R.string.im_error_default) : app.getString(R.string.im_error_codec);
    }

    public static int[] ft() {
        return um;
    }

    public static void d(int[] iArr) {
        if (iArr != null) {
            um = iArr;
        }
    }

    public static String getUrl() {
        return uj;
    }

    public static void setUrl(String str) {
        uj = str;
    }

    public static String fu() {
        return uk;
    }

    public static void T(String str) {
        uk = str;
    }

    public static ArrayList<BasicNameValuePair> fv() {
        return uo;
    }

    public static void c(ArrayList<BasicNameValuePair> arrayList) {
        uo = arrayList;
    }
}
