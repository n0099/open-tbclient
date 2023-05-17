package com.baidu.location;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class Jni {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 0;
    public static int b = 1;
    public static int c = 2;
    public static int d = 11;
    public static int e = 12;
    public static int f = 13;
    public static int g = 14;
    public static int h = 15;
    public static int i = 1024;
    public static boolean j;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1037069090, "Lcom/baidu/location/Jni;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1037069090, "Lcom/baidu/location/Jni;");
                return;
            }
        }
        try {
            System.loadLibrary("locSDK8b");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            j = true;
        }
    }

    public Jni() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static native String a(byte[] bArr, int i2);

    public static native String b(double d2, double d3, int i2, int i3);

    public static native String c(byte[] bArr, int i2);

    public static double[] coorEncrypt(double d2, double d3, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3), str})) == null) {
            double[] dArr = {0.0d, 0.0d};
            if (j) {
                return dArr;
            }
            int i2 = -1;
            if (str.equals("bd09")) {
                i2 = a;
            } else if (str.equals("bd09ll")) {
                i2 = b;
            } else if (str.equals("gcj02")) {
                i2 = c;
            } else if (str.equals(BDLocation.BDLOCATION_WGS84_TO_GCJ02)) {
                i2 = d;
            } else if (str.equals(BDLocation.BDLOCATION_BD09_TO_GCJ02)) {
                i2 = e;
            } else if (str.equals(BDLocation.BDLOCATION_BD09LL_TO_GCJ02)) {
                i2 = f;
            } else if (str.equals("wgs842mc")) {
                i2 = h;
            }
            try {
                String[] split = b(d2, d3, str.equals("gcj2wgs") ? 16 : i2, 132456).split(":");
                dArr[0] = Double.parseDouble(split[0]);
                dArr[1] = Double.parseDouble(split[1]);
            } catch (Throwable unused) {
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
            }
            return dArr;
        }
        return (double[]) invokeCommon.objValue;
    }

    public static native String ee(String str, int i2);

    public static String en1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (j) {
                return "err!";
            }
            if (str == null) {
                return StringUtil.NULL_STRING;
            }
            byte[] bytes = str.getBytes();
            byte[] bArr = new byte[i];
            int length = bytes.length;
            if (length > 740) {
                length = 740;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (bytes[i3] != 0) {
                    bArr[i2] = bytes[i3];
                    i2++;
                }
            }
            try {
                return a(bArr, 132456);
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return "err!";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String encode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (j) {
                return "err!";
            }
            return en1(str) + "|tp=3";
        }
        return (String) invokeL.objValue;
    }

    public static String encode2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (j) {
                return "err!";
            }
            if (str == null) {
                return StringUtil.NULL_STRING;
            }
            try {
                return c(str.getBytes(), 132456);
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return "err!";
            }
        }
        return (String) invokeL.objValue;
    }

    public static Long encode3(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (j) {
                return null;
            }
            try {
                str2 = new String(str.getBytes(), "UTF-8");
            } catch (Exception unused) {
                str2 = "";
            }
            try {
                return Long.valueOf(murmur(str2));
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (Long) invokeL.objValue;
    }

    public static native String encodeNotLimit(String str, int i2);

    public static String encodeOfflineLocationUpdateRequest(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            String str3 = "err!";
            if (j) {
                return "err!";
            }
            try {
                str2 = new String(str.getBytes(), "UTF-8");
            } catch (Exception unused) {
                str2 = "";
            }
            try {
                str3 = encodeNotLimit(str2, 132456);
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            }
            return str3 + "|tp=3";
        }
        return (String) invokeL.objValue;
    }

    public static String encodeTp4(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            String str3 = "err!";
            if (j) {
                return "err!";
            }
            try {
                str2 = new String(str.getBytes(), "UTF-8");
            } catch (Exception unused) {
                str2 = "";
            }
            try {
                str3 = ee(str2, 132456);
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            }
            return str3 + "|tp=4";
        }
        return (String) invokeL.objValue;
    }

    public static String encodeTp4NoTag(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            if (j) {
                return "err!";
            }
            try {
                str2 = new String(str.getBytes(), "UTF-8");
            } catch (Exception unused) {
                str2 = "";
            }
            try {
                return ee(str2, 132456);
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return "err!";
            }
        }
        return (String) invokeL.objValue;
    }

    public static native byte[] encrypt(byte[] bArr);

    public static native void f(byte[] bArr, byte[] bArr2);

    public static native String g(byte[] bArr);

    public static double getGpsSwiftRadius(float f2, double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{Float.valueOf(f2), Double.valueOf(d2), Double.valueOf(d3)})) == null) {
            if (j) {
                return 0.0d;
            }
            try {
                return gsr(f2, d2, d3);
            } catch (UnsatisfiedLinkError unused) {
                return 0.0d;
            }
        }
        return invokeCommon.doubleValue;
    }

    public static String getldkaiv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            if (j) {
                return null;
            }
            try {
                return ldkaiv();
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static native double gsr(float f2, double d2, double d3);

    public static native String ldkaiv();

    public static native long murmur(String str);
}
