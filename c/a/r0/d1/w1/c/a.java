package c.a.r0.d1.w1.c;

import c.a.q0.r.r.e2;
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
    public int f16654b;

    /* renamed from: c  reason: collision with root package name */
    public List<e2> f16655c;

    /* renamed from: d  reason: collision with root package name */
    public ScoreCardInfo f16656d;

    /* renamed from: e  reason: collision with root package name */
    public List<FeatureCardHot> f16657e;

    /* renamed from: f  reason: collision with root package name */
    public List<FeatureCardTopic> f16658f;

    /* renamed from: g  reason: collision with root package name */
    public List<b> f16659g;

    /* renamed from: h  reason: collision with root package name */
    public List<FeatureCardCompetition> f16660h;

    /* renamed from: i  reason: collision with root package name */
    public List<FeatureCardGod> f16661i;

    /* renamed from: j  reason: collision with root package name */
    public List<FeatureCardGame> f16662j;

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
        this.f16655c = new ArrayList();
        this.f16657e = new ArrayList();
        this.f16658f = new ArrayList();
        this.f16659g = new ArrayList();
        this.f16660h = new ArrayList();
        this.f16661i = new ArrayList();
        this.f16662j = new ArrayList();
    }
}
