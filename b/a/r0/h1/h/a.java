package b.a.r0.h1.h;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipHttpResMsg;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipSocketResMsg;
import com.baidu.tieba.homepage.personalize.view.ConcernUnreadTipView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ScrollFragmentTabHost f17275a;

    /* renamed from: b  reason: collision with root package name */
    public PersonalizePageView f17276b;

    /* renamed from: c  reason: collision with root package name */
    public ConcernUnreadTipView f17277c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext f17278d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f17279e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f17280f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.e.c.g.a f17281g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f17282h;

    /* renamed from: b.a.r0.h1.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC0887a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f17283e;

        public RunnableC0887a(a aVar) {
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
            this.f17283e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f17283e.f17276b == null) {
                return;
            }
            if (this.f17283e.f17277c != null) {
                this.f17283e.f17276b.removeView(this.f17283e.f17277c);
                TiebaStatic.log(new StatisticItem("c12632").param("obj_locate", 3));
            }
            this.f17283e.f17276b.setIsUnreadTipShow(false);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f17284a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17284a = aVar;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                    this.f17284a.e(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
                } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                    this.f17284a.e(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f17285a;

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
            this.f17285a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f17285a.f(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f17286e;

        public d(a aVar) {
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
            this.f17286e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17286e.f17277c == null || this.f17286e.f17277c.mClose == null) {
                return;
            }
            if (view.getId() != this.f17286e.f17277c.mClose.getId()) {
                if (this.f17286e.f17275a != null) {
                    this.f17286e.f17275a.setCurrentTab(0);
                    return;
                }
                return;
            }
            this.f17286e.f(false);
            TiebaStatic.log(new StatisticItem("c12632").param("obj_locate", 1));
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
        this.f17280f = new RunnableC0887a(this);
        this.f17281g = new b(this, CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541);
        this.f17282h = new c(this, 2921064);
        if (tbPageContext == null) {
            return;
        }
        this.f17278d = tbPageContext;
        tbPageContext.registerListener(this.f17281g);
        tbPageContext.registerListener(this.f17282h);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, b.a.r0.l3.f0.a.a(TbConfig.URL_CONCERN_UNREAD_TIP, 309541));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(ConcernUnreadTipHttpResMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        b.a.q0.z0.b bVar = new b.a.q0.z0.b(309541);
        bVar.setResponsedClass(ConcernUnreadTipSocketResMsg.class);
        bVar.g(true);
        MessageManager.getInstance().registerTask(bVar);
    }

    public final void e(b.a.r0.h1.h.j.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) && eVar != null && eVar.a()) {
            k(eVar);
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            b.a.e.e.m.e.a().removeCallbacks(this.f17280f);
            PersonalizePageView personalizePageView = this.f17276b;
            if (personalizePageView != null) {
                ConcernUnreadTipView concernUnreadTipView = this.f17277c;
                if (concernUnreadTipView != null) {
                    personalizePageView.removeView(concernUnreadTipView);
                    if (z && this.f17276b.getIsUnreadTipShow()) {
                        b.a.q0.s.e0.b.j().w(b.a.q0.s.e0.b.n("concern_unread_tip_next_show_time"), 0L);
                        TiebaStatic.log(new StatisticItem("c12632").param("obj_locate", 2));
                    }
                }
                this.f17276b.setIsUnreadTipShow(false);
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f17276b = null;
            this.f17275a = null;
            if (this.f17280f != null) {
                b.a.e.e.m.e.a().removeCallbacks(this.f17280f);
            }
            MessageManager.getInstance().unRegisterListener(this.f17281g);
            MessageManager.getInstance().unRegisterListener(this.f17282h);
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            this.f17279e = bdUniqueId;
        }
    }

    public void i(PersonalizePageView personalizePageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, personalizePageView) == null) {
            this.f17276b = personalizePageView;
        }
    }

    public void j(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, scrollFragmentTabHost) == null) {
            this.f17275a = scrollFragmentTabHost;
        }
    }

    public void k(b.a.r0.h1.h.j.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) || this.f17276b == null) {
            return;
        }
        ConcernUnreadTipView concernUnreadTipView = new ConcernUnreadTipView(this.f17278d.getContext());
        this.f17277c = concernUnreadTipView;
        concernUnreadTipView.setBdUniqueId(this.f17279e);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 49;
        this.f17277c.setLayoutParams(layoutParams);
        this.f17277c.setData(eVar);
        this.f17277c.setClickListener(new d(this));
        this.f17276b.setIsUnreadTipShow(true);
        this.f17276b.addView(this.f17277c);
        if (eVar != null) {
            TiebaStatic.log(new StatisticItem("c12631").param("obj_param1", eVar.f17451a).param(TiebaStatic.Params.OBJ_PARAM2, eVar.f17455e));
        }
        b.a.e.e.m.e.a().postDelayed(this.f17280f, 5000L);
    }
}
