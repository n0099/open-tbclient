package c.a.s0.s2.y.f;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s2.r.k;
import c.a.s0.s2.r.l;
import c.a.s0.s2.r.n;
import c.a.s0.s2.r.x;
import c.a.s0.s2.u.f.a0;
import c.a.s0.s2.u.f.b0;
import c.a.s0.s2.u.f.i0;
import c.a.s0.s2.u.f.m0;
import c.a.s0.s2.u.f.z0;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i0 m;
    public a0 n;
    public b0 o;
    public z0 p;
    public PbReplyLoadMoreAdapter q;
    public j r;
    public i s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        super(detailInfoAndReplyFragment, bdTypeRecyclerView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {detailInfoAndReplyFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((DetailInfoAndReplyFragment) objArr2[0], (BdTypeRecyclerView) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        G();
    }

    @Override // c.a.s0.s2.y.f.a
    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.o.k0(onClickListener);
        }
    }

    @Override // c.a.s0.s2.y.f.a
    public void B(c.a.s0.s2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
        }
    }

    @Override // c.a.s0.s2.y.f.a
    public void C(c.a.s0.s2.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            super.C(cVar);
            this.p.X0(cVar);
        }
    }

    @Override // c.a.s0.s2.y.f.a
    public void D(c.a.s0.s2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.r.w0(fVar);
        }
    }

    @Override // c.a.s0.s2.y.f.a
    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.r.q(str);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.r = new j(this.f23434b.getVideoPbFragment(), PostData.y0);
            this.n = new a0(this.f23434b.getVideoPbFragment(), k.f22543g, this.f23434b.getUniqueId());
            this.o = new b0(this.f23434b.getVideoPbFragment(), l.f22546e);
            this.m = new i0(this.f23434b.getVideoPbFragment(), n.N0);
            z0 z0Var = new z0(this.f23434b.getVideoPbFragment(), PostData.z0);
            this.p = z0Var;
            z0Var.Y0(this.f23434b.getVideoPbFragment());
            this.p.U0(this.f23434b.getVideoPbFragment().getFromVideoPageType());
            this.q = new PbReplyLoadMoreAdapter(this.f23434b.getVideoPbFragment(), PostData.F0);
            this.s = new i(this.f23434b.getContext(), x.f22591f, this.f23434b.getVideoPbFragment());
            this.f23437e.add(this.r);
            this.f23437e.add(this.s);
            this.f23437e.add(this.m);
            this.f23437e.add(this.n);
            this.f23437e.add(this.o);
            this.f23437e.add(this.p);
            this.f23437e.add(this.q);
            this.f23435c.addAdapters(this.f23437e);
        }
    }

    @Override // c.a.s0.s2.y.f.a
    public m0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (m0) invokeV.objValue;
    }

    @Override // c.a.s0.s2.y.f.a
    public c.a.s0.s2.u.f.l f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (c.a.s0.s2.u.f.l) invokeV.objValue;
    }

    @Override // c.a.s0.s2.y.f.a
    public PbFirstFloorCommentAndPraiseAdapter g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // c.a.s0.s2.y.f.a
    public void k() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (bdTypeRecyclerView = this.f23435c) == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f23435c.getListAdapter().notifyDataSetChanged();
    }

    @Override // c.a.s0.s2.y.f.a
    public void l() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (jVar = this.r) == null) {
            return;
        }
        jVar.K();
    }

    @Override // c.a.s0.s2.y.f.a
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @Override // c.a.s0.s2.y.f.a
    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
        }
    }

    @Override // c.a.s0.s2.y.f.a
    public void p(c.a.s0.s2.r.f fVar, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{fVar, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.p.t(fVar);
            this.p.setFromCDN(z);
            this.p.q(str);
            this.p.c(z2);
            this.p.W0(0.5f);
        }
    }

    @Override // c.a.s0.s2.y.f.a
    public void u(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onClickListener) == null) {
            super.u(onClickListener);
            this.p.m(onClickListener);
        }
    }

    @Override // c.a.s0.s2.y.f.a
    public void v(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, yVar) == null) {
            super.v(yVar);
            this.p.p(yVar);
        }
    }

    @Override // c.a.s0.s2.y.f.a
    public void w(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onLongClickListener) == null) {
            super.w(onLongClickListener);
            this.p.d(onLongClickListener);
        }
    }

    @Override // c.a.s0.s2.y.f.a
    public void y(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) {
            super.y(onClickListener);
            this.p.e(onClickListener);
            this.q.k0(onClickListener);
        }
    }

    @Override // c.a.s0.s2.y.f.a
    public void z(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            this.n.k0(onClickListener);
        }
    }
}
