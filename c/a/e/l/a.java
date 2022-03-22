package c.a.e.l;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.e.d;
import c.a.p0.b2.o.l.f;
import c.a.p0.b2.o.l.h;
import c.a.p0.b2.o.l.j;
import c.a.p0.f1.t2.c;
import c.a.p0.l3.m0.e;
import c.a.p0.l3.m0.g;
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
public class a extends c.a.d.o.e.a<d, AdCardViewHolder> implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ICardInfo i;
    public d j;
    public TbPageContext k;
    public c.a.p0.f1.j1.a l;
    public c m;
    public j n;
    public List<j> o;
    public f p;

    /* renamed from: c.a.e.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0113a implements c.a.p0.b2.o.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0113a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.p0.b2.o.a
        public void a(int i, HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, hashMap) == null) {
                a aVar = this.a;
                aVar.d0(aVar.j, this.a.j.i());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, c.a.p0.f1.j1.a aVar, c cVar, f fVar) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, aVar, cVar, fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new ArrayList();
        this.k = tbPageContext;
        this.l = aVar;
        this.m = cVar;
        this.p = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: b0 */
    public View E(int i, View view, ViewGroup viewGroup, d dVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view, viewGroup, dVar})) == null) {
            this.j = dVar;
            this.i = dVar.k();
            return super.E(i, view, viewGroup, dVar);
        }
        return (View) invokeCommon.objValue;
    }

    public boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            j jVar = this.n;
            if (jVar != null) {
                return jVar.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void d0(d dVar, int i) {
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, dVar, i) == null) || dVar == null) {
            return;
        }
        AdvertAppInfo s = dVar.s();
        int i2 = 2;
        if (s != null && (iLegoAdvert = s.i) != null && iLegoAdvert.forFree()) {
            i2 = 102;
        }
        e.b().d(g.b(s, i2, i));
        c.a.p0.b2.o.h.c.h(dVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: e0 */
    public AdCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        c.a.p0.b2.o.l.e a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            if (this.i == null || (a = c.a.p0.b2.o.b.h().a(this.k, this.i, 2)) == null) {
                return null;
            }
            if (a instanceof j) {
                this.o.add((j) a);
            }
            a.setAfterClickSchemeListener(new C0113a(this));
            return new AdCardViewHolder(a);
        }
        return (AdCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: f0 */
    public AdCardViewHolder N(ViewGroup viewGroup, d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup, dVar)) == null) {
            if (dVar == null || dVar.k() == null) {
                return null;
            }
            this.j = dVar;
            this.i = dVar.k();
            return M(viewGroup);
        }
        return (AdCardViewHolder) invokeLL.objValue;
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            for (j jVar : this.o) {
                if (jVar != null) {
                    jVar.onDestroy();
                }
            }
        }
    }

    @Override // c.a.p0.b2.o.l.f
    public void h(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jVar) == null) {
            this.n = jVar;
            f fVar = this.p;
            if (fVar != null) {
                fVar.h(jVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: h0 */
    public View S(int i, View view, ViewGroup viewGroup, d dVar, AdCardViewHolder adCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), view, viewGroup, dVar, adCardViewHolder})) == null) {
            if (dVar == null || adCardViewHolder == null) {
                return null;
            }
            if (adCardViewHolder.c() instanceof h) {
                h hVar = (h) adCardViewHolder.c();
                hVar.setAutoPlayCallBack(this.l);
                hVar.setOnVideoContainerForegroundClickListener(this.m);
                hVar.setCurrentPlayCallBack(this);
            }
            dVar.q();
            if (adCardViewHolder.c() != null) {
                adCardViewHolder.c().setPosition(i);
                adCardViewHolder.c().update(dVar.k());
            }
            return adCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void i0() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (jVar = this.n) == null) {
            return;
        }
        jVar.pausePlay();
    }

    public void j0() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (jVar = this.n) == null) {
            return;
        }
        jVar.stopPlay();
    }
}
