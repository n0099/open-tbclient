package c.a.q0.v0.t1.c;

import c.a.p0.s.q.c2;
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
    public boolean f27172a;

    /* renamed from: b  reason: collision with root package name */
    public int f27173b;

    /* renamed from: c  reason: collision with root package name */
    public List<c2> f27174c;

    /* renamed from: d  reason: collision with root package name */
    public ScoreCardInfo f27175d;

    /* renamed from: e  reason: collision with root package name */
    public List<FeatureCardHot> f27176e;

    /* renamed from: f  reason: collision with root package name */
    public List<FeatureCardTopic> f27177f;

    /* renamed from: g  reason: collision with root package name */
    public List<b> f27178g;

    /* renamed from: h  reason: collision with root package name */
    public List<FeatureCardCompetition> f27179h;

    /* renamed from: i  reason: collision with root package name */
    public List<FeatureCardGod> f27180i;

    /* renamed from: j  reason: collision with root package name */
    public List<FeatureCardGame> f27181j;

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
        this.f27174c = new ArrayList();
        this.f27176e = new ArrayList();
        this.f27177f = new ArrayList();
        this.f27178g = new ArrayList();
        this.f27179h = new ArrayList();
        this.f27180i = new ArrayList();
        this.f27181j = new ArrayList();
    }
}
