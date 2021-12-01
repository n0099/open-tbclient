package c.a.r0.d1.f2.d;

import c.a.d.m.e.n;
import c.a.q0.s.q.d2;
import c.a.r0.d1.w;
import c.a.r0.n0.b;
import c.a.r0.n0.c;
import c.a.r0.n0.d;
import c.a.r0.n0.e;
import c.a.r0.n0.f;
import c.a.r0.n0.g;
import c.a.r0.n0.h;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<n> a;

    /* renamed from: b  reason: collision with root package name */
    public List<d2> f15491b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f15492c;

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
        this.f15491b = new ArrayList();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i2 = 0; i2 < this.f15491b.size(); i2++) {
                d2 d2Var = this.f15491b.get(i2);
                if (d2Var != null) {
                    if (i2 % 4 == 0) {
                        c.a.r0.n0.a aVar = new c.a.r0.n0.a();
                        aVar.g(d2Var);
                        this.a.add(aVar);
                    } else {
                        b bVar = new b();
                        bVar.g(d2Var);
                        this.a.add(bVar);
                    }
                }
            }
        }
    }

    public void c(int i2, c.a.r0.d1.f2.c.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, aVar) == null) || aVar == null) {
            return;
        }
        if (1 == i2) {
            this.a.clear();
            this.f15491b.clear();
            this.f15492c = new Object[aVar.f15480b + 10];
        }
        if (!ListUtils.isEmpty(aVar.f15481c)) {
            ArrayList arrayList = new ArrayList(aVar.f15481c.size());
            for (d2 d2Var : aVar.f15481c) {
                if (d2Var != null) {
                    arrayList.add(d2Var);
                }
            }
            this.f15491b.addAll(arrayList);
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
            Object[] objArr = this.f15492c;
            if (i2 >= objArr.length) {
                this.f15492c = Arrays.copyOf(objArr, i2 + 1);
            }
        }
    }

    public final void e(c.a.r0.d1.f2.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            if (!ListUtils.isEmpty(aVar.f15483e)) {
                for (FeatureCardHot featureCardHot : aVar.f15483e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.f15492c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.f15484f)) {
                for (FeatureCardTopic featureCardTopic : aVar.f15484f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.f15492c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.f15485g)) {
                for (c.a.r0.d1.f2.c.b bVar : aVar.f15485g) {
                    if (bVar != null && bVar.a()) {
                        d(bVar.f15490c.intValue());
                        this.f15492c[bVar.f15490c.intValue()] = bVar;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.f15486h)) {
                for (FeatureCardCompetition featureCardCompetition : aVar.f15486h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.f15492c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.f15487i)) {
                for (FeatureCardGod featureCardGod : aVar.f15487i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.f15492c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (ListUtils.isEmpty(aVar.f15488j)) {
                return;
            }
            for (FeatureCardGame featureCardGame : aVar.f15488j) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    d(featureCardGame.floor.intValue());
                    this.f15492c[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    public final void f(c.a.r0.d1.f2.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            g gVar = new g();
            gVar.i(aVar.f15482d);
            this.a.add(0, gVar);
        }
    }

    public final void g() {
        Object[] objArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (objArr = this.f15492c) == null || objArr.length <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            Object[] objArr2 = this.f15492c;
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
                } else if (obj instanceof c.a.r0.d1.f2.c.b) {
                    d dVar = new d();
                    dVar.i((c.a.r0.d1.f2.c.b) obj);
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
