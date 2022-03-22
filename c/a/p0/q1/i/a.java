package c.a.p0.q1.i;

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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ScrollFragmentTabHost a;

    /* renamed from: b  reason: collision with root package name */
    public PersonalizePageView f17364b;

    /* renamed from: c  reason: collision with root package name */
    public ConcernUnreadTipView f17365c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext f17366d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f17367e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f17368f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.d.c.g.a f17369g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f17370h;

    /* renamed from: c.a.p0.q1.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1305a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public RunnableC1305a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f17364b == null) {
                return;
            }
            if (this.a.f17365c != null) {
                this.a.f17364b.removeView(this.a.f17365c);
                TiebaStatic.log(new StatisticItem("c12632").param("obj_locate", 3));
            }
            this.a.f17364b.setIsUnreadTipShow(false);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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

    /* loaded from: classes2.dex */
    public class c extends CustomMessageListener {
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.f(true);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f17365c == null || this.a.f17365c.a == null) {
                return;
            }
            if (view.getId() != this.a.f17365c.a.getId()) {
                if (this.a.a != null) {
                    this.a.a.setCurrentTab(0);
                    return;
                }
                return;
            }
            this.a.f(false);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17368f = new RunnableC1305a(this);
        this.f17369g = new b(this, CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541);
        this.f17370h = new c(this, 2921064);
        if (tbPageContext == null) {
            return;
        }
        this.f17366d = tbPageContext;
        tbPageContext.registerListener(this.f17369g);
        tbPageContext.registerListener(this.f17370h);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, c.a.p0.a4.g0.a.a(TbConfig.URL_CONCERN_UNREAD_TIP, 309541));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(ConcernUnreadTipHttpResMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        c.a.o0.z0.b bVar = new c.a.o0.z0.b(309541);
        bVar.setResponsedClass(ConcernUnreadTipSocketResMsg.class);
        bVar.g(true);
        MessageManager.getInstance().registerTask(bVar);
    }

    public final void e(c.a.p0.q1.i.j.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) && eVar != null && eVar.a()) {
            k(eVar);
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.f17368f);
            PersonalizePageView personalizePageView = this.f17364b;
            if (personalizePageView != null) {
                ConcernUnreadTipView concernUnreadTipView = this.f17365c;
                if (concernUnreadTipView != null) {
                    personalizePageView.removeView(concernUnreadTipView);
                    if (z && this.f17364b.getIsUnreadTipShow()) {
                        c.a.o0.r.j0.b.k().x(c.a.o0.r.j0.b.o("concern_unread_tip_next_show_time"), 0L);
                        TiebaStatic.log(new StatisticItem("c12632").param("obj_locate", 2));
                    }
                }
                this.f17364b.setIsUnreadTipShow(false);
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f17364b = null;
            this.a = null;
            if (this.f17368f != null) {
                c.a.d.f.m.e.a().removeCallbacks(this.f17368f);
            }
            MessageManager.getInstance().unRegisterListener(this.f17369g);
            MessageManager.getInstance().unRegisterListener(this.f17370h);
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            this.f17367e = bdUniqueId;
        }
    }

    public void i(PersonalizePageView personalizePageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, personalizePageView) == null) {
            this.f17364b = personalizePageView;
        }
    }

    public void j(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, scrollFragmentTabHost) == null) {
            this.a = scrollFragmentTabHost;
        }
    }

    public void k(c.a.p0.q1.i.j.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) || this.f17364b == null) {
            return;
        }
        ConcernUnreadTipView concernUnreadTipView = new ConcernUnreadTipView(this.f17366d.getContext());
        this.f17365c = concernUnreadTipView;
        concernUnreadTipView.setBdUniqueId(this.f17367e);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 49;
        this.f17365c.setLayoutParams(layoutParams);
        this.f17365c.setData(eVar);
        this.f17365c.setClickListener(new d(this));
        this.f17364b.setIsUnreadTipShow(true);
        this.f17364b.addView(this.f17365c);
        if (eVar != null) {
            TiebaStatic.log(new StatisticItem("c12631").param("obj_param1", eVar.a).param(TiebaStatic.Params.OBJ_PARAM2, eVar.f17447e));
        }
        c.a.d.f.m.e.a().postDelayed(this.f17368f, 5000L);
    }
}
