package com.baidu.searchbox.live.goback;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\u0018\u0000B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\"\u0010\u000b\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\"\u0010\u000e\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007R\"\u0010\u0011\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0007R\"\u0010\u0014\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0005\"\u0004\b\u0016\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/live/goback/LiveGoBackBean;", "", "source", "Ljava/lang/String;", "getSource", "()Ljava/lang/String;", "setSource", "(Ljava/lang/String;)V", "userAvatar", "getUserAvatar", "setUserAvatar", "userBgUrl", "getUserBgUrl", "setUserBgUrl", "userPlayUrl", "getUserPlayUrl", "setUserPlayUrl", "userRoomId", "getUserRoomId", "setUserRoomId", "userScheme", "getUserScheme", "setUserScheme", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveGoBackBean {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String source;
    public String userAvatar;
    public String userBgUrl;
    public String userPlayUrl;
    public String userRoomId;
    public String userScheme;

    public LiveGoBackBean() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.userRoomId = "";
        this.userScheme = "";
        this.userAvatar = "";
        this.userBgUrl = "";
        this.userPlayUrl = "";
        this.source = "";
    }

    public final String getSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.source : (String) invokeV.objValue;
    }

    public final String getUserAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.userAvatar : (String) invokeV.objValue;
    }

    public final String getUserBgUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.userBgUrl : (String) invokeV.objValue;
    }

    public final String getUserPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.userPlayUrl : (String) invokeV.objValue;
    }

    public final String getUserRoomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.userRoomId : (String) invokeV.objValue;
    }

    public final String getUserScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.userScheme : (String) invokeV.objValue;
    }

    public final void setSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.source = str;
        }
    }

    public final void setUserAvatar(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.userAvatar = str;
        }
    }

    public final void setUserBgUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.userBgUrl = str;
        }
    }

    public final void setUserPlayUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.userPlayUrl = str;
        }
    }

    public final void setUserRoomId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.userRoomId = str;
        }
    }

    public final void setUserScheme(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.userScheme = str;
        }
    }
}
