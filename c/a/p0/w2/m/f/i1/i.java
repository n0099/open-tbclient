package c.a.p0.w2.m.f.i1;

import android.content.res.Configuration;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
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
    public PbFragment a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.w2.p.g f20123b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.w2.p.f f20124c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f20125d;

    public i(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20125d = false;
        this.a = pbFragment;
    }

    public void a() {
        c.a.p0.w2.p.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (gVar = this.f20123b) == null) {
            return;
        }
        gVar.O();
    }

    public void b() {
        c.a.p0.w2.p.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (gVar = this.f20123b) == null) {
            return;
        }
        gVar.f0();
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.p0.w2.p.g gVar = this.f20123b;
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
            c.a.p0.w2.p.g gVar = this.f20123b;
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
            c.a.p0.w2.p.g gVar = this.f20123b;
            return gVar != null && gVar.X();
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.p0.w2.p.g gVar = this.f20123b;
            if (gVar != null) {
                return gVar.Z();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void h(int i) {
        c.a.p0.w2.p.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (fVar = this.f20124c) == null) {
            return;
        }
        fVar.c(i);
    }

    public void i(int i) {
        c.a.p0.w2.p.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || (gVar = this.f20123b) == null) {
            return;
        }
        gVar.c0(i);
    }

    public void j(Configuration configuration) {
        c.a.p0.w2.p.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) || (gVar = this.f20123b) == null) {
            return;
        }
        gVar.d0(configuration);
    }

    public boolean k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            c.a.p0.w2.p.g gVar = this.f20123b;
            if (gVar != null) {
                return gVar.e0(i);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void l() {
        c.a.p0.w2.p.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (gVar = this.f20123b) == null) {
            return;
        }
        gVar.f0();
    }

    public void m() {
        c.a.p0.w2.p.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (gVar = this.f20123b) == null) {
            return;
        }
        gVar.g0();
    }

    public void n(AbsListView absListView, int i, int i2, int i3) {
        c.a.p0.w2.p.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048589, this, absListView, i, i2, i3) == null) || (gVar = this.f20123b) == null) {
            return;
        }
        gVar.h0(absListView, i);
    }

    public void o(AbsListView absListView, int i) {
        c.a.p0.w2.p.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048590, this, absListView, i) == null) || (gVar = this.f20123b) == null) {
            return;
        }
        gVar.i0(absListView, i);
    }

    public void p(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        c.a.p0.w2.p.g gVar = this.f20123b;
        if (gVar != null) {
            bdTypeListView.removeHeaderView(gVar.R());
        }
        c.a.p0.w2.p.f fVar = this.f20124c;
        if (fVar != null) {
            fVar.e(bdTypeListView);
        }
    }

    public void q(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048592, this, pbLandscapeListView, textView, i) == null) || pbLandscapeListView == null) {
            return;
        }
        c.a.p0.w2.p.g gVar = this.f20123b;
        if (gVar == null || gVar.P() == null) {
            c.a.p0.w2.p.g gVar2 = this.f20123b;
            if (gVar2 != null) {
                pbLandscapeListView.removeHeaderView(gVar2.R());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.x(textView, 0);
                return;
            }
            return;
        }
        if (textView != null) {
            pbLandscapeListView.removeHeaderView(textView);
            pbLandscapeListView.setTextViewAdded(false);
        }
        if (i != 1) {
            pbLandscapeListView.removeHeaderView(this.f20123b.R());
            pbLandscapeListView.x(this.f20123b.R(), 0);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f20125d = z;
        }
    }

    public void s(View.OnClickListener onClickListener) {
        c.a.p0.w2.p.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) || (gVar = this.f20123b) == null) {
            return;
        }
        gVar.r0(onClickListener);
    }

    public void t() {
        c.a.p0.w2.p.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (gVar = this.f20123b) == null) {
            return;
        }
        gVar.s0();
    }

    public void u(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, bdTypeListView) == null) || this.f20123b == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c11997").param("obj_type", 1));
        this.f20123b.s0();
        bdTypeListView.smoothScrollToPosition(0);
    }

    public void v(c.a.p0.w2.i.f fVar, PostData postData, BdTypeListView bdTypeListView, h hVar, FrameLayout frameLayout, c.a.p0.w2.m.f.o1.c cVar, String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{fVar, postData, bdTypeListView, hVar, frameLayout, cVar, str, Long.valueOf(j)}) == null) && fVar != null && fVar.r0()) {
            c.a.p0.w2.p.g gVar = this.f20123b;
            if (gVar == null) {
                c.a.p0.w2.p.g gVar2 = new c.a.p0.w2.p.g(this.a, cVar, fVar.O().getThreadVideoInfo(), j);
                this.f20123b = gVar2;
                gVar2.U(fVar.O().getThreadVideoInfo(), fVar.O(), fVar.m());
                this.f20123b.v0();
            } else if (this.f20125d) {
                gVar.U(fVar.O().getThreadVideoInfo(), fVar.O(), fVar.m());
                this.f20123b.v0();
            } else {
                gVar.w0(fVar.m());
            }
            c.a.p0.w2.o.a.d(this.a.getUniqueId(), fVar, postData, 1, 1);
            if (fVar.K() != null && fVar.K().size() >= 1) {
                ThreadData threadData = fVar.K().get(0);
                this.f20123b.p0(threadData);
                this.f20123b.q0(threadData.getTitle());
            }
            this.f20123b.k0(postData, fVar.O(), fVar.S());
            this.f20125d = false;
            bdTypeListView.removeHeaderView(this.f20123b.R());
            bdTypeListView.x(this.f20123b.R(), 0);
            if (this.f20123b.P() != null && this.f20123b.P().getParent() == null) {
                frameLayout.addView(this.f20123b.P());
            }
            if (this.f20124c == null) {
                this.f20124c = new c.a.p0.w2.p.f(this.a.getBaseFragmentActivity());
            }
            this.f20124c.d(fVar, str);
            bdTypeListView.removeHeaderView(this.f20124c.b());
            bdTypeListView.x(this.f20124c.b(), 1);
            hVar.w(bdTypeListView);
            hVar.k(bdTypeListView, 2);
            if (this.f20123b != null) {
                cVar.G(false);
                this.f20123b.c0(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}
