package c.a.t0.s2.u.g;

import android.content.Context;
import android.content.DialogInterface;
import c.a.d.a.f;
import c.a.d.a.j;
import c.a.s0.s.i0.c;
import c.a.t0.s2.l;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.pb.pb.report.UEGReportResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a implements c.a.t0.e4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f23774b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.t0.s2.u.g.b f23775c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.s0.s.i0.a f23776d;

    /* renamed from: e  reason: collision with root package name */
    public c f23777e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f23778f;

    /* renamed from: c.a.t0.s2.u.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class DialogInterface$OnCancelListenerC1398a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23779e;

        public DialogInterface$OnCancelListenerC1398a(a aVar) {
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
            this.f23779e = aVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                MessageManager.getInstance().removeMessage(this.f23779e.f23774b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof UEGReportResponsedMessage)) {
                if (this.a.f23776d != null) {
                    this.a.f23776d.h(false);
                }
                UEGReportResponsedMessage uEGReportResponsedMessage = (UEGReportResponsedMessage) httpResponsedMessage;
                String url = uEGReportResponsedMessage.getUrl();
                if (!StringUtils.isNull(url)) {
                    this.a.i(url);
                    return;
                }
                String errorString = uEGReportResponsedMessage.getErrorString();
                if (StringUtils.isNull(errorString)) {
                    errorString = this.a.a.getString(l.neterror);
                }
                this.a.f23777e.b(errorString);
            }
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23778f = new b(this, CmdConfigHttp.CMD_UEG_REPORT);
        this.a = context;
        this.f23775c = new c.a.t0.s2.u.g.b();
        c cVar = new c();
        this.f23777e = cVar;
        cVar.a = 1000L;
    }

    @Override // c.a.t0.e4.a
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            j();
            this.f23775c.a(str);
        }
    }

    @Override // c.a.t0.e4.a
    public void b(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            this.f23774b = bdUniqueId;
            this.f23775c.c(bdUniqueId);
            this.f23778f.setTag(bdUniqueId);
            this.f23778f.setSelfListener(true);
            MessageManager.getInstance().registerListener(this.f23778f);
        }
    }

    @Override // c.a.t0.e4.a
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            j();
            this.f23775c.b(str);
        }
    }

    public final void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.a, this.a.getString(l.pb_web_view_report_title), str, true)));
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f23776d == null) {
                f<?> a = j.a(this.a);
                TbPageContext tbPageContext = a instanceof TbPageContext ? (TbPageContext) a : null;
                if (tbPageContext == null) {
                    return;
                }
                c.a.s0.s.i0.a aVar = new c.a.s0.s.i0.a(tbPageContext);
                this.f23776d = aVar;
                aVar.e(new DialogInterface$OnCancelListenerC1398a(this));
            }
            this.f23776d.h(true);
        }
    }
}
