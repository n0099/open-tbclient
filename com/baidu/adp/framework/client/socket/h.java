package com.baidu.adp.framework.client.socket;

import android.app.Application;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class h {
    private static int BASE_ERROR_NO = -100000000;
    public static final int uu = BASE_ERROR_NO - 200;
    public static final int uv = BASE_ERROR_NO - 201;
    public static final int uw = BASE_ERROR_NO - 210;
    public static final int ux = BASE_ERROR_NO - 211;
    public static final int uy = BASE_ERROR_NO - 212;
    public static final int uz = BASE_ERROR_NO - 213;
    public static final int uA = BASE_ERROR_NO - 214;
    public static final int uB = BASE_ERROR_NO - 220;
    public static final int uC = BASE_ERROR_NO - 221;
    public static final int uD = BASE_ERROR_NO - 230;
    public static final int uE = BASE_ERROR_NO - 231;
    public static final int uF = BASE_ERROR_NO - 232;
    public static final int uG = BASE_ERROR_NO - 233;
    public static final int uH = BASE_ERROR_NO - 234;
    public static final int uI = BASE_ERROR_NO - 235;
    public static final int uJ = BASE_ERROR_NO - 236;
    public static final int uK = BASE_ERROR_NO - 301;
    public static final int uL = BASE_ERROR_NO - 302;
    public static final int uM = BASE_ERROR_NO + PassFaceRecogResult.ERROR_CODE_FACE_SDK_INIT_FAIL;
    public static final int uN = BASE_ERROR_NO + GetTplStokenResult.ERROR_CODE_PARSE_DATA_FAIL;
    public static final int uO = BASE_ERROR_NO - 305;
    public static final int uP = BASE_ERROR_NO - 306;
    public static final int uQ = BASE_ERROR_NO + PassFaceRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION;
    public static final int uR = BASE_ERROR_NO - 308;
    public static final int uS = BASE_ERROR_NO - 309;
    public static final int uT = BASE_ERROR_NO - 310;
    public static final int uU = BASE_ERROR_NO - 311;
    public static final int uV = BASE_ERROR_NO - 312;
    public static final int uW = BASE_ERROR_NO - 313;
    public static final int uX = BASE_ERROR_NO - 314;
    public static final int uY = BASE_ERROR_NO - 310;
    public static final int uZ = BASE_ERROR_NO - 311;
    public static final int va = BASE_ERROR_NO - 400;
    public static final int vb = BASE_ERROR_NO - 501;
    private static String vc = null;
    private static String vd = null;
    private static String[] ve = null;
    private static int[] vf = com.baidu.adp.framework.c.reconStrategy;
    private static ArrayList<BasicNameValuePair> vg = null;

    public static String I(int i) {
        int i2 = BASE_ERROR_NO - i;
        Application app = BdBaseApplication.getInst().getApp();
        return (i2 <= -300 || i2 > -200) ? app.getString(R.string.im_error_default) : app.getString(R.string.im_error_codec);
    }

    public static int[] fR() {
        return vf;
    }

    public static void d(int[] iArr) {
        if (iArr != null) {
            vf = iArr;
        }
    }

    public static String getUrl() {
        return vc;
    }

    public static void setUrl(String str) {
        vc = str;
    }

    public static String fS() {
        return vd;
    }

    public static void T(String str) {
        vd = str;
    }

    public static ArrayList<BasicNameValuePair> fT() {
        return vg;
    }

    public static void d(ArrayList<BasicNameValuePair> arrayList) {
        vg = arrayList;
    }
}
