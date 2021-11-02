package b.a.r0.x0.u1;

import android.view.View;
import android.view.ViewGroup;
import b.a.q0.s.s.a;
import b.a.r0.l3.j0.n;
import b.a.r0.x0.b1;
import b.a.r0.x0.e1;
import b.a.r0.x0.h1;
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
import com.baidu.tieba.frs.broadcast.ForumManagerRightsResMsg;
import com.baidu.tieba.view.ScreenTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f26373a;

    /* renamed from: b  reason: collision with root package name */
    public int f26374b;

    /* renamed from: c  reason: collision with root package name */
    public String f26375c;

    /* renamed from: d  reason: collision with root package name */
    public String f26376d;

    /* renamed from: e  reason: collision with root package name */
    public String f26377e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f26378f;

    /* renamed from: b.a.r0.x0.u1.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1292a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f26379e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f26380f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f26381g;

        /* renamed from: b.a.r0.x0.u1.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC1293a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1292a f26382e;

            public View$OnClickListenerC1293a(C1292a c1292a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1292a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f26382e = c1292a;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", this.f26382e.f26381g.f26375c);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new n(this.f26382e.f26381g.f26373a.getPageActivity(), "ForumGradePage", hashMap)));
                }
            }
        }

        public C1292a(a aVar, b.a.q0.s.s.a aVar2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26381g = aVar;
            this.f26379e = aVar2;
            this.f26380f = i2;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                b.a.q0.s.e0.b.j().t("key_forum_broadcast_no_tip_again", this.f26379e.isNoTipAgainChecked());
                this.f26379e.dismiss();
                if (this.f26380f == 0) {
                    new ScreenTopToast(this.f26381g.f26373a.getPageActivity()).setTitle(this.f26381g.f26373a.getPageActivity().getString(h1.frs_forum_bawu_send_broadcast_none_tip)).setBtnText(this.f26381g.f26373a.getString(h1.frs_recommend_fail_tip_btn)).setBtnClickListener(new View$OnClickListenerC1293a(this)).show((ViewGroup) this.f26381g.f26373a.getPageActivity().findViewById(e1.frs));
                    return;
                }
                ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(this.f26381g.f26373a.getPageActivity());
                if (this.f26381g.f26374b == 1) {
                    forumBroadcastHelper.jumpFlutterEditGenear(this.f26381g.f26375c, this.f26381g.f26376d, "3");
                } else if (this.f26381g.f26374b == 2) {
                    forumBroadcastHelper.jumpFlutterEditGenear(this.f26381g.f26375c, this.f26381g.f26376d, "4");
                } else {
                    forumBroadcastHelper.jumpFlutterEditGenear(this.f26381g.f26375c, this.f26381g.f26376d, "0");
                }
                forumBroadcastHelper.clipCopy(this.f26381g.f26377e);
                forumBroadcastHelper.start();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f26383e;

        public b(a aVar, b.a.q0.s.s.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26383e = aVar2;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                b.a.q0.s.e0.b.j().t("key_call_fans_no_tip_again", false);
                this.f26383e.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26384a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, int i2) {
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
            this.f26384a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof ForumManagerRightsResMsg)) {
                ForumManagerRightsResMsg forumManagerRightsResMsg = (ForumManagerRightsResMsg) httpResponsedMessage;
                boolean g2 = b.a.q0.s.e0.b.j().g("key_forum_broadcast_no_tip_again", false);
                int i2 = forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount;
                if (!g2) {
                    this.f26384a.j(i2);
                } else if (this.f26384a.f26374b == 1) {
                    this.f26384a.f26373a.showToast(h1.top_success);
                } else if (this.f26384a.f26374b == 2) {
                    this.f26384a.f26373a.showToast(h1.set_good_success);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26378f = new c(this, CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS);
        this.f26373a = tbPageContext;
        i();
        tbPageContext.registerListener(this.f26378f);
    }

    public void g(int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, str2, str3}) == null) {
            this.f26374b = i2;
            this.f26375c = str;
            this.f26376d = str2;
            this.f26377e = str3;
            h(str);
        }
    }

    public final void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            httpMessage.addParam("forum_id", str);
            this.f26373a.sendMessage(httpMessage);
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

    public final void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f26373a.getPageActivity());
            aVar.setUseNoTipAgainStyle(true);
            aVar.setNegativeTextColor(b1.CAM_X0105);
            int i3 = this.f26374b;
            if (i3 == 1) {
                aVar.setTitle(h1.top_success);
            } else if (i3 == 2) {
                aVar.setTitle(h1.set_good_success);
            }
            aVar.setMessage(String.format(this.f26373a.getString(h1.forum_broadcast_intro), Integer.valueOf(i2)));
            aVar.setContentViewSize(1);
            aVar.setPositiveButton(this.f26373a.getString(h1.send_forum_broadcast), new C1292a(this, aVar, i2));
            aVar.setNegativeButton(this.f26373a.getString(h1.next_time), new b(this, aVar));
            aVar.create(this.f26373a).show();
        }
    }
}
