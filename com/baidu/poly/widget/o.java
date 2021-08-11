package com.baidu.poly.widget;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.face.base.b.c;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class o implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String Xd;
    public String Yd;
    public String Zd;
    public int _d;
    public int ae;
    public int be;
    public int ce;
    public long de;
    public String ee;
    public boolean fe;
    public int ge;
    public long he;
    public String icon;
    public String ie;
    public String je;
    public String pay_text;
    public int wa;

    public o(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.Xd = jSONObject.optString("display_name");
        this.Yd = jSONObject.optString(DI.PAY_CHANNEL);
        this.pay_text = jSONObject.optString("pay_text");
        this.Zd = jSONObject.optString("error_text");
        this.he = jSONObject.optLong("available_par_money");
        this.icon = jSONObject.optString("icon");
        this._d = jSONObject.optInt("is_fold");
        this.ae = jSONObject.optInt("is_selected");
        this.be = jSONObject.optInt("is_private");
        this.ce = jSONObject.optInt("free_pay");
        this.wa = jSONObject.optInt(c.l);
        this.ee = jSONObject.optString("display_color");
        this.fe = jSONObject.optBoolean("flow");
        this.ge = jSONObject.optInt("parasitifer");
        this.ie = jSONObject.optString("host_marketing_detail");
        this.de = jSONObject.optLong("pre_pay_money");
        this.je = jSONObject.optString("loading_icon");
    }

    public long L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.he : invokeV.longValue;
    }

    public String M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.ee : (String) invokeV.objValue;
    }

    public int N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.wa : invokeV.intValue;
    }

    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.ie : (String) invokeV.objValue;
    }

    public int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.ae : invokeV.intValue;
    }

    public String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.je : (String) invokeV.objValue;
    }

    public String R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.Yd : (String) invokeV.objValue;
    }

    public String S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.pay_text : (String) invokeV.objValue;
    }

    public String getDisplayName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.Xd : (String) invokeV.objValue;
    }

    public String getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.icon : (String) invokeV.objValue;
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.ae = i2;
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.ie = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return "PayChannelEntity{display_name='" + this.Xd + ExtendedMessageFormat.QUOTE + ", pay_channel='" + this.Yd + ExtendedMessageFormat.QUOTE + ", pay_text='" + this.pay_text + ExtendedMessageFormat.QUOTE + ", error_text='" + this.Zd + ExtendedMessageFormat.QUOTE + ", icon='" + this.icon + ExtendedMessageFormat.QUOTE + ", is_fold=" + this._d + ", is_selected=" + this.ae + ", is_private=" + this.be + ", free_pay=" + this.ce + ", pre_pay_money=" + this.de + ", enable=" + this.wa + ", display_color='" + this.ee + ExtendedMessageFormat.QUOTE + ", flow=" + this.fe + ", parasitifer=" + this.ge + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
