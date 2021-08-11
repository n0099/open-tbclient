package c.a.p0.p3;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.o0.t.g.g;
import c.a.p0.c;
import c.a.p0.i3.z;
import c.a.p0.v0.j;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.view.ShareDialogItemView;
import com.baidu.tieba.transmitShare.ShareGridLayout;
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
/* loaded from: classes3.dex */
public class b implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int s;
    public static final int t;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f23195e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<TransmitForumData> f23196f;

    /* renamed from: g  reason: collision with root package name */
    public Context f23197g;

    /* renamed from: h  reason: collision with root package name */
    public ShareGridLayout f23198h;

    /* renamed from: i  reason: collision with root package name */
    public ShareItem f23199i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.p0.p3.a f23200j;
    public View.OnClickListener k;
    public View.OnClickListener l;
    public boolean m;
    public c.a.p0.c n;
    public c.a.p0.q3.a o;
    public String p;
    public CustomMessageListener q;
    public c.b r;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f23201a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
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
            this.f23201a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ArrayList)) {
                return;
            }
            this.f23201a.f23196f = (ArrayList) customResponsedMessage.getData();
        }
    }

    /* renamed from: c.a.p0.p3.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1076b implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f23202a;

        public C1076b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23202a = bVar;
        }

        @Override // c.a.p0.c.b
        public void a(boolean z) {
            ShareDialogItemView shareDialogItemView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (shareDialogItemView = (ShareDialogItemView) this.f23202a.f23198h.findViewWithTag(16)) == null) {
                return;
            }
            shareDialogItemView.updateItemIcon(z ? R.drawable.icon_pure_share_collected40 : R.drawable.icon_pure_share_collect40, SkinManager.getColor(R.color.CAM_X0107));
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1692489668, "Lc/a/p0/p3/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1692489668, "Lc/a/p0/p3/b;");
                return;
            }
        }
        s = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds202);
        t = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds239);
    }

    public b(Context context) {
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
        this.m = false;
        this.q = new a(this, 2016563);
        this.r = new C1076b(this);
        this.f23197g = context;
        MessageManager.getInstance().registerListener(this.q);
    }

    public final void c(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048576, this, i2, i3, i4) == null) {
            d(i2, i3, SkinManager.getColor(R.color.CAM_X0107), i4);
        }
    }

    public final void d(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.f23197g);
            shareDialogItemView.setItemIcon(i3, i4, i5);
            shareDialogItemView.setItemName(i2);
            shareDialogItemView.setOnClickListener(this);
            this.f23198h.addView(shareDialogItemView.create());
        }
    }

    public final void e(int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.f23197g);
            shareDialogItemView.setItemIcon(i3, SkinManager.getColor(R.color.CAM_X0107), i4);
            shareDialogItemView.setItemName(i2);
            shareDialogItemView.setOnClickListener(this);
            ShareDialogItemView create = shareDialogItemView.create();
            MaskView.maskNovelViewGroup(create, z);
            this.f23198h.addView(create);
        }
    }

    public final void f(AbsSvgType absSvgType, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048579, this, absSvgType, i2, i3) == null) || absSvgType == null) {
            return;
        }
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.f23197g);
        shareDialogItemView.setItemIcon(absSvgType, i3);
        shareDialogItemView.setItemName(i2);
        shareDialogItemView.setOnClickListener(this);
        this.f23198h.addView(shareDialogItemView.create());
    }

    public final void g(AbsSvgType absSvgType, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{absSvgType, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) || absSvgType == null) {
            return;
        }
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.f23197g);
        shareDialogItemView.setItemIcon(absSvgType, i3);
        shareDialogItemView.setItemName(i2);
        shareDialogItemView.setOnClickListener(this);
        ShareDialogItemView create = shareDialogItemView.create();
        MaskView.maskNovelViewGroup(create, z);
        this.f23198h.addView(create);
    }

    public MarkData h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(this.f23199i.K);
            markData.setPostId(this.f23199i.V);
            markData.setTime(date.getTime());
            markData.setId(this.f23199i.K);
            markData.setFloor(1);
            markData.setForumId(this.f23199i.J);
            return markData;
        }
        return (MarkData) invokeV.objValue;
    }

    public final BdUniqueId i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
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

    public ShareGridLayout j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f23198h == null) {
                m();
            }
            return this.f23198h;
        }
        return (ShareGridLayout) invokeV.objValue;
    }

    public final void k(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) && i2 == 13) {
            q();
            u(13);
        }
    }

    public final void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            g gVar = new g(this.f23197g, null);
            ShareItem shareItem = this.f23199i;
            if (i2 == 4) {
                v("share_to_weixin", new Object[0]);
                y(shareItem, 4);
                if (shareItem != null) {
                    gVar.m(shareItem);
                }
            } else if (i2 == 3) {
                v("share_to_pyq", new Object[0]);
                y(shareItem, 3);
                if (shareItem != null) {
                    if (shareItem.f47871b) {
                        shareItem.s = "【" + shareItem.r + "】 " + shareItem.s;
                    }
                    gVar.n(shareItem);
                }
            } else if (i2 == 9) {
                if (z.b(this.f23197g, "com.tencent.mobileqq")) {
                    v("share_to_qq_friend", new Object[0]);
                    y(shareItem, 9);
                    if (shareItem != null) {
                        if (!StringUtils.isNull(shareItem.r) && !StringUtils.isNull(shareItem.s) && shareItem.r.trim().equals(shareItem.s.trim())) {
                            shareItem.s = "";
                        }
                        gVar.h(shareItem);
                        return;
                    }
                    return;
                }
                Context context = this.f23197g;
                BdToast.c(context, context.getText(R.string.share_qq_not_install)).q();
            } else if (i2 == 5) {
                if (z.b(this.f23197g, "com.tencent.mobileqq")) {
                    v("share_to_qzone", new Object[0]);
                    y(shareItem, 5);
                    if (shareItem != null) {
                        if (!StringUtils.isNull(shareItem.r) && !StringUtils.isNull(shareItem.s) && shareItem.r.trim().equals(shareItem.s.trim())) {
                            shareItem.s = "";
                        }
                        gVar.i(shareItem);
                        return;
                    }
                    return;
                }
                Context context2 = this.f23197g;
                BdToast.c(context2, context2.getText(R.string.share_qq_not_install)).q();
            } else if (i2 != 7) {
                if (i2 == 10) {
                    y(shareItem, 10);
                    String o = g.o(shareItem.t, shareItem.K);
                    shareItem.t = o;
                    c.a.e.e.p.a.a(o);
                    l.M(this.f23197g.getApplicationContext(), this.f23197g.getResources().getString(R.string.copy_pb_url_success));
                    w(shareItem);
                    if (shareItem == null || !shareItem.f47870a) {
                        return;
                    }
                    x(8, shareItem.C);
                }
            } else {
                try {
                    if (!WbSdk.isWbInstall(this.f23197g)) {
                        WbSdk.install(this.f23197g, new AuthInfo(this.f23197g, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
                    }
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
                v("share_to_sweibo", new Object[0]);
                y(shareItem, 7);
                if (shareItem != null) {
                    if (!shareItem.f47870a) {
                        if (!StringUtils.isNull(shareItem.r) && !StringUtils.isNull(shareItem.s) && shareItem.r.trim().equals(shareItem.s.trim())) {
                            shareItem.s = "";
                        }
                        shareItem.s = "【" + shareItem.r + "】 " + shareItem.s;
                    }
                    gVar.k(shareItem);
                }
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ShareGridLayout shareGridLayout = new ShareGridLayout(this.f23197g);
            this.f23198h = shareGridLayout;
            shareGridLayout.setItemParams(s, t);
        }
    }

    public final boolean n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? i2 == 4 || i2 == 3 || i2 == 9 || i2 == 5 || i2 == 7 || i2 == 10 : invokeI.booleanValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (!"frs".equals(this.p) || this.f23199i == null) {
                return false;
            }
            return (j.g() || p()) && j.d(j.a()) && StringHelper.equals(this.f23199i.J, j.c());
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            c.a.p0.p3.a aVar = this.f23200j;
            if (aVar != null) {
                aVar.a(view);
            }
            if (view.getTag() instanceof Integer) {
                Integer num = (Integer) view.getTag();
                if (!c.a.e.e.p.j.z() && num.intValue() != 10) {
                    l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                } else if (num.intValue() == 14) {
                    View.OnClickListener onClickListener = this.k;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                } else if (num.intValue() == 16) {
                    if (ViewHelper.checkUpIsLogin(this.f23197g)) {
                        if (this.n.f()) {
                            this.n.e();
                        } else {
                            this.n.d();
                        }
                    }
                } else if (num.intValue() == 17) {
                    if (ViewHelper.checkUpIsLogin(this.f23197g)) {
                        if (this.o == null && (runTask = MessageManager.getInstance().runTask(2921343, c.a.p0.q3.a.class, this.f23197g)) != null) {
                            this.o = (c.a.p0.q3.a) runTask.getData();
                        }
                        c.a.p0.q3.a aVar2 = this.o;
                        if (aVar2 != null) {
                            aVar2.b(i(this.f23197g));
                            this.o.a(this.f23199i.V);
                        }
                    }
                } else {
                    if (num.intValue() == 18) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921607, Boolean.TRUE));
                        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_IMMERSION_VIDEO_SHARE_DIALOG_MUSK_CLiCK);
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        ShareItem shareItem = this.f23199i;
                        if (shareItem != null) {
                            statisticItem.param("tid", shareItem.K);
                            statisticItem.param("fid", this.f23199i.J);
                            statisticItem.param("fname", this.f23199i.p);
                        }
                        TiebaStatic.log(statisticItem);
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem2.param("tid", this.f23199i.K);
                        statisticItem2.param("fid", this.f23199i.J);
                        statisticItem2.param("fname", this.f23199i.p);
                        statisticItem2.param("obj_source", 4);
                        TiebaStatic.log(statisticItem2);
                    }
                    if (num.intValue() == 14) {
                        View.OnClickListener onClickListener2 = this.k;
                        if (onClickListener2 != null) {
                            onClickListener2.onClick(view);
                        }
                    } else if (num.intValue() == 15) {
                        View.OnClickListener onClickListener3 = this.l;
                        if (onClickListener3 != null) {
                            onClickListener3.onClick(view);
                        }
                    } else if (n(num.intValue())) {
                        l(num.intValue());
                    } else {
                        k(num.intValue());
                    }
                }
            }
        }
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ShareItem shareItem = this.f23199i;
            return shareItem != null && shareItem.G == 11;
        }
        return invokeV.booleanValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.f23197g, 25018);
            selectForumActivityConfig.setIsShare(true);
            selectForumActivityConfig.setForumList(this.f23196f);
            if (this.m) {
                selectForumActivityConfig.setFrom(4);
                selectForumActivityConfig.setMoreForumImg(this.f23199i.w);
                selectForumActivityConfig.setMoreForumUrl(this.f23199i.t);
                selectForumActivityConfig.setMoreForumTitle(this.f23199i.r);
            } else {
                selectForumActivityConfig.setFrom(2);
            }
            ShareItem.ForwardInfo forwardInfo = this.f23199i.U;
            if (forwardInfo != null) {
                selectForumActivityConfig.setBaijiahaoData(forwardInfo.baijiahaoData);
                selectForumActivityConfig.setTransmitOriginThreadComment(this.f23199i.U.transmitOriginThreadComment);
                selectForumActivityConfig.setTransmitThreadAuthorNameShow(this.f23199i.U.transmitThreadAuthorNameShow);
            }
            selectForumActivityConfig.setOriginalThread(this.f23199i.T);
            selectForumActivityConfig.setPrivateThread(this.f23195e);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, selectForumActivityConfig));
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.q);
        }
    }

    public void s(c.a.p0.p3.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            this.f23200j = aVar;
        }
    }

    public void t(ShareDialogConfig shareDialogConfig, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048594, this, shareDialogConfig, z) == null) {
            this.f23199i = shareDialogConfig.shareItem;
            this.f23196f = shareDialogConfig.mForumList;
            this.f23195e = shareDialogConfig.mPrivateThread;
            this.k = shareDialogConfig.disLikeListener;
            this.l = shareDialogConfig.closeAdListener;
            this.f23198h.removeAllViews();
            this.m = shareDialogConfig.mShowMoreForumShare;
            this.p = shareDialogConfig.getPrePage();
            if (this.m) {
                f(new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
                f(new SvgMaskType(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
                f(new SvgMaskType(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
                f(new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, 5);
                f(new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
                c(R.string.more_forums, R.drawable.icon_pure_share_moreba40, 13);
                return;
            }
            if (this.f23199i.a0) {
                g(new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4, shareDialogConfig.isShowNovelMask());
                g(new SvgMaskType(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3, shareDialogConfig.isShowNovelMask());
                g(new SvgMaskType(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9, shareDialogConfig.isShowNovelMask());
                g(new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, 5, shareDialogConfig.isShowNovelMask());
                g(new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7, shareDialogConfig.isShowNovelMask());
                e(R.string.share_copy, R.drawable.icon_pure_share_copy40, 10, shareDialogConfig.isShowNovelMask());
            }
            if (shareDialogConfig.isFromImmersionVideo) {
                if (shareDialogConfig.isCollected) {
                    d(R.string.mark, R.drawable.icon_pure_share_collected40, 0, 16);
                } else {
                    c(R.string.mark, R.drawable.icon_pure_share_collect40, 16);
                }
            }
            if (shareDialogConfig.showDisLike) {
                c(R.string.not_interested, R.drawable.icon_pure_share_unlike40, 14);
            }
            if (this.f23199i.b0) {
                c(R.string.close_ad, R.drawable.icon_pure_share_unlike40, 15);
            }
            if (shareDialogConfig.isFromImmersionVideo) {
                if (o()) {
                    c(R.string.forum_shield, R.drawable.icon_pure_pb_shield40, 18);
                }
                c(R.string.report_text, R.drawable.icon_pure_share_report40, 17);
            }
            if (z) {
                c(R.string.more_forums, R.drawable.icon_pure_share_moreba40, 13);
            }
            if (shareDialogConfig.isFromImmersionVideo) {
                c.a.p0.c cVar = new c.a.p0.c(this.f23197g);
                this.n = cVar;
                cVar.i(this.r);
                this.n.g(shareDialogConfig.isCollected);
                this.n.h(h());
            }
        }
    }

    public final void u(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || this.f23199i == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", this.f23199i.J).param("tid", this.f23199i.K).param("obj_type", i2).param("obj_source", this.f23199i.E).param("obj_param1", this.f23199i.F).param(TiebaStatic.Params.OBJ_PARAM2, this.f23199i.G));
        int i3 = this.f23199i.M;
        int i4 = 0;
        int i5 = i3 == 5 ? 1 : i3 == 6 ? 2 : i3 == 7 ? 3 : i3 == 8 ? 4 : 0;
        int i6 = this.f23199i.E;
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

    public final void v(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, objArr) == null) {
            TiebaStatic.eventStat(this.f23197g, str, PrefetchEvent.STATE_CLICK, 1, objArr);
        }
    }

    public final void w(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, shareItem) == null) {
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

    public final void x(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048598, this, i2, str) == null) {
            TiebaStatic.eventStat(this.f23197g, "pb_new_share", null, 1, "loc", Integer.valueOf(i2), PbChosenActivityConfig.KEY_TID, str);
        }
    }

    public final void y(ShareItem shareItem, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048599, this, shareItem, i2) == null) || shareItem == null || shareItem.q == null) {
            return;
        }
        if (shareItem.f47871b) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.q).param("obj_type", i2).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G));
        } else if (!shareItem.f47872c && !shareItem.f47875f) {
            if (shareItem.f47873d) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.q).param("obj_type", i2));
            } else if (shareItem.f47870a) {
                x(i2, shareItem.C);
            } else if (shareItem.f47874e) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i2).param("fid", shareItem.q).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G));
            } else if (shareItem.f47876g) {
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
