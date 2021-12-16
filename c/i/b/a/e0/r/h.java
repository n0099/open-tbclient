package c.i.b.a.e0.r;

import androidx.core.view.InputDeviceCompat;
import c.i.b.a.i0.l;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public final class h {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern a;

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f30430b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1190044037, "Lc/i/b/a/e0/r/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1190044037, "Lc/i/b/a/e0/r/h;");
                return;
            }
        }
        a = Pattern.compile("^NOTE(( |\t).*)?$");
        f30430b = Pattern.compile("^\ufeff?WEBVTT(( |\t).*)?$");
    }

    public static Matcher a(l lVar) {
        String k2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, lVar)) != null) {
            return (Matcher) invokeL.objValue;
        }
        while (true) {
            String k3 = lVar.k();
            if (k3 == null) {
                return null;
            }
            if (a.matcher(k3).matches()) {
                do {
                    k2 = lVar.k();
                    if (k2 != null) {
                    }
                } while (!k2.isEmpty());
            } else {
                Matcher matcher = f.f30422b.matcher(k3);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }

    public static float b(String str) throws NumberFormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str.endsWith("%")) {
                return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
            }
            throw new NumberFormatException("Percentages must end with %");
        }
        return invokeL.floatValue;
    }

    public static long c(String str) throws NumberFormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX, 2);
            long j2 = 0;
            for (String str2 : split[0].split(":")) {
                j2 = (j2 * 60) + Long.parseLong(str2);
            }
            long j3 = j2 * 1000;
            if (split.length == 2) {
                j3 += Long.parseLong(split[1]);
            }
            return j3 * 1000;
        }
        return invokeL.longValue;
    }

    public static void d(l lVar) throws SubtitleDecoderException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, lVar) == null) {
            String k2 = lVar.k();
            if (k2 == null || !f30430b.matcher(k2).matches()) {
                throw new SubtitleDecoderException("Expected WEBVTT. Got " + k2);
            }
        }
    }
}
