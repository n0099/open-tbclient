package c.a.r0.v.d.f.c;

import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.f0.f;
import c.a.q0.s.f0.g;
import c.a.r0.v.d.f.a.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.data.AlaAttentionData;
import com.baidu.ala.view.AlaAttentionManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.AlaRecentHistoryActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AlaRecentHistoryActivity f25768a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f25769b;

    /* renamed from: c  reason: collision with root package name */
    public View f25770c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f25771d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f25772e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f25773f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f25774g;

    /* renamed from: h  reason: collision with root package name */
    public g f25775h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.v.d.f.a.a f25776i;

    /* renamed from: j  reason: collision with root package name */
    public int f25777j;
    public c.a.r0.v.d.f.b.b k;
    public CustomMessageListener l;

    /* renamed from: c.a.r0.v.d.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1204a implements c.InterfaceC1203c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f25778a;

        public C1204a(a aVar) {
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
            this.f25778a = aVar;
        }

        @Override // c.a.r0.v.d.f.a.c.InterfaceC1203c
        public void a(c.a.r0.v.d.f.b.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                this.f25778a.k = bVar;
                this.f25778a.m(bVar.f25762a.J(), bVar.f25763b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(a aVar) {
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
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) && i2 == 0) {
                c.a.r0.v.d.e.a.c().g();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f25779a;

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
            this.f25779a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f48084c) || this.f25779a.k == null) {
                    return;
                }
                if (updateAttentionMessage.getData().f48084c.equals(String.valueOf((this.f25779a.k.f25762a == null || this.f25779a.k.f25762a.J() == null) ? -100L : this.f25779a.k.f25762a.J().getUserIdLong()))) {
                    if (updateAttentionMessage.getData().f48082a) {
                        this.f25779a.k.f25763b = true;
                        if (this.f25779a.f25776i instanceof c.a.r0.v.d.f.a.c) {
                            this.f25779a.f25776i.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    this.f25779a.k.f25763b = false;
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25769b = tbPageContext;
        this.f25768a = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.f25777j = i2;
        j();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f25772e.completePullRefresh();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = this.f25777j;
            if (i2 == 0) {
                this.f25776i = new c.a.r0.v.d.f.a.b(this.f25769b);
            } else if (1 == i2) {
                this.f25776i = new c.a.r0.v.d.f.a.c(this.f25769b);
                n();
                ((c.a.r0.v.d.f.a.c) this.f25776i).i(new C1204a(this));
            }
            this.f25772e.setAdapter((ListAdapter) this.f25776i);
            this.f25772e.setOnScrollListener(new b(this));
        }
    }

    public ViewGroup g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25771d : (ViewGroup) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f25770c : (View) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            f();
        }
    }

    public void j() {
        ColorDrawable colorDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View inflate = LayoutInflater.from(this.f25768a).inflate(R.layout.square_recent_history_view, (ViewGroup) null);
            this.f25770c = inflate;
            inflate.setPadding(0, (int) this.f25768a.getResources().getDimension(R.dimen.ds80), 0, 0);
            this.f25771d = (FrameLayout) this.f25770c.findViewById(R.id.square_recent_history_container);
            this.f25772e = (BdListView) this.f25770c.findViewById(R.id.square_recent_history_listview);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                colorDrawable = new ColorDrawable(this.f25768a.getPageContext().getResources().getColor(R.color.CAM_X0204_1));
            } else {
                colorDrawable = new ColorDrawable(this.f25768a.getPageContext().getResources().getColor(R.color.CAM_X0204));
            }
            this.f25772e.setDivider(colorDrawable);
            this.f25772e.setDividerHeight(this.f25768a.getActivity().getResources().getDimensionPixelSize(R.dimen.ds1));
            this.f25773f = (NoNetworkView) this.f25770c.findViewById(R.id.square_recent_history_network);
            g gVar = new g(this.f25769b);
            this.f25775h = gVar;
            gVar.V(this.f25768a.getUniqueId());
            this.f25772e.setPullRefresh(this.f25775h);
            PbListView pbListView = new PbListView(this.f25768a);
            this.f25774g = pbListView;
            pbListView.a();
            i();
        }
    }

    public void k(int i2) {
        NoNetworkView noNetworkView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (noNetworkView = this.f25773f) == null) {
            return;
        }
        noNetworkView.onChangeSkinType(this.f25769b, i2);
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.l == null) {
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.l);
    }

    public final void m(MetaData metaData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, metaData, z) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.f25769b.getPageActivity());
                return;
            }
            String valueOf = String.valueOf(metaData.getUserId());
            AlaAttentionManager.getInstance().updateAttention(valueOf, new AlaAttentionData(metaData.getPortrait(), valueOf, "1", !z, null));
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.l = new c(this, 2001115);
            MessageManager.getInstance().registerListener(this.l);
        }
    }

    public void o(List<c.a.r0.v.d.f.b.b> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, list, z) == null) {
            c.a.r0.v.d.f.a.a aVar = this.f25776i;
            if (aVar instanceof c.a.r0.v.d.f.a.b) {
                aVar.c(list);
            } else if (aVar instanceof c.a.r0.v.d.f.a.c) {
                aVar.c(list);
            }
            if (z) {
                s();
            } else {
                t();
            }
        }
    }

    public void p(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, gVar) == null) {
            this.f25775h.a(gVar);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f25772e.setNextPage(null);
        }
    }

    public void r(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, pVar) == null) {
            this.f25772e.setOnSrollToBottomListener(pVar);
        }
    }

    public final void s() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (pbListView = this.f25774g) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f25772e.setNextPage(this.f25774g);
        }
        this.f25774g.M();
        this.f25774g.O();
    }

    public final void t() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (pbListView = this.f25774g) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f25772e.setNextPage(this.f25774g);
        }
        this.f25774g.A(this.f25768a.getPageContext().getResources().getString(R.string.list_no_more));
        this.f25774g.f();
    }
}
