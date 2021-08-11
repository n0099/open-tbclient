package c.a.p0.v0.t1.c;

import c.a.o0.s.q.c2;
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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f26833a;

    /* renamed from: b  reason: collision with root package name */
    public int f26834b;

    /* renamed from: c  reason: collision with root package name */
    public List<c2> f26835c;

    /* renamed from: d  reason: collision with root package name */
    public ScoreCardInfo f26836d;

    /* renamed from: e  reason: collision with root package name */
    public List<FeatureCardHot> f26837e;

    /* renamed from: f  reason: collision with root package name */
    public List<FeatureCardTopic> f26838f;

    /* renamed from: g  reason: collision with root package name */
    public List<b> f26839g;

    /* renamed from: h  reason: collision with root package name */
    public List<FeatureCardCompetition> f26840h;

    /* renamed from: i  reason: collision with root package name */
    public List<FeatureCardGod> f26841i;

    /* renamed from: j  reason: collision with root package name */
    public List<FeatureCardGame> f26842j;

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
        this.f26835c = new ArrayList();
        this.f26837e = new ArrayList();
        this.f26838f = new ArrayList();
        this.f26839g = new ArrayList();
        this.f26840h = new ArrayList();
        this.f26841i = new ArrayList();
        this.f26842j = new ArrayList();
    }
}
