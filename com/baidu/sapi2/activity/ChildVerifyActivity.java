package com.baidu.sapi2.activity;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.callback.AccountRealNameCallback;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ChildVerifyActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_EXTERNAL_URL = "external_url";
    public static final String u = "ChildVerifyActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public AccountRealNameCallback t;

    public ChildVerifyActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            try {
                this.t = CoreViewRouter.getInstance().getAccountRealNameCallback();
                CoreViewRouter.getInstance().releaseAccountRealNameCallback();
                setContentView(R.layout.obfuscated_res_0x7f0d0508);
                setupViews();
            } catch (Throwable th) {
                reportWebviewError(th);
            }
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.setupViews();
            this.sapiWebView.setWebviewPageFinishCallback(new SapiJsCallBacks.WebviewPageFinishCallback(this) { // from class: com.baidu.sapi2.activity.ChildVerifyActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChildVerifyActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.SapiJsCallBacks.WebviewPageFinishCallback
                public void onFinish(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                        Log.d(ChildVerifyActivity.u, "WebviewPageFinishCallback onFinish result=" + str);
                        if (this.a.t != null) {
                            AccountRealNameResult accountRealNameResult = new AccountRealNameResult();
                            JSONObject jSONObject = null;
                            try {
                                jSONObject = new JSONObject(str);
                            } catch (JSONException e) {
                                Log.e(e);
                            }
                            if (jSONObject != null) {
                                accountRealNameResult.setResultCode(0);
                                accountRealNameResult.setResultMsg("成功");
                                accountRealNameResult.callbackkey = jSONObject.optString("callbackKey");
                            } else {
                                accountRealNameResult.setResultCode(-202);
                                accountRealNameResult.setResultMsg("网络连接失败，请检查网络设置");
                            }
                            this.a.t.onFinish(accountRealNameResult);
                        }
                        this.a.finish();
                    }
                }
            });
            this.sapiWebView.loadUrl(getIntent().getStringExtra("external_url"));
        }
    }
}
