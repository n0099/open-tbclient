package c.a.r0.n0.n;

import android.view.View;
import c.a.e.e.p.k;
import c.a.q0.s.q.q1;
import c.a.q0.s.q.r1;
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
    public TbPageContext<?> f22880a;

    /* renamed from: b  reason: collision with root package name */
    public RecommendForumLayout f22881b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f22882c;

    /* renamed from: d  reason: collision with root package name */
    public PullLeftRefreshLayout.f f22883d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.n.f f22884e;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f22885e;

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
            this.f22885e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.r0.n0.b.a(this.f22885e.f22880a, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements PullLeftRefreshLayout.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f22886a;

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
            this.f22886a = dVar;
        }

        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.n0.b.a(this.f22886a.f22880a, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements c.a.q0.n.f<q1> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f22887e;

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
            this.f22887e = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.n.f
        /* renamed from: b */
        public void c(View view, q1 q1Var, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, q1Var, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.n.f
        /* renamed from: d */
        public void a(View view, q1 q1Var, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, q1Var, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                if (q1Var == null) {
                    c.a.r0.n0.b.a(this.f22887e.f22880a, null);
                    return;
                }
                String p = q1Var.p();
                if (k.isForumName(p)) {
                    this.f22887e.f22880a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f22887e.f22880a.getPageActivity()).createNormalCfg(p, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
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
        this.f22882c = new a(this);
        this.f22883d = new b(this);
        this.f22884e = new c(this);
        this.f22880a = tbPageContext;
        RecommendForumLayout recommendForumLayout = new RecommendForumLayout(tbPageContext);
        this.f22881b = recommendForumLayout;
        recommendForumLayout.setShowMore(true);
        this.f22881b.setSquareEntranceAtStart(true);
        this.f22881b.setTabName(null);
        this.f22881b.setFrom(0);
        this.f22881b.setOnClickRightArrowListener(this.f22882c);
        this.f22881b.setOnRullOkCallbackr(this.f22883d);
        this.f22881b.setOnItemCoverListener(this.f22884e);
    }

    public void b(r1 r1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, r1Var) == null) {
            this.f22881b.bindData(r1Var);
        }
    }

    public RecommendForumLayout c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22881b : (RecommendForumLayout) invokeV.objValue;
    }
}
