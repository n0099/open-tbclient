package com.baidu.sapi2.activity;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.a.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.NormalizeGuestAccountDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.result.NormalizeGuestAccountResult;
import com.baidu.sapi2.utils.PtokenStat;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class NormalizeGuestAccountActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_BDUSS = "EXTRA_BDUSS";
    public transient /* synthetic */ FieldHolder $fh;
    public NormalizeGuestAccountResult t;
    public String u;
    public SocialType v;

    public NormalizeGuestAccountActivity() {
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
        this.t = new NormalizeGuestAccountResult(this) { // from class: com.baidu.sapi2.activity.NormalizeGuestAccountActivity.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ NormalizeGuestAccountActivity f44809a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f44809a = this;
            }

            @Override // com.baidu.sapi2.result.NormalizeGuestAccountResult
            public void finishActivity() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.finishActivity();
                    this.f44809a.finish();
                    CoreViewRouter.getInstance().release();
                }
            }
        };
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? CoreViewRouter.getInstance().getNormalizeGuestAccountDTO() : (SapiWebDTO) invokeV.objValue;
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.init();
            this.t.activity = this;
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onBottomBackBtnClick();
            a();
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onClose();
            this.t.setResultCode(-301);
            this.t.setResultMsg("您已取消操作");
            b();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            try {
                setContentView(f.layout_sapi_sdk_webview_with_title_bar);
                this.u = getIntent().getStringExtra("EXTRA_BDUSS");
                SapiAccount accountFromBduss = SapiContext.getInstance().getAccountFromBduss(this.u);
                if (!TextUtils.isEmpty(this.u) && accountFromBduss != null) {
                    this.v = accountFromBduss.getSocialType();
                    init();
                    setupViews();
                    return;
                }
                this.t.setResultCode(-204);
                this.t.setResultMsg("参数错误，请稍后再试");
                b();
            } catch (Throwable th) {
                reportWebviewError(th);
                this.t.setResultCode(-202);
                this.t.setResultMsg("网络连接失败，请检查网络设置");
                b();
            }
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onLeftBtnClick();
            if (this.executeSubClassMethod) {
                a();
            }
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.setupViews();
            this.sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback(this) { // from class: com.baidu.sapi2.activity.NormalizeGuestAccountActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ NormalizeGuestAccountActivity f44810a;

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
                    this.f44810a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
                public void onBack() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f44810a.a();
                    }
                }
            });
            this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback(this) { // from class: com.baidu.sapi2.activity.NormalizeGuestAccountActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ NormalizeGuestAccountActivity f44811a;

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
                    this.f44811a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f44811a.onClose();
                    }
                }
            });
            ArrayList arrayList = new ArrayList();
            NormalizeGuestAccountDTO normalizeGuestAccountDTO = CoreViewRouter.getInstance().getNormalizeGuestAccountDTO();
            if (normalizeGuestAccountDTO != null) {
                if (WebLoginDTO.statExtraValid(normalizeGuestAccountDTO.statExtra)) {
                    arrayList.add(new PassNameValuePair("extrajson", WebLoginDTO.getStatExtraDecode(normalizeGuestAccountDTO.statExtra)));
                }
                str = normalizeGuestAccountDTO.description;
            } else {
                str = "";
            }
            this.sapiWebView.setNormalizeGuestAccountCallback(new SapiJsCallBacks.NormalizeGuestAccountCallback(this) { // from class: com.baidu.sapi2.activity.NormalizeGuestAccountActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ NormalizeGuestAccountActivity f44812a;

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
                    this.f44812a = this;
                }

                @Override // com.baidu.sapi2.SapiJsCallBacks.NormalizeGuestAccountCallback
                public void onFailure(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                        this.f44812a.t.setResultCode(i2);
                        this.f44812a.t.setResultMsg(str2);
                        this.f44812a.b();
                    }
                }

                @Override // com.baidu.sapi2.SapiJsCallBacks.NormalizeGuestAccountCallback
                public void onSuccess(boolean z, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str2) == null) {
                        this.f44812a.t.isAccountMerge = z;
                        this.f44812a.t.setNormalizeWay(str2);
                        this.f44812a.t.setResultCode(0);
                        this.f44812a.t.setResultMsg("成功");
                        this.f44812a.c();
                        new PtokenStat().onEvent(PtokenStat.NORMAL_GUEST);
                    }
                }
            }, str);
            setNewLoginTitleAndSetStyleChangeCallBack();
            this.sapiWebView.loadNormalizeGuestAccount(arrayList, this.u, this.v);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            SapiWebView sapiWebView = this.sapiWebView;
            if (sapiWebView != null && sapiWebView.canGoBack()) {
                this.sapiWebView.goBack();
            } else {
                onClose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            if (CoreViewRouter.getInstance().getNormalizeGuestAccountCallback() != null) {
                CoreViewRouter.getInstance().getNormalizeGuestAccountCallback().onFailure(this.t);
            }
            finish();
            CoreViewRouter.getInstance().release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            if (CoreViewRouter.getInstance().getNormalizeGuestAccountCallback() != null) {
                CoreViewRouter.getInstance().getNormalizeGuestAccountCallback().onSuccess(this.t);
            }
            NormalizeGuestAccountDTO normalizeGuestAccountDTO = CoreViewRouter.getInstance().getNormalizeGuestAccountDTO();
            if (normalizeGuestAccountDTO == null || !normalizeGuestAccountDTO.finishActivityAfterSuc) {
                return;
            }
            finish();
            CoreViewRouter.getInstance().release();
        }
    }
}
