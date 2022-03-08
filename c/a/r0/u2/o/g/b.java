package c.a.r0.u2.o.g;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.u2.h.k;
import c.a.r0.u2.h.l;
import c.a.r0.u2.h.n;
import c.a.r0.u2.h.x;
import c.a.r0.u2.k.f.a1;
import c.a.r0.u2.k.f.b0;
import c.a.r0.u2.k.f.c0;
import c.a.r0.u2.k.f.j0;
import c.a.r0.u2.k.f.m;
import c.a.r0.u2.k.f.n0;
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
/* loaded from: classes2.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public j0 m;
    public b0 n;
    public c0 o;
    public a1 p;
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

    @Override // c.a.r0.u2.o.g.a
    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.o.d0(onClickListener);
        }
    }

    @Override // c.a.r0.u2.o.g.a
    public void B(c.a.r0.u2.h.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
        }
    }

    @Override // c.a.r0.u2.o.g.a
    public void C(c.a.r0.u2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            super.C(cVar);
            this.p.Q0(cVar);
        }
    }

    @Override // c.a.r0.u2.o.g.a
    public void D(c.a.r0.u2.h.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.r.p0(fVar);
        }
    }

    @Override // c.a.r0.u2.o.g.a
    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.r.q(str);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.r = new j(this.f23973b.getVideoPbFragment(), PostData.z0);
            this.n = new b0(this.f23973b.getVideoPbFragment(), k.f23111g, this.f23973b.getUniqueId());
            this.o = new c0(this.f23973b.getVideoPbFragment(), l.f23114e);
            this.m = new j0(this.f23973b.getVideoPbFragment(), n.O0);
            a1 a1Var = new a1(this.f23973b.getVideoPbFragment(), PostData.A0);
            this.p = a1Var;
            a1Var.R0(this.f23973b.getVideoPbFragment());
            this.p.N0(this.f23973b.getVideoPbFragment().getFromVideoPageType());
            this.q = new PbReplyLoadMoreAdapter(this.f23973b.getVideoPbFragment(), PostData.G0);
            this.s = new i(this.f23973b.getContext(), x.f23157f, this.f23973b.getVideoPbFragment());
            this.f23976e.add(this.r);
            this.f23976e.add(this.s);
            this.f23976e.add(this.m);
            this.f23976e.add(this.n);
            this.f23976e.add(this.o);
            this.f23976e.add(this.p);
            this.f23976e.add(this.q);
            this.f23974c.addAdapters(this.f23976e);
        }
    }

    @Override // c.a.r0.u2.o.g.a
    public n0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (n0) invokeV.objValue;
    }

    @Override // c.a.r0.u2.o.g.a
    public m f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (m) invokeV.objValue;
    }

    @Override // c.a.r0.u2.o.g.a
    public PbFirstFloorCommentAndPraiseAdapter g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // c.a.r0.u2.o.g.a
    public void k() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (bdTypeRecyclerView = this.f23974c) == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f23974c.getListAdapter().notifyDataSetChanged();
    }

    @Override // c.a.r0.u2.o.g.a
    public void l() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (jVar = this.r) == null) {
            return;
        }
        jVar.H();
    }

    @Override // c.a.r0.u2.o.g.a
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @Override // c.a.r0.u2.o.g.a
    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
        }
    }

    @Override // c.a.r0.u2.o.g.a
    public void p(c.a.r0.u2.h.f fVar, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{fVar, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.p.t(fVar);
            this.p.setFromCDN(z);
            this.p.q(str);
            this.p.c(z2);
            this.p.P0(0.5f);
        }
    }

    @Override // c.a.r0.u2.o.g.a
    public void u(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onClickListener) == null) {
            super.u(onClickListener);
            this.p.m(onClickListener);
        }
    }

    @Override // c.a.r0.u2.o.g.a
    public void v(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, yVar) == null) {
            super.v(yVar);
            this.p.p(yVar);
        }
    }

    @Override // c.a.r0.u2.o.g.a
    public void w(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onLongClickListener) == null) {
            super.w(onLongClickListener);
            this.p.d(onLongClickListener);
        }
    }

    @Override // c.a.r0.u2.o.g.a
    public void y(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) {
            super.y(onClickListener);
            this.p.e(onClickListener);
            this.q.d0(onClickListener);
        }
    }

    @Override // c.a.r0.u2.o.g.a
    public void z(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            this.n.d0(onClickListener);
        }
    }
}
