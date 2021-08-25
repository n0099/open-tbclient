package c.a.q0.m0.n;

import android.view.View;
import c.a.e.e.p.k;
import c.a.p0.s.q.p1;
import c.a.p0.s.q.q1;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.RecommendForumLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f22312a;

    /* renamed from: b  reason: collision with root package name */
    public RecommendForumLayout f22313b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f22314c;

    /* renamed from: d  reason: collision with root package name */
    public PullLeftRefreshLayout.f f22315d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.n.f f22316e;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f22317e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22317e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.q0.m0.b.a(this.f22317e.f22312a, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements PullLeftRefreshLayout.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f22318a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22318a = dVar;
        }

        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.m0.b.a(this.f22318a.f22312a, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements c.a.p0.n.f<p1> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f22319e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22319e = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f
        /* renamed from: b */
        public void c(View view, p1 p1Var, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, p1Var, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f
        /* renamed from: d */
        public void a(View view, p1 p1Var, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, p1Var, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                if (p1Var == null) {
                    c.a.q0.m0.b.a(this.f22319e.f22312a, null);
                    return;
                }
                String p = p1Var.p();
                if (k.isForumName(p)) {
                    this.f22319e.f22312a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f22319e.f22312a.getPageActivity()).createNormalCfg(p, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                }
            }
        }
    }

    public d(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22314c = new a(this);
        this.f22315d = new b(this);
        this.f22316e = new c(this);
        this.f22312a = tbPageContext;
        RecommendForumLayout recommendForumLayout = new RecommendForumLayout(tbPageContext);
        this.f22313b = recommendForumLayout;
        recommendForumLayout.setShowMore(true);
        this.f22313b.setSquareEntranceAtStart(true);
        this.f22313b.setTabName(null);
        this.f22313b.setFrom(0);
        this.f22313b.setOnClickRightArrowListener(this.f22314c);
        this.f22313b.setOnRullOkCallbackr(this.f22315d);
        this.f22313b.setOnItemCoverListener(this.f22316e);
    }

    public void b(q1 q1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, q1Var) == null) {
            this.f22313b.bindData(q1Var);
        }
    }

    public RecommendForumLayout c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22313b : (RecommendForumLayout) invokeV.objValue;
    }
}
