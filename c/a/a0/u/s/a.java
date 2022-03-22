package c.a.a0.u.s;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.nadcore.net.request.BodyStyle;
import com.baidu.nadcore.net.request.RequestMethod;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.RequestBody;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final MediaType a;

    /* renamed from: b  reason: collision with root package name */
    public static final MediaType f1625b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.a0.u.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0068a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f1626b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1615777037, "Lc/a/a0/u/s/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1615777037, "Lc/a/a0/u/s/a$a;");
                    return;
                }
            }
            int[] iArr = new int[BodyStyle.values().length];
            f1626b = iArr;
            try {
                iArr[BodyStyle.BYTE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1626b[BodyStyle.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1626b[BodyStyle.FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1626b[BodyStyle.FORM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[RequestMethod.values().length];
            a = iArr2;
            try {
                iArr2[RequestMethod.HEAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[RequestMethod.GET.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[RequestMethod.POST.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[RequestMethod.PUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[RequestMethod.DELETE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[RequestMethod.PATCH.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[RequestMethod.OPTIONS.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[RequestMethod.TRACE.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(555870698, "Lc/a/a0/u/s/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(555870698, "Lc/a/a0/u/s/a;");
                return;
            }
        }
        a = MediaType.parse("text/plain");
        f1625b = MediaType.parse("application/octet-stream");
        MediaType.parse("application/x-www-form-urlencoded");
    }

    public static RequestBody a(@NonNull c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cVar)) == null) {
            byte[] bArr = cVar.f1640d;
            if (bArr != null && bArr.length > 0) {
                return RequestBody.create(d(cVar.f1638b, f1625b), cVar.f1640d);
            }
            return RequestBody.create((MediaType) null, new byte[0]);
        }
        return (RequestBody) invokeL.objValue;
    }

    public static RequestBody b(@NonNull c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            if (cVar.f1641e != null) {
                return RequestBody.create(d(cVar.f1638b, f1625b), cVar.f1641e);
            }
            return RequestBody.create((MediaType) null, new byte[0]);
        }
        return (RequestBody) invokeL.objValue;
    }

    public static RequestBody c(@NonNull c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cVar)) == null) {
            if (!c.a.a0.x.a.h(cVar.f1642f)) {
                FormBody.Builder builder = new FormBody.Builder();
                for (Map.Entry<String, String> entry : cVar.f1642f.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                        builder.add(entry.getKey(), entry.getValue());
                    }
                }
                return builder.build();
            }
            return RequestBody.create((MediaType) null, new byte[0]);
        }
        return (RequestBody) invokeL.objValue;
    }

    public static MediaType d(@NonNull String str, MediaType mediaType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, mediaType)) == null) {
            MediaType parse = !TextUtils.isEmpty(str) ? MediaType.parse(str) : null;
            return (parse != null || mediaType == null) ? parse : mediaType;
        }
        return (MediaType) invokeLL.objValue;
    }

    public static RequestBody e(@NonNull c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, cVar)) == null) {
            int i = C0068a.f1626b[cVar.a.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return RequestBody.create((MediaType) null, new byte[0]);
                        }
                        return c(cVar);
                    }
                    return b(cVar);
                }
                return f(cVar);
            }
            return a(cVar);
        }
        return (RequestBody) invokeL.objValue;
    }

    public static RequestBody f(@NonNull c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, cVar)) == null) {
            if (!TextUtils.isEmpty(cVar.f1639c)) {
                return RequestBody.create(d(cVar.f1638b, a), cVar.f1639c);
            }
            return RequestBody.create((MediaType) null, new byte[0]);
        }
        return (RequestBody) invokeL.objValue;
    }

    public static RequestBody g(@NonNull String str, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, cVar)) == null) {
            if (cVar == null) {
                return null;
            }
            int i = C0068a.a[RequestMethod.reverse(str).ordinal()];
            if (i == 3 || i == 4 || i == 5 || i == 6) {
                return e(cVar);
            }
            return null;
        }
        return (RequestBody) invokeLL.objValue;
    }
}
