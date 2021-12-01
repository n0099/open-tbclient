package c.a.r0.l4.j;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import c.a.d.f.p.l;
import c.a.q0.t.c.m0;
import c.a.r0.t3.s0.m;
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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b a;

    /* renamed from: b  reason: collision with root package name */
    public final NewWriteModel f19479b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f19480c;

    /* renamed from: d  reason: collision with root package name */
    public final NewWriteModel.g f19481d;

    /* renamed from: c.a.r0.l4.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1161a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1161a(a aVar) {
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

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, m0 m0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m0Var, writeData, antiData}) == null) || this.a.a == null || this.a.f19479b == null || this.a.f19479b.Y() == null) {
                return;
            }
            this.a.a.o(false);
            if (writeData == null) {
                writeData = this.a.f19479b.Y();
            }
            WriteData writeData2 = writeData;
            if (z) {
                this.a.f19480c = true;
                if (writeData2.getType() != 0 || writeData2.isUserFeedback()) {
                    if (postWriteCallBackData == null) {
                        m.b(this.a.a.getContext().getActivity(), this.a.a.getContext().getResources().getString(R.string.send_success), null, null);
                    } else {
                        m.b(this.a.a.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    }
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                BaseActivity context = this.a.a.getContext();
                this.a.a.getContext();
                context.setResult(-1, intent);
                this.a.a.getContext().finish();
            } else if (writeData2 != null && m0Var != null && !TextUtils.isEmpty(m0Var.d())) {
                writeData2.setVcodeMD5(m0Var.b());
                writeData2.setVcodeUrl(m0Var.c());
                writeData2.setVcodeExtra(m0Var.a());
                this.a.a.getContext().setVisible(false);
                if (c.a.q0.e1.a.b(m0Var.d())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.a.getContext().getActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData2, false, m0Var.d())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.a.getContext().getActivity(), writeData2, CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE)));
                }
            } else if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                if (postWriteCallBackData != null) {
                    m.b(this.a.a.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    BaseActivity context2 = this.a.a.getContext();
                    this.a.a.getContext();
                    context2.setResult(0, null);
                }
                this.a.a.getContext().finish();
            } else {
                Intent intent2 = new Intent();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent2.putExtras(bundle2);
                BaseActivity context3 = this.a.a.getContext();
                this.a.a.getContext();
                context3.setResult(0, intent2);
                this.a.a.getContext().finish();
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
        C1161a c1161a = new C1161a(this);
        this.f19481d = c1161a;
        this.a = bVar;
        this.f19479b = newWriteModel;
        newWriteModel.j0(c1161a);
    }

    public void d() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.a) == null) {
            return;
        }
        bVar.r(500);
    }

    public void e() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.a) == null) {
            return;
        }
        bVar.o(false);
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (this.a == null || str == null) {
                return false;
            }
            if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_CANCEL)) {
                this.a.getContext().finish();
                return true;
            } else if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_INPUT_FOCUS)) {
                this.a.n(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
                if (this.a.g() != this.a.h()) {
                    b bVar = this.a;
                    bVar.m(bVar.g());
                    this.a.s();
                }
                this.a.i().setVisibility(0);
                return true;
            } else if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_VALID_SUCCESS)) {
                g();
                return true;
            } else if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_FEEDBACK_HTTP) || str.equals(AccountAccessActivity.ACCOUNT_ACCESS_FEEDBACK_HTTPS)) {
                this.a.getContext().finish();
                UrlManager.getInstance().dealOneLink(this.a.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
                return true;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.a == null || this.f19479b == null) {
            return;
        }
        if (!l.C()) {
            this.a.getContext().showToast(R.string.neterror);
            this.a.getContext().finish();
            return;
        }
        this.a.o(true);
        this.f19479b.n0();
    }

    public void h(String str) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (bVar = this.a) == null) {
            return;
        }
        bVar.p(true);
        this.a.q(false);
        this.a.i().loadUrl(str);
    }
}
