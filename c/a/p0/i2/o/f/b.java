package c.a.p0.i2.o.f;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.i2.h.l;
import c.a.p0.i2.h.v;
import c.a.p0.i2.k.e.b0;
import c.a.p0.i2.k.e.i0;
import c.a.p0.i2.k.e.m;
import c.a.p0.i2.k.e.m0;
import c.a.p0.i2.k.e.y0;
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
    public i0 m;
    public b0 n;
    public y0 o;
    public PbReplyLoadMoreAdapter p;
    public j q;
    public i r;

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
        F();
    }

    @Override // c.a.p0.i2.o.f.a
    public void A(c.a.p0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
        }
    }

    @Override // c.a.p0.i2.o.f.a
    public void B(c.a.p0.i2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            super.B(cVar);
            this.o.X0(cVar);
        }
    }

    @Override // c.a.p0.i2.o.f.a
    public void C(c.a.p0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            this.q.x0(eVar);
        }
    }

    @Override // c.a.p0.i2.o.f.a
    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.q.q(str);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.q = new j(this.f19702b.getVideoPbFragment(), PostData.u0);
            this.n = new b0(this.f19702b.getVideoPbFragment(), c.a.p0.i2.h.j.f18750g, this.f19702b.getUniqueId());
            this.m = new i0(this.f19702b.getVideoPbFragment(), l.J0);
            y0 y0Var = new y0(this.f19702b.getVideoPbFragment(), PostData.v0);
            this.o = y0Var;
            y0Var.Y0(this.f19702b.getVideoPbFragment());
            this.o.U0(this.f19702b.getVideoPbFragment().getFromVideoPageType());
            this.p = new PbReplyLoadMoreAdapter(this.f19702b.getVideoPbFragment(), PostData.B0);
            this.r = new i(this.f19702b.getContext(), v.f18801f, this.f19702b.getVideoPbFragment());
            this.f19705e.add(this.q);
            this.f19705e.add(this.r);
            this.f19705e.add(this.m);
            this.f19705e.add(this.n);
            this.f19705e.add(this.o);
            this.f19705e.add(this.p);
            this.f19703c.addAdapters(this.f19705e);
        }
    }

    @Override // c.a.p0.i2.o.f.a
    public m0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (m0) invokeV.objValue;
    }

    @Override // c.a.p0.i2.o.f.a
    public m f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (m) invokeV.objValue;
    }

    @Override // c.a.p0.i2.o.f.a
    public PbFirstFloorCommentAndPraiseAdapter g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // c.a.p0.i2.o.f.a
    public void k() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (bdTypeRecyclerView = this.f19703c) == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f19703c.getListAdapter().notifyDataSetChanged();
    }

    @Override // c.a.p0.i2.o.f.a
    public void l() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (jVar = this.q) == null) {
            return;
        }
        jVar.P();
    }

    @Override // c.a.p0.i2.o.f.a
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // c.a.p0.i2.o.f.a
    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
        }
    }

    @Override // c.a.p0.i2.o.f.a
    public void p(c.a.p0.i2.h.e eVar, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{eVar, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.o.t(eVar);
            this.o.setFromCDN(z);
            this.o.q(str);
            this.o.c(z2);
            this.o.W0(0.5f);
        }
    }

    @Override // c.a.p0.i2.o.f.a
    public void u(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) {
            super.u(onClickListener);
            this.o.m(onClickListener);
        }
    }

    @Override // c.a.p0.i2.o.f.a
    public void v(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, zVar) == null) {
            super.v(zVar);
            this.o.p(zVar);
        }
    }

    @Override // c.a.p0.i2.o.f.a
    public void w(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onLongClickListener) == null) {
            super.w(onLongClickListener);
            this.o.d(onLongClickListener);
        }
    }

    @Override // c.a.p0.i2.o.f.a
    public void y(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            super.y(onClickListener);
            this.o.e(onClickListener);
            this.p.l0(onClickListener);
        }
    }

    @Override // c.a.p0.i2.o.f.a
    public void z(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) {
            this.n.l0(onClickListener);
        }
    }
}
