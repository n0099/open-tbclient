package com.baidu.adp.framework.client.socket;

import android.app.Application;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.fsg.face.liveness.result.LivenessRecogResult;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class h {
    private static int BASE_ERROR_NO = -100000000;
    public static final int wJ = BASE_ERROR_NO - 200;
    public static final int wK = BASE_ERROR_NO - 201;
    public static final int wL = BASE_ERROR_NO - 210;
    public static final int wM = BASE_ERROR_NO - 211;
    public static final int wN = BASE_ERROR_NO - 212;
    public static final int wO = BASE_ERROR_NO - 213;
    public static final int wP = BASE_ERROR_NO - 214;
    public static final int wQ = BASE_ERROR_NO - 220;
    public static final int wR = BASE_ERROR_NO - 221;
    public static final int wS = BASE_ERROR_NO - 230;
    public static final int wT = BASE_ERROR_NO - 231;
    public static final int wU = BASE_ERROR_NO - 232;
    public static final int wV = BASE_ERROR_NO - 233;
    public static final int wW = BASE_ERROR_NO - 234;
    public static final int wX = BASE_ERROR_NO - 235;
    public static final int wY = BASE_ERROR_NO - 236;
    public static final int wZ = BASE_ERROR_NO - 301;
    public static final int xa = BASE_ERROR_NO - 302;
    public static final int xb = BASE_ERROR_NO + LivenessRecogResult.ERROR_CODE_FACE_SDK_INIT_FAIL;
    public static final int xc = BASE_ERROR_NO - 304;
    public static final int xd = BASE_ERROR_NO - 305;
    public static final int xe = BASE_ERROR_NO - 306;
    public static final int xf = BASE_ERROR_NO + LivenessRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION;
    public static final int xg = BASE_ERROR_NO + LivenessRecogResult.ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION;
    public static final int xh = BASE_ERROR_NO + LivenessRecogResult.ERROR_CODE_VIDEO_IS_REVIEWING;
    public static final int xi = BASE_ERROR_NO - 310;
    public static final int xj = BASE_ERROR_NO - 311;
    public static final int xk = BASE_ERROR_NO - 312;
    public static final int xl = BASE_ERROR_NO - 313;
    public static final int xm = BASE_ERROR_NO - 314;
    public static final int xn = BASE_ERROR_NO - 310;
    public static final int xo = BASE_ERROR_NO - 311;
    public static final int xp = BASE_ERROR_NO - 400;
    public static final int xq = BASE_ERROR_NO - 501;
    private static String xr = null;
    private static String xs = null;
    private static String[] xt = null;
    private static int[] xu = com.baidu.adp.framework.c.reconStrategy;
    private static ArrayList<BasicNameValuePair> xv = null;

    public static String Q(int i) {
        int i2 = BASE_ERROR_NO - i;
        Application app = BdBaseApplication.getInst().getApp();
        return (i2 <= -300 || i2 > -200) ? app.getString(R.string.im_error_default) : app.getString(R.string.im_error_codec);
    }

    public static int[] gU() {
        return xu;
    }

    public static void d(int[] iArr) {
        if (iArr != null) {
            xu = iArr;
        }
    }

    public static String getUrl() {
        return xr;
    }

    public static void setUrl(String str) {
        xr = str;
    }

    public static String gV() {
        return xs;
    }

    public static void ak(String str) {
        xs = str;
    }

    public static ArrayList<BasicNameValuePair> gW() {
        return xv;
    }

    public static void c(ArrayList<BasicNameValuePair> arrayList) {
        xv = arrayList;
    }
}
