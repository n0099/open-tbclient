package c.a.p0.b4.j;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import c.a.e.e.p.l;
import c.a.o0.t.c.k0;
import c.a.p0.i3.q0.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.accountAccess.AccountAccessActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b f15880a;

    /* renamed from: b  reason: collision with root package name */
    public final NewWriteModel f15881b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f15882c;

    /* renamed from: d  reason: collision with root package name */
    public final NewWriteModel.g f15883d;

    /* renamed from: c.a.p0.b4.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0759a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f15884a;

        public C0759a(a aVar) {
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
            this.f15884a = aVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, k0 k0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, k0Var, writeData, antiData}) == null) || this.f15884a.f15880a == null || this.f15884a.f15881b == null || this.f15884a.f15881b.X() == null) {
                return;
            }
            this.f15884a.f15880a.p(false);
            if (writeData == null) {
                writeData = this.f15884a.f15881b.X();
            }
            WriteData writeData2 = writeData;
            if (z) {
                this.f15884a.f15882c = true;
                if (writeData2.getType() != 0 || writeData2.isUserFeedback()) {
                    if (postWriteCallBackData == null) {
                        m.b(this.f15884a.f15880a.g().getActivity(), this.f15884a.f15880a.g().getResources().getString(R.string.send_success), null, null);
                    } else {
                        m.b(this.f15884a.f15880a.g().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    }
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                BaseActivity g2 = this.f15884a.f15880a.g();
                this.f15884a.f15880a.g();
                g2.setResult(-1, intent);
                this.f15884a.f15880a.g().finish();
            } else if (writeData2 != null && k0Var != null && !TextUtils.isEmpty(k0Var.d())) {
                writeData2.setVcodeMD5(k0Var.b());
                writeData2.setVcodeUrl(k0Var.c());
                writeData2.setVcodeExtra(k0Var.a());
                this.f15884a.f15880a.g().setVisible(false);
                if (c.a.o0.c1.a.b(k0Var.d())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.f15884a.f15880a.g().getActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData2, false, k0Var.d())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.f15884a.f15880a.g().getActivity(), writeData2, CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE)));
                }
            } else if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                if (postWriteCallBackData != null) {
                    m.b(this.f15884a.f15880a.g().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    BaseActivity g3 = this.f15884a.f15880a.g();
                    this.f15884a.f15880a.g();
                    g3.setResult(0, null);
                }
                this.f15884a.f15880a.g().finish();
            } else {
                Intent intent2 = new Intent();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent2.putExtras(bundle2);
                BaseActivity g4 = this.f15884a.f15880a.g();
                this.f15884a.f15880a.g();
                g4.setResult(0, intent2);
                this.f15884a.f15880a.g().finish();
            }
        }
    }

    public a(b bVar, NewWriteModel newWriteModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, newWriteModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        C0759a c0759a = new C0759a(this);
        this.f15883d = c0759a;
        this.f15880a = bVar;
        this.f15881b = newWriteModel;
        newWriteModel.h0(c0759a);
    }

    public void d() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f15880a) == null) {
            return;
        }
        bVar.s(500);
    }

    public void e() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.f15880a) == null) {
            return;
        }
        bVar.p(false);
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (this.f15880a == null || str == null) {
                return false;
            }
            if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_CANCEL)) {
                this.f15880a.g().finish();
                return true;
            } else if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_INPUT_FOCUS)) {
                this.f15880a.o(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
                if (this.f15880a.h() != this.f15880a.i()) {
                    b bVar = this.f15880a;
                    bVar.n(bVar.h());
                    this.f15880a.t();
                }
                this.f15880a.j().setVisibility(0);
                return true;
            } else if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_VALID_SUCCESS)) {
                g();
                return true;
            } else if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_FEEDBACK_HTTP) || str.equals(AccountAccessActivity.ACCOUNT_ACCESS_FEEDBACK_HTTPS)) {
                this.f15880a.g().finish();
                UrlManager.getInstance().dealOneLink(this.f15880a.g().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
                return true;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f15880a == null || this.f15881b == null) {
            return;
        }
        if (!l.D()) {
            this.f15880a.g().showToast(R.string.neterror);
            this.f15880a.g().finish();
            return;
        }
        this.f15880a.p(true);
        this.f15881b.l0();
    }

    public void h(String str) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (bVar = this.f15880a) == null) {
            return;
        }
        bVar.q(true);
        this.f15880a.r(false);
        this.f15880a.j().loadUrl(str);
    }
}
