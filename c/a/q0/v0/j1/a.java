package c.a.q0.v0.j1;

import android.view.View;
import android.view.ViewGroup;
import c.a.p0.s.s.a;
import c.a.q0.i3.i0.n;
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
    public TbPageContext f26261a;

    /* renamed from: b  reason: collision with root package name */
    public int f26262b;

    /* renamed from: c  reason: collision with root package name */
    public String f26263c;

    /* renamed from: d  reason: collision with root package name */
    public String f26264d;

    /* renamed from: e  reason: collision with root package name */
    public String f26265e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f26266f;

    /* renamed from: c.a.q0.v0.j1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1222a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.s.s.a f26267e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f26268f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f26269g;

        /* renamed from: c.a.q0.v0.j1.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC1223a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1222a f26270e;

            public View$OnClickListenerC1223a(C1222a c1222a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1222a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f26270e = c1222a;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", this.f26270e.f26269g.f26263c);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new n(this.f26270e.f26269g.f26261a.getPageActivity(), "ForumGradePage", hashMap)));
                }
            }
        }

        public C1222a(a aVar, c.a.p0.s.s.a aVar2, int i2) {
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
            this.f26269g = aVar;
            this.f26267e = aVar2;
            this.f26268f = i2;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                c.a.p0.s.d0.b.j().t("key_forum_broadcast_no_tip_again", this.f26267e.isNoTipAgainChecked());
                this.f26267e.dismiss();
                if (this.f26268f == 0) {
                    new ScreenTopToast(this.f26269g.f26261a.getPageActivity()).setTitle(this.f26269g.f26261a.getPageActivity().getString(R.string.frs_forum_bawu_send_broadcast_none_tip)).setBtnText(this.f26269g.f26261a.getString(R.string.frs_recommend_fail_tip_btn)).setBtnClickListener(new View$OnClickListenerC1223a(this)).show((ViewGroup) this.f26269g.f26261a.getPageActivity().findViewById(R.id.frs));
                    return;
                }
                ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(this.f26269g.f26261a.getPageActivity());
                if (this.f26269g.f26262b == 1) {
                    forumBroadcastHelper.jumpFlutterEditGenear(this.f26269g.f26263c, this.f26269g.f26264d, "3");
                } else if (this.f26269g.f26262b == 2) {
                    forumBroadcastHelper.jumpFlutterEditGenear(this.f26269g.f26263c, this.f26269g.f26264d, "4");
                } else {
                    forumBroadcastHelper.jumpFlutterEditGenear(this.f26269g.f26263c, this.f26269g.f26264d, "0");
                }
                forumBroadcastHelper.clipCopy(this.f26269g.f26265e);
                forumBroadcastHelper.start();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.s.s.a f26271e;

        public b(a aVar, c.a.p0.s.s.a aVar2) {
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
            this.f26271e = aVar2;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                c.a.p0.s.d0.b.j().t("key_call_fans_no_tip_again", false);
                this.f26271e.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26272a;

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
            this.f26272a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof ForumManagerRightsResMsg)) {
                ForumManagerRightsResMsg forumManagerRightsResMsg = (ForumManagerRightsResMsg) httpResponsedMessage;
                boolean g2 = c.a.p0.s.d0.b.j().g("key_forum_broadcast_no_tip_again", false);
                int i2 = forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount;
                if (!g2) {
                    this.f26272a.j(i2);
                } else if (this.f26272a.f26262b == 1) {
                    this.f26272a.f26261a.showToast(R.string.top_success);
                } else if (this.f26272a.f26262b == 2) {
                    this.f26272a.f26261a.showToast(R.string.set_good_success);
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
        this.f26266f = new c(this, CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS);
        this.f26261a = tbPageContext;
        i();
        tbPageContext.registerListener(this.f26266f);
    }

    public void g(int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, str2, str3}) == null) {
            this.f26262b = i2;
            this.f26263c = str;
            this.f26264d = str2;
            this.f26265e = str3;
            h(str);
        }
    }

    public final void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            httpMessage.addParam("forum_id", str);
            this.f26261a.sendMessage(httpMessage);
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
            c.a.p0.s.s.a aVar = new c.a.p0.s.s.a(this.f26261a.getPageActivity());
            aVar.setUseNoTipAgainStyle(true);
            aVar.setNegativeTextColor(R.color.CAM_X0105);
            int i3 = this.f26262b;
            if (i3 == 1) {
                aVar.setTitle(R.string.top_success);
            } else if (i3 == 2) {
                aVar.setTitle(R.string.set_good_success);
            }
            aVar.setMessage(String.format(this.f26261a.getString(R.string.forum_broadcast_intro), Integer.valueOf(i2)));
            aVar.setContentViewSize(1);
            aVar.setPositiveButton(this.f26261a.getString(R.string.send_forum_broadcast), new C1222a(this, aVar, i2));
            aVar.setNegativeButton(this.f26261a.getString(R.string.next_time), new b(this, aVar));
            aVar.create(this.f26261a).show();
        }
    }
}
