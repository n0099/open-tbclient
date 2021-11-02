package b.a.r0.x0.e2.c;

import b.a.q0.s.q.d2;
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

    /* renamed from: a  reason: collision with root package name */
    public boolean f25701a;

    /* renamed from: b  reason: collision with root package name */
    public int f25702b;

    /* renamed from: c  reason: collision with root package name */
    public List<d2> f25703c;

    /* renamed from: d  reason: collision with root package name */
    public ScoreCardInfo f25704d;

    /* renamed from: e  reason: collision with root package name */
    public List<FeatureCardHot> f25705e;

    /* renamed from: f  reason: collision with root package name */
    public List<FeatureCardTopic> f25706f;

    /* renamed from: g  reason: collision with root package name */
    public List<b> f25707g;

    /* renamed from: h  reason: collision with root package name */
    public List<FeatureCardCompetition> f25708h;

    /* renamed from: i  reason: collision with root package name */
    public List<FeatureCardGod> f25709i;
    public List<FeatureCardGame> j;

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
        this.f25703c = new ArrayList();
        this.f25705e = new ArrayList();
        this.f25706f = new ArrayList();
        this.f25707g = new ArrayList();
        this.f25708h = new ArrayList();
        this.f25709i = new ArrayList();
        this.j = new ArrayList();
    }
}
