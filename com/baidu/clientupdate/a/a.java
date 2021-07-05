package com.baidu.clientupdate.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class a implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f4604a;

    /* renamed from: b  reason: collision with root package name */
    public String f4605b;

    /* renamed from: c  reason: collision with root package name */
    public String f4606c;

    /* renamed from: d  reason: collision with root package name */
    public String f4607d;

    /* renamed from: e  reason: collision with root package name */
    public JSONArray f4608e;

    /* renamed from: f  reason: collision with root package name */
    public JSONArray f4609f;

    /* renamed from: g  reason: collision with root package name */
    public JSONArray f4610g;

    /* renamed from: h  reason: collision with root package name */
    public JSONArray f4611h;

    /* renamed from: i  reason: collision with root package name */
    public JSONArray f4612i;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public a(String str, String str2, String str3, String str4, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, JSONArray jSONArray4, JSONArray jSONArray5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, jSONArray, jSONArray2, jSONArray3, jSONArray4, jSONArray5};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f4605b = str;
        this.f4607d = str2;
        this.f4604a = str3;
        this.f4606c = str4;
        this.f4608e = jSONArray;
        this.f4609f = jSONArray2;
        this.f4610g = jSONArray3;
        this.f4611h = jSONArray4;
        this.f4612i = jSONArray5;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f4604a : (String) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f4604a = str;
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f4606c : (String) invokeV.objValue;
    }

    public JSONArray c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f4608e : (JSONArray) invokeV.objValue;
    }

    public JSONArray d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f4609f : (JSONArray) invokeV.objValue;
    }

    public JSONArray e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f4610g : (JSONArray) invokeV.objValue;
    }

    public JSONArray f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f4611h : (JSONArray) invokeV.objValue;
    }

    public JSONArray g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f4612i : (JSONArray) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "LogModel{sessioninfo='" + this.f4604a + "', ug='" + this.f4605b + "', nm='" + this.f4606c + "', flag='" + this.f4607d + "', stm=" + this.f4608e + ", sc=" + this.f4609f + ", etm=" + this.f4610g + ", mg=" + this.f4611h + ", ex=" + this.f4612i + '}';
        }
        return (String) invokeV.objValue;
    }
}
