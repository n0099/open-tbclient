package c.a.s0.n0;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import c.a.d.f.p.n;
import c.a.s0.r0.h;
import c.a.s0.s.s.m;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
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
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;

    /* renamed from: b  reason: collision with root package name */
    public final HttpMessageListener f13251b;

    /* renamed from: c  reason: collision with root package name */
    public final TbHttpMessageTask f13252c;

    /* renamed from: d  reason: collision with root package name */
    public final BdUniqueId f13253d;

    /* renamed from: e  reason: collision with root package name */
    public final BdUniqueId f13254e;

    /* renamed from: f  reason: collision with root package name */
    public int f13255f;

    /* renamed from: g  reason: collision with root package name */
    public long f13256g;

    /* renamed from: h  reason: collision with root package name */
    public String f13257h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13258i;

    /* renamed from: j  reason: collision with root package name */
    public AlertDialog f13259j;

    /* renamed from: k  reason: collision with root package name */
    public final TbPageContext<?> f13260k;
    public final CustomMessageListener l;
    public boolean m;

    /* loaded from: classes6.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
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
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (!(httpResponsedMessage instanceof NovelPayResponse) || httpResponsedMessage.getOrginalMessage() == null) {
                    this.a.f13258i = false;
                    return;
                }
                NovelPayResponse novelPayResponse = (NovelPayResponse) httpResponsedMessage;
                if (this.a.a == null) {
                    this.a.f13258i = false;
                    return;
                }
                BdUniqueId tag = novelPayResponse.getOrginalMessage().getTag();
                if (tag != this.a.f13253d) {
                    if (tag == this.a.f13254e) {
                        this.a.f13258i = false;
                        this.a.a.a(novelPayResponse.isSuccessful() ? NovelResult.PAY_NOVEL_SUCC : NovelResult.PAY_NOVEL_FAIL);
                        return;
                    }
                    this.a.f13258i = false;
                } else if (!novelPayResponse.isSuccessful() || novelPayResponse.getYYCoin() < 0) {
                    this.a.f13258i = false;
                    this.a.a.a(NovelResult.PAY_NOVEL_FAIL);
                } else {
                    this.a.p(novelPayResponse.getYYCoin());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
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
            this.a = cVar;
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

    /* renamed from: c.a.s0.n0.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0850c extends c.a.s0.r0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public C0850c(c cVar) {
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

        @Override // c.a.s0.r0.c
        public void a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hVar) == null) {
                this.a.m = true;
            }
        }

        @Override // c.a.s0.r0.a
        public void b(byte b2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeB(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2) == null) && b2 == 6) {
                if (!this.a.m) {
                    this.a.f13258i = false;
                    if (this.a.a != null) {
                        this.a.a.a(NovelResult.DEPOSIT_CANCEL);
                        return;
                    }
                    return;
                }
                c cVar = this.a;
                cVar.r(cVar.f13256g, this.a.f13257h, this.a.f13255f, true);
                this.a.m = false;
            }
        }

        @Override // c.a.s0.r0.c
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) {
                this.a.f13258i = false;
                if (this.a.a != null) {
                    this.a.a.a(NovelResult.DEPOSIT_FAIL);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface d {
        void a(NovelResult novelResult);
    }

    public c(@NonNull TbPageContext<?> tbPageContext) {
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
        this.f13253d = BdUniqueId.gen();
        this.f13254e = BdUniqueId.gen();
        this.f13255f = -1;
        this.f13256g = -1L;
        this.f13258i = false;
        this.m = false;
        this.f13260k = tbPageContext;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_NOVEL_PAY, TbDomainConfig.DOMAIN_HTTPS_SERVER_ADDRESS + TbConfig.NOVEL_PAY);
        this.f13252c = tbHttpMessageTask;
        tbHttpMessageTask.setResponsedClass(NovelPayResponse.class);
        this.f13251b = new a(this, CmdConfigHttp.CMD_NOVEL_PAY);
        this.l = new b(this, 2001227);
    }

    public void l(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            this.a = dVar;
            MessageManager.getInstance().registerTask(this.f13252c);
            this.f13260k.registerListener(this.f13251b);
            this.f13260k.registerListener(this.l);
        }
    }

    public /* synthetic */ void m(View view) {
        AlertDialog alertDialog = this.f13259j;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.f13258i = false;
        d dVar = this.a;
        if (dVar != null) {
            dVar.a(NovelResult.PAY_NOVEL_CANCEL);
        }
        e.c(CommonStatisticKey.KEY_PB_NOVEL_INFO_PAY_DIALOG_CLICK, 1);
    }

    public /* synthetic */ void n(View view) {
        AlertDialog alertDialog = this.f13259j;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        r(this.f13256g, this.f13257h, this.f13255f, false);
        e.c(CommonStatisticKey.KEY_PB_NOVEL_INFO_PAY_DIALOG_CLICK, 2);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a = null;
            MessageManager.getInstance().unRegisterTask(this.f13252c.getCmd());
            MessageManager.getInstance().unRegisterListener(this.f13251b);
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public final void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            if (i2 >= this.f13255f) {
                s(i2);
            } else if (!n.C()) {
                this.f13258i = false;
                d dVar = this.a;
                if (dVar != null) {
                    dVar.a(NovelResult.DEPOSIT_FAIL);
                }
            } else {
                CurrencyJumpHelper.buyGiftGotoBuyTBeanPage(this.f13260k.getPageActivity(), new C0850c(this), this.f13260k.getString(R.string.novel_yy_not_enough), Long.valueOf(this.f13255f), false, 1);
            }
        }
    }

    public void q(long j2, String str, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j2), str, Integer.valueOf(i2)}) == null) && !this.f13258i && ViewHelper.checkUpIsLogin(this.f13260k.getPageActivity())) {
            this.f13258i = true;
            this.f13255f = i2;
            this.f13256g = j2;
            this.f13257h = str;
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
            httpMessage.addParam("only_check_yycoin", z ? 1 : 0);
            httpMessage.setTag(z ? this.f13253d : this.f13254e);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            AlertDialog alertDialog = this.f13259j;
            if (alertDialog != null && alertDialog.isShowing()) {
                this.f13259j.dismiss();
            }
            m mVar = new m(this.f13260k.getPageActivity());
            mVar.s(String.format(Locale.CHINA, this.f13260k.getString(R.string.novel_pay_info), Double.valueOf((this.f13255f * 1.0d) / 100.0d)));
            mVar.q(R.string.novel_confirm_pay_info);
            mVar.n(String.format(Locale.CHINA, this.f13260k.getString(R.string.novel_current_yy_coin), Double.valueOf((i2 * 1.0d) / 100.0d)));
            mVar.l(true);
            mVar.g(false);
            mVar.p(new TBAlertConfig.a(this.f13260k.getString(R.string.protocol_cancel), TBAlertConfig.OperateBtnStyle.SECONDARY, new View.OnClickListener() { // from class: c.a.s0.n0.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        c.this.m(view);
                    }
                }
            }), new TBAlertConfig.a(this.f13260k.getString(R.string.novel_confirm_pay), TBAlertConfig.OperateBtnStyle.MAIN, new View.OnClickListener() { // from class: c.a.s0.n0.b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        c.this.n(view);
                    }
                }
            }));
            this.f13259j = mVar.u();
            d dVar = this.a;
            if (dVar != null) {
                dVar.a(NovelResult.PAY_NOVEL_CONFIRM_DIALOG);
            }
            e.e(CommonStatisticKey.KEY_PB_NOVEL_INFO_PAY_DIALOG_SHOW);
        }
    }
}
