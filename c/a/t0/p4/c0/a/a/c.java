package c.a.t0.p4.c0.a.a;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.e;
import c.a.d.f.p.n;
import c.a.s0.t.c.n0;
import c.a.t0.p4.j;
import c.a.t0.x3.s0.h;
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
public class c implements c.a.t0.p4.c0.a.a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NewVcodeView a;

    /* renamed from: b  reason: collision with root package name */
    public final NewWriteModel f21282b;

    /* renamed from: c  reason: collision with root package name */
    public String f21283c;

    /* renamed from: d  reason: collision with root package name */
    public String f21284d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f21285e;

    /* renamed from: f  reason: collision with root package name */
    public String f21286f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21287g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f21288h;

    /* renamed from: i  reason: collision with root package name */
    public final NewWriteModel.g f21289i;

    /* renamed from: j  reason: collision with root package name */
    public NewWriteModel.g f21290j;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f21291e;

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
            this.f21291e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21291e.a == null) {
                return;
            }
            if (StringUtils.isNull(this.f21291e.f21286f)) {
                this.f21291e.a.showToast(false, this.f21291e.a.getContext().getResources().getString(j.drag_vcode_error));
            } else {
                this.f21291e.a.showToast(false, this.f21291e.f21286f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

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
            this.a = cVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, n0 n0Var, WriteData writeData, AntiData antiData) {
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, n0Var, writeData, antiData}) == null) || this.a.a == null) {
                return;
            }
            this.a.a.showPostThreadLoadingView(false);
            if (z) {
                this.a.f21287g = true;
                if (writeData != null && writeData.getVideoReviewType() == 1) {
                    this.a.a.showToast(true, this.a.a.getContext().getResources().getString(j.video_send_success_under_review));
                } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                    this.a.a.showToast(true, this.a.a.getContext().getResources().getString(j.video_send_success));
                } else if (writeData != null) {
                    String string = this.a.a.getContext().getResources().getString(j.send_success);
                    String str2 = null;
                    if (postWriteCallBackData != null) {
                        str2 = postWriteCallBackData.getPreMsg();
                        str = postWriteCallBackData.getColorMsg();
                        string = postWriteCallBackData.getErrorString();
                    } else {
                        str = null;
                    }
                    if (writeData.getType() != 7) {
                        h.b(this.a.a.getContext().getActivity(), string, str2, str);
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
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                this.a.a.getContext().setVisible(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.a.getContext().getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015 && this.a.f21290j != null) {
                if (this.a.f21290j != null) {
                    this.a.f21290j.callback(z, postWriteCallBackData, n0Var, writeData, antiData);
                }
            } else if (postWriteCallBackData == null) {
            } else {
                if (StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.a.a.showToast(false, this.a.a.getContext().getResources().getString(j.input_vcode_error));
                } else {
                    this.a.a.showToast(false, postWriteCallBackData.getErrorString());
                }
                this.a.m();
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
        this.f21285e = false;
        this.f21286f = null;
        this.f21288h = new a(this);
        b bVar = new b(this);
        this.f21289i = bVar;
        this.a = newVcodeView;
        this.f21282b = newWriteModel;
        newWriteModel.l0(bVar);
    }

    @Override // c.a.t0.p4.c0.a.a.b
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.a.setRatio(1.2631578f);
            this.a.showWebView(false);
            String str = TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/captcha";
            if (z) {
                str = str + "?feedback=1";
            }
            this.a.getWebView().loadUrl(str);
        }
    }

    @Override // c.a.t0.p4.c0.a.a.b
    public boolean b(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str)) == null) {
            if (str.contains("objc:jsChangeVcode")) {
                String a2 = c.a.s0.e1.a.a(str);
                this.f21283c = a2;
                if (a2 == null || this.f21282b.Z() == null) {
                    return false;
                }
                NewVcodeView newVcodeView = this.a;
                String str2 = this.f21283c;
                newVcodeView.runJsMethod(str2, "'" + this.f21282b.Z().getVcodeUrl() + "'");
                return true;
            } else if (str.equals("objc:jumpToFeedback()")) {
                if (WriteActivityConfig.isAsyncWriting()) {
                    return false;
                }
                WriteActivityConfig.newInstance(this.a.getContext()).setType(0).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setIsVcodeFeedBack().send();
                return true;
            } else if (str.contains("objc:jsSubmit")) {
                return k(c.a.s0.e1.a.a(str));
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.t0.p4.c0.a.a.b
    public void c(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            this.f21290j = gVar;
        }
    }

    @Override // c.a.t0.p4.c0.a.a.b
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.showPostThreadLoadingView(false);
            this.f21282b.cancelLoadData();
        }
    }

    @Override // c.a.t0.p4.c0.a.a.b
    public void e(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, str) == null) {
            this.f21285e = z;
            this.f21286f = str;
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
            this.f21284d = split[0];
            l(split[1]);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (!n.C()) {
                this.a.getContext().showToast(j.neterror);
                this.a.getContext().finish();
            } else if (!StringUtils.isNull(str)) {
                this.a.showPostThreadLoadingView(true);
                this.f21282b.Z().setVcode(str);
                this.f21282b.Z().setVcodeType("4");
                this.f21282b.p0();
            } else {
                this.a.getContext().showToast(j.neterror);
                this.a.getContext().finish();
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            NewVcodeView newVcodeView = this.a;
            String str = this.f21284d;
            newVcodeView.runJsMethod(str, "'" + this.f21282b.Z().getVcodeUrl() + "'");
        }
    }

    @Override // c.a.t0.p4.c0.a.a.b
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            e.a().removeCallbacks(this.f21288h);
        }
    }

    @Override // c.a.t0.p4.c0.a.a.b
    public void onPageFinished(WebView webView, String str) {
        NewVcodeView newVcodeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, webView, str) == null) || (newVcodeView = this.a) == null) {
            return;
        }
        newVcodeView.showWebViewDelay(500);
        if (this.f21285e) {
            e.a().postDelayed(this.f21288h, 500L);
        }
    }
}
