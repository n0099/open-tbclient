package c.a.t0.e1.g2.d;

import c.a.d.n.e.n;
import c.a.s0.s.q.e2;
import c.a.t0.e1.w;
import c.a.t0.n0.b;
import c.a.t0.n0.c;
import c.a.t0.n0.d;
import c.a.t0.n0.e;
import c.a.t0.n0.f;
import c.a.t0.n0.g;
import c.a.t0.n0.h;
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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<n> a;

    /* renamed from: b  reason: collision with root package name */
    public List<e2> f16445b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f16446c;

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
        this.a = new ArrayList();
        this.f16445b = new ArrayList();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i2 = 0; i2 < this.f16445b.size(); i2++) {
                e2 e2Var = this.f16445b.get(i2);
                if (e2Var != null) {
                    if (i2 % 4 == 0) {
                        c.a.t0.n0.a aVar = new c.a.t0.n0.a();
                        aVar.g(e2Var);
                        this.a.add(aVar);
                    } else {
                        b bVar = new b();
                        bVar.g(e2Var);
                        this.a.add(bVar);
                    }
                }
            }
        }
    }

    public void c(int i2, c.a.t0.e1.g2.c.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, aVar) == null) || aVar == null) {
            return;
        }
        if (1 == i2) {
            this.a.clear();
            this.f16445b.clear();
            this.f16446c = new Object[aVar.f16434b + 10];
        }
        if (!ListUtils.isEmpty(aVar.f16435c)) {
            ArrayList arrayList = new ArrayList(aVar.f16435c.size());
            for (e2 e2Var : aVar.f16435c) {
                if (e2Var != null) {
                    arrayList.add(e2Var);
                }
            }
            this.f16445b.addAll(arrayList);
        }
        if (1 == i2) {
            e(aVar);
        }
        this.a.clear();
        b();
        g();
        f(aVar);
    }

    public final void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            Object[] objArr = this.f16446c;
            if (i2 >= objArr.length) {
                this.f16446c = Arrays.copyOf(objArr, i2 + 1);
            }
        }
    }

    public final void e(c.a.t0.e1.g2.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            if (!ListUtils.isEmpty(aVar.f16437e)) {
                for (FeatureCardHot featureCardHot : aVar.f16437e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.f16446c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.f16438f)) {
                for (FeatureCardTopic featureCardTopic : aVar.f16438f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.f16446c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.f16439g)) {
                for (c.a.t0.e1.g2.c.b bVar : aVar.f16439g) {
                    if (bVar != null && bVar.a()) {
                        d(bVar.f16444c.intValue());
                        this.f16446c[bVar.f16444c.intValue()] = bVar;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.f16440h)) {
                for (FeatureCardCompetition featureCardCompetition : aVar.f16440h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.f16446c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.f16441i)) {
                for (FeatureCardGod featureCardGod : aVar.f16441i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.f16446c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (ListUtils.isEmpty(aVar.f16442j)) {
                return;
            }
            for (FeatureCardGame featureCardGame : aVar.f16442j) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    d(featureCardGame.floor.intValue());
                    this.f16446c[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    public final void f(c.a.t0.e1.g2.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            g gVar = new g();
            gVar.i(aVar.f16436d);
            this.a.add(0, gVar);
        }
    }

    public final void g() {
        Object[] objArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (objArr = this.f16446c) == null || objArr.length <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            Object[] objArr2 = this.f16446c;
            if (i2 >= objArr2.length) {
                return;
            }
            Object obj = objArr2[i2];
            if (obj != null) {
                int i3 = i2 - 1;
                if (i3 < 0) {
                    i3 = 0;
                } else if (i3 >= this.a.size()) {
                    i3 = this.a.size();
                }
                if (obj instanceof FeatureCardHot) {
                    e eVar = new e();
                    eVar.i((FeatureCardHot) obj);
                    this.a.add(i3, eVar);
                } else if (obj instanceof FeatureCardTopic) {
                    h hVar = new h();
                    hVar.d((FeatureCardTopic) obj);
                    this.a.add(i3, hVar);
                } else if (obj instanceof c.a.t0.e1.g2.c.b) {
                    d dVar = new d();
                    dVar.i((c.a.t0.e1.g2.c.b) obj);
                    this.a.add(i3, dVar);
                } else if (obj instanceof FeatureCardCompetition) {
                    c cVar = new c();
                    cVar.d((FeatureCardCompetition) obj);
                    this.a.add(i3, cVar);
                } else if (obj instanceof FeatureCardGod) {
                    w wVar = new w();
                    wVar.h((FeatureCardGod) obj);
                    this.a.add(i3, wVar);
                } else if (obj instanceof FeatureCardGame) {
                    f fVar = new f();
                    fVar.d((FeatureCardGame) obj);
                    this.a.add(i3, fVar);
                }
            }
            i2++;
        }
    }
}
