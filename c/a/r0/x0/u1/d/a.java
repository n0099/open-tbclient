package c.a.r0.x0.u1.d;

import c.a.e.l.e.n;
import c.a.q0.s.q.d2;
import c.a.r0.h0.b;
import c.a.r0.h0.c;
import c.a.r0.h0.d;
import c.a.r0.h0.e;
import c.a.r0.h0.f;
import c.a.r0.h0.g;
import c.a.r0.h0.h;
import c.a.r0.x0.w;
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
    public List<n> f28059a;

    /* renamed from: b  reason: collision with root package name */
    public List<d2> f28060b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f28061c;

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
        this.f28059a = new ArrayList();
        this.f28060b = new ArrayList();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28059a : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i2 = 0; i2 < this.f28060b.size(); i2++) {
                d2 d2Var = this.f28060b.get(i2);
                if (d2Var != null) {
                    if (i2 % 4 == 0) {
                        c.a.r0.h0.a aVar = new c.a.r0.h0.a();
                        aVar.g(d2Var);
                        this.f28059a.add(aVar);
                    } else {
                        b bVar = new b();
                        bVar.g(d2Var);
                        this.f28059a.add(bVar);
                    }
                }
            }
        }
    }

    public void c(int i2, c.a.r0.x0.u1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, aVar) == null) || aVar == null) {
            return;
        }
        if (1 == i2) {
            this.f28059a.clear();
            this.f28060b.clear();
            this.f28061c = new Object[aVar.f28047b + 10];
        }
        if (!ListUtils.isEmpty(aVar.f28048c)) {
            ArrayList arrayList = new ArrayList(aVar.f28048c.size());
            for (d2 d2Var : aVar.f28048c) {
                if (d2Var != null) {
                    arrayList.add(d2Var);
                }
            }
            this.f28060b.addAll(arrayList);
        }
        if (1 == i2) {
            e(aVar);
        }
        this.f28059a.clear();
        b();
        g();
        f(aVar);
    }

    public final void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            Object[] objArr = this.f28061c;
            if (i2 >= objArr.length) {
                this.f28061c = Arrays.copyOf(objArr, i2 + 1);
            }
        }
    }

    public final void e(c.a.r0.x0.u1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            if (!ListUtils.isEmpty(aVar.f28050e)) {
                for (FeatureCardHot featureCardHot : aVar.f28050e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.f28061c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.f28051f)) {
                for (FeatureCardTopic featureCardTopic : aVar.f28051f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.f28061c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.f28052g)) {
                for (c.a.r0.x0.u1.c.b bVar : aVar.f28052g) {
                    if (bVar != null && bVar.a()) {
                        d(bVar.f28058c.intValue());
                        this.f28061c[bVar.f28058c.intValue()] = bVar;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.f28053h)) {
                for (FeatureCardCompetition featureCardCompetition : aVar.f28053h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.f28061c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.f28054i)) {
                for (FeatureCardGod featureCardGod : aVar.f28054i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.f28061c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (ListUtils.isEmpty(aVar.f28055j)) {
                return;
            }
            for (FeatureCardGame featureCardGame : aVar.f28055j) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    d(featureCardGame.floor.intValue());
                    this.f28061c[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    public final void f(c.a.r0.x0.u1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            g gVar = new g();
            gVar.i(aVar.f28049d);
            this.f28059a.add(0, gVar);
        }
    }

    public final void g() {
        Object[] objArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (objArr = this.f28061c) == null || objArr.length <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            Object[] objArr2 = this.f28061c;
            if (i2 >= objArr2.length) {
                return;
            }
            Object obj = objArr2[i2];
            if (obj != null) {
                int i3 = i2 - 1;
                if (i3 < 0) {
                    i3 = 0;
                } else if (i3 >= this.f28059a.size()) {
                    i3 = this.f28059a.size();
                }
                if (obj instanceof FeatureCardHot) {
                    e eVar = new e();
                    eVar.i((FeatureCardHot) obj);
                    this.f28059a.add(i3, eVar);
                } else if (obj instanceof FeatureCardTopic) {
                    h hVar = new h();
                    hVar.c((FeatureCardTopic) obj);
                    this.f28059a.add(i3, hVar);
                } else if (obj instanceof c.a.r0.x0.u1.c.b) {
                    d dVar = new d();
                    dVar.i((c.a.r0.x0.u1.c.b) obj);
                    this.f28059a.add(i3, dVar);
                } else if (obj instanceof FeatureCardCompetition) {
                    c cVar = new c();
                    cVar.c((FeatureCardCompetition) obj);
                    this.f28059a.add(i3, cVar);
                } else if (obj instanceof FeatureCardGod) {
                    w wVar = new w();
                    wVar.h((FeatureCardGod) obj);
                    this.f28059a.add(i3, wVar);
                } else if (obj instanceof FeatureCardGame) {
                    f fVar = new f();
                    fVar.c((FeatureCardGame) obj);
                    this.f28059a.add(i3, fVar);
                }
            }
            i2++;
        }
    }
}
