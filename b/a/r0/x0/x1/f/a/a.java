package b.a.r0.x0.x1.f.a;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.e.p.j;
import b.a.q0.b.d;
import b.a.q0.d1.f0;
import b.a.r0.l3.p0.e;
import b.a.r0.x0.b1;
import b.a.r0.x0.c1;
import b.a.r0.x0.e1;
import b.a.r0.x0.f1;
import b.a.r0.x0.h1;
import b.a.r0.x0.x2.k;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f26691a;

    /* renamed from: b  reason: collision with root package name */
    public BaseFragment f26692b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26693c;

    /* renamed from: d  reason: collision with root package name */
    public FrsTabSortSwitchButton f26694d;

    /* renamed from: e  reason: collision with root package name */
    public int f26695e;

    /* renamed from: f  reason: collision with root package name */
    public String f26696f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabSortSwitchButton.e f26697g;

    /* renamed from: b.a.r0.x0.x1.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1309a implements FrsTabSortSwitchButton.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26698a;

        public C1309a(a aVar) {
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
            this.f26698a = aVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0078, code lost:
            if (((com.baidu.tieba.frs.commontab.FrsCommonTabFragment) r4.f26698a.f26692b).getMainView() != null) goto L18;
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
                if (!b.a.r0.x0.b.f().i() && !b.a.r0.x0.a.h().j()) {
                    if (!j.A()) {
                        this.f26698a.f26692b.showToast(h1.neterror);
                        return false;
                    }
                    if (this.f26698a.f26692b instanceof FrsNewAreaFragment) {
                        if (((FrsNewAreaFragment) this.f26698a.f26692b).getModelController() == null || ((FrsNewAreaFragment) this.f26698a.f26692b).getFrsView() == null) {
                            return false;
                        }
                    } else if (this.f26698a.f26692b instanceof FrsCommonTabFragment) {
                        if (((FrsCommonTabFragment) this.f26698a.f26692b).getModelController() != null) {
                        }
                    }
                    z = true;
                    if (this.f26698a.f26695e == i2) {
                        return true;
                    }
                    this.f26698a.f26695e = i2;
                    if (this.f26698a.f26695e != 7) {
                        f0.c();
                        e.a();
                    } else {
                        e.b();
                    }
                    if (this.f26698a.f26692b instanceof FrsNewAreaFragment) {
                        ((FrsNewAreaFragment) this.f26698a.f26692b).getModelController().L(this.f26698a.f26694d.getSwitchMenuId(this.f26698a.f26695e));
                        if (d.q()) {
                            b.a.q0.b.g.a.f(this.f26698a.f26694d.getSwitchMenuId(this.f26698a.f26695e));
                        }
                        ((FrsNewAreaFragment) this.f26698a.f26692b).getFrsView().L();
                    } else {
                        ((FrsCommonTabFragment) this.f26698a.f26692b).setSortType(k.d(this.f26698a.f26694d.getSwitchMenuId(this.f26698a.f26695e)));
                        ((FrsCommonTabFragment) this.f26698a.f26692b).getMainView().x(true);
                    }
                    this.f26698a.f();
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
        this.f26695e = -1;
        this.f26697g = new C1309a(this);
        if (baseFragment == null || relativeLayout == null) {
            return;
        }
        this.f26692b = baseFragment;
        View inflate = LayoutInflater.from(baseFragment.getContext()).inflate(f1.frs_sort_tab_layout, relativeLayout);
        this.f26691a = inflate;
        inflate.setPadding(UtilHelper.getDimenPixelSize(c1.M_W_X003), 0, UtilHelper.getDimenPixelSize(c1.M_W_X003), 0);
        this.f26693c = (TextView) this.f26691a.findViewById(e1.sort_tab_sort_name);
        FrsTabSortSwitchButton frsTabSortSwitchButton = (FrsTabSortSwitchButton) this.f26691a.findViewById(e1.sort_tab_switch_btn);
        this.f26694d = frsTabSortSwitchButton;
        frsTabSortSwitchButton.setOnSwitchChangeListener(this.f26697g);
        this.f26695e = this.f26694d.getState();
        h();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c11437");
            statisticItem.param("obj_type", this.f26694d.getSwitchMenuId(this.f26695e));
            statisticItem.param("fid", this.f26696f);
            TiebaStatic.log(statisticItem);
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f26694d == null) {
            return;
        }
        this.f26694d.changeState(k.f(i2));
        this.f26695e = this.f26694d.getState();
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            FrsTabSortSwitchButton frsTabSortSwitchButton = this.f26694d;
            if (frsTabSortSwitchButton != null) {
                frsTabSortSwitchButton.onChangeSkinType();
            }
            SkinManager.setViewTextColor(this.f26693c, b1.CAM_X0105);
        }
    }

    public void i(List<FrsTabInfo> list) {
        FrsTabSortSwitchButton frsTabSortSwitchButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || (frsTabSortSwitchButton = this.f26694d) == null) {
            return;
        }
        frsTabSortSwitchButton.setData(list);
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f26696f = str;
        }
    }
}
