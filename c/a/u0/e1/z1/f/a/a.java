package c.a.u0.e1.z1.f.a;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.t0.b.d;
import c.a.t0.d1.i0;
import c.a.u0.e1.b3.p;
import c.a.u0.e1.c1;
import c.a.u0.e1.d1;
import c.a.u0.e1.f1;
import c.a.u0.e1.g1;
import c.a.u0.e1.i1;
import c.a.u0.z3.q0.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public BaseFragment f17439b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f17440c;

    /* renamed from: d  reason: collision with root package name */
    public FrsTabSortSwitchButton f17441d;

    /* renamed from: e  reason: collision with root package name */
    public int f17442e;

    /* renamed from: f  reason: collision with root package name */
    public String f17443f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabSortSwitchButton.e f17444g;

    /* renamed from: c.a.u0.e1.z1.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1091a implements FrsTabSortSwitchButton.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1091a(a aVar) {
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
            this.a = aVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0078, code lost:
            if (((com.baidu.tieba.frs.commontab.FrsCommonTabFragment) r4.a.f17439b).getMainView() != null) goto L18;
         */
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                boolean z = false;
                if (!c.a.u0.e1.b.f().i() && !c.a.u0.e1.a.h().j()) {
                    if (!l.A()) {
                        this.a.f17439b.showToast(i1.neterror);
                        return false;
                    }
                    if (this.a.f17439b instanceof FrsNewAreaFragment) {
                        if (((FrsNewAreaFragment) this.a.f17439b).getModelController() == null || ((FrsNewAreaFragment) this.a.f17439b).getFrsView() == null) {
                            return false;
                        }
                    } else if (this.a.f17439b instanceof FrsCommonTabFragment) {
                        if (((FrsCommonTabFragment) this.a.f17439b).getModelController() != null) {
                        }
                    }
                    z = true;
                    if (this.a.f17442e == i2) {
                        return true;
                    }
                    this.a.f17442e = i2;
                    if (this.a.f17442e != 7) {
                        i0.c();
                        e.a();
                    } else {
                        e.b();
                    }
                    if (this.a.f17439b instanceof FrsNewAreaFragment) {
                        ((FrsNewAreaFragment) this.a.f17439b).getModelController().L(this.a.f17441d.getSwitchMenuId(this.a.f17442e));
                        if (d.w()) {
                            c.a.t0.b.g.a.f(this.a.f17441d.getSwitchMenuId(this.a.f17442e));
                        }
                        ((FrsNewAreaFragment) this.a.f17439b).getFrsView().L();
                    } else {
                        ((FrsCommonTabFragment) this.a.f17439b).setSortType(p.d(this.a.f17441d.getSwitchMenuId(this.a.f17442e)));
                        ((FrsCommonTabFragment) this.a.f17439b).getMainView().x(true);
                    }
                    this.a.f();
                }
                return z;
            }
            return invokeI.booleanValue;
        }
    }

    public a(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, relativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17442e = -1;
        this.f17444g = new C1091a(this);
        if (baseFragment == null || relativeLayout == null) {
            return;
        }
        this.f17439b = baseFragment;
        View inflate = LayoutInflater.from(baseFragment.getContext()).inflate(g1.frs_sort_tab_layout, relativeLayout);
        this.a = inflate;
        inflate.setPadding(UtilHelper.getDimenPixelSize(d1.M_W_X003), 0, UtilHelper.getDimenPixelSize(d1.M_W_X003), 0);
        this.f17440c = (TextView) this.a.findViewById(f1.sort_tab_sort_name);
        FrsTabSortSwitchButton frsTabSortSwitchButton = (FrsTabSortSwitchButton) this.a.findViewById(f1.sort_tab_switch_btn);
        this.f17441d = frsTabSortSwitchButton;
        frsTabSortSwitchButton.setOnSwitchChangeListener(this.f17444g);
        this.f17442e = this.f17441d.getState();
        h();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c11437");
            statisticItem.param("obj_type", this.f17441d.getSwitchMenuId(this.f17442e));
            statisticItem.param("fid", this.f17443f);
            TiebaStatic.log(statisticItem);
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f17441d == null) {
            return;
        }
        this.f17441d.changeState(p.f(i2));
        this.f17442e = this.f17441d.getState();
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            FrsTabSortSwitchButton frsTabSortSwitchButton = this.f17441d;
            if (frsTabSortSwitchButton != null) {
                frsTabSortSwitchButton.onChangeSkinType();
            }
            SkinManager.setViewTextColor(this.f17440c, c1.CAM_X0105);
        }
    }

    public void i(List<FrsTabInfo> list) {
        FrsTabSortSwitchButton frsTabSortSwitchButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || (frsTabSortSwitchButton = this.f17441d) == null) {
            return;
        }
        frsTabSortSwitchButton.setData(list);
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f17443f = str;
        }
    }
}
