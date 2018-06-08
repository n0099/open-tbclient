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
    public static final int tK = BASE_ERROR_NO + SapiErrorCode.NETWORK_FAILED;
    public static final int tL = BASE_ERROR_NO - 201;
    public static final int tM = BASE_ERROR_NO - 210;
    public static final int tN = BASE_ERROR_NO - 211;
    public static final int tO = BASE_ERROR_NO - 212;
    public static final int tP = BASE_ERROR_NO - 213;
    public static final int tQ = BASE_ERROR_NO - 214;
    public static final int tR = BASE_ERROR_NO - 220;
    public static final int tS = BASE_ERROR_NO - 221;
    public static final int tT = BASE_ERROR_NO - 230;
    public static final int tU = BASE_ERROR_NO - 231;
    public static final int tV = BASE_ERROR_NO - 232;
    public static final int tW = BASE_ERROR_NO - 233;
    public static final int tX = BASE_ERROR_NO - 234;
    public static final int tY = BASE_ERROR_NO - 235;
    public static final int tZ = BASE_ERROR_NO - 236;
    public static final int ub = BASE_ERROR_NO - 301;
    public static final int uc = BASE_ERROR_NO - 302;
    public static final int ud = BASE_ERROR_NO + LivenessRecogResult.ERROR_CODE_FACE_SDK_INIT_FAIL;
    public static final int ue = BASE_ERROR_NO - 304;
    public static final int uf = BASE_ERROR_NO - 305;
    public static final int ug = BASE_ERROR_NO - 306;
    public static final int uh = BASE_ERROR_NO + LivenessRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION;
    public static final int ui = BASE_ERROR_NO + LivenessRecogResult.ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION;
    public static final int uj = BASE_ERROR_NO + LivenessRecogResult.ERROR_CODE_VIDEO_IS_REVIEWING;
    public static final int uk = BASE_ERROR_NO - 310;
    public static final int ul = BASE_ERROR_NO - 311;
    public static final int um = BASE_ERROR_NO - 312;
    public static final int uo = BASE_ERROR_NO - 313;
    public static final int uq = BASE_ERROR_NO - 314;
    public static final int ur = BASE_ERROR_NO - 310;
    public static final int us = BASE_ERROR_NO - 311;
    public static final int ut = BASE_ERROR_NO - 400;
    public static final int uu = BASE_ERROR_NO - 501;
    private static String uv = null;
    private static String uw = null;
    private static String[] ux = null;
    private static int[] uy = com.baidu.adp.framework.c.reconStrategy;
    private static ArrayList<BasicNameValuePair> uz = null;

    public static String I(int i) {
        int i2 = BASE_ERROR_NO - i;
        Application app = BdBaseApplication.getInst().getApp();
        return (i2 <= -300 || i2 > -200) ? app.getString(R.string.im_error_default) : app.getString(R.string.im_error_codec);
    }

    public static int[] fu() {
        return uy;
    }

    public static void d(int[] iArr) {
        if (iArr != null) {
            uy = iArr;
        }
    }

    public static String getUrl() {
        return uv;
    }

    public static void setUrl(String str) {
        uv = str;
    }

    public static String fv() {
        return uw;
    }

    public static void T(String str) {
        uw = str;
    }

    public static ArrayList<BasicNameValuePair> fw() {
        return uz;
    }

    public static void c(ArrayList<BasicNameValuePair> arrayList) {
        uz = arrayList;
    }
}
