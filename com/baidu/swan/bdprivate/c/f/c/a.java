package com.baidu.swan.bdprivate.c.f.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.location.BDLocation;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.impl.nalib.encrypt.EncryptConstant;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.a;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;

    public static boolean di(@NonNull Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static int dj(Context context) {
        TelephonyManager telephonyManager;
        String simOperator;
        if (context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null && (simOperator = telephonyManager.getSimOperator()) != null) {
            if ("46000".equals(simOperator) || "46002".equals(simOperator) || "46007".equals(simOperator)) {
                return 1;
            }
            if ("46001".equals(simOperator)) {
                return 3;
            }
            return "46003".equals(simOperator) ? 2 : 0;
        }
        return 0;
    }

    public static int afQ() {
        String networkClass = SwanAppNetworkUtils.getNetworkClass();
        if ("wifi".equals(networkClass)) {
            return 1;
        }
        if ("2g".equals(networkClass)) {
            return 2;
        }
        if ("3g".equals(networkClass)) {
            return 3;
        }
        if ("4g".equals(networkClass)) {
            return 4;
        }
        return 0;
    }

    @Nullable
    public static String mS(String str) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, new SecretKeySpec((EncryptConstant.getPartRecommendAesKey() + "rtad@mic").getBytes(), "AES"), new IvParameterSpec((EncryptConstant.getPartRecommendAesIv() + "21248000").getBytes()));
            return Base64.encodeToString(cipher.doFinal(str.getBytes("utf-8")), 2);
        } catch (Exception e) {
            e.printStackTrace();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("info", "encrypt request param fail with exception : " + e.getMessage());
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            mT(jSONObject.toString());
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(com.baidu.swan.bdprivate.c.f.b.a aVar, com.baidu.swan.bdprivate.c.f.b.b bVar) {
        boolean z;
        int i;
        if (aVar != null && bVar != null) {
            String str = TextUtils.isEmpty(bVar.bZf) ? "unknown" : bVar.bZf;
            switch (str.hashCode()) {
                case -1395470197:
                    if (str.equals("bd09ll")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 3017163:
                    if (str.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09)) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 98175376:
                    if (str.equals("gcj02")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 113079775:
                    if (str.equals(CoordinateType.WGS84)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            switch (z) {
                case false:
                    i = 0;
                    break;
                case true:
                    i = 1;
                    break;
                case true:
                    i = 2;
                    break;
                case true:
                    i = 3;
                    break;
                default:
                    i = -1;
                    break;
            }
            aVar.bYV.coordType = i;
            aVar.bYV.latitude = bVar.latitude;
            aVar.bYV.longitude = bVar.longitude;
        }
    }

    public static void mT(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.d("recommend", "reportInfoWhenResponseIsNull: " + str);
            }
            new a.C0285a(10003).ln(str).lm(e.ZU()).Tz();
        }
    }
}
