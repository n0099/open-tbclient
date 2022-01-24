package c.a.t0.u.c;

import android.view.View;
import c.a.d.f.p.l;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.account.safeManage.AccountSafeModel;
import com.baidu.tieba.setting.im.more.ResponsedPrivacyHttpMessage;
import com.baidu.tieba.setting.im.more.ResponsedPrivacySocketMessage;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final BaseActivity f23841e;

    /* renamed from: f  reason: collision with root package name */
    public b f23842f;

    /* renamed from: g  reason: collision with root package name */
    public AccountSafeModel f23843g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.d.c.g.a f23844h;

    /* renamed from: c.a.t0.u.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1450a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1450a(a aVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (this.a.f23843g != null) {
                    this.a.f23843g.E(false);
                }
                this.a.f23841e.closeLoadingDialog();
                if (responsedMessage == null) {
                    return;
                }
                if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                    c.a.t0.n3.k.a.a privacyData = responsedMessage instanceof ResponsedPrivacyHttpMessage ? ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData() : null;
                    if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                        privacyData = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                    }
                    if (this.a.f23843g != null) {
                        this.a.f23843g.D(privacyData);
                    }
                    if (this.a.f23842f == null || this.a.f23843g == null || this.a.f23843g.x() == null) {
                        return;
                    }
                    this.a.f23842f.d(this.a.f23843g.x().f());
                    return;
                }
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    errorString = this.a.f23841e.getString(R.string.neterror);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                this.a.f23841e.showToast(errorString);
            }
        }
    }

    public a(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        C1450a c1450a = new C1450a(this, CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);
        this.f23844h = c1450a;
        this.f23841e = baseActivity;
        baseActivity.registerListener(c1450a);
        this.f23842f = new b(this.f23841e, this);
        this.f23843g = new AccountSafeModel(this.f23841e);
        if (l.z()) {
            g();
        } else {
            this.f23841e.showToast(R.string.neterror);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f23842f.a() : (View) invokeV.objValue;
    }

    public void e(int i2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (bVar = this.f23842f) == null) {
            return;
        }
        bVar.e(i2);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f23841e.closeLoadingDialog();
            AccountSafeModel accountSafeModel = this.f23843g;
            if (accountSafeModel != null) {
                accountSafeModel.cancelLoadData();
            }
            b bVar = this.f23842f;
            if (bVar != null) {
                bVar.c();
            }
        }
    }

    public final void g() {
        AccountSafeModel accountSafeModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (accountSafeModel = this.f23843g) == null || accountSafeModel.A()) {
            return;
        }
        this.f23843g.C();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            if (view.getId() == R.id.bar_record) {
                TiebaStatic.log("c10013");
                if (!l.z()) {
                    this.f23841e.showToast(R.string.neterror);
                } else {
                    UrlManager.getInstance().dealOneLink(this.f23841e.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
                }
            } else if (view.getId() == R.id.account_status) {
                AccountSafeModel accountSafeModel = this.f23843g;
                AntiHelper.p(this.f23841e, accountSafeModel != null ? accountSafeModel.y() : "");
            }
        }
    }
}
