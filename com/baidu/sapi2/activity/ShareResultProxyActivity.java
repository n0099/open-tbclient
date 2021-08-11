package com.baidu.sapi2.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareLoginModel;
import com.baidu.sapi2.share.ShareResultCallback;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class ShareResultProxyActivity extends Activity implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_EXTRA_PARAMS = "key_extra_params";
    public static final String KEY_PKG = "key_pkg";
    public static final String KEY_SESSION_ID = "key_session_id";
    public static final String KEY_TRACE_ID = "key_trace_id";
    public static final String KEY_URL = "key_url";
    public static final String KEY_VERSION = "key_version";

    /* renamed from: h  reason: collision with root package name */
    public static final String f44558h = "ShareResultProxyActivity";

    /* renamed from: i  reason: collision with root package name */
    public static final String f44559i = "key_launch_share_activity_status";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f44560a;

    /* renamed from: b  reason: collision with root package name */
    public String f44561b;

    /* renamed from: c  reason: collision with root package name */
    public String f44562c;

    /* renamed from: d  reason: collision with root package name */
    public String f44563d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<PassNameValuePair> f44564e;

    /* renamed from: f  reason: collision with root package name */
    public String f44565f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f44566g;

    public ShareResultProxyActivity() {
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

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.f44566g = true;
            this.f44560a = getIntent().getStringExtra(KEY_PKG);
            if (ShareLoginModel.getInstance().isMeetShareV4(this, this.f44560a)) {
                Log.d(f44558h, "openShareLogin: is meet share_v4");
                ShareLoginModel.getInstance().openV4ShareLogin(this, this.f44560a, "product");
                return;
            }
            Log.d(f44558h, "openShareLogin: is not share_v4");
            b();
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            Intent intent = getIntent();
            this.f44560a = intent.getStringExtra(KEY_PKG);
            this.f44561b = intent.getStringExtra("key_url");
            this.f44562c = intent.getStringExtra(KEY_TRACE_ID);
            this.f44563d = intent.getStringExtra("key_session_id");
            this.f44564e = (ArrayList) intent.getSerializableExtra(KEY_EXTRA_PARAMS);
            this.f44565f = intent.getStringExtra("key_version");
            new ShareCallPacking().startLoginShareActivityForResult(this, this.f44560a, this.f44561b, this.f44562c, this.f44563d, this.f44564e, this.f44565f, "product");
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 20001) {
                CoreViewRouter.getInstance().onShareLoginActivityResult(i2, i3, intent, "");
            } else if (i2 == 100004) {
                ShareLoginModel.getInstance().processShareResult(this, intent, new ShareResultCallback(this) { // from class: com.baidu.sapi2.activity.ShareResultProxyActivity.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ ShareResultProxyActivity f44567a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f44567a = this;
                    }

                    @Override // com.baidu.sapi2.share.ShareResultCallback
                    public void onResultAccount(SapiAccount sapiAccount) {
                        WebAuthListener webAuthListener;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, sapiAccount) == null) || (webAuthListener = CoreViewRouter.getInstance().getWebAuthListener()) == null) {
                            return;
                        }
                        WebAuthResult webAuthResult = new WebAuthResult();
                        if (sapiAccount == null) {
                            webAuthResult.setResultCode(-207);
                            webAuthResult.setResultMsg("互通登录失败,请稍后再试");
                            webAuthListener.onFailure(webAuthResult);
                            return;
                        }
                        webAuthResult.accountType = AccountType.NORMAL;
                        webAuthResult.setResultCode(0);
                        webAuthListener.onSuccess(webAuthResult);
                        CoreViewRouter.getInstance().release();
                    }
                });
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            Window window = getWindow();
            window.setGravity(51);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.x = 0;
            attributes.y = 0;
            attributes.width = 1;
            attributes.height = 1;
            attributes.type = 2002;
            attributes.flags = 32;
            window.setAttributes(attributes);
            if (bundle != null) {
                this.f44566g = bundle.getBoolean(f44559i, false);
            }
            if (this.f44566g) {
                return;
            }
            a();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            bundle.putBoolean(f44559i, this.f44566g);
            super.onSaveInstanceState(bundle);
        }
    }
}
