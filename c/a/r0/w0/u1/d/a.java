package c.a.r0.w0.u1.d;

import c.a.e.l.e.n;
import c.a.q0.s.q.d2;
import c.a.r0.g0.b;
import c.a.r0.g0.c;
import c.a.r0.g0.d;
import c.a.r0.g0.e;
import c.a.r0.g0.f;
import c.a.r0.g0.g;
import c.a.r0.g0.h;
import c.a.r0.w0.w;
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
    public List<n> f27863a;

    /* renamed from: b  reason: collision with root package name */
    public List<d2> f27864b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f27865c;

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
        this.f27863a = new ArrayList();
        this.f27864b = new ArrayList();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f27863a : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i2 = 0; i2 < this.f27864b.size(); i2++) {
                d2 d2Var = this.f27864b.get(i2);
                if (d2Var != null) {
                    if (i2 % 4 == 0) {
                        c.a.r0.g0.a aVar = new c.a.r0.g0.a();
                        aVar.g(d2Var);
                        this.f27863a.add(aVar);
                    } else {
                        b bVar = new b();
                        bVar.g(d2Var);
                        this.f27863a.add(bVar);
                    }
                }
            }
        }
    }

    public void c(int i2, c.a.r0.w0.u1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, aVar) == null) || aVar == null) {
            return;
        }
        if (1 == i2) {
            this.f27863a.clear();
            this.f27864b.clear();
            this.f27865c = new Object[aVar.f27851b + 10];
        }
        if (!ListUtils.isEmpty(aVar.f27852c)) {
            ArrayList arrayList = new ArrayList(aVar.f27852c.size());
            for (d2 d2Var : aVar.f27852c) {
                if (d2Var != null) {
                    arrayList.add(d2Var);
                }
            }
            this.f27864b.addAll(arrayList);
        }
        if (1 == i2) {
            e(aVar);
        }
        this.f27863a.clear();
        b();
        g();
        f(aVar);
    }

    public final void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            Object[] objArr = this.f27865c;
            if (i2 >= objArr.length) {
                this.f27865c = Arrays.copyOf(objArr, i2 + 1);
            }
        }
    }

    public final void e(c.a.r0.w0.u1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            if (!ListUtils.isEmpty(aVar.f27854e)) {
                for (FeatureCardHot featureCardHot : aVar.f27854e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.f27865c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.f27855f)) {
                for (FeatureCardTopic featureCardTopic : aVar.f27855f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.f27865c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.f27856g)) {
                for (c.a.r0.w0.u1.c.b bVar : aVar.f27856g) {
                    if (bVar != null && bVar.a()) {
                        d(bVar.f27862c.intValue());
                        this.f27865c[bVar.f27862c.intValue()] = bVar;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.f27857h)) {
                for (FeatureCardCompetition featureCardCompetition : aVar.f27857h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.f27865c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.f27858i)) {
                for (FeatureCardGod featureCardGod : aVar.f27858i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.f27865c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (ListUtils.isEmpty(aVar.f27859j)) {
                return;
            }
            for (FeatureCardGame featureCardGame : aVar.f27859j) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    d(featureCardGame.floor.intValue());
                    this.f27865c[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    public final void f(c.a.r0.w0.u1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            g gVar = new g();
            gVar.i(aVar.f27853d);
            this.f27863a.add(0, gVar);
        }
    }

    public final void g() {
        Object[] objArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (objArr = this.f27865c) == null || objArr.length <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            Object[] objArr2 = this.f27865c;
            if (i2 >= objArr2.length) {
                return;
            }
            Object obj = objArr2[i2];
            if (obj != null) {
                int i3 = i2 - 1;
                if (i3 < 0) {
                    i3 = 0;
                } else if (i3 >= this.f27863a.size()) {
                    i3 = this.f27863a.size();
                }
                if (obj instanceof FeatureCardHot) {
                    e eVar = new e();
                    eVar.i((FeatureCardHot) obj);
                    this.f27863a.add(i3, eVar);
                } else if (obj instanceof FeatureCardTopic) {
                    h hVar = new h();
                    hVar.c((FeatureCardTopic) obj);
                    this.f27863a.add(i3, hVar);
                } else if (obj instanceof c.a.r0.w0.u1.c.b) {
                    d dVar = new d();
                    dVar.i((c.a.r0.w0.u1.c.b) obj);
                    this.f27863a.add(i3, dVar);
                } else if (obj instanceof FeatureCardCompetition) {
                    c cVar = new c();
                    cVar.c((FeatureCardCompetition) obj);
                    this.f27863a.add(i3, cVar);
                } else if (obj instanceof FeatureCardGod) {
                    w wVar = new w();
                    wVar.h((FeatureCardGod) obj);
                    this.f27863a.add(i3, wVar);
                } else if (obj instanceof FeatureCardGame) {
                    f fVar = new f();
                    fVar.c((FeatureCardGame) obj);
                    this.f27863a.add(i3, fVar);
                }
            }
            i2++;
        }
    }
}
