package com.baidu.sapi2.enums;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class PortraitCategory {
    public static /* synthetic */ Interceptable $ic;
    public static final PortraitCategory NEW;
    public static final PortraitCategory NORMAL;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ PortraitCategory[] f44660b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f44661a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1211520563, "Lcom/baidu/sapi2/enums/PortraitCategory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1211520563, "Lcom/baidu/sapi2/enums/PortraitCategory;");
                return;
            }
        }
        NORMAL = new PortraitCategory("NORMAL", 0, "");
        PortraitCategory portraitCategory = new PortraitCategory("NEW", 1, "new");
        NEW = portraitCategory;
        f44660b = new PortraitCategory[]{NORMAL, portraitCategory};
    }

    public PortraitCategory(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f44661a = str2;
    }

    public static PortraitCategory valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PortraitCategory) Enum.valueOf(PortraitCategory.class, str) : (PortraitCategory) invokeL.objValue;
    }

    public static PortraitCategory[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PortraitCategory[]) f44660b.clone() : (PortraitCategory[]) invokeV.objValue;
    }

    public String getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f44661a : (String) invokeV.objValue;
    }
}
