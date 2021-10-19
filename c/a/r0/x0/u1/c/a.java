package c.a.r0.x0.u1.c;

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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f28046a;

    /* renamed from: b  reason: collision with root package name */
    public int f28047b;

    /* renamed from: c  reason: collision with root package name */
    public List<d2> f28048c;

    /* renamed from: d  reason: collision with root package name */
    public ScoreCardInfo f28049d;

    /* renamed from: e  reason: collision with root package name */
    public List<FeatureCardHot> f28050e;

    /* renamed from: f  reason: collision with root package name */
    public List<FeatureCardTopic> f28051f;

    /* renamed from: g  reason: collision with root package name */
    public List<b> f28052g;

    /* renamed from: h  reason: collision with root package name */
    public List<FeatureCardCompetition> f28053h;

    /* renamed from: i  reason: collision with root package name */
    public List<FeatureCardGod> f28054i;

    /* renamed from: j  reason: collision with root package name */
    public List<FeatureCardGame> f28055j;

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
        this.f28048c = new ArrayList();
        this.f28050e = new ArrayList();
        this.f28051f = new ArrayList();
        this.f28052g = new ArrayList();
        this.f28053h = new ArrayList();
        this.f28054i = new ArrayList();
        this.f28055j = new ArrayList();
    }
}
