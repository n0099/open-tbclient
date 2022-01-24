package c.a.t0.e1.r2;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.n.e.v;
import c.a.s0.s.q.d2;
import c.a.s0.s.q.e2;
import c.a.s0.s.q.g0;
import c.a.t0.e1.a0;
import c.a.t0.e1.c1;
import c.a.t0.e1.d1;
import c.a.t0.e1.f1;
import c.a.t0.e1.i1;
import c.a.t0.e1.s;
import c.a.t0.e1.t;
import c.a.t0.e1.z2.p;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern p;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f16827b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f16828c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f16829d;

    /* renamed from: e  reason: collision with root package name */
    public PbListView f16830e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.e1.r2.f f16831f;

    /* renamed from: g  reason: collision with root package name */
    public BannerView f16832g;

    /* renamed from: h  reason: collision with root package name */
    public g0 f16833h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f16834i;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f16835j;
    public c.a.t0.e1.z1.f.a.a k;
    public boolean l;
    public BannerView.b m;
    public CustomMessageListener n;
    public CustomMessageListener o;

    /* loaded from: classes7.dex */
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
            PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(f1.abstract_voice);
            if (playVoiceBnt != null) {
                playVoiceBnt.reset();
            }
            FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(f1.abstract_img_layout);
            if (frsCommonImageLayout != null) {
                frsCommonImageLayout.reset();
            }
            if (view instanceof UserPhotoLayout) {
                ((UserPhotoLayout) view).reset();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

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
            this.a = gVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.a.f16832g.isBannerViewShowing() && !this.a.f16834i && this.a.f16828c != null) {
                this.a.f16834i = true;
                this.a.f16828c.addHeaderView(this.a.f16832g, 1);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements BannerView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

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
            this.a = gVar;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.u();
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.h();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f16836e;

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
            this.f16836e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16836e.f16828c.removeHeaderView(this.f16836e.f16835j);
                this.f16836e.f16828c.addHeaderView(this.f16836e.f16835j, 0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f16837e;

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
                this.f16837e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f16837e.a.f16831f.l();
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
            this.a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e2 e2Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                List<c.a.d.n.e.n> j2 = this.a.f16831f.j();
                if (ListUtils.isEmpty(j2)) {
                    return;
                }
                if (!ListUtils.isEmpty(j2)) {
                    for (c.a.d.n.e.n nVar : j2) {
                        if (nVar instanceof d2) {
                            d2 d2Var = (d2) nVar;
                            if (d2Var.x != 0 && (e2Var = d2Var.w) != null) {
                                int[] i0 = e2Var.i0();
                                d2Var.x = i0[0];
                                d2Var.y = i0[1];
                            }
                        }
                    }
                }
                c.a.d.f.m.e.a().postDelayed(new a(this), 500L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

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
            this.a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                this.a.w(str);
                this.a.v(str);
                this.a.f16831f.p();
            }
        }
    }

    /* renamed from: c.a.t0.e1.r2.g$g  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class C1067g {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(274090538, "Lc/a/t0/e1/r2/g$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(274090538, "Lc/a/t0/e1/r2/g$g;");
                    return;
                }
            }
            int[] iArr = new int[UtilHelper.NativePageType.values().length];
            a = iArr;
            try {
                iArr[UtilHelper.NativePageType.FRS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[UtilHelper.NativePageType.PB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-393010419, "Lc/a/t0/e1/r2/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-393010419, "Lc/a/t0/e1/r2/g;");
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
        this.a = null;
        this.f16827b = null;
        this.f16828c = null;
        this.f16832g = null;
        this.f16834i = false;
        this.l = true;
        this.m = new c(this);
        this.n = new e(this, 2921414);
        this.o = new f(this, 2016331);
        this.a = frsNewAreaFragment;
        o(view);
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || z) {
            return;
        }
        t tVar = new t();
        tVar.a = 503;
        tVar.f16908b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f16829d.setVisibility(z ? 0 : 8);
        }
    }

    public void C(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f16828c.setSelection(i2);
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.l = z;
            if (z) {
                this.f16830e.D(TbadkCoreApplication.getInst().getContext().getResources().getString(i1.load_more));
                BdTypeRecyclerView bdTypeRecyclerView = this.f16828c;
                if (bdTypeRecyclerView.getChildAt(bdTypeRecyclerView.getChildCount() - 1) == this.f16830e.b()) {
                    this.f16830e.R();
                    this.a.loadMore();
                    return;
                }
                this.f16830e.f();
                return;
            }
            this.f16830e.D(this.a.getResources().getString(i1.load_more_must_after_delete));
            this.f16830e.f();
        }
    }

    public void E(v vVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, vVar) == null) {
            this.f16831f.u(vVar);
        }
    }

    public void F(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onScrollListener) == null) {
            this.f16828c.setOnScrollListener(onScrollListener);
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            a0 a0Var = new a0();
            a0Var.a = 503;
            a0Var.f15992c = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, a0Var));
        }
    }

    public void H(ArrayList<c.a.d.n.e.n> arrayList, int i2, FrsViewData frsViewData, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{arrayList, Integer.valueOf(i2), frsViewData, Integer.valueOf(i3)}) == null) {
            ArrayList<c.a.d.n.e.n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            if (switchThreadDataToThreadCardInfo == null || switchThreadDataToThreadCardInfo.size() <= 0) {
                s sVar = new s();
                ArrayList<c.a.d.n.e.n> arrayList2 = new ArrayList<>();
                arrayList2.add(sVar);
                switchThreadDataToThreadCardInfo = arrayList2;
            }
            if (frsViewData != null && frsViewData.getEntelechyTabInfo() != null) {
                List<FrsTabInfo> i4 = i(frsViewData);
                if (ListUtils.isEmpty(i4)) {
                    RelativeLayout relativeLayout = this.f16835j;
                    if (relativeLayout != null) {
                        this.f16828c.removeHeaderView(relativeLayout);
                    }
                } else if (this.f16835j != null) {
                    this.f16828c.post(new d(this));
                }
                if (frsViewData != null && frsViewData.getIsBrandForum()) {
                    FrsTabInfo frsTabInfo = (FrsTabInfo) ListUtils.getItem(i4, 0);
                    if (frsViewData != null && this.a.getModelController() != null && frsTabInfo != null) {
                        this.a.getModelController().L(frsTabInfo.tab_id.intValue());
                    }
                } else if (this.k != null && frsViewData.getForum() != null) {
                    this.k.i(i4);
                    this.k.j(frsViewData.getForum().getId());
                    if (c.a.s0.b.d.u() && c.a.s0.b.g.a.f12403c != c.a.s0.b.g.a.d()) {
                        this.k.g(p.d(c.a.s0.b.g.a.d()));
                    }
                }
            }
            this.f16831f.q(switchThreadDataToThreadCardInfo, frsViewData);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f16828c.setVisibility(0);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f16828c.setNextPage(this.f16830e);
            this.f16830e.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f16830e.R();
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f16828c.setNextPage(this.f16830e);
            this.f16830e.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f16830e.f();
            this.f16830e.D(this.a.getResources().getString(i1.list_has_no_more));
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            t tVar = new t();
            tVar.a = 503;
            tVar.f16908b = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public final void h() {
        g0 g0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (g0Var = this.f16833h) == null) {
            return;
        }
        String d2 = g0Var.d();
        if (this.f16833h.a() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.a.getPageContext().getPageActivity(), d2, false, BannerView.FRS_BANNER)));
        } else if (this.f16833h.a() == 2) {
            if (d2.contains(TbPatternsCompat.TB_DOMAIN_NAME)) {
                Matcher matcher = p.matcher(d2);
                if (matcher.find()) {
                    try {
                        String group = matcher.group(2);
                        PbActivityConfig createNormalCfg = new PbActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(group, null, BannerView.FRS_BANNER);
                        createNormalCfg.setForumId(group);
                        createNormalCfg.setStartFrom(3);
                        this.a.sendMessage(new CustomMessage(2004001, createNormalCfg));
                    } catch (Exception e2) {
                        BdLog.e(e2.toString());
                    }
                }
            }
        } else if (this.f16833h.a() == 3) {
            new UtilHelper.NativePage();
            UtilHelper.NativePage isNativeAddress = UtilHelper.isNativeAddress(d2);
            UtilHelper.NativePageType nativePageType = isNativeAddress.type;
            if (nativePageType != UtilHelper.NativePageType.NONE) {
                int i2 = C1067g.a[nativePageType.ordinal()];
                if (i2 == 1) {
                    this.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, BannerView.FRS_BANNER)));
                    return;
                } else if (i2 != 2) {
                    return;
                } else {
                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, BannerView.FRS_BANNER);
                    createNormalCfg2.setForumId(isNativeAddress.id);
                    createNormalCfg2.setStartFrom(3);
                    this.a.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                    return;
                }
            }
            UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{d2});
            if (StringUtils.isNull(d2) || !d2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                return;
            }
            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), BannerView.FRS_BANNER, "click", 1, "ref_id", "4000601", "ref_type", "603");
        } else if (this.f16833h.a() == 4) {
            this.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(d2, BannerView.FRS_BANNER)));
        }
    }

    public final List<FrsTabInfo> i(FrsViewData frsViewData) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, frsViewData)) == null) {
            Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().a.iterator();
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
            for (FrsTabInfo frsTabInfo : frsViewData.getEntelechyTabInfo().f25203b) {
                if (frsTabInfo.tab_type.intValue() == i2) {
                    arrayList.add(frsTabInfo);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public c.a.t0.e1.r2.f j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f16831f : (c.a.t0.e1.r2.f) invokeV.objValue;
    }

    public BdTypeRecyclerView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f16828c : (BdTypeRecyclerView) invokeV.objValue;
    }

    public RelativeLayout l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f16827b : (RelativeLayout) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f16828c.setNextPage(null);
        }
    }

    public final void n(g0 g0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, g0Var) == null) && this.f16832g == null) {
            this.f16832g = new BannerView(this.a.getPageContext().getPageActivity());
            this.f16832g.setLayoutParams(new AbsListView.LayoutParams(-1, this.a.getResources().getDimensionPixelSize(d1.ds100)));
            this.f16832g.setVisibility(8);
            this.f16832g.setBannerViewClickListener(this.m);
            this.f16832g.setBannerData(g0Var);
            this.f16832g.setBannerViewEvent(new b(this));
        }
    }

    public final void o(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, view) == null) {
            this.f16827b = (RelativeLayout) view.findViewById(f1.frs_good_container);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(f1.frs_good_lv_thread);
            this.f16828c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
            this.f16828c.setFadingEdgeLength(0);
            this.f16828c.setOverScrollMode(2);
            this.f16828c.setRecyclerListener(new a(this));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(d1.M_W_X004);
            BdTypeRecyclerView bdTypeRecyclerView2 = this.f16828c;
            bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f16828c.getPaddingBottom());
            PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
            this.f16830e = pbListView;
            pbListView.a();
            this.f16830e.p(c1.transparent);
            this.f16830e.t(c.a.d.f.p.n.f(this.a.getActivity(), d1.tbds182));
            this.f16830e.y();
            this.f16830e.H(d1.tbfontsize33);
            this.f16830e.F(SkinManager.getColor(c1.CAM_X0107));
            this.f16830e.B(c1.CAM_X0110);
            this.f16828c.setOnSrollToBottomListener(this.a);
            this.f16829d = (FrameLayout) view.findViewById(f1.frs_list_content);
            this.f16831f = new c.a.t0.e1.r2.f(this.a, this.f16828c);
            A(false);
            this.f16835j = new RelativeLayout(this.a.getContext());
            this.f16835j.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.k = new c.a.t0.e1.z1.f.a.a(this.a, this.f16835j);
            this.a.registerListener(this.n);
            this.a.registerListener(this.o);
        }
    }

    public void p() {
        c.a.t0.e1.r2.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (fVar = this.f16831f) == null) {
            return;
        }
        fVar.l();
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            c.a.t0.e1.r2.f fVar = this.f16831f;
            if (fVar != null) {
                fVar.w();
                this.f16831f.l();
                this.f16831f.n(i2);
            }
            this.a.getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
            this.a.getBaseFragmentActivity().getLayoutMode().j(this.f16827b);
            BannerView bannerView = this.f16832g;
            if (bannerView != null) {
                bannerView.onChangeSkin();
            }
            PbListView pbListView = this.f16830e;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(c1.CAM_X0107));
                this.f16830e.d(i2);
            }
            this.k.h();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f16831f.o();
            this.f16828c.setOnSrollToBottomListener(null);
        }
    }

    public void s(ForumData forumData, UserData userData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048599, this, forumData, userData) == null) || this.f16834i || forumData == null || forumData.getFrsBannerData() == null || !forumData.getFrsBannerData().e()) {
            return;
        }
        g0 frsBannerData = forumData.getFrsBannerData();
        this.f16833h = frsBannerData;
        n(frsBannerData);
        this.f16832g.reset();
        this.f16828c.removeHeaderView(this.f16832g);
        if (this.f16833h.getType() != 1 || TextUtils.isEmpty(this.f16833h.b())) {
            return;
        }
        this.f16832g.setData(this.a.getPageContext(), this.f16833h.b());
        if (this.f16833h.d().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.f16831f.l();
        }
    }

    public void u() {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (bannerView = this.f16832g) == null) {
            return;
        }
        this.f16834i = false;
        this.f16828c.removeHeaderView(bannerView);
    }

    public void v(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, str) == null) || this.a.getLoadMoreModel() == null) {
            return;
        }
        this.a.getLoadMoreModel().J(str);
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, str) == null) || StringUtils.isNull(str) || ListUtils.isEmpty(this.f16831f.j())) {
            return;
        }
        Iterator<c.a.d.n.e.n> it = this.f16831f.j().iterator();
        while (it.hasNext()) {
            c.a.d.n.e.n next = it.next();
            if (next instanceof c.a.t0.h.c) {
                c.a.t0.h.c cVar = (c.a.t0.h.c) next;
                if ((cVar.a() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) cVar.a()).g4)) {
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
            this.f16830e.D(this.a.getResources().getString(i1.load_more_must_after_delete));
            this.f16830e.f();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            t tVar = new t();
            tVar.a = 503;
            tVar.f16908b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.f16831f.m();
        }
    }
}
