package c.a.p0.c0.f.f.c;

import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.l0.f;
import c.a.o0.r.l0.g;
import c.a.p0.c0.f.f.a.c;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaRecentHistoryActivity a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f13060b;

    /* renamed from: c  reason: collision with root package name */
    public View f13061c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f13062d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f13063e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f13064f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f13065g;

    /* renamed from: h  reason: collision with root package name */
    public g f13066h;
    public c.a.p0.c0.f.f.a.a i;
    public int j;
    public c.a.p0.c0.f.f.b.b k;
    public CustomMessageListener l;

    /* renamed from: c.a.p0.c0.f.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0984a implements c.InterfaceC0983c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0984a(a aVar) {
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

        @Override // c.a.p0.c0.f.f.a.c.InterfaceC0983c
        public void a(c.a.p0.c0.f.f.b.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                this.a.k = bVar;
                this.a.m(bVar.a.getAuthor(), bVar.f13056b);
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) && i == 0) {
                c.a.p0.c0.f.e.a.c().g();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f30338c) || this.a.k == null) {
                    return;
                }
                if (updateAttentionMessage.getData().f30338c.equals(String.valueOf((this.a.k.a == null || this.a.k.a.getAuthor() == null) ? -100L : this.a.k.a.getAuthor().getUserIdLong()))) {
                    if (updateAttentionMessage.getData().a) {
                        this.a.k.f13056b = true;
                        if (this.a.i instanceof c.a.p0.c0.f.f.a.c) {
                            this.a.i.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    this.a.k.f13056b = false;
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13060b = tbPageContext;
        this.a = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.j = i;
        j();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f13063e.z();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i = this.j;
            if (i == 0) {
                this.i = new c.a.p0.c0.f.f.a.b(this.f13060b);
            } else if (1 == i) {
                this.i = new c.a.p0.c0.f.f.a.c(this.f13060b);
                n();
                ((c.a.p0.c0.f.f.a.c) this.i).i(new C0984a(this));
            }
            this.f13063e.setAdapter((ListAdapter) this.i);
            this.f13063e.setOnScrollListener(new b(this));
        }
    }

    public ViewGroup g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f13062d : (ViewGroup) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13061c : (View) invokeV.objValue;
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
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d07aa, (ViewGroup) null);
            this.f13061c = inflate;
            inflate.setPadding(0, (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070275), 0, 0);
            this.f13062d = (FrameLayout) this.f13061c.findViewById(R.id.obfuscated_res_0x7f091d80);
            this.f13063e = (BdListView) this.f13061c.findViewById(R.id.obfuscated_res_0x7f091d81);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                colorDrawable = new ColorDrawable(this.a.getPageContext().getResources().getColor(R.color.CAM_X0204_1));
            } else {
                colorDrawable = new ColorDrawable(this.a.getPageContext().getResources().getColor(R.color.CAM_X0204));
            }
            this.f13063e.setDivider(colorDrawable);
            this.f13063e.setDividerHeight(this.a.getActivity().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198));
            this.f13064f = (NoNetworkView) this.f13061c.findViewById(R.id.obfuscated_res_0x7f091d82);
            g gVar = new g(this.f13060b);
            this.f13066h = gVar;
            gVar.a0(this.a.getUniqueId());
            this.f13063e.setPullRefresh(this.f13066h);
            PbListView pbListView = new PbListView(this.a);
            this.f13065g = pbListView;
            pbListView.a();
            i();
        }
    }

    public void k(int i) {
        NoNetworkView noNetworkView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || (noNetworkView = this.f13064f) == null) {
            return;
        }
        noNetworkView.c(this.f13060b, i);
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
                ViewHelper.skipToLoginActivity(this.f13060b.getPageActivity());
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

    public void o(List<c.a.p0.c0.f.f.b.b> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, list, z) == null) {
            c.a.p0.c0.f.f.a.a aVar = this.i;
            if (aVar instanceof c.a.p0.c0.f.f.a.b) {
                aVar.c(list);
            } else if (aVar instanceof c.a.p0.c0.f.f.a.c) {
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
            this.f13066h.f(gVar);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f13063e.setNextPage(null);
        }
    }

    public void r(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, pVar) == null) {
            this.f13063e.setOnSrollToBottomListener(pVar);
        }
    }

    public final void s() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (pbListView = this.f13065g) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f13063e.setNextPage(this.f13065g);
        }
        this.f13065g.P();
        this.f13065g.R();
    }

    public final void t() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (pbListView = this.f13065g) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f13063e.setNextPage(this.f13065g);
        }
        this.f13065g.D(this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f09e8));
        this.f13065g.f();
    }
}
