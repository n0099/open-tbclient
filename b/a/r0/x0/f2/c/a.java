package b.a.r0.x0.f2.c;

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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f27296a;

    /* renamed from: b  reason: collision with root package name */
    public int f27297b;

    /* renamed from: c  reason: collision with root package name */
    public List<d2> f27298c;

    /* renamed from: d  reason: collision with root package name */
    public ScoreCardInfo f27299d;

    /* renamed from: e  reason: collision with root package name */
    public List<FeatureCardHot> f27300e;

    /* renamed from: f  reason: collision with root package name */
    public List<FeatureCardTopic> f27301f;

    /* renamed from: g  reason: collision with root package name */
    public List<b> f27302g;

    /* renamed from: h  reason: collision with root package name */
    public List<FeatureCardCompetition> f27303h;

    /* renamed from: i  reason: collision with root package name */
    public List<FeatureCardGod> f27304i;
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
        this.f27298c = new ArrayList();
        this.f27300e = new ArrayList();
        this.f27301f = new ArrayList();
        this.f27302g = new ArrayList();
        this.f27303h = new ArrayList();
        this.f27304i = new ArrayList();
        this.j = new ArrayList();
    }
}
