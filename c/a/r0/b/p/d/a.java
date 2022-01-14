package c.a.r0.b.p.d;

import androidx.core.view.InputDeviceCompat;
import c.a.r0.b.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public String f10178b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10179c;

    /* renamed from: d  reason: collision with root package name */
    public String f10180d;

    /* renamed from: e  reason: collision with root package name */
    public int f10181e;

    /* renamed from: f  reason: collision with root package name */
    public String f10182f;

    /* renamed from: g  reason: collision with root package name */
    public String f10183g;

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

    public String a() {
        InterceptResult invokeV;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = this.f10180d;
            int hashCode = str.hashCode();
            if (hashCode == 2154) {
                if (str.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CMCC)) {
                    c2 = 2;
                }
                c2 = 65535;
            } else if (hashCode != 2161) {
                if (hashCode == 2162 && str.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CUCC)) {
                    c2 = 1;
                }
                c2 = 65535;
            } else {
                if (str.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CTCC)) {
                    c2 = 0;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                this.f10183g = AppRuntime.getAppContext().getString(h.account_onekey_login_dx_agree_text);
            } else if (c2 == 1) {
                this.f10183g = AppRuntime.getAppContext().getString(h.account_onekey_login_lt_agree_text);
            } else if (c2 != 2) {
                this.f10183g = "";
            } else {
                this.f10183g = AppRuntime.getAppContext().getString(h.account_onekey_login_yd_agree_text);
            }
            return this.f10183g;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String str = this.f10180d;
            int hashCode = str.hashCode();
            if (hashCode == 2154) {
                if (str.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CMCC)) {
                    c2 = 2;
                }
                c2 = 65535;
            } else if (hashCode != 2161) {
                if (hashCode == 2162 && str.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CUCC)) {
                    c2 = 1;
                }
                c2 = 65535;
            } else {
                if (str.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CTCC)) {
                    c2 = 0;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                this.f10182f = "https://e.189.cn/sdk/agreement/detail.do?hidetop=true";
            } else if (c2 == 1) {
                this.f10182f = "https://ms.zzx9.cn/html/oauth/protocol2.html";
            } else if (c2 == 2) {
                this.f10182f = "https://wap.cmpassport.com/resources/html/contract.html";
            }
            return this.f10182f;
        }
        return (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f10178b : (String) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f10179c : invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f10181e : invokeV.intValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : invokeV.booleanValue;
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f10178b = str;
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f10179c = z;
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f10181e = i2;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.a = z;
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f10180d = str;
        }
    }
}
