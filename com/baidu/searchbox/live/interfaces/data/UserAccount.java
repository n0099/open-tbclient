package com.baidu.searchbox.live.interfaces.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiAccount;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000B\u0007¢\u0006\u0004\b'\u0010(R$\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R$\u0010\u000b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R0\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0016\u0010\u0005\"\u0004\b\u0017\u0010\u0007R$\u0010\u0018\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0003\u001a\u0004\b\u0019\u0010\u0005\"\u0004\b\u001a\u0010\u0007R$\u0010\u001b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001c\u0010\u0005\"\u0004\b\u001d\u0010\u0007R$\u0010\u001e\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001f\u0010\u0005\"\u0004\b \u0010\u0007R$\u0010!\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0003\u001a\u0004\b\"\u0010\u0005\"\u0004\b#\u0010\u0007R$\u0010$\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0003\u001a\u0004\b%\u0010\u0005\"\u0004\b&\u0010\u0007¨\u0006)"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/data/UserAccount;", "", "bduss", "Ljava/lang/String;", "getBduss", "()Ljava/lang/String;", "setBduss", "(Ljava/lang/String;)V", "displayname", "getDisplayname", "setDisplayname", "email", "getEmail", "setEmail", "Ljava/util/HashMap;", "extFields", "Ljava/util/HashMap;", "getExtFields", "()Ljava/util/HashMap;", "setExtFields", "(Ljava/util/HashMap;)V", "nickName", "getNickName", "setNickName", "phone", "getPhone", "setPhone", "protrait", "getProtrait", "setProtrait", SapiAccount.SAPI_ACCOUNT_PTOKEN, "getPtoken", "setPtoken", "uid", "getUid", "setUid", "uk", "getUk", "setUk", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class UserAccount {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String bduss;
    public String displayname;
    public String email;
    public HashMap<String, String> extFields;
    public String nickName;
    public String phone;
    public String protrait;
    public String ptoken;
    public String uid;
    public String uk;

    public UserAccount() {
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

    public final String getBduss() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.bduss : (String) invokeV.objValue;
    }

    public final String getDisplayname() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.displayname : (String) invokeV.objValue;
    }

    public final String getEmail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.email : (String) invokeV.objValue;
    }

    public final HashMap<String, String> getExtFields() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.extFields : (HashMap) invokeV.objValue;
    }

    public final String getNickName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.nickName : (String) invokeV.objValue;
    }

    public final String getPhone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.phone : (String) invokeV.objValue;
    }

    public final String getProtrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.protrait : (String) invokeV.objValue;
    }

    public final String getPtoken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.ptoken : (String) invokeV.objValue;
    }

    public final String getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.uid : (String) invokeV.objValue;
    }

    public final String getUk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.uk : (String) invokeV.objValue;
    }

    public final void setBduss(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.bduss = str;
        }
    }

    public final void setDisplayname(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.displayname = str;
        }
    }

    public final void setEmail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.email = str;
        }
    }

    public final void setExtFields(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, hashMap) == null) {
            this.extFields = hashMap;
        }
    }

    public final void setNickName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.nickName = str;
        }
    }

    public final void setPhone(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.phone = str;
        }
    }

    public final void setProtrait(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.protrait = str;
        }
    }

    public final void setPtoken(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.ptoken = str;
        }
    }

    public final void setUid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.uid = str;
        }
    }

    public final void setUk(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.uk = str;
        }
    }
}
