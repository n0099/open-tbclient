package b.a.r0.e4.s.a.a;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.m.e;
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
public class c implements b.a.r0.e4.s.a.a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final NewVcodeView f17637a;

    /* renamed from: b  reason: collision with root package name */
    public final NewWriteModel f17638b;

    /* renamed from: c  reason: collision with root package name */
    public String f17639c;

    /* renamed from: d  reason: collision with root package name */
    public String f17640d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f17641e;

    /* renamed from: f  reason: collision with root package name */
    public String f17642f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17643g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f17644h;

    /* renamed from: i  reason: collision with root package name */
    public final NewWriteModel.g f17645i;
    public NewWriteModel.g j;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f17646e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17646e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f17646e.f17637a == null) {
                return;
            }
            if (StringUtils.isNull(this.f17646e.f17642f)) {
                this.f17646e.f17637a.showToast(false, this.f17646e.f17637a.getContext().getResources().getString(R.string.drag_vcode_error));
            } else {
                this.f17646e.f17637a.showToast(false, this.f17646e.f17642f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f17647a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17647a = cVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, m0 m0Var, WriteData writeData, AntiData antiData) {
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m0Var, writeData, antiData}) == null) || this.f17647a.f17637a == null) {
                return;
            }
            this.f17647a.f17637a.showPostThreadLoadingView(false);
            if (z) {
                this.f17647a.f17643g = true;
                if (writeData != null && writeData.getVideoReviewType() == 1) {
                    this.f17647a.f17637a.showToast(true, this.f17647a.f17637a.getContext().getResources().getString(R.string.video_send_success_under_review));
                } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                    this.f17647a.f17637a.showToast(true, this.f17647a.f17637a.getContext().getResources().getString(R.string.video_send_success));
                } else if (writeData != null) {
                    String string = this.f17647a.f17637a.getContext().getResources().getString(R.string.send_success);
                    String str2 = null;
                    if (postWriteCallBackData != null) {
                        str2 = postWriteCallBackData.getPreMsg();
                        str = postWriteCallBackData.getColorMsg();
                        string = postWriteCallBackData.getErrorString();
                    } else {
                        str = null;
                    }
                    if (writeData.getType() != 7) {
                        m.b(this.f17647a.f17637a.getContext().getActivity(), string, str2, str);
                    }
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                BaseActivity context = this.f17647a.f17637a.getContext();
                this.f17647a.f17637a.getContext();
                context.setResult(-1, intent);
                this.f17647a.f17637a.getContext().finish();
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                this.f17647a.f17637a.getContext().setVisible(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.f17647a.f17637a.getContext().getActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData, postWriteCallBackData.getAccessState())));
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && this.f17647a.j != null) {
                if (this.f17647a.j != null) {
                    this.f17647a.j.callback(z, postWriteCallBackData, m0Var, writeData, antiData);
                }
            } else if (postWriteCallBackData == null) {
            } else {
                if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.f17647a.f17637a.showToast(false, this.f17647a.f17637a.getContext().getResources().getString(R.string.input_vcode_error));
                } else {
                    this.f17647a.f17637a.showToast(false, postWriteCallBackData.getErrorString());
                }
                this.f17647a.m();
            }
        }
    }

    public c(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
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
        this.f17641e = false;
        this.f17642f = null;
        this.f17644h = new a(this);
        b bVar = new b(this);
        this.f17645i = bVar;
        this.f17637a = newVcodeView;
        this.f17638b = newWriteModel;
        newWriteModel.h0(bVar);
    }

    @Override // b.a.r0.e4.s.a.a.b
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f17637a.setRatio(1.2631578f);
            this.f17637a.showWebView(false);
            String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/captcha";
            if (z) {
                str = str + "?feedback=1";
            }
            this.f17637a.getWebView().loadUrl(str);
        }
    }

    @Override // b.a.r0.e4.s.a.a.b
    public boolean b(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str)) == null) {
            if (str.contains("objc:jsChangeVcode")) {
                String a2 = b.a.q0.d1.a.a(str);
                this.f17639c = a2;
                if (a2 == null || this.f17638b.X() == null) {
                    return false;
                }
                NewVcodeView newVcodeView = this.f17637a;
                String str2 = this.f17639c;
                newVcodeView.runJsMethod(str2, "'" + this.f17638b.X().getVcodeUrl() + "'");
                return true;
            } else if (str.equals("objc:jumpToFeedback()")) {
                if (WriteActivityConfig.isAsyncWriting()) {
                    return false;
                }
                WriteActivityConfig.newInstance(this.f17637a.getContext()).setType(0).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setIsVcodeFeedBack().send();
                return true;
            } else if (str.contains("objc:jsSubmit")) {
                return k(b.a.q0.d1.a.a(str));
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // b.a.r0.e4.s.a.a.b
    public void c(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            this.j = gVar;
        }
    }

    @Override // b.a.r0.e4.s.a.a.b
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f17637a.showPostThreadLoadingView(false);
            this.f17638b.cancelLoadData();
        }
    }

    @Override // b.a.r0.e4.s.a.a.b
    public void e(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, str) == null) {
            this.f17641e = z;
            this.f17642f = str;
        }
    }

    public final boolean k(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
                return false;
            }
            this.f17640d = split[0];
            l(split[1]);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (!l.D()) {
                this.f17637a.getContext().showToast(R.string.neterror);
                this.f17637a.getContext().finish();
            } else if (!StringUtils.isNull(str)) {
                this.f17637a.showPostThreadLoadingView(true);
                this.f17638b.X().setVcode(str);
                this.f17638b.X().setVcodeType("4");
                this.f17638b.l0();
            } else {
                this.f17637a.getContext().showToast(R.string.neterror);
                this.f17637a.getContext().finish();
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            NewVcodeView newVcodeView = this.f17637a;
            String str = this.f17640d;
            newVcodeView.runJsMethod(str, "'" + this.f17638b.X().getVcodeUrl() + "'");
        }
    }

    @Override // b.a.r0.e4.s.a.a.b
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            e.a().removeCallbacks(this.f17644h);
        }
    }

    @Override // b.a.r0.e4.s.a.a.b
    public void onPageFinished(WebView webView, String str) {
        NewVcodeView newVcodeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, webView, str) == null) || (newVcodeView = this.f17637a) == null) {
            return;
        }
        newVcodeView.showWebViewDelay(500);
        if (this.f17641e) {
            e.a().postDelayed(this.f17644h, 500L);
        }
    }
}
