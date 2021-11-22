package b.a.r0.x0.y1.f.a;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.f.p.j;
import b.a.q0.b.d;
import b.a.q0.c1.f0;
import b.a.r0.m3.p0.e;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.f1;
import b.a.r0.x0.g1;
import b.a.r0.x0.i1;
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
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f28294a;

    /* renamed from: b  reason: collision with root package name */
    public FrsFragment f28295b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f28296c;

    /* renamed from: d  reason: collision with root package name */
    public FrsTabSortSwitchButton f28297d;

    /* renamed from: e  reason: collision with root package name */
    public String f28298e;

    /* renamed from: f  reason: collision with root package name */
    public int f28299f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabSortSwitchButton.e f28300g;

    /* loaded from: classes6.dex */
    public class a implements FrsTabSortSwitchButton.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f28301a;

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
            this.f28301a = bVar;
        }

        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.e
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                boolean z = false;
                if (!b.a.r0.x0.b.f().i() && !b.a.r0.x0.a.h().j()) {
                    if (!j.A()) {
                        this.f28301a.f28295b.showToast(i1.neterror);
                        return false;
                    } else if (this.f28301a.f28295b.getModelController() != null && this.f28301a.f28295b.getFrsView() != null) {
                        z = true;
                        if (this.f28301a.f28299f == i2) {
                            return true;
                        }
                        this.f28301a.f28295b.getModelController().N0(this.f28301a.f28297d.getSwitchMenuId(this.f28301a.f28299f));
                        this.f28301a.f28299f = i2;
                        if (this.f28301a.f28299f != 7) {
                            f0.c();
                            e.a();
                        } else {
                            e.b();
                        }
                        this.f28301a.f28295b.getModelController().J0(this.f28301a.f28297d.getSwitchMenuId(this.f28301a.f28299f));
                        if (d.q()) {
                            b.a.q0.b.g.a.f(this.f28301a.f28297d.getSwitchMenuId(this.f28301a.f28299f));
                        }
                        this.f28301a.f28295b.getModelController().M0(true);
                        this.f28301a.f28295b.getFrsView().Q1();
                        this.f28301a.f28295b.getModelController().L0(true);
                        this.f28301a.f();
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
        this.f28299f = -1;
        this.f28300g = new a(this);
        if (frsFragment == null || relativeLayout == null) {
            return;
        }
        this.f28295b = frsFragment;
        View inflate = LayoutInflater.from(frsFragment.getContext()).inflate(g1.frs_sort_tab_layout, relativeLayout);
        this.f28294a = inflate;
        inflate.setPadding(UtilHelper.getDimenPixelSize(d1.M_W_X003), 0, UtilHelper.getDimenPixelSize(d1.M_W_X003), 0);
        this.f28296c = (TextView) this.f28294a.findViewById(f1.sort_tab_sort_name);
        FrsTabSortSwitchButton frsTabSortSwitchButton = (FrsTabSortSwitchButton) this.f28294a.findViewById(f1.sort_tab_switch_btn);
        this.f28297d = frsTabSortSwitchButton;
        frsTabSortSwitchButton.setOnSwitchChangeListener(this.f28300g);
        this.f28299f = this.f28297d.getState();
        i();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c11437");
            statisticItem.param("obj_type", this.f28297d.getSwitchMenuId(this.f28299f));
            statisticItem.param("fid", this.f28298e);
            TiebaStatic.log(statisticItem);
        }
    }

    public void g(int i2) {
        FrsTabSortSwitchButton frsTabSortSwitchButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (frsTabSortSwitchButton = this.f28297d) == null) {
            return;
        }
        frsTabSortSwitchButton.changeState(i2);
        this.f28299f = this.f28297d.getState();
    }

    public FrsTabSortSwitchButton h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28297d : (FrsTabSortSwitchButton) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            FrsTabSortSwitchButton frsTabSortSwitchButton = this.f28297d;
            if (frsTabSortSwitchButton != null) {
                frsTabSortSwitchButton.onChangeSkinType();
            }
            SkinManager.setViewTextColor(this.f28296c, c1.CAM_X0108);
        }
    }

    public void j(List<FrsTabInfo> list) {
        FrsTabSortSwitchButton frsTabSortSwitchButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || (frsTabSortSwitchButton = this.f28297d) == null) {
            return;
        }
        frsTabSortSwitchButton.setData(list);
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f28298e = str;
        }
    }
}
