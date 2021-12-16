package com.baidu.searchbox.account.params;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class LoginParams {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ANIM_LOGIN_LEFT_RIGHT = 10;
    public static final int ANIM_LOGIN_TOP_BOTTOM = 11;
    public transient /* synthetic */ FieldHolder $fh;
    public final String mCustomLoginCss;
    public final int mIntentFlags;
    public final String mLoginDialogTitle;
    public int mLoginMode;
    public final int mLoginPageAnim;
    public UserAccountActionItem mLoginSrc;
    public final String mLoginSrcToPass;
    public final boolean mNeedUserSettingForLogin;
    public final boolean mNoSupportGuestLogin;
    public final String mNormalAccountSubTitle;
    public final String mNormalAccountTitle;
    public final String mOauth;
    public final String mShareLoginDialogBgUrl;
    public final String mShareLoginDialogTitle;
    public final boolean mThirdLogin;
    public final boolean mVoiceLogin;

    /* renamed from: com.baidu.searchbox.account.params.LoginParams$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String mCustomLoginCss;
        public int mIntentFlags;
        public String mLoginDialogTitle;
        public int mLoginMode;
        public int mLoginPageAnim;
        public UserAccountActionItem mLoginSrc;
        public String mLoginSrcToPass;
        public boolean mNeedUserSettingForLogin;
        public boolean mNoSupportGuestLogin;
        public String mNormalAccountSubTitle;
        public String mNormalAccountTitle;
        public String mOauth;
        public String mShareLoginDialogBgUrl;
        public String mShareLoginDialogTitle;
        public boolean mThirdLogin;
        public boolean mVoiceLogin;

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
                    return;
                }
            }
            this.mLoginMode = 0;
            this.mIntentFlags = 0;
            this.mNeedUserSettingForLogin = false;
            this.mThirdLogin = true;
            this.mVoiceLogin = false;
            this.mNoSupportGuestLogin = false;
            this.mLoginDialogTitle = "登录一下，畅所欲言";
            this.mLoginSrcToPass = null;
            this.mShareLoginDialogTitle = "点击帐号，一键登录";
            this.mShareLoginDialogBgUrl = "";
            this.mCustomLoginCss = "";
            this.mNormalAccountTitle = "";
            this.mNormalAccountSubTitle = "";
        }

        public LoginParams build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.mLoginSrc == null) {
                    this.mLoginSrc = new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, "unknown");
                }
                int i2 = this.mLoginPageAnim;
                if (i2 != 10 && i2 != 11) {
                    this.mLoginPageAnim = 11;
                }
                return new LoginParams(this, null);
            }
            return (LoginParams) invokeV.objValue;
        }

        public Builder setCustomLoginCss(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.mCustomLoginCss = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setIntentFlags(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.mIntentFlags = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setLoginAnim(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                this.mLoginPageAnim = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setLoginDialogTitle(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.mLoginDialogTitle = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setLoginMode(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                this.mLoginMode = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setLoginSrc(UserAccountActionItem userAccountActionItem) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, userAccountActionItem)) == null) {
                this.mLoginSrc = userAccountActionItem;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setLoginSrcToPass(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.mLoginSrcToPass = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setNeedUserSettingForLogin(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
                this.mNeedUserSettingForLogin = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setNoSupportGuestLogin(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
                this.mNoSupportGuestLogin = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setNormalAccountTitle(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, str2)) == null) {
                this.mNormalAccountTitle = str;
                this.mNormalAccountSubTitle = str2;
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder setOauthParam(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                this.mOauth = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setShareLoginDialogBgUrl(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                this.mShareLoginDialogBgUrl = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setShareLoginDialogTitle(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
                this.mShareLoginDialogTitle = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setThirdLogin(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
                this.mThirdLogin = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setVoiceLogin(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
                this.mVoiceLogin = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }
    }

    public /* synthetic */ LoginParams(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public static LoginParams getDefaultParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new Builder().setLoginSrc(new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS)).build() : (LoginParams) invokeV.objValue;
    }

    public LoginParams(Builder builder) {
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
        this.mLoginMode = builder.mLoginMode;
        this.mLoginSrc = builder.mLoginSrc;
        this.mLoginPageAnim = builder.mLoginPageAnim;
        this.mIntentFlags = builder.mIntentFlags;
        this.mOauth = builder.mOauth;
        this.mNeedUserSettingForLogin = builder.mNeedUserSettingForLogin;
        this.mThirdLogin = builder.mThirdLogin;
        this.mVoiceLogin = builder.mVoiceLogin;
        this.mNoSupportGuestLogin = builder.mNoSupportGuestLogin;
        this.mLoginDialogTitle = builder.mLoginDialogTitle;
        this.mLoginSrcToPass = builder.mLoginSrcToPass;
        this.mShareLoginDialogTitle = builder.mShareLoginDialogTitle;
        this.mShareLoginDialogBgUrl = builder.mShareLoginDialogBgUrl;
        this.mCustomLoginCss = builder.mCustomLoginCss;
        this.mNormalAccountTitle = builder.mNormalAccountTitle;
        this.mNormalAccountSubTitle = builder.mNormalAccountSubTitle;
    }
}
