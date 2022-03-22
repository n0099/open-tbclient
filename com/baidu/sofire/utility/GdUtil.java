package com.baidu.sofire.utility;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.ContentUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary4util.BaseNCodec;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GdUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AES_KEY;
    public static final String AES_KEY_PART_ONE;
    public static final String AES_KEY_PART_TWO;
    public static final String EXT_DIR = "_99uIeWLLYgYWnfdVm4xmTNMy58crLVzIq1_1xd6OaXaqNsyUOaKaQPHeL9hMa2J";
    public static final String EXT_FILE = "u2fjUEpcZJL7IE6RlBqIRmFJW_FjZrNApjdMKDgt7FM=";
    public static final String EXT_FILE_V2 = "idzo8hWEQF2c4tBTa5WOlQMU8UU8Wq-86X4X9ljayiU=";
    public static final String KEY_BAIDU = "q6R8gqLUgHDSsH6dbL27xN7Qr9sa0MxMqXTV66AWUUE=";
    public static final String KEY_DEVICE_ID = "FLI7RPHK558lhmIMdK5V18TV2libLOeHJlQPRa8lKBaxRs4pujQo1mXKtiCUFVkg";
    public static final String KEY_DEVICE_ID_V2 = "FLI7RPHK558lhmIMdK5V1-nh-gfSlVAFvUdffcjh8sgAXO2nb2l_YXWA6lX6geWt";
    public static final String KEY_IMEI = "ARQJ8IArCy4jLSUJ6i4PbDdNue2ww1CwfUTDQn8F4ug=";
    public static final String KEY_LIB = "K5j7Snuat7HHCaEg62XaRa41Ukv_4vtSH9Z4FqXi1Fs=";
    public static final String OLD_EXT_DIR = "u_lhldj5Nkwulw6YvIU2wr_ieZRcYQnQZ7zSlbUYnYY=";
    public static CUIDInfo sCachedCuidInfo;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    /* renamed from: com.baidu.sofire.utility.GdUtil$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class AESUtil {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String ALGORITHM_NAME = "AES";
        public static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
        public transient /* synthetic */ FieldHolder $fh;

        public AESUtil() {
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

        public static byte[] decrypt(String str, String str2, byte[] bArr) throws Exception {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, str2, bArr)) == null) {
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
                return cipher.doFinal(bArr);
            }
            return (byte[]) invokeLLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class Base64 {
        public static /* synthetic */ Interceptable $ic;
        public static final byte[] MAP;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1042768263, "Lcom/baidu/sofire/utility/GdUtil$Base64;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1042768263, "Lcom/baidu/sofire/utility/GdUtil$Base64;");
                    return;
                }
            }
            MAP = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, Cea608Decoder.CTRL_END_OF_CAPTION};
        }

        public Base64() {
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

        public static byte[] decode(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) ? decode(bArr, bArr.length) : (byte[]) invokeL.objValue;
        }

        public static byte[] decode(byte[] bArr, int i) {
            InterceptResult invokeLI;
            byte b2;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, bArr, i)) == null) {
                int i3 = (i / 4) * 3;
                if (i3 == 0) {
                    return new byte[0];
                }
                byte[] bArr2 = new byte[i3];
                int i4 = i;
                int i5 = 0;
                while (true) {
                    byte b3 = bArr[i4 - 1];
                    b2 = 10;
                    if (b3 != 10 && b3 != 13 && b3 != 32 && b3 != 9) {
                        if (b3 != 61) {
                            break;
                        }
                        i5++;
                    }
                    i4--;
                }
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                int i9 = 0;
                while (i6 < i4) {
                    byte b4 = bArr[i6];
                    if (b4 != b2 && b4 != 13 && b4 != 32 && b4 != 9) {
                        if (b4 >= 65 && b4 <= 90) {
                            i2 = b4 - 65;
                        } else if (b4 >= 97 && b4 <= 122) {
                            i2 = b4 - 71;
                        } else if (b4 >= 48 && b4 <= 57) {
                            i2 = b4 + 4;
                        } else if (b4 == 43) {
                            i2 = 62;
                        } else if (b4 != 47) {
                            return null;
                        } else {
                            i2 = 63;
                        }
                        i7 = ((byte) i2) | (i7 << 6);
                        if (i9 % 4 == 3) {
                            int i10 = i8 + 1;
                            bArr2[i8] = (byte) ((16711680 & i7) >> 16);
                            int i11 = i10 + 1;
                            bArr2[i10] = (byte) ((65280 & i7) >> 8);
                            bArr2[i11] = (byte) (i7 & 255);
                            i8 = i11 + 1;
                        }
                        i9++;
                    }
                    i6++;
                    b2 = 10;
                }
                if (i5 > 0) {
                    int i12 = i7 << (i5 * 6);
                    int i13 = i8 + 1;
                    bArr2[i8] = (byte) ((i12 & 16711680) >> 16);
                    if (i5 == 1) {
                        i8 = i13 + 1;
                        bArr2[i13] = (byte) ((i12 & 65280) >> 8);
                    } else {
                        i8 = i13;
                    }
                }
                byte[] bArr3 = new byte[i8];
                System.arraycopy(bArr2, 0, bArr3, 0, i8);
                return bArr3;
            }
            return (byte[]) invokeLI.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class CUIDInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String deviceId;
        public String imei;

        public CUIDInfo() {
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

        public static CUIDInfo createFromJson(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String string = jSONObject.getString("deviceid");
                    String string2 = jSONObject.getString("imei");
                    if (!TextUtils.isEmpty(string) && string2 != null) {
                        CUIDInfo cUIDInfo = new CUIDInfo();
                        cUIDInfo.deviceId = string;
                        cUIDInfo.imei = string2;
                        return cUIDInfo;
                    }
                    return null;
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                    return null;
                }
            }
            return (CUIDInfo) invokeL.objValue;
        }

        public String getFinalCUID() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    String str = this.imei;
                    if (TextUtils.isEmpty(str)) {
                        str = "0";
                    }
                    String stringBuffer = new StringBuffer(str).reverse().toString();
                    return this.deviceId + "|" + stringBuffer;
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                    return null;
                }
            }
            return (String) invokeV.objValue;
        }

        public /* synthetic */ CUIDInfo(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public static class MD5Util {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public MD5Util() {
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

        public static String toHexString(byte[] bArr, String str, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65537, null, bArr, str, z)) == null) {
                StringBuilder sb = new StringBuilder();
                for (byte b2 : bArr) {
                    String hexString = Integer.toHexString(b2 & 255);
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
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, bArr, z)) == null) {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.reset();
                    messageDigest.update(bArr);
                    return toHexString(messageDigest.digest(), "", z);
                } catch (NoSuchAlgorithmException e2) {
                    throw new RuntimeException(e2);
                }
            }
            return (String) invokeLZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(545637098, "Lcom/baidu/sofire/utility/GdUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(545637098, "Lcom/baidu/sofire/utility/GdUtil;");
                return;
            }
        }
        AES_KEY_PART_ONE = new String(Base64.decode(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 73, BaseNCodec.PAD_DEFAULT}));
        AES_KEY_PART_TWO = new String(Base64.decode(new byte[]{90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, BaseNCodec.PAD_DEFAULT}));
        AES_KEY = AES_KEY_PART_ONE + AES_KEY_PART_TWO;
    }

    public GdUtil(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
    }

    private boolean checkSelfPermission(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) ? this.mContext.checkPermission(str, Process.myPid(), Process.myUid()) == 0 : invokeL.booleanValue;
    }

    public static String decryptCUIDInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return new String(AESUtil.decrypt(AES_KEY, AES_KEY, Base64.decode(str.getBytes())));
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    private CUIDInfo getCUidInfoFromSystemSettingV1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            try {
                String systemSettingValue = getSystemSettingValue(CommonMethods.decodeString("FLI7RPHK558lhmIMdK5V18TV2libLOeHJlQPRa8lKBaxRs4pujQo1mXKtiCUFVkg"));
                String systemSettingValue2 = getSystemSettingValue(CommonMethods.decodeString("ARQJ8IArCy4jLSUJ6i4PbDdNue2ww1CwfUTDQn8F4ug="));
                if (TextUtils.isEmpty(systemSettingValue2)) {
                    systemSettingValue2 = getIMEIFromSystem("");
                }
                if (TextUtils.isEmpty(systemSettingValue)) {
                    String androidId = PrivacyOperationUtil.getAndroidId(this.mContext);
                    systemSettingValue = getSystemSettingValue(MD5Util.toMd5((CommonMethods.decodeString("q6R8gqLUgHDSsH6dbL27xN7Qr9sa0MxMqXTV66AWUUE=") + systemSettingValue2 + androidId).getBytes(), true));
                }
                if (!TextUtils.isEmpty(systemSettingValue)) {
                    CUIDInfo cUIDInfo = new CUIDInfo(null);
                    cUIDInfo.deviceId = systemSettingValue;
                    cUIDInfo.imei = systemSettingValue2;
                    return cUIDInfo;
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            return null;
        }
        return (CUIDInfo) invokeV.objValue;
    }

    public static String getCuid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                CUIDInfo cuidInfo = getCuidInfo(context);
                return cuidInfo != null ? cuidInfo.getFinalCUID() : "";
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static synchronized CUIDInfo getCuidInfo(Context context) {
        InterceptResult invokeL;
        CUIDInfo cUIDInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            synchronized (GdUtil.class) {
                if (sCachedCuidInfo == null) {
                    sCachedCuidInfo = new GdUtil(context).getCuidInfoImpl();
                }
                cUIDInfo = sCachedCuidInfo;
            }
            return cUIDInfo;
        }
        return (CUIDInfo) invokeL.objValue;
    }

    private CUIDInfo getCuidInfoFromExternalV2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            try {
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            if (PrivacyOperationUtil.allowReadSdCard(this.mContext)) {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                File file = new File(externalStorageDirectory, CommonMethods.decodeString(EXT_DIR) + "/" + CommonMethods.decodeString(EXT_FILE_V2));
                if (file.exists()) {
                    String fileContent = getFileContent(file);
                    if (!TextUtils.isEmpty(fileContent)) {
                        return CUIDInfo.createFromJson(new String(AESUtil.decrypt(AES_KEY, AES_KEY, Base64.decode(fileContent.getBytes()))));
                    }
                }
                return null;
            }
            return null;
        }
        return (CUIDInfo) invokeV.objValue;
    }

    private CUIDInfo getCuidInfoImpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            try {
                File file = new File(this.mContext.getFilesDir(), CommonMethods.decodeString(KEY_LIB));
                CUIDInfo createFromJson = file.exists() ? CUIDInfo.createFromJson(decryptCUIDInfo(getFileContent(file))) : null;
                if (createFromJson != null) {
                    return createFromJson;
                }
                CUIDInfo createFromJson2 = CUIDInfo.createFromJson(decryptCUIDInfo(getSystemSettingValue(CommonMethods.decodeString(KEY_DEVICE_ID_V2))));
                if (createFromJson2 != null) {
                    return createFromJson2;
                }
                boolean checkSelfPermission = checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE");
                if (checkSelfPermission) {
                    createFromJson2 = getCuidInfoFromExternalV2();
                }
                if (createFromJson2 != null) {
                    return createFromJson2;
                }
                CUIDInfo cUidInfoFromSystemSettingV1 = getCUidInfoFromSystemSettingV1();
                return (cUidInfoFromSystemSettingV1 == null && checkSelfPermission) ? getExternalV1DeviceId(getIMEIFromSystem("")) : cUidInfoFromSystemSettingV1;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return null;
            }
        }
        return (CUIDInfo) invokeV.objValue;
    }

    private CUIDInfo getExternalV1DeviceId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, str)) == null) {
            boolean z = Build.VERSION.SDK_INT < 23;
            if (!(z && TextUtils.isEmpty(str)) && PrivacyOperationUtil.allowReadSdCard(this.mContext)) {
                String str2 = "";
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                File file = new File(externalStorageDirectory, CommonMethods.decodeString("u_lhldj5Nkwulw6YvIU2wr_ieZRcYQnQZ7zSlbUYnYY=") + "/" + CommonMethods.decodeString("u2fjUEpcZJL7IE6RlBqIRmFJW_FjZrNApjdMKDgt7FM="));
                if (!file.exists()) {
                    File externalStorageDirectory2 = Environment.getExternalStorageDirectory();
                    file = new File(externalStorageDirectory2, CommonMethods.decodeString(EXT_DIR) + "/" + CommonMethods.decodeString("u2fjUEpcZJL7IE6RlBqIRmFJW_FjZrNApjdMKDgt7FM="));
                }
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
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
                    String[] split = new String(AESUtil.decrypt(AES_KEY, AES_KEY, Base64.decode(sb.toString().getBytes()))).split("=");
                    if (split != null && split.length == 2) {
                        if (z && str.equals(split[0])) {
                            str2 = split[1];
                        } else if (!z) {
                            if (TextUtils.isEmpty(str)) {
                                str = split[1];
                            }
                            str2 = split[1];
                        }
                    }
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                }
                if (TextUtils.isEmpty(str2)) {
                    return null;
                }
                CUIDInfo cUIDInfo = new CUIDInfo(null);
                cUIDInfo.deviceId = str2;
                cUIDInfo.imei = str;
                return cUIDInfo;
            }
            return null;
        }
        return (CUIDInfo) invokeL.objValue;
    }

    public static String getFileContent(File file) {
        InterceptResult invokeL;
        FileReader fileReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65546, null, file)) != null) {
            return (String) invokeL.objValue;
        }
        try {
            fileReader = new FileReader(file);
            try {
                char[] cArr = new char[8192];
                CharArrayWriter charArrayWriter = new CharArrayWriter();
                while (true) {
                    int read = fileReader.read(cArr);
                    if (read <= 0) {
                        break;
                    }
                    charArrayWriter.write(cArr, 0, read);
                }
                String charArrayWriter2 = charArrayWriter.toString();
                try {
                    fileReader.close();
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                }
                return charArrayWriter2;
            } catch (Throwable th2) {
                th = th2;
                try {
                    CommonMethods.handleNuLException(th);
                    return null;
                } finally {
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable th3) {
                            CommonMethods.handleNuLException(th3);
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            fileReader = null;
        }
    }

    private String getIMEIFromSystem(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, str)) == null) {
            String imeiCheck = imeiCheck("0");
            return TextUtils.isEmpty(imeiCheck) ? str : imeiCheck;
        }
        return (String) invokeL.objValue;
    }

    private String getSystemSettingValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, str)) == null) {
            try {
                return PrivacyOperationUtil.allowReadSettings(this.mContext) ? Settings.System.getString(this.mContext.getContentResolver(), str) : "";
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    private boolean hasReadImeiPermission() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) ? checkSelfPermission("android.permission.READ_PHONE_STATE") : invokeV.booleanValue;
    }

    public static String imeiCheck(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) ? (str == null || !str.contains(":")) ? str : "" : (String) invokeL.objValue;
    }
}
