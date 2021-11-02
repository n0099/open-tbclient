package b.a.r0.d4.s.a.a;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import b.a.e.e.p.l;
import b.a.q0.t.c.m0;
import b.a.r0.l3.s0.m;
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
/* loaded from: classes4.dex */
public class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final NewVcodeView f16018a;

    /* renamed from: b  reason: collision with root package name */
    public final NewWriteModel f16019b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f16020c;

    /* renamed from: d  reason: collision with root package name */
    public PostWriteCallBackData f16021d;

    /* renamed from: e  reason: collision with root package name */
    public final NewWriteModel.g f16022e;

    /* renamed from: f  reason: collision with root package name */
    public NewWriteModel.g f16023f;

    /* renamed from: b.a.r0.d4.s.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0816a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f16024a;

        public C0816a(a aVar) {
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
            this.f16024a = aVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, m0 m0Var, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m0Var, writeData, antiData}) == null) || this.f16024a.f16018a == null) {
                return;
            }
            this.f16024a.f16018a.showPostThreadLoadingView(false);
            if (z) {
                this.f16024a.f16021d = postWriteCallBackData;
                this.f16024a.f16020c = true;
                String str3 = null;
                if (m0Var == null || m0Var.a() == null) {
                    str = null;
                    str2 = null;
                } else {
                    String str4 = m0Var.a().endPoint;
                    String str5 = m0Var.a().successImg;
                    str2 = m0Var.a().slideEndPoint;
                    str = str4;
                    str3 = str5;
                }
                this.f16024a.f16018a.runJsMethod("success", str3 + "," + str + "," + str2);
            } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                if (this.f16024a.f16023f != null) {
                    this.f16024a.f16023f.callback(false, postWriteCallBackData, m0Var, writeData, antiData);
                }
            } else {
                this.f16024a.f16018a.getContext().setVisible(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.f16024a.f16018a.getContext().getActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData, postWriteCallBackData.getAccessState())));
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
        C0816a c0816a = new C0816a(this);
        this.f16022e = c0816a;
        this.f16018a = newVcodeView;
        this.f16019b = newWriteModel;
        newWriteModel.h0(c0816a);
    }

    @Override // b.a.r0.d4.s.a.a.b
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f16018a.setRatio(0.9433962f);
            this.f16018a.showWebView(false);
            this.f16018a.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
        }
    }

    @Override // b.a.r0.d4.s.a.a.b
    public boolean b(WebView webView, String str) {
        InterceptResult invokeLL;
        WriteData X;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str)) == null) {
            if (this.f16019b.X() == null || StringUtils.isNull(str) || (X = this.f16019b.X()) == null) {
                return false;
            }
            if (str.contains("objc:loadReady")) {
                if (X.getVcodeExtra() == null) {
                    return false;
                }
                this.f16018a.runJsMethod("handleFreshCaptcha", "'" + X.getVcodeUrl() + "','" + X.getVcodeExtra().slideImg + "','" + X.getVcodeExtra().textImg + "'");
                return true;
            } else if (str.contains("objc:jsChangePosition")) {
                j(b.a.q0.e1.a.a(str));
                return true;
            } else if (str.contains("objc:finish")) {
                if (X != null && X.getVideoReviewType() == 1) {
                    NewVcodeView newVcodeView = this.f16018a;
                    newVcodeView.showToast(true, newVcodeView.getContext().getResources().getString(R.string.video_send_success_under_review));
                } else if (X != null && X.getVideoReviewType() == 2) {
                    NewVcodeView newVcodeView2 = this.f16018a;
                    newVcodeView2.showToast(true, newVcodeView2.getContext().getResources().getString(R.string.video_send_success));
                } else {
                    String string = this.f16018a.getContext().getResources().getString(R.string.send_success);
                    PostWriteCallBackData postWriteCallBackData = this.f16021d;
                    String str3 = null;
                    if (postWriteCallBackData != null) {
                        str3 = postWriteCallBackData.getPreMsg();
                        str2 = this.f16021d.getColorMsg();
                        string = this.f16021d.getErrorString();
                    } else {
                        str2 = null;
                    }
                    if (X.getType() != 7) {
                        m.b(this.f16018a.getContext().getActivity(), string, str3, str2);
                    }
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", this.f16021d);
                intent.putExtras(bundle);
                BaseActivity context = this.f16018a.getContext();
                this.f16018a.getContext();
                context.setResult(-1, intent);
                this.f16018a.getContext().finish();
                return true;
            } else if (!str.contains("objc:jumpToFeedback()") || WriteActivityConfig.isAsyncWriting()) {
                return false;
            } else {
                WriteActivityConfig.newInstance(this.f16018a.getContext()).setType(0).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setIsVcodeFeedBack().send();
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // b.a.r0.d4.s.a.a.b
    public void c(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            this.f16023f = gVar;
        }
    }

    @Override // b.a.r0.d4.s.a.a.b
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f16018a.showPostThreadLoadingView(false);
            this.f16019b.cancelLoadData();
        }
    }

    @Override // b.a.r0.d4.s.a.a.b
    public void e(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, str) == null) {
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (!l.D()) {
                this.f16018a.getContext().showToast(R.string.neterror);
                this.f16018a.getContext().finish();
            } else if (!StringUtils.isNull(str)) {
                this.f16018a.showPostThreadLoadingView(true);
                this.f16019b.X().setVcode(str);
                this.f16019b.X().setVcodeType("5");
                this.f16019b.l0();
            } else {
                this.f16018a.getContext().showToast(R.string.neterror);
                this.f16018a.getContext().finish();
            }
        }
    }

    @Override // b.a.r0.d4.s.a.a.b
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // b.a.r0.d4.s.a.a.b
    public void onPageFinished(WebView webView, String str) {
        NewVcodeView newVcodeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, webView, str) == null) || (newVcodeView = this.f16018a) == null) {
            return;
        }
        newVcodeView.showWebViewDelay(1000);
    }
}
