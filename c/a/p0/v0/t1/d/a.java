package c.a.p0.v0.t1.d;

import c.a.e.k.e.n;
import c.a.o0.s.q.c2;
import c.a.p0.g0.b;
import c.a.p0.g0.c;
import c.a.p0.g0.d;
import c.a.p0.g0.e;
import c.a.p0.g0.f;
import c.a.p0.g0.g;
import c.a.p0.g0.h;
import c.a.p0.v0.w;
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
    public List<n> f26846a;

    /* renamed from: b  reason: collision with root package name */
    public List<c2> f26847b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f26848c;

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
        this.f26846a = new ArrayList();
        this.f26847b = new ArrayList();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f26846a : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i2 = 0; i2 < this.f26847b.size(); i2++) {
                c2 c2Var = this.f26847b.get(i2);
                if (c2Var != null) {
                    if (i2 % 4 == 0) {
                        c.a.p0.g0.a aVar = new c.a.p0.g0.a();
                        aVar.g(c2Var);
                        this.f26846a.add(aVar);
                    } else {
                        b bVar = new b();
                        bVar.g(c2Var);
                        this.f26846a.add(bVar);
                    }
                }
            }
        }
    }

    public void c(int i2, c.a.p0.v0.t1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, aVar) == null) || aVar == null) {
            return;
        }
        if (1 == i2) {
            this.f26846a.clear();
            this.f26847b.clear();
            this.f26848c = new Object[aVar.f26834b + 10];
        }
        if (!ListUtils.isEmpty(aVar.f26835c)) {
            ArrayList arrayList = new ArrayList(aVar.f26835c.size());
            for (c2 c2Var : aVar.f26835c) {
                if (c2Var != null) {
                    arrayList.add(c2Var);
                }
            }
            this.f26847b.addAll(arrayList);
        }
        if (1 == i2) {
            e(aVar);
        }
        this.f26846a.clear();
        b();
        g();
        f(aVar);
    }

    public final void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            Object[] objArr = this.f26848c;
            if (i2 >= objArr.length) {
                this.f26848c = Arrays.copyOf(objArr, i2 + 1);
            }
        }
    }

    public final void e(c.a.p0.v0.t1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            if (!ListUtils.isEmpty(aVar.f26837e)) {
                for (FeatureCardHot featureCardHot : aVar.f26837e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.f26848c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.f26838f)) {
                for (FeatureCardTopic featureCardTopic : aVar.f26838f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.f26848c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.f26839g)) {
                for (c.a.p0.v0.t1.c.b bVar : aVar.f26839g) {
                    if (bVar != null && bVar.a()) {
                        d(bVar.f26845c.intValue());
                        this.f26848c[bVar.f26845c.intValue()] = bVar;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.f26840h)) {
                for (FeatureCardCompetition featureCardCompetition : aVar.f26840h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.f26848c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.f26841i)) {
                for (FeatureCardGod featureCardGod : aVar.f26841i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.f26848c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (ListUtils.isEmpty(aVar.f26842j)) {
                return;
            }
            for (FeatureCardGame featureCardGame : aVar.f26842j) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    d(featureCardGame.floor.intValue());
                    this.f26848c[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    public final void f(c.a.p0.v0.t1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            g gVar = new g();
            gVar.i(aVar.f26836d);
            this.f26846a.add(0, gVar);
        }
    }

    public final void g() {
        Object[] objArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (objArr = this.f26848c) == null || objArr.length <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            Object[] objArr2 = this.f26848c;
            if (i2 >= objArr2.length) {
                return;
            }
            Object obj = objArr2[i2];
            if (obj != null) {
                int i3 = i2 - 1;
                if (i3 < 0) {
                    i3 = 0;
                } else if (i3 >= this.f26846a.size()) {
                    i3 = this.f26846a.size();
                }
                if (obj instanceof FeatureCardHot) {
                    e eVar = new e();
                    eVar.i((FeatureCardHot) obj);
                    this.f26846a.add(i3, eVar);
                } else if (obj instanceof FeatureCardTopic) {
                    h hVar = new h();
                    hVar.c((FeatureCardTopic) obj);
                    this.f26846a.add(i3, hVar);
                } else if (obj instanceof c.a.p0.v0.t1.c.b) {
                    d dVar = new d();
                    dVar.i((c.a.p0.v0.t1.c.b) obj);
                    this.f26846a.add(i3, dVar);
                } else if (obj instanceof FeatureCardCompetition) {
                    c cVar = new c();
                    cVar.c((FeatureCardCompetition) obj);
                    this.f26846a.add(i3, cVar);
                } else if (obj instanceof FeatureCardGod) {
                    w wVar = new w();
                    wVar.h((FeatureCardGod) obj);
                    this.f26846a.add(i3, wVar);
                } else if (obj instanceof FeatureCardGame) {
                    f fVar = new f();
                    fVar.c((FeatureCardGame) obj);
                    this.f26846a.add(i3, fVar);
                }
            }
            i2++;
        }
    }
}
