package c.a.o0.m0;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.q0.h;
import c.a.o0.r.t.o;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.novel.NovelPayResponse;
import com.baidu.tbadk.novel.NovelResult;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.wallet.CurrencyJumpHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InterfaceC0818d a;

    /* renamed from: b  reason: collision with root package name */
    public final HttpMessageListener f10442b;

    /* renamed from: c  reason: collision with root package name */
    public final TbHttpMessageTask f10443c;

    /* renamed from: d  reason: collision with root package name */
    public final BdUniqueId f10444d;

    /* renamed from: e  reason: collision with root package name */
    public final BdUniqueId f10445e;

    /* renamed from: f  reason: collision with root package name */
    public int f10446f;

    /* renamed from: g  reason: collision with root package name */
    public long f10447g;

    /* renamed from: h  reason: collision with root package name */
    public String f10448h;
    public boolean i;
    public AlertDialog j;
    public final TbPageContext<?> k;
    public final CustomMessageListener l;
    public boolean m;
    public String n;
    public String o;
    public c.a.o0.q0.a p;

    /* loaded from: classes2.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (!(httpResponsedMessage instanceof NovelPayResponse) || httpResponsedMessage.getOrginalMessage() == null) {
                    this.a.i = false;
                    return;
                }
                NovelPayResponse novelPayResponse = (NovelPayResponse) httpResponsedMessage;
                if (this.a.a == null) {
                    this.a.i = false;
                    return;
                }
                BdUniqueId tag = novelPayResponse.getOrginalMessage().getTag();
                if (tag != this.a.f10444d) {
                    if (tag == this.a.f10445e) {
                        this.a.i = false;
                        this.a.a.a(novelPayResponse.isSuccessful() ? NovelResult.PAY_NOVEL_SUCC : NovelResult.PAY_NOVEL_FAIL);
                        return;
                    }
                    this.a.i = false;
                } else if (!novelPayResponse.isSuccessful() || novelPayResponse.getYYCoin() < 0) {
                    this.a.i = false;
                    this.a.a.a(NovelResult.PAY_NOVEL_FAIL);
                } else {
                    this.a.p(novelPayResponse.getYYCoin());
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.a == null) {
                return;
            }
            this.a.a.a(NovelResult.DEPOSIT_SUCC);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends c.a.o0.q0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.o0.q0.c
        public void a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hVar) == null) {
                this.a.m = true;
            }
        }

        @Override // c.a.o0.q0.a
        public void b(byte b2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeB(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2) == null) && b2 == 6) {
                if (!this.a.m) {
                    this.a.i = false;
                    if (this.a.a != null) {
                        this.a.a.a(NovelResult.DEPOSIT_CANCEL);
                        return;
                    }
                    return;
                }
                d dVar = this.a;
                dVar.r(dVar.f10447g, this.a.f10448h, this.a.f10446f, true);
                this.a.m = false;
            }
        }

        @Override // c.a.o0.q0.c
        public void onFail(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, str) == null) {
                this.a.i = false;
                if (this.a.a != null) {
                    this.a.a.a(NovelResult.DEPOSIT_FAIL);
                }
            }
        }
    }

    /* renamed from: c.a.o0.m0.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0818d {
        void a(NovelResult novelResult);
    }

    public d(@NonNull TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10444d = BdUniqueId.gen();
        this.f10445e = BdUniqueId.gen();
        this.f10446f = -1;
        this.f10447g = -1L;
        this.i = false;
        this.m = false;
        this.p = null;
        this.k = tbPageContext;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_NOVEL_PAY, TbDomainConfig.DOMAIN_HTTPS_SERVER_ADDRESS + TbConfig.NOVEL_PAY);
        this.f10443c = tbHttpMessageTask;
        tbHttpMessageTask.setResponsedClass(NovelPayResponse.class);
        this.f10442b = new a(this, CmdConfigHttp.CMD_NOVEL_PAY);
        this.l = new b(this, 2001227);
    }

    public void l(InterfaceC0818d interfaceC0818d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, interfaceC0818d) == null) {
            this.a = interfaceC0818d;
            MessageManager.getInstance().registerTask(this.f10443c);
            this.k.registerListener(this.f10442b);
            this.k.registerListener(this.l);
        }
    }

    public /* synthetic */ void m(View view) {
        AlertDialog alertDialog = this.j;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.i = false;
        InterfaceC0818d interfaceC0818d = this.a;
        if (interfaceC0818d != null) {
            interfaceC0818d.a(NovelResult.PAY_NOVEL_CANCEL);
        }
        f.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_PAY_DIALOG_CLICK, 1, String.valueOf(this.f10447g), this.n, this.o);
    }

    public /* synthetic */ void n(View view) {
        AlertDialog alertDialog = this.j;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        int i = this.f10446f;
        if (i == 0) {
            this.a.a(NovelResult.PAY_NOVEL_SUCC);
        } else if (i > 0) {
            r(this.f10447g, this.f10448h, i, false);
        }
        f.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_PAY_DIALOG_CLICK, 2, String.valueOf(this.f10447g), this.n, this.o);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a = null;
            MessageManager.getInstance().unRegisterTask(this.f10443c.getCmd());
            MessageManager.getInstance().unRegisterListener(this.f10442b);
            MessageManager.getInstance().unRegisterListener(this.l);
            MessageManager.getInstance().sendMessage(new CustomMessage(2921661, this.p));
        }
    }

    public final void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            if (i >= this.f10446f) {
                t(i);
            } else if (!n.C()) {
                this.i = false;
                InterfaceC0818d interfaceC0818d = this.a;
                if (interfaceC0818d != null) {
                    interfaceC0818d.a(NovelResult.DEPOSIT_FAIL);
                }
            } else {
                this.p = new c(this);
                CurrencyJumpHelper.buyGiftGotoBuyTBeanPage(this.k.getPageActivity(), this.p, this.k.getString(R.string.obfuscated_res_0x7f0f0c9a), Long.valueOf(this.f10446f), false, 1);
                f.b("c10291", "31", this.n, this.o);
            }
        }
    }

    public void q(long j, String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), str, Integer.valueOf(i)}) == null) && !this.i && ViewHelper.checkUpIsLogin(this.k.getPageActivity())) {
            this.i = true;
            this.f10446f = i;
            this.f10447g = j;
            this.f10448h = str;
            r(j, str, i, true);
        }
    }

    public final void r(long j, String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_NOVEL_PAY);
            httpMessage.addParam("goods_id", j);
            httpMessage.addParam("goods_name", str);
            httpMessage.addParam("cost", i);
            httpMessage.addParam("tid", this.n);
            httpMessage.addParam("only_check_yycoin", z ? 1 : 0);
            httpMessage.setTag(z ? this.f10444d : this.f10445e);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void s(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            this.n = str;
            this.o = str2;
        }
    }

    public final void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            AlertDialog alertDialog = this.j;
            if (alertDialog != null && alertDialog.isShowing()) {
                this.j.dismiss();
            }
            o oVar = new o(this.k.getPageActivity());
            oVar.w(String.format(Locale.CHINA, this.k.getString(R.string.obfuscated_res_0x7f0f0c92), Double.valueOf((this.f10446f * 1.0d) / 100.0d)));
            oVar.u(R.string.obfuscated_res_0x7f0f0c8d);
            oVar.p(String.format(Locale.CHINA, this.k.getString(R.string.obfuscated_res_0x7f0f0c8e), Double.valueOf((i * 1.0d) / 100.0d)));
            oVar.n(true);
            oVar.i(false);
            oVar.r(new TBAlertConfig.a(this.k.getString(R.string.obfuscated_res_0x7f0f0eeb), TBAlertConfig.OperateBtnStyle.SECONDARY, new View.OnClickListener() { // from class: c.a.o0.m0.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        d.this.m(view);
                    }
                }
            }), new TBAlertConfig.a(this.k.getString(R.string.obfuscated_res_0x7f0f0c8c), TBAlertConfig.OperateBtnStyle.MAIN, new View.OnClickListener() { // from class: c.a.o0.m0.b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        d.this.n(view);
                    }
                }
            }));
            this.j = oVar.y();
            InterfaceC0818d interfaceC0818d = this.a;
            if (interfaceC0818d != null) {
                interfaceC0818d.a(NovelResult.PAY_NOVEL_CONFIRM_DIALOG);
            }
            f.b(CommonStatisticKey.KEY_PB_NOVEL_INFO_PAY_DIALOG_SHOW, String.valueOf(this.f10447g), this.n, this.o);
        }
    }
}
