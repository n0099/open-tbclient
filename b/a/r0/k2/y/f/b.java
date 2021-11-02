package b.a.r0.k2.y.f;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.k2.r.k;
import b.a.r0.k2.r.m;
import b.a.r0.k2.r.w;
import b.a.r0.k2.u.f.a0;
import b.a.r0.k2.u.f.h0;
import b.a.r0.k2.u.f.l;
import b.a.r0.k2.u.f.l0;
import b.a.r0.k2.u.f.y0;
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
/* loaded from: classes5.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h0 m;
    public a0 n;
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

    @Override // b.a.r0.k2.y.f.a
    public void A(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
        }
    }

    @Override // b.a.r0.k2.y.f.a
    public void B(b.a.r0.k2.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            super.B(cVar);
            this.o.X0(cVar);
        }
    }

    @Override // b.a.r0.k2.y.f.a
    public void C(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            this.q.w0(fVar);
        }
    }

    @Override // b.a.r0.k2.y.f.a
    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.q.q(str);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.q = new j(this.f19760b.getVideoPbFragment(), PostData.x0);
            this.n = new a0(this.f19760b.getVideoPbFragment(), k.f18776g, this.f19760b.getUniqueId());
            this.m = new h0(this.f19760b.getVideoPbFragment(), m.M0);
            y0 y0Var = new y0(this.f19760b.getVideoPbFragment(), PostData.y0);
            this.o = y0Var;
            y0Var.Y0(this.f19760b.getVideoPbFragment());
            this.o.U0(this.f19760b.getVideoPbFragment().getFromVideoPageType());
            this.p = new PbReplyLoadMoreAdapter(this.f19760b.getVideoPbFragment(), PostData.E0);
            this.r = new i(this.f19760b.getContext(), w.f18824f, this.f19760b.getVideoPbFragment());
            this.f19763e.add(this.q);
            this.f19763e.add(this.r);
            this.f19763e.add(this.m);
            this.f19763e.add(this.n);
            this.f19763e.add(this.o);
            this.f19763e.add(this.p);
            this.f19761c.addAdapters(this.f19763e);
        }
    }

    @Override // b.a.r0.k2.y.f.a
    public l0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (l0) invokeV.objValue;
    }

    @Override // b.a.r0.k2.y.f.a
    public l f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (l) invokeV.objValue;
    }

    @Override // b.a.r0.k2.y.f.a
    public PbFirstFloorCommentAndPraiseAdapter g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // b.a.r0.k2.y.f.a
    public void k() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (bdTypeRecyclerView = this.f19761c) == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f19761c.getListAdapter().notifyDataSetChanged();
    }

    @Override // b.a.r0.k2.y.f.a
    public void l() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (jVar = this.q) == null) {
            return;
        }
        jVar.O();
    }

    @Override // b.a.r0.k2.y.f.a
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // b.a.r0.k2.y.f.a
    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
        }
    }

    @Override // b.a.r0.k2.y.f.a
    public void p(b.a.r0.k2.r.f fVar, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{fVar, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.o.t(fVar);
            this.o.setFromCDN(z);
            this.o.q(str);
            this.o.c(z2);
            this.o.W0(0.5f);
        }
    }

    @Override // b.a.r0.k2.y.f.a
    public void u(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) {
            super.u(onClickListener);
            this.o.m(onClickListener);
        }
    }

    @Override // b.a.r0.k2.y.f.a
    public void v(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, zVar) == null) {
            super.v(zVar);
            this.o.p(zVar);
        }
    }

    @Override // b.a.r0.k2.y.f.a
    public void w(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onLongClickListener) == null) {
            super.w(onLongClickListener);
            this.o.d(onLongClickListener);
        }
    }

    @Override // b.a.r0.k2.y.f.a
    public void y(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            super.y(onClickListener);
            this.o.e(onClickListener);
            this.p.k0(onClickListener);
        }
    }

    @Override // b.a.r0.k2.y.f.a
    public void z(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) {
            this.n.k0(onClickListener);
        }
    }
}
