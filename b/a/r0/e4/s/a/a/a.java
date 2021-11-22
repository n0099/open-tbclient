package b.a.r0.e4.s.a.a;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import b.a.e.f.p.l;
import b.a.q0.t.c.m0;
import b.a.r0.m3.s0.m;
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
    public final NewVcodeView f17630a;

    /* renamed from: b  reason: collision with root package name */
    public final NewWriteModel f17631b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f17632c;

    /* renamed from: d  reason: collision with root package name */
    public PostWriteCallBackData f17633d;

    /* renamed from: e  reason: collision with root package name */
    public final NewWriteModel.g f17634e;

    /* renamed from: f  reason: collision with root package name */
    public NewWriteModel.g f17635f;

    /* renamed from: b.a.r0.e4.s.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0889a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f17636a;

        public C0889a(a aVar) {
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
            this.f17636a = aVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, m0 m0Var, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m0Var, writeData, antiData}) == null) || this.f17636a.f17630a == null) {
                return;
            }
            this.f17636a.f17630a.showPostThreadLoadingView(false);
            if (z) {
                this.f17636a.f17633d = postWriteCallBackData;
                this.f17636a.f17632c = true;
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
                this.f17636a.f17630a.runJsMethod("success", str3 + "," + str + "," + str2);
            } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                if (this.f17636a.f17635f != null) {
                    this.f17636a.f17635f.callback(false, postWriteCallBackData, m0Var, writeData, antiData);
                }
            } else {
                this.f17636a.f17630a.getContext().setVisible(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.f17636a.f17630a.getContext().getActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData, postWriteCallBackData.getAccessState())));
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
        C0889a c0889a = new C0889a(this);
        this.f17634e = c0889a;
        this.f17630a = newVcodeView;
        this.f17631b = newWriteModel;
        newWriteModel.h0(c0889a);
    }

    @Override // b.a.r0.e4.s.a.a.b
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f17630a.setRatio(0.9433962f);
            this.f17630a.showWebView(false);
            this.f17630a.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
        }
    }

    @Override // b.a.r0.e4.s.a.a.b
    public boolean b(WebView webView, String str) {
        InterceptResult invokeLL;
        WriteData X;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str)) == null) {
            if (this.f17631b.X() == null || StringUtils.isNull(str) || (X = this.f17631b.X()) == null) {
                return false;
            }
            if (str.contains("objc:loadReady")) {
                if (X.getVcodeExtra() == null) {
                    return false;
                }
                this.f17630a.runJsMethod("handleFreshCaptcha", "'" + X.getVcodeUrl() + "','" + X.getVcodeExtra().slideImg + "','" + X.getVcodeExtra().textImg + "'");
                return true;
            } else if (str.contains("objc:jsChangePosition")) {
                j(b.a.q0.d1.a.a(str));
                return true;
            } else if (str.contains("objc:finish")) {
                if (X != null && X.getVideoReviewType() == 1) {
                    NewVcodeView newVcodeView = this.f17630a;
                    newVcodeView.showToast(true, newVcodeView.getContext().getResources().getString(R.string.video_send_success_under_review));
                } else if (X != null && X.getVideoReviewType() == 2) {
                    NewVcodeView newVcodeView2 = this.f17630a;
                    newVcodeView2.showToast(true, newVcodeView2.getContext().getResources().getString(R.string.video_send_success));
                } else {
                    String string = this.f17630a.getContext().getResources().getString(R.string.send_success);
                    PostWriteCallBackData postWriteCallBackData = this.f17633d;
                    String str3 = null;
                    if (postWriteCallBackData != null) {
                        str3 = postWriteCallBackData.getPreMsg();
                        str2 = this.f17633d.getColorMsg();
                        string = this.f17633d.getErrorString();
                    } else {
                        str2 = null;
                    }
                    if (X.getType() != 7) {
                        m.b(this.f17630a.getContext().getActivity(), string, str3, str2);
                    }
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", this.f17633d);
                intent.putExtras(bundle);
                BaseActivity context = this.f17630a.getContext();
                this.f17630a.getContext();
                context.setResult(-1, intent);
                this.f17630a.getContext().finish();
                return true;
            } else if (!str.contains("objc:jumpToFeedback()") || WriteActivityConfig.isAsyncWriting()) {
                return false;
            } else {
                WriteActivityConfig.newInstance(this.f17630a.getContext()).setType(0).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setIsVcodeFeedBack().send();
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // b.a.r0.e4.s.a.a.b
    public void c(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            this.f17635f = gVar;
        }
    }

    @Override // b.a.r0.e4.s.a.a.b
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f17630a.showPostThreadLoadingView(false);
            this.f17631b.cancelLoadData();
        }
    }

    @Override // b.a.r0.e4.s.a.a.b
    public void e(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, str) == null) {
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (!l.D()) {
                this.f17630a.getContext().showToast(R.string.neterror);
                this.f17630a.getContext().finish();
            } else if (!StringUtils.isNull(str)) {
                this.f17630a.showPostThreadLoadingView(true);
                this.f17631b.X().setVcode(str);
                this.f17631b.X().setVcodeType("5");
                this.f17631b.l0();
            } else {
                this.f17630a.getContext().showToast(R.string.neterror);
                this.f17630a.getContext().finish();
            }
        }
    }

    @Override // b.a.r0.e4.s.a.a.b
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // b.a.r0.e4.s.a.a.b
    public void onPageFinished(WebView webView, String str) {
        NewVcodeView newVcodeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, webView, str) == null) || (newVcodeView = this.f17630a) == null) {
            return;
        }
        newVcodeView.showWebViewDelay(1000);
    }
}
