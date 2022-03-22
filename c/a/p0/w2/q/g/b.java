package c.a.p0.w2.q.g;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.w2.i.l;
import c.a.p0.w2.i.m;
import c.a.p0.w2.i.o;
import c.a.p0.w2.i.y;
import c.a.p0.w2.m.f.g0;
import c.a.p0.w2.m.f.g1;
import c.a.p0.w2.m.f.h0;
import c.a.p0.w2.m.f.p;
import c.a.p0.w2.m.f.p0;
import c.a.p0.w2.m.f.t0;
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
/* loaded from: classes3.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public p0 m;
    public g0 n;
    public h0 o;
    public g1 p;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((DetailInfoAndReplyFragment) objArr2[0], (BdTypeRecyclerView) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        G();
    }

    @Override // c.a.p0.w2.q.g.a
    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.o.d0(onClickListener);
        }
    }

    @Override // c.a.p0.w2.q.g.a
    public void B(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
        }
    }

    @Override // c.a.p0.w2.q.g.a
    public void C(c.a.p0.w2.j.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            super.C(cVar);
            this.p.Q0(cVar);
        }
    }

    @Override // c.a.p0.w2.q.g.a
    public void D(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.r.p0(fVar);
        }
    }

    @Override // c.a.p0.w2.q.g.a
    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.r.q(str);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.r = new j(this.f20467b.t(), PostData.v0);
            this.n = new g0(this.f20467b.t(), l.f19833c, this.f20467b.getUniqueId());
            this.o = new h0(this.f20467b.t(), m.a);
            this.m = new p0(this.f20467b.t(), o.K0);
            g1 g1Var = new g1(this.f20467b.t(), PostData.w0);
            this.p = g1Var;
            g1Var.R0(this.f20467b.t());
            this.p.N0(this.f20467b.t().V2());
            this.q = new PbReplyLoadMoreAdapter(this.f20467b.t(), PostData.C0);
            this.s = new i(this.f20467b.getContext(), y.f19873b, this.f20467b.t());
            this.f20470e.add(this.r);
            this.f20470e.add(this.s);
            this.f20470e.add(this.m);
            this.f20470e.add(this.n);
            this.f20470e.add(this.o);
            this.f20470e.add(this.p);
            this.f20470e.add(this.q);
            this.f20468c.a(this.f20470e);
        }
    }

    @Override // c.a.p0.w2.q.g.a
    public t0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (t0) invokeV.objValue;
    }

    @Override // c.a.p0.w2.q.g.a
    public p f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (p) invokeV.objValue;
    }

    @Override // c.a.p0.w2.q.g.a
    public PbFirstFloorCommentAndPraiseAdapter g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // c.a.p0.w2.q.g.a
    public void k() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (bdTypeRecyclerView = this.f20468c) == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f20468c.getListAdapter().notifyDataSetChanged();
    }

    @Override // c.a.p0.w2.q.g.a
    public void l() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (jVar = this.r) == null) {
            return;
        }
        jVar.H();
    }

    @Override // c.a.p0.w2.q.g.a
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @Override // c.a.p0.w2.q.g.a
    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
        }
    }

    @Override // c.a.p0.w2.q.g.a
    public void p(c.a.p0.w2.i.f fVar, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{fVar, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.p.t(fVar);
            this.p.setFromCDN(z);
            this.p.q(str);
            this.p.c(z2);
            this.p.P0(0.5f);
        }
    }

    @Override // c.a.p0.w2.q.g.a
    public void u(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onClickListener) == null) {
            super.u(onClickListener);
            this.p.m(onClickListener);
        }
    }

    @Override // c.a.p0.w2.q.g.a
    public void v(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, yVar) == null) {
            super.v(yVar);
            this.p.p(yVar);
        }
    }

    @Override // c.a.p0.w2.q.g.a
    public void w(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onLongClickListener) == null) {
            super.w(onLongClickListener);
            this.p.d(onLongClickListener);
        }
    }

    @Override // c.a.p0.w2.q.g.a
    public void y(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) {
            super.y(onClickListener);
            this.p.e(onClickListener);
            this.q.d0(onClickListener);
        }
    }

    @Override // c.a.p0.w2.q.g.a
    public void z(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            this.n.d0(onClickListener);
        }
    }
}
