package c.a.p0.v0.m1.f.a;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.j;
import c.a.o0.b.d;
import c.a.o0.b1.e0;
import c.a.p0.i3.n0.e;
import c.a.p0.v0.n2.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f26150a;

    /* renamed from: b  reason: collision with root package name */
    public BaseFragment f26151b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26152c;

    /* renamed from: d  reason: collision with root package name */
    public FrsTabSortSwitchButton f26153d;

    /* renamed from: e  reason: collision with root package name */
    public int f26154e;

    /* renamed from: f  reason: collision with root package name */
    public String f26155f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabSortSwitchButton.e f26156g;

    /* renamed from: c.a.p0.v0.m1.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1223a implements FrsTabSortSwitchButton.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26157a;

        public C1223a(a aVar) {
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
            this.f26157a = aVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0078, code lost:
            if (((com.baidu.tieba.frs.commontab.FrsCommonTabFragment) r4.f26157a.f26151b).getMainView() != null) goto L18;
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
                if (!c.a.p0.v0.b.f().i() && !c.a.p0.v0.a.h().j()) {
                    if (!j.A()) {
                        this.f26157a.f26151b.showToast(R.string.neterror);
                        return false;
                    }
                    if (this.f26157a.f26151b instanceof FrsNewAreaFragment) {
                        if (((FrsNewAreaFragment) this.f26157a.f26151b).getModelController() == null || ((FrsNewAreaFragment) this.f26157a.f26151b).getFrsView() == null) {
                            return false;
                        }
                    } else if (this.f26157a.f26151b instanceof FrsCommonTabFragment) {
                        if (((FrsCommonTabFragment) this.f26157a.f26151b).getModelController() != null) {
                        }
                    }
                    z = true;
                    if (this.f26157a.f26154e == i2) {
                        return true;
                    }
                    this.f26157a.f26154e = i2;
                    if (this.f26157a.f26154e != 7) {
                        e0.c();
                        e.a();
                    } else {
                        e.b();
                    }
                    if (this.f26157a.f26151b instanceof FrsNewAreaFragment) {
                        ((FrsNewAreaFragment) this.f26157a.f26151b).getModelController().M(this.f26157a.f26153d.getSwitchMenuId(this.f26157a.f26154e));
                        if (d.z()) {
                            c.a.o0.b.g.a.f(this.f26157a.f26153d.getSwitchMenuId(this.f26157a.f26154e));
                        }
                        ((FrsNewAreaFragment) this.f26157a.f26151b).getFrsView().L();
                    } else {
                        ((FrsCommonTabFragment) this.f26157a.f26151b).setSortType(k.d(this.f26157a.f26153d.getSwitchMenuId(this.f26157a.f26154e)));
                        ((FrsCommonTabFragment) this.f26157a.f26151b).getMainView().w(true);
                    }
                    this.f26157a.f();
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
        this.f26154e = -1;
        this.f26156g = new C1223a(this);
        if (baseFragment == null || relativeLayout == null) {
            return;
        }
        this.f26151b = baseFragment;
        View inflate = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
        this.f26150a = inflate;
        inflate.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
        this.f26152c = (TextView) this.f26150a.findViewById(R.id.sort_tab_sort_name);
        FrsTabSortSwitchButton frsTabSortSwitchButton = (FrsTabSortSwitchButton) this.f26150a.findViewById(R.id.sort_tab_switch_btn);
        this.f26153d = frsTabSortSwitchButton;
        frsTabSortSwitchButton.setOnSwitchChangeListener(this.f26156g);
        this.f26154e = this.f26153d.getState();
        h();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c11437");
            statisticItem.param("obj_type", this.f26153d.getSwitchMenuId(this.f26154e));
            statisticItem.param("fid", this.f26155f);
            TiebaStatic.log(statisticItem);
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f26153d == null) {
            return;
        }
        this.f26153d.changeState(k.f(i2));
        this.f26154e = this.f26153d.getState();
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            FrsTabSortSwitchButton frsTabSortSwitchButton = this.f26153d;
            if (frsTabSortSwitchButton != null) {
                frsTabSortSwitchButton.onChangeSkinType();
            }
            SkinManager.setViewTextColor(this.f26152c, R.color.CAM_X0105);
        }
    }

    public void i(List<FrsTabInfo> list) {
        FrsTabSortSwitchButton frsTabSortSwitchButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || (frsTabSortSwitchButton = this.f26153d) == null) {
            return;
        }
        frsTabSortSwitchButton.setData(list);
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f26155f = str;
        }
    }
}
