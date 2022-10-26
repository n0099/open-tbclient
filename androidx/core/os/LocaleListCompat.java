package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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

    public static LocaleListCompat getEmptyLocaleList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return sEmptyLocaleList;
        }
        return (LocaleListCompat) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mImpl.hashCode();
        }
        return invokeV.intValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mImpl.isEmpty();
        }
        return invokeV.booleanValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mImpl.size();
        }
        return invokeV.intValue;
    }

    public String toLanguageTags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mImpl.toLanguageTags();
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mImpl.toString();
        }
        return (String) invokeV.objValue;
    }

    public Object unwrap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mImpl.getLocaleList();
        }
        return invokeV.objValue;
    }

    public LocaleListCompat(LocaleListInterface localeListInterface) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {localeListInterface};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mImpl = localeListInterface;
    }

    public static LocaleListCompat create(Locale... localeArr) {
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

    public static LocaleListCompat wrap(LocaleList localeList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, localeList)) == null) {
            return new LocaleListCompat(new LocaleListPlatformWrapper(localeList));
        }
        return (LocaleListCompat) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if ((obj instanceof LocaleListCompat) && this.mImpl.equals(((LocaleListCompat) obj).mImpl)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Locale get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return this.mImpl.get(i);
        }
        return (Locale) invokeI.objValue;
    }

    public Locale getFirstMatch(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
            return this.mImpl.getFirstMatch(strArr);
        }
        return (Locale) invokeL.objValue;
    }

    public int indexOf(Locale locale) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, locale)) == null) {
            return this.mImpl.indexOf(locale);
        }
        return invokeL.intValue;
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

    public static LocaleListCompat forLanguageTags(String str) {
        InterceptResult invokeL;
        Locale forLanguageTagCompat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str != null && !str.isEmpty()) {
                String[] split = str.split(",", -1);
                int length = split.length;
                Locale[] localeArr = new Locale[length];
                for (int i = 0; i < length; i++) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        forLanguageTagCompat = Locale.forLanguageTag(split[i]);
                    } else {
                        forLanguageTagCompat = forLanguageTagCompat(split[i]);
                    }
                    localeArr[i] = forLanguageTagCompat;
                }
                return create(localeArr);
            }
            return getEmptyLocaleList();
        }
        return (LocaleListCompat) invokeL.objValue;
    }

    public static LocaleListCompat getAdjustedDefault() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return wrap(LocaleList.getAdjustedDefault());
            }
            return create(Locale.getDefault());
        }
        return (LocaleListCompat) invokeV.objValue;
    }

    public static LocaleListCompat getDefault() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return wrap(LocaleList.getDefault());
            }
            return create(Locale.getDefault());
        }
        return (LocaleListCompat) invokeV.objValue;
    }

    @Deprecated
    public static LocaleListCompat wrap(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, obj)) == null) {
            return wrap((LocaleList) obj);
        }
        return (LocaleListCompat) invokeL.objValue;
    }
}
