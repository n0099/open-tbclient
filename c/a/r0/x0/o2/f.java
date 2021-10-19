package c.a.r0.x0.o2;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.s.a;
import c.a.r0.k3.g0;
import c.a.r0.k3.x;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f27607a;

    /* renamed from: b  reason: collision with root package name */
    public TBSpecificationBtn f27608b;

    /* renamed from: c  reason: collision with root package name */
    public LikeModel f27609c;

    /* renamed from: d  reason: collision with root package name */
    public g0 f27610d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f27611e;

    /* renamed from: f  reason: collision with root package name */
    public AntiHelper.k f27612f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f27613g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.e.a.e f27614h;

    /* renamed from: i  reason: collision with root package name */
    public g0.a f27615i;

    /* loaded from: classes4.dex */
    public class a implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f27616a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(f fVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2)};
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
            this.f27616a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof x)) {
                this.f27616a.f(customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f27617a;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27617a = fVar;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.f27617a.f(obj);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements g0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f27618a;

        public d(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27618a = fVar;
        }

        @Override // c.a.r0.k3.g0.a
        public void a(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j2) == null) {
            }
        }

        @Override // c.a.r0.k3.g0.a
        public void b(String str, long j2) {
            FrsViewData frsViewData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j2) == null) || this.f27618a.f27607a == null || (frsViewData = this.f27618a.f27607a.getFrsViewData()) == null || frsViewData.getForum() == null) {
                return;
            }
            String name = frsViewData.getForum().getName();
            String id = frsViewData.getForum().getId();
            if (j2 == c.a.e.e.m.b.g(id, 0L) && TextUtils.equals(name, str)) {
                h headerVC = this.f27618a.f27607a.getHeaderVC();
                if (headerVC != null) {
                    headerVC.Y(str);
                }
                frsViewData.getForum().setLike(0);
                if (headerVC != null) {
                    headerVC.T(0);
                }
                this.f27618a.f27607a.unlikeCallBack(Boolean.TRUE);
                this.f27618a.l(false, id);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, id));
                x xVar = new x();
                xVar.v(0);
                xVar.s(id);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, xVar));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f27619e;

        public e(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27619e = fVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                if (this.f27619e.f27607a == null || this.f27619e.f27610d == null) {
                    return;
                }
                FrsViewData frsViewData = this.f27619e.f27607a.getFrsViewData();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (frsViewData == null || frsViewData.getForum() == null) {
                        return;
                    }
                    this.f27619e.f27610d.c(frsViewData.getForum().getName(), c.a.e.e.m.b.g(frsViewData.getForum().getId(), 0L));
                    return;
                }
                TbadkCoreApplication.getInst().login(this.f27619e.f27607a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f27619e.f27607a.getActivity(), true, 11036)));
            }
        }
    }

    /* renamed from: c.a.r0.x0.o2.f$f  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1298f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1298f(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    public f(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27609c = null;
        this.f27610d = null;
        this.f27612f = new a(this);
        this.f27613g = new b(this, 2921600);
        this.f27614h = new c(this);
        this.f27615i = new d(this);
        this.f27607a = frsFragment;
        if (frsFragment != null) {
            frsFragment.registerListener(this.f27613g);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13605");
            FrsFragment frsFragment = this.f27607a;
            if (frsFragment != null) {
                c.a.q0.n0.c.b(frsFragment.getContext(), statisticItem);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void f(Object obj) {
        FrsFragment frsFragment;
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) || (frsFragment = this.f27607a) == null || (frsViewData = frsFragment.getFrsViewData()) == null || frsViewData.getForum() == null || obj == null) {
            return;
        }
        if (AntiHelper.m(this.f27609c.getErrorCode(), this.f27609c.getErrorString())) {
            if (AntiHelper.t(this.f27607a.getActivity(), this.f27609c.J(), this.f27612f) != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                return;
            }
            return;
        }
        String name = frsViewData.getForum().getName();
        String id = frsViewData.getForum().getId();
        x xVar = obj instanceof x ? (x) obj : null;
        boolean z = xVar != null && this.f27609c.getErrorCode() == 0;
        if (xVar.d() == 3250013) {
            BdToast.h(TbadkCoreApplication.getInst().getContext(), xVar.e(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
            z = false;
        }
        if (xVar != null && z) {
            h headerVC = this.f27607a.getHeaderVC();
            if (headerVC != null) {
                headerVC.Y(name);
            }
            xVar.v(1);
            frsViewData.updateLikeData(xVar);
            frsViewData.setLikeFeedForumDataList(xVar.f());
            if (headerVC != null) {
                headerVC.f0(frsViewData, this.f27611e);
            }
            this.f27611e = true;
            FrsFragment frsFragment2 = this.f27607a;
            frsFragment2.showToast(frsFragment2.getResources().getString(R.string.attention_success));
            if (c.a.q0.t.h.a.e(this.f27607a.getContext(), 0)) {
                c.a.q0.t.h.a.g(this.f27607a.getPageContext(), 4, 2000L);
            }
            l(true, id);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, xVar));
            e();
        } else if (this.f27609c.getErrorCode() == 22) {
            FrsFragment frsFragment3 = this.f27607a;
            frsFragment3.showToast(frsFragment3.getString(R.string.had_liked_forum));
        } else {
            this.f27607a.showToast(this.f27609c.getErrorString());
        }
        this.f27607a.likeCallBack(Boolean.valueOf(z));
    }

    public void g(TBSpecificationBtn tBSpecificationBtn) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tBSpecificationBtn) == null) {
            this.f27608b = tBSpecificationBtn;
            m();
        }
    }

    public final void h() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (frsFragment = this.f27607a) == null) {
            return;
        }
        LikeModel likeModel = new LikeModel(frsFragment.getPageContext());
        this.f27609c = likeModel;
        likeModel.setLoadDataCallBack(this.f27614h);
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            g0 g0Var = new g0();
            this.f27610d = g0Var;
            g0Var.a("from_frs");
            this.f27610d.b(this.f27615i);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            h();
            i();
        }
    }

    public void k() {
        LikeModel likeModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (likeModel = this.f27609c) == null) {
            return;
        }
        likeModel.I();
    }

    public final void l(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048583, this, z, str) == null) {
            c.a.r0.l1.t.d.j().g(TbadkCoreApplication.getCurrentAccount(), str, z, null);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    public void m() {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (tBSpecificationBtn = this.f27608b) == null) {
            return;
        }
        tBSpecificationBtn.changeSkinType();
    }

    public void n(String str, String str2) {
        LikeModel likeModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) || (likeModel = this.f27609c) == null) {
            return;
        }
        likeModel.M(str, str2, "FRS");
    }

    public void o(boolean z) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (frsFragment = this.f27607a) == null || this.f27609c == null) {
            return;
        }
        FrsViewData frsViewData = frsFragment.getFrsViewData();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (frsViewData == null || frsViewData.getForum() == null) {
                return;
            }
            if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.f27607a.getFrom())) {
                TiebaStatic.log(new StatisticItem("c10356").param("fid", frsViewData.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.f27607a.getFrom())) {
                TiebaStatic.log(new StatisticItem("c10590").param("obj_type", 2).param("fid", frsViewData.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.f27607a.getFrom())) {
                TiebaStatic.log(new StatisticItem("c10587").param("obj_type", 2).param("fid", frsViewData.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.f27607a.getFrom())) {
                TiebaStatic.log(new StatisticItem("c10578").param("obj_type", 2).param("fid", frsViewData.getForum().getId()));
            }
            this.f27609c.setFrom("recom_flist_like_frs");
            if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.f27607a.getFrom())) {
                TiebaStatic.eventStat(this.f27607a.getPageContext().getPageActivity(), "square_frs_focus", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.f27607a.getFrom())) {
                TiebaStatic.log(new StatisticItem("c10359").param("fid", frsViewData.getForum().getId()));
            }
            this.f27609c.M(frsViewData.getForum().getName(), frsViewData.getForum().getId(), "FRS");
            this.f27611e = z;
            return;
        }
        TbadkCoreApplication.getInst().login(this.f27607a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f27607a.getActivity(), true, CyberPlayerManager.MEDIA_INFO_KERNEL_NET_TRAFFIC)));
    }

    public void p() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (frsFragment = this.f27607a) == null) {
            return;
        }
        c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(frsFragment.getActivity());
        FrsViewData frsViewData = this.f27607a.getFrsViewData();
        String name = (frsViewData == null || frsViewData.getForum() == null || frsViewData.getForum().getName() == null) ? "" : frsViewData.getForum().getName();
        if (!StringUtils.isNull(name)) {
            aVar.setMessage(String.format(this.f27607a.getString(R.string.attention_cancel_dialog_content), name));
        } else {
            aVar.setMessage(this.f27607a.getString(R.string.attention_cancel_dialog_content_default));
        }
        aVar.setPositiveButton(this.f27607a.getString(R.string.editor_dialog_yes), new e(this));
        aVar.setNegativeButton(this.f27607a.getString(R.string.editor_dialog_no), new C1298f(this));
        aVar.create(this.f27607a.getTbPageContext()).show();
    }
}
