package c.a.t0.o1.h;

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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ScrollFragmentTabHost a;

    /* renamed from: b  reason: collision with root package name */
    public PersonalizePageView f20982b;

    /* renamed from: c  reason: collision with root package name */
    public ConcernUnreadTipView f20983c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext f20984d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f20985e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f20986f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.d.c.g.a f20987g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f20988h;

    /* renamed from: c.a.t0.o1.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1268a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20989e;

        public RunnableC1268a(a aVar) {
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
            this.f20989e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f20989e.f20982b == null) {
                return;
            }
            if (this.f20989e.f20983c != null) {
                this.f20989e.f20982b.removeView(this.f20989e.f20983c);
                TiebaStatic.log(new StatisticItem("c12632").param("obj_locate", 3));
            }
            this.f20989e.f20982b.setIsUnreadTipShow(false);
        }
    }

    /* loaded from: classes7.dex */
    public class b extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                    this.a.e(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
                } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                    this.a.e(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.f(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20990e;

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
            this.f20990e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f20990e.f20983c == null || this.f20990e.f20983c.mClose == null) {
                return;
            }
            if (view.getId() != this.f20990e.f20983c.mClose.getId()) {
                if (this.f20990e.a != null) {
                    this.f20990e.a.setCurrentTab(0);
                    return;
                }
                return;
            }
            this.f20990e.f(false);
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
        this.f20986f = new RunnableC1268a(this);
        this.f20987g = new b(this, CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541);
        this.f20988h = new c(this, 2921064);
        if (tbPageContext == null) {
            return;
        }
        this.f20984d = tbPageContext;
        tbPageContext.registerListener(this.f20987g);
        tbPageContext.registerListener(this.f20988h);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, c.a.t0.w3.f0.a.a(TbConfig.URL_CONCERN_UNREAD_TIP, 309541));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(ConcernUnreadTipHttpResMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        c.a.s0.a1.b bVar = new c.a.s0.a1.b(309541);
        bVar.setResponsedClass(ConcernUnreadTipSocketResMsg.class);
        bVar.g(true);
        MessageManager.getInstance().registerTask(bVar);
    }

    public final void e(c.a.t0.o1.h.j.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) && eVar != null && eVar.a()) {
            k(eVar);
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.f20986f);
            PersonalizePageView personalizePageView = this.f20982b;
            if (personalizePageView != null) {
                ConcernUnreadTipView concernUnreadTipView = this.f20983c;
                if (concernUnreadTipView != null) {
                    personalizePageView.removeView(concernUnreadTipView);
                    if (z && this.f20982b.getIsUnreadTipShow()) {
                        c.a.s0.s.g0.b.j().w(c.a.s0.s.g0.b.n("concern_unread_tip_next_show_time"), 0L);
                        TiebaStatic.log(new StatisticItem("c12632").param("obj_locate", 2));
                    }
                }
                this.f20982b.setIsUnreadTipShow(false);
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f20982b = null;
            this.a = null;
            if (this.f20986f != null) {
                c.a.d.f.m.e.a().removeCallbacks(this.f20986f);
            }
            MessageManager.getInstance().unRegisterListener(this.f20987g);
            MessageManager.getInstance().unRegisterListener(this.f20988h);
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            this.f20985e = bdUniqueId;
        }
    }

    public void i(PersonalizePageView personalizePageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, personalizePageView) == null) {
            this.f20982b = personalizePageView;
        }
    }

    public void j(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, scrollFragmentTabHost) == null) {
            this.a = scrollFragmentTabHost;
        }
    }

    public void k(c.a.t0.o1.h.j.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) || this.f20982b == null) {
            return;
        }
        ConcernUnreadTipView concernUnreadTipView = new ConcernUnreadTipView(this.f20984d.getContext());
        this.f20983c = concernUnreadTipView;
        concernUnreadTipView.setBdUniqueId(this.f20985e);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 49;
        this.f20983c.setLayoutParams(layoutParams);
        this.f20983c.setData(eVar);
        this.f20983c.setClickListener(new d(this));
        this.f20982b.setIsUnreadTipShow(true);
        this.f20982b.addView(this.f20983c);
        if (eVar != null) {
            TiebaStatic.log(new StatisticItem("c12631").param("obj_param1", eVar.a).param(TiebaStatic.Params.OBJ_PARAM2, eVar.f21103e));
        }
        c.a.d.f.m.e.a().postDelayed(this.f20986f, 5000L);
    }
}
