package com.baidu.platform.comapi.map;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
/* loaded from: classes2.dex */
public final class IndoorMapInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String[] c;
    public int[] d;
    public int e;
    public int f;
    public String g;

    public IndoorMapInfo(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.b = str2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IndoorMapInfo(String str, String str2, String[] strArr, int[] iArr, int i) {
        this(str, str2, strArr, iArr, i, 0, "");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, strArr, iArr, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (String) objArr2[1], (String[]) objArr2[2], (int[]) objArr2[3], ((Integer) objArr2[4]).intValue(), ((Integer) objArr2[5]).intValue(), (String) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IndoorMapInfo(String str, String str2, String[] strArr, int[] iArr, int i, int i2) {
        this(str, str2, strArr, iArr, i, i2, "");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, strArr, iArr, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (String) objArr2[1], (String[]) objArr2[2], (int[]) objArr2[3], ((Integer) objArr2[4]).intValue(), ((Integer) objArr2[5]).intValue(), (String) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public IndoorMapInfo(String str, String str2, String[] strArr, int[] iArr, int i, int i2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, strArr, iArr, Integer.valueOf(i), Integer.valueOf(i2), str3};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = str;
        this.b = str2;
        this.e = i;
        this.f = i2;
        if (strArr != null) {
            String[] strArr2 = (String[]) Array.newInstance(String.class, strArr.length);
            this.c = strArr2;
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        }
        if (iArr != null) {
            int[] iArr2 = new int[iArr.length];
            this.d = iArr2;
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        }
        this.g = str3;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == null || !(obj instanceof IndoorMapInfo)) {
                return false;
            }
            IndoorMapInfo indoorMapInfo = (IndoorMapInfo) obj;
            if (!TextUtils.equals(this.a, indoorMapInfo.a) || !TextUtils.equals(this.b, indoorMapInfo.b) || !Arrays.equals(this.c, indoorMapInfo.c)) {
                return false;
            }
            return Arrays.equals(this.d, indoorMapInfo.d);
        }
        return invokeL.booleanValue;
    }

    public String getBuildingId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public final int[] getFloorAttribute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (int[]) invokeV.objValue;
    }

    public String getFloorId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public final String[] getFloorList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (String[]) invokeV.objValue;
    }

    public String getIdrSearch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public int getIdrguide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public int getIndoorType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "IndoorMapInfo:building_id:" + this.a + ";floor_id:" + this.b + ";indoor_type:" + this.e + ";floor_list:" + Arrays.toString(this.c) + ";floor_attribute:" + Arrays.toString(this.d);
        }
        return (String) invokeV.objValue;
    }
}
