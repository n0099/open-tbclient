package c.a.q0.v0.t1.d;

import c.a.e.l.e.n;
import c.a.p0.s.q.c2;
import c.a.q0.g0.b;
import c.a.q0.g0.c;
import c.a.q0.g0.d;
import c.a.q0.g0.e;
import c.a.q0.g0.f;
import c.a.q0.g0.g;
import c.a.q0.g0.h;
import c.a.q0.v0.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.FeatureCardGod;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<n> f27185a;

    /* renamed from: b  reason: collision with root package name */
    public List<c2> f27186b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f27187c;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27185a = new ArrayList();
        this.f27186b = new ArrayList();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f27185a : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i2 = 0; i2 < this.f27186b.size(); i2++) {
                c2 c2Var = this.f27186b.get(i2);
                if (c2Var != null) {
                    if (i2 % 4 == 0) {
                        c.a.q0.g0.a aVar = new c.a.q0.g0.a();
                        aVar.g(c2Var);
                        this.f27185a.add(aVar);
                    } else {
                        b bVar = new b();
                        bVar.g(c2Var);
                        this.f27185a.add(bVar);
                    }
                }
            }
        }
    }

    public void c(int i2, c.a.q0.v0.t1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, aVar) == null) || aVar == null) {
            return;
        }
        if (1 == i2) {
            this.f27185a.clear();
            this.f27186b.clear();
            this.f27187c = new Object[aVar.f27173b + 10];
        }
        if (!ListUtils.isEmpty(aVar.f27174c)) {
            ArrayList arrayList = new ArrayList(aVar.f27174c.size());
            for (c2 c2Var : aVar.f27174c) {
                if (c2Var != null) {
                    arrayList.add(c2Var);
                }
            }
            this.f27186b.addAll(arrayList);
        }
        if (1 == i2) {
            e(aVar);
        }
        this.f27185a.clear();
        b();
        g();
        f(aVar);
    }

    public final void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            Object[] objArr = this.f27187c;
            if (i2 >= objArr.length) {
                this.f27187c = Arrays.copyOf(objArr, i2 + 1);
            }
        }
    }

    public final void e(c.a.q0.v0.t1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            if (!ListUtils.isEmpty(aVar.f27176e)) {
                for (FeatureCardHot featureCardHot : aVar.f27176e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.f27187c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.f27177f)) {
                for (FeatureCardTopic featureCardTopic : aVar.f27177f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.f27187c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.f27178g)) {
                for (c.a.q0.v0.t1.c.b bVar : aVar.f27178g) {
                    if (bVar != null && bVar.a()) {
                        d(bVar.f27184c.intValue());
                        this.f27187c[bVar.f27184c.intValue()] = bVar;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.f27179h)) {
                for (FeatureCardCompetition featureCardCompetition : aVar.f27179h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.f27187c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.f27180i)) {
                for (FeatureCardGod featureCardGod : aVar.f27180i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.f27187c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (ListUtils.isEmpty(aVar.f27181j)) {
                return;
            }
            for (FeatureCardGame featureCardGame : aVar.f27181j) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    d(featureCardGame.floor.intValue());
                    this.f27187c[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    public final void f(c.a.q0.v0.t1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            g gVar = new g();
            gVar.i(aVar.f27175d);
            this.f27185a.add(0, gVar);
        }
    }

    public final void g() {
        Object[] objArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (objArr = this.f27187c) == null || objArr.length <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            Object[] objArr2 = this.f27187c;
            if (i2 >= objArr2.length) {
                return;
            }
            Object obj = objArr2[i2];
            if (obj != null) {
                int i3 = i2 - 1;
                if (i3 < 0) {
                    i3 = 0;
                } else if (i3 >= this.f27185a.size()) {
                    i3 = this.f27185a.size();
                }
                if (obj instanceof FeatureCardHot) {
                    e eVar = new e();
                    eVar.i((FeatureCardHot) obj);
                    this.f27185a.add(i3, eVar);
                } else if (obj instanceof FeatureCardTopic) {
                    h hVar = new h();
                    hVar.c((FeatureCardTopic) obj);
                    this.f27185a.add(i3, hVar);
                } else if (obj instanceof c.a.q0.v0.t1.c.b) {
                    d dVar = new d();
                    dVar.i((c.a.q0.v0.t1.c.b) obj);
                    this.f27185a.add(i3, dVar);
                } else if (obj instanceof FeatureCardCompetition) {
                    c cVar = new c();
                    cVar.c((FeatureCardCompetition) obj);
                    this.f27185a.add(i3, cVar);
                } else if (obj instanceof FeatureCardGod) {
                    w wVar = new w();
                    wVar.h((FeatureCardGod) obj);
                    this.f27185a.add(i3, wVar);
                } else if (obj instanceof FeatureCardGame) {
                    f fVar = new f();
                    fVar.c((FeatureCardGame) obj);
                    this.f27185a.add(i3, fVar);
                }
            }
            i2++;
        }
    }
}
