package c.a.q0.f1.h;

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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ScrollFragmentTabHost f17636a;

    /* renamed from: b  reason: collision with root package name */
    public PersonalizePageView f17637b;

    /* renamed from: c  reason: collision with root package name */
    public ConcernUnreadTipView f17638c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext f17639d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f17640e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f17641f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.e.c.g.a f17642g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f17643h;

    /* renamed from: c.a.q0.f1.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0854a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f17644e;

        public RunnableC0854a(a aVar) {
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
            this.f17644e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f17644e.f17637b == null) {
                return;
            }
            if (this.f17644e.f17638c != null) {
                this.f17644e.f17637b.removeView(this.f17644e.f17638c);
                TiebaStatic.log(new StatisticItem("c12632").param("obj_locate", 3));
            }
            this.f17644e.f17637b.setIsUnreadTipShow(false);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f17645a;

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
            this.f17645a = aVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                    this.f17645a.e(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
                } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                    this.f17645a.e(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f17646a;

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
            this.f17646a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f17646a.f(true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f17647e;

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
            this.f17647e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17647e.f17638c == null || this.f17647e.f17638c.mClose == null) {
                return;
            }
            if (view.getId() != this.f17647e.f17638c.mClose.getId()) {
                if (this.f17647e.f17636a != null) {
                    this.f17647e.f17636a.setCurrentTab(0);
                    return;
                }
                return;
            }
            this.f17647e.f(false);
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
        this.f17641f = new RunnableC0854a(this);
        this.f17642g = new b(this, CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541);
        this.f17643h = new c(this, 2921064);
        if (tbPageContext == null) {
            return;
        }
        this.f17639d = tbPageContext;
        tbPageContext.registerListener(this.f17642g);
        tbPageContext.registerListener(this.f17643h);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, c.a.q0.i3.d0.a.a(TbConfig.URL_CONCERN_UNREAD_TIP, 309541));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(ConcernUnreadTipHttpResMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        c.a.p0.x0.b bVar = new c.a.p0.x0.b(309541);
        bVar.setResponsedClass(ConcernUnreadTipSocketResMsg.class);
        bVar.g(true);
        MessageManager.getInstance().registerTask(bVar);
    }

    public final void e(c.a.q0.f1.h.j.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) && eVar != null && eVar.a()) {
            k(eVar);
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            c.a.e.e.m.e.a().removeCallbacks(this.f17641f);
            PersonalizePageView personalizePageView = this.f17637b;
            if (personalizePageView != null) {
                ConcernUnreadTipView concernUnreadTipView = this.f17638c;
                if (concernUnreadTipView != null) {
                    personalizePageView.removeView(concernUnreadTipView);
                    if (z && this.f17637b.getIsUnreadTipShow()) {
                        c.a.p0.s.d0.b.j().w(c.a.p0.s.d0.b.n("concern_unread_tip_next_show_time"), 0L);
                        TiebaStatic.log(new StatisticItem("c12632").param("obj_locate", 2));
                    }
                }
                this.f17637b.setIsUnreadTipShow(false);
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f17637b = null;
            this.f17636a = null;
            if (this.f17641f != null) {
                c.a.e.e.m.e.a().removeCallbacks(this.f17641f);
            }
            MessageManager.getInstance().unRegisterListener(this.f17642g);
            MessageManager.getInstance().unRegisterListener(this.f17643h);
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            this.f17640e = bdUniqueId;
        }
    }

    public void i(PersonalizePageView personalizePageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, personalizePageView) == null) {
            this.f17637b = personalizePageView;
        }
    }

    public void j(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, scrollFragmentTabHost) == null) {
            this.f17636a = scrollFragmentTabHost;
        }
    }

    public void k(c.a.q0.f1.h.j.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) || this.f17637b == null) {
            return;
        }
        ConcernUnreadTipView concernUnreadTipView = new ConcernUnreadTipView(this.f17639d.getContext());
        this.f17638c = concernUnreadTipView;
        concernUnreadTipView.setBdUniqueId(this.f17640e);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 49;
        this.f17638c.setLayoutParams(layoutParams);
        this.f17638c.setData(eVar);
        this.f17638c.setClickListener(new d(this));
        this.f17637b.setIsUnreadTipShow(true);
        this.f17637b.addView(this.f17638c);
        if (eVar != null) {
            TiebaStatic.log(new StatisticItem("c12631").param("obj_param1", eVar.f17815a).param(TiebaStatic.Params.OBJ_PARAM2, eVar.f17819e));
        }
        c.a.e.e.m.e.a().postDelayed(this.f17641f, 5000L);
    }
}
