package androidx.core.os;

import android.os.Build;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes.dex */
public final class LocaleListCompatWrapper implements LocaleListInterface {
    public static /* synthetic */ Interceptable $ic;
    public static final Locale EN_LATN;
    public static final Locale LOCALE_AR_XB;
    public static final Locale LOCALE_EN_XA;
    public static final Locale[] sEmptyList;
    public transient /* synthetic */ FieldHolder $fh;
    public final Locale[] mList;
    @NonNull
    public final String mStringRepresentation;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1072880137, "Landroidx/core/os/LocaleListCompatWrapper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1072880137, "Landroidx/core/os/LocaleListCompatWrapper;");
                return;
            }
        }
        sEmptyList = new Locale[0];
        LOCALE_EN_XA = new Locale("en", "XA");
        LOCALE_AR_XB = new Locale("ar", "XB");
        EN_LATN = LocaleListCompat.forLanguageTagCompat("en-Latn");
    }

    public LocaleListCompatWrapper(@NonNull Locale... localeArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {localeArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (localeArr.length == 0) {
            this.mList = sEmptyList;
            this.mStringRepresentation = "";
            return;
        }
        Locale[] localeArr2 = new Locale[localeArr.length];
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < localeArr.length; i4++) {
            Locale locale = localeArr[i4];
            if (locale != null) {
                if (!hashSet.contains(locale)) {
                    Locale locale2 = (Locale) locale.clone();
                    localeArr2[i4] = locale2;
                    toLanguageTag(sb, locale2);
                    if (i4 < localeArr.length - 1) {
                        sb.append(',');
                    }
                    hashSet.add(locale2);
                } else {
                    throw new IllegalArgumentException("list[" + i4 + "] is a repetition");
                }
            } else {
                throw new NullPointerException("list[" + i4 + "] is null");
            }
        }
        this.mList = localeArr2;
        this.mStringRepresentation = sb.toString();
    }

    private Locale computeFirstMatch(Collection<String> collection, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, this, collection, z)) == null) {
            int computeFirstMatchIndex = computeFirstMatchIndex(collection, z);
            if (computeFirstMatchIndex == -1) {
                return null;
            }
            return this.mList[computeFirstMatchIndex];
        }
        return (Locale) invokeLZ.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x001f, code lost:
        if (r6 < Integer.MAX_VALUE) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int computeFirstMatchIndex(Collection<String> collection, boolean z) {
        InterceptResult invokeLZ;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, this, collection, z)) == null) {
            Locale[] localeArr = this.mList;
            if (localeArr.length == 1) {
                return 0;
            }
            if (localeArr.length == 0) {
                return -1;
            }
            if (z) {
                i2 = findFirstMatchIndex(EN_LATN);
                if (i2 == 0) {
                    return 0;
                }
            }
            i2 = Integer.MAX_VALUE;
            for (String str : collection) {
                int findFirstMatchIndex = findFirstMatchIndex(LocaleListCompat.forLanguageTagCompat(str));
                if (findFirstMatchIndex == 0) {
                    return 0;
                }
                if (findFirstMatchIndex < i2) {
                    i2 = findFirstMatchIndex;
                }
            }
            if (i2 == Integer.MAX_VALUE) {
                return 0;
            }
            return i2;
        }
        return invokeLZ.intValue;
    }

    private int findFirstMatchIndex(Locale locale) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65540, this, locale)) != null) {
            return invokeL.intValue;
        }
        int i2 = 0;
        while (true) {
            Locale[] localeArr = this.mList;
            if (i2 >= localeArr.length) {
                return Integer.MAX_VALUE;
            }
            if (matchScore(locale, localeArr[i2]) > 0) {
                return i2;
            }
            i2++;
        }
    }

    public static String getLikelyScript(Locale locale) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, locale)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                String script = locale.getScript();
                if (!script.isEmpty()) {
                    return script;
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static boolean isPseudoLocale(Locale locale) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, locale)) == null) ? LOCALE_EN_XA.equals(locale) || LOCALE_AR_XB.equals(locale) : invokeL.booleanValue;
    }

    @IntRange(from = 0, to = 1)
    public static int matchScore(Locale locale, Locale locale2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, locale, locale2)) == null) {
            if (locale.equals(locale2)) {
                return 1;
            }
            if (!locale.getLanguage().equals(locale2.getLanguage()) || isPseudoLocale(locale) || isPseudoLocale(locale2)) {
                return 0;
            }
            String likelyScript = getLikelyScript(locale);
            if (likelyScript.isEmpty()) {
                String country = locale.getCountry();
                return (country.isEmpty() || country.equals(locale2.getCountry())) ? 1 : 0;
            }
            return likelyScript.equals(getLikelyScript(locale2)) ? 1 : 0;
        }
        return invokeLL.intValue;
    }

    @VisibleForTesting
    public static void toLanguageTag(StringBuilder sb, Locale locale) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, sb, locale) == null) {
            sb.append(locale.getLanguage());
            String country = locale.getCountry();
            if (country == null || country.isEmpty()) {
                return;
            }
            sb.append(SignatureImpl.SEP);
            sb.append(locale.getCountry());
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, obj)) != null) {
            return invokeL.booleanValue;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocaleListCompatWrapper)) {
            return false;
        }
        Locale[] localeArr = ((LocaleListCompatWrapper) obj).mList;
        if (this.mList.length != localeArr.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            Locale[] localeArr2 = this.mList;
            if (i2 >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i2].equals(localeArr[i2])) {
                return false;
            }
            i2++;
        }
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 >= 0) {
                Locale[] localeArr = this.mList;
                if (i2 < localeArr.length) {
                    return localeArr[i2];
                }
            }
            return null;
        }
        return (Locale) invokeI.objValue;
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale getFirstMatch(@NonNull String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) ? computeFirstMatch(Arrays.asList(strArr), false) : (Locale) invokeL.objValue;
    }

    @Override // androidx.core.os.LocaleListInterface
    @Nullable
    public Object getLocaleList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048580, this)) != null) {
            return invokeV.intValue;
        }
        int i2 = 1;
        int i3 = 0;
        while (true) {
            Locale[] localeArr = this.mList;
            if (i3 >= localeArr.length) {
                return i2;
            }
            i2 = (i2 * 31) + localeArr[i3].hashCode();
            i3++;
        }
    }

    @Override // androidx.core.os.LocaleListInterface
    public int indexOf(Locale locale) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048581, this, locale)) != null) {
            return invokeL.intValue;
        }
        int i2 = 0;
        while (true) {
            Locale[] localeArr = this.mList;
            if (i2 >= localeArr.length) {
                return -1;
            }
            if (localeArr[i2].equals(locale)) {
                return i2;
            }
            i2++;
        }
    }

    @Override // androidx.core.os.LocaleListInterface
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mList.length == 0 : invokeV.booleanValue;
    }

    @Override // androidx.core.os.LocaleListInterface
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mList.length : invokeV.intValue;
    }

    @Override // androidx.core.os.LocaleListInterface
    public String toLanguageTags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mStringRepresentation : (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048585, this)) != null) {
            return (String) invokeV.objValue;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(PreferencesUtil.LEFT_MOUNT);
        int i2 = 0;
        while (true) {
            Locale[] localeArr = this.mList;
            if (i2 < localeArr.length) {
                sb.append(localeArr[i2]);
                if (i2 < this.mList.length - 1) {
                    sb.append(',');
                }
                i2++;
            } else {
                sb.append(PreferencesUtil.RIGHT_MOUNT);
                return sb.toString();
            }
        }
    }
}
