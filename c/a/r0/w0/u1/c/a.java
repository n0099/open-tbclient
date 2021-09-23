package c.a.r0.w0.u1.c;

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
    public boolean f27870a;

    /* renamed from: b  reason: collision with root package name */
    public int f27871b;

    /* renamed from: c  reason: collision with root package name */
    public List<d2> f27872c;

    /* renamed from: d  reason: collision with root package name */
    public ScoreCardInfo f27873d;

    /* renamed from: e  reason: collision with root package name */
    public List<FeatureCardHot> f27874e;

    /* renamed from: f  reason: collision with root package name */
    public List<FeatureCardTopic> f27875f;

    /* renamed from: g  reason: collision with root package name */
    public List<b> f27876g;

    /* renamed from: h  reason: collision with root package name */
    public List<FeatureCardCompetition> f27877h;

    /* renamed from: i  reason: collision with root package name */
    public List<FeatureCardGod> f27878i;

    /* renamed from: j  reason: collision with root package name */
    public List<FeatureCardGame> f27879j;

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
        this.f27872c = new ArrayList();
        this.f27874e = new ArrayList();
        this.f27875f = new ArrayList();
        this.f27876g = new ArrayList();
        this.f27877h = new ArrayList();
        this.f27878i = new ArrayList();
        this.f27879j = new ArrayList();
    }
}
