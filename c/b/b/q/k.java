package c.b.b.q;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes9.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final Locale f27422d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f27423e;
    public transient /* synthetic */ FieldHolder $fh;
    public k a;

    /* renamed from: b  reason: collision with root package name */
    public Locale f27424b;

    /* renamed from: c  reason: collision with root package name */
    public w<String, String> f27425c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(156866784, "Lc/b/b/q/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(156866784, "Lc/b/b/q/k;");
                return;
            }
        }
        f27422d = new Locale("", "", "");
        f27423e = false;
    }

    public k() {
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

    public static boolean a(c.b.b.m.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, aVar)) == null) {
            try {
                aVar.m().close();
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static k b(c.b.b.m.a aVar, Locale locale) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, aVar, locale)) == null) ? d(aVar, locale, "UTF-8") : (k) invokeLL.objValue;
    }

    public static k c(c.b.b.m.a aVar, Locale locale, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar, locale, str)) == null) ? d(aVar, locale, str) : (k) invokeLLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:
        if (r0 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0085, code lost:
        throw new java.util.MissingResourceException("Can't find bundle for base file handle " + r9.j() + ", locale " + r10, r9 + "_" + r10, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static k d(c.b.b.m.a aVar, Locale locale, String str) {
        InterceptResult invokeLLL;
        k j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, aVar, locale, str)) == null) {
            k kVar = null;
            if (aVar == null || locale == null || str == null) {
                throw null;
            }
            Locale locale2 = locale;
            do {
                List<Locale> e2 = e(locale2);
                j2 = j(aVar, str, e2, 0, kVar);
                if (j2 != null) {
                    Locale g2 = j2.g();
                    boolean equals = g2.equals(f27422d);
                    if (!equals || g2.equals(locale) || (e2.size() == 1 && g2.equals(e2.get(0)))) {
                        break;
                    } else if (equals && kVar == null) {
                        kVar = j2;
                    }
                }
                locale2 = f(locale2);
            } while (locale2 != null);
            return j2;
        }
        return (k) invokeLLL.objValue;
    }

    public static List<Locale> e(Locale locale) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, locale)) == null) {
            String language = locale.getLanguage();
            String country = locale.getCountry();
            String variant = locale.getVariant();
            ArrayList arrayList = new ArrayList(4);
            if (variant.length() > 0) {
                arrayList.add(locale);
            }
            if (country.length() > 0) {
                arrayList.add(arrayList.isEmpty() ? locale : new Locale(language, country));
            }
            if (language.length() > 0) {
                if (!arrayList.isEmpty()) {
                    locale = new Locale(language);
                }
                arrayList.add(locale);
            }
            arrayList.add(f27422d);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static Locale f(Locale locale) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, locale)) == null) {
            Locale locale2 = Locale.getDefault();
            if (locale.equals(locale2)) {
                return null;
            }
            return locale2;
        }
        return (Locale) invokeL.objValue;
    }

    public static k i(c.b.b.m.a aVar, String str, Locale locale) {
        InterceptResult invokeLLL;
        k kVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, aVar, str, locale)) == null) {
            Reader reader = null;
            try {
                try {
                    c.b.b.m.a l = l(aVar, locale);
                    if (a(l)) {
                        kVar = new k();
                        reader = l.r(str);
                        kVar.h(reader);
                    } else {
                        kVar = null;
                    }
                    if (kVar != null) {
                        kVar.k(locale);
                    }
                    return kVar;
                } catch (IOException e2) {
                    throw new GdxRuntimeException(e2);
                }
            } finally {
                i0.a(reader);
            }
        }
        return (k) invokeLLL.objValue;
    }

    public static k j(c.b.b.m.a aVar, String str, List<Locale> list, int i2, k kVar) {
        InterceptResult invokeCommon;
        k kVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{aVar, str, list, Integer.valueOf(i2), kVar})) == null) {
            Locale locale = list.get(i2);
            if (i2 != list.size() - 1) {
                kVar2 = j(aVar, str, list, i2 + 1, kVar);
            } else if (kVar != null && locale.equals(f27422d)) {
                return kVar;
            } else {
                kVar2 = null;
            }
            k i3 = i(aVar, str, locale);
            if (i3 != null) {
                i3.a = kVar2;
                return i3;
            }
            return kVar2;
        }
        return (k) invokeCommon.objValue;
    }

    public static c.b.b.m.a l(c.b.b.m.a aVar, Locale locale) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, aVar, locale)) == null) {
            j0 j0Var = new j0(aVar.g());
            if (!locale.equals(f27422d)) {
                String language = locale.getLanguage();
                String country = locale.getCountry();
                String variant = locale.getVariant();
                boolean equals = "".equals(language);
                boolean equals2 = "".equals(country);
                boolean equals3 = "".equals(variant);
                if (!equals || !equals2 || !equals3) {
                    j0Var.a('_');
                    if (!equals3) {
                        j0Var.n(language);
                        j0Var.a('_');
                        j0Var.n(country);
                        j0Var.a('_');
                        j0Var.n(variant);
                    } else if (!equals2) {
                        j0Var.n(language);
                        j0Var.a('_');
                        j0Var.n(country);
                    } else {
                        j0Var.n(language);
                    }
                }
            }
            j0Var.n(".properties");
            return aVar.s(j0Var.toString());
        }
        return (c.b.b.m.a) invokeLL.objValue;
    }

    public Locale g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f27424b : (Locale) invokeV.objValue;
    }

    public void h(Reader reader) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, reader) == null) {
            w<String, String> wVar = new w<>();
            this.f27425c = wVar;
            b0.a(wVar, reader);
        }
    }

    public final void k(Locale locale) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, locale) == null) {
            this.f27424b = locale;
            new k0(locale, !f27423e);
        }
    }
}
