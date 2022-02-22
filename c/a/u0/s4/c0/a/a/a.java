package c.a.u0.s4.c0.a.a;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import c.a.d.f.p.n;
import c.a.t0.t.c.o0;
import c.a.u0.s4.j;
import c.a.u0.z3.t0.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NewVcodeView a;

    /* renamed from: b  reason: collision with root package name */
    public final NewWriteModel f22023b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f22024c;

    /* renamed from: d  reason: collision with root package name */
    public PostWriteCallBackData f22025d;

    /* renamed from: e  reason: collision with root package name */
    public final NewWriteModel.g f22026e;

    /* renamed from: f  reason: collision with root package name */
    public NewWriteModel.g f22027f;

    /* renamed from: c.a.u0.s4.c0.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1360a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1360a(a aVar) {
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, o0 o0Var, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, o0Var, writeData, antiData}) == null) || this.a.a == null) {
                return;
            }
            this.a.a.showPostThreadLoadingView(false);
            if (z) {
                this.a.f22025d = postWriteCallBackData;
                this.a.f22024c = true;
                String str3 = null;
                if (o0Var == null || o0Var.a() == null) {
                    str = null;
                    str2 = null;
                } else {
                    String str4 = o0Var.a().endPoint;
                    String str5 = o0Var.a().successImg;
                    str2 = o0Var.a().slideEndPoint;
                    str = str4;
                    str3 = str5;
                }
                this.a.a.runJsMethod("success", str3 + "," + str + "," + str2);
            } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                if (this.a.f22027f != null) {
                    this.a.f22027f.callback(false, postWriteCallBackData, o0Var, writeData, antiData);
                }
            } else {
                this.a.a.getContext().setVisible(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.a.getContext().getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
            }
        }
    }

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newVcodeView, newWriteModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        C1360a c1360a = new C1360a(this);
        this.f22026e = c1360a;
        this.a = newVcodeView;
        this.f22023b = newWriteModel;
        newWriteModel.l0(c1360a);
    }

    @Override // c.a.u0.s4.c0.a.a.b
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.a.setRatio(0.9433962f);
            this.a.showWebView(false);
            this.a.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
        }
    }

    @Override // c.a.u0.s4.c0.a.a.b
    public boolean b(WebView webView, String str) {
        InterceptResult invokeLL;
        WriteData Z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str)) == null) {
            if (this.f22023b.Z() == null || StringUtils.isNull(str) || (Z = this.f22023b.Z()) == null) {
                return false;
            }
            if (str.contains("objc:loadReady")) {
                if (Z.getVcodeExtra() == null) {
                    return false;
                }
                this.a.runJsMethod("handleFreshCaptcha", "'" + Z.getVcodeUrl() + "','" + Z.getVcodeExtra().slideImg + "','" + Z.getVcodeExtra().textImg + "'");
                return true;
            } else if (str.contains("objc:jsChangePosition")) {
                j(c.a.t0.e1.a.a(str));
                return true;
            } else if (str.contains("objc:finish")) {
                if (Z != null && Z.getVideoReviewType() == 1) {
                    NewVcodeView newVcodeView = this.a;
                    newVcodeView.showToast(true, newVcodeView.getContext().getResources().getString(j.video_send_success_under_review));
                } else if (Z != null && Z.getVideoReviewType() == 2) {
                    NewVcodeView newVcodeView2 = this.a;
                    newVcodeView2.showToast(true, newVcodeView2.getContext().getResources().getString(j.video_send_success));
                } else {
                    String string = this.a.getContext().getResources().getString(j.send_success);
                    PostWriteCallBackData postWriteCallBackData = this.f22025d;
                    String str3 = null;
                    if (postWriteCallBackData != null) {
                        str3 = postWriteCallBackData.getPreMsg();
                        str2 = this.f22025d.getColorMsg();
                        string = this.f22025d.getErrorString();
                    } else {
                        str2 = null;
                    }
                    if (Z.getType() != 7) {
                        h.b(this.a.getContext().getActivity(), string, str3, str2);
                    }
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", this.f22025d);
                intent.putExtras(bundle);
                BaseActivity context = this.a.getContext();
                this.a.getContext();
                context.setResult(-1, intent);
                this.a.getContext().finish();
                return true;
            } else if (!str.contains("objc:jumpToFeedback()") || WriteActivityConfig.isAsyncWriting()) {
                return false;
            } else {
                WriteActivityConfig.newInstance(this.a.getContext()).setType(0).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setIsVcodeFeedBack().send();
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.u0.s4.c0.a.a.b
    public void c(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            this.f22027f = gVar;
        }
    }

    @Override // c.a.u0.s4.c0.a.a.b
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.showPostThreadLoadingView(false);
            this.f22023b.cancelLoadData();
        }
    }

    @Override // c.a.u0.s4.c0.a.a.b
    public void e(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, str) == null) {
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (!n.C()) {
                this.a.getContext().showToast(j.neterror);
                this.a.getContext().finish();
            } else if (!StringUtils.isNull(str)) {
                this.a.showPostThreadLoadingView(true);
                this.f22023b.Z().setVcode(str);
                this.f22023b.Z().setVcodeType("5");
                this.f22023b.p0();
            } else {
                this.a.getContext().showToast(j.neterror);
                this.a.getContext().finish();
            }
        }
    }

    @Override // c.a.u0.s4.c0.a.a.b
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // c.a.u0.s4.c0.a.a.b
    public void onPageFinished(WebView webView, String str) {
        NewVcodeView newVcodeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, webView, str) == null) || (newVcodeView = this.a) == null) {
            return;
        }
        newVcodeView.showWebViewDelay(1000);
    }
}
