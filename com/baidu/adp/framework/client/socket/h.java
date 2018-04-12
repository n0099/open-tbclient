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
    public static final int nn = BASE_ERROR_NO + SapiErrorCode.NETWORK_FAILED;
    public static final int np = BASE_ERROR_NO - 201;
    public static final int nq = BASE_ERROR_NO - 210;
    public static final int nr = BASE_ERROR_NO - 211;
    public static final int ns = BASE_ERROR_NO - 212;
    public static final int nt = BASE_ERROR_NO - 213;
    public static final int nu = BASE_ERROR_NO - 214;
    public static final int nv = BASE_ERROR_NO - 220;
    public static final int nw = BASE_ERROR_NO - 221;
    public static final int nx = BASE_ERROR_NO - 230;
    public static final int ny = BASE_ERROR_NO - 231;
    public static final int nz = BASE_ERROR_NO - 232;
    public static final int nA = BASE_ERROR_NO - 233;
    public static final int nB = BASE_ERROR_NO - 234;
    public static final int nC = BASE_ERROR_NO - 235;
    public static final int nD = BASE_ERROR_NO - 236;
    public static final int nE = BASE_ERROR_NO - 301;
    public static final int nF = BASE_ERROR_NO - 302;
    public static final int nG = BASE_ERROR_NO + LivenessRecogResult.ERROR_CODE_FACE_SDK_INIT_FAIL;
    public static final int nH = BASE_ERROR_NO - 304;
    public static final int nI = BASE_ERROR_NO - 305;
    public static final int nJ = BASE_ERROR_NO - 306;
    public static final int nK = BASE_ERROR_NO + LivenessRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION;
    public static final int nL = BASE_ERROR_NO + LivenessRecogResult.ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION;
    public static final int nM = BASE_ERROR_NO + LivenessRecogResult.ERROR_CODE_VIDEO_IS_REVIEWING;
    public static final int nN = BASE_ERROR_NO - 310;
    public static final int nO = BASE_ERROR_NO - 311;
    public static final int nP = BASE_ERROR_NO - 312;
    public static final int nQ = BASE_ERROR_NO - 313;
    public static final int nR = BASE_ERROR_NO - 314;
    public static final int nS = BASE_ERROR_NO - 310;
    public static final int nT = BASE_ERROR_NO - 311;
    public static final int nU = BASE_ERROR_NO - 400;
    public static final int nV = BASE_ERROR_NO - 501;
    private static String nW = null;
    private static String nX = null;
    private static String[] nY = null;
    private static int[] nZ = com.baidu.adp.framework.c.reconStrategy;
    private static ArrayList<BasicNameValuePair> oa = null;

    public static String H(int i) {
        int i2 = BASE_ERROR_NO - i;
        Application app = BdBaseApplication.getInst().getApp();
        return (i2 <= -300 || i2 > -200) ? app.getString(R.string.im_error_default) : app.getString(R.string.im_error_codec);
    }

    public static int[] cF() {
        return nZ;
    }

    public static void c(int[] iArr) {
        if (iArr != null) {
            nZ = iArr;
        }
    }

    public static String getUrl() {
        return nW;
    }

    public static void setUrl(String str) {
        nW = str;
    }

    public static String cG() {
        return nX;
    }

    public static void H(String str) {
        nX = str;
    }

    public static ArrayList<BasicNameValuePair> cH() {
        return oa;
    }

    public static void c(ArrayList<BasicNameValuePair> arrayList) {
        oa = arrayList;
    }
}
