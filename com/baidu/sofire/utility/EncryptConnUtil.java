package com.baidu.sofire.utility;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.core.RandomKeyUtil;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class EncryptConnUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public EncryptConnUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String encryptRequestGet(Context context, String str, boolean z, boolean z2) throws Throwable {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? encryptRequestPostOrGet(context, str, "", z, z2, true) : (String) invokeCommon.objValue;
    }

    public static String encryptRequestPost(Context context, String str, String str2, boolean z, boolean z2) throws Throwable {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? encryptRequestPostOrGet(context, str, str2, z, z2, false) : (String) invokeCommon.objValue;
    }

    public static String encryptRequestPostOrGet(Context context, String str, String str2, boolean z, boolean z2, boolean z3) throws Throwable {
        InterceptResult invokeCommon;
        byte[] bytes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            String[] selectAppKeyAndSecurityKey = CommonMethods.selectAppKeyAndSecurityKey(context);
            String str3 = selectAppKeyAndSecurityKey[0];
            String str4 = selectAppKeyAndSecurityKey[1];
            if (CommonMethods.PKGNAME_HUAWEI_INPUT.equals(context.getPackageName()) && !SharedPreferenceManager.getInstance(context).getCanConn()) {
                throw new NetworkErrorException("conn is blocked");
            }
            String valueOf = String.valueOf(new Date().getTime() / 1000);
            String md5 = MD5Util.getMD5(str3 + valueOf + str4);
            byte[] randomKey = RandomKeyUtil.getRandomKey();
            String str5 = "";
            if (!TextUtils.isEmpty(str2)) {
                bytes = F.getInstance().ae(GZipUtil.compress(str2.getBytes()), randomKey);
            } else {
                bytes = "".getBytes();
            }
            byte[] bytes2 = MD5Util.getMD5(DbUtil.getCUID(context)).getBytes();
            String encodeToString = Base64.encodeToString(F.getInstance().re(randomKey, bytes2), 0);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("/100/");
            sb.append(str3);
            sb.append("/");
            sb.append(valueOf);
            sb.append("/");
            sb.append(md5);
            if (!TextUtils.isEmpty(encodeToString)) {
                sb.append("?skey=");
                sb.append(URLEncoder.encode(encodeToString, IMAudioTransRequest.CHARSET));
            }
            try {
                if (z3) {
                    if (OkHttpUtil.useOkHttp(context)) {
                        str5 = new OkHttpUtil(context).requestForGet(sb.toString());
                    } else {
                        str5 = new HttpUtil(context, null).requestForGet(sb.toString());
                    }
                } else if (OkHttpUtil.useOkHttp(context)) {
                    str5 = new OkHttpUtil(context).requestForPost(sb.toString(), bytes);
                } else {
                    str5 = new HttpUtil(context, null).requestForPost(sb.toString(), bytes);
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            if (z && TextUtils.isEmpty(str5)) {
                handlePullCloudConfigFailed(context);
                throw new NetworkErrorException("response is empty");
            } else if (z2) {
                JSONObject jSONObject = new JSONObject(str5);
                byte[] rd = F.getInstance().rd(Base64.decode(jSONObject.optString("skey"), 0), bytes2);
                String optString = jSONObject.optString("response");
                jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
                byte[] decode = Base64.decode(optString, 0);
                byte[] ad = F.getInstance().ad(decode, rd);
                if (decode != null && decode.length > 0 && (ad == null || ad.length == 0)) {
                    CommonMethods.handleAesFailed(context);
                    throw new NetworkErrorException("aes is fail");
                }
                return new String(ad);
            } else {
                return str5;
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static void handlePullCloudConfigFailed(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            try {
                SharedPreferenceManager sharedPreferenceManager = SharedPreferenceManager.getInstance(context);
                if (System.currentTimeMillis() - sharedPreferenceManager.getPullCloudFailedTime() > 86400000) {
                    HashMap hashMap = new HashMap();
                    if (CommonMethods.isWifiAvailable(context)) {
                        hashMap.put("0", Integer.valueOf(sharedPreferenceManager.getPullCloudWifiFailed() + 1));
                        hashMap.put("1", Integer.valueOf(sharedPreferenceManager.getPullCloudMobileFailed()));
                    } else {
                        hashMap.put("0", Integer.valueOf(sharedPreferenceManager.getPullCloudWifiFailed()));
                        hashMap.put("1", Integer.valueOf(sharedPreferenceManager.getPullCloudMobileFailed() + 1));
                    }
                    sharedPreferenceManager.setPullCloudMobileFailed(0);
                    sharedPreferenceManager.setPullCloudWifiFailed(0);
                    sharedPreferenceManager.setPullCloudFailedTime();
                    CommonMethods.sendEventUDC(context, "1003112", hashMap, false);
                } else if (CommonMethods.isWifiAvailable(context)) {
                    sharedPreferenceManager.setPullApkWifiFailed(sharedPreferenceManager.getPullCloudWifiFailed() + 1);
                } else {
                    sharedPreferenceManager.setPullApkMobileFailed(sharedPreferenceManager.getPullCloudMobileFailed() + 1);
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }
}
