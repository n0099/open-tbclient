package c.b.b.q;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.SerializationException;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.baidu.webkit.internal.utils.UtilsBlink;
import com.kwad.yoga.YogaNodeJNIBase;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.IOException;
import java.io.Reader;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes9.dex */
public class p implements c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f27468e;

    /* renamed from: f  reason: collision with root package name */
    public static final short[] f27469f;

    /* renamed from: g  reason: collision with root package name */
    public static final char[] f27470g;

    /* renamed from: h  reason: collision with root package name */
    public static final byte[] f27471h;

    /* renamed from: i  reason: collision with root package name */
    public static final byte[] f27472i;

    /* renamed from: j  reason: collision with root package name */
    public static final short[] f27473j;
    public static final byte[] k;
    public static final byte[] l;
    public static final byte[] m;
    public static final byte[] n;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<JsonValue> a;

    /* renamed from: b  reason: collision with root package name */
    public final a<JsonValue> f27474b;

    /* renamed from: c  reason: collision with root package name */
    public JsonValue f27475c;

    /* renamed from: d  reason: collision with root package name */
    public JsonValue f27476d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(156866939, "Lc/b/b/q/p;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(156866939, "Lc/b/b/q/p;");
                return;
            }
        }
        f27468e = d();
        f27469f = h();
        f27470g = l();
        f27471h = j();
        f27472i = i();
        f27473j = f();
        k = g();
        l = m();
        m = k();
        n = e();
    }

    public p() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new a<>(8);
        this.f27474b = new a<>(8);
    }

    public static byte[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new byte[]{0, 1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 1, 6, 1, 7, 1, 8, 2, 0, 7, 2, 0, 8, 2, 1, 3, 2, 1, 5} : (byte[]) invokeV.objValue;
    }

    public static byte[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0} : (byte[]) invokeV.objValue;
    }

    public static short[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? new short[]{0, 0, 11, 14, 16, 19, 28, 34, 40, 43, 54, 62, 70, 79, 81, 90, 93, 96, 105, 108, 111, 113, 116, 119, 130, 138, 146, 157, 159, 170, 173, 176, 187, 190, 193, 196, 201, 206, 207} : (short[]) invokeV.objValue;
    }

    public static byte[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? new byte[]{1, 1, 2, 3, 4, 3, 5, 3, 6, 1, 0, 7, 7, 3, 8, 3, 9, 9, 3, 11, 11, StandardMessageCodec.LIST, 13, 14, 3, 15, 11, 10, YogaNodeJNIBase.HAS_NEW_LAYOUT, YogaNodeJNIBase.HAS_NEW_LAYOUT, 17, 18, YogaNodeJNIBase.HAS_NEW_LAYOUT, 3, 19, 19, 20, 21, 19, 3, 22, 22, 3, 21, 21, 24, 3, 25, 3, 26, 3, 27, 21, 23, 28, 29, 29, 28, 30, 31, 32, 3, PublicSuffixDatabase.EXCEPTION_MARKER, 34, 34, PublicSuffixDatabase.EXCEPTION_MARKER, 13, Base64.INTERNAL_PADDING, 15, 3, 34, 34, StandardMessageCodec.LIST, 36, 37, 3, 15, 34, 10, YogaNodeJNIBase.HAS_NEW_LAYOUT, 3, 36, 36, StandardMessageCodec.LIST, 3, 38, 3, 3, 36, 10, 39, 39, 3, 40, 40, 3, 13, 13, StandardMessageCodec.LIST, 3, 41, 3, 15, 13, 10, 42, 42, 3, 43, 43, 3, 28, 3, 44, 44, 3, UtilsBlink.VER_TYPE_SEPARATOR, UtilsBlink.VER_TYPE_SEPARATOR, 3, 47, 47, 48, 49, 50, 3, 51, 52, 53, 47, 46, 54, 55, 55, 54, 56, 57, 58, 3, 59, 60, 60, 59, 49, 61, 52, 3, 60, 60, 48, 62, 63, 3, 51, 52, 53, 60, 46, 54, 3, 62, 62, 48, 3, 64, 3, 51, 3, 53, 62, 46, 65, 65, 3, 66, 66, 3, 49, 49, 48, 3, 67, 3, 51, 52, 53, 49, 46, 68, 68, 3, 69, 69, 3, 70, 70, 3, 8, 8, 71, 8, 3, 72, 72, 73, 72, 3, 3, 3, 0} : (byte[]) invokeV.objValue;
    }

    public static short[] h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? new short[]{0, 0, 11, 13, 14, 16, 25, 31, 37, 39, 50, 57, 64, 73, 74, 83, 85, 87, 96, 98, 100, 101, 103, 105, 116, 123, 130, 141, 142, 153, 155, 157, 168, 170, 172, 174, 179, 184, 184} : (short[]) invokeV.objValue;
    }

    public static byte[] i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? new byte[]{0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0} : (byte[]) invokeV.objValue;
    }

    public static byte[] j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? new byte[]{0, 9, 2, 1, 2, 7, 4, 4, 2, 9, 7, 7, 7, 1, 7, 2, 2, 7, 2, 2, 1, 2, 2, 9, 7, 7, 9, 1, 9, 2, 2, 9, 2, 2, 2, 3, 3, 0, 0} : (byte[]) invokeV.objValue;
    }

    public static byte[] k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? new byte[]{13, 0, 15, 0, 0, 7, 3, 11, 1, 11, 17, 0, 20, 0, 0, 5, 1, 1, 1, 0, 0, 0, 11, 13, 15, 0, 7, 3, 1, 1, 1, 1, 23, 0, 0, 0, 0, 0, 0, 11, 11, 0, 11, 11, 11, 11, 13, 0, 15, 0, 0, 7, 9, 3, 1, 1, 1, 1, 26, 0, 0, 0, 0, 0, 0, 11, 11, 0, 11, 11, 11, 1, 0, 0} : (byte[]) invokeV.objValue;
    }

    public static char[] l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? new char[]{CharUtils.CR, ' ', '\"', ',', '/', ':', '[', ']', ExtendedMessageFormat.START_FE, '\t', '\n', '*', '/', '\"', '*', '/', CharUtils.CR, ' ', '\"', ',', '/', ':', ExtendedMessageFormat.END_FE, '\t', '\n', CharUtils.CR, ' ', '/', ':', '\t', '\n', CharUtils.CR, ' ', '/', ':', '\t', '\n', '*', '/', CharUtils.CR, ' ', '\"', ',', '/', ':', '[', ']', ExtendedMessageFormat.START_FE, '\t', '\n', '\t', '\n', CharUtils.CR, ' ', ',', '/', ExtendedMessageFormat.END_FE, '\t', '\n', CharUtils.CR, ' ', ',', '/', ExtendedMessageFormat.END_FE, CharUtils.CR, ' ', '\"', ',', '/', ':', ExtendedMessageFormat.END_FE, '\t', '\n', '\"', CharUtils.CR, ' ', '\"', ',', '/', ':', ExtendedMessageFormat.END_FE, '\t', '\n', '*', '/', '*', '/', CharUtils.CR, ' ', '\"', ',', '/', ':', ExtendedMessageFormat.END_FE, '\t', '\n', '*', '/', '*', '/', '\"', '*', '/', '*', '/', CharUtils.CR, ' ', '\"', ',', '/', ':', '[', ']', ExtendedMessageFormat.START_FE, '\t', '\n', '\t', '\n', CharUtils.CR, ' ', ',', '/', ']', '\t', '\n', CharUtils.CR, ' ', ',', '/', ']', CharUtils.CR, ' ', '\"', ',', '/', ':', '[', ']', ExtendedMessageFormat.START_FE, '\t', '\n', '\"', CharUtils.CR, ' ', '\"', ',', '/', ':', '[', ']', ExtendedMessageFormat.START_FE, '\t', '\n', '*', '/', '*', '/', CharUtils.CR, ' ', '\"', ',', '/', ':', '[', ']', ExtendedMessageFormat.START_FE, '\t', '\n', '*', '/', '*', '/', '*', '/', CharUtils.CR, ' ', '/', '\t', '\n', CharUtils.CR, ' ', '/', '\t', '\n', 0} : (char[]) invokeV.objValue;
    }

    public static byte[] m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? new byte[]{Base64.INTERNAL_PADDING, 1, 3, 0, 4, 36, 36, 36, 36, 1, 6, 5, 13, 17, 22, 37, 7, 8, 9, 7, 8, 9, 7, 10, 20, 21, 11, 11, 11, StandardMessageCodec.LIST, 17, 19, 37, 11, StandardMessageCodec.LIST, 19, 14, YogaNodeJNIBase.HAS_NEW_LAYOUT, 15, 14, StandardMessageCodec.LIST, 18, 17, 11, 9, 5, 24, 23, 27, 31, 34, 25, 38, 25, 25, 26, 31, PublicSuffixDatabase.EXCEPTION_MARKER, 38, 25, 26, PublicSuffixDatabase.EXCEPTION_MARKER, 28, 30, 29, 28, 26, 32, 31, 25, 23, 2, 36, 2} : (byte[]) invokeV.objValue;
    }

    @Override // c.b.b.q.c
    public JsonValue a(c.b.b.m.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            try {
                try {
                    return p(aVar.r("UTF-8"));
                } catch (Exception e2) {
                    throw new SerializationException("Error parsing file: " + aVar, e2);
                }
            } catch (Exception e3) {
                throw new SerializationException("Error reading file: " + aVar, e3);
            }
        }
        return (JsonValue) invokeL.objValue;
    }

    public final void b(String str, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jsonValue) == null) {
            jsonValue.Q(str);
            JsonValue jsonValue2 = this.f27476d;
            if (jsonValue2 == null) {
                this.f27476d = jsonValue;
                this.f27475c = jsonValue;
            } else if (!jsonValue2.v() && !this.f27476d.D()) {
                this.f27475c = this.f27476d;
            } else {
                JsonValue jsonValue3 = this.f27476d;
                jsonValue.k = jsonValue3;
                if (jsonValue3.n == 0) {
                    jsonValue3.f31137j = jsonValue;
                } else {
                    JsonValue pop = this.f27474b.pop();
                    pop.l = jsonValue;
                    jsonValue.m = pop;
                }
                this.f27474b.a(jsonValue);
                this.f27476d.n++;
            }
        }
    }

    public void c(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z) == null) {
            b(str, new JsonValue(z));
        }
    }

    public void n(String str, double d2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Double.valueOf(d2), str2}) == null) {
            b(str, new JsonValue(d2, str2));
        }
    }

    public void o(String str, long j2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Long.valueOf(j2), str2}) == null) {
            b(str, new JsonValue(j2, str2));
        }
    }

    public JsonValue p(Reader reader) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048581, this, reader)) != null) {
            return (JsonValue) invokeL.objValue;
        }
        char[] cArr = new char[1024];
        int i2 = 0;
        while (true) {
            try {
                try {
                    int read = reader.read(cArr, i2, cArr.length - i2);
                    if (read == -1) {
                        i0.a(reader);
                        return q(cArr, 0, i2);
                    } else if (read == 0) {
                        char[] cArr2 = new char[cArr.length * 2];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        cArr = cArr2;
                    } else {
                        i2 += read;
                    }
                } catch (IOException e2) {
                    throw new SerializationException("Error reading input.", e2);
                }
            } catch (Throwable th) {
                i0.a(reader);
                throw th;
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:401:0x005c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:454:0x009c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:456:0x009c */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002f, code lost:
        if (r11 != 4) goto L313;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x023d, code lost:
        r11 = 2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01a1 A[LOOP:7: B:360:0x0168->B:125:0x01a1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:328:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x0358 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:384:0x0350 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:387:0x0346 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:425:0x01a6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e2 A[Catch: RuntimeException -> 0x045b, TRY_LEAVE, TryCatch #9 {RuntimeException -> 0x045b, blocks: (B:262:0x0394, B:264:0x039a, B:268:0x03ac, B:275:0x03bd, B:281:0x03d2, B:286:0x03dd, B:21:0x0045, B:23:0x0053, B:25:0x005e, B:34:0x0090, B:36:0x0096, B:38:0x009e, B:39:0x00a1, B:41:0x00b7, B:42:0x00bc, B:44:0x00c6, B:45:0x00cd, B:46:0x00d4, B:48:0x00e2, B:139:0x01d1, B:161:0x0208, B:162:0x0210, B:164:0x0214, B:166:0x021c, B:168:0x0222, B:169:0x022e, B:170:0x0236, B:172:0x0241, B:174:0x0245, B:176:0x024d, B:178:0x0253, B:180:0x0261, B:185:0x0275, B:187:0x027b, B:191:0x028c, B:198:0x029d, B:204:0x02b0, B:209:0x02bd, B:26:0x0063, B:28:0x0077, B:29:0x007c, B:31:0x0084, B:32:0x0089), top: B:374:0x0045 }] */
    /* JADX WARN: Type inference failed for: r0v40, types: [int[], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v50, types: [int[], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v16, types: [int] */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v50, types: [int] */
    /* JADX WARN: Type inference failed for: r13v53 */
    /* JADX WARN: Type inference failed for: r18v13, types: [int] */
    /* JADX WARN: Type inference failed for: r18v16, types: [int] */
    /* JADX WARN: Type inference failed for: r18v17, types: [int] */
    /* JADX WARN: Type inference failed for: r4v0, types: [int[]] */
    /* JADX WARN: Type inference failed for: r9v5, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JsonValue q(char[] cArr, int i2, int i3) {
        InterceptResult invokeLII;
        String str;
        int i4;
        byte[] bArr;
        RuntimeException runtimeException;
        String str2;
        int i5;
        a aVar;
        boolean z;
        int i6;
        short s;
        short s2;
        byte b2;
        int i7;
        byte[] bArr2;
        byte b3;
        int i8;
        boolean z2;
        int i9;
        boolean z3;
        int i10;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, cArr, i2, i3)) == null) {
            a aVar2 = new a(8);
            byte[] bArr3 = new int[4];
            int i11 = 0;
            char c2 = 0;
            byte b4 = 1;
            int i12 = 0;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            int i13 = i2;
            while (true) {
                str = "false";
                try {
                    if (c2 != 0) {
                        if (c2 != 1) {
                            if (c2 == 2) {
                                i4 = i11;
                                bArr = bArr3;
                                if (b4 == 0) {
                                    i11 = i4;
                                    bArr3 = bArr;
                                    c2 = 5;
                                } else {
                                    i13++;
                                    if (i13 != i3) {
                                        i11 = i4;
                                        bArr3 = bArr;
                                        c2 = 1;
                                    }
                                }
                            }
                        }
                    } else if (i13 == i3) {
                        c2 = 4;
                    } else if (b4 == 0) {
                        c2 = 5;
                    }
                    short s3 = f27469f[b4];
                    short s4 = f27473j[b4];
                    byte b5 = f27471h[b4];
                    if (b5 > 0) {
                        int i14 = s3 + b5;
                        int i15 = i14 - 1;
                        i6 = i12;
                        int i16 = s3;
                        while (i15 >= i16) {
                            int i17 = i16 + ((i15 - i16) >> 1);
                            int i18 = i15;
                            int i19 = i16;
                            if (cArr[i13] < f27470g[i17]) {
                                i15 = i17 - 1;
                                i16 = i19;
                            } else if (cArr[i13] > f27470g[i17]) {
                                i16 = i17 + 1;
                                i15 = i18;
                            } else {
                                s2 = s4 + (i17 - s3);
                                b2 = k[s2];
                                byte b6 = l[b2];
                                if (m[b2] == 0) {
                                    byte b7 = m[b2];
                                    int i20 = b7 + 1;
                                    byte b8 = f27468e[b7];
                                    int i21 = i20;
                                    i12 = i6;
                                    while (true) {
                                        ?? r18 = b8 - 1;
                                        if (b8 > 0) {
                                            try {
                                                int i22 = i21 + 1;
                                                switch (f27468e[i21]) {
                                                    case 0:
                                                        i7 = i11;
                                                        bArr2 = bArr3;
                                                        b3 = b6;
                                                        z5 = true;
                                                        b6 = b3;
                                                        b8 = r18;
                                                        i21 = i22;
                                                        i11 = i7;
                                                        bArr3 = bArr2;
                                                    case 1:
                                                        String str3 = new String(cArr, i12, i13 - i12);
                                                        if (z4) {
                                                            str3 = v(str3);
                                                        }
                                                        if (z5) {
                                                            aVar2.a(str3);
                                                            i8 = i13;
                                                            i7 = i11;
                                                            bArr2 = bArr3;
                                                            b3 = b6;
                                                            z5 = false;
                                                        } else {
                                                            String str4 = aVar2.f27361f > 0 ? (String) aVar2.pop() : null;
                                                            if (z6) {
                                                                if (str3.equals("true")) {
                                                                    c(str4, true);
                                                                } else if (str3.equals("false")) {
                                                                    c(str4, false);
                                                                } else if (str3.equals(StringUtil.NULL_STRING)) {
                                                                    i7 = i11;
                                                                    u(str4, null);
                                                                    i8 = i13;
                                                                    bArr2 = bArr3;
                                                                    b3 = b6;
                                                                } else {
                                                                    i7 = i11;
                                                                    boolean z7 = false;
                                                                    boolean z8 = true;
                                                                    while (true) {
                                                                        if (i12 < i13) {
                                                                            i8 = i13;
                                                                            char c3 = cArr[i12];
                                                                            boolean z9 = z7;
                                                                            if (c3 != '+') {
                                                                                if (c3 != 'E' && c3 != 'e') {
                                                                                    if (c3 != '-') {
                                                                                        if (c3 != '.') {
                                                                                            switch (c3) {
                                                                                                case '0':
                                                                                                case '1':
                                                                                                case '2':
                                                                                                case '3':
                                                                                                case '4':
                                                                                                case '5':
                                                                                                case '6':
                                                                                                case '7':
                                                                                                case '8':
                                                                                                case '9':
                                                                                                    break;
                                                                                                default:
                                                                                                    z8 = false;
                                                                                                    z2 = false;
                                                                                                    break;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                                z7 = true;
                                                                                z8 = false;
                                                                                i12++;
                                                                                i13 = i8;
                                                                            }
                                                                            z7 = z9;
                                                                            i12++;
                                                                            i13 = i8;
                                                                        } else {
                                                                            i8 = i13;
                                                                            z2 = z7;
                                                                        }
                                                                    }
                                                                    if (z2) {
                                                                        bArr2 = bArr3;
                                                                        b3 = b6;
                                                                        try {
                                                                            n(str4, Double.parseDouble(str3), str3);
                                                                        } catch (NumberFormatException unused) {
                                                                        }
                                                                    } else {
                                                                        bArr2 = bArr3;
                                                                        b3 = b6;
                                                                        if (z8) {
                                                                            o(str4, Long.parseLong(str3), str3);
                                                                        }
                                                                    }
                                                                }
                                                                i8 = i13;
                                                                i7 = i11;
                                                                bArr2 = bArr3;
                                                                b3 = b6;
                                                            } else {
                                                                i8 = i13;
                                                                i7 = i11;
                                                                bArr2 = bArr3;
                                                                b3 = b6;
                                                            }
                                                            u(str4, str3);
                                                        }
                                                        i13 = i8;
                                                        i12 = i13;
                                                        z6 = false;
                                                        b6 = b3;
                                                        b8 = r18;
                                                        i21 = i22;
                                                        i11 = i7;
                                                        bArr3 = bArr2;
                                                        break;
                                                    case 2:
                                                        t(aVar2.f27361f > 0 ? (String) aVar2.pop() : null);
                                                        if (i11 == bArr3.length) {
                                                            ?? r0 = new int[bArr3.length * 2];
                                                            System.arraycopy(bArr3, 0, r0, 0, bArr3.length);
                                                            bArr3 = r0;
                                                        }
                                                        int i23 = i11 + 1;
                                                        bArr3[i11] = b6;
                                                        i11 = i23;
                                                        c2 = 2;
                                                        b4 = 5;
                                                        break;
                                                    case 3:
                                                        r();
                                                        i11--;
                                                        b4 = bArr3[i11];
                                                        break;
                                                    case 4:
                                                        s(aVar2.f27361f > 0 ? (String) aVar2.pop() : null);
                                                        if (i11 == bArr3.length) {
                                                            ?? r02 = new int[bArr3.length * 2];
                                                            System.arraycopy(bArr3, 0, r02, 0, bArr3.length);
                                                            bArr3 = r02;
                                                        }
                                                        bArr3[i11] = b6;
                                                        b4 = 23;
                                                        i11++;
                                                        break;
                                                    case 5:
                                                        r();
                                                        i11--;
                                                        b4 = bArr3[i11];
                                                        break;
                                                    case 6:
                                                        int i24 = i13 + 1;
                                                        if (cArr[i13] != '/') {
                                                            while (true) {
                                                                int i25 = i24;
                                                                i24 = i25 + 1;
                                                                try {
                                                                    if (i24 < i3) {
                                                                        i9 = i25;
                                                                        if (cArr[i25] != '*') {
                                                                        }
                                                                    } else {
                                                                        i9 = i25;
                                                                    }
                                                                    if (cArr[i24] == '/') {
                                                                        i13 = i24;
                                                                    }
                                                                } catch (RuntimeException e2) {
                                                                    runtimeException = e2;
                                                                    i13 = i9;
                                                                    break;
                                                                }
                                                            }
                                                        } else {
                                                            int i26 = i24;
                                                            while (i26 != i3 && cArr[i26] != '\n') {
                                                                i26++;
                                                            }
                                                            i13 = i26 - 1;
                                                        }
                                                        i7 = i11;
                                                        bArr2 = bArr3;
                                                        b3 = b6;
                                                        b6 = b3;
                                                        b8 = r18;
                                                        i21 = i22;
                                                        i11 = i7;
                                                        bArr3 = bArr2;
                                                        break;
                                                    case 7:
                                                        char c4 = CharUtils.CR;
                                                        if (z5) {
                                                            i10 = i13;
                                                            z4 = false;
                                                            do {
                                                                try {
                                                                    char c5 = cArr[i10];
                                                                    z3 = z4;
                                                                    if (c5 != '\n' && c5 != '\r') {
                                                                        if (c5 == '/') {
                                                                            int i27 = i10 + 1;
                                                                            if (i27 != i3) {
                                                                                char c6 = cArr[i27];
                                                                                if (c6 != '/') {
                                                                                    if (c6 == '*') {
                                                                                    }
                                                                                }
                                                                            }
                                                                            z4 = z3;
                                                                            i10++;
                                                                        } else if (c5 != ':') {
                                                                            if (c5 != '\\') {
                                                                                z4 = z3;
                                                                                i10++;
                                                                            } else {
                                                                                z4 = true;
                                                                                i10++;
                                                                            }
                                                                        }
                                                                        b6 = b3;
                                                                        b8 = r18;
                                                                        i21 = i22;
                                                                        i11 = i7;
                                                                        bArr3 = bArr2;
                                                                    }
                                                                } catch (RuntimeException e3) {
                                                                    runtimeException = e3;
                                                                    i13 = i10;
                                                                    break;
                                                                }
                                                            } while (i10 != i3);
                                                            do {
                                                                i10--;
                                                            } while (Character.isSpace(cArr[i10]));
                                                            i7 = i11;
                                                            bArr2 = bArr3;
                                                            b3 = b6;
                                                            z6 = true;
                                                            i12 = i13;
                                                            i13 = i10;
                                                            b6 = b3;
                                                            b8 = r18;
                                                            i21 = i22;
                                                            i11 = i7;
                                                            bArr3 = bArr2;
                                                        } else {
                                                            int i28 = i13;
                                                            boolean z10 = false;
                                                            while (true) {
                                                                try {
                                                                    char c7 = cArr[i28];
                                                                    z3 = z10;
                                                                    if (c7 != '\n' && c7 != c4 && c7 != ',') {
                                                                        if (c7 == '/') {
                                                                            int i29 = i28 + 1;
                                                                            if (i29 != i3) {
                                                                                char c8 = cArr[i29];
                                                                                if (c8 != '/') {
                                                                                    if (c8 == '*') {
                                                                                    }
                                                                                }
                                                                            }
                                                                            i28++;
                                                                            if (i28 == i3) {
                                                                            }
                                                                        } else if (c7 != '}') {
                                                                            if (c7 == '\\') {
                                                                                z3 = true;
                                                                            } else if (c7 != ']') {
                                                                            }
                                                                            i28++;
                                                                            if (i28 == i3) {
                                                                                z10 = z3;
                                                                                c4 = CharUtils.CR;
                                                                            }
                                                                        }
                                                                    }
                                                                } catch (RuntimeException e4) {
                                                                    runtimeException = e4;
                                                                    i13 = i28;
                                                                    break;
                                                                }
                                                            }
                                                            i10 = i28;
                                                        }
                                                        z4 = z3;
                                                        do {
                                                            i10--;
                                                        } while (Character.isSpace(cArr[i10]));
                                                        i7 = i11;
                                                        bArr2 = bArr3;
                                                        b3 = b6;
                                                        z6 = true;
                                                        i12 = i13;
                                                        i13 = i10;
                                                        b6 = b3;
                                                        b8 = r18;
                                                        i21 = i22;
                                                        i11 = i7;
                                                        bArr3 = bArr2;
                                                        break;
                                                    case 8:
                                                        int i30 = i13 + 1;
                                                        int i31 = i30;
                                                        boolean z11 = false;
                                                        do {
                                                            try {
                                                                char c9 = cArr[i31];
                                                                if (c9 != '\"') {
                                                                    if (c9 == '\\') {
                                                                        i31++;
                                                                        z11 = true;
                                                                    }
                                                                    i31++;
                                                                }
                                                                i12 = i30;
                                                                i7 = i11;
                                                                i13 = i31 - 1;
                                                                bArr2 = bArr3;
                                                                b3 = b6;
                                                                z4 = z11;
                                                                b6 = b3;
                                                                b8 = r18;
                                                                i21 = i22;
                                                                i11 = i7;
                                                                bArr3 = bArr2;
                                                            } catch (RuntimeException e5) {
                                                                runtimeException = e5;
                                                                i13 = i31;
                                                                break;
                                                            }
                                                        } while (i31 != i3);
                                                        i12 = i30;
                                                        i7 = i11;
                                                        i13 = i31 - 1;
                                                        bArr2 = bArr3;
                                                        b3 = b6;
                                                        z4 = z11;
                                                        b6 = b3;
                                                        b8 = r18;
                                                        i21 = i22;
                                                        i11 = i7;
                                                        bArr3 = bArr2;
                                                    default:
                                                        i7 = i11;
                                                        bArr2 = bArr3;
                                                        b3 = b6;
                                                        b6 = b3;
                                                        b8 = r18;
                                                        i21 = i22;
                                                        i11 = i7;
                                                        bArr3 = bArr2;
                                                }
                                            } catch (RuntimeException e6) {
                                                e = e6;
                                                runtimeException = e;
                                                JsonValue jsonValue = this.f27475c;
                                                this.f27475c = null;
                                                this.f27476d = null;
                                                this.f27474b.clear();
                                                if (i13 < i3) {
                                                }
                                            }
                                        } else {
                                            i4 = i11;
                                            bArr = bArr3;
                                            b4 = b6;
                                        }
                                    }
                                } else {
                                    i4 = i11;
                                    bArr = bArr3;
                                    b4 = b6;
                                    i12 = i6;
                                }
                                if (b4 == 0) {
                                }
                            }
                        }
                        s3 = i14;
                        s = s4 + b5;
                    } else {
                        i6 = i12;
                        s = s4;
                    }
                    byte b9 = f27472i[b4];
                    s2 = s;
                    if (b9 > 0) {
                        int i32 = ((b9 << 1) + s3) - 2;
                        int i33 = s3;
                        while (true) {
                            if (i32 < i33) {
                                s2 = s + b9;
                            } else {
                                int i34 = i33 + (((i32 - i33) >> 1) & (-2));
                                byte b10 = b9;
                                int i35 = i32;
                                if (cArr[i13] < f27470g[i34]) {
                                    i32 = i34 - 2;
                                    b9 = b10;
                                } else if (cArr[i13] > f27470g[i34 + 1]) {
                                    i33 = i34 + 2;
                                    b9 = b10;
                                    i32 = i35;
                                } else {
                                    s2 = s + ((i34 - s3) >> 1);
                                }
                            }
                        }
                    }
                    b2 = k[s2];
                    byte b62 = l[b2];
                    if (m[b2] == 0) {
                    }
                    if (b4 == 0) {
                    }
                } catch (RuntimeException e7) {
                    e = e7;
                }
            }
            if (i13 == i3) {
                try {
                    byte b11 = n[b4];
                    int i36 = b11 + 1;
                    byte b12 = f27468e[b11];
                    while (true) {
                        ?? r9 = b12 - 1;
                        if (b12 > 0) {
                            int i37 = i36 + 1;
                            if (f27468e[i36] != 1) {
                                i5 = i13;
                                aVar = aVar2;
                                boolean z12 = z6;
                                str2 = str;
                                z = z12;
                            } else {
                                String str5 = new String(cArr, i12, i13 - i12);
                                if (z4) {
                                    str5 = v(str5);
                                }
                                if (z5) {
                                    aVar2.a(str5);
                                    str2 = str;
                                    i5 = i13;
                                    aVar = aVar2;
                                    z5 = false;
                                } else {
                                    String str6 = aVar2.f27361f > 0 ? (String) aVar2.pop() : null;
                                    if (z6) {
                                        if (str5.equals("true")) {
                                            c(str6, true);
                                        } else if (str5.equals(str)) {
                                            c(str6, false);
                                        } else if (str5.equals(StringUtil.NULL_STRING)) {
                                            u(str6, null);
                                        } else {
                                            str2 = str;
                                            int i38 = i12;
                                            boolean z13 = false;
                                            boolean z14 = true;
                                            while (true) {
                                                if (i38 < i13) {
                                                    i5 = i13;
                                                    try {
                                                        char c10 = cArr[i38];
                                                        aVar = aVar2;
                                                        if (c10 != '+') {
                                                            if (c10 != 'E' && c10 != 'e') {
                                                                if (c10 != '-') {
                                                                    if (c10 != '.') {
                                                                        switch (c10) {
                                                                            case '0':
                                                                            case '1':
                                                                            case '2':
                                                                            case '3':
                                                                            case '4':
                                                                            case '5':
                                                                            case '6':
                                                                            case '7':
                                                                            case '8':
                                                                            case '9':
                                                                                i38++;
                                                                                i13 = i5;
                                                                                aVar2 = aVar;
                                                                            default:
                                                                                z13 = false;
                                                                                z14 = false;
                                                                                break;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            z13 = true;
                                                            z14 = false;
                                                            i38++;
                                                            i13 = i5;
                                                            aVar2 = aVar;
                                                        }
                                                        i38++;
                                                        i13 = i5;
                                                        aVar2 = aVar;
                                                    } catch (RuntimeException e8) {
                                                        runtimeException = e8;
                                                        i13 = i5;
                                                    }
                                                } else {
                                                    i5 = i13;
                                                    aVar = aVar2;
                                                }
                                            }
                                            if (z13) {
                                                try {
                                                    n(str6, Double.parseDouble(str5), str5);
                                                } catch (NumberFormatException unused2) {
                                                }
                                            } else if (z14) {
                                                o(str6, Long.parseLong(str5), str5);
                                            }
                                        }
                                        str2 = str;
                                        i5 = i13;
                                        aVar = aVar2;
                                    } else {
                                        str2 = str;
                                        i5 = i13;
                                        aVar = aVar2;
                                    }
                                    u(str6, str5);
                                }
                                i12 = i5;
                                z = false;
                            }
                            b12 = r9;
                            i36 = i37;
                            i13 = i5;
                            aVar2 = aVar;
                            String str7 = str2;
                            z6 = z;
                            str = str7;
                        }
                    }
                } catch (RuntimeException e9) {
                    e = e9;
                    runtimeException = e;
                    JsonValue jsonValue2 = this.f27475c;
                    this.f27475c = null;
                    this.f27476d = null;
                    this.f27474b.clear();
                    if (i13 < i3) {
                    }
                }
            }
            i13 = i13;
            runtimeException = null;
            JsonValue jsonValue22 = this.f27475c;
            this.f27475c = null;
            this.f27476d = null;
            this.f27474b.clear();
            if (i13 < i3) {
                int i39 = 1;
                for (int i40 = 0; i40 < i13; i40++) {
                    if (cArr[i40] == '\n') {
                        i39++;
                    }
                }
                int max = Math.max(0, i13 - 32);
                throw new SerializationException("Error parsing JSON on line " + i39 + " near: " + new String(cArr, max, i13 - max) + "*ERROR*" + new String(cArr, i13, Math.min(64, i3 - i13)), runtimeException);
            }
            a<JsonValue> aVar3 = this.a;
            if (aVar3.f27361f == 0) {
                if (runtimeException == null) {
                    return jsonValue22;
                } else {
                    throw new SerializationException("Error parsing JSON: " + new String(cArr), runtimeException);
                }
            }
            JsonValue peek = aVar3.peek();
            this.a.clear();
            if (peek != null && peek.D()) {
                throw new SerializationException("Error parsing JSON, unmatched brace.");
            }
            throw new SerializationException("Error parsing JSON, unmatched bracket.");
        }
        return (JsonValue) invokeLII.objValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f27475c = this.a.pop();
            if (this.f27476d.n > 0) {
                this.f27474b.pop();
            }
            a<JsonValue> aVar = this.a;
            this.f27476d = aVar.f27361f > 0 ? aVar.peek() : null;
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            JsonValue jsonValue = new JsonValue(JsonValue.ValueType.array);
            if (this.f27476d != null) {
                b(str, jsonValue);
            }
            this.a.a(jsonValue);
            this.f27476d = jsonValue;
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            JsonValue jsonValue = new JsonValue(JsonValue.ValueType.object);
            if (this.f27476d != null) {
                b(str, jsonValue);
            }
            this.a.a(jsonValue);
            this.f27476d = jsonValue;
        }
    }

    public void u(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            b(str, new JsonValue(str2));
        }
    }

    public final String v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            int length = str.length();
            j0 j0Var = new j0(length + 16);
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                char charAt = str.charAt(i2);
                if (charAt != '\\') {
                    j0Var.a(charAt);
                } else if (i3 == length) {
                    break;
                } else {
                    i2 = i3 + 1;
                    char charAt2 = str.charAt(i3);
                    if (charAt2 == 'u') {
                        i3 = i2 + 4;
                        j0Var.p(Character.toChars(Integer.parseInt(str.substring(i2, i3), 16)));
                    } else {
                        if (charAt2 != '\"' && charAt2 != '/' && charAt2 != '\\') {
                            if (charAt2 == 'b') {
                                charAt2 = '\b';
                            } else if (charAt2 == 'f') {
                                charAt2 = '\f';
                            } else if (charAt2 == 'n') {
                                charAt2 = '\n';
                            } else if (charAt2 == 'r') {
                                charAt2 = CharUtils.CR;
                            } else if (charAt2 != 't') {
                                throw new SerializationException("Illegal escaped character: \\" + charAt2);
                            } else {
                                charAt2 = '\t';
                            }
                        }
                        j0Var.a(charAt2);
                    }
                }
                i2 = i3;
            }
            return j0Var.toString();
        }
        return (String) invokeL.objValue;
    }
}
