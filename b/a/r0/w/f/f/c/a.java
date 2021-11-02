package b.a.r0.w.f.f.c;

import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.g0.f;
import b.a.q0.s.g0.g;
import b.a.r0.w.f.f.a.c;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AlaRecentHistoryActivity f24803a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f24804b;

    /* renamed from: c  reason: collision with root package name */
    public View f24805c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f24806d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f24807e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f24808f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f24809g;

    /* renamed from: h  reason: collision with root package name */
    public g f24810h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.r0.w.f.f.a.a f24811i;
    public int j;
    public b.a.r0.w.f.f.b.b k;
    public CustomMessageListener l;

    /* renamed from: b.a.r0.w.f.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1212a implements c.InterfaceC1211c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f24812a;

        public C1212a(a aVar) {
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
            this.f24812a = aVar;
        }

        @Override // b.a.r0.w.f.f.a.c.InterfaceC1211c
        public void a(b.a.r0.w.f.f.b.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                this.f24812a.k = bVar;
                this.f24812a.m(bVar.f24797a.J(), bVar.f24798b);
            }
        }
    }

    /* loaded from: classes5.dex */
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
                b.a.r0.w.f.e.a.c().g();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f24813a;

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
            this.f24813a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f45669c) || this.f24813a.k == null) {
                    return;
                }
                if (updateAttentionMessage.getData().f45669c.equals(String.valueOf((this.f24813a.k.f24797a == null || this.f24813a.k.f24797a.J() == null) ? -100L : this.f24813a.k.f24797a.J().getUserIdLong()))) {
                    if (updateAttentionMessage.getData().f45667a) {
                        this.f24813a.k.f24798b = true;
                        if (this.f24813a.f24811i instanceof b.a.r0.w.f.f.a.c) {
                            this.f24813a.f24811i.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    this.f24813a.k.f24798b = false;
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
        this.f24804b = tbPageContext;
        this.f24803a = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.j = i2;
        j();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f24807e.completePullRefresh();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = this.j;
            if (i2 == 0) {
                this.f24811i = new b.a.r0.w.f.f.a.b(this.f24804b);
            } else if (1 == i2) {
                this.f24811i = new b.a.r0.w.f.f.a.c(this.f24804b);
                n();
                ((b.a.r0.w.f.f.a.c) this.f24811i).i(new C1212a(this));
            }
            this.f24807e.setAdapter((ListAdapter) this.f24811i);
            this.f24807e.setOnScrollListener(new b(this));
        }
    }

    public ViewGroup g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f24806d : (ViewGroup) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f24805c : (View) invokeV.objValue;
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
            View inflate = LayoutInflater.from(this.f24803a).inflate(R.layout.square_recent_history_view, (ViewGroup) null);
            this.f24805c = inflate;
            inflate.setPadding(0, (int) this.f24803a.getResources().getDimension(R.dimen.ds80), 0, 0);
            this.f24806d = (FrameLayout) this.f24805c.findViewById(R.id.square_recent_history_container);
            this.f24807e = (BdListView) this.f24805c.findViewById(R.id.square_recent_history_listview);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                colorDrawable = new ColorDrawable(this.f24803a.getPageContext().getResources().getColor(R.color.CAM_X0204_1));
            } else {
                colorDrawable = new ColorDrawable(this.f24803a.getPageContext().getResources().getColor(R.color.CAM_X0204));
            }
            this.f24807e.setDivider(colorDrawable);
            this.f24807e.setDividerHeight(this.f24803a.getActivity().getResources().getDimensionPixelSize(R.dimen.ds1));
            this.f24808f = (NoNetworkView) this.f24805c.findViewById(R.id.square_recent_history_network);
            g gVar = new g(this.f24804b);
            this.f24810h = gVar;
            gVar.U(this.f24803a.getUniqueId());
            this.f24807e.setPullRefresh(this.f24810h);
            PbListView pbListView = new PbListView(this.f24803a);
            this.f24809g = pbListView;
            pbListView.a();
            i();
        }
    }

    public void k(int i2) {
        NoNetworkView noNetworkView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (noNetworkView = this.f24808f) == null) {
            return;
        }
        noNetworkView.onChangeSkinType(this.f24804b, i2);
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
                ViewHelper.skipToLoginActivity(this.f24804b.getPageActivity());
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

    public void o(List<b.a.r0.w.f.f.b.b> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, list, z) == null) {
            b.a.r0.w.f.f.a.a aVar = this.f24811i;
            if (aVar instanceof b.a.r0.w.f.f.a.b) {
                aVar.c(list);
            } else if (aVar instanceof b.a.r0.w.f.f.a.c) {
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
            this.f24810h.a(gVar);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f24807e.setNextPage(null);
        }
    }

    public void r(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, pVar) == null) {
            this.f24807e.setOnSrollToBottomListener(pVar);
        }
    }

    public final void s() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (pbListView = this.f24809g) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f24807e.setNextPage(this.f24809g);
        }
        this.f24809g.O();
        this.f24809g.Q();
    }

    public final void t() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (pbListView = this.f24809g) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f24807e.setNextPage(this.f24809g);
        }
        this.f24809g.C(this.f24803a.getPageContext().getResources().getString(R.string.list_no_more));
        this.f24809g.f();
    }
}
