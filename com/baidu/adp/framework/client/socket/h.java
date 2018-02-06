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
    public static final int ada = BASE_ERROR_NO + SapiErrorCode.NETWORK_FAILED;
    public static final int adb = BASE_ERROR_NO - 201;
    public static final int adc = BASE_ERROR_NO - 210;
    public static final int ade = BASE_ERROR_NO - 211;
    public static final int adf = BASE_ERROR_NO - 212;
    public static final int adg = BASE_ERROR_NO - 213;
    public static final int adh = BASE_ERROR_NO - 214;
    public static final int adi = BASE_ERROR_NO - 220;
    public static final int adj = BASE_ERROR_NO - 221;
    public static final int adk = BASE_ERROR_NO - 230;
    public static final int adl = BASE_ERROR_NO - 231;
    public static final int adm = BASE_ERROR_NO - 232;
    public static final int adn = BASE_ERROR_NO - 233;
    public static final int ado = BASE_ERROR_NO - 234;
    public static final int adp = BASE_ERROR_NO - 235;
    public static final int adq = BASE_ERROR_NO - 236;
    public static final int adr = BASE_ERROR_NO - 301;
    public static final int ads = BASE_ERROR_NO - 302;
    public static final int adt = BASE_ERROR_NO + LivenessRecogResult.ERROR_CODE_FACE_SDK_INIT_FAIL;
    public static final int adu = BASE_ERROR_NO - 304;
    public static final int adv = BASE_ERROR_NO - 305;
    public static final int adw = BASE_ERROR_NO - 306;
    public static final int adx = BASE_ERROR_NO + LivenessRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION;
    public static final int ady = BASE_ERROR_NO + LivenessRecogResult.ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION;
    public static final int adz = BASE_ERROR_NO + LivenessRecogResult.ERROR_CODE_VIDEO_IS_REVIEWING;
    public static final int adA = BASE_ERROR_NO - 310;
    public static final int adB = BASE_ERROR_NO - 311;
    public static final int adC = BASE_ERROR_NO - 312;
    public static final int adD = BASE_ERROR_NO - 313;
    public static final int adE = BASE_ERROR_NO - 314;
    public static final int adF = BASE_ERROR_NO - 310;
    public static final int adG = BASE_ERROR_NO - 311;
    public static final int adH = BASE_ERROR_NO - 400;
    public static final int adI = BASE_ERROR_NO - 501;
    private static String adJ = null;
    private static String adK = null;
    private static String[] adL = null;
    private static int[] adM = com.baidu.adp.framework.c.reconStrategy;
    private static ArrayList<BasicNameValuePair> adN = null;

    public static String cH(int i) {
        int i2 = BASE_ERROR_NO - i;
        Application app = BdBaseApplication.getInst().getApp();
        return (i2 <= -300 || i2 > -200) ? app.getString(R.string.im_error_default) : app.getString(R.string.im_error_codec);
    }

    public static int[] kB() {
        return adM;
    }

    public static void h(int[] iArr) {
        if (iArr != null) {
            adM = iArr;
        }
    }

    public static String getUrl() {
        return adJ;
    }

    public static void setUrl(String str) {
        adJ = str;
    }

    public static String kC() {
        return adK;
    }

    public static void K(String str) {
        adK = str;
    }

    public static ArrayList<BasicNameValuePair> kD() {
        return adN;
    }

    public static void d(ArrayList<BasicNameValuePair> arrayList) {
        adN = arrayList;
    }
}
