package c.a.q0.m0;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.q0.q0.h;
import c.a.q0.r.t.m;
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
    public InterfaceC0851d a;

    /* renamed from: b  reason: collision with root package name */
    public final HttpMessageListener f12760b;

    /* renamed from: c  reason: collision with root package name */
    public final TbHttpMessageTask f12761c;

    /* renamed from: d  reason: collision with root package name */
    public final BdUniqueId f12762d;

    /* renamed from: e  reason: collision with root package name */
    public final BdUniqueId f12763e;

    /* renamed from: f  reason: collision with root package name */
    public int f12764f;

    /* renamed from: g  reason: collision with root package name */
    public long f12765g;

    /* renamed from: h  reason: collision with root package name */
    public String f12766h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12767i;

    /* renamed from: j  reason: collision with root package name */
    public AlertDialog f12768j;
    public final TbPageContext<?> k;
    public final CustomMessageListener l;
    public boolean m;
    public String n;
    public String o;
    public c.a.q0.q0.a p;

    /* loaded from: classes2.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                    this.a.f12767i = false;
                    return;
                }
                NovelPayResponse novelPayResponse = (NovelPayResponse) httpResponsedMessage;
                if (this.a.a == null) {
                    this.a.f12767i = false;
                    return;
                }
                BdUniqueId tag = novelPayResponse.getOrginalMessage().getTag();
                if (tag != this.a.f12762d) {
                    if (tag == this.a.f12763e) {
                        this.a.f12767i = false;
                        this.a.a.a(novelPayResponse.isSuccessful() ? NovelResult.PAY_NOVEL_SUCC : NovelResult.PAY_NOVEL_FAIL);
                        return;
                    }
                    this.a.f12767i = false;
                } else if (!novelPayResponse.isSuccessful() || novelPayResponse.getYYCoin() < 0) {
                    this.a.f12767i = false;
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
        public b(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
    public class c extends c.a.q0.q0.a {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.q0.q0.c
        public void a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hVar) == null) {
                this.a.m = true;
            }
        }

        @Override // c.a.q0.q0.a
        public void b(byte b2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeB(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2) == null) && b2 == 6) {
                if (!this.a.m) {
                    this.a.f12767i = false;
                    if (this.a.a != null) {
                        this.a.a.a(NovelResult.DEPOSIT_CANCEL);
                        return;
                    }
                    return;
                }
                d dVar = this.a;
                dVar.r(dVar.f12765g, this.a.f12766h, this.a.f12764f, true);
                this.a.m = false;
            }
        }

        @Override // c.a.q0.q0.c
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) {
                this.a.f12767i = false;
                if (this.a.a != null) {
                    this.a.a.a(NovelResult.DEPOSIT_FAIL);
                }
            }
        }
    }

    /* renamed from: c.a.q0.m0.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0851d {
        void a(NovelResult novelResult);
    }

    public d(@NonNull TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12762d = BdUniqueId.gen();
        this.f12763e = BdUniqueId.gen();
        this.f12764f = -1;
        this.f12765g = -1L;
        this.f12767i = false;
        this.m = false;
        this.p = null;
        this.k = tbPageContext;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_NOVEL_PAY, TbDomainConfig.DOMAIN_HTTPS_SERVER_ADDRESS + TbConfig.NOVEL_PAY);
        this.f12761c = tbHttpMessageTask;
        tbHttpMessageTask.setResponsedClass(NovelPayResponse.class);
        this.f12760b = new a(this, CmdConfigHttp.CMD_NOVEL_PAY);
        this.l = new b(this, 2001227);
    }

    public void l(InterfaceC0851d interfaceC0851d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, interfaceC0851d) == null) {
            this.a = interfaceC0851d;
            MessageManager.getInstance().registerTask(this.f12761c);
            this.k.registerListener(this.f12760b);
            this.k.registerListener(this.l);
        }
    }

    public /* synthetic */ void m(View view) {
        AlertDialog alertDialog = this.f12768j;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.f12767i = false;
        InterfaceC0851d interfaceC0851d = this.a;
        if (interfaceC0851d != null) {
            interfaceC0851d.a(NovelResult.PAY_NOVEL_CANCEL);
        }
        f.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_PAY_DIALOG_CLICK, 1, String.valueOf(this.f12765g), this.n, this.o);
    }

    public /* synthetic */ void n(View view) {
        AlertDialog alertDialog = this.f12768j;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        int i2 = this.f12764f;
        if (i2 == 0) {
            this.a.a(NovelResult.PAY_NOVEL_SUCC);
        } else if (i2 > 0) {
            r(this.f12765g, this.f12766h, i2, false);
        }
        f.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_PAY_DIALOG_CLICK, 2, String.valueOf(this.f12765g), this.n, this.o);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a = null;
            MessageManager.getInstance().unRegisterTask(this.f12761c.getCmd());
            MessageManager.getInstance().unRegisterListener(this.f12760b);
            MessageManager.getInstance().unRegisterListener(this.l);
            MessageManager.getInstance().sendMessage(new CustomMessage(2921661, this.p));
        }
    }

    public final void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            if (i2 >= this.f12764f) {
                t(i2);
            } else if (!n.C()) {
                this.f12767i = false;
                InterfaceC0851d interfaceC0851d = this.a;
                if (interfaceC0851d != null) {
                    interfaceC0851d.a(NovelResult.DEPOSIT_FAIL);
                }
            } else {
                this.p = new c(this);
                CurrencyJumpHelper.buyGiftGotoBuyTBeanPage(this.k.getPageActivity(), this.p, this.k.getString(R.string.novel_yy_not_enough), Long.valueOf(this.f12764f), false, 1);
                f.b("c10291", "31", this.n, this.o);
            }
        }
    }

    public void q(long j2, String str, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j2), str, Integer.valueOf(i2)}) == null) && !this.f12767i && ViewHelper.checkUpIsLogin(this.k.getPageActivity())) {
            this.f12767i = true;
            this.f12764f = i2;
            this.f12765g = j2;
            this.f12766h = str;
            r(j2, str, i2, true);
        }
    }

    public final void r(long j2, String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j2), str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_NOVEL_PAY);
            httpMessage.addParam("goods_id", j2);
            httpMessage.addParam("goods_name", str);
            httpMessage.addParam("cost", i2);
            httpMessage.addParam("tid", this.n);
            httpMessage.addParam("only_check_yycoin", z ? 1 : 0);
            httpMessage.setTag(z ? this.f12762d : this.f12763e);
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

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            AlertDialog alertDialog = this.f12768j;
            if (alertDialog != null && alertDialog.isShowing()) {
                this.f12768j.dismiss();
            }
            m mVar = new m(this.k.getPageActivity());
            mVar.w(String.format(Locale.CHINA, this.k.getString(R.string.novel_pay_info), Double.valueOf((this.f12764f * 1.0d) / 100.0d)));
            mVar.u(R.string.novel_confirm_pay_info);
            mVar.p(String.format(Locale.CHINA, this.k.getString(R.string.novel_current_yy_coin), Double.valueOf((i2 * 1.0d) / 100.0d)));
            mVar.n(true);
            mVar.i(false);
            mVar.r(new TBAlertConfig.a(this.k.getString(R.string.protocol_cancel), TBAlertConfig.OperateBtnStyle.SECONDARY, new View.OnClickListener() { // from class: c.a.q0.m0.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        d.this.m(view);
                    }
                }
            }), new TBAlertConfig.a(this.k.getString(R.string.novel_confirm_pay), TBAlertConfig.OperateBtnStyle.MAIN, new View.OnClickListener() { // from class: c.a.q0.m0.b
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
            this.f12768j = mVar.y();
            InterfaceC0851d interfaceC0851d = this.a;
            if (interfaceC0851d != null) {
                interfaceC0851d.a(NovelResult.PAY_NOVEL_CONFIRM_DIALOG);
            }
            f.b(CommonStatisticKey.KEY_PB_NOVEL_INFO_PAY_DIALOG_SHOW, String.valueOf(this.f12765g), this.n, this.o);
        }
    }
}
