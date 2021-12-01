package c.a.r0.d1.f2.c;

import c.a.q0.s.q.d2;
import com.baidu.tbadk.data.FeatureCardGod;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public int f15480b;

    /* renamed from: c  reason: collision with root package name */
    public List<d2> f15481c;

    /* renamed from: d  reason: collision with root package name */
    public ScoreCardInfo f15482d;

    /* renamed from: e  reason: collision with root package name */
    public List<FeatureCardHot> f15483e;

    /* renamed from: f  reason: collision with root package name */
    public List<FeatureCardTopic> f15484f;

    /* renamed from: g  reason: collision with root package name */
    public List<b> f15485g;

    /* renamed from: h  reason: collision with root package name */
    public List<FeatureCardCompetition> f15486h;

    /* renamed from: i  reason: collision with root package name */
    public List<FeatureCardGod> f15487i;

    /* renamed from: j  reason: collision with root package name */
    public List<FeatureCardGame> f15488j;

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
        this.f15481c = new ArrayList();
        this.f15483e = new ArrayList();
        this.f15484f = new ArrayList();
        this.f15485g = new ArrayList();
        this.f15486h = new ArrayList();
        this.f15487i = new ArrayList();
        this.f15488j = new ArrayList();
    }
}
