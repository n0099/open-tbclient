package com.baidu.tbadk.core.util;

import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class CurrentPageTypeHelper {
    public static /* synthetic */ Interceptable $ic;
    public static PageType currentPageType;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class PageType {
        public static final /* synthetic */ PageType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final PageType FLUTTER;
        public static final PageType NATIVE;
        public static final PageType NATIVE_WEB;
        public static final PageType NONE;
        public static final PageType OTHER;
        public static final PageType SMART_APP;
        public static final PageType WEB;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1977938530, "Lcom/baidu/tbadk/core/util/CurrentPageTypeHelper$PageType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1977938530, "Lcom/baidu/tbadk/core/util/CurrentPageTypeHelper$PageType;");
                    return;
                }
            }
            NATIVE = new PageType(Constant.TYPE_NATIVE, 0);
            FLUTTER = new PageType("FLUTTER", 1);
            WEB = new PageType("WEB", 2);
            SMART_APP = new PageType("SMART_APP", 3);
            OTHER = new PageType("OTHER", 4);
            NATIVE_WEB = new PageType("NATIVE_WEB", 5);
            PageType pageType = new PageType("NONE", 6);
            NONE = pageType;
            $VALUES = new PageType[]{NATIVE, FLUTTER, WEB, SMART_APP, OTHER, NATIVE_WEB, pageType};
        }

        public PageType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static PageType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PageType) Enum.valueOf(PageType.class, str) : (PageType) invokeL.objValue;
        }

        public static PageType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PageType[]) $VALUES.clone() : (PageType[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1865171915, "Lcom/baidu/tbadk/core/util/CurrentPageTypeHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1865171915, "Lcom/baidu/tbadk/core/util/CurrentPageTypeHelper;");
                return;
            }
        }
        currentPageType = PageType.NONE;
    }

    public CurrentPageTypeHelper() {
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
}
