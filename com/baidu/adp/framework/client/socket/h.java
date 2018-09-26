package com.baidu.adp.framework.client.socket;

import android.app.Application;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.fsg.face.liveness.result.LivenessRecogResult;
import com.baidu.sapi2.shell.SapiErrorCode;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class h {
    private static int BASE_ERROR_NO = -100000000;
    public static final int vW = BASE_ERROR_NO + SapiErrorCode.NETWORK_FAILED;
    public static final int vX = BASE_ERROR_NO - 201;
    public static final int vY = BASE_ERROR_NO - 210;
    public static final int vZ = BASE_ERROR_NO - 211;
    public static final int wa = BASE_ERROR_NO - 212;
    public static final int wb = BASE_ERROR_NO - 213;
    public static final int wc = BASE_ERROR_NO - 214;
    public static final int wd = BASE_ERROR_NO - 220;
    public static final int we = BASE_ERROR_NO - 221;
    public static final int wf = BASE_ERROR_NO - 230;
    public static final int wg = BASE_ERROR_NO - 231;
    public static final int wh = BASE_ERROR_NO - 232;
    public static final int wi = BASE_ERROR_NO - 233;
    public static final int wj = BASE_ERROR_NO - 234;
    public static final int wk = BASE_ERROR_NO - 235;
    public static final int wl = BASE_ERROR_NO - 236;
    public static final int wn = BASE_ERROR_NO - 301;
    public static final int wo = BASE_ERROR_NO - 302;
    public static final int wp = BASE_ERROR_NO + LivenessRecogResult.ERROR_CODE_FACE_SDK_INIT_FAIL;
    public static final int wq = BASE_ERROR_NO - 304;
    public static final int wr = BASE_ERROR_NO - 305;
    public static final int ws = BASE_ERROR_NO - 306;
    public static final int wt = BASE_ERROR_NO + LivenessRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION;
    public static final int wu = BASE_ERROR_NO + LivenessRecogResult.ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION;
    public static final int wv = BASE_ERROR_NO + LivenessRecogResult.ERROR_CODE_VIDEO_IS_REVIEWING;
    public static final int ww = BASE_ERROR_NO - 310;
    public static final int wx = BASE_ERROR_NO - 311;
    public static final int wy = BASE_ERROR_NO - 312;
    public static final int wz = BASE_ERROR_NO - 313;
    public static final int wA = BASE_ERROR_NO - 314;
    public static final int wB = BASE_ERROR_NO - 310;
    public static final int wC = BASE_ERROR_NO - 311;
    public static final int wD = BASE_ERROR_NO - 400;
    public static final int wE = BASE_ERROR_NO - 501;
    private static String wF = null;
    private static String wG = null;
    private static String[] wH = null;
    private static int[] wI = com.baidu.adp.framework.c.reconStrategy;
    private static ArrayList<BasicNameValuePair> wJ = null;

    public static String Q(int i) {
        int i2 = BASE_ERROR_NO - i;
        Application app = BdBaseApplication.getInst().getApp();
        return (i2 <= -300 || i2 > -200) ? app.getString(R.string.im_error_default) : app.getString(R.string.im_error_codec);
    }

    public static int[] gC() {
        return wI;
    }

    public static void d(int[] iArr) {
        if (iArr != null) {
            wI = iArr;
        }
    }

    public static String getUrl() {
        return wF;
    }

    public static void setUrl(String str) {
        wF = str;
    }

    public static String gD() {
        return wG;
    }

    public static void ak(String str) {
        wG = str;
    }

    public static ArrayList<BasicNameValuePair> gE() {
        return wJ;
    }

    public static void c(ArrayList<BasicNameValuePair> arrayList) {
        wJ = arrayList;
    }
}
