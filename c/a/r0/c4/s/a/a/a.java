package c.a.r0.c4.s.a.a;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import c.a.e.e.p.l;
import c.a.q0.t.c.k0;
import c.a.r0.j3.r0.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final NewVcodeView f16848a;

    /* renamed from: b  reason: collision with root package name */
    public final NewWriteModel f16849b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f16850c;

    /* renamed from: d  reason: collision with root package name */
    public PostWriteCallBackData f16851d;

    /* renamed from: e  reason: collision with root package name */
    public final NewWriteModel.g f16852e;

    /* renamed from: f  reason: collision with root package name */
    public NewWriteModel.g f16853f;

    /* renamed from: c.a.r0.c4.s.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0813a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f16854a;

        public C0813a(a aVar) {
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
            this.f16854a = aVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, k0 k0Var, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, k0Var, writeData, antiData}) == null) || this.f16854a.f16848a == null) {
                return;
            }
            this.f16854a.f16848a.showPostThreadLoadingView(false);
            if (z) {
                this.f16854a.f16851d = postWriteCallBackData;
                this.f16854a.f16850c = true;
                String str3 = null;
                if (k0Var == null || k0Var.a() == null) {
                    str = null;
                    str2 = null;
                } else {
                    String str4 = k0Var.a().endPoint;
                    String str5 = k0Var.a().successImg;
                    str2 = k0Var.a().slideEndPoint;
                    str = str4;
                    str3 = str5;
                }
                this.f16854a.f16848a.runJsMethod("success", str3 + "," + str + "," + str2);
            } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                if (this.f16854a.f16853f != null) {
                    this.f16854a.f16853f.callback(false, postWriteCallBackData, k0Var, writeData, antiData);
                }
            } else {
                this.f16854a.f16848a.getContext().setVisible(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.f16854a.f16848a.getContext().getActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData, postWriteCallBackData.getAccessState())));
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
        C0813a c0813a = new C0813a(this);
        this.f16852e = c0813a;
        this.f16848a = newVcodeView;
        this.f16849b = newWriteModel;
        newWriteModel.h0(c0813a);
    }

    @Override // c.a.r0.c4.s.a.a.b
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f16848a.setRatio(0.9433962f);
            this.f16848a.showWebView(false);
            this.f16848a.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
        }
    }

    @Override // c.a.r0.c4.s.a.a.b
    public boolean b(WebView webView, String str) {
        InterceptResult invokeLL;
        WriteData X;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str)) == null) {
            if (this.f16849b.X() == null || StringUtils.isNull(str) || (X = this.f16849b.X()) == null) {
                return false;
            }
            if (str.contains("objc:loadReady")) {
                if (X.getVcodeExtra() == null) {
                    return false;
                }
                this.f16848a.runJsMethod("handleFreshCaptcha", "'" + X.getVcodeUrl() + "','" + X.getVcodeExtra().slideImg + "','" + X.getVcodeExtra().textImg + "'");
                return true;
            } else if (str.contains("objc:jsChangePosition")) {
                j(c.a.q0.e1.a.a(str));
                return true;
            } else if (str.contains("objc:finish")) {
                if (X != null && X.getVideoReviewType() == 1) {
                    NewVcodeView newVcodeView = this.f16848a;
                    newVcodeView.showToast(true, newVcodeView.getContext().getResources().getString(R.string.video_send_success_under_review));
                } else if (X != null && X.getVideoReviewType() == 2) {
                    NewVcodeView newVcodeView2 = this.f16848a;
                    newVcodeView2.showToast(true, newVcodeView2.getContext().getResources().getString(R.string.video_send_success));
                } else {
                    String string = this.f16848a.getContext().getResources().getString(R.string.send_success);
                    PostWriteCallBackData postWriteCallBackData = this.f16851d;
                    String str3 = null;
                    if (postWriteCallBackData != null) {
                        str3 = postWriteCallBackData.getPreMsg();
                        str2 = this.f16851d.getColorMsg();
                        string = this.f16851d.getErrorString();
                    } else {
                        str2 = null;
                    }
                    if (X.getType() != 7) {
                        m.b(this.f16848a.getContext().getActivity(), string, str3, str2);
                    }
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", this.f16851d);
                intent.putExtras(bundle);
                BaseActivity context = this.f16848a.getContext();
                this.f16848a.getContext();
                context.setResult(-1, intent);
                this.f16848a.getContext().finish();
                return true;
            } else if (!str.contains("objc:jumpToFeedback()") || WriteActivityConfig.isAsyncWriting()) {
                return false;
            } else {
                WriteActivityConfig.newInstance(this.f16848a.getContext()).setType(0).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setIsVcodeFeedBack().send();
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.r0.c4.s.a.a.b
    public void c(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            this.f16853f = gVar;
        }
    }

    @Override // c.a.r0.c4.s.a.a.b
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f16848a.showPostThreadLoadingView(false);
            this.f16849b.cancelLoadData();
        }
    }

    @Override // c.a.r0.c4.s.a.a.b
    public void e(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, str) == null) {
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (!l.D()) {
                this.f16848a.getContext().showToast(R.string.neterror);
                this.f16848a.getContext().finish();
            } else if (!StringUtils.isNull(str)) {
                this.f16848a.showPostThreadLoadingView(true);
                this.f16849b.X().setVcode(str);
                this.f16849b.X().setVcodeType("5");
                this.f16849b.l0();
            } else {
                this.f16848a.getContext().showToast(R.string.neterror);
                this.f16848a.getContext().finish();
            }
        }
    }

    @Override // c.a.r0.c4.s.a.a.b
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // c.a.r0.c4.s.a.a.b
    public void onPageFinished(WebView webView, String str) {
        NewVcodeView newVcodeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, webView, str) == null) || (newVcodeView = this.f16848a) == null) {
            return;
        }
        newVcodeView.showWebViewDelay(1000);
    }
}
