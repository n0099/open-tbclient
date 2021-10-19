package c.a.r0.x0.k1;

import android.view.View;
import android.view.ViewGroup;
import c.a.q0.s.s.a;
import c.a.r0.k3.i0.n;
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
import com.baidu.tieba.view.ScreenTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f27122a;

    /* renamed from: b  reason: collision with root package name */
    public int f27123b;

    /* renamed from: c  reason: collision with root package name */
    public String f27124c;

    /* renamed from: d  reason: collision with root package name */
    public String f27125d;

    /* renamed from: e  reason: collision with root package name */
    public String f27126e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f27127f;

    /* renamed from: c.a.r0.x0.k1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1268a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f27128e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f27129f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f27130g;

        /* renamed from: c.a.r0.x0.k1.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC1269a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1268a f27131e;

            public View$OnClickListenerC1269a(C1268a c1268a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1268a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f27131e = c1268a;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", this.f27131e.f27130g.f27124c);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new n(this.f27131e.f27130g.f27122a.getPageActivity(), "ForumGradePage", hashMap)));
                }
            }
        }

        public C1268a(a aVar, c.a.q0.s.s.a aVar2, int i2) {
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
            this.f27130g = aVar;
            this.f27128e = aVar2;
            this.f27129f = i2;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                c.a.q0.s.d0.b.j().t("key_forum_broadcast_no_tip_again", this.f27128e.isNoTipAgainChecked());
                this.f27128e.dismiss();
                if (this.f27129f == 0) {
                    new ScreenTopToast(this.f27130g.f27122a.getPageActivity()).setTitle(this.f27130g.f27122a.getPageActivity().getString(R.string.frs_forum_bawu_send_broadcast_none_tip)).setBtnText(this.f27130g.f27122a.getString(R.string.frs_recommend_fail_tip_btn)).setBtnClickListener(new View$OnClickListenerC1269a(this)).show((ViewGroup) this.f27130g.f27122a.getPageActivity().findViewById(R.id.frs));
                    return;
                }
                ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(this.f27130g.f27122a.getPageActivity());
                if (this.f27130g.f27123b == 1) {
                    forumBroadcastHelper.jumpFlutterEditGenear(this.f27130g.f27124c, this.f27130g.f27125d, "3");
                } else if (this.f27130g.f27123b == 2) {
                    forumBroadcastHelper.jumpFlutterEditGenear(this.f27130g.f27124c, this.f27130g.f27125d, "4");
                } else {
                    forumBroadcastHelper.jumpFlutterEditGenear(this.f27130g.f27124c, this.f27130g.f27125d, "0");
                }
                forumBroadcastHelper.clipCopy(this.f27130g.f27126e);
                forumBroadcastHelper.start();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f27132e;

        public b(a aVar, c.a.q0.s.s.a aVar2) {
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
            this.f27132e = aVar2;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                c.a.q0.s.d0.b.j().t("key_call_fans_no_tip_again", false);
                this.f27132e.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f27133a;

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
            this.f27133a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof ForumManagerRightsResMsg)) {
                ForumManagerRightsResMsg forumManagerRightsResMsg = (ForumManagerRightsResMsg) httpResponsedMessage;
                boolean g2 = c.a.q0.s.d0.b.j().g("key_forum_broadcast_no_tip_again", false);
                int i2 = forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount;
                if (!g2) {
                    this.f27133a.j(i2);
                } else if (this.f27133a.f27123b == 1) {
                    this.f27133a.f27122a.showToast(R.string.top_success);
                } else if (this.f27133a.f27123b == 2) {
                    this.f27133a.f27122a.showToast(R.string.set_good_success);
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
        this.f27127f = new c(this, CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS);
        this.f27122a = tbPageContext;
        i();
        tbPageContext.registerListener(this.f27127f);
    }

    public void g(int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, str2, str3}) == null) {
            this.f27123b = i2;
            this.f27124c = str;
            this.f27125d = str2;
            this.f27126e = str3;
            h(str);
        }
    }

    public final void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            httpMessage.addParam("forum_id", str);
            this.f27122a.sendMessage(httpMessage);
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
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f27122a.getPageActivity());
            aVar.setUseNoTipAgainStyle(true);
            aVar.setNegativeTextColor(R.color.CAM_X0105);
            int i3 = this.f27123b;
            if (i3 == 1) {
                aVar.setTitle(R.string.top_success);
            } else if (i3 == 2) {
                aVar.setTitle(R.string.set_good_success);
            }
            aVar.setMessage(String.format(this.f27122a.getString(R.string.forum_broadcast_intro), Integer.valueOf(i2)));
            aVar.setContentViewSize(1);
            aVar.setPositiveButton(this.f27122a.getString(R.string.send_forum_broadcast), new C1268a(this, aVar, i2));
            aVar.setNegativeButton(this.f27122a.getString(R.string.next_time), new b(this, aVar));
            aVar.create(this.f27122a).show();
        }
    }
}
