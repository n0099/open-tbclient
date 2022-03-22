package c.a.p0.f1.w1.d;

import c.a.d.o.e.n;
import c.a.p0.f1.w;
import c.a.p0.o0.b;
import c.a.p0.o0.c;
import c.a.p0.o0.d;
import c.a.p0.o0.e;
import c.a.p0.o0.f;
import c.a.p0.o0.g;
import c.a.p0.o0.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<n> a;

    /* renamed from: b  reason: collision with root package name */
    public List<ThreadData> f14819b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f14820c;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.f14819b = new ArrayList();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i = 0; i < this.f14819b.size(); i++) {
                ThreadData threadData = this.f14819b.get(i);
                if (threadData != null) {
                    if (i % 4 == 0) {
                        c.a.p0.o0.a aVar = new c.a.p0.o0.a();
                        aVar.e(threadData);
                        this.a.add(aVar);
                    } else {
                        b bVar = new b();
                        bVar.e(threadData);
                        this.a.add(bVar);
                    }
                }
            }
        }
    }

    public void c(int i, c.a.p0.f1.w1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, aVar) == null) || aVar == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.f14819b.clear();
            this.f14820c = new Object[aVar.f14810b + 10];
        }
        if (!ListUtils.isEmpty(aVar.f14811c)) {
            ArrayList arrayList = new ArrayList(aVar.f14811c.size());
            for (ThreadData threadData : aVar.f14811c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.f14819b.addAll(arrayList);
        }
        if (1 == i) {
            e(aVar);
        }
        this.a.clear();
        b();
        g();
        f(aVar);
    }

    public final void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            Object[] objArr = this.f14820c;
            if (i >= objArr.length) {
                this.f14820c = Arrays.copyOf(objArr, i + 1);
            }
        }
    }

    public final void e(c.a.p0.f1.w1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            if (!ListUtils.isEmpty(aVar.f14813e)) {
                for (FeatureCardHot featureCardHot : aVar.f14813e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.f14820c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.f14814f)) {
                for (FeatureCardTopic featureCardTopic : aVar.f14814f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.f14820c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.f14815g)) {
                for (c.a.p0.f1.w1.c.b bVar : aVar.f14815g) {
                    if (bVar != null && bVar.a()) {
                        d(bVar.f14818c.intValue());
                        this.f14820c[bVar.f14818c.intValue()] = bVar;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.f14816h)) {
                for (FeatureCardCompetition featureCardCompetition : aVar.f14816h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.f14820c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.i)) {
                for (FeatureCardGod featureCardGod : aVar.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.f14820c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (ListUtils.isEmpty(aVar.j)) {
                return;
            }
            for (FeatureCardGame featureCardGame : aVar.j) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    d(featureCardGame.floor.intValue());
                    this.f14820c[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    public final void f(c.a.p0.f1.w1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            g gVar = new g();
            gVar.g(aVar.f14812d);
            this.a.add(0, gVar);
        }
    }

    public final void g() {
        Object[] objArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (objArr = this.f14820c) == null || objArr.length <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            Object[] objArr2 = this.f14820c;
            if (i >= objArr2.length) {
                return;
            }
            Object obj = objArr2[i];
            if (obj != null) {
                int i2 = i - 1;
                if (i2 < 0) {
                    i2 = 0;
                } else if (i2 >= this.a.size()) {
                    i2 = this.a.size();
                }
                if (obj instanceof FeatureCardHot) {
                    e eVar = new e();
                    eVar.g((FeatureCardHot) obj);
                    this.a.add(i2, eVar);
                } else if (obj instanceof FeatureCardTopic) {
                    h hVar = new h();
                    hVar.b((FeatureCardTopic) obj);
                    this.a.add(i2, hVar);
                } else if (obj instanceof c.a.p0.f1.w1.c.b) {
                    d dVar = new d();
                    dVar.g((c.a.p0.f1.w1.c.b) obj);
                    this.a.add(i2, dVar);
                } else if (obj instanceof FeatureCardCompetition) {
                    c cVar = new c();
                    cVar.b((FeatureCardCompetition) obj);
                    this.a.add(i2, cVar);
                } else if (obj instanceof FeatureCardGod) {
                    w wVar = new w();
                    wVar.g((FeatureCardGod) obj);
                    this.a.add(i2, wVar);
                } else if (obj instanceof FeatureCardGame) {
                    f fVar = new f();
                    fVar.b((FeatureCardGame) obj);
                    this.a.add(i2, fVar);
                }
            }
            i++;
        }
    }
}
