package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.Size;
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
import java.util.Locale;
/* loaded from: classes.dex */
public final class LocaleListCompat {
    public static /* synthetic */ Interceptable $ic;
    public static final LocaleListCompat sEmptyLocaleList;
    public transient /* synthetic */ FieldHolder $fh;
    public LocaleListInterface mImpl;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-265918644, "Landroidx/core/os/LocaleListCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-265918644, "Landroidx/core/os/LocaleListCompat;");
                return;
            }
        }
        sEmptyLocaleList = create(new Locale[0]);
    }

    public LocaleListCompat(LocaleListInterface localeListInterface) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {localeListInterface};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mImpl = localeListInterface;
    }

    @NonNull
    public static LocaleListCompat create(@NonNull Locale... localeArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, localeArr)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return wrap(new LocaleList(localeArr));
            }
            return new LocaleListCompat(new LocaleListCompatWrapper(localeArr));
        }
        return (LocaleListCompat) invokeL.objValue;
    }

    public static Locale forLanguageTagCompat(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str.contains("-")) {
                String[] split = str.split("-", -1);
                if (split.length > 2) {
                    return new Locale(split[0], split[1], split[2]);
                }
                if (split.length > 1) {
                    return new Locale(split[0], split[1]);
                }
                if (split.length == 1) {
                    return new Locale(split[0]);
                }
            } else if (str.contains("_")) {
                String[] split2 = str.split("_", -1);
                if (split2.length > 2) {
                    return new Locale(split2[0], split2[1], split2[2]);
                }
                if (split2.length > 1) {
                    return new Locale(split2[0], split2[1]);
                }
                if (split2.length == 1) {
                    return new Locale(split2[0]);
                }
            } else {
                return new Locale(str);
            }
            throw new IllegalArgumentException("Can not parse language tag: [" + str + PreferencesUtil.RIGHT_MOUNT);
        }
        return (Locale) invokeL.objValue;
    }

    @NonNull
    public static LocaleListCompat forLanguageTags(@Nullable String str) {
        InterceptResult invokeL;
        Locale forLanguageTagCompat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
            if (str != null && !str.isEmpty()) {
                String[] split = str.split(",", -1);
                int length = split.length;
                Locale[] localeArr = new Locale[length];
                for (int i2 = 0; i2 < length; i2++) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        forLanguageTagCompat = Locale.forLanguageTag(split[i2]);
                    } else {
                        forLanguageTagCompat = forLanguageTagCompat(split[i2]);
                    }
                    localeArr[i2] = forLanguageTagCompat;
                }
                return create(localeArr);
            }
            return getEmptyLocaleList();
        }
        return (LocaleListCompat) invokeL.objValue;
    }

    @NonNull
    @Size(min = 1)
    public static LocaleListCompat getAdjustedDefault() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? Build.VERSION.SDK_INT >= 24 ? wrap(LocaleList.getAdjustedDefault()) : create(Locale.getDefault()) : (LocaleListCompat) invokeV.objValue;
    }

    @NonNull
    @Size(min = 1)
    public static LocaleListCompat getDefault() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? Build.VERSION.SDK_INT >= 24 ? wrap(LocaleList.getDefault()) : create(Locale.getDefault()) : (LocaleListCompat) invokeV.objValue;
    }

    @NonNull
    public static LocaleListCompat getEmptyLocaleList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? sEmptyLocaleList : (LocaleListCompat) invokeV.objValue;
    }

    @RequiresApi(24)
    @Deprecated
    public static LocaleListCompat wrap(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, obj)) == null) ? wrap((LocaleList) obj) : (LocaleListCompat) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? (obj instanceof LocaleListCompat) && this.mImpl.equals(((LocaleListCompat) obj).mImpl) : invokeL.booleanValue;
    }

    public Locale get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.mImpl.get(i2) : (Locale) invokeI.objValue;
    }

    @Nullable
    public Locale getFirstMatch(@NonNull String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) ? this.mImpl.getFirstMatch(strArr) : (Locale) invokeL.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mImpl.hashCode() : invokeV.intValue;
    }

    @IntRange(from = -1)
    public int indexOf(Locale locale) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, locale)) == null) ? this.mImpl.indexOf(locale) : invokeL.intValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mImpl.isEmpty() : invokeV.booleanValue;
    }

    @IntRange(from = 0)
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mImpl.size() : invokeV.intValue;
    }

    @NonNull
    public String toLanguageTags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mImpl.toLanguageTags() : (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mImpl.toString() : (String) invokeV.objValue;
    }

    @Nullable
    public Object unwrap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mImpl.getLocaleList() : invokeV.objValue;
    }

    @NonNull
    @RequiresApi(24)
    public static LocaleListCompat wrap(@NonNull LocaleList localeList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, localeList)) == null) ? new LocaleListCompat(new LocaleListPlatformWrapper(localeList)) : (LocaleListCompat) invokeL.objValue;
    }
}
