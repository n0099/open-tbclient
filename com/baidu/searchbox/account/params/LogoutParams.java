package com.baidu.searchbox.account.params;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class LogoutParams {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final UserAccountActionItem mLogoutSrc;

    /* renamed from: com.baidu.searchbox.account.params.LogoutParams$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public UserAccountActionItem mLogoutSrc;

        public Builder() {
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

        public LogoutParams build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.mLogoutSrc == null) {
                    this.mLogoutSrc = new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGOUT, UserAccountActionItem.UserAccountType.NATIVE, AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS);
                }
                return new LogoutParams(this, null);
            }
            return (LogoutParams) invokeV.objValue;
        }

        public Builder setLogoutSrc(UserAccountActionItem userAccountActionItem) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, userAccountActionItem)) == null) {
                this.mLogoutSrc = userAccountActionItem;
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    public /* synthetic */ LogoutParams(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            UserAccountActionItem userAccountActionItem = this.mLogoutSrc;
            if (userAccountActionItem != null) {
                return userAccountActionItem.toString();
            }
            return super.toString();
        }
        return (String) invokeV.objValue;
    }

    public LogoutParams(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLogoutSrc = builder.mLogoutSrc;
    }
}
