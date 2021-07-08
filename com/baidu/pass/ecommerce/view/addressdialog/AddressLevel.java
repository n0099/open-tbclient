package com.baidu.pass.ecommerce.view.addressdialog;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class AddressLevel {
    public static final /* synthetic */ AddressLevel[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final AddressLevel CITY;
    public static final AddressLevel COUNTRY;
    public static final AddressLevel DISTRICT;
    public static final AddressLevel PROVINCE;
    public static final AddressLevel TOWN;
    public transient /* synthetic */ FieldHolder $fh;
    public String name;
    public int value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(200367373, "Lcom/baidu/pass/ecommerce/view/addressdialog/AddressLevel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(200367373, "Lcom/baidu/pass/ecommerce/view/addressdialog/AddressLevel;");
                return;
            }
        }
        COUNTRY = new AddressLevel("COUNTRY", 0, 0, "country");
        PROVINCE = new AddressLevel("PROVINCE", 1, 1, "province");
        CITY = new AddressLevel("CITY", 2, 2, "city");
        DISTRICT = new AddressLevel("DISTRICT", 3, 3, "county");
        AddressLevel addressLevel = new AddressLevel("TOWN", 4, 4, "town");
        TOWN = addressLevel;
        $VALUES = new AddressLevel[]{COUNTRY, PROVINCE, CITY, DISTRICT, addressLevel};
    }

    public AddressLevel(String str, int i2, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.value = i3;
        this.name = str2;
    }

    public static AddressLevel valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (AddressLevel) Enum.valueOf(AddressLevel.class, str) : (AddressLevel) invokeL.objValue;
    }

    public static AddressLevel[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (AddressLevel[]) $VALUES.clone() : (AddressLevel[]) invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    public int getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.value : invokeV.intValue;
    }
}
