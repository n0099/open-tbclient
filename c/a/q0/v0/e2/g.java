package c.a.q0.v0.e2;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.l.e.w;
import c.a.p0.s.q.b2;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.g0;
import c.a.q0.v0.s;
import c.a.q0.v0.t;
import c.a.q0.v0.z;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsNewAreaFragment f25988a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f25989b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f25990c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f25991d;

    /* renamed from: e  reason: collision with root package name */
    public PbListView f25992e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.v0.e2.f f25993f;

    /* renamed from: g  reason: collision with root package name */
    public BannerView f25994g;

    /* renamed from: h  reason: collision with root package name */
    public g0 f25995h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f25996i;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f25997j;
    public c.a.q0.v0.m1.f.a.a k;
    public boolean l;
    public BannerView.b m;
    public CustomMessageListener n;
    public CustomMessageListener o;

    /* loaded from: classes4.dex */
    public class a implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || (view = viewHolder.itemView) == null) {
                return;
            }
            PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(R.id.abstract_voice);
            if (playVoiceBnt != null) {
                playVoiceBnt.reset();
            }
            FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(R.id.abstract_img_layout);
            if (frsCommonImageLayout != null) {
                frsCommonImageLayout.reset();
            }
            if (view instanceof UserPhotoLayout) {
                ((UserPhotoLayout) view).reset();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f25998a;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25998a = gVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.f25998a.f25994g.isBannerViewShowing() && !this.f25998a.f25996i && this.f25998a.f25990c != null) {
                this.f25998a.f25996i = true;
                this.f25998a.f25990c.addHeaderView(this.f25998a.f25994g, 1);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements BannerView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f25999a;

        public c(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25999a = gVar;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f25999a.u();
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f25999a.h();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f26000e;

        public d(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26000e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26000e.f25990c.removeHeaderView(this.f26000e.f25997j);
                this.f26000e.f25990c.addHeaderView(this.f26000e.f25997j, 0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f26001a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f26002e;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f26002e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f26002e.f26001a.f25993f.l();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(g gVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26001a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c2 c2Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                List<c.a.e.l.e.n> j2 = this.f26001a.f25993f.j();
                if (ListUtils.isEmpty(j2)) {
                    return;
                }
                if (!ListUtils.isEmpty(j2)) {
                    for (c.a.e.l.e.n nVar : j2) {
                        if (nVar instanceof b2) {
                            b2 b2Var = (b2) nVar;
                            if (b2Var.x != 0 && (c2Var = b2Var.w) != null) {
                                int[] g0 = c2Var.g0();
                                b2Var.x = g0[0];
                                b2Var.y = g0[1];
                            }
                        }
                    }
                }
                c.a.e.e.m.e.a().postDelayed(new a(this), 500L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f26003a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(g gVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26003a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                this.f26003a.w(str);
                this.f26003a.v(str);
                this.f26003a.f25993f.p();
            }
        }
    }

    /* renamed from: c.a.q0.v0.e2.g$g  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class C1216g {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f26004a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(968378472, "Lc/a/q0/v0/e2/g$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(968378472, "Lc/a/q0/v0/e2/g$g;");
                    return;
                }
            }
            int[] iArr = new int[UtilHelper.NativePageType.values().length];
            f26004a = iArr;
            try {
                iArr[UtilHelper.NativePageType.FRS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26004a[UtilHelper.NativePageType.PB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-633628469, "Lc/a/q0/v0/e2/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-633628469, "Lc/a/q0/v0/e2/g;");
                return;
            }
        }
        p = Pattern.compile("(/p/){1}(\\d+)");
    }

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsNewAreaFragment, view};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f25988a = null;
        this.f25989b = null;
        this.f25990c = null;
        this.f25994g = null;
        this.f25996i = false;
        this.l = true;
        this.m = new c(this);
        this.n = new e(this, 2921414);
        this.o = new f(this, 2016331);
        this.f25988a = frsNewAreaFragment;
        o(view);
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || z) {
            return;
        }
        t tVar = new t();
        tVar.f27158a = 503;
        tVar.f27159b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f25991d.setVisibility(z ? 0 : 8);
        }
    }

    public void C(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f25990c.setSelection(i2);
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.l = z;
            if (z) {
                this.f25992e.A(TbadkCoreApplication.getInst().getContext().getResources().getString(R.string.load_more));
                BdTypeRecyclerView bdTypeRecyclerView = this.f25990c;
                if (bdTypeRecyclerView.getChildAt(bdTypeRecyclerView.getChildCount() - 1) == this.f25992e.b()) {
                    this.f25992e.O();
                    this.f25988a.loadMore();
                    return;
                }
                this.f25992e.f();
                return;
            }
            this.f25992e.A(this.f25988a.getResources().getString(R.string.load_more_must_after_delete));
            this.f25992e.f();
        }
    }

    public void E(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wVar) == null) {
            this.f25993f.u(wVar);
        }
    }

    public void F(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onScrollListener) == null) {
            this.f25990c.setOnScrollListener(onScrollListener);
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            z zVar = new z();
            zVar.f27379a = 503;
            zVar.f27381c = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, zVar));
        }
    }

    public void H(ArrayList<c.a.e.l.e.n> arrayList, int i2, FrsViewData frsViewData, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{arrayList, Integer.valueOf(i2), frsViewData, Integer.valueOf(i3)}) == null) {
            ArrayList<c.a.e.l.e.n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            if (switchThreadDataToThreadCardInfo == null || switchThreadDataToThreadCardInfo.size() <= 0) {
                s sVar = new s();
                ArrayList<c.a.e.l.e.n> arrayList2 = new ArrayList<>();
                arrayList2.add(sVar);
                switchThreadDataToThreadCardInfo = arrayList2;
            }
            if (frsViewData != null && frsViewData.getEntelechyTabInfo() != null) {
                List<FrsTabInfo> i4 = i(frsViewData);
                if (ListUtils.isEmpty(i4)) {
                    RelativeLayout relativeLayout = this.f25997j;
                    if (relativeLayout != null) {
                        this.f25990c.removeHeaderView(relativeLayout);
                    }
                } else if (this.f25997j != null) {
                    this.f25990c.post(new d(this));
                }
                if (frsViewData != null && frsViewData.getIsBrandForum()) {
                    FrsTabInfo frsTabInfo = (FrsTabInfo) ListUtils.getItem(i4, 0);
                    if (frsViewData != null && this.f25988a.getModelController() != null && frsTabInfo != null) {
                        this.f25988a.getModelController().M(frsTabInfo.tab_id.intValue());
                    }
                } else if (this.k != null && frsViewData.getForum() != null) {
                    this.k.i(i4);
                    this.k.j(frsViewData.getForum().getId());
                    if (c.a.p0.b.d.z() && c.a.p0.b.g.a.f12793c != c.a.p0.b.g.a.d()) {
                        this.k.g(c.a.q0.v0.m2.k.d(c.a.p0.b.g.a.d()));
                    }
                }
            }
            this.f25993f.q(switchThreadDataToThreadCardInfo, frsViewData);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f25990c.setVisibility(0);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f25990c.setNextPage(this.f25992e);
            this.f25992e.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f25992e.O();
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f25990c.setNextPage(this.f25992e);
            this.f25992e.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f25992e.f();
            this.f25992e.A(this.f25988a.getResources().getString(R.string.list_has_no_more));
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            t tVar = new t();
            tVar.f27158a = 503;
            tVar.f27159b = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public final void h() {
        g0 g0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (g0Var = this.f25995h) == null) {
            return;
        }
        String e2 = g0Var.e();
        if (this.f25995h.a() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.f25988a.getPageContext().getPageActivity(), e2, false, BannerView.FRS_BANNER)));
        } else if (this.f25995h.a() == 2) {
            if (e2.contains(TbPatternsCompat.TB_DOMAIN_NAME)) {
                Matcher matcher = p.matcher(e2);
                if (matcher.find()) {
                    try {
                        String group = matcher.group(2);
                        PbActivityConfig createNormalCfg = new PbActivityConfig(this.f25988a.getPageContext().getPageActivity()).createNormalCfg(group, null, BannerView.FRS_BANNER);
                        createNormalCfg.setForumId(group);
                        createNormalCfg.setStartFrom(3);
                        this.f25988a.sendMessage(new CustomMessage(2004001, createNormalCfg));
                    } catch (Exception e3) {
                        BdLog.e(e3.toString());
                    }
                }
            }
        } else if (this.f25995h.a() == 3) {
            new UtilHelper.NativePage();
            UtilHelper.NativePage isNativeAddress = UtilHelper.isNativeAddress(e2);
            UtilHelper.NativePageType nativePageType = isNativeAddress.type;
            if (nativePageType != UtilHelper.NativePageType.NONE) {
                int i2 = C1216g.f26004a[nativePageType.ordinal()];
                if (i2 == 1) {
                    this.f25988a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f25988a.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, BannerView.FRS_BANNER)));
                    return;
                } else if (i2 != 2) {
                    return;
                } else {
                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.f25988a.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, BannerView.FRS_BANNER);
                    createNormalCfg2.setForumId(isNativeAddress.id);
                    createNormalCfg2.setStartFrom(3);
                    this.f25988a.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                    return;
                }
            }
            UrlManager.getInstance().dealOneLink(this.f25988a.getPageContext(), new String[]{e2});
            if (StringUtils.isNull(e2) || !e2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                return;
            }
            TiebaStatic.eventStat(this.f25988a.getPageContext().getPageActivity(), BannerView.FRS_BANNER, PrefetchEvent.STATE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
        } else if (this.f25995h.a() == 4) {
            this.f25988a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f25988a.getPageContext().getPageActivity()).createNormalCfg(e2, BannerView.FRS_BANNER)));
        }
    }

    public final List<FrsTabInfo> i(FrsViewData frsViewData) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, frsViewData)) == null) {
            Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().tab.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                }
                FrsTabInfo next = it.next();
                if (next.tab_id.intValue() == 503) {
                    i2 = next.tab_type.intValue();
                    break;
                }
            }
            if (i2 == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : frsViewData.getEntelechyTabInfo().menu) {
                if (frsTabInfo.tab_type.intValue() == i2) {
                    arrayList.add(frsTabInfo);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public c.a.q0.v0.e2.f j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f25993f : (c.a.q0.v0.e2.f) invokeV.objValue;
    }

    public BdTypeRecyclerView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f25990c : (BdTypeRecyclerView) invokeV.objValue;
    }

    public RelativeLayout l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f25989b : (RelativeLayout) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f25990c.setNextPage(null);
        }
    }

    public final void n(g0 g0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, g0Var) == null) && this.f25994g == null) {
            this.f25994g = new BannerView(this.f25988a.getPageContext().getPageActivity());
            this.f25994g.setLayoutParams(new AbsListView.LayoutParams(-1, this.f25988a.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.f25994g.setVisibility(8);
            this.f25994g.setBannerViewClickListener(this.m);
            this.f25994g.setBannerData(g0Var);
            this.f25994g.setBannerViewEvent(new b(this));
        }
    }

    public final void o(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, view) == null) {
            this.f25989b = (RelativeLayout) view.findViewById(R.id.frs_good_container);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
            this.f25990c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
            this.f25990c.setFadingEdgeLength(0);
            this.f25990c.setOverScrollMode(2);
            this.f25990c.setRecyclerListener(new a(this));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            BdTypeRecyclerView bdTypeRecyclerView2 = this.f25990c;
            bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f25990c.getPaddingBottom());
            PbListView pbListView = new PbListView(this.f25988a.getPageContext().getPageActivity());
            this.f25992e = pbListView;
            pbListView.a();
            this.f25992e.o(R.color.transparent);
            this.f25992e.r(c.a.e.e.p.l.g(this.f25988a.getActivity(), R.dimen.tbds182));
            this.f25992e.v();
            this.f25992e.E(R.dimen.tbfontsize33);
            this.f25992e.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f25992e.y(R.color.CAM_X0110);
            this.f25990c.setOnSrollToBottomListener(this.f25988a);
            this.f25991d = (FrameLayout) view.findViewById(R.id.frs_list_content);
            this.f25993f = new c.a.q0.v0.e2.f(this.f25988a, this.f25990c);
            A(false);
            this.f25997j = new RelativeLayout(this.f25988a.getContext());
            this.f25997j.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.k = new c.a.q0.v0.m1.f.a.a(this.f25988a, this.f25997j);
            this.f25988a.registerListener(this.n);
            this.f25988a.registerListener(this.o);
        }
    }

    public void p() {
        c.a.q0.v0.e2.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (fVar = this.f25993f) == null) {
            return;
        }
        fVar.l();
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            c.a.q0.v0.e2.f fVar = this.f25993f;
            if (fVar != null) {
                fVar.w();
                this.f25993f.l();
                this.f25993f.n(i2);
            }
            this.f25988a.getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
            this.f25988a.getBaseFragmentActivity().getLayoutMode().j(this.f25989b);
            BannerView bannerView = this.f25994g;
            if (bannerView != null) {
                bannerView.onChangeSkin();
            }
            PbListView pbListView = this.f25992e;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
                this.f25992e.d(i2);
            }
            this.k.h();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f25993f.o();
            this.f25990c.setOnSrollToBottomListener(null);
        }
    }

    public void s(ForumData forumData, UserData userData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048599, this, forumData, userData) == null) || this.f25996i || forumData == null || forumData.getFrsBannerData() == null || !forumData.getFrsBannerData().f()) {
            return;
        }
        g0 frsBannerData = forumData.getFrsBannerData();
        this.f25995h = frsBannerData;
        n(frsBannerData);
        this.f25994g.reset();
        this.f25990c.removeHeaderView(this.f25994g);
        if (this.f25995h.d() != 1 || TextUtils.isEmpty(this.f25995h.b())) {
            return;
        }
        this.f25994g.setData(this.f25988a.getPageContext(), this.f25995h.b());
        if (this.f25995h.e().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
            TiebaStatic.eventStat(this.f25988a.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.f25993f.l();
        }
    }

    public void u() {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (bannerView = this.f25994g) == null) {
            return;
        }
        this.f25996i = false;
        this.f25990c.removeHeaderView(bannerView);
    }

    public void v(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, str) == null) || this.f25988a.getLoadMoreModel() == null) {
            return;
        }
        this.f25988a.getLoadMoreModel().I(str);
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, str) == null) || StringUtils.isNull(str) || ListUtils.isEmpty(this.f25993f.j())) {
            return;
        }
        Iterator<c.a.e.l.e.n> it = this.f25993f.j().iterator();
        while (it.hasNext()) {
            c.a.e.l.e.n next = it.next();
            if (next instanceof c.a.q0.f.c) {
                c.a.q0.f.c cVar = (c.a.q0.f.c) next;
                if ((cVar.b() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) cVar.b()).T3)) {
                    it.remove();
                }
            }
        }
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (this.l) {
                return false;
            }
            this.f25992e.A(this.f25988a.getResources().getString(R.string.load_more_must_after_delete));
            this.f25992e.f();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            t tVar = new t();
            tVar.f27158a = 503;
            tVar.f27159b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.f25993f.m();
        }
    }
}
