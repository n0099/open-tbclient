package c.a.p0.f1.m1;

import android.view.View;
import android.view.ViewGroup;
import c.a.o0.r.t.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.broadcast.ForumManagerRightsResMsg;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.view.ScreenTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public int f14237b;

    /* renamed from: c  reason: collision with root package name */
    public String f14238c;

    /* renamed from: d  reason: collision with root package name */
    public String f14239d;

    /* renamed from: e  reason: collision with root package name */
    public String f14240e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f14241f;

    /* renamed from: c.a.p0.f1.m1.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1069a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.o0.r.t.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f14242b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f14243c;

        /* renamed from: c.a.p0.f1.m1.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class View$OnClickListenerC1070a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ C1069a a;

            public View$OnClickListenerC1070a(C1069a c1069a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1069a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = c1069a;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", this.a.f14243c.f14238c);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a.f14243c.a.getPageActivity(), "ForumGradePage", hashMap)));
                }
            }
        }

        public C1069a(a aVar, c.a.o0.r.t.a aVar2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14243c = aVar;
            this.a = aVar2;
            this.f14242b = i;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                c.a.o0.r.j0.b.k().u("key_forum_broadcast_no_tip_again", this.a.isNoTipAgainChecked());
                this.a.dismiss();
                if (this.f14242b == 0) {
                    ScreenTopToast screenTopToast = new ScreenTopToast(this.f14243c.a.getPageActivity());
                    screenTopToast.m(this.f14243c.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f06bf));
                    screenTopToast.k(this.f14243c.a.getString(R.string.obfuscated_res_0x7f0f0720));
                    screenTopToast.j(new View$OnClickListenerC1070a(this));
                    screenTopToast.n((ViewGroup) this.f14243c.a.getPageActivity().findViewById(R.id.obfuscated_res_0x7f090abb));
                    return;
                }
                ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(this.f14243c.a.getPageActivity());
                if (this.f14243c.f14237b == 1) {
                    forumBroadcastHelper.jumpFlutterEditGenear(this.f14243c.f14238c, this.f14243c.f14239d, "3");
                } else if (this.f14243c.f14237b == 2) {
                    forumBroadcastHelper.jumpFlutterEditGenear(this.f14243c.f14238c, this.f14243c.f14239d, "4");
                } else {
                    forumBroadcastHelper.jumpFlutterEditGenear(this.f14243c.f14238c, this.f14243c.f14239d, "0");
                }
                forumBroadcastHelper.clipCopy(this.f14243c.f14240e);
                forumBroadcastHelper.start();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.o0.r.t.a a;

        public b(a aVar, c.a.o0.r.t.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar2;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                c.a.o0.r.j0.b.k().u("key_call_fans_no_tip_again", false);
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i)};
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof ForumManagerRightsResMsg)) {
                ForumManagerRightsResMsg forumManagerRightsResMsg = (ForumManagerRightsResMsg) httpResponsedMessage;
                boolean h2 = c.a.o0.r.j0.b.k().h("key_forum_broadcast_no_tip_again", false);
                int i = forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount;
                if (!h2) {
                    this.a.j(i);
                } else if (this.a.f14237b == 1) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f13ff);
                } else if (this.a.f14237b == 2) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f10ed);
                }
            }
        }
    }

    public a(TbPageContext tbPageContext) {
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
        this.f14241f = new c(this, CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS);
        this.a = tbPageContext;
        i();
        tbPageContext.registerListener(this.f14241f);
    }

    public void g(int i, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, str3}) == null) {
            this.f14237b = i;
            this.f14238c = str;
            this.f14239d = str2;
            this.f14240e = str3;
            h(str);
        }
    }

    public final void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            httpMessage.addParam("forum_id", str);
            this.a.sendMessage(httpMessage);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS, TbConfig.SERVER_ADDRESS + "c/f/forum/getForumMangerRights");
            tbHttpMessageTask.setResponsedClass(ForumManagerRightsResMsg.class);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    public final void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.a.getPageActivity());
            aVar.setUseNoTipAgainStyle(true);
            aVar.setNegativeTextColor(R.color.CAM_X0105);
            int i2 = this.f14237b;
            if (i2 == 1) {
                aVar.setTitle(R.string.obfuscated_res_0x7f0f13ff);
            } else if (i2 == 2) {
                aVar.setTitle(R.string.obfuscated_res_0x7f0f10ed);
            }
            aVar.setMessage(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0641), Integer.valueOf(i)));
            aVar.setContentViewSize(1);
            aVar.setPositiveButton(this.a.getString(R.string.obfuscated_res_0x7f0f10db), new C1069a(this, aVar, i));
            aVar.setNegativeButton(this.a.getString(R.string.obfuscated_res_0x7f0f0c21), new b(this, aVar));
            aVar.create(this.a).show();
        }
    }
}
