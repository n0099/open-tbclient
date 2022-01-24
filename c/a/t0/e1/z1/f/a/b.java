package c.a.t0.e1.z1.f.a;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.s0.b.d;
import c.a.s0.d1.h0;
import c.a.t0.e1.c1;
import c.a.t0.e1.d1;
import c.a.t0.e1.f1;
import c.a.t0.e1.g1;
import c.a.t0.e1.i1;
import c.a.t0.x3.p0.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public FrsFragment f17317b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f17318c;

    /* renamed from: d  reason: collision with root package name */
    public FrsTabSortSwitchButton f17319d;

    /* renamed from: e  reason: collision with root package name */
    public String f17320e;

    /* renamed from: f  reason: collision with root package name */
    public int f17321f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabSortSwitchButton.e f17322g;

    /* loaded from: classes7.dex */
    public class a implements FrsTabSortSwitchButton.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.e
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                boolean z = false;
                if (!c.a.t0.e1.b.f().i() && !c.a.t0.e1.a.h().j()) {
                    if (!l.A()) {
                        this.a.f17317b.showToast(i1.neterror);
                        return false;
                    } else if (this.a.f17317b.getModelController() != null && this.a.f17317b.getFrsView() != null) {
                        z = true;
                        if (this.a.f17321f == i2) {
                            return true;
                        }
                        this.a.f17317b.getModelController().M0(this.a.f17319d.getSwitchMenuId(this.a.f17321f));
                        this.a.f17321f = i2;
                        if (this.a.f17321f != 7) {
                            h0.c();
                            e.a();
                        } else {
                            e.b();
                        }
                        this.a.f17317b.getModelController().I0(this.a.f17319d.getSwitchMenuId(this.a.f17321f));
                        if (d.u()) {
                            c.a.s0.b.g.a.f(this.a.f17319d.getSwitchMenuId(this.a.f17321f));
                        }
                        this.a.f17317b.getModelController().L0(true);
                        this.a.f17317b.getFrsView().Q1();
                        this.a.f17317b.getModelController().K0(true);
                        this.a.f();
                    }
                }
                return z;
            }
            return invokeI.booleanValue;
        }
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, relativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17321f = -1;
        this.f17322g = new a(this);
        if (frsFragment == null || relativeLayout == null) {
            return;
        }
        this.f17317b = frsFragment;
        View inflate = LayoutInflater.from(frsFragment.getContext()).inflate(g1.frs_sort_tab_layout, relativeLayout);
        this.a = inflate;
        inflate.setPadding(UtilHelper.getDimenPixelSize(d1.M_W_X003), 0, UtilHelper.getDimenPixelSize(d1.M_W_X003), 0);
        this.f17318c = (TextView) this.a.findViewById(f1.sort_tab_sort_name);
        FrsTabSortSwitchButton frsTabSortSwitchButton = (FrsTabSortSwitchButton) this.a.findViewById(f1.sort_tab_switch_btn);
        this.f17319d = frsTabSortSwitchButton;
        frsTabSortSwitchButton.setOnSwitchChangeListener(this.f17322g);
        this.f17321f = this.f17319d.getState();
        i();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c11437");
            statisticItem.param("obj_type", this.f17319d.getSwitchMenuId(this.f17321f));
            statisticItem.param("fid", this.f17320e);
            TiebaStatic.log(statisticItem);
        }
    }

    public void g(int i2) {
        FrsTabSortSwitchButton frsTabSortSwitchButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (frsTabSortSwitchButton = this.f17319d) == null) {
            return;
        }
        frsTabSortSwitchButton.changeState(i2);
        this.f17321f = this.f17319d.getState();
    }

    public FrsTabSortSwitchButton h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f17319d : (FrsTabSortSwitchButton) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            FrsTabSortSwitchButton frsTabSortSwitchButton = this.f17319d;
            if (frsTabSortSwitchButton != null) {
                frsTabSortSwitchButton.onChangeSkinType();
            }
            SkinManager.setViewTextColor(this.f17318c, c1.CAM_X0108);
        }
    }

    public void j(List<FrsTabInfo> list) {
        FrsTabSortSwitchButton frsTabSortSwitchButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || (frsTabSortSwitchButton = this.f17319d) == null) {
            return;
        }
        frsTabSortSwitchButton.setData(list);
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f17320e = str;
        }
    }
}
