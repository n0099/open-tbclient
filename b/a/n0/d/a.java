package b.a.n0.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.baidu.webkit.internal.utils.UtilsBlink;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.ByteCompanionObject;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final String f3523c;

    /* renamed from: d  reason: collision with root package name */
    public static int f3524d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f3525a;

    /* renamed from: b  reason: collision with root package name */
    public PublicKey f3526b;

    /* renamed from: b.a.n0.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0098a implements Comparator<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0098a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, dVar, dVar2)) == null) {
                int i2 = dVar2.f3529c - dVar.f3529c;
                if (i2 != 0) {
                    return i2;
                }
                if (dVar.f3528b && dVar2.f3528b) {
                    return 0;
                }
                if (dVar.f3528b) {
                    return -1;
                }
                if (dVar2.f3528b) {
                    return 1;
                }
                return i2;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static byte[] a(String str, String str2, byte[] bArr) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, str, str2, bArr)) == null) {
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
                return cipher.doFinal(bArr);
            }
            return (byte[]) invokeLLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1660040148, "Lb/a/n0/d/a$c;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1660040148, "Lb/a/n0/d/a$c;");
            }
        }

        public static byte[] a(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) ? b(bArr, bArr.length) : (byte[]) invokeL.objValue;
        }

        public static byte[] b(byte[] bArr, int i2) {
            InterceptResult invokeLI;
            byte b2;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, bArr, i2)) == null) {
                int i4 = (i2 / 4) * 3;
                if (i4 == 0) {
                    return new byte[0];
                }
                byte[] bArr2 = new byte[i4];
                int i5 = i2;
                int i6 = 0;
                while (true) {
                    byte b3 = bArr[i5 - 1];
                    b2 = 10;
                    if (b3 != 10 && b3 != 13 && b3 != 32 && b3 != 9) {
                        if (b3 != 61) {
                            break;
                        }
                        i6++;
                    }
                    i5--;
                }
                int i7 = 0;
                int i8 = 0;
                int i9 = 0;
                int i10 = 0;
                while (i7 < i5) {
                    byte b4 = bArr[i7];
                    if (b4 != b2 && b4 != 13 && b4 != 32 && b4 != 9) {
                        if (b4 >= 65 && b4 <= 90) {
                            i3 = b4 - 65;
                        } else if (b4 >= 97 && b4 <= 122) {
                            i3 = b4 - 71;
                        } else if (b4 >= 48 && b4 <= 57) {
                            i3 = b4 + 4;
                        } else if (b4 == 43) {
                            i3 = 62;
                        } else if (b4 != 47) {
                            return null;
                        } else {
                            i3 = 63;
                        }
                        i9 = ((byte) i3) | (i9 << 6);
                        if (i10 % 4 == 3) {
                            int i11 = i8 + 1;
                            bArr2[i8] = (byte) ((16711680 & i9) >> 16);
                            int i12 = i11 + 1;
                            bArr2[i11] = (byte) ((65280 & i9) >> 8);
                            bArr2[i12] = (byte) (i9 & 255);
                            i8 = i12 + 1;
                        }
                        i10++;
                    }
                    i7++;
                    b2 = 10;
                }
                if (i6 > 0) {
                    int i13 = i9 << (i6 * 6);
                    int i14 = i8 + 1;
                    bArr2[i8] = (byte) ((i13 & 16711680) >> 16);
                    if (i6 == 1) {
                        i8 = i14 + 1;
                        bArr2[i14] = (byte) ((i13 & 65280) >> 8);
                    } else {
                        i8 = i14;
                    }
                }
                byte[] bArr3 = new byte[i8];
                System.arraycopy(bArr2, 0, bArr3, 0, i8);
                return bArr3;
            }
            return (byte[]) invokeLI.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ApplicationInfo f3527a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f3528b;

        /* renamed from: c  reason: collision with root package name */
        public int f3529c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f3530d;

        public /* synthetic */ d(C0098a c0098a) {
            this();
        }

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3529c = 0;
            this.f3530d = false;
            this.f3528b = false;
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f3531a;

        /* renamed from: b  reason: collision with root package name */
        public String f3532b;

        /* renamed from: c  reason: collision with root package name */
        public int f3533c;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3533c = 0;
        }

        public static e a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    Iterator<String> keys = jSONObject.keys();
                    String str2 = "0";
                    String str3 = "0";
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!a.r("ZGV2aWNlaWQ=").equals(next) && !a.r("dmVy").equals(next)) {
                            str3 = jSONObject.optString(next, "0");
                        }
                    }
                    String string = jSONObject.getString(a.r("ZGV2aWNlaWQ="));
                    jSONObject.getInt(a.r("dmVy"));
                    int length = TextUtils.isEmpty(str3) ? 0 : str3.length();
                    if (!TextUtils.isEmpty(string)) {
                        e eVar = new e();
                        eVar.f3531a = string;
                        eVar.f3533c = length;
                        if (length >= 14) {
                            return eVar;
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            str2 = str3;
                        }
                        eVar.f3532b = str2;
                        return eVar;
                    }
                } catch (Exception e2) {
                    b.a.n0.l.c.d(e2);
                }
                return null;
            }
            return (e) invokeL.objValue;
        }

        public static boolean d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? i2 >= 14 : invokeI.booleanValue;
        }

        public static e e(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                e eVar = new e();
                eVar.f3531a = str;
                int length = TextUtils.isEmpty(str2) ? 0 : str2.length();
                eVar.f3533c = length;
                if (length >= 14) {
                    return eVar;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = "0";
                }
                eVar.f3532b = str2;
                return eVar;
            }
            return (e) invokeLL.objValue;
        }

        public static boolean g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? TextUtils.isEmpty(str) : invokeL.booleanValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String str = this.f3532b;
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                return this.f3531a + "|" + str;
            }
            return (String) invokeV.objValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d(this.f3533c) : invokeV.booleanValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? g(this.f3532b) : invokeV.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static byte[] a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? new byte[]{48, -126, 3, 99, 48, -126, 2, 75, -96, 3, 2, 1, 2, 2, 4, 106, -93, 120, 122, 48, 13, 6, 9, ExifInterface.START_CODE, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 48, 97, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 99, 110, 49, 16, 48, 14, 6, 3, 85, 4, 8, 19, 7, 98, Constants.SHORT_PING_CMD_TYPE, 105, 106, 105, 110, 103, 49, 16, 48, 14, 6, 3, 85, 4, 7, 19, 7, 104, 97, 105, 100, 105, 97, 110, 49, 14, 48, StandardMessageCodec.LIST, 6, 3, 85, 4, 10, 19, 5, 98, 97, 105, 100, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 49, 14, 48, StandardMessageCodec.LIST, 6, 3, 85, 4, 11, 19, 5, 98, 97, 105, 100, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 49, 14, 48, StandardMessageCodec.LIST, 6, 3, 85, 4, 3, 19, 5, 98, 97, 105, 100, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 48, 32, 23, 13, 49, 53, 49, 48, 50, 49, 48, 52, 51, 54, 51, 55, 90, 24, 15, 50, 48, 55, 48, 48, 55, 50, 52, 48, 52, 51, 54, 51, 55, 90, 48, 97, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 99, 110, 49, 16, 48, 14, 6, 3, 85, 4, 8, 19, 7, 98, Constants.SHORT_PING_CMD_TYPE, 105, 106, 105, 110, 103, 49, 16, 48, 14, 6, 3, 85, 4, 7, 19, 7, 104, 97, 105, 100, 105, 97, 110, 49, 14, 48, StandardMessageCodec.LIST, 6, 3, 85, 4, 10, 19, 5, 98, 97, 105, 100, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 49, 14, 48, StandardMessageCodec.LIST, 6, 3, 85, 4, 11, 19, 5, 98, 97, 105, 100, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 49, 14, 48, StandardMessageCodec.LIST, 6, 3, 85, 4, 3, 19, 5, 98, 97, 105, 100, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 48, -126, 1, 34, 48, 13, 6, 9, ExifInterface.START_CODE, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -126, 1, 15, 0, 48, -126, 1, 10, 2, -126, 1, 1, 0, -86, -91, -2, -41, ByteCompanionObject.MAX_VALUE, 37, -25, -33, 93, 51, -73, 32, -81, 61, 108, 37, 126, 14, -125, 125, ExifInterface.MARKER_SOF9, -29, 34, -60, 84, -67, -46, 125, -93, -67, -27, 97, 54, Base64.INTERNAL_PADDING, 0, -6, 83, 67, -116, 43, -24, 26, 88, -5, PublicSuffixDatabase.EXCEPTION_MARKER, 27, -105, 49, 76, -70, -32, 105, -48, 67, 69, 102, -111, -81, 93, -103, -18, 17, 55, 81, -34, -80, -76, -13, -84, 6, 91, 10, 48, -56, -1, UtilsBlink.VER_TYPE_SEPARATOR, 9, 23, 34, 6, 103, Base64.INTERNAL_PADDING, ExifInterface.MARKER_SOF13, 29, 70, -19, ExifInterface.MARKER_SOF13, 20, ExifInterface.MARKER_EOI, -43, -97, 75, 23, -124, -101, -71, -75, -107, -88, -13, -71, 80, 90, -76, -119, 51, -80, 118, ByteCompanionObject.MIN_VALUE, -12, -108, 98, -29, -27, 60, -119, -74, 110, 61, 51, -22, 53, 66, -99, -45, -25, 111, -121, 25, -72, ByteCompanionObject.MAX_VALUE, 3, 51, -100, 57, -90, 116, ExifInterface.MARKER_SOF5, -117, 74, -71, 121, 59, 19, -8, -109, PublicSuffixDatabase.EXCEPTION_MARKER, -14, 76, -105, -127, -23, 5, 99, -82, 22, -99, 51, 78, -26, 77, -52, -29, 121, ExifInterface.START_CODE, -76, 20, 2, 116, 111, -76, 2, -78, -90, ExifInterface.MARKER_SOF10, 81, 115, 82, 50, 124, -83, 96, 20, ExifInterface.MARKER_SOI, -118, 105, 90, -70, 120, -33, -110, StandardMessageCodec.LIST, -15, 38, 34, -125, -116, 69, ExifInterface.MARKER_SOF10, -103, -109, -124, 26, 94, -89, -98, -11, -66, 89, 48, -68, ExifInterface.MARKER_SOF13, 107, -60, StandardMessageCodec.LIST, 114, -71, 119, 49, ExifInterface.MARKER_APP1, -65, 113, -99, 3, -90, 79, -88, ExifInterface.MARKER_SOS, -87, -25, ExifInterface.MARKER_SOS, 41, 110, -25, 29, 49, 124, -76, -91, 77, -11, -90, 114, ExifInterface.MARKER_SOF1, 118, -22, -5, -124, 19, 22, -74, -75, 78, 28, ExifInterface.WEBP_VP8L_SIGNATURE, -69, 2, 3, 1, 0, 1, -93, PublicSuffixDatabase.EXCEPTION_MARKER, 48, 31, 48, 29, 6, 3, 85, 29, 14, 4, 22, 4, 20, -41, -108, PublicSuffixDatabase.EXCEPTION_MARKER, -126, -103, Base64.INTERNAL_PADDING, 115, -83, 99, 110, ExifInterface.MARKER_EOI, 110, -125, -118, -69, 87, -103, 30, StandardMessageCodec.LIST, ExifInterface.MARKER_SOF11, 48, 13, 6, 9, ExifInterface.START_CODE, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 3, -126, 1, 1, 0, 0, -117, 0, -28, 51, 26, -4, -15, 86, ByteCompanionObject.MAX_VALUE, 14, -101, -48, 121, 115, ExifInterface.MARKER_SOF11, -72, -22, 4, -83, 49, 106, -15, -44, -116, -105, 19, 65, -32, 65, 92, 21, 51, 61, -21, -74, 71, 91, 64, 75, -72, -48, 102, 17, -120, -23, -68, 51, 23, -104, 107, 65, -30, 109, -6, 46, -44, -46, -73, ExifInterface.MARKER_SOF10, ExifInterface.MARKER_SOF9, 63, 77, ExifInterface.MARKER_SOF10, -11, ExifInterface.MARKER_SOF13, 27, -1, 114, 86, -80, 28, -89, 29, -20, 49, -8, 57, -7, -30, 61, -108, -6, -60, 113, UtilsBlink.VER_TYPE_SEPARATOR, -32, -93, 19, ExifInterface.MARKER_SOF2, -89, 106, 91, 96, -48, 90, ExifInterface.MARKER_SOF5, 46, 104, 111, -88, 51, ExifInterface.MARKER_EOI, 40, -36, -113, 86, -92, 25, 30, 94, -13, -15, ExifInterface.MARKER_SOF7, 59, -21, -111, 104, ExifInterface.MARKER_SOF14, -3, -121, -90, -43, 61, 105, -3, 57, 69, 51, -3, ExifInterface.MARKER_APP1, 105, -12, 19, 77, -82, -120, 121, 108, ExifInterface.MARKER_SOF1, -126, 46, -43, 14, -56, 21, ExifInterface.WEBP_VP8L_SIGNATURE, 63, -104, -7, 113, 57, 100, -9, -12, -101, 107, -77, ExifInterface.MARKER_SOF0, 91, -104, ExifInterface.MARKER_SOF3, 0, -7, -72, -19, 75, StandardMessageCodec.LIST, 111, ByteCompanionObject.MAX_VALUE, -115, -46, -99, -111, -93, -67, -42, -66, 32, 81, 70, 109, ExifInterface.MARKER_SOF7, 10, 19, ExifInterface.MARKER_SOF15, -44, 59, 21, 31, ExifInterface.MARKER_SOF3, ExifInterface.MARKER_SOF5, 83, -14, 43, 73, -88, 120, ExifInterface.MARKER_SOF6, -46, 46, 66, 41, -2, -70, -6, -42, 103, 8, 4, 89, 110, -122, 68, -86, 62, -68, 13, -117, Base64.INTERNAL_PADDING, -52, -6, 106, -91, 91, ExifInterface.MARKER_SOF2, -56, -26, -41, -109, 68, -102, -43, -29, 113, 43, -126, -127, 122, -47, -30, -96, -2, 78, 44, -92, ExifInterface.MARKER_SOS, -124, -102, 73, -105, -66, 5, -85, -7, 56} : (byte[]) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static byte[] a(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
                try {
                    return MessageDigest.getInstance("SHA-1").digest(bArr);
                } catch (Exception e2) {
                    a.m(e2);
                    return new byte[0];
                }
            }
            return (byte[]) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1906650379, "Lb/a/n0/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1906650379, "Lb/a/n0/d/a;");
                return;
            }
        }
        String str = new String(c.a(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 73, 61}));
        f3523c = str + new String(c.a(new byte[]{90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, 61}));
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f3525a = context.getApplicationContext();
        t();
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            e a2 = new a(context).a();
            return a2 != null ? a2.c() : "";
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(File file) {
        InterceptResult invokeL;
        FileReader fileReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, null, file)) != null) {
            return (String) invokeL.objValue;
        }
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader(file);
            try {
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
                    } catch (Exception e2) {
                        m(e2);
                    }
                    return charArrayWriter2;
                } catch (Exception e3) {
                    e = e3;
                    m(e);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e4) {
                            m(e4);
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileReader2 = fileReader;
                if (fileReader2 != null) {
                    try {
                        fileReader2.close();
                    } catch (Exception e5) {
                        m(e5);
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            fileReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (fileReader2 != null) {
            }
            throw th;
        }
    }

    public static String e(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bArr)) == null) {
            if (bArr != null) {
                String str = "";
                for (byte b2 : bArr) {
                    String hexString = Integer.toHexString(b2 & 255);
                    str = hexString.length() == 1 ? str + "0" + hexString : str + hexString;
                }
                return str.toLowerCase();
            }
            throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
        }
        return (String) invokeL.objValue;
    }

    public static byte[] j(byte[] bArr, PublicKey publicKey) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, bArr, publicKey)) == null) {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, publicKey);
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static void m(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, th) == null) {
        }
    }

    public static String p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return new String(b.a(f3523c, f3523c, c.a(str.getBytes())));
            } catch (Exception e2) {
                m(e2);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? new String(c.a(str.getBytes())) : (String) invokeL.objValue;
    }

    public final e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<d> f2 = f(new Intent("com.baidu.intent.action.GALAXY").setPackage(this.f3525a.getPackageName()), true);
            boolean z = false;
            if (f2 != null && f2.size() != 0) {
                z = f2.get(0).f3530d;
            }
            File file = new File(this.f3525a.getFilesDir(), "libcuid.so");
            e a2 = file.exists() ? e.a(p(c(file))) : null;
            if (a2 == null) {
                f3524d |= 16;
                List<d> f3 = f(new Intent("com.baidu.intent.action.GALAXY"), z);
                if (f3 != null) {
                    String str = com.baidu.fsg.face.base.b.c.f37774g;
                    File filesDir = this.f3525a.getFilesDir();
                    if (!com.baidu.fsg.face.base.b.c.f37774g.equals(filesDir.getName())) {
                        str = filesDir.getName();
                    }
                    for (d dVar : f3) {
                        if (!dVar.f3528b) {
                            File file2 = new File(new File(dVar.f3527a.dataDir, str), "libcuid.so");
                            if (file2.exists() && (a2 = e.a(p(c(file2)))) != null) {
                                break;
                            }
                        }
                    }
                }
            }
            if (a2 == null) {
                a2 = e.a(p(u("com.baidu.deviceid.v2")));
            }
            boolean n = n("android.permission.READ_EXTERNAL_STORAGE");
            if (a2 == null && n) {
                f3524d |= 2;
                a2 = o();
            }
            if (a2 == null) {
                f3524d |= 8;
                a2 = l();
            }
            if (a2 == null && n) {
                f3524d |= 1;
                a2 = s(q());
            }
            h(a2);
            return a2;
        }
        return (e) invokeV.objValue;
    }

    public final List<d> f(Intent intent, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent, z)) == null) {
            ArrayList arrayList = new ArrayList();
            PackageManager packageManager = this.f3525a.getPackageManager();
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
            if (queryBroadcastReceivers != null) {
                for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    if (activityInfo != null && activityInfo.applicationInfo != null) {
                        try {
                            Bundle bundle = packageManager.getReceiverInfo(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name), 128).metaData;
                            if (bundle != null) {
                                String string = bundle.getString("galaxy_data");
                                if (!TextUtils.isEmpty(string)) {
                                    byte[] a2 = c.a(string.getBytes("utf-8"));
                                    JSONObject jSONObject = new JSONObject(new String(a2));
                                    d dVar = new d(null);
                                    dVar.f3529c = jSONObject.getInt("priority");
                                    dVar.f3527a = resolveInfo.activityInfo.applicationInfo;
                                    if (this.f3525a.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                                        dVar.f3528b = true;
                                    }
                                    if (z) {
                                        String string2 = bundle.getString("galaxy_sf");
                                        if (!TextUtils.isEmpty(string2)) {
                                            PackageInfo packageInfo = packageManager.getPackageInfo(resolveInfo.activityInfo.applicationInfo.packageName, 64);
                                            JSONArray jSONArray = jSONObject.getJSONArray("sigs");
                                            int length = jSONArray.length();
                                            String[] strArr = new String[length];
                                            for (int i2 = 0; i2 < length; i2++) {
                                                strArr[i2] = jSONArray.getString(i2);
                                            }
                                            if (i(strArr, k(packageInfo.signatures))) {
                                                byte[] j = j(c.a(string2.getBytes()), this.f3526b);
                                                if (j != null && Arrays.equals(j, g.a(a2))) {
                                                    dVar.f3530d = true;
                                                }
                                            }
                                        }
                                    }
                                    arrayList.add(dVar);
                                }
                            }
                        } catch (Exception e2) {
                            m(e2);
                        }
                    }
                }
            }
            Collections.sort(arrayList, new C0098a(this));
            return arrayList;
        }
        return (List) invokeLZ.objValue;
    }

    public final boolean h(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar)) == null) {
            if (eVar == null) {
                return false;
            }
            if (eVar.f()) {
                eVar.f3532b = "O";
                return true;
            } else if (eVar.h()) {
                eVar.f3532b = "0";
                return true;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean i(String[] strArr, String[] strArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, strArr, strArr2)) == null) {
            if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
                return false;
            }
            HashSet hashSet = new HashSet();
            for (String str : strArr) {
                hashSet.add(str);
            }
            HashSet hashSet2 = new HashSet();
            for (String str2 : strArr2) {
                hashSet2.add(str2);
            }
            return hashSet.equals(hashSet2);
        }
        return invokeLL.booleanValue;
    }

    public final String[] k(Signature[] signatureArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, signatureArr)) == null) {
            int length = signatureArr.length;
            String[] strArr = new String[length];
            for (int i2 = 0; i2 < length; i2++) {
                strArr[i2] = e(g.a(signatureArr[i2].toByteArray()));
            }
            return strArr;
        }
        return (String[]) invokeL.objValue;
    }

    public final e l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? e.e(u("com.baidu.deviceid"), u("bd_setting_i")) : (e) invokeV.objValue;
    }

    public final boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? this.f3525a.checkPermission(str, Process.myPid(), Process.myUid()) == 0 : invokeL.booleanValue;
    }

    public final e o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "backups/.SystemConfig/.cuid2");
            if (file.exists()) {
                String c2 = c(file);
                if (TextUtils.isEmpty(c2)) {
                    return null;
                }
                try {
                    return e.a(new String(b.a(f3523c, f3523c, c.a(c2.getBytes()))));
                } catch (Exception e2) {
                    m(e2);
                    return null;
                }
            }
            return null;
        }
        return (e) invokeV.objValue;
    }

    public final String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "0" : (String) invokeV.objValue;
    }

    public final e s(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            String str3 = "";
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "baidu/.cuid");
            if (!file.exists()) {
                file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "backups/.SystemConfig/.cuid");
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
                    sb.append(Part.CRLF);
                }
                bufferedReader.close();
                String[] split = new String(b.a(f3523c, f3523c, c.a(sb.toString().getBytes()))).split("=");
                if (split == null || split.length != 2) {
                    str2 = "";
                } else {
                    str2 = split[0];
                    try {
                        str3 = split[1];
                    } catch (Exception e2) {
                        e = e2;
                        m(e);
                        return e.e(str3, str2);
                    }
                }
            } catch (Exception e3) {
                e = e3;
                str2 = "";
            }
            return e.e(str3, str2);
        }
        return (e) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void t() {
        ByteArrayInputStream byteArrayInputStream;
        Exception e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ByteArrayInputStream byteArrayInputStream2 = null;
            try {
                try {
                    try {
                        byteArrayInputStream = new ByteArrayInputStream(f.a());
                        try {
                            this.f3526b = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream).getPublicKey();
                            byteArrayInputStream.close();
                        } catch (Exception e3) {
                            e2 = e3;
                            m(e2);
                            if (byteArrayInputStream != null) {
                                byteArrayInputStream.close();
                            }
                        }
                    } catch (Throwable th) {
                        ByteArrayInputStream byteArrayInputStream3 = byteArrayInputStream;
                        th = th;
                        byteArrayInputStream2 = byteArrayInputStream3;
                        if (byteArrayInputStream2 != null) {
                            try {
                                byteArrayInputStream2.close();
                            } catch (Exception e4) {
                                m(e4);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    byteArrayInputStream = null;
                    e2 = e5;
                } catch (Throwable th2) {
                    th = th2;
                    if (byteArrayInputStream2 != null) {
                    }
                    throw th;
                }
            } catch (Exception e6) {
                m(e6);
            }
        }
    }

    public final String u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            try {
                return Settings.System.getString(this.f3525a.getContentResolver(), str);
            } catch (Exception e2) {
                m(e2);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
