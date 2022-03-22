package c.a.p0.f1.p1.f.a;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.o0.c1.h0;
import c.a.p0.a4.q0.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.helper.FrsTabTestHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public FrsFragment f14368b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f14369c;

    /* renamed from: d  reason: collision with root package name */
    public FrsTabSortSwitchButton f14370d;

    /* renamed from: e  reason: collision with root package name */
    public String f14371e;

    /* renamed from: f  reason: collision with root package name */
    public int f14372f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabSortSwitchButton.e f14373g;

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.e
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                boolean z = false;
                if (!c.a.p0.f1.b.f().i() && !c.a.p0.f1.a.h().j()) {
                    if (!l.A()) {
                        this.a.f14368b.showToast(R.string.obfuscated_res_0x7f0f0c15);
                        return false;
                    } else if (this.a.f14368b.b0() != null && this.a.f14368b.x0() != null) {
                        z = true;
                        if (this.a.f14372f == i) {
                            return true;
                        }
                        this.a.f14368b.b0().Q0(this.a.f14370d.w(this.a.f14372f));
                        this.a.f14372f = i;
                        if (this.a.f14372f != 7) {
                            h0.c();
                            e.a();
                        } else {
                            e.b();
                        }
                        this.a.f14368b.b0().M0(this.a.f14370d.w(this.a.f14372f));
                        if (UbsABTestHelper.isFrsNewAreaTabSortTestA()) {
                            FrsTabTestHelper.storeFrsNewAreaTabSort(this.a.f14370d.w(this.a.f14372f));
                        }
                        this.a.f14368b.b0().P0(true);
                        this.a.f14368b.x0().T1();
                        this.a.f14368b.b0().O0(true);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14372f = -1;
        this.f14373g = new a(this);
        if (frsFragment == null || relativeLayout == null) {
            return;
        }
        this.f14368b = frsFragment;
        View inflate = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0353, relativeLayout);
        this.a = inflate;
        inflate.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
        this.f14369c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091d43);
        FrsTabSortSwitchButton frsTabSortSwitchButton = (FrsTabSortSwitchButton) this.a.findViewById(R.id.obfuscated_res_0x7f091d44);
        this.f14370d = frsTabSortSwitchButton;
        frsTabSortSwitchButton.setOnSwitchChangeListener(this.f14373g);
        this.f14372f = this.f14370d.getState();
        i();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c11437");
            statisticItem.param("obj_type", this.f14370d.w(this.f14372f));
            statisticItem.param("fid", this.f14371e);
            TiebaStatic.log(statisticItem);
        }
    }

    public void g(int i) {
        FrsTabSortSwitchButton frsTabSortSwitchButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (frsTabSortSwitchButton = this.f14370d) == null) {
            return;
        }
        frsTabSortSwitchButton.t(i);
        this.f14372f = this.f14370d.getState();
    }

    public FrsTabSortSwitchButton h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14370d : (FrsTabSortSwitchButton) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            FrsTabSortSwitchButton frsTabSortSwitchButton = this.f14370d;
            if (frsTabSortSwitchButton != null) {
                frsTabSortSwitchButton.E();
            }
            SkinManager.setViewTextColor(this.f14369c, (int) R.color.CAM_X0108);
        }
    }

    public void j(List<FrsTabInfo> list) {
        FrsTabSortSwitchButton frsTabSortSwitchButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || (frsTabSortSwitchButton = this.f14370d) == null) {
            return;
        }
        frsTabSortSwitchButton.setData(list);
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f14371e = str;
        }
    }
}
