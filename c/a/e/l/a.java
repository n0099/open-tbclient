package c.a.e.l;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.e.d;
import c.a.r0.d1.a3.c;
import c.a.r0.h3.l0.e;
import c.a.r0.h3.l0.g;
import c.a.r0.w1.o.l.f;
import c.a.r0.w1.o.l.h;
import c.a.r0.w1.o.l.j;
import com.baidu.adp.BdUniqueId;
import com.baidu.afd.adapter.AdCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class a extends c.a.d.m.e.a<d, AdCardViewHolder> implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ICardInfo m;
    public d n;
    public TbPageContext o;
    public c.a.r0.d1.s1.a p;
    public c q;
    public j r;
    public List<j> s;
    public f t;

    /* renamed from: c.a.e.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0100a implements c.a.r0.w1.o.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0100a(a aVar) {
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
            this.a = aVar;
        }

        @Override // c.a.r0.w1.o.a
        public void a(int i2, HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, hashMap) == null) {
                a aVar = this.a;
                aVar.k0(aVar.n, this.a.n.k());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, c.a.r0.d1.s1.a aVar, c cVar, f fVar) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, aVar, cVar, fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = new ArrayList();
        this.o = tbPageContext;
        this.p = aVar;
        this.q = cVar;
        this.t = fVar;
    }

    @Override // c.a.r0.w1.o.l.f
    public void h(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jVar) == null) {
            this.r = jVar;
            f fVar = this.t;
            if (fVar != null) {
                fVar.h(jVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: i0 */
    public View E(int i2, View view, ViewGroup viewGroup, d dVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, dVar})) == null) {
            this.n = dVar;
            this.m = dVar.o();
            return super.E(i2, view, viewGroup, dVar);
        }
        return (View) invokeCommon.objValue;
    }

    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            j jVar = this.r;
            if (jVar != null) {
                return jVar.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void k0(d dVar, int i2) {
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, dVar, i2) == null) || dVar == null) {
            return;
        }
        AdvertAppInfo w = dVar.w();
        int i3 = 2;
        if (w != null && (iLegoAdvert = w.k4) != null && iLegoAdvert.forFree()) {
            i3 = 102;
        }
        e.b().d(g.b(w, i3, i2));
        c.a.r0.w1.o.h.c.h(dVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: l0 */
    public AdCardViewHolder S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        c.a.r0.w1.o.l.e a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            if (this.m == null || (a = c.a.r0.w1.o.b.h().a(this.o, this.m, 2)) == null) {
                return null;
            }
            if (a instanceof j) {
                this.s.add((j) a);
            }
            a.setAfterClickSchemeListener(new C0100a(this));
            return new AdCardViewHolder(a);
        }
        return (AdCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: m0 */
    public AdCardViewHolder T(ViewGroup viewGroup, d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, viewGroup, dVar)) == null) {
            if (dVar == null || dVar.o() == null) {
                return null;
            }
            this.n = dVar;
            this.m = dVar.o();
            return S(viewGroup);
        }
        return (AdCardViewHolder) invokeLL.objValue;
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            for (j jVar : this.s) {
                if (jVar != null) {
                    jVar.onDestroy();
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: o0 */
    public View Z(int i2, View view, ViewGroup viewGroup, d dVar, AdCardViewHolder adCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), view, viewGroup, dVar, adCardViewHolder})) == null) {
            if (dVar == null || adCardViewHolder == null) {
                return null;
            }
            if (adCardViewHolder.getAdCardView() instanceof h) {
                h hVar = (h) adCardViewHolder.getAdCardView();
                hVar.setAutoPlayCallBack(this.p);
                hVar.setOnVideoContainerForegroundClickListener(this.q);
                hVar.setCurrentPlayCallBack(this);
            }
            dVar.q();
            if (adCardViewHolder.getAdCardView() != null) {
                adCardViewHolder.getAdCardView().setPosition(i2);
                adCardViewHolder.getAdCardView().update(dVar.o());
            }
            return adCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void p0() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (jVar = this.r) == null) {
            return;
        }
        jVar.pausePlay();
    }

    public void q0() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (jVar = this.r) == null) {
            return;
        }
        jVar.stopPlay();
    }
}
