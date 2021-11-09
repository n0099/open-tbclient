package b.a.r0.x0.y2;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.a.r;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.h1;
import b.a.r0.x0.q;
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
import org.json.JSONObject;
import tbclient.SignActivityInfo;
/* loaded from: classes5.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f26878a;

    /* renamed from: b  reason: collision with root package name */
    public TBSpecificationBtn f26879b;

    /* renamed from: c  reason: collision with root package name */
    public String f26880c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f26881d;

    /* renamed from: e  reason: collision with root package name */
    public int f26882e;

    /* renamed from: f  reason: collision with root package name */
    public int f26883f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26884g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f26885h;

    /* renamed from: i  reason: collision with root package name */
    public SignActivityInfo f26886i;
    public String j;
    public CustomMessageListener k;
    public AntiHelper.k l;
    public CustomMessageListener m;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f26887a;

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
            this.f26887a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:88:0x02db  */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData frsViewData;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            boolean z2;
            q frsView;
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f26887a.f26878a == null || !(customResponsedMessage instanceof SignMessage) || (frsViewData = this.f26887a.f26878a.getFrsViewData()) == null || frsViewData.getForum() == null || (name = (forum = frsViewData.getForum()).getName()) == null || !name.equals(FrsActivityStatic.f48184c) || customResponsedMessage.getOrginalMessage().getTag() != this.f26887a.f26881d) {
                return;
            }
            TiebaStatic.eventStat(this.f26887a.f26878a.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
            String name2 = forum.getName();
            SignMessage signMessage = (SignMessage) customResponsedMessage;
            if (!AntiHelper.m(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                h headerVC = this.f26887a.f26878a.getHeaderVC();
                if (signMessage == null || (signData = signMessage.signData) == null) {
                    signData = null;
                    z = false;
                } else {
                    String str = signData.forumId;
                    if (str == null || !str.equals(forum.getId())) {
                        return;
                    }
                    if (headerVC != null) {
                        headerVC.Y(name2);
                    }
                    frsViewData.updateSignData(signData);
                    signData.forumId = forum.getId();
                    signData.forumName = forum.getName();
                    z = true;
                }
                if (z) {
                    int user_level = forum.getUser_level();
                    if (headerVC != null ? headerVC.z() : false) {
                        int user_level2 = forum.getUser_level();
                        if (user_level >= user_level2) {
                            user_level2++;
                        }
                        user_level = user_level2;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, user_level);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
                    try {
                        i2 = new JSONObject(signData.userInfoJson).getInt("activity_status");
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (i2 == 1 || i2 == 2) {
                        z2 = true;
                        if (z2 || !this.f26887a.f26885h) {
                            if (!this.f26887a.l() && signData.contDays > 0) {
                                b.a.q0.t.d.f.c().j(signData.userInfoJson);
                                TbPageContext<?> tbPageContext = this.f26887a.f26878a.getTbPageContext();
                                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.f26887a.f26878a.getActivity(), "", this.f26887a.f26880c, false, true, true);
                                tbWebViewActivityConfig.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
                                tbPageContext.sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
                                r.g().k().b();
                                return;
                            }
                            b.a.q0.t.d.f.c().j(null);
                            if (headerVC != null || headerVC.s()) {
                                this.f26887a.f26878a.showToast(TbadkCoreApplication.getInst().getString(h1.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                            } else {
                                this.f26887a.f26878a.showToast(TbadkCoreApplication.getInst().getString(h1.frs_sign_success, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                            }
                            frsView = this.f26887a.f26878a.getFrsView();
                            if (frsView == null) {
                                b.a.q0.t.d.f.c().a(this.f26887a.f26878a.getTbPageContext(), frsView.k0());
                                return;
                            }
                            return;
                        }
                        if (signData != null && this.f26887a.f26886i != null) {
                            try {
                                JSONObject jSONObject = new JSONObject(signData.userInfoJson);
                                jSONObject.put("activity_id", this.f26887a.f26886i.activity_id);
                                jSONObject.put("activity_suc_msg", this.f26887a.f26886i.activity_suc_msg);
                                jSONObject.put("activity_fail_msg", this.f26887a.f26886i.activity_fail_msg);
                                jSONObject.put("gift_type", this.f26887a.f26886i.gift_type);
                                jSONObject.put("gift_url", this.f26887a.f26886i.gift_url);
                                jSONObject.put("gift_name", this.f26887a.f26886i.gift_name);
                                jSONObject.put("icon_name", this.f26887a.f26886i.icon_name);
                                jSONObject.put("icon_lifecycle", this.f26887a.f26886i.icon_lifecycle);
                                jSONObject.put("activity_name", this.f26887a.f26886i.activity_name);
                                jSONObject.put("image_url", this.f26887a.f26886i.image_url);
                                b.a.q0.t.d.f.c().j(jSONObject.toString());
                            } catch (Exception unused) {
                            }
                        }
                        TbPageContext<?> tbPageContext2 = this.f26887a.f26878a.getTbPageContext();
                        TbWebViewActivityConfig tbWebViewActivityConfig2 = new TbWebViewActivityConfig(this.f26887a.f26878a.getActivity(), "", this.f26887a.j, false, true, true);
                        tbWebViewActivityConfig2.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
                        tbPageContext2.sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig2));
                        r.g().k().b();
                        return;
                    }
                    z2 = false;
                    if (z2) {
                    }
                    if (!this.f26887a.l()) {
                    }
                    b.a.q0.t.d.f.c().j(null);
                    if (headerVC != null) {
                    }
                    this.f26887a.f26878a.showToast(TbadkCoreApplication.getInst().getString(h1.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                    frsView = this.f26887a.f26878a.getFrsView();
                    if (frsView == null) {
                    }
                } else {
                    if (signMessage.mSignErrorCode == 160002 && headerVC != null) {
                        headerVC.g0(1);
                    }
                    this.f26887a.f26878a.showToast(signMessage.mSignErrorString);
                }
            } else {
                if (signMessage.signData != null) {
                    AntiHelper.t(this.f26887a.f26878a.getActivity(), signMessage.signData.blockPopInfoData, this.f26887a.l);
                } else {
                    AntiHelper.u(this.f26887a.f26878a.getActivity(), signMessage.mSignErrorString);
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
            }
        }
    }

    /* loaded from: classes5.dex */
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
        public void onNavigationButtonClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f26888a;

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
            this.f26888a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData frsViewData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f26888a.f26878a == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof SignData) || (frsViewData = this.f26888a.f26878a.getFrsViewData()) == null || frsViewData.getForum() == null) {
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
            h headerVC = this.f26888a.f26878a.getHeaderVC();
            boolean z = false;
            if (headerVC != null) {
                headerVC.h0(frsViewData);
                z = headerVC.z();
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
        this.j = "https://tieba.baidu.com/mo/q/signActivityPage";
        this.k = new a(this, 2001425);
        this.l = new b(this);
        this.m = new c(this, 2001222);
        this.f26878a = frsFragment;
        this.f26881d = bdUniqueId;
        this.f26880c = TbSingleton.getInstance().getWalletSignLink();
    }

    public void i(TBSpecificationBtn tBSpecificationBtn) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tBSpecificationBtn) == null) {
            this.f26879b = tBSpecificationBtn;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z && !this.f26884g) {
            StatisticItem.make("c13560").param("obj_type", 1).eventStat();
            this.f26884g = true;
        }
    }

    public float k(ForumData forumData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, forumData)) == null) {
            if (forumData == null) {
                return 0.0f;
            }
            this.f26882e = forumData.getLevelupScore();
            int curScore = forumData.getCurScore();
            this.f26883f = curScore;
            int i2 = this.f26882e;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? !TextUtils.isEmpty(this.f26880c) : invokeV.booleanValue;
    }

    public void m(b.a.r0.x0.b3.b bVar, SignData signData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, bVar, signData) == null) || bVar == null || signData == null) {
            return;
        }
        int i2 = signData.sign_bonus_point;
        boolean z = false;
        if (i2 >= this.f26882e - this.f26883f) {
            z = true;
            this.f26882e = signData.levelup_score;
        }
        int i3 = this.f26883f + i2;
        this.f26883f = i3;
        int i4 = this.f26882e;
        if (i3 > i4) {
            this.f26883f = i4;
        }
        int i5 = this.f26882e;
        float f2 = i5 != 0 ? this.f26883f / i5 : 0.0f;
        if (f2 > 0.999f) {
            f2 = 1.0f;
        }
        bVar.v(z, f2);
    }

    public void n() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (frsFragment = this.f26878a) == null) {
            return;
        }
        frsFragment.registerListener(this.k);
        this.f26878a.registerListener(this.m);
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.f26879b == null) {
            return;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(c1.tbds42);
        this.f26879b.getLayoutParams().width = -2;
        this.f26879b.setPadding(0, 0, 0, 0);
        TBSpecificationButtonConfig styleConfig = this.f26879b.getStyleConfig();
        styleConfig.g(dimenPixelSize);
        if (i2 > 0) {
            this.f26879b.setText(String.format(TbadkCoreApplication.getInst().getString(h1.miss_sign_days), Integer.valueOf(i2)));
            styleConfig.i(d1.icon_pure_frs_sign_add16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        } else {
            this.f26879b.setText(TbadkCoreApplication.getInst().getString(h1.signed));
            styleConfig.i(d1.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        }
        this.f26879b.setTextSize(c1.T_X08);
        this.f26879b.changeSkinType();
        this.f26879b.setVisibility(0);
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f26879b == null) {
            return;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(c1.tbds52);
        this.f26879b.getLayoutParams().width = -2;
        this.f26879b.setPadding(0, 0, 0, 0);
        this.f26879b.setTextSize(c1.T_X08);
        this.f26879b.setText(TbadkCoreApplication.getInst().getString(h1.sign));
        TBSpecificationButtonConfig styleConfig = this.f26879b.getStyleConfig();
        styleConfig.g(dimenPixelSize);
        styleConfig.f(b.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), c1.M_W_X002));
        styleConfig.o(TBSpecificationButtonConfig.WebpType.MASK);
        styleConfig.i(d1.icon_mask_frs_gift20, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.f26879b.changeSkinType();
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f26879b == null) {
            return;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(c1.tbds42);
        this.f26879b.getLayoutParams().width = UtilHelper.getDimenPixelSize(c1.tbds158);
        this.f26879b.setPadding(0, 0, 0, 0);
        this.f26879b.setTextSize(c1.T_X08);
        this.f26879b.setText(TbadkCoreApplication.getInst().getString(h1.sign));
        TBSpecificationButtonConfig styleConfig = this.f26879b.getStyleConfig();
        styleConfig.g(dimenPixelSize);
        styleConfig.i(d1.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.f26879b.changeSkinType();
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f26879b == null) {
            return;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(c1.tbds52);
        this.f26879b.getLayoutParams().width = -2;
        this.f26879b.setPadding(0, 0, 0, 0);
        this.f26879b.setTextSize(c1.T_X08);
        this.f26879b.setText(TbadkCoreApplication.getInst().getString(h1.sign));
        TBSpecificationButtonConfig styleConfig = this.f26879b.getStyleConfig();
        styleConfig.g(dimenPixelSize);
        styleConfig.f(b.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), c1.M_W_X002));
        styleConfig.o(TBSpecificationButtonConfig.WebpType.MASK);
        styleConfig.i(d1.icon_mask_frs_gold20, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.f26879b.changeSkinType();
    }

    public void t(b.a.r0.x0.b3.b bVar, FrsViewData frsViewData) {
        ForumData forum;
        SignData signData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, bVar, frsViewData) == null) || frsViewData == null || frsViewData.getForum() == null || bVar == null || (signData = (forum = frsViewData.getForum()).getSignData()) == null) {
            return;
        }
        bVar.B(forum, frsViewData);
        bVar.F(signData.is_signed);
        if (signData.sign_bonus_point <= 0 || !bVar.l()) {
            return;
        }
        m(bVar, signData);
        forum.setCurScore(this.f26883f);
        forum.setLevelupScore(this.f26882e);
        bVar.B(forum, frsViewData);
    }

    public void u(SignActivityInfo signActivityInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, signActivityInfo) == null) {
            this.f26886i = signActivityInfo;
        }
    }

    public void v(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048589, this, z, str) == null) {
            this.f26885h = z;
            TbSingleton.getInstance().setActivityId(str);
            FrsFragment frsFragment = this.f26878a;
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
                FrsActivityStatic.f48184c = forum.getName() == null ? "" : forum.getName();
                CustomMessage customMessage = new CustomMessage(2001425, forum);
                customMessage.setTag(this.f26881d);
                MessageManager.getInstance().sendMessage(customMessage);
                return;
            }
            TbadkCoreApplication.getInst().login(this.f26878a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f26878a.getActivity(), true, 11014)));
        }
    }

    public void w(int i2, int i3, int i4) {
        FrsFragment frsFragment;
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048590, this, i2, i3, i4) == null) || (frsFragment = this.f26878a) == null || i2 <= 0 || i3 <= 0 || (frsViewData = frsFragment.getFrsViewData()) == null || frsViewData.getForum() == null || frsViewData.getSignData() == null) {
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
        h headerVC = this.f26878a.getHeaderVC();
        TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, headerVC != null ? headerVC.z() : false ? forum.getUser_level() + 1 : -1);
    }
}
