package c.a.r0.k2.k.e.a1;

import android.content.res.Configuration;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.d2;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f20033a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.k2.n.g f20034b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.k2.n.f f20035c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f20036d;

    public i(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20036d = false;
        this.f20033a = pbFragment;
    }

    public void a() {
        c.a.r0.k2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (gVar = this.f20034b) == null) {
            return;
        }
        gVar.O();
    }

    public void b() {
        c.a.r0.k2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (gVar = this.f20034b) == null) {
            return;
        }
        gVar.f0();
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.r0.k2.n.g gVar = this.f20034b;
            if (gVar != null) {
                return gVar.P();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View c2 = c();
            if (c2 != null) {
                return c2.getHeight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.r0.k2.n.g gVar = this.f20034b;
            if (gVar != null) {
                return gVar.Q();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.r0.k2.n.g gVar = this.f20034b;
            return gVar != null && gVar.X();
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.r0.k2.n.g gVar = this.f20034b;
            if (gVar != null) {
                return gVar.Z();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void h(int i2) {
        c.a.r0.k2.n.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (fVar = this.f20035c) == null) {
            return;
        }
        fVar.c(i2);
    }

    public void i(int i2) {
        c.a.r0.k2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (gVar = this.f20034b) == null) {
            return;
        }
        gVar.c0(i2);
    }

    public void j(Configuration configuration) {
        c.a.r0.k2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) || (gVar = this.f20034b) == null) {
            return;
        }
        gVar.d0(configuration);
    }

    public boolean k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            c.a.r0.k2.n.g gVar = this.f20034b;
            if (gVar != null) {
                return gVar.e0(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void l() {
        c.a.r0.k2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (gVar = this.f20034b) == null) {
            return;
        }
        gVar.f0();
    }

    public void m() {
        c.a.r0.k2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (gVar = this.f20034b) == null) {
            return;
        }
        gVar.g0();
    }

    public void n(AbsListView absListView, int i2, int i3, int i4) {
        c.a.r0.k2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048589, this, absListView, i2, i3, i4) == null) || (gVar = this.f20034b) == null) {
            return;
        }
        gVar.h0(absListView, i2);
    }

    public void o(AbsListView absListView, int i2) {
        c.a.r0.k2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048590, this, absListView, i2) == null) || (gVar = this.f20034b) == null) {
            return;
        }
        gVar.i0(absListView, i2);
    }

    public void p(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        c.a.r0.k2.n.g gVar = this.f20034b;
        if (gVar != null) {
            bdTypeListView.removeHeaderView(gVar.R());
        }
        c.a.r0.k2.n.f fVar = this.f20035c;
        if (fVar != null) {
            fVar.e(bdTypeListView);
        }
    }

    public void q(PbLandscapeListView pbLandscapeListView, TextView textView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048592, this, pbLandscapeListView, textView, i2) == null) || pbLandscapeListView == null) {
            return;
        }
        c.a.r0.k2.n.g gVar = this.f20034b;
        if (gVar == null || gVar.P() == null) {
            c.a.r0.k2.n.g gVar2 = this.f20034b;
            if (gVar2 != null) {
                pbLandscapeListView.removeHeaderView(gVar2.R());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.addHeaderView(textView, 0);
                return;
            }
            return;
        }
        if (textView != null) {
            pbLandscapeListView.removeHeaderView(textView);
            pbLandscapeListView.setTextViewAdded(false);
        }
        if (i2 != 1) {
            pbLandscapeListView.removeHeaderView(this.f20034b.R());
            pbLandscapeListView.addHeaderView(this.f20034b.R(), 0);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f20036d = z;
        }
    }

    public void s(View.OnClickListener onClickListener) {
        c.a.r0.k2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) || (gVar = this.f20034b) == null) {
            return;
        }
        gVar.r0(onClickListener);
    }

    public void t() {
        c.a.r0.k2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (gVar = this.f20034b) == null) {
            return;
        }
        gVar.s0();
    }

    public void u(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, bdTypeListView) == null) || this.f20034b == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c11997").param("obj_type", 1));
        this.f20034b.s0();
        bdTypeListView.smoothScrollToPosition(0);
    }

    public void v(c.a.r0.k2.h.e eVar, PostData postData, BdTypeListView bdTypeListView, h hVar, FrameLayout frameLayout, c.a.r0.k2.k.e.g1.c cVar, String str, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{eVar, postData, bdTypeListView, hVar, frameLayout, cVar, str, Long.valueOf(j2)}) == null) && eVar != null && eVar.q0()) {
            c.a.r0.k2.n.g gVar = this.f20034b;
            if (gVar == null) {
                c.a.r0.k2.n.g gVar2 = new c.a.r0.k2.n.g(this.f20033a, cVar, eVar.O().q1(), j2);
                this.f20034b = gVar2;
                gVar2.U(eVar.O().q1(), eVar.O(), eVar.n());
                this.f20034b.v0();
            } else if (this.f20036d) {
                gVar.U(eVar.O().q1(), eVar.O(), eVar.n());
                this.f20034b.v0();
            } else {
                gVar.w0(eVar.n());
            }
            c.a.r0.k2.m.a.d(this.f20033a.getUniqueId(), eVar, postData, 1, 1);
            if (eVar.K() != null && eVar.K().size() >= 1) {
                d2 d2Var = eVar.K().get(0);
                this.f20034b.p0(d2Var);
                this.f20034b.q0(d2Var.getTitle());
            }
            this.f20034b.k0(postData, eVar.O(), eVar.S());
            this.f20036d = false;
            bdTypeListView.removeHeaderView(this.f20034b.R());
            bdTypeListView.addHeaderView(this.f20034b.R(), 0);
            if (this.f20034b.P() != null && this.f20034b.P().getParent() == null) {
                frameLayout.addView(this.f20034b.P());
            }
            if (this.f20035c == null) {
                this.f20035c = new c.a.r0.k2.n.f(this.f20033a.getBaseFragmentActivity());
            }
            this.f20035c.d(eVar, str);
            bdTypeListView.removeHeaderView(this.f20035c.b());
            bdTypeListView.addHeaderView(this.f20035c.b(), 1);
            hVar.t(bdTypeListView);
            hVar.i(bdTypeListView, 2);
            if (this.f20034b != null) {
                cVar.G(false);
                this.f20034b.c0(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}
