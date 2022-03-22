package c.a.p0.f1.w1.c;

import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public int f14810b;

    /* renamed from: c  reason: collision with root package name */
    public List<ThreadData> f14811c;

    /* renamed from: d  reason: collision with root package name */
    public ScoreCardInfo f14812d;

    /* renamed from: e  reason: collision with root package name */
    public List<FeatureCardHot> f14813e;

    /* renamed from: f  reason: collision with root package name */
    public List<FeatureCardTopic> f14814f;

    /* renamed from: g  reason: collision with root package name */
    public List<b> f14815g;

    /* renamed from: h  reason: collision with root package name */
    public List<FeatureCardCompetition> f14816h;
    public List<FeatureCardGod> i;
    public List<FeatureCardGame> j;

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
        this.f14811c = new ArrayList();
        this.f14813e = new ArrayList();
        this.f14814f = new ArrayList();
        this.f14815g = new ArrayList();
        this.f14816h = new ArrayList();
        this.i = new ArrayList();
        this.j = new ArrayList();
    }
}
