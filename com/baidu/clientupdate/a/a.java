package com.baidu.clientupdate.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class a implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f38843a;

    /* renamed from: b  reason: collision with root package name */
    public String f38844b;

    /* renamed from: c  reason: collision with root package name */
    public String f38845c;

    /* renamed from: d  reason: collision with root package name */
    public String f38846d;

    /* renamed from: e  reason: collision with root package name */
    public JSONArray f38847e;

    /* renamed from: f  reason: collision with root package name */
    public JSONArray f38848f;

    /* renamed from: g  reason: collision with root package name */
    public JSONArray f38849g;

    /* renamed from: h  reason: collision with root package name */
    public JSONArray f38850h;

    /* renamed from: i  reason: collision with root package name */
    public JSONArray f38851i;

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
        this.f38844b = str;
        this.f38846d = str2;
        this.f38843a = str3;
        this.f38845c = str4;
        this.f38847e = jSONArray;
        this.f38848f = jSONArray2;
        this.f38849g = jSONArray3;
        this.f38850h = jSONArray4;
        this.f38851i = jSONArray5;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f38843a : (String) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f38843a = str;
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f38845c : (String) invokeV.objValue;
    }

    public JSONArray c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f38847e : (JSONArray) invokeV.objValue;
    }

    public JSONArray d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f38848f : (JSONArray) invokeV.objValue;
    }

    public JSONArray e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f38849g : (JSONArray) invokeV.objValue;
    }

    public JSONArray f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f38850h : (JSONArray) invokeV.objValue;
    }

    public JSONArray g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f38851i : (JSONArray) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "LogModel{sessioninfo='" + this.f38843a + ExtendedMessageFormat.QUOTE + ", ug='" + this.f38844b + ExtendedMessageFormat.QUOTE + ", nm='" + this.f38845c + ExtendedMessageFormat.QUOTE + ", flag='" + this.f38846d + ExtendedMessageFormat.QUOTE + ", stm=" + this.f38847e + ", sc=" + this.f38848f + ", etm=" + this.f38849g + ", mg=" + this.f38850h + ", ex=" + this.f38851i + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
