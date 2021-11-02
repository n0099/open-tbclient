package b.a.r0.x0.p2;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.l.e.w;
import b.a.q0.s.q.c2;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.g0;
import b.a.r0.x0.b1;
import b.a.r0.x0.c1;
import b.a.r0.x0.e1;
import b.a.r0.x0.h1;
import b.a.r0.x0.s;
import b.a.r0.x0.t;
import b.a.r0.x0.z;
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
/* loaded from: classes5.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsNewAreaFragment f26123a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f26124b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f26125c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f26126d;

    /* renamed from: e  reason: collision with root package name */
    public PbListView f26127e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.x0.p2.f f26128f;

    /* renamed from: g  reason: collision with root package name */
    public BannerView f26129g;

    /* renamed from: h  reason: collision with root package name */
    public g0 f26130h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f26131i;
    public RelativeLayout j;
    public b.a.r0.x0.x1.f.a.a k;
    public boolean l;
    public BannerView.b m;
    public CustomMessageListener n;
    public CustomMessageListener o;

    /* loaded from: classes5.dex */
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
            PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(e1.abstract_voice);
            if (playVoiceBnt != null) {
                playVoiceBnt.reset();
            }
            FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(e1.abstract_img_layout);
            if (frsCommonImageLayout != null) {
                frsCommonImageLayout.reset();
            }
            if (view instanceof UserPhotoLayout) {
                ((UserPhotoLayout) view).reset();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f26132a;

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
            this.f26132a = gVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.f26132a.f26129g.isBannerViewShowing() && !this.f26132a.f26131i && this.f26132a.f26125c != null) {
                this.f26132a.f26131i = true;
                this.f26132a.f26125c.addHeaderView(this.f26132a.f26129g, 1);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements BannerView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f26133a;

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
            this.f26133a = gVar;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26133a.u();
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f26133a.h();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f26134e;

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
            this.f26134e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26134e.f26125c.removeHeaderView(this.f26134e.j);
                this.f26134e.f26125c.addHeaderView(this.f26134e.j, 0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f26135a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f26136e;

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
                this.f26136e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f26136e.f26135a.f26128f.l();
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
            this.f26135a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d2 d2Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                List<b.a.e.l.e.n> j = this.f26135a.f26128f.j();
                if (ListUtils.isEmpty(j)) {
                    return;
                }
                if (!ListUtils.isEmpty(j)) {
                    for (b.a.e.l.e.n nVar : j) {
                        if (nVar instanceof c2) {
                            c2 c2Var = (c2) nVar;
                            if (c2Var.x != 0 && (d2Var = c2Var.w) != null) {
                                int[] g0 = d2Var.g0();
                                c2Var.x = g0[0];
                                c2Var.y = g0[1];
                            }
                        }
                    }
                }
                b.a.e.e.m.e.a().postDelayed(new a(this), 500L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f26137a;

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
            this.f26137a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                this.f26137a.w(str);
                this.f26137a.v(str);
                this.f26137a.f26128f.p();
            }
        }
    }

    /* renamed from: b.a.r0.x0.p2.g$g  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class C1286g {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f26138a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(101244657, "Lb/a/r0/x0/p2/g$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(101244657, "Lb/a/r0/x0/p2/g$g;");
                    return;
                }
            }
            int[] iArr = new int[UtilHelper.NativePageType.values().length];
            f26138a = iArr;
            try {
                iArr[UtilHelper.NativePageType.FRS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26138a[UtilHelper.NativePageType.PB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-442352236, "Lb/a/r0/x0/p2/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-442352236, "Lb/a/r0/x0/p2/g;");
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
        this.f26123a = null;
        this.f26124b = null;
        this.f26125c = null;
        this.f26129g = null;
        this.f26131i = false;
        this.l = true;
        this.m = new c(this);
        this.n = new e(this, 2921414);
        this.o = new f(this, 2016331);
        this.f26123a = frsNewAreaFragment;
        o(view);
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || z) {
            return;
        }
        t tVar = new t();
        tVar.f26328a = 503;
        tVar.f26329b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f26126d.setVisibility(z ? 0 : 8);
        }
    }

    public void C(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f26125c.setSelection(i2);
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.l = z;
            if (z) {
                this.f26127e.C(TbadkCoreApplication.getInst().getContext().getResources().getString(h1.load_more));
                BdTypeRecyclerView bdTypeRecyclerView = this.f26125c;
                if (bdTypeRecyclerView.getChildAt(bdTypeRecyclerView.getChildCount() - 1) == this.f26127e.b()) {
                    this.f26127e.Q();
                    this.f26123a.loadMore();
                    return;
                }
                this.f26127e.f();
                return;
            }
            this.f26127e.C(this.f26123a.getResources().getString(h1.load_more_must_after_delete));
            this.f26127e.f();
        }
    }

    public void E(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wVar) == null) {
            this.f26128f.u(wVar);
        }
    }

    public void F(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onScrollListener) == null) {
            this.f26125c.setOnScrollListener(onScrollListener);
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            z zVar = new z();
            zVar.f26943a = 503;
            zVar.f26945c = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, zVar));
        }
    }

    public void H(ArrayList<b.a.e.l.e.n> arrayList, int i2, FrsViewData frsViewData, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{arrayList, Integer.valueOf(i2), frsViewData, Integer.valueOf(i3)}) == null) {
            ArrayList<b.a.e.l.e.n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            if (switchThreadDataToThreadCardInfo == null || switchThreadDataToThreadCardInfo.size() <= 0) {
                s sVar = new s();
                ArrayList<b.a.e.l.e.n> arrayList2 = new ArrayList<>();
                arrayList2.add(sVar);
                switchThreadDataToThreadCardInfo = arrayList2;
            }
            if (frsViewData != null && frsViewData.getEntelechyTabInfo() != null) {
                List<FrsTabInfo> i4 = i(frsViewData);
                if (ListUtils.isEmpty(i4)) {
                    RelativeLayout relativeLayout = this.j;
                    if (relativeLayout != null) {
                        this.f26125c.removeHeaderView(relativeLayout);
                    }
                } else if (this.j != null) {
                    this.f26125c.post(new d(this));
                }
                if (frsViewData != null && frsViewData.getIsBrandForum()) {
                    FrsTabInfo frsTabInfo = (FrsTabInfo) ListUtils.getItem(i4, 0);
                    if (frsViewData != null && this.f26123a.getModelController() != null && frsTabInfo != null) {
                        this.f26123a.getModelController().L(frsTabInfo.tab_id.intValue());
                    }
                } else if (this.k != null && frsViewData.getForum() != null) {
                    this.k.i(i4);
                    this.k.j(frsViewData.getForum().getId());
                    if (b.a.q0.b.d.q() && b.a.q0.b.g.a.f11959c != b.a.q0.b.g.a.d()) {
                        this.k.g(b.a.r0.x0.x2.k.d(b.a.q0.b.g.a.d()));
                    }
                }
            }
            this.f26128f.q(switchThreadDataToThreadCardInfo, frsViewData);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f26125c.setVisibility(0);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f26125c.setNextPage(this.f26127e);
            this.f26127e.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f26127e.Q();
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f26125c.setNextPage(this.f26127e);
            this.f26127e.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f26127e.f();
            this.f26127e.C(this.f26123a.getResources().getString(h1.list_has_no_more));
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            t tVar = new t();
            tVar.f26328a = 503;
            tVar.f26329b = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public final void h() {
        g0 g0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (g0Var = this.f26130h) == null) {
            return;
        }
        String d2 = g0Var.d();
        if (this.f26130h.a() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.f26123a.getPageContext().getPageActivity(), d2, false, BannerView.FRS_BANNER)));
        } else if (this.f26130h.a() == 2) {
            if (d2.contains(TbPatternsCompat.TB_DOMAIN_NAME)) {
                Matcher matcher = p.matcher(d2);
                if (matcher.find()) {
                    try {
                        String group = matcher.group(2);
                        PbActivityConfig createNormalCfg = new PbActivityConfig(this.f26123a.getPageContext().getPageActivity()).createNormalCfg(group, null, BannerView.FRS_BANNER);
                        createNormalCfg.setForumId(group);
                        createNormalCfg.setStartFrom(3);
                        this.f26123a.sendMessage(new CustomMessage(2004001, createNormalCfg));
                    } catch (Exception e2) {
                        BdLog.e(e2.toString());
                    }
                }
            }
        } else if (this.f26130h.a() == 3) {
            new UtilHelper.NativePage();
            UtilHelper.NativePage isNativeAddress = UtilHelper.isNativeAddress(d2);
            UtilHelper.NativePageType nativePageType = isNativeAddress.type;
            if (nativePageType != UtilHelper.NativePageType.NONE) {
                int i2 = C1286g.f26138a[nativePageType.ordinal()];
                if (i2 == 1) {
                    this.f26123a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f26123a.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, BannerView.FRS_BANNER)));
                    return;
                } else if (i2 != 2) {
                    return;
                } else {
                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.f26123a.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, BannerView.FRS_BANNER);
                    createNormalCfg2.setForumId(isNativeAddress.id);
                    createNormalCfg2.setStartFrom(3);
                    this.f26123a.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                    return;
                }
            }
            UrlManager.getInstance().dealOneLink(this.f26123a.getPageContext(), new String[]{d2});
            if (StringUtils.isNull(d2) || !d2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                return;
            }
            TiebaStatic.eventStat(this.f26123a.getPageContext().getPageActivity(), BannerView.FRS_BANNER, PrefetchEvent.STATE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
        } else if (this.f26130h.a() == 4) {
            this.f26123a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f26123a.getPageContext().getPageActivity()).createNormalCfg(d2, BannerView.FRS_BANNER)));
        }
    }

    public final List<FrsTabInfo> i(FrsViewData frsViewData) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, frsViewData)) == null) {
            Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().f20737a.iterator();
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
            for (FrsTabInfo frsTabInfo : frsViewData.getEntelechyTabInfo().f20738b) {
                if (frsTabInfo.tab_type.intValue() == i2) {
                    arrayList.add(frsTabInfo);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public b.a.r0.x0.p2.f j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f26128f : (b.a.r0.x0.p2.f) invokeV.objValue;
    }

    public BdTypeRecyclerView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f26125c : (BdTypeRecyclerView) invokeV.objValue;
    }

    public RelativeLayout l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f26124b : (RelativeLayout) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f26125c.setNextPage(null);
        }
    }

    public final void n(g0 g0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, g0Var) == null) && this.f26129g == null) {
            this.f26129g = new BannerView(this.f26123a.getPageContext().getPageActivity());
            this.f26129g.setLayoutParams(new AbsListView.LayoutParams(-1, this.f26123a.getResources().getDimensionPixelSize(c1.ds100)));
            this.f26129g.setVisibility(8);
            this.f26129g.setBannerViewClickListener(this.m);
            this.f26129g.setBannerData(g0Var);
            this.f26129g.setBannerViewEvent(new b(this));
        }
    }

    public final void o(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, view) == null) {
            this.f26124b = (RelativeLayout) view.findViewById(e1.frs_good_container);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(e1.frs_good_lv_thread);
            this.f26125c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
            this.f26125c.setFadingEdgeLength(0);
            this.f26125c.setOverScrollMode(2);
            this.f26125c.setRecyclerListener(new a(this));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(c1.M_W_X004);
            BdTypeRecyclerView bdTypeRecyclerView2 = this.f26125c;
            bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f26125c.getPaddingBottom());
            PbListView pbListView = new PbListView(this.f26123a.getPageContext().getPageActivity());
            this.f26127e = pbListView;
            pbListView.a();
            this.f26127e.p(b1.transparent);
            this.f26127e.s(b.a.e.e.p.l.g(this.f26123a.getActivity(), c1.tbds182));
            this.f26127e.x();
            this.f26127e.G(c1.tbfontsize33);
            this.f26127e.E(SkinManager.getColor(b1.CAM_X0107));
            this.f26127e.A(b1.CAM_X0110);
            this.f26125c.setOnSrollToBottomListener(this.f26123a);
            this.f26126d = (FrameLayout) view.findViewById(e1.frs_list_content);
            this.f26128f = new b.a.r0.x0.p2.f(this.f26123a, this.f26125c);
            A(false);
            this.j = new RelativeLayout(this.f26123a.getContext());
            this.j.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.k = new b.a.r0.x0.x1.f.a.a(this.f26123a, this.j);
            this.f26123a.registerListener(this.n);
            this.f26123a.registerListener(this.o);
        }
    }

    public void p() {
        b.a.r0.x0.p2.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (fVar = this.f26128f) == null) {
            return;
        }
        fVar.l();
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            b.a.r0.x0.p2.f fVar = this.f26128f;
            if (fVar != null) {
                fVar.w();
                this.f26128f.l();
                this.f26128f.n(i2);
            }
            this.f26123a.getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
            this.f26123a.getBaseFragmentActivity().getLayoutMode().j(this.f26124b);
            BannerView bannerView = this.f26129g;
            if (bannerView != null) {
                bannerView.onChangeSkin();
            }
            PbListView pbListView = this.f26127e;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(b1.CAM_X0107));
                this.f26127e.d(i2);
            }
            this.k.h();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f26128f.o();
            this.f26125c.setOnSrollToBottomListener(null);
        }
    }

    public void s(ForumData forumData, UserData userData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048599, this, forumData, userData) == null) || this.f26131i || forumData == null || forumData.getFrsBannerData() == null || !forumData.getFrsBannerData().e()) {
            return;
        }
        g0 frsBannerData = forumData.getFrsBannerData();
        this.f26130h = frsBannerData;
        n(frsBannerData);
        this.f26129g.reset();
        this.f26125c.removeHeaderView(this.f26129g);
        if (this.f26130h.getType() != 1 || TextUtils.isEmpty(this.f26130h.b())) {
            return;
        }
        this.f26129g.setData(this.f26123a.getPageContext(), this.f26130h.b());
        if (this.f26130h.d().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
            TiebaStatic.eventStat(this.f26123a.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.f26128f.l();
        }
    }

    public void u() {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (bannerView = this.f26129g) == null) {
            return;
        }
        this.f26131i = false;
        this.f26125c.removeHeaderView(bannerView);
    }

    public void v(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, str) == null) || this.f26123a.getLoadMoreModel() == null) {
            return;
        }
        this.f26123a.getLoadMoreModel().I(str);
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, str) == null) || StringUtils.isNull(str) || ListUtils.isEmpty(this.f26128f.j())) {
            return;
        }
        Iterator<b.a.e.l.e.n> it = this.f26128f.j().iterator();
        while (it.hasNext()) {
            b.a.e.l.e.n next = it.next();
            if (next instanceof b.a.r0.g.c) {
                b.a.r0.g.c cVar = (b.a.r0.g.c) next;
                if ((cVar.a() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) cVar.a()).X3)) {
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
            this.f26127e.C(this.f26123a.getResources().getString(h1.load_more_must_after_delete));
            this.f26127e.f();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            t tVar = new t();
            tVar.f26328a = 503;
            tVar.f26329b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.f26128f.m();
        }
    }
}
