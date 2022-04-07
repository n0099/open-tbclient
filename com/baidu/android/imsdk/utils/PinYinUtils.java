package com.baidu.android.imsdk.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class PinYinUtils {
    public static /* synthetic */ Interceptable $ic;
    public static Comparator<PinYinObject> pyComparator;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface PinYinObject {
        String getPy();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2086162920, "Lcom/baidu/android/imsdk/utils/PinYinUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2086162920, "Lcom/baidu/android/imsdk/utils/PinYinUtils;");
                return;
            }
        }
        pyComparator = new Comparator<PinYinObject>() { // from class: com.baidu.android.imsdk.utils.PinYinUtils.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(PinYinObject pinYinObject, PinYinObject pinYinObject2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, pinYinObject, pinYinObject2)) == null) ? pinYinObject.getPy().compareToIgnoreCase(pinYinObject2.getPy()) : invokeLL.intValue;
            }
        };
    }

    public PinYinUtils() {
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

    public static String getPinYin(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            ArrayList<HanziToPinyin.Token> arrayList = HanziToPinyin.getInstance().get(str);
            StringBuilder sb = new StringBuilder();
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<HanziToPinyin.Token> it = arrayList.iterator();
                while (it.hasNext()) {
                    HanziToPinyin.Token next = it.next();
                    if (2 == next.type) {
                        sb.append(next.target);
                    } else {
                        sb.append(next.source);
                    }
                }
            }
            return sb.toString().toLowerCase();
        }
        return (String) invokeL.objValue;
    }

    public static String getPy(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str == null) {
                return null;
            }
            return "".equals(str) ? str : getPinYin(str);
        }
        return (String) invokeL.objValue;
    }

    public static void sortByPinYin(List<? extends PinYinObject> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list) == null) || list == null) {
            return;
        }
        Collections.sort(list, pyComparator);
    }
}
