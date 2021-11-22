package b.a.r0.x0.z2;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.s.a;
import b.a.r0.m3.h0;
import b.a.r0.m3.x;
import b.a.r0.x0.e1;
import b.a.r0.x0.i1;
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
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f28460a;

    /* renamed from: b  reason: collision with root package name */
    public TBSpecificationBtn f28461b;

    /* renamed from: c  reason: collision with root package name */
    public LikeModel f28462c;

    /* renamed from: d  reason: collision with root package name */
    public h0 f28463d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f28464e;

    /* renamed from: f  reason: collision with root package name */
    public AntiHelper.k f28465f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f28466g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.e.a.e f28467h;

    /* renamed from: i  reason: collision with root package name */
    public h0.a f28468i;

    /* loaded from: classes6.dex */
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
        public void onNavigationButtonClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f28469a;

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
            this.f28469a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof x)) {
                this.f28469a.f(customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends b.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f28470a;

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
            this.f28470a = fVar;
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.f28470a.f(obj);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements h0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f28471a;

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
            this.f28471a = fVar;
        }

        @Override // b.a.r0.m3.h0.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            }
        }

        @Override // b.a.r0.m3.h0.a
        public void b(String str, long j) {
            FrsViewData frsViewData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) || this.f28471a.f28460a == null || (frsViewData = this.f28471a.f28460a.getFrsViewData()) == null || frsViewData.getForum() == null) {
                return;
            }
            String name = frsViewData.getForum().getName();
            String id = frsViewData.getForum().getId();
            if (j == b.a.e.f.m.b.g(id, 0L) && TextUtils.equals(name, str)) {
                h headerVC = this.f28471a.f28460a.getHeaderVC();
                if (headerVC != null) {
                    headerVC.Y(str);
                }
                frsViewData.getForum().setLike(0);
                if (headerVC != null) {
                    headerVC.T(0);
                }
                this.f28471a.f28460a.unlikeCallBack(Boolean.TRUE);
                this.f28471a.l(false, id);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, id));
                x xVar = new x();
                xVar.v(0);
                xVar.s(id);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, xVar));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f28472e;

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
            this.f28472e = fVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                if (this.f28472e.f28460a == null || this.f28472e.f28463d == null) {
                    return;
                }
                FrsViewData frsViewData = this.f28472e.f28460a.getFrsViewData();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (frsViewData == null || frsViewData.getForum() == null) {
                        return;
                    }
                    this.f28472e.f28463d.c(frsViewData.getForum().getName(), b.a.e.f.m.b.g(frsViewData.getForum().getId(), 0L));
                    return;
                }
                TbadkCoreApplication.getInst().login(this.f28472e.f28460a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f28472e.f28460a.getActivity(), true, 11036)));
            }
        }
    }

    /* renamed from: b.a.r0.x0.z2.f$f  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1394f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1394f(f fVar) {
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

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
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
        this.f28462c = null;
        this.f28463d = null;
        this.f28465f = new a(this);
        this.f28466g = new b(this, 2921600);
        this.f28467h = new c(this);
        this.f28468i = new d(this);
        this.f28460a = frsFragment;
        if (frsFragment != null) {
            frsFragment.registerListener(this.f28466g);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13605");
            FrsFragment frsFragment = this.f28460a;
            if (frsFragment != null) {
                b.a.q0.n0.c.b(frsFragment.getContext(), statisticItem);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void f(Object obj) {
        FrsFragment frsFragment;
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) || (frsFragment = this.f28460a) == null || (frsViewData = frsFragment.getFrsViewData()) == null || frsViewData.getForum() == null || obj == null) {
            return;
        }
        if (AntiHelper.m(this.f28462c.getErrorCode(), this.f28462c.getErrorString())) {
            if (AntiHelper.t(this.f28460a.getActivity(), this.f28462c.J(), this.f28465f) != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                return;
            }
            return;
        }
        String name = frsViewData.getForum().getName();
        String id = frsViewData.getForum().getId();
        x xVar = obj instanceof x ? (x) obj : null;
        boolean z = xVar != null && this.f28462c.getErrorCode() == 0;
        if (xVar.d() == 3250013) {
            BdToast.h(TbadkCoreApplication.getInst().getContext(), xVar.e(), e1.icon_pure_toast_mistake40_svg, 3000, true).q();
            z = false;
        }
        if (xVar != null && z) {
            h headerVC = this.f28460a.getHeaderVC();
            if (headerVC != null) {
                headerVC.Y(name);
            }
            xVar.v(1);
            frsViewData.updateLikeData(xVar);
            frsViewData.setLikeFeedForumDataList(xVar.f());
            if (headerVC != null) {
                headerVC.f0(frsViewData, this.f28464e);
            }
            this.f28464e = true;
            FrsFragment frsFragment2 = this.f28460a;
            frsFragment2.showToast(frsFragment2.getResources().getString(i1.attention_success));
            if (b.a.q0.t.h.a.e(this.f28460a.getContext(), 0)) {
                b.a.q0.t.h.a.g(this.f28460a.getPageContext(), 4, 2000L);
            }
            l(true, id);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, xVar));
            e();
        } else if (this.f28462c.getErrorCode() == 22) {
            FrsFragment frsFragment3 = this.f28460a;
            frsFragment3.showToast(frsFragment3.getString(i1.had_liked_forum));
        } else {
            this.f28460a.showToast(this.f28462c.getErrorString());
        }
        this.f28460a.likeCallBack(Boolean.valueOf(z));
    }

    public void g(TBSpecificationBtn tBSpecificationBtn) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tBSpecificationBtn) == null) {
            this.f28461b = tBSpecificationBtn;
            m();
        }
    }

    public final void h() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (frsFragment = this.f28460a) == null) {
            return;
        }
        LikeModel likeModel = new LikeModel(frsFragment.getPageContext());
        this.f28462c = likeModel;
        likeModel.setLoadDataCallBack(this.f28467h);
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            h0 h0Var = new h0();
            this.f28463d = h0Var;
            h0Var.a("from_frs");
            this.f28463d.b(this.f28468i);
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
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (likeModel = this.f28462c) == null) {
            return;
        }
        likeModel.I();
    }

    public final void l(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048583, this, z, str) == null) {
            b.a.r0.l1.t.d.j().g(TbadkCoreApplication.getCurrentAccount(), str, z, null);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    public void m() {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (tBSpecificationBtn = this.f28461b) == null) {
            return;
        }
        tBSpecificationBtn.changeSkinType();
    }

    public void n(String str, String str2) {
        LikeModel likeModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) || (likeModel = this.f28462c) == null) {
            return;
        }
        likeModel.M(str, str2, "FRS");
    }

    public void o(boolean z) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (frsFragment = this.f28460a) == null || this.f28462c == null) {
            return;
        }
        FrsViewData frsViewData = frsFragment.getFrsViewData();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (frsViewData == null || frsViewData.getForum() == null) {
                return;
            }
            if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.f28460a.getFrom())) {
                TiebaStatic.log(new StatisticItem("c10356").param("fid", frsViewData.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.f28460a.getFrom())) {
                TiebaStatic.log(new StatisticItem("c10590").param("obj_type", 2).param("fid", frsViewData.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.f28460a.getFrom())) {
                TiebaStatic.log(new StatisticItem("c10587").param("obj_type", 2).param("fid", frsViewData.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.f28460a.getFrom())) {
                TiebaStatic.log(new StatisticItem("c10578").param("obj_type", 2).param("fid", frsViewData.getForum().getId()));
            }
            this.f28462c.setFrom("recom_flist_like_frs");
            if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.f28460a.getFrom())) {
                TiebaStatic.eventStat(this.f28460a.getPageContext().getPageActivity(), "square_frs_focus", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.f28460a.getFrom())) {
                TiebaStatic.log(new StatisticItem("c10359").param("fid", frsViewData.getForum().getId()));
            }
            this.f28462c.M(frsViewData.getForum().getName(), frsViewData.getForum().getId(), "FRS");
            this.f28464e = z;
            return;
        }
        TbadkCoreApplication.getInst().login(this.f28460a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f28460a.getActivity(), true, CyberPlayerManager.MEDIA_INFO_KERNEL_NET_TRAFFIC)));
    }

    public void p() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (frsFragment = this.f28460a) == null) {
            return;
        }
        b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(frsFragment.getActivity());
        FrsViewData frsViewData = this.f28460a.getFrsViewData();
        String name = (frsViewData == null || frsViewData.getForum() == null || frsViewData.getForum().getName() == null) ? "" : frsViewData.getForum().getName();
        if (!StringUtils.isNull(name)) {
            aVar.setMessage(String.format(this.f28460a.getString(i1.attention_cancel_dialog_content), name));
        } else {
            aVar.setMessage(this.f28460a.getString(i1.attention_cancel_dialog_content_default));
        }
        aVar.setPositiveButton(this.f28460a.getString(i1.editor_dialog_yes), new e(this));
        aVar.setNegativeButton(this.f28460a.getString(i1.editor_dialog_no), new C1394f(this));
        aVar.create(this.f28460a.getTbPageContext()).show();
    }
}
