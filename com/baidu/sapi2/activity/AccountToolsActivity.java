package com.baidu.sapi2.activity;

import android.app.Activity;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.callback.AccountToolsCallback;
import com.baidu.sapi2.dto.AccountCenterDTO;
import com.baidu.sapi2.result.AccountCenterResult;
import com.baidu.sapi2.result.AccountToolsResult;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.SapiHost;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.x;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class AccountToolsActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_ACCOUNT_TOOLS_TYPE = "ACCOUNT_TOOLS_TYPE";
    public static final String EXTRA_SWEEP_LIGHT_LOADING = "sweepLightLoading";
    public transient /* synthetic */ FieldHolder $fh;
    public AccountToolsResult a;

    /* renamed from: b  reason: collision with root package name */
    public AccountToolsCallback f39118b;

    public AccountToolsActivity() {
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
        this.a = new AccountToolsResult();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            int intExtra = getIntent().getIntExtra(EXTRA_ACCOUNT_TOOLS_TYPE, -1);
            this.f39118b = CoreViewRouter.getInstance().getAccountToolsCallback();
            AccountCenterDTO accountCenterDTO = new AccountCenterDTO();
            accountCenterDTO.accountToolsUrl = a(intExtra);
            accountCenterDTO.sweepLightLoading = getIntent().getBooleanExtra(EXTRA_SWEEP_LIGHT_LOADING, false);
            CoreViewRouter.getInstance().loadAccountCenter(new AccountCenterCallback(this) { // from class: com.baidu.sapi2.activity.AccountToolsActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AccountToolsActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.callback.AccountCenterCallback
                public void onFinish(AccountCenterResult accountCenterResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, accountCenterResult) == null) {
                        this.a.a.setResultCode(accountCenterResult.getResultCode());
                        this.a.a.setResultMsg(accountCenterResult.getResultMsg());
                        this.a.a();
                    }
                }

                @Override // com.baidu.sapi2.callback.AccountCenterCallback
                public void onSocialBind(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    }
                }
            }, accountCenterDTO);
            LogUtil.logActivity(this, "onCreate");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            AccountToolsCallback accountToolsCallback = this.f39118b;
            if (accountToolsCallback != null) {
                accountToolsCallback.onFinish(this.a);
            }
            finish();
        }
    }

    private String a(int i2) {
        InterceptResult invokeI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) {
            HashMap hashMap = new HashMap();
            if (i2 == 1) {
                str = "/wp/v3/ucenter/accountfreezeapply";
            } else if (i2 == 2) {
                str = "/wp/v3/ucenter/findaccback";
            } else if (i2 == 3) {
                str = "/wp/v3/ucenter/accountcancelpage";
            } else if (i2 == 4) {
                str = "/v4/appeal/";
            } else if (i2 == 5) {
                hashMap.put(x.o, SapiHost.getHost(SapiHost.DOMAIN_BAIDU_HTTPS_URL) + "?__wp-action=modify-pwd");
                hashMap.put(SpeedStatsUtils.UBC_VALUE_BANNER, "1");
                str = "/wp/wappassword";
            } else {
                throw new RuntimeException("account tools type is not support");
            }
            SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
            String str2 = sapiConfiguration.environment.getWap() + str + "?" + ParamsUtil.buildH5CommonParams(sapiConfiguration);
            return !hashMap.isEmpty() ? ParamsUtil.addExtras(str2, hashMap) : str2;
        }
        return (String) invokeI.objValue;
    }
}
