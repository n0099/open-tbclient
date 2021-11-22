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
    public ScrollFragmentTabHost f18743a;

    /* renamed from: b  reason: collision with root package name */
    public PersonalizePageView f18744b;

    /* renamed from: c  reason: collision with root package name */
    public ConcernUnreadTipView f18745c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext f18746d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f18747e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f18748f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.e.c.g.a f18749g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f18750h;

    /* renamed from: b.a.r0.h1.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC0955a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f18751e;

        public RunnableC0955a(a aVar) {
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
            this.f18751e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f18751e.f18744b == null) {
                return;
            }
            if (this.f18751e.f18745c != null) {
                this.f18751e.f18744b.removeView(this.f18751e.f18745c);
                TiebaStatic.log(new StatisticItem("c12632").param("obj_locate", 3));
            }
            this.f18751e.f18744b.setIsUnreadTipShow(false);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f18752a;

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
            this.f18752a = aVar;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                    this.f18752a.e(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
                } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                    this.f18752a.e(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f18753a;

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
            this.f18753a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f18753a.f(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f18754e;

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
            this.f18754e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f18754e.f18745c == null || this.f18754e.f18745c.mClose == null) {
                return;
            }
            if (view.getId() != this.f18754e.f18745c.mClose.getId()) {
                if (this.f18754e.f18743a != null) {
                    this.f18754e.f18743a.setCurrentTab(0);
                    return;
                }
                return;
            }
            this.f18754e.f(false);
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
        this.f18748f = new RunnableC0955a(this);
        this.f18749g = new b(this, CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541);
        this.f18750h = new c(this, 2921064);
        if (tbPageContext == null) {
            return;
        }
        this.f18746d = tbPageContext;
        tbPageContext.registerListener(this.f18749g);
        tbPageContext.registerListener(this.f18750h);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, b.a.r0.m3.f0.a.a(TbConfig.URL_CONCERN_UNREAD_TIP, 309541));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(ConcernUnreadTipHttpResMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        b.a.q0.y0.b bVar = new b.a.q0.y0.b(309541);
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
            b.a.e.f.m.e.a().removeCallbacks(this.f18748f);
            PersonalizePageView personalizePageView = this.f18744b;
            if (personalizePageView != null) {
                ConcernUnreadTipView concernUnreadTipView = this.f18745c;
                if (concernUnreadTipView != null) {
                    personalizePageView.removeView(concernUnreadTipView);
                    if (z && this.f18744b.getIsUnreadTipShow()) {
                        b.a.q0.s.e0.b.j().w(b.a.q0.s.e0.b.n("concern_unread_tip_next_show_time"), 0L);
                        TiebaStatic.log(new StatisticItem("c12632").param("obj_locate", 2));
                    }
                }
                this.f18744b.setIsUnreadTipShow(false);
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f18744b = null;
            this.f18743a = null;
            if (this.f18748f != null) {
                b.a.e.f.m.e.a().removeCallbacks(this.f18748f);
            }
            MessageManager.getInstance().unRegisterListener(this.f18749g);
            MessageManager.getInstance().unRegisterListener(this.f18750h);
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            this.f18747e = bdUniqueId;
        }
    }

    public void i(PersonalizePageView personalizePageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, personalizePageView) == null) {
            this.f18744b = personalizePageView;
        }
    }

    public void j(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, scrollFragmentTabHost) == null) {
            this.f18743a = scrollFragmentTabHost;
        }
    }

    public void k(b.a.r0.h1.h.j.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) || this.f18744b == null) {
            return;
        }
        ConcernUnreadTipView concernUnreadTipView = new ConcernUnreadTipView(this.f18746d.getContext());
        this.f18745c = concernUnreadTipView;
        concernUnreadTipView.setBdUniqueId(this.f18747e);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 49;
        this.f18745c.setLayoutParams(layoutParams);
        this.f18745c.setData(eVar);
        this.f18745c.setClickListener(new d(this));
        this.f18744b.setIsUnreadTipShow(true);
        this.f18744b.addView(this.f18745c);
        if (eVar != null) {
            TiebaStatic.log(new StatisticItem("c12631").param("obj_param1", eVar.f18920a).param(TiebaStatic.Params.OBJ_PARAM2, eVar.f18924e));
        }
        b.a.e.f.m.e.a().postDelayed(this.f18748f, 5000L);
    }
}
