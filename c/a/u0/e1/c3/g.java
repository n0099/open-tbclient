package c.a.u0.e1.c3;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.a.r;
import c.a.t0.s.r.z1;
import c.a.u0.e1.d1;
import c.a.u0.e1.e1;
import c.a.u0.e1.f1;
import c.a.u0.e1.i1;
import c.a.u0.e1.q;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.message.SignMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tbclient.SignActivityInfo;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;

    /* renamed from: b  reason: collision with root package name */
    public List<TBSpecificationBtn> f16329b;

    /* renamed from: c  reason: collision with root package name */
    public String f16330c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f16331d;

    /* renamed from: e  reason: collision with root package name */
    public int f16332e;

    /* renamed from: f  reason: collision with root package name */
    public int f16333f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16334g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16335h;

    /* renamed from: i  reason: collision with root package name */
    public SignActivityInfo f16336i;

    /* renamed from: j  reason: collision with root package name */
    public String f16337j;
    public CustomMessageListener k;
    public AntiHelper.k l;
    public CustomMessageListener m;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g gVar, int i2) {
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
            FrsViewData frsViewData;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            boolean z2;
            int i2;
            z1 z1Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.a == null || !(customResponsedMessage instanceof SignMessage) || (frsViewData = this.a.a.getFrsViewData()) == null || frsViewData.getForum() == null || (name = (forum = frsViewData.getForum()).getName()) == null || !name.equals(FrsActivityStatic.f43288c) || customResponsedMessage.getOrginalMessage().getTag() != this.a.f16331d) {
                return;
            }
            TiebaStatic.eventStat(this.a.a.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
            String name2 = forum.getName();
            SignMessage signMessage = (SignMessage) customResponsedMessage;
            if (!AntiHelper.m(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                h headerVC = this.a.a.getHeaderVC();
                if (signMessage == null || (signData = signMessage.signData) == null) {
                    signData = null;
                    z = false;
                } else {
                    String str = signData.forumId;
                    if (str == null || !str.equals(forum.getId())) {
                        return;
                    }
                    if (headerVC != null) {
                        headerVC.S(name2);
                    }
                    frsViewData.updateSignData(signData);
                    signData.forumId = forum.getId();
                    signData.forumName = forum.getName();
                    z = true;
                }
                if (z) {
                    int user_level = forum.getUser_level();
                    if (headerVC != null ? headerVC.A() : false) {
                        int user_level2 = forum.getUser_level();
                        if (user_level >= user_level2) {
                            user_level2++;
                        }
                        user_level = user_level2;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, user_level);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
                    if (c.a.t0.b.d.r0() && signData != null && (z1Var = signData.mSignStampInfoData) != null && !ListUtils.isEmpty(z1Var.a())) {
                        new c.a.u0.v3.e().f(signData.mSignStampInfoData);
                        return;
                    }
                    if (!c.a.t0.b.d.r0()) {
                        try {
                            i2 = new JSONObject(signData.userInfoJson).getInt("activity_status");
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        if (i2 == 1 || i2 == 2) {
                            z2 = true;
                            if (z2 || !this.a.f16335h) {
                                if (!this.a.l() && signData.contDays > 0) {
                                    c.a.t0.t.d.f.c().j(signData.userInfoJson);
                                    TbPageContext<?> tbPageContext = this.a.a.getTbPageContext();
                                    TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.a.a.getActivity(), "", this.a.f16330c, false, true, true);
                                    tbWebViewActivityConfig.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
                                    tbPageContext.sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
                                    r.g().k().b();
                                    return;
                                }
                                c.a.t0.t.d.f.c().j(null);
                            } else {
                                if (signData != null && this.a.f16336i != null) {
                                    try {
                                        JSONObject jSONObject = new JSONObject(signData.userInfoJson);
                                        jSONObject.put("activity_id", this.a.f16336i.activity_id);
                                        jSONObject.put("activity_suc_msg", this.a.f16336i.activity_suc_msg);
                                        jSONObject.put("activity_fail_msg", this.a.f16336i.activity_fail_msg);
                                        jSONObject.put("gift_type", this.a.f16336i.gift_type);
                                        jSONObject.put("gift_url", this.a.f16336i.gift_url);
                                        jSONObject.put("gift_name", this.a.f16336i.gift_name);
                                        jSONObject.put("icon_name", this.a.f16336i.icon_name);
                                        jSONObject.put("icon_lifecycle", this.a.f16336i.icon_lifecycle);
                                        jSONObject.put("activity_name", this.a.f16336i.activity_name);
                                        jSONObject.put("image_url", this.a.f16336i.image_url);
                                        c.a.t0.t.d.f.c().j(jSONObject.toString());
                                    } catch (Exception unused) {
                                    }
                                }
                                TbPageContext<?> tbPageContext2 = this.a.a.getTbPageContext();
                                TbWebViewActivityConfig tbWebViewActivityConfig2 = new TbWebViewActivityConfig(this.a.a.getActivity(), "", this.a.f16337j, false, true, true);
                                tbWebViewActivityConfig2.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
                                tbPageContext2.sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig2));
                                r.g().k().b();
                                return;
                            }
                        }
                        z2 = false;
                        if (z2) {
                        }
                        if (!this.a.l()) {
                        }
                        c.a.t0.t.d.f.c().j(null);
                    }
                    if (headerVC == null || headerVC.t()) {
                        this.a.a.showToast(TbadkCoreApplication.getInst().getString(i1.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                    } else {
                        this.a.a.showToast(TbadkCoreApplication.getInst().getString(i1.frs_sign_success, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                    }
                    q frsView = this.a.a.getFrsView();
                    if (frsView != null) {
                        c.a.t0.t.d.f.c().a(this.a.a.getTbPageContext(), frsView.n0());
                        return;
                    }
                    return;
                }
                if (signMessage.mSignErrorCode == 160002 && headerVC != null) {
                    headerVC.a0(1);
                }
                this.a.a.showToast(signMessage.mSignErrorString);
                return;
            }
            if (signMessage.signData != null) {
                AntiHelper.t(this.a.a.getActivity(), signMessage.signData.blockPopInfoData, this.a.l);
            } else {
                AntiHelper.u(this.a.a.getActivity(), signMessage.mSignErrorString);
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
        }
    }

    /* loaded from: classes7.dex */
    public class b implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(c.a.t0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(c.a.t0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(g gVar, int i2) {
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
            FrsViewData frsViewData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.a == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof SignData) || (frsViewData = this.a.a.getFrsViewData()) == null || frsViewData.getForum() == null) {
                return;
            }
            ForumData forum = frsViewData.getForum();
            SignData signData = (SignData) customResponsedMessage.getData();
            int user_level = forum.getUser_level();
            String str = signData.forumId;
            if (str == null || !str.equals(forum.getId())) {
                return;
            }
            frsViewData.updateSignData(signData);
            h headerVC = this.a.a.getHeaderVC();
            boolean z = false;
            if (headerVC != null) {
                headerVC.b0(frsViewData);
                z = headerVC.A();
            }
            if (z) {
                int user_level2 = forum.getUser_level();
                if (user_level >= user_level2) {
                    user_level2++;
                }
                user_level = user_level2;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, user_level);
        }
    }

    public g(FrsFragment frsFragment, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16329b = new ArrayList();
        this.f16337j = "https://tieba.baidu.com/mo/q/signActivityPage";
        this.k = new a(this, 2001425);
        this.l = new b(this);
        this.m = new c(this, 2001222);
        this.a = frsFragment;
        this.f16331d = bdUniqueId;
        this.f16330c = TbSingleton.getInstance().getWalletSignLink();
    }

    public void i(List<TBSpecificationBtn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.f16329b = list;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z && !this.f16334g) {
            StatisticItem.make("c13560").param("obj_type", 1).eventStat();
            this.f16334g = true;
        }
    }

    public float k(ForumData forumData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, forumData)) == null) {
            if (forumData == null) {
                return 0.0f;
            }
            this.f16332e = forumData.getLevelupScore();
            int curScore = forumData.getCurScore();
            this.f16333f = curScore;
            int i2 = this.f16332e;
            if (i2 > 0) {
                return curScore / i2;
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? !TextUtils.isEmpty(this.f16330c) : invokeV.booleanValue;
    }

    public void m(c.a.u0.e1.f3.b bVar, SignData signData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, bVar, signData) == null) || bVar == null || signData == null) {
            return;
        }
        int i2 = signData.sign_bonus_point;
        boolean z = false;
        if (i2 >= this.f16332e - this.f16333f) {
            z = true;
            this.f16332e = signData.levelup_score;
        }
        int i3 = this.f16333f + i2;
        this.f16333f = i3;
        int i4 = this.f16332e;
        if (i3 > i4) {
            this.f16333f = i4;
        }
        int i5 = this.f16332e;
        float f2 = i5 != 0 ? this.f16333f / i5 : 0.0f;
        if (f2 > 0.999f) {
            f2 = 1.0f;
        }
        bVar.y(z, f2);
    }

    public void n() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (frsFragment = this.a) == null) {
            return;
        }
        frsFragment.registerListener(this.k);
        this.a.registerListener(this.m);
    }

    public void o(int i2) {
        TBSpecificationBtn next;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            Iterator<TBSpecificationBtn> it = this.f16329b.iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(d1.tbds42);
                next.getLayoutParams().width = -2;
                next.setPadding(0, 0, 0, 0);
                TBSpecificationButtonConfig styleConfig = next.getStyleConfig();
                styleConfig.g(dimenPixelSize);
                if (i2 > 0) {
                    next.setText(String.format(TbadkCoreApplication.getInst().getString(i1.miss_sign_days), Integer.valueOf(i2)));
                    styleConfig.i(e1.icon_pure_frs_sign_add16, 0, TBSpecificationButtonConfig.IconType.WEBP);
                } else {
                    next.setText(TbadkCoreApplication.getInst().getString(i1.signed));
                    styleConfig.i(e1.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
                }
                styleConfig.o(TBSpecificationButtonConfig.WebpType.PURE);
                next.setTextSize(d1.T_X08);
                next.changeSkinType();
                next.setVisibility(0);
                next.setTag(f1.item_tag_data, Boolean.TRUE);
                c.a.u0.e1.v2.c.f.c.a(next);
            }
        }
    }

    public final void p() {
        TBSpecificationBtn next;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Iterator<TBSpecificationBtn> it = this.f16329b.iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(d1.tbds52);
                next.getLayoutParams().width = -2;
                next.setPadding(0, 0, 0, 0);
                next.setTextSize(d1.T_X08);
                next.setText(TbadkCoreApplication.getInst().getString(i1.sign));
                TBSpecificationButtonConfig styleConfig = next.getStyleConfig();
                styleConfig.g(dimenPixelSize);
                styleConfig.f(c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), d1.M_W_X002));
                styleConfig.o(TBSpecificationButtonConfig.WebpType.MASK);
                styleConfig.i(e1.icon_mask_frs_gift20, 0, TBSpecificationButtonConfig.IconType.WEBP);
                next.changeSkinType();
            }
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                p();
            } else if (l()) {
                s();
            } else {
                r();
            }
        }
    }

    public final void r() {
        TBSpecificationBtn next;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            Iterator<TBSpecificationBtn> it = this.f16329b.iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(d1.tbds42);
                next.getLayoutParams().width = UtilHelper.getDimenPixelSize(d1.tbds158);
                next.setPadding(0, 0, 0, 0);
                next.setTextSize(d1.T_X08);
                next.setText(TbadkCoreApplication.getInst().getString(i1.sign));
                TBSpecificationButtonConfig styleConfig = next.getStyleConfig();
                styleConfig.g(dimenPixelSize);
                styleConfig.i(e1.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
                styleConfig.o(TBSpecificationButtonConfig.WebpType.PURE);
                next.changeSkinType();
            }
        }
    }

    public final void s() {
        TBSpecificationBtn next;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            Iterator<TBSpecificationBtn> it = this.f16329b.iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(d1.tbds52);
                next.getLayoutParams().width = -2;
                next.setPadding(0, 0, 0, 0);
                next.setTextSize(d1.T_X08);
                next.setText(TbadkCoreApplication.getInst().getString(i1.sign));
                TBSpecificationButtonConfig styleConfig = next.getStyleConfig();
                styleConfig.g(dimenPixelSize);
                styleConfig.f(c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), d1.M_W_X002));
                styleConfig.o(TBSpecificationButtonConfig.WebpType.MASK);
                styleConfig.i(e1.icon_mask_frs_gold20, 0, TBSpecificationButtonConfig.IconType.WEBP);
                next.changeSkinType();
            }
        }
    }

    public void t(c.a.u0.e1.f3.b bVar, FrsViewData frsViewData) {
        ForumData forum;
        SignData signData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, bVar, frsViewData) == null) || frsViewData == null || frsViewData.getForum() == null || bVar == null || (signData = (forum = frsViewData.getForum()).getSignData()) == null) {
            return;
        }
        bVar.E(forum, frsViewData);
        bVar.I(signData.is_signed);
        if (signData.sign_bonus_point <= 0 || !bVar.m()) {
            return;
        }
        m(bVar, signData);
        forum.setCurScore(this.f16333f);
        forum.setLevelupScore(this.f16332e);
        bVar.E(forum, frsViewData);
    }

    public void u(SignActivityInfo signActivityInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, signActivityInfo) == null) {
            this.f16336i = signActivityInfo;
        }
    }

    public void v(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048589, this, z, str) == null) {
            this.f16335h = z;
            TbSingleton.getInstance().setActivityId(str);
            FrsFragment frsFragment = this.a;
            if (frsFragment == null) {
                return;
            }
            FrsViewData frsViewData = frsFragment.getFrsViewData();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (frsViewData == null || frsViewData.getForum() == null) {
                    return;
                }
                ForumData forum = frsViewData.getForum();
                forum.setFromPage("frs");
                FrsActivityStatic.f43288c = forum.getName() == null ? "" : forum.getName();
                CustomMessage customMessage = new CustomMessage(2001425, forum);
                customMessage.setTag(this.f16331d);
                MessageManager.getInstance().sendMessage(customMessage);
                return;
            }
            TbadkCoreApplication.getInst().login(this.a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.a.getActivity(), true, 11014)));
        }
    }

    public void w(int i2, int i3, int i4) {
        FrsFragment frsFragment;
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048590, this, i2, i3, i4) == null) || (frsFragment = this.a) == null || i2 <= 0 || i3 <= 0 || (frsViewData = frsFragment.getFrsViewData()) == null || frsViewData.getForum() == null || frsViewData.getSignData() == null) {
            return;
        }
        ForumData forum = frsViewData.getForum();
        SignData signData = frsViewData.getSignData();
        signData.levelup_score = forum.getLevelupScore();
        signData.sign_bonus_point = i4;
        signData.miss_sign_num -= i3;
        signData.count_sign_num = i2;
        frsViewData.updateSignData(signData);
        signData.forumId = forum.getId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
        h headerVC = this.a.getHeaderVC();
        TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, headerVC != null ? headerVC.A() : false ? forum.getUser_level() + 1 : -1);
    }
}
