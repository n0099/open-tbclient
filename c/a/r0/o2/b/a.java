package c.a.r0.o2.b;

import android.content.Intent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.h;
import c.a.q0.s.l.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f20870b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.o2.b.b f20871c;

    /* renamed from: d  reason: collision with root package name */
    public BdAsyncTask<?, ?, ?> f20872d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.o2.b.c f20873e;

    /* renamed from: f  reason: collision with root package name */
    public String f20874f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f20875g;

    /* renamed from: h  reason: collision with root package name */
    public final a.InterfaceC0804a f20876h;

    /* renamed from: c.a.r0.o2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC1239a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20877e;

        public View$OnClickListenerC1239a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20877e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20877e.n(view);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SocialType f20878e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f20879f;

        public b(a aVar, SocialType socialType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, socialType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20879f = aVar;
            this.f20878e = socialType;
        }

        @Override // com.baidu.sapi2.shell.listener.WebAuthListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiAccount) == null) {
                this.f20879f.l();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, webAuthResult) == null) {
                this.f20879f.f20870b.closeLoadingDialog();
                BaseActivity baseActivity = this.f20879f.f20870b;
                baseActivity.showToast(String.format(baseActivity.getString(R.string.third_login_fail), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, webAuthResult) == null) {
                this.f20879f.f();
                DialogLoginHelper.addLoginDialogSuccessLog(DialogLoginHelper.getOneKeyLoginActivityLocate(), this.f20879f.f20874f, this.f20878e.name().toLowerCase());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements a.InterfaceC0804a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.q0.s.l.a.InterfaceC0804a
        public void onBeforeLogin(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.l();
            }
        }

        @Override // c.a.q0.s.l.a.InterfaceC0804a
        public void onFailure(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2, str2) == null) {
                this.a.f20870b.closeLoadingDialog();
                this.a.f20870b.showToast(str2);
            }
        }

        @Override // c.a.q0.s.l.a.InterfaceC0804a
        public void onSuccess(AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
                this.a.f20870b.closeLoadingDialog();
                this.a.e(accountData);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AccountData f20880e;

        public d(a aVar, AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, accountData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20880e = accountData;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.s.l.c.g(this.f20880e);
                c.a.q0.s.a0.a.a("account", -1L, 0, "login_activity_save_account_to_db", 0, "", new Object[0]);
            }
        }
    }

    public a(TbPageContext tbPageContext, c.a.r0.o2.b.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20875g = new View$OnClickListenerC1239a(this);
        this.f20876h = new c(this);
        this.a = tbPageContext;
        if (tbPageContext.getPageActivity() instanceof BaseActivity) {
            this.f20870b = (BaseActivity) tbPageContext.getPageActivity();
        }
        this.f20871c = bVar;
        this.f20874f = str;
        bVar.d(this.f20875g);
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f20870b.setResult(i2, new Intent());
            this.f20870b.finish();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            new LoginActivityConfig(this.f20870b, true, 25061).start();
        }
    }

    public final void e(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
            h(accountData);
            c.a.q0.s.a0.a.a("account", -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
            TbadkCoreApplication.getInst().onUserChanged(this.f20870b.getIntent());
            c(-1);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(Boolean.TRUE));
            SapiAccount session = SapiAccountManager.getInstance().getSession();
            if (session != null) {
                BdAsyncTask<?, ?, ?> bdAsyncTask = this.f20872d;
                if (bdAsyncTask != null) {
                    bdAsyncTask.cancel();
                }
                this.f20872d = c.a.q0.s.l.a.b().a(session.username, session.bduss, "", null, this.f20876h);
                return;
            }
            this.f20870b.closeLoadingDialog();
            c(0);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            m(SocialType.QQ_SSO);
        }
    }

    public final void h(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, accountData) == null) {
            h.a().c(new d(this, accountData));
            c.a.q0.s.a0.a.a("account", -1L, 0, "login_activity_save_account_to_application", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(accountData, this.a.getPageActivity());
            c.a.q0.m.a.f(TbadkCoreApplication.getInst());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921024, Boolean.TRUE));
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f20871c.b(z);
        }
    }

    public abstract void j(c.a.r0.o2.b.c cVar);

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f20871c.e(z);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.f20870b.getLoadingDialog() == null || !this.f20870b.getLoadingDialog().c()) {
                this.f20870b.showLoadingDialog(this.a.getString(R.string.sapi_logining));
                if (this.f20870b.getLoadingDialog() != null) {
                    this.f20870b.getLoadingDialog().f(false);
                    this.f20870b.getLoadingDialog().g(false);
                }
            }
        }
    }

    public final void m(SocialType socialType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, socialType) == null) {
            PassportSDK.getInstance().loadThirdPartyLogin(new b(this, socialType), socialType);
        }
    }

    public void n(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view) == null) {
            if (view.getId() == R.id.btn_close) {
                this.f20870b.finish();
            } else if (view.getId() == R.id.btn_skip) {
                this.f20870b.finish();
            } else if (view.getId() == R.id.qq_login_btn) {
                g();
            } else if (view.getId() == R.id.wechat_login_btn) {
                o();
            } else if (view.getId() == R.id.weibo_login_btn) {
                p();
            } else if (view.getId() == R.id.yy_login_btn) {
                q();
            } else if (view.getId() == R.id.more_login_btn) {
                d();
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            m(SocialType.WEIXIN);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            m(SocialType.SINA_WEIBO_SSO);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            m(SocialType.YY);
        }
    }
}
