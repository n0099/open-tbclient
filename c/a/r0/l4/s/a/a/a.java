package c.a.r0.l4.s.a.a;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import c.a.d.f.p.l;
import c.a.q0.t.c.m0;
import c.a.r0.t3.s0.m;
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
/* loaded from: classes6.dex */
public class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NewVcodeView a;

    /* renamed from: b  reason: collision with root package name */
    public final NewWriteModel f19614b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f19615c;

    /* renamed from: d  reason: collision with root package name */
    public PostWriteCallBackData f19616d;

    /* renamed from: e  reason: collision with root package name */
    public final NewWriteModel.g f19617e;

    /* renamed from: f  reason: collision with root package name */
    public NewWriteModel.g f19618f;

    /* renamed from: c.a.r0.l4.s.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1170a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1170a(a aVar) {
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
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m0Var, writeData, antiData}) == null) || this.a.a == null) {
                return;
            }
            this.a.a.showPostThreadLoadingView(false);
            if (z) {
                this.a.f19616d = postWriteCallBackData;
                this.a.f19615c = true;
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
                this.a.a.runJsMethod("success", str3 + "," + str + "," + str2);
            } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                if (this.a.f19618f != null) {
                    this.a.f19618f.callback(false, postWriteCallBackData, m0Var, writeData, antiData);
                }
            } else {
                this.a.a.getContext().setVisible(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.a.getContext().getActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData, postWriteCallBackData.getAccessState())));
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
        C1170a c1170a = new C1170a(this);
        this.f19617e = c1170a;
        this.a = newVcodeView;
        this.f19614b = newWriteModel;
        newWriteModel.j0(c1170a);
    }

    @Override // c.a.r0.l4.s.a.a.b
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.a.setRatio(0.9433962f);
            this.a.showWebView(false);
            this.a.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
        }
    }

    @Override // c.a.r0.l4.s.a.a.b
    public boolean b(WebView webView, String str) {
        InterceptResult invokeLL;
        WriteData Y;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str)) == null) {
            if (this.f19614b.Y() == null || StringUtils.isNull(str) || (Y = this.f19614b.Y()) == null) {
                return false;
            }
            if (str.contains("objc:loadReady")) {
                if (Y.getVcodeExtra() == null) {
                    return false;
                }
                this.a.runJsMethod("handleFreshCaptcha", "'" + Y.getVcodeUrl() + "','" + Y.getVcodeExtra().slideImg + "','" + Y.getVcodeExtra().textImg + "'");
                return true;
            } else if (str.contains("objc:jsChangePosition")) {
                j(c.a.q0.e1.a.a(str));
                return true;
            } else if (str.contains("objc:finish")) {
                if (Y != null && Y.getVideoReviewType() == 1) {
                    NewVcodeView newVcodeView = this.a;
                    newVcodeView.showToast(true, newVcodeView.getContext().getResources().getString(R.string.video_send_success_under_review));
                } else if (Y != null && Y.getVideoReviewType() == 2) {
                    NewVcodeView newVcodeView2 = this.a;
                    newVcodeView2.showToast(true, newVcodeView2.getContext().getResources().getString(R.string.video_send_success));
                } else {
                    String string = this.a.getContext().getResources().getString(R.string.send_success);
                    PostWriteCallBackData postWriteCallBackData = this.f19616d;
                    String str3 = null;
                    if (postWriteCallBackData != null) {
                        str3 = postWriteCallBackData.getPreMsg();
                        str2 = this.f19616d.getColorMsg();
                        string = this.f19616d.getErrorString();
                    } else {
                        str2 = null;
                    }
                    if (Y.getType() != 7) {
                        m.b(this.a.getContext().getActivity(), string, str3, str2);
                    }
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", this.f19616d);
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

    @Override // c.a.r0.l4.s.a.a.b
    public void c(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            this.f19618f = gVar;
        }
    }

    @Override // c.a.r0.l4.s.a.a.b
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.showPostThreadLoadingView(false);
            this.f19614b.cancelLoadData();
        }
    }

    @Override // c.a.r0.l4.s.a.a.b
    public void e(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, str) == null) {
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (!l.C()) {
                this.a.getContext().showToast(R.string.neterror);
                this.a.getContext().finish();
            } else if (!StringUtils.isNull(str)) {
                this.a.showPostThreadLoadingView(true);
                this.f19614b.Y().setVcode(str);
                this.f19614b.Y().setVcodeType("5");
                this.f19614b.n0();
            } else {
                this.a.getContext().showToast(R.string.neterror);
                this.a.getContext().finish();
            }
        }
    }

    @Override // c.a.r0.l4.s.a.a.b
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // c.a.r0.l4.s.a.a.b
    public void onPageFinished(WebView webView, String str) {
        NewVcodeView newVcodeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, webView, str) == null) || (newVcodeView = this.a) == null) {
            return;
        }
        newVcodeView.showWebViewDelay(1000);
    }
}
