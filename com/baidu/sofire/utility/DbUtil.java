package com.baidu.sofire.utility;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sofire.MyProvider;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.sofire.utility.GdUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
/* loaded from: classes2.dex */
public final class DbUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AES_KEY = "30212102dicudiab";
    public static final String EXT_FILE = "u2fjUEpcZJL7IE6RlBqIRmFJW_FjZrNApjdMKDgt7FM=";
    public static final String KEY_BAIDU = "q6R8gqLUgHDSsH6dbL27xN7Qr9sa0MxMqXTV66AWUUE=";
    public static final String KEY_DEVICE_ID = "FLI7RPHK558lhmIMdK5V18TV2libLOeHJlQPRa8lKBaxRs4pujQo1mXKtiCUFVkg";
    public static final String KEY_IMEI = "ARQJ8IArCy4jLSUJ6i4PbDdNue2ww1CwfUTDQn8F4ug=";
    public static final String OLD_EXT_DIR = "u_lhldj5Nkwulw6YvIU2wr_ieZRcYQnQZ7zSlbUYnYY=";
    public static String sCuid = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2120835049, "Lcom/baidu/sofire/utility/DbUtil;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2120835049, "Lcom/baidu/sofire/utility/DbUtil;");
        }
    }

    public DbUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void checkCUID(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            try {
                SharedPreferenceManager sharedPreferenceManager = SharedPreferenceManager.getInstance(context);
                String encodeCUID = sharedPreferenceManager.getEncodeCUID();
                if (TextUtils.isEmpty(encodeCUID)) {
                    return;
                }
                String decodeString = CommonMethods.decodeString(encodeCUID);
                if (TextUtils.isEmpty(decodeString) || decodeString.equals(sharedPreferenceManager.getCUID())) {
                    return;
                }
                sharedPreferenceManager.setCUID(decodeString);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public static synchronized String getCUID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            synchronized (DbUtil.class) {
                try {
                    if (!TextUtils.isEmpty(sCuid)) {
                        return sCuid;
                    }
                    SharedPreferenceManager sharedPreferenceManager = SharedPreferenceManager.getInstance(context);
                    String encodeCUID = sharedPreferenceManager.getEncodeCUID();
                    if (!TextUtils.isEmpty(encodeCUID)) {
                        String decodeString = CommonMethods.decodeString(encodeCUID);
                        if (!TextUtils.isEmpty(decodeString)) {
                            sCuid = decodeString;
                            return decodeString;
                        }
                    }
                    String cuid = sharedPreferenceManager.getCUID();
                    if (!TextUtils.isEmpty(cuid)) {
                        sharedPreferenceManager.setEncodeCUID(new String(Base64.encode(EncryptUtil.aesEncrypt("30212102dicudiab".getBytes(), cuid.getBytes("UTF-8"), true), 10), "UTF-8"));
                        sCuid = cuid;
                        return cuid;
                    }
                    String str = getDeviceID() + "|0";
                    String str2 = new String(Base64.encode(EncryptUtil.aesEncrypt("30212102dicudiab".getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8");
                    String cuid2 = sharedPreferenceManager.getCUID();
                    if (TextUtils.isEmpty(cuid2)) {
                        sharedPreferenceManager.setCUID(str);
                        sharedPreferenceManager.setEncodeCUID(str2);
                        sCuid = str;
                        return str;
                    }
                    sCuid = cuid2;
                    return cuid2;
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                    return "";
                }
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getDeviceID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? toMd5(UUID.randomUUID().toString().getBytes(), true) : (String) invokeV.objValue;
    }

    public static String getExternalCuid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                try {
                    String string = PrivacyOperationUtil.allowReadSettings(context) ? Settings.System.getString(context.getContentResolver(), CommonMethods.decodeString("ARQJ8IArCy4jLSUJ6i4PbDdNue2ww1CwfUTDQn8F4ug=")) : "";
                    if (TextUtils.isEmpty(string)) {
                        string = PrivacyOperationUtil.getIMEI(context);
                    }
                    String imei = PrivacyOperationUtil.getIMEI(context);
                    if (TextUtils.isEmpty(imei)) {
                        imei = "0";
                    }
                    String stringBuffer = new StringBuffer(imei).reverse().toString();
                    String externalDeviceId = getExternalDeviceId(context, string);
                    if (TextUtils.isEmpty(externalDeviceId)) {
                        return "";
                    }
                    return externalDeviceId + "|" + stringBuffer;
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                    return "";
                }
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getExternalDeviceId(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            if (!TextUtils.isEmpty(str) && PrivacyOperationUtil.allowReadSdCard(context)) {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(externalStorageDirectory, CommonMethods.decodeString("u_lhldj5Nkwulw6YvIU2wr_ieZRcYQnQZ7zSlbUYnYY=") + "/" + CommonMethods.decodeString("u2fjUEpcZJL7IE6RlBqIRmFJW_FjZrNApjdMKDgt7FM="))));
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                        sb.append("\r\n");
                    }
                    bufferedReader.close();
                    Object[] split = new String(GdUtil.AESUtil.decrypt("30212102dicudiab", "30212102dicudiab", Base64.decode(sb.toString().getBytes(), 0))).split("=");
                    return (split != null && split.length == 2 && str.equals(split[0])) ? split[1] : "";
                } catch (Exception e) {
                    CommonMethods.handleNuLException(e);
                    return "";
                }
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static String getPushUID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            try {
                return "1|" + NewUid.getNewUid(context);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String loadReaderAsString(Reader reader) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, reader)) == null) {
            try {
                StringBuilder sb = new StringBuilder();
                char[] cArr = new char[4096];
                int read = reader.read(cArr);
                while (read >= 0) {
                    sb.append(cArr, 0, read);
                    read = reader.read(cArr);
                }
                return sb.toString();
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[Catch: all -> 0x0099, TryCatch #2 {all -> 0x0099, blocks: (B:5:0x0006, B:16:0x002a, B:18:0x003e, B:21:0x006a, B:24:0x0076, B:15:0x0027), top: B:35:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0069 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006a A[Catch: all -> 0x0099, TryCatch #2 {all -> 0x0099, blocks: (B:5:0x0006, B:16:0x002a, B:18:0x003e, B:21:0x006a, B:24:0x0076, B:15:0x0027), top: B:35:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String loadSettingDeviceId(Context context) {
        InterceptResult invokeL;
        String str;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            try {
                String androidId = PrivacyOperationUtil.getAndroidId(context);
                try {
                    str = Settings.System.getString(context.getContentResolver(), CommonMethods.decodeString("ARQJ8IArCy4jLSUJ6i4PbDdNue2ww1CwfUTDQn8F4ug="));
                    try {
                        if (TextUtils.isEmpty(str)) {
                            str = PrivacyOperationUtil.getIMEI(context);
                        }
                    } catch (Throwable th) {
                        th = th;
                        CommonMethods.handleNuLException(th);
                        string = Settings.System.getString(context.getContentResolver(), CommonMethods.decodeString("FLI7RPHK558lhmIMdK5V18TV2libLOeHJlQPRa8lKBaxRs4pujQo1mXKtiCUFVkg"));
                        if (TextUtils.isEmpty(string)) {
                        }
                        if (string != null) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    str = "";
                }
                string = Settings.System.getString(context.getContentResolver(), CommonMethods.decodeString("FLI7RPHK558lhmIMdK5V18TV2libLOeHJlQPRa8lKBaxRs4pujQo1mXKtiCUFVkg"));
                if (TextUtils.isEmpty(string)) {
                    string = Settings.System.getString(context.getContentResolver(), toMd5((CommonMethods.decodeString("q6R8gqLUgHDSsH6dbL27xN7Qr9sa0MxMqXTV66AWUUE=") + str + androidId).getBytes(), true));
                }
                if (string != null) {
                    return "";
                }
                String imei = PrivacyOperationUtil.getIMEI(context);
                if (TextUtils.isEmpty(imei)) {
                    imei = "0";
                }
                String stringBuffer = new StringBuffer(imei).reverse().toString();
                return string + "|" + stringBuffer;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String requestRemoteCuid(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65546, null, context, z)) == null) {
            try {
                Bundle callSharedProvider = ProviderAccessUtil.callSharedProvider(context, MyProvider.CALL_METHOD_ZID, null, z, null, false);
                if (callSharedProvider != null) {
                    String string = callSharedProvider.getString(MyProvider.BUNDLE_KEY_ZID);
                    return !TextUtils.isEmpty(string) ? string : "";
                }
                return "";
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return "";
            }
        }
        return (String) invokeLZ.objValue;
    }

    public static void resetZid(Context context) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, context) == null) {
            try {
                SharedPreferenceManager sharedPreferenceManager = SharedPreferenceManager.getInstance(context);
                String encodeCUID = sharedPreferenceManager.getEncodeCUID();
                if (TextUtils.isEmpty(encodeCUID)) {
                    return;
                }
                String decodeString = CommonMethods.decodeString(encodeCUID);
                if (TextUtils.isEmpty(decodeString) || (split = decodeString.split(WebChromeClient.PARAM_SEPARATOR)) == null || split.length != 2 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1]) || split[1].equals("0")) {
                    return;
                }
                String str = split[0] + "|0";
                sharedPreferenceManager.setEncodeCUID(new String(Base64.encode(EncryptUtil.aesEncrypt("30212102dicudiab".getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8"));
                sharedPreferenceManager.setCUID(str);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public static String subProcessRequestCuid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            if (!TextUtils.isEmpty(sCuid)) {
                return sCuid;
            }
            String requestRemoteCuid = requestRemoteCuid(context, true);
            if (!TextUtils.isEmpty(requestRemoteCuid)) {
                sCuid = requestRemoteCuid;
                return requestRemoteCuid;
            }
            return getCUID(context);
        }
        return (String) invokeL.objValue;
    }

    public static String toHexString(byte[] bArr, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65549, null, bArr, str, z)) == null) {
            StringBuilder sb = new StringBuilder();
            for (byte b : bArr) {
                String hexString = Integer.toHexString(b & 255);
                if (z) {
                    hexString = hexString.toUpperCase();
                }
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString);
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeLLZ.objValue;
    }

    public static String toMd5(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65550, null, bArr, z)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                messageDigest.update(bArr);
                return toHexString(messageDigest.digest(), "", z);
            } catch (NoSuchAlgorithmException e) {
                CommonMethods.handleNuLException(e);
                return null;
            }
        }
        return (String) invokeLZ.objValue;
    }
}
