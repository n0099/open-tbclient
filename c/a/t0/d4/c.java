package c.a.t0.d4;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.s0.t.g.g;
import c.a.t0.c;
import c.a.t0.e1.j;
import c.a.t0.x3.b0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tieba.R;
import com.baidu.tieba.flutter.plugin.passprovider.PassProviderPlugin;
import com.baidu.tieba.sharesdk.view.ShareDialogItemView;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import com.baidu.tieba.transmitShare.ShareScrollableLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
/* loaded from: classes7.dex */
public class c implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int A;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f15953e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<TransmitForumData> f15954f;

    /* renamed from: g  reason: collision with root package name */
    public Context f15955g;

    /* renamed from: h  reason: collision with root package name */
    public View f15956h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.t0.d4.b f15957i;

    /* renamed from: j  reason: collision with root package name */
    public ShareItem f15958j;
    public c.a.t0.d4.a k;
    public View.OnClickListener l;
    public View.OnClickListener m;
    public View.OnClickListener n;
    public boolean o;
    public c.a.t0.c p;
    public c.a.t0.e4.a q;
    public String r;
    public boolean s;
    public boolean t;
    public String u;
    @NonNull
    public c.a.s0.j0.e.b v;
    @Nullable
    public c.a.s0.j0.e.a w;
    public CustomMessageListener x;
    public c.b y;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
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
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ArrayList)) {
                return;
            }
            this.a.f15954f = (ArrayList) customResponsedMessage.getData();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.t0.c.b
        public void a(boolean z) {
            ShareDialogItemView shareDialogItemView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (shareDialogItemView = (ShareDialogItemView) this.a.f15956h.findViewWithTag(16)) == null) {
                return;
            }
            shareDialogItemView.updateItemIcon(z ? R.drawable.icon_pure_share_collected40 : R.drawable.icon_pure_share_collect40, SkinManager.getColor(R.color.CAM_X0107));
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(972731946, "Lc/a/t0/d4/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(972731946, "Lc/a/t0/d4/c;");
                return;
            }
        }
        z = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds202);
        A = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds239);
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.o = false;
        this.v = (c.a.s0.j0.e.b) c.a.s0.j0.b.c(c.a.s0.j0.e.b.a);
        this.w = null;
        this.x = new a(this, 2016563);
        this.y = new b(this);
        this.f15955g = context;
        MessageManager.getInstance().registerListener(this.x);
    }

    public final void c(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048576, this, i2, i3, i4, i5) == null) {
            g(i2, i3, SkinManager.getColor(R.color.CAM_X0107), i4, i5);
        }
    }

    public final void d(int i2, int i3, int i4, boolean z2, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z2), Integer.valueOf(i5)}) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.f15955g);
            shareDialogItemView.setItemIcon(i3, SkinManager.getColor(R.color.CAM_X0107), i4);
            shareDialogItemView.setItemName(i2);
            shareDialogItemView.setOnClickListener(this);
            ShareDialogItemView create = shareDialogItemView.create();
            MaskView.maskNovelViewGroup(create, z2);
            this.f15957i.addViewAtRow(i5, create);
        }
    }

    public final void e(AbsSvgType absSvgType, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, absSvgType, i2, i3, i4) == null) || absSvgType == null) {
            return;
        }
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.f15955g);
        shareDialogItemView.setItemIcon(absSvgType, i3);
        shareDialogItemView.setItemName(i2);
        shareDialogItemView.setOnClickListener(this);
        this.f15957i.addViewAtRow(i4, shareDialogItemView.create());
    }

    public final void f(AbsSvgType absSvgType, int i2, int i3, boolean z2, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{absSvgType, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), Integer.valueOf(i4)}) == null) || absSvgType == null) {
            return;
        }
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.f15955g);
        shareDialogItemView.setItemIcon(absSvgType, i3);
        shareDialogItemView.setItemName(i2);
        shareDialogItemView.setOnClickListener(this);
        ShareDialogItemView create = shareDialogItemView.create();
        MaskView.maskNovelViewGroup(create, z2);
        this.f15957i.addViewAtRow(i4, create);
    }

    public final void g(int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.f15955g);
            shareDialogItemView.setItemIcon(i3, i4, i5);
            shareDialogItemView.setItemName(i2);
            shareDialogItemView.setOnClickListener(this);
            this.f15957i.addViewAtRow(i6, shareDialogItemView.create());
        }
    }

    @NonNull
    public c.a.s0.j0.e.a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.w == null) {
                this.w = this.v.b(j());
            }
            return (c.a.s0.j0.e.a) Objects.requireNonNull(this.w);
        }
        return (c.a.s0.j0.e.a) invokeV.objValue;
    }

    public MarkData i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(this.f15958j.K);
            markData.setPostId(this.f15958j.X);
            markData.setTime(date.getTime());
            markData.setId(this.f15958j.K);
            markData.setFloor(1);
            markData.setForumId(this.f15958j.J);
            return markData;
        }
        return (MarkData) invokeV.objValue;
    }

    @NonNull
    public final TbPageContext j() {
        InterceptResult invokeV;
        TbPageContext<BaseFragmentActivity> pageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Context context = this.f15955g;
            if (context instanceof BaseActivity) {
                pageContext = ((BaseActivity) context).getPageContext();
            } else {
                pageContext = context instanceof BaseFragmentActivity ? ((BaseFragmentActivity) context).getPageContext() : null;
            }
            return (TbPageContext) Objects.requireNonNull(pageContext);
        }
        return (TbPageContext) invokeV.objValue;
    }

    public final BdUniqueId k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
            if (context instanceof BaseActivity) {
                return ((BaseActivity) context).getUniqueId();
            }
            if (context instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) context).getUniqueId();
            }
            return null;
        }
        return (BdUniqueId) invokeL.objValue;
    }

    public View l(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z2)) == null) {
            if (this.f15956h == null) {
                if (z2) {
                    this.f15957i = new ShareScrollableLayout(this.f15955g);
                } else {
                    this.f15957i = new ShareGridLayout(this.f15955g);
                }
                this.f15957i.setItemParams(z, A);
                this.f15956h = this.f15957i.getView();
            }
            return this.f15956h;
        }
        return (View) invokeZ.objValue;
    }

    public final void m(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i2) == null) && i2 == 13) {
            r();
            v(13);
        }
    }

    public final void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            g gVar = new g(this.f15955g, null);
            ShareItem shareItem = this.f15958j;
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_VOICE_ROOM_SHARE);
            if (i2 == 4) {
                w("share_to_weixin", new Object[0]);
                statisticItem.param(TiebaStatic.Params.TIEBA_PARAMS, ThirdPartyUtil.TYPE_WEIXIN);
                z(shareItem, 4);
                if (shareItem != null) {
                    gVar.t(shareItem);
                }
            } else if (i2 == 3) {
                w("share_to_pyq", new Object[0]);
                statisticItem.param(TiebaStatic.Params.TIEBA_PARAMS, "pyq");
                z(shareItem, 3);
                if (shareItem != null) {
                    if (shareItem.f40790b) {
                        shareItem.s = "【" + shareItem.r + "】 " + shareItem.s;
                    }
                    gVar.u(shareItem);
                }
            } else if (i2 == 9) {
                statisticItem.param(TiebaStatic.Params.TIEBA_PARAMS, "qq");
                if (b0.b(this.f15955g, "com.tencent.mobileqq")) {
                    w("share_to_qq_friend", new Object[0]);
                    z(shareItem, 9);
                    if (shareItem != null) {
                        if (!StringUtils.isNull(shareItem.r) && !StringUtils.isNull(shareItem.s) && shareItem.r.trim().equals(shareItem.s.trim())) {
                            shareItem.s = "";
                        }
                        gVar.o(shareItem);
                    }
                } else {
                    Context context = this.f15955g;
                    BdToast.c(context, context.getText(R.string.share_qq_not_install)).q();
                }
            } else if (i2 == 5) {
                statisticItem.param(TiebaStatic.Params.TIEBA_PARAMS, "qqzone");
                if (b0.b(this.f15955g, "com.tencent.mobileqq")) {
                    w("share_to_qzone", new Object[0]);
                    z(shareItem, 5);
                    if (shareItem != null) {
                        if (!StringUtils.isNull(shareItem.r) && !StringUtils.isNull(shareItem.s) && shareItem.r.trim().equals(shareItem.s.trim())) {
                            shareItem.s = "";
                        }
                        gVar.p(shareItem);
                    }
                } else {
                    Context context2 = this.f15955g;
                    BdToast.c(context2, context2.getText(R.string.share_qq_not_install)).q();
                }
            } else if (i2 == 7) {
                statisticItem.param(TiebaStatic.Params.TIEBA_PARAMS, PassProviderPlugin.LOGIN_TYPE_WEIBO);
                try {
                    if (!WbSdk.isWbInstall(this.f15955g)) {
                        WbSdk.install(this.f15955g, new AuthInfo(this.f15955g, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
                    }
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
                w("share_to_sweibo", new Object[0]);
                z(shareItem, 7);
                if (shareItem != null) {
                    if (!shareItem.a) {
                        if (!StringUtils.isNull(shareItem.r) && !StringUtils.isNull(shareItem.s) && shareItem.r.trim().equals(shareItem.s.trim())) {
                            shareItem.s = "";
                        }
                        shareItem.s = "【" + shareItem.r + "】 " + shareItem.s;
                    }
                    gVar.r(shareItem);
                }
            } else if (i2 == 10) {
                statisticItem.param(TiebaStatic.Params.TIEBA_PARAMS, "copylink");
                z(shareItem, 10);
                String v = g.v(shareItem.t, shareItem.K, UtilHelper.isVideoThread(shareItem.M));
                shareItem.t = v;
                c.a.d.f.p.c.a(v);
                n.N(this.f15955g.getApplicationContext(), this.f15955g.getResources().getString(R.string.copy_pb_url_success));
                x(shareItem);
                if (shareItem != null && shareItem.a) {
                    y(8, shareItem.C);
                }
            }
            if (shareItem.E != 8 || shareItem.U <= 0) {
                return;
            }
            statisticItem.param("obj_type", "2");
            statisticItem.param("room_id", shareItem.U);
            TiebaStatic.log(statisticItem);
        }
    }

    public final boolean o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) ? i2 == 4 || i2 == 3 || i2 == 9 || i2 == 5 || i2 == 7 || i2 == 10 : invokeI.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            c.a.t0.d4.a aVar = this.k;
            if (aVar != null) {
                aVar.a(view);
            }
            if (view.getTag() instanceof Integer) {
                Integer num = (Integer) view.getTag();
                if (!l.z() && num.intValue() != 10) {
                    n.M(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                } else if (num.intValue() == 14) {
                    View.OnClickListener onClickListener2 = this.l;
                    if (onClickListener2 != null) {
                        onClickListener2.onClick(view);
                    }
                } else if (num.intValue() == 16) {
                    if (ViewHelper.checkUpIsLogin(this.f15955g)) {
                        if (this.p.f()) {
                            this.p.e();
                        } else {
                            this.p.d();
                        }
                    }
                } else if (num.intValue() == 17) {
                    if (ViewHelper.checkUpIsLogin(this.f15955g)) {
                        if (this.q == null && (runTask = MessageManager.getInstance().runTask(2921343, c.a.t0.e4.a.class, this.f15955g)) != null) {
                            this.q = (c.a.t0.e4.a) runTask.getData();
                        }
                        c.a.t0.e4.a aVar2 = this.q;
                        if (aVar2 != null) {
                            aVar2.b(k(this.f15955g));
                            this.q.a(this.f15958j.X);
                        }
                    }
                } else {
                    if (num.intValue() == 18) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921607, Boolean.TRUE));
                        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_IMMERSION_VIDEO_SHARE_DIALOG_MUSK_CLiCK);
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        ShareItem shareItem = this.f15958j;
                        if (shareItem != null) {
                            statisticItem.param("tid", shareItem.K);
                            statisticItem.param("fid", this.f15958j.J);
                            statisticItem.param("fname", this.f15958j.p);
                        }
                        TiebaStatic.log(statisticItem);
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem2.param("tid", this.f15958j.K);
                        statisticItem2.param("fid", this.f15958j.J);
                        statisticItem2.param("fname", this.f15958j.p);
                        statisticItem2.param("obj_source", 4);
                        TiebaStatic.log(statisticItem2);
                    } else if (num.intValue() == 19) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921607, Boolean.FALSE));
                    } else if (num.intValue() == 20) {
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        ShareItem shareItem2 = this.f15958j;
                        String str = shareItem2.Z;
                        String str2 = shareItem2.a0;
                        String str3 = shareItem2.X;
                        String str4 = shareItem2.Y;
                        Context context = this.f15955g;
                        ShareItem shareItem3 = this.f15958j;
                        new ForbidActivityConfig(context, shareItem3.J, shareItem3.p, shareItem3.K, currentAccount, str, str2, str3, str4).start();
                    } else if (num.intValue() == 21) {
                        c.a.s0.j0.e.a h2 = h();
                        ShareItem shareItem4 = this.f15958j;
                        h2.b(shareItem4.J, shareItem4.p, shareItem4.K, this.s);
                    } else if (num.intValue() == 22) {
                        c.a.s0.j0.e.a h3 = h();
                        ShareItem shareItem5 = this.f15958j;
                        h3.a(shareItem5.J, shareItem5.p, shareItem5.K, this.t);
                    } else if (num.intValue() == 23) {
                        if (ViewHelper.checkUpIsLogin(this.f15955g) && (onClickListener = this.n) != null) {
                            onClickListener.onClick(view);
                            return;
                        }
                        return;
                    }
                    if (num.intValue() == 14) {
                        View.OnClickListener onClickListener3 = this.l;
                        if (onClickListener3 != null) {
                            onClickListener3.onClick(view);
                        }
                    } else if (num.intValue() == 15) {
                        View.OnClickListener onClickListener4 = this.m;
                        if (onClickListener4 != null) {
                            onClickListener4.onClick(view);
                        }
                    } else if (o(num.intValue())) {
                        n(num.intValue());
                    } else {
                        m(num.intValue());
                    }
                }
            }
        }
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (!"frs".equals(this.r) || this.f15958j == null) {
                return false;
            }
            return (j.g() || q()) && j.d(j.a()) && StringHelper.equals(this.f15958j.J, j.c());
        }
        return invokeV.booleanValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            ShareItem shareItem = this.f15958j;
            return shareItem != null && shareItem.G == 11;
        }
        return invokeV.booleanValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.f15955g, 25018);
            selectForumActivityConfig.setIsShare(true);
            selectForumActivityConfig.setForumList(this.f15954f);
            if (this.o) {
                selectForumActivityConfig.setFrom(4);
                selectForumActivityConfig.setMoreForumImg(this.f15958j.w);
                selectForumActivityConfig.setMoreForumUrl(this.f15958j.t);
                selectForumActivityConfig.setMoreForumTitle(this.f15958j.r);
            } else {
                selectForumActivityConfig.setFrom(2);
            }
            ShareItem.ForwardInfo forwardInfo = this.f15958j.W;
            if (forwardInfo != null) {
                selectForumActivityConfig.setBaijiahaoData(forwardInfo.baijiahaoData);
                selectForumActivityConfig.setTransmitOriginThreadComment(this.f15958j.W.transmitOriginThreadComment);
                selectForumActivityConfig.setTransmitThreadAuthorNameShow(this.f15958j.W.transmitThreadAuthorNameShow);
            }
            selectForumActivityConfig.setOriginalThread(this.f15958j.T);
            selectForumActivityConfig.setPrivateThread(this.f15953e);
            if (!StringUtils.isNull(this.u)) {
                selectForumActivityConfig.setTopicId(this.u);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, selectForumActivityConfig));
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.x);
        }
    }

    public void t(c.a.t0.d4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) {
            this.k = aVar;
        }
    }

    public void u(ShareDialogConfig shareDialogConfig, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048595, this, shareDialogConfig, z2) == null) {
            this.f15958j = shareDialogConfig.shareItem;
            this.f15954f = shareDialogConfig.mForumList;
            this.f15953e = shareDialogConfig.mPrivateThread;
            this.l = shareDialogConfig.disLikeListener;
            this.m = shareDialogConfig.closeAdListener;
            this.n = shareDialogConfig.heatingListener;
            this.u = shareDialogConfig.topicId;
            this.f15957i.removeAllViews();
            this.o = shareDialogConfig.mShowMoreForumShare;
            this.r = shareDialogConfig.getPrePage();
            this.s = shareDialogConfig.isMadeTop;
            this.t = shareDialogConfig.isAddedGood;
            if (this.o) {
                e(new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4, 0);
                e(new SvgMaskType(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3, 0);
                e(new SvgMaskType(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9, 0);
                e(new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, 5, 0);
                e(new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7, 0);
                c(R.string.more_forums, R.drawable.icon_pure_share_moreba40, 13, 0);
                return;
            }
            if (this.f15958j.f0) {
                f(new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4, shareDialogConfig.isShowNovelMask(), 0);
                f(new SvgMaskType(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3, shareDialogConfig.isShowNovelMask(), 0);
                f(new SvgMaskType(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9, shareDialogConfig.isShowNovelMask(), 0);
                f(new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, 5, shareDialogConfig.isShowNovelMask(), 0);
                f(new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7, shareDialogConfig.isShowNovelMask(), 0);
                d(R.string.share_copy, R.drawable.icon_pure_share_copy40, 10, shareDialogConfig.isShowNovelMask(), 1);
            }
            boolean isPrePagePersonalPage = shareDialogConfig.isPrePagePersonalPage();
            boolean z3 = shareDialogConfig.isHost;
            if (shareDialogConfig.isFromImmersionVideo) {
                if (!isPrePagePersonalPage && p()) {
                    c(R.string.forum_shield, R.drawable.icon_pure_pb_shield40, 18, 1);
                }
                if (shareDialogConfig.isCollected) {
                    g(R.string.mark, R.drawable.icon_pure_share_collected40, 0, 16, 1);
                } else {
                    c(R.string.mark, R.drawable.icon_pure_share_collect40, 16, 1);
                }
                if (!z3) {
                    c(R.string.report_text, R.drawable.icon_pure_share_report40, 17, 1);
                } else if (isPrePagePersonalPage) {
                    c(R.string.delete, R.drawable.icon_pure_share_cutout40, 19, 1);
                }
            }
            if (shareDialogConfig.showDisLike && !isPrePagePersonalPage) {
                c(R.string.not_interested, R.drawable.icon_pure_share_unlike40, 14, 1);
            }
            if (this.f15958j.g0) {
                c(R.string.close_ad, R.drawable.icon_pure_share_unlike40, 15, 1);
            }
            if (shareDialogConfig.showHeating) {
                c(shareDialogConfig.isSelfHeating ? R.string.heating_thread : R.string.help_heating_thread, R.drawable.icon_pure_share_fire_40, 23, 1);
            }
            if (z2) {
                c(R.string.more_forums, R.drawable.icon_pure_share_moreba40, 13, 1);
            }
            if (shareDialogConfig.isFromImmersionVideo) {
                c.a.t0.c cVar = new c.a.t0.c(this.f15955g);
                this.p = cVar;
                cVar.i(this.y);
                this.p.g(shareDialogConfig.isCollected);
                this.p.h(i());
            }
        }
    }

    public final void v(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i2) == null) || this.f15958j == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", this.f15958j.J).param("tid", this.f15958j.K).param("obj_type", i2).param("obj_source", this.f15958j.E).param("obj_param1", this.f15958j.F).param(TiebaStatic.Params.OBJ_PARAM2, this.f15958j.G));
        int i3 = this.f15958j.M;
        int i4 = 0;
        int i5 = i3 == 5 ? 1 : i3 == 6 ? 2 : i3 == 7 ? 3 : i3 == 8 ? 4 : 0;
        int i6 = this.f15958j.E;
        if (i6 == 4) {
            i4 = 1;
        } else if (i6 == 3) {
            i4 = 2;
        } else if (i6 == 8) {
            i4 = 3;
        } else if (i6 == 6) {
            i4 = 4;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_TRANSFER_BTN_CLICK).param("obj_locate", i2 != 11 ? 1 : 2).param("obj_source", i4).param("obj_type", i5));
    }

    public final void w(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, objArr) == null) {
            TiebaStatic.eventStat(this.f15955g, str, "click", 1, objArr);
        }
    }

    public final void x(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, shareItem) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 7);
            int i2 = shareItem.F;
            if (i2 != 0) {
                param.param("obj_param1", i2);
                int i3 = shareItem.F;
                if (i3 == 2) {
                    param.param("fid", shareItem.J);
                } else if (i3 == 3) {
                    int i4 = shareItem.M;
                    if (i4 != 0) {
                        param.param("obj_type", i4);
                    }
                    param.param("tid", shareItem.K).param("fid", shareItem.J);
                }
            }
            param.param("obj_locate", 9);
            TiebaStatic.log(param);
        }
    }

    public final void y(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048599, this, i2, str) == null) {
            TiebaStatic.eventStat(this.f15955g, "pb_new_share", null, 1, "loc", Integer.valueOf(i2), PbChosenActivityConfig.KEY_TID, str);
        }
    }

    public final void z(ShareItem shareItem, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048600, this, shareItem, i2) == null) || shareItem == null || shareItem.q == null) {
            return;
        }
        if (shareItem.f40790b) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.q).param("obj_type", i2).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G));
        } else if (!shareItem.f40791c && !shareItem.f40794f) {
            if (shareItem.f40792d) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.q).param("obj_type", i2));
            } else if (shareItem.a) {
                y(i2, shareItem.C);
            } else if (shareItem.f40793e) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i2).param("fid", shareItem.q).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G));
            } else if (shareItem.f40795g) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i2);
                param.param("obj_source", shareItem.E);
                param.param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G);
                TiebaStatic.log(param);
            }
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.q).param("obj_type", i2).param("obj_source", shareItem.E).param("obj_param1", shareItem.F).param("fid", shareItem.J).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G));
        }
    }
}
