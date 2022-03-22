package c.a.p0.u2.b;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class d extends c.a.p0.u2.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public class a extends OneKeyLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onFail(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, oneKeyLoginResult) == null) {
                this.a.f18951b.closeLoadingDialog();
                BaseActivity baseActivity = this.a.f18951b;
                baseActivity.showToast(String.format(baseActivity.getString(R.string.obfuscated_res_0x7f0f0cc0), Integer.valueOf(oneKeyLoginResult.getResultCode()), oneKeyLoginResult.getResultMsg()));
            }
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onGuideProcess(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oneKeyLoginResult) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onSuccess(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oneKeyLoginResult) == null) {
                DialogLoginHelper.addLoginDialogSuccessLog(DialogLoginHelper.getOneKeyLoginActivityLocate(), DialogLoginHelper.FULL_SCREEN_TYPE_ONE_KEY, DialogLoginHelper.FULL_SCREEN_TYPE_ONE_KEY);
                this.a.f();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext tbPageContext, b bVar) {
        super(tbPageContext, bVar, DialogLoginHelper.FULL_SCREEN_TYPE_ONE_KEY);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (b) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.u2.b.a
    public void j(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            this.f18954e = cVar;
        }
    }

    @Override // c.a.p0.u2.b.a
    public void n(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            super.n(view);
            if (view.getId() == R.id.obfuscated_res_0x7f091336) {
                s();
            } else if (view.getId() == R.id.obfuscated_res_0x7f09160d) {
                t();
            } else if (view.getId() == R.id.obfuscated_res_0x7f090167) {
                r();
            } else if (view.getId() == R.id.obfuscated_res_0x7f0918f7) {
                u();
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BaseActivity baseActivity = this.f18951b;
            new TbWebViewActivityConfig(baseActivity, baseActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0cb7), "https://passport.baidu.com/static/passpc-account/html/protocal.html", false).start();
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            l();
            PassportSDK passportSDK = PassportSDK.getInstance();
            BaseActivity baseActivity = this.f18951b;
            passportSDK.loadOneKeyLogin(baseActivity, c.a.p0.u2.c.b.h(baseActivity, this.f18954e.f18967c), new a(this));
        }
    }

    public final void t() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cVar = this.f18954e) == null) {
            return;
        }
        int a2 = cVar.a();
        if (a2 == 1) {
            BaseActivity baseActivity = this.f18951b;
            new TbWebViewActivityConfig(baseActivity, baseActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0cb8), "https://ms.zzx9.cn/html/oauth/protocol2.html", false).start();
        } else if (a2 == 2) {
            BaseActivity baseActivity2 = this.f18951b;
            new TbWebViewActivityConfig(baseActivity2, baseActivity2.getResources().getString(R.string.obfuscated_res_0x7f0f0cb9), "https://e.189.cn/sdk/agreement/detail.do?hidetop=true", false).start();
        } else if (a2 != 3) {
        } else {
            BaseActivity baseActivity3 = this.f18951b;
            new TbWebViewActivityConfig(baseActivity3, baseActivity3.getResources().getString(R.string.obfuscated_res_0x7f0f0cba), "https://wap.cmpassport.com/resources/html/contract.html", false).start();
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            BaseActivity baseActivity = this.f18951b;
            new TbWebViewActivityConfig(baseActivity, baseActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0cbb), "http://privacy.baidu.com/mdetail?id=288", false).start();
        }
    }
}
